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
import java.awt.*;

/**
 * @author: Ing. Manuel Fernando Garizao;
 * Email: manuel.garizao@fac.mil.co manuelfp@gmail.com
 * @date: 24/03/21, 1:44 PM
 **/
public class OtherObserverForm extends JFrame implements Observer {

    JPanel jPanel = new JPanel();

    public OtherObserverForm() {
        super("Observer Frame");
        this.setSize(400, 100);
        initComponent();
    }

    private void initComponent(){
        this.add(jPanel);
        JLabel jLabel = new JLabel("Hello Listening to Observable from..");
        this.jPanel.add(jLabel);
    }

    @Override
    public void update(int i, String message) {
        jPanel.add(new Button(String.format("O: %d Message: %s", i, message)));
        jPanel.revalidate();
    }
}
