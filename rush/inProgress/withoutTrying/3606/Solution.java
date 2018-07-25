import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* 
Осваиваем ClassLoader и Reflection
Аргументом для класса Solution является абсолютный путь к пакету.
Имя пакета может содержать File.separator.
В этом пакете кроме скомпилированных классов (.class) могут находиться и другие файлы (например: .java).
Известно, что каждый класс имеет конструктор без параметров и реализует интерфейс HiddenClass.
Считай все классы с файловой системы, создай фабрику - реализуй метод getHiddenClassObjectByKey.
Примечание: в пакете может быть только один класс, простое имя которого начинается с String key без учета регистра.

Требования:
1. Реализуй метод scanFileSystem, он должен добавлять в поле hiddenClasses найденные классы.
2. Реализуй метод getHiddenClassObjectByKey, он должен создавать объект класса согласно условию задачи.
3. Метод main не изменяй.
4. Метод getHiddenClassObjectByKey не должен кидать исключений.
*/
public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplse"));
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplf"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        return null;
    }
}
