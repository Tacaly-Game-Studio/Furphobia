package screens;

import com.tacaly.furphobia.Image;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.LinearGradient;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

import static java.awt.SystemColor.menu;

public class MainMenu {
    @Override
    public void start(Stage stage) throws Exception{
        stage.setScene(new Scene(createMenu()));
        stage.show();
    }

    private Parent createMenu() {
        Pane root = new Pane();
        root.setPrefSize(1280,720);

        Image bgImage = new Image(
                getClass().getResource(resources/menu.jpg),
                1280,720,
                false, true
        );
        return root;
    }
    private static class MenuItem extends StackPane {
        MenuItem(String name, Runnable action) {
            LinearGradient gradient = new LinearGradient();
        }
    }
}
