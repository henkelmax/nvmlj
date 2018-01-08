package de.bommel24.nvmlj;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

public class NVMLViolationTime extends Structure {
	public long referenceTime;
	public long violationTime;
	
	@Override
	protected List<String> getFieldOrder() {
		return Arrays.asList("referenceTime", "violationTime");
	}

	public static class ByReference extends NVMLViolationTime implements Structure.ByReference {
	};

	public static class ByValue extends NVMLViolationTime implements Structure.ByValue {
	};
}
