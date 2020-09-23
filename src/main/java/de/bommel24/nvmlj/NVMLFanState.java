package de.bommel24.nvmlj;

public enum NVMLFanState {

    NVML_FAN_NORMAL(0), NVML_FAN_FAILED(1);

    private final int i;

    NVMLFanState(int i) {
        this.i = i;
    }

    public int getValue() {
        return i;
    }

    public static NVMLFanState fromInt(int i) {
        for (NVMLFanState ret : values()) {
            if (i == ret.i) {
                return ret;
            }
        }
        return NVML_FAN_FAILED;
    }
}
