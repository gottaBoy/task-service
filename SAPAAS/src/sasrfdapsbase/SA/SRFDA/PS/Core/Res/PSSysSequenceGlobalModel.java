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
import SA.SRFDA.PS.Core.Res.IPSSysSequence;
import SA.SRFDA.PS.Core.Res.PSSysSequenceImpl;
import SA.SRFDA.PS.Data.PSSysSequence;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysSequenceGlobalModel
extends PSSystemGlobalModelBase<String, PSSysSequence, IPSSysSequence> {
    private static final Log log = LogFactory.getLog(PSSysSequenceGlobalModel.class);

    @Override
    protected PSSysSequence GetObject(String strPSSysSequenceId) {
        PSSysSequence psSysSequence = new PSSysSequence();
        CallResult callResult = this.iPSModelHelper.getPSSysSequence(strPSSysSequenceId, psSysSequence);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u503c\u5e8f\u5217[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysSequenceId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysSequence;
    }

    @Override
    protected IPSSysSequence OnCreateModelHelper(PSSysSequence vt) throws Exception {
        PSSysSequenceImpl iPSSysSequence = new PSSysSequenceImpl();
        iPSSysSequence.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysSequence;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysSequence obj) {
        return false;
    }

    @Override
    protected IPSSysSequence registerModel(PSSysSequence vt) throws Exception {
        IPSSysSequence iPSSysSequence = (IPSSysSequence)this.InternalGetModelHelper(vt.getPSSYSSEQUENCEID());
        if (iPSSysSequence != null) {
            return iPSSysSequence;
        }
        this.setModel(vt.getPSSYSSEQUENCEID(), vt, null);
        iPSSysSequence = (IPSSysSequence)this.FindModelHelper(vt.getPSSYSSEQUENCEID());
        return iPSSysSequence;
    }

    @Override
    protected Vector<PSSysSequence> getAllModels() throws Exception {
        Vector<PSSysSequence> list = new Vector<PSSysSequence>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysSequences(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u503c\u5e8f\u5217\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysSequence vt) {
        return vt.getPSSYSSEQUENCEID();
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

    protected String[] getObjectAliases(PSSysSequence vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

