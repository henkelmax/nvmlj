package de.bommel24.nvmlj;

public enum NVMLPageRetirementCause {

    NVML_PAGE_RETIREMENT_CAUSE_MULTIPLE_SINGLE_BIT_ECC_ERRORS(0), NVML_PAGE_RETIREMENT_CAUSE_DOUBLE_BIT_ECC_ERROR(1);

    private final int i;

    NVMLPageRetirementCause(int i) {
        this.i = i;
    }

    public int getValue() {
        return i;
    }

    public static NVMLPageRetirementCause fromInt(int i) {
        for (NVMLPageRetirementCause ret : values()) {
            if (i == ret.i) {
                return ret;
            }
        }
        return NVML_PAGE_RETIREMENT_CAUSE_MULTIPLE_SINGLE_BIT_ECC_ERRORS;
    }
}
