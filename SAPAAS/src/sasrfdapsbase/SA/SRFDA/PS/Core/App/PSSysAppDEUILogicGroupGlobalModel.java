/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroup;
import SA.SRFDA.PS.Core.App.PSApplicationGlobalModelBase;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSSysDEUILogicGroupImpl;
import SA.SRFDA.PS.Data.PSCtrlLogicGroup;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysAppDEUILogicGroupGlobalModel
extends PSApplicationGlobalModelBase<String, PSCtrlLogicGroup, IPSAppDEUILogicGroup> {
    private static final Log log = LogFactory.getLog(PSSysAppDEUILogicGroupGlobalModel.class);

    @Override
    protected PSCtrlLogicGroup GetObject(String strPSCtrlLogicGroupId) {
        return null;
    }

    @Override
    protected IPSAppDEUILogicGroup OnCreateModelHelper(PSCtrlLogicGroup vt) throws Exception {
        PSSysDEUILogicGroupImpl iPSCtrlLogicGroup = new PSSysDEUILogicGroupImpl();
        iPSCtrlLogicGroup.init(this.iDAGlobalHelper, this.getPSApplication(), vt);
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
        CallResult callResult = this.iPSModelHelper.getPSSysCtrlLogicGroups(this.getPSApplication().getPSSystem().getId(), psCtrlLogicGroupList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5168\u5c40\u754c\u9762\u903b\u8f91\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
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
}

