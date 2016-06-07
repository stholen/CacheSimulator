package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Helpers.Functions;
import Models.CacheMemory;
import Models.MappingModel;
import Models.MemoryTraceColect;
import Models.MemoryTraceModeling;
import Controllers.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.DirectColorModel;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.io.File;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.Vector;

public class MainScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JRadioButton rb_directMapping;
	private JRadioButton rb_setAssociative_fifo;
	private JPanel jp_configuration;
	private JPanel jp_results;
	private JRadioButton rb_setAssociative_lru;
	private ButtonGroup jbg_options_words;
	private ButtonGroup jbg_options_mapping;
	private ButtonGroup jbg_options_slots;
	private ButtonGroup jbg_options_process;
	private JButton jbtn_process;
	private String[] slots;
	
	public static int slotsAmount,wordSize,associativityDegree,timeAcess;
	

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
		setBounds(100, 100, 685, 717);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel jp_mappings = new JPanel();
		jp_mappings.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "MAPPINGS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		jp_mappings.setBounds(433, 12, 222, 163);
		contentPane.add(jp_mappings);
		jbg_options_mapping = new ButtonGroup();
		jp_mappings.setLayout(null);

		rb_directMapping = new JRadioButton("Direct Mapping");
		rb_directMapping.setBounds(10, 22, 122, 23);
		rb_directMapping.setFont(new Font("Serif", Font.PLAIN, 12));
		rb_directMapping.setSelected(true);
		jp_mappings.add(rb_directMapping);

		JRadioButton rb_fullAssociative_fifo = new JRadioButton("Full Associative - FIFO");
		rb_fullAssociative_fifo.setBounds(10, 49, 163, 23);
		rb_fullAssociative_fifo.setFont(new Font("Serif", Font.PLAIN, 12));
		jp_mappings.add(rb_fullAssociative_fifo);

		JRadioButton rb_fullAssociative_lru = new JRadioButton("Full Assiciative - LRU");
		rb_fullAssociative_lru.setBounds(10, 76, 157, 23);
		rb_fullAssociative_lru.setFont(new Font("Serif", Font.PLAIN, 12));
		jp_mappings.add(rb_fullAssociative_lru);

		rb_setAssociative_fifo = new JRadioButton("Set Associative -FIFO");
		rb_setAssociative_fifo.setBounds(10, 103, 154, 23);
		rb_setAssociative_fifo.setFont(new Font("Serif", Font.PLAIN, 12));
		jp_mappings.add(rb_setAssociative_fifo);

		rb_setAssociative_lru = new JRadioButton("Set Associative - LRU");
		rb_setAssociative_lru.setBounds(10, 130, 155, 23);
		rb_setAssociative_lru.setFont(new Font("Serif", Font.PLAIN, 12));
		jp_mappings.add(rb_setAssociative_lru);

		jbg_options_mapping.add(rb_directMapping);
		jbg_options_mapping.add(rb_fullAssociative_fifo);
		jbg_options_mapping.add(rb_fullAssociative_lru);
		jbg_options_mapping.add(rb_setAssociative_fifo);
		jbg_options_mapping.add(rb_setAssociative_lru);
		jbg_options_words = new ButtonGroup();

		jbtn_process = new JButton("Processcle");
		jp_configuration = new JPanel();
		jp_configuration
				.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "CONFIGURATION", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		jp_configuration.setBounds(12, 12, 409, 219);
		contentPane.add(jp_configuration);
		jp_configuration.setLayout(null);

		JButton btn_archhive = new JButton("CLICK");
		btn_archhive.setForeground(new Color(255, 255, 255));
		btn_archhive.setFont(new Font("Serif", Font.BOLD, 10));
		btn_archhive.setBackground(new Color(105, 105, 105));
		btn_archhive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Necessario colocar um numero por linha.\n O arquivo se encontra na pasta Model/MemoryTrace",
						"Alerta", JOptionPane.INFORMATION_MESSAGE);
				try {
					JFileChooser jfc = new JFileChooser();
					String url = getClass().getResource(getClass().getSimpleName()).getPath();
					url = url.substring(0, url.length() - 10) + "/bin/Models/MemoryTrace";
					jfc.setCurrentDirectory(new File(url));
					jfc.setDialogTitle("Carrega Arquivo MemoryTrace");
					jfc.showOpenDialog(jfc);
					MemoryTraceColect.path = jfc.getSelectedFile().getAbsolutePath();

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Erro ao Carregar arquivo", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btn_archhive.setBounds(305, 21, 78, 25);
		jp_configuration.add(btn_archhive);

		JSpinner sp_slotsAmount = new JSpinner();
		sp_slotsAmount.setBounds(305, 58, 78, 25);
		jp_configuration.add(sp_slotsAmount);

		JLabel lblLoadMemorytrace = new JLabel("Load MemoryTrace ::");
		lblLoadMemorytrace.setFont(new Font("Serif", Font.PLAIN, 12));
		lblLoadMemorytrace.setBounds(12, 29, 215, 15);
		jp_configuration.add(lblLoadMemorytrace);

		JLabel lblSlotsAmount = new JLabel("Slots Amount ::");
		lblSlotsAmount.setFont(new Font("Serif", Font.PLAIN, 12));
		lblSlotsAmount.setBounds(12, 68, 215, 15);
		jp_configuration.add(lblSlotsAmount);

		JLabel lblWordSize = new JLabel("Word Size ::");
		lblWordSize.setFont(new Font("Serif", Font.PLAIN, 12));
		lblWordSize.setBounds(12, 102, 215, 15);
		jp_configuration.add(lblWordSize);

		JSpinner sp_wordSize = new JSpinner();
		sp_wordSize.setBounds(305, 95, 78, 25);
		jp_configuration.add(sp_wordSize);

		JLabel lblAssociativyDegree = new JLabel("Associativity Degree ::");
		lblAssociativyDegree.setFont(new Font("Serif", Font.PLAIN, 12));
		lblAssociativyDegree.setBounds(12, 139, 215, 15);
		jp_configuration.add(lblAssociativyDegree);

		JSpinner sp_AD = new JSpinner();
		sp_AD.setBounds(305, 132, 78, 25);
		jp_configuration.add(sp_AD);

		JSlider jsld_timeAcess = new JSlider();
		jsld_timeAcess.setFont(new Font("Serif", Font.PLAIN, 10));
		jsld_timeAcess.setPaintLabels(true);
		jsld_timeAcess.setMajorTickSpacing(100);
		jsld_timeAcess.setMaximum(1000);
		jsld_timeAcess.setMinimum(100);
		jsld_timeAcess.setBounds(162, 166, 235, 30);
		jp_configuration.add(jsld_timeAcess);

		JLabel lblTimeAcess = new JLabel("Time Access in (Ns) ::");
		lblTimeAcess.setFont(new Font("Serif", Font.PLAIN, 12));
		lblTimeAcess.setBounds(12, 181, 147, 15);
		jp_configuration.add(lblTimeAcess);

		jp_results = new JPanel();
		jp_results.setBorder(new TitledBorder(null, "Results", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jp_results.setBounds(12, 491, 645, 185);
		contentPane.add(jp_results);
		jp_results.setLayout(null);

		JTextArea ta_results = new JTextArea(10, 20);
		ta_results.setBounds(12, 12, 556, 146);
		ta_results.setEditable(false);
		JScrollPane jsp = new JScrollPane(ta_results);
		jsp.setBounds(12, 23, 621, 150);
		jp_results.add(jsp);

		JButton bt_save = new JButton("Save");
		bt_save.setForeground(new Color(105, 105, 105));
		bt_save.setBackground(new Color(192, 192, 192));
		bt_save.setBounds(12, 242, 117, 40);
		contentPane.add(bt_save);

		JButton bt_edit = new JButton("Edit");
		bt_edit.setForeground(new Color(105, 105, 105));
		bt_edit.setBackground(new Color(192, 192, 192));
		bt_edit.setBounds(141, 243, 117, 40);
		contentPane.add(bt_edit);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Cache Memory", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panel.setBounds(12, 294, 645, 185);
		contentPane.add(panel);

		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(12, 23, 621, 150);
		panel.add(scrollPane);

		JTextArea ta_cacheMemory = new JTextArea(10, 20);
		ta_cacheMemory.setEditable(false);
		scrollPane.setViewportView(ta_cacheMemory);

		JPanel jp_processOption = new JPanel();
		jp_processOption.setLayout(null);
		jp_processOption.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "PROCESS OPTION", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		jp_processOption.setBounds(433, 178, 222, 52);
		contentPane.add(jp_processOption);

		JRadioButton rdbtnStepByStep = new JRadioButton("Step by Step");
		rdbtnStepByStep.setFont(new Font("Serif", Font.PLAIN, 12));
		rdbtnStepByStep.setBounds(112, 23, 102, 23);
		jp_processOption.add(rdbtnStepByStep);

		JRadioButton rdbtnFast = new JRadioButton("Fast");
		rdbtnFast.setSelected(true);
		rdbtnFast.setFont(new Font("Serif", Font.PLAIN, 12));
		rdbtnFast.setBounds(23, 23, 59, 23);
		jp_processOption.add(rdbtnFast);
		jbg_options_process = new ButtonGroup();
		jbg_options_process.add(rdbtnFast);
		jbg_options_process.add(rdbtnStepByStep);

		JButton btnProcess = new JButton("Process");
		btnProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rb_directMapping.isSelected()) {
					if (rdbtnFast.isSelected()) {
						DirectMapping dm = new DirectMapping(wordSize, slotsAmount, ta_cacheMemory, ta_results);

						dm.fastDirectMapping();

					} else if(rdbtnStepByStep.isSelected()) {
						DirectMapping dm = new DirectMapping(wordSize, slotsAmount, ta_cacheMemory, ta_results);
						dm.slowDirectMapping();
					}

				} else if (rb_fullAssociative_fifo.isSelected()) {

					FullAssociativeMapping fam = new FullAssociativeMapping(wordSize, associativityDegree, ta_cacheMemory, ta_results);
					fam.fifo();
				} else if(rb_fullAssociative_lru.isSelected()) {
					FullAssociativeMapping fam = new FullAssociativeMapping(wordSize, associativityDegree, ta_cacheMemory, ta_results);
					fam.LRU();
				}
			}
		});
		btnProcess.setForeground(new Color(105, 105, 105));
		btnProcess.setFont(new Font("Serif", Font.BOLD, 14));
		btnProcess.setBackground(new Color(144, 238, 144));
		btnProcess.setBounds(433, 242, 222, 40);
		contentPane.add(btnProcess);
		jbg_options_slots = new ButtonGroup();
		jbg_options_process = new ButtonGroup();

		rb_directMapping.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sp_AD.setEnabled(false);
				sp_slotsAmount.setEnabled(true);
			}
		});

		rb_fullAssociative_fifo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sp_AD.setEnabled(true);
				sp_slotsAmount.setEnabled(false);
			}
		});
		rb_fullAssociative_lru.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sp_AD.setEnabled(true);
				sp_slotsAmount.setEnabled(false);
			}
		});
		rb_setAssociative_fifo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sp_AD.setEnabled(true);
				sp_slotsAmount.setEnabled(true);
			}
		});
		rb_setAssociative_lru.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sp_AD.setEnabled(true);
				sp_slotsAmount.setEnabled(true);
			}
		});

		if(rb_directMapping.isSelected()) {
			sp_AD.setEnabled(false);
		}
		btnProcess.setEnabled(false);
		bt_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Functions.desableComponets(jp_configuration, false);
				Functions.desableComponets(jp_mappings, false);
				slotsAmount = (int) sp_slotsAmount.getValue();
				wordSize = (int) sp_wordSize.getValue();
				associativityDegree = (int) sp_AD.getValue();
				timeAcess = jsld_timeAcess.getValue();
				btnProcess.setEnabled(true);

			}
		});
		bt_edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Functions.desableComponets(jp_configuration, true);
				Functions.desableComponets(jp_mappings, true);
				btnProcess.setEnabled(false);
				if(rb_directMapping.isSelected()) {
					sp_AD.setEnabled(false);
					sp_slotsAmount.setEnabled(true);
				} else if(rb_fullAssociative_fifo.isSelected()) {
					sp_AD.setEnabled(true);
					sp_slotsAmount.setEnabled(false);
				} else if (rb_fullAssociative_lru.isSelected()) {
					sp_AD.setEnabled(true);
					sp_slotsAmount.setEnabled(false);
				} else if(rb_setAssociative_fifo.isSelected() || rb_setAssociative_lru.isSelected()) {
					sp_AD.setEnabled(true);
					sp_slotsAmount.setEnabled(true);
				}

			}
		});

	}
}
