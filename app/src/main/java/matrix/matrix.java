package matrix;

public class matrix {
    //1st number functions
    public static float[][] sum(float[][] MA, float num) {//+
        float sol[][] = new float[MA.length][MA[0].length];
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol[0].length; j++) {
                sol[i][j] = MA[i][j] + num;
            }
        }
        return sol;
    }

    public static float[][] sub(float[][] MA, float num) {//-
        float sol[][] = new float[MA.length][MA[0].length];
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol[0].length; j++) {
                sol[i][j] = MA[i][j] - num;
            }
        }
        return sol;
    }

    public static float[][] sub(float num, float[][] MA) {//-
        float sol[][] = new float[MA.length][MA[0].length];
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol[0].length; j++) {
                sol[i][j] = num - MA[i][j];
            }
        }
        return sol;
    }

    public static float[][] mult(float[][] MA, float num) {//*
        float sol[][] = new float[MA.length][MA[0].length];
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol[0].length; j++) {
                sol[i][j] = MA[i][j] * num;
            }
        }
        return sol;
    }

    public static float[][] div(float[][] MA, float num) {// /
        float sol[][] = new float[MA.length][MA[0].length];
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol[0].length; j++) {
                sol[i][j] = MA[i][j] / num;
            }
        }
        return sol;
    }

    public static float[][] div(float num, float[][] MA) {// /
        float sol[][] = new float[MA.length][MA[0].length];
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol[0].length; j++) {
                sol[i][j] = num / MA[i][j];
            }
        }
        return sol;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //2nd two matrixes functions
    public static float[][] sum(float[][] MA, float[][] MB) {//+
        if (MA.length == MB.length && MA[0].length == MB[0].length) {
            float sol[][] = new float[MA.length][MA[0].length];
            for (int i = 0; i < sol.length; i++) {
                for (int j = 0; j < sol[0].length; j++) {
                    sol[i][j] = MA[i][j] + MB[i][j];
                }
            }
            return sol;
        }
        return null;
    }

    public static float[][] sub(float[][] MA, float[][] MB) {//-
        if (MA.length == MB.length && MA[0].length == MB[0].length) {
            float sol[][] = new float[MA.length][MA[0].length];
            for (int i = 0; i < sol.length; i++) {
                for (int j = 0; j < sol[0].length; j++) {
                    sol[i][j] = MA[i][j] - MB[i][j];
                }
            }
            return sol;
        }
        return null;
    }

    public static float[][] mult(float[][] MA, float[][] MB) {//*
        float val;
        if (MA[0].length == MB.length) {
            float sol[][] = new float[MA.length][MB[0].length];
            for (int i = 0; i < sol.length; i++) {
                for (int j = 0; j < sol[0].length; j++) {
                    val = 0;
                    for (int k = 0; k < MA[0].length; k++) {
                        val += MA[i][k] + MB[k][j];
                    }
                    sol[i][j] = val;
                }
            }
            return sol;
        }
        return null;
    }

    public static float[][] div(float[][] MA, float[][] MB) {// /
        if (MA.length == MB.length && MA[0].length == MB[0].length) {
            float sol[][] = new float[MA.length][MA[0].length];
            for (int i = 0; i < sol.length; i++) {
                for (int j = 0; j < sol[0].length; j++) {
                    sol[i][j] = MA[i][j] / MB[i][j];
                }
            }
            return sol;
        }
        return null;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //3rd matrixes stuff
    public static float[][] transport(float[][] MA) {//المنقول
        float sol[][] = new float[MA[0].length][MA.length];
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol[0].length; j++) {
                sol[i][j] = MA[j][i];
            }
        }
        return sol;
    }

    public static boolean isSquare(float[][] MA) {//مصفوفة مربعة
        return MA.length == MA[0].length;//يستعدعى شرط قبل المحدد والمقلوب
    }

    public static float determinant(float[][] MA) {//المحدد//استدعاء شرط المربعة
        float result = 0;
        if (MA.length == 1) {
            result = MA[0][0];
            return result;
        }
        if (MA.length == 2) {
            result = MA[0][0] * MA[1][1] - MA[0][1] * MA[1][0];
            return result;
        }
        for (int i = 0; i < MA[0].length; i++) {
            float temp[][] = new float[MA.length - 1][MA[0].length - 1];
            for (int j = 1; j < MA.length; j++) {
                for (int k = 0; k < MA[0].length; k++) {
                    if (k < i) {
                        temp[j - 1][k] = MA[j][k];
                    } else if (k > i) {
                        temp[j - 1][k - 1] = MA[j][k];
                    }
                }
            }
            result += MA[0][i] * Math.pow(-1, (int) i) * determinant(temp);
        }
        return result;
    }

    public static float[][] invert(float[][] MA) {//المقلوب
        float MB[][] = new float[MA.length][MA.length];
        float sol[][] = new float[MA.length][MA.length];
        int index[] = new int[MA.length];
        for (int i = 0; i < MA.length; i++) {
            MB[i][i] = 1;
        }
        // Transform the matrix into an upper triangle
        gaussian(MA, index);
        // Update the matrix MB[i][j] with the ratios stored
        for (int i = 0; i < MA.length - 1; i++) {
            for (int j = i + 1; j < MA.length; j++) {
                for (int k = 0; k < MA.length; k++) {
                    MB[index[j]][k] -= MA[index[j]][i] * MB[index[i]][k];
                }
            }
        }
        // Perform backward substitutions
        for (int i = 0; i < MA.length; i++) {
            sol[MA.length - 1][i] = MB[index[MA.length - 1]][i] / MA[index[MA.length - 1]][MA.length - 1];
            for (int j = MA.length - 2; j >= 0; j--) {
                sol[j][i] = MB[index[j]][i];
                for (int k = j + 1; k < MA.length; k++) {
                    sol[j][i] -= MA[index[j]][k] * MB[k][i];
                }
                sol[j][i] /= MA[index[j]][j];
            }
        }
        return sol;
    }

    // Method to carry out the partial-pivoting Gaussian
    // elimination.  Here index[] stores pivoting order.
    public static void gaussian(float[][] MA, int[] index) {//تابع مساعد للمقلوب
        float MB[] = new float[index.length];
        // Initialize the index
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }
        // Find the rescaling factors, one from each row
        for (int i = 0; i < index.length; i++) {
            float c1 = 0;
            for (int j = 0; j < index.length; j++) {
                float c0 = Math.abs(MA[i][j]);
                if (c0 > c1) {
                    c1 = c0;
                }
            }
            MB[i] = c1;
        }

        // Search the pivoting element from each column
        int k = 0;
        for (int j = 0; j < index.length - 1; j++) {
            double pi1 = 0;
            for (int i = j; i < index.length; i++) {
                double pi0 = Math.abs(MA[index[i]][j]);
                pi0 /= MB[index[i]];
                if (pi0 > pi1) {
                    pi1 = pi0;
                    k = i;
                }
            }

            // Interchange rows according to the pivoting order
            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i = j + 1; i < index.length; i++) {
                float pj = MA[index[i]][j] / MA[index[j]][j];

                // Record pivoting ratios below the diagonal
                MA[index[i]][j] = pj;
                // Modify other elements accordingly
                for (int l = j + 1; l < index.length; l++) {
                    MA[index[i]][l] -= pj * MA[index[j]][l];
                }
            }
        }
    }
}
