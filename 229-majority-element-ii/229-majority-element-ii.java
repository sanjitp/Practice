class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res=new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))
                map.put(nums[i],map.get(nums[i]) + 1);
            else
                map.put(nums[i],1);
        }
        int n=nums.length;
        for(Map.Entry<Integer,Integer> entry: map.entrySet())
        {
            if(entry.getValue()>n/3)
                res.add(entry.getKey());
        }
        return res;
    }
}