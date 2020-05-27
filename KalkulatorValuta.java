package projekt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;

public class KalkulatorValuta extends JFrame {

	private JPanel contentPane;
	private JTextField unos;
	private JTextField rezultat;
	double prvi=0,drugi=0;
	private static DecimalFormat df = new DecimalFormat("0.00");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KalkulatorValuta frame = new KalkulatorValuta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public KalkulatorValuta() {
		super("Kalkulator Valuta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JComboBox prvaValuta = new JComboBox();
		prvaValuta.setFont(new Font("Tahoma", Font.BOLD, 13));
		prvaValuta.setBounds(54, 34, 136, 44);
		prvaValuta.addItem("Kuna");
		prvaValuta.addItem("Euro");
		prvaValuta.addItem("Dolar");
		prvaValuta.addItem("Funta");
		contentPane.add(prvaValuta);
		
		JComboBox drugaValuta = new JComboBox();
		drugaValuta.setFont(new Font("Tahoma", Font.BOLD, 13));
		drugaValuta.setBounds(233, 34, 136, 44);
		drugaValuta.addItem("Euro");
		drugaValuta.addItem("Kuna");
		drugaValuta.addItem("Dolar");
		drugaValuta.addItem("Funta");
		contentPane.add(drugaValuta);
		
		unos = new JTextField();
		unos.setFont(new Font("Tahoma", Font.BOLD, 13));
		unos.setBounds(54, 115, 136, 37);
		contentPane.add(unos);
		unos.setColumns(10);
		
		rezultat = new JTextField();
		rezultat.setFont(new Font("Tahoma", Font.BOLD, 13));
		rezultat.setBounds(233, 115, 136, 37);
		contentPane.add(rezultat);
		rezultat.setColumns(10);
		
		
		
		JButton btnIzracunaj = new JButton("Izracunaj");
		btnIzracunaj.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnIzracunaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnIzracunaj) {
					String s=(String) drugaValuta.getSelectedItem();
					if(prvaValuta.getSelectedItem()=="Kuna") {
						IzKune(s);
					}
					if(prvaValuta.getSelectedItem()=="Euro") {
						IzEura(s);
					}
					if(prvaValuta.getSelectedItem()=="Dolar") {
						IzDolara(s);
					}
					if(prvaValuta.getSelectedItem()=="Funta") {
						IzFunte(s);
					}
				}
			}
		});
		btnIzracunaj.setBounds(157, 184, 97, 25);
		contentPane.add(btnIzracunaj);
		
		JButton btnZatvori = new JButton("Zatvori");
		btnZatvori.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int zatvori=JOptionPane.showConfirmDialog(null,"Jeste li sigurni da želite zatvoriti?","Zatvori",JOptionPane.YES_NO_OPTION);
				if(zatvori==JOptionPane.YES_OPTION) {
					dispose();
				}
				else {
					zatvori=JOptionPane.NO_OPTION;
				}
			}
		});
		btnZatvori.setBounds(323, 215, 97, 25);
		contentPane.add(btnZatvori);
		
		JLabel lblPretvoriIz = new JLabel("Pretvori iz");
		lblPretvoriIz.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPretvoriIz.setBounds(54, 13, 104, 16);
		lblPretvoriIz.setForeground(Color.RED);
		contentPane.add(lblPretvoriIz);
		
		JLabel lblPretvoriU = new JLabel("Pretvori u");
		lblPretvoriU.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPretvoriU.setBounds(235, 13, 81, 16);
		lblPretvoriU.setForeground(Color.GREEN);
		contentPane.add(lblPretvoriU);
		

		
	}
	public void IzKune(String s) {
		if(s=="Euro") {
			prvi=Double.parseDouble(unos.getText());
			drugi=(prvi*0.13);
			rezultat.setText(""+df.format(drugi));
		}
		if(s=="Dolar") {
			prvi=Double.parseDouble(unos.getText());
			drugi=(prvi*0.15);
			rezultat.setText(""+df.format(drugi));
		}
		if(s=="Kuna") {
			prvi=Double.parseDouble(unos.getText());
			drugi=prvi;
			rezultat.setText(""+df.format(drugi));
		}
		if(s=="Funta") {
			prvi=Double.parseDouble(unos.getText());
			drugi=(prvi*0.11);
			rezultat.setText(""+df.format(drugi));
		}
	}		
	
	public void IzEura(String s) {
		if(s=="Kuna") {
			prvi=Double.parseDouble(unos.getText());
			drugi=(prvi*7.52);
			rezultat.setText(""+df.format(drugi));
		}
		if(s=="Dolar") {
			prvi=Double.parseDouble(unos.getText());
			drugi=(prvi*1.13);
			rezultat.setText(""+df.format(drugi));
		}
		if(s=="Funta") {
			prvi=Double.parseDouble(unos.getText());
			drugi=(prvi*0.86);
			rezultat.setText(""+df.format(drugi));
		}
		if(s=="Euro") {
			prvi=Double.parseDouble(unos.getText());
			drugi=prvi;
			rezultat.setText(""+df.format(drugi));
		}
	}

	public void IzDolara(String s) {
		if(s=="Kuna") {
			prvi=Double.parseDouble(unos.getText());
			drugi=(prvi*6.66);
			rezultat.setText(""+df.format(drugi));
		}
		if(s=="Euro") {
			prvi=Double.parseDouble(unos.getText());
			drugi=(prvi*0.89);
			rezultat.setText(""+df.format(drugi));
		}
		if(s=="Dolar") {
			prvi=Double.parseDouble(unos.getText());
			drugi=prvi;
			rezultat.setText(""+df.format(drugi));	
		}
		if(s=="Funta") {
			prvi=Double.parseDouble(unos.getText());
			drugi=(prvi*1.30);
			rezultat.setText(""+df.format(drugi));
		}
	}
	public void IzFunte(String s) {
		if(s=="Kuna") {
			prvi=Double.parseDouble(unos.getText());
			drugi=(prvi*8.69);
			rezultat.setText(""+df.format(drugi));
		}
		if(s=="Euro") {
			prvi=Double.parseDouble(unos.getText());
			drugi=(prvi*1.16);
			rezultat.setText(""+df.format(drugi));
		}
		if(s=="Dolar") {
			prvi=Double.parseDouble(unos.getText());
			drugi=(prvi*1.30);
			rezultat.setText(""+df.format(drugi));
		}
		if(s=="Funta") {
			prvi=Double.parseDouble(unos.getText());
			drugi=prvi;
			rezultat.setText(""+df.format(drugi));	
		}
	}
}

