package JavaRegex;

public class MinWindowSubstring1 {

    static final int no_of_chars = 256;

    public static String MinWindowSubstring(String[] strArr) {
        String full = strArr[0];
        String s = strArr[1];
        return findSubString(full, s);
    }

    static String findSubString(String str, String pat) {
        int len1 = str.length();
        int len2 = pat.length();

        if (len1 < len2) {
            System.out.println("No such window exists");
            return "";
        }

        int hash_pat[] = new int[no_of_chars];
        int hash_str[] = new int[no_of_chars];

        for (int i = 0; i < len2; i++) {
            hash_pat[pat.charAt(i)]++;
        }

        int start = 0, start_index = -1, min_len = Integer.MAX_VALUE;

        // start traversing the string
        int count = 0; // count of characters
        for (int j = 0; j < len1; j++) {
            hash_str[str.charAt(j)]++;

            if (hash_pat[str.charAt(j)] != 0 &&
                    hash_str[str.charAt(j)] <= hash_pat[str.charAt(j)]) {
                count++;
            }

            // if all characters are matched
            if (count == len2) {
                // Try to minimize the window i.e., check if
                // any character is occuring more no. of times
                // than its occurance in pattern, if yes
                // then remove it from starting and also remove
                // the useless characters.
                while (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)]
                        || hash_pat[str.charAt(start)] == 0) {
                    if (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)])
                        hash_str[str.charAt(start)]--;
                    start++;
                }

                // update window size
                int len_window = j - start + 1;
                if (min_len > len_window) {
                    min_len = len_window;
                    start_index = start;
                }
            }
        }

        // If no window found
        if (start_index == -1) {
            System.out.println("No such window exists");
            return "";
        }

        return str.substring(start_index, start_index + min_len);
    }

    public static void main(String[] args) {
        String[] strings = {"ahffaksfajeeubsne", "jefaa"};

        System.out.println(MinWindowSubstring(strings));
    }

}