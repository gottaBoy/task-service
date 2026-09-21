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
package SA.SRFDA.PS.Core.DataEntity.UIAction;

import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.DataEntity.UIAction.PSDEUIActionImpl;
import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Data.PSDEUIAction;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysDEUIActionGlobalModel
extends PSSystemGlobalModelBase<String, PSDEUIAction, IPSDEUIAction> {
    private static final Log log = LogFactory.getLog(PSSysDEUIActionGlobalModel.class);

    @Override
    protected PSDEUIAction GetObject(String strPSDEUIActionId) {
        return null;
    }

    @Override
    protected IPSDEUIAction OnCreateModelHelper(PSDEUIAction vt) throws Exception {
        IPSDEUIAction iPSDEUIAction = null;
        String strItemObj = vt.getITEMOBJ();
        if (StringHelper.IsNullOrEmpty((String)strItemObj)) {
            strItemObj = vt.getSYSITEMOBJ();
        }
        iPSDEUIAction = StringHelper.IsNullOrEmpty((String)strItemObj) ? new PSDEUIActionImpl() : (IPSDEUIAction)ObjectHelper.Create((String)strItemObj);
        if (StringHelper.IsNullOrEmpty((String)vt.getPSDEID())) {
            iPSDEUIAction.init(this.iDAGlobalHelper, this.getPSSystem(), null, vt);
        } else {
            iPSDEUIAction = this.getPSSystem().getPSDataEntity2(vt.getPSDEID()).getPSDEUIAction(vt.getPSDEUIACTIONID());
        }
        return iPSDEUIAction;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEUIAction obj) {
        return false;
    }

    @Override
    protected Vector<PSDEUIAction> getAllModels() throws Exception {
        Vector<PSDEUIAction> psDEUIActionList = new Vector<PSDEUIAction>();
        CallResult callResult = this.iPSModelHelper.getPSSysDEUIActions(this.getPSSystem().getId(), psDEUIActionList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u53d1\u751f\u9519\u8bef\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEUIActionList;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        try {
            this.getAllModelHelperCount();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    protected IPSDEUIAction registerModel(PSDEUIAction vt) throws Exception {
        IPSDEUIAction iPSDEUIAction = (IPSDEUIAction)this.InternalGetModelHelper(vt.getPSDEUIACTIONID());
        if (iPSDEUIAction != null) {
            return iPSDEUIAction;
        }
        this.setModel(vt.getPSDEUIACTIONID(), vt, null);
        return (IPSDEUIAction)this.FindModelHelper(vt.getPSDEUIACTIONID());
    }

    @Override
    protected String getObjectId(PSDEUIAction vt) {
        return vt.getPSDEUIACTIONID();
    }
}

