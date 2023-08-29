import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.net.URI;
import java.util.Map;

public class mainpage implements ActionListener{
    JMenuBar men;
    JFrame jf;
    JLabel intro;

    JPanel pan5;

    mainpage(){
        jf=new JFrame("list creator");
        // GridBagLayout gb=new GridBagLayout();
        // GridBagConstraints gbc=new GridBagConstraints();
        jf.setSize(new Dimension(700,500));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new BorderLayout(50,200));

        // jf.setLayout(gb);
      /*  gbc.anchor=GridBagConstraints.NORTHEAST;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.gridwidth=GridBagConstraints.RELATIVE; */
        createmen();
        JMenu file=new JMenu("FILE");
        JMenu create_list=new JMenu("CREATE LIST");
        JMenuItem shoppinglist=new JMenuItem(("SHOPPING LIST"));
        JMenuItem musiclist=new JMenuItem("MUSIC LIST");
        JMenuItem grocerylist=new JMenuItem("GROCERY LIST");
        JMenuItem movieselection= new JMenuItem("MOVIE SELECTION");
        create_list.add(shoppinglist);
        create_list.add(musiclist);
        create_list.add(grocerylist);
        create_list.add(movieselection);
        men.add(create_list);
        JMenuItem close=new JMenuItem("CLOSE");
        file.add(close);
        //      gb.setConstraints(file,gbc);
        men.add(file);
        //    gbc.gridwidth=GridBagConstraints.REMAINDER;
        JMenu Help=new JMenu("Help");
        //  gb.setConstraints(Help,gbc);
        men.add(Help);
        //gbc.gridwidth=GridBagConstraints.NONE;
        //gbc.anchor=GridBagConstraints.NORTHEAST;
        //gb.setConstraints(men,gbc);
        jf.setJMenuBar(men);
        shoppinglist.addActionListener(this);
        close.addActionListener(this);
        grocerylist.addActionListener(this);
        movieselection.addActionListener(this);
        musiclist.addActionListener(this);
        Help.addActionListener(this);
        String msg="<html><p>Welcome to the list creator website . You can create a any type of day to day lists that you wish to write down in a paper .All you have to do is click the create button in menubar and start designing</p><br><p>Also you can select movies from the collection of movies available to stream and enjoy watching one</P></html> ";
        intro=new JLabel(msg);
        intro.setFont(new Font("SANS_SERIF",Font.ITALIC,30));
        intro.setBorder(BorderFactory.createLineBorder(Color.pink,5));
        intro.setForeground(Color.red);
        intro.setBackground(Color.black);
        intro.setOpaque(true);
        pan5=new JPanel();
        pan5.setLayout(new BoxLayout(pan5,BoxLayout.X_AXIS));
        JLabel pic1=new JLabel(new ImageIcon("C:\\Users\\kamal\\Downloads\\movielist.png"));
        pan5.add(pic1);
        JLabel pic2=new JLabel(new ImageIcon("C:\\Users\\kamal\\Downloads\\wishlist.jpg"));
        pan5.add(pic2);
        JLabel pic3=new JLabel(new ImageIcon("C:\\Users\\kamal\\Downloads\\spo.jpg"));
        pan5.add(pic3);
        pan5.setSize(new Dimension(600,400));
        pan5.add(intro);
        JScrollBar s=new JScrollBar(JScrollBar.VERTICAL);
        pan5.add(s);
        JScrollBar s1=new JScrollBar(JScrollBar.HORIZONTAL);
        pan5.add(s1);
        pan5.setVisible(true);
        jf.add(pan5,BorderLayout.CENTER);
        jf.setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        String com=ae.getActionCommand();
        if (com.equalsIgnoreCase("CLOSE")){
            System.exit(0);
        }
        if (com.equalsIgnoreCase("SHOPPING LIST")){
            new intframe(jf,pan5);
        }
        if (com.equalsIgnoreCase("MOVIE SELECTION")){
            new intframe1(jf,pan5);
        }
        if (com.equalsIgnoreCase("MUSIC LIST")){
            new intframe2(jf,pan5);
        }
    }

    protected void createmen(){
        men=new JMenuBar();
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new mainpage();
            }
        });
    }
}
class intframe extends InternalFrameAdapter implements ActionListener{
    JFrame jf; JPanel intro;JTextField itemname;JTextField quantity;int i=0;JPanel pan1;
    intframe(JFrame jf,JPanel intro){
        this.jf=jf;
        this.intro=intro;
        JInternalFrame shop=new JInternalFrame();
        JPanel pan=new JPanel();
        pan.setBorder(BorderFactory.createLineBorder(Color.MAGENTA,10));
        pan.setAutoscrolls(true);
        BoxLayout bx1=new BoxLayout(pan,BoxLayout.Y_AXIS);
        pan.setLayout(bx1);
        JLabel i=new JLabel("Enter item name");
        itemname=new JTextField();
        JLabel q=new JLabel("Enter quantity");
        quantity=new JTextField();
        JButton save=new JButton("ADD");
        save.setActionCommand("ADD");
        save.addActionListener(this);
        pan.add(i);
        pan.add(itemname);
        pan.add(q);
        pan.add(quantity);
        pan.add(save);
        //shop.add(pan);
        pan1=new JPanel();
        BoxLayout bx=new BoxLayout(pan1,BoxLayout.Y_AXIS);
        pan1.setLayout(bx);
        pan1.setAutoscrolls(true);
        JLabel jlb1=new JLabel("SHOPPING LIST");
        jlb1.setFont(new Font("SERIF",Font.BOLD,20));
        pan1.add(jlb1);
        JCheckBox def=new JCheckBox("default");
        pan1.add(def);
        pan1.setVisible(true);
        pan1.setBorder(BorderFactory.createLineBorder(Color.CYAN,10));
        JScrollPane jsp=new JScrollPane(pan1);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JSplitPane spl=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pan,jsp);
        spl.setVisible(true);
        spl.setAutoscrolls(true);
        shop.add(spl,BorderLayout.CENTER);
        jf.remove(intro);
        jf.add(shop,BorderLayout.CENTER);
        pan.setVisible(true);
        shop.setVisible(true);
        shop.setClosable(true);
        shop.setResizable(true);
        pan.setAutoscrolls(true);
        shop.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        shop.addInternalFrameListener(this);

    }
    public void internalFrameClosed(InternalFrameEvent e){
        jf.add(intro,BorderLayout.CENTER);
    }
    public void actionPerformed(ActionEvent ae){
        String com=ae.getActionCommand();
        if (com.equalsIgnoreCase("ADD")){
            i++;
            String stritem=itemname.getText() + "     "+ quantity.getText();
            JCheckBox bx=new JCheckBox(stritem);
            pan1.add(bx);
            pan1.setVisible(false);
            pan1.setVisible(true);
        }

    }
}

