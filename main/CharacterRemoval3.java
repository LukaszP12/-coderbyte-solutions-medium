
public class CharacterRemoval3 {

    public static int CharacterRemoval(String[] inputData) {
        String letters = inputData[0];
        String[] dictionary = inputData[1].split(",");
        int minRemoved = Integer.MAX_VALUE;

        for (String dictionaryEntry : dictionary) {
            int mainIndex = 0;
            int secondaryIndex = 0;
            int removalNumber = 0;

            while (mainIndex < dictionaryEntry.length() && secondaryIndex < letters.length()) {
                if (dictionaryEntry.charAt(mainIndex) == letters.charAt(secondaryIndex)) {
                    mainIndex++;
                    secondaryIndex++;
                } else {
                    secondaryIndex++;
                    removalNumber++;
                }
            }


            if (mainIndex == dictionaryEntry.length()) {
                if (secondaryIndex < letters.length()) {
                    removalNumber += (letters.length() - secondaryIndex);
                }

                if (removalNumber < minRemoved) {
                    minRemoved = removalNumber;
                }
            }

        }
        return (minRemoved == Integer.MAX_VALUE ? -1 : minRemoved);

    }

    public static void main(String[] args) {
        String[] strings = {"baseball", "a,all,b,ball,bas,base,cat,code,d,e,quit,z"};
        System.out.println(CharacterRemoval(strings));

        String[] strings1 = {"apbpleeeef", "a,ab,abc,abcg,b,c,dog,e,efd,zzzz"};
        System.out.println(CharacterRemoval(strings1));
    }

}
