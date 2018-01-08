package de.bommel24.nvmlj;

public enum NVMLPstates {
	NVML_PSTATE_0(0), NVML_PSTATE_1(1), NVML_PSTATE_2(2), NVML_PSTATE_3(3), NVML_PSTATE_4(4), NVML_PSTATE_5(5), 
	NVML_PSTATE_6(6), NVML_PSTATE_7(7), NVML_PSTATE_8(8), NVML_PSTATE_9(9), NVML_PSTATE_10(10), NVML_PSTATE_11(11),
	NVML_PSTATE_12(12), NVML_PSTATE_13(13), NVML_PSTATE_14(14), NVML_PSTATE_15(15), NVML_PSTATE_UNKNOWN(32);

	private int i;

	private NVMLPstates(int i) {
		this.i = i;
	}

	public int getValue() {
		return i;
	}

	public static NVMLPstates fromInt(int i) {
		for (NVMLPstates ret : values()) {
			if (i == ret.i) {
				return ret;
			}
		}
		return NVML_PSTATE_UNKNOWN;
	}
}
