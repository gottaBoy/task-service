package SA.SRFDA.EAI.Ctrl.Router;

import SA.SRFDA.EAI.Model.EAIConnectionConfig;
import SA.SRFDA.EAI.Model.EAIDecideProcessConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import junit.framework.TestCase;
import org.mule.api.MessagingException;
import org.mule.api.MuleException;
import org.mule.api.MuleMessage;
import org.mule.api.MuleSession;
import org.mule.api.endpoint.OutboundEndpoint;
import org.mule.transport.NullPayload;

public class DecideOutboundRouterTest extends TestCase {
    private final MuleSession session = proxy(MuleSession.class, null);

    public void testFirstMatchingRulePrecedesDefaultAndSendsSynchronousResponse() throws Exception {
        Router router = router();
        EAIConnectionConfig fallback = connection("fallback", true, "AND");
        EAIConnectionConfig first = connection("first", false, "AND");
        rule(first, 0, EAIConnectionConfig.OP_GT, "10", false);
        rule(first, 1, EAIConnectionConfig.OP_LTANDEQ, "20", false);
        EAIConnectionConfig second = connection("second", false, "AND");
        rule(second, 0, EAIConnectionConfig.OP_GTANDEQ, "10", false);
        router.config.getConnectionsConfig().add(fallback);
        router.config.getConnectionsConfig().add(first);
        router.config.getConnectionsConfig().add(second);
        router.addEndpoint(endpoint("fallback", true));
        router.addEndpoint(endpoint("first", true));
        router.addEndpoint(endpoint("second", true));
        MuleMessage message = message(data("VALUE", 15));
        assertTrue(router.isMatch(message));
        assertSame(message, router.route(message, session));
        assertEquals("send:first", router.operation);
        assertEquals("first", router.selected);
    }

    public void testOrWithReferencedOperandAndAsyncDispatch() throws Exception {
        Router router = router();
        EAIConnectionConfig rule = connection("reference", false, "OR");
        rule(rule, 0, EAIConnectionConfig.OP_EQ, "0", false);
        rule(rule, 2, EAIConnectionConfig.OP_GT, "##LIMIT", true);
        router.config.getConnectionsConfig().add(rule);
        router.addEndpoint(endpoint("reference", false));
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("VALUE", 11);
        payload.put("LIMIT", 10);
        assertNull(router.route(message(payload), session));
        assertEquals("dispatch:reference", router.operation);
    }

    public void testNullChecksAndDefaultOnlyAfterAllRulesFail() throws Exception {
        Router router = router();
        EAIConnectionConfig present = connection("present", false, "AND");
        rule(present, 0, EAIConnectionConfig.OP_ISNOTNULL, null, false);
        EAIConnectionConfig absent = connection("absent", false, "AND");
        rule(absent, 0, EAIConnectionConfig.OP_ISNULL, null, false);
        EAIConnectionConfig fallback = connection("fallback", true, "AND");
        router.config.getConnectionsConfig().add(present);
        router.config.getConnectionsConfig().add(absent);
        router.config.getConnectionsConfig().add(fallback);
        router.addEndpoint(endpoint("present", true));
        router.addEndpoint(endpoint("absent", true));
        router.addEndpoint(endpoint("fallback", true));
        router.route(message(NullPayload.getInstance()), session);
        assertEquals("absent", router.selected);
        router.route(message(data("VALUE", "hello")), session);
        assertEquals("present", router.selected);

        Router noRule = router();
        noRule.config.getConnectionsConfig().add(connection("empty", false, "AND"));
        noRule.config.getConnectionsConfig().add(fallback);
        noRule.addEndpoint(endpoint("fallback", true));
        noRule.route(message(data("VALUE", 4)), session);
        assertEquals("fallback", noRule.selected);
    }

    public void testStringAndNumericOperatorsAndFunctionValues() throws Exception {
        MuleMessage text = message(data("VALUE", "beta"));
        assertTrue(DecideOutboundRouter.CheckStringValueRule(text, EAIConnectionConfig.OP_GT, "beta", "alpha"));
        assertTrue(DecideOutboundRouter.CheckStringValueRule(text, EAIConnectionConfig.OP_NOTEQ, "beta", "alpha"));
        assertFalse(DecideOutboundRouter.CheckStringValueRule(text, EAIConnectionConfig.OP_LT, "beta", "alpha"));
        assertTrue(DecideOutboundRouter.CheckNumberValueRule(text, 9, EAIConnectionConfig.OP_EQ, 8, 8));
        assertTrue(DecideOutboundRouter.CheckNumberValueRule(text, 7, EAIConnectionConfig.OP_LT, 2.5, 3.5));
        assertEquals("beta", DecideOutboundRouter.GetParamValue(text, 25, "##VALUE", true));
        assertEquals("literal", DecideOutboundRouter.GetParamValue(text, 25, "literal", false));
        assertNotNull(DecideOutboundRouter.GetParamValue(text, 27, "@@DATE", true));
        assertNotNull(DecideOutboundRouter.GetParamValue(text, 28, "@@TIME", true));
        assertNotNull(DecideOutboundRouter.GetParamValue(text, 5, "@@DATETIME", true));
    }

