public abstract class Vehicle {

    private int id;

    public Vehicle(){}

    public Vehicle(int id){
        this.id = id;
    }
    public void drive(){
        System.out.println("Drive!");
    }
}
