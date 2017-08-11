package marc_SWTFinalTask;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import models.Word;
import models.WordParser;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;

public class WordCounterUI {

	protected Shell shell;
	private Text text;
	private Composite compositeResultTable;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			WordCounterUI window = new WordCounterUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(790,581);
		shell.setText("SWT Application");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite = new Composite(shell, SWT.NONE);
		
		Composite compositeInput = new Composite(composite, SWT.NONE);
		compositeInput.setBounds(33, 47, 361, 193);
		
		text = new Text(compositeInput, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		text.setBounds(10, 47, 312, 101);
		
		Label lblInputText = new Label(compositeInput, SWT.NONE);
		lblInputText.setBounds(10, 26, 55, 15);
		lblInputText.setText("Input text:");
		
		Button btnNewButton = new Button(compositeInput, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				// there will be a method that has input the text and output an word[] array
				WordParser wp = WordParser.getInstance();
//				Word[] words = wp.getWords(text.getText());
				
				// some values for testing
				Word word1 = new Word("Jora", 5, 21.5);
				Word word2 = new Word("Fedea", 3, 24.6);
				Word word3 = new Word("grisha", 5, 21.5);
				Word word4 = new Word("aleosha", 9, 9.8);
				
				Word[] words = {word1, word2, word3, word4};
				
				
				for (Word word : words) {
					Label l1 = new Label(compositeResultTable, SWT.NONE);
					l1.setText(word.getName());
					l1.getParent().layout();
					
					Label l2 = new Label(compositeResultTable, SWT.NONE);
					l2.setText("" + word.getFrequency());
					l2.getParent().layout();
					
					Label l3 = new Label(compositeResultTable, SWT.NONE);
					l3.setText("" + word.getRate() + "%");
					l3.getParent().layout();
				}
				
			}
		});
		btnNewButton.setBounds(10, 158, 75, 25);
		btnNewButton.setText("Process");
		
		Composite composite_1 = new Composite(shell, SWT.NONE);
		composite_1.setLayout(new FormLayout());
		
		compositeResultTable = new Composite(composite_1, SWT.BORDER);
		FormData fd_compositeResultTable = new FormData();
		fd_compositeResultTable.bottom = new FormAttachment(100, -48);
		fd_compositeResultTable.left = new FormAttachment(0, 36);
		fd_compositeResultTable.top = new FormAttachment(0, 59);
		fd_compositeResultTable.right = new FormAttachment(0, 322);
		compositeResultTable.setLayoutData(fd_compositeResultTable);
		compositeResultTable.setLayout(new GridLayout(3, false));
		
		Label lblWord = new Label(compositeResultTable, SWT.NONE);
		GridData gd_lblWord = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblWord.widthHint = 110;
		lblWord.setLayoutData(gd_lblWord);
		lblWord.setText("Word");
		
		
		Label lblFrequency = new Label(compositeResultTable, SWT.NONE);
		GridData gd_lblFrequency = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblFrequency.widthHint = 70;
		lblFrequency.setLayoutData(gd_lblFrequency);
		lblFrequency.setText("Frequency");
		
		Label lblRate = new Label(compositeResultTable, SWT.NONE);
		GridData gd_lblRate = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblRate.widthHint = 70;
		lblRate.setLayoutData(gd_lblRate);
		lblRate.setText("Rate (%)");
		
	}

}
