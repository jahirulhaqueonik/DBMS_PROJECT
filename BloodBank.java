package bloodbank;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class BloodBank extends JFrame implements ActionListener {
    
    JButton sButton;
    private Container c;
    public JLabel todayLabel;
    private JFormattedTextField today;
    private JLabel titleLabel, fnLabel, lnLabel, phoneLabel, addressLabel, weightLabel, ageLabel,bloodGroupLabel,genderLabel;
    private JTextField fnTf, lnTf, phoneTf, addressTf, weightTf, ageTf, bloodGroupTf,genderTf;
    private JButton addButton, updateButton, deleteButton;
    private JTable table;
    private JScrollPane scroll;
    private DefaultTableModel model;
    public String[] columns = {"First Name", "Donor Id", "Address", "Phone No", "Weight", "Age", "Blood Group", "Date","Gender"};
    public String[] rows = new String[9];
    

    BloodBank() {
        initComponents();
    }

        public void initComponents() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(880, 900);
        this.setLocationRelativeTo(null);
        this.setTitle("ABC BLOOD BANK");

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.PINK);

        Font font = new Font("Arial", Font.BOLD, 14);

       // titleLabel = new JLabel("ABC BLOOD BANk");
        titleLabel = new JLabel("DONOR INFORMATION FORM");
        
        titleLabel.setFont(font);
        titleLabel.setBounds(280, 10, 300, 50);
        c.add(titleLabel);

        fnLabel = new JLabel("First Name    ");
        fnLabel.setBounds(10, 80, 140, 30);
        fnLabel.setFont(font);
        c.add(fnLabel);

        fnTf = new JTextField();
        fnTf.setBounds(110, 80, 200, 30);
        fnTf.setFont(font);
        c.add(fnTf);

        lnLabel = new JLabel("DONOR ID    ");
        lnLabel.setBounds(400, 80, 140, 30);
        lnLabel.setFont(font);
        c.add(lnLabel);

        lnTf = new JTextField();
        lnTf.setBounds(520, 80, 200, 30);
        lnTf.setFont(font);
        c.add(lnTf);

        addressLabel = new JLabel("Address    ");
        addressLabel.setBounds(10, 130, 140, 30);
        addressLabel.setFont(font);
        c.add(addressLabel);

        addressTf = new JTextField();
        addressTf.setBounds(110, 130, 200, 30);
        addressTf.setFont(font);
        c.add(addressTf);

        phoneLabel = new JLabel("Phone Number   ");
        phoneLabel.setBounds(400, 130, 140, 30);
        phoneLabel.setFont(font);
        c.add(phoneLabel);

        phoneTf = new JTextField();
        phoneTf.setBounds(520, 130, 200, 30);
        phoneTf.setFont(font);
        c.add(phoneTf);

        weightLabel = new JLabel("Weight   ");
        weightLabel.setBounds(10, 180, 140, 30);
        weightLabel.setFont(font);
        c.add(weightLabel);

        weightTf = new JTextField();
        weightTf.setBounds(110, 180, 200, 30);
        weightTf.setFont(font);
        c.add(weightTf);

        ageLabel = new JLabel("Age   ");
        ageLabel.setBounds(400, 180, 140, 30);
        ageLabel.setFont(font);
        c.add(ageLabel);

        ageTf = new JTextField();
        ageTf.setBounds(520, 180, 200, 30);
        ageTf.setFont(font);
        c.add(ageTf);
       
        
        
        
     //   box = new BoxLayout(c,BoxLayout.Y_AXIS);
       
        bloodGroupLabel = new JLabel("Blood Group");
        bloodGroupLabel.setBounds(400, 230, 140, 30);
        bloodGroupLabel.setFont(font);
        c.add(bloodGroupLabel);
        
        bloodGroupTf = new JTextField();
        bloodGroupTf.setBounds(520,230,200,30);
       bloodGroupTf.setFont(font);
        c.add(bloodGroupTf);
        
        
        genderLabel = new JLabel("Gender");
        genderLabel.setBounds(10, 280, 140, 30);
        genderLabel.setFont(font);
        c.add(genderLabel);
        
          genderTf = new JTextField();
          genderTf.setBounds(110,280,200,30);
          genderTf.setFont(font);
        c.add(  genderTf);

     

        //    This Part For Auto Generated Date  
        todayLabel = new JLabel("Date   ");
        todayLabel.setBounds(10, 230, 200, 30);
        todayLabel.setFont(font);
        c.add(todayLabel);

        DateFormat dateFormat = new SimpleDateFormat("dd MMM YYYY");
        today = new JFormattedTextField(dateFormat);
        today.setEditable(true);
        today.setValue(new Date());
        today.setBounds(110, 230, 200, 30);
        today.setBackground(Color.white);
        c.add(today);
        // close the part of Auto Generated Date  */          

        addButton = new JButton(" Add ");
        addButton.setBounds(40, 350, 100, 30);
        addButton.setFont(font);
        c.add(addButton);

        updateButton = new JButton("Update");
        updateButton.setBounds(170, 350, 100, 30);
        updateButton.setFont(font);
        c.add(updateButton);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(310, 350, 100, 30);
        deleteButton.setFont(font);
        c.add(deleteButton);
        
       
        
        
        table = new JTable();

        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setFont(font);
        table.setSelectionBackground(Color.GREEN);
        table.setBackground(Color.white);
        table.setRowHeight(40);
        table.setEnabled(true);

        scroll = new JScrollPane(table);
        scroll.setBounds(10, 400, 840, 250);
        c.add(scroll);

        addButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);

        table.addMouseListener(new MouseAdapter() {
            public void mouseClciked(MouseEvent me) {
                int numberOfRow = table.getSelectedRow();
                String f_name = model.getValueAt(numberOfRow, 0).toString();
                String l_name = model.getValueAt(numberOfRow, 1).toString();
                String address = model.getValueAt(numberOfRow, 2).toString();
                String phone = model.getValueAt(numberOfRow, 3).toString();
                String weight = model.getValueAt(numberOfRow, 4).toString();
                String age = model.getValueAt(numberOfRow, 5).toString();
                String blood = model.getValueAt(numberOfRow, 6).toString();
                String date = model.getValueAt(numberOfRow, 7).toString();
                String gen= model.getValueAt(numberOfRow, 8).toString();

                fnTf.setText(f_name);
                lnTf.setText(l_name);
                addressTf.setText(address);
                phoneTf.setText(phone);
                weightTf.setText(weight);
                ageTf.setText(age);
                bloodGroupTf.setText(blood);

            }
        });
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addButton) {

            rows[0] = fnTf.getText();
            rows[1] = lnTf.getText();
            rows[2] = addressTf.getText();
            rows[3] = phoneTf.getText();
            rows[4] = weightTf.getText();
            rows[5] = ageTf.getText();
            rows[6]=bloodGroupTf.getText();
            rows[7] = today.getText();
            rows[8] = genderTf.getText();
          
             
      
            
            model.addRow(rows);
        } else if (e.getSource() == deleteButton) {
            int numberOfRow = table.getSelectedRow();
            if (numberOfRow >= 0) {
                model.removeRow(numberOfRow);
            } else {
                JOptionPane.showMessageDialog(null, " Row has not been selected ");
            }
        } else if (e.getSource() == updateButton) {
            int numberOfRow = table.getSelectedRow();
            String f_name = fnTf.getText();
            String l_name = lnTf.getText();
            String address = addressTf.getText();
            String phone = phoneTf.getText();
            String weight = weightTf.getText();
            String age = ageTf.getText();
           String bloodGroup = bloodGroupTf.getText();
           String gender = genderTf.getText();

            model.setValueAt(f_name, numberOfRow, 0);
            model.setValueAt(l_name, numberOfRow, 1);
            model.setValueAt(address, numberOfRow, 2);
            model.setValueAt(phone, numberOfRow, 3);
            model.setValueAt(weight, numberOfRow, 4);
            model.setValueAt(age, numberOfRow, 5);
            model.setValueAt(bloodGroup, numberOfRow, 7);
            model.setValueAt(gender, numberOfRow, 8);

        }
 
           
    }
    

    public static void main(String[] args) {
        BloodBank frame = new BloodBank();
        frame.setVisible(true);
    }

}
