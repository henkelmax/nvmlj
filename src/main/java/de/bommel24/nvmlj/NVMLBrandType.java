package de.bommel24.nvmlj;

public enum NVMLBrandType {

    NVML_BRAND_UNKNOWN(0), NVML_BRAND_QUADRO(1), NVML_BRAND_TESLA(2), NVML_BRAND_NVS(3), NVML_BRAND_GRID(4), NVML_BRAND_GEFORCE(5);

    private final int i;

    NVMLBrandType(int i) {
        this.i = i;
    }

    public int getValue() {
        return i;
    }

    public static NVMLBrandType fromInt(int i) {
        for (NVMLBrandType ret : values()) {
            if (i == ret.i) {
                return ret;
            }
        }
        return NVML_BRAND_UNKNOWN;
    }
}
