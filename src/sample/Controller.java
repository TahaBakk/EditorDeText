package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;



public class Controller extends Component {


    public TextArea textArea;
    private int tamany = 12;
    private String font = "Arial";

    public void Copia(ActionEvent actionEvent) {
        textArea.copy();
    }

    public void Deshacer(ActionEvent actionEvent) {
        textArea.undo();
    }

    public void Pegar(ActionEvent actionEvent) {
        textArea.paste();
    }

    public void Cortar(ActionEvent actionEvent) {
        textArea.cut();
    }

    public void Borrar(ActionEvent actionEvent) {
        textArea.deletePreviousChar();
    }



    public void onClose(){
        Platform.exit();
    }

    public void onAbout(){
        System.out.println("Taha");
    }

    public void tamanyPrimer (ActionEvent actionEvent){
        textArea.setFont(Font.font(font,11));
        tamany = 11;

    }
    public void tamanySegon (ActionEvent actionEvent){
        textArea.setFont(Font.font(font,12));
        tamany = 12;

    }

    public void tamanyTercer (ActionEvent actionEvent){
        textArea.setFont(Font.font(font,14));
        tamany = 14;
    }

    public void Cantarell (ActionEvent actionEvent) {
        textArea.setFont(Font.font("Cantarell", tamany));
        font = "Cantarell";
    }
    public void Comic (ActionEvent actionEvent) {
        textArea.setFont(Font.font("Comic Sans", tamany));
        font = "Comic Sans";
    }
    public void times (ActionEvent actionEvent) {
        textArea.setFont(Font.font("times new roman", tamany));
        font = "times new roman";
    }

    public void  onLoad() throws IOException {

        String linia ="";
        String texto ="";

        JFileChooser file = new JFileChooser();
        file.getName();
        file.showOpenDialog(this);

        File f1 = file.getSelectedFile();
        Stage stage = (Stage) textArea.getScene().getWindow();
        stage.setTitle(f1.getName());


        if(f1 !=null) {
            FileReader archivos = new FileReader(f1);
            BufferedReader br = new BufferedReader(archivos);
            while ((linia = br.readLine()) != null) {
                texto += linia + "\n";
            }
            br.close();
        }
        textArea.setText(texto);

    }

    public void  onSave() throws IOException {
        //String nombre="";
        JFileChooser file=new JFileChooser();
        file.showSaveDialog(this);
        File f1 =file.getSelectedFile();

        if(f1 !=null)
        {
            FileWriter fw = new FileWriter(f1);
            fw.write(textArea.getText());
            fw.close();
        }
    }




}