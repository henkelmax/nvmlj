package de.bommel24.nvmlj;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

public class NVMLUtilization extends Structure {

    public int gpu;
    public int memory;

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("gpu", "memory");
    }

    public static class ByReference extends NVMLUtilization implements Structure.ByReference {
    }

    public static class ByValue extends NVMLUtilization implements Structure.ByValue {
    }
}
