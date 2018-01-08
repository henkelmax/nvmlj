package de.bommel24.nvmlj;

public enum NVMLValueType {
	NVML_VALUE_TYPE_DOUBLE(0), NVML_VALUE_TYPE_UNSIGNED_INT(1), NVML_VALUE_TYPE_UNSIGNED_LONG(
			2), NVML_VALUE_TYPE_UNSIGNED_LONG_LONG(3), NVML_VALUE_TYPE_SIGNED_LONG_LONG(4);

	private int i;

	private NVMLValueType(int i) {
		this.i = i;
	}

	public int getValue() {
		return i;
	}

	public static NVMLValueType fromInt(int i) {
		for (NVMLValueType ret : values()) {
			if (i == ret.i) {
				return ret;
			}
		}
		return NVML_VALUE_TYPE_UNSIGNED_INT;
	}
}
