/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.db;

import java.util.ArrayList;
import net.ibizsys.paas.db.IDataSet;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DataSetCache {
    private static final Log log = LogFactory.getLog(DataSetCache.class);
    private static ThreadLocal<ArrayList<IDataSet>> dataSetMap = new ThreadLocal();

    public static void enableCurrent() {
        ArrayList<IDataSet> curList = dataSetMap.get();
        if (curList != null) {
            return;
        }
        dataSetMap.set(new ArrayList());
    }

    public static void resetCurrent() {
        ArrayList<IDataSet> curList = dataSetMap.get();
        if (curList != null) {
            dataSetMap.set(null);
            for (IDataSet iDataSet : curList) {
                log.warn((Object)StringHelper.format("\u7ed3\u679c\u96c6\u5408\u6ca1\u6709\u91ca\u653e\r\n%1$s\r\n", iDataSet.getSqlInfo()));
                try {
                    iDataSet.close();
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
            curList.clear();
        }
    }

    public static void register(IDataSet iDataSet) {
        ArrayList<IDataSet> curList = dataSetMap.get();
        if (curList == null || iDataSet == null) {
            return;
        }
        curList.add(iDataSet);
    }

    public static void unregister(IDataSet iDataSet) {
        ArrayList<IDataSet> curList = dataSetMap.get();
        if (curList == null || iDataSet == null) {
            return;
        }
        curList.remove(iDataSet);
    }
}

