/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIAction;
import SA.SRFDA.PS.Core.App.PSApplicationGlobalModelBase;
import SA.SRFDA.PS.Core.DataEntity.UIAction.PSDEUIActionImpl;
import SA.SRFDA.PS.Data.PSAppLocalDE;
import SA.SRFDA.PS.Data.PSDEUIAction;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.HashMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysAppDEUIActionGlobalModel
extends PSApplicationGlobalModelBase<String, PSDEUIAction, IPSAppDEUIAction> {
    private static final Log log = LogFactory.getLog(PSSysAppDEUIActionGlobalModel.class);

    @Override
    protected PSDEUIAction GetObject(String strPSDEUIActionId) {
        return null;
    }

    @Override
    protected IPSAppDEUIAction OnCreateModelHelper(PSDEUIAction vt) throws Exception {
        IPSAppDEUIAction iPSDEUIAction = null;
        String strItemObj = vt.getITEMOBJ();
        if (StringHelper.IsNullOrEmpty((String)strItemObj)) {
            strItemObj = vt.getSYSITEMOBJ();
        }
        if (StringHelper.IsNullOrEmpty((String)vt.getPSDEID())) {
            iPSDEUIAction = StringHelper.IsNullOrEmpty((String)strItemObj) ? new PSDEUIActionImpl() : (IPSAppDEUIAction)ObjectHelper.Create((String)strItemObj);
            iPSDEUIAction.init(this.iDAGlobalHelper, this.getPSApplication(), null, vt);
        } else {
            iPSDEUIAction = this.getPSApplication().getPSAppDataEntityByDEId(vt.getPSDEID(), false).getPSAppDEUIAction2(vt.getPSDEUIACTIONID(), false);
        }
        return iPSDEUIAction;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEUIAction obj) {
        return false;
    }

    @Override
    protected Vector<PSDEUIAction> getAllModels() throws Exception {
        Vector<PSAppLocalDE> list = new Vector<PSAppLocalDE>();
        CallResult callResult = this.iPSModelHelper.getAllPSAppLocalDEs(this.iPSApplication.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u5168\u90e8\u5e94\u7528\u5b9e\u4f53\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        Vector<PSDEUIAction> psDEUIActionList2 = new Vector<PSDEUIAction>();
        callResult = this.iPSModelHelper.getPSSysDEUIActions(this.getPSApplication().getPSSystem().getId(), psDEUIActionList2);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u53d1\u751f\u9519\u8bef\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSAppLocalDE> psAppLocalDEMap = new HashMap<String, PSAppLocalDE>();
        for (PSAppLocalDE psAppLocalDE : list) {
            psAppLocalDEMap.put(psAppLocalDE.getPSDEID(), psAppLocalDE);
        }
        Vector<PSDEUIAction> psDEUIActionList = new Vector<PSDEUIAction>();
        for (PSDEUIAction psDEUIAction : psDEUIActionList2) {
            if (!StringHelper.IsNullOrEmpty((String)psDEUIAction.getPSDEID()) && !psAppLocalDEMap.containsKey(psDEUIAction.getPSDEID())) continue;
            psDEUIActionList.add(psDEUIAction);
        }
        return psDEUIActionList;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        try {
            this.getAllModelHelperCount();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    protected IPSAppDEUIAction registerModel(PSDEUIAction vt) throws Exception {
        IPSAppDEUIAction iPSDEUIAction = (IPSAppDEUIAction)this.InternalGetModelHelper(vt.getPSDEUIACTIONID());
        if (iPSDEUIAction != null) {
            return iPSDEUIAction;
        }
        this.setModel(vt.getPSDEUIACTIONID(), vt, null);
        return (IPSAppDEUIAction)this.FindModelHelper(vt.getPSDEUIACTIONID());
    }

    @Override
    protected String getObjectId(PSDEUIAction vt) {
        return vt.getPSDEUIACTIONID();
    }
}

