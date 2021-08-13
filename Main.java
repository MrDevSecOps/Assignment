// Name: Ho Weng Yin
// ID: D210044A
// Batch: IT21A
// Subject Name: IT_FSDD_2021B
// Project
// Topic: Computer Shop Stock Management System
// Submission Date: /8/21
/*
Introduction:
    Problem Statement. Since MCO or Covid-19 Outbreak, the demand for the semiconductor especially the computer 
needed in the various industry is increased significantly. Therefore, this industry could be desperately needing
a completed system compared to previous. That is the reason the hardware industry I have chose. The computer shop
could be more relevant and more easier to found in the domestric area. It contributes to the idea of computer shop
stock management system chose as my topic to help the industry. 
    My stock management system is mainly helping the clients, computer shop owner to organizing their stock 
in the automated system instead of manpower key-in system. 

*/
/*
    My Stock management system has several objectives.  
    First. Computer Shop Stock Management System can read, modify and delete the computer accessories stock record.
    Secondly. Computer Shop Stock Management System can calculate the stock value.
    Thirdly. Computer Shop Stock Management System could do the stock procurement related operation as 
    find the supplier, calculate the compound interest, breakeven, currency convertion
    Next. Computer Shop Stock Management System provide simple accounting system to assist the users to do the
    basic understanding about the computer
*/

/*
    1.Stock Management
        READ 
        SEARCH 
        ADD 
        DELETE 
        ADVANCED SEARCH 

    2. Stock Evaluation
    3. Stock Procurement
        Logistics
        Compound Interest Calculator
        Breakeven Calculator
        Currency Convertor Calculator
    4. Balance Sheet




*/

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.BufferedReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.io.FileInputStream;

public class Main {
    // Global Variable
    public static boolean Repeated =true;
    public static boolean SubMenuRepeated =true;
    public static boolean SubMenuEachFunction = true;
    //
    public static boolean RepeatedForThree = true;
    // Global Array
    public static String[] Desktop;
    public static String[] Laptop;

    public static String[][] Non_Current= new String[10][4];
    public static String[][] Current= new String[10][4];
    public static String[][] EQUITY= new String[10][4];

    // Priority Method Start
    // Menu Method
    public static void ComputerArt(){
        System.out.println(
        "\n   	    ________________________________________________	       "
        +"\n          /                                                 \\	       "
        +"\n          |    _________________________________________     |	       "
        +"\n          |   |                                         |    |	       "
        +"\n          |   |  C:\\>Welcome To Computer Shop Management|    |	       "
        +"\n          |   |  System                                 |    |	       "
        +"\n          |   |  C:\\> java IT_FSDD_Project_D210044A.java|    |	       "
        +"\n          |   |  C:\\>                                   |    |	       "
        +"\n          |   |  Created By Ho Weng Yin                 |    |	       "
        +"\n          |   |                                         |    |	       "
        +"\n          |   |  1. Stock Management                    |    |	       "
        +"\n          |   |  2. Stock Valuation                     |    |	       "
        +"\n          |   |  3. Stock Procurement                   |    |	       "
        +"\n          |   |  4. Balance Sheet                       |    |	       "
        +"\n          |   |                                         |    |	       "
        +"\n          |   |  9. Exit                                |    |	       "
        +"\n          |   |  Insert 1-9:                            |    |	       "
        +"\n          |   |_________________________________________|    |	       "
        +"\n          |                                                  |	       "
        +"\n           \\_________________________________________________/	       "
        +"\n                  \\___________________________________/		       "
        +"\n               ___________________________________________		       "
        +"\n            _-'    .-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.  --- `-_	       "
        +"\n        _-'.-.-. .---.-.-.-.-.-.-.-.-.-.-.-.-.-.-.--.  .-.-.`-_	       "
        +"\n      _-'.-.-.-. .---.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-`__`. .-.-.-.`-_	       "
        +"\n   _-'.-.-.-.-. .-----.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-----. .-.-.-.-.`-_     "
        +"\n_-'.-.-.-.-.-. .---.-. .-------------------------. .-.---. .---.-.-.-.`-_  "
        +"\n:-------------------------------------------------------------------------:"
        +"\n`---._.-------------------------------------------------------------._.---'"
        +"\nInsert 1-9:"
        );
    }

    public static void StockManagementArt(){
        System.out.println(
        "\n   	    ________________________________________________	       "
        +"\n          /                                                 \\	       "
        +"\n          |    _________________________________________     |	       "
        +"\n          |   |                                         |    |	       "
        +"\n          |   |  Created By Ho Weng Yin                 |    |	       "
        +"\n          |   |                                         |    |	       "
        +"\n          |   |  1. Read Stock                          |    |	       "
        +"\n          |   |  2. Search Stock                        |    |	       "
        +"\n          |   |  3. Add Stock                           |    |	       "
        +"\n          |   |  4. Delete Single Item (Cannot Overlap) |    |	       "
        +"\n          |   |  5. Delete Multiple Items (Can Overlap) |    |	       "
        +"\n          |   |  6. Delete The Specific Item(Advanced)  |    |	       "
        +"\n          |   |  7. Edit Stock                          |    |	       "
        +"\n          |   |  8. Advanced Search                     |    |	       "
        +"\n          |   |  9. Return To Main Page                 |    |	       "
        +"\n          |   |  999. Create Database                   |    |	       "
        +"\n          |   |  Insert 1-9:                            |    |	       "
        +"\n          |   |_________________________________________|    |	       "
        +"\n          |                                                  |	       "
        +"\n           \\_________________________________________________/	       "
        +"\n                  \\___________________________________/		       "
        +"\n               ___________________________________________		       "
        +"\n            _-'    .-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.  --- `-_	       "
        +"\n        _-'.-.-. .---.-.-.-.-.-.-.-.-.-.-.-.-.-.-.--.  .-.-.`-_	       "
        +"\n      _-'.-.-.-. .---.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-`__`. .-.-.-.`-_	       "
        +"\n   _-'.-.-.-.-. .-----.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-----. .-.-.-.-.`-_     "
        +"\n_-'.-.-.-.-.-. .---.-. .-------------------------. .-.---. .---.-.-.-.`-_  "
        +"\n:-------------------------------------------------------------------------:"
        +"\n`---._.-------------------------------------------------------------._.---'"
        +"\nInsert 1-9:"
        );
    }

    public static void ComputerStockArt(){
        System.out.println(
            "\n   	    ________________________________________________	       "
            +"\n          /                                                 \\	       "
            +"\n          |    _________________________________________     |	       "
            +"\n          |   |                                         |    |	       "
            +"\n          |   |  Created By Ho Weng Yin                 |    |	       "
            +"\n          |   |                                         |    |	       "
            +"\n          |   |  1. Desktop Stock                       |    |	       "
            +"\n          |   |  2. LapTop Stock                        |    |	       "
            +"\n          |   |                                         |    |	       "
            +"\n          |   |  9. Return To Main Page                 |    |	       "
            +"\n          |   |  Insert 1-9:                            |    |	       "
            +"\n          |   |_________________________________________|    |	       "
            +"\n          |                                                  |	       "
            +"\n           \\_________________________________________________/	       "
            +"\n                  \\___________________________________/		       "
            +"\n               ___________________________________________		       "
            +"\n            _-'    .-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.  --- `-_	       "
            +"\n        _-'.-.-. .---.-.-.-.-.-.-.-.-.-.-.-.-.-.-.--.  .-.-.`-_	       "
            +"\n      _-'.-.-.-. .---.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-`__`. .-.-.-.`-_	       "
            +"\n   _-'.-.-.-.-. .-----.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-----. .-.-.-.-.`-_     "
            +"\n_-'.-.-.-.-.-. .---.-. .-------------------------. .-.---. .---.-.-.-.`-_  "
            +"\n:-------------------------------------------------------------------------:"
            +"\n`---._.-------------------------------------------------------------._.---'"
            +"\nInsert 1-9:"
            );

    }
    public static void AdvancedSearchArt(){
        System.out.println(
            "\n   	    ________________________________________________	       "
            +"\n          /                                                 \\	       "
            +"\n          |    _________________________________________     |	       "
            +"\n          |   |                                         |    |	       "
            +"\n          |   |  ADVANCED SEARCH                        |    |	       "
            +"\n          |   |                                         |    |	       "
            +"\n          |   |  Created By Ho Weng Yin                 |    |	       "
            +"\n          |   |                                         |    |	       "
            +"\n          |   |                                         |    |	       "
            +"\n          |   |  1. Search by Budget                    |    |	       "
            +"\n          |   |  2. Search by Brand                     |    |	       "
            +"\n          |   |  3. Search by Hardware Specification    |    |	       "
            +"\n          |   |  4. Search by Assending Price           |    |	       "
            +"\n          |   |  5. Search by Assending Quantity        |    |	       "
            +"\n          |   |  6. Search by Assending Date            |    |	       "
            +"\n          |   |                                         |    |	       "
            +"\n          |   |  9. Return To Main Page                 |    |	       "
            +"\n          |   |  Insert 1-9:                            |    |	       "
            +"\n          |   |_________________________________________|    |	       "
            +"\n          |                                                  |	       "
            +"\n           \\_________________________________________________/	       "
            +"\n                  \\___________________________________/		       "
            +"\n               ___________________________________________		       "
            +"\n            _-'    .-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.  --- `-_	       "
            +"\n        _-'.-.-. .---.-.-.-.-.-.-.-.-.-.-.-.-.-.-.--.  .-.-.`-_	       "
            +"\n      _-'.-.-.-. .---.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-`__`. .-.-.-.`-_	       "
            +"\n   _-'.-.-.-.-. .-----.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-----. .-.-.-.-.`-_     "
            +"\n_-'.-.-.-.-.-. .---.-. .-------------------------. .-.---. .---.-.-.-.`-_  "
            +"\n:-------------------------------------------------------------------------:"
            +"\n`---._.-------------------------------------------------------------._.---'"
            +"\nInsert 1-9:"
            );

    }

