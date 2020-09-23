# NVMLJ ![GitHub Workflow Status](https://img.shields.io/github/workflow/status/henkelmax/nvmlj/Build) ![GitHub issues](https://img.shields.io/github/issues-raw/henkelmax/nvmlj) ![GitHub release (latest by date)](https://img.shields.io/github/v/release/henkelmax/nvmlj?include_prereleases)

A Java wrapper for the [NVIDIA Management Library](https://developer.nvidia.com/nvidia-management-library-nvml).

## Usage

Maven (*pom.xml*)

``` xml
<dependency>
  <groupId>de.bommel24.nvmlj</groupId>
  <artifactId>nvmlj</artifactId>
  <version>1.0.1</version>
</dependency>
```

``` xml
<repository>
  <id>henkelmax.public</id>
  <url>https://maven.maxhenkel.de/repository/public</url>
</repository>
```

## Example

``` java
// The path to the nvml library (Defaults to C:/Program Files/NVIDIA Corporation/NVSMI/nvml.dll)
System.setProperty("nvml.path", "path/to/your/nvml.dll");
NVMLJ.nvmlInit();
System.out.println(NVMLJ.nvmlDeviceGetCount());
NVMLJ.nvmlShutdown();
```
