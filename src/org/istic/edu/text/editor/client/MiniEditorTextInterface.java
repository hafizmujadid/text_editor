package org.istic.edu.text.editor.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.istic.edu.text.editor.cmd.*;
import org.istic.edu.text.editor.invoker.CommandInvoker;
import org.istic.edu.text.editor.receiver.*;

public class MiniEditorTextInterface {
	static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

	// Direct reference to MiniEditor (for V1 only)
	static EditorEngine editorEngine = new EditorEngineStub();

	public static void main(String[] args) {
		// Create Editor engine
		EditorEngine engine = new EditorEngineStub();
		Selection selection = null;

		// commands to be done
		CopyCommand copy = null;
		CutCommand cut = null;
		PasteCommand paste = null;
		InsertCommand insert = null;
		DeleteCommand delete = null;
		CommandInvoker invoker= null;
		SelectCommand select= null;

		String inputLine;
		char commandLetter;

		System.out.println("Welcome to MiniEditor V1.0");
		System.out.println("-----------------------------------------------------------");
		System.out.println("Please provide input in the form of command inputs  like I hello world");
		System.out.println("Enter command (I/S/C/X/V/D/R/E/P/Z/Y/Q) > ");
		try {
			inputLine = keyboard.readLine();
		} catch (IOException e) {
			System.out.println("Unable to read standard input");
			inputLine = "W";
		}
		if (inputLine.isEmpty()) {
			commandLetter = '0';
		} else {
			commandLetter = Character.toUpperCase(inputLine.charAt(0));
		}
		while (commandLetter != 'Q') /* Quit */
		{
			switch (commandLetter) {
			case '0':
				break;
			case 'I': /* Insert */
				insert= new InsertCommand(engine, inputLine.substring(2));
				invoker.setCommand(insert);
				invoker.storeAndExecute();
				break;
			case 'S': /* Select */
				String numberString = "";
				try {
					String[] arguments = inputLine.substring(2).split("\\s+");
					numberString = arguments[0];
					int start = Integer.parseInt(numberString);
					numberString = arguments[1];
					int stop = Integer.parseInt(numberString);
					selection.setStart(start);
					selection.setStop(stop);
					select= new SelectCommand(engine, selection);
					invoker.setCommand(select);
					invoker.storeAndExecute();
				} catch (Exception e) {
					System.out.println("Invalid number: " + numberString);
				}
				break;
			case 'C': /* Copy */
				copy= new CopyCommand(engine);
				invoker.setCommand(copy);
				invoker.storeAndExecute();
				break;
			case 'X': /* cut */
				cut= new CutCommand(engine);
				invoker.setCommand(cut);
				invoker.storeAndExecute();
				break;
			case 'V': /* paste */
				paste= new PasteCommand(engine);
				invoker.setCommand(paste);
				invoker.storeAndExecute();
				break;
			case 'D': /* Delete, i.e. insert empty string */
				delete= new DeleteCommand(engine);
				invoker.setCommand(delete);
				invoker.storeAndExecute();
				break;
			case 'R': /* start Recording */
				// Insert your code here (V2)
				break;
			case 'E': /* End recording */
				// Insert your code here (V2)
				break;
			case 'P': /* Play recording */
				// Insert your code here (V2)
				break;
			case 'Z': /* undo */
				// Insert your code here (V3)
				break;
			case 'Y': /* redo */
				// Insert your code here (V3)
				break;
			default:
				System.out.println("Unrecognized command, please try again:");
				break;
			}
			System.out.println("-----------------------------------------------------");
			System.out.println("[" + editorEngine.getBuffer() + "]");
			System.out.println("-----------------------------------------------------");
			System.out.println("[" + editorEngine.getSelection() + "]");
			System.out.println("-----------------------------------------------------");
			System.out.println("[" + editorEngine.getClipboard() + "]");
			System.out.println("-----------------------------------------------------");

			System.out.println("Enter command (I/S/C/X/V/D/R/E/P/Z/Y/Q) > ");
			try {
				inputLine = keyboard.readLine();
			} catch (IOException e) {
				System.out.println("Unable to read standard input");
				inputLine = "W";
			}
			if (inputLine.isEmpty()) {
				commandLetter = '0';
			} else {
				commandLetter = Character.toUpperCase(inputLine.charAt(0));
			}
		}
		System.out.println("Goodbye");
	}
}
