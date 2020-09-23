package de.bommel24.nvmlj;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

@Deprecated
public class NVMLEncoderSessionInfo extends Structure {

    public int test;
    public long test2;

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("test", "test2");
    }

    public static class ByReference extends NVMLEncoderSessionInfo implements Structure.ByReference {
    }

    public static class ByValue extends NVMLEncoderSessionInfo implements Structure.ByValue {
    }
}
