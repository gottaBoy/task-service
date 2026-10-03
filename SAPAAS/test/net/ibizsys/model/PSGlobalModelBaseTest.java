package net.ibizsys.model;

import java.util.Iterator;
import java.util.Vector;
import junit.framework.TestCase;

public class PSGlobalModelBaseTest extends TestCase {
    public void testHelperLookupAndReset() throws Exception {
        ModelRegistry registry = new ModelRegistry();
        assertEquals("helper-one", registry.findModelHelper("one"));
        assertEquals("helper-one", registry.findModelHelper("one"));
        assertEquals(1, registry.created);
        assertEquals(1, registry.getModelCount());

        registry.resetModel("one");
        assertEquals(1, registry.reset);
        assertEquals("helper-one", registry.findModelHelper("one"));
        assertEquals(2, registry.created);
    }

    public void testAllHelpersAreCachedAndReset() throws Exception {
        ModelRegistry registry = new ModelRegistry();
        assertEquals(2, registry.getAllModelHelperCount());
        assertEquals(2, registry.getAllModelHelperCount());
        assertEquals(2, registry.created);
        Iterator<String> helpers = registry.getAllModelHelpers();
        assertEquals("helper-one", helpers.next());
        assertEquals("helper-two", helpers.next());
        assertFalse(helpers.hasNext());

        registry.resetAll();
        assertEquals(2, registry.reset);
        assertEquals(2, registry.getAllModelHelperCount());
        assertEquals(4, registry.created);
    }

    private static class ModelRegistry extends PSGlobalModelBase<String, String, String> {
        int created;
        int reset;

        protected String getObject(String key) {
            return key;
        }

        protected String onCreateModelHelper(String model) {
            created++;
            return "helper-" + model;
        }

        protected String registerModel(String model) throws Exception {
            setModel(model, model, null);
            return findModelHelper(model);
        }

        protected Vector<String> getAllModels() {
            Vector<String> models = new Vector<String>();
            models.add("one");
            models.add("two");
            return models;
        }

        protected void onResetModelHelper(String helper) {
            reset++;
        }

        protected String getObjectId(String model) {
            return model;
        }

        public String getPSSysModelInstId() {
            return null;
        }
    }
}
