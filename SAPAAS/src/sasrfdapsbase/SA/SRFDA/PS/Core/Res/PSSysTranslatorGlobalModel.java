/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.Res.IPSSysTranslator;
import SA.SRFDA.PS.Core.Res.PSSysTranslatorImpl;
import SA.SRFDA.PS.Data.PSSysTranslator;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysTranslatorGlobalModel
extends PSSystemGlobalModelBase<String, PSSysTranslator, IPSSysTranslator> {
    private static final Log log = LogFactory.getLog(PSSysTranslatorGlobalModel.class);

    @Override
    protected PSSysTranslator GetObject(String strPSSysTranslatorId) {
        PSSysTranslator psSysTranslator = new PSSysTranslator();
        CallResult callResult = this.iPSModelHelper.getPSSysTranslator(strPSSysTranslatorId, psSysTranslator);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u503c\u8f6c\u6362\u5668[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysTranslatorId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysTranslator;
    }

    @Override
    protected IPSSysTranslator OnCreateModelHelper(PSSysTranslator vt) throws Exception {
        PSSysTranslatorImpl iPSSysTranslator = new PSSysTranslatorImpl();
        iPSSysTranslator.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysTranslator;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysTranslator obj) {
        return false;
    }

    @Override
    protected IPSSysTranslator registerModel(PSSysTranslator vt) throws Exception {
        IPSSysTranslator iPSSysTranslator = (IPSSysTranslator)this.InternalGetModelHelper(vt.getPSSYSTRANSLATORID());
        if (iPSSysTranslator != null) {
            return iPSSysTranslator;
        }
        this.setModel(vt.getPSSYSTRANSLATORID(), vt, null);
        iPSSysTranslator = (IPSSysTranslator)this.FindModelHelper(vt.getPSSYSTRANSLATORID());
        return iPSSysTranslator;
    }

    @Override
    protected Vector<PSSysTranslator> getAllModels() throws Exception {
        Vector<PSSysTranslator> list = new Vector<PSSysTranslator>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysTranslators(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u503c\u8f6c\u6362\u5668\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysTranslator vt) {
        return vt.getPSSYSTRANSLATORID();
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

    protected String[] getObjectAliases(PSSysTranslator vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

