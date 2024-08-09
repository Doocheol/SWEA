class Solution {
    public int solution(int[] numbers) {
        int mul = numbers[0]*numbers[1];
        for(int i =0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                if(mul<numbers[i]*numbers[j]){
                    mul=numbers[i]*numbers[j];
                }
            }
        }
        return mul;
    }
}