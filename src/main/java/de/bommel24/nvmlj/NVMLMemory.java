package de.bommel24.nvmlj;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

public class NVMLMemory extends Structure {

    public long total;
    public long free;
    public long used;

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("total", "free", "used");
    }

    public static class ByReference extends NVMLMemory implements Structure.ByReference {
    }

    public static class ByValue extends NVMLMemory implements Structure.ByValue {
    }
}
