/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import java.util.HashMap;
import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSets;
import net.ibizsys.paas.util.StringHelper;

public class DEDataSetsAnnoHelper {
    private HashMap<String, DEDataSet> deDataSetMap = new HashMap();
    private DEDataSets dedatasets = null;

    public DEDataSetsAnnoHelper(DEDataSets dedatasets) {
        this.dedatasets = dedatasets;
        DEDataSet[] dEDataSetArray = this.dedatasets.value();
        int n = dEDataSetArray.length;
        int n2 = 0;
        while (n2 < n) {
            DEDataSet dedataset = dEDataSetArray[n2];
            this.deDataSetMap.put(dedataset.id(), dedataset);
            this.deDataSetMap.put(dedataset.name(), dedataset);
            ++n2;
        }
    }

    public DEDataSet getDEDataSet(String strName, boolean bTry) throws Exception {
        DEDataSet dedataset = this.deDataSetMap.get(strName);
        if (dedataset == null && !bTry) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6570\u636e\u96c6\u5408[%1$s]", strName));
        }
        return dedataset;
    }
}

