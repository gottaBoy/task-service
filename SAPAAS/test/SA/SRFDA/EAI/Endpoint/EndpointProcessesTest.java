package SA.SRFDA.EAI.Endpoint;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.Data.MsgSendQueue;
import SA.SRFDA.Ctrl.Data.MsgTemplate;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import junit.framework.TestCase;
import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.MuleContext;
import org.mule.api.registry.MuleRegistry;
import org.mule.api.service.Service;

public class EndpointProcessesTest extends TestCase {
    private static final class Calls implements InvocationHandler {
        String name;
        Object[] args;
        CallResult result = new CallResult();
        int saves;

        public Object invoke(Object proxy, Method method, Object[] arguments) {
            name = method.getName();
            args = arguments;
            if ("Save".equals(name)) {
                saves++;
            }
            return result;
        }

        IDEDataCtrl controller() {
            return (IDEDataCtrl) Proxy.newProxyInstance(IDEDataCtrl.class.getClassLoader(),
                    new Class<?>[] {IDEDataCtrl.class}, this);
        }
    }

    public void testControllerActionsAndErrors() throws Exception {
        Calls calls = new Calls();
        IDEDataCtrl ctrl = calls.controller();
        BaseDataEntity entity = new BaseDataEntity();
        DEDataCtrlEndpoint.execute(ctrl, "insert", null, entity);
        assertEquals("Save", calls.name);
        assertEquals(Boolean.TRUE, calls.args[0]);
        assertSame(entity, calls.args[1]);
        DEDataCtrlEndpoint.execute(ctrl, "UPDATE", "FAST", entity);
        assertEquals("Save", calls.name);
        assertEquals(Boolean.FALSE, calls.args[0]);
        assertEquals("FAST", calls.args[1]);
        DEDataCtrlEndpoint.execute(ctrl, "DELETE", null, entity);
        assertEquals("Remove", calls.name);
        DEDataCtrlEndpoint.execute(ctrl, "CUSTOM", "RETRY", entity);
        assertEquals("CustomCall", calls.name);
        DEDataCtrlEndpoint.execute(ctrl, "PROC", "RUN", entity);
        assertEquals("CustomProcCall", calls.name);
        calls.result.setRetCode(17);
        calls.result.setErrorInfo("rejected");
        try {
            DEDataCtrlEndpoint.execute(ctrl, "INSERT", "", entity);
            fail("Expected the controller error");
        } catch (Exception expected) {
            assertTrue(expected.getMessage().contains("17: rejected"));
        }
        assertEquals("TestSave", calls.name);
        assertEquals(2, calls.saves);
        try {
            DEDataCtrlEndpoint.execute(ctrl, "CUSTOM", "", entity);
            fail("Missing action mode");
        } catch (IllegalArgumentException expected) {
            assertTrue(expected.getMessage().contains("ACTIONMODE"));
        }
    }

    public void testPreparationCloneAndMap() throws Exception {
        BaseDataEntity original = new BaseDataEntity();
        original.SetParamValue("NAME", "before");
        DEPrepareProcess process = new DEPrepareProcess();
        assertSame(original, process.onCall(event(original, null)));
        process.setCloneDataEntity(true);
        BaseDataEntity copy = (BaseDataEntity) process.onCall(event(original, null));
        assertNotSame(original, copy);
        copy.SetParamValue("NAME", "after");
        assertEquals("before", original.GetParamStringValue("NAME", ""));
        process.setReturnPayloadAsMap(true);
        assertEquals("before", ((Map) process.onCall(event(original, null))).get("NAME"));
    }

    public void testMergeUpdatesAndRejectBadInput() throws Exception {
        Map<String, Object> input = new HashMap<String, Object>();
        input.put("ONE", 1);
        Map<String, Object> updates = new HashMap<String, Object>();
        updates.put("TWO", 2);
        DataEntityUpdateProcess process = new DataEntityUpdateProcess();
        assertSame(input, process.onCall(event(input, props("UPDATES", updates))));
        assertEquals(1, input.get("ONE"));
        assertEquals(2, input.get("TWO"));
        try {
            process.onCall(event(input, null));
            fail("Expected missing updates to fail");
        } catch (IllegalArgumentException expected) {
            assertTrue(expected.getMessage().contains("UPDATES"));
        }
    }

