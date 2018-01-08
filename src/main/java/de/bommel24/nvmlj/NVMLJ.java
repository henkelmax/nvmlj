package de.bommel24.nvmlj;

import com.sun.jna.Native;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.LongByReference;

public class NVMLJ {

	public static void nvmlInit() throws NVMLJException {
		NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlInit());
		if (error != NVMLReturn.NVML_SUCCESS) {
			throw (new NVMLJException(error));
		}
	}

	public static void nvmlInitWithFlags(NVMLInitFlags initFlags) throws NVMLJException {
		NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlInitWithFlags(initFlags.getValue()));
		if (error != NVMLReturn.NVML_SUCCESS) {
			throw (new NVMLJException(error));
		}
	}

	public static void nvmlShutdown() throws NVMLJException {
		NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlShutdown());
		if (error != NVMLReturn.NVML_SUCCESS) {
			throw (new NVMLJException(error));
		}
	}

	public static int nvmlSystemGetCudaDriverVersion() throws NVMLJException {
		IntByReference cudaDriverVersion = new IntByReference();
		NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlSystemGetCudaDriverVersion(cudaDriverVersion));
		if (error != NVMLReturn.NVML_SUCCESS) {
			throw (new NVMLJException(error));
		}
		return cudaDriverVersion.getValue();
	}

	public static String nvmlSystemGetDriverVersion() throws NVMLJException {
		byte[] string = new byte[NVMLJConstants.NVML_SYSTEM_DRIVER_VERSION_BUFFER_SIZE];
		NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlSystemGetDriverVersion(string,
				NVMLJConstants.NVML_SYSTEM_DRIVER_VERSION_BUFFER_SIZE));
		if (error != NVMLReturn.NVML_SUCCESS) {
			throw (new NVMLJException(error));
		}
		return Native.toString(string);
	}

	public static String nvmlSystemGetNVMLVersion() throws NVMLJException {
		byte[] string = new byte[NVMLJConstants.NVML_SYSTEM_NVML_VERSION_BUFFER_SIZE];
		NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlSystemGetNVMLVersion(string,
				NVMLJConstants.NVML_SYSTEM_NVML_VERSION_BUFFER_SIZE));
		if (error != NVMLReturn.NVML_SUCCESS) {
			throw (new NVMLJException(error));
		}
		return Native.toString(string);
	}

	public static String nvmlSystemGetProcessName(int pid) throws NVMLJException {
		byte[] string = new byte[NVMLJConstants.NVML_MAX_STRING_SIZE];
		NVMLReturn error = NVMLReturn.fromInt(
				NVMLJWrapper.INSTANCE.nvmlSystemGetProcessName(pid, string, NVMLJConstants.NVML_MAX_STRING_SIZE));
		if (error != NVMLReturn.NVML_SUCCESS) {
			throw (new NVMLJException(error));
		}
		return Native.toString(string);
	}

	public static NVMLHwbcEntry[] nvmlSystemGetHicVersion() throws NVMLJException {
		int size = nvmlUnitGetCount();
		NVMLHwbcEntry s = new NVMLHwbcEntry();
		NVMLHwbcEntry[] array = (NVMLHwbcEntry[]) s.toArray(size);
		NVMLReturn error = NVMLReturn
				.fromInt(NVMLJWrapper.INSTANCE.nvmlSystemGetHicVersion(new IntByReference(size), array[0]));
		if (error != NVMLReturn.NVML_SUCCESS) {
			throw (new NVMLJException(error));
		}
		return array;
	}

	public static int nvmlUnitGetCount() throws NVMLJException {
		IntByReference inte = new IntByReference();
		NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlUnitGetCount(inte));
		if (error != NVMLReturn.NVML_SUCCESS) {
			throw (new NVMLJException(error));
		}
		return inte.getValue();
	}


	public static NVMLUnit nvmlUnitGetHandleByIndex(int index) throws NVMLJException {
		LongByReference s = new LongByReference();
		NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlUnitGetHandleByIndex(index, s));
		if (error != NVMLReturn.NVML_SUCCESS) {
			throw (new NVMLJException(error));
		}
		return new NVMLUnit(s.getValue());
	}

	public static int nvmlDeviceGetCount() throws NVMLJException {
		IntByReference inte = new IntByReference();
		NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetCount(inte));
		if (error != NVMLReturn.NVML_SUCCESS) {
			throw (new NVMLJException(error));
		}
		return inte.getValue();
	}

	public static NVMLDevice nvmlDeviceGetHandleByIndex(int index) throws NVMLJException {
		LongByReference s = new LongByReference();
		NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetHandleByIndex(index, s));
		if (error != NVMLReturn.NVML_SUCCESS) {
			throw (new NVMLJException(error));
		}
		return new NVMLDevice(s.getValue());
	}

	public static NVMLDevice nvmlDeviceGetHandleByPciBusId(String pciBusId) throws NVMLJException {
		LongByReference s = new LongByReference();
		NVMLReturn error = NVMLReturn
				.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetHandleByPciBusId(pciBusId.toCharArray(), s));
		if (error != NVMLReturn.NVML_SUCCESS) {
			throw (new NVMLJException(error));
		}
		return new NVMLDevice(s.getValue());
	}

	public static NVMLDevice nvmlDeviceGetHandleBySerial(String serial) throws NVMLJException {
		LongByReference s = new LongByReference();
		NVMLReturn error = NVMLReturn
				.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetHandleBySerial(serial.toCharArray(), s));
		if (error != NVMLReturn.NVML_SUCCESS) {
			throw (new NVMLJException(error));
		}
		return new NVMLDevice(s.getValue());
	}

	public static NVMLDevice nvmlDeviceGetHandleByUUID(String uuid) throws NVMLJException {
		LongByReference s = new LongByReference();
		NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlDeviceGetHandleByUUID(uuid.toCharArray(), s));
		if (error != NVMLReturn.NVML_SUCCESS) {
			throw (new NVMLJException(error));
		}
		return new NVMLDevice(s.getValue());
	}

	public static NVMLDevice[] nvmlSystemGetTopologyGpuSet(int cpu) throws NVMLJException {
		IntByReference s = new IntByReference();
		long[] longs = new long[NVMLJConstants.NVML_MAX_PAGES];
		NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlSystemGetTopologyGpuSet(cpu, s, longs));
		if (error != NVMLReturn.NVML_SUCCESS) {
			throw (new NVMLJException(error));
		}
		NVMLDevice[] array2 = new NVMLDevice[s.getValue()];
		for (int i = 0; i < array2.length; i++) {
			array2[i] = new NVMLDevice(longs[i]);
		}
		return array2;
	}

}
