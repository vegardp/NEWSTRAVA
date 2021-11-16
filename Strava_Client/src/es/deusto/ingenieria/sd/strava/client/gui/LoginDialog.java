package es.deusto.ingenieria.sd.strava.client.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import es.deusto.ingenieria.sd.strava.client.controller.LoginController;
import es.deusto.ingenieria.sd.strava.client.controller.TrainingController;
import es.deusto.ingenieria.sd.strava.client.remote.ServiceLocator;
import es.deusto.ingenieria.sd.strava.client.gui.TrainingWindow;

public class LoginDialog {

	private LoginController controller;
	private ServiceLocator serviceLocator;
	private String email = "thomas.e2001@gmail.com";
	private String password = "$!9PhNz,";
	private String nickname;
	private String dbirthdate;
	private int dweight;
	private int dheight;
	private int dmaxRate;
	private int dminRate;

	public LoginDialog(LoginController controller, ServiceLocator serviceLocator) {
		this.controller = controller;
		this.serviceLocator = serviceLocator;
	}

	public boolean LoginD() {
		JFrame f = new JFrame("STRAVA LOGIN");

		final JLabel lemail = new JLabel("Email");
		lemail.setBounds(120, 20, 150, 20);

		final JTextField emailBox = new JTextField();
		emailBox.setBounds(120, 50, 150, 20);
		emailBox.setText("thomas.e2001@gmail.com");

		final JLabel lpass = new JLabel("Password");
		lpass.setBounds(120, 70, 150, 20);

		final JTextField pass = new JTextField();
		pass.setBounds(120, 100, 150, 20);
		pass.setText("$!9PhNz,");

		final JLabel lname = new JLabel("Name");
		lname.setBounds(120, 120, 150, 20);

		final JTextField name = new JTextField();
		name.setBounds(120, 140, 150, 20);
		name.setText("Thomas");

		final JLabel lweigth = new JLabel("Weigth");
		lweigth.setBounds(120, 160, 150, 20);

		final JTextField weigth = new JTextField();
		weigth.setBounds(120, 180, 50, 20);
		weigth.setText("80 kg");

		final JLabel lheight = new JLabel("Height");
		lheight.setBounds(120, 200, 150, 20);

		final JTextField height = new JTextField();
		height.setBounds(120, 220, 50, 20);
		height.setText("175 cm");

		final JLabel lmaxrate = new JLabel("Max Heart Rate");
		lmaxrate.setBounds(180, 160, 150, 20);

		final JTextField maxrate = new JTextField();
		maxrate.setBounds(180, 180, 50, 20);
		maxrate.setText("220");

		final JLabel lminrate = new JLabel("Min Heart Rate");
		lminrate.setBounds(180, 200, 150, 20);

		final JTextField minrate = new JTextField();
		minrate.setBounds(180, 220, 50, 20);
		minrate.setText("65");

		final JLabel lbirth = new JLabel("Birthdate");
		lbirth.setBounds(120, 240, 150, 20);

		final JTextField birthBox = new JTextField();
		birthBox.setBounds(120, 260, 70, 20);
		birthBox.setText("1998-10-22");

		JButton b = new JButton("LOGIN");
		b.setBounds(100, 250, 95, 30);
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * JOptionPane.showMessageDialog(null, "Login request sent"); email.setText("");
				 * pass.setText("");
				 */
				JOptionPane.showMessageDialog(null, "Login request sent");
				String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex(password);
				JOptionPane.showMessageDialog(null, "\t* Password hash: " + sha1);
				boolean result = controller.login(email, sha1);
				System.out.println("User signed in.");
				JOptionPane.showMessageDialog(null, "Login result");
				long loginToken = controller.getToken();
				JOptionPane.showMessageDialog(null, "Token: " + loginToken);
				// reset text fields
				emailBox.setText("");
				pass.setText("");
				// ServiceLocator serviceLocator = new ServiceLocator();
				TrainingController trainingController = new TrainingController(serviceLocator);
				TrainingWindow trainingWindow = new TrainingWindow(trainingController, loginToken);
				trainingWindow.TrainingFrame();

				// Send login

			}
		});

		JButton c = new JButton("REGISTER");
		c.setBounds(200, 250, 95, 30);
		c.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				c.setBounds(200, 300, 95, 30);
				b.setVisible(false);
				c.setVisible(false);

				lname.setVisible(true);
				name.setVisible(true);

				lweigth.setVisible(true);
				weigth.setVisible(true);

				lheight.setVisible(true);
				height.setVisible(true);

				lmaxrate.setVisible(true);
				maxrate.setVisible(true);

				lminrate.setVisible(true);
				minrate.setVisible(true);

				lbirth.setVisible(true);
				birthBox.setVisible(true);
				
			

			}
		});

		JButton d = new JButton("SEND");
		d.setBounds(200, 250, 95, 30);
		d.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				c.setBounds(200, 250, 95, 30);
				b.setVisible(true);
				c.setVisible(true);
				d.setVisible(true);

				lname.setVisible(false);
				name.setVisible(false);

				lweigth.setVisible(false);
				weigth.setVisible(false);

				lheight.setVisible(false);
				height.setVisible(false);

				lmaxrate.setVisible(false);
				maxrate.setVisible(false);

				lminrate.setVisible(false);
				minrate.setVisible(false);

				lbirth.setVisible(false);
				birthBox.setVisible(false);

				nickname=name.getText();
				dbirthdate=birthBox.getText();
				dweight=Integer.valueOf (weigth.getText());
				dheight=Integer.valueOf (height.getText());
				dmaxRate=Integer.valueOf (maxrate.getText());
				dminRate=Integer.valueOf (minrate.getText());

				JOptionPane.showMessageDialog(null, "Register request sent");
				String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex(password);
				JOptionPane.showMessageDialog(null, "\t* Password hash: " + sha1);
				System.out.println("lanza register");
				boolean result = controller.registration(email, sha1, nickname, dbirthdate, dweight, dheight, dmaxRate,
						dminRate);

				System.out.println("devuelve register");
				JOptionPane.showMessageDialog(null, "Register result");

				JOptionPane.showMessageDialog(null, "Token: " + controller.getToken());

			}
		});

		f.add(b);
		f.add(c);
		f.add(d);
		f.add(emailBox);
		f.add(lemail);

		f.add(pass);
		f.add(lpass);
		

		// register fields
		f.add(lname);
		f.add(name);
		lname.setVisible(false);
		name.setVisible(false);

		f.add(lmaxrate);
		f.add(maxrate);
		lmaxrate.setVisible(false);
		maxrate.setVisible(false);

		f.add(lminrate);
		f.add(minrate);
		lminrate.setVisible(false);
		minrate.setVisible(false);

		f.add(lweigth);
		f.add(weigth);
		lweigth.setVisible(false);
		weigth.setVisible(false);

		f.add(lheight);
		f.add(height);
		lheight.setVisible(false);
		height.setVisible(false);
		
		f.add(lbirth);
		f.add(birthBox);
		lbirth.setVisible(false);
		birthBox.setVisible(false);

		f.setSize(400, 400);
		f.setLayout(null);
		f.setVisible(true);

		boolean result = true;
		return result;

	}

	public void logout() {
		System.out.println(" - Logout from the server...");
		this.controller.logout();
		System.out.println("\t* Logout success!");

	}

}