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

import SA.SRFDA.PS.Core.Help.IPSHelpPrjTempl;
import SA.SRFDA.PS.Core.Help.PSHelpPrjTemplImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSHelpPrjTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSHelpPrjTemplGlobalModel
extends PSGlobalModelBase<String, PSHelpPrjTempl, IPSHelpPrjTempl> {
    private static final Log log = LogFactory.getLog(PSHelpPrjTemplGlobalModel.class);
    private IPSHelpPrjTempl defaultPSHelpPrjTempl = null;

    @Override
    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper) {
        return super.Init(iDAGlobalHelper);
    }

    @Override
    protected PSHelpPrjTempl GetObject(String strPSHelpPrjTemplId) {
        PSHelpPrjTempl PSHelpPrjTempl2 = new PSHelpPrjTempl();
        CallResult callResult = this.iPSModelHelper.getPSHelpPrjTempl(strPSHelpPrjTemplId, PSHelpPrjTempl2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5e2e\u52a9\u9879\u76ee\u6a21\u677f[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSHelpPrjTemplId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSHelpPrjTempl2;
    }

    @Override
    protected IPSHelpPrjTempl OnCreateModelHelper(PSHelpPrjTempl vt) throws Exception {
        PSHelpPrjTemplImpl iPSHelpPrjTempl = new PSHelpPrjTemplImpl();
        iPSHelpPrjTempl.init(this.iDAGlobalHelper, vt);
        return iPSHelpPrjTempl;
    }

    @Override
    protected Boolean TestObjectRenew(PSHelpPrjTempl obj) {
        return false;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        Vector<PSHelpPrjTempl> psHelpPrjTemplList = new Vector<PSHelpPrjTempl>();
        CallResult callResult = this.iPSModelHelper.getPSHelpPrjTempls(psHelpPrjTemplList);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5e2e\u52a9\u9879\u76ee\u6a21\u7248\u914d\u7f6e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return;
        }
        String strDefaultTemplId = null;
        for (PSHelpPrjTempl psHelpPrjTempl : psHelpPrjTemplList) {
            this.setModel(psHelpPrjTempl.getPSHELPPRJTEMPLID(), psHelpPrjTempl, null);
            if (!psHelpPrjTempl.getDEFAULTFLAG()) continue;
            strDefaultTemplId = psHelpPrjTempl.getPSHELPPRJTEMPLID();
        }
        if (!StringHelper.IsNullOrEmpty(strDefaultTemplId)) {
            try {
                this.defaultPSHelpPrjTempl = (IPSHelpPrjTempl)this.FindModelHelper(strDefaultTemplId);
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
    protected String getObjectId(PSHelpPrjTempl vt) {
        return vt.getPSHELPPRJTEMPLID();
    }

    @Override
    protected String getModelInfo() {
        return StringHelper.Format((String)"%1$s", (Object)super.getModelInfo());
    }

    public IPSHelpPrjTempl getDefaultPSHelpPrjTempl() {
        this.preloadModels();
        return this.defaultPSHelpPrjTempl;
    }
}

