/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.WT.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.WT.Ctrl.IWTAccountHelper;
import SA.WT.Ctrl.IWTConfigTypeHelper;
import SA.WT.Ctrl.IWTModelHelper;
import SA.WT.Ctrl.IWTModelStorage;
import SA.WT.Ctrl.IWTServiceHelper;
import SA.WT.Ctrl.IWTServiceTypeHelper;
import SA.WT.Ctrl.WTAccountGlobalModel;
import SA.WT.Ctrl.WTConfigTypeGlobalModel;
import SA.WT.Ctrl.WTModelHelperFactory;
import SA.WT.Ctrl.WTServiceGlobalModel;
import SA.WT.Ctrl.WTServiceTypeGlobalModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WTModelStorage
implements IWTModelStorage {
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    protected WTConfigTypeGlobalModel wtConfigTypeGlobalModel = new WTConfigTypeGlobalModel();
    protected WTAccountGlobalModel wtAccountGlobalModel = new WTAccountGlobalModel();
    protected WTServiceGlobalModel wtServiceGlobalModel = new WTServiceGlobalModel();
    protected WTServiceTypeGlobalModel wtServiceTypeGlobalModel = new WTServiceTypeGlobalModel();
    private static final Log log = LogFactory.getLog(WTModelStorage.class);

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.wtConfigTypeGlobalModel.Init(iDAGlobalHelper);
        this.wtAccountGlobalModel.Init(iDAGlobalHelper);
        this.wtServiceGlobalModel.Init(iDAGlobalHelper);
        this.wtServiceTypeGlobalModel.Init(iDAGlobalHelper);
    }

    protected final void setDAGlobalHelper(ISRFDAGlobalHelper iDAGlobalHelper) {
        this.iDAGlobalHelper = iDAGlobalHelper;
    }

    protected final ISRFDAGlobalHelper getDAGlobalHelper() {
        return this.iDAGlobalHelper;
    }

    protected final IWTModelHelper getWTModelHelper() throws Exception {
        return WTModelHelperFactory.Create(this.getDAGlobalHelper());
    }

    @Override
    public IWTConfigTypeHelper FindWTConfigType(String strWTConfigType) throws Exception {
        return (IWTConfigTypeHelper)this.wtConfigTypeGlobalModel.FindModelHelper(strWTConfigType);
    }

    @Override
    public IWTAccountHelper FindWTAccount(String strWTAccountId) throws Exception {
        return (IWTAccountHelper)this.wtAccountGlobalModel.FindModelHelper(strWTAccountId);
    }

    @Override
    public void ResetWTAccount(String strWTAccountId) throws Exception {
        this.wtAccountGlobalModel.ResetModel(strWTAccountId);
    }

    @Override
    public IWTServiceTypeHelper FindWTServiceType(String strWTServiceTypeId) throws Exception {
        return (IWTServiceTypeHelper)this.wtServiceTypeGlobalModel.FindModelHelper(strWTServiceTypeId);
    }

    @Override
    public void ResetWTServiceType(String strWTServiceTypeId) throws Exception {
        this.wtServiceTypeGlobalModel.ResetModel(strWTServiceTypeId);
    }

    @Override
    public IWTServiceHelper FindWTService(String strWTServiceId) throws Exception {
        return (IWTServiceHelper)this.wtServiceGlobalModel.FindModelHelper(strWTServiceId);
    }

    @Override
    public IWTServiceHelper FindWTServiceByCode(String strWTServiceCode) throws Exception {
        return this.wtServiceGlobalModel.FindWTServiceByCode(strWTServiceCode);
    }

    @Override
    public void ResetWTService(String strWTServiceId) throws Exception {
        this.wtServiceGlobalModel.ResetModel(strWTServiceId);
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