    public void testMissingConfigOrEndpointAndInvalidOperandFailClosed() throws Exception {
        Router noConfig = new Router();
        noConfig.setProcessId("decision");
        try {
            noConfig.route(message(data("VALUE", "hello")), session);
            fail("Missing configuration should fail");
        } catch (MessagingException expected) {
            assertTrue(expected.getMessage().contains("not configured"));
        }
        Router router = router();
        EAIConnectionConfig match = connection("missing", false, "AND");
        rule(match, 0, EAIConnectionConfig.OP_EQ, "hello", false);
        router.config.getConnectionsConfig().add(match);
        try {
            router.route(message(data("VALUE", "hello")), session);
            fail("Missing endpoint should fail");
        } catch (MessagingException expected) {
            assertTrue(expected.getMessage().contains("endpoint not found"));
        }
        try {
            DecideOutboundRouter.GetParamValue(message(data("VALUE", 1)), 9, "", false);
            fail("Invalid number should fail");
        } catch (MessagingException expected) {
            assertTrue(expected.getMessage().contains("Invalid decision operand"));
        }
        try {
            DecideOutboundRouter.GetParamValue(message(data("VALUE", 1)), 9, "WRONG", true);
            fail("Unknown function should fail");
        } catch (MessagingException expected) {
            assertTrue(expected.getMessage().contains("Unknown decision operand function"));
        }
    }

    public void testUnsupportedPayloadAndUnknownOperatorFailClosed() throws Exception {
        Router router = router();
        EAIConnectionConfig match = connection("match", false, "AND");
        rule(match, 0, 99, "hello", false);
        router.config.getConnectionsConfig().add(match);
        try {
            router.route(message("hello"), session);
            fail("Unsupported payload should fail");
        } catch (MessagingException expected) {
            assertTrue(expected.getMessage().contains("Unsupported decision payload"));
        }
        try {
            router.route(message(data("VALUE", "hello")), session);
            fail("Unknown operator should fail");
        } catch (MessagingException expected) {
            assertTrue(expected.getMessage().contains("Unknown decision operator"));
        }
    }

    public void testMapAndEntityValues() {
        Map<String, Object> map = data("VALUE", "yes");
        assertSame(map, DecideOutboundRouter.GetMap(map));
        BaseDataEntity entity = new BaseDataEntity();
        entity.SetParamValue("VALUE", "yes");
        assertEquals("yes", DecideOutboundRouter.GetMap(entity).get("VALUE"));
        assertTrue(DecideOutboundRouter.GetMap(NullPayload.getInstance()).isEmpty());
    }

    public void testXmlConfigurationAndTenthRule() throws Exception {
        SA.SRFDA.EAI.Model.EAIConfig model = new SA.SRFDA.EAI.Model.EAIConfig();
        assertTrue(model.LoadXML("<SRFEXEAISERVICE><SRFEXEAIPROCESSES>"
                + "<SRFEXEAIDECISION ID=\"decision\" PARAMID=\"VALUE\">"
                + "<SRFEXEAICONNECTIONS>"
                + "<SRFEXEAICONNECTION ID=\"tenth\" OP10=\"GT\" OPPARAM10=\"10\"/>"
                + "<SRFEXEAICONNECTION ID=\"fallback\" DEFAULTMODE=\"true\"/>"
                + "</SRFEXEAICONNECTIONS></SRFEXEAIDECISION>"
                + "</SRFEXEAIPROCESSES></SRFEXEAISERVICE>"));
        Router router = new Router();
        router.setProcessId("decision");
        router.config = (EAIDecideProcessConfig) model.getProcessesConfig().FindProcessConfig("decision");
        assertNotNull(router.config);
        router.addEndpoint(endpoint("tenth", true));
        router.addEndpoint(endpoint("fallback", true));
        router.route(message(data("VALUE", 11)), session);
        assertEquals("tenth", router.selected);
        router.route(message(data("VALUE", 9)), session);
        assertEquals("fallback", router.selected);
    }

