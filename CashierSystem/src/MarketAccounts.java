import discount.AbstractDiscount;

/**
 * @author : kongyy
 * @time : 2020/5/20 20:42
 */
public class MarketAccounts {

    private double price;

    private AbstractDiscount discount;

    public void setPrice(double price){
        this.price = price;
    }

    public void setDiscount(AbstractDiscount discount){
        this.discount = discount;
    }

    public double calculate(int num){
        return discount.calculate(price, num);
    }
}
