package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TextField;
import javafx.scene.canvas.Canvas;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public Canvas myCanvas;
    public GraphicsContext graphicsContext;
    @FXML
    private TextField mySize;
    @FXML
    private ColorPicker color;
    @FXML
    private CheckBox square;
    @FXML
    private CheckBox circle;
    @FXML
    private CheckBox triangle;

    public void drawSquare(double x, double y) {
        graphicsContext.setFill(color.getValue());
        int size = Integer.parseInt(mySize.getText());
        graphicsContext.fillRect(x, y, size, size);
    }

    public void drawCircle(double x, double y) {
        graphicsContext.setFill(color.getValue());
        int size = Integer.parseInt(mySize.getText());
        graphicsContext.fillOval(x, y, size, size);
    }

    public void drawTriangle(double x, double y) {
        int size = Integer.parseInt(mySize.getText());
        graphicsContext.setLineWidth(3);
        graphicsContext.strokeLine(x - size / 2, y + size / 2, x + size / 2, y + size / 2);
        graphicsContext.strokeLine(x, y - size / 2, x - size / 2, y + size / 2);
        graphicsContext.strokeLine(x, y - size / 2, x + size / 2, y + size / 2);

    }

    public void drawShape(MouseEvent mouseEvent) {
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();

        if (square.isSelected())
            drawSquare(x, y);
        else if (circle.isSelected())
            drawCircle(x, y);
        else if (triangle.isSelected())
            drawTriangle(x, y);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        System.out.println("all good !");
        graphicsContext = myCanvas.getGraphicsContext2D();
    }

    @FXML
    public void resetTable() {
        System.out.println("resetTable");
        graphicsContext.clearRect(0, 0, myCanvas.getWidth(), myCanvas.getHeight());
    }

    @FXML
    public void exitProgram() {
        System.exit(0);
    }

    @FXML
    public void saveTable(ActionEvent actionEvent) {
        WritableImage image = myCanvas.snapshot(new SnapshotParameters(), null);

        //we will set the extension
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show the file
        File file = fileChooser.showSaveDialog(new Stage());

        try {
            if (file != null) {
                ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

    }

    @FXML
    public void loadCanvas(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("PNG files (*.png", "*.png");
        fileChooser.getExtensionFilters().add(extensionFilter);

        File load = fileChooser.showSaveDialog(new Stage());

        try {
            BufferedImage bufferedImage = ImageIO.read(load);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            graphicsContext.drawImage(image, 0.0, 0.0);

        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }

    }

    public void undoShape(ActionEvent actionEvent) {
        System.out.println("undo");
    }
}
