class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strings){
            char[] arr = str.toCharArray();
            int val = arr[0] - 'a';
            for(int i = 0; i < arr.length; i++){
                int temp = Math.floorMod(arr[i] - val, 26);
                arr[i] = (char)(temp);
            }
            String base = String.valueOf(arr);
            List<String> list = new ArrayList<>();
            if(map.containsKey(base)){
                list = map.get(base);
            }
            list.add(str);
            map.put(base, list);
        }
        List<List<String>> list = new ArrayList<>();
        for(String key : map.keySet()){
            list.add(new ArrayList<>(map.get(key)));
        }
        return list;
    }
}