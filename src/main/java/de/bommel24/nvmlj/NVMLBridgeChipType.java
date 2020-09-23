package de.bommel24.nvmlj;

public enum NVMLBridgeChipType {

    NVML_BRIDGE_CHIP_PLX(0), NVML_BRIDGE_CHIP_BRO4(1);

    private final int i;

    NVMLBridgeChipType(int i) {
        this.i = i;
    }

    public int getValue() {
        return i;
    }

    public static NVMLBridgeChipType fromInt(int i) {
        for (NVMLBridgeChipType ret : values()) {
            if (i == ret.i) {
                return ret;
            }
        }
        return NVML_BRIDGE_CHIP_PLX;
    }
}
