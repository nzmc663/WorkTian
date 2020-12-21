package tianzefa.work.algorithm.exam;

    /**
     题干： 我们知道每一个大于1的整数都一定是质数或者可以用质数的乘积来表示，如10=2*5。现在请设计一个程序，对于给定的一个(1，N) 之间的正整数（N取值不超过10万），你需要统计(1，N)之间所有整数的质数分解后，所有质数个数的总个数。

     举例，输入数据为6，那么满足(1,6)的整数为2，3，4，5，6，各自进行质数分解后为：2=>2，3=>3，4=>22，5=>5，6=>23。对应的质数个数即为1，1，2，1，2。最后统计总数为7。

     要求：
     不考虑存储情况下，考虑算法速度最优
     语言不限，建议使用语言 c/c++,python,java
     代码直接提交，要求45分钟
     **/

import java.util.Scanner;

public class Main4{

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum = 0;
        for(int i=2;i<=num;i++){
            sum+=count(i);
        }
        System.out.println(sum);

    }

    private static int count(int num){
        int count = 0;
        int n = 2;
        int temp = num;
        while(num>1){
            if ((n>Math.sqrt(temp)+1)){
                if (num==temp) return 1;
                else return ++count;
            }else if(num%n==0){
                count++;
                num = num/n;
            }else{
                n++;
            }
        }
        return count;
    }
}


