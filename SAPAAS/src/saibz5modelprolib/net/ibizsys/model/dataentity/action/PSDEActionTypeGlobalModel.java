/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.action;

import net.ibizsys.model.PSGlobalModelBase;
import net.ibizsys.model.dataentity.action.IPSDEActionType;
import net.ibizsys.model.dataentity.action.PSDEActionTypeImpl;
import net.ibizsys.model.entity.PSDEActionType;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEActionTypeGlobalModel
extends PSGlobalModelBase<String, PSDEActionType, IPSDEActionType> {
    private static final Log log = LogFactory.getLog(PSDEActionTypeGlobalModel.class);

    @Override
    protected PSDEActionType getObject(String strPSDEActionTypeId) {
        PSDEActionType psDEActionType = new PSDEActionType();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEActionType(strPSDEActionTypeId, psDEActionType);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5b9e\u4f53\u884c\u4e3a\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEActionTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psDEActionType;
    }

    @Override
    protected IPSDEActionType onCreateModelHelper(PSDEActionType vt) throws Exception {
        PSDEActionTypeImpl iPSDEActionType = new PSDEActionTypeImpl();
        iPSDEActionType.init(this.getPSModelStorageContext(), vt);
        return iPSDEActionType;
    }

    @Override
    protected Boolean testObjectRenew(PSDEActionType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSDEActionType vt) {
        return vt.getPSDEACTIONTYPEID();
    }
}

