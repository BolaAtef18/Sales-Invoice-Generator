package SalesInvoiceGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.jar.JarFile;
import javax.swing.GroupLayout;


public class SIG extends JFrame implements ActionListener {
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem openMenuItem;
    private JMenuItem saveMenuItem;
    private JMenuItem exitMenuItem;
    private JTable table;
    private String[] cols1 = {"NO.", "Date", "Customer", "Total"};

    private String[][] Invoice_Table = {
            {"", "", "", ""},
            {"", "", "", ""},
            {"", "", "", ""}
    };

    private String[] cols2 = {"NO.", "Item Name", "Item Price", "Count", "Item Total"};

    private String[][] Invoice_Items = {
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""}
    };
    private JButton CNI;
    private JButton DI;

    private JButton Save;
    private JButton Cancel;

    private JTextField InvoiceDate;
    private JTextField CustomerName;

    private JLabel InvoiceNumber;

    private JLabel InvoiceTable;

    private JLabel InvoiceTotal;

    private JLabel InvoiceItems;


    public SIG() {
        super("Sales Invoice Generator");
        setLayout(new FlowLayout());

        InvoiceTable = new JLabel();
        add(new JLabel("Invoice Table"));
        add(InvoiceTable);

        table = new JTable(Invoice_Table, cols1);
        add(new JScrollPane(table));

        CNI = new JButton("Create New Invoice");
        add(CNI);
        CNI.addActionListener(this);


        DI = new JButton("Delet Invoice");
        add(DI);


        InvoiceNumber = new JLabel();
        add(new JLabel("Invoice Number"));
        add(InvoiceNumber);

        InvoiceDate = new JTextField(30);
        add(new JLabel("Invoice Date"));
        add(InvoiceDate);

        CustomerName = new JTextField(30);
        add(new JLabel("Customer Name"));
        add(CustomerName);

        InvoiceTotal = new JLabel();
        add(new JLabel("Invoice Total"));
        add(InvoiceTotal);

        InvoiceItems = new JLabel();
        add(new JLabel("Invoice Items"));
        add(InvoiceItems);

        table = new JTable(Invoice_Items, cols2);
        add(new JScrollPane(table));


        Save = new JButton("Save");
        add(Save);

        Cancel = new JButton("Cancel");
        add(Cancel);


        menuBar = new JMenuBar();
        openMenuItem = new JMenuItem("Load File", 'L');
        saveMenuItem = new JMenuItem("Save File", 'S');
        openMenuItem.setAccelerator(KeyStroke.getKeyStroke('L', KeyEvent.ALT_DOWN_MASK));
        saveMenuItem.setAccelerator(KeyStroke.getKeyStroke('S', KeyEvent.ALT_DOWN_MASK));

        openMenuItem.addActionListener(this);
        openMenuItem.setActionCommand("L");

        saveMenuItem.addActionListener(this);
        saveMenuItem.setActionCommand("S");
        ButtonGroup group = new ButtonGroup();
        fileMenu = new JMenu("File");
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
        setSize(1000, 600);
        setLocation(200, 50);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new SIG().setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "L":
                load();
                break;
            case "S":
              //  save();
                break;

        }

    }

    private void load() {
        JFileChooser fc = new JFileChooser();
        int result = fc.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            String path = fc.getSelectedFile().getPath();
            FileInputStream fis = null;

            try {
                fis = new FileInputStream(path);
                int size = fis.available();
                byte[] b = new byte[size];
                fis.read(b);
                table.getTableHeader();
            } catch (FileNotFoundException e) {

                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fis.close();
                } catch (IOException e) {
                }
            }
        }
    }

   /* private void save() {
        JFileChooser fc = new JFileChooser();
        int result = fc.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION){
            String path = fc.getSelectedFile().getPath();
            FileOutputStream fos = null;
            fos = new FileOutputStream(path);
            byte[] b = table.getTableHeader();


        }*/
    }




