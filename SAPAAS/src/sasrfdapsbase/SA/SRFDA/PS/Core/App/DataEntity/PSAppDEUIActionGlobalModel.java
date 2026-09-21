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
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIAction;
import SA.SRFDA.PS.Core.App.DataEntity.PSAppDataEntityGlobalModelBase;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityException;
import SA.SRFDA.PS.Core.DataEntity.UIAction.PSDEUIActionImpl;
import SA.SRFDA.PS.Data.PSDEUIAction;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppDEUIActionGlobalModel
extends PSAppDataEntityGlobalModelBase<String, PSDEUIAction, IPSAppDEUIAction> {
    private static final Log log = LogFactory.getLog(PSAppDEUIActionGlobalModel.class);

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
        iPSDEUIAction = StringHelper.IsNullOrEmpty((String)strItemObj) ? new PSDEUIActionImpl() : (IPSAppDEUIAction)ObjectHelper.Create((String)strItemObj);
        iPSDEUIAction.init(this.iDAGlobalHelper, this.getPSAppDataEntity().getPSApplication(), this.getPSAppDataEntity(), vt);
        return iPSDEUIAction;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEUIAction obj) {
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
    protected Vector<PSDEUIAction> getAllModels() throws Exception {
        Vector<PSDEUIAction> psDEUIActionList = new Vector<PSDEUIAction>();
        CallResult callResult = this.iPSModelHelper.getPSDEUIActions(this.getPSDataEntity().getId(), psDEUIActionList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5168\u90e8\u754c\u9762\u884c\u4e3a\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEUIAction psDEUIAction : psDEUIActionList) {
            this.setModel(psDEUIAction.getPSDEUIACTIONID(), psDEUIAction, null);
        }
        return psDEUIActionList;
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

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSDataEntityException.create(this.getPSDataEntity(), 20002, objObjectId);
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSDEUIAction vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

