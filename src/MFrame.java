import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MFrame extends JFrame implements ActionListener{
	  JPanel panel=null;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	  //布局与监听
    public MFrame(){
    	Date date=new Date();
    	final DateFormat format=new SimpleDateFormat("HH:mm");
    	String time=format.format(date);
       
    	final JFrame frame = new JFrame();  
        final JPanel panel1 = new JPanel();  
       
        final JTextArea textAreaStart = new JTextArea();  
        JLabel lable1=new JLabel("起始时间:");
       
        textAreaStart.setText(time);  
        
        panel1.add(lable1);
        panel1.add(textAreaStart);
       
        frame.add(panel1);  
        
        
        
        final JTextArea taTimes = new JTextArea();  
        final JTextArea taOffset = new JTextArea();  
        JLabel lable12=new JLabel("时间差:");
        JLabel lable13=new JLabel("*");
        taOffset.setText("35");  
        taTimes.setText("1");
        panel1.add(lable12);
        panel1.add(taTimes);
        panel1.add(lable13);
        panel1.add(taOffset);
        final JCheckBox checkBox=new JCheckBox("往前");
        checkBox.setSelected(true);
        panel1.add(checkBox);
        
       
       
        JButton btn=new JButton("计算");
        
        
        
        panel1.add(btn);
        
        JLabel lable14=new JLabel("结果:");
        final JLabel lable15=new JLabel("");
        panel1.add(lable14);
        panel1.add(lable15);
        btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Date date=format.parse(textAreaStart.getText());
					
					int times=Integer.parseInt(taTimes.getText());
					int offset=Integer.parseInt(taOffset.getText());
					
					boolean isBefore=checkBox.isSelected();
					
					
					String result=cal(date,times,offset,isBefore);
					lable15.setText(result);
					
					
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(frame, "输入错误！");
					
				}
				
			}

			
		});
        frame.setTitle("毛媛专用计算器");
        frame.add(panel1);    
        frame.setSize(600,100);  
        frame.setVisible(true);  
        
    }

	protected String cal(Date date, int times, int offset, boolean isBefore) {
		// TODO Auto-generated method stub
		
		long delta=times*offset*60*1000;
		if(isBefore)delta=-delta;
		
		date.setTime(date.getTime()+delta);
		
		
		final DateFormat format=new SimpleDateFormat("HH:mm");
    	String time=format.format(date);
		
		
		
		return time;
	}

}
