package alarmClock;

import classes.*;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class AlarmClock extends javax.swing.JFrame {
	protected static SetTimeFormat SetTimeFormat;
	static SetAlarm12 SetAlarm12;
	
	Time time = new Time(); // Create only one Time object
	Time12 time12 = new Time12(); // 12-Hour Format
	Time24 time24 = new Time24(); // 24-Hour Format
	
	/**
	 * Creates new form AlarmClock
	 */
	public AlarmClock() {
		initComponents();
		setLocationRelativeTo(null);
		setResizable(false);
		time.checkClockSettings();
		
		Timer timer = new Timer(0000, (ActionEvent e) -> {
			
			if(time.getIs12HourFormat() == true){
				// Update the current time by getting the latest hour, minute, second and AM/PM
				time12.updateCurrentTime(); 
				currentTimeFormat.setText("12-Hour Format");
				currentTime.setText(time12.toString12());
			}
			else{
				// Update the current time by getting the latest hour, minute and second
				time24.updateCurrentTime();
				currentTimeFormat.setText("24-Hour Format");
				currentTime.setText(time24.toString24());
			}
			currentDate.setText(time.getDate());

		});
		timer.start();
	}

/*	This method is resource inefficient because it repeatedly calls a new Time object to update the current time
	
		Timer timer = new Timer(0000, (ActionEvent e) -> {
			Time time = new Time();
			if(time.getIs12HourFormat() == true){
				Time12 time12 = new Time12();
				currentTimeFormat.setText("12-Hour Format");
				currentTime.setText(time12.toString12(time12.getHour12(), time12.getMinute(), time12.getSecond(), time12.getAm_pm()));
			}
			else{
				Time24 time24 = new Time24();
				currentTimeFormat.setText("24-Hour Format");
				currentTime.setText(time24.toString24(time24.getHour24(), time24.getMinute(), time24.getSecond()));
			}

		});
		timer.start();
*/		

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        currentTimeFormat = new javax.swing.JLabel();
        currentDate = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        currentTime = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        setTimeBtn = new javax.swing.JButton();
        setAlarmBtn = new javax.swing.JButton();
        setSnoozingTimeBtn = new javax.swing.JButton();
        setTimeFormatBtn = new javax.swing.JButton();
        viewAlarmsBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        title.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        title.setText("Alarm Clock");
        title.setPreferredSize(new java.awt.Dimension(207, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(305, 305, 305))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setPreferredSize(new java.awt.Dimension(686, 159));

        currentTimeFormat.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        currentTimeFormat.setText("currentTimeFormat");
        currentTimeFormat.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        currentDate.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        currentDate.setText("currentDate");
        currentDate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        currentTime.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        currentTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        currentTime.setText("currentTime");
        currentTime.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(currentTime, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(currentTime, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(currentTimeFormat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(currentDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(currentTimeFormat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(currentDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setPreferredSize(new java.awt.Dimension(550, 99));

        setTimeBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        setTimeBtn.setText("Set Time");
        setTimeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setTimeBtnActionPerformed(evt);
            }
        });

        setAlarmBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        setAlarmBtn.setText("Set Alarm");
        setAlarmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setAlarmBtnActionPerformed(evt);
            }
        });

        setSnoozingTimeBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        setSnoozingTimeBtn.setText("Set Snoozing Time");
        setSnoozingTimeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setSnoozingTimeBtnActionPerformed(evt);
            }
        });

        setTimeFormatBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        setTimeFormatBtn.setText("Set Time Format");
        setTimeFormatBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setTimeFormatBtnActionPerformed(evt);
            }
        });

        viewAlarmsBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        viewAlarmsBtn.setText("View Alarms");
        viewAlarmsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAlarmsBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(setTimeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(setTimeFormatBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(setAlarmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(viewAlarmsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(setSnoozingTimeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(setTimeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(setAlarmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(setSnoozingTimeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(setTimeFormatBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewAlarmsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setTimeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setTimeBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_setTimeBtnActionPerformed

    private void setAlarmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setAlarmBtnActionPerformed
        // TODO add your handling code here:
		dispose();
		AlarmClock.SetAlarm12 = new SetAlarm12();
		AlarmClock.SetAlarm12.setVisible(true);
    }//GEN-LAST:event_setAlarmBtnActionPerformed

    private void setSnoozingTimeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setSnoozingTimeBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_setSnoozingTimeBtnActionPerformed

    private void setTimeFormatBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setTimeFormatBtnActionPerformed
        // TODO add your handling code here:
//		RunAlarmClock.AlarmClock.setVisible(false);
		dispose();
		AlarmClock.SetTimeFormat = new SetTimeFormat();
		AlarmClock.SetTimeFormat.setVisible(true);
		
    }//GEN-LAST:event_setTimeFormatBtnActionPerformed

    private void viewAlarmsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAlarmsBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewAlarmsBtnActionPerformed

	/**
	 * @param args the command line arguments
	 */
	
//	public static void main(String args[]) {
//		/* Set the Nimbus look and feel */
//		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//		 */
//		try {
//			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//				if ("Nimbus".equals(info.getName())) {
//					javax.swing.UIManager.setLookAndFeel(info.getClassName());
//					break;
//				}
//			}
//		} catch (ClassNotFoundException ex) {
//			java.util.logging.Logger.getLogger(AlarmClock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//		} catch (InstantiationException ex) {
//			java.util.logging.Logger.getLogger(AlarmClock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//		} catch (IllegalAccessException ex) {
//			java.util.logging.Logger.getLogger(AlarmClock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
//			java.util.logging.Logger.getLogger(AlarmClock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//		}
//		//</editor-fold>
//
//		/* Create and display the form */
//		java.awt.EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				new AlarmClock().setVisible(true);
//			}
//		});
//	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel currentDate;
    private javax.swing.JLabel currentTime;
    private javax.swing.JLabel currentTimeFormat;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton setAlarmBtn;
    private javax.swing.JButton setSnoozingTimeBtn;
    private javax.swing.JButton setTimeBtn;
    private javax.swing.JButton setTimeFormatBtn;
    private javax.swing.JLabel title;
    private javax.swing.JButton viewAlarmsBtn;
    // End of variables declaration//GEN-END:variables

	
//	private void checkClockSettings() {
//		try{
//			File file = new File("src/classes/ClockSettings.txt");
//			if(!file.exists()){
//				file.createNewFile();
//				System.out.println("The file is created successfully");
//				FileWriter fw = new FileWriter(file);
//				fw.write("isTimeDefault/is12HourFormat/isDefaultSnoozingTime/snoozingTime\n");
//				fw.write("true/true/true/120000");
//				fw.close();
//				time.setIsTimeDefault(true);
//				time.setIs12HourFormat(true);
//				time.setIsDefaultSnoozingTime(true);
//				time.setSnoozingTime(120000);
//			}
//			else{
//				System.out.println("The file already exists");
//				FileReader fr = new FileReader(file);
//
//			}
//		}
//		catch(IOException e){
//			e.printStackTrace();
//		}
//		
//	}
}
