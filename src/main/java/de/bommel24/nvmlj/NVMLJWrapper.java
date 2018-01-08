package de.bommel24.nvmlj;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.LongByReference;

interface NVMLJWrapper extends Library {
	NVMLJWrapper INSTANCE = (NVMLJWrapper) Native.loadLibrary(NVMLPath.getPath(), NVMLJWrapper.class);

	int nvmlInit();

	int nvmlInitWithFlags(int initFlags);

	int nvmlShutdown();

	int nvmlSystemGetCudaDriverVersion(IntByReference cudaDriverVersion);

	int nvmlSystemGetDriverVersion(byte[] version, int length);

	int nvmlSystemGetNVMLVersion(byte[] version, int length);

	int nvmlSystemGetProcessName(int pid, byte[] name, int length);

	int nvmlSystemGetHicVersion(IntByReference hwbcCount, NVMLHwbcEntry array);

	int nvmlSystemGetTopologyGpuSet(int cpuNumber, IntByReference count, long[] deviceArray);

	// UNIT
	int nvmlUnitGetCount(IntByReference unitCount);

	int nvmlUnitGetDevices(long unit, IntByReference intby, long[] array);

	int nvmlUnitGetFanSpeedInfo(long unit, NVMLUnitFanSpeeds fanSpeeds);

	int nvmlUnitGetHandleByIndex(int index, LongByReference s);

	int nvmlUnitGetLedState(long unit, NVMLLedState state);

	int nvmlUnitGetPsuInfo(long unit, NVMLPsuInfo psu);

	int nvmlUnitGetTemperature(long unit, int type, IntByReference temp);

	int nvmlUnitGetUnitInfo(long unit, NVMLUnitInfo uinfo);

	int nvmlUnitSetLedState(long unit, int color);

	// DEVICE
	int nvmlDeviceGetCount(IntByReference deviceCount);

	int nvmlDeviceGetHandleByIndex(int index, LongByReference s);

	int nvmlDeviceGetHandleByPciBusId(char[] chars, LongByReference s);

	int nvmlDeviceGetHandleBySerial(char[] chars, LongByReference s);

	int nvmlDeviceGetHandleByUUID(char[] chars, LongByReference s);

	int nvmlDeviceClearCpuAffinity(long device);

	int nvmlDeviceGetAPIRestriction(long device, int apiType, IntByReference isRestricted);

	int nvmlDeviceGetApplicationsClock(long device, int clockType, IntByReference intBy);

	int nvmlDeviceGetAutoBoostedClocksEnabled(long device, IntByReference isEnabled, IntByReference isEnabledDefault);

	int nvmlDeviceGetBAR1MemoryInfo(long device, NVMLBAR1Memory bar1Memory);

	int nvmlDeviceGetBoardId(long device, IntByReference boardId);

	int nvmlDeviceGetBoardPartNumber(long device, byte[] name, int length);

	int nvmlDeviceGetBrand(long device, IntByReference type);

	int nvmlDeviceGetBridgeChipInfo(long device, NVMLBridgeChipHierarchy.ByReference type);

	int nvmlDeviceGetClock(long device, int clockType, int clockId, IntByReference clockMHz);

	int nvmlDeviceGetClockInfo(long device, int clockType, IntByReference clockMHz);

	int nvmlDeviceGetComputeMode(long device, IntByReference mode);

	int nvmlDeviceGetComputeRunningProcesses(long device, IntByReference infoCount, NVMLProcessInfo infos);

	int nvmlDeviceGetCpuAffinity(long device, int cpuSetSize, int[] longArray);

	int nvmlDeviceGetCudaComputeCapability(long device, IntByReference major, IntByReference minor);

	int nvmlDeviceGetCurrPcieLinkGeneration(long device, IntByReference currLinkGen);

	int nvmlDeviceGetCurrPcieLinkWidth(long device, IntByReference currLinkGen);

	int nvmlDeviceGetCurrentClocksThrottleReasons(long device, LongByReference clocksThrottleReasons);

	int nvmlDeviceGetDecoderUtilization(long device, IntByReference utilization, IntByReference samplingPeriodUs);

	int nvmlDeviceGetDefaultApplicationsClock(long device, int clockType, IntByReference clockMHz);

	int nvmlDeviceGetDetailedEccErrors(long device, int errorType, int counterType, NVMLEccErrorCounts eccCounts);

	int nvmlDeviceGetDisplayActive(long device, IntByReference isActive);

	int nvmlDeviceGetDisplayMode(long device, IntByReference isActive);

	int nvmlDeviceGetDriverModel(long device, IntByReference current, IntByReference pending);

	int nvmlDeviceGetEccMode(long device, IntByReference current, IntByReference pending);

	int nvmlDeviceGetEncoderCapacity(long device, int encoderQueryType, IntByReference encoderCapacity);

	int nvmlDeviceGetEncoderSessions(long device, IntByReference infoCount, NVMLEncoderSessionInfo infos);

	int nvmlDeviceGetEncoderStats(long device, IntByReference sessionCount, IntByReference averageFps,
                                  IntByReference averageLatency);

	int nvmlDeviceGetEncoderUtilization(long device, IntByReference utilization, IntByReference samplingPeriodUs);

	int nvmlDeviceGetEnforcedPowerLimit(long device, IntByReference limit);

	int nvmlDeviceGetFanSpeed(long device, IntByReference speed);

	int nvmlDeviceGetGpuOperationMode(long device, IntByReference current, IntByReference pending);

