package de.bommel24.nvmlj;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

public class NVMLUnitFanInfo extends Structure {
	public int speed;
	public int state;
	
	@Override
	protected List<String> getFieldOrder() {
		return Arrays.asList("speed", "state");
	}

	public static class ByReference extends NVMLUnitFanInfo implements Structure.ByReference {
	};

	public static class ByValue extends NVMLUnitFanInfo implements Structure.ByValue {
	};
}
