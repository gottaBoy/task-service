/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.form;

import net.ibizsys.model.PSGlobalModelBase;
import net.ibizsys.model.control.form.IPSFormType;
import net.ibizsys.model.control.form.PSFormTypeImpl;
import net.ibizsys.model.entity.PSFormType;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSFormTypeGlobalModel
extends PSGlobalModelBase<String, PSFormType, IPSFormType> {
    private static final Log log = LogFactory.getLog(PSFormTypeGlobalModel.class);

    @Override
    protected PSFormType getObject(String strPSFormTypeId) {
        PSFormType PSFormType2 = new PSFormType();
        CallResult callResult = this.getPSModelQueryHelper().getPSFormType(strPSFormTypeId, PSFormType2);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5b9e\u4f53\u8868\u5355\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSFormTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSFormType2;
    }

    @Override
    protected IPSFormType onCreateModelHelper(PSFormType vt) throws Exception {
        PSFormTypeImpl iPSFormType = new PSFormTypeImpl();
        iPSFormType.init(this.getPSModelStorageContext(), vt);
        return iPSFormType;
    }

    @Override
    protected Boolean testObjectRenew(PSFormType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSFormType vt) {
        return vt.getPSFORMTYPEID();
    }
}

