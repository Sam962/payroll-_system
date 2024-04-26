import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Check {

  /**
   * Colors:
   */
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";
  public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
  public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
  public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
  public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

  public static void setBold(String text) {
    System.out.print("\033[0;1m" + text + "\033[0;0m");
  }

  public static void setUnderline(String text) {
    System.out.print("\033[0;4m" + text + "\033[0;0m");
  }

  public static void resetColor() {
    System.out.print("\033[0;0m");
  }

  public static void setColor(String color, String text) {
    System.out.print(color + text + ANSI_RESET);
  }

  public Employee newEmployee = new Employee();

  public Double pay = 0.0;

  public static String getName(Scanner input) {
    setColor(ANSI_RED, "Enter employee name: ");
    String name = input.nextLine();
    System.out.println();
    while (name.isEmpty()) {
      setBold(
        ANSI_RED_BACKGROUND +
        ANSI_YELLOW +
        "ERROR: Name cannot be empty" +
        ANSI_RESET +
        "\n"
      );
      setColor(ANSI_RED, "Enter employee name: ");
      name = input.nextLine();
    }
    return name;
  }

  public static String getAddress(Scanner input) {
    setColor(ANSI_RED, "Enter employee address: " + ANSI_RESET);
    String address = input.nextLine();
    System.out.println();
    while (address.isEmpty()) {
      setBold(
        ANSI_RED_BACKGROUND +
        ANSI_YELLOW +
        "ERROR: Address cannot be empty" +
        ANSI_RESET +
        "\n"
      );
      setColor(ANSI_RED, "Enter employee address: ");
      address = input.nextLine();
    }
    return address;
  }

  public static int getNumber(Scanner input) {
    setColor(ANSI_RED, "Enter employee number: ");
    String number = input.nextLine();
    System.out.println();

    while (!number.matches("[0-9]+")) {
      setBold(
        ANSI_RED_BACKGROUND +
        ANSI_YELLOW +
        "ERROR: Number must be a number" +
        ANSI_RESET +
        "\n"
      );
      setColor(ANSI_RED, "Enter employee number: ");
      number = input.nextLine();
    }

    return Integer.parseInt(number);
  }

  public static double getHours(Scanner input) {
    setColor(ANSI_RED, "Enter employee hours: ");
    String hours = input.nextLine();
    System.out.println();

    while (!hours.matches("[0-9]+")) {
      setBold(
        ANSI_RED_BACKGROUND +
        ANSI_YELLOW +
        "ERROR: Hours must be a number" +
        ANSI_RESET +
        "\n"
      );
      setColor(ANSI_RED, "Enter employee hours: ");
      hours = input.nextLine();
    }
    return Double.parseDouble(hours);
  }

  public static double getRate(Scanner input) {
    setColor(ANSI_RED, "Enter employee rate: (e.g. 10.00): " + ANSI_RESET);
    String rate = input.nextLine();
    System.out.println();

    while (!rate.matches("[0-9]+(\\.[0-9]+)?")) {
      setBold(
        ANSI_RED_BACKGROUND +
        ANSI_YELLOW +
        "ERROR: Rate must be a number" +
        ANSI_RESET +
        "\n"
      );
      System.out.print("\n");
      setColor(ANSI_RED, "Enter employee rate: ");
      rate = input.nextLine();
    }
    return Double.parseDouble(rate);
  }

  public static double getOvertime(Scanner input) {
    setColor(ANSI_RED, "Enter employee overtime: ");
    String overtime = input.nextLine();
    System.out.println();

    while (!overtime.matches("[0-9]+")) {
      setBold(
        ANSI_RED_BACKGROUND +
        ANSI_YELLOW +
        "ERROR: Overtime must be a number" +
        ANSI_RESET +
        "\n"
      );
      setColor(ANSI_RED, "Enter employee overtime: ");
      overtime = input.nextLine();
    }
    return Double.parseDouble(overtime);
  }

  public String getDate() {
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    return formatter.format(date);
  }

  public void getInformation() {
    Scanner input = new Scanner(System.in);

    try {
      System.out.println(
        ANSI_RED_BACKGROUND +
        ANSI_YELLOW +
        "👨‍💼 Paycheck Management System 👨‍💼" +
        ANSI_BLACK_BACKGROUND +
        ANSI_RESET
      );
      String name = getName(input);
      String address = getAddress(input);
      int number = getNumber(input);
      double hours = getHours(input);
      double rate = getRate(input);

      newEmployee = new Employee(name, address, number, hours, rate);
      pay = newEmployee.calculateWeeklyPay();
    } catch (Exception e) {
      setBold(
        ANSI_RED_BACKGROUND +
        ANSI_YELLOW +
        "ERROR: Something went wrong. Please try again." +
        ANSI_RESET +
        "\n"
      );
    } finally {
      input.close();
    }
    Check payCheck = new Check();
    payCheck.PrintCheck(newEmployee);
  }

  public void PrintCheck(Employee newEmployee) {
    /**
     * Get the information from the employee
     */
    String name = newEmployee.getName();
    String address = newEmployee.getAddress();
    int number = newEmployee.getNumber();
    double pay = newEmployee.calculateWeeklyPay();
    double rate = newEmployee.getRate();
    double overtime = newEmployee.getOvertime();
    double netPay = pay * 0.95 * 0.85 * 0.938;
    System.out.println("\n\n\n");
    /**
     * Breakdown of the check
     */

    // Colorify the output
    System.out.println("\033[0;32m");
    setBold(
      ANSI_GREEN_BACKGROUND + ANSI_PURPLE + "👨‍💼 Paycheck Management System 👨‍💼"
    );
    // BACKGROUND WHITE
    System.out.println(ANSI_WHITE_BACKGROUND + ANSI_RED);
    System.out.println(
      ANSI_WHITE_BACKGROUND + ANSI_RED + "🏘️ Address: " + ANSI_YELLOW + address
    );
    System.out.println(
      ANSI_WHITE_BACKGROUND + ANSI_RED + "💸 Pay rate: $" + ANSI_YELLOW + rate
    );
    System.out.println(
      ANSI_RED +
      "🏛️ State Tax withholding (9.5%): $" +
      ANSI_YELLOW +
      pay *
      0.095
    );
    System.out.println(
      ANSI_RED +
      "🏦 Federal Tax withholding (15%): $" +
      ANSI_YELLOW +
      pay *
      0.15
    );
    System.out.println(
      ANSI_RED +
      "👴 Social Security withholding (6.2%): $" +
      ANSI_YELLOW +
      pay *
      0.062
    );
    System.out.println(
      ANSI_RED +
      "🏥 Medicare withholding (1.45%): $" +
      ANSI_YELLOW +
      pay *
      0.0145
    );
    System.out.println(
      ANSI_RED + "⏱️ Overtime at 1.5x: $" + ANSI_YELLOW + overtime * rate * 1.5
    );
    System.out.println(ANSI_RED + "💵 Net Pay: $" + ANSI_YELLOW + netPay);
    setBold(ANSI_GREEN_BACKGROUND + ANSI_PURPLE + "🏦PNC BANK  🏦");
    // BACKGROUND WHITE
    System.out.println(ANSI_WHITE_BACKGROUND + ANSI_RED);
    System.out.println(ANSI_WHITE_BACKGROUND + ANSI_RED);
    System.out.println("________________________________________________");
    System.out.println(
      ANSI_PURPLE + "🖋️ Signature:" + ANSI_YELLOW + " Sam .A. Aldahayat, CEO"
    );
    System.out.println(ANSI_RED + "📝 Memo: Payroll");
    System.out.println("🏢 Company: " + ANSI_YELLOW + " Sam's Software");
    System.out.println(
      "📍 Address: " + ANSI_YELLOW + "  1234 Main St, Pittsburgh, PA 15213"
    );
    System.out.println(
      ANSI_RED +
      "🔢 Check Number: " +
      ANSI_YELLOW +
      (int) (Math.random() * 1000000)
    );
    System.out.println(
      ANSI_RED + "🔀 Routing Number:" + ANSI_YELLOW + "1234567"
    );
    System.out.println(
      ANSI_RED + "🔢 Account Number: " + ANSI_YELLOW + "12332133"
    );
    System.out.println(
      ANSI_RED + "📅 Date of Check: " + ANSI_YELLOW + getDate()
    );
    System.out.println(
      ANSI_RED + "💵 Pay to the order of " + ANSI_YELLOW + name + " the sum of"
    );
    System.out.println(ANSI_RED + "👤 For: " + ANSI_YELLOW + name);
    System.out.println(ANSI_RED + "🏠 Address: " + ANSI_YELLOW + address);
    System.out.println(ANSI_RED + " Employee Number: " + ANSI_YELLOW + number);
    System.out.println(ANSI_GREEN + "🔢 Amount: $" + ANSI_YELLOW + pay);
    System.out.println(
      ANSI_RED +
      "✒️🖊️ By signing below, you agree to accept this amount as payment in full for all services rendered."
    );
    System.out.println(
      ANSI_PURPLE +
      "Signature:" +
      ANSI_YELLOW +
      "________________________________________________ \n"
    );
  }
}
