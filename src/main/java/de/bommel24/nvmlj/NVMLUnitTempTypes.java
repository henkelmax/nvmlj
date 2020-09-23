package de.bommel24.nvmlj;

public enum NVMLUnitTempTypes {

    NVML_TEMP_INTAKE(0), NVML_TEMP_EXHAUST(1), NVML_TEMP_BOARD(2);

    private final int i;

    NVMLUnitTempTypes(int i) {
        this.i = i;
    }

    public int getValue() {
        return i;
    }

    public static NVMLUnitTempTypes fromInt(int i) {
        for (NVMLUnitTempTypes ret : values()) {
            if (i == ret.i) {
                return ret;
            }
        }
        return NVML_TEMP_INTAKE;
    }
}
