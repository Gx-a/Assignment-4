/*  Akein Bantin #2401011023
    Zhane Tomlin #2401010939
    Chevar Prince #
    Ryan Brown #
    Georgia Black Golding #1817002195
*/
import java.io.*;

public class Invoice implements Payable, Serializable{
    protected String partNumber;
    protected String partDescription;
    protected int quantity;
    protected double pricePerItem;

    public Invoice(String partNumber, String partDescription, int quality, double pricePerItem) {
    this.partNumber = partNumber;
    this.partDescription = partDescription;
    this.quantity = quality;
    this.pricePerItem = pricePerItem;
    }

    //--------------------------------------------------------------------------------------
    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }
    public String getPartNumber() {
        return partNumber;
    }

    //--------------------------------------------------------------------------------------
    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }
    public String getPartDescription() {
        return partDescription;
    }

    //---------------------------------------------------------------------------------------
    public void setQuality(int quality) {
        this.quantity = quality;
    }
    public int getQuality() {
        return quantity;
    }

    //--------------------------------------------------------------------------------------
    public void setPricePerItem(double pricePerItem) {
        this.pricePerItem = pricePerItem;
    }
    public double getPricePerItem() {
        return pricePerItem;
    }
    //--------------------------------------------------------------------------------------


    @Override
    public double getPaymentAmount() {
        return pricePerItem * quantity;
    }


    @Override
    public void writeToFile()
    {
        try(PrintWriter out = new PrintWriter( new FileWriter("Invoice.txt", true))){
            out.println("PartNumber: " + partNumber + "\n" + "Part Description: " + partDescription + "\n"
                    + "Quantity: " + quantity + "\n" + "Price: " + pricePerItem + "\n" +
                    "Total: " + getPaymentAmount() + "\n" + "-----------------------------" + "\n");

        }
        catch(IOException e){
            System.out.println("Error writing to file");
        }
    }
}