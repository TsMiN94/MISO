package miso.views;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import miso.utility.Scope;

public class KeyboardView extends View{
	protected FXMLLoader loader;
	private String fxml = "/miso/fxml/keyboard.fxml";
	private AnchorPane root;
	
	@Override
	public void load() {
	
		try {
			primaryStage = new Stage();
			loader = new FXMLLoader(getClass().getResource(fxml));
			System.out.println(loader + "1");
			root = loader.load();
			
	
			System.out.println(root + "2");
			scene = new Scene(root, 720, 400);
			
			Scope.getInstace().setKeyboardStage(primaryStage);
			primaryStage.getIcons().add(new Image("/miso/icon/keyboard.png"));
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.hide();
			
			primaryStage.setOnCloseRequest(e->{
				
			});
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public AnchorPane getRoot() {
		return root;
	}

	public void setRoot(AnchorPane root) {
		this.root = root;
	}
	
}
