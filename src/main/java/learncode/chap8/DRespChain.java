package learncode.chap8;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * @Description 责任链模式
 * @Author YC
 * @Date 2019/9/1 22:56
 * @Version 1.0
 */
public class DRespChain {

    public static void main(String[] args) {
        HeaderTextProcessing p1 = new HeaderTextProcessing();
        SpellCheckerProcessing p2 = new SpellCheckerProcessing();
        p1.setSuccessor(p2);
        String result = p1.handle("Aren't labdas really sexy?!!");
        System.out.println(result);

        UnaryOperator<String> headerProcessing = (String text) -> "From Raoul,Mario and Alan: " + text;
        UnaryOperator<String> spellCheckerProcessing = (String text) -> text.replaceAll("labda", "lambda");

        Function<String, String> pipeline = headerProcessing.andThen(spellCheckerProcessing);
        System.out.println(pipeline.apply("Aren't labdas really sexy?!!"));
    }
}
