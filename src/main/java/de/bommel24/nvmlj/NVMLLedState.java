package de.bommel24.nvmlj;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

public class NVMLLedState extends Structure {
	public byte[] cause=new byte[256];
	public int ledColor;
	
	@Override
	protected List<String> getFieldOrder() {
		return Arrays.asList("cause", "ledColor");
	}

	public static class ByReference extends NVMLLedState implements Structure.ByReference {
	};

	public static class ByValue extends NVMLLedState implements Structure.ByValue {
	};
}
