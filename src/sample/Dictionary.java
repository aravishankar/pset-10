package sample;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.event.ListSelectionEvent;
import javax.swing.BorderFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.Font;

//To be, or not to be, that is the question:
//Whether 'tis nobler in the mind to suffer
//The slings and arrows of outrageous fortune,
//Or to take arms against a sea of troubles
//And by opposing end them. To die—to sleep,

public class Dictionary {

	private JFrame frmDictionary;
	private JTextField txtSearch;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;
	private JTextField txtDefinitions;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTextField textField_3;

	public static void main(String[] args) throws FileNotFoundException {
		getWords();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dictionary window = new Dictionary();
					window.frmDictionary.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static DefaultListModel<String> getWords() throws FileNotFoundException {
		Gson gson = new Gson();
		String classpathDirectory = Utils.getClasspathDir();
		BufferedReader br = new BufferedReader(new FileReader(classpathDirectory + "words.json"));
		Word[] words = gson.fromJson(br, Word[].class);
		DefaultListModel<String> listOfWords = new DefaultListModel<String>();
		for (Word word : words) {
			listOfWords.addElement(word.getWord().toLowerCase());
		}
		;
		return Utils.sortWordsAsc(listOfWords);
	}

	private static ArrayList<Word> getWordClass() throws FileNotFoundException {
		Gson gson = new Gson();
		String classpathDirectory = Utils.getClasspathDir();
		BufferedReader br = new BufferedReader(new FileReader(classpathDirectory + "words.json"));
		Word[] words = gson.fromJson(br, Word[].class);
		ArrayList<Word> listOfWords = new ArrayList<Word>();
		for (Word word : words) {
			listOfWords.add(word);
		}
		;
		return listOfWords;
	}

	public Dictionary() throws FileNotFoundException, BadLocationException {
		initialize();
	}

	private void initialize() throws FileNotFoundException, BadLocationException {
		frmDictionary = new JFrame();
		frmDictionary.getContentPane().setBackground(Color.PINK);
		frmDictionary.setResizable(false);
		frmDictionary.setTitle("Dictionary");
		frmDictionary.setBounds(100, 100, 800, 600);
		frmDictionary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDictionary.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(207, 11, 566, 549);
		frmDictionary.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));

		JScrollPane scrollPane_3 = new JScrollPane();
		panel.add(scrollPane_3, "addWord");

		JPanel panel_1 = new JPanel();
//		panel_1.setToolTipText("");
		panel_1.setBackground(new Color(255, 255, 255));
		scrollPane_3.setViewportView(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Word*");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
		lblNewLabel.setBounds(10, 11, 117, 54);
		panel_1.add(lblNewLabel);

		textField = new JTextField();
		textField.setFont(new Font("Lato", Font.PLAIN, 11));
		textField.setBackground(new Color(230, 230, 250));
//		textField.setToolTipText("word");
		textField.setBounds(20, 76, 286, 20);
		panel_1.add(textField);
		textField.setColumns(10);

		JButton btnNewButton_2 = new JButton("Add");
		btnNewButton_2.setFont(new Font("Impact", Font.PLAIN, 36));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(255, 0, 0));
		btnNewButton_2.setBounds(427, 11, 127, 127);
		panel_1.add(btnNewButton_2);

		JLabel lblDefinitions = new JLabel("Definitions*");
		lblDefinitions.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
		lblDefinitions.setBounds(10, 107, 199, 54);
		panel_1.add(lblDefinitions);

		txtDefinitions = new JTextField();
		txtDefinitions.setFont(new Font("Lato", Font.PLAIN, 11));
		txtDefinitions.setBackground(new Color(230, 230, 250));
//		txtDefinitions.setToolTipText("Definitions");
		txtDefinitions.setColumns(10);
		txtDefinitions.setBounds(20, 182, 286, 20);
		panel_1.add(txtDefinitions);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Lato", Font.PLAIN, 11));
		textField_2.setBackground(new Color(230, 230, 250));
//		textField_2.setToolTipText("Part of Speech");
		textField_2.setColumns(10);
		textField_2.setBounds(20, 482, 147, 20);
		panel_1.add(textField_2);

		JLabel lblPartOfSpech = new JLabel("Parts of Speech*");
		lblPartOfSpech.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblPartOfSpech.setBounds(20, 437, 157, 20);
		panel_1.add(lblPartOfSpech);

		JLabel lblSynonyms = new JLabel("Synonyms");
		lblSynonyms.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
		lblSynonyms.setBounds(10, 213, 184, 54);
		panel_1.add(lblSynonyms);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Lato", Font.PLAIN, 11));
		textField_1.setBackground(new Color(230, 230, 250));
//		textField_1.setToolTipText("synonym");
		textField_1.setColumns(10);
		textField_1.setBounds(20, 287, 286, 20);
		panel_1.add(textField_1);

