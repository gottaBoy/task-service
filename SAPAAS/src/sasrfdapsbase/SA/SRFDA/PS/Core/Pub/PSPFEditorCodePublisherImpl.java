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
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFEditorTempl;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFEditorCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFDA.PS.Core.Pub.PSPFCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Data.PSPFEditorTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFEditorCodePublisherImpl
extends PSPFCodePublisherImpl
implements IPSPFEditorCodePublisher {
    private static final Log log = LogFactory.getLog(PSPFEditorCodePublisherImpl.class);
    protected IPSPFEditorTempl iPSPFEditorTempl = null;
    protected IPSPublisherContext iPSPublisherContext = null;
    protected IPSAppView iPSAppView = null;
    protected IPSApplication iPSApplication = null;
    protected IPSPF iPSPF = null;
    protected IPSPFStyle iPSPFStyle = null;
    protected IPSControl iPSControl = null;
    protected Object object = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPFEditorTempl iPSPFEditorTempl) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSPFEditorTempl = iPSPFEditorTempl;
        this.setPSPFPubCode(this.iPSPFEditorTempl.getPSPFPubCode());
        this.onInit();
    }

    @Override
    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl, Object object) throws Exception {
        this.object = object;
        this.iPSControl = iPSControl;
        this.iPSPublisherContext = iPSPublisherContext;
        this.iPSAppView = iPSControl.getPSAppView();
        this.iPSApplication = this.iPSAppView.getPSApplication();
        this.iPSPF = this.iPSApplication.getPSPF();
        this.iPSPFStyle = this.iPSAppView.getPSPFStyle();
        return this.onGenerateCode();
    }

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        PSGenerateCodeResultImpl psGenerateCodeResultImpl = new PSGenerateCodeResultImpl();
        psGenerateCodeResultImpl.setObject(this.iPSControl);
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("publisher", this);
        params.put("item", this.object);
        params.put("ctrl", this.iPSControl);
        params.put("app", this.iPSApplication);
        params.put("sys", this.iPSApplication.getPSSystem());
        params.put("view", this.iPSAppView);
        params.put("ctrltempl", this.iPSPFEditorTempl);
        params.put("codetempl", this.iPSPFEditorTempl);
        params.put("pf", this.iPSPF);
        params.put("pfstyle", this.iPSPFStyle);
        this.onFillGenerateCodeParams(params);
        PSPFEditorTempl psPFEditorTempl = this.iPSPFEditorTempl.getPSPFEditorTemplData();
        if (!StringHelper.IsNullOrEmpty((String)psPFEditorTempl.getTEMPLCODE())) {
            psGenerateCodeResultImpl.setCode(PSTemplHelper.generateCode((BaseDataEntity)psPFEditorTempl, "TEMPLCODE", params));
        }
        if (!StringHelper.IsNullOrEmpty((String)psPFEditorTempl.getTEMPLCODE2())) {
            psGenerateCodeResultImpl.setCode2(PSTemplHelper.generateCode((BaseDataEntity)psPFEditorTempl, "TEMPLCODE2", params));
        }
        if (!StringHelper.IsNullOrEmpty((String)psPFEditorTempl.getTEMPLCODE3())) {
            psGenerateCodeResultImpl.setCode3(PSTemplHelper.generateCode((BaseDataEntity)psPFEditorTempl, "TEMPLCODE3", params));
        }
        if (!StringHelper.IsNullOrEmpty((String)psPFEditorTempl.getTEMPLCODE4())) {
            psGenerateCodeResultImpl.setCode4(PSTemplHelper.generateCode((BaseDataEntity)psPFEditorTempl, "TEMPLCODE4", params));
        }
        psGenerateCodeResultImpl.setParams(params);
        return psGenerateCodeResultImpl;
    }

    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
    }

    @Override
    public void close() {
        this.iPSPublisherContext = null;
        this.iPSAppView = null;
        this.iPSApplication = null;
        this.iPSPF = null;
        this.iPSPFStyle = null;
        this.iPSControl = null;
        this.object = null;
        this.onClose();
        if (this.iPSPFEditorTempl != null) {
            this.iPSPFEditorTempl.releasePSPFEditorCodePublisher(this);
        }
    }

    @Override
    public IPSPublisherContext getContext() {
        return this.iPSPublisherContext;
    }
}

