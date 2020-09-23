package de.bommel24.nvmlj;

public class NVMLJException extends Exception {

    public NVMLJException(NVMLReturn error) {
        super(error.name());
    }

}