class intframe1 extends InternalFrameAdapter {
    JFrame jf;
    JLabel jlb;
    JPanel pan1,intro;
    String movies[]={"Peaky Blinders","Iron man","la la land","dunkirk","what's your number","saving private ryan","Forest Gump","Ambulance","Father figures"};


    intframe1(JFrame jf, JPanel intro) {
        this.jf = jf;
        this.intro = intro;
        JInternalFrame shop = new JInternalFrame();
        JPanel pan = new JPanel();
        pan.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 10));
        pan.setAutoscrolls(true);
        JList<String> jl=new JList<String>(movies);
        jl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane jsp=new JScrollPane(jl);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        pan1 = new JPanel();
        pan1.setLayout(new BorderLayout());
        pan1.setVisible(true);
        pan1.setBorder(BorderFactory.createLineBorder(Color.CYAN, 10));
        jlb=new JLabel("Choose the film");
        pan1.add(jlb,BorderLayout.CENTER);
        JSplitPane spl = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jsp, pan1);
        spl.setVisible(true);
        spl.setAutoscrolls(true);
        shop.add(spl, BorderLayout.CENTER);
        jf.remove(intro);
        jf.add(shop, BorderLayout.CENTER);
        pan.setVisible(true);
        shop.setVisible(true);
        shop.setClosable(true);
        shop.setResizable(true);
        pan.setAutoscrolls(true);
        shop.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        shop.addInternalFrameListener(this);
        jl.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int idx=jl.getSelectedIndex();
                if (idx!=-1){
                    pan1.remove(jlb);
                    jlb=new JLabel(movies[idx]);
                    Font font = jlb.getFont();
                    Map attributes = font.getAttributes();
                    attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                    jlb.setFont(font.deriveFont(attributes));
                    jlb.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            try{
                                JOptionPane.showMessageDialog(pan1,"You are redirected to movie streaming site.");
                                Desktop.getDesktop().browse(new URI("https://youtu.be/PxZ5gGfPtCQ"));
                            } catch (Exception ef){
                                ef.printStackTrace();
                            }
                        }
                    });
                    pan1.add(jlb,BorderLayout.CENTER);
                    pan1.setVisible(false);
                    pan1.setVisible(true);
                }
            }
        });


    }

    public void internalFrameClosed(InternalFrameEvent e) {
        jf.add(intro, BorderLayout.CENTER);
    }
}
class intframe2 extends InternalFrameAdapter implements ItemListener {
    JFrame jf;
    JLabel jlb;
    JPanel pan1,intro;
    JRadioButton jrb;
    String music[]={"Uptown Funk","Dancing Queen","Perfect","I don't wanna live forever","Crazy In Love"};

    intframe2(JFrame jf, JPanel intro) {
        this.jf = jf;
        this.intro = intro;
        JInternalFrame shop = new JInternalFrame();
        JPanel pan = new JPanel();
        pan.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 10));
        pan.setAutoscrolls(true);
        BoxLayout bx=new BoxLayout(pan,BoxLayout.Y_AXIS);
        pan.setLayout(bx);
        ButtonGroup bg=new ButtonGroup();
        for(int i=0;i<music.length;i++){
            JRadioButton jb=new JRadioButton(music[i]);
            bg.add(jb);
            jb.addItemListener(this);
            pan.add(jb);
        }
        pan1 = new JPanel();
        pan1.setLayout(new BorderLayout());
        pan1.setVisible(true);
        pan1.setBorder(BorderFactory.createLineBorder(Color.CYAN, 10));
        jlb = new JLabel("Click the song");
        pan1.add(jlb, BorderLayout.CENTER);
        JSplitPane spl = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pan, pan1);
        spl.setVisible(true);
        spl.setAutoscrolls(true);
        shop.add(spl, BorderLayout.CENTER);
        jf.remove(intro);
        jf.add(shop, BorderLayout.CENTER);
        pan.setVisible(true);
        shop.setVisible(true);
        shop.setClosable(true);
        shop.setResizable(true);
        pan.setAutoscrolls(true);
        shop.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        shop.addInternalFrameListener(this);
    }

    public void internalFrameClosed(InternalFrameEvent e) {
        jf.add(intro, BorderLayout.CENTER);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange()==1) {
            jrb = (JRadioButton) e.getSource();
            String s = jrb.getText();
            JOptionPane.showMessageDialog(pan1, "playing " + s);
        }
    }
}
