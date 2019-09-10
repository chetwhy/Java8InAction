package test.learncode.chap8; 

import learncode.chap8.Point;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.Arrays;
import java.util.List;

/** 
* ProductFactory Tester. 
* 
* @author <Authors name> 
* @since <pre>九月 5, 2019</pre> 
* @version 1.0 
*/ 
public class ProductFactoryTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: createProduct(String name) 
* 
*/ 
@Test
public void testCreateProduct() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: main(String[] args) 
* 
*/ 
@Test
public void testMain() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: createProduce(String name) 
* 
*/ 
@Test
public void testCreateProduce() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: moveAllPointsRightBy(List<Point> points, int x) 
* 
*/ 
@Test
public void testMoveAllPointsRightBy() throws Exception {
    List<Point> points = Arrays.asList(new Point(5, 5), new Point(10, 5));
    List<Point> expectedPoints = Arrays.asList(new Point(15, 5), new Point(20, 5));
    List<Point> newPoints = Point.moveAllPointsRightBy(points, 10);
    Assert.assertEquals(expectedPoints, newPoints);
} 


} 
