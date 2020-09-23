package de.bommel24.nvmlj;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

public class NVMLBAR1Memory extends Structure {

    public long bar1Total;
    public long bar1Free;
    public long bar1Used;

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("bar1Total", "bar1Free", "bar1Used");
    }

    public static class ByReference extends NVMLBAR1Memory implements Structure.ByReference {
    }

    public static class ByValue extends NVMLBAR1Memory implements Structure.ByValue {
    }
}
