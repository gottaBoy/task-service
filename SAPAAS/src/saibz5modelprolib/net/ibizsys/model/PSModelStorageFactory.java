/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSModelStorage
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model;

import net.ibizsys.model.IPSModelStorage;
import net.ibizsys.model.PSModelStorageImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSModelStorageFactory {
    private static final Log log = LogFactory.getLog(PSModelStorageFactory.class);
    private static IPSModelStorage iPSModelStorage = null;
    private static Object objPSModelStorageLock = new Object();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final IPSModelStorage getInstance() throws Exception {
        Object object = objPSModelStorageLock;
        synchronized (object) {
            if (iPSModelStorage != null) {
                return iPSModelStorage;
            }
            PSModelStorageImpl psModelStorageImpl = new PSModelStorageImpl();
            psModelStorageImpl.init();
            iPSModelStorage = psModelStorageImpl;
            return iPSModelStorage;
        }
    }
}

