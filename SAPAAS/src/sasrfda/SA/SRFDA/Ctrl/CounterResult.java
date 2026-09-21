/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.Ctrl;

import SA.SRFramework.DataEx.CallResult;
import java.util.HashMap;

public class CounterResult
extends CallResult {
    protected int nCount;
    protected HashMap<String, Integer> extCountMap = new HashMap();

    public int getCount() {
        return this.nCount;
    }

    public void setCount(int nCount) {
        this.nCount = nCount;
    }

    public HashMap<String, Integer> getExtCountMap() {
        return this.extCountMap;
    }
}

