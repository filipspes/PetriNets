package sk.stuba.fei.oop.painting;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class InputChooser extends JFileChooser {

    public InputChooser() {

        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "XML files", "xml");
        setFileFilter(filter);
    }
}
