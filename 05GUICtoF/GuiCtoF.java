import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuiCtoF extends JFrame implements ActionListener{
    private Container pane;
    private JButton convert;
    private JLabel c,f;
    private JTextField ct,ft;
    private JRadioButton ctf, ftc;
    private Container containerf;
    private Container containerc;
    private Container containerbt;
    private JCheckBox x;

    public GuiCtoF() {
	this.setTitle("My first GUI");
	this.setSize(300,100);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);	

	pane = this.getContentPane();
	pane.setLayout(new GridLayout(2,1));
	
	c = new JLabel("C: ",null,JLabel.CENTER);
	f = new JLabel("F: ",null,JLabel.CENTER);
	ct = new JTextField(10);
	ft = new JTextField(10);
	ctf = new JRadioButton("Celcius to F");
	ctf.setActionCommand("ctf");
	ctf.setSelected(true);
	ctf.addActionListener(this);
	ftc = new JRadioButton("Fahrenheit to C");
	ftc.setActionCommand("ftc");
	ftc.addActionListener(this);
	convert = new JButton("Convert");
	convert.setActionCommand("ctf2");
	convert.addActionListener(this);

	ButtonGroup btg = new ButtonGroup();
	btg.add(ctf);
	btg.add(ftc);

	containerf = new Container();
	containerf.setLayout(new FlowLayout());
	containerf.add(f);
	containerf.add(ft);

	containerc = new Container();
	containerc.setLayout(new FlowLayout());
	containerc.add(c);
	containerc.add(ct);

	containerbt = new Container();
	containerbt.setLayout(new GridLayout(0,1));
	containerbt.add(ctf);
	containerbt.add(ftc);

	pane.add(containerc);
	pane.add(containerf);
	pane.add(containerbt);
	pane.add(convert);
    }

    public void actionPerformed(ActionEvent e){
	if (e.getActionCommand().equals("ctf")){
	    convert.setActionCommand("ctf2");
	} else if (e.getActionCommand().equals("ftc")){
	    convert.setActionCommand("ftc2");
	} else if (e.getActionCommand().equals("ctf2")){
	    ft.setText(Double.toString(Double.parseDouble(ct.getText())*1.8+32));
	} else if (e.getActionCommand().equals("ftc2")){
	    ct.setText(Double.toString((Double.parseDouble(ft.getText())-32)/1.8));
	}
	
    }

    public static void main(String[] args) {
	GuiCtoF window = new GuiCtoF();
	window.setVisible(true);
    }
}
