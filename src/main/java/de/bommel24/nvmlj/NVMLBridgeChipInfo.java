package de.bommel24.nvmlj;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

public class NVMLBridgeChipInfo extends Structure {

    public int fwVersion;
    public int type;

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("fwVersion", "type");
    }

    public static class ByReference extends NVMLBridgeChipInfo implements Structure.ByReference {
    }

    public static class ByValue extends NVMLBridgeChipInfo implements Structure.ByValue {
    }
}
