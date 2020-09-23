package de.bommel24.nvmlj;

public enum NVMLClockType {

    NVML_CLOCK_GRAPHICS(0), NVML_CLOCK_SM(1), NVML_CLOCK_MEM(2), NVML_CLOCK_VIDEO(3);

    private final int i;

    NVMLClockType(int i) {
        this.i = i;
    }

    public int getValue() {
        return i;
    }

    public static NVMLClockType fromInt(int i) {
        for (NVMLClockType ret : values()) {
            if (i == ret.i) {
                return ret;
            }
        }
        return NVML_CLOCK_GRAPHICS;
    }
}
