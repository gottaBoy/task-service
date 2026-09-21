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
import net.ibizsys.model.dataentity.logic.IPSDELogicLinkCondType;
import net.ibizsys.model.dataentity.logic.PSDELogicLinkCondTypeImpl;
import net.ibizsys.model.entity.PSDELogicLinkCondType;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDELogicLinkCondTypeGlobalModel
extends PSGlobalModelBase<String, PSDELogicLinkCondType, IPSDELogicLinkCondType> {
    private static final Log log = LogFactory.getLog(PSDELogicLinkCondTypeGlobalModel.class);

    @Override
    protected PSDELogicLinkCondType getObject(String strPSDELogicLinkCondTypeId) {
        PSDELogicLinkCondType PSDELogicLinkCondType2 = new PSDELogicLinkCondType();
        CallResult callResult = this.getPSModelQueryHelper().getPSDELogicLinkCondType(strPSDELogicLinkCondTypeId, PSDELogicLinkCondType2);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5b9e\u4f53\u903b\u8f91\u8fde\u63a5\u6761\u4ef6\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDELogicLinkCondTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSDELogicLinkCondType2;
    }

    @Override
    protected IPSDELogicLinkCondType onCreateModelHelper(PSDELogicLinkCondType vt) throws Exception {
        PSDELogicLinkCondTypeImpl iPSDELogicLinkCondType = new PSDELogicLinkCondTypeImpl();
        iPSDELogicLinkCondType.init(this.getPSModelStorageContext(), vt);
        return iPSDELogicLinkCondType;
    }

    @Override
    protected Boolean testObjectRenew(PSDELogicLinkCondType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSDELogicLinkCondType vt) {
        return vt.getPSDELLCONDTYPEID();
    }
}

