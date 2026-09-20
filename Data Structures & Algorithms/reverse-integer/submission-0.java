class Solution {
    public int reverse(int x) {
        long num = Math.abs(x);
        int countOfNum = count(num);
        long revNum = 0;
        while (countOfNum > 0) {
            revNum = revNum + ((num % 10) * (int) Math.pow(10, countOfNum - 1));
            num = num / 10;
            countOfNum--;
        }
        if(x < 0){
            revNum = -1 * revNum;
        }
        
        if(x<0){
            if(revNum < Integer.MIN_VALUE) revNum = 0;
        }
        if(x>0){
            if(revNum > Integer.MAX_VALUE) revNum = 0;
        }


        return (int) revNum;
        

    }
    int count(long num) {
        int cnt = 0;
        while (num > 0) {
            num = num / 10;
            cnt++;
        }
        return cnt;
    }
}
