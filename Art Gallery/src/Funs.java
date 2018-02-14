
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;






public class Funs {





        private static File pFile = null;
        private static Scanner from = null;
        private static BufferedWriter bw = null;
        private static FileWriter fw = null;
        private static ArrayList<String> cid = null;
        private static ArrayList<String> password = null;
        private static ArrayList<String> meta = null;
        private static Formatter output = null;
        //this function will check validation of loginName in registering new customer
        static boolean checkValidation(String loginName) throws FileNotFoundException{
            meta = new ArrayList<String>();
            pFile = new File("C:\\Users\\w\\IdeaProjects\\untitled\\src\\CustomerLogins.txt");
            from = new Scanner(pFile);
            from.useDelimiter(",");
            while(from.hasNext()){
                from.next();
                if(from.next().equals(loginName)){
                    return false;
                }
                from.next();
                from.nextLine();
            }
            from.close();
            return true;

        }
        //this function will update customer password in the file customerLogins.txt
        static void updateCustomerPassword(String Cid,String Password) throws IOException{
            password = new ArrayList<String>();
            cid = new ArrayList<String>();
            meta = new ArrayList<String>();


            pFile = new File("CustomerLogins.txt");
            from = new Scanner(pFile);
            from.useDelimiter(",");
            while(from.hasNext()){
                cid.add(from.next());
                meta.add(from.next());
                password.add(from.next());
                from.nextLine();
            }
            for(String id : cid){
                if(id.equals(Cid)){
                    int index = cid.indexOf(id);
                    password.set(index, Password);
                }
            }
            from.close();
            //write updation to file

            pFile = new File("CustomerLogins.txt");
            output = new Formatter(pFile);
            for(int i=0;i< cid.size();++i){
                output.format("\n%s,%s,%s,",cid.get(i),meta.get(i),password.get(i));
            }

            output.close();
            password.clear();
            cid.clear();
            meta.clear();

        }
        //this function will match the customer from the file
        static boolean matchCustomer(String id,String password) throws FileNotFoundException{
            ArrayList<String> cID = new ArrayList<String>();
            ArrayList<String> cpassword = new ArrayList<String>();
            pFile = new File("C:\\Users\\w\\IdeaProjects\\Art Gallery\\src\\CustomerLogins.txt");
            from = new Scanner(pFile);
            from.useDelimiter(",");
            while(from.hasNextLine()){
                cID.add(from.next());
                from.next();
                cpassword.add(from.next());
                from.nextLine();
            }


            for(int i=0;i<cID.size();++i){

                if((cID.get(i).equals(id) )&& (cpassword.get(i).equals(password)))
                {
                    return true;
                }
            }
            return false;
        }
        //this function prepares the array list of credit cards from  CreditCards.txt and return populatted array list
        static ArrayList<CreditCard> getCreditCardsFromFile(ArrayList<CreditCard> creditCards) throws FileNotFoundException{
            pFile= new File("C:\\Users\\w\\IdeaProjects\\Art Gallery\\src\\CreditCards.txt");
            from= new Scanner(pFile);
            from.useDelimiter(",");
            while(from.hasNext()){
                CreditCard card = new CreditCard(from.next(),from.nextDouble());
                creditCards.add(card);
                from.nextLine();
            }
            return creditCards;
        }
        //this function prepares the array list of transaction from transactions.txt and return populatted array list
        static ArrayList<Transactions> getTransactionsFromFile(ArrayList<Transactions> transactions) throws FileNotFoundException{

            pFile = new File("C:\\Users\\w\\IdeaProjects\\Art Gallery\\src\\Transactions.txt");
            from = new Scanner(pFile);

            from.useDelimiter(",");
            while(from.hasNext()){
                Transactions tr = new Transactions();
                tr.setPaintingId((from.next()));
                tr.setCustomerId(from.next());
                tr.setSellingPrice(from.nextDouble());
                transactions.add(tr);
                from.nextLine();

            }
            from.close();

            return transactions;
        }
        //this function prepares the array list of artists from  artists.txt and return populatted array list
        static ArrayList<Artist> getArtistsFromFile(ArrayList<Artist> artists)throws FileNotFoundException
        {
            pFile = new File("C:\\Users\\w\\IdeaProjects\\Art Gallery\\src\\Artists.txt");
            from = new Scanner(pFile);

            from.useDelimiter(",");
            while(from.hasNext())
            {
                Artist artist = new Artist();
                artist.setArtist_idA(from.next());
                artist.setNameA(from.next());
                artist.setCountry(from.next());
                artist.setExpertise(from.next());

                artists.add(artist);
                from.nextLine();
            }
            from.close();

            return artists;
        }
        //this function prepares the array list of customer from  customers.txt and return populatted array list
        static  ArrayList<Customer>getCustomerFile(ArrayList<Customer> customers) throws FileNotFoundException
        {
            pFile = new File("C:\\Users\\w\\IdeaProjects\\Art Gallery\\src\\Customers.txt");
             from = new Scanner(pFile);

            from.useDelimiter(",");
            while(from.hasNextLine())
            {
                Customer cdata = new Customer();
                cdata.setCustomer_id(from.next());
                cdata.setNameC(from.next());
                cdata.setAddress(from.next());
                cdata.setPhone(from.nextLong());
                cdata.setCreditCardNum(from.next());
                customers.add(cdata);


              from.nextLine();
            }

            from.close();
            return customers;

        }
        //this function prepares the array list of paintings from  Paintings.txt and return populatted array list
        static ArrayList<Painting> getPaintingFromFile(ArrayList<Painting> paintings) throws FileNotFoundException
        {

            //reading painting
            pFile = new File("C:\\Users\\w\\IdeaProjects\\Art Gallery\\src\\Paintings.txt");
            from = new Scanner(pFile);
            from.useDelimiter(",");
            Painting p =null;
            while(from.hasNextLine())
            {

                 p=new Painting();
                p.setPainting_id(from.next());
                p.setP_name(from.next());
                p.setStyle(from.next());
                p.setArtist_idP(from.next());
                p.setCostprice(from.nextInt());
                p.setStatus(from.next());
                paintings.add(p);
                from.nextLine();
            }
            from.close();
                //System.out.println(pain);
            return paintings;
        }

