package SA.SRFramework.WebEx.DP.UI;

import junit.framework.TestCase;

public class DPFormItemConfigUtilityTest extends TestCase {
    public void testRegisteredCreatorsReturnNewInstancesOfTheirRegisteredClasses() {
        DPFormItemConfigUtility utility = new DPFormItemConfigUtility();
        assertEquals(24, utility.objectCreatorMap.size());
        for (String className : utility.objectCreatorMap.keySet()) {
            Object first = utility.CreateObject(className);
            Object second = utility.CreateObject(className);
            assertEquals(className, first.getClass().getName());
            assertEquals(className, second.getClass().getName());
            assertNotSame(first, second);
        }
    }

    public void testUnregisteredClassUsesReflectionFallback() {
        Object result = new DPFormItemConfigUtility().CreateObject("java.lang.StringBuilder");
        assertTrue(result instanceof StringBuilder);
    }
}
