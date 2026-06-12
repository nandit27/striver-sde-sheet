// class Solution {
//     public void setZeroes(int[][] matrix) {
        
//         if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
//             return;
//         }
//         boolean[] rowX = new boolean[matrix.length];
//         boolean[] colX = new boolean[matrix[0].length];

//         for (int i = 0; i < matrix.length; i++) {
//             for (int j = 0; j < matrix[0].length; j++) {
//                 if (matrix[i][j] == 0) {
//                     rowX[i] = true;
//                     colX[j] = true;
//                 }
//             }
//         }
//         for (int i = 0; i < matrix.length; i++) {
//             for (int j = 0; j < matrix[i].length; j++) {
//                 if (rowX[i] || colX[j]) {
//                     matrix[i][j] = 0;
//                 }
//             }
//         }
//     }
// }

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<int[]> list = new ArrayList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 0) list.add(new int[]{i,j});
            }
        }
        for(int[] arr: list){
            for(int i=0;i<m;i++){
                matrix[i][arr[1]] = 0;
            }
            for(int i=0;i<n;i++){
                matrix[arr[0]][i] = 0;
            }
        }
        return ;
    }
}
