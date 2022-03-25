import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculator extends Application
{
   public void start (Stage stage)
   {
      TextField txtNum1= new TextField();
      txtNum1.setMaxWidth(50);
      TextField txtNum2= new TextField();
      txtNum2.setMaxWidth(50);
      Label lblNum1= new Label("Enter number 1");
      Label lblNum2= new Label("Enter number 2");
      Button btnAdd= new Button("Add");
      Button btnSub= new Button("Subtract");
      Button btnMul= new Button("Multiply");
      Button btnDiv= new Button("Divide");
      Label lblResult= new Label("Result:");
      HBox input= new HBox(10);
      input.getChildren().addAll(lblNum1,txtNum1,lblNum2,txtNum2);
      input.setAlignment(Pos.CENTER);
      VBox root= new VBox(25);
      HBox operations= new HBox(10);
      operations.getChildren().addAll(btnAdd,btnSub,btnMul,btnDiv);
      operations.setAlignment(Pos.CENTER);
      root.getChildren().addAll(input,operations,lblResult);
      root.setAlignment(Pos.CENTER);
      
      btnAdd.setOnAction(e->lblResult.setText("Result:"+(Double.parseDouble(txtNum1.getText())+Double.parseDouble(txtNum2.getText()))));
      btnSub.setOnAction(e->lblResult.setText("Result:"+(Double.parseDouble(txtNum1.getText())-Double.parseDouble(txtNum2.getText()))));
      btnMul.setOnAction(e->lblResult.setText("Result:"+(Double.parseDouble(txtNum1.getText())*Double.parseDouble(txtNum2.getText()))));
      btnDiv.setOnAction(e->lblResult.setText("Result:"+(Double.parseDouble(txtNum1.getText())/Double.parseDouble(txtNum2.getText()))));

      
      Scene scene= new Scene (root,350,250);
      stage.setScene(scene);
      stage.setTitle("Calculator");
      stage.show();
      }
      
      public static void main (String [] args)
      {
         launch(args);
         }
}
      
      
      



