import javafx.application.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.stage.*;


public class ArtShow extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // 1. set up root Group or Pane
        Group root = new Group();
        // 2. set up Scene
        double sceneWidth = 800;
        double sceneHeight = 600;
        Scene gallery = new Scene(root, sceneWidth, sceneHeight, Color.WHITESMOKE);
        primaryStage.setScene(gallery);
        primaryStage.setTitle("ArtShow");
        primaryStage.show();
        // 3. add Nodes
        double spc = 4;
        Pane mondrian = new Pane();
        HBox artwork = new HBox(spc);
        // COLUMN A
        VBox colA = new VBox(spc);
        Rectangle a1 = new Rectangle(30, 60);
        a1.setFill(Color.WHITE);
        colA.getChildren().add(a1);
        Rectangle a2 = new Rectangle(30, 120);
        a2.setFill(Color.YELLOW);
        colA.getChildren().add(a2);
        Rectangle a3 = new Rectangle(30, 60);
        a3.setFill(Color.WHITE);
        colA.getChildren().add(a3);
        Rectangle a4 = new Rectangle(30, 30);
        a4.setFill(Color.DARKBLUE);
        colA.getChildren().add(a4);
        // COLUMN B
        VBox colB = new VBox(spc);
        colB.setLayoutX(colA.getLayoutX() + 120);
        Rectangle b1 = new Rectangle(120, (a1.getHeight()/3)-spc/2);
        b1.setFill(Color.WHITE);
        colB.getChildren().add(b1);
        HBox b2 = new HBox(spc);
        Rectangle b2_1 = new Rectangle(60 - spc/2, ((a1.getHeight()/3)*2)-spc/2);
        b2_1.setFill(Color.WHITE);
        Rectangle b2_2 = new Rectangle(60 - spc/2,((a1.getHeight()/3)*2)-spc/2);
        b2_2.setFill(Color.WHITE);
        b2.getChildren().add(b2_1);
        b2.getChildren().add(b2_2);
        colB.getChildren().add(b2);
        Rectangle b3 = new Rectangle(120, a2.getHeight()+a3.getHeight()+spc);
        b3.setFill(Color.WHITE);
        colB.getChildren().add(b3);
        Rectangle b4 = new Rectangle(120, a4.getHeight());
        b4.setFill(Color.WHITE);
        colB.getChildren().add(b4);
        // COLUMN C
        VBox colC = new VBox(spc);
        Rectangle c1 = new Rectangle(90, 40-spc/2);
        c1.setFill(Color.WHITE);
        colC.getChildren().add(c1);
        Rectangle c2 = new Rectangle(c1.getWidth(),  20 - spc/2);
        c2.setFill(Color.CRIMSON);
        colC.getChildren().add(c2);
        Rectangle c3 = new Rectangle(c1.getWidth(), 120);
        c3.setFill(Color.WHITE);
        colC.getChildren().add(c3);
        Rectangle c4 = new Rectangle(c1.getWidth(), 60);
        c4.setFill(Color.WHITE);
        colC.getChildren().add(c4);
        Rectangle c5 = new Rectangle(c1.getWidth(), 30);
        c5.setFill(Color.BLACK);
        colC.getChildren().add(c5);
        // COLUMN D
        VBox colD = new VBox(spc);
        Rectangle d1 = new Rectangle(60, a1.getHeight());
        d1.setFill(Color.WHITE);
        colD.getChildren().add(d1);
        Rectangle d2 = new Rectangle(60, a2.getHeight());
        d2.setFill(Color.WHITE);
        colD.getChildren().add(d2);
        Rectangle d3 = new Rectangle(60, a3.getHeight());
        d3.setFill(Color.DARKBLUE);
        colD.getChildren().add(d3);
        Rectangle d4 = new Rectangle(60, a4.getHeight());
        d4.setFill(Color.WHITE);
        colD.getChildren().add(d4);
        // COLUMN E
        VBox colE = new VBox(spc);
        Rectangle e1 = new Rectangle(d1.getWidth(), c1.getHeight());
        e1.setFill(Color.YELLOW);
        colE.getChildren().add(e1);
        Rectangle e2 = new Rectangle(d1.getWidth(),  20 - spc/2);
        e2.setFill(Color.WHITE);
        colE.getChildren().add(e2);
        HBox e3 = new HBox(spc);
        Rectangle e3_1 = new Rectangle(d1.getWidth()/2 - spc/2, d2.getHeight() + d3.getHeight() + d4.getHeight() + spc * 2);
        e3_1.setFill(Color.WHITE);
        e3.getChildren().add(e3_1);
        Rectangle e3_2 = new Rectangle(d1.getWidth()/2 - spc/2, d2.getHeight() + d3.getHeight() + d4.getHeight() + spc * 2);
        e3_2.setFill(Color.WHITE);
        e3.getChildren().add(e3_2);
        colE.getChildren().add(e3);

        double artworkWidth = a1.getWidth() + b1.getWidth() + c1.getWidth() + d1.getWidth() + e1.getWidth() + spc * 5;
        double artworkHeight = a1.getHeight() + a2.getHeight() + a3.getHeight() + a4.getHeight() + spc * 4;

        double matte = 50;
        double frameStrokeWidth = 10;
        double frameWidth = artworkWidth + frameStrokeWidth * 2 + matte * 2;
        double frameHeight = artworkHeight + frameStrokeWidth * 2 + matte * 2;

        // frame
        Rectangle frame = new Rectangle(frameWidth, frameHeight);
        frame.setStroke(Color.SIENNA);
        frame.setFill(Color.FLORALWHITE);
        frame.setStrokeWidth(frameStrokeWidth);
        mondrian.getChildren().add(frame);
        Rectangle blackBars = new Rectangle(artworkWidth, artworkHeight - 1);
        blackBars.setFill(Color.BLACK);
        mondrian.getChildren().add(blackBars);
        blackBars.setLayoutX(frameWidth/2 - artworkWidth/2);
        blackBars.setLayoutY(frameHeight/2 - artworkHeight/2);

        artwork.getChildren().add(colA);
        artwork.getChildren().add(colB);
        artwork.getChildren().add(colC);
        artwork.getChildren().add(colD);
        artwork.getChildren().add(colE);
        mondrian.getChildren().add(artwork);
        artwork.setLayoutX(frameWidth/2 - artworkWidth/2 + 1);
        artwork.setLayoutY(frameHeight/2 - artworkHeight/2 + 1);

        Font fCaptionHead = new Font(18);
        Font fCaptionBody = new Font(14);
        Text captionHead = new Text("Mondrian-style painting (Brent, 2021)");
        Text captionBody = new Text("Piet Mondrian is well-known for his neo-plasticism art such as " + "\n" +
                                    "\"Composition with Red Blue and Yellow\" (1930). This piece is an original" + "\n" +
                                    "creation done in homage to Mondrian's style.");
        captionHead.setFont(fCaptionHead);
        captionBody.setFont(fCaptionBody);
        VBox caption = new VBox();
        caption.getChildren().add(captionHead);
        caption.getChildren().add(captionBody);
        mondrian.getChildren().add(caption);

        caption.setLayoutY(frameHeight + 25);

        root.getChildren().add(mondrian);
        mondrian.setLayoutX(sceneWidth/2 - frameWidth/2);
        mondrian.setLayoutY(sceneHeight/3 - frameHeight/3);

    }
}
