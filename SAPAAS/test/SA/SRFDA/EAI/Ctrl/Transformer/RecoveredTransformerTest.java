package SA.SRFDA.EAI.Ctrl.Transformer;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import junit.framework.TestCase;
import org.mule.api.transformer.TransformerException;

public class RecoveredTransformerTest extends TestCase {
    public void testObjectStreamInteroperatesWithEntitySerialization() throws Exception {
        BaseDataEntity original = new BaseDataEntity();
        original.SetParamValue("NAME", "alpha");
        original.SetParamValue("COUNT", Integer.valueOf(3));
        original.SetParamValue("EMPTY", null);
        ObjectStream2DataEntity decoder = new ObjectStream2DataEntity();
        BaseDataEntity fromExisting = (BaseDataEntity)decoder.doTransform(
                BaseDataEntity.ToString(original, true), "UTF-8");
        assertEquals("alpha", fromExisting.GetParamValue("NAME"));
        assertTrue(fromExisting.IsParamNull("EMPTY"));

        String encoded = (String)new DataEntity2ObjectStream().doTransform(original, null);
        BaseDataEntity decoded = (BaseDataEntity)decoder.doTransform(
                new ByteArrayInputStream(encoded.getBytes("UTF-8")), "UTF-8");
        assertEquals(Integer.valueOf(3), decoded.GetParamValue("COUNT"));
        assertEquals("", decoded.GetParamValue("EMPTY"));
        assertEquals("alpha", BaseDataEntity.FromString(encoded).GetParamValue("NAME"));
        try {
            decoder.doTransform("not serialized", null);
            fail("Invalid stream must fail");
        } catch (TransformerException expected) {
            assertNotNull(expected.getCause());
        }
    }

    public void testArrayAndUpdateUseConfiguredFields() throws Exception {
        BaseDataEntity entity = new BaseDataEntity();
        entity.SetParamValue("CODE", "A");
        entity.SetParamValue("COUNT", 2);
        DataEntity2Array array = new DataEntity2Array();
        Map<String, String> config = new HashMap<String, String>();
        config.put(DataEntity2Array.TAG_ARRAYSIZE, "3");
        config.put("ITEM1", "COUNT");
        config.put("ITEM2", "CODE");
        config.put("ITEM3", "MISSING");
        array.setConfig(config);
        assertTrue(Arrays.equals(new Object[] {2, "A", null},
                (Object[])array.doTransform(entity, null)));
        config.remove("ITEM3");
        try {
            array.doTransform(entity, null);
            fail("Missing mapping must fail");
        } catch (TransformerException expected) {
            assertTrue(expected.getMessage().contains("ITEM3"));
        }

        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("COUNT", 1);
        payload.put("KEEP", "ok");
        payload.put("UPDATE", entity);
        Map updated = (Map)new DataEntityUpdater().doTransform(payload, null);
        assertSame(payload, updated);
        assertEquals(2, updated.get("COUNT"));
        assertEquals("ok", updated.get("KEEP"));
        assertEquals("A", updated.get("CODE"));
    }

    public void testFixedWidthRoundTripAndMalformedInput() throws Exception {
        Map<String, String> config = new HashMap<String, String>();
        config.put(StringTransformer.TAG_HEADERFORMAT, "KIND:3:STRING");
        config.put(StringTransformer.TAG_CONTENTFORMAT, "COUNT:3:INTEGER,NAME:5:STRING");
        config.put(StringTransformer.TAG_SEPERATOR, "|");
        BaseDataEntity entity = new BaseDataEntity();
        entity.SetParamValue("KIND", "ABC");
        entity.SetParamValue("COUNT", 12);
        entity.SetParamValue("NAME", "Bob");
        DataEntity2StringTransformer writer = new DataEntity2StringTransformer();
        writer.setConfig(config);
        String text = (String)writer.doTransform(entity, null);
        assertEquals("ABC|12 Bob  ", text);
        String2DataEntityTransformer reader = new String2DataEntityTransformer();
        reader.setConfig(config);
        BaseDataEntity result = (BaseDataEntity)reader.doTransform(text, null);
        assertEquals(12, result.GetParamIntValue("COUNT", -1));
        assertEquals("ABC", result.GetParamValue("KIND"));
        assertEquals("Bob", result.GetParamValue("NAME"));
        try {
            reader.doTransform("ABC|12", null);
            fail("Truncated packet must fail");
        } catch (TransformerException expected) {
            assertNotNull(expected.getCause());
        }
        try {
            new DataEntity2StringTransformer().doTransform(entity, null);
            fail("Unconfigured format must fail");
        } catch (TransformerException expected) {
            assertNotNull(expected.getCause());
        }
        try {
            writer.doTransform(entityWith("NAME", "longer"), null);
            fail("Oversized field must fail");
        } catch (TransformerException expected) {
            assertNotNull(expected.getCause());
        }
    }

