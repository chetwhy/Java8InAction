package learncode.chap9.aone;

import lambdasinaction.chap9.Drawable;

/**
 * @Description TODO
 * @Author YC
 * @Date 2019/9/8 23:47
 * @Version 1.0
 */
public interface Resizable extends Drawable {

    int getWidth();

    int getHeight();

    void setWidth(int width);

    void setHeight(int height);

    void setAbsoluteSize(int width, int height);
}
