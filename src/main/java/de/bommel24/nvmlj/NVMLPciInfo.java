package de.bommel24.nvmlj;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Native;
import com.sun.jna.Structure;

public class NVMLPciInfo extends Structure {
	public byte[] busId = new byte[16];
	public int domain;
	public int bus;
	public int device;
	public int pciDeviceId;
	public int pciSubSystemId;
	public int reserved0;
	public int reserved1;
	public int reserved2;
	public int reserved3;

	@Override
	protected List<String> getFieldOrder() {
		return Arrays.asList("busId", "domain", "bus", "device", "pciDeviceId", "pciSubSystemId", "reserved0",
				"reserved1", "reserved2", "reserved3");
	}

	public static class ByReference extends NVMLPciInfo implements Structure.ByReference {
	};

	public static class ByValue extends NVMLPciInfo implements Structure.ByValue {
	};
	
	public String getBusId()
	{
		return Native.toString(busId);
	}
}
