package utils;

public class Form {
    String numberOfInstances;
    String operationSystem;
    String vmClass;
    String instanceType;
    String numberOfGPUs;
    String gpuType;
    String localSSD;
    String committedUsage;
    String datacenterLocation;

    public Form() {
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    public String getVmClass() {
        return vmClass;
    }

    public void setVmClass(String vmClass) {
        this.vmClass = vmClass;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public void setNumberOfGPUs(String numberOfGPUs) {
        this.numberOfGPUs = numberOfGPUs;
    }

    public String getGpuType() {
        return gpuType;
    }

    public void setGpuType(String gpuType) {
        this.gpuType = gpuType;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public void setDatacenterLocation(String datacenterLocation) {
        this.datacenterLocation = datacenterLocation;
    }

    public void showForm()
    {
        System.out.println("numberOfInstances: " + numberOfInstances +"\n"+
                "operationSystem: " + operationSystem +"\n"+
                "vmClass: " + vmClass +"\n"+
                "instanceType: " + instanceType +"\n"+
                "numberOfGPUs: " + numberOfGPUs +"\n"+
                "gpuType: " + gpuType +"\n"+
                "localSSD: " + localSSD +"\n"+
                "committedUsage: " + committedUsage +"\n"+
                "datacenterLocation: " + datacenterLocation);
    }
}
