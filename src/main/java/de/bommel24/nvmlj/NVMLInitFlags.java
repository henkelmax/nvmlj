package de.bommel24.nvmlj;

public enum NVMLInitFlags {

    NVML_INIT_FLAG_NO_GPUS(1);

    private final int i;

    NVMLInitFlags(int i) {
        this.i = i;
    }

    public int getValue() {
        return i;
    }
}
