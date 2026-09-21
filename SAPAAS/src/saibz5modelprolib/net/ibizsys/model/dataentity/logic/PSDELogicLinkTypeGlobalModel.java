/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.logic;

import net.ibizsys.model.PSGlobalModelBase;
import net.ibizsys.model.dataentity.logic.IPSDELogicLinkType;
import net.ibizsys.model.dataentity.logic.PSDELogicLinkTypeImpl;
import net.ibizsys.model.entity.PSDELogicLinkType;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDELogicLinkTypeGlobalModel
extends PSGlobalModelBase<String, PSDELogicLinkType, IPSDELogicLinkType> {
    private static final Log log = LogFactory.getLog(PSDELogicLinkTypeGlobalModel.class);

    @Override
    protected PSDELogicLinkType getObject(String strPSDELogicLinkTypeId) {
        PSDELogicLinkType PSDELogicLinkType2 = new PSDELogicLinkType();
        CallResult callResult = this.getPSModelQueryHelper().getPSDELogicLinkType(strPSDELogicLinkTypeId, PSDELogicLinkType2);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5b9e\u4f53\u903b\u8f91\u8282\u70b9\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDELogicLinkTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSDELogicLinkType2;
    }

    @Override
    protected IPSDELogicLinkType onCreateModelHelper(PSDELogicLinkType vt) throws Exception {
        PSDELogicLinkTypeImpl iPSDELogicLinkType = new PSDELogicLinkTypeImpl();
        iPSDELogicLinkType.init(this.getPSModelStorageContext(), vt);
        return iPSDELogicLinkType;
    }

    @Override
    protected Boolean testObjectRenew(PSDELogicLinkType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSDELogicLinkType vt) {
        return vt.getPSDELLTYPEID();
    }
}

