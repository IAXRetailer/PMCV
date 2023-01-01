package io.github.h2sxxa.pmcv.swing;

import io.github.h2sxxa.pmcv.Main;
import io.github.h2sxxa.pmcv.config.ModConfig;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

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

        lblImg.setText(String.format(ModConfig.viewerhtml,url));
    }

    public void DisplayLocalImg(String url) throws IOException {
        Main.logger.info(String.format("show img %s",url));
        setTitle("SimpleViewer");
        setSize(200, 140);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        lblImg = new JLabel();

        add(lblImg,BorderLayout.CENTER);
        setVisible(true);
        ImageIcon image = new ImageIcon(ImageIO.read(new File(url)));
        lblImg.setIcon(image);
    }


}