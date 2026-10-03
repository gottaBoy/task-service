package SA.SRFDA.Ctrl.ToolbarWriter;

import junit.framework.TestCase;

public class DefaultToolbarWriterContextTest extends TestCase {
    public void testRegisteredConditions() {
        DefaultToolbarWriterContext context = new DefaultToolbarWriterContext();
        context.RegisterGlobal("READ", true);
        context.RegisterGlobal("WRITE", false);
        assertTrue(context.TestCondition("READ"));
        assertFalse(context.TestCondition("WRITE"));
        assertTrue(context.TestCondition("READ && !WRITE"));
        assertFalse(context.TestCondition("READ && WRITE"));
    }
}
