public class Main {

  public static void main(String[] args) {
    /**
     *  Get java version for emoji support
     * */
    System.out.println("Java version: " + System.getProperty("java.version"));
    Integer version = Integer.parseInt(
      System.getProperty("java.version").split("\\.")[0]
    );
    System.out.println("You are using Java " + version);
    if (!(version >= 20)) {
      System.out.println(
        "You are using an outdated version of Java so Emojies will not be displayed correctly. Please update to 21 or later."
      );
    }
    Check check = new Check();
    check.getInformation();
  }
}
