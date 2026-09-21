/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.service;

import java.util.HashMap;
import net.ibizsys.paas.util.StringHelper;

public class ImportSession {
    protected HashMap<String, String> importDataMap = new HashMap();
    private String strName = "";

    public String getName() {
        return this.strName;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    public boolean register(String strDEId, Object objKeyValue) {
        String strImportTag = StringHelper.format("%1$s||%2$s", strDEId, objKeyValue);
        if (this.importDataMap.containsKey(strImportTag)) {
            return false;
        }
        this.importDataMap.put(strImportTag, "");
        return true;
    }
}

