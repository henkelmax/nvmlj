package de.bommel24.nvmlj;

public enum NVMLGpuOperationMode {

    NVML_GOM_ALL_ON(0), NVML_GOM_COMPUTE(1), NVML_GOM_LOW_DP(2);

    private final int i;

    NVMLGpuOperationMode(int i) {
        this.i = i;
    }

    public int getValue() {
        return i;
    }

    public static NVMLGpuOperationMode fromInt(int i) {
        for (NVMLGpuOperationMode ret : values()) {
            if (i == ret.i) {
                return ret;
            }
        }
        return NVML_GOM_ALL_ON;
    }
}
