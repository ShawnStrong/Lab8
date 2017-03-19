import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.ListUI;
import javax.swing.plaf.basic.BasicListUI;

import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;


public class Buttons extends JFrame{
  public static void main(String[] args) {
    
   JLabel l;
   //BasicListUI ui = new BasicListUI();
   //ui.installUI();
    final JTextField t1;
    final JTextField t2;
    final JTextField t3;
    final JTextField t4;
    JButton b1;
    JButton b2;	
    JButton b3;
    JButton b4;	  
    JFrame f = new JFrame("Lab 8");
    //should make exit button work
    f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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

    cp.add(t1 = new JTextField(35), c);
    t1.setFocusAccelerator('n');
    c.gridx = 1;
    c.gridy = GridBagConstraints.RELATIVE;
    cp.add(t2 = new JTextField(35), c);
    t2.setFocusAccelerator('h');
    cp.add(t3 = new JTextField(35), c);
    t3.setFocusAccelerator('c');
    cp.add(t4 = new JTextField(35), c);
    t4.setFocusAccelerator('s');
    
    c.weightx = 0.0;
    c.fill = GridBagConstraints.NONE;
  	c.anchor = GridBagConstraints.PAGE_END;
   	c.gridwidth = 2;
   	c.gridx = 0;
   	c.gridy = 4;
    cp.add(b1 = new JButton("Sumbit"), c);
    b1.setMnemonic('s');
    c.gridwidth = 2;
   	c.gridx = 4;
   	c.gridy = 4;
    cp.add(b2 = new JButton("Exit"), c);
    b2.setMnemonic('e');
	  c.gridwidth = 2;
   	c.gridx = 1;
   	c.gridy = 4;
    cp.add(b3 = new JButton("Print"), c);
    b1.setMnemonic('p');
    c.gridwidth = 2;
   	c.gridx = 2;
   	c.gridy = 4;
    cp.add(b4 = new JButton("Clear"), c);
    b4.setMnemonic('c');	  
    
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
    
    DefaultListModel<String> model = new DefaultListModel<String>();
    model.ensureCapacity(6);
    model.addElement("Mr.");
    model.addElement("Ms.");
    model.addElement("Mrs.");
    model.addElement("Dr.");
    model.addElement("Col.");
    model.addElement("Prof.");
    
    c.anchor = GridBagConstraints.FIRST_LINE_START;

    JList<String> m = new JList<String>(model);
   
    //m.setUI(ui);
    //m.setLocation(10, 40);
    m.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    JScrollPane list = new JScrollPane(m);
    f.add(list,c);
    
    //b1 is the submit button
    
    b1.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e)
    	{
    		//JOptionPane.showMessageDialog(null, "worked!");
    		//make a setter method in employee that will recive the data from t1-4
    		//and set the values of employee, t1 = first.....t4 = phone
    		DirectoryProxy s = new DirectoryProxy();
    		boolean[] Rbuttons = {option1.isSelected(), option2.isSelected(), option3.isSelected()};
    		boolean[] Lists = { m.isSelectedIndex(0),m.isSelectedIndex(1),m.isSelectedIndex(2),m.isSelectedIndex(3),m.isSelectedIndex(4),m.isSelectedIndex(5)};
    		s.add(new Employee(t1.getText(),t2.getText(),t3.getText(),t4.getText(),Rbuttons,Lists));
    		t1.setText("");
    		t2.setText("");
    		t3.setText("");
    		t4.setText("");
    		//JOptionPane.
    	}
    });    
    b2.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e)
    	{
    		//JOptionPane.showMessageDialog(null, "worked!");
    		 f.dispose();
    	}
    });    
    b3.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e)
    	{
    		//JOptionPane.showMessageDialog(null, "worked!");
    		DirectoryProxy s = new DirectoryProxy();
    		s.print();
    	}
    });  
    b4.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e)
    	{
    		//JOptionPane.showMessageDialog(null, "worked!");
    		DirectoryProxy s = new DirectoryProxy();
    		s.clear();
    	}
    }); 
    
  //Can't seem to get the list to work properly with formatting of the JFrame
  
  
    
}
  }
