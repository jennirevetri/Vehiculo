// Vehiculo.java
public class Vehiculo {
    private String ownerName;
    private String ownerLastname;
    private String ownerId;
    private String ownerPhone;
    private String ownerAddress;
    private String vehiclePlate;
    private String vehicleBrand;
    private String vehicleModel;
    private int vehicleYear;
    private String vehicleColor;
    private String vehiclePic;

    public Vehiculo(String ownerName, String ownerLastname, String ownerId, String ownerPhone, String ownerAddress, String vehiclePlate, String vehicleBrand, String vehicleModel, int vehicleYear, String vehicleColor, String vehiclePic) {
        this.ownerName = ownerName;
        this.ownerLastname = ownerLastname;
        this.ownerId = ownerId;
        this.ownerPhone = ownerPhone;
        this.ownerAddress = ownerAddress;
        this.vehiclePlate = vehiclePlate;
        this.vehicleBrand = vehicleBrand;
        this.vehicleModel = vehicleModel;
        this.vehicleYear = vehicleYear;
        this.vehicleColor = vehicleColor;
        this.vehiclePic = vehiclePic;
    }

    // Getters y Setters
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerLastname() {
        return ownerLastname;
    }

    public void setOwnerLastname(String ownerLastname) {
        this.ownerLastname = ownerLastname;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public int getVehicleYear() {
        return vehicleYear;
    }

    public void setVehicleYear(int vehicleYear) {
        this.vehicleYear = vehicleYear;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public String getVehiclePic() {
        return vehiclePic;
    }

    public void setVehiclePic(String vehiclePic) {
        this.vehiclePic = vehiclePic;
    }
}

