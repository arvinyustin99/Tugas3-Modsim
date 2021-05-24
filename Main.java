public class Main {
  public static void main(String[] args) {
    Model model = new Model(100, 100.0, 3600);
    model.Await();

    System.exit(0);
  }
}