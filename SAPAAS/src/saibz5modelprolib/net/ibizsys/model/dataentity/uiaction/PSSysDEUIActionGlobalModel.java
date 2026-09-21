/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.uiaction.IPSDEUIAction
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.uiaction;

import java.util.Vector;
import net.ibizsys.model.PSSystemGlobalModelBase;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIAction;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIActionRuntime;
import net.ibizsys.model.dataentity.uiaction.PSDEUIActionImpl;
import net.ibizsys.model.entity.PSDEUIAction;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysDEUIActionGlobalModel
extends PSSystemGlobalModelBase<String, PSDEUIAction, IPSDEUIAction> {
    private static final Log log = LogFactory.getLog(PSSysDEUIActionGlobalModel.class);

    @Override
    protected PSDEUIAction getObject(String strPSDEUIActionId) {
        return null;
    }

    @Override
    protected IPSDEUIAction onCreateModelHelper(PSDEUIAction vt) throws Exception {
        PSDEUIActionImpl iPSDEUIAction = null;
        String strItemObj = vt.getITEMOBJ();
        if (StringHelper.isNullOrEmpty((String)strItemObj)) {
            strItemObj = vt.getSYSITEMOBJ();
        }
        iPSDEUIAction = StringHelper.isNullOrEmpty((String)strItemObj) ? new PSDEUIActionImpl() : (IPSDEUIAction)this.getPSModelStorageContext().createObject(strItemObj);
        if (StringHelper.isNullOrEmpty((String)vt.getPSDEID())) {
            ((IPSDEUIActionRuntime)iPSDEUIAction).init(this.getPSModelStorageContext(), this.getPSSystem(), null, vt);
        } else {
            iPSDEUIAction = this.getPSSystem().getPSDataEntity(vt.getPSDEID()).getPSDEUIAction(vt.getPSDEUIACTIONID());
        }
        return iPSDEUIAction;
    }

    @Override
    protected Boolean testObjectRenew(PSDEUIAction obj) {
        return false;
    }

    @Override
    protected Vector<PSDEUIAction> getAllModels() throws Exception {
        Vector<PSDEUIAction> psDEUIActionList = new Vector<PSDEUIAction>();
        CallResult callResult = this.getPSModelQueryHelper().getPSSysDEUIActions(this.getPSSystem().getId(), psDEUIActionList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u53d1\u751f\u9519\u8bef\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
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
    protected IPSDEUIAction registerModel(PSDEUIAction vt) throws Exception {
        IPSDEUIAction iPSDEUIAction = (IPSDEUIAction)this.internalGetModelHelper(vt.getPSDEUIACTIONID());
        if (iPSDEUIAction != null) {
            return iPSDEUIAction;
        }
        this.setModel(vt.getPSDEUIACTIONID(), vt, null);
        return (IPSDEUIAction)this.findModelHelper(vt.getPSDEUIACTIONID());
    }

    @Override
    protected String getObjectId(PSDEUIAction vt) {
        return vt.getPSDEUIACTIONID();
    }
}

