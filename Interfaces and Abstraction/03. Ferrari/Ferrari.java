public class Ferrari implements Car{
    private String driverName;
    private static final String MODEL = "488-Spider";

    public Ferrari(String driverName){
        setDriverName(driverName);
    }

    public String getDriverName() {
        return driverName;
    }

    private void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String useBrakes() {
       return "Brakes!";

    }

    @Override
    public String pushGasPedal() {
       return "Zadu6avam sA!";
    }

    public String toString(){
        return String.format("%s/%s/%s/%s",MODEL,this.useBrakes(),this.pushGasPedal(),this.getDriverName());
    }
}
