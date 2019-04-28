import java.io.*;
import java.util.Scanner;

class CSV_File {

    private String productName;
    private String price;
    private String quantity;
    private String deleteRecord;


    public void createCvsFile(String productName, String price, String quantity, String filePath) {

        try {


            FileOutputStream file = new FileOutputStream(filePath, true);
            PrintWriter pw = new PrintWriter(file);
            pw.println(productName + "," + price + "," + quantity);

            pw.close();


        } catch (Exception E) {

        }


    }

    public void writeIntoA_CvsFile(String filePath) {


        try {
            Scanner scan = new Scanner(System.in);

            FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bf = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bf);

            System.out.println("Introduce the new value for the table:\n");
            System.out.println("ProductName");
            productName = scan.nextLine();
            System.out.println("Price");
            price = scan.nextLine();
            System.out.println("Quantity");
            quantity = scan.nextLine();

            pw.println(productName + "," + price + "," + quantity);

            pw.close();


        } catch (Exception E) {

        }


    }

    public void editCsvFile(String filePath) {

        String editTerm;
        String newProduct;
        String newPrice;
        String newQuantity;


        System.out.println("Please intorduce:\n" +
                "the name of the product you are trying to update:");
        Scanner scan = new Scanner(System.in);
        editTerm = scan.next();
        System.out.println("Introduce the new name of the product:");
        newProduct = scan.next();
        System.out.println("introduce the new price");
        newPrice = scan.next();
        System.out.println("Introduce the new Quantity");
        newQuantity = scan.next();


        String tempFile = "temp.csv";
        File oldFile = new File(filePath);
        File newFile = new File(tempFile);

        String product = "";
        String price = "";
        String quantity = "";

        try {
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bf = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bf);

            scan = new Scanner(new File(filePath));
            scan.useDelimiter("[,\n]");

            while (scan.hasNext()) {


                product = scan.next();
                price = scan.next();
                quantity = scan.next();

                if (product.equals(editTerm)) {


                    pw.append(newProduct + "," + newPrice + "," + newQuantity);
                    pw.append("\n");
                } else {
                    pw.append(product + "," + price + "," + quantity);
                    pw.append("\n");

                }


            }


            scan.close();
            pw.flush();
            pw.close();
            //noinspection ResultOfMethodCallIgnored
            oldFile.delete();

            File dump = new File(filePath);
            //noinspection ResultOfMethodCallIgnored,ResultOfMethodCallIgnored
            newFile.renameTo(dump);


        } catch (Exception e) {
        }


    }


    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void deleteRecordCsV_File(String filePath) {


        System.out.println("Please enter the product name from the row you want to delete:");
        Scanner sc = new Scanner(System.in);
        deleteRecord = sc.next();


        String tempFile = "temp.csv";
        File oldFile = new File(filePath);
        File newFile = new File(tempFile);

        String name = "";
        String priceP = "";
        String quan = "";


        try {
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            sc = new Scanner(new File(filePath));
            sc.useDelimiter("[,\n]");
            while (sc.hasNext()) {


                name = sc.next();
                priceP = sc.next();
                quan = sc.next();
                if (!name.equals(deleteRecord)) {

                    pw.append(name + "," + priceP + "," + quan);
                    pw.append("\n");
                }
            }


            sc.close();
            pw.flush();
            pw.close();

            //noinspection ResultOfMethodCallIgnored
            oldFile.delete();

            File dump = new File(filePath);
            //noinspection ResultOfMethodCallIgnored
            newFile.renameTo(dump);


        } catch (Exception e) {
            System.out.println("Something is not right");

        }


    }


    public void readingFromACsvFile(String filePath) {
        System.out.println("Please enter the product you are searching for:");
        Scanner sc = new Scanner(System.in);
        String searchTerm = sc.next();
        boolean foundTerm = false;
        String nameP = "";
        String priceP = "";
        String quan = "";

        try {
            sc = new Scanner(new File(filePath));
            sc.useDelimiter("[,\n]");

            while (sc.hasNext() && !foundTerm) {
                nameP = sc.next();
                priceP = sc.next();
                quan = sc.next();

                if (nameP.equals(searchTerm)) {
                    foundTerm = true;
                }


            }

            if (foundTerm) {
                System.out.println(nameP + "," + priceP + "," + quan);
            } else {
                System.out.println("Record not found");
            }

        } catch (Exception e) {

        }


    }


}
