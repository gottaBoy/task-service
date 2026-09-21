/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.wf;

import net.ibizsys.model.PSGlobalModelBase;
import net.ibizsys.model.entity.PSWFLinkType;
import net.ibizsys.model.wf.IPSWFLinkType;
import net.ibizsys.model.wf.PSWFLinkTypeImpl;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWFLinkTypeGlobalModel
extends PSGlobalModelBase<String, PSWFLinkType, IPSWFLinkType> {
    private static final Log log = LogFactory.getLog(PSWFLinkTypeGlobalModel.class);

    @Override
    protected PSWFLinkType getObject(String strPSWFLinkTypeId) {
        PSWFLinkType PSWFLinkType2 = new PSWFLinkType();
        CallResult callResult = this.getPSModelQueryHelper().getPSWFLinkType(strPSWFLinkTypeId, PSWFLinkType2);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u6d41\u7a0b\u8fde\u63a5\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSWFLinkTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSWFLinkType2;
    }

    @Override
    protected IPSWFLinkType onCreateModelHelper(PSWFLinkType vt) throws Exception {
        PSWFLinkTypeImpl iPSWFLinkType = new PSWFLinkTypeImpl();
        iPSWFLinkType.init(this.getPSModelStorageContext(), vt);
        return iPSWFLinkType;
    }

    @Override
    protected Boolean testObjectRenew(PSWFLinkType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSWFLinkType vt) {
        return vt.getPSWFLINKTYPEID();
    }
}

