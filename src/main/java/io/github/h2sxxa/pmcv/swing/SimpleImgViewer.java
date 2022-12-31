package io.github.h2sxxa.pmcv.swing;

import io.github.h2sxxa.pmcv.Main;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SimpleImgViewer extends JFrame {

    private JLabel lblImg;

    public void DisplayImageHtml(String url) {
        Main.logger.info(String.format("show img %s",url));
        setTitle("SimpleViewer");
        setSize(200, 140);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        lblImg = new JLabel();
        add(lblImg);
        setVisible(true);

        lblImg.setText(String.format("<html><img src='%s' alt='load image error' /><html>",url));
    }
}