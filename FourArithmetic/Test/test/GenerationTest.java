package test;

import junit.framework.TestCase;
import org.junit.Test;
import pairing.Generation;

import static org.junit.Assert.*;

public class GenerationTest {

    @Test
    public void generateExp() {
        // 测试随机生成完整表达式
        for (int i = 1; i <= 10; i++) {
            Generation generation = new Generation();
            System.out.println(generation.GenerateExp(10));
        }
    }

    @Test
    public void generateNum() {
    }

    @Test
    public void fraction() {

        //1.
        Generation g1 = new Generation();
        // 测试对生成表达式的结果进行约分
        System.out.println(g1.Fraction(4, 8));
/*        //2.
        System.out.println(g1.Fraction(5, 75));

        //3.
        System.out.println(g1.Fraction(3, 18));*/
        // 假分数转真分数处理
        System.out.println(g1.Fraction(8, 3));

/*        //2.
        System.out.println(g1.Fraction(9,2));

        //3.
        System.out.println(g1.Fraction(18, 5));*/

    }

    @Test
    public void generateOperator() {
    }
}