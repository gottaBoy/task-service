/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.EAI.Ctrl.Transformer;

import java.util.Map;

public abstract class BaseTransformer {
    public static final String TAG_ENCODING = "ENCODING";
    private Map<String, String> config;

    public BaseTransformer() {
    }

    public Map<String, String> getConfig() {
        return this.config;
    }

    public void setConfig(Map<String, String> config) {
        this.config = config;
    }

    protected int GetConfig(String key, int defaultValue) {
        String value = this.GetConfig(key, (String)null);
        if (value == null) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            return defaultValue;
        }
    }

    protected String GetConfig(String key, String defaultValue) {
        if (this.config == null) {
            return defaultValue;
        }
        String value = this.config.get(key);
        return value == null ? defaultValue : value;
    }

    protected boolean GetConfig(String key, boolean defaultValue) {
        String value = this.GetConfig(key, (String)null);
        if ("true".equalsIgnoreCase(value)) {
            return true;
        }
        if ("false".equalsIgnoreCase(value)) {
            return false;
        }
        return defaultValue;
    }
}
