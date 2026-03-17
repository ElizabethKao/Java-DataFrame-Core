public class Tool {

    /**
     * Calculates the mean of a Series object.
     *
     * @param d the Series object to calculate the mean from
     */
    public static Integer mean(Series<Integer> d) throws ArithmeticException {
        // TODO: Implement mean calculation

        if (d == null) {
            throw new NullPointerException("mean (Series d): d can't be null");
        }

        if (d.getLength() == 0) {
            throw new IllegalArgumentException("mean (Series d): d can't be an empty Series");
        }

        int total = 0;
        int count = 0;

        for (int i=0; i < d.getLength(); i++) {
            try {
                Integer value = d.iloc(i);
                int current = value.intValue();

                total += current;
                count ++;
            }
            catch (NullPointerException e) {
                continue;
            }
        }

        int avg = total / count;

        return avg;
    }

    /**
     * Finds the maximum value in a Series object.
     *
     * @param d the Series object to find the maximum value from
     */
    public static Integer max(Series<Integer> d) throws IllegalArgumentException, ArithmeticException, NullPointerException {
        // TODO: Implement max value finder
        if (d == null) {
            throw new NullPointerException("max (Series d): d can't be null");
        }

        if (d.getLength() == 0) {
            throw new IllegalArgumentException("max (Series d): d can't be an empty Series");
        }

        Integer max = Integer.MIN_VALUE;
        int nullCount = 0;

        for (int i = 0; i < d.getLength(); i++) {
            try {
                Integer dataPt = d.iloc(i);

                if (dataPt == null) {
                    nullCount += 1;
                    continue;
                }
                else if (dataPt > max) {
                    max = dataPt;
                }
            }
            catch (NullPointerException e) {
                continue;
            }
        }

        if (nullCount == d.getLength()) {
            throw new ArithmeticException("All elements are null");
        }
        return max;
    }
}
