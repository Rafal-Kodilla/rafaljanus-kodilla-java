package com.kodilla.testing.shape;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by RJanus on 05.08.2017.
 */
public class ShapeCollectorTestSuite {

    @Test
    public void testAddShape(){
        ShapeCollector testCollection = new ShapeCollector();
        Shape testShape = new Triangle("Triangle",10,5);

        testCollection.addShape(testShape);
        String resultName = testCollection.shapes.get(0).getShapeName();
        double resultField = testCollection.shapes.get(0).getField();

        Assert.assertEquals(1,testCollection.shapes.size());
        Assert.assertEquals("Triangle",resultName);
        Assert.assertEquals(25,resultField,0.001);
    }

    @Test
    public void testRemoveShape(){
        ShapeCollector testCollection = new ShapeCollector();
        Shape testShape1 = new Circle("Circle",10.5);
        testCollection.addShape(testShape1);
        Shape testShape2 = new Square("Square",10.5);
        testCollection.addShape(testShape2);

        testCollection.removeShape(testShape2);
        Assert.assertEquals(1,testCollection.shapes.size());

        testCollection.removeShape(testShape2);
        Assert.assertEquals(1,testCollection.shapes.size());
   }

   @Test
   public void testGetFigure(){
       ShapeCollector testCollection = new ShapeCollector();
       Shape testShape = new Square("Square",8);
       testCollection.addShape(testShape);

       Assert.assertEquals(64,testCollection.getShapeFromList(0).getField(),0.0001);
       Assert.assertEquals("Square",testCollection.getShapeFromList(0).getShapeName());

   }

   @Test
    public void testPrintWholeList(){
       ShapeCollector testCollection = new ShapeCollector();
       testCollection.addShape(new Square("Square",8));
       testCollection.addShape(new Circle("Circle",4));

       String expected = "Shape: Square. Field: 64.0.\n";
       expected = expected + "Shape: Circle. Field: 50.24.";

       String result = testCollection.printWholeList();

       Assert.assertEquals(expected,result);

   }
}