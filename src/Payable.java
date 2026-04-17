import java.io.Serializable;

public interface Payable extends Serializable {

    public double getPaymentAmount();
    public void writeToFile();

}
