/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.EAI;

import SA.SRFDA.PS.Core.EAI.IPSSysEAIScheme;
import SA.SRFDA.PS.Core.EAI.PSSysEAISchemeImpl;
import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Data.PSSysEAIScheme;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysEAISchemeGlobalModel
extends PSSystemGlobalModelBase<String, PSSysEAIScheme, IPSSysEAIScheme> {
    private static final Log log = LogFactory.getLog(PSSysEAISchemeGlobalModel.class);

    @Override
    protected PSSysEAIScheme GetObject(String strPSSysEAISchemeId) {
        PSSysEAIScheme psSysEAIScheme = new PSSysEAIScheme();
        CallResult callResult = this.iPSModelHelper.getPSSysEAIScheme(strPSSysEAISchemeId, psSysEAIScheme);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u5e94\u7528\u96c6\u6210\u4f53\u7cfb[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysEAISchemeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysEAIScheme;
    }

    @Override
    protected IPSSysEAIScheme OnCreateModelHelper(PSSysEAIScheme vt) throws Exception {
        PSSysEAISchemeImpl iPSSysEAIScheme = new PSSysEAISchemeImpl();
        iPSSysEAIScheme.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysEAIScheme;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysEAIScheme obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSSysEAIScheme registerModel(PSSysEAIScheme vt) throws Exception {
        IPSSysEAIScheme iIPSSysEAIScheme = (IPSSysEAIScheme)this.InternalGetModelHelper(vt.getPSSYSEAISCHEMEID());
        if (iIPSSysEAIScheme != null) {
            return iIPSSysEAIScheme;
        }
        this.setModel(vt.getPSSYSEAISCHEMEID(), vt, null);
        return (IPSSysEAIScheme)this.FindModelHelper(vt.getPSSYSEAISCHEMEID());
    }

    @Override
    protected Vector<PSSysEAIScheme> getAllModels() throws Exception {
        Vector<PSSysEAIScheme> list = new Vector<PSSysEAIScheme>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysEAISchemes(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u5e94\u7528\u96c6\u6210\u4f53\u7cfb\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysEAIScheme vt) {
        return vt.getPSSYSEAISCHEMEID();
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSSysEAIScheme vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

