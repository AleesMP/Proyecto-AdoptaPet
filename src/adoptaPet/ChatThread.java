package adoptaPet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.swing.JTextArea;

public class ChatThread extends Thread {
	BufferedReader inputClient;
	JTextArea chatArea;

	public ChatThread(BufferedReader inputClient,JTextArea chatArea) {
		this.inputClient = inputClient;
		this.chatArea = chatArea;
	}

	public void run() {
		while (true) {
			try {
				chatArea.append("\n" + inputClient.readLine());
			}

			catch (IOException e) {
				System.out.println(e);
			}
		}
	}

}