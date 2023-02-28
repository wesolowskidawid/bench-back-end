package objects;

import java.util.List;

public class Med {
    private final String name;
    private final double powerMg;
    private final double powerMl;
    private final List<Double> packageSizeMl; // if there are capsules, put the amount instead of ml
    private final int capsuleSizeMl; // if there are capsules, put ml of the capsules
    private final double doseMg;
    private final double doseKg;

    public Med(String name, double powerMg, double powerMl, List<Double> packageSizeMl, int capsuleSizeMl, double doseMg, double doseKg) {
        this.name = name;
        this.powerMg = powerMg;
        this.powerMl = powerMl;
        this.packageSizeMl = packageSizeMl;
        this.capsuleSizeMl = capsuleSizeMl;
        this.doseMg = doseMg;
        this.doseKg = doseKg;
    }

    public String getName() {
        return name;
    }

    public double getPowerMg() {
        return powerMg;
    }

    public double getPowerMl() {
        return powerMl;
    }

    public List<Double> getPackageSizeMl() {
        return packageSizeMl;
    }

    public int getCapsuleSizeMl() {
        return capsuleSizeMl;
    }

    public double getDoseMg() {
        return doseMg;
    }

    public double getDoseKg() {
        return doseKg;
    }
}
