/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.AI;

import SA.SRFDA.PS.Core.AI.IPSSysAIFactory;
import SA.SRFDA.PS.Core.AI.PSSysAIFactoryImpl;
import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Data.PSSysAIFactory;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysAIFactoryGlobalModel
extends PSSystemGlobalModelBase<String, PSSysAIFactory, IPSSysAIFactory> {
    private static final Log log = LogFactory.getLog(PSSysAIFactoryGlobalModel.class);

    @Override
    protected PSSysAIFactory GetObject(String strPSSysAIFactoryId) {
        PSSysAIFactory psSysAIFactory = new PSSysAIFactory();
        CallResult callResult = this.iPSModelHelper.getPSSysAIFactory(strPSSysAIFactoryId, psSysAIFactory);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edfAI\u5de5\u5382[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysAIFactoryId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysAIFactory;
    }

    @Override
    protected IPSSysAIFactory OnCreateModelHelper(PSSysAIFactory vt) throws Exception {
        PSSysAIFactoryImpl iPSSysAIFactory = new PSSysAIFactoryImpl();
        iPSSysAIFactory.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysAIFactory;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysAIFactory obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSSysAIFactory registerModel(PSSysAIFactory vt) throws Exception {
        IPSSysAIFactory iIPSSysAIFactory = (IPSSysAIFactory)this.InternalGetModelHelper(vt.getPSSYSAIFACTORYID());
        if (iIPSSysAIFactory != null) {
            return iIPSSysAIFactory;
        }
        this.setModel(vt.getPSSYSAIFACTORYID(), vt, null);
        return (IPSSysAIFactory)this.FindModelHelper(vt.getPSSYSAIFACTORYID());
    }

    @Override
    protected Vector<PSSysAIFactory> getAllModels() throws Exception {
        Vector<PSSysAIFactory> list = new Vector<PSSysAIFactory>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysAIFactories(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8AI\u5de5\u5382\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysAIFactory vt) {
        return vt.getPSSYSAIFACTORYID();
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSSysAIFactory vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

