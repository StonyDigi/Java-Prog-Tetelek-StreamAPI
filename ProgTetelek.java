package progTetelekStreamApi;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ProgTetelek {

	private JFrame frameProgTetelek;
	private JButton btnVeletlenSzamokGeneralasa;
	private JButton btnOsszeg;
	private JButton btnAtlag;
	private JButton btnLegkisebbElem;
	private JButton btnLegnagyobbElem;
	private JButton btnRendezNovekvo;
	private JButton btnRendezCsokkeno;
	private JButton btnHarommalOszthatoSzamok;
	@SuppressWarnings("rawtypes")
	private JList listUiVelSzamok;
	private JButton btnExit;
	List<Integer> velSzamokLista = new ArrayList<Integer>();
	DefaultListModel<Integer> listModel; // JList, Combobox, JTable-h�z kell a modell, jobb vele
	private JTextField tfSzamokIntervallum;
	private JTextField tfSzamokMerete;
	private JLabel lblSzamokIntervallum;
	private JLabel lblSzamokMerete;
	private JButton btnUj;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnHatvanyoz;
	private JTextField tfHatvanyEredmeny;
	private JButton btnReset;
	private JScrollBar scrollBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProgTetelek window = new ProgTetelek();
					window.frameProgTetelek.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProgTetelek() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("rawtypes")
	private void initialize() {
		frameProgTetelek = new JFrame();
		frameProgTetelek.setTitle("Prog t\u00E9telek - Stream API");
		frameProgTetelek.setBounds(100, 100, 869, 693);
		frameProgTetelek.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameProgTetelek.getContentPane().setLayout(null);
		
		listUiVelSzamok = new JList();
		listUiVelSzamok.setBounds(10, 18, 87, 602);
		frameProgTetelek.getContentPane().add(listUiVelSzamok);
		
		btnVeletlenSzamokGeneralasa = new JButton("V\u00E9letlen sz\u00E1mok gener\u00E1l\u00E1sa");
		btnVeletlenSzamokGeneralasa.setBounds(229, 106, 411, 31);
		btnVeletlenSzamokGeneralasa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVeletlenSzamokGeneralasa.setBackground(SystemColor.inactiveCaption);
		btnVeletlenSzamokGeneralasa.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnVeletlenSzamokGeneralasa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//1.l�p�s. adatszerk. felt�lt�se (ArrayList) �s az ui. komponens (Jlist) felt�lt�se
				listaFeltolt();
				//2.l�p�s. gombok enged�lyez�se/tilt�sa, hogy nyomhat�k legyenek a gombok
				btnVeletlenSzamokGeneralasa.setEnabled(false);
				btnOsszeg.setEnabled(true);
				btnAtlag.setEnabled(true);
				btnLegkisebbElem.setEnabled(true);
				btnLegnagyobbElem.setEnabled(true);
				btnRendezCsokkeno.setEnabled(true);
				btnRendezNovekvo.setEnabled(true);
				btnHarommalOszthatoSzamok.setEnabled(true);	
			}
		});
		frameProgTetelek.getContentPane().add(btnVeletlenSzamokGeneralasa);
		
		btnOsszeg = new JButton("\u00D6sszeg");
		btnOsszeg.setBounds(142, 164, 148, 31);
		btnOsszeg.setEnabled(false);
		btnOsszeg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String eredmeny = listaOsszegMeghataroz(velSzamokLista) + ""; //+"" sz�vegg� alak�t�s
				JOptionPane.showMessageDialog(frameProgTetelek, "A lista �sszege: "+eredmeny, "�sszeg", JOptionPane.PLAIN_MESSAGE);
			}
		});
		frameProgTetelek.getContentPane().add(btnOsszeg);
		
		btnAtlag = new JButton("\u00C1tlag");
		btnAtlag.setBounds(119, 222, 381, 31);
		btnAtlag.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAtlag.setEnabled(false);
		btnAtlag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAtlag.setText("�tlag �rt�ke: "+listaAtlagMeghataroz(velSzamokLista).getAsDouble());
				
			}
		});
		frameProgTetelek.getContentPane().add(btnAtlag);
		
		btnLegkisebbElem = new JButton("Legkisebb \u00E9rt\u00E9k\u0171 elem/index");
		btnLegkisebbElem.setBounds(119, 339, 360, 31);
		btnLegkisebbElem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String eredmeny = listaLegkisebbErtekMeghataroz(velSzamokLista) + ", index:" +
				velSzamokLista.indexOf(listaLegkisebbErtekMeghataroz(velSzamokLista)); //+"" sz�vegg� alak�t�s
				JOptionPane.showMessageDialog(frameProgTetelek,
						"Legkisebb �rt�k/index:"+eredmeny,
						"Legkisebb �rt�k, index",
						JOptionPane.PLAIN_MESSAGE);
				
				
			}
		});
		btnLegkisebbElem.setEnabled(false);
		frameProgTetelek.getContentPane().add(btnLegkisebbElem);
		
		btnLegnagyobbElem = new JButton("Legnagyobb \u00E9rt\u00E9k\u0171 elem/index");
		btnLegnagyobbElem.setBounds(119, 394, 360, 31);
		btnLegnagyobbElem.setEnabled(false);
		btnLegnagyobbElem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String eredmeny = listaLegNagyobbErtekMeghataroz(velSzamokLista) +", index" +
			velSzamokLista.indexOf(listaLegNagyobbErtekMeghataroz(velSzamokLista));
				JOptionPane.showMessageDialog(frameProgTetelek,
						"Legnagyobb �rt�k� elem/index:"+eredmeny,
						"Legnagyobb �rt�k� elem, index",
						JOptionPane.PLAIN_MESSAGE);
				
			}

		
		});
		btnLegnagyobbElem.setEnabled(false);
		frameProgTetelek.getContentPane().add(btnLegnagyobbElem);
		
		
		
		btnRendezNovekvo = new JButton("Rendez n\u00F6vekv\u0151");
		btnRendezNovekvo.setBounds(533, 180, 298, 31);
		btnRendezNovekvo.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				rendezNovekvo(velSzamokLista);//1. itt berendezt�k a list�t
				listModel = new DefaultListModel<Integer>();//2. itt l�trehoztuk a list modelt
				for(Integer item : velSzamokLista) {//3. itt felt�ltj�k a rendezett list�t a modelbe
					listModel.addElement(item);
				}
				listUiVelSzamok.setModel(listModel);//4. �s v�g�l hozz�adtuk az Ui komponenshez
			
			}
		});
		btnRendezNovekvo.setEnabled(false);
		frameProgTetelek.getContentPane().add(btnRendezNovekvo);
		
		btnRendezCsokkeno = new JButton("Rendez cs\u00F6kken\u0151");
		btnRendezCsokkeno.setBounds(533, 218, 298, 31);
		btnRendezCsokkeno.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				RendezCsokkeno(velSzamokLista);
				listModel = new DefaultListModel<Integer>();
				for(Integer item : velSzamokLista) {
					listModel.addElement(item);
				}
				listUiVelSzamok.setModel(listModel);
			}
		});
		btnRendezCsokkeno.setEnabled(false);
		frameProgTetelek.getContentPane().add(btnRendezCsokkeno);
		
		btnHarommalOszthatoSzamok = new JButton("H\u00E1rommal oszthat\u00F3 sz\u00E1mok db");
		btnHarommalOszthatoSzamok.setBounds(395, 271, 436, 31);
		btnHarommalOszthatoSzamok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String eredmeny = listaHarommalOszthatoakDarabSzamaMeghataroz(velSzamokLista) + ""; //+"" sz�vegg� alak�t�s
				JOptionPane.showMessageDialog(frameProgTetelek,
						"A h�rommal oszthat�ak:"+eredmeny+ " db",
						"H�rommal oszthat�ak",
						JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnHarommalOszthatoSzamok.setEnabled(false);
		frameProgTetelek.getContentPane().add(btnHarommalOszthatoSzamok);
		
		btnExit = new JButton("KIL\u00C9P");
		btnExit.setBounds(716, 537, 115, 75);
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(Color.RED);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		frameProgTetelek.getContentPane().add(btnExit);
		
		lblSzamokIntervallum = new JLabel("Adja meg a sz\u00E1mok intervallum\u00E1t(t\u00F3l-ig):");
		lblSzamokIntervallum.setBounds(142, 10, 275, 31);
		lblSzamokIntervallum.setFont(new Font("Tahoma", Font.BOLD, 12));
		frameProgTetelek.getContentPane().add(lblSzamokIntervallum);
		
		tfSzamokIntervallum = new JTextField();
		tfSzamokIntervallum.setBounds(441, 16, 86, 20);
		tfSzamokIntervallum.setBackground(Color.WHITE);
		tfSzamokIntervallum.setHorizontalAlignment(SwingConstants.CENTER);
		frameProgTetelek.getContentPane().add(tfSzamokIntervallum);
		tfSzamokIntervallum.setColumns(10);
		
		lblSzamokMerete = new JLabel("Adja meg a sz\u00E1mok lista m\u00E9ret\u00E9t:");
		lblSzamokMerete.setBounds(175, 52, 205, 31);
		lblSzamokMerete.setFont(new Font("Tahoma", Font.BOLD, 12));
		frameProgTetelek.getContentPane().add(lblSzamokMerete);
		
		tfSzamokMerete = new JTextField();
		tfSzamokMerete.setBounds(441, 58, 86, 20);
		tfSzamokMerete.setBackground(Color.WHITE);
		tfSzamokMerete.setHorizontalAlignment(SwingConstants.CENTER);
		frameProgTetelek.getContentPane().add(tfSzamokMerete);
		tfSzamokMerete.setColumns(10);
		
		btnHatvanyoz = new JButton("Hatv\u00E1nyoz");
		btnHatvanyoz.setBounds(324, 489, 127, 23);
		btnHatvanyoz.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHatvanyoz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String szamok = "";
				for (Integer item : velSzamokLista) {
					szamok = szamok + Math.pow(item, 2) + ",";	//texten bel�li sort�r�s???
				}
				tfHatvanyEredmeny.setText(szamok);		
			}	
		});
		btnHatvanyoz.setBackground(SystemColor.activeCaption);
		btnHatvanyoz.setFont(new Font("Tahoma", Font.BOLD, 16));
		frameProgTetelek.getContentPane().add(btnHatvanyoz);
		
		tfHatvanyEredmeny = new JTextField();
		tfHatvanyEredmeny.setBounds(107, 540, 555, 68);
		tfHatvanyEredmeny.setBackground(Color.GREEN);
		tfHatvanyEredmeny.setHorizontalAlignment(SwingConstants.CENTER);
		frameProgTetelek.getContentPane().add(tfHatvanyEredmeny);
		tfHatvanyEredmeny.setColumns(10);
		
		btnReset = new JButton("RESET");
		btnReset.setBounds(650, 18, 89, 23);
		btnReset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearFieldsReset();
				
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReset.setBackground(SystemColor.activeCaption);
		frameProgTetelek.getContentPane().add(btnReset);
		
		scrollBar = new JScrollBar();
		scrollBar.setBounds(667, 537, 17, 75);
		frameProgTetelek.getContentPane().add(scrollBar);
		
	}
		


	@SuppressWarnings("unchecked")
	private void listaFeltolt() {
		Random r = new Random();
		
		//1.l�p�s : ArrayList felt�lt�se 20 v sz�mmal 1-100
		for (int i = 0; i < Integer.parseInt(tfSzamokIntervallum.getText()); i++) {
			int velSzam = r.nextInt(Integer.parseInt(tfSzamokMerete.getText()))+1;
			velSzamokLista.add(velSzam);
		}
		//2.l�p�s ListModel l�trehoz�sa �s felt�lt�se az ArrayList elemeivel
		listModel = new DefaultListModel<Integer>();
		for (Integer item : velSzamokLista) {
			listModel.addElement(item);
		}
		//3.l�p�s : hozz�rendelj�k a modellt a Jlist ui. komponenshez
		listUiVelSzamok.setModel(listModel);
		
	}
	private Integer listaOsszegMeghataroz(List<Integer> lista) {
//		int osszeg = 0;
//		for (Integer item : lista) {
//			osszeg += item;
//			
//		}
//		return osszeg;
//		
		return lista.stream().mapToInt(x->x.intValue()).sum(); // a fenti �sszegz�s t�tele 1 sorban, list�n bel�li eg�sz sz�mok
		
	}
	private OptionalDouble listaAtlagMeghataroz(List<Integer> lista) {
		return lista.stream().mapToDouble(x->x.intValue()).average(); //vedd minden egyes elem�t a list�nak �s sz�molj �tlagot bel�le
		//(ahol mappel�s van ott a lista �sszes elem�t veszi �s megcsin�lja az �tlagol�st)
	}
	private Integer listaLegkisebbErtekMeghataroz(List<Integer> lista) {
		return lista.stream().mapToInt(x->x.intValue()).min().getAsInt();
	}
	private void rendezNovekvo(List<Integer> lista) {
		Collections.sort(lista);
	}
	private Integer listaLegNagyobbErtekMeghataroz(List<Integer> lista) {
		return lista.stream().mapToInt(x->x.intValue()).max().getAsInt();	
	}
	private void RendezCsokkeno(List<Integer> lista) {//reverse csak a sorrendet cser�li meg, nem rendez!!
		Collections.sort(lista, Collections.reverseOrder());
	}
	private Long listaHarommalOszthatoakDarabSzamaMeghataroz(List<Integer> lista) {
		//arrow operator -> lambda expression: legyen
		return lista.stream().filter(i->i%3==0).count();//1. lista.stream()-et l�trehozzuk, majd sz�r�nk a 3-al oszthat� sz�mokra
	}
	private void clearFieldsReset() {
	 DefaultListModel listModel = (DefaultListModel) listUiVelSzamok.getModel();
	 listModel.removeAllElements();
	 btnVeletlenSzamokGeneralasa.setEnabled(true);
	 btnAtlag.setText("�tlag");
	 tfSzamokIntervallum.setText("");
	 tfSzamokMerete.setText("");
	 tfHatvanyEredmeny.setText("");	 
	}
}