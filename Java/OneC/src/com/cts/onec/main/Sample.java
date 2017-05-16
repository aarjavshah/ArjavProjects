package com.cts.onec.main;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
 
public class Sample extends JPanel implements ActionListener{
    
   static private final String newline = "\n";
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel,controlPanel1,controlPanel2;
   JButton openButton, openButton1, saveButton, loginButton, checkLogs, clearLogs;
   static JTextArea log;
   static JTextField oldPath,newPath;
   JFileChooser fc;
   JScrollPane logScrollPane;
   PathBO paths = new PathBO();
   public Sample(){
      prepareGUI();
   }

   public static void main(String[] args){
	   Sample  swingControlDemo = new Sample();      
      swingControlDemo.showTextFieldDemo();
   }

   private void prepareGUI(){
      mainFrame = new JFrame("Java Swing Examples");
      mainFrame.setSize(800,500);
      mainFrame.setLayout(new GridLayout(5, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel = new JLabel("", JLabel.CENTER);        
      //statusLabel = new JLabel("",JLabel.CENTER);    

      //statusLabel.setSize(350,100);

      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());
      controlPanel1= new JPanel();
      controlPanel1.setLayout(new FlowLayout());
      controlPanel2 = new JPanel();
      controlPanel2.setLayout(new FlowLayout());
      logScrollPane = new JScrollPane();
      log = new JTextArea(5,20);
      log.setSize(800, 200);
      log.setMargin(new Insets(5,5,5,5));
      log.setEditable(false);
      logScrollPane = new JScrollPane(log);
      JScrollBar bar = logScrollPane.getVerticalScrollBar();
      bar.setPreferredSize(new Dimension(20, 0));
      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(controlPanel1);
      mainFrame.add(controlPanel2);
      //mainFrame.add(statusLabel);
      mainFrame.add(logScrollPane);
      mainFrame.setVisible(true);  
   }

   private void showTextFieldDemo(){
      headerLabel.setText("Migration Tool"); 

      JLabel  namelabel= new JLabel("Path to Old Workspace: ", JLabel.RIGHT);
      JLabel  passwordLabel = new JLabel("Update and save to: ", JLabel.CENTER);
      oldPath = new JTextField(25);
      newPath = new JTextField(25);      
      
      fc = new JFileChooser();
      fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
     
//      new ActionListener() {
//         public void actionPerformed(ActionEvent e) {     
//            String data = "Username " + userText.getText();
//            data += ", Password: " 
//            + new String(passwordText.getPassword()); 
//            statusLabel.setText(data);        
//         }
//      }); 
      openButton = new JButton("Browse");
      openButton.addActionListener(this);
      openButton1 = new JButton("Browse");
      openButton1.addActionListener(this);
      loginButton = new JButton("Check Issues");
      loginButton.addActionListener(this);
      checkLogs = new JButton("Check Logs");
      checkLogs.addActionListener(this);
      saveButton = new JButton("Migrate");
      saveButton.addActionListener(this);
      clearLogs = new JButton("Clear");
      clearLogs.addActionListener(this);
      controlPanel.add(namelabel);
      controlPanel.add(oldPath);
      controlPanel.add(openButton);
      controlPanel1.add(passwordLabel);       
      controlPanel1.add(newPath);
      controlPanel1.add(openButton1);
      controlPanel2.add(loginButton);
      controlPanel2.add(checkLogs);
      controlPanel2.add(saveButton);
      controlPanel2.add(clearLogs);
      mainFrame.setVisible(true);  
   }

@Override
public void actionPerformed(ActionEvent e) {
	if (e.getSource() == openButton) {
        int returnVal = fc.showOpenDialog(Sample.this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            oldPath.setText(file.getAbsolutePath());
            paths.setInPath(file.getAbsolutePath());
            //This is where a real application would open the file.
            log.append("Setting Input Workspace Directory: " + file.getAbsolutePath() + "." + newline);
        } else {
            log.append("Input workspace selection cancelled.." + newline);
        }
        log.setCaretPosition(log.getDocument().getLength());

    //Handle save button action.
    }else if (e.getSource() == openButton1) {
        int returnVal = fc.showOpenDialog(Sample.this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            newPath.setText(file.getAbsolutePath());
//            paths.setOutPath(file.getAbsolutePath());
            //This is where a real application would open the file.
            log.append("Setting Output Workspace Directory: " + file.getAbsolutePath() + "." + newline);
        } else {
            log.append("Output workspace selection cancelled." + newline);
        }
        log.setCaretPosition(log.getDocument().getLength());
    //Handle save button action.
    }else if (e.getSource() == loginButton) {
    	if(oldPath.getText()==null || newPath.getText()==null||oldPath.getText().isEmpty()||newPath.getText().isEmpty()){
    		log.append("Please Select Directories for Input and Output Workspaces"+newline);
    	}else{
    		paths.setInPath(oldPath.getText());
    		paths.setOutPath(newPath.getText());
    		Execute(paths.getInPath(), paths.getOutPath(),"MigrateCheck.py");}
    	//    	Sample1.Test();
    	//batchExecute();
//        int returnVal = fc.showSaveDialog(Sample.this);
//        if (returnVal == JFileChooser.APPROVE_OPTION) {
//            File file = fc.getSelectedFile();
//            //This is where a real application would save the file.
//            log.append("Saving: " + file.getName() + "." + newline);
//        } else {
//            log.append("Save command cancelled by user." + newline);
//        }
//        log.setCaretPosition(log.getDocument().getLength());
    }else if(e.getSource() == saveButton){
    	if(oldPath.getText()==null || newPath.getText()==null||oldPath.getText().isEmpty()||newPath.getText().isEmpty()){
    		log.append("Please Select Directories for Input and Output Workspaces"+newline);
    	}else{
    		paths.setInPath(oldPath.getText());
    		paths.setOutPath(newPath.getText());
    		Execute(paths.getInPath(), paths.getOutPath(),"MigrateExec.py");
    		}
    }
    else if(e.getSource() == checkLogs){//checkLogs
    	File report = new File(oldPath.getText()+"Report.txt");
    	if(report.exists()){
    		ProcessBuilder pb = new ProcessBuilder("Notepad.exe", report.getAbsolutePath());
    		try {
				pb.start();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

    	}else{
    		log.append("Please check for issues first to get the analysis report on the existing workspace."+newline);
    	}
    }
    else if(e.getSource() == clearLogs){//checkLogs
    	log.setText(null);
    }
}

public static void Execute(String in,String out,String cmd){
	try
	{
		Runtime rt = Runtime.getRuntime();

		//String command = "C:\\Python27\\python.exe"; 
				//"C:\\Users\\aarjav.shah\\Desktop\\OneClick\\OneClickMigration\\Migration.bat C:\\Users\\aarjav.shah\\Desktop\\OneClickMig\\Inputs C:\\Users\\aarjav.shah\\Desktop\\OneClickMig\\Outputs";
		//command = "cmd";
		Process pr = new ProcessBuilder("C:\\Python27\\python.exe",cmd,"-i",in,"-o",out).start();
				//rt.exec(command);

		BufferedReader processOutput = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		BufferedWriter processInput = new BufferedWriter(new OutputStreamWriter(pr.getOutputStream()));
		//Thread.sleep(5000);
		//String commandToSend = "echo arjav";
		//commandToSend = "dir\n" + "exit\n";

		//processInput.write(commandToSend);
		//processInput.flush();
		//Thread.sleep(1000);
		//String commandToSend = "y";
		//processInput.write(commandToSend);
		//processInput.flush();
		//int lineCounter = 0;
		while(true)
		{
			String line = processOutput.readLine();
			if(line == null) break;
			log.append(line+newline);
		}

		processInput.close();
		processOutput.close();
		pr.waitFor();
	}
	catch(Exception x)
	{
		x.printStackTrace();
	}

}
}
