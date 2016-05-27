package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Models.MemoryTraceColect;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.DirectColorModel;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.io.File;
import java.net.URL;

public class MainScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JRadioButton rb_directMapping;
	private JRadioButton rb_setAssociative_fifo;
	private JPanel jp_amount_words;
	private JPanel jp_memoryTrace;
	private JScrollPane scrollPane_1;
	private JTable table_1;
	private JPanel panel_3;
	private JRadioButton rb_setAssociative_lru;
	private ButtonGroup jbg_options_words;
	private ButtonGroup jbg_options_mapping;
	private ButtonGroup jbg_options_slots;
	private ButtonGroup jbg_options_process;
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
		jp_amount_words.setBounds(407, 192, 195, 55);
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
		
		JButton btn_archhive = new JButton("Carregar Arquivo");
		btn_archhive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Necessario colocar um numero por linha","Alerta",JOptionPane.INFORMATION_MESSAGE);
				try {
                    JFileChooser jfc = new JFileChooser();
                    jfc.setCurrentDirectory(new File("/"));
                    jfc.setDialogTitle("Carrega Arquivo MemoryTrace");
                    jfc.showOpenDialog(jfc);
                    MemoryTraceColect.path = jfc.getSelectedFile().getAbsolutePath();
                    

                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null,"Erro ao Carregar arquivo","Error",JOptionPane.ERROR_MESSAGE);
                }
			}
		});
		btn_archhive.setBounds(95, 30, 174, 48);
		jp_memoryTrace.add(btn_archhive);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 192, 395, 110);
		contentPane.add(scrollPane_1);
		scrollPane_1.setBorder(new TitledBorder(null, "Slots", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "11", "10", "01", "00" }));
		scrollPane_1.setViewportView(table_1);

		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Results", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(22, 413, 580, 170);
		contentPane.add(panel_3);

		JButton jbt_process = new JButton("Process");
		
		jbt_process.setBounds(407, 361, 195, 40);
		contentPane.add(jbt_process);
		
		JPanel jp_amount_slots = new JPanel();
		jp_amount_slots.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Slot(s)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		jp_amount_slots.setBounds(407, 247, 195, 55);
		contentPane.add(jp_amount_slots);
		jbg_options_slots = new ButtonGroup();
		jp_amount_slots.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JRadioButton rb_slots_1 = new JRadioButton("1");
		rb_slots_1.setSelected(true);
		jp_amount_slots.add(rb_slots_1);
		
		JRadioButton rb_slots_2 = new JRadioButton("2");
		jp_amount_slots.add(rb_slots_2);
		
		JRadioButton rb_slots_3 = new JRadioButton("3");
		jp_amount_slots.add(rb_slots_3);
		
		JRadioButton rb_slots_4 = new JRadioButton("4");
		jp_amount_slots.add(rb_slots_4);
		
		jbg_options_slots.add(rb_slots_1);
		jbg_options_slots.add(rb_slots_2);
		jbg_options_slots.add(rb_slots_3);
		jbg_options_slots.add(rb_slots_4);
		
		JPanel jp_chooseProcess = new JPanel();
		jp_chooseProcess.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Processamento", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		jp_chooseProcess.setBounds(407, 300, 195, 55);
		contentPane.add(jp_chooseProcess);
		jbg_options_process = new ButtonGroup();
		jp_chooseProcess.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JRadioButton rb_chooseProcess_1 = new JRadioButton("Direto");
		rb_chooseProcess_1.setSelected(true);
		jp_chooseProcess.add(rb_chooseProcess_1);
		
		JRadioButton rb_chooseProcess_2 = new JRadioButton("A Passo");
		jp_chooseProcess.add(rb_chooseProcess_2);
		
		jbg_options_process.add(rb_chooseProcess_1);
		jbg_options_process.add(rb_chooseProcess_2);
		
		//Actions
		
		jbt_process.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int words=1;
				int mappingOption= 1;
				int chooseOfProcess = 1;
				int amountSlots = 4;
				
				if (rb_amount_words_1.isSelected()) {
					words = 1;
				} else if (rb_amount_words_2.isSelected()) {
					words = 2;
				} else if (rb_amount_words_4.isSelected()) {
					words = 4;
				}

				if (rb_directMapping.isSelected()) {
					mappingOption= 1;
					
				} else if (rb_fullAssociative_fifo.isSelected()) {
					mappingOption = 2;
				} else if (rb_fullAssociative_lru.isSelected()) {
					mappingOption = 3;
				} else if (rb_setAssociative_fifo.isSelected()) {
					mappingOption = 4;
				} else if (rb_setAssociative_lru.isSelected()) {
					mappingOption = 5;
				}
				if(rb_chooseProcess_1.isSelected()){
					chooseOfProcess = 1;
				}else if(rb_chooseProcess_2.isSelected()){
					chooseOfProcess = 2;
				}
				if(rb_slots_1.isSelected()){
					amountSlots = 1;
				}else if(rb_slots_2.isSelected()){
					amountSlots = 2;
				}else if(rb_slots_3.isSelected()){
					amountSlots = 3;
				}else if(rb_slots_4.isSelected()){
					amountSlots = 4;
				}
				
				
				
			}
		});
		
	}
}
