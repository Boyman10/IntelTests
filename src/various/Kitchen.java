package various;

enum Kitchen {

    GROUND ("."),
    DISH ("D"),
    WINDOW ("W"),
    BLUE ("B"),
    ICE ("I");

    private String name = "";

    //Constructeur
    Kitchen(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }

}