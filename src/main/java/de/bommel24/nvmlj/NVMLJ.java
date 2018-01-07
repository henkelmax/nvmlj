package de.bommel24.nvmlj;

import com.sun.jna.Native;
import com.sun.jna.ptr.IntByReference;

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
}
