package SA.SRFDA.EAI.Ctrl;

import SA.SRFDA.Ctrl.Data.Registry;
import SA.SRFDA.Ctrl.IDAModelHelper;
import SA.SRFDA.EAI.Ctrl.Data.EAIService;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.xml.parsers.DocumentBuilderFactory;
import junit.framework.TestCase;
import org.mule.api.MuleContext;
import org.mule.api.registry.MuleRegistry;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ServiceMgrLifecycleTest extends TestCase {
    private static final String SERVICE_MODEL =
            "<SRFEXEAISERVICE><SRFEXEAIPROCESSES/></SRFEXEAISERVICE>";
    private static final String SPRING = "http://www.springframework.org/schema/beans";

    private static class State implements InvocationHandler {
        boolean started;
        boolean disposed;
        boolean failStart;
        boolean failStop;
        boolean failDispose;
        boolean failMarkStopped;
        boolean autoStart;
        int starting;
        int stopped;
        int reset;
        int dataSourceRegistries;
        int instanceRegistries;
        int processQueries;
        String file;
        ServiceMgr manager;

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            String name = method.getName();
            if ("MarkServiceStarting".equals(name)) {
                starting++;
            } else if ("MarkServiceStop".equals(name)) {
                stopped++;
                if (failMarkStopped) {
                    CallResult failure = new CallResult();
                    failure.setRetCode(1);
                    failure.setErrorInfo("status failed");
                    return failure;
                }
            } else if ("MarkAllServiceStop".equals(name)) {
                reset++;
            } else if ("GetAutoStartServices".equals(name)) {
                if (autoStart) {
                    EAIService service = new EAIService();
                    service.setEAISERVICEID("Auto");
                    service.setEAISERVICENAME("Auto");
                    service.setSVRMODEL(SERVICE_MODEL);
                    ((Vector<EAIService>) args[0]).add(service);
                }
                return new CallResult();
            } else if ("GetService".equals(name)) {
                ((EAIService) args[1]).setEAISERVICEID((String) args[0]);
                ((EAIService) args[1]).setEAISERVICENAME((String) args[0]);
                ((EAIService) args[1]).setSVRMODEL(SERVICE_MODEL);
                return new CallResult();
            } else if ("GetServiceProcesses".equals(name)) {
                processQueries++;
                return new CallResult();
            } else if ("getDAModelHelper".equals(name)) {
                return Proxy.newProxyInstance(getClass().getClassLoader(),
                        new Class<?>[] {IDAModelHelper.class}, this);
            } else if ("GetRegistry".equals(name)) {
                assertEquals("EAI", args[0]);
                Registry registry = (Registry) args[2];
                if ("SRFDADATASOURCE".equals(args[1])) {
                    dataSourceRegistries++;
                    registry.GetParams().setProperty("DRIVERNAME", "org.example.Driver");
                    registry.GetParams().setProperty("URL", "jdbc:example://localhost/db");
                    registry.GetParams().setProperty("USER", "db-user");
                    registry.GetParams().setProperty("PASSWORD", "a&b");
                } else if ("EAIINSTANCE".equals(args[1])) {
                    instanceRegistries++;
                    registry.GetParams().setProperty("APPMODE", "development");
                } else {
                    throw new AssertionError("Unexpected registry " + args[1]);
                }
                return new CallResult();
            } else if ("lookupObject".equals(name)) {
                if ("EAISERVICEMGR".equals(args[0])) {
                    return manager;
                }
                if ("SRFDACONTEXTHELPER".equals(args[0])) {
                    return Proxy.newProxyInstance(getClass().getClassLoader(),
                            new Class<?>[] {ISRFDAGlobalHelper.class}, this);
                }
                return null;
            } else if ("getRegistry".equals(name)) {
                return proxyRegistry();
            } else if ("start".equals(name)) {
                if (failStart) {
                    throw new org.mule.api.DefaultMuleException("start failed");
                }
                started = true;
            } else if ("stop".equals(name)) {
                if (failStop) {
                    throw new org.mule.api.DefaultMuleException("stop failed");
                }
                started = false;
            } else if ("dispose".equals(name)) {
                if (failDispose) {
                    throw new IllegalStateException("dispose failed");
                }
                disposed = true;
            } else if ("isStarted".equals(name)) {
                return started;
            }
            if (method.getReturnType() == CallResult.class) {
                return new CallResult();
            }
            return null;
        }

        private MuleRegistry proxyRegistry() {
            return (MuleRegistry) Proxy.newProxyInstance(getClass().getClassLoader(),
                    new Class<?>[] {MuleRegistry.class}, this);
        }

        MuleContext proxyContext() {
            return (MuleContext) Proxy.newProxyInstance(getClass().getClassLoader(),
                    new Class<?>[] {MuleContext.class}, this);
        }

        ISRFEAIDataCtrl proxyCtrl() {
            return (ISRFEAIDataCtrl) Proxy.newProxyInstance(getClass().getClassLoader(),
                    new Class<?>[] {ISRFEAIDataCtrl.class}, this);
        }
    }

    private static class Manager extends ServiceMgr {
        private final State state;

        Manager(State state, File directory) {
            this.state = state;
            this.strConfigPath = directory.getPath();
            this.eaiDataCtrl = state.proxyCtrl();
        }

        @Override
        protected MuleContext createServiceContext(String path) {
            state.file = path;
            return state.proxyContext();
        }
    }

    public void testStartStopAndFailureRollback() throws Exception {
        State state = new State();
        File directory = Files.createTempDirectory("eai-service-mgr-").toFile();
        try {
            Manager manager = new Manager(state, directory);
            assertEquals(0, manager.StartServiceProcess("Example").getRetCode());
            assertEquals(new File(directory, "example.xml").getPath(), state.file);
            assertTrue(manager.IsServiceStart("Example"));
            assertEquals(5, manager.StartServiceProcess("eXAMPLE").getRetCode());
            assertEquals(0, manager.StopService("example").getRetCode());
            assertFalse(manager.IsServiceStart("Example"));
            assertTrue(state.disposed);
            assertEquals(1, state.starting);
            assertEquals(1, state.stopped);

            State failing = new State();
            failing.failStart = true;
            Manager failedManager = new Manager(failing, directory);
            assertTrue(failedManager.StartServiceProcess("Broken").IsError());
            assertEquals(1, failing.starting);
            assertEquals(1, failing.stopped);
            assertTrue(failing.disposed);
            assertFalse(failedManager.IsServiceStart("Broken"));
        } finally {
            assertTrue(directory.delete());
        }
    }

    public void testAutoStartAndProxyLifecycle() throws Exception {
        State state = new State();
        state.autoStart = true;
        File directory = Files.createTempDirectory("eai-service-mgr-").toFile();
        try {
            Manager manager = new Manager(state, directory);
            state.manager = manager;
            manager.setMuleContext(state.proxyContext());
            Map<String, String> config = new HashMap<String, String>();
            config.put("CONFIGPATH", directory.getPath());
            manager.setConfig(config);
            manager.initialise();
            manager.start();
            assertEquals(1, state.reset);
            assertTrue(manager.IsServiceStart("auto"));
            assertEquals(1, ((Vector<?>) manager.GetStartupServices().getUserObject()).size());
            assertServiceConfig(new File(directory, "auto.xml"), "Auto");

            Server server = new Server();
            server.setMuleContext(state.proxyContext());
            assertEquals(0, server.StartService("Alpha").getRetCode());
            assertTrue(manager.IsServiceStart("Alpha"));
            assertServiceConfig(new File(directory, "alpha.xml"), "Alpha");
            assertEquals(2, state.dataSourceRegistries);
            assertEquals(2, state.instanceRegistries);
            assertEquals(2, state.processQueries);
            ServerEx serverEx = new ServerEx();
            serverEx.setMuleContext(state.proxyContext());
            serverEx.initialise();
            assertEquals(0, serverEx.StopService("Alpha").getRetCode());
            assertFalse(manager.IsServiceStart("Alpha"));
            manager.stop();
            assertFalse(manager.IsServiceStart("Auto"));
            manager.dispose();

            Server missing = new Server();
            assertTrue(missing.StartService("Alpha").IsError());
            try {
                new ServerEx().initialise();
                fail("missing manager must fail initialization");
            } catch (org.mule.api.lifecycle.InitialisationException expected) {
                // Expected.
            }
        } finally {
            assertTrue(new File(directory, "auto.xml").delete());
            assertTrue(new File(directory, "alpha.xml").delete());
            assertTrue(directory.delete());
        }
    }

    private static void assertServiceConfig(File file, String serviceId) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        Document document = factory.newDocumentBuilder().parse(file);
        assertEquals("mule", document.getDocumentElement().getLocalName());
        NodeList beans = document.getElementsByTagNameNS(SPRING, "bean");
        assertEquals(4, beans.getLength());
        boolean hasDataSource = false;
        boolean hasInstance = false;
        for (int i = 0; i < beans.getLength(); i++) {
            Element bean = (Element) beans.item(i);
            if ("SRFDADATASOURCE".equals(bean.getAttribute("id"))) {
                hasDataSource = true;
                assertEquals("com.mchange.v2.c3p0.ComboPooledDataSource",
                        bean.getAttribute("class"));
            } else if ("EAISERVICE".equals(bean.getAttribute("id"))) {
                hasInstance = true;
                NodeList entries = bean.getElementsByTagNameNS(SPRING, "entry");
                boolean hasServiceId = false;
                for (int j = 0; j < entries.getLength(); j++) {
                    Element entry = (Element) entries.item(j);
                    if ("SERVICEID".equals(entry.getAttribute("key"))) {
                        assertEquals(serviceId, entry.getAttribute("value"));
                        hasServiceId = true;
                    }
                }
                assertTrue(hasServiceId);
            }
        }
        assertTrue(hasDataSource);
        assertTrue(hasInstance);
        assertEquals(1, document.getElementsByTagName("model").getLength());
    }

    public void testStopFailureStillDisposesAndUpdatesStatus() throws Exception {
        State state = new State();
        Manager manager = new Manager(state, Files.createTempDirectory("eai-service-mgr-").toFile());
        try {
            assertEquals(0, manager.StartServiceProcess("BrokenStop").getRetCode());
            state.failStop = true;
            assertTrue(manager.StopService("BrokenStop").IsError());
            assertTrue(state.disposed);
            assertFalse(manager.IsServiceStart("BrokenStop"));
            assertEquals(1, state.stopped);
        } finally {
            assertTrue(new File(manager.strConfigPath).delete());
        }
    }

    public void testFailedDisposeCanBeRetried() throws Exception {
        State state = new State();
        Manager manager = new Manager(state, Files.createTempDirectory("eai-service-mgr-").toFile());
        try {
            assertEquals(0, manager.StartServiceProcess("Retry").getRetCode());
            state.failDispose = true;
            assertTrue(manager.StopService("Retry").IsError());
            assertFalse(manager.IsServiceStart("Retry"));
            assertEquals(5, manager.StartServiceProcess("Retry").getRetCode());
            assertEquals(0, state.stopped);
            state.failDispose = false;
            assertEquals(0, manager.StopService("Retry").getRetCode());
            assertEquals(1, state.stopped);
        } finally {
            assertTrue(new File(manager.strConfigPath).delete());
        }
    }

    public void testFailedStartReportsCleanupStatusFailure() throws Exception {
        State state = new State();
        state.failStart = true;
        state.failDispose = true;
        state.failMarkStopped = true;
        Manager manager = new Manager(state, Files.createTempDirectory("eai-service-mgr-").toFile());
        try {
            CallResult result = manager.StartServiceProcess("Failed");
            assertTrue(result.IsError());
            assertTrue(result.getErrorInfo().contains("start failed"));
            assertTrue(result.getErrorInfo().contains("status failed"));
            assertEquals(1, state.stopped);
            assertFalse(manager.IsServiceStart("Failed"));
        } finally {
            assertTrue(new File(manager.strConfigPath).delete());
        }
    }
}
