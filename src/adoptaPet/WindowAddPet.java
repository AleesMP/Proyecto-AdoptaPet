package adoptaPet;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;

public class WindowAddPet {
	public JFrame frmAddPet;
	private JTextField txtName;
	private JTextField txtSpecies;
	private JTextField txtDate;
	private JLabel lblDate;
	private JLabel lblGender;
	private JLabel lblSize;
	private JButton btnAccept;
	private JLabel lblPhoto;
	private JButton btnUpload;
	public static ImageIcon image;
	static InputStream inputImage;
	protected static Pet newPet;
	protected ImageIcon scaledPic;
	protected ArrayList<Pet> updateNewPetArrayList = new ArrayList<Pet>();
	protected JPanel updatePanelAnimals = new JPanel();
	protected ArrayList <JButton> updateBotonesAnimales = new ArrayList <>();
	
	//Para conectarse a la base de datos 
	Connection connection;
	String url="jdbc:mysql://localhost:33306/AdoptaPet";
	String user="root";
	String password="alumnoalumno";
	
	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowAddPet window = new WindowAddPet();
					window.frmAddPet.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public WindowAddPet()
	{
		
	}
	public WindowAddPet(ArrayList<Pet> updateNewPetArrayList, JPanel updatePanelAnimals, ArrayList <JButton> updateBotonesAnimales) {
		this.updateNewPetArrayList=updateNewPetArrayList;
		this.updatePanelAnimals=updatePanelAnimals;
		this.updateBotonesAnimales=updateBotonesAnimales;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frmAddPet = new JFrame();
		frmAddPet.setIconImage(Toolkit.getDefaultToolkit().getImage("/media/karvil/KAREN/1 DAW/Proyecto final/Logo/logo.png"));
		frmAddPet.getContentPane().setBackground(new Color(172, 209, 233 ));
		frmAddPet.setBounds(100, 100, 659, 520);
		frmAddPet.getContentPane().setLayout(null);

		txtName = new JTextField();
		txtName.setBounds(184, 67, 155, 21);
		frmAddPet.getContentPane().add(txtName);
		txtName.setColumns(10);

		txtSpecies = new JTextField();
		txtSpecies.setBounds(184, 110, 155, 21);
		frmAddPet.getContentPane().add(txtSpecies);
		txtSpecies.setColumns(10);

		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		lblName.setBounds(25, 69, 68, 17);
		frmAddPet.getContentPane().add(lblName);

		JLabel lblSpecies = new JLabel("Species:");
		lblSpecies.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		lblSpecies.setBounds(25, 112, 60, 17);
		frmAddPet.getContentPane().add(lblSpecies);

		txtDate = new JTextField();
		txtDate.setBounds(184, 157, 155, 21);
		frmAddPet.getContentPane().add(txtDate);
		txtDate.setColumns(10);

		lblDate = new JLabel("Date of birth:");
		lblDate.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		lblDate.setBounds(25, 159, 110, 17);
		frmAddPet.getContentPane().add(lblDate);

		lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		lblGender.setBounds(25, 204, 60, 17);
		frmAddPet.getContentPane().add(lblGender);

		lblSize = new JLabel("Size:");
		lblSize.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		lblSize.setBounds(25, 255, 60, 17);
		frmAddPet.getContentPane().add(lblSize);		
		
		JLabel lblAdoptionStatus = new JLabel("Adoption status:");
		lblAdoptionStatus.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		lblAdoptionStatus.setBounds(25, 309, 139, 17);
		frmAddPet.getContentPane().add(lblAdoptionStatus);

		JComboBox comboSize = new JComboBox();
		comboSize.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		comboSize.setBackground(Color.WHITE);
		comboSize.setModel(new DefaultComboBoxModel(new String[] {"Small", "Medium", "Big"}));
		comboSize.setBounds(184, 250, 155, 26);
		frmAddPet.getContentPane().add(comboSize);
		
		JComboBox comboGender = new JComboBox();
		comboGender.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		comboGender.setBackground(Color.WHITE);
		comboGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboGender.setBounds(184, 199, 155, 26);
		frmAddPet.getContentPane().add(comboGender);
		
		JComboBox comboEstado = new JComboBox();
		comboEstado.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		comboEstado.setBackground(Color.WHITE);
		comboEstado.setModel(new DefaultComboBoxModel(new String[] {"Urgent", "In adoption"}));
		comboEstado.setBounds(184, 304, 155, 26);
		frmAddPet.getContentPane().add(comboEstado);
		
		btnUpload = new JButton("Upload Image");
		btnUpload.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		btnUpload.setBackground(Color.WHITE);
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser fc = new JFileChooser();
                int sele=fc.showOpenDialog(frmAddPet.getContentPane());

                if (sele == JFileChooser.APPROVE_OPTION){
                    ImageIcon image = new ImageIcon (fc.getSelectedFile().getAbsolutePath());
                    scaledPic = new ImageIcon(image.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT));
                    lblPhoto.setText("");
                    lblPhoto.setIcon(scaledPic);
                    Path from = Paths.get(fc.getSelectedFile().getAbsolutePath());
                    Path to = Paths.get("/media/karvil/KAREN/1DAW/Proyectofinal/proyectoJava/imagenes/foto2.jpg");
                    CopyOption [] options = new CopyOption[] {
                    		StandardCopyOption.REPLACE_EXISTING,
                    		StandardCopyOption.COPY_ATTRIBUTES
                    };
                
                    
                    try {
						Files.copy(from, to,options);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    
                    
                }  
                
               
			}
		});
		btnUpload.setBounds(403, 329, 144, 27);
		frmAddPet.getContentPane().add(btnUpload);	
		
		

		btnAccept = new JButton("Accept");
		btnAccept.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		btnAccept.setBackground(Color.WHITE);
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//coger el indice del tamaño, genero y el estado de adopcion
				int size= comboSize.getSelectedIndex();
				int gender= comboGender.getSelectedIndex();
				int estadoAdopcion=comboEstado.getSelectedIndex();
				
				
				String txtSize;
				String txtGender;
				String txtEstadoAdopcion;
				
				if (size==0)
				{
					txtSize="Small";
				}
				else if (size==1)
				{
					txtSize="Medium";
				}
				else
				{
					txtSize="Big";
				}
				
				
				if (gender==0)
				{
					txtGender="Male";
				}
				else
				{
					txtGender="Female";
				}

				
				if (estadoAdopcion==0)
				{
					txtEstadoAdopcion="Urgent";
				}
				else
				{
					txtEstadoAdopcion="In adoption";
				}
				
				boolean infoCheck=true;
				
				///////////////ME HE QUEDADO AQUí
				if (txtName.getText().equals("") ||txtSpecies.getText().equals("") || txtDate.getText().equals(""))
				{
					JOptionPane.showMessageDialog(frmAddPet,
							"Information cannot be empty",
							"Information warning",
							JOptionPane.WARNING_MESSAGE);
							infoCheck=false;
				}
				
				if (infoCheck)
				{
					newPet = new Pet(txtName.getText(), txtSpecies.getText(), txtDate.getText(), txtGender, txtSize, txtEstadoAdopcion);				
					updateNewPetArrayList.add(newPet);
					JButton updateButton = new JButton();
					updateButton.setText(txtName.getText());
					updateButton.setName(updateBotonesAnimales.size()+"");
					updateButton.setBackground(Color.WHITE);
					updateButton.addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent arg0) {
		    			PetInformation window = new PetInformation();
		    			window.frame.setVisible(true);
		    			System.out.println(arg0);
		    			JButton b1 = (JButton) arg0.getSource();
		    		
		    			System.out.println(b1.getName());
		    			int n=Integer.valueOf(b1.getName());
		    			
		    			PetInformation.namePet.setText(updateNewPetArrayList.get(n).getName());
		    			PetInformation.dateOfBirth.setText(updateNewPetArrayList.get(n).getDateBirth());
		    			PetInformation.adoptionStatus.setText(updateNewPetArrayList.get(n).getEstadoAdopcion());
		    			PetInformation.gender.setText(updateNewPetArrayList.get(n).getGender());
		    			PetInformation.species.setText(updateNewPetArrayList.get(n).getSpecies());
		    			PetInformation.size.setText(updateNewPetArrayList.get(n).getSize());
		    			
		    			}
		    		});
					
					updatePanelAnimals.add(updateButton);
					updateBotonesAnimales.add(updateButton);
					updatePanelAnimals.repaint();
					updatePanelAnimals.updateUI();
				
					
					
					JOptionPane.showMessageDialog(
							frmAddPet, "Correctly registered", "Information",
							JOptionPane.INFORMATION_MESSAGE);
					try {
						newPet.AddPetBaseDeDatos();
					} catch (IOException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				txtName.setText("");
				txtSpecies.setText("");
				txtDate.setText("");
			

			}
		});
		btnAccept.setBounds(273, 406, 105, 27);
		frmAddPet.getContentPane().add(btnAccept);
		
		lblPhoto = new JLabel("PHOTO");
		lblPhoto.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		lblPhoto.setBackground(Color.WHITE);
		lblPhoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoto.setBounds(357, 67, 250, 250);
		frmAddPet.getContentPane().add(lblPhoto);		
	}
}
