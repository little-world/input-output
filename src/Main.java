
/*


variabelen naming
++ --
ternair

break continue
labels


 */


import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) throws InterruptedException {

    // File file = new File("text.txt");

    write();

    Thread.sleep(1000);

    read();


  }

  private static void write() {



    List<User> users = new ArrayList<>();
    users.add(new User("piet", "geheim"));
    users.add(new User("jan", "secret"));
    users.add(new User("xxx", "yyy"));

    final Path path = Path.of("text.txt");

    try (
       FileOutputStream fos = new FileOutputStream(path.toFile())) {


       ObjectOutputStream oos = new ObjectOutputStream(fos);


       oos.writeObject(users);



    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }


  static void read() {
    final Path path = Path.of("text.txt");
    try (
       FileInputStream fis = new FileInputStream(path.toFile())) {

       ObjectInputStream ois = new ObjectInputStream(fis);

      List<User> result = (List<User>) ois.readObject();

      System.out.println(result);


    }
    catch (IOException e) {
      throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}