    public void testSaveFileAndRejectTraversal() throws Exception {
        File directory = Files.createTempDirectory("eai-file-").toFile();
        try {
            byte[] bytes = new byte[] {1, 2, 3};
            Map<String, Object> properties = props("DIRECTORY", directory.getPath());
            properties.put("FILENAME", "report.bin");
            assertSame(bytes, new SimpleSaveFileProcess().onCall(event(bytes, properties)));
            assertTrue(java.util.Arrays.equals(bytes,
                    Files.readAllBytes(new File(directory, "report.bin").toPath())));
            properties.put("FILENAME", "../escape.bin");
            try {
                new SimpleSaveFileProcess().onCall(event(bytes, properties));
                fail("Expected invalid filename to fail");
            } catch (IllegalArgumentException expected) {
                assertTrue(expected.getMessage().contains("FILENAME"));
            }
        } finally {
            new File(directory, "report.bin").delete();
            directory.delete();
        }
    }

    public void testSimpleWsAndIdentityProcess() throws Exception {
        MuleEventContext event = event("hello", null);
        assertEquals("hello", new SimpleProcess().onCall(event));
        assertEquals("hello", new SimpleWSEndpoint().onCall(event));
        assertEquals("hello", new SimpleWSEndpoint().Call("hello"));
    }

