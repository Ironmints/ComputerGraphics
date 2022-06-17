import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class rectangle extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 300, 250);
        javafx.scene.shape.Rectangle r = new javafx.scene.shape.Rectangle(50, 50, 200, 100);
        root.getChildren().add(r);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

