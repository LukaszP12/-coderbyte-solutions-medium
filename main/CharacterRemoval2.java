
public class CharacterRemoval2 {

    private static int CharacterRemoval(String[] strArr) {
        String[] dic = strArr[1].split(",");
        char[] wordArr = strArr[0].toCharArray();
        int n = wordArr.length;

        if (check(wordArr, dic)) return 0;

        int maxVal = -1;
        int r = n - 1;

        // number of chars to get
        while (r > 0 && maxVal == -1) { // number of chars to get
            char[] combArr = new char[r];
            maxVal = combine(wordArr, combArr, dic, 0, n - 1, 0, r);
            r--;
            combArr = null;
        }

        return maxVal;
    }

    public static int combine(char[] wordArr, char[] combArr, String[] dic,
                              int s, int e, int index, int r) {
        int maxVal = -1;

        if (index == r) {
            if (check(combArr, dic)) {
                return wordArr.length - r;
            } else {
                return maxVal;
            }
        }

        for (int k = s; k <= e && e - k + 1 >= r - index; k++) {
            combArr[index] = wordArr[k];
            maxVal = Math.max(maxVal, combine(wordArr, combArr, dic, k + 1, e, index + 1, r));
        }

        return maxVal;
    }

    public static boolean check(char[] wordArr, String[] dic) {
        String word = String.valueOf(wordArr).trim();

        for (int i = 0; i < dic.length; i++) {
            if (dic[i].equals(word)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        String[] strings = {"baseball", "a,all,b,ball,bas,base,cat,code,d,e,quit,z"};
        System.out.println(CharacterRemoval(strings));

        String[] strings1 = {"apbpleeeef", "a,ab,abc,abcg,b,c,dog,e,efd,zzzz"};
        System.out.println(CharacterRemoval(strings1));
    }

}
