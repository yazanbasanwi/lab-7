package sa.edu.kau.fcit.cpit252;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


public class Lab7Test {


    @Test
    public void testImageElementsFactory(){
        ImageElementsFactory factory = new ImageElementsFactory();
        ImageElement e = factory.getFlyweight("Tree");
        assertNotNull(e);
        assertEquals(1, factory.numberOfFlyweights());
        factory.getFlyweight("Tree");
        assertEquals(1, factory.numberOfFlyweights());
    }

    @Test
    public void testImageElement(){
        ImageIcon treeIcon = assertDoesNotThrow(() -> new ImageElement("Tree.png").getImageElement());
        assertNotNull(treeIcon);
        assertNotNull(treeIcon.getImage());
        assertThrows(Exception.class, () -> new ImageElement("WrongImageFile.png").getImageElement());
    }

    /* Should create four ImageElement objects of different locations  1000 times
     *  but create only four objects
     */
    @Test
    public void testFlyweight(){
        String[] elements = new String[]{"Tree", "Palm", "Cloud", "Flower"};
        ImageElementsFactory factory = new ImageElementsFactory();

        List<ImageElement> elementList = new ArrayList<>();
        assertEquals(0, factory.numberOfFlyweights());

        Random r = new Random();
        for (int i = 0; i < 10000; i++) {
            String name = elements[r.nextInt(elements.length)] + ".png";
            ImageElement e = factory.getFlyweight(name);
            elementList.add(e);
        }
        assertEquals(4, factory.numberOfFlyweights());
    }
}