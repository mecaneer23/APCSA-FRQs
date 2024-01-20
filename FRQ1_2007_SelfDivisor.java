import java.lang.Math;

class SelfDivisor {
    public static boolean isSelfDivisor(int number) {
        String numAsString = "" + number;
        int numberOfDigits = numAsString.length();
        if (numAsString.contains("0")) {
            return false;
        }
        for (int i = 0; i < numberOfDigits; i++) {
            if (number % (number % Math.pow(10, i + 1)) != 0) {
                return false;
            }
        }
        return true;
    }

    public static int[] firstNumSelfDivisors(int start, int num) {
        int[] outputArr = new int[num];
        int spotsFilled = 0;
        int counter = start;
        while (spotsFilled < num) {
            if (isSelfDivisor(counter)) {
                outputArr[spotsFilled] = counter;
                spotsFilled++;
            }
            counter++;
        }
        return outputArr;
    }

    public static void main(String[] args) {
        int[] nums = firstNumSelfDivisors(10, 3);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}