/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.ISRFDATransactionManager
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.ND.Ctrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.ISRFDATransactionManager;
import SA.SRFDA.ND.Ctrl.INDActionContext;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Connection;
import java.util.HashMap;

public class NDActionContext
implements INDActionContext {
    protected HashMap<String, Object> userTagMap = new HashMap();
    protected IDEDataCtrl iDEDataCtrl = null;
    protected ISRFDAWebContext daWebContext;
    protected String strOPPersonId = "";
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;

    public NDActionContext() {
    }

    public NDActionContext(ISRFDAGlobalHelper iDAGlobalHelper, ISRFDAWebContext daWebContext, IDEDataCtrl iDEDataCtrl) {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.iDEDataCtrl = iDEDataCtrl;
        this.daWebContext = daWebContext;
    }

    public NDActionContext(ISRFDAGlobalHelper iDAGlobalHelper, IDEDataCtrl iDEDataCtrl) {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.iDEDataCtrl = iDEDataCtrl;
        if (this.iDEDataCtrl != null) {
            this.daWebContext = iDEDataCtrl.getWebContext();
        }
    }

    public NDActionContext(IDEDataCtrl iDEDataCtrl) {
        this.iDEDataCtrl = iDEDataCtrl;
        this.iDAGlobalHelper = iDEDataCtrl.getGlobalHelper();
        this.daWebContext = iDEDataCtrl.getWebContext();
    }

    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, ISRFDAWebContext daWebContext, IDEDataCtrl iDEDataCtrl) {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.iDEDataCtrl = iDEDataCtrl;
        this.daWebContext = daWebContext;
    }

    @Override
    public IDEDataCtrl getDEDataCtrl(String strDEId) throws Exception {
        if (this.iDEDataCtrl == null) {
            this.iDEDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl(strDEId, this.daWebContext);
            return this.iDEDataCtrl;
        }
        if (StringHelper.Compare((String)this.iDEDataCtrl.GetDEHelper().getId(), (String)strDEId, (boolean)true) == 0) {
            return this.iDEDataCtrl;
        }
        return this.iDEDataCtrl.GetRelatedDataCtrl(strDEId);
    }

    @Override
    public Object getUserTag(String strUserTagId) {
        return this.userTagMap.get(strUserTagId);
    }

    @Override
    public void setUserTag(String strUserTagId, Object obj) {
        if (obj == null) {
            this.userTagMap.remove(strUserTagId);
        } else {
            this.userTagMap.put(strUserTagId, obj);
        }
    }

    @Override
    public ISRFDATransactionManager getTransactionManager() {
        if (this.iDEDataCtrl == null) {
            return null;
        }
        return this.iDEDataCtrl.getTransactionManager();
    }

    @Override
    public Connection getDBConnection(String strDBStorage) {
        if (this.getTransactionManager() == null) {
            return null;
        }
        return this.getTransactionManager().GetConnection(strDBStorage);
    }

    @Override
    public ISRFDAWebContext getWebContext() {
        return this.daWebContext;
    }
}

