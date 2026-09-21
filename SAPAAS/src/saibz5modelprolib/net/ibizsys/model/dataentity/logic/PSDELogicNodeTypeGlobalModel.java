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
import net.ibizsys.model.dataentity.logic.IPSDELogicNodeType;
import net.ibizsys.model.dataentity.logic.PSDELogicNodeTypeImpl;
import net.ibizsys.model.entity.PSDELogicNodeType;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDELogicNodeTypeGlobalModel
extends PSGlobalModelBase<String, PSDELogicNodeType, IPSDELogicNodeType> {
    private static final Log log = LogFactory.getLog(PSDELogicNodeTypeGlobalModel.class);

    @Override
    protected PSDELogicNodeType getObject(String strPSDELogicNodeTypeId) {
        PSDELogicNodeType PSDELogicNodeType2 = new PSDELogicNodeType();
        CallResult callResult = this.getPSModelQueryHelper().getPSDELogicNodeType(strPSDELogicNodeTypeId, PSDELogicNodeType2);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5b9e\u4f53\u903b\u8f91\u8282\u70b9\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDELogicNodeTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSDELogicNodeType2;
    }

    @Override
    protected IPSDELogicNodeType onCreateModelHelper(PSDELogicNodeType vt) throws Exception {
        PSDELogicNodeTypeImpl iPSDELogicNodeType = new PSDELogicNodeTypeImpl();
        iPSDELogicNodeType.init(this.getPSModelStorageContext(), vt);
        return iPSDELogicNodeType;
    }

    @Override
    protected Boolean testObjectRenew(PSDELogicNodeType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSDELogicNodeType vt) {
        return vt.getPSDELNTYPEID();
    }
}

