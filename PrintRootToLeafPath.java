/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> allRootToLeaf(TreeNode root) {
        //your code goes here
        List<Integer> lastPath = new ArrayList<>();
        solve(root,lastPath);
        return result;
    }
    public void solve(TreeNode root,List<Integer> lastPath){
        if(root == null) return;

        lastPath.add(root.data);

        if(root.right == null && root.left == null) result.add(new ArrayList<>(lastPath));

        solve(root.left,lastPath);
        solve(root.right,lastPath);
        lastPath.remove(lastPath.size() - 1);
    }
}
