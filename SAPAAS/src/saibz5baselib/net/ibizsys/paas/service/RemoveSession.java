/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.service;

import java.util.HashMap;
import net.ibizsys.paas.util.StringHelper;

@Deprecated
public class RemoveSession {
    protected HashMap<String, String> removeDataMap = new HashMap();

    public boolean register(String strDEId, Object objKeyValue) {
        String strRemoveTag = StringHelper.format("%1$s||%2$s", strDEId, objKeyValue);
        if (this.removeDataMap.containsKey(strRemoveTag)) {
            return false;
        }
        this.removeDataMap.put(strRemoveTag, "");
        return true;
    }
}

