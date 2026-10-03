class Solution {
    public String[] reorderLogFiles(String[] logs) {
       List<String> letter = new ArrayList<>();
       List<String> digit = new ArrayList<>();

       for(String log: logs){
            String[] temp = log.split(" ", 2);
            if(Character.isDigit(temp[1].charAt(0))){
                digit.add(log);
            }
            else{
                letter.add(log);
            }
       }

       Collections.sort(letter, (a,b) -> {
            String[] partA = a.split(" " , 2);
            String[] partB = b.split(" ", 2);

            String identifierA = partA[0];
            String identifierB = partB[0];

            String contentA = partA[1];
            String contentB = partB[1];

            int result = contentA.compareTo(contentB);

            if(result == 0){
                return identifierA.compareTo(identifierB);
            } 

            return result;
       });

       letter.addAll(digit);
       return letter.toArray(new String[0]);
    }
}