
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentIDFormViewer {

    public static void main (String args[]) {
    StudentFormFrame gui = new StudentFormFrame();
    gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    gui.setSize(600,800);
    gui.setVisible(true);
    gui.pack();
    gui.setTitle("Student ID Form Viewer");
  }

}