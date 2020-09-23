package de.bommel24.nvmlj;

public enum NVMLSamplingType {
    NVML_TOTAL_POWER_SAMPLES(0), NVML_GPU_UTILIZATION_SAMPLES(1), NVML_MEMORY_UTILIZATION_SAMPLES(2),
    NVML_ENC_UTILIZATION_SAMPLES(3), NVML_DEC_UTILIZATION_SAMPLES(4), NVML_PROCESSOR_CLK_SAMPLES(5),
    NVML_MEMORY_CLK_SAMPLES(6);

    private final int i;

    NVMLSamplingType(int i) {
        this.i = i;
    }

    public int getValue() {
        return i;
    }

    public static NVMLSamplingType fromInt(int i) {
        for (NVMLSamplingType ret : values()) {
            if (i == ret.i) {
                return ret;
            }
        }
        return NVML_TOTAL_POWER_SAMPLES;
    }
}
