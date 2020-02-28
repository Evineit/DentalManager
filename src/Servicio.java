import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Servicio implements Serializable {
    private String name;
    private Double price;

    public Servicio(String name, Double price) {
        this.name = name;
        this.price = round(price,2);
    }
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    @Override
    public String toString() {
        return name + " - "+price +" $";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
