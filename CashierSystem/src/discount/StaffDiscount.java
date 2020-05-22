package discount;

/**
 * @author : kongyy
 * @time : 2020/5/20 19:50
 */
public class StaffDiscount extends AbstractDiscount{

    @Override
    public double calculate(double price, int num){
        double nowPrice = price * 0.8 * num;
        return nowPrice;
    }
}
