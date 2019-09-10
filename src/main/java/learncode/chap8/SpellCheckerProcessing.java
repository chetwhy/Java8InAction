package learncode.chap8;

/**
 * @Description TODO
 * @Author YC
 * @Date 2019/9/1 22:55
 * @Version 1.0
 */
public class SpellCheckerProcessing extends ProcessingObject<String> {
    @Override
    protected String handleWork(String input) {
        return input.replaceAll("labda", "lambda");
    }
}