	int nvmlDeviceGetGraphicsRunningProcesses(long device, IntByReference infoCount, NVMLProcessInfo infos);

	int nvmlDeviceGetIndex(long device, IntByReference index);

	int nvmlDeviceGetInforomConfigurationChecksum(long device, IntByReference index);

	int nvmlDeviceGetInforomImageVersion(long device, byte[] intBy, int length);

	int nvmlDeviceGetInforomVersion(long device, int inforom, byte[] intBy, int length);

	int nvmlDeviceGetMaxClockInfo(long device, int clockType, IntByReference clock);

	int nvmlDeviceGetMaxCustomerBoostClock(long device, int clockType, IntByReference clock);

	int nvmlDeviceGetMaxPcieLinkGeneration(long device, IntByReference index);

	int nvmlDeviceGetMaxPcieLinkWidth(long device, IntByReference index);

	int nvmlDeviceGetMemoryErrorCounter(long device, int memoryError, int eccError, int memoryLocation,
                                        LongByReference count);

	int nvmlDeviceGetMemoryInfo(long device, NVMLMemory memory);

	int nvmlDeviceGetMinorNumber(long device, IntByReference intBy);

	int nvmlDeviceGetMultiGpuBoard(long device, IntByReference intBy);

	int nvmlDeviceGetName(long device, byte[] intBy, int length);

	int nvmlDeviceGetP2PStatus(long device1, long device2, int p2pIndex, IntByReference p2pStatus);

	int nvmlDeviceGetPciInfo(long device, NVMLPciInfo pciInfo);

	int nvmlDeviceGetPcieReplayCounter(long device, IntByReference intBy);

	int nvmlDeviceGetPcieThroughput(long device, int counter, IntByReference intBy);

	int nvmlDeviceGetPerformanceState(long device, IntByReference pState);

	int nvmlDeviceGetPersistenceMode(long device, IntByReference pState);

	int nvmlDeviceGetPowerManagementDefaultLimit(long device, IntByReference pState);

	int nvmlDeviceGetPowerManagementLimit(long device, IntByReference pState);

	int nvmlDeviceGetPowerManagementLimitConstraints(long device, IntByReference min, IntByReference max);

	int nvmlDeviceGetPowerManagementMode(long device, IntByReference mode);

	int nvmlDeviceGetPowerState(long device, IntByReference mode);

	int nvmlDeviceGetPowerUsage(long device, IntByReference mode);

	int nvmlDeviceGetRetiredPages(long device, int cause, IntByReference pageCount, long[] addresses);

	int nvmlDeviceGetRetiredPagesPendingStatus(long device, IntByReference isPending);

	int nvmlDeviceGetSamples(long device, int type, long lastSeenTimeStamp, IntByReference sampleValType,
                             IntByReference sampleCount, NVMLSample samples);

	int nvmlDeviceGetSerial(long device, byte[] chars, int length);

	int nvmlDeviceGetSupportedClocksThrottleReasons(long device, LongByReference bit);

	int nvmlDeviceGetSupportedGraphicsClocks(long device, int memoryClockMHz, IntByReference count, int[] clocksMHz);

	int nvmlDeviceGetSupportedMemoryClocks(long device, IntByReference count, int[] clocksMHz);

	int nvmlDeviceGetTemperature(long device, int sensorType, IntByReference temp);

	int nvmlDeviceGetTemperatureThreshold(long device, int thresholdType, IntByReference temp);

	int nvmlDeviceGetTopologyCommonAncestor(long device1, long device2, IntByReference pathInfo);

	int nvmlDeviceGetTopologyNearestGpus(long device, int level, IntByReference count, long[] deviceArray);

	int nvmlDeviceGetTotalEccErrors(long device, int errorType, int counterType, LongByReference eccCounts);

	int nvmlDeviceGetTotalEnergyConsumption(long device, LongByReference energy);

	int nvmlDeviceGetUUID(long device, byte[] intBy, int length);

	int nvmlDeviceGetUtilizationRates(long device, NVMLUtilization util);

	int nvmlDeviceGetVbiosVersion(long device, byte[] intBy, int length);

	int nvmlDeviceGetViolationStatus(long device, int perfPolicy, NVMLViolationTime util);

	int nvmlDeviceOnSameBoard(long device1, long device2, IntByReference onSameBoard);

	int nvmlDeviceResetApplicationsClocks(long device1);

	int nvmlDeviceSetAutoBoostedClocksEnabled(long device, int enabled);

	int nvmlDeviceSetCpuAffinity(long device1);

	int nvmlDeviceSetDefaultAutoBoostedClocksEnabled(long device, int enabled, int flags);

	int nvmlDeviceValidateInforom(long device);

	int nvmlDeviceClearEccErrorCounts(long device, int counterType);

	int nvmlDeviceSetAPIRestriction(long device, int apiType, int isRestricted);

	int nvmlDeviceSetApplicationsClocks(long device, int memClockMHz, int graphicsClockMHz);

	int nvmlDeviceSetComputeMode(long device, int mode);

	int nvmlDeviceSetDriverModel(long device, int driverModel, int flags);

	int nvmlDeviceSetEccMode(long device, int ecc);

	int nvmlDeviceSetGpuOperationMode(long device, int mode);

	int nvmlDeviceSetPersistenceMode(long device, int mode);

	int nvmlDeviceSetPowerManagementLimit(long device, int limit);
}
