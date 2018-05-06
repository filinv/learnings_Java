import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {
    private SomeInterfaceWithMethods someInterfaceWithMethods;
    public CustomInvocationHandler(SomeInterfaceWithMethods someInterfaceWithMethods) {
        this.someInterfaceWithMethods=someInterfaceWithMethods;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.format("%s in%n",method.getName());
        Object o=method.invoke(someInterfaceWithMethods,args);
        System.out.format("%s out%n",method.getName());
        return o;
    }
}
