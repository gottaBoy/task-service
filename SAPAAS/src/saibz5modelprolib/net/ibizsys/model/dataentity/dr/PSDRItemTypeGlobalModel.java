/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.dr;

import net.ibizsys.model.PSGlobalModelBase;
import net.ibizsys.model.dataentity.dr.IPSDRItemType;
import net.ibizsys.model.dataentity.dr.PSDRItemTypeImpl;
import net.ibizsys.model.entity.PSDRItemType;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDRItemTypeGlobalModel
extends PSGlobalModelBase<String, PSDRItemType, IPSDRItemType> {
    private static final Log log = LogFactory.getLog(PSDRItemTypeGlobalModel.class);

    @Override
    protected PSDRItemType getObject(String strPSDRItemTypeId) {
        PSDRItemType PSDRItemType2 = new PSDRItemType();
        CallResult callResult = this.getPSModelQueryHelper().getPSDRItemType(strPSDRItemTypeId, PSDRItemType2);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u6570\u636e\u5173\u7cfb\u9879\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDRItemTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSDRItemType2;
    }

    @Override
    protected IPSDRItemType onCreateModelHelper(PSDRItemType vt) throws Exception {
        PSDRItemTypeImpl iPSDRItemType = new PSDRItemTypeImpl();
        iPSDRItemType.init(this.getPSModelStorageContext(), vt);
        return iPSDRItemType;
    }

    @Override
    protected Boolean testObjectRenew(PSDRItemType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSDRItemType vt) {
        return vt.getPSDRITEMTYPEID();
    }
}

