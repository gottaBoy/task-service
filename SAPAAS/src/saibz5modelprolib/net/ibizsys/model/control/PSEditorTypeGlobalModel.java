/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSEditorType
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control;

import net.ibizsys.model.PSGlobalModelBase;
import net.ibizsys.model.control.IPSEditorType;
import net.ibizsys.model.control.PSEditorTypeImpl;
import net.ibizsys.model.entity.PSEditorType;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSEditorTypeGlobalModel
extends PSGlobalModelBase<String, PSEditorType, IPSEditorType> {
    private static final Log log = LogFactory.getLog(PSEditorTypeGlobalModel.class);

    @Override
    protected PSEditorType getObject(String strPSEditorTypeId) {
        PSEditorType PSEditorType2 = new PSEditorType();
        CallResult callResult = this.getPSModelQueryHelper().getPSEditorType(strPSEditorTypeId, PSEditorType2);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u7f16\u8f91\u5668\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSEditorTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSEditorType2;
    }

    @Override
    protected IPSEditorType onCreateModelHelper(PSEditorType vt) throws Exception {
        PSEditorTypeImpl iPSEditorType = new PSEditorTypeImpl();
        iPSEditorType.init(this.getPSModelStorageContext(), vt);
        return iPSEditorType;
    }

    @Override
    protected Boolean testObjectRenew(PSEditorType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSEditorType vt) {
        return vt.getPSEDITORTYPEID();
    }
}

