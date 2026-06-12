class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        list.add(new ArrayList<>(first));

        if(numRows == 1) return list;
        List<Integer> second = new ArrayList<>();
        second.add(1);
        second.add(1);
        list.add(new ArrayList<>(second));

        if(numRows == 2) return list;

        solve(numRows,list,3);
        return list;
    }
    public void solve(int numRows,List<List<Integer>> list,int n){
        if(n > numRows) return;
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = list.get(n-2);
        l1.add(1);

        for(int i=1;i<l2.size();i++){
            l1.add(l2.get(i) + l2.get(i-1));
        }

        l1.add(1);
        list.add(new ArrayList<>(l1));
        solve(numRows,list,n+1);
    }
}
