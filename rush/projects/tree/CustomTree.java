import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList implements Cloneable,Serializable{
    private int index;
    private Collection<? extends String> c;
    Entry<String> root;

    public static void main(String[] args) {
        List<String> list = new CustomTree();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        //System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
        list.remove("5");
        //System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
        //return null;
    }
    @Override
    public int size() {
        return 0;
    }
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
        //return (String)super.set(index, element);
    }
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
        //super.add(index, element);
    }
    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
        //return (String)super.remove(index);
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
    static class Entry<T> implements Serializable{
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
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
