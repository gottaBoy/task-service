/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.demodel;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.demodel.IDEFInputTipSetModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DEFInputTipSetModelGlobal {
    private static final Log log = LogFactory.getLog(DEFInputTipSetModelGlobal.class);
    private static HashMap<String, IDEFInputTipSetModel> defInputTipSetMap = new HashMap();

    public static void registerDEFInputTipSet(String strDEFInputTipSetClsType, IDEFInputTipSetModel iDEFInputTipSet) {
        defInputTipSetMap.put(strDEFInputTipSetClsType, iDEFInputTipSet);
        defInputTipSetMap.put(iDEFInputTipSet.getId(), iDEFInputTipSet);
    }

    public static IDEFInputTipSetModel getDEFInputTipSet(Class cls) throws Exception {
        return DEFInputTipSetModelGlobal.getDEFInputTipSet(cls.getCanonicalName());
    }

    public static IDEFInputTipSetModel getDEFInputTipSet(String strDEFInputTipSetClsType) throws Exception {
        return defInputTipSetMap.get(strDEFInputTipSetClsType);
    }

    public static void reloadAllDEFInputTipSets() {
        ArrayList<IDEFInputTipSetModel> list = new ArrayList<IDEFInputTipSetModel>();
        list.addAll(defInputTipSetMap.values());
        for (IDEFInputTipSetModel iDEFInputTipSetModel : list) {
            iDEFInputTipSetModel.resetAll();
        }
    }
}

