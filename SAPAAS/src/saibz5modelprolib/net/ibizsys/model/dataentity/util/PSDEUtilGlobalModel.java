/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.util.IPSDEUtil
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.util;

import java.util.Vector;
import net.ibizsys.model.dataentity.PSDataEntityGlobalModelBase;
import net.ibizsys.model.dataentity.util.IPSDEUtil;
import net.ibizsys.model.dataentity.util.PSDEUtilImpl;
import net.ibizsys.model.entity.PSDEUtil;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEUtilGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEUtil, IPSDEUtil> {
    private static final Log log = LogFactory.getLog(PSDEUtilGlobalModel.class);

    @Override
    protected PSDEUtil getObject(String strPSDEUtilId) {
        return null;
    }

    @Override
    protected IPSDEUtil onCreateModelHelper(PSDEUtil vt) throws Exception {
        PSDEUtilImpl iPSDEUtil = new PSDEUtilImpl();
        iPSDEUtil.init(this.getPSModelStorageContext(), this.getPSDataEntity(), vt);
        return iPSDEUtil;
    }

    @Override
    protected Boolean testObjectRenew(PSDEUtil obj) {
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
    protected Vector<PSDEUtil> getAllModels() throws Exception {
        Vector<PSDEUtil> psDEUtil = new Vector<PSDEUtil>();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEUtils(this.getPSDataEntity().getId(), psDEUtil);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5168\u90e8\u5b9e\u4f53\u8f85\u52a9\u529f\u80fd\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEUtil;
    }

    @Override
    protected IPSDEUtil registerModel(PSDEUtil vt) throws Exception {
        IPSDEUtil iPSDEUtil = (IPSDEUtil)this.internalGetModelHelper(vt.getPSDEUTILDEID());
        if (iPSDEUtil != null) {
            return iPSDEUtil;
        }
        this.setModel(vt.getPSDEUTILDEID(), vt, null);
        this.setModel(vt.getUTILTYPE(), vt, null);
        return (IPSDEUtil)this.findModelHelper(vt.getPSDEUTILDEID());
    }

    @Override
    protected String getObjectId(PSDEUtil vt) {
        return vt.getPSDEUTILDEID();
    }
}

