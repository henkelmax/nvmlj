package de.bommel24.nvmlj;

public enum NVMLEnableState {

    NVML_FEATURE_DISABLED(0), NVML_FEATURE_ENABLED(1);

    private final int i;

    NVMLEnableState(int i) {
        this.i = i;
    }

    public int getValue() {
        return i;
    }

    public static NVMLEnableState fromInt(int i) {
        for (NVMLEnableState ret : values()) {
            if (i == ret.i) {
                return ret;
            }
        }
        return NVML_FEATURE_DISABLED;
    }
}
