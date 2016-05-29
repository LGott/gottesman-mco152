package gottesman.nypl;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class NYPLGui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container container;
	private JTextField search;
	private JButton searchButton;
	private JPanel northPanel;
	private JPanel southNorthPanel;
	private JButton previous;
	private JButton next;
	private JLabel num;
	private JPanel centerPanel;
	private JList<String> listBox;
	private DefaultListModel<String> listModel;
	private JScrollPane listScroller;
	private JLabel icon;
	private NYPLGui self;
	private Result[] result;
	private ImageConnection imgThread;

	public NYPLGui() {
		setTitle("NYPL Search");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.container = getContentPane();
		this.search = new JTextField();
		this.searchButton = new JButton("Search");
		this.northPanel = new JPanel();
		this.southNorthPanel = new JPanel();
		this.previous = new JButton("Previous");
		this.next = new JButton("Next");
		this.num = new JLabel("0/0");
		this.centerPanel = new JPanel();
		this.listModel = new DefaultListModel<String>();
		this.listBox = new JList<String>(listModel);
		this.icon = new JLabel();
		this.listScroller = new JScrollPane(icon);
		this.self = this;
		this.result = null;
		setComponents();
		addComponents();
	}

	public void setComponents() {
		container.setLayout(new BorderLayout());
		this.northPanel.setLayout(new BorderLayout());
		this.centerPanel.setLayout(new BorderLayout());
		this.listBox.setLayoutOrientation(JList.VERTICAL_WRAP);
		this.listBox.setVisibleRowCount(-1);
		this.previous.setEnabled(false);
		this.next.setEnabled(false);
	}

	private void addComponents() {
		this.northPanel.add(this.searchButton, BorderLayout.EAST);
		this.northPanel.add(this.search, BorderLayout.CENTER);
		this.centerPanel.add(this.southNorthPanel, BorderLayout.NORTH);
		this.centerPanel.add(this.listScroller, BorderLayout.CENTER);
		this.southNorthPanel.add(this.previous);
		this.southNorthPanel.add(this.num);
		this.southNorthPanel.add(this.next);
		container.add(this.northPanel, BorderLayout.NORTH);
		container.add(this.listBox, BorderLayout.WEST);
		this.container.add(this.centerPanel, BorderLayout.CENTER);

		this.search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startSearch(search.getText());
			}
		});
		this.searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startSearch(search.getText());
			}
		});

		listBox.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent evt) {
				JList<?> list = (JList<?>) evt.getSource();
				if (evt.getClickCount() == 1) {

					int index = list.getSelectedIndex();

					ImageConnection imgThread = new ImageConnection(result[index].getApiItemURL(), icon, num, previous,
							next, self);
					imgThread.start();

				}
			}
		});
		this.previous.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				imgThread.previousImage();
			}

		});
		this.next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				imgThread.nextImage();
			}
		});
	}

	public void setResult(Result[] result) {
		this.result = result;
	}

	public void setPicThread(ImageConnection imgThread) {
		this.imgThread = imgThread;
	}

	public void startSearch(String searchTopic) {
		SearchThread thread = new SearchThread(listModel, listBox, icon, searchTopic, this.num, this.previous,
				this.next, this.self);
		thread.start();
	}
}