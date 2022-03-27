import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BankGUI extends Application
{
   private BankAccount currAcc = new BankAccount(87594, "Mary Green", 250.00);
   public void start (Stage stage)
   {
      Label lblOpt1= new Label("Choose an option");
      Button btnAdd= new Button("View all Account Details");
      Button btnSub= new Button("View Balance Only");
      Button btnMul= new Button("Deposit Money");
      Button btnDiv= new Button("Withdraw Money");
      Label lblResult= new Label();
      VBox root= new VBox(25);
      root.getChildren().addAll(lblOpt1,btnAdd,btnSub,btnMul,btnDiv,lblResult);
      root.setAlignment(Pos.CENTER);
      
      btnAdd.setOnAction(e->lblResult.setText("Account details: "+currAcc.toString()));

      btnSub.setOnAction(e->lblResult.setText("Balance: "+currAcc.viewBalance()));

      btnMul.setOnAction(e->
         {
         lblResult.setText("How much money you want to deposit?");

         TextField txtNum1= new TextField();
         Button btnDep= new Button("Deposit");
         txtNum1.setMaxWidth(50);
         root.getChildren().addAll(txtNum1,btnDep);
         btnDep.setOnAction(e2->
            {
               currAcc.depositMoney(Double.parseDouble(txtNum1.getText()));
               root.getChildren().removeAll(txtNum1,btnDep);
               lblResult.setText("Balance: "+currAcc.viewBalance());
             });
         });
      btnDiv.setOnAction(e->
         {
         lblResult.setText("How much money you want to withdraw?");

         TextField txtNum2= new TextField();
         Button btnDep= new Button("Withdraw");
         txtNum2.setMaxWidth(50);
         root.getChildren().addAll(txtNum2,btnDep);
         btnDep.setOnAction(e2->
            {
               currAcc.withdrawMoney(Double.parseDouble(txtNum2.getText()));
               root.getChildren().removeAll(txtNum2,btnDep);
               lblResult.setText("Balance: "+currAcc.viewBalance());
             });
         });

      
      Scene scene= new Scene (root,550,550);
      stage.setScene(scene);
      stage.setTitle("ATM");
      stage.show();
      }
      
      public static void main (String [] args)
      {
         launch(args);
         }
}
      
      
      



