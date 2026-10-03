package SA.SRFDA.EAI.Ctrl.Transformer;

import java.util.HashMap;
import java.util.Map;
import junit.framework.TestCase;

public class BaseTransformerTest extends TestCase {
    private static final class ConfigTransformer extends BaseTransformer {
        int integer(String key, int fallback) {
            return GetConfig(key, fallback);
        }

        String text(String key, String fallback) {
            return GetConfig(key, fallback);
        }

        boolean flag(String key, boolean fallback) {
            return GetConfig(key, fallback);
        }
    }

    public void testDefaultsBeforeConfiguration() {
        ConfigTransformer transformer = new ConfigTransformer();
        assertNull(transformer.getConfig());
        assertEquals(7, transformer.integer("size", 7));
        assertEquals("UTF-8", transformer.text("encoding", "UTF-8"));
        assertTrue(transformer.flag("enabled", true));
    }

    public void testConfiguredValuesAndInvalidFallbacks() {
        ConfigTransformer transformer = new ConfigTransformer();
        Map<String, String> config = new HashMap<String, String>();
        config.put("size", "12");
        config.put("encoding", "GBK");
        config.put("enabled", "FALSE");
        transformer.setConfig(config);
        assertSame(config, transformer.getConfig());
        assertEquals(12, transformer.integer("size", 7));
        assertEquals("GBK", transformer.text("encoding", "UTF-8"));
        assertFalse(transformer.flag("enabled", true));
        config.put("size", "not-an-integer");
        config.put("enabled", "not-a-boolean");
        assertEquals(7, transformer.integer("size", 7));
        assertTrue(transformer.flag("enabled", true));
        assertEquals("missing", transformer.text("unknown", "missing"));
    }
}
