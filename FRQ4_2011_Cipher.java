public class FRQ4_2011_Cipher {
    private static int numRows = 2;

    private static int numCols = 4;

    private static String[][] letterBlock = new String[numRows][numCols];

    private static String encryptBlock() {
        StringBuilder encryptedBlock = new StringBuilder();
        for (int c = 0; c < numCols; c++) {
            for (int r = 0; r < numRows; r++) {
                encryptedBlock.append(letterBlock[r][c]);
            }
        }
        return encryptedBlock.toString();
    }

    private static void fillBlock(String str) {
        System.out.println(str);
        int k = 1;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (k > str.length()) {
                    letterBlock[i][j] = "A";
                    k++;
                    continue;
                }
                letterBlock[i][j] = str.substring(k - 1, k);
                k++;
            }
        }
    }

    public static String encryptMessage(String message) {
        if (message.equals("")) {
            return message;
        }
        String out = "";
        for (int i = 0; i < message.length() / (numCols * numRows); i++) {
            fillBlock(message.substring((message.length() / (numCols * numRows)) * i,
                    (message.length() / (numCols * numRows)) * (i + (numCols * numRows))));
            out += encryptBlock();
        }
        return out;
    }

    public static void printBlock() {
        for (String[] row : letterBlock) {
            for (String letter : row) {
                System.out.print(letter + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printBlock();
        System.out.println(encryptMessage("Surprise"));
        printBlock();
    }
}