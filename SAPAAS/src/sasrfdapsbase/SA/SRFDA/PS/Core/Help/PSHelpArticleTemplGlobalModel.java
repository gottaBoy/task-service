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

import SA.SRFDA.PS.Core.Help.IPSHelpArticleTempl;
import SA.SRFDA.PS.Core.Help.PSHelpArticleTemplImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSHelpArticleTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSHelpArticleTemplGlobalModel
extends PSGlobalModelBase<String, PSHelpArticleTempl, IPSHelpArticleTempl> {
    private static final Log log = LogFactory.getLog(PSHelpArticleTemplGlobalModel.class);
    private IPSHelpArticleTempl defaultPSHelpArticleTempl = null;

    @Override
    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper) {
        return super.Init(iDAGlobalHelper);
    }

    @Override
    protected PSHelpArticleTempl GetObject(String strPSHelpArticleTemplId) {
        PSHelpArticleTempl PSHelpArticleTempl2 = new PSHelpArticleTempl();
        CallResult callResult = this.iPSModelHelper.getPSHelpArticleTempl(strPSHelpArticleTemplId, PSHelpArticleTempl2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5e2e\u52a9\u6587\u7ae0\u6a21\u677f[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSHelpArticleTemplId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSHelpArticleTempl2;
    }

    @Override
    protected IPSHelpArticleTempl OnCreateModelHelper(PSHelpArticleTempl vt) throws Exception {
        PSHelpArticleTemplImpl iPSHelpArticleTempl = new PSHelpArticleTemplImpl();
        iPSHelpArticleTempl.init(this.iDAGlobalHelper, vt);
        return iPSHelpArticleTempl;
    }

    @Override
    protected Boolean TestObjectRenew(PSHelpArticleTempl obj) {
        return false;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        Vector<PSHelpArticleTempl> psHelpArticleTemplList = new Vector<PSHelpArticleTempl>();
        CallResult callResult = this.iPSModelHelper.getPSHelpArticleTempls(psHelpArticleTemplList);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5e2e\u52a9\u6587\u7ae0\u6a21\u7248\u914d\u7f6e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return;
        }
        String strDefaultTemplId = null;
        for (PSHelpArticleTempl psHelpArticleTempl : psHelpArticleTemplList) {
            this.setModel(psHelpArticleTempl.getPSHELPARTICLETEMPLID(), psHelpArticleTempl, null);
            if (!psHelpArticleTempl.getDEFAULTFLAG()) continue;
            strDefaultTemplId = psHelpArticleTempl.getPSHELPARTICLETEMPLID();
        }
        if (!StringHelper.IsNullOrEmpty(strDefaultTemplId)) {
            try {
                this.defaultPSHelpArticleTempl = (IPSHelpArticleTempl)this.FindModelHelper(strDefaultTemplId);
            }
            catch (Exception e) {
                log.error((Object)e);
            }
        }
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSHelpArticleTempl vt) {
        return vt.getPSHELPARTICLETEMPLID();
    }

    @Override
    protected String getModelInfo() {
        return StringHelper.Format((String)"%1$s", (Object)super.getModelInfo());
    }

    public IPSHelpArticleTempl getDefaultPSHelpArticleTempl() {
        this.preloadModels();
        return this.defaultPSHelpArticleTempl;
    }
}

