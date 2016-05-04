package codeDesign.builder;


public class Client {
    public static void main(String[] args) {
        DoDoContact ddc = new DoDoContact.Builder()
                .setAge(10)
                .setAddress("beijing")
                .setName("Jack").build();

        System.out.println("name=" + ddc.getName() + " age =" + ddc.getAge() + " address=" + ddc.getAddress());
    }
}
