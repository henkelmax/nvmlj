package de.bommel24.nvmlj;

public enum NVMLGpuTopologyLevel {
	NVML_TOPOLOGY_INTERNAL(0), NVML_TOPOLOGY_SINGLE(10), NVML_TOPOLOGY_MULTIPLE(20), NVML_TOPOLOGY_HOSTBRIDGE(
			30), NVML_TOPOLOGY_NODE(40), NVML_TOPOLOGY_SYSTEM(50);

	private int i;

	private NVMLGpuTopologyLevel(int i) {
		this.i = i;
	}

	public int getValue() {
		return i;
	}

	public static NVMLGpuTopologyLevel fromInt(int i) {
		for (NVMLGpuTopologyLevel ret : values()) {
			if (i == ret.i) {
				return ret;
			}
		}
		return NVML_TOPOLOGY_INTERNAL;
	}
}
