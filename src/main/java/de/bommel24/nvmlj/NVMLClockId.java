package de.bommel24.nvmlj;

public enum NVMLClockId {
	NVML_CLOCK_ID_CURRENT(0), NVML_CLOCK_ID_APP_CLOCK_TARGET(1), NVML_CLOCK_ID_APP_CLOCK_DEFAULT(
			2), NVML_CLOCK_ID_CUSTOMER_BOOST_MAX(3);

	private int i;

	private NVMLClockId(int i) {
		this.i = i;
	}

	public int getValue() {
		return i;
	}

	public static NVMLClockId fromInt(int i) {
		for (NVMLClockId ret : values()) {
			if (i == ret.i) {
				return ret;
			}
		}
		return NVML_CLOCK_ID_CURRENT;
	}
}
