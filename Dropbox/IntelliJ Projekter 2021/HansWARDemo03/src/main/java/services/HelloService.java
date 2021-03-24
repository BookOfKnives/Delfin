package services;

public class HelloService {

    public HelloService(){
        System.out.println("Nu kører helloservice");
        HelloWorldService();
    }
    public String HelloWorldService()
    {
       return "Hello world";
    }
}
