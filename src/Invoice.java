public class Invoice {
    protected String partNumber;
    protected String partDescription;
    protected int quality;
    protected double pricePerItem;

    public Invoice(String partNumber, String partDescription, int quality, double pricePerItem) {
    this.partNumber = partNumber;
    this.partDescription = partDescription;
    this.quality = quality;
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
        this.quality = quality;
    }
    public int getQuality() {
        return quality;
    }

    //--------------------------------------------------------------------------------------
    public void setPricePerItem(double pricePerItem) {
        this.pricePerItem = pricePerItem;
    }
    public double getPricePerItem() {
        return pricePerItem;
    }
    //--------------------------------------------------------------------------------------
}