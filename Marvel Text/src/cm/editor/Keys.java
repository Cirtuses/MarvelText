package cm.editor;
/**Shortcut keys for the program
 * @author Shane Moe (https://github.com/ssoemoe)*/
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

public class Keys {
	
	public static final KeyCombination ctrR = new KeyCodeCombination(KeyCode.R,KeyCombination.CONTROL_ANY);// 重命名
	public static final KeyCombination ctrN = new KeyCodeCombination(KeyCode.N,KeyCombination.CONTROL_ANY);// 新建Tag
	public static final KeyCombination ctrS = new KeyCodeCombination(KeyCode.S,KeyCombination.CONTROL_ANY);// 保存 
	public static final KeyCombination ctrShfS = new KeyCodeCombination(KeyCode.S,KeyCombination.SHIFT_ANY,KeyCombination.CONTROL_ANY); //另存为
	public static final KeyCombination ctrShfR = new KeyCodeCombination(KeyCode.N,KeyCombination.SHIFT_ANY,KeyCombination.CONTROL_ANY); // 移除
	public static final KeyCombination ctrH = new KeyCodeCombination(KeyCode.H,KeyCombination.CONTROL_ANY); // 帮助文档
}
