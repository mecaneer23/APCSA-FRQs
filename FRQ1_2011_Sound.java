class FRQ1_2011_Sound {
    public static void main(String[] args) {
        Sound sound = new Sound();
        int[] samples = { 40, 2532, 17, -2300, -17, -4000, 2000, 1048, -420, 33, 15, -32, 2030, 3223 };
        sound.samples = samples;
        System.out.println("Changes: " + sound.limitAmplitude(2000));
        for (int sample : sound.samples) {
            System.out.print(sample + " ");
        }
        System.out.println();
        System.out.println();

        int[] samples1 = { 0, 0, 0, 0, -14, 0, -35, -39, 0, -7, 16, 32, 37, 29, 0, 0 };
        sound.samples = samples1;
        for (int sample : samples1) {
            System.out.print(sample + " ");
        }
        System.out.println();

        sound.trimSilenceFromBeginning();
        for (int sample : sound.samples) {
            System.out.print(sample + " ");
        }
        System.out.println();
    }
}

class Sound {
    public int[] samples;

    public int limitAmplitude(int limit) {
        int changes = 0;
        for (int i = 0; i < samples.length; i++) {
            if (samples[i] > limit) {
                samples[i] = limit;
                changes++;
            } else if (samples[i] < -limit) {
                samples[i] = -limit;
                changes++;
            }
        }
        return changes;
    }

    public void trimSilenceFromBeginning() {
        boolean startsWithZero = true;
        int counter = 0;
        for (int sample : samples) {
            if (!startsWithZero || sample != 0) {
                counter++;
                startsWithZero = false;
            }
        }
        int[] newArr = new int[counter];
        for (int i = 0; i < counter; i++) {
            newArr[i] = samples[i + samples.length - counter];
        }
        samples = newArr;
    }
}
