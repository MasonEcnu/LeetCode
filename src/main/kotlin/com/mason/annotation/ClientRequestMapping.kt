package com.mason.annotation

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
import java.io.IOException
import java.lang.reflect.Method
import java.net.JarURLConnection
import java.net.URL
import java.net.URLDecoder
import java.util.*
import java.util.jar.JarFile
import kotlin.reflect.KClass

/**
 * Created by mwu on 2019/11/20
 */

open class MessageLite

class HelloWorldRequest : MessageLite()

class HelloGotRequest : MessageLite()

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class ClientRequestMapping(val request: KClass<out MessageLite>)

object AnnotationTest {

  private val logger: Logger = LoggerFactory.getLogger(AnnotationTest::class.java)

  @ClientRequestMapping(request = HelloWorldRequest::class)
  fun testHelloWorldRequest(player: String, msg: String) {
    println("This is HelloWorldRequest, name:$player, msg:$msg")
  }

  @ClientRequestMapping(request = HelloGotRequest::class)
  fun testHelloGotRequest(player: String, msg: String) {
    println("This is HelloWorldRequest, name:$player, msg:$msg")
  }


  private fun getClass4Annotation(
    pkgName: String,
    annotation: KClass<out Annotation>
  ): Map<KClass<out MessageLite>, Method> {
    var packageName = pkgName
    val methodAnnotation = hashMapOf<KClass<out MessageLite>, Method>()
    // 是否循环迭代
//    val recursive = true
    // 获取包名，并进行替换
    val packageDirName = packageName.replace(".", File.separator)
    // 定义一个枚举的集合，并进行循环来处理目录下的things
    val dirs: Enumeration<URL>
    try {
      dirs = Thread.currentThread().contextClassLoader.getResources(packageDirName)
      // 循环迭代
      while (dirs.hasMoreElements()) {
        // 获取下一个元素
        val url = dirs.nextElement()
        // 得到协议名称
        val protocol = url.protocol
        // 如果是以文件的形式保存在服务器上
        if ("file" == protocol) {
          // 获取包的物理路径
          val filePath = URLDecoder.decode(url.file, "UTF-8")
          // 以文件的方式扫描整个包下的文件，并添加到集合中
          val dir = File(filePath)
          val fileList = arrayListOf<File>()
          fetchFileList(dir, fileList)
          fileList.forEach { file ->
            val fileName = file.absolutePath
            if (fileName.endsWith(".class")) {
              val noSuffixFileName = fileName.substring(5 + fileName.lastIndexOf("main"), fileName.indexOf(".class"))
              val filePackage = noSuffixFileName.replace("\\", ".")
              try {
                val clazz = Class.forName(filePackage)
                val methods = clazz.declaredMethods
                methods.forEach { method ->
                  method.annotations.forEach { anno ->
                    if (annotation.isInstance(anno)) {
                      methodAnnotation[(anno as ClientRequestMapping).request] = method
                    }
                  }
                }
              } catch (e: ClassNotFoundException) {
                e.printStackTrace()
              }
            }
          }
        } else if ("jar" == protocol) {
          // 如果是jar包
          // 定义一个JarFile
          val jar: JarFile
          try {
            // 获取jar
            println(url)
            val urlConnection = url.openConnection() as JarURLConnection
            jar = urlConnection.jarFile
            // 从此jar包，得到一个枚举类
            val entries = jar.entries()
            // 同样进行循环迭代
            while (entries.hasMoreElements()) {
              // 获取jar里的一个实体，可以是目录和一些jar中的文件
              val entry = entries.nextElement()
              var name = entry.name
              if (name[0] == '/') {
                // 获取后面字符串
                name = name.substring(1)
              }
              // 如果前半部分和定义的包名相同
              if (name.startsWith(packageDirName)) {
                val idx = name.lastIndexOf("/")
                if (idx != -1) {
                  // 获取包名，把/替换成.
                  packageName = name.substring(0, idx).replace("/", ".")
                }
                // 如果可以迭代下去，并且是一个包
                // 如果是一个.class文件，而且不是目录
                if (name.endsWith(".class") && !entry.isDirectory) {
                  // 去掉后面的.class 获取真正的类名
                  val className = name.substring(packageName.length + 1, name.length - 6)
                  try {
                    val clazz = Class.forName("$packageName.$className")
                    val methods = clazz.declaredMethods
                    methods.forEach { method ->
                      method.annotations.forEach { anno ->
                        if (annotation.isInstance(anno)) {
                          methodAnnotation[(anno as ClientRequestMapping).request] = method
                        }
                      }
                    }
                  } catch (e: ClassNotFoundException) {
                    e.printStackTrace()
                  }
                }
              }
            }
          } catch (e: IOException) {
            e.printStackTrace()
          }
        }
      }
    } catch (e: IOException) {
      e.printStackTrace()
    } catch (e: ClassNotFoundException) {
      e.printStackTrace()
    }

    return methodAnnotation
  }

  private fun fetchFileList(dir: File, fileList: ArrayList<File>) {
    if (dir.isDirectory) {
      dir.listFiles().forEach { file ->
        file?.also {
          fetchFileList(file, fileList)
        }
      }
    } else {
      fileList.add(dir)
    }
  }

  @JvmStatic
  fun main(args: Array<String>) {
    val packageName = "com.mason.annotation"
    val methodMap = getClass4Annotation(packageName, ClientRequestMapping::class)
    val msg = HelloWorldRequest()
    methodMap[msg::class]?.also {
      it.invoke(this, "hello", "world")
    }
  }
}