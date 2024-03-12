public class FRQ4_2012_GrayImage {
    public static final int BLACK = 0;
    public static final int WHITE = 255;

    private static int[][] pixelValues = {
        {255, 184, 178, 84, 129},
        {84, 255, 255, 130, 84},
        {78, 255, 0, 0, 78},
        {84, 130, 255, 130, 84},
    };

    public static int countWhitePixels() {
        int count = 0;
        for (int[] row : pixelValues) {
            for (int pixel : row) {
                if (pixel == WHITE) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void processImage() {
        for (int i = 0; i < pixelValues.length; i++) {
            for (int j = 0; j < pixelValues[0].length; j++) {
                if (i + 2 < pixelValues.length && j + 2 < pixelValues[0].length) {
                    pixelValues[i][j] -= pixelValues[i + 2][j + 2];
                }
                if (pixelValues[i][j] < BLACK) {
                    pixelValues[i][j] = BLACK;
                }
            }
        }
    }

    public static void printPixelValues() {
        for (int[] row : pixelValues) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printPixelValues();
        System.out.println(countWhitePixels());
        processImage();
        printPixelValues();
    }
}
