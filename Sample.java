class Sample{

/**********************PROBLEM-1*****************/
    //TC:0(N)
//SC:0(1)
    class Solution {
        public int trap(int[] height) {
            if(height==null || height.length==0){
                return 0;
            }
            int n=height.length,total=0;
            int l=0,lw=0,r=n-1,rw=0;
            while(l<=r){
                if(lw<=rw){
                    if(height[l]<lw){
                        total+=lw-height[l];
                    }else{
                        lw=height[l];
                    }
                    l++;
                }else{
                    if(height[r]<rw){
                        total+=rw-height[r];
                    }else{
                        rw=height[r];
                    }
                    r--;
                }
            }
            return total;

        }
    }


    /****************PROBLEM-2******************/
    //TC:0(NlogN)
//SC:0(N)
    class Solution {
        public int hIndex(int[] citations) {
            if(citations==null || citations.length==0){
                return 0;
            }
            int n=citations.length;
            Arrays.sort(citations);
            for(int i=0;i<n;i++){
                if(citations[i]>=n-i){
                    return n-i;
                }
            }
            return 0;
        }
    }


    //TC:0(N)
//SC:0(N)
    class Solution {
        public int hIndex(int[] citations) {
            if(citations==null || citations.length==0){
                return 0;
            }
            int n=citations.length;
            int[] result=new int[n+1];
            for(int i=0;i<n;i++){
                int index=citations[i];
                if(index>=n){
                    result[n]++;
                }else{
                    result[index]++;
                }
            }
            int sum=0;
            for(int i=n;i>=0;i--){
                sum+=result[i];
                if(sum>=i){
                    return i;
                }
            }
            return 0;
        }
    }


}