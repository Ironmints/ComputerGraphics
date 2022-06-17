import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.*;

public class redline extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 300, 250);
        Rectangle r = new Rectangle(50, 50, 200, 100);
        root.getChildren().add(r);
        r.setFill(Color.YELLOW);;
        scene.setFill(Color.GREEN);
        Line l = new Line(100, 100, 200, 100); //
        root.getChildren().add(l);
        l.setStroke(Color.RED);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
