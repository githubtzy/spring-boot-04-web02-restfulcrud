package com.atguigu.springboot.controller;

/**
 * @author 熟尔
 * @createdate 2019/11/15 0015-19:38
 */
public class KuaipaiController {

    public static void main(String[] args) {
        int[] a  = {1,3,5,2,2};
        int n =5;
                int K =3;
        int aaa = KuaipaiController.findKth( a, n, K );
        System.out.println(aaa);
    }






        public static int findKth(int[] a, int n, int K) {
            // write code here

            if(K>1 && K<n){ mergeSort(a,0,n-1);
                return a[K-1];}
            return -1;





        }
        public static void mergeSort (int[] a, int l , int h){

            if(l == h ){return ;}
            else{
                int M = (l+h)/2;
                mergeSort(a,l,M-1);
                mergeSort(a,M+1,h);
                merge(a,l,M+1,h);
            }}

        public static void merge(int a[],int L ,int M , int R ){

            int[] leftArray = new int [M-L];
            int[] rightArray = new int[R-M+1];
            for (int i = L; i <M ; i++) {

                leftArray[i-L] = a[i];

            }
            for (int i = M; i <=R ; i++) {

                rightArray[i-L] = a[i];

            }

            int i=0 , j=0 ;
            int k = L;
            while ( i<leftArray.length &&j<rightArray.length){
                if (leftArray[i] < rightArray[j]){
                    a[k] = leftArray[i];
                    i++;
                    k++;
                }
                else{
                    a[k] = rightArray[i];
                    j++;
                    k++;

                }
            }

            while (i<leftArray.length){
                a[k] = leftArray[i];
                i++;
                k++;
            }
            while (j<rightArray.length){
                a[k] = rightArray[i];
                j++;
                k++;
            }
        }


    }
