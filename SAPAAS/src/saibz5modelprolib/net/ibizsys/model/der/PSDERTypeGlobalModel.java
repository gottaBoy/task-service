/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.der;

import net.ibizsys.model.PSGlobalModelBase;
import net.ibizsys.model.der.IPSDERType;
import net.ibizsys.model.der.PSDERTypeImpl;
import net.ibizsys.model.entity.PSDERType;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDERTypeGlobalModel
extends PSGlobalModelBase<String, PSDERType, IPSDERType> {
    private static final Log log = LogFactory.getLog(PSDERTypeGlobalModel.class);

    @Override
    protected PSDERType getObject(String strPSDERTypeId) {
        PSDERType PSDERType2 = new PSDERType();
        CallResult callResult = this.getPSModelQueryHelper().getPSDERType(strPSDERTypeId, PSDERType2);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5b9e\u4f53\u5173\u7cfb\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDERTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSDERType2;
    }

    @Override
    protected IPSDERType onCreateModelHelper(PSDERType vt) throws Exception {
        PSDERTypeImpl iPSDERType = new PSDERTypeImpl();
        iPSDERType.init(this.getPSModelStorageContext(), vt);
        return iPSDERType;
    }

    @Override
    protected Boolean testObjectRenew(PSDERType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSDERType vt) {
        return vt.getPSDERTYPEID();
    }
}

