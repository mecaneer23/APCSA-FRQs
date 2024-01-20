public class FRQ1_2009_NumberCube {
    public static int[] getCubeTosses(NumberCube cube, int numTosses) {
        int[] tosses = new int[numTosses];
        for (int i = 0; i < numTosses; i++) {
            tosses[i] = cube.toss();
        }
        return tosses;
    }

    public static int getLongestRun(int[] values) {
        int maxLength = 0;
        int startPostion = -1;
        int currentRunLength = 0;
        for (int i = 1; i < values.length; i++) {
            if (values[i] == values[i - 1]) {
                currentRunLength++;
            } else {
                currentRunLength = 0;
            }
            if (currentRunLength > maxLength) {
                startPostion = i - currentRunLength;
                maxLength = currentRunLength;
            }
        }
        return startPostion;
    }

    public static void main(String[] args) {
        int[] tosses = getCubeTosses(new NumberCube(), 17);
        for (int toss : tosses) {
            System.out.print(toss + " ");
        }
        System.out.println();

        int[] customTosses = {1, 5, 5, 4, 3, 1, 2, 2, 2, 2, 6, 1, 3, 3, 5, 5, 5, 5};
        for (int toss : customTosses) {
            System.out.print(toss + " ");
        }
        System.out.println();
        System.out.println(getLongestRun(customTosses));
    }
}

class NumberCube {
    public int toss() {
        return (int) (Math.random() * 6) + 1;
    }
}