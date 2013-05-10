package woodCut;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JRadioButton;

import woodCut.misc.Trees;
import woodCut.misc.Variables;


public class WoodCutGUI extends JFrame implements ActionListener
{
	private JPanel contentPane;
	private JComboBox comboBox = new JComboBox(Trees.values());
	private JButton btnStart = new JButton("Start");
	private JRadioButton radioDrop = new JRadioButton("Drop");
	private static JRadioButton radioBurn = new JRadioButton("Burn");
	
	
	public WoodCutGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 297, 185);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTree = new JLabel("Tree:");
		lblTree.setBounds(29, 29, 46, 14);
		contentPane.add(lblTree);

		comboBox.setBounds(65, 26, 112, 20);
		contentPane.add(comboBox);
		
		
		btnStart.addActionListener(this);
		
		btnStart.setBounds(65, 87, 121, 38);
		contentPane.add(btnStart);
		
		radioBurn.setBounds(189, 25, 109, 23);
		contentPane.add(radioBurn);
		
		radioDrop.setSelected(true);
		radioDrop.setBounds(189, 51, 109, 23);
		contentPane.add(radioDrop);
		
		groupButton( );
	
	}
	
	private void groupButton( ) {

		ButtonGroup bg1 = new ButtonGroup( );

		bg1.add(radioBurn);
		bg1.add(radioDrop);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		if(source == btnStart)
		{
			Variables.treeIds = Trees.values()[comboBox.getSelectedIndex()].getTreeIds();
			Variables.logId = Trees.values()[comboBox.getSelectedIndex()].getLogID();
			
			if(radioDrop.isSelected())
				Variables.drop = true;
			else
				Variables.burn = true;
			
			setVisible(false);
		}
		
	}

	
}
