class Solution {
    public String solution(String my_string, int n) {
        StringBuilder sb = new StringBuilder();
        
        char[] arr= my_string.toCharArray();
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<n; j++){
                sb.append(arr[i]);
            }
        }
        
        String answer = sb.toString();
        return answer;
    }
}