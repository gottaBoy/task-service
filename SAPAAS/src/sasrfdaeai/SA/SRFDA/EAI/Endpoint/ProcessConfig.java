/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.EAI.Endpoint;

import java.util.Map;

public class ProcessConfig {
    private Map<String, String> config;

    public Map<String, String> getConfig() {
        return this.config;
    }

    public void setConfig(Map<String, String> config) {
        this.config = config;
    }

    protected int GetConfig(String strParam, int nDefault) {
        if (this.config == null) {
            return nDefault;
        }
        String strValue = this.config.get(strParam);
        if (strValue == null) {
            return nDefault;
        }
        try {
            return Integer.parseInt(strValue);
        }
        catch (Exception ex) {
            return nDefault;
        }
    }

    protected String GetConfig(String strParam, String strDefault) {
        if (this.config == null) {
            return strDefault;
        }
        String strValue = this.config.get(strParam);
        if (strValue == null) {
            return strDefault;
        }
        return strValue;
    }
}

