package de.bommel24.nvmlj;


public class Test {

	public static void main(String[] args) throws NVMLJException {
		NVMLJ.nvmlInit();
		System.out.println(NVMLJ.nvmlSystemGetProcessName(3176));
	}

}
