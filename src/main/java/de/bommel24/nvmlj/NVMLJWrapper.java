package de.bommel24.nvmlj;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.ptr.IntByReference;

interface NVMLJWrapper extends Library {
	NVMLJWrapper INSTANCE = (NVMLJWrapper) Native.loadLibrary(NVMLPath.getPath(), NVMLJWrapper.class);

	int nvmlInit();

	int nvmlInitWithFlags(int initFlags);

	int nvmlShutdown();

	int nvmlSystemGetCudaDriverVersion(IntByReference cudaDriverVersion);

	int nvmlSystemGetDriverVersion(byte[] version, int length);

	int nvmlSystemGetNVMLVersion(byte[] version, int length);

	int nvmlSystemGetProcessName(int pid, byte[] name, int length);
}
