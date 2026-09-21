/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.uiaction.IPSDEUIActionGroup
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.uiaction;

import java.util.Vector;
import net.ibizsys.model.dataentity.PSDataEntityException;
import net.ibizsys.model.dataentity.PSDataEntityGlobalModelBase;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIActionGroup;
import net.ibizsys.model.dataentity.uiaction.PSDEUIActionGroupImpl;
import net.ibizsys.model.entity.PSDEUIActionGroup;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEUIActionGroupGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEUIActionGroup, IPSDEUIActionGroup> {
    private static final Log log = LogFactory.getLog(PSDEUIActionGroupGlobalModel.class);

    @Override
    protected PSDEUIActionGroup getObject(String strPSDEUIActionGroupId) {
        return null;
    }

    @Override
    protected IPSDEUIActionGroup onCreateModelHelper(PSDEUIActionGroup vt) throws Exception {
        PSDEUIActionGroupImpl iPSDEUIActionGroup = new PSDEUIActionGroupImpl();
        iPSDEUIActionGroup.init(this.getPSModelStorageContext(), this.getPSDataEntity().getPSSystem(), this.getPSDataEntity(), vt);
        return iPSDEUIActionGroup;
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
        CallResult callResult = this.getPSModelQueryHelper().getPSDEUIActionGroups(this.getPSDataEntity().getId(), psDEUIActionGroupList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEUIActionGroupList;
    }

    @Override
    protected IPSDEUIActionGroup registerModel(PSDEUIActionGroup vt) throws Exception {
        IPSDEUIActionGroup iPSDEUIActionGroup = (IPSDEUIActionGroup)this.internalGetModelHelper(vt.getPSDEUAGROUPID());
        if (iPSDEUIActionGroup != null) {
            return iPSDEUIActionGroup;
        }
        this.setModel(vt.getPSDEUAGROUPID(), vt, null);
        return (IPSDEUIActionGroup)this.findModelHelper(vt.getPSDEUAGROUPID());
    }

    @Override
    protected String getObjectId(PSDEUIActionGroup vt) {
        return vt.getPSDEUAGROUPID();
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSDataEntityException.create(this.getPSDataEntity(), 20002, objObjectId);
    }
}

