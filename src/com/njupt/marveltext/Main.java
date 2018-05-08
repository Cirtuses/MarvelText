package com.njupt.marveltext;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
//import javafx.scene.layout.VBoxBuilder;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args){
		launch(args);
	}

	/**TabPane*/
	private TabPane tabPane;
	private TextField searchBar;
	@Override
	public void start(Stage stage) throws Exception {

		searchBar = new TextField();
		//����Ĭ��tab
		Tab tab = new Tab();
		TextArea txtArea = new TextArea();
		tab.setContent(txtArea);
		tab.setText("�½��ĵ�");

		tabPane = new TabPane();
		tabPane.getTabs().addAll(tab);
		// ˫��tag����������
		tabPane.setOnMouseClicked(e->{
			if(e.getClickCount() == 2)
				renameTab();
		});

		// Ctrl + R �Ƴ���ǰѡ���ĵ�Tag
		tabPane.setOnKeyPressed(e->{
			if(Keys.ctrR.match(e)){
				tabPane.getTabs().remove(tabPane.getSelectionModel().getSelectedItem());
			}
			// Ctrl + N �½� Tag ����
			else if(Keys.ctrN.match(e)){
				newTabHandler();
			}
			// F2 ������
			else if(e.getCode()==KeyCode.F2){
				renameTab();
			}
		});

		// 
		VBox layout = new VBox(10);
		layout.setId("main_layout");
		layout.getChildren().addAll(getMenuBar(), tabPane);

		Scene scene = new Scene(layout,800,600,Color.BLACK);

		//�󶨿��
		tabPane.prefHeightProperty().bind(scene.heightProperty());
		tabPane.prefWidthProperty().bind(scene.widthProperty());


		stage.setScene(scene);
		stage.setTitle("Marvel Text");
		stage.show();
	}

	// ������Menu
	public MenuBar getMenuBar() {

		//�ļ���
		Menu file = new Menu("�ļ�");

		MenuItem newTab =new MenuItem("�½�  (Ctrl + N)");
		newTab.setOnAction(e->{
			newTabHandler();
		});

		MenuItem renameTab = new MenuItem("������  (Ctrl + R)");
		renameTab.setOnAction(e-> {
			renameTab();
		});

		MenuItem openFile =new MenuItem("���ļ�  (Ctrl + Shift + F)");
		openFile.setOnAction(e -> {
			// doSomething
		});
		MenuItem openDir =new MenuItem("��Ŀ¼  (Ctrl + Shift + D )");
		openDir.setOnAction(e -> {
			// doSomething
		});

		MenuItem saveAs =new MenuItem("���Ϊ");
		saveAs.setOnAction(e -> {
			// doSomething
		});
		file.getItems().addAll(newTab, saveAs, renameTab, openFile, openDir);



		// View ��
		Menu view = new Menu("��ͼ");
		// ������


		// �༭��
		Menu edit = new Menu("  �༭  "); 
		MenuItem copy = new MenuItem("  ����  ");
		MenuItem paste = new MenuItem(" ճ��  ");
		MenuItem replace = new MenuItem("  �滻  ");
		MenuItem find = new MenuItem("  ����  ");
		MenuItem del = new MenuItem("  ɾ��  ");
		MenuItem selectAll = new MenuItem("  ȫѡ  ");
		MenuItem undo = new MenuItem("  ����  ");
		MenuItem cut = new MenuItem("  ����  ");
		edit.getItems().addAll(copy, paste, replace, find, del, selectAll, undo, cut);


		// ������
		Menu help = new Menu("  ����   ");
		MenuItem manual = new MenuItem("  �����ĵ�  ");
		MenuItem about = new MenuItem("  ���ڼ��±�  ");
		MenuItem contact = new MenuItem("  ��ϵ����  ");
		help.getItems().addAll(manual, about, contact);


		//��Menu�������
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(file, view, edit, help);

		return menuBar;
	}

	// ������Tag����
	public void newTabHandler(){
		Tab nT = new Tab("New Tab");
		nT.setContent(new TextArea());
		tabPane.getTabs().addAll(nT);
	}

	// ������tag
	public void renameTab(){
		String userInput = "";
		do {
			userInput = JOptionPane.showInputDialog("���������:");

			if(userInput == null || userInput.equals("")) {
				JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ�"
						, "��Ч����", JOptionPane.ERROR_MESSAGE, null);
			}
		} while(userInput == null || userInput.equals(""));

		// ����ǿ�
		tabPane.getSelectionModel().getSelectedItem().setText(userInput);
	}
}
