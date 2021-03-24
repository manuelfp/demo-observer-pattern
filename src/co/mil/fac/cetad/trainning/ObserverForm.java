/**
 * COPYRIGHT NOTICE
 * <p>
 * All Technical Data and software is Copyright (c), 2021 by
 * COLOMBIAN AIR FORCE.
 * <p>
 * COPYRIGHT NOTICE
 */
package co.mil.fac.cetad.trainning;

import javax.swing.*;

/**
 * @author: Ing. Manuel Fernando Garizao;
 * Email: manuel.garizao@fac.mil.co manuelfp@gmail.com
 * @date: 24/03/21, 1:44 PM
 **/
public class ObserverForm extends JFrame implements Observer {

    JPanel jPanel = new JPanel();
    JLabel jLabelCounter;

    public ObserverForm() {
        super("Observer Frame");
        this.setSize(400, 100);
        initComponent();
    }

    private void initComponent(){
        this.add(jPanel);
        JLabel jLabel = new JLabel("Hello Listening to Observable from..");
        jLabelCounter = new JLabel("1");
        this.jPanel.add(jLabel);
        this.jPanel.add(jLabelCounter);
    }

    @Override
    public void update(int i, String message) {
        jLabelCounter.setText("Observers: " + i + " Message from principal: " + message);
        jPanel.revalidate();
    }
}
