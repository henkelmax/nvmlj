package de.bommel24.nvmlj;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

public class NVMLBridgeChipHierarchy extends Structure {

	public NVMLBridgeChipInfo[]	bridgeChipInfo = new NVMLBridgeChipInfo[NVMLJConstants.NVML_MAX_PHYSICAL_BRIDGE];
	public byte bridgeCount;

	@Override
	protected List<String> getFieldOrder() {
		return Arrays.asList("bridgeChipInfo", "bridgeCount");
	}

	public static class ByReference extends NVMLBridgeChipHierarchy implements Structure.ByReference {
	};

	public static class ByValue extends NVMLBridgeChipHierarchy implements Structure.ByValue {
	};
}
