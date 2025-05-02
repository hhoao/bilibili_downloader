package nicelee.test.junit.common;

import java.util.List;
import nicelee.bilibili.PackageScanLoader;
import nicelee.bilibili.annotations.Bilibili;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PackageScanLoaderTest {

    @BeforeClass
    public static void setUpBeforeClass() {}

    @AfterClass
    public static void tearDownAfterClass() {}

    @Before
    public void setUp() {}

    @After
    public void tearDown() {}

    // @Test
    public void testAll() {
        PackageScanLoader pLoader =
                new PackageScanLoader() {
                    @Override
                    public boolean isValid(Class<?> klass) {
                        return true;
                    }
                };
        List<Class<?>> clazzes = pLoader.scanRoot("nicelee.bilibili");
        System.out.println("所有类名");
        for (Class<?> clazz : clazzes) {
            System.out.println(clazz.getName());
        }
    }

    @Test
    public void testLoadAnnotation() {
        PackageScanLoader pLoader =
                new PackageScanLoader() {
                    @Override
                    public boolean isValid(Class<?> klass) {
                        Bilibili bili = klass.getAnnotation(Bilibili.class);
                        if (null != bili) {
                            // System.out.println(bili.name());
                            return true;
                        }
                        return false;
                    }
                };
        List<Class<?>> clazzes = pLoader.scanRoot("nicelee.bilibili");
        System.out.println("有bilibili注解的类名");
        for (Class<?> clazz : clazzes) {
            System.out.println(clazz.getName());
        }
    }
}
