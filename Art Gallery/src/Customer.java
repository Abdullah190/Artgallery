import java.util.Scanner;

public class Customer {

    private String customer_id;
    private String name;
    private String address;
    private long phone;
    private String creditCardNum;

   //Constructors.

    public Customer()
    {
        customer_id=" ";
        name=" ";
        address=" ";
        phone=0;
        creditCardNum=" ";
    }

    public Customer(String id1,String name1,String address1,long phone1,String creditcard1)
    {
        customer_id=id1;
        name=name1;
        address=address1;
        phone=phone1;
        creditCardNum=creditcard1;
    }


    //setters

    public void setCustomer_id(String id1)
    {
        customer_id=id1;
    }

    public void setNameC(String name1)
    {
        name=name1;
    }

    public void setAddress(String address1)
    {
        address=address1;
    }

    public void setPhone(long phone1)
    {
        phone=phone1;
    }

    public void setCreditCardNum(String creditCardNum1)
    {
        creditCardNum=creditCardNum1;
    }


    //getters

    public String getCustomer_id()
    {
        return customer_id;
    }

    public String getNameC()
    {
        return name;
    }

    public String getAddress()
    {
        return address;
    }

    public long getPhone()
    {
        return phone;
    }

    public String getCreditCardNum() {
        return creditCardNum;
    }




}

