/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import java.util.TreeMap;

public class DataPrivCodeStorage {
    private TreeMap<String, String> codeMap = new TreeMap();

    public synchronized boolean IsContainsDE(String strDEId) {
        return this.codeMap.containsKey(strDEId.toUpperCase());
    }

    public synchronized void Register(String strDEId, String strCode) {
    }

    public synchronized String GetCode(String strDEId) {
        return this.codeMap.get(strDEId.toUpperCase());
    }

    public synchronized void Reset() {
        this.codeMap.clear();
    }
}

