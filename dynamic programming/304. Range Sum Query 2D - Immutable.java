public class NumMatrix {
    private int matrix[][];

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        // OR: this.matrix = new int[matrix.length][matrix[0].length];
        this.matrix = new int[matrix.length][];
        for (int i = 0; i < this.matrix.length; i++) {
            this.matrix[i] = new int[matrix[i].length];
            this.matrix[i][0] = matrix[i][0];
            for (int j = 1; j < this.matrix[i].length; j++) {
                this.matrix[i][j] = this.matrix[i][j - 1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;

        for (int i = row1; i <= row2; i++) {
            if (col1 == 0) {
                sum += this.matrix[i][col2];
            } else {
                sum += this.matrix[i][col2] - this.matrix[i][col1 - 1];
            }
        }

        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */