package java8;

import java.util.function.Function;

public class FuntionDemos {



  static  <R> R execute(Function<String, R> funtion){
       String s = "test";
       return funtion.apply(s);
   }

    public static void main(String[] args) {
        System.out.println((String) execute((s)-> s + "3"));
    }
}
