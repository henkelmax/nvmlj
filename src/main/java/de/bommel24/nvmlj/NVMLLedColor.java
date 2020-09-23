package de.bommel24.nvmlj;

public enum NVMLLedColor {

    NVML_LED_COLOR_GREEN(0), NVML_LED_COLOR_AMBER(1);

    private final int i;

    NVMLLedColor(int i) {
        this.i = i;
    }

    public int getValue() {
        return i;
    }

    public static NVMLLedColor fromInt(int i) {
        for (NVMLLedColor ret : values()) {
            if (i == ret.i) {
                return ret;
            }
        }
        return NVML_LED_COLOR_GREEN;
    }
}
