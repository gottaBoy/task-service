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

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIActionGroup;
import SA.SRFDA.PS.Core.App.PSApplicationGlobalModelBase;
import SA.SRFDA.PS.Core.DataEntity.UIAction.PSDEUIActionGroupImpl;
import SA.SRFDA.PS.Data.PSAppLocalDE;
import SA.SRFDA.PS.Data.PSDEUIActionGroup;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysAppDEUIActionGroupGlobalModel
extends PSApplicationGlobalModelBase<String, PSDEUIActionGroup, IPSAppDEUIActionGroup> {
    private static final Log log = LogFactory.getLog(PSSysAppDEUIActionGroupGlobalModel.class);

    @Override
    protected PSDEUIActionGroup GetObject(String strPSDEUIActionGroupId) {
        return null;
    }

    @Override
    protected IPSAppDEUIActionGroup OnCreateModelHelper(PSDEUIActionGroup vt) throws Exception {
        PSDEUIActionGroupImpl iPSDEUIActionGroup = new PSDEUIActionGroupImpl();
        iPSDEUIActionGroup.init(this.iDAGlobalHelper, this.getPSApplication(), null, vt);
        return iPSDEUIActionGroup;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEUIActionGroup obj) {
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
    protected String getObjectId(PSDEUIActionGroup vt) {
        return vt.getPSDEUAGROUPID();
    }

    @Override
    protected Vector<PSDEUIActionGroup> getAllModels() throws Exception {
        Vector<PSAppLocalDE> list = new Vector<PSAppLocalDE>();
        CallResult callResult = this.iPSModelHelper.getAllPSAppLocalDEs(this.iPSApplication.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u5168\u90e8\u5e94\u7528\u5b9e\u4f53\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        Vector<PSDEUIActionGroup> psDEUIActionGroupList2 = new Vector<PSDEUIActionGroup>();
        callResult = this.iPSModelHelper.getPSSysDEUIActionGroups(this.getPSApplication().getPSSystem().getId(), psDEUIActionGroupList2);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u7ec4\u53d1\u751f\u9519\u8bef\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSAppLocalDE> psAppLocalDEMap = new HashMap<String, PSAppLocalDE>();
        for (PSAppLocalDE psAppLocalDE : list) {
            psAppLocalDEMap.put(psAppLocalDE.getPSDEID(), psAppLocalDE);
        }
        Vector<PSDEUIActionGroup> psDEUIActionGroupList = new Vector<PSDEUIActionGroup>();
        for (PSDEUIActionGroup psDEUIActionGroup : psDEUIActionGroupList2) {
            if (!StringHelper.IsNullOrEmpty((String)psDEUIActionGroup.getPSDEID()) && !psAppLocalDEMap.containsKey(psDEUIActionGroup.getPSDEID())) continue;
            psDEUIActionGroupList.add(psDEUIActionGroup);
        }
        return psDEUIActionGroupList;
    }

    @Override
    protected IPSAppDEUIActionGroup registerModel(PSDEUIActionGroup vt) throws Exception {
        IPSAppDEUIActionGroup iPSDEUIActionGroup = (IPSAppDEUIActionGroup)this.InternalGetModelHelper(vt.getPSDEUAGROUPID());
        if (iPSDEUIActionGroup != null) {
            return iPSDEUIActionGroup;
        }
        this.setModel(vt.getPSDEUAGROUPID(), vt, null);
        return (IPSAppDEUIActionGroup)this.FindModelHelper(vt.getPSDEUAGROUPID());
    }
}

