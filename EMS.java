
/******************** Importing Essential Libraries ************************/

import java.util.*;
import java.io.*;

/*************************** MENU OF EMS ****************************/

class MainMenu {
  public void menu() {
    String str = "\n\t\t\t   **************************************************************************************\n\t\t\t\t\t\t\t  EMPLOYEE MANAGEMENT SYSTEM\n\t\t\t   **************************************************************************************\n\t\t\t\t\t\t\t\n\nPress 1 : To Add an Employee Details\nPress 2 : To See an Employee Details\nPress 3 : To Remove an Employee\nPress 4 : To Update Employee Details\nPress 5 : To Exit the EMS Portal";

    char currChar;
    for (int i = 0; i < str.length(); i++) {
      currChar = str.charAt(i);
      System.out.print(currChar);
      for (double j = 0; j < 50000; j += 0.1)
        ;
    }

  }
}

/************************ To add details of an Employee *********************/

class Employee_Add {
  public void createFile() {
    Scanner sc = new Scanner(System.in);

    EmployeeDetail emp = new EmployeeDetail();
    // Get information from user
    emp.getInfo();

    try {
      File file1 = new File("EmployeeData");
      file1.mkdir();
    } catch (Exception e) {
      System.out.println(e);
    }

    try {
      File f1 = new File("C:/Users/Hp/OneDrive/Desktop/Programs/Programs1/EmployeeData/file" + emp.employ_id + ".txt");
      if (f1.createNewFile()) {
        FileWriter myWriter = new FileWriter(
            "C:/Users/Hp/OneDrive/Desktop/Programs/Programs1/EmployeeData/file" + emp.employ_id + ".txt");
        myWriter.write("Employee ID: " + emp.employ_id + "\n" + "Employee Name     : " + emp.name + "\n" +
            "Father's Name     : " + emp.father_name + "\n" + "Employee Contact  : " + emp.employ_contact + "\n" +
            "Email Information : " + emp.email + "\n" + "Employee position : " + emp.position + "\n" +
            "Employee Salary   : " + emp.employ_salary);
        myWriter.close();
        System.out.println("\nEmployee has been Added :)\n");

        System.out.print("\nPress Enter to Continue...");
        sc.nextLine();
      } else {
        System.out.println("\nEmployee already exists :(");
        System.out.print("\nPress Enter to Continue...");
        sc.nextLine();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}

/************************* Taking Employee Details ************************/

class EmployeeDetail {
  String name;
  String father_name;
  String email;
  String position;
  String employ_id;
  String employ_salary;
  String employ_contact;

  public void getInfo() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter Employee's name --------: ");
    name = sc.nextLine();
    System.out.print("Enter Employee's Father name -: ");
    father_name = sc.nextLine();
    System.out.print("Enter Employee's ID ----------: ");
    employ_id = sc.nextLine();
    System.out.print("Enter Employee's Email ID ----: ");
    email = sc.nextLine();
    System.out.print("Enter Employee's Position ----: ");
    position = sc.nextLine();
    System.out.print("Enter Employee contact Info --: ");
    employ_contact = sc.nextLine();
    System.out.print("Enter Employee's Salary ------: ");
    employ_salary = sc.nextLine();
  }
}

/************************ To show details of an Employee *********************/

class Employee_Show {
  public void viewFile(String s) throws FileNotFoundException {

    File file = new File("C:/Users/Hp/OneDrive/Desktop/Programs/Programs1/EmployeeData/file"
        + s + ".txt");
    if (file.exists()) {
      Scanner sc = new Scanner(file);

      while (sc.hasNextLine()) {
        System.out.println(sc.nextLine());
      }
    } else {
      System.out.println("Sorry! Employee " + s + " data not found");
    }
  }

}

/***************************** To remove an employee *************************/

class Employee_Remove {
  public void removeFile(String ID) {

    File file = new File("C:/Users/Hp/OneDrive/Desktop/Programs/Programs1/EmployeeData/file" + ID + ".txt");
    if (file.exists()) {
      if (file.delete()) {
        System.out.println("\nEmployee has been removed Successfully");
      }
    } else {
      System.out.println("\nEmployee does not exists :( ");
    }
  }
}

/************************ To Update details of Employee ********************/

class Employee_Update {
  public void updateFile(String s) throws IOException {
    File file = new File("C:/Users/Hp/OneDrive/Desktop/Programs/Programs1/EmployeeData/file" + s + ".txt");

    System.out.println("After editing the file press ctrl+s key and then press alt+f4 key");
    for (double i = 0; i < 80000000; i += 0.1)
      ;
    ProcessBuilder pb = new ProcessBuilder("Notepad.exe", file.toString());
    pb.start();

  }

}

/************************ To Exit from the EMS Portal *********************/

class CodeExit {
  public void out() {
    System.out.println("\n*****************************************");
    System.out.println("$  Thank You For Using my Software :) ");
    System.out.println("*****************************************");
    System.out.println("\t\t/~  By Mohammad Adnan\n");
    System.exit(0);
  }
}

/************************ To clear output screen *********************/

class clearScr {
  public void cleared() {

    try {
      new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

    } catch (Exception e) {
      System.out.println(e);
    }

  }
}

/************************ For EMS Portal login *********************/

class EMSLoginPage {
  public static int attempt = 3;

  public void login() {

    Scanner sc = new Scanner(System.in);

    System.out.println("\n\n\n\n");
    for (int i = 0; i < 20; i++) {
      System.out.print("*");
    }

    System.out.println();
    System.out.println("|  Enter ID: " + "\t   |\t\t\t\t\t\t\t\t\t\t\t\t\t     Hint:admin");

    for (int i = 0; i < 20; i++) {
      System.out.print("*");
    }
    System.out.println();
    String id = sc.nextLine();
    System.out.println();
    for (int i = 0; i < 20; i++) {
      System.out.print("*");
    }

    System.out.println();
    System.out.println("| Enter Password:  |\t\t\t\t\t\t\t\t\t\t\t\t\t     Hint:password");

    for (int i = 0; i < 20; i++) {
      System.out.print("*");
    }
    System.out.println();
    String password = sc.nextLine();
    clearScr cs = new clearScr();

    if (id.equals("admin") && password.equals("password")) {
      cs.cleared();
      return;
    }

    else {
      cs.cleared();
      if (attempt > 1) {
        System.out.println("Incorrect Password\nTry again");
        attempt--;
        System.out.println("Attempts Left: " + attempt);
        login();
      } else {
        System.out.println("Try after some time");
        System.exit(0);
      }
    }
  }

}

/***************************** Main Class *******************************/
class EMS {

  public static void main(String args[]) {
    System.out.println("\n\n\n\n");
    System.out.println("\t\t\t\t\t******************WELLCOME TO****************");
    System.out.println("\t\t\t\t\t\t  EMPLOYEE MANAGEMENT SYSTEM");
    System.out.println("\t\t\t\t\t*******************************************");
    System.out.println("\t\t\t\t\t\t    --------------------");
    System.out.println("\t\t\t\t\t\t     ~By Mohammad Adnan");
    System.out.println("\t\t\t\t\t\t    --------------------");
    for (double i = 0; i < 50000000; i += 0.1)
      ;

    /** To clear the output Screen **/
    clearScr cs = new clearScr();
    cs.cleared();

    Scanner sc = new Scanner(System.in);
    EMSLoginPage log_in = new EMSLoginPage();
    Employee_Show epv = new Employee_Show();

    log_in.login();

    /*** Calling Main Menu Class function ****/
    MainMenu obj1 = new MainMenu();
    obj1.menu();
    int i = 0;

    /*** Initialising loop for Menu Choices ***/
    while (i < 6) {

      System.out.print("\nPlease Enter choice :");
      try {
        i = Integer.parseInt(sc.nextLine());

        if (i < 6 && i > 0) {
          /** Switch Case Statements **/
          switch (i) {
            case 1: {
              /** Creating class's object and calling Function using that object **/

              Employee_Add ep = new Employee_Add();
              ep.createFile();

              cs.cleared();
              obj1.menu();
              break;
            }
            case 2: {
              System.out.print("\nPlease Enter Employee's ID :");
              String s = sc.nextLine();
              try {
                epv.viewFile(s);
              } catch (Exception e) {
                System.out.println("Employee does not exists :( ");
              }

              System.out.print("\nPress Enter to Continue...");
              sc.nextLine();
              cs.cleared();
              obj1.menu();
              break;
            }

            case 3: {
              System.out.print("\nPlease Enter Employee's ID :");
              String s = sc.nextLine();
              Employee_Remove epr = new Employee_Remove();
              epr.removeFile(s);

              System.out.print("\nPress Enter to Continue...");
              sc.nextLine();
              cs.cleared();
              obj1.menu();
              break;
            }
            case 4: {
              System.out.print("\nPlease Enter Employee's ID :");
              String I = sc.nextLine();

              File file = new File("C:/Users/Hp/OneDrive/Desktop/Programs/Programs1/EmployeeData/file" + I + ".txt");

              if (file.exists()) {
                Employee_Update epu = new Employee_Update();
                try {
                  epu.updateFile(I);
                  System.out.print("\nPress Enter to Continue...");
                  sc.nextLine();
                  cs.cleared();
                  obj1.menu();
                  break;
                } catch (IOException e) {
                  System.out.println("Info isn't updated, try again");
                }
              }

              else {
                System.out.println("Employee does not exists :( ");
                System.out.print("\nPress Enter to Continue...");
                sc.nextLine();
                cs.cleared();
                obj1.menu();
                break;
              }
            }
            case 5: {
              CodeExit obj = new CodeExit();
              obj.out();
            }
          }
        } else {
          cs.cleared();
          System.out.println("Please enter an option between 1 to 5");
          for (double k = 0; k < 50000000; k = k + 0.1)
            ;
          cs.cleared();
          main(args);
        }
      } catch (Exception e) {
        System.out.println("Please enter an Integer value");
      }
    }
  }
}