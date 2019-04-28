
import java.util.*;

class AppCore {



    private final CSV_File file = new CSV_File();
    private final Scanner sc = new Scanner(System.in);
    //
    private int optionMenuStart;
    private boolean optionMenuTrue = true;
    //second method
    int caseNumber;
    private String fileName;
    private String csvFileName;

    //last Menu
    private int lastMenuOption;








    public int MenuStart() {

        System.out.println("Do you have a CSV file?\n");



        System.out.println("Please choose an option:\n" +
                "1.Yes\n" +
                "2.No\n" +
                "3.Learn how to use the app\n" +
                "0.Exit");
        do {
            try {
                Scanner scan = new Scanner(System.in);
                optionMenuStart = scan.nextInt();
                optionMenuTrue = false;
            } catch (Exception e) {
                System.out.println("You can only enter 1 or 2 , dont enter a string!!Try Again");
            }
        }while ( optionMenuTrue);

        return optionMenuStart;






    }


    public void  checkOptionMenuStart(){
        boolean value = true;




        switch (optionMenuStart){


            case 1:

                System.out.println("Please go into the CRUD_APP Folder\n" +
                        "and copy, paste your file there\n" +
                        "Now enter the name of your file:");

                  fileName =  sc.next() + ".csv";//number 1 ;

                do {
                  lastMenu();
                  checkOptionLastMenuExistedCsvFile();
                    System.out.println("We have Write the data into the csv File\n" +
                            "Choose an option:\n" +
                            "0.Exit\n" +
                            "5.Go Back");
                   do {
                       try {
                           Scanner scan = new Scanner(System.in);
                           lastMenuOption = scan.nextInt();
                           value =  false;
                       } catch (InputMismatchException e) {
                           System.out.println("Introduce a number");
                       }
                   }while (value);
                }while (lastMenuOption != 0);

                break;


            case 2:
                System.out.println("We will create a csv file for you,\n" +
                        "you will find it in the CRUD_APP Folder\n" +
                        "What name should it have?:\n" +
                        "Please enter a name:");
                 csvFileName =  sc.next() + ".csv";
                file.createCvsFile("Product Name", "Price","Quantity",csvFileName);

                    do {
                        lastMenu();
                        checkOptionLastMenuCreatedCsvFile();
                        System.out.println("We have Write the data into the csv File\n" +
                                "Choose an option:\n" +
                                "0.Exit\n" +
                                "5.Go Back");
                      do{
                          try {

                           lastMenuOption = sc.nextInt();
                           value = false;
                       }catch (InputMismatchException e){
                           System.out.println("Enter a number");
                       }
                      }while (value);


                    }while (lastMenuOption != 0);



                break;
            case 3:

                System.out.println("For option 1, you must put yout csv file in the CRUD_APP Folder\n" +
                        "then you need to type his name.\n" +
                        "For option 2 you just need to type what name should your file have;");

                break;
            case 0:
                System.exit(0);
                default:
                    System.out.println("something is not right");

        }






    }




    private int lastMenu(){

        System.out.println("Choose an option:\n" +
                "1.Add a new row to the csv File\n" +
                "2.Read a row from csv file\n" +
                "3.Update csv file\n" +
                "4.Delete record from  csv file\n" +
                "0.Exit" );
                 lastMenuOption = sc.nextInt();
                return lastMenuOption;
    }

    private void checkOptionLastMenuCreatedCsvFile(){

        switch (lastMenuOption){

            case 1:
                file.writeIntoA_CvsFile(csvFileName);


                break;
            case 2:
                file.readingFromACsvFile(csvFileName);
                break;
            case 3:
                file.editCsvFile(csvFileName);
                break;
            case 4:
                file.deleteRecordCsV_File(csvFileName);
                 break;
             default:
                     System.out.println("Something is not right");

        }

    }



    private void checkOptionLastMenuExistedCsvFile(){

        switch (lastMenuOption){

            case 1:

                file.writeIntoA_CvsFile(fileName);


                break;
            case 2:
                file.readingFromACsvFile(fileName);
                break;
            case 3:
                file.editCsvFile(fileName);
                break;
            case 4:
                file.deleteRecordCsV_File(fileName);
                break;
                default:
                    System.out.println("Something is not right!");



        }

    }





}













