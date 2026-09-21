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
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewLogic;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PF.IPSPFViewLogicTempl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFViewLogicCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFDA.PS.Core.Pub.PSPFCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Data.PSPFViewLogicTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFViewLogicCodePublisherImpl
extends PSPFCodePublisherImpl
implements IPSPFViewLogicCodePublisher {
    private static final Log log = LogFactory.getLog(PSPFViewLogicCodePublisherImpl.class);
    protected IPSPFViewLogicTempl iPSPFViewLogicTempl = null;
    protected IPSPublisherContext iPSPublisherContext = null;
    protected IPSAppView iPSAppView = null;
    protected IPSApplication iPSApplication = null;
    protected IPSPF iPSPF = null;
    protected IPSPFStyle iPSPFStyle = null;
    protected IPSAppViewLogic iPSAppViewLogic = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPFViewLogicTempl iPSPFViewLogicTempl) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSPFViewLogicTempl = iPSPFViewLogicTempl;
        this.setPSPFPubCode(this.iPSPFViewLogicTempl.getPSPFPubCode());
        this.onInit();
    }

    @Override
    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSAppViewLogic iPSAppViewLogic) throws Exception {
        this.iPSAppViewLogic = iPSAppViewLogic;
        this.iPSPublisherContext = iPSPublisherContext;
        this.iPSAppView = iPSAppViewLogic.getPSAppView();
        this.iPSApplication = this.iPSAppView.getPSApplication();
        this.iPSPF = this.iPSApplication.getPSPF();
        this.iPSPFStyle = this.iPSAppView.getPSPFStyle();
        return this.onGenerateCode();
    }

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        PSGenerateCodeResultImpl psGenerateCodeResultImpl = new PSGenerateCodeResultImpl();
        psGenerateCodeResultImpl.setObject(this.iPSAppViewLogic);
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("publisher", this);
        params.put("item", this.iPSAppViewLogic);
        params.put("app", this.iPSApplication);
        params.put("view", this.iPSAppView);
        params.put("itemtempl", this.iPSPFViewLogicTempl);
        params.put("codetempl", this.iPSPFViewLogicTempl);
        params.put("pf", this.iPSPF);
        params.put("pfstyle", this.iPSPFStyle);
        this.onFillGenerateCodeParams(params);
        PSPFViewLogicTempl psPFViewLogicTempl = this.iPSPFViewLogicTempl.getPSPFViewLogicTemplData();
        if (!StringHelper.IsNullOrEmpty((String)psPFViewLogicTempl.getTEMPLCODE())) {
            psGenerateCodeResultImpl.setCode(PSTemplHelper.generateCode((BaseDataEntity)psPFViewLogicTempl, "TEMPLCODE", params));
        }
        if (!StringHelper.IsNullOrEmpty((String)psPFViewLogicTempl.getTEMPLCODE2())) {
            psGenerateCodeResultImpl.setCode2(PSTemplHelper.generateCode((BaseDataEntity)psPFViewLogicTempl, "TEMPLCODE2", params));
        }
        if (!StringHelper.IsNullOrEmpty((String)psPFViewLogicTempl.getTEMPLCODE3())) {
            psGenerateCodeResultImpl.setCode3(PSTemplHelper.generateCode((BaseDataEntity)psPFViewLogicTempl, "TEMPLCODE3", params));
        }
        if (!StringHelper.IsNullOrEmpty((String)psPFViewLogicTempl.getTEMPLCODE4())) {
            psGenerateCodeResultImpl.setCode4(PSTemplHelper.generateCode((BaseDataEntity)psPFViewLogicTempl, "TEMPLCODE4", params));
        }
        psGenerateCodeResultImpl.setParams(params);
        return psGenerateCodeResultImpl;
    }

    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
    }

    @Override
    protected void onClose() {
        this.iPSPublisherContext = null;
        this.iPSAppView = null;
        this.iPSApplication = null;
        this.iPSPF = null;
        this.iPSPFStyle = null;
        this.iPSAppViewLogic = null;
        super.onClose();
        if (this.iPSPFViewLogicTempl != null) {
            this.iPSPFViewLogicTempl.releasePSPFViewLogicCodePublisher(this);
        }
    }

    @Override
    public IPSPublisherContext getContext() {
        return this.iPSPublisherContext;
    }
}

