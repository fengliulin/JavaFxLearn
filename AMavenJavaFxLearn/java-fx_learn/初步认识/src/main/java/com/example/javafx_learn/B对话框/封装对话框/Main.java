package com.example.javafx_learn.B对话框.封装对话框;

import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class Main extends Application
{
	StudentPane studentPane =new StudentPane();
	
	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			BorderPane root = new BorderPane();
			root.setCenter(studentPane);
			
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			Button add = new Button("添加");
			root.setTop(add);
			add.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event)
				{
					onAdd();
				}				
			});
			
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void onAdd()
	{
		AddStudentDialog dlg = new AddStudentDialog();
		Optional<Boolean> result = dlg.showAndWait();
		if( result.isPresent() && result.get() == true)
		{
			Student s = dlg.getValue(); // getValue()是自己添加的方法
			studentPane.add(s );			
		}
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
