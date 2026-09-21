/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroup;
import SA.SRFDA.PS.Core.App.DataEntity.PSAppDataEntityGlobalModelBase;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDEUILogicGroupImpl;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityException;
import SA.SRFDA.PS.Data.PSCtrlLogicGroup;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppDEUILogicGroupGlobalModel
extends PSAppDataEntityGlobalModelBase<String, PSCtrlLogicGroup, IPSAppDEUILogicGroup> {
    private static final Log log = LogFactory.getLog(PSAppDEUILogicGroupGlobalModel.class);

    @Override
    protected PSCtrlLogicGroup GetObject(String strPSCtrlLogicGroupId) {
        return null;
    }

    @Override
    protected IPSAppDEUILogicGroup OnCreateModelHelper(PSCtrlLogicGroup vt) throws Exception {
        PSDEUILogicGroupImpl iPSCtrlLogicGroup = new PSDEUILogicGroupImpl();
        iPSCtrlLogicGroup.init(this.iDAGlobalHelper, this.getPSAppDataEntity(), vt);
        return iPSCtrlLogicGroup;
    }

    @Override
    protected Boolean TestObjectRenew(PSCtrlLogicGroup obj) {
        return false;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    protected Vector<PSCtrlLogicGroup> getAllModels() throws Exception {
        Vector<PSCtrlLogicGroup> psCtrlLogicGroupList = new Vector<PSCtrlLogicGroup>();
        CallResult callResult = this.iPSModelHelper.getPSCtrlLogicGroups(this.getPSDataEntity().getId(), psCtrlLogicGroupList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psCtrlLogicGroupList;
    }

    @Override
    protected IPSAppDEUILogicGroup registerModel(PSCtrlLogicGroup vt) throws Exception {
        IPSAppDEUILogicGroup iPSCtrlLogicGroup = (IPSAppDEUILogicGroup)this.InternalGetModelHelper(vt.getPSCTRLLOGICGROUPID());
        if (iPSCtrlLogicGroup != null) {
            return iPSCtrlLogicGroup;
        }
        this.setModel(vt.getPSCTRLLOGICGROUPID(), vt, null);
        return (IPSAppDEUILogicGroup)this.FindModelHelper(vt.getPSCTRLLOGICGROUPID());
    }

    @Override
    protected String getObjectId(PSCtrlLogicGroup vt) {
        return vt.getPSCTRLLOGICGROUPID();
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSDataEntityException.create(this.getPSDataEntity(), 20029, objObjectId);
    }
}

