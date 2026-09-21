/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psba.dao;

import java.util.HashMap;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psba.dao.IBADAO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BADAOGlobal {
    private static final Log log = LogFactory.getLog(BADAOGlobal.class);
    private static HashMap<String, IBADAO> daoMap = new HashMap();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void registerBADAO(String strDAOClsType, IBADAO iDAO) {
        HashMap<String, IBADAO> hashMap = daoMap;
        synchronized (hashMap) {
            if (!daoMap.containsKey(strDAOClsType)) {
                daoMap.put(strDAOClsType, iDAO);
            }
        }
    }

    public static IBADAO getBADAO(Class cls) throws Exception {
        return BADAOGlobal.getBADAO(cls.getCanonicalName());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static IBADAO getBADAO(String strDAOClsType) throws Exception {
        HashMap<String, IBADAO> hashMap = daoMap;
        synchronized (hashMap) {
            IBADAO iDAO = daoMap.get(strDAOClsType);
            if (iDAO == null) {
                throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9aBADAO[%1$s]", strDAOClsType));
            }
            return iDAO;
        }
    }
}

