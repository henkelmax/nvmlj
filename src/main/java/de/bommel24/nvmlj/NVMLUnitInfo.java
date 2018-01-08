package de.bommel24.nvmlj;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

public class NVMLUnitInfo extends Structure {
	byte[] name = new byte[96]; // !< Product name
	byte[] id = new byte[96]; // !< Product identifier
	byte[] serial = new byte[96]; // !< Product serial number
	byte[] firmwareVersion = new byte[96]; // !< Firmware version

	@Override
	protected List<String> getFieldOrder() {
		return Arrays.asList("name", "id", "serial", "firmwareVersion");
	}

	public static class ByReference extends NVMLUnitInfo implements Structure.ByReference {
	};

	public static class ByValue extends NVMLUnitInfo implements Structure.ByValue {
	};
}
