public class CharacterRemoval4 {

    public static String CharacterRemoval(String[] strArr) {
        String bigWord = strArr[0];
        String[] words = strArr[1].split(",");

        int minRemove = Integer.MAX_VALUE;
        int tempRemove = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            boolean foundWord = true;
            int prevIndex = 0;
            for (int j = 0; j < word.length(); j++) {
                char searchC = word.charAt(j);
                if (bigWord.indexOf(searchC, prevIndex) != -1) {
                    prevIndex = bigWord.indexOf(searchC, prevIndex) + 1;
                } else {
                    foundWord = false;
                    break;
                }
            }
            if (foundWord) {
                tempRemove = bigWord.length() - word.length();
                if (minRemove > tempRemove) {
                    minRemove = tempRemove;
                }
            }

        }
        if (minRemove == Integer.MAX_VALUE) {
            return "-1";
        } else {
            return "" + minRemove;
        }

    }

    public static void main(String[] args) {
        String[] strings = {"baseball", "a,all,b,ball,bas,base,cat,code,d,e,quit,z"};
        CharacterRemoval(strings);
    }

}
