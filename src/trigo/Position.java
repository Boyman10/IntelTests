package trigo;


/**
 * Entity Class for position of item
 */
class Position {

    private int id;
    private String name;
    private String address;
    private String phone;
    private double longPos;
    private double latPos;

    public double getLongPos() {
        return longPos;
    }

    public void setLongPos(double longPos) {
        this.longPos = longPos;
    }

    public double getLatPos() {
        return latPos;
    }

    public void setLatPos(double latPos) {
        this.latPos = latPos;
    }

    public Position(String allData) {
        String[] data;
        allData = allData.replace(',', '.');
        data = allData.split(";");

        try {
            this.id = Integer.parseInt(data[0]);
            this.name = data[1];
            this.address = data[2];
            this.phone = data[3];
            this.longPos = Float.parseFloat(data[4]);
            this.latPos = Float.parseFloat(data[5]);

        } catch (Exception e) {
            System.err.println(e.getMessage() + "Size : " + data.length + " long : " + this.longPos + " lat : " + this.latPos);
        }
    }


}