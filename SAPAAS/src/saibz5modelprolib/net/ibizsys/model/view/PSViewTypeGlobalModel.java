/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.view.IPSViewType
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.view;

import net.ibizsys.model.PSGlobalModelBase;
import net.ibizsys.model.entity.PSViewType;
import net.ibizsys.model.view.IPSViewType;
import net.ibizsys.model.view.PSViewTypeImpl;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSViewTypeGlobalModel
extends PSGlobalModelBase<String, PSViewType, IPSViewType> {
    private static final Log log = LogFactory.getLog(PSViewTypeGlobalModel.class);

    @Override
    protected PSViewType getObject(String strPSViewTypeId) {
        PSViewType PSViewType2 = new PSViewType();
        CallResult callResult = this.getPSModelQueryHelper().getPSViewType(strPSViewTypeId, PSViewType2);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u89c6\u56fe\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSViewTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSViewType2;
    }

    @Override
    protected IPSViewType onCreateModelHelper(PSViewType vt) throws Exception {
        PSViewTypeImpl iPSViewType = new PSViewTypeImpl();
        iPSViewType.init(this.getPSModelStorageContext(), vt);
        return iPSViewType;
    }

    @Override
    protected Boolean testObjectRenew(PSViewType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSViewType vt) {
        return vt.getPSVIEWTYPEID();
    }
}

