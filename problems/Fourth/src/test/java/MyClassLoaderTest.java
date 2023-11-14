import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyClassLoaderTest {
    @Test
    public void checkLoadingClass(){
        MyClassLoader myClassLoader = new MyClassLoader();
        Class foundClass = myClassLoader.findClass("classes.Human");
        Assert.assertEquals(foundClass.getName(), "classes.Human");
    }

}