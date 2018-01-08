package de.bommel24.nvmlj;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;
import com.sun.jna.Union;

public class NVMLSample extends Structure {
	public long timeStamp;
	public SampleUnion sampleValue;

	@Override
	protected List<String> getFieldOrder() {
		return Arrays.asList("timeStamp", "sampleValue");
	}

	public static class ByReference extends NVMLSample implements Structure.ByReference {
	};

	public static class ByValue extends NVMLSample implements Structure.ByValue {
	};

	public static class SampleUnion extends Union {
		public static class ByValue extends SampleUnion implements Union.ByValue {
		};

		public double dVal;
		public int uiVal;
		public long ulVal;
		public long ullVal;
	}
}
