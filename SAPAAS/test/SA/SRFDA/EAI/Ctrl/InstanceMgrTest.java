package SA.SRFDA.EAI.Ctrl;

import SA.SRFramework.DataEx.CallResult;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import junit.framework.TestCase;
import org.mule.api.MuleContext;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.registry.MuleRegistry;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class InstanceMgrTest extends TestCase {
    public void testLifecycleUsesRegisteredHelperAndAllowsRestart() throws Exception {
        File directory = File.createTempFile("eai-lifecycle-", ".dir");
        assertTrue(directory.delete());
        assertTrue(directory.mkdir());
        File marker = new File(directory, "sample.run");
        EAIDAGlobalHelper helper = helper();
        InstanceMgr instance = instance(helper, helper, directory);
        final int[] stopped = {0};
        try {
            instance.initialise();
            instance.eaiDataCtrl = (ISRFEAIDataCtrl)Proxy.newProxyInstance(
                    ISRFEAIDataCtrl.class.getClassLoader(), new Class<?>[] {ISRFEAIDataCtrl.class},
                    new InvocationHandler() {
                        public Object invoke(Object proxy, Method method, Object[] args) {
                            assertEquals("MarkServiceStop", method.getName());
                            stopped[0]++;
                            return new CallResult();
                        }
                    });
            instance.start();
            assertTrue(marker.isFile());
            instance.stop();
            assertFalse(marker.exists());
            instance.start();
            assertTrue(marker.isFile());
            assertTrue(marker.delete());
            instance.run();
            assertEquals(2, stopped[0]);
            assertFalse(marker.exists());
        } finally {
            if (marker.exists()) marker.delete();
            assertTrue(directory.delete());
        }
    }

    public void testInitialiseRejectsUnregisteredHelper() throws Exception {
        File directory = new File(System.getProperty("java.io.tmpdir"));
        InstanceMgr instance = instance(helper(), null, directory);
        try {
            instance.initialise();
            fail("Expected missing registry helper to fail initialization");
        } catch (InitialisationException expected) {
            assertTrue(expected.getMessage().contains("global helper"));
        }
    }

    public void testSpringPropertyNamesMatchBeanSetters() throws Exception {
        assertWritable(EAIDAGlobalHelper.class, "DBCallerEx");
        assertWritable(InstanceMgr.class, "globalHelper");
        assertWritable(InstanceMgr.class, "config");
        assertWritable(EAIDBCallerHelperEx.class, "dataSource");
        assertWritable(com.mchange.v2.c3p0.ComboPooledDataSource.class, "driverClass");
        assertWritable(com.mchange.v2.c3p0.ComboPooledDataSource.class, "jdbcUrl");
    }

    private static void assertWritable(Class<?> bean, String name) throws Exception {
        for (PropertyDescriptor property : Introspector.getBeanInfo(bean).getPropertyDescriptors()) {
            if (name.equals(property.getName()) && property.getWriteMethod() != null) return;
        }
        fail("Missing writable Spring bean property " + bean.getName() + "." + name);
    }

    private static EAIDAGlobalHelper helper() {
        EAIDAGlobalHelper helper = new EAIDAGlobalHelper();
        EAIDBCallerHelperEx caller = new EAIDBCallerHelperEx();
        caller.setDataSource(new DriverManagerDataSource());
        helper.setDBCallerEx(caller);
        return helper;
    }

    private static InstanceMgr instance(EAIDAGlobalHelper helper, final Object registered,
            File directory) {
        MuleRegistry registry = (MuleRegistry)Proxy.newProxyInstance(
                MuleRegistry.class.getClassLoader(), new Class<?>[] {MuleRegistry.class},
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) {
                        assertEquals("lookupObject", method.getName());
                        assertEquals("SRFDACONTEXTHELPER", args[0]);
                        return registered;
                    }
                });
        final MuleRegistry actualRegistry = registry;
        MuleContext context = (MuleContext)Proxy.newProxyInstance(
                MuleContext.class.getClassLoader(), new Class<?>[] {MuleContext.class},
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) {
                        assertEquals("getRegistry", method.getName());
                        return actualRegistry;
                    }
                });
        InstanceMgr instance = new InstanceMgr();
        instance.setMuleContext(context);
        instance.setGlobalHelper(helper);
        Map<String, String> config = new HashMap<String, String>();
        config.put("SERVICEID", "Sample");
        config.put("CONFIGPATH", directory.getAbsolutePath());
        instance.setConfig(config);
        return instance;
    }
}
