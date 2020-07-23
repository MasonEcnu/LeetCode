package com.mason.leetcode.string.easy;

/**
 * Created by mwu on 2020/5/19
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 示例 1:
 * 输入: "aba"
 * 输出: True
 * <p>
 * 示例 2:
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * <p>
 * 注意:
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 */
public class ValidPalindromeII680 {

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(validPalindrome2("sxgbhujarjjqabzxhpgpojhtbuamilocicridcgzwoelkpxzcrdfdiepxsrjoeyvqbymkpobjilcmlpvojenvoevcodwresmcwhdskcacirdpmarwsgjzizvggbythkjquyqpelpmaorjkfwlsimhuvlaqusnlueqowcuruewxywttpqeanmrqdfqjpwadtivuveufexunyeiyqnxikjqilgaaqcjsadghfiwdvqcidbbzpccyzcvqphjwmwduwklwpltbldqbyhdkeniodgwunolteoxqbqbtcvfenjjefxufrlhjumycpuqiqkxowopezyywgkvwxcsgiknixeeicimlwuedmebjmwvcezgiphmzfffgrvhudsgczjycsahdtipkejkkjkuuxwyrsvpucciaznnmenidscncaaxrvolnkivwkscbimaiwmgeamnhrfvibmaoadgatawfcpinbrmtiuezxwhusnqlbpafrfvnpafwmlmmaaiazmyzhetqmydipbqotuvpwpefdhjkbprcrqgizkxaurodpnnhpevqrcunmvgirbkuqsmenrmwdedlpydjvzswwntqjacxnhdqebwbagdvrjdudgzymthnsgzpdxzumnlawtfoqwnrwhzjzbprqktbucywfhenzgdhbgjasueivditofopxqnnqmtzyzpzpqvjzocabgnzkeupbfbrajltmoidouqczvkfjrytnenphfmsgtaogzwriasrtxhcbztlodoxvscdmdbfnfsouaopiatcxbqqjeokumqrbkoubaxelqzrfkwndwexmmysquebmiarrpkwdjfsiwwqrormtiyzhptitkihweqyufzlzejydgqtlrwvrmfshilwsobhsvdxqtqocudjqfgbwxympktscixhisdhhimvifvxvcvfjvikvxijggyvlulromuuqcuefvvxiftjlanlqorxtywubqdwgkglewceqvjvdgxnsaqhybmxvoridljsducdgmuuvmoypjfxbssyghzmeuybpbzmpuuogkmxmnqckrvwdnlhuskyfkqopbqveckotmmmikprlakoidwrhzdmedlycxoyysgcseuhdbiyltazaqbuxclycsrxzcwmcvqfjwldtohbvhjgvnbokiafxohgadtadhtqmltjcfyhjznngqnsoivgbxhulynwwckeedpjbtoqmddssbzomuyjbxghflrepbcngqogxdclqvujzqwwfrthpwqrqyefodhjsutuhvvtfnwolyzspgvpikuzkrcpwvppbnyorxcfzobcvclslxrxpfltessviyjtcjzndxkxabeuoualclhpcbfjghjhmeowazowdvklwciturbgoinfmtpljwukdzddffjxievffhjuultovhjurwokzeiyfxuvfhivpjqufbzsdwjbidbmatcdekemngwrmcnbdclosnyfnemaswplleesftpqodzlrihfwhuopagmclvbjeemvwjegfnzrcnthuzknhtlqcaxbzlcvgraequcolsqjqttvpjebfpiqpqdmwlcslrhtbhczrknththipwpqagseugvjdbqtdmglgexqhithnybqvxfmblzpdvlxqbuteqwtyqgrljvjxpitecdrpdvdlyhenvxvdexvcxqvuqtxugkyusbxbfpckykmimkzuqokohqfkbrmeiueiafneydxibmlsvztstcbjmpwlcrxslpwphjzdwadlxivsrftafykvyeoshrwtxaospinawybqoyigvwhyheikxbjqsiqwkehzzbblhkaephipssaqguipmopyuumuvxbvfdwjqzlomckfxrgxkyipjrmutoflhnyfgdbrrdtjxyvydhtxewgmmbmjhxgonumbjdssggikcjrlvfxsgeewatzmcldmdhnomdolffkgfecahnqvfnoimqppwuqbpjgcaswcscvvfuzemtprbxkqgdqmjdbrjetivsrexpddujilhmrrxdjlaqgbsktfokjpkmvmqsrfxdjjvflnesxdaqlzdjmomkbzpqbfwwungzufbhockfbkpbmxxhrcgswyqzjvskescdqonmgnajcbproqcvadoromfuwnfemfsjmhrqmdyqqmzjerhabicpzlbodbavtkjwofeuqeffwpfsbrormyexsugrtwpqisjydzzjeovrowbnvhpcpuvberhhavlkgmugkojugzutgbbbcdryqlesjmryvowcwwhgwfadrazfxumnduanihfyccwuuogsfeehwiqnspafrhgteakxncidhxctfihdxgovbpuhgupeydguaypyjgvjmyosatxpsglkdiffihcrdfosllvhwqrkygcsqvehguutqjmkpdojneqvlcwjlqmgliycjigukconyvxxfzjzukhixkkgqmwgtsawhxxvmgwcvkzvlbumasbmrzkzytxzprincuvoqlvtymarulnivhlfrtmidopouksspxgdedazonjtwjmrsnapcsklpgqbszbzbewvrgjmcnvibviqvfnrtxgzjnsuvbwvroqvwlvqaydgrfgtumdxicczupjpmrqpgjojyneoilymsaytzgnmyrupokcgahkpqnioyxtaidjylvqkwrdflctlryktouhtjneeaxzyeeahcbzyhjbwatsxforrzgfwpaxqjedllmioroaxtqoisiaxfjorxwsdvwoxraxswmsogshimivrsgaoqihknevhrttosymthtxtzywntfaqvkwxkvzytwphecvxopncsejwpusomrioufnqrtktdsywhlweufugshzanlnofflpidhkhbuutdvkurkkchpqqzmtvllyovvzkigowxxyudnzbbtubhfywricbidvfxczmbstxfnbyzzidavlpeowcfqcqvdpepuwnwrgaltqztocetvlkvflcfafiskxlzfubjowvutqvplfbjiajfgpnnrksdjbwztxsputlxsoxqaldfciacbhnxoozdyhvlodcrtpqjbogyzfjgjoujckymjurywvdauuslgmkhozxntpthociytyxuuvyrpsnngkbrztqmgvfbxllbxdoacqkbttgbziuaorbknclzkfjenozdefbmmuzeopjrcxbqhottirqoocmptuksebiodyfnlsqjkrugygaqvypuyvqjrqingquyzjefhayofxjnjhetpxzhntqeqtwxagmarwaajxwljxzbpljhthqchkcdxmwuwzddgbyomqhxtproekdnpexagxmaqjhvnmhrlnannzeexsxkcoxpvmpjrgbvrqcnmnljtkjbibxokotwgzlhxgyxzqpjgmfjycidhgjbtyzulsmafyyjiheizsosctbgjamtqlmtkvslkpmrlozbbdhlsacmzjqluomvosdtulmehpipjuyzwitvcwlcceninbsejdlwfesljufmftvvunyktainxirlobsertlhydibztsyshlgizemalfwrtimhzvqtiacnyikhmiadvpbehzohqzrbvwayhsxxzchsirrtuyoywjbmfbxfkpqbssmrkmhxlbwsvcicefzdrlkhkkhbnprodychldqurdjbgoawvznrnogletqkzaxumimegpkelzbhchoknqhqnnpjyjgvamgsmoioscmjtgnwnjglwhsukzzfjerqubkvezjlrqqatdkgmnxzbvbsgmithvnioeynkunqqukqerhfdptumhgllfgpvzcrlnvmebafrbmkoatpzydkhgnlfmcrxzpvqcpyjhykbqvohhgtfhkoprofcbeeccfzemofazrkekuguwnzqtfksdbbcibjmqfjhiugkzkazzcctbkgwfbmpgetwntdrcmkapwceubbfuvkwqbeinulgnaqhddhjhgmogjcoidvvjphiyvlrbddofaxudpcpzuxmhbutydklsezlwnalfjtqppduhcnfpbrrrnglmspzkjozjqstircvxxlfqqdxghaftdauxboycpnhusgsxtxfztqnffgqbkqsljrexwfnyzyeydrpnrxoytzdsbjrlmzthnddhakgfpaqcjxcktdljnywxdotywdjflyyavpbttewwixetzgboepfulkwcqcopveuhrkiszmfeyjjutfosmlvydcsjrfspbxntgwtpsbavslhvthxepoquzcdkhbpotpcfkjclmkugmxdfunpulhniqsbhrldzygmstrxrozbusgpvpbwtguozqhqettfaahioxysclffjagedsdaqwclolhruhnhvrjrnxpsgbzskutowjbsfbhlobhymctnxbnrpkijnkzugxwluzrnbiicjnvhldeccvjqnihwrvvaozcpqrckwgjrzupkjgztwvkfdwscklmuxucbjajnljcisufmdyshyvoanmdrwjnnumeknqagevetbnututlrwdgtpfslzbajfenhqhygfzsiaqknvxcorfekarrrpqpgjaltitensbiusvdrevzoprigjsbsgsvgekcjmlozgjylwftqqfqmsdkakwfhazbwdycvukfamojbuelomqrdmnrtiworqipuxlkweglfinjusnnhknanwyduycmgirqmjptnqkupdgmavkuqgtfiseazioosacyaqrgfjzwcwpvrhcnilaenregfttmzzkpupubzgbmyukcdbijtzlbtamvkdpucflgcpvjlszpjaoluiqxqhqvdkhmhfzjvlrienovnuchzdtaztryybfwahxtibjflxohiameksqhmvzbjemiyomerayjcmwiomrnfamcmbtrcmjxkrlonmlvovjoccvufivbushiutivoafyvpelzxeupsqnhnlosgcpbrbsegqowojkwuxckvzgofgaguuyvpsubcqdejhkiywxtimaunrjpifbwetguwbjoop"));
        System.out.println(System.currentTimeMillis());
    }

    public static boolean validPalindrome(String s) {
        int len = s.length();
        if (len == 0) return false;
        if (isValidPalindrome(s)) return true;

        for (int i = 0; i < len; i++) {
            String str = s.substring(0, i) + s.substring(i + 1);
            if (isValidPalindrome(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i <= len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    // 这个方法的可扩展性更强，可以用来做chance>1的题
    public static boolean validPalindrome1(String s) {
        return validPalindrome(s, 0, s.length() - 1, 1);
    }

    /**
     * @param s      输入字符串
     * @param left   左指针
     * @param right  右指针
     * @param chance 删除节点的机会次数
     */
    private static boolean validPalindrome(String s, int left, int right, int chance) {
        if (left > right) {
            return true;
        }
        if (s.charAt(left) == s.charAt(right)) {
            return validPalindrome(s, left + 1, right - 1, chance);
        } else {
            if (chance == 0) {
                return false;
            }
            return validPalindrome(s, left, right - 1, chance - 1) || validPalindrome(s, left + 1, right, chance - 1);
        }
    }

    // 双指针，双遍历
    public static boolean validPalindrome2(String s) {
        int lo = 0, hi = s.length() - 1;
        while (lo < hi) {
            if (s.charAt(lo) != s.charAt(hi)) {
                // 相当于删除lo+1位置或者hi-1位置的字符
                return isValidPalindrome(s, lo + 1, hi) || isValidPalindrome(s, lo, hi - 1);
            }
            lo++;
            hi--;
        }
        return true;
    }

    public static boolean isValidPalindrome(String s, int lo, int hi) {
        while (lo < hi) {
            if (s.charAt(lo) != s.charAt(hi)) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }
}
