package de.bommel24.nvmlj;

import com.sun.jna.ptr.IntByReference;

public class NVMLUnit {

	long id;

	public NVMLUnit(long id) {
		this.id = id;
	}

	public NVMLDevice[] nvmlUnitGetDevices() throws NVMLJException {
		IntByReference intby = new IntByReference(512);
		long[] longs = new long[intby.getValue()];
		NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlUnitGetDevices(id, intby, longs));
		if (error != NVMLReturn.NVML_SUCCESS) {
			throw (new NVMLJException(error));
		}
		NVMLDevice[] array2 = new NVMLDevice[intby.getValue()];
		for (int i = 0; i < array2.length; i++) {
			array2[i] = new NVMLDevice(longs[i]);
		}
		return array2;
	}

	public NVMLUnitFanSpeeds nvmlUnitGetFanSpeedInfo() throws NVMLJException {
		NVMLUnitFanSpeeds.ByReference s = new NVMLUnitFanSpeeds.ByReference();
		NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlUnitGetFanSpeedInfo(id, s));
		if (error != NVMLReturn.NVML_SUCCESS) {
			throw (new NVMLJException(error));
		}
		return s;
	}

	public NVMLLedState nvmlUnitGetLedState() throws NVMLJException {
		NVMLLedState.ByReference s = new NVMLLedState.ByReference();
		NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlUnitGetLedState(id, s));
		if (error != NVMLReturn.NVML_SUCCESS) {
			throw (new NVMLJException(error));
		}
		return s;
	}

	public NVMLPsuInfo nvmlUnitGetPsuInfo() throws NVMLJException {
		NVMLPsuInfo.ByReference s = new NVMLPsuInfo.ByReference();
		NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlUnitGetPsuInfo(id, s));
		if (error != NVMLReturn.NVML_SUCCESS) {
			throw (new NVMLJException(error));
		}
		return s;
	}

	public int nvmlUnitGetTemperature(NVMLUnitTempTypes tempType) throws NVMLJException {
		IntByReference s = new IntByReference();
		NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlUnitGetTemperature(id, tempType.getValue(), s));
		if (error != NVMLReturn.NVML_SUCCESS) {
			throw (new NVMLJException(error));
		}
		return s.getValue();
	}

	public NVMLUnitInfo nvmlUnitGetUnitInfo() throws NVMLJException {
		NVMLUnitInfo.ByReference s = new NVMLUnitInfo.ByReference();
		NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlUnitGetUnitInfo(id, s));
		if (error != NVMLReturn.NVML_SUCCESS) {
			throw (new NVMLJException(error));
		}
		return s;
	}

	public void nvmlUnitSetLedState(NVMLLedColor color) throws NVMLJException {
		NVMLReturn error = NVMLReturn.fromInt(NVMLJWrapper.INSTANCE.nvmlUnitSetLedState(id, color.getValue()));
		if (error != NVMLReturn.NVML_SUCCESS) {
			throw (new NVMLJException(error));
		}
	}

}
