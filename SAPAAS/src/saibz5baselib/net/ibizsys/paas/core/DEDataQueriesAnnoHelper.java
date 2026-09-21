/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import java.util.HashMap;
import net.ibizsys.paas.core.DEDataQueries;
import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.util.StringHelper;

public class DEDataQueriesAnnoHelper {
    private HashMap<String, DEDataQuery> deDataQueryMap = new HashMap();
    private DEDataQueries dedataqueries = null;

    public DEDataQueriesAnnoHelper(DEDataQueries dedataqueries) {
        this.dedataqueries = dedataqueries;
        DEDataQuery[] dEDataQueryArray = this.dedataqueries.value();
        int n = dEDataQueryArray.length;
        int n2 = 0;
        while (n2 < n) {
            DEDataQuery dedataquery = dEDataQueryArray[n2];
            this.deDataQueryMap.put(dedataquery.id(), dedataquery);
            ++n2;
        }
    }

    public DEDataQuery getDEDataQuery(String strName, String strDBType, boolean bTry) throws Exception {
        String strFullName = StringHelper.format("%1$s_%2$s", strName, strDBType);
        DEDataQuery dedataquery = this.deDataQueryMap.get(strFullName);
        if (dedataquery == null && !bTry) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6570\u636e\u67e5\u8be2[%1$s]", strFullName));
        }
        return dedataquery;
    }
}

