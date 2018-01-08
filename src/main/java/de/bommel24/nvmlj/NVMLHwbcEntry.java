package de.bommel24.nvmlj;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

public class NVMLHwbcEntry extends Structure {

	public int hwbcId;
	public char[] firmwareVersion = new char[32];

	@Override
	protected List<String> getFieldOrder() {
		return Arrays.asList("hwbcId", "firmwareVersion");
	}

	public static class ByReference extends NVMLHwbcEntry implements Structure.ByReference {
	};

	public static class ByValue extends NVMLHwbcEntry implements Structure.ByValue {
	};
}
