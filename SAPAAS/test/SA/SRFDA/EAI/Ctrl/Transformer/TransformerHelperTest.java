package SA.SRFDA.EAI.Ctrl.Transformer;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import junit.framework.TestCase;
import org.mule.api.transformer.TransformerException;
import org.mule.transport.NullPayload;

public class TransformerHelperTest extends TestCase {
    private final BaseTransformer transformer = new BaseTransformer() {};

    public void testStringBytesAndStreamUseConfiguredEncoding() throws Exception {
        assertEquals("text", TransformerHelper.GetString(transformer, "text", "UTF-8"));
        byte[] utf8 = "中文".getBytes("UTF-8");
        assertEquals("中文", TransformerHelper.GetString(null, utf8, null));
        assertEquals("中文", TransformerHelper.GetString(transformer, new ByteArrayInputStream(utf8), "UTF-8"));

        Map<String, String> config = new HashMap<String, String>();
        config.put(BaseTransformer.TAG_ENCODING, "GBK");
        transformer.setConfig(config);
        assertEquals("中文", TransformerHelper.GetString(transformer, "中文".getBytes("GBK"), "ISO-8859-1"));
    }

    public void testInvalidStringInputsReportTransformationErrors() throws Exception {
        try {
            TransformerHelper.GetString(transformer, new Object(), "UTF-8");
            fail("Expected unsupported input to fail");
        } catch (TransformerException expected) {
            assertTrue(expected.getMessage().contains("String"));
        }
        try {
            TransformerHelper.GetString(transformer, new byte[] {(byte)0xc3, (byte)0x28}, "UTF-8");
            fail("Expected malformed UTF-8 to fail");
        } catch (TransformerException expected) {
            assertNotNull(expected.getCause());
        }
        try {
            TransformerHelper.GetString(transformer, new byte[] {65}, "invalid-charset");
            fail("Expected invalid charset to fail");
        } catch (TransformerException expected) {
            assertNotNull(expected.getCause());
        }
        InputStream broken = new InputStream() {
            public int read() throws IOException {
                throw new IOException("read failed");
            }
        };
        try {
            TransformerHelper.GetString(transformer, broken, "UTF-8");
            fail("Expected stream read failure");
        } catch (TransformerException expected) {
            assertTrue(expected.getCause() instanceof IOException);
        }
    }

    public void testDataEntityPassThroughMapAndEmptyMulePayload() throws Exception {
        BaseDataEntity original = new BaseDataEntity();
        original.SetParamValue("NAME", "existing");
        assertSame(original, TransformerHelper.GetDataEntity(transformer, original));

        Map<String, Object> input = new HashMap<String, Object>();
        input.put("NAME", "from map");
        input.put("COUNT", 5);
        input.put("EMPTY", "");
        input.put("NULL", null);
        BaseDataEntity converted = TransformerHelper.GetDataEntity(transformer, input);
        assertEquals("from map", converted.GetParamStringValue("NAME", ""));
        assertEquals(5, converted.GetParamIntValue("COUNT", -1));
        assertTrue(converted.IsParamNull("EMPTY"));
        assertFalse(converted.ContainesParam("NULL"));
        assertEquals("from map", input.get("NAME"));

        BaseDataEntity empty = TransformerHelper.GetDataEntity(transformer, NullPayload.getInstance());
        assertNull(empty.GetParamValue("NAME"));
    }

    public void testDataEntityRejectsUnsupportedAndInvalidMap() throws Exception {
        try {
            TransformerHelper.GetDataEntity(transformer, null);
            fail("Expected null reference to fail");
        } catch (TransformerException expected) {
            assertTrue(expected.getMessage().contains("null"));
        }
        Map<Object, Object> invalid = new HashMap<Object, Object>();
        invalid.put(null, "value");
        try {
            TransformerHelper.GetDataEntity(transformer, invalid);
            fail("Expected invalid map key to fail");
        } catch (TransformerException expected) {
            assertNotNull(expected.getCause());
        }
    }

    public void testMapPassThroughAndEntityConversion() throws Exception {
        Map<String, Object> original = new HashMap<String, Object>();
        assertSame(original, TransformerHelper.GetMap(transformer, original));
        BaseDataEntity entity = new BaseDataEntity();
        entity.SetParamValue("NAME", "converted");
        entity.SetParamValue("EMPTY", null);
        Map result = TransformerHelper.GetMap(transformer, entity);
        assertEquals("converted", result.get("NAME"));
        assertEquals("", result.get("EMPTY"));
        try {
            TransformerHelper.GetMap(transformer, "wrong");
            fail("Expected unsupported input to fail");
        } catch (TransformerException expected) {
            assertTrue(expected.getMessage().contains("Map"));
        }
    }

    public void testPayloadOverlaysMapAndExistingEntity() throws Exception {
        BaseDataEntity update = new BaseDataEntity();
        update.SetParamValue("SHARED", "new");
        update.SetParamValue("ADDED", 3);
        Map<String, Object> original = new HashMap<String, Object>();
        original.put("SHARED", "old");
        original.put("KEPT", "value");
        Map merged = TransformerHelper.GetPayload(transformer, original, update);
        assertSame(original, merged);
        assertEquals("new", merged.get("SHARED"));
        assertEquals("value", merged.get("KEPT"));
        assertEquals(3, merged.get("ADDED"));

        BaseDataEntity previous = new BaseDataEntity();
        previous.SetParamValue("SHARED", "old");
        previous.SetParamValue("KEPT", "value");
        merged = TransformerHelper.GetPayload(transformer, previous, update);
        assertEquals("new", merged.get("SHARED"));
        assertEquals("value", merged.get("KEPT"));
        assertEquals("old", previous.GetParamStringValue("SHARED", ""));
        assertEquals("new", TransformerHelper.GetPayload(transformer, NullPayload.getInstance(), update).get("SHARED"));
    }

    public void testPayloadRejectsUnsupportedSourceAndMissingUpdate() throws Exception {
        BaseDataEntity update = new BaseDataEntity();
        update.SetParamValue("NAME", "value");
        try {
            TransformerHelper.GetPayload(transformer, "wrong", update);
            fail("Expected invalid source to fail");
        } catch (TransformerException expected) {
            assertTrue(expected.getMessage().contains("Map"));
        }
        try {
            TransformerHelper.GetPayload(transformer, new HashMap<String, Object>(), null);
            fail("Expected null update to fail");
        } catch (TransformerException expected) {
            assertTrue(expected.getMessage().contains("BaseDataEntity"));
        }
        try {
            TransformerHelper.GetPayload(transformer, Collections.emptyMap(), update);
            fail("Expected read-only map to fail");
        } catch (TransformerException expected) {
            assertNotNull(expected.getCause());
        }
    }
}