        //this function will write the painting object into the Paintings.txt file
        static void writePaintingToFile(Painting p) throws IOException{
            pFile = new File("C:\\Users\\w\\IdeaProjects\\Art Gallery\\src\\Paintings.txt");
            fw = new FileWriter(pFile,true);
            bw = new BufferedWriter(fw);
            bw.write(p.toString());
            bw.close();
            fw.close();
        }
        //this function will write the transaction object into the transactions.txt file
        static void writeTransactionsToFile(Transactions t) throws IOException{
            pFile = new File("C:\\Users\\w\\IdeaProjects\\Art Gallery\\src\\Transactions.txt");
            fw = new FileWriter(pFile,true);
            bw = new BufferedWriter(fw);
            bw.write("\n" +t.toString());
            bw.close();
            fw.close();
        }
        //this function will write the artist object into the artists.txt file
        static void writeArtistToFile(Artist a)throws IOException{
            pFile = new File("C:\\Users\\w\\IdeaProjects\\Art Gallery\\src\\Artists.txt");
            fw = new FileWriter(pFile,true);
            bw = new BufferedWriter(fw);
            bw.write( a.toString());
            bw.close();
            fw.close();
        }
        //this function will write creditcard object to creditcard.txt file
        static void writeCreditCardToFile(CreditCard creditCard) throws IOException{
            pFile = new File("C:\\Users\\w\\IdeaProjects\\Art Gallery\\src\\CreditCards.txt");
            fw = new FileWriter(pFile,true);
            bw = new BufferedWriter(fw);
            bw.write( creditCard.toString());
            bw.close();
            fw.close();
        }
        //this function will write customer object to Customers.txt file
        static void writeCustomerToFile(Customer temp) throws IOException{
            pFile = new File("C:\\Users\\w\\IdeaProjects\\Art Gallery\\src\\Customers.txt");
            fw = new FileWriter(pFile,true);
            bw = new BufferedWriter(fw);
            String cus = temp.toString();
            bw.write(cus);
            bw.close();
            fw.close();
        }

        //this function will update the password on taking new password and matchiing
        static String UpdatePassword(String oldPassword){
            String cpass="";
            Scanner jin = new Scanner(System.in);
            boolean flag = false;
            System.out.println("\nEnter the Current password");
            while(!flag){
                cpass=jin.next();
                if(cpass.equals(oldPassword)){
                    System.out.println("\nPassword Matches");
                    flag = true;
                }else{
                    System.out.println("\nPassword is not matched, try again");
                }
            }
            if(flag == true){
                System.out.println("\nEnter the new password");
                cpass = jin.next();
                System.out.println("\nConfirm Password");
                while(!cpass.equals(jin.next())){
                    System.out.println("\n Not matched,Try Again");
                }
            }
            jin.close();
            return cpass;
        }
        //this function will update the painting file with the arraylist of painting
        static void updatePaintingsToFile(ArrayList<Painting> paintings) throws IOException{
            pFile = new File("Paintings.txt");
            fw = new FileWriter(pFile);
            bw = new BufferedWriter(fw);
            for(Painting p: paintings){
                bw.write(p.toString());
            }
            bw.close();
            fw.close();

        }
        //this function will update the creditcard file with the arraylist of creditcards
        static void updateCreditCardsToFile(ArrayList<CreditCard> creditCards) throws IOException{
            pFile = new File("C:\\Users\\w\\IdeaProjects\\Art Gallery\\src\\CreditCards.txt");
            fw = new FileWriter(pFile);
            bw = new BufferedWriter(fw);
            for(CreditCard c:creditCards){
                bw.write("\n");
                bw.write(c.toString());
            }
            bw.close();
            fw.close();
        }
        //this function will write Log In info of the customer object in cutomerLogins.txt
        static void writeCLogIn(String id,String logInName,String password) throws IOException{
            pFile = new File("C:\\Users\\w\\IdeaProjects\\Art Gallery\\src\\customerLogins.txt");
            fw = new FileWriter(pFile,true);
            bw = new BufferedWriter(fw);
            //bw.newLine();
            bw.write( "\n"+id+ "," + logInName +","+ password +",");

            bw.close();
            fw.close();
        }




}
