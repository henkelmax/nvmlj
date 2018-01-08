package de.bommel24.nvmlj;

public enum NVMLTemperatureThresholds {
	NVML_TEMPERATURE_THRESHOLD_SHUTDOWN(0), NVML_TEMPERATURE_THRESHOLD_SLOWDOWN(1), NVML_TEMPERATURE_THRESHOLD_MEM_MAX(
			2), NVML_TEMPERATURE_THRESHOLD_GPU_MAX(3);

	private int i;

	private NVMLTemperatureThresholds(int i) {
		this.i = i;
	}

	public int getValue() {
		return i;
	}

	public static NVMLTemperatureThresholds fromInt(int i) {
		for (NVMLTemperatureThresholds ret : values()) {
			if (i == ret.i) {
				return ret;
			}
		}
		return NVML_TEMPERATURE_THRESHOLD_SHUTDOWN;
	}
}
