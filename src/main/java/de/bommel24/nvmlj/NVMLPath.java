package de.bommel24.nvmlj;

import java.io.File;

class NVMLPath {

    static String getPath(){
        String home=System.getProperty("nvml.home", "C:\\Program Files\\NVIDIA Corporation\\NVSMI\\");
        File folder=new File(home);
        return new File(folder, "nvml.dll").getAbsolutePath();
    }

}
