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
		//设置默认tab
		Tab tab = new Tab();
		TextArea txtArea = new TextArea();
		tab.setContent(txtArea);
		tab.setText("新建文档");

		tabPane = new TabPane();
		tabPane.getTabs().addAll(tab);
		// 双击tag栏可重命名
		tabPane.setOnMouseClicked(e->{
			if(e.getClickCount() == 2)
				renameTab();
		});

		// Ctrl + R 移除当前选定的的Tag
		tabPane.setOnKeyPressed(e->{
			if(Keys.ctrR.match(e)){
				tabPane.getTabs().remove(tabPane.getSelectionModel().getSelectedItem());
			}
			// Ctrl + N 新建 Tag 窗口
			else if(Keys.ctrN.match(e)){
				newTabHandler();
			}
			// F2 重命名
			else if(e.getCode()==KeyCode.F2){
				renameTab();
			}
		});

		// 
		VBox layout = new VBox(10);
		layout.setId("main_layout");
		layout.getChildren().addAll(getMenuBar(), tabPane);

		Scene scene = new Scene(layout,800,600,Color.BLACK);

		//绑定宽高
		tabPane.prefHeightProperty().bind(scene.heightProperty());
		tabPane.prefWidthProperty().bind(scene.widthProperty());


		stage.setScene(scene);
		stage.setTitle("Marvel Text");
		stage.show();
	}

	// 创建新Menu
	public MenuBar getMenuBar() {

		//文件栏
		Menu file = new Menu("文件");

		MenuItem newTab =new MenuItem("新建  (Ctrl + N)");
		newTab.setOnAction(e->{
			newTabHandler();
		});

		MenuItem renameTab = new MenuItem("重命名  (Ctrl + R)");
		renameTab.setOnAction(e-> {
			renameTab();
		});

		MenuItem openFile =new MenuItem("打开文件  (Ctrl + Shift + F)");
		openFile.setOnAction(e -> {
			// doSomething
		});
		MenuItem openDir =new MenuItem("打开目录  (Ctrl + Shift + D )");
		openDir.setOnAction(e -> {
			// doSomething
		});

		MenuItem saveAs =new MenuItem("另存为");
		saveAs.setOnAction(e -> {
			// doSomething
		});
		file.getItems().addAll(newTab, saveAs, renameTab, openFile, openDir);



		// View 栏
		Menu view = new Menu("视图");
		// 待补充


		// 编辑栏
		Menu edit = new Menu("  编辑  "); 
		MenuItem copy = new MenuItem("  复制  ");
		MenuItem paste = new MenuItem(" 粘贴  ");
		MenuItem replace = new MenuItem("  替换  ");
		MenuItem find = new MenuItem("  查找  ");
		MenuItem del = new MenuItem("  删除  ");
		MenuItem selectAll = new MenuItem("  全选  ");
		MenuItem undo = new MenuItem("  撤销  ");
		MenuItem cut = new MenuItem("  剪切  ");
		edit.getItems().addAll(copy, paste, replace, find, del, selectAll, undo, cut);


		// 帮助栏
		Menu help = new Menu("  帮助   ");
		MenuItem manual = new MenuItem("  帮助文档  ");
		MenuItem about = new MenuItem("  关于记事本  ");
		MenuItem contact = new MenuItem("  联系我们  ");
		help.getItems().addAll(manual, about, contact);


		//把Menu组合起来
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(file, view, edit, help);

		return menuBar;
	}

	// 创建新Tag函数
	public void newTabHandler(){
		Tab nT = new Tab("New Tab");
		nT.setContent(new TextArea());
		tabPane.getTabs().addAll(nT);
	}

	// 重命名tag
	public void renameTab(){
		String userInput = "";
		do {
			userInput = JOptionPane.showInputDialog("请输入标题:");

			if(userInput == null || userInput.equals("")) {
				JOptionPane.showMessageDialog(null, "输入不能为空！"
						, "无效名称", JOptionPane.ERROR_MESSAGE, null);
			}
		} while(userInput == null || userInput.equals(""));

		// 输入非空
		tabPane.getSelectionModel().getSelectedItem().setText(userInput);
	}
}
