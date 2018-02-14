public class CreditCard {

    private String creditcardNum;
    private double balance;

    public CreditCard()
    {
        creditcardNum=" ";
        balance=0;
    }

    public CreditCard(String creditcardNum1,double balance1)
    {
        creditcardNum=creditcardNum1;
        balance=balance1;
    }


    //getters
    public double getBalance() {
        return balance;
    }

    public String getCreditcardNum() {
        return creditcardNum;
    }


    //setters


    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCreditcardNum(String creditcardNum) {
        this.creditcardNum = creditcardNum;
    }
}
