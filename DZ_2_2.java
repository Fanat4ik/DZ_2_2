package DZ;

public class DZ_2_2 {
    static String sMatrix = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";

    private static final class NumberIsNotNumberException extends RuntimeException {
        NumberIsNotNumberException(String message) {
            super("Содержит не число: " + message);
        }
    }
    private static final class ArrLinghtException extends RuntimeException {
        ArrLinghtException(String message) {
            super("Ошибка размера массива: " + message);
        }
    }


    public static int strToIntsummArrDel2 (String aRR[][]){
        int summArr = 0;
        int [][] intArr = new int[aRR.length][aRR[0].length];
        for (int l = 0; l < aRR.length ; l++) {
            for (int n = 0; n <aRR[l].length; n++) {
                try {
                    intArr[l][n] = Integer.parseInt(String.valueOf(aRR[l][n]));
                } catch (NumberFormatException e){
                    throw new NumberIsNotNumberException(aRR[l][n]);
                }
            }
        }
        for (int i = 0; i < intArr.length ; i++) {
            for (int j = 0; j <intArr[i].length; j++) {
                summArr += intArr[i][j];
            }
        }
        return summArr/2;
    }

    public static void main(String[] args) {
        int [][] iMatrix = new int[4][4];
        int a = 0;
        int b = 0;
        System.out.println(sMatrix.length());
        String [][] sArray = new String[a+4][b+4];
        for (int i = 0; i< sMatrix.length(); i++) {
            if (sMatrix.charAt(i) - '0' == -16) {
                //System.out.print(" ");
               //String[][] newsArray = new String[sArray.length][sArray[b].length+1];
               //System.arraycopy(sArray, 0, newsArray, 0, sArray.length);
              // sArray = newsArray;
                b = b + 1;
            } else {
                if ((sMatrix.charAt(i) - '0') == -38) {
                    //System.out.println("перенос");
                    //String[][] newsArray = new String[sArray.length+1][sArray[b].length];
                    //System.arraycopy(sArray, 0, newsArray, 0, sArray.length);
                    //sArray = newsArray;
                    a = a + 1;
                    b = 0;
                } else {
                    String k = String.valueOf(sMatrix.charAt(i));
                    try {
                        if (sArray[a][b] == null) {
                            sArray[a][b] = Character.toString(sMatrix.charAt(i));
                        } else {
                            sArray[a][b] = sArray[a][b] + k;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                            throw new ArrLinghtException("а > " + sArray.length+ "или  b > " + sArray[a].length);
                    }
                }
            }
        }
        System.out.println(strToIntsummArrDel2 (sArray));
    }
}