package de.bommel24.nvmlj;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

public class NVMLPsuInfo extends Structure {
	public byte[] state=new byte[256];
	public int current;
	public int voltage;
	public int power;
	
	@Override
	protected List<String> getFieldOrder() {
		return Arrays.asList("state", "current", "voltage", "power");
	}

	public static class ByReference extends NVMLPsuInfo implements Structure.ByReference {
	};

	public static class ByValue extends NVMLPsuInfo implements Structure.ByValue {
	};
}
