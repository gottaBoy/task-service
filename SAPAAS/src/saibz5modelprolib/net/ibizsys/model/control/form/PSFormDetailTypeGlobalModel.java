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
import net.ibizsys.model.control.form.IPSFormDetailType;
import net.ibizsys.model.control.form.PSFormDetailTypeImpl;
import net.ibizsys.model.entity.PSFormDetailType;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSFormDetailTypeGlobalModel
extends PSGlobalModelBase<String, PSFormDetailType, IPSFormDetailType> {
    private static final Log log = LogFactory.getLog(PSFormDetailTypeGlobalModel.class);

    @Override
    protected PSFormDetailType getObject(String strPSFormDetailTypeId) {
        PSFormDetailType PSFormDetailType2 = new PSFormDetailType();
        CallResult callResult = this.getPSModelQueryHelper().getPSFormDetailType(strPSFormDetailTypeId, PSFormDetailType2);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5b9e\u4f53\u8868\u5355\u6210\u5458\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSFormDetailTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSFormDetailType2;
    }

    @Override
    protected IPSFormDetailType onCreateModelHelper(PSFormDetailType vt) throws Exception {
        IPSFormDetailType iPSFormDetailType = null;
        iPSFormDetailType = StringHelper.isNullOrEmpty((String)vt.getTYPEOBJ()) ? new PSFormDetailTypeImpl() : (IPSFormDetailType)this.getPSModelStorageContext().createObject(vt.getTYPEOBJ());
        iPSFormDetailType.init(this.getPSModelStorageContext(), vt);
        return iPSFormDetailType;
    }

    @Override
    protected Boolean testObjectRenew(PSFormDetailType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSFormDetailType vt) {
        return vt.getPSFORMDETAILTYPEID();
    }
}

