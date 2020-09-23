package de.bommel24.nvmlj;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

public class NVMLUnitInfo extends Structure {

    byte[] name = new byte[96];
    byte[] id = new byte[96];
    byte[] serial = new byte[96];
    byte[] firmwareVersion = new byte[96];

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("name", "id", "serial", "firmwareVersion");
    }

    public static class ByReference extends NVMLUnitInfo implements Structure.ByReference {
    }

    public static class ByValue extends NVMLUnitInfo implements Structure.ByValue {
    }
}
