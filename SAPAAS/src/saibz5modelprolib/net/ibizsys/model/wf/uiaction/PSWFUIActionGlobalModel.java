/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWFVersion
 *  net.ibizsys.model.wf.uiaction.IPSWFUIAction
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.wf.uiaction;

import java.util.Vector;
import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSGlobalModelBase;
import net.ibizsys.model.entity.PSDEUIAction;
import net.ibizsys.model.wf.IPSWFVersion;
import net.ibizsys.model.wf.uiaction.IPSWFUIAction;
import net.ibizsys.model.wf.uiaction.IPSWFUIActionRuntime;
import net.ibizsys.model.wf.uiaction.PSWFUIActionImpl;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWFUIActionGlobalModel
extends PSGlobalModelBase<String, PSDEUIAction, IPSWFUIAction> {
    private static final Log log = LogFactory.getLog(PSWFUIActionGlobalModel.class);
    protected IPSWFVersion iPSWFVersion = null;

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSWFVersion iPSWFVersion) throws Exception {
        this.iPSWFVersion = iPSWFVersion;
        super.init(iPSModelStorageContext);
    }

    @Override
    protected PSDEUIAction getObject(String strPSDEUIActionId) {
        log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u6d41\u7a0b\u754c\u9762\u884c\u4e3a[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEUIActionId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSWFUIAction onCreateModelHelper(PSDEUIAction vt) throws Exception {
        PSWFUIActionImpl iPSWFUIAction = null;
        String strItemObj = vt.getITEMOBJ();
        if (StringHelper.isNullOrEmpty((String)strItemObj)) {
            strItemObj = vt.getSYSITEMOBJ();
        }
        iPSWFUIAction = StringHelper.isNullOrEmpty((String)strItemObj) ? new PSWFUIActionImpl() : (IPSWFUIAction)this.getPSModelStorageContext().createObject(strItemObj);
        ((IPSWFUIActionRuntime)iPSWFUIAction).init(this.getPSModelStorageContext(), this.iPSWFVersion, vt);
        return iPSWFUIAction;
    }

    @Override
    protected Boolean testObjectRenew(PSDEUIAction obj) {
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
        CallResult callResult = this.getPSModelQueryHelper().getPSWFUIActions(this.iPSWFVersion.getId(), psDEUIActionList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5168\u90e8\u6d41\u7a0b\u754c\u9762\u884c\u4e3a\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEUIActionList;
    }

    @Override
    protected IPSWFUIAction registerModel(PSDEUIAction vt) throws Exception {
        IPSWFUIAction iPSWFUIAction = (IPSWFUIAction)this.internalGetModelHelper(vt.getPSDEUIACTIONID());
        if (iPSWFUIAction != null) {
            return iPSWFUIAction;
        }
        this.setModel(vt.getPSDEUIACTIONID(), vt, null);
        return (IPSWFUIAction)this.findModelHelper(vt.getPSDEUIACTIONID());
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.iPSWFVersion).getPSSysModelInstId();
    }

    @Override
    protected String getObjectId(PSDEUIAction vt) {
        return vt.getPSDEUIACTIONID();
    }

    @Override
    public String getPSDynaInstId() {
        if (this.iPSWFVersion != null) {
            return ((IPSModelObjectRuntime)this.iPSWFVersion).getPSDynaInstId();
        }
        return super.getPSDynaInstId();
    }
}

