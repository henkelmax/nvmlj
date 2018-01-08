package de.bommel24.nvmlj;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

public class NVMLUnitFanSpeeds extends Structure {
	public int  count;
	public NVMLUnitFanInfo[] fans=new NVMLUnitFanInfo[24];
	
	@Override
	protected List<String> getFieldOrder() {
		return Arrays.asList("count", "fans");
	}

	public static class ByReference extends NVMLUnitFanSpeeds implements Structure.ByReference {
	};

	public static class ByValue extends NVMLUnitFanSpeeds implements Structure.ByValue {
	};
}
