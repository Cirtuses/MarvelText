package cm.editor;
/**Shortcut keys for the program
 * @author Shane Moe (https://github.com/ssoemoe)*/
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

public class Keys {
	
	public static final KeyCombination ctrR = new KeyCodeCombination(KeyCode.R,KeyCombination.CONTROL_ANY);// ������
	public static final KeyCombination ctrN = new KeyCodeCombination(KeyCode.N,KeyCombination.CONTROL_ANY);// �½�Tag
	public static final KeyCombination ctrS = new KeyCodeCombination(KeyCode.S,KeyCombination.CONTROL_ANY);// ���� 
	public static final KeyCombination ctrShfS = new KeyCodeCombination(KeyCode.S,KeyCombination.SHIFT_ANY,KeyCombination.CONTROL_ANY); //���Ϊ
	public static final KeyCombination ctrShfR = new KeyCodeCombination(KeyCode.N,KeyCombination.SHIFT_ANY,KeyCombination.CONTROL_ANY); // �Ƴ�
	public static final KeyCombination ctrH = new KeyCodeCombination(KeyCode.H,KeyCombination.CONTROL_ANY); // �����ĵ�
}
