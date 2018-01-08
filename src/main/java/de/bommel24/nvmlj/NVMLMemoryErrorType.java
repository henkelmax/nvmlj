package de.bommel24.nvmlj;

public enum NVMLMemoryErrorType {
	NVML_MEMORY_ERROR_TYPE_CORRECTED(0), NVML_MEMORY_ERROR_TYPE_UNCORRECTED(1);

	private int i;

	private NVMLMemoryErrorType(int i) {
		this.i = i;
	}

	public int getValue() {
		return i;
	}

	public static NVMLMemoryErrorType fromInt(int i) {
		for (NVMLMemoryErrorType ret : values()) {
			if (i == ret.i) {
				return ret;
			}
		}
		return NVML_MEMORY_ERROR_TYPE_CORRECTED;
	}
}
