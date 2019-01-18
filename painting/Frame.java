package sk.stuba.fei.oop.painting;

import sk.stuba.fei.oop.generated.Document;
import sk.stuba.fei.oop.petriNet.PetrinetParser;

import javax.swing.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class Frame extends JFrame implements ActionListener {

    private JButton importNetButton;
    private JButton addTokensButton;
    private JButton removeTokensButton;
    private DrawingField petrinetVisualisation;
    private InputChooser petrinetChooser;
    private File selectedFile;
    protected boolean addingTokens = false;
    protected boolean removingTokens = false;

    public Frame() {
        super("PETRINET");

        Panel controlItems = new Panel();
        importNetButton = new JButton("Open file");
        importNetButton.addActionListener(this);
        addTokensButton = new JButton(" + ");
        addTokensButton.addActionListener(this);
        removeTokensButton = new JButton(" - ");
        removeTokensButton.addActionListener(this);
        petrinetChooser = new InputChooser();
        petrinetVisualisation = new DrawingField();

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        controlItems.add(importNetButton);
        controlItems.add(addTokensButton);
        controlItems.add(removeTokensButton);

        add("North", controlItems);
        add("Center", petrinetVisualisation);

        setVisible(true);
    }

    public void actionPerformed (ActionEvent e) {

        if(e.getSource() == importNetButton) {
            int returnValue = petrinetChooser.showOpenDialog(this);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                this.selectedFile = petrinetChooser.getSelectedFile();

                try {
                    File file = new File(selectedFile.getPath());
                    JAXBContext jaxbContext = JAXBContext.newInstance(Document.class);
                    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                    Document document = (Document) jaxbUnmarshaller.unmarshal(file);

                    petrinetVisualisation.addPetrinet(new PetrinetParser(document));
                } catch (Exception ignored) {
                    ignored.printStackTrace();
                }
            }
            petrinetVisualisation.repaint();
        }
        if(e.getSource() == addTokensButton) {
            this.addingTokens = true;
            this.removingTokens = false;
            petrinetVisualisation.changingTokensStatus(this.addingTokens, this.removingTokens);
        }
        if(e.getSource() == removeTokensButton) {
            this.removingTokens = true;
            this.addingTokens = false;
            petrinetVisualisation.changingTokensStatus(this.addingTokens, this.removingTokens);
        }


    }
}
