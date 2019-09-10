package test.learncode.chap8;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import learncode.chap8.Point;

import java.util.Comparator;

/**
 * Point Tester.
 * 
 * @author <Authors name>
 * @since
 * 
 *        <pre>
 * 九月 3, 2019
 *        </pre>
 * 
 * @version 1.0
 */
public class PointTest {

    @Before
    public void before() throws Exception {}

    @After
    public void after() throws Exception {}

    /**
     * 
     * Method: getX()
     * 
     */
    @Test
    public void testGetX() throws Exception {
        // TODO: Test goes here...
    }

    /**
     * 
     * Method: getY()
     * 
     */
    @Test
    public void testGetY() throws Exception {
        // TODO: Test goes here...
    }

    /**
     * 
     * Method: moveRight(int x)
     * 
     */
    @Test
    public void testMoveRight() throws Exception {
        Point p1 = new Point(5, 5);
        Point p2 = p1.moveRight(10);

        Assert.assertEquals(15, p2.getX());
        Assert.assertEquals(5, p2.getY());
    }

    @Test
    public void test01() {
        Point p1 = new Point(10, 15);
        Point p2 = new Point(10, 20);
        int result = Point.compareByXAndThenY.compare(p1, p2);
        Assert.assertEquals(-1, result);
    }
}
