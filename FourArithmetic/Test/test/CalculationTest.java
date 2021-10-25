package test;

import junit.framework.TestCase;
import org.junit.Test;
import pairing.Calculation;

import static org.junit.Assert.*;

public class CalculationTest {

    @Test
    public void toHouzhui() {
        String zhongzhui1 = "4+3*5-(6+1)";
        Calculation c1 = new Calculation();
        String houzhui1 = c1.toHouzhui(zhongzhui1);
        System.out.println(houzhui1);

        String zhongzhui2 = "(4+3)*5-(6+1)";
        Calculation c2 = new Calculation();
        String houzhui2 = c2.toHouzhui(zhongzhui2);
        System.out.println(houzhui2);


        String zhongzhui3 = "(4+3*5)-1/6";
        Calculation c3 = new Calculation();
        String houzhui3 = c2.toHouzhui(zhongzhui3);
        System.out.println(houzhui3);

    }


    @Test
    public void cal() throws Exception {

        Calculation c = new Calculation();
        //测试通过后缀表达式 通过弹出栈顶结果的三个用例
        //1.
        String zhongzhui1 = "4+3*5-(6+1)";
        Calculation c1 = new Calculation();
        String houzhui1 = c1.toHouzhui(zhongzhui1);
        String ans1 = c1.cal(houzhui1);
        System.out.println(ans1);

        //2.
        String zhongzhui2 = "(4+3)*5-(6+1)";
        Calculation c2 = new Calculation();
        String houzhui2 = c2.toHouzhui(zhongzhui2);
        String ans2 = c2.cal(houzhui2);
        System.out.println(ans2);

        //3.
        String zhongzhui3 = "(4+3*5)-1/6";
        Calculation c3 = new Calculation();
        String houzhui3 = c2.toHouzhui(zhongzhui3);
        String ans3 = c3.cal(houzhui3);
        System.out.println(ans3);


    }

    @Test
    public void calculate() throws Exception {
        Calculation c = new Calculation();

        //测试整数与分数之间的加减乘除
        String result1 = c.calculate("1/3", "8", "+");
        System.out.println(result1);

        //测试分数与分数之间的加减乘除
        String result2 = c.calculate("5/8","7/9","÷");
        System.out.println(result2);

        //带分数与整数之间的加减乘除
        String result3 = c.calculate("1'4/7","7","+");
        System.out.println(result3);

        //测试带分数与真分数之间的加减乘除
        String result4 = c.calculate("2'5/9","4/7","*");
        System.out.println(result4);

        //测试带分数与带分数之间的加减乘除
        String result5 = c.calculate("1'1/2","5/6","÷");
        System.out.println(result5);
    }
}