    public void testXMLFieldsAndRejectExternalEntities() throws Exception {
        XML2DataEntityTransformer transformer = new XML2DataEntityTransformer();
        Map<String, String> config = new HashMap<String, String>();
        config.put(StringTransformer.TAG_CONTENTFORMAT, "COUNT:2:INTEGER,NAME:8:STRING");
        transformer.setConfig(config);
        BaseDataEntity result = (BaseDataEntity)transformer.doTransform(
                "<record><COUNT>12</COUNT><NAME>A&amp;B</NAME></record>", null);
        assertEquals(12, result.GetParamIntValue("COUNT", -1));
        assertEquals("A&B", result.GetParamValue("NAME"));
        try {
            transformer.doTransform("<!DOCTYPE x [<!ENTITY x SYSTEM 'file:///etc/passwd'>]>"
                    + "<record><COUNT>12</COUNT><NAME>&x;</NAME></record>", null);
            fail("External entity must fail");
        } catch (TransformerException expected) {
            assertNotNull(expected.getCause());
        }
    }

    public void testGroovyEngineUsesEntityAndExpression() {
        final BaseDataEntity entity = new BaseDataEntity();
        entity.SetParamValue("A", 4);
        entity.SetParamValue("B", 2);
        entity.SetParamValue("NAME", "abc");
        GrooveStringEngine engine = new GrooveStringEngine() {};
        engine.dataEntity = entity;
        assertEquals(4, engine.Int("A", 0));
        assertTrue(engine.InternalTest("dp.Int('A', 0) > dp.Int('B', 0)", false));
        assertFalse(engine.InternalTest("bad groovy (", false));
        assertTrue(engine.RegEx("NAME", "a.c"));
        assertTrue(engine.IntDiff("A", "B") > 0);
        engine.Part(1, 3, "SLICE", "abcde");
        assertEquals("bcd", entity.GetParamValue("SLICE"));
    }

    public void testTypedFieldsAndCustomPadding() throws Exception {
        assertEquals(Boolean.TRUE, StringTransformer.ParseValue("1", "BOOLEAN", ""));
        assertTrue(Arrays.equals(new byte[] {0x0a, (byte)0xff},
                (byte[])StringTransformer.ParseValue("0Aff", "HEXBINARY", "")));
        try {
            StringTransformer.ParseValue("maybe", "BOOLEAN", "");
            fail("Bad boolean must fail");
        } catch (java.text.ParseException expected) {
            assertNotNull(expected);
        }
        Map<String, String> config = new HashMap<String, String>();
        config.put(StringTransformer.TAG_CONTENTFORMAT, "CODE:4:STRING,ACTIVE:1:BOOLEAN");
        config.put(StringTransformer.TAG_STUFFCHAR, "_");
        BaseDataEntity entity = new BaseDataEntity();
        entity.SetParamValue("CODE", "A");
        entity.SetParamValue("ACTIVE", Boolean.TRUE);
        DataEntity2StringTransformer writer = new DataEntity2StringTransformer();
        writer.setConfig(config);
        assertEquals("A___1", writer.doTransform(entity, null));
        String2DataEntityTransformer reader = new String2DataEntityTransformer();
        reader.setConfig(config);
        BaseDataEntity decoded = (BaseDataEntity)reader.doTransform("A___1", null);
        assertEquals("A", decoded.GetParamValue("CODE"));
        assertEquals(Boolean.TRUE, decoded.GetParamValue("ACTIVE"));
        entity.SetParamValue("ACTIVE", "maybe");
        try {
            writer.doTransform(entity, null);
            fail("Bad boolean must fail on writing");
        } catch (TransformerException expected) {
            assertNotNull(expected.getCause());
        }
    }

    private static BaseDataEntity entityWith(String name, Object value) {
        BaseDataEntity result = new BaseDataEntity();
        result.SetParamValue(name, value);
        return result;
    }
}
