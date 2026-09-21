/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.res.IPSPortletType
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.res;

import net.ibizsys.model.PSGlobalModelBase;
import net.ibizsys.model.entity.PSPortletType;
import net.ibizsys.model.res.IPSPortletType;
import net.ibizsys.model.res.PSPortletTypeImpl;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPortletTypeGlobalModel
extends PSGlobalModelBase<String, PSPortletType, IPSPortletType> {
    private static final Log log = LogFactory.getLog(PSPortletTypeGlobalModel.class);

    @Override
    protected PSPortletType getObject(String strPSPortletTypeId) {
        PSPortletType PSPortletType2 = new PSPortletType();
        CallResult callResult = this.getPSModelQueryHelper().getPSPortletType(strPSPortletTypeId, PSPortletType2);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5b9e\u4f53\u8868\u5355\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSPortletTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSPortletType2;
    }

    @Override
    protected IPSPortletType onCreateModelHelper(PSPortletType vt) throws Exception {
        PSPortletTypeImpl iPSPortletType = new PSPortletTypeImpl();
        iPSPortletType.init(this.getPSModelStorageContext(), vt);
        return iPSPortletType;
    }

    @Override
    protected Boolean testObjectRenew(PSPortletType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSPortletType vt) {
        return vt.getPSPORTLETTYPEID();
    }
}

