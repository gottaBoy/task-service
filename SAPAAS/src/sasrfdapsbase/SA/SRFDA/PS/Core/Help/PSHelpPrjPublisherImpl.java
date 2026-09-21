/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Help;

import SA.SRFDA.PS.Core.Help.IPSHelpPrj;
import SA.SRFDA.PS.Core.Help.IPSHelpPrjPublisher;
import SA.SRFDA.PS.Core.Help.IPSHelpPrjTempl;
import SA.SRFDA.PS.Core.Help.PSHelpPublisherImpl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Data.PSHelpPrjTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSHelpPrjPublisherImpl
extends PSHelpPublisherImpl
implements IPSHelpPrjPublisher {
    private static final Log log = LogFactory.getLog(PSHelpPrjPublisherImpl.class);
    protected IPSHelpPrjTempl iPSHelpPrjTempl = null;
    protected IPSPublisherContext iPSPublisherContext = null;
    protected IPSHelpPrj iPSHelpPrj = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSHelpPrjTempl iPSHelpPrjTempl) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSHelpPrjTempl = iPSHelpPrjTempl;
        this.onInit();
    }

    @Override
    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSHelpPrj iPSHelpPrj) throws Exception {
        this.iPSHelpPrj = iPSHelpPrj;
        this.iPSPublisherContext = iPSPublisherContext;
        this.iPSSystem = iPSHelpPrj.getPSSystem();
        return this.onGenerateCode();
    }

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        PSGenerateCodeResultImpl psGenerateCodeResultImpl = new PSGenerateCodeResultImpl();
        psGenerateCodeResultImpl.setObject(this.iPSHelpPrj);
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("publisher", this);
        params.put("item", this.iPSHelpPrj);
        params.put("sys", this.iPSHelpPrj.getPSSystem());
        this.onFillGenerateCodeParams(this.iPSHelpPrj, params);
        PSHelpPrjTempl psHelpPrjTempl = this.iPSHelpPrjTempl.getPSHelpPrjTemplData();
        if (!StringHelper.IsNullOrEmpty((String)psHelpPrjTempl.getTEMPLCODE())) {
            psGenerateCodeResultImpl.setCode(PSTemplHelper.generateCode((BaseDataEntity)psHelpPrjTempl, "TEMPLCODE", params));
        }
        if (!StringHelper.IsNullOrEmpty((String)psHelpPrjTempl.getTEMPLCODE2())) {
            psGenerateCodeResultImpl.setCode2(PSTemplHelper.generateCode((BaseDataEntity)psHelpPrjTempl, "TEMPLCODE2", params));
        }
        psGenerateCodeResultImpl.setParams(params);
        return psGenerateCodeResultImpl;
    }

    @Override
    public void saveFile(IPSPublisherContext iPSPublisherContext, IPSHelpPrj iPSHelpPrj) throws Exception {
        this.iPSHelpPrj = iPSHelpPrj;
        this.iPSPublisherContext = iPSPublisherContext;
        this.iPSSystem = iPSHelpPrj.getPSSystem();
        this.saveFile(this.iPSHelpPrj, StringHelper.Format((String)"%1$s.htm", (Object)iPSHelpPrj.getPrjSN()), "prjs", null, this.iPSHelpPrjTempl.getPSHelpPrjTemplData());
    }

    @Override
    protected void onFillGenerateCodeParams(Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(obj, params);
    }

    @Override
    public void close() {
        this.iPSPublisherContext = null;
        this.iPSHelpPrj = null;
        this.iPSSystem = null;
        this.onClose();
        if (this.iPSHelpPrjTempl != null) {
            this.iPSHelpPrjTempl.releasePSHelpPrjPublisher(this);
        }
    }

    protected IPSHelpPrjTempl getPSHelpPrjTempl() {
        return this.iPSHelpPrjTempl;
    }

    @Override
    public IPSPublisherContext getContext() {
        return this.iPSPublisherContext;
    }
}