    public void testInvokeSendsOriginalMessageToConfiguredTarget() throws Exception {
        final MuleEventContext original = event("request", props("PROCESS", "vm://next"));
        MuleEventContext forwarding = (MuleEventContext) Proxy.newProxyInstance(
                MuleEventContext.class.getClassLoader(), new Class<?>[] {MuleEventContext.class},
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) {
                        if ("getService".equals(method.getName())) {
                            return null;
                        }
                        if ("getMessage".equals(method.getName())) {
                            return original.getMessage();
                        }
                        if ("sendEvent".equals(method.getName())) {
                            assertSame(original.getMessage(), args[0]);
                            assertEquals("vm://next", args[1]);
                            return message("response", null);
                        }
                        throw new AssertionError(method);
                    }
                });
        assertEquals("response", new ProcessInvokeEndPoint().onCall(forwarding));
    }

    public void testFtpAndMessageRequireValidInputs() throws Exception {
        try {
            new FtpPutProcess().onCall(event(new HashMap<String, Object>(), null));
            fail("Expected missing FTP settings");
        } catch (IllegalArgumentException expected) {
            assertTrue(expected.getMessage().contains("FTP connection"));
        }
        try {
            new SendMsgProcess().onCall(event(new HashMap<String, Object>(), null));
            fail("Expected missing message type");
        } catch (IllegalArgumentException expected) {
            assertTrue(expected.getMessage().contains("MSGTYPE"));
        }
    }

    public void testConfigUsesGeneratedServiceBeanBeforeMessageProperty() {
        ProcessConfig config = new ProcessConfig();
        Map<String, String> entries = new HashMap<String, String>();
        entries.put("ACTION", "DELETE");
        config.setConfig(entries);
        MuleEventContext event = registeredEvent("body", props("ACTION", "INSERT"), config);
        assertEquals("DELETE", EndpointRuntime.setting(event, "ACTION"));
        assertEquals("INSERT", EndpointRuntime.setting(event("body", props("ACTION", "INSERT")),
                "ACTION"));
    }

    public void testConfiguredProcessSavesAndReturnsUpdatedMap() throws Exception {
        ProcessConfig config = new ProcessConfig();
        Map<String, String> entries = new HashMap<String, String>();
        entries.put("ACTION", "INSERT");
        config.setConfig(entries);
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("NAME", "before");
        Calls calls = new Calls();
        DEDataCtrlProcess process = new DEDataCtrlProcess();
        process.setDEDataCtrl(calls.controller());
        process.setReturnPayloadAsMap(true);
        assertSame(payload, process.onCall(registeredEvent(payload, props("ACTION", "DELETE"), config)));
        assertEquals("Save", calls.name);
        assertEquals(Boolean.TRUE, calls.args[0]);
        assertEquals("before", payload.get("NAME"));
    }

    public void testMessageTemplateQueuesRenderedContentAndRecipients() throws Exception {
        MsgTemplate template = new MsgTemplate();
        template.setSUBJECT("Notice");
        template.setCONTENT("Ready");
        Calls calls = new Calls();
        SendMsgProcess process = new SendMsgProcess();
        process.setMsgTemplate(template);
        process.setMsgSendQueueDataCtrl(calls.controller());
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("DSTADDRESSES", "user@example.com");
        data.put("FILEAT", "attachment.txt");
        Map<String, Object> properties = props("MSGTYPE", "2");
        ISRFDAGlobalHelper helper = (ISRFDAGlobalHelper) Proxy.newProxyInstance(
                ISRFDAGlobalHelper.class.getClassLoader(), new Class<?>[] {ISRFDAGlobalHelper.class},
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) {
                        throw new AssertionError(method);
                    }
                });
        assertTrue(process.onCall(registeredEvent(data, properties, helper)) instanceof BaseDataEntity);
        assertEquals("Save", calls.name);
        assertEquals(Boolean.TRUE, calls.args[0]);
        MsgSendQueue queued = (MsgSendQueue) calls.args[1];
        assertEquals(2, queued.getMSGTYPE());
        assertEquals("Notice", queued.getSUBJECT());
        assertEquals("Ready", queued.getCONTENT());
        assertEquals("user@example.com", queued.getDSTADDRESSES());
        assertEquals("attachment.txt", queued.getFILEAT());
    }

    private static MuleEventContext registeredEvent(Object payload, Map<String, Object> properties,
            final Object registration) {
        final MuleEventContext base = event(payload, properties);
        final MuleRegistry registry = (MuleRegistry) Proxy.newProxyInstance(
                MuleRegistry.class.getClassLoader(), new Class<?>[] {MuleRegistry.class},
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) {
                        assertEquals("lookupObject", method.getName());
                        assertTrue("cfg_task".equals(args[0]) || "SRFDACONTEXTHELPER".equals(args[0]));
                        return registration;
                    }
                });
        final MuleContext context = (MuleContext) Proxy.newProxyInstance(
                MuleContext.class.getClassLoader(), new Class<?>[] {MuleContext.class},
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) {
                        assertEquals("getRegistry", method.getName());
                        return registry;
                    }
                });
        final Service service = (Service) Proxy.newProxyInstance(
                Service.class.getClassLoader(), new Class<?>[] {Service.class},
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) {
                        assertEquals("getName", method.getName());
                        return "task";
                    }
                });
        return (MuleEventContext) Proxy.newProxyInstance(
                MuleEventContext.class.getClassLoader(), new Class<?>[] {MuleEventContext.class},
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) {
                        if ("getMessage".equals(method.getName())) {
                            return base.getMessage();
                        }
                        if ("getMuleContext".equals(method.getName())) {
                            return context;
                        }
                        if ("getService".equals(method.getName())) {
                            return service;
                        }
                        throw new AssertionError(method);
                    }
                });
    }

    private static Map<String, Object> props(String key, Object value) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(key, value);
        return result;
    }

    private static MuleEventContext event(Object payload, Map<String, Object> properties) {
        final MuleMessage message = message(payload, properties);
        return (MuleEventContext) Proxy.newProxyInstance(MuleEventContext.class.getClassLoader(),
                new Class<?>[] {MuleEventContext.class}, new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) {
                        if ("getMessage".equals(method.getName())) {
                            return message;
                        }
                        if ("getService".equals(method.getName())) {
                            return null;
                        }
                        throw new AssertionError(method);
                    }
                });
    }

    private static MuleMessage message(final Object payload, final Map<String, Object> properties) {
        return (MuleMessage) Proxy.newProxyInstance(MuleMessage.class.getClassLoader(),
                new Class<?>[] {MuleMessage.class}, new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) {
                        if ("getPayload".equals(method.getName())) {
                            return payload;
                        }
                        if ("getProperty".equals(method.getName())) {
                            return properties == null ? null : properties.get(args[0]);
                        }
                        if ("getExceptionPayload".equals(method.getName())) {
                            return null;
                        }
                        throw new AssertionError(method);
                    }
                });
    }
}