    public void testMissingDefaultAndInvalidRuleFailClosed() throws Exception {
        Router router = router();
        EAIConnectionConfig rule = connection("no-match", false, "AND");
        rule(rule, 0, EAIConnectionConfig.OP_GT, "10", false);
        router.config.getConnectionsConfig().add(rule);
        router.addEndpoint(endpoint("no-match", true));
        try {
            router.route(message(data("VALUE", 9)), session);
            fail("Unmatched routes cannot disappear silently");
        } catch (MessagingException expected) {
            assertTrue(expected.getMessage().contains("No matching decision connection"));
        }
        rule.getOPList().put(0, 99);
        try {
            router.route(message(data("VALUE", null)), session);
            fail("Invalid operator must fail even for a null value");
        } catch (MessagingException expected) {
            assertTrue(expected.getMessage().contains("Unknown decision operator"));
        }
    }

    public void testInvalidComparisonAndModeFailClosed() throws Exception {
        Router router = router();
        EAIConnectionConfig rule = connection("reference", false, "AND");
        rule(rule, 0, EAIConnectionConfig.OP_GT, "##LIMIT", true);
        router.config.getConnectionsConfig().add(rule);
        Map<String, Object> payload = data("VALUE", 4);
        payload.put("LIMIT", "not-a-number");
        try {
            router.route(message(payload), session);
            fail("Invalid referenced number should be a messaging failure");
        } catch (MessagingException expected) {
            assertTrue(expected.getMessage().contains("Cannot compare decision values"));
        }
        rule.setOpMode("XOR");
        try {
            router.route(message(payload), session);
            fail("Unknown combination mode should fail");
        } catch (MessagingException expected) {
            assertTrue(expected.getMessage().contains("Invalid decision mode"));
        }
    }

    private static Router router() {
        Router router = new Router();
        router.setProcessId("decision");
        router.setParamId("VALUE");
        router.config = new EAIDecideProcessConfig();
        return router;
    }

    private static EAIConnectionConfig connection(String id, boolean fallback, String mode) {
        EAIConnectionConfig connection = new EAIConnectionConfig();
        connection.setID(id);
        connection.setDefaultMode(fallback);
        connection.setOpMode(mode);
        return connection;
    }

    private static void rule(EAIConnectionConfig connection, int index, int op, String operand, boolean function) {
        connection.getOPList().put(index, op);
        if (operand != null) {
            connection.getOPParamList().put(index, operand);
        }
        connection.getOpParamAsFuncList().put(index, function);
    }

    private static Map<String, Object> data(String key, Object value) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(key, value);
        return map;
    }

    private static MuleMessage message(final Object payload) {
        return proxy(MuleMessage.class, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) {
                if ("getPayload".equals(method.getName())) {
                    return payload;
                }
                throw new AssertionError("Unexpected message call: " + method);
            }
        });
    }

    private static OutboundEndpoint endpoint(final String name, final boolean synchronous) {
        return proxy(OutboundEndpoint.class, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) {
                if ("getName".equals(method.getName())) {
                    return name;
                }
                if ("isSynchronous".equals(method.getName())) {
                    return synchronous;
                }
                throw new AssertionError("Unexpected endpoint call: " + method);
            }
        });
    }

    private static <T> T proxy(Class<T> type, InvocationHandler handler) {
        if (handler == null) {
            handler = new InvocationHandler() {
                public Object invoke(Object proxy, Method method, Object[] args) {
                    throw new AssertionError("Unexpected Mule call: " + method);
                }
            };
        }
        return type.cast(Proxy.newProxyInstance(type.getClassLoader(), new Class<?>[] {type}, handler));
    }

    private static class Router extends DecideOutboundRouter {
        EAIDecideProcessConfig config;
        String selected;
        String operation;

        @Override
        public MuleMessage route(MuleMessage message, MuleSession session) throws MessagingException {
            decideProcessConfig = config;
            return super.route(message, session);
        }

        @Override
        public MuleMessage send(MuleSession session, MuleMessage message, OutboundEndpoint endpoint)
                throws MuleException {
            selected = endpoint.getName();
            operation = "send:" + selected;
            return message;
        }

        @Override
        public void dispatch(MuleSession session, MuleMessage message, OutboundEndpoint endpoint)
                throws MuleException {
            selected = endpoint.getName();
            operation = "dispatch:" + selected;
        }
    }
}
