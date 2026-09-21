/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.ac.IPSDEACMode
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.ac;

import java.util.Vector;
import net.ibizsys.model.dataentity.PSDataEntityException;
import net.ibizsys.model.dataentity.PSDataEntityGlobalModelBase;
import net.ibizsys.model.dataentity.ac.IPSDEACMode;
import net.ibizsys.model.dataentity.ac.PSDEACModeImpl;
import net.ibizsys.model.entity.PSDEACMode;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEACModeGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEACMode, IPSDEACMode> {
    private static final Log log = LogFactory.getLog(PSDEACModeGlobalModel.class);

    @Override
    protected PSDEACMode getObject(String strPSDEACModeId) {
        log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEACModeId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEACMode onCreateModelHelper(PSDEACMode vt) throws Exception {
        PSDEACModeImpl iPSDEACMode = new PSDEACModeImpl();
        iPSDEACMode.init(this.getPSModelStorageContext(), this.getPSDataEntity(), vt);
        return iPSDEACMode;
    }

    @Override
    protected Boolean testObjectRenew(PSDEACMode obj) {
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
    protected IPSDEACMode registerModel(PSDEACMode vt) throws Exception {
        IPSDEACMode iPSDEACMode = (IPSDEACMode)this.internalGetModelHelper(vt.getPSDEACMODEID());
        if (iPSDEACMode != null) {
            return iPSDEACMode;
        }
        this.setModel(vt.getPSDEACMODEID(), vt, null);
        iPSDEACMode = (IPSDEACMode)this.findModelHelper(vt.getPSDEACMODEID());
        return iPSDEACMode;
    }

    @Override
    protected Vector<PSDEACMode> getAllModels() throws Exception {
        Vector<PSDEACMode> psDEACModeList = new Vector<PSDEACMode>();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEACModes(this.getPSDataEntity().getId(), psDEACModeList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5168\u90e8\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEACModeList;
    }

    @Override
    protected String getObjectId(PSDEACMode vt) {
        return vt.getPSDEACMODEID();
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSDataEntityException.create(this.getPSDataEntity(), 20003, objObjectId);
    }
}

