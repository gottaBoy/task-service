/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.uiaction;

import net.ibizsys.model.PSGlobalModelBase;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIActionType;
import net.ibizsys.model.dataentity.uiaction.PSDEUIActionTypeImpl;
import net.ibizsys.model.entity.PSDEUIActionType;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEUIActionTypeGlobalModel
extends PSGlobalModelBase<String, PSDEUIActionType, IPSDEUIActionType> {
    private static final Log log = LogFactory.getLog(PSDEUIActionTypeGlobalModel.class);

    @Override
    protected PSDEUIActionType getObject(String strPSDEUIActionTypeId) {
        PSDEUIActionType psDEUIActionType = new PSDEUIActionType();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEUIActionType(strPSDEUIActionTypeId, psDEUIActionType);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEUIActionTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psDEUIActionType;
    }

    @Override
    protected IPSDEUIActionType onCreateModelHelper(PSDEUIActionType vt) throws Exception {
        PSDEUIActionTypeImpl iPSDEUIActionType = new PSDEUIActionTypeImpl();
        iPSDEUIActionType.init(this.getPSModelStorageContext(), vt);
        return iPSDEUIActionType;
    }

    @Override
    protected Boolean testObjectRenew(PSDEUIActionType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSDEUIActionType vt) {
        return vt.getPSDEUIACTIONTYPEID();
    }
}

