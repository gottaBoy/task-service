package SA.SRFDA.EAI.Ctrl;

import junit.framework.TestCase;

public class EAIDAGlobalHelperTest extends TestCase {
    private static final String SERVICE_MANAGER_KEY = "{753F59D7-C01F-4b0a-A0C9-2EAD77744308}";

    public void testGlobalValuesAreStoredPerInstanceAndCanBeRemoved() {
        EAIDAGlobalHelper helper = new EAIDAGlobalHelper();
        EAIDAGlobalHelper other = new EAIDAGlobalHelper();
        Object service = new Object();

        helper.SetGlobalValue(SERVICE_MANAGER_KEY, service);
        assertSame(service, helper.GetGlobalValue(SERVICE_MANAGER_KEY));
        assertNull(other.GetGlobalValue(SERVICE_MANAGER_KEY));

        helper.SetGlobalValue(SERVICE_MANAGER_KEY, null);
        assertNull(helper.GetGlobalValue(SERVICE_MANAGER_KEY));
    }

    public void testAppModeReadsCurrentGlobalValue() {
        EAIDAGlobalHelper helper = new EAIDAGlobalHelper();
        assertEquals("", helper.getAppMode());

        helper.SetGlobalValue("SRFDAAPPMODE", "DEVELOPMENT");
        assertEquals("DEVELOPMENT", helper.getAppMode());

        helper.SetGlobalValue("SRFDAAPPMODE", null);
        assertEquals("", helper.getAppMode());
    }
}
