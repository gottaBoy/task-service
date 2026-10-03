package SA.SRFDA.EAI.Endpoint;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import junit.framework.TestCase;
import org.mule.api.MuleContext;
import org.mule.api.MuleEventContext;
import org.mule.api.registry.MuleRegistry;
import org.mule.transport.NullPayload;

public class BaseProcessEndpointTest extends TestCase {
    public void testGetDataEntityPreservesEntityAndConvertsMapAndNullPayload() throws Exception {
        BaseDataEntity original = new BaseDataEntity();
        original.SetParamValue("NAME", "original");
        assertSame(original, BaseProcessEndpoint.GetDataEntity(original));

        Map<String, Object> input = new HashMap<String, Object>();
        input.put("NAME", "from map");
        input.put("COUNT", 5);
        input.put("EMPTY", "");
        input.put("NULL", null);
        BaseDataEntity converted = BaseProcessEndpoint.GetDataEntity(input);
        assertEquals("from map", converted.GetParamStringValue("NAME", ""));
        assertEquals(5, converted.GetParamIntValue("COUNT", -1));
        assertTrue(converted.IsParamNull("EMPTY"));
        assertFalse(converted.ContainesParam("NULL"));
        assertEquals("from map", input.get("NAME"));

        BaseDataEntity empty = BaseProcessEndpoint.GetDataEntity(NullPayload.getInstance());
        assertNull(empty.GetParamValue("NAME"));
    }

    public void testGetDataEntityRejectsOtherPayloadsAndInvalidMaps() throws Exception {
        for (Object invalid : new Object[] {null, "unsupported"}) {
            try {
                BaseProcessEndpoint.GetDataEntity(invalid);
                fail("Expected unsupported payload to fail");
            } catch (Exception expected) {
                assertEquals("\u65e0\u6cd5\u8bc6\u522b\u7684\u5bf9\u8c61", expected.getMessage());
            }
        }
        Map<Object, Object> invalid = new HashMap<Object, Object>();
        invalid.put(null, "value");
        try {
            BaseProcessEndpoint.GetDataEntity(invalid);
            fail("Expected invalid map key to fail");
        } catch (NullPointerException expected) {
            // BaseDataEntity.FromMap requires non-null keys.
        }
    }

    public void testGetGlobalHelperUsesMuleRegistry() {
        ISRFDAGlobalHelper helper = proxy(ISRFDAGlobalHelper.class, "toString", "helper");
        assertSame(helper, BaseProcessEndpoint.GetGlobalHelper(event(helper)));
    }

    public void testGetGlobalHelperRejectsMissingAndInvalidRegistration() {
        for (Object value : new Object[] {null, "not a helper"}) {
            try {
                BaseProcessEndpoint.GetGlobalHelper(event(value));
                fail("Expected invalid registration to fail");
            } catch (IllegalStateException expected) {
                assertTrue(expected.getMessage().contains("SRFDACONTEXTHELPER"));
            }
        }
        try {
            BaseProcessEndpoint.GetGlobalHelper(null);
            fail("Expected missing context to fail");
        } catch (IllegalArgumentException expected) {
            assertTrue(expected.getMessage().contains("Mule context"));
        }
    }

    private static MuleEventContext event(Object helper) {
        MuleRegistry registry = proxy(MuleRegistry.class, "lookupObject", helper);
        MuleContext context = proxy(MuleContext.class, "getRegistry", registry);
        return proxy(MuleEventContext.class, "getMuleContext", context);
    }

    private static <T> T proxy(Class<T> type, final String name, final Object value) {
        return type.cast(Proxy.newProxyInstance(type.getClassLoader(),
                new Class<?>[] {type}, new InvocationHandler() {
                    public Object invoke(Object instance, Method method, Object[] args) {
                        if (name.equals(method.getName())) {
                            if ("lookupObject".equals(name)) {
                                assertEquals("SRFDACONTEXTHELPER", args[0]);
                            }
                            return value;
                        }
                        throw new AssertionError("Unexpected Mule call: " + method);
                    }
                }));
    }
}
