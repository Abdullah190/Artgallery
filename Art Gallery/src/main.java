import java.util.Formatter;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class main {

    //attributes that are required for functionalities
    static Scanner jin = new Scanner(System.in);
    static Formatter output = null;


    static ArrayList<Painting> paintings = null;
    static ArrayList<Artist> artists = null;
    static ArrayList<Customer> customers = null;
    static ArrayList<Transactions> transactions = null;
    static ArrayList<CreditCard> creditCards = null;


    // MAIN
    public static void main(String[] args) {
        int choice;
        System.out.println("Enter \n 1-Login as user. \n 2-Login as customer. \n 3-register new customer. \n 4-exit program.");
        Scanner scan = new Scanner(System.in);
        choice = scan.nextInt();
        switch (choice) {
            case 1: {
                String password = " ";
                System.out.println("Input password:");
                password = scan.next();

                File file = new File("C:\\Users\\w\\IdeaProjects\\Art Gallery\\src\\OwnerPassword.txt");
                Scanner fromFile = null;
                try {
                    fromFile = new Scanner(file);
                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                String mPswd = fromFile.next();
                fromFile.close();
                String reverse = new StringBuffer(mPswd).reverse().toString();
                if (password.equals(reverse)) {
                    try {
                        owner(reverse);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else
                    System.out.println("Log in Failed");
                break;


            }
            case 2: {

                String password = "";
                String cID = "";
                System.out.println("Enter Customer's ID  :");
                cID = jin.next();
                System.out.println("Enter Password   :");
                password = jin.next();
                try {
                    if ((Funs.matchCustomer(cID, password)) == true) {
                        customer(cID, password);
                    } else {
                        System.out.println("\nLog In Failed");
                    }
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                break;

            }
            case 3: {
                try {
                    createCustomer();
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            case 4: {
                System.out.println("Exiting.");
                break;
            }
            default: {
                System.out.println("Invalid input");
            }
        }
    }


    static void owner(String oldPassword) throws IOException {
        int Ochoice = 0;
        paintings = new ArrayList<Painting>();
        artists = new ArrayList<Artist>();
        transactions = new ArrayList<Transactions>();
        customers = new ArrayList<Customer>();
        paintings = Funs.getPaintingFromFile(paintings);
        artists = Funs.getArtistsFromFile(artists);
        transactions = Funs.getTransactionsFromFile(transactions);
        customers = Funs.getCustomerFile(customers);
        while (Ochoice != 6) {

            System.out.println("Enter \n 1-View All paintings \n 2-View Artist info \n 3-Add painting. \n");
            System.out.println("4-View Transactions \n 5- Change password \n 6-Logout");
            Ochoice = jin.nextInt();
            switch (Ochoice)
            {
                case 1: {
                    String aname = "";
                    for (Painting p : paintings) {
                        System.out.println("Painting name " + p.getP_name());
                        System.out.println("\nPainting Style" + p.getStyle());
                        System.out.println("\nPainting Price " + p.getCostprice());
                        for (Artist a : artists) {
                            if (p.getArtist_id2().equals(a.getArtist_id1())) {
                                aname = a.getNameA();
                                break;
                            }
                        }
                        System.out.println("\nArtist Name " + aname + "\n\n");
                    }
                    break;
                }
                case 2: {
                    String artistNamii = " ";
                    System.out.println("Enter Artist Name :");
                    artistNamii = jin.next();
                    boolean flag = false;
                    boolean flag2 = false;
                    for (Artist a : artists) {
                        if (a.getNameA().equals(artistNamii)) {
                            System.out.println("\nArtist Name : " + a.getNameA());
                            System.out.println("\nArtist Country : " + a.getCountry());
                            System.out.println("\nArtist Expertise : " + a.getExpertise());
                            for (Painting p : paintings) {
                                if (p.getArtist_id2().equals(a.getArtist_id1())) {
                                    flag2 = true;
                                    System.out.println("\nPainting Name : " + p.getP_name());
                                }
                                flag = true;
                            }
                        }
                    }
                    if (flag == false) {
                        System.out.println("\n No Artist Found ");
                    }
                    if (flag2 == false)
                        System.out.println("\nNo painting found");
                    break;
                }
                case 3: {
                    //output = new Formatter("Paintings.txt");
                    String aname;
                    boolean flag = false;
                    Painting newpainting = new Painting();

                    System.out.println("\nEnter Painting Name : ");
                    jin.nextLine();
                    newpainting.setP_name(jin.nextLine());
                    System.out.println("\nEnter Painting Style : ");
                    newpainting.setStyle(jin.nextLine());
                    System.out.println("\nEnter Artist's Name  : ");
                    aname = jin.nextLine();
                    System.out.println("\nEnter Painting's Cost Price : ");
                    newpainting.setCostprice(jin.nextInt());
                    newpainting.setStatus("Unsold");

                    System.out.println("\nNew Painting id Alloted with ");
                    //setting new painting id
                    newpainting.setPainting_id("P" + (paintings.size()));
                    System.out.println(newpainting.getPainting_id());

                    for (Artist a : artists) {
                        if (a.getNameA().equals(aname)) {
                            newpainting.setArtist_idP(a.getArtist_id1());
                            System.out.println("Artist has been found \n");
                            newpainting.setArtist_idP(a.getArtist_id1());
                            paintings.add(newpainting);
                            flag = true;
                            break;
                        }

                    }
                    if (flag == false) {
                        System.out.println("\nNo Artist Found in the record");
                        System.out.println("\nEnter info");
                        Artist newartist = new Artist();
                        System.out.println("\nEnter Artist Name : ");
                        jin.nextLine();
                        newartist.setNameA(jin.nextLine());
                        System.out.println("\nEnter Artist's Country : ");
                        newartist.setCountry(jin.nextLine());
                        System.out.println("\nEnter Artist's Expertise  : ");
                        newartist.setExpertise(jin.nextLine());
                        artists.add(newartist);


                        // also write to file
                        System.out.println("\nNew Artist id Alloted with ");
                        //setting new Artist id
                        newartist.setArtist_idA("A" + (artists.size() - 1));
                        newpainting.setArtist_idP(newartist.getArtist_id1());
                        System.out.println(newartist.getArtist_id1());
                        artists.add(newartist);
                        //also write to file
                        Funs.writeArtistToFile(newartist);
                    }
                    paintings.add(newpainting);
                    //also write to file
                    Funs.writePaintingToFile(newpainting);
                    break;
                }

                case 4: {
                    for (Transactions t : transactions) {
                        for (Customer c : customers) {
                            if (c.getCustomer_id().equals(t.getCustomerId())) {
                                System.out.println("\nCustomer's name " + c.getNameC());
                            }
                        }
                        for (Painting p : paintings) {
                            if (p.getPainting_id().equals(t.getPaintingId())) {
                                System.out.println("\nPainting's Name " + p.getP_name());
                            }
                        }
                    }
                    break;
                }
                case 5: {
                    String cpass = "";
                    cpass = Funs.UpdatePassword(oldPassword);

                    output = new Formatter("OwnerPassword.txt");
                    String reverse = new StringBuffer(cpass).reverse().toString();
                    output.format(reverse);
                    output.close();
                    System.out.println("Password has been Successfully updated");
                    break;
                }

            }
            clearScreen();
        }
        paintings.clear();
        artists.clear();
        customers.clear();
        transactions.clear();
    }


    static void customer(String thisCustomerID, String currentPassword) throws IOException {
        System.out.println("Customer Menu");
        paintings = new ArrayList<Painting>();
        customers = new ArrayList<Customer>();
        artists = new ArrayList<Artist>();
        transactions = new ArrayList<Transactions>();
        creditCards = new ArrayList<CreditCard>();
        creditCards = Funs.getCreditCardsFromFile(creditCards);

        paintings = Funs.getPaintingFromFile(paintings);
        customers = Funs.getCustomerFile(customers);
        artists = Funs.getArtistsFromFile(artists);
        transactions = Funs.getTransactionsFromFile(transactions);
        int Cchoice = 0;
        while (Cchoice != 6) {
            System.out.println("Enter \n 1-ViewAllPaintings. \n 2-View paintings by price" +
                    "\n 3- Buy paintinig \n 4-View Transactions \n 5-Change password. \n 6-Logout.");
            Cchoice = jin.nextInt();

            switch (Cchoice) {
                case 1: {
                    for (Painting p : paintings) {
                        if (p.getStatus().equals("Unsold")) {
                            for (Artist a : artists) {
                                if (a.getArtist_id1().equals(p.getArtist_id2())) {
                                    System.out.println("Painting Id  " + p.getPainting_id());
                                    System.out.println("Painting Name " + p.getP_name());
                                    System.out.println("Painting Style " + p.getStyle());
                                    System.out.println("Painting Cost Price " + p.getCostprice());
                                    System.out.println("Artist's Name " + a.getNameA() + "\n");

                                }
                            }
                        }
                    }
                    break;
                }
                case 2: {
                    double cPrice = 0.0;
                    System.out.println("Enter Cost Price");
                    cPrice = jin.nextDouble();
                    for (Painting p : paintings) {
                        if (p.getStatus().equals("Unsold") && p.getCostprice() <= cPrice) {
                            for (Artist a : artists) {
                                if (a.getArtist_id1().equals(p.getArtist_id2())) {
                                    System.out.println("Painting Id  " + p.getPainting_id());
                                    System.out.println("Painting Name " + p.getP_name());
                                    System.out.println("Painting Style " + p.getStyle());
                                    System.out.println("Painting Cost Price " + p.getCostprice());
                                    System.out.println("Artist's Name " + a.getNameA() + "\n");
                                }
                            }
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.println("\nEnter Painting ID");
                    String pid = jin.next();
                    boolean flag = false;
                    double sellingPrice = 0.0;
                    for (Painting p : paintings) {
                        if (p.getPainting_id().equals(pid)) {
                            System.out.println(p.getStatus());
                            sellingPrice = ((p.getCostprice() * (20 / 100)) + p.getCostprice());
                            for (Customer c : customers) {
                                if (c.getCustomer_id().equals(thisCustomerID)) {

                                    for (CreditCard card : creditCards) {

                                        if (card.getCreditcardNum().equals(c.getCreditCardNum())) {

                                            if (card.getBalance() >= sellingPrice) {
                                                int index = creditCards.indexOf(card);
                                                //setting balance in record
                                                card.setBalance(card.getBalance() - sellingPrice);
                                                creditCards.set(index, card);
                                                //creating transaction
                                                Transactions t = new Transactions();
                                                t.setCustomerId(thisCustomerID);
                                                t.setPaintingId(pid);
                                                t.setSellingPrice(sellingPrice);
                                                transactions.add(t);
                                                //also write to file
                                                Funs.writeTransactionsToFile(t);
                                                Funs.updateCreditCardsToFile(creditCards);
                                                int index2 = paintings.indexOf(p);
                                                p.setStatus("Sold");
                                                paintings.set(index2, p);
                                                Funs.updatePaintingsToFile(paintings);
                                                System.out.println("Painting is bought successfully ");
                                                flag = true;

                                            } else
                                                System.out.println("\nThere is no enough balance in CCard,Undable to buy");
                                        }
                                        if (flag == true)
                                            break;
                                    }
                                }
                                if (flag == true)
                                    break;
                            }
                        }
                    }
                    break;
                }

                case 4: {
                    boolean flag = false;
                    for (Transactions tr : transactions) {
                        for (Painting p : paintings) {
                            if (tr.getCustomerId().equals(thisCustomerID) && tr.getPaintingId().equals(p.getPainting_id())) {
                                System.out.println("Painting Name  " + p.getP_name());
                                System.out.println("Selling Price  " + tr.getSellingPrice() + "\n");
                                flag = true;
                            }
                        }
                    }
                    if (flag == false)
                        System.out.println("Unfortunately No Transaction Found For Customer" + thisCustomerID);
                    break;
                }
                case 5: {
                    String newPassword = Funs.UpdatePassword(currentPassword);

                    try {
                        Funs.updateCustomerPassword(thisCustomerID, newPassword);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println("\nPassword Successfully changed");
                    //Also Update the Password in File,Customer Log In .txt
                    break;
                }
            }

        }
    }


    static void createCustomer() throws FileNotFoundException {
        String name = "";
        boolean flag = true;
        String logInName = "";
        customers = new ArrayList<Customer>();
        creditCards = new ArrayList<CreditCard>();
        customers = Funs.getCustomerFile(customers);
        creditCards = Funs.getCreditCardsFromFile(creditCards);

        Customer temp = new Customer();
        CreditCard tCard = new CreditCard();
        System.out.println("\nEnter Customer's Name");
        name = jin.next();
        System.out.println("\nEnter Log In Name");
        logInName = jin.next();
        for (Customer c : customers) {
            if (c.getNameC().equals(name)) {

                flag = false;
            }
        }
        if (flag == true && Funs.checkValidation(logInName)) {
            temp.setNameC(name);
            System.out.println("Enter Address  ");
            temp.setAddress(jin.next());
            System.out.println("Enter Phone Number ");
            temp.setPhone(jin.nextLong());
            System.out.println("Enter Credit Card Number");
            tCard.setCreditcardNum(jin.next());
            String password = "";
            System.out.println("Enter password of length 8 or 6  ");
            flag = false;
            while (!flag) {
                password = jin.next();
                if (password.length() >= 6 && password.length() <= 8 && password.length() != 7) {

                    flag = true;
                } else
                    System.out.println("invalid size ,Enter password again,");
            }
            temp.setCustomer_id("C" + (customers.size() ));
            System.out.println("Unique Id Generated for new Customer is " + temp.getCustomer_id());
            System.out.println("\nEnter Credit Card Amount");
            double amount = 0.0;
            while (amount < 100 || amount > 10000) {
                amount = jin.nextDouble();
                System.out.println("Enter within range 100 - 10000) ");
            }
            tCard.setBalance(amount);
            temp.setCreditCardNum(tCard.getCreditcardNum());
            creditCards.add(tCard);
            //credit card to file
            try {
                Funs.writeCreditCardToFile(tCard);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            customers.add(temp);
            //writing customer to file
            try {
                Funs.writeCustomerToFile(temp);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //writing name,loginname,password to customerlogins.txt file
            try {
                Funs.writeCLogIn(temp.getCustomer_id(), logInName, password);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("Customer has been registered successfully");
        } else {
            System.out.println("\nName or log in name is not unique");
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}




