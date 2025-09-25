import java.io.*;

public class PartB_SerializationDemo {
    public static void main(String[] args) {
        String filename = "student.ser";

        // Serialization
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            Student s1 = new Student(101, "Alice", "A");
            oos.writeObject(s1);
            System.out.println("Student object serialized and saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialization
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Student deserializedStudent = (Student) ois.readObject();
            System.out.println("\nDeserialized Student details:");
            deserializedStudent.display();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
