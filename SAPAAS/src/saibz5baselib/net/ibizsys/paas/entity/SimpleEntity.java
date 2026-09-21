/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.entity;

import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.entity.EntityBase;

public class SimpleEntity
extends EntityBase {
    public Iterator<String> getFieldNames() {
        HashMap<String, Object> fieldsMap = new HashMap<String, Object>();
        this.fillMap(fieldsMap);
        return fieldsMap.keySet().iterator();
    }
}

