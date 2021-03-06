package sample;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class Utils {

	public static String getClasspathDir() {
		String classpath = System.getProperty("java.class.path", ".");
		boolean windows = false;
		if (classpath.matches(".*\\\\.*")) {
			windows = true;
		}
		if (windows) {
			String[] splitClasspathDir = classpath.split(";");
			String classpathDirectory = "";
			for (String s : splitClasspathDir) {
				if (s.matches(".*lib\\\\.*")) {
					classpathDirectory = s;
				}
			}
			return classpathDirectory;
		} else {
			String[] splitClasspathDir = classpath.split(":");
			String classpathDirectory = "";
			for (String s : splitClasspathDir) {
				if (s.matches(".*lib/.*")) {
					classpathDirectory = s;
				}
			}
			return classpathDirectory;
		}
	}

//  Sorts DLM in ascending order
	public static DefaultListModel<String> sortWordsAsc(DefaultListModel<String> wordList) {
		String temp;
		int n = wordList.getSize();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if ((wordList.get(i).compareTo(wordList.get(j)) > 0)) {
					temp = wordList.get(i);
					wordList.set(i, wordList.get(j));
					wordList.set(j, temp);
				}
			}
		}
		return wordList;
	}

//  Reverse the order of a DLM
	public static DefaultListModel<String> reverseOrder(DefaultListModel<String> words) {
		DefaultListModel<String> b = new DefaultListModel<String>();
		int n = words.getSize();
		int j = n;
		for (int i = 0; i < n; i++) {
			b.addElement(words.get(j - 1));
			j = j - 1;
		}
		return b;
	}

	public static ArrayList<Word> reverseOrderArrayList(ArrayList<Word> words) {
		ArrayList<Word> b = new ArrayList<Word>();
		int n = words.size();
		int j = n;
		for (int i = 0; i < n; i++) {
			b.add(words.get(j - 1));
			j = j - 1;
		}
		return b;
	}

}