    public static void BadApple(){
        // Refer To https://github.com/Pasc99/text2BAinWinConsole/blob/master/text2ba.zip
        System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
        +"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM20MMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
        +"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM:     SMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
        +"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMr       .Sri::0MMMMMMMMMMMMMMMMMMM\n"
        +"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMX              .WMMMMMMMMMMMMMMMMM\n"
        +"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMZ.                 ZMMMMMMMMMMMMMMMM\n"
        +"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMB                      MMMMMMMMMMMMMMMM\n"
        +"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM0                       ;MMMMMMMMMMMMMMM\n"
        +"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMS                         0MMMMMMMMMMMMMM\n"
        +"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMX                          MMMMMMMMMMMMMM\n"
        +"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMr                          XMMMMMMMMMMMMM\n"
        +"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMX                           @MMMMMMMMMMMM\n"
        +"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMai;                        MMMMMMMMMMMMM\n"
        +"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMX                       BMMMMMMMMMMMM\n"
        +"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM0.                        MMMMMMMMMMMM\n"
        +"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM2                       MMMMMMMMMMMM\n"
        +"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM;                     MMMMMMMMMMMM\n"
        +"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMX   ZX            ;   MMMMMMMMMMMM\n"
        +"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM.                M r WMMMMMMMMMMM\n"
        +"MMMMMMMMMMMMMMMMMMMMMMMM0:i    aMMMMMMMMMMMMMMX                 a7SMMMMMMMMMMMM\n"
        +"MMMMMMMMMMMMMMMMMMMMMM8         SMMMMMMMMMMMMMS                XMaMMMMMMMMMMMMM\n"
        +"MMMMMMMMMMMMMMMMMMMMMMB         7MMMMMMMMMMMMB.                MMMMMMMMMMMMMMMM\n"
        +"MMMMMMMMMMMMMMMMMMMMMM8         .WMMMMMMMM7                  M,BMMMMMMMMMMMMMMM\n"
        +"MMMMMMMMMMMMMMMMMMMMMMM:           .SBMMMMX                  MMMMMMMMMMMMMMMMMM\n"
        +"MMMMMMMMMMMMMMMMMMMMMMMM@;            .aZ;                    MMMMMMMMMMMMMMMMM\n"
        +"MMMMMMMMMMMMMMMMMMMMMMMMMMMMM,                                MMMMMMMMMMMMMMMMM\n"
        +"MMMMMMMMMMMMMMMMMMMMMMMMMMMM0                                 MMMMMMMMMMMMMMMMM\n"
        +"MMMMMMMMMMMMMMMMMMMMMMMMMMMM0                                 a0S.  WMMMMMMMMMM\n"
        +"MMMMMMMMMMMMMMMMMMMMMMMMMMMMB                                    8BBMMMMMMMMMMM\n"
        +"MMMMMMMMMMMMMMMMMMMMMMMMMMM@.               i,                  MMMMMMMMMMMMMMM\n"
        +"MMMMMMMMMMMMMMMMMMMMMMMMMMM8                ,:                   MMMMMMMMMMMMMM\n");

