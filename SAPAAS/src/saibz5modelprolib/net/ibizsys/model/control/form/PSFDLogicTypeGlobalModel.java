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
import net.ibizsys.model.control.form.IPSFDLogicType;
import net.ibizsys.model.control.form.PSFDLogicTypeImpl;
import net.ibizsys.model.entity.PSFDLogicType;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSFDLogicTypeGlobalModel
extends PSGlobalModelBase<String, PSFDLogicType, IPSFDLogicType> {
    private static final Log log = LogFactory.getLog(PSFDLogicTypeGlobalModel.class);

    @Override
    protected PSFDLogicType getObject(String strPSFDLogicTypeId) {
        PSFDLogicType PSFDLogicType2 = new PSFDLogicType();
        CallResult callResult = this.getPSModelQueryHelper().getPSFDLogicType(strPSFDLogicTypeId, PSFDLogicType2);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5b9e\u4f53\u8868\u5355\u6210\u5458\u903b\u8f91\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSFDLogicTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSFDLogicType2;
    }

    @Override
    protected IPSFDLogicType onCreateModelHelper(PSFDLogicType vt) throws Exception {
        PSFDLogicTypeImpl iPSFDLogicType = new PSFDLogicTypeImpl();
        iPSFDLogicType.init(this.getPSModelStorageContext(), vt);
        return iPSFDLogicType;
    }

    @Override
    protected Boolean testObjectRenew(PSFDLogicType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSFDLogicType vt) {
        return vt.getPSFDLOGICTYPEID();
    }
}

