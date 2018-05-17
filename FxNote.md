## JavaFx学习笔记  
理解JavaFX应用程序基本结构需要了解的一些重点：  
** JavaFX应用程序的主类需要继承自application.Application类。start()方法是所有JavaF用程序的入口。**  

*JavaFX应用程序将UI容器定义为舞台(Stage)与场景(Scene)Stage类是JavaFX顶级容器。Scene类是所有内容的容器。  
*在JavaFX中，Scene中的内容会以由图形节点(Node)构成的分层场景图(Scene Graph)来展现。  
*root节点包含一个带文本的按钮子节点，按钮上添加了一个事件处理器(Event Handler)，它在点击按钮时会向控制台输出信息。


```java
public void start(Stage primaryStage) {
   Button btn = new Button();
   btn.setText("Say Hello World");


   btn.setOnAction(new EventHandler<ActionEvent>() {
       @Override
       public void handle(ActionEvent event) {
          System.out.println("Hello World");
       }
   });
}
```

```java
btn.setOnAction(new EventHandler<ActionEvent>() {//注册事件handler
  @Override
  public void handle(ActionEvent e) {
      actiontarget.setFill(Color.FIREBRICK);//将文字颜色变成 firebrick red
      actiontarget.setText(“Sign in button pressed”);
  }
});
```
