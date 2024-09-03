package search;

public class NewTon {

    //使用牛顿迭代法求平方根的近似值
    public static double sqrt(double a) {
        double error = 1e-15;
        double cur = a;
        while (Math.abs(cur * cur - a) > error) {
            cur = (cur + a / cur) / 2;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(2d));
    }
}
