import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultListModel;


public class Employee extends JFrame{
  public static void main(String[] args) {
    
    JLabel l;
    JTextField t;
    JButton b;
    JFrame f = new JFrame("Lab 8");
    Container cp = f.getContentPane();
    cp.setLayout(new GridBagLayout());
    cp.setBackground(UIManager.getColor("control"));
    GridBagConstraints c = new GridBagConstraints();
    
    

    c.gridx = 0;
    c.gridy = GridBagConstraints.RELATIVE;
    c.gridwidth = 1;
    c.gridheight = 1;
    c.insets = new Insets(2, 2, 2, 2);
    c.anchor = GridBagConstraints.EAST;

    cp.add(l = new JLabel("First Name:", SwingConstants.RIGHT), c);
    l.setDisplayedMnemonic('n');
    cp.add(l = new JLabel("Last Name:", SwingConstants.RIGHT), c);
    l.setDisplayedMnemonic('h');
    cp.add(l = new JLabel("Department Number:", SwingConstants.RIGHT), c);
    l.setDisplayedMnemonic('d');
    cp.add(l = new JLabel("Phone Number:", SwingConstants.RIGHT), c);
    l.setDisplayedMnemonic('p');


    c.gridx = 1;
    c.gridy = 0;
    c.weightx = 1.0;
    c.fill = GridBagConstraints.HORIZONTAL;
    c.anchor = GridBagConstraints.CENTER;

    cp.add(t = new JTextField(35), c);
    t.setFocusAccelerator('n');
    c.gridx = 1;
    c.gridy = GridBagConstraints.RELATIVE;
    cp.add(t = new JTextField(35), c);
    t.setFocusAccelerator('h');
    cp.add(t = new JTextField(35), c);
    t.setFocusAccelerator('c');
    cp.add(t = new JTextField(35), c);
    t.setFocusAccelerator('s');
    
    c.weightx = 0.0;
    c.fill = GridBagConstraints.NONE;
  	c.anchor = GridBagConstraints.PAGE_END;
   	c.gridwidth = 2;
   	c.gridx = 0;
   	c.gridy = 4;
    cp.add(b = new JButton("Sumbit"), c);
    b.setMnemonic('s');
    c.gridwidth = 2;
   	c.gridx = 1;
   	c.gridy = 4;
    cp.add(b = new JButton("Exit"), c);
    b.setMnemonic('e');
    
    f.pack();
    f.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent evt) {
        System.exit(0);
      }
    });
    f.setVisible(true);
    
    JRadioButton option1 = new JRadioButton("Male");
    JRadioButton option2 = new JRadioButton("Female");
    JRadioButton option3 = new JRadioButton("Other");

    ButtonGroup group = new ButtonGroup();
    group.add(option1);
    group.add(option2);
    group.add(option3);


    cp.add(option1);
    cp.add(option2);
    cp.add(option3);
    
    
  //Can't seem to get the list to wirk properly with formatting of the JFrame
//  DefaultListModel<String> model = new DefaultListModel<String>();
//  model.ensureCapacity(6);
//  model.addElement("Mr.");
//  model.addElement("Ms.");
//  model.addElement("Mrs.");
//  model.addElement("Dr.");
//  model.addElement("Col.");
//  model.addElement("Prof.");
//  
//  c.anchor = GridBagConstraints.FIRST_LINE_START;
//
//  
//  
//
//
//  JList<String> m = new JList<String>(model);
//  m.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//  JScrollPane list = new JScrollPane(m);
//  f.add(list,c);
    
}
  }



