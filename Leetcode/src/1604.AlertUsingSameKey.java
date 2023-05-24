class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        HashMap<String, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < keyName.length; i++){
            String name = keyName[i];
            String time = keyTime[i];
            List<Integer> list = new ArrayList<>();
            if(map.containsKey(name)){
                list = map.get(name);
            }
            list.add(convertToInt(time));
            map.put(name, list);
        }

        List<String> list = new ArrayList<>();
        for(String name : map.keySet()){
            if(isAlerted(map.get(name))){
                list.add(name);
            }
        }
        list.sort((a,b)->a.compareTo(b));
        return list;
    }

    public boolean isAlerted(List<Integer> list){
        list.sort((a,b)->a-b);

        for(int i = 2; i < list.size(); i++){
            if(list.get(i) - list.get(i - 1) <= 60 && list.get(i) - list.get(i - 2) <= 60){
                return true;
            }
        }
        return false;
    }

    public int convertToInt(String time){
        int res = 0;
        res += Integer.valueOf(time.substring(0,2)) * 60;
        res += Integer.valueOf(time.substring(3,5));
        return res;
    }
}