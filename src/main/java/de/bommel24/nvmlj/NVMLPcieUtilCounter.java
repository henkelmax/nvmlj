package de.bommel24.nvmlj;

public enum NVMLPcieUtilCounter {

    NVML_PCIE_UTIL_TX_BYTES(0), NVML_PCIE_UTIL_RX_BYTES(1);

    private final int i;

    NVMLPcieUtilCounter(int i) {
        this.i = i;
    }

    public int getValue() {
        return i;
    }

    public static NVMLPcieUtilCounter fromInt(int i) {
        for (NVMLPcieUtilCounter ret : values()) {
            if (i == ret.i) {
                return ret;
            }
        }
        return NVML_PCIE_UTIL_TX_BYTES;
    }
}
