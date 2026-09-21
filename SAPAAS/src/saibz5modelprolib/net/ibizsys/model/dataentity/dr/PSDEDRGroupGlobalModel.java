/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.dr.IPSDEDRGroup
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.dr;

import java.util.Vector;
import net.ibizsys.model.dataentity.PSDataEntityGlobalModelBase;
import net.ibizsys.model.dataentity.dr.IPSDEDRGroup;
import net.ibizsys.model.dataentity.dr.PSDEDRGroupImpl;
import net.ibizsys.model.entity.PSDEDRGroup;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDRGroupGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEDRGroup, IPSDEDRGroup> {
    private static final Log log = LogFactory.getLog(PSDEDRGroupGlobalModel.class);

    @Override
    protected PSDEDRGroup getObject(String strPSDEDRGroupId) {
        log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5b9e\u4f53\u5b9e\u4f53\u5173\u7cfb\u5206\u7ec4[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEDRGroupId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEDRGroup onCreateModelHelper(PSDEDRGroup vt) throws Exception {
        PSDEDRGroupImpl iPSDEDRGroup = new PSDEDRGroupImpl();
        iPSDEDRGroup.init(this.getPSModelStorageContext(), this.getPSDataEntity(), vt);
        return iPSDEDRGroup;
    }

    @Override
    protected Boolean testObjectRenew(PSDEDRGroup obj) {
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
    protected Vector<PSDEDRGroup> getAllModels() throws Exception {
        Vector<PSDEDRGroup> psDEDRGroup = new Vector<PSDEDRGroup>();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEDRGroups(this.getPSDataEntity().getId(), psDEDRGroup);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5b9e\u4f53\u5b9e\u4f53\u5173\u7cfb\u5206\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEDRGroup;
    }

    @Override
    protected IPSDEDRGroup registerModel(PSDEDRGroup vt) throws Exception {
        IPSDEDRGroup iPSDEDRGroup = (IPSDEDRGroup)this.internalGetModelHelper(vt.getPSDEDRGROUPID());
        if (iPSDEDRGroup != null) {
            return iPSDEDRGroup;
        }
        this.setModel(vt.getPSDEDRGROUPID(), vt, null);
        return (IPSDEDRGroup)this.findModelHelper(vt.getPSDEDRGROUPID());
    }

    @Override
    protected String getObjectId(PSDEDRGroup vt) {
        return vt.getPSDEDRGROUPID();
    }

    @Override
    protected String getModelInfo() {
        return StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5173\u7cfb\u754c\u9762\u5206\u7ec4", (Object)this.getPSDataEntity().getName());
    }
}

