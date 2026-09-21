/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicGroup;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDEUILogicGroupImpl;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityException;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSCtrlLogicGroup;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDEUILogicGroupGlobalModel
extends PSDataEntityGlobalModelBase<String, PSCtrlLogicGroup, IPSDEUILogicGroup> {
    private static final Log log = LogFactory.getLog(PSDEUILogicGroupGlobalModel.class);

    @Override
    protected PSCtrlLogicGroup GetObject(String strPSCtrlLogicGroupId) {
        return null;
    }

    @Override
    protected IPSDEUILogicGroup OnCreateModelHelper(PSCtrlLogicGroup vt) throws Exception {
        PSDEUILogicGroupImpl iPSCtrlLogicGroup = new PSDEUILogicGroupImpl();
        iPSCtrlLogicGroup.init(this.iDAGlobalHelper, this.getPSDataEntity(), vt);
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
    protected IPSDEUILogicGroup registerModel(PSCtrlLogicGroup vt) throws Exception {
        IPSDEUILogicGroup iPSCtrlLogicGroup = (IPSDEUILogicGroup)this.InternalGetModelHelper(vt.getPSCTRLLOGICGROUPID());
        if (iPSCtrlLogicGroup != null) {
            return iPSCtrlLogicGroup;
        }
        this.setModel(vt.getPSCTRLLOGICGROUPID(), vt, null);
        return (IPSDEUILogicGroup)this.FindModelHelper(vt.getPSCTRLLOGICGROUPID());
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

