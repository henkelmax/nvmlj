package de.bommel24.nvmlj;

public enum NVMLReturn {
	NVML_SUCCESS(0), NVML_ERROR_UNINITIALIZED(1), NVML_ERROR_INVALID_ARGUMENT(2), NVML_ERROR_NOT_SUPPORTED(
			3), NVML_ERROR_NO_PERMISSION(4), NVML_ERROR_ALREADY_INITIALIZED(5), NVML_ERROR_NOT_FOUND(
					6), NVML_ERROR_INSUFFICIENT_SIZE(7), NVML_ERROR_INSUFFICIENT_POWER(8), NVML_ERROR_DRIVER_NOT_LOADED(
							9), NVML_ERROR_TIMEOUT(10), NVML_ERROR_IRQ_ISSUE(11), NVML_ERROR_LIBRARY_NOT_FOUND(
									12), NVML_ERROR_FUNCTION_NOT_FOUND(13), NVML_ERROR_CORRUPTED_INFOROM(
											14), NVML_ERROR_GPU_IS_LOST(15), NVML_ERROR_RESET_REQUIRED(
													16), NVML_ERROR_OPERATING_SYSTEM(
															17), NVML_ERROR_LIB_RM_VERSION_MISMATCH(
																	18), NVML_ERROR_IN_USE(19), NVML_ERROR_MEMORY(
																			20), NVML_ERROR_NO_DATA(
																					21), NVML_ERROR_VGPU_ECC_NOT_SUPPORTED(
																							22), NVML_ERROR_UNKNOWN(
																									999);

	private int i;

	private NVMLReturn(int i) {
		this.i = i;
	}

	public static NVMLReturn fromInt(int i) {
		for (NVMLReturn ret : values()) {
			if (i == ret.i) {
				return ret;
			}
		}
		return NVML_ERROR_UNKNOWN;
	}

}