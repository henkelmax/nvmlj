package de.bommel24.nvmlj;

public enum NVMLTemperatureSensors {
	NVML_TEMPERATURE_GPU(0);

	private int i;

	private NVMLTemperatureSensors(int i) {
		this.i = i;
	}

	public int getValue() {
		return i;
	}

	public static NVMLTemperatureSensors fromInt(int i) {
		for (NVMLTemperatureSensors ret : values()) {
			if (i == ret.i) {
				return ret;
			}
		}
		return NVML_TEMPERATURE_GPU;
	}
}
