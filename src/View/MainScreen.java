package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Controllers.DirectMapping;
import Models.MappingModel;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.DirectColorModel;
import java.awt.event.ActionEvent;

public class MainScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JRadioButton rb_directMapping;
	private JRadioButton rb_setAssociative_fifo;
	private JPanel jp_amount_words;
	private JPanel jp_memoryTrace;
	private JTable table;
	private JTextField jtf_memoryTrace_1;
	private JTextField jtf_memoryTrace_2;
	private JTextField jtf_memoryTrace_3;
	private JTextField jtf_memoryTrace_4;
	private JTextField jtf_memoryTrace_8;
	private JTextField jtf_memoryTrace_7;
	private JTextField jtf_memoryTrace_6;
	private JTextField jtf_memoryTrace_5;
	private JTextField jtf_memoryTrace_12;
	private JTextField jtf_memoryTrace_11;
	private JTextField jtf_memoryTrace_10;
	private JTextField jtf_memoryTrace_9;
	private JTextField jtf_memoryTrace_16;
	private JTextField jtf_memoryTrace_15;
	private JTextField jtf_memoryTrace_14;
	private JTextField jtf_memoryTrace_13;
	private JScrollPane scrollPane_1;
	private JTable table_1;
	private JPanel panel_3;
	private JRadioButton rb_setAssociative_lru;
	private ButtonGroup jbg_options_words;
	private ButtonGroup jbg_options_mapping;
	private JButton jbtn_process;
	private String[] slots;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
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
	public MainScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 634);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel jp_mappings = new JPanel();
		FlowLayout fl_jp_mappings = (FlowLayout) jp_mappings.getLayout();
		fl_jp_mappings.setAlignment(FlowLayout.LEFT);
		jp_mappings.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Mappings",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		jp_mappings.setBounds(407, 11, 195, 170);
		contentPane.add(jp_mappings);
		jbg_options_mapping = new ButtonGroup();

		rb_directMapping = new JRadioButton("Direct Mapping");
		rb_directMapping.setSelected(true);
		jp_mappings.add(rb_directMapping);

		JRadioButton rb_fullAssociative_fifo = new JRadioButton("Full Associative - FIFO");
		jp_mappings.add(rb_fullAssociative_fifo);

		JRadioButton rb_fullAssociative_lru = new JRadioButton("Full Assiciative - LRU");
		jp_mappings.add(rb_fullAssociative_lru);

		rb_setAssociative_fifo = new JRadioButton("Set Associative -FIFO");
		jp_mappings.add(rb_setAssociative_fifo);

		rb_setAssociative_lru = new JRadioButton("Set Associative - LRU");
		jp_mappings.add(rb_setAssociative_lru);

		jbg_options_mapping.add(rb_directMapping);
		jbg_options_mapping.add(rb_fullAssociative_fifo);
		jbg_options_mapping.add(rb_fullAssociative_lru);
		jbg_options_mapping.add(rb_setAssociative_fifo);
		jbg_options_mapping.add(rb_setAssociative_lru);
		jp_amount_words = new JPanel();
		jp_amount_words.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Word(s)",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		jp_amount_words.setBounds(407, 192, 195, 95);
		contentPane.add(jp_amount_words);
		FlowLayout fl_jp_amount_words = new FlowLayout(FlowLayout.CENTER, 5, 5);
		jp_amount_words.setLayout(fl_jp_amount_words);
		jbg_options_words = new ButtonGroup();

		JRadioButton rb_amount_words_1 = new JRadioButton("1");
		rb_amount_words_1.setSelected(true);
		jp_amount_words.add(rb_amount_words_1);

		JRadioButton rb_amount_words_2 = new JRadioButton("2");
		jp_amount_words.add(rb_amount_words_2);

		JRadioButton rb_amount_words_4 = new JRadioButton("4");
		jp_amount_words.add(rb_amount_words_4);

		jbtn_process = new JButton("Processcle");

		jbg_options_words.add(rb_amount_words_1);
		jbg_options_words.add(rb_amount_words_2);
		jbg_options_words.add(rb_amount_words_4);
		jp_memoryTrace = new JPanel();
		jp_memoryTrace
				.setBorder(new TitledBorder(null, "MemoryTrace", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jp_memoryTrace.setBounds(10, 11, 395, 170);
		contentPane.add(jp_memoryTrace);
		jp_memoryTrace.setLayout(null);

		jtf_memoryTrace_1 = new JTextField();
		jtf_memoryTrace_1.setBounds(10, 34, 86, 20);
		jp_memoryTrace.add(jtf_memoryTrace_1);
		jtf_memoryTrace_1.setColumns(10);

		jtf_memoryTrace_2 = new JTextField();
		jtf_memoryTrace_2.setColumns(10);
		jtf_memoryTrace_2.setBounds(106, 34, 86, 20);
		jp_memoryTrace.add(jtf_memoryTrace_2);

		jtf_memoryTrace_3 = new JTextField();
		jtf_memoryTrace_3.setColumns(10);
		jtf_memoryTrace_3.setBounds(202, 34, 86, 20);
		jp_memoryTrace.add(jtf_memoryTrace_3);

		jtf_memoryTrace_4 = new JTextField();
		jtf_memoryTrace_4.setColumns(10);
		jtf_memoryTrace_4.setBounds(298, 34, 86, 20);
		jp_memoryTrace.add(jtf_memoryTrace_4);

		jtf_memoryTrace_8 = new JTextField();
		jtf_memoryTrace_8.setColumns(10);
		jtf_memoryTrace_8.setBounds(298, 65, 86, 20);
		jp_memoryTrace.add(jtf_memoryTrace_8);

		jtf_memoryTrace_7 = new JTextField();
		jtf_memoryTrace_7.setColumns(10);
		jtf_memoryTrace_7.setBounds(202, 65, 86, 20);
		jp_memoryTrace.add(jtf_memoryTrace_7);

		jtf_memoryTrace_6 = new JTextField();
		jtf_memoryTrace_6.setColumns(10);
		jtf_memoryTrace_6.setBounds(106, 65, 86, 20);
		jp_memoryTrace.add(jtf_memoryTrace_6);

		jtf_memoryTrace_5 = new JTextField();
		jtf_memoryTrace_5.setColumns(10);
		jtf_memoryTrace_5.setBounds(10, 65, 86, 20);
		jp_memoryTrace.add(jtf_memoryTrace_5);

		jtf_memoryTrace_12 = new JTextField();
		jtf_memoryTrace_12.setColumns(10);
		jtf_memoryTrace_12.setBounds(298, 96, 86, 20);
		jp_memoryTrace.add(jtf_memoryTrace_12);

		jtf_memoryTrace_11 = new JTextField();
		jtf_memoryTrace_11.setColumns(10);
		jtf_memoryTrace_11.setBounds(202, 96, 86, 20);
		jp_memoryTrace.add(jtf_memoryTrace_11);

		jtf_memoryTrace_10 = new JTextField();
		jtf_memoryTrace_10.setColumns(10);
		jtf_memoryTrace_10.setBounds(106, 96, 86, 20);
		jp_memoryTrace.add(jtf_memoryTrace_10);

		jtf_memoryTrace_9 = new JTextField();
		jtf_memoryTrace_9.setColumns(10);
		jtf_memoryTrace_9.setBounds(10, 96, 86, 20);
		jp_memoryTrace.add(jtf_memoryTrace_9);

		jtf_memoryTrace_16 = new JTextField();
		jtf_memoryTrace_16.setColumns(10);
		jtf_memoryTrace_16.setBounds(298, 127, 86, 20);
		jp_memoryTrace.add(jtf_memoryTrace_16);

		jtf_memoryTrace_15 = new JTextField();
		jtf_memoryTrace_15.setColumns(10);
		jtf_memoryTrace_15.setBounds(202, 127, 86, 20);
		jp_memoryTrace.add(jtf_memoryTrace_15);

		jtf_memoryTrace_14 = new JTextField();
		jtf_memoryTrace_14.setColumns(10);
		jtf_memoryTrace_14.setBounds(106, 127, 86, 20);
		jp_memoryTrace.add(jtf_memoryTrace_14);

		jtf_memoryTrace_13 = new JTextField();
		jtf_memoryTrace_13.setColumns(10);
		jtf_memoryTrace_13.setBounds(10, 127, 86, 20);
		jp_memoryTrace.add(jtf_memoryTrace_13);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "Processing", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setBounds(10, 339, 395, 245);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setBorder(null);
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "WORDS", "TAG", "MAPPING", "SHIFTING" }));

		scrollPane.setViewportView(table);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 192, 395, 95);
		contentPane.add(scrollPane_1);
		scrollPane_1.setBorder(new TitledBorder(null, "Slots", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "11", "10", "01", "00" }));
		scrollPane_1.setViewportView(table_1);

		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Results", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(407, 339, 183, 245);
		contentPane.add(panel_3);

		JButton jbt_process = new JButton("Process");
		jbt_process.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int words=1;
				int mappingOption= 1;
				int [] memoryTrace = null;
				if (rb_amount_words_1.isSelected()) {
					words = 1;
				} else if (rb_amount_words_2.isSelected()) {
					words = 2;
				} else if (rb_amount_words_4.isSelected()) {
					words = 4;
				}

				if (rb_directMapping.isSelected()) {
					
					
				} else if (rb_fullAssociative_fifo.isSelected()) {
					mappingOption = 2;
				} else if (rb_fullAssociative_lru.isSelected()) {
					mappingOption = 3;
				} else if (rb_setAssociative_fifo.isSelected()) {
					mappingOption = 4;
				} else if (rb_setAssociative_lru.isSelected()) {
					mappingOption = 5;
				}

				//execulte the logic for choose user with one indice
				if(optionUser == 1){

				}else if(optionUser == 2) { //execulte the logic for choose user with two indice


				}

				
				
			}
		});
		jbt_process.setBounds(407, 297, 183, 40);
		contentPane.add(jbt_process);
	}
}
