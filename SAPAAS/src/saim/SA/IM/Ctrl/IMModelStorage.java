/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.IIMConfigTypeHelper;
import SA.IM.Ctrl.IIMModelHelper;
import SA.IM.Ctrl.IIMModelStorage;
import SA.IM.Ctrl.IMConfigTypeGlobalModel;
import SA.IM.Ctrl.IMModelHelperFactory;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IMModelStorage
implements IIMModelStorage {
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    protected IMConfigTypeGlobalModel imConfigTypeGlobalModel = new IMConfigTypeGlobalModel();
    private static final Log log = LogFactory.getLog(IMModelStorage.class);

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.imConfigTypeGlobalModel.Init(iDAGlobalHelper);
    }

    protected final void setDAGlobalHelper(ISRFDAGlobalHelper iDAGlobalHelper) {
        this.iDAGlobalHelper = iDAGlobalHelper;
    }

    protected final ISRFDAGlobalHelper getDAGlobalHelper() {
        return this.iDAGlobalHelper;
    }

    protected final IIMModelHelper getIMModelHelper() throws Exception {
        return IMModelHelperFactory.Create(this.getDAGlobalHelper());
    }

    @Override
    public IIMConfigTypeHelper FindIMConfigType(String strIMConfigType) throws Exception {
        return (IIMConfigTypeHelper)this.imConfigTypeGlobalModel.FindModelHelper(strIMConfigType);
    }

    protected final int GetLastVersion(String strDEId, String strKey, int nVersion) {
        if (nVersion < 0) {
            return this.getDAGlobalHelper().getDAModelStorage().GetDAModelVersion(strDEId, (Object)strKey);
        }
        if (nVersion == 0) {
            return this.getDAGlobalHelper().getDAModelStorage().GetDAModelVersion(strDEId, (Object)strKey, true);
        }
        return nVersion;
    }
}

