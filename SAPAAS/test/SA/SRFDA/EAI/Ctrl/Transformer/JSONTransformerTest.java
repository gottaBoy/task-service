package SA.SRFDA.EAI.Ctrl.Transformer;

import SA.SRFramework.DataEx.BaseDataEntities;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.HashMap;
import java.util.Map;
import junit.framework.TestCase;
import net.sf.json.JSONObject;

public class JSONTransformerTest extends TestCase {
    public void testRoundTripPreservesValuesAndNestedEntities() {
        BaseDataEntity entity = new BaseDataEntity();
        entity.SetParamValue("TITLE", "中文 \"quote\"");
        entity.SetParamValue("COUNT", 3);
        BaseDataEntities rows = new BaseDataEntities();
        BaseDataEntity row = new BaseDataEntity();
        row.SetParamValue("CODE", "A");
        rows.add(row);
        entity.SetParamValue("ROWS", rows);

        String json = (String)new DataEntity2JSON().doTransform(entity, "UTF-8");
        JSONObject parsed = JSONObject.fromString(json);
        assertEquals("中文 \"quote\"", parsed.getString("title"));
        assertEquals(3, parsed.getInt("count"));
        assertEquals("A", parsed.getJSONArray("rows").getJSONObject(0).getString("code"));

        BaseDataEntity result = (BaseDataEntity)new JSON2DataEntity().doTransform(json, "UTF-8");
        assertEquals("中文 \"quote\"", result.GetParamStringValue("TITLE", ""));
        assertEquals(3, result.GetParamIntValue("COUNT", -1));
        assertEquals("A", result.GetParamDataEntitiesValue("ROWS").get(0).GetParamStringValue("CODE", ""));
    }

    public void testNullFieldsFollowBaseDataEntitySerialization() {
        BaseDataEntity entity = new BaseDataEntity();
        entity.SetParamValue("EMPTY", null);
        assertEquals("{}", new DataEntity2JSON().doTransform(entity, null));

        BaseDataEntity result = (BaseDataEntity)new JSON2DataEntity().doTransform("{\"empty\":null}", null);
        assertTrue(result.ContainesParam("EMPTY"));
        assertTrue(result.IsParamNull("EMPTY"));
    }

    public void testUnsupportedInputsFailExplicitly() {
        try {
            new DataEntity2JSON().doTransform(null, null);
            fail("Expected invalid entity input to fail");
        } catch (IllegalArgumentException expected) {
            assertTrue(expected.getMessage().contains("BaseDataEntity"));
        }
        try {
            new JSON2DataEntity().doTransform(new Object(), null);
            fail("Expected invalid JSON input to fail");
        } catch (IllegalArgumentException expected) {
            assertTrue(expected.getMessage().contains("String"));
        }
    }

    public void testEncodedBytesAndMalformedInput() throws Exception {
        JSON2DataEntity transformer = new JSON2DataEntity();
        Map<String, String> config = new HashMap<String, String>();
        config.put(BaseTransformer.TAG_ENCODING, "UTF-8");
        transformer.setConfig(config);

        byte[] bytes = "{\"title\":\"中文\"}".getBytes("UTF-8");
        BaseDataEntity result = (BaseDataEntity)transformer.doTransform(bytes, "ISO-8859-1");
        assertEquals("中文", result.GetParamStringValue("TITLE", ""));

        try {
            transformer.doTransform(new byte[] {(byte)0xc3, (byte)0x28}, "UTF-8");
            fail("Expected malformed input to fail");
        } catch (IllegalArgumentException expected) {
            assertNotNull(expected.getCause());
        }
    }

    public void testInvalidJsonIsNotSilentlyIgnored() {
        try {
            new JSON2DataEntity().doTransform("{invalid", null);
            fail("Expected invalid JSON input to fail");
        } catch (RuntimeException expected) {
            assertNotNull(expected);
        }
    }
}
