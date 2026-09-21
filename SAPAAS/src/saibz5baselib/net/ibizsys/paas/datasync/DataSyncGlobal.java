/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.datasync;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.core.IDEDataSyncIn;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DataSyncGlobal {
    private static final Log log = LogFactory.getLog(DataSyncGlobal.class);
    private static HashMap<String, ArrayList<IDEDataSyncIn>> deDataSyncListMap = new HashMap();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     */
    public static void registerDEDataSyncIn(IDEDataSyncIn iDEDataSyncIn) {
        block9: {
            deNames = iDEDataSyncIn.getDENames();
            if (deNames != null) ** GOTO lbl34
            strDEName = iDEDataSyncIn.getDataEntity().getName();
            deDataSyncList = null;
            var4_6 = DataSyncGlobal.deDataSyncListMap;
            synchronized (var4_6) {
                deDataSyncList = DataSyncGlobal.deDataSyncListMap.get(strDEName);
                if (deDataSyncList == null) {
                    deDataSyncList = new ArrayList<E>();
                    DataSyncGlobal.deDataSyncListMap.put(strDEName, deDataSyncList);
                }
            }
            deDataSyncList.add(iDEDataSyncIn);
            break block9;
lbl-1000:
            // 1 sources

            {
                strDEName = deNames.next();
                deDataSyncList = null;
                var4_7 = DataSyncGlobal.deDataSyncListMap;
                synchronized (var4_7) {
                    deDataSyncList = DataSyncGlobal.deDataSyncListMap.get(strDEName);
                    if (deDataSyncList == null) {
                        deDataSyncList = new ArrayList<E>();
                        DataSyncGlobal.deDataSyncListMap.put(strDEName, deDataSyncList);
                    }
                }
                deDataSyncList.add(iDEDataSyncIn);
lbl34:
                // 2 sources

                ** while (deNames.hasNext())
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Iterator<IDEDataSyncIn> getDEDataSyncIns(String strDEName) {
        ArrayList<IDEDataSyncIn> deDataSyncList = null;
        HashMap<String, ArrayList<IDEDataSyncIn>> hashMap = deDataSyncListMap;
        synchronized (hashMap) {
            deDataSyncList = deDataSyncListMap.get(strDEName);
        }
        if (deDataSyncList == null) {
            return null;
        }
        return deDataSyncList.iterator();
    }
}

