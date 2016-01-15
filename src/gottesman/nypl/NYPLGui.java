package gottesman.nypl;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class NYPLGui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JList<String> titles;
	private JTextField searchBox;
	private JButton button;
	private JPanel panel;
	private String searchText;
	private NYPLThread thread;
	private ImageIcon image;

	public NYPLGui() {
		setTitle("NYPL Search");
		setSize(500, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		BorderLayout layout = new BorderLayout();
		Container container = getContentPane();
		container.setLayout(layout);

		titles = new JList<String>();
		titles.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		// titles.setMaximumSize(30);
		titles.setLayoutOrientation(JList.VERTICAL);
		titles.setVisibleRowCount(-1);

		searchBox = new JTextField("");
		button = new JButton("Search");

		image = new ImageIcon();

		panel = new JPanel();

		button.setVisible(true);

		panel.add(button);
		panel.setVisible(true);

		container.add(searchBox, BorderLayout.NORTH);

		container.add(panel, BorderLayout.SOUTH);

		container.setVisible(true);

		container.add(new JScrollPane(titles), BorderLayout.WEST);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub

				searchText = searchBox.getText();

				thread = new NYPLThread(titles, searchText);
				thread.start();

			}
		});

		MouseListener mouseListener = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent mouseEvent) {
				if (mouseEvent.getClickCount() == 1) {

					int index = titles.locationToIndex(mouseEvent.getPoint());
					if (index >= 0) {

						Result result = thread.getResults()[index];
						String url = result.getURl();
						// ImageConnection imageThread = new ImageConnection(url, image);
						// imageThread.start();

					}
				}
			}
		};
		titles.addMouseListener(mouseListener);

	}

	public static void main(String[] args) {
		NYPLGui nypl = new NYPLGui();
		nypl.setVisible(true);
	}
}
