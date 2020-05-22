package discount;

/**
 * @author : kongyy
 * @time : 2020/5/20 19:55
 */
public class VIPDiscount extends AbstractDiscount{

    @Override
    public double calculate(double price, int num){
        double nowPrice = price*0.6*num;
        return nowPrice;
    }
}
