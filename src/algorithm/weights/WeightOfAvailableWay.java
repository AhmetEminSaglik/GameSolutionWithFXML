package algorithm.weights;


public class WeightOfAvailableWay {
    double weightOfDirection[] = new double[8];// may have  0..7 ways to move forwardLocation

    public WeightOfAvailableWay() {
        for (int i = 0; i < weightOfDirection.length; i++) {
            weightOfDirection[i] = weightOfDirection.length - i;
        }
    }

    public double[] getWeightOfDirection() {
        return weightOfDirection;
    }
}
