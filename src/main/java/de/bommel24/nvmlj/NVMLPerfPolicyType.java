package de.bommel24.nvmlj;

public enum NVMLPerfPolicyType {
	NVML_PERF_POLICY_POWER(0), NVML_PERF_POLICY_THERMAL(1), NVML_PERF_POLICY_SYNC_BOOST(
			2), NVML_PERF_POLICY_BOARD_LIMIT(3), NVML_PERF_POLICY_LOW_UTILIZATION(4), NVML_PERF_POLICY_RELIABILITY(
					5), NVML_PERF_POLICY_TOTAL_APP_CLOCKS(10), NVML_PERF_POLICY_TOTAL_BASE_CLOCKS(11);

	private int i;

	private NVMLPerfPolicyType(int i) {
		this.i = i;
	}

	public int getValue() {
		return i;
	}

	public static NVMLPerfPolicyType fromInt(int i) {
		for (NVMLPerfPolicyType ret : values()) {
			if (i == ret.i) {
				return ret;
			}
		}
		return NVML_PERF_POLICY_POWER;
	}
}