		JLabel lblSeperateByComma = new JLabel("Seperate by comma");
		lblSeperateByComma.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblSeperateByComma.setBounds(20, 264, 137, 20);
		panel_1.add(lblSeperateByComma);

		JLabel label = new JLabel("Seperate by comma");
		label.setFont(new Font("Calibri", Font.PLAIN, 12));
		label.setBounds(20, 157, 137, 20);
		panel_1.add(label);

		JLabel label_1 = new JLabel("Seperate by comma");
		label_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		label_1.setBounds(20, 457, 137, 20);
		panel_1.add(label_1);

		JLabel lblAntonyms = new JLabel("Antonyms");
		lblAntonyms.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
		lblAntonyms.setBounds(10, 318, 184, 54);
		panel_1.add(lblAntonyms);

		JLabel label_2 = new JLabel("Seperate by comma");
		label_2.setFont(new Font("Calibri", Font.PLAIN, 12));
		label_2.setBounds(20, 369, 137, 20);
		panel_1.add(label_2);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Lato", Font.PLAIN, 11));
		textField_3.setBackground(new Color(230, 230, 250));
//		textField_3.setToolTipText("antonyms");
		textField_3.setColumns(10);
		textField_3.setBounds(20, 400, 286, 20);
		panel_1.add(textField_3);

		JLabel lblRequred = new JLabel("* = required field");
		lblRequred.setFont(new Font("DialogInput", Font.PLAIN, 20));
		lblRequred.setBounds(329, 516, 225, 20);
		panel_1.add(lblRequred);

		JScrollPane scrollPane_2 = new JScrollPane();
		panel.add(scrollPane_2, "defintions");

		CardLayout cardLayout = (CardLayout) panel.getLayout();
		cardLayout.show(panel, "defintions");

		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		scrollPane_2.setViewportView(textPane);

		StyledDocument doc = textPane.getStyledDocument();
		DefaultCaret caret = (DefaultCaret) textPane.getCaret();
		caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
		textPane.setBorder(BorderFactory.createCompoundBorder(textPane.getBorder(),
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));

		Style bigWord = textPane.addStyle("Style", null);
		Style header = textPane.addStyle("Style", null);
		StyleConstants.setFontSize(header, 20);
		StyleConstants.setFontSize(bigWord, 36);
		StyleConstants.setBold(bigWord, true);

		doc.remove(0, doc.getLength());
		doc.insertString(doc.getLength(), "Example Word\n", bigWord);
		doc.insertString(doc.getLength(), "\n", null);
		doc.insertString(doc.getLength(), "Definitions\n", header);
		doc.insertString(doc.getLength(), "\n", null);
		doc.insertString(doc.getLength(), "1. Example Word (pos) \n\n    Definition of example word\n\n", null);
		doc.insertString(doc.getLength(), "\n", null);
		doc.insertString(doc.getLength(), "Synonyms\n", header);
		doc.insertString(doc.getLength(), "\n1.Synonym ", null);
		doc.insertString(doc.getLength(), "\n\n", null);
		doc.insertString(doc.getLength(), "Antonyms\n", header);
		doc.insertString(doc.getLength(), "\n1.Antonym ", null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 114, 179, 446);
		frmDictionary.getContentPane().add(scrollPane_1);

