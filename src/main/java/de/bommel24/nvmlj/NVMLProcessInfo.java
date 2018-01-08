package de.bommel24.nvmlj;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

public class NVMLProcessInfo extends Structure {
	public int pid;
	public long usedGpuMemory;

	@Override
	protected List<String> getFieldOrder() {
		return Arrays.asList("pid", "usedGpuMemory");
	}

	public static class ByReference extends NVMLProcessInfo implements Structure.ByReference {
	};

	public static class ByValue extends NVMLProcessInfo implements Structure.ByValue {
	};
}
