package com.atguigu.springboot.test01;

/**
 * @author 熟尔
 * @createdate 2019/9/15 0015-9:50
 */
public class dd {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};


//       ConcurrentHashMap

        int n = nums.length;
        if (n == 0) {
            System.out.println(0);
        }
        if(n == 1){
            System.out.println(nums[0]);
        }

        int js = 0;
        int os = 0 ;

        for(int i = 0;i<n-1;i++){

            if(i%2 ==0 ){
                js+=nums[i];
            }
            else{

                os+=nums[i];


            }
        }

        System.out.println(js > os ? js : os);

    }
}