import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainForm extends JFrame implements ActionListener
{
    SpringLayout layout = new SpringLayout();

    JLabel lblName, lblPhone, lblEmail, lblAddress;
    JTextField txtName, txtPhone, txtEmail;
    JTextArea txtAddress;
    JButton btnFirst, btnPrevious, btnNext, btnLast;
    JButton btnNew, btnSave, btnDelete, btnSearch;
    JLabel lblSearch;
    JTextField txtSearch;


    public MainForm()
    {
        setTitle("My Awesome Address Book");
        setSize(400,400);
        setLocation(400,200);
        setLayout(layout);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        SetupEntryFormFieldsAndLabels();
        SetupAddressTextArea();
        SetupNavigationButtons();
        SetupFunctionlityButtons();

        setVisible(true);
    }

    private void SetupEntryFormFieldsAndLabels() {
        lblName = UIBuilderLibrary.BuildJLabelWithNorthWestAnchor("Name",20,20,layout,this);
        add(lblName);
        lblPhone = UIBuilderLibrary.BuildJLabelInlineBelow("Phone",8,layout,lblName);
        add(lblPhone);
        lblEmail = UIBuilderLibrary.BuildJLabelInlineBelow("Email",8,layout,lblPhone);
        add(lblEmail);
        lblAddress = UIBuilderLibrary.BuildJLabelInlineBelow("Address",8,layout,lblEmail);
        add(lblAddress);
        txtName = UIBuilderLibrary.BuildJTextFieldInlineToRight(10,20,layout,lblName);
        add(txtName);
        txtPhone = UIBuilderLibrary.BuildJTextFieldInlineBelow(10,4,layout,txtName);
        add(txtPhone);
        txtEmail = UIBuilderLibrary.BuildJTextFieldInlineBelow(10,4,layout,txtPhone);
        add(txtEmail);
    }

    private void SetupAddressTextArea() {
        //Create a JTextarea with no specified size.
        txtAddress = new JTextArea();
        //txtAddress.setBorder(new LineBorder(Color.GRAY));
        //Set the line wrap so the text does not exceed the right side of the box
        txtAddress.setLineWrap(true);
        //Create a scroll pane to contain the text area. The text are will set  its size to match the
        //scroll pane.
        JScrollPane scroll = new JScrollPane(txtAddress);
        //Set the scroll pane's size
        scroll.setPreferredSize(new Dimension(115,50));
        //make the scrollbars only appear when needed, when the text is longer than the pane.
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        //set the scroll panes position and add it to the form.
        layout.putConstraint(SpringLayout.WEST, scroll, 0, SpringLayout.WEST,txtEmail);
        layout.putConstraint(SpringLayout.NORTH, scroll, 4, SpringLayout.SOUTH,txtEmail);
        add(scroll);
    }

    private void SetupNavigationButtons() {
        btnFirst = UIBuilderLibrary.BuildJButtonInlineBelow(40,25,"|<",40,this,layout,lblAddress);
        btnFirst.setMargin(new Insets(0,0,0,0));
        add(btnFirst);
        btnPrevious = UIBuilderLibrary.BuildJButtonInlineToRight(40,25,"<<",0,this,layout,btnFirst);
        btnPrevious.setMargin(new Insets(0,0,0,0));
        add(btnPrevious);
        btnNext = UIBuilderLibrary.BuildJButtonInlineToRight(40,25,">>",0,this, layout,btnPrevious);
        btnNext.setMargin(new Insets(0,0,0,0));
        add(btnNext);
        btnLast = UIBuilderLibrary.BuildJButtonInlineToRight(40,25,">>",0,this, layout,btnNext);
        btnLast.setMargin(new Insets(0,0,0,0));
        add(btnLast);
    }

    private void SetupFunctionlityButtons() {
        btnNew = UIBuilderLibrary.BuildJButtonWithNorthWestAnchor(120,25,"NEW",220,20,this,layout,this);
        add(btnNew);
        btnSave = UIBuilderLibrary.BuildJButtonInlineBelow(120,25,"SAVE",5,this,layout,btnNew);
        add(btnSave);
        btnDelete = UIBuilderLibrary.BuildJButtonInlineBelow(120,25,"SAVE",5,this,layout,btnSave);
        add(btnDelete);
        lblSearch = UIBuilderLibrary.BuildJLabelInlineBelow("Search:",5,layout,btnDelete);
        add(lblSearch);
        txtSearch = UIBuilderLibrary.BuildJTextFieldInlineToRight(6,5,layout,lblSearch);
        add(txtSearch);
        btnSearch = UIBuilderLibrary.BuildJButtonInlineBelow(120,25,"SEARCH",5,this,layout,lblSearch);
        add(btnSearch);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
