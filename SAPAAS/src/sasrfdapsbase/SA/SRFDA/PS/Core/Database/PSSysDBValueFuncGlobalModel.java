/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSSysDBValueFunc;
import SA.SRFDA.PS.Core.Database.PSSysDBValueFuncImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Data.PSSysDBValueFunc;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSSysDBValueFuncGlobalModel
extends PSSystemGlobalModelBase<String, PSSysDBValueFunc, IPSSysDBValueFunc> {
    private static final Log log = LogFactory.getLog(PSSysDBValueFuncGlobalModel.class);

    @Override
    protected PSSysDBValueFunc GetObject(String strPSSysDBValueFuncId) {
        PSSysDBValueFunc PSSysDBValueFunc2 = new PSSysDBValueFunc();
        CallResult callResult = this.iPSModelHelper.getPSSysDBValueFunc(this.getPSSystem().getId(), strPSSysDBValueFuncId, PSSysDBValueFunc2);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u503c\u51fd\u6570[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysDBValueFuncId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSSysDBValueFunc2;
    }

    @Override
    protected IPSSysDBValueFunc OnCreateModelHelper(PSSysDBValueFunc vt) throws Exception {
        PSSysDBValueFuncImpl iPSSysDBValueFunc = new PSSysDBValueFuncImpl();
        iPSSysDBValueFunc.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysDBValueFunc;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysDBValueFunc obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSSysDBValueFunc vt) {
        return vt.getPSSYSDBVFID();
    }

    @Override
    protected IPSSysDBValueFunc registerModel(PSSysDBValueFunc vt) throws Exception {
        IPSSysDBValueFunc iPSSysDBValueFunc = (IPSSysDBValueFunc)this.InternalGetModelHelper(vt.getPSSYSDBVFID());
        if (iPSSysDBValueFunc != null) {
            return iPSSysDBValueFunc;
        }
        this.setModel(vt.getPSSYSDBVFID(), vt, null);
        iPSSysDBValueFunc = (IPSSysDBValueFunc)this.FindModelHelper(vt.getPSSYSDBVFID());
        return iPSSysDBValueFunc;
    }

    @Override
    protected Vector<PSSysDBValueFunc> getAllModels() throws Exception {
        Vector<PSSysDBValueFunc> list = new Vector<PSSysDBValueFunc>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysDBValueFuncs(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u503c\u51fd\u6570\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSSysDBValueFunc vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

