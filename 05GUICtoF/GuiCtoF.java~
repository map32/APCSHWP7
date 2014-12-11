import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuiCtoF extends JFrame implements ActionListener{
    private Container pane;
    private JButton convert;
    private JLabel c,f;
    private JTextField ct,ft;
    private Container containerf;
    private Container containerc;
    private JCheckBox x;

    public GuiCtoF() {
	this.setTitle("My first GUI");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);	

	pane = this.getContentPane();
	pane.setLayout(new GridLayout(2,1));
	
	c = new JLabel("C: ",null,JLabel.CENTER);
	f = new JLabel("F: ",null,JLabel.CENTER);
	ct = new JTextField(10);
	ft = new JTextField(10);
	convert = new JButton("Convert");

	containerf = new Container();
	containerf.setLayout(new FlowLayout());
	containerf.add(f);
	containerf.add(ft);

	containerc = new Container();
	containerc.setLayout(new FlowLayout());
	containerc.add(c);
	containerc.add(ct);

	pane.add(containerc);
	pane.add(containerf);
	pane.add(convert);
    }

    public void actionPerformed(ActionEvent e){
    }

    public static void main(String[] args) {
	GuiCtoF window = new GuiCtoF();
	window.setVisible(true);
    }
}