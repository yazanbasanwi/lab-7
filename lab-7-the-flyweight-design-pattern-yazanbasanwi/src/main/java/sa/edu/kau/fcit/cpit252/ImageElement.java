package sa.edu.kau.fcit.cpit252;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

import javax.swing.ImageIcon;

public class ImageElement {

    private String name;

    public ImageElement(String name) {
        this.name = name;
    }

    public String myPosition(int position) {
        return "" + position + " " + this.name + ": " + this;
    }

    public ImageIcon getImageElement() throws FileNotFoundException {
        String imagePAth = File.separator + "images" + File.separator + this.name;
        URL imageURL = ImageElement.class.getResource(imagePAth); // This works on Linux
        if(imageURL == null){ // This works on Windows
            imageURL = ImageElement.class.getClassLoader().getResource(imagePAth);
        }
        ImageIcon imageIcon = new ImageIcon(imageURL);
        if (imageIcon.getImageLoadStatus() != MediaTracker.COMPLETE) {
            throw new FileNotFoundException(String.format("Failed to load image file %s", imageURL.getFile()));
        }
        return imageIcon;
    }
}
