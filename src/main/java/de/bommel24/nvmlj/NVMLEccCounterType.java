package de.bommel24.nvmlj;

public enum NVMLEccCounterType {
	NVML_VOLATILE_ECC(0), NVML_AGGREGATE_ECC (1);

	private int i;

	private NVMLEccCounterType(int i) {
		this.i = i;
	}

	public int getValue() {
		return i;
	}

	public static NVMLEccCounterType fromInt(int i) {
		for (NVMLEccCounterType ret : values()) {
			if (i == ret.i) {
				return ret;
			}
		}
		return NVML_VOLATILE_ECC;
	}
}
