import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;


public class FrameMain extends JFrame{
    private JPanel panel1;
    private JButton buttonLoadInputFromFile;
    private JScrollPane scroll1;
    private JTable tableInput;
    private JPanel panel2;
    private JButton buttonExecute;
    private JScrollPane scroll2;
    private JTable tableOutput;
    private JPanel panel3;
    private JButton buttonSaveOutputIntoFile;
    private JPanel panelMain;
    private JFileChooser fileChooserOpen;
    private JFileChooser fileChooserSave;
    private JMenuBar menuBarMain;
    private JMenu menuLookAndFeel;





    public FrameMain() throws FileNotFoundException {
        //TestOpa.runTest();//00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
        this.setTitle("FrameMain");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        JTableUtils.initJTableForArray(tableInput, 100, false, true, false, true);
        JTableUtils.initJTableForArray(tableOutput, 100, false, true, false, true);
        //tableOutput.setEnabled(false);
        tableInput.setRowHeight(25);
        tableOutput.setRowHeight(25);
        scroll1.setPreferredSize(new Dimension(-1, 90));
        scroll2.setPreferredSize(new Dimension(-1, 90));


        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);// мы создали обьект который позволяет выбирать файл, который мы подключем к кнопке



        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");

        menuBarMain = new JMenuBar();
        setJMenuBar(menuBarMain);

        menuLookAndFeel = new JMenu();
        menuLookAndFeel.setText("Вид");
        menuBarMain.add(menuLookAndFeel);
        SwingUtils.initLookAndFeelMenu(menuLookAndFeel);

        //JTableUtils.initJTableForArray(tableInput);

        //this.pack();





        buttonLoadInputFromFile.addActionListener(new ActionListener() {//
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        int[][] arr = ArrayUtils.readIntArray2FromFile(fileChooserOpen.getSelectedFile().getPath());//    колбэк
                        JTableUtils.writeArrayToJTable(tableInput, arr);
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
        buttonExecute.addActionListener(new ActionListener() {//преобразовать 00000000000000000000000000000000000000000000
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[][] arr = JTableUtils.readIntMatrixFromJTable(tableInput);
                    if(arr!=null){
                        if(arr.length == 2){
                            int[] data = MainLogicTask.Process(arr);
                            JTableUtils.writeArrayToJTable(tableOutput, data);
                        }else{
                            System.out.println("Некорректное количество данных");
                        }
                    }else{
                        System.out.println("Данных нет");
                    }
                    //int[] data = MainLogicTask.Process(arr);
                    //JTableUtils.writeArrayToJTable(tableOutput, data);//000000000000000000000000000000000000000000000000
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
        buttonSaveOutputIntoFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        int[] arr = JTableUtils.readIntArrayFromJTable(tableOutput);
                        String file = fileChooserSave.getSelectedFile().getPath();
                        if (!file.toLowerCase().endsWith(".txt")) {
                            file += ".txt";
                        }
                        ArrayUtils.writeArrayToFile(file, arr);
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

    }
    //остальное сюда

}
