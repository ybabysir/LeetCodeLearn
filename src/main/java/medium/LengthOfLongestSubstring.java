package medium;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("ohomm"));
    }

    public static int lengthOfLongestSubstring(String s) {
        //Convert this String to char[] for "foreach"
        char[] result = s.toCharArray();
        int count = "".equals(s)?0:1;
        int monitor = 0;
        //For per no-repeat array
        String container = "";
        //first, i need to foreach this string;
        for(int i = 0; i < result.length; i++){
            //Judgement is contain repeat char.
            if(container.indexOf(result[i]) == -1){
                container += result[i];
                monitor++;
            }else {
                /*if it contains,find the first element's index.
                 * delete the first index to the first duplicate index .
                 **/
                container = container.substring(container.indexOf(result[i]) + 1, container.length());
                container += result[i];
                //set count to be newest
                if(count < monitor){
                    count = monitor;
                }
                //reset monitor, keeping it always equal current no-repeat array.
                monitor = container.length();
            }
        }
        return count>monitor?count:monitor;
    }
}
