package net.ibizsys.pscore.srv.util.gitlab.util;

import junit.framework.TestCase;

public class JacksonJsonEnumHelperTest extends TestCase {
    private enum Value {
        FIRST_ITEM,
        SECOND_ITEM
    }

    public void testDefaultAndWordSeparatedNames() {
        JacksonJsonEnumHelper<Value> defaults =
                new JacksonJsonEnumHelper<Value>(Value.class);
        assertSame(Value.FIRST_ITEM, defaults.forValue("first_item"));
        assertEquals("first_item", defaults.toString(Value.FIRST_ITEM));

        JacksonJsonEnumHelper<Value> separated =
                new JacksonJsonEnumHelper<Value>(Value.class, false, false);
        assertSame(Value.SECOND_ITEM, separated.forValue("second item"));
        assertEquals("second item", separated.toString(Value.SECOND_ITEM));
    }

    public void testCamelCaseAndCustomAlias() {
        JacksonJsonEnumHelper<Value> camelCase =
                new JacksonJsonEnumHelper<Value>(Value.class, false, true);
        assertSame(Value.FIRST_ITEM, camelCase.forValue("firstItem"));
        assertEquals("firstItem", camelCase.toString(Value.FIRST_ITEM));

        JacksonJsonEnumHelper<Value> pascalCase =
                new JacksonJsonEnumHelper<Value>(Value.class, true, true);
        assertSame(Value.SECOND_ITEM, pascalCase.forValue("SecondItem"));
        pascalCase.addEnum(Value.SECOND_ITEM, "replacement");
        assertSame(Value.SECOND_ITEM, pascalCase.forValue("replacement"));
        assertEquals("replacement", pascalCase.toString(Value.SECOND_ITEM));
    }
}
