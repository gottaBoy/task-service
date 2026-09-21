/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.entity;

import java.util.Iterator;
import java.util.TreeMap;

public class BAColumnHistory {
    private TreeMap<Long, Object> valueMap = new TreeMap();

    public Iterator<Long> getTimestamps() {
        return this.valueMap.keySet().iterator();
    }

    public Object getValue(long nTimestamp) throws Exception {
        if (nTimestamp > 0L) {
            if (!this.valueMap.containsKey(nTimestamp)) {
                throw new Exception("\u4e0d\u5b58\u5728\u6307\u5b9a\u65f6\u95f4\u53d8\u66f4\u6570\u636e");
            }
            return this.valueMap.get(nTimestamp);
        }
        long nIndex = nTimestamp;
        Long nLastKey = this.valueMap.lastEntry().getKey();
        while (nIndex < 0L) {
            if ((nLastKey = this.valueMap.lowerKey(nLastKey)) == null) {
                return null;
            }
            ++nIndex;
        }
        return this.valueMap.get(nLastKey);
    }

    public void setValue(long nTimestamp, Object objValue) {
        this.valueMap.put(nTimestamp, objValue);
    }

    public Object getLastValue() {
        if (this.valueMap.size() == 0) {
            return null;
        }
        return this.valueMap.lastEntry().getValue();
    }
}

