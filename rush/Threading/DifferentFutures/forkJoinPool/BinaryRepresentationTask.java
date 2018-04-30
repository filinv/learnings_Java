import java.util.concurrent.RecursiveTask;

public class BinaryRepresentationTask extends RecursiveTask<String>{
    final int x;
    public BinaryRepresentationTask(int x) {
        this.x=x;
    }

    @Override
    protected String compute() {
        BinaryRepresentationTask a=new BinaryRepresentationTask(x%2);
        a.fork();
        BinaryRepresentationTask b=new BinaryRepresentationTask(x/2);
        String result=String.valueOf(a.x);
        if(b.x>0)return b.compute()+a.join();
        return result;        
    }
}
