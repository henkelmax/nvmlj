package de.bommel24.nvmlj;

public enum NVMLInforomObject {

    NVML_INFOROM_OEM(0), NVML_INFOROM_ECC(1), NVML_INFOROM_POWER(2);

    private final int i;

    NVMLInforomObject(int i) {
        this.i = i;
    }

    public int getValue() {
        return i;
    }

    public static NVMLInforomObject fromInt(int i) {
        for (NVMLInforomObject ret : values()) {
            if (i == ret.i) {
                return ret;
            }
        }
        return NVML_INFOROM_OEM;
    }
}
