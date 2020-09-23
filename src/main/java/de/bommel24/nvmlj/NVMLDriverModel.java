package de.bommel24.nvmlj;

public enum NVMLDriverModel {

    NVML_DRIVER_WDDM(0), NVML_DRIVER_WDM(1);

    private final int i;

    NVMLDriverModel(int i) {
        this.i = i;
    }

    public int getValue() {
        return i;
    }

    public static NVMLDriverModel fromInt(int i) {
        for (NVMLDriverModel ret : values()) {
            if (i == ret.i) {
                return ret;
            }
        }
        return NVML_DRIVER_WDM;
    }
}
