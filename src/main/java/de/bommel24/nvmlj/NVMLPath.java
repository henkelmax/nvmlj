package de.bommel24.nvmlj;

import java.io.File;

class NVMLPath {

    static String getPath() {
        String home = System.getProperty("nvml.path", "C:\\Program Files\\NVIDIA Corporation\\NVSMI\\nvml.dll");
        return new File(home).getAbsolutePath();
    }

}
