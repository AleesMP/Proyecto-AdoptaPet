package adoptaPet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.swing.JTextArea;

public class ChatThread extends Thread {
	BufferedReader input;
	JTextArea chatArea;

	public ChatThread(BufferedReader input,JTextArea chatArea) {
		this.input = input;
		this.chatArea = chatArea;
	}

	public void run() {
		while (true) {
			try {
				chatArea.append("\n" + input.readLine());
			}

			catch (IOException e) {
				System.out.println(e);
			}
		}
	}

}