        System.out.println("1- Logistic Partner Details");
        System.out.println("2- Compound Interesting Calculator");
        System.out.println("3-  Breakeven Calculator");
        System.out.println("4-  Currency Convertor");
        System.out.println("9- Exit");
        System.out.println("Please Insert (1-9):");

    }
    public static void CalculatorArt(Double Number){
        System.out.println("_____________________\n"
        +"|  _________________  |\n"
        +"| |   + "+Number+"  \n"
        +"| |_________________| |\n"
        +"|  ___ ___ ___   ___  |\n"
        +"| | 7 | 8 | 9 | | + | |\n"
        +"| |___|___|___| |___| |\n"
        +"| | 4 | 5 | 6 | | - | |\n"
        +"| |___|___|___| |___| |\n"
        +"| | 1 | 2 | 3 | | x | |\n"
        +"| |___|___|___| |___| |\n"
        +"| | . | 0 | = | | / | |\n"
        +"| |___|___|___| |___| |\n"
        +"|_____________________|\n");
    }
    // Repeat Menu Method
    public static void Menu(){
        // Display The ComputerArt As The Menu Graphics User Interface
        ComputerArt();           
    }
    // Clear Screen Method
    // Used Several Time In Order To Clear The Messy User Interface
    public static void ClearScreen(){
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
        }

        catch (final Exception e) {
            e.printStackTrace();
        }
    }

    // Menu Menu User Input Handling Before Proceed Into Sub Menu
    public static void UserInput(int Input){
        switch(Input){
            case 1:
                // SubMenu -1 
                Stock_Management();
                break;
            case 2:
                // SubMenu -2
                System.out.println("__________________________________________DESKTOP_________________________________");
                Stock_Valuation("DESKTOP.txt");
                System.out.println("__________________________________________LAPTOP_________________________________");
                Stock_Valuation("LAPTOP.txt");
                break;
            case 3:
                // subMenu -3 
                Stock_Procurement();
                break;

            case 4:
                // subMenu -4
                BalanceSheet();
                break;
            case 9:
                // Set the Main Menu Exit...
                System.out.println("You are exiting the program...");
                Repeated = false;
                break;
            default:
                System.out.println("Invalid Options! Please Try Again");
            
        }
    }

    // SubMenu - 1
    public static void Stock_Management(){
        while(SubMenuRepeated){
            // Redeclare Make Sure It Will Repeat Again
            SubMenuEachFunction = true;
            StockManagementArt();
            Scanner ManagementOption = new Scanner(System.in);
            try{
                int Management_Function_Chose = ManagementOption.nextInt();
                switch (Management_Function_Chose){
                    case 1:
                        // SubMenu 1 - Read Function
                        System.out.println("Case 1");
                        ReadStock();
                        break;
                    case 2:
                        // SubMenu 2- Add Function
                        System.out.println("Case 2");
                        SearchStock();
                        break;

                    case 3: 
                        // SubMenu 3- Delete Function
                        System.out.println("Case 3");
                        AddStock();
                        break;
                    case 4:
                        // SubMenu 4- Edit Function
                        System.out.println("Case 4");
                        DeleteStock();
                        break;
                    case 5:
                        // SubMenu 5- Advanced Search Function
                        System.out.println("Case 5");
                        DeleteMultipleStock();
                        break;
                    case 6:
                        System.out.println("Case 6");
                        break;
                    case 7:
                        System.out.println("Case 7");
                        EditStock();
                        break;

                    case 8:
                        System.out.println("Case 8");
                        AdvancedSearchStock();
                        break;
                   

                    case 9:
                        // SubMenu-1 Exit 
                        SubMenuRepeated = false;
                        System.out.println("Back To Main Menu... ");
                        break;

                    case 999:
                        System.out.println("Case 999");
                        CreateDatabase();
                        break;
                    default:
                        break;
                }
            }catch (Exception e) { 
                ClearScreen();
                System.out.println("Please Try Again");
            }

        }  
    }


    // Reading File Lines Before Declare The Array     * IMPORTANT FUNCTION
    public static long CountFileLine(String fileName){
        // Refer Documentation http://tutorials.jenkov.com/java-nio/path.html
        // Refer Documentation https://mkyong.com/java/how-to-get-the-total-number-of-lines-of-a-file-in-java/
        Path path = Paths.get(fileName);
        long lines=0;
        try{
            lines = Files.lines(path).count();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    // Reading File For Manipulating * IMPORTANT FUNCTION
    public static String[] ReadingFileIntoArray(String Readfile){
        // Reading File Line From Long Into Integer Type
        int NumberOfLine = (int)CountFileLine(Readfile);
        // Create Array according to the filesize
        Desktop = new String[NumberOfLine];
        int i=0;
        try {
            // Reading The File
            File myObj = new File(Readfile);
            // Declare Scanner
            Scanner myReader = new Scanner(myObj);
            // Scanner will loop to read the next line until the end because .hasNextLine()
            while (myReader.hasNextLine()) {
              Desktop[i] = myReader.nextLine();
              i++;
            }
            // File Closing
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        // Return String Array
        return Desktop;
    }
    // SubMenu 1- 1.Read Stock Method
    public static void ReadStock(){
    // Repeated by SubMenuEach Function
    while(SubMenuEachFunction){
        // Display Art As Menu
        ComputerStockArt();
        // Declare Scanner
        Scanner StockTypeOption = new Scanner(System.in);
        // Try and Catch the Error Input Especially the input is not integer type
        try{
            int StockType = StockTypeOption.nextInt();
            // Switch Case
            switch(StockType){
            case 1:
                // Use the previous method to get the each line of the file into array example line[0] = Desktoplist[0]
                String[] Desktoplist = ReadingFileIntoArray("DESKTOP.txt");
                // Refer https://www.tutorialkart.com/java/java-print-array-elements/
                int index = 0;
                while(index < Desktoplist.length) {
                    String item = Desktoplist[index];
                    System.out.println(index+1 + " "+ item);
                    index++;
                }


                break;
           
            case 2:  
                // Same as Case 1 but for Laptop
                String[] Laptoplist = ReadingFileIntoArray("LAPTOP.txt");

                int index1 = 0;
                while(index1 < Laptoplist.length) {
                    String item = Laptoplist[index1];
                    System.out.println(index1+1 + " "+ item);
                    index1++;
                }

                break;
                        
            case 9:
                // Exit By Setting the SubMenuEachFunction Becomes False to exit the function
                SubMenuEachFunction = false;
                ClearScreen();
                System.out.println("Back To Each Sub Menu -1 ");
                break;
            default:
                System.out.println("Invalid Input");
                break;
            }
        } catch(Exception e) { 
            ClearScreen();
            System.out.println("Please Try Again");
        }

    }
    

            
    
}

    // SubMenu 1- 2.Search Stock Method
    public static void SearchStock(){
        Scanner SearchItem = new Scanner(System.in);
        // Prompt to get the user input in order to search desired items from user
        System.out.println("What Stock you want to search?");
        String ItemSearch = SearchItem.next();
        // Open Two Arrays To Check the desired item from user
        String[] Desktoplist = ReadingFileIntoArray("DESKTOP.txt");
        String[] Laptoplist = ReadingFileIntoArray("LAPTOP.txt");
        int index = 0;
        int index1 = 0;
        // Loop for Searching from the Desktop Array
        while(index < Desktoplist.length) {
            String item1 = Desktoplist[index];
            if(item1.contains(ItemSearch) || item1.contains(ItemSearch.toUpperCase())){
                System.out.println(item1);
            }
            index++;
        }
        // Loop for Searching from the Laptop Array
        while(index1 < Laptoplist.length) {
            String item2 = Laptoplist[index1];
            if(item2.contains(ItemSearch) || item2.contains(ItemSearch.toUpperCase())){
                System.out.println(item2);
            }
            index1++;
        }
    }
    //Add Method Separate From SubMenu In Order Make Less Code * Important Function
    //public static void AddGeneral(String[] INSERTNEW){

    //}
    // SubMenu 1- 3.Add Stock Method
    public static void AddStock(){
        // Repeated by SubMenuEach Function
        while(SubMenuEachFunction){
            ComputerStockArt();
            Scanner StockTypeOption = new Scanner(System.in);
            try{
                int StockType = StockTypeOption.nextInt();
                switch(StockType){
                    case 1:
                        // Reading File
                        // Display Before Adding New Items
                        String[] Desktoplist = ReadingFileIntoArray("DESKTOP.txt");
                        int index = 0;
                        while(index < Desktoplist.length) {
                            String item = Desktoplist[index];
                            System.out.println(index+1 + " "+ item);
                            index++;
                        }
                        //
                        // Declare Array to be written before written into File
                        String[] NewItem = new String[9];
                        String[] Prompt = {"Enter The CPU (I3/I5/I7/I9/I11)","What Type OF Hardware? Default:(Desktop)","What is the Price? Such as 3000","How Many RAM? Such as 8", "Any Accessories? Such as Mouse,Keyboard","How many Quantity? Such as 800"," What is your cost? Such as 2000","When You Purchase Such as 1/1/2021","What is the brand? Such as Lenovo"};
                        // Can Insert The ITEM BUT CANNOT VALID THE USER INPUT ** FOR IMPROVEMENT
                        Scanner NEWITEMSCANNER = new Scanner(System.in);
                        for(int PromptManyTimes = 0; PromptManyTimes< 9; PromptManyTimes++){
                            if(PromptManyTimes != 1){
                                System.out.println(Prompt[PromptManyTimes]);
                                NewItem[PromptManyTimes] = NEWITEMSCANNER.next();
                            } else{
                                // Because This Case 1 is For The Desktop Therefore No Need To Prompt the type. Just Info
                                // Users. 
                                System.out.println(Prompt[PromptManyTimes]);
                                System.out.println("AutoKey-in By Default");
                                NewItem[PromptManyTimes] = "Desktop";
                            }
                            
                        }
                        // To Make The Output Is Correct Before proceeding the advanced feature
                        //System.out.println(Arrays.toString(NewItem));
                        //Check The Reading File Array List First To make Sure the line before adding new lines
                        // System.out.println(Desktoplist.length);
                        // Working and Know The Total Lines Of Array

                        //Now Need To Transform Array[9] into Array[1] Before Written Into File Otherwise won't working
                        //1-CPU 2-DESKTOP 3-Price:RMXXXX 4-RAM:12GB 5-Mouse,Keyboard 6-QTY:3000 7-COST:RM8000 8-PURCHASE_DATE:5/5/2020 9-BRAND:XXX
                        String[] MergeArrayIntoOne = {NewItem[0]+ " "+ NewItem[1]+ " "+ "Price:RM"+ NewItem[2]+ " "+"RAM:"+ NewItem[3]+ "GB"+" "+ NewItem[4]+ " "+"QTY:" + NewItem[5] + " "+ "COST:RM"+NewItem[6] + " "+"PURCHASE_DATE:"+NewItem[7]+" "+ "BRAND:"+NewItem[8]};                    
                        //System.out.println(Arrays.toString(MergeArrayIntoOne));

                        //Adding Array Into New Array (Copy)
                        String[] copy =  new String[Desktoplist.length + 1];
                        for(int ArrayCounting=0; ArrayCounting < copy.length; ArrayCounting++){
                            if(ArrayCounting < copy.length-1 ){
                                copy[ArrayCounting] = Desktoplist[ArrayCounting];
                            } else {
                                // Adding New Item at the last row
                                copy[ArrayCounting] = MergeArrayIntoOne[0];

                            }
                        }
                        //System.out.println(Arrays.toString(copy));
                        //System.out.println(copy[DisplayCounting]);

                        // New Array With New Items (Display)
                        // Adding New Array Into File
                        //First Trial
                        //try{
                            //File myObj = new File("DESKTOP.txt");
                            //FileWriter fileWriter = new FileWriter(myObj, true);
                            //BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                            //for(int DisplayCounting=0; DisplayCounting < copy.length; DisplayCounting++){
                                //bufferedWriter.write(copy[DisplayCounting]);  
                            //}
                        //}catch (Exception e){
                            //System.out.println("Cannot Write and Add Item Unsucessfully...");
                        //}
                        // Second Trial
                        // Refer To https://stackoverflow.com/questions/13707223/how-to-write-an-array-to-a-file-java
                        try{
                            BufferedWriter outputWriter = null;
                            outputWriter = new BufferedWriter(new FileWriter("DESKTOP.txt"));
                            for (int i = 0; i < copy.length; i++) {
                              // Maybe:
                              //outputWriter.write(copy[i]+"");
                              // Or:
                              outputWriter.write(copy[i]);
                              outputWriter.newLine();
                            }
                            outputWriter.flush();  
                            outputWriter.close();  
                        } catch(Exception e) {
                            System.out.println("Write Unsuccessfully due to the errors");
                        }                      
                        //
                        // New Array is to be declared in order to take the array file and new array to sum up them
                        // Into New Array with new items before written into file
                        //String[] writtenToFile= new String[]
                        break;

                    case 2: 
                        String[] Laptoplist = ReadingFileIntoArray("LAPTOP.txt");
                        int index1 = 0;
                        while(index1 < Laptoplist.length) {
                            String item = Laptoplist[index1];
                            System.out.println(index1+1 + " "+ item);
                            index1++;
                        }
                        // Same as Previous (NewItem and Prompt) but here NewItem1 and Prompt 
                        String[] NewItem1 = new String[9];
                        String[] Prompt1 = {"Enter The CPU (I3/I5/I7/I9/I11)","What Type OF Hardware? Default:(Desktop)","What is the Price? Such as 3000","How Many RAM? Such as 8", "Any Accessories? Such as Mouse,Keyboard","How many Quantity? Such as 800"," What is your cost? Such as 2000","When You Purchase Such as 1/1/2021","What is the brand? Such as Lenovo"};
                        // Same as Previous NEWITEMSCANNER1
                        Scanner NEWITEMSCANNER1 = new Scanner(System.in);
                        for(int PromptManyTimes1 = 0; PromptManyTimes1< 9; PromptManyTimes1++){
                            if(PromptManyTimes1 != 1){
                                System.out.println(Prompt1[PromptManyTimes1]);
                                NewItem1[PromptManyTimes1] = NEWITEMSCANNER1.next();
                            } else{
                                // Because This Case 1 is For The Desktop Therefore No Need To Prompt the type. Just Info
                                // Users. 
                                System.out.println(Prompt1[PromptManyTimes1]);
                                System.out.println("AutoKey-in By Default");
                                // Here Different Because The Type Of Item is Laptop
                                NewItem1[PromptManyTimes1] = "Laptop";
                            }
                            
                        }
                        /////////////////////////////// Same as Case But Everything is NewItem1
                        String[] MergeArrayIntoOne1 = {NewItem1[0]+ " "+ NewItem1[1]+ " "+ "Price:RM"+ NewItem1[2]+ " "+"RAM:"+ NewItem1[3]+ "GB"+" "+ NewItem1[4]+ " "+"QTY:" + NewItem1[5] + " "+ "COST:RM"+NewItem1[6] + " "+"PURCHASE_DATE:"+NewItem1[7]+" "+ "BRAND:"+NewItem1[8]};                    
                        // 
                        //Adding Array Into New Array (Copy1)
                        // LaptopList
                        String[] copy1 =  new String[Laptoplist.length + 1];
                        for(int ArrayCounting1=0; ArrayCounting1 < copy1.length; ArrayCounting1++){
                            if(ArrayCounting1 < copy1.length-1 ){
                                copy1[ArrayCounting1] = Laptoplist[ArrayCounting1];
                            } else {
                                // Adding New Item at the last row
                                copy1[ArrayCounting1] = MergeArrayIntoOne1[0];
      
                            }
                        }
                        // Array To File 
                        try{
                            BufferedWriter outputWriter1 = null;
                            outputWriter1 = new BufferedWriter(new FileWriter("LAPTOP.txt"));
                            for (int i = 0; i < copy1.length; i++) {
                              // Maybe:
                              //outputWriter1.write(copy1[i]+"");
                              // Or:
                              outputWriter1.write(copy1[i]);
                              outputWriter1.newLine();
                            }
                            outputWriter1.flush();  
                            outputWriter1.close();  
                        } catch(Exception e) {
                            System.out.println("Write Unsuccessfully due to the errors");
                        }                      
                        //


                        break;
                    
                    case 9:
                        // Exit the Program By Setting SubMenuEachFunction = false
                        SubMenuEachFunction = false;
                        System.out.println("Back To Each Sub Menu -1 ");
                        break;
                    default:
                        System.out.println("Invalid Input");
                        break;
                }
            } catch(Exception e) { 
                ClearScreen();
                System.out.println("Please Try Again");
            }
        }
        

    }
    
    // Delete General Method
    
    // SubMenu 1- 4.Delete Stock Method
    public static void DeleteStock(){
        while(SubMenuEachFunction){
            ComputerStockArt();
            Scanner DeleteScanner = new Scanner(System.in);
            try{
                int DeleteType = DeleteScanner.nextInt();
                switch(DeleteType){
                    case 1:
                        System.out.println("Delete Desktop Item Function ");
                        System.out.println("_____________________________________");
                        // Make Sure Working

                        // Display Before Delete
                        String[] DeleteDesktoplist = ReadingFileIntoArray("DESKTOP.txt");
                        int Number = 0;
                        while(Number < DeleteDesktoplist.length) {
                            String DisplayDeleteItem = DeleteDesktoplist[Number];
                            System.out.println(Number+1 + " "+ DisplayDeleteItem);
                            Number++;
                        }
                        // Finised Display

                        // Prompt User Which What To Delete
                        // Use Search Method to Narrow Down The Scope Before Delete Therefore It Can Delete Specific Items
                        // Should add Exit Button If the User Dont Want To Delete
                        try{
                            System.out.println("");
                            System.out.println("What Item You Want To Delete (If Want To Exit Press - 0)");
                            String UserDeleteDecision = DeleteScanner.next();
                            if(UserDeleteDecision == "0"){
                                // To Exit Program
                                SubMenuEachFunction = false;
                                System.out.println("Back To Each Sub Menu -1 ");
                            } else{
                                // Delete Function Here

                                String[] DeleteDesktopList = ReadingFileIntoArray("DESKTOP.txt");
                                int DeleteIndex1 = 0;
                                // Loop for Searching from the Desktop Array
                                while(DeleteIndex1 < DeleteDesktopList.length) {
                                    String DeleteItem1 = DeleteDesktopList[DeleteIndex1];
                                    if(DeleteItem1.contains(UserDeleteDecision) || DeleteItem1.contains(UserDeleteDecision.toUpperCase())){
                                        System.out.println(UserDeleteDecision);
                                    }
                                    DeleteIndex1++;
                                }


                            }
                            
                        }catch(Exception e){
                            System.out.println("Please Insert The Correct Input");
                        }
                        break;

                    case 2:
                        System.out.println("Delete Laptop Item Function ");
                        System.out.println("_____________________________________");
                        // Make Sure Working
                        // Display Before Delete
                        String[] DeleteDesktoplist1 = ReadingFileIntoArray("LAPTOP.txt");
                        int Number1 = 0;
                        while(Number1 < DeleteDesktoplist1.length) {
                            String DisplayDeleteItem1 = DeleteDesktoplist1[Number1];
                            System.out.println(Number1+1 + " "+ DisplayDeleteItem1);
                            Number1++;
                        }
                        // Finised Display
                        // Prompt User Which What To Delete
                        // Use Search Method to Narrow Down The Scope Before Delete Therefore It Can Delete Specific Items
                        try{
                            System.out.println("");
                            System.out.println("What Item You Want To Delete (If Want To Exit Press - 0)");
                            String UserDeleteDecision = DeleteScanner.next();
                            if(UserDeleteDecision == "0"){
                                // To Exit Program
                                SubMenuEachFunction = false;
                                System.out.println("Back To Each Sub Menu -1 ");
                            } else{
                                // Delete Function Here

                                //Extracted From Search Function // In Order To Run Through The Data
                                String[] DeleteLaptopList = ReadingFileIntoArray("LAPTOP.txt");
                                String[] SumOneToDelete = new String[1];
                                int DeleteIndex = 0;
                                int Sum = 0;
                                int Countline=0;
                                // Loop for Searching from the Desktop Array
                                while(DeleteIndex < DeleteLaptopList.length) {
                                    String DeleteItem = DeleteLaptopList[DeleteIndex];
                                    if(DeleteItem.contains(UserDeleteDecision) || DeleteItem.contains(UserDeleteDecision.toUpperCase())){
                                        System.out.println(DeleteItem);
                                        Sum += 1;
                                        SumOneToDelete[0] = DeleteItem;
                                        if(Sum == 1){
                                            Countline = DeleteIndex;
                                        }
                                      
                                    }
                                  
                                    DeleteIndex++;
                                }
                                // Add One More If-Else Statement in order User to exit anytime
                                //  Checking
                                //System.out.println(Sum);
                                // Checking In Order To Know Which Line To Delete
                                System.out.println(Countline);
                                // Now Got Two Condition; First Condition Is Sum = 1; Second Condition Sum > 1
                                // For The First Condition Ask Whether Want To Delete To Double Confirm Before Delete and Provide
                                // Exit Choice
                                Boolean ConfirmDelete = true;
                                //Scanner ConfirmScannerToDelete = new Scanner(System.in);
                                if(Sum == 1){
                                    //System.out.println(SumOneToDelete[0]);
                                    // Now We Have Delete Element And Delete Row...
                                    // But How Do We Actually Delete Array Which Has The Fixed Size?
                                    // Method is Declaring New Array with one lesser length in order to do this...
                                    String[] SmallerSizeArray = new String[DeleteLaptopList.length-1];
                                    int ForLoop = 0;
                                    //Second Trial Successfully Delete Element From Array
                                    while(ForLoop < DeleteLaptopList.length-1){
                                        if(ForLoop == Countline){
                                            SmallerSizeArray[ForLoop] = DeleteLaptopList[ForLoop+1];
                                            ForLoop++;
                                        } else {
                                            SmallerSizeArray[ForLoop] = DeleteLaptopList[ForLoop];
                                            ForLoop++;
                                        }
                                    }
                                    //Checking/ Testing
                                    //System.out.println(Arrays.toString(SmallerSizeArray));
                                    // Now, we're going to write into File BY Referring previous examples

                                    try{
                                        BufferedWriter outputWriter2 = null;
                                        outputWriter2 = new BufferedWriter(new FileWriter("LAPTOP.txt"));
                                        for (int i = 0; i < SmallerSizeArray.length; i++) {
                                          // Maybe:
                                          //outputWriter1.write(copy1[i]+"");
                                          // Or:
                                          outputWriter2.write(SmallerSizeArray[i]);
                                          outputWriter2.newLine();
                                        }
                                        outputWriter2.flush();  
                                        outputWriter2.close();  
                                    } catch(Exception e) {
                                        System.out.println("Write Unsuccessfully due to the errors");
                                    }   

                                    // Delete Successfully

                                } else{
                                    System.out.println("Too Many Files are selected/ No File is Selected");
                                }

                            }
                            
                        }catch(Exception e){
                            System.out.println("Please Insert The Correct Input");
                        }



                        break;


                    case 9:
                        SubMenuEachFunction = false;
                        System.out.println("Back To Each Sub Menu -1 ");
                        break;
                    default:
                        System.out.println("Invalid Input");
                        break;
                }
            } catch(Exception e){
                ClearScreen();
                System.out.println("Please Try Again");
            }

        }
    }
    // SubMenu 1- 5.Delete Multiple Stock Method
    public static void DeleteMultipleStock(){

    }
    // SubMenu 1- 6.Modify Stock Method
    public static void EditStock(){
        
    }
    // SubMenu 1- 7.Advanced Search Stock Method
    public static void AdvancedSearchStock(){
         // Repeated by SubMenuEach Function
        while(SubMenuEachFunction){
        AdvancedSearchArt();
        Scanner StockTypeOption = new Scanner(System.in);
        try{
            int StockType = StockTypeOption.nextInt();
            switch(StockType){
            case 1:
                // Search By Budget -1 
                System.out.println("Enter You Budget? Such as 3000");
                try{
                    int Budget = StockTypeOption.nextInt();
                    // Convert To String In order to use contains
                    String BudgetSearch = Integer.toString(Budget);
                    // Read File
                    String[] Desktoplist = ReadingFileIntoArray("DESKTOP.txt");
                    String[] Laptoplist = ReadingFileIntoArray("LAPTOP.txt");
                    // Declare Variables
                    int index = 0;
                    int index1 = 0;
                    //Get The Price Only From The List
                    // From Desktop
                    while(index < Desktoplist.length) {
                        String item1 = Desktoplist[index];
                        // We Split The Line and Get The Price:RMXXX, Later Need to Eliminate Price:RMXXXX
                        String[] splited = item1.split("\\s+");
                        // Result Price:RMXXXX
                        //System.out.println(splited[2]);
                        // Result XXXX In order to compare the price
                        // System.out.println(splited[2].substring(8,splited[2].length()));
                        String Price = splited[2].substring(8,splited[2].length());
                        int ComparedPrice = Integer.parseInt(Price);
                        if(Budget >= ComparedPrice){
                            System.out.println("Within Your Budget: "+item1);
                        } 
                        index++;
                    }
               
              
                } catch(Exception e) { 
                    ClearScreen();
                    System.out.println("You Enter Non-integer Type. Please Enter Integer such as 1000");
                }
    
                break;
    
            case 2:  
                // Search By Brand -2
                // Repeated by SubMenuEach Function
                System.out.println("Enter You Brands? Such As Acer, Apple, Lenovo");
                try{
                    Scanner BRANDSCANNER = new Scanner(System.in);
                    String Brands =  BRANDSCANNER.next();
                    String[] Desktoplist = ReadingFileIntoArray("DESKTOP.txt");
                    String[] Laptoplist = ReadingFileIntoArray("LAPTOP.txt");
                    String Brands_Upper = Brands.toUpperCase();

                    int index2 = 0;
                    while(index2 < Desktoplist.length) {
                        String item2 = Desktoplist[index2];
                        String[] splited = item2.split("\\s+");
                        String BrandsFromArrays = splited[8].substring(6,splited[8].length());
                        //System.out.println(BrandsFromArrays);
                        // Compare Strings to Strings If They Equal Then The item is printed
                        if(Brands.equals(BrandsFromArrays)|| Brands_Upper.equals(BrandsFromArrays)){
                            System.out.println(item2);
                        }
                      
                        index2++;

                    }

                } catch(Exception e) { 
                    ClearScreen();
                    System.out.println("Please Enter Correct Brand Name");
                }
                break;

            case 3:
                //Search By Hardware Specifications -3
                System.out.println("Search By Hardware Specifications");
                try{
                    Scanner SpecScanner = new Scanner(System.in);
                    String Hardware =  SpecScanner.next();
                    String[] Desktoplist = ReadingFileIntoArray("DESKTOP.txt");
                    String[] Laptoplist = ReadingFileIntoArray("LAPTOP.txt");
                    String Hardware_Upper = Hardware.toUpperCase();

                    int index3 = 0;
                    while(index3 < Desktoplist.length) {
                        String item3 = Desktoplist[index3];
                        String[] splited = item3.split("\\s+");
                        String CPUFromArrays = splited[0];
                        String RAMFromArrays = splited[3].substring(3,splited[3].length());
                        // Compare Strings to Strings If They Equal Then The item is printed
                        if(Hardware.equals(CPUFromArrays)|| Hardware_Upper.equals(CPUFromArrays) || RAMFromArrays.equals(RAMFromArrays)){
                            System.out.println(item3);
                        }
                      
                        index3++;

                    }

                } catch(Exception e) { 
                    ClearScreen();
                    System.out.println("Please Enter Correct Brand Name");
                }
                break;

            case 4:
                System.out.println("Search By Assending Price");
                int index4 =0;
                String[] Desktoplist = ReadingFileIntoArray("DESKTOP.txt");
                long TotalLine = CountFileLine("DESKTOP.txt");
                int IntegerLine = (int)(TotalLine);
                int[] Price = new int[IntegerLine];
                while(index4 < Desktoplist.length) {
                    String item4 = Desktoplist[index4];
                    String[] splited = item4.split("\\s+");
                    String PriceFromArray = splited[2].substring(6,splited[2].length());
                    System.out.println(PriceFromArray);
                    //System.out.println(Date);

                    // Convert String To Integer Array
                    //Integer[] numbers = new Integer[IntegerLine];
                    //for(int z=0; z < IntegerLine; z++){
                        //numbers[z] = Integer.parseInt(item4);
                        //Price[z] = numbers[z];
                        //System.out.println(Price[z]);
                    //}
                    //Price[index4] = PriceFromArray[index4];
              
                    index4++;
                }
                break;

            case 5: 
                System.out.println("Search By Assending Quantity");
                int index5 =0;
                String[] Desktoplist1 = ReadingFileIntoArray("DESKTOP.txt");
                long TotalLine1 = CountFileLine("DESKTOP.txt");
                int IntegerLine1 = (int)(TotalLine1);
                int[] Price1 = new int[IntegerLine1];
                while(index5 < Desktoplist1.length) {
                String item5 = Desktoplist1[index5];
                String[] splited = item5.split("\\s+");
                String PriceFromArray = splited[2].substring(6,splited[2].length());
                System.out.println(PriceFromArray);
                index5++;
                }
                break;
            case 6:
                System.out.println("Search By Assending Date");
                int index6 =0;
                String[] Desktoplist2 = ReadingFileIntoArray("DESKTOP.txt");
                long TotalLine2 = CountFileLine("DESKTOP.txt");
                int IntegerLine2 = (int)(TotalLine2);
                int[] Price2 = new int[IntegerLine2];
                while(index6 < Desktoplist2.length) {
                String item6 = Desktoplist2[index6];
                String[] splited = item6.split("\\s+");
                String PriceFromArray = splited[2].substring(6,splited[2].length());
                System.out.println(PriceFromArray);
                index6++;
                }
                break;
             
                

            case 9:
                SubMenuEachFunction = false;
                break;

            default:
                break;
            }

        }
        catch (Exception e) {
            System.out.println("You Enter Non-integer Type. Please Enter Integer such as 1000");
        }
    }
            

    }

    public static void CreateDatabase(){
        // Refer TO:https://www.javatpoint.com/how-to-create-a-file-in-java
        System.out.println("Create Database");
        System.out.println("\n\nYour file format should follow this:");
        System.out.println("\nI3 LAPTOP PRICE:RM3000 RAM:8GB Webcam,Mouse,Mousepad QTY:1000 COST:RM1500 PURCHASE_DATE:5/5/2020 BRAND:ACER\n\n");
        File file = new File("DESKTOP.txt");
        File file2 = new File("LAPTOP.txt");
        boolean result;
        boolean result2;
        try{
            result = file.createNewFile();
            if(result){
                System.out.println("File Created" + file.getCanonicalPath());
            } else{
                System.out.println("DESKTOP.txt already exists");
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        try{
            result2 = file2.createNewFile();
            if(result2){
                System.out.println("File Created" + file2.getCanonicalPath());
            } else{
                System.out.println("LAPTOP.txt already exists");
            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    // Priority Method End
    // Less Priority Method

    //SubMenu 2
    public static void Stock_Valuation(String FILENAME){
        String[] Desktoplist = ReadingFileIntoArray(FILENAME);
        //String[] Laptoplist = ReadingFileIntoArray("LAPTOP.txt");
        long Lines = CountFileLine(FILENAME);
        int Lines_integer = (int) Lines;

        //long Lines2 = CountFileLine("LAPTOP.txt");
        //int Lines_integer2 = (int) Lines2;
        String[] PriceArray = new String[Lines_integer];
        String[] CostArray = new String[Lines_integer];
        String[] QuantityArray = new String[Lines_integer];

        //String[] PriceArray2 = new String[Lines_integer2];
        //String[] CostArray2 = new String[Lines_integer2];
        //String[] QuantityArray2 = new String[Lines_integer2];

        int index =0;
        Double NetProfit = 0.0;
        Double TotalCost = 0.0;

        //Double NetProfit2 = 0.0;
        //Double TotalCost2 = 0.0;

        System.out.println("Price\t\t\t\t\tCost\t\t\tQuantity");
        while(index < Desktoplist.length) {
            String item1 = Desktoplist[index];
            // We Split The Line and Get The Price:RMXXX, Later Need to Eliminate Price:RMXXXX
            String[] splited = item1.split("\\s+");
            // Price Value
            String Price = splited[2].substring(8,splited[2].length());
            PriceArray[index] = Price;
            System.out.print(Price);
            // Cost Value
            String Cost = splited[6].substring(7,splited[6].length());
            CostArray[index] = Cost;
            System.out.print("\t\t\t\t\t"+Cost);

            // Quantity
            String Quantity = splited[5].substring(4,splited[5].length());
            QuantityArray[index] = Quantity;
            System.out.print("\t\t\t"+Quantity);
            System.out.println("");
            // Now We Have Sale Price and Cost Price
            // Profit = (Sale -Cost)*Quantity   --Each Product
            index++;
        }
        //int indexForLaptop = 0;
        //while(indexForLaptop< Laptoplist.length) {        
            // Laptop
            //String item2 = Laptoplist[indexForLaptop];
            //String[] splited2 = item2.split("\\s+");
            //String Price2 = splited2[2].substring(8,splited2[2].length());
            //PriceArray2[indexForLaptop] = Price2;
            //String Cost2 = splited2[6].substring(7,splited2[6].length());
            //CostArray2[indexForLaptop] = Cost2;
            //String Quantity2 = splited2[5].substring(4,splited2[5].length());
            //QuantityArray2[indexForLaptop] = Quantity2;
            //indexForLaptop++;
        //}

        int NextIndex = 0;
        //int NextIndex2 = 0;

        // Convert String to Double Array
        Double[] SalePrice = new Double[PriceArray.length];
        Double[] CostPerUnit = new Double[CostArray.length];
        Double[] QuantityEachProduct = new Double[QuantityArray.length];
        //Laptop
        //Double[] SalePrice2 = new Double[PriceArray2.length];
        //Double[] CostPerUnit2 = new Double[CostArray2.length];
        //Double[] QuantityEachProduct2 = new Double[QuantityArray2.length];

        for (int i = 0; i < PriceArray.length; i++) {
            SalePrice[i] = Double.parseDouble(PriceArray[i]);
            CostPerUnit[i] = Double.parseDouble(CostArray[i]);
            QuantityEachProduct[i] = Double.parseDouble(QuantityArray[i]);
         

        }
        //for (int p  = 0; p < PriceArray2.length; p++) {
            //Laptop
            //SalePrice2[p] = Double.parseDouble(PriceArray2[p]);
            //CostPerUnit2[p] = Double.parseDouble(CostArray2[p]);
            //QuantityEachProduct2[p] = Double.parseDouble(QuantityArray2[p]);

        //}
        while(NextIndex < Desktoplist.length){
            NetProfit += (SalePrice[NextIndex]-CostPerUnit[NextIndex]) * QuantityEachProduct[NextIndex];
            TotalCost += (CostPerUnit[NextIndex] * QuantityEachProduct[NextIndex]);
            NextIndex++;
        
        }
        //while(NextIndex2 < Laptoplist.length){
            //NetProfit2 += (SalePrice2[NextIndex]-CostPerUnit2[NextIndex]) * QuantityEachProduct2[NextIndex];
            //TotalCost2 += (CostPerUnit2[NextIndex] * QuantityEachProduct2[NextIndex]);
            //NextIndex2++;

        //}

        
        // Refer To https://stackoverflow.com/questions/8639115/java-and-decimals-e-numbers
        System.out.printf("\n\nTotal Of The Sale Price of Products minus the Total Cost of The Product times with the quantity RM%.2f", NetProfit);
        System.out.printf("\nTotal Cost is: RM%.2f\n",TotalCost);

        //System.out.println("\n______________________Laptop____________________________");
        //System.out.printf("\n\nTotal Of The Sale Price of Products minus the Total Cost of The Product times with the quantity RM%.2f", NetProfit2);
        //System.out.println("Total Cost is: " + TotalCost2);

        
        /*
            Next Task: WE'RE GOING WRITE THE RESULT INTO FILE IN ORDER TO DO BALANCE SHEET
        */
    }
    public static void Logistics(){
        System.out.println("Logistics First Page");

    }
    // Checking Numeric Method 
    // Refer https://java2blog.com/java-isnumeric/
    public static boolean isNumeric(String str) {
        return str != null && str.matches("[-+]?\\d*\\.?\\d+");
    }
    public static void CompoundInterest(){
        boolean Looping= true;
        Scanner Compound_Interest_Scanner = new Scanner(System.in);
        while(RepeatedForThree){
            System.out.println("\n\n1- Find Future Value");
            System.out.println("2- Find Present Value\n\n");

            //  
            System.out.println("9- Exit");
            try{
                int NumberForOperation = Compound_Interest_Scanner.nextInt();

                if(NumberForOperation == 1){
                    // FV = PV x (1 + i)^n 
                    // FV = P (1 + r/n) ^ nt 
                    
                    ClearScreen();
                    try{    
                        System.out.println("\n\nTHIS FORMULA IS ADOPT: FV = P (1+ r/n) ^nt\n ");
                        while(Looping){
                            System.out.println("Please Enter Your Present Value: ");
                            String PresentValue = Compound_Interest_Scanner.next();
                            if(isNumeric(PresentValue)){
                                Looping = false;
                            } else{
                                continue;
                            }

                        }   
                        Looping = true;   
                        while(Looping){
                            System.out.println("What is your annual interest rate? Such as 5");
                            String AnnualInterest = Compound_Interest_Scanner.next();
                            if(isNumeric(AnnualInterest)){
                                Looping = false;
                            } else{
                                continue;
                            }

                        }   
                        Looping = true;   
                        while(Looping){
                            System.out.println("How many times compounding for one year? Such as 1");
                            String CompoundTimes = Compound_Interest_Scanner.next();
                            if(isNumeric(CompoundTimes)){
                                Looping = false;
                            } else{
                                continue;
                            }

                        }   
                        Looping = true;  
                        while(Looping){          
                            System.out.println("How many times years? Such as 5");
                            String Total_YEAR = Compound_Interest_Scanner.next();
                            if(isNumeric(Total_YEAR)){
                                Looping = false;
                            } else{
                                continue;
                            }

                        }   
                        Looping = true;  
    
                        //Double FutureValue = PresentValue * Math.pow((1+((AnnualInterest/100)/CompoundTimes)),(Total_YEAR*CompoundTimes));
                    

                    }catch(Exception e){
                        System.out.println("You are not entering numbers");
                    }

                    CalculatorArt(7.0);
                } else if(NumberForOperation == 2){
                    ClearScreen();
                    CalculatorArt(7.0);

                }else if(NumberForOperation == 9){
                    ClearScreen();
                    CalculatorArt(7.0);
                    RepeatedForThree = false;

                } else{
                    System.out.println("Invalid Input");
                }

            }catch(Exception e){
                System.out.println("You Are Not Enter Numbers");
            }

        }
    }
    public static void Breakeven(){
        // Cost = Fixed Cost + (Quantity)(Variable Cost) 
        // Profit = (Sale Price)(Quantity)
        

    }
    public static void Currency_Convertor(){
        // Constant Variable 
        final Double USD_DOLLAR = 4.24;
        final Double SDG_DOLLAR = 3.12;
        final Double RMB_RM = 0.65;
        
        Scanner Currency_Input = new Scanner(System.in);
        while(RepeatedForThree){
            System.out.println("\n\nCurrency Convertor");
            System.out.println("1. RM TO RMB");
            System.out.println("2. RM TO SGD");
            System.out.println("3. RM TO USD");
            System.out.println("4. RMB TO RM");
            System.out.println("5. SGD TO RM");
            System.out.println("6. USD TO RM");
            System.out.println("");
            System.out.println("");
            System.out.println("9. Exit");
            System.out.println("Which Currency You Want To Convert? ");
            String CurrencyOption = Currency_Input.next();
            Double TargetCurrency = 0.0;
            if(CurrencyOption.equals("1")){
                System.out.println("________________________________________________________");
                System.out.println("1. RM TO RMB");
                System.out.println("Please Enter your amount: ");
                try{
                    String AmountCurrency = Currency_Input.next();
                    TargetCurrency = Integer.parseInt(AmountCurrency) / RMB_RM;
                    System.out.println("\n\nYou Can Get RMB:"+ TargetCurrency);
                }catch(Exception e){
                    System.out.println("\n\n\nYou Are Not Key In Numbers. Please Try Again\n\n\n");     
                }        

            }else if(CurrencyOption.equals("2")){
                System.out.println("________________________________________________________");
                System.out.println("2. RM TO SGD");
                System.out.println("\n\nPlease Enter your amount: ");
                try{
                    String AmountCurrency = Currency_Input.next();
                    TargetCurrency = Integer.parseInt(AmountCurrency) / SDG_DOLLAR;
                    System.out.println("\n\nYou Can Get SGD:"+ TargetCurrency);
                }catch(Exception e){
                    System.out.println("\n\n\nYou Are Not Key In Numbers. Please Try Again\n\n\n");     
                }
                 

            } else if(CurrencyOption.equals("3")){
                System.out.println("________________________________________________________");
                System.out.println("3. RM TO USD");
                System.out.println("Please Enter your amount: ");
                try{
                    String AmountCurrency = Currency_Input.next();
                    TargetCurrency = Integer.parseInt(AmountCurrency) / USD_DOLLAR;
                    System.out.println("\n\nYou Can Get USD:"+ TargetCurrency);
                }catch(Exception e){
                    System.out.println("\n\n\nYou Are Not Key In Numbers. Please Try Again\n\n\n");     
                }
                 

            }else if(CurrencyOption.equals("4")){
                System.out.println("________________________________________________________");
                System.out.println("4. RMB TO RM");
                System.out.println("Please Enter your amount: ");
                try{
                    String AmountCurrency = Currency_Input.next();
                    TargetCurrency = Integer.parseInt(AmountCurrency) * RMB_RM;
                    System.out.println("\n\nYou Can Get RM:"+ TargetCurrency);
                }catch(Exception e){
                    System.out.println("\n\n\nYou Are Not Key In Numbers. Please Try Again\n\n\n");     
                }

            }else if(CurrencyOption.equals("5")){
                System.out.println("________________________________________________________");
                System.out.println("5. SGD TO RM");
                System.out.println("Please Enter your amount: ");
                try{
                    String AmountCurrency = Currency_Input.next();
                    TargetCurrency = Integer.parseInt(AmountCurrency) * SDG_DOLLAR;
                    System.out.println("\n\nYou Can Get RM:"+ TargetCurrency);
                }catch(Exception e){
                    System.out.println("\n\n\nYou Are Not Key In Numbers. Please Try Again\n\n\n");     
                }


            } else if(CurrencyOption.equals("6")){
                System.out.println("________________________________________________________");
                System.out.println("6. USD TO RM");
                System.out.println("Please Enter your amount: ");
                try{
                    String AmountCurrency = Currency_Input.next();
                    TargetCurrency = Integer.parseInt(AmountCurrency) * USD_DOLLAR;
                    System.out.println("\n\nYou Can Get RM:"+ TargetCurrency);
                }catch(Exception e){
                    System.out.println("\n\n\nYou Are Not Key In Numbers. Please Try Again\n\n\n");     
                }


            }else if (CurrencyOption.equals("9")){
                System.out.println("Exit The Currency Convertor...");
                RepeatedForThree = false;

            }else {
                System.out.println("Invalid Input");
            }

        }



    }
    
    public static void Module_3_DistributionMethod(String input){

        switch(input){
            case "1":
                Logistics();
                break;
            case "2":
                CompoundInterest();
                break;
            case "3":
                Breakeven();
                break;
            case "4":
                Currency_Convertor();
                break;
            
            case "9":
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }
    }


    // SubMenu 3
    public static void Stock_Procurement(){
        RepeatedForThree = true;
        BadApple();
        // 1. LOGISTIC PARTNER ALL DETAILS
        // 2. Compound Interesting
        // 3. Breakeven Calculator
        // 4. Currency Convertor
        Scanner Function3Scanner = new Scanner(System.in);
        String SelectionToFunction = Function3Scanner.next();
        Module_3_DistributionMethod(SelectionToFunction);   
    }
    // Just trial
    public static void Module_4_DistributionMethod(String input2){
        switch(input2){
            case "1":
                ReadBalanceSheet();
                break;
            case "2":
                break;
            case "3":
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }
    }
    public static void BalanceSheet(){

        System.out.println("1- Read Balance Sheet");
        System.out.println("2- Edit Balance Sheet");
        System.out.println("3- Produce Balance Sheet into Txt File");
        System.out.println("\n9- Exit");
        Scanner Function4Scanner = new Scanner(System.in);
        String SelectionToFunction2 = Function4Scanner.next();
        Module_4_DistributionMethod(SelectionToFunction2);   
    }
    // Printing Function
    //https://www.geeksforgeeks.org/print-2-d-array-matrix-java/
    
    public static void print2D(String mat[][])
    {   int aligment = 30;
        int totalspace = 0;
        // Loop through all rows
        for (int i = 0; i < mat.length; i++){
             // Loop through all elements of current row
             for (int j = 0; j < mat[i].length; j++){
                System.out.print(mat[i][j]);
                totalspace = aligment - mat[i][j].length();
                for(int k=0; k< totalspace; k++){
                    System.out.print(" ");
                }
                
            }
            System.out.println("");

        }
 
           
    }

    public static void ReadBalanceSheet(){
        // Read File 
        String[] CURRENT_INFILE = ReadingFileIntoArray("CURRENT.txt");
        //System.out.println(Arrays.toString(CURRENT_INFILE));

        // Split Array Into Multidimensional Arrays
        int INPUT_FILE = 0;
        while(INPUT_FILE < CURRENT_INFILE.length) {
            String CURRENT_BALANCE_SHEET = CURRENT_INFILE[INPUT_FILE];
            // One Dimensional Array
            // WE GET EACH ROW FROM ARRAY FROM FILE
            String[] CURRENT_splitted= CURRENT_BALANCE_SHEET.split("\\s+");
            // INSERT EACH ROW's ELEMENT INTO NEW MULTIDIMENSIONAL ARRAY
            //String Price = splited[2].substring(8,splited[2].length());

            Current[INPUT_FILE][0] = CURRENT_splitted[0].substring(0,CURRENT_splitted[0].length());
            Current[INPUT_FILE][1] = CURRENT_splitted[1].substring(0,CURRENT_splitted[1].length());
            Current[INPUT_FILE][2] = CURRENT_splitted[2].substring(0,CURRENT_splitted[2].length());
            Current[INPUT_FILE][3] = CURRENT_splitted[3].substring(0,CURRENT_splitted[3].length());

            INPUT_FILE++;
        }

        // Read File 
        String[] NON_CURRENT_INFILE = ReadingFileIntoArray("NONCURRENT.txt");
        //System.out.println(Arrays.toString(CURRENT_INFILE));
  
        // Split Array Into Multidimensional Arrays
        int NON_INPUT_FILE = 0;
        while(NON_INPUT_FILE < CURRENT_INFILE.length) {
        String CURRENT_BALANCE_SHEET = CURRENT_INFILE[NON_INPUT_FILE];
        // One Dimensional Array
        // WE GET EACH ROW FROM ARRAY FROM FILE
        String[] NON_CURRENT_splitted= CURRENT_BALANCE_SHEET.split("\\s+");
        // INSERT EACH ROW's ELEMENT INTO NEW MULTIDIMENSIONAL ARRAY
        //String Price = splited[2].substring(8,splited[2].length());
  
        Non_Current[NON_INPUT_FILE][0] = NON_CURRENT_splitted[0].substring(0,NON_CURRENT_splitted[0].length());
        Non_Current[NON_INPUT_FILE][1] = NON_CURRENT_splitted[1].substring(0,NON_CURRENT_splitted[1].length());
        Non_Current[NON_INPUT_FILE][2] = NON_CURRENT_splitted[2].substring(0,NON_CURRENT_splitted[2].length());
        Non_Current[NON_INPUT_FILE][3] = NON_CURRENT_splitted[3].substring(0,NON_CURRENT_splitted[3].length());
  
        NON_INPUT_FILE++;
        }

        // EQUITY
        String[] EQUITY_INFILE = ReadingFileIntoArray("EQUITY.txt");
        //System.out.println(Arrays.toString(CURRENT_INFILE));
  
        // Split Array Into Multidimensional Arrays
        int EQUITY_FILE = 0;
        while(NON_INPUT_FILE < CURRENT_INFILE.length) {
        String CURRENT_BALANCE_SHEET = CURRENT_INFILE[NON_INPUT_FILE];
        // One Dimensional Array
        // WE GET EACH ROW FROM ARRAY FROM FILE
        String[] EQUITY_splitted= CURRENT_BALANCE_SHEET.split("\\s+");
        // INSERT EACH ROW's ELEMENT INTO NEW MULTIDIMENSIONAL ARRAY
        //String Price = splited[2].substring(8,splited[2].length());
  
        EQUITY[EQUITY_FILE][0] = EQUITY_splitted[0].substring(0,EQUITY_splitted[0].length());
        EQUITY[EQUITY_FILE][1] = EQUITY_splitted[1].substring(0,EQUITY_splitted[1].length());
        EQUITY[EQUITY_FILE][2] = EQUITY_splitted[2].substring(0,EQUITY_splitted[2].length());
        EQUITY[EQUITY_FILE][3] = EQUITY_splitted[3].substring(0,EQUITY_splitted[3].length());
  
        EQUITY_FILE++;
        }
  



        System.out.println("\n");

        System.out.println("__________Debit__________________________________________________________________Credit____________________________");
        System.out.println("Non-Current Assert              RM                                          Non-Current Liability              RM");
        System.out.println("___________________________________________________________________________________________________________________");
        print2D(Non_Current);

        //for(int ROW=0; ROW< 10; ROW++){
            //for(int COLUMN=0; COLUMN<10; COLUMN++){
                //System.out.print(Current[ROW][COLUMN]);
            //}
            //System.out.println("");
        //}
        System.out.println("__________________________________________________________________________________________________________________");
        System.out.println("Current Assert                  RM                                              Current Liability              RM");
        System.out.println("___________________________________________________________________________________________________________________");
        print2D(Current);


        System.out.println("__________________________________________________________________________________________________________________");
        System.out.println("                                RM                                                EQUITY                       RM");
        System.out.println("___________________________________________________________________________________________________________________");
        System.out.println("\n\n___________________________________________________________________________________________________________________");
        System.out.println("                                                                                                                    ");
        System.out.println("___________________________________________________________________________________________________________________");


    }




    // Main Function
    public static void main(String args[]){
        Scanner UserInput = new Scanner(System.in);
        // It will be repeated until The UserInput Method Set Repeated Error
        while(Repeated){
            // Redeclare Make Sure Sub Menu Repeated Again
            SubMenuRepeated = true;
            // Display Menu
            Menu();
            // Error Handling For String Input
            try{
            String ReadInputFromUser_String = UserInput.next();
            int ReadInputFromUser_Integer = Integer.parseInt(ReadInputFromUser_String);
            UserInput(ReadInputFromUser_Integer);
            } catch (Exception e) {
                ClearScreen();
                System.out.println("Invalid Input");
            }

        }
        UserInput.close();

    }
    
}
