import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame1 {

	protected static URL testURL = null; //do not make final so it can be initialized later
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Initialize testURL and use try/catch to check if the URL is in the right format
		try {
			testURL = new URL("https://generic.sucks");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					openWebpage(testURL.toURI());
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setSelectedIcon(new ImageIcon(Frame1.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Bold-Black.png")));
		btnNewButton.setToolTipText("Goes to http://generic.sucks/");
		btnNewButton.setIcon(new ImageIcon(Frame1.class.getResource("/resources/memeplane.png")));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(100, 74, 220, 137);
		frame.getContentPane().add(btnNewButton);
	}
	
	//https://stackoverflow.com/questions/10967451/open-a-link-in-browser-with-java-button
	public static void openWebpage(URI uri) {
	    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
	    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
	        try {
	            desktop.browse(uri);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
}
