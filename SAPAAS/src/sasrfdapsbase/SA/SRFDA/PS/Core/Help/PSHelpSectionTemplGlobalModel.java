/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Help;

import SA.SRFDA.PS.Core.Help.IPSHelpSectionTempl;
import SA.SRFDA.PS.Core.Help.PSHelpSectionTemplImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSHelpSectionTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSHelpSectionTemplGlobalModel
extends PSGlobalModelBase<String, PSHelpSectionTempl, IPSHelpSectionTempl> {
    private static final Log log = LogFactory.getLog(PSHelpSectionTemplGlobalModel.class);

    @Override
    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper) {
        return super.Init(iDAGlobalHelper);
    }

    @Override
    protected PSHelpSectionTempl GetObject(String strPSHelpSectionTemplId) {
        PSHelpSectionTempl PSHelpSectionTempl2 = new PSHelpSectionTempl();
        CallResult callResult = this.iPSModelHelper.getPSHelpSectionTempl(strPSHelpSectionTemplId, PSHelpSectionTempl2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5e2e\u52a9\u6587\u7ae0\u7ae0\u8282\u6a21\u677f[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSHelpSectionTemplId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSHelpSectionTempl2;
    }

    @Override
    protected IPSHelpSectionTempl OnCreateModelHelper(PSHelpSectionTempl vt) throws Exception {
        PSHelpSectionTemplImpl iPSHelpSectionTempl = new PSHelpSectionTemplImpl();
        iPSHelpSectionTempl.init(this.iDAGlobalHelper, vt);
        return iPSHelpSectionTempl;
    }

    @Override
    protected Boolean TestObjectRenew(PSHelpSectionTempl obj) {
        return false;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        Vector<PSHelpSectionTempl> psHelpSectionTemplList = new Vector<PSHelpSectionTempl>();
        CallResult callResult = this.iPSModelHelper.getPSHelpSectionTempls(psHelpSectionTemplList);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5e2e\u52a9\u6587\u7ae0\u7ae0\u8282\u6a21\u7248\u914d\u7f6e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return;
        }
        String strDefaultTemplId = null;
        for (PSHelpSectionTempl psHelpSectionTempl : psHelpSectionTemplList) {
            this.setModel(psHelpSectionTempl.getPSHELPSECTIONTEMPLID(), psHelpSectionTempl, null);
            if (!psHelpSectionTempl.getDEFAULTFLAG()) continue;
            strDefaultTemplId = psHelpSectionTempl.getPSHELPSECTIONTEMPLID();
        }
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSHelpSectionTempl vt) {
        return vt.getPSHELPSECTIONTEMPLID();
    }

    @Override
    protected String getModelInfo() {
        return StringHelper.Format((String)"%1$s", (Object)super.getModelInfo());
    }
}

