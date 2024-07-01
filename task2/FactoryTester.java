package finalexam.task2;

public class FactoryTester {
    public static void main(String[] args) {
        PaperFactory factory = new PaperFactory();
        Person p1 = new Person("John", "Doe", "123456789");
        Person p2 = new Person("Jane", "Doe", "987654321");
        factory.addPerson(p1);
        factory.addPerson(p2);

        System.out.println(factory.getStaff());

        factory.deletePerson(p1);

        System.out.println(factory.getStaff());
    }
}