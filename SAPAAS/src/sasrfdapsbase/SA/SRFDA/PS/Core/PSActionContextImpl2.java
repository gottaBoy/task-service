/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.ISRFDATransactionManager
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  net.ibizsys.paas.service.IService
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.ISRFDATransactionManager;
import SA.SRFDA.PS.Core.IPSActionContext;
import SA.SRFDA.Web.ISRFDAWebContext;
import java.sql.Connection;
import java.util.HashMap;
import net.ibizsys.paas.service.IService;

public class PSActionContextImpl2
implements IPSActionContext {
    protected HashMap<String, Object> userTagMap = new HashMap();
    private IPSActionContext iNUActionContext = null;

    public PSActionContextImpl2(IPSActionContext iNUActionContext) {
        this.iNUActionContext = iNUActionContext;
    }

    public IDEDataCtrl getDEDataCtrl(String strDEId) throws Exception {
        return this.iNUActionContext.getDEDataCtrl(strDEId);
    }

    public Object getUserTag(String strUserTagId) {
        Object objValue = this.userTagMap.get(strUserTagId);
        if (objValue == null) {
            return this.iNUActionContext.getUserTag(strUserTagId);
        }
        return objValue;
    }

    public void setUserTag(String strUserTagId, Object obj) {
        if (obj == null) {
            this.userTagMap.remove(strUserTagId);
        } else {
            this.userTagMap.put(strUserTagId, obj);
        }
    }

    public ISRFDATransactionManager getTransactionManager() {
        return this.iNUActionContext.getTransactionManager();
    }

    public Connection getDBConnection(String strDBStorage) {
        return this.iNUActionContext.getDBConnection(strDBStorage);
    }

    public ISRFDAWebContext getWebContext() {
        return this.iNUActionContext.getWebContext();
    }

    @Override
    public String getLanguage() {
        return this.iNUActionContext.getLanguage();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iNUActionContext.getPSSysModelInstId();
    }

    @Override
    public IService getService(Class cls) throws Exception {
        return this.iNUActionContext.getService(cls);
    }
}

