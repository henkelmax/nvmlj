package de.bommel24.nvmlj;

public enum NVMLComputeMode {

    NVML_COMPUTEMODE_DEFAULT(0), NVML_COMPUTEMODE_EXCLUSIVE_THREAD(1), NVML_COMPUTEMODE_PROHIBITED(2), NVML_COMPUTEMODE_EXCLUSIVE_PROCESS(3);

    private final int i;

    NVMLComputeMode(int i) {
        this.i = i;
    }

    public int getValue() {
        return i;
    }

    public static NVMLComputeMode fromInt(int i) {
        for (NVMLComputeMode ret : values()) {
            if (i == ret.i) {
                return ret;
            }
        }
        return NVML_COMPUTEMODE_DEFAULT;
    }
}
