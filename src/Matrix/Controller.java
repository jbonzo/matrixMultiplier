package Matrix;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.ArrayDeque;
import java.util.List;

/**
 * Created by pearlterminal on 2/3/16.
 */
public class Controller {

    @FXML //fx:id="multiplyButton"
    private Button multiplyButton;

    @FXML //fx:id="grid1"
    private GridPane grid1;

    @FXML
    private GridPane grid2;

    @FXML
    private GridPane outputGrid;

    private TextField[][] matrix1 = new TextField[2][2];
    private TextField[][] matrix2 = new TextField[2][2];

    private ArrayDeque<Double> queue = new ArrayDeque<Double>();

    @FXML
    public void multiplyBtnAction(ActionEvent event) {
        double[][] matrixA;
        double[][] matrixB;
        double[][] productMatrix;


        // read in Matrix A and convert it to a matrix
        getInput(grid1);
        matrixA = GruntWork.convertToMatrix(queue, 2, 2);

        // read in Matrix B and convert it to a matrix
        getInput(grid2);
        matrixB = GruntWork.convertToMatrix(queue, 2, 2);

        // Find the answer!
        productMatrix = GruntWork.multiply(matrixA, matrixB);

        //String matrixString = toString(productMatrix);

        //System.out.println(matrixString);

        showProduct(productMatrix);

    }

    private String toString(double[][] matrix) {
        String result = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result += (int) matrix[i][j] + "  ";
            }
            result += "\n";
        }
        return result;
    }

    private void showProduct(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        List<Label> children = (List) outputGrid.getChildren();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                children.get(j * cols + i).setText((int) matrix[i][j] + "  ");
            }
        }
    }

    private void getInput(GridPane gridMatrix) {
        for (Node node : gridMatrix.getChildren()) {
            TextField field = (TextField) node;
            queue.add(Double.parseDouble(field.getCharacters().toString()));
        }
    }
}
