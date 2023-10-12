package smart4aviation.task.util;

public class WeightUnitExchanger {

    private static float KG_TO_LB_RATIO = 2.2f;

    private static float LB_TO_KG_RATIO = 0.45359237f;

    public static int lbToKg(int lb) {
        return (int) (lb * LB_TO_KG_RATIO);
    }

    public static int kgToLb(int kg) {
        return (int) (kg * KG_TO_LB_RATIO);
    }
}
