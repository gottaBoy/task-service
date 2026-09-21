/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityException;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Data.PSDEAction;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEActionGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEAction, IPSDEAction> {
    private static final Log log = LogFactory.getLog(PSDEActionGlobalModel.class);

    @Override
    protected PSDEAction GetObject(String strPSDEActionId) {
        return null;
    }

    @Override
    protected IPSDEAction OnCreateModelHelper(PSDEAction vt, String objObjectId) throws Exception {
        IPSDEAction iPSDEAction = this.iPSModelStorage.getPSDEActionType(vt.getACTIONTYPE()).createPSDEAction(vt);
        this.setModel(objObjectId, vt, iPSDEAction);
        iPSDEAction.init(this.iDAGlobalHelper, this.getPSDataEntity(), vt);
        return iPSDEAction;
    }

    @Override
    protected IPSDEAction OnCreateModelHelper(PSDEAction vt) throws Exception {
        IPSDEAction iPSDEAction = this.iPSModelStorage.getPSDEActionType(vt.getACTIONTYPE()).createPSDEAction(vt);
        iPSDEAction.init(this.iDAGlobalHelper, this.getPSDataEntity(), vt);
        return iPSDEAction;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEAction obj) {
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
    protected IPSDEAction registerModel(PSDEAction vt) throws Exception {
        IPSDEAction iPSDEAction = (IPSDEAction)this.InternalGetModelHelper(vt.getPSDEACTIONID());
        if (iPSDEAction != null) {
            return iPSDEAction;
        }
        this.setModel(vt.getPSDEACTIONID(), vt, null);
        iPSDEAction = (IPSDEAction)this.FindModelHelper(vt.getPSDEACTIONID());
        return iPSDEAction;
    }

    @Override
    protected Vector<PSDEAction> getAllModels() throws Exception {
        Vector<PSDEAction> psDEActionList = new Vector<PSDEAction>();
        CallResult callResult = this.iPSModelHelper.getPSDEActions(this.getPSDataEntity().getId(), psDEActionList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5168\u90e8\u5b9e\u4f53\u884c\u4e3a\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEActionList;
    }

    @Override
    protected String getObjectId(PSDEAction vt) {
        return vt.getPSDEACTIONID();
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSDataEntityException.create(this.getPSDataEntity(), 20001, objObjectId);
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSDEAction vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getPSDEACTIONNAME())) {
            return new String[]{vt.getPSDEACTIONNAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

