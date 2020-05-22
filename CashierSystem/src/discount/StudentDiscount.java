package discount;

/**
 * @author : kongyy
 * @time : 2020/5/20 19:54
 */
public class StudentDiscount extends AbstractDiscount{
    @Override
    public double calculate(double price, int num){
        price = price*num;
        double nowPrice = 0.0;
        if(price >= 100){
            double x = price/100;
            int y = (int)x;
            nowPrice = price - y*10;
        }
        else{
            nowPrice = price;
        }
        return nowPrice;
    }
}
