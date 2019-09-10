package learncode.chap9.cthree;

/**
 * @Description TODO
 * @Author YC
 * @Date 2019/9/10 0:00
 * @Version 1.0
 */
public interface Rotatable {

    void setRotationAngle(int angleDegrees);

    int getRotationAngle();

    default void rotateBy(int angleInDegrees) {
        setRotationAngle((getRotationAngle() + angleInDegrees) % 360);
    }
}
