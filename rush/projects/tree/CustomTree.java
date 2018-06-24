import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable,Serializable{
    private int index;
    private Collection<? extends String> c;
    Entry<String> root;
    private int count=0;

    public CustomTree() {
        this.root = new Entry<>("0");
    }

    public static void main(String[] args) {
        List<String> list = new CustomTree();
        for (int i = 1; i < 131; i++) {
            list.add(String.valueOf(i));
        }
        System.out.println("Expected parent for 129 is 64, actual is " + ((CustomTree) list).getParent("129"));
        System.out.println("Expected parent for 5 is 2, actual is " + ((CustomTree) list).getParent("5"));
        System.out.println(list.size());
        //list.remove("5");
        //System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));
    }

    @Override
    public String get(int index) {
        //throw new UnsupportedOperationException();
        return null;
    }
    /** метод ввёл для простоты тестирования:
     *  ищет элемент по имени и возвращает его*/
    public Entry<String> getElement(String elementName){
        if(elementName==null)return null;
        Queue<Entry<String>>queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Entry<String>rootElement=queue.poll();
            if(rootElement.elementName.equals(elementName))return rootElement;
            else {
                if(rootElement.leftChild!=null)queue.offer(rootElement.leftChild);
                if(rootElement.rightChild!=null)queue.offer(rootElement.rightChild);
            }
        }
        return null;
    }
    /** возвращает текущее количество элементов в дереве
     * После добавления N элементов в дерево с помощью метода add,
     * метод size должен возвращать N*/
    @Override
    public int size() {
        return count;
    }
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
        //return (String)super.set(index, element);
    }

    /** добавляет элементы дерева,
     * в качестве параметра принимает имя элемента (elementName),
     * искать место для вставки начинаем слева направо */
    public boolean add(String s){
        if(s==null)return false;
        Queue<Entry<String>> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Entry<String>rootElement=queue.poll();
            if(rootElement!=null){
                rootElement.checkChildren();
                if(rootElement.isAvailableToAddChildren()){
                    if(rootElement.availableToAddLeftChildren){
                        rootElement.leftChild=new Entry<>(s);
                        rootElement.leftChild.isLeft=true;
                        rootElement.leftChild.parent=rootElement;
                        count++;
                        //System.out.println("Added left element named "+rootElement.leftChild.elementName+" with parent "+rootElement.leftChild.parent.elementName);
                    } else if(rootElement.availableToAddRightChildren){
                        rootElement.rightChild=new Entry<>(s);
                        rootElement.rightChild.isRight=true;
                        rootElement.rightChild.parent=rootElement;
                        count++;
                        //System.out.println("Added right element named "+rootElement.rightChild.elementName+" with parent "+rootElement.rightChild.parent.elementName);
                    }
                    return true;
                } else {
                    if(rootElement.leftChild!=null)queue.offer(rootElement.leftChild);
                    else {
                        rootElement.availableToAddLeftChildren=true;
                        queue.offer(rootElement);
                    }
                    if(rootElement.rightChild!=null)queue.offer(rootElement.rightChild);
                    else {
                        rootElement.availableToAddRightChildren=true;
                        queue.offer(rootElement);
                    }
                }
            }
        }
        return false;
    }
    /** будет удалять элемент дерева имя которого было полученного в качестве параметра.
     * Если переданный объект не является строкой,
     * метод должен бросить UnsupportedOperationException*/
    @Override
    public boolean remove(Object o) {
        if(o instanceof String){
            if(o==null)return false;
            List<Entry>branch=null;
            String elementName=(String)o;
            if(root.elementName.equals(elementName)){
                root=new Entry<>("0");
                return true;
            }
            Queue<Entry<String>>queue=new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                Entry<String>rootElement=queue.poll();
                if(rootElement.elementName.equals(elementName)){
                    //System.out.println("element was founded");
                    branch=getChildsAndParent(rootElement);
                    if(rootElement.isLeft){
                        rootElement.parent.availableToAddLeftChildren=true;
                        //System.out.println("may add left children? "+rootElement.parent.availableToAddLeftChildren);
                    }
                    else{
                        rootElement.parent.availableToAddRightChildren=true;
                        //System.out.println("may add right children? "+rootElement.parent.availableToAddRightChildren);
                    }
                    break;
                } else {
                    if(rootElement.leftChild!=null)queue.offer(rootElement.leftChild);
                    if(rootElement.rightChild!=null)queue.offer(rootElement.rightChild);
                }
            }
            for(Entry<String> element:branch){
                if(element.leftChild!=null)element.leftChild=null;
                if(element.rightChild!=null)element.rightChild=null;
                if(element.isLeft)element.parent.leftChild=null;
                else if(element.isRight)element.parent.rightChild=null;
                count--;
            }
            //System.out.println(branch.get(0).elementName);
            return true;
        } else throw new UnsupportedOperationException();
    }
    /** позволяет выбрать целую ветвь*/
    public List<Entry> getChildsAndParent(Entry parent){
        if(parent==null)return null;
        List<Entry> family=new ArrayList<>();
        Queue<Entry> queue=new LinkedList<>();
        queue.offer(parent);
        while (!queue.isEmpty()){
            Entry rootElement=queue.poll();
            if(rootElement.leftChild!=null)queue.offer(rootElement.leftChild);
            if(rootElement.rightChild!=null)queue.offer(rootElement.rightChild);
            family.add(rootElement);
        }
        return family;
    }
    @Override
    public List subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
        //return super.subList(fromIndex, toIndex);
    }
    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
        //super.removeRange(fromIndex, toIndex);
    }
    public boolean addAll(int index, Collection c) {
        throw new UnsupportedOperationException();
        //return super.addAll(index, c);
    }
    /** возвращает имя родителя элемента дерева,
     * имя которого было полученного в качестве параметра */
    public String getParent(String s){
        if(root==null||s==null)return null;
        Queue<Entry<String>>queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Entry<String>rootElement=queue.poll();
            //System.out.println("now checked element name is "+rootElement.elementName);
            if(rootElement.elementName.equals(s)){
                if(rootElement.parent==null){
                    return "Have no parent";
                } else return rootElement.parent.elementName;
            } else {
                if(rootElement.leftChild!=null){
                    queue.offer(rootElement.leftChild);
                }
                if(rootElement.rightChild!=null){
                    queue.offer(rootElement.rightChild);
                }
            }
        }
        return null;}

    static class Entry<T> implements Serializable{
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        boolean isLeft=false, isRight=false;
        Entry<T> parent, leftChild, rightChild;
        public Entry(String string){
            elementName=string;
            availableToAddLeftChildren=true;
            availableToAddRightChildren=true;
        }
        void checkChildren(){
            if(leftChild!=null)availableToAddLeftChildren=false;
            if(rightChild!=null)availableToAddRightChildren=false;
        }
        boolean isAvailableToAddChildren(){
            return availableToAddLeftChildren|availableToAddRightChildren;
        }
    }
}
