/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionType;
import SA.SRFDA.PS.Core.DataEntity.Action.PSDEActionTypeImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSDEActionType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEActionTypeGlobalModel
extends PSGlobalModelBase<String, PSDEActionType, IPSDEActionType> {
    private static final Log log = LogFactory.getLog(PSDEActionTypeGlobalModel.class);

    @Override
    protected PSDEActionType GetObject(String strPSDEActionTypeId) {
        PSDEActionType psDEActionType = new PSDEActionType();
        CallResult callResult = this.iPSModelHelper.getPSDEActionType(strPSDEActionTypeId, psDEActionType);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5b9e\u4f53\u884c\u4e3a\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEActionTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psDEActionType;
    }

    @Override
    protected IPSDEActionType OnCreateModelHelper(PSDEActionType vt) throws Exception {
        PSDEActionTypeImpl iPSDEActionType = new PSDEActionTypeImpl();
        iPSDEActionType.init(this.iDAGlobalHelper, vt);
        return iPSDEActionType;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEActionType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSDEActionType vt) {
        return vt.getPSDEACTIONTYPEID();
    }
}

