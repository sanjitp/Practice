class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res=new ArrayList<>();
        int num1=-1,num2=-1,count1=0,count2=0,len=nums.length;
        
        for(int i=0;i<len;i++)
        {
            if(nums[i]==num1)
                count1++;
            else if(nums[i]==num2)
                count2++;
            else if(count1==0)
            {
                num1=nums[i];
                count1=1;
            }
            else if(count2==0)
            {
                num2=nums[i];
                count2=1;
            }
            else
            {
                count1--;
                count2--;
            }
        }
        count1=0;count2=0;
        
        for(int i=0;i<len;i++)
        {
            if(nums[i]==num1)
                count1++;
            else if(nums[i]==num2)
                count2++;
        }
        if (count1 > len / 3)
            res.add(num1);
        if (count2 > len / 3)
            res.add(num2);
        return res;
    }
}