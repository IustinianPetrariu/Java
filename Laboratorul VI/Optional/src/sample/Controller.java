package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TextField;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
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
    private TextField stroke;
    @FXML
    private RadioButton freeDraw;
    @FXML
    private RadioButton square;
    @FXML
    private RadioButton circle;
    @FXML
    private RadioButton triangle;
    @FXML
    private RadioButton delete;
    @FXML
    private HBox panelForTriangle;

    private LinkedList<MyShapes> shapes = new LinkedList<>();


    public void drawSquare(double x, double y) {

        graphicsContext.setFill(color.getValue());
        int size = 0;
        String parsingSize = mySize.getText();
        if (parsingSize.length() == 0) {
            ///if user don't specify the lenght, to avoid obtaining an error
            size = 21;
        } else {
            size = Integer.parseInt(mySize.getText());
        }

        graphicsContext.fillRect(x, y, size, size);
        MyShapes shape = new MyShapes("square", x, y, size, color.getValue());
        shapes.addFirst(shape);

    }

    public void drawCircle(double x, double y) {
        int size;
        graphicsContext.setFill(color.getValue());
        String parsingSize = mySize.getText();
        if (parsingSize.length() == 0) {
            ///if user don't specify the lenght, to avoid obtaining an error
            size = 21;
        } else {
            size = Integer.parseInt(mySize.getText());
        }
        graphicsContext.fillOval(x, y, size, size);
        MyShapes shape = new MyShapes("circle", x, y, size, color.getValue());
        shapes.addFirst(shape);
    }

    public void drawTriangle(double x, double y) {
        int size = 0;
        String parsingSize = mySize.getText();
        if (parsingSize.length() == 0) {
            ///if user don't specify the lenght, to avoid obtaining an error
            size = 21;
        } else {
            size = Integer.parseInt(mySize.getText());
        }
        int strokeLine = 0;
        String parsingStroke = stroke.getText();
        if (parsingStroke.length() == 0) {
            strokeLine = 2;
        } else {
            strokeLine = Integer.parseInt(stroke.getText());
        }
        graphicsContext.setLineWidth(strokeLine);
        graphicsContext.setStroke(color.getValue());
        graphicsContext.strokeLine(x - size / 2, y + size / 2, x + size / 2, y + size / 2);
        graphicsContext.strokeLine(x, y - size / 2, x - size / 2, y + size / 2);
        graphicsContext.strokeLine(x, y - size / 2, x + size / 2, y + size / 2);
        MyShapes shape = new MyShapes("triangle", x, y, size, color.getValue());
        shape.setLineWidth(strokeLine);
        shapes.addFirst(shape);
    }

    public void deleteShape(double xMouse, double yMouse) {
        System.out.println("deleted!");
        //iterate to all the shapes and find the one to delete and then paint again
        for (int j = 0; j < shapes.size(); j++) {
            double x = shapes.get(j).getX();
            double y = shapes.get(j).getY();
            int size = shapes.get(j).getSize();
            if (xMouse >= x && xMouse <= x + size && yMouse >= y && yMouse <= y + size) {
                shapes.remove(j);
                graphicsContext.clearRect(0, 0, myCanvas.getWidth(), myCanvas.getHeight());
                int sizeFigure, lineWidth;
                double x1, y1;
                for (int i = 0; i < shapes.size(); i++) {
                    switch (shapes.get(i).getFigure()) {
                        case "circle":
                            graphicsContext.setFill(shapes.get(i).getColor());
                            sizeFigure = shapes.get(i).getSize();
                            x1 = shapes.get(i).getX();
                            y1 = shapes.get(i).getY();
                            graphicsContext.fillOval(x1, y1, sizeFigure, sizeFigure);
                            break;
                        case "square":
                            sizeFigure = shapes.get(i).getSize();
                            x1 = shapes.get(i).getX();
                            y1 = shapes.get(i).getY();
                            graphicsContext.setFill(shapes.get(i).getColor());
                            graphicsContext.fillRect(x1, y1, sizeFigure, sizeFigure);
                            break;
                        case "triangle":
                            size = shapes.get(i).getSize();
                            x = shapes.get(i).getX();
                            y = shapes.get(i).getY();
                            lineWidth = shapes.get(i).getLineWidth();
                            graphicsContext.setStroke(shapes.get(i).getColor());
                            graphicsContext.setLineWidth(lineWidth);
                            graphicsContext.strokeLine(x - size / 2, y + size / 2, x + size / 2, y + size / 2);
                            graphicsContext.strokeLine(x, y - size / 2, x - size / 2, y + size / 2);
                            graphicsContext.strokeLine(x, y - size / 2, x + size / 2, y + size / 2);
                            break;

                    }
                }

            }

        }

    }

    public void drawShape(MouseEvent mouseEvent) {
        if (freeDraw.isSelected()) {
            myCanvas.setOnMouseDragged(e -> {
                if (freeDraw.isSelected()) {
                    double size = 12;
                    double x = e.getX();
                    double y = e.getY();
                    graphicsContext.setFill(Color.RED);
                    graphicsContext.fillOval(x, y, size, size);
                }
            });
        }

        ///now I want to delete a selected shape!

        double x = mouseEvent.getX();
        double y = mouseEvent.getY();
        if (delete.isSelected()) {
            deleteShape(x, y);
        }
        if (square.isSelected()) {
            drawSquare(x, y);
        }
        if (circle.isSelected()) {
            drawCircle(x, y);
        }
        if (triangle.isSelected()) {
            drawTriangle(x, y);
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        System.out.println("all good !");
        graphicsContext = myCanvas.getGraphicsContext2D();
        panelForTriangle.setVisible(false);
    }

    @FXML
    public void resetTable() {
        System.out.println("resetTable");
        graphicsContext.clearRect(0, 0, myCanvas.getWidth(), myCanvas.getHeight());
        shapes.clear();

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
        graphicsContext.clearRect(0, 0, myCanvas.getWidth(), myCanvas.getHeight());
        shapes.removeFirst();
        int size, lineWidth;
        double x, y;
        for (int i = 0; i < shapes.size(); i++) {
            switch (shapes.get(i).getFigure()) {
                case "circle":
                    graphicsContext.setFill(shapes.get(i).getColor());
                    size = shapes.get(i).getSize();
                    x = shapes.get(i).getX();
                    y = shapes.get(i).getY();
                    graphicsContext.fillOval(x, y, size, size);
                    break;
                case "square":
                    size = shapes.get(i).getSize();
                    x = shapes.get(i).getX();
                    y = shapes.get(i).getY();
                    graphicsContext.setFill(shapes.get(i).getColor());
                    graphicsContext.fillRect(x, y, size, size);
                    break;
                case "triangle":
                    size = shapes.get(i).getSize();
                    x = shapes.get(i).getX();
                    y = shapes.get(i).getY();
                    lineWidth = shapes.get(i).getLineWidth();
                    graphicsContext.setLineWidth(lineWidth);
                    graphicsContext.setStroke(shapes.get(i).getColor());
                    graphicsContext.strokeLine(x - size / 2, y + size / 2, x + size / 2, y + size / 2);
                    graphicsContext.strokeLine(x, y - size / 2, x - size / 2, y + size / 2);
                    graphicsContext.strokeLine(x, y - size / 2, x + size / 2, y + size / 2);
                    break;

            }
        }
    }

    public void freeDrawing(MouseEvent mouseEvent) {

        double size = 12;
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();
        graphicsContext.setFill(Color.RED);
        graphicsContext.fillOval(x, y, size, size);

    }

    public void showPanel(MouseEvent mouseEvent) {

        panelForTriangle.setVisible(true);
    }

    public void hidePanel(MouseEvent mouseEvent) {
        panelForTriangle.setVisible(false);
    }
}
