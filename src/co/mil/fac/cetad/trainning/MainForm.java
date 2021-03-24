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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Ing. Manuel Fernando Garizao;
 * Email: manuel.garizao@fac.mil.co manuelfp@gmail.com
 * @date: 24/03/21, 1:34 PM
 **/
public class MainForm extends JFrame implements Observable {

    private static MainForm mainForm;
    private static List<Observer> observerList = new ArrayList<>();
    private JTextArea jTextArea = new JTextArea("Message to Observers.");
    private int count = 0;

    static {
        mainForm = new MainForm();
    }

    private MainForm() {
        this.setName("Demo Observer Pattern.");
        this.setSize(400, 300);
        init();
    }

    private void init() {
        JPanel jPanel = new JPanel();
        this.add(jPanel);
        JButton jButtonObserver = new JButton("Open Observer.");
        jButtonObserver.addActionListener(e -> {
            ObserverForm observerForm = new ObserverForm();
            observerForm.setVisible(true);
            addObserver(observerForm);

        });

        JButton jButtonOtherKindObserver = new JButton("Open new Observer");
        jButtonOtherKindObserver.addActionListener(e -> {
            OtherObserverForm otherObserverForm = new OtherObserverForm();
            otherObserverForm.setVisible(true);
            addObserver(otherObserverForm);
            notifyAllObserver();
        });
        jPanel.add(jButtonObserver);
        jPanel.add(jButtonOtherKindObserver);
        jPanel.add(jTextArea);
    }

    public static MainForm getInstance() {
        return mainForm;
    }

    @Override
    public void addObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observerList.remove(o);
    }

    @Override
    public void notifyAllObserver() {
        count++;
        for (Observer o: observerList) {
            o.update(count, jTextArea.getText());
        }
    }

}
