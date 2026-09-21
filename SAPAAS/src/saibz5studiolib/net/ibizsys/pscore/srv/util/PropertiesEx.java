/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.pscore.srv.util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import net.ibizsys.paas.util.StringHelper;

public class PropertiesEx
extends Properties {
    private Map<String, Object> map = new LinkedHashMap<String, Object>();

    public Map<String, Object> getMap() {
        return this.map;
    }

    public void load(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        this.map.putAll(map);
        this.load(null, map);
    }

    protected void set(String string, Object object) {
        if (object instanceof Map) {
            this.load(string, (Map)object);
        } else {
            this.put(string, object);
        }
    }

    protected void load(String string, Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String string2 = null;
            string2 = !StringHelper.isNullOrEmpty((String)string) ? String.format("%1$s.%2$s", string, entry.getKey()) : entry.getKey();
            this.set(string2, entry.getValue());
        }
    }
}

