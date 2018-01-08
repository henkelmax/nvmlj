package de.bommel24.nvmlj;

public class NVMLJConstants {
	public static final int NVML_MAX_STRING_SIZE = 512;
	public static final int NVML_MAX_RUNNING_PROCESSES = 1024;
	public static final int NVML_MAX_PAGES = 1024;
	
	public static final int NVML_DEVICE_INFOROM_VERSION_BUFFER_SIZE = 16;
	public static final int NVML_DEVICE_NAME_BUFFER_SIZE = 64;
	public static final int NVML_DEVICE_PART_NUMBER_BUFFER_SIZE = 80;
	public static final int NVML_DEVICE_SERIAL_BUFFER_SIZE = 30;
	public static final int NVML_DEVICE_UUID_BUFFER_SIZE = 80;
	public static final int NVML_DEVICE_VBIOS_VERSION_BUFFER_SIZE = 32;
	public static final int NVML_SYSTEM_DRIVER_VERSION_BUFFER_SIZE = 80;
	public static final int NVML_SYSTEM_NVML_VERSION_BUFFER_SIZE = 80;
	public static final int NVML_DEVICE_PCI_BUS_ID_BUFFER_SIZE = 32;
	public static final int NVML_DEVICE_PCI_BUS_ID_BUFFER_V2_SIZE = 16;
	public static final int NVML_MAX_PHYSICAL_BRIDGE = 128;
	public static final int NVML_NVLINK_MAX_LINKS = 6;
	public static final int NVML_VALUE_NOT_AVAILABLE = -1;

	public static final long nvmlClocksThrottleReasonApplicationsClocksSetting = 0x0000000000000002L;
	public static final long nvmlClocksThrottleReasonGpuIdle = 0x0000000000000001L;
	public static final long nvmlClocksThrottleReasonHwSlowdown = 0x0000000000000008L;
	public static final long nvmlClocksThrottleReasonNone = 0x0000000000000000L;
	public static final long nvmlClocksThrottleReasonSwPowerCap = 0x0000000000000004L;
	public static final long nvmlClocksThrottleReasonSwThermalSlowdown = 0x0000000000000020L;
	public static final long nvmlClocksThrottleReasonSyncBoost = 0x0000000000000010L;
	
	
}
