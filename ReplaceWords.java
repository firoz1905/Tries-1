// Approach : Using HashSet
// Time : O(mXl^2)
// space : O(N*L) 
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String> set = new HashSet<>(dictionary); // O(N*L)
        StringBuilder result = new StringBuilder(); // for building result

        // split the sentence into words
        String[] splitArr = sentence.split(" "); // split on spaces
        // search each word in Trie and see if there is shortest version
        for(int i =0;i<splitArr.length;i++){
            if(i>0) result.append(" ");
            boolean flag = false;
            String word = splitArr[i];
            for(int j=0;j<word.length();j++){ // O(l)
                String subStr = word.substring(0,j+1);// O(l)
                if(set.contains(subStr)){
                    result.append(subStr);
                    flag = true;
                    break;
                }
            }
            if(!flag){
                result.append(word);
            }
        }
        return result.toString();

    }
}