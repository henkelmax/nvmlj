package de.bommel24.nvmlj;

public enum NVMLRestrictedApi {
	NVML_RESTRICTED_API_SET_APPLICATION_CLOCKS(0), NVML_RESTRICTED_API_SET_AUTO_BOOSTED_CLOCKS(1);

	private int i;

	private NVMLRestrictedApi(int i) {
		this.i = i;
	}

	public int getValue() {
		return i;
	}

	public static NVMLRestrictedApi fromInt(int i) {
		for (NVMLRestrictedApi ret : values()) {
			if (i == ret.i) {
				return ret;
			}
		}
		return NVML_RESTRICTED_API_SET_APPLICATION_CLOCKS;
	}
}
