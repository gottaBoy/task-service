/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.ISRFDATransactionManager
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.ISRFDATransactionManager;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.TM.Ctrl.BaseTMObject;
import SA.TM.Ctrl.ITMActionContext;
import java.sql.Connection;
import java.util.Hashtable;

public class TMActionContext
extends BaseTMObject
implements ITMActionContext {
    protected Hashtable<String, Object> userTagMap = new Hashtable();
    protected IDEDataCtrl iDEDataCtrl = null;
    protected String strOPPersonId = "";

    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IDEDataCtrl iDEDataCtrl) {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.iDEDataCtrl = iDEDataCtrl;
    }

    public IDEDataCtrl getDEDataCtrl(String strDEId) throws Exception {
        return this.iDEDataCtrl.GetRelatedDataCtrl(strDEId);
    }

    public Object getUserTag(String strUserTagId) {
        return this.userTagMap.get(strUserTagId);
    }

    public void setUserTag(String strUserTagId, Object obj) {
        if (obj == null) {
            this.userTagMap.remove(strUserTagId);
        } else {
            this.userTagMap.put(strUserTagId, obj);
        }
    }

    public ISRFDATransactionManager getTransactionManager() {
        return this.iDEDataCtrl.getTransactionManager();
    }

    public Connection getDBConnection(String strDBStorage) {
        if (this.getTransactionManager() == null) {
            return null;
        }
        return this.getTransactionManager().GetConnection(strDBStorage);
    }
}