		JList<String> list = new JList<String>();
		list.addListSelectionListener(new ListSelectionListener() {
			boolean ranOnce = false;

			public void valueChanged(ListSelectionEvent arg0) {
				if (ranOnce) {
					ranOnce = false;
				} else {
					ranOnce = true;

					String selectedWord = list.getSelectedValue();

					try {
						ArrayList<Word> Words = getWordClass();
						for (Word word : Words) {
							if (word.getWord().equals(selectedWord)) {
								doc.remove(0, doc.getLength());
								doc.insertString(doc.getLength(),
										selectedWord.substring(0, 1).toUpperCase() + selectedWord.substring(1) + "\n",
										bigWord);
								doc.insertString(doc.getLength(), "\n", null);
								doc.insertString(doc.getLength(), "Definitions\n", header);
								doc.insertString(doc.getLength(), "\n", null);
								Definition[] definitions = word.getDefinitions();
								int definitionCounter = 1;
								for (Definition definition : definitions) {
									doc.insertString(doc.getLength(),
											definitionCounter + "." + selectedWord + " (" + definition.getPartOfSpeech()
													+ ")\n\n    " + definition.getDefinition() + "\n\n",
											null);
									definitionCounter++;
								}
								String[] synonyms = word.getSynonyms();
								if (synonyms != null && synonyms.length != 0) {
									doc.insertString(doc.getLength(), "Synonyms\n", header);
									doc.insertString(doc.getLength(), "\n", null);
									int synonymCounter = 1;
									for (String synonym : synonyms) {

										doc.insertString(doc.getLength(), synonymCounter + "." + synonym + "\n", null);
										synonymCounter++;
									}
								}
								String[] antonyms = word.getAntonyms();
								if (antonyms != null && antonyms.length != 0) {
									doc.insertString(doc.getLength(), "\n", null);
									doc.insertString(doc.getLength(), "Antonyms\n", header);
									doc.insertString(doc.getLength(), "\n", null);
									int antonymCounter = 1;
									for (String antonym : antonyms) {
										doc.insertString(doc.getLength(), antonymCounter + "." + antonym + "\n", null);
										antonymCounter++;
									}
								}

							}
						}
					} catch (FileNotFoundException | BadLocationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		scrollPane_1.setViewportView(list);

		DefaultListModel<String> DLM = getWords();

		list.setModel(DLM);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Asc");
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Desc");

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
//	      add
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panel, "addWord");
				textField.setText("");
				txtDefinitions.setText("");
				textField_2.setText("");
				textField_1.setText("");
				textField_3.setText("");

			}
		});
		btnNewButton.setBounds(2, 11, 89, 23);
		frmDictionary.getContentPane().add(btnNewButton);

		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String word = textField.getText().toLowerCase();
				String definitionInput = txtDefinitions.getText().toLowerCase();
				String posInput = textField_2.getText().toLowerCase();
				String synonymInput = textField_1.getText().toLowerCase();
				String antonymsInput = textField_3.getText().toLowerCase();
				word = word.trim();
				if (!word.equals("") && !definitionInput.equals("") && !posInput.equals("")) {
					ArrayList<Word> wordList = new ArrayList<Word>();
					try {
						wordList = getWordClass();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					String[] definitions = definitionInput.split("\\s*,\\s*");
					String[] poss = posInput.split("\\s*,\\s*");
					String[] synonyms = synonymInput.split("\\s*,\\s*");
					String[] antonyms = antonymsInput.split("\\s*,\\s*");

					if (definitions.length == poss.length) {
						Definition[] deffs = new Definition[definitions.length];
						for (int i = 0; i < definitions.length; i++) {
							deffs[i] = new Definition(definitions[i], poss[i]);
						}
						if (synonymInput.equals("")) {
							synonyms = null;
						}
						if (antonymsInput.equals("")) {
							antonyms = null;
						}
						Word wordToAdd = new Word(word, deffs, synonyms, antonyms);
						wordList.add(wordToAdd);
						Gson gson = new GsonBuilder().setPrettyPrinting().create();
						String classpathDirectory = Utils.getClasspathDir();
						try (FileWriter writer = new FileWriter(classpathDirectory + "words.json")) {
							gson.toJson(wordList, writer);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						DefaultListModel<String> DLM = null;
						if (!rdbtnNewRadioButton.isSelected()) {
							try {
								DLM = Utils.reverseOrder(getWords());
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}

						} else {
							try {
								DLM = getWords();
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						list.setModel(DLM);
					} else {
						JOptionPane.showMessageDialog(null, "Amount of definitions and parts of speech do not match!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Required field was left empty!");
				}

				cardLayout.show(panel, "defintions");
			}
		});

		JButton btnNewButton_1 = new JButton("Remove");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<String> selectedWords = list.getSelectedValuesList();
				try {
					Boolean wordFound = false;
					ArrayList<Word> words = getWordClass();
					ArrayList<Word> wordsToRemove = new ArrayList<Word>();
					for (String selectedWord : selectedWords) {
						for (Word word : words) {
							if (selectedWord.equals(word.getWord())) {
								wordsToRemove.add(word);
								wordFound = true;
							}
						}
					}
					if (wordFound) {
						int dialogResult = JOptionPane.showConfirmDialog(null,
								"Are you sure you want to delete the following word(s)\nfrom the ditionary?\n\nThis action cannot be undone.\n\n",
								"Warning", JOptionPane.YES_NO_OPTION);
						if (dialogResult == JOptionPane.YES_OPTION) {
							for (Word word : wordsToRemove) {
								words.remove(word);
							}
						}

						Gson gson = new GsonBuilder().setPrettyPrinting().create();
						String classpathDirectory = Utils.getClasspathDir();
						try (FileWriter writer = new FileWriter(classpathDirectory + "words.json")) {
							gson.toJson(words, writer);
						} catch (IOException e) {
							e.printStackTrace();
						}

					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				DefaultListModel<String> DLM = null;
				try {
					if (!rdbtnNewRadioButton.isSelected()) {
						try {
							DLM = Utils.reverseOrder(getWords());
						} catch (FileNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}

					} else {
						try {
							DLM = getWords();
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					list.setModel(DLM);
					txtSearch.setText("");
					doc.remove(0, doc.getLength());
					doc.insertString(doc.getLength(), "Example Word\n", bigWord);
					doc.insertString(doc.getLength(), "\n", null);
					doc.insertString(doc.getLength(), "Definitions\n", header);
					doc.insertString(doc.getLength(), "\n", null);
					doc.insertString(doc.getLength(), "1. Example Word (pos) \n\n    Definition of example word\n\n",
							null);
					doc.insertString(doc.getLength(), "\n", null);
					doc.insertString(doc.getLength(), "Synonyms\n", header);
					doc.insertString(doc.getLength(), "\n1.Synonym ", null);
					doc.insertString(doc.getLength(), "\n\n", null);
					doc.insertString(doc.getLength(), "Antonyms\n", header);
					doc.insertString(doc.getLength(), "\n1.Antonym ", null);
				} catch (BadLocationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		btnNewButton_1.setBounds(101, 11, 89, 23);
		frmDictionary.getContentPane().add(btnNewButton_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(490, 332, -57, -98);
		frmDictionary.getContentPane().add(scrollPane);

		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(36, 78, 59, 23);
		frmDictionary.getContentPane().add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setSelected(true);

		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(110, 78, 59, 23);
		frmDictionary.getContentPane().add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {

				int state = event.getStateChange();
				if (state == ItemEvent.SELECTED) {
					try {
						txtSearch.setText("");
						list.setModel(Utils.reverseOrder(getWords()));
						doc.remove(0, doc.getLength());
						doc.insertString(doc.getLength(), "Example Word\n", bigWord);
						doc.insertString(doc.getLength(), "\n", null);
						doc.insertString(doc.getLength(), "Definitions\n", header);
						doc.insertString(doc.getLength(), "\n", null);
						doc.insertString(doc.getLength(),
								"1. Example Word (pos) \n\n    Definition of example word\n\n", null);
						doc.insertString(doc.getLength(), "\n", null);
						doc.insertString(doc.getLength(), "Synonyms\n", header);
						doc.insertString(doc.getLength(), "\n1.Synonym ", null);
						doc.insertString(doc.getLength(), "\n\n", null);
						doc.insertString(doc.getLength(), "Antonyms\n", header);
						doc.insertString(doc.getLength(), "\n1.Antonym ", null);
					} catch (FileNotFoundException | BadLocationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else if (state == ItemEvent.DESELECTED) {
					try {
						txtSearch.setText("");
						list.setModel(getWords());
						doc.remove(0, doc.getLength());
						doc.insertString(doc.getLength(), "Example Word\n", bigWord);
						doc.insertString(doc.getLength(), "\n", null);
						doc.insertString(doc.getLength(), "Definitions\n", header);
						doc.insertString(doc.getLength(), "\n", null);
						doc.insertString(doc.getLength(),
								"1. Example Word (pos) \n\n    Definition of example word\n\n", null);
						doc.insertString(doc.getLength(), "\n", null);
						doc.insertString(doc.getLength(), "Synonyms\n", header);
						doc.insertString(doc.getLength(), "\n1.Synonym ", null);
						doc.insertString(doc.getLength(), "\n\n", null);
						doc.insertString(doc.getLength(), "Antonyms\n", header);
						doc.insertString(doc.getLength(), "\n1.Antonym ", null);
					} catch (FileNotFoundException | BadLocationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		});

		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String searched = txtSearch.getText().toLowerCase();
				DefaultListModel<String> words = new DefaultListModel<String>();
				if (!rdbtnNewRadioButton.isSelected()) {
					try {
						words = Utils.reverseOrder(getWords());
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

				} else {
					try {
						words = getWords();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				DefaultListModel<String> filtered = new DefaultListModel<String>();
				for (int i = 0; i < words.size(); i++) {
					if ((words.get(i).startsWith(searched))) {
						filtered.addElement(words.get(i));
					}
				}
				list.setModel(filtered);
				try {
					doc.remove(0, doc.getLength());
					doc.insertString(doc.getLength(), "Example Word\n", bigWord);
					doc.insertString(doc.getLength(), "\n", null);
					doc.insertString(doc.getLength(), "Definitions\n", header);
					doc.insertString(doc.getLength(), "\n", null);
					doc.insertString(doc.getLength(), "1. Example Word (pos) \n\n    Definition of example word\n\n",
							null);
					doc.insertString(doc.getLength(), "\n", null);
					doc.insertString(doc.getLength(), "Synonyms\n", header);
					doc.insertString(doc.getLength(), "\n1.Synonym ", null);
					doc.insertString(doc.getLength(), "\n\n", null);
					doc.insertString(doc.getLength(), "Antonyms\n", header);
					doc.insertString(doc.getLength(), "\n1.Antonym ", null);
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
//		txtSearch.setToolTipText("Search");
		txtSearch.setBounds(12, 45, 179, 20);
		frmDictionary.getContentPane().add(txtSearch);
		txtSearch.setColumns(10);
	}
}