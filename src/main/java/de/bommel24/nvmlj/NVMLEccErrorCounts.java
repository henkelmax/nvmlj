package de.bommel24.nvmlj;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

public class NVMLEccErrorCounts extends Structure {

	public long l1Cache;
	public long l2Cache;
	public long deviceMemory;
	public long registerFile;	

	@Override
	protected List<String> getFieldOrder() {
		return Arrays.asList("l1Cache", "l2Cache", "deviceMemory", "registerFile");
	}

	public static class ByReference extends NVMLEccErrorCounts implements Structure.ByReference {
	};

	public static class ByValue extends NVMLEccErrorCounts implements Structure.ByValue {
	};
}
