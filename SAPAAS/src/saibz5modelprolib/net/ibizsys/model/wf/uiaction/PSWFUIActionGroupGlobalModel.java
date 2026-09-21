/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWFVersion
 *  net.ibizsys.model.wf.uiaction.IPSWFUIActionGroup
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
import net.ibizsys.model.entity.PSDEUIActionGroup;
import net.ibizsys.model.wf.IPSWFVersion;
import net.ibizsys.model.wf.uiaction.IPSWFUIActionGroup;
import net.ibizsys.model.wf.uiaction.PSWFUIActionGroupImpl;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWFUIActionGroupGlobalModel
extends PSGlobalModelBase<String, PSDEUIActionGroup, IPSWFUIActionGroup> {
    private static final Log log = LogFactory.getLog(PSWFUIActionGroupGlobalModel.class);
    protected IPSWFVersion iPSWFVersion = null;

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSWFVersion iPSWFVersion) throws Exception {
        this.iPSWFVersion = iPSWFVersion;
        super.init(iPSModelStorageContext);
    }

    @Override
    protected PSDEUIActionGroup getObject(String strPSDEUIActionGroupId) {
        log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u6d41\u7a0b\u754c\u9762\u884c\u4e3a\u7ec4[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEUIActionGroupId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSWFUIActionGroup onCreateModelHelper(PSDEUIActionGroup vt) throws Exception {
        PSWFUIActionGroupImpl iPSWFUIActionGroup = new PSWFUIActionGroupImpl();
        iPSWFUIActionGroup.init(this.getPSModelStorageContext(), this.iPSWFVersion, vt);
        return iPSWFUIActionGroup;
    }

    @Override
    protected Boolean testObjectRenew(PSDEUIActionGroup obj) {
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
    protected Vector<PSDEUIActionGroup> getAllModels() throws Exception {
        Vector<PSDEUIActionGroup> psDEUIActionGroupList = new Vector<PSDEUIActionGroup>();
        CallResult callResult = this.getPSModelQueryHelper().getPSWFUIActionGroups(this.iPSWFVersion.getId(), psDEUIActionGroupList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u6d41\u7a0b\u754c\u9762\u884c\u4e3a\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEUIActionGroupList;
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.iPSWFVersion).getPSSysModelInstId();
    }

    @Override
    protected String getObjectId(PSDEUIActionGroup vt) {
        return vt.getPSDEUAGROUPID();
    }

    @Override
    protected IPSWFUIActionGroup registerModel(PSDEUIActionGroup vt) throws Exception {
        IPSWFUIActionGroup iPSWFUIActionGroup = (IPSWFUIActionGroup)this.internalGetModelHelper(vt.getPSDEUAGROUPID());
        if (iPSWFUIActionGroup != null) {
            return iPSWFUIActionGroup;
        }
        this.setModel(vt.getPSDEUAGROUPID(), vt, null);
        return (IPSWFUIActionGroup)this.findModelHelper(vt.getPSDEUAGROUPID());
    }

    @Override
    public String getPSDynaInstId() {
        if (this.iPSWFVersion != null) {
            return ((IPSModelObjectRuntime)this.iPSWFVersion).getPSDynaInstId();
        }
        return super.getPSDynaInstId();
    }
}

