package de.bommel24.nvmlj;

public enum NVMLMemoryLocation {

    NVML_MEMORY_LOCATION_L1_CACHE(0), NVML_MEMORY_LOCATION_L2_CACHE(1), NVML_MEMORY_LOCATION_DEVICE_MEMORY(2), NVML_MEMORY_LOCATION_REGISTER_FILE(3), NVML_MEMORY_LOCATION_TEXTURE_MEMORY(4), NVML_MEMORY_LOCATION_TEXTURE_SHM(5), NVML_MEMORY_LOCATION_CBU(6);

    private final int i;

    NVMLMemoryLocation(int i) {
        this.i = i;
    }

    public int getValue() {
        return i;
    }

    public static NVMLMemoryLocation fromInt(int i) {
        for (NVMLMemoryLocation ret : values()) {
            if (i == ret.i) {
                return ret;
            }
        }
        return NVML_MEMORY_LOCATION_L1_CACHE;
    }
}
