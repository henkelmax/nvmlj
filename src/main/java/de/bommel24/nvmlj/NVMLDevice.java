package de.bommel24.nvmlj;

import com.sun.jna.Native;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.LongByReference;

public class NVMLDevice {

    long id;

    public NVMLDevice(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id + "";
    }

    public void nvmlDeviceClearCpuAffinity() throws NVMLJException {
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceClearCpuAffinity(id));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
    }

    public NVMLEnableState nvmlDeviceGetAPIRestriction(int apiType) throws NVMLJException {
        IntByReference intBy = new IntByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetAPIRestriction(id, apiType, intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return NVMLEnableState.fromInt(intBy.getValue());
    }

    public int nvmlDeviceGetApplicationsClock(NVMLClockType clockType) throws NVMLJException {
        IntByReference intBy = new IntByReference();
        NVMLReturn error = NVMLReturn
                .fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetApplicationsClock(id, clockType.getValue(), intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy.getValue();
    }

    public NVMLEnableState nvmlDeviceGetAutoBoostedClocksEnabled() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        IntByReference intBy2 = new IntByReference();
        NVMLReturn error = NVMLReturn
                .fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetAutoBoostedClocksEnabled(id, intBy, intBy2));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return NVMLEnableState.fromInt(intBy.getValue());
    }

    public NVMLEnableState nvmlDeviceGetAutoBoostedClocksEnabledByDefault() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        IntByReference intBy2 = new IntByReference();
        NVMLReturn error = NVMLReturn
                .fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetAutoBoostedClocksEnabled(id, intBy, intBy2));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return NVMLEnableState.fromInt(intBy2.getValue());
    }

    public NVMLBAR1Memory nvmlDeviceGetBAR1MemoryInfo() throws NVMLJException {
        NVMLBAR1Memory intBy = new NVMLBAR1Memory();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetBAR1MemoryInfo(id, intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy;
    }

    public int nvmlDeviceGetBoardId() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetBoardId(id, intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy.getValue();
    }

    public String nvmlDeviceGetBoardPartNumber() throws NVMLJException {
        byte[] string = new byte[NVMLJConstants.NVML_DEVICE_PART_NUMBER_BUFFER_SIZE];
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetBoardPartNumber(id, string,
                NVMLJConstants.NVML_DEVICE_PART_NUMBER_BUFFER_SIZE));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return Native.toString(string);
    }

    public NVMLBrandType nvmlDeviceGetBrand() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetBrand(id, intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return NVMLBrandType.fromInt(intBy.getValue());
    }

    public NVMLBridgeChipHierarchy nvmlDeviceGetBridgeChipInfo() throws NVMLJException {
        NVMLBridgeChipHierarchy.ByReference intBy = new NVMLBridgeChipHierarchy.ByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetBridgeChipInfo(id, intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy;
    }

    public int nvmlDeviceGetClock(NVMLClockType clockType, NVMLClockId clockId) throws NVMLJException {
        IntByReference intBy = new IntByReference();
        NVMLReturn error = NVMLReturn
                .fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetClock(id, clockType.getValue(), clockId.getValue(), intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy.getValue();
    }

    public int nvmlDeviceGetClockInfo(NVMLClockType clockType) throws NVMLJException {
        IntByReference intBy = new IntByReference();
        NVMLReturn error = NVMLReturn
                .fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetClockInfo(id, clockType.getValue(), intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy.getValue();
    }

    public NVMLComputeMode nvmlDeviceGetComputeMode() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetComputeMode(id, intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return NVMLComputeMode.fromInt(intBy.getValue());
    }

    public NVMLProcessInfo[] nvmlDeviceGetComputeRunningProcesses() throws NVMLJException {
        IntByReference intBy = new IntByReference(NVMLJConstants.NVML_MAX_RUNNING_PROCESSES);
        NVMLProcessInfo s = new NVMLProcessInfo();
        NVMLProcessInfo[] array = (NVMLProcessInfo[]) s.toArray(intBy.getValue());
        NVMLReturn error = NVMLReturn
                .fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetComputeRunningProcesses(id, intBy, array[0]));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        NVMLProcessInfo[] array2 = new NVMLProcessInfo[intBy.getValue()];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = array[i];
        }
        return array2;
    }

    public int[] nvmlDeviceGetCpuAffinity() throws NVMLJException {
        int[] longArray = new int[512];
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetCpuAffinity(id, 512, longArray));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return longArray;
    }

    public int nvmlDeviceGetCudaComputeCapabilityMajor() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        IntByReference intBy2 = new IntByReference();
        NVMLReturn error = NVMLReturn
                .fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetCudaComputeCapability(id, intBy, intBy2));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy.getValue();
    }

    public int nvmlDeviceGetCudaComputeCapabilityMinor() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        IntByReference intBy2 = new IntByReference();
        NVMLReturn error = NVMLReturn
                .fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetCudaComputeCapability(id, intBy, intBy2));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy2.getValue();
    }

    public int nvmlDeviceGetCurrPcieLinkGeneration() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetCurrPcieLinkGeneration(id, intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy.getValue();
    }

    public int nvmlDeviceGetCurrPcieLinkWidth() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetCurrPcieLinkWidth(id, intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy.getValue();
    }

    public long nvmlDeviceGetCurrentClocksThrottleReasons() throws NVMLJException {
        LongByReference intBy = new LongByReference();
        NVMLReturn error = NVMLReturn
                .fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetCurrentClocksThrottleReasons(id, intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy.getValue();
    }

    public int nvmlDeviceGetDecoderUtilization() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        IntByReference intBy2 = new IntByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetDecoderUtilization(id, intBy, intBy2));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy.getValue();
    }

    public int nvmlDeviceGetDecoderUtilizationSamplingPeriod() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        IntByReference intBy2 = new IntByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetDecoderUtilization(id, intBy, intBy2));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy2.getValue();
    }

    public int nvmlDeviceGetDefaultApplicationsClock(NVMLClockType clockType) throws NVMLJException {
        IntByReference intBy = new IntByReference();
        NVMLReturn error = NVMLReturn
                .fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetDefaultApplicationsClock(id, clockType.getValue(), intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy.getValue();
    }

    public NVMLEccErrorCounts nvmlDeviceGetDetailedEccErrors(NVMLMemoryErrorType memoryError, NVMLEccCounterType eccCounter) throws NVMLJException {
        NVMLEccErrorCounts.ByReference intBy = new NVMLEccErrorCounts.ByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetDetailedEccErrors(id,
                memoryError.getValue(), eccCounter.getValue(), intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy;
    }

    public NVMLEnableState nvmlDeviceGetDisplayActive() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetDisplayActive(id, intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return NVMLEnableState.fromInt(intBy.getValue());
    }

    public NVMLEnableState nvmlDeviceGetDisplayMode() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetDisplayMode(id, intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return NVMLEnableState.fromInt(intBy.getValue());
    }

    public NVMLDriverModel nvmlDeviceGetDriverModelCurrent() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        IntByReference intBy2 = new IntByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetDriverModel(id, intBy, intBy2));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return NVMLDriverModel.fromInt(intBy.getValue());
    }

    public NVMLDriverModel nvmlDeviceGetDriverModelPending() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        IntByReference intBy2 = new IntByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetDriverModel(id, intBy, intBy2));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return NVMLDriverModel.fromInt(intBy2.getValue());
    }

    public NVMLDriverModel nvmlDeviceGetEccModeCurrent() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        IntByReference intBy2 = new IntByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetEccMode(id, intBy, intBy2));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return NVMLDriverModel.fromInt(intBy.getValue());
    }

    public NVMLDriverModel nvmlDeviceGetEccModePending() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        IntByReference intBy2 = new IntByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetEccMode(id, intBy, intBy2));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return NVMLDriverModel.fromInt(intBy2.getValue());
    }

    public int nvmlDeviceGetEncoderCapacity(int encoder) throws NVMLJException {
        IntByReference intBy = new IntByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetEncoderCapacity(id, encoder, intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy.getValue();
    }

    public NVMLEncoderSessionInfo[] nvmlDeviceGetEncoderSessions() throws NVMLJException {
        IntByReference intBy = new IntByReference(512);
        NVMLEncoderSessionInfo s = new NVMLEncoderSessionInfo();
        NVMLEncoderSessionInfo[] array = (NVMLEncoderSessionInfo[]) s.toArray(intBy.getValue());
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetEncoderSessions(id, intBy, array[0]));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        NVMLEncoderSessionInfo[] array2 = new NVMLEncoderSessionInfo[intBy.getValue()];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = array[i];
        }
        return array2;
    }

    public int nvmlDeviceGetEncoderSessionCount() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        IntByReference intBy2 = new IntByReference();
        IntByReference intBy3 = new IntByReference();
        NVMLReturn error = NVMLReturn
                .fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetEncoderStats(id, intBy, intBy2, intBy3));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy.getValue();
    }

    public int nvmlDeviceGetEncoderAverageFps() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        IntByReference intBy2 = new IntByReference();
        IntByReference intBy3 = new IntByReference();
        NVMLReturn error = NVMLReturn
                .fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetEncoderStats(id, intBy, intBy2, intBy3));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy2.getValue();
    }

    public int nvmlDeviceGetEncoderAverageLatency() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        IntByReference intBy2 = new IntByReference();
        IntByReference intBy3 = new IntByReference();
        NVMLReturn error = NVMLReturn
                .fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetEncoderStats(id, intBy, intBy2, intBy3));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy3.getValue();
    }

    public int nvmlDeviceGetEncoderUtilization() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        IntByReference intBy2 = new IntByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetEncoderUtilization(id, intBy, intBy2));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy.getValue();
    }

    public int nvmlDeviceGetEncoderUtilizationSamplingPeriod() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        IntByReference intBy2 = new IntByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetEncoderUtilization(id, intBy, intBy2));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy2.getValue();
    }

    public int nvmlDeviceGetEnforcedPowerLimit() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetEnforcedPowerLimit(id, intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy.getValue();
    }

    public int nvmlDeviceGetFanSpeed() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetFanSpeed(id, intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy.getValue();
    }

    public NVMLGpuOperationMode nvmlDeviceGetGpuOperationModeCurrent() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        IntByReference intBy2 = new IntByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetGpuOperationMode(id, intBy, intBy2));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return NVMLGpuOperationMode.fromInt(intBy.getValue());
    }

    public NVMLGpuOperationMode nvmlDeviceGetGpuOperationModePending() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        IntByReference intBy2 = new IntByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetGpuOperationMode(id, intBy, intBy2));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return NVMLGpuOperationMode.fromInt(intBy2.getValue());
    }

    public NVMLProcessInfo[] nvmlDeviceGetGraphicsRunningProcesses() throws NVMLJException {
        IntByReference intBy = new IntByReference(NVMLJConstants.NVML_MAX_RUNNING_PROCESSES);
        NVMLProcessInfo s = new NVMLProcessInfo();
        NVMLProcessInfo[] array = (NVMLProcessInfo[]) s.toArray(intBy.getValue());
        NVMLReturn error = NVMLReturn
                .fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetGraphicsRunningProcesses(id, intBy, array[0]));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        NVMLProcessInfo[] array2 = new NVMLProcessInfo[intBy.getValue()];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = array[i];
        }
        return array2;
    }

    public int nvmlDeviceGetIndex() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetIndex(id, intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy.getValue();
    }

    public int nvmlDeviceGetInforomConfigurationChecksum() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        NVMLReturn error = NVMLReturn
                .fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetInforomConfigurationChecksum(id, intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy.getValue();
    }

    public String nvmlDeviceGetInforomImageVersion() throws NVMLJException {
        byte[] intBy = new byte[NVMLJConstants.NVML_DEVICE_INFOROM_VERSION_BUFFER_SIZE];
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetInforomImageVersion(id, intBy,
                NVMLJConstants.NVML_DEVICE_INFOROM_VERSION_BUFFER_SIZE));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return Native.toString(intBy);
    }

    public String nvmlDeviceGetInforomVersion(NVMLInforomObject inforom) throws NVMLJException {
        byte[] intBy = new byte[NVMLJConstants.NVML_DEVICE_INFOROM_VERSION_BUFFER_SIZE];
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetInforomVersion(id, inforom.getValue(),
                intBy, NVMLJConstants.NVML_DEVICE_INFOROM_VERSION_BUFFER_SIZE));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return Native.toString(intBy);
    }

    public int nvmlDeviceGetMaxClockInfo(NVMLClockType clockType) throws NVMLJException {
        IntByReference intBy = new IntByReference();
        NVMLReturn error = NVMLReturn
                .fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetMaxClockInfo(id, clockType.getValue(), intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy.getValue();
    }

    public int nvmlDeviceGetMaxCustomerBoostClock(NVMLClockType clockType) throws NVMLJException {
        IntByReference intBy = new IntByReference();
        NVMLReturn error = NVMLReturn
                .fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetMaxCustomerBoostClock(id, clockType.getValue(), intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy.getValue();
    }

    public int nvmlDeviceGetMaxPcieLinkGeneration() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetMaxPcieLinkGeneration(id, intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy.getValue();
    }

    public int nvmlDeviceGetMaxPcieLinkWidth() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetMaxPcieLinkWidth(id, intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy.getValue();
    }

    public long nvmlDeviceGetMemoryErrorCounter(NVMLMemoryErrorType memoryError, NVMLEccCounterType counterType,
                                                NVMLMemoryLocation loc) throws NVMLJException {
        LongByReference intBy = new LongByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetMemoryErrorCounter(id,
                memoryError.getValue(), counterType.getValue(), loc.getValue(), intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy.getValue();
    }

    public NVMLMemory nvmlDeviceGetMemoryInfo() throws NVMLJException {
        NVMLMemory.ByReference intBy = new NVMLMemory.ByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetMemoryInfo(id, intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy;
    }

    public int nvmlDeviceGetMinorNumber() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetMinorNumber(id, intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy.getValue();
    }

    public int nvmlDeviceGetMultiGpuBoard() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetMultiGpuBoard(id, intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy.getValue();
    }

    public String nvmlDeviceGetName() throws NVMLJException {
        byte[] intBy = new byte[NVMLJConstants.NVML_DEVICE_NAME_BUFFER_SIZE];
        NVMLReturn error = NVMLReturn.fromInt(
                NVMLJWrapper.INSTANCE.nvmlDeviceGetName(id, intBy, NVMLJConstants.NVML_DEVICE_NAME_BUFFER_SIZE));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return Native.toString(intBy);
    }

    public int nvmlDeviceGetP2PStatus(NVMLDevice device2, int p2pIndex) throws NVMLJException {
        IntByReference intBy = new IntByReference();
        NVMLReturn error = NVMLReturn
                .fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetP2PStatus(id, device2.id, p2pIndex, intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy.getValue();
    }

    public NVMLPciInfo nvmlDeviceGetPciInfo() throws NVMLJException {
        NVMLPciInfo.ByReference intBy = new NVMLPciInfo.ByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetPciInfo(id, intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy;
    }

    public int nvmlDeviceGetPcieReplayCounter() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetPcieReplayCounter(id, intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy.getValue();
    }

    public int nvmlDeviceGetPcieThroughput(NVMLPcieUtilCounter counter) throws NVMLJException {
        IntByReference intBy = new IntByReference();
        NVMLReturn error = NVMLReturn
                .fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetPcieThroughput(id, counter.getValue(), intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy.getValue();
    }

    public NVMLPstates nvmlDeviceGetPerformanceState() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetPerformanceState(id, intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return NVMLPstates.fromInt(intBy.getValue());
    }

    public NVMLEnableState nvmlDeviceGetPersistenceMode() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetPersistenceMode(id, intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return NVMLEnableState.fromInt(intBy.getValue());
    }

    public int nvmlDeviceGetPowerManagementDefaultLimit() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        NVMLReturn error = NVMLReturn
                .fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetPowerManagementDefaultLimit(id, intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy.getValue();
    }

    public int nvmlDeviceGetPowerManagementLimit() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetPowerManagementLimit(id, intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy.getValue();
    }

    public int nvmlDeviceGetPowerManagementLimitMin() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        IntByReference intBy2 = new IntByReference();
        NVMLReturn error = NVMLReturn
                .fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetPowerManagementLimitConstraints(id, intBy, intBy2));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy.getValue();
    }

    public int nvmlDeviceGetPowerManagementLimitMax() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        IntByReference intBy2 = new IntByReference();
        NVMLReturn error = NVMLReturn
                .fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetPowerManagementLimitConstraints(id, intBy, intBy2));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy2.getValue();
    }

    public NVMLEnableState nvmlDeviceGetPowerManagementMode() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetPowerManagementMode(id, intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return NVMLEnableState.fromInt(intBy.getValue());
    }

    public NVMLPstates nvmlDeviceGetPowerState() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetPowerState(id, intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return NVMLPstates.fromInt(intBy.getValue());
    }

    public int nvmlDeviceGetPowerUsage() throws NVMLJException {
        IntByReference intBy = new IntByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetPowerUsage(id, intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy.getValue();
    }

    public long[] nvmlDeviceGetRetiredPages(NVMLPageRetirementCause cause) throws NVMLJException {
        IntByReference intBy = new IntByReference(NVMLJConstants.NVML_MAX_PAGES);
        long[] longs = new long[NVMLJConstants.NVML_MAX_PAGES];
        NVMLReturn error = NVMLReturn
                .fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetRetiredPages(id, cause.getValue(), intBy, longs));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        long[] array2 = new long[intBy.getValue()];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = longs[i];
        }
        return array2;
    }

    public NVMLEnableState nvmlDeviceGetRetiredPagesPendingStatus() throws NVMLJException {
        IntByReference intBy = new IntByReference(NVMLJConstants.NVML_MAX_PAGES);
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetRetiredPagesPendingStatus(id, intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return NVMLEnableState.fromInt(intBy.getValue());
    }

    public NVMLSampleHolder nvmlDeviceGetSamples(NVMLSamplingType type, long timestamp, int samples)
            throws NVMLJException {
        IntByReference valType = new IntByReference();
        IntByReference sampleCount = new IntByReference(samples);
        NVMLSample s = new NVMLSample();
        NVMLSample[] array = (NVMLSample[]) s.toArray(sampleCount.getValue());
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetSamples(id, type.getValue(), timestamp,
                valType, sampleCount, array[0]));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        NVMLSample[] array2 = new NVMLSample[sampleCount.getValue()];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = array[i];
        }
        return new NVMLSampleHolder(array2, NVMLValueType.fromInt(valType.getValue()));
    }

    public String nvmlDeviceGetSerial() throws NVMLJException {
        byte[] chars = new byte[NVMLJConstants.NVML_DEVICE_SERIAL_BUFFER_SIZE];
        NVMLReturn error = NVMLReturn.fromInt(
                NVMLJWrapper.INSTANCE.nvmlDeviceGetSerial(id, chars, NVMLJConstants.NVML_DEVICE_SERIAL_BUFFER_SIZE));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return Native.toString(chars);
    }

    public long nvmlDeviceGetSupportedClocksThrottleReasons() throws NVMLJException {
        LongByReference longby = new LongByReference();
        NVMLReturn error = NVMLReturn
                .fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetSupportedClocksThrottleReasons(id, longby));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return longby.getValue();
    }

    public int[] nvmlDeviceGetSupportedGraphicsClocks(int memoryClock) throws NVMLJException {
        IntByReference intby = new IntByReference();
        int[] array = new int[NVMLJConstants.NVML_MAX_PAGES];
        NVMLReturn error = NVMLReturn
                .fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetSupportedGraphicsClocks(id, memoryClock, intby, array));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        int[] array2 = new int[intby.getValue()];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = array[i];
        }
        return array2;
    }

    public int[] nvmlDeviceGetSupportedMemoryClocks() throws NVMLJException {
        IntByReference intby = new IntByReference();
        int[] array = new int[NVMLJConstants.NVML_MAX_PAGES];
        NVMLReturn error = NVMLReturn
                .fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetSupportedMemoryClocks(id, intby, array));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        int[] array2 = new int[intby.getValue()];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = array[i];
        }
        return array2;
    }

    public int nvmlDeviceGetTemperature(NVMLTemperatureSensors tempSensor) throws NVMLJException {
        IntByReference intby = new IntByReference();

        NVMLReturn error = NVMLReturn
                .fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetTemperature(id, tempSensor.getValue(), intby));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intby.getValue();
    }

    public int nvmlDeviceGetTemperatureThreshold(NVMLTemperatureThresholds temperatureThresholds)
            throws NVMLJException {
        IntByReference intby = new IntByReference();

        NVMLReturn error = NVMLReturn.fromInt(
                NVMLJWrapper.INSTANCE.nvmlDeviceGetTemperatureThreshold(id, temperatureThresholds.getValue(), intby));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intby.getValue();
    }

    public NVMLGpuTopologyLevel nvmlDeviceGetTopologyCommonAncestor(NVMLDevice device2) throws NVMLJException {
        IntByReference intby = new IntByReference();

        NVMLReturn error = NVMLReturn
                .fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetTopologyCommonAncestor(id, device2.id, intby));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return NVMLGpuTopologyLevel.fromInt(intby.getValue());
    }

    public NVMLDevice[] nvmlDeviceGetTopologyNearestGpus(NVMLGpuTopologyLevel topology) throws NVMLJException {
        IntByReference intby = new IntByReference(512);
        long[] longs = new long[intby.getValue()];
        NVMLReturn error = NVMLReturn
                .fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetTopologyNearestGpus(id, topology.getValue(), intby, longs));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        NVMLDevice[] array2 = new NVMLDevice[intby.getValue()];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = new NVMLDevice(longs[i]);
        }
        return array2;
    }

    public long nvmlDeviceGetTotalEccErrors(NVMLMemoryErrorType memErr, NVMLEccCounterType countType)
            throws NVMLJException {
        LongByReference intby = new LongByReference();
        NVMLReturn error = NVMLReturn.fromInt(
                NVMLJWrapper.INSTANCE.nvmlDeviceGetTotalEccErrors(id, memErr.getValue(), countType.getValue(), intby));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intby.getValue();
    }

    public long nvmlDeviceGetTotalEnergyConsumption() throws NVMLJException {
        LongByReference intby = new LongByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetTotalEnergyConsumption(id, intby));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intby.getValue();
    }

    public String nvmlDeviceGetUUID() throws NVMLJException {
        byte[] intBy = new byte[NVMLJConstants.NVML_DEVICE_UUID_BUFFER_SIZE];
        NVMLReturn error = NVMLReturn.fromInt(
                NVMLJWrapper.INSTANCE.nvmlDeviceGetUUID(id, intBy, NVMLJConstants.NVML_DEVICE_UUID_BUFFER_SIZE));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return Native.toString(intBy);
    }

    public NVMLUtilization nvmlDeviceGetUtilizationRates() throws NVMLJException {
        NVMLUtilization.ByReference util = new NVMLUtilization.ByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetUtilizationRates(id, util));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return util;
    }

    public String nvmlDeviceGetVbiosVersion() throws NVMLJException {
        byte[] intBy = new byte[NVMLJConstants.NVML_DEVICE_VBIOS_VERSION_BUFFER_SIZE];
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetVbiosVersion(id, intBy,
                NVMLJConstants.NVML_DEVICE_VBIOS_VERSION_BUFFER_SIZE));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return Native.toString(intBy);
    }

    public NVMLViolationTime nvmlDeviceGetViolationStatus(NVMLPerfPolicyType policy) throws NVMLJException {
        NVMLViolationTime.ByReference intBy = new NVMLViolationTime.ByReference();
        NVMLReturn error = NVMLReturn
                .fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetViolationStatus(id, policy.getValue(), intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy;
    }

    public int nvmlDeviceOnSameBoard(NVMLDevice device2) throws NVMLJException {
        IntByReference intBy = new IntByReference();
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceOnSameBoard(id, device2.id, intBy));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
        return intBy.getValue();
    }

    public void nvmlDeviceResetApplicationsClocks() throws NVMLJException {
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceResetApplicationsClocks(id));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
    }

    public void nvmlDeviceSetAutoBoostedClocksEnabled(NVMLEnableState state) throws NVMLJException {
        NVMLReturn error = NVMLReturn
                .fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceSetAutoBoostedClocksEnabled(id, state.getValue()));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
    }

    public void nvmlDeviceSetCpuAffinity() throws NVMLJException {
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceSetCpuAffinity(id));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
    }

    public void nvmlDeviceSetDefaultAutoBoostedClocksEnabled(NVMLEnableState state, int flags) throws NVMLJException {
        NVMLReturn error = NVMLReturn.fromInt(
                NVMLJWrapper.INSTANCE.nvmlDeviceSetDefaultAutoBoostedClocksEnabled(id, state.getValue(), flags));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
    }

    public void nvmlDeviceValidateInforom() throws NVMLJException {
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceValidateInforom(id));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
    }

    public void nvmlDeviceClearEccErrorCounts(NVMLEccCounterType countType) throws NVMLJException {
        NVMLReturn error = NVMLReturn
                .fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceClearEccErrorCounts(id, countType.getValue()));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
    }

    public void nvmlDeviceSetAPIRestriction(NVMLRestrictedApi api, NVMLEnableState enable) throws NVMLJException {
        NVMLReturn error = NVMLReturn
                .fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceSetAPIRestriction(id, api.getValue(), enable.getValue()));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
    }

    public void nvmlDeviceSetApplicationsClocks(int memClock, int graphicsClock) throws NVMLJException {
        NVMLReturn error = NVMLReturn
                .fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceSetApplicationsClocks(id, memClock, graphicsClock));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
    }

    public void nvmlDeviceSetComputeMode(NVMLComputeMode compMode) throws NVMLJException {
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceSetComputeMode(id, compMode.getValue()));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
    }

    public void nvmlDeviceSetDriverModel(NVMLDriverModel driverModel, int flags) throws NVMLJException {
        NVMLReturn error = NVMLReturn
                .fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceSetDriverModel(id, driverModel.getValue(), flags));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
    }

    public void nvmlDeviceSetEccMode(NVMLEnableState state) throws NVMLJException {
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceSetEccMode(id, state.getValue()));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
    }

    public void nvmlDeviceSetGpuOperationMode(NVMLGpuOperationMode state) throws NVMLJException {
        NVMLReturn error = NVMLReturn
                .fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceSetGpuOperationMode(id, state.getValue()));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
    }

    public void nvmlDeviceSetPersistenceMode(NVMLEnableState state) throws NVMLJException {
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceSetPersistenceMode(id, state.getValue()));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
    }

    public void nvmlDeviceSetPowerManagementLimit(int limit) throws NVMLJException {
        NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceSetPowerManagementLimit(id, limit));
        if (error != NVMLReturn.NVML_SUCCESS) {
            throw (new NVMLJException(error));
        }
    }
}
