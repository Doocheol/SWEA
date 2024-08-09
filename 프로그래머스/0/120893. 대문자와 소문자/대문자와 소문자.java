class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<my_string.length(); i++){
            // 소문자
            if (my_string.charAt(i)>='a' && my_string.charAt(i)<='z') sb.append((char)(my_string.charAt(i)-32));
            else sb.append((char)(my_string.charAt(i)+32));
        }
        
        String answer = sb.toString();
        return answer;
    }
}