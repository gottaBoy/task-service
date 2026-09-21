/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.action.IPSDEAction
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.action;

import java.util.Vector;
import net.ibizsys.model.dataentity.PSDataEntityException;
import net.ibizsys.model.dataentity.PSDataEntityGlobalModelBase;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.action.IPSDEActionRuntime;
import net.ibizsys.model.entity.PSDEAction;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEActionGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEAction, IPSDEAction> {
    private static final Log log = LogFactory.getLog(PSDEActionGlobalModel.class);

    @Override
    protected PSDEAction getObject(String strPSDEActionId) {
        return null;
    }

    @Override
    protected IPSDEAction onCreateModelHelper(PSDEAction vt, String objObjectId) throws Exception {
        IPSDEAction iPSDEAction = this.getPSModelStorageContext().getPSDEActionType(vt.getACTIONTYPE()).createPSDEAction(vt);
        this.setModel(objObjectId, vt, iPSDEAction);
        ((IPSDEActionRuntime)iPSDEAction).init(this.getPSModelStorageContext(), this.getPSDataEntity(), vt);
        return iPSDEAction;
    }

    @Override
    protected IPSDEAction onCreateModelHelper(PSDEAction vt) throws Exception {
        IPSDEAction iPSDEAction = this.getPSModelStorageContext().getPSDEActionType(vt.getACTIONTYPE()).createPSDEAction(vt);
        ((IPSDEActionRuntime)iPSDEAction).init(this.getPSModelStorageContext(), this.getPSDataEntity(), vt);
        return iPSDEAction;
    }

    @Override
    protected Boolean testObjectRenew(PSDEAction obj) {
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
        IPSDEAction iPSDEAction = (IPSDEAction)this.internalGetModelHelper(vt.getPSDEACTIONID());
        if (iPSDEAction != null) {
            return iPSDEAction;
        }
        this.setModel(vt.getPSDEACTIONID(), vt, null);
        iPSDEAction = (IPSDEAction)this.findModelHelper(vt.getPSDEACTIONID());
        this.setModel(vt.getPSDEACTIONNAME().toUpperCase(), vt, iPSDEAction);
        return iPSDEAction;
    }

    @Override
    protected Vector<PSDEAction> getAllModels() throws Exception {
        Vector<PSDEAction> psDEActionList = new Vector<PSDEAction>();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEActions(this.getPSDataEntity().getId(), psDEActionList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5168\u90e8\u5b9e\u4f53\u884c\u4e3a\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEAction psDEAction : psDEActionList) {
            this.setModel(psDEAction.getPSDEACTIONID(), psDEAction, null);
            this.setModel(psDEAction.getPSDEACTIONNAME().toUpperCase(), psDEAction, null);
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
}

