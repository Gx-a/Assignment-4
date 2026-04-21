/*  Akein Bantin #2401011023
    Zhane Tomlin #2401010939
    Chevar Prince #
    Ryan Brown #
    Georgia Black Golding #1817002195
*/
import java.io.Serializable;

public interface Payable extends Serializable {

    public double getPaymentAmount();
    public void writeToFile();

}
