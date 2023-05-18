public class NestedIterator implements Iterator<Integer> {
    List<Integer> res;
    int index = 0;
    public NestedIterator(List<NestedInteger> nestedList) {
        res = method(nestedList);
    }

    public List<Integer> method(List<NestedInteger> nestedList){
        List<Integer> list = new ArrayList<>();
        for(NestedInteger nested : nestedList){
            if(nested.isInteger()){
                list.add(nested.getInteger());
            }else{
                list.addAll( method(nested.getList()) );
            }
        }
        return list;
    }

    @Override
    public Integer next() {
        return res.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < res.size();
    }
}