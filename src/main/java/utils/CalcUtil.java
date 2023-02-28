package utils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CalcUtil {
    public static double calculateActiveSubstance(double weight, double doseMl, double doseKg) {
        return (weight/doseKg)*doseMl;
    }

    public static double calculateDose(double activeSubstace, double powerMg, double powerMl) {
        return (activeSubstace/powerMg)*powerMl;
    }

    public List<Double> calculatePackageSizeNoCapsules(int days, int timesADay, double dose, List<Double> packageSize) {
        double bigDose = dose*(days*timesADay);
        List<Double> result = new ArrayList<>();
        while(bigDose > 0) {
            for(int i = 0; i < packageSize.size(); i++) {
                if(i == packageSize.size()-1) {
                    result.add(packageSize.get(i));
                    bigDose -= packageSize.get(i);
                    break;
                }
                else if(Math.abs(bigDose - packageSize.get(i)) < Math.abs(bigDose - packageSize.get(i + 1))) {
                    result.add(packageSize.get(i));
                    bigDose -= packageSize.get(i);
                    break;
                }
            }
        }
        return result;
    }

    public List<Double> calculatePackageSizeCapsules(int days, int timesADay, double dose, List<Double> packageSize, int capsuleSizeMl) {
        double bigDose = dose*(days*timesADay);
        List<Double> result = new ArrayList<>();
        double capsulesAmount = bigDose / capsuleSizeMl;
        while(capsulesAmount > 0) {
            for(int i = 0; i < packageSize.size(); i++) {
                if(i == packageSize.size()-1) {
                    result.add(packageSize.get(i));
                    capsulesAmount -= packageSize.get(i);
                    break;
                }
                else if(Math.abs(capsulesAmount - packageSize.get(i)) < Math.abs(capsulesAmount - packageSize.get(i + 1))) {
                    result.add(packageSize.get(i));
                    capsulesAmount -= packageSize.get(i);
                    break;
                }
            }
        }
        return result;
    }

    public static String roundDouble(double x) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(x);
    }
}
