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
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTemplDetail;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFDA.PS.Core.Pub.PSPFCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Data.PSPFCtrlTemplDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFCtrlPartCodePublisherImpl
extends PSPFCodePublisherImpl
implements IPSPFCtrlPartCodePublisher {
    private static final Log log = LogFactory.getLog(PSPFCtrlPartCodePublisherImpl.class);
    protected IPSPFCtrlTemplDetail iPSPFCtrlTemplDetail = null;
    private IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher = null;
    protected IPSPublisherContext iPSPublisherContext = null;
    protected IPSAppView iPSAppView = null;
    protected IPSApplication iPSApplication = null;
    protected IPSPF iPSPF = null;
    protected IPSPFStyle iPSPFStyle = null;
    protected IPSControl iPSControl = null;
    protected Object object = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPFCtrlTemplDetail iPSPFCtrlTemplDetail) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSPFCtrlTemplDetail = iPSPFCtrlTemplDetail;
        this.setPSPFPubCode(this.iPSPFCtrlTemplDetail.getPSPFPubCode());
        this.onInit();
    }

    protected IPSPFCtrlTempl getPSPFCtrlTempl() {
        return this.iPSPFCtrlTemplDetail.getPSPFCtrlTempl();
    }

    @Override
    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl, Object object) throws Exception {
        return this.generateCode(iPSPublisherContext, iPSControl, object, null);
    }

    @Override
    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl, Object object, Map<String, Object> params) throws Exception {
        return this.generateCode(iPSPublisherContext, null, iPSControl, object, params);
    }

    @Override
    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher, IPSControl iPSControl, Object object, Map<String, Object> params) throws Exception {
        this.object = object;
        this.iPSControl = iPSControl;
        this.iPSPublisherContext = iPSPublisherContext;
        this.iPSPFCtrlCodePublisher = iPSPFCtrlCodePublisher;
        this.iPSAppView = iPSControl.getPSAppView();
        this.iPSApplication = this.iPSAppView.getPSApplication();
        if (iPSControl.isDesignMode()) {
            this.iPSPF = this.iPSPFCtrlTemplDetail.getPSPFCtrlTempl().getPSPF();
            this.iPSPFStyle = this.iPSPFCtrlTemplDetail.getPSPFCtrlTempl().getPSPFStyle();
        } else {
            this.iPSPF = this.iPSApplication.getPSPF();
            this.iPSPFStyle = this.iPSAppView.getPSPFStyle();
        }
        if (params == null) {
            return this.onGenerateCode();
        }
        return this.onGenerateCode((HashMap)params);
    }

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        return this.onGenerateCode(null);
    }

    protected PSGenerateCodeResultImpl onGenerateCode(HashMap<String, Object> params) throws Exception {
        PSGenerateCodeResultImpl psGenerateCodeResultImpl = new PSGenerateCodeResultImpl();
        psGenerateCodeResultImpl.setObject(this.object);
        if (params == null) {
            params = new HashMap();
        }
        params.put("publisher", this);
        params.put("item", this.object);
        params.put("ctrl", this.iPSControl);
        params.put("app", this.iPSApplication);
        params.put("sys", this.iPSApplication.getPSSystem());
        params.put("view", this.iPSAppView);
        params.put("ctrltempl", this.iPSPFCtrlTemplDetail);
        params.put("codetempl", this.iPSPFCtrlTemplDetail);
        params.put("pf", this.iPSPF);
        params.put("pfstyle", this.iPSPFStyle);
        String strFullClassName = this.iPSApplication.getPKGCodeName();
        if (!StringHelper.IsNullOrEmpty((String)this.getPSPFPubCode().getPKGCodeName())) {
            strFullClassName = String.valueOf(strFullClassName) + StringHelper.Format((String)".%1$s", (Object)this.getPSPFPubCode().getPKGCodeName());
        }
        if (!StringHelper.IsNullOrEmpty((String)strFullClassName)) {
            strFullClassName = String.valueOf(strFullClassName) + StringHelper.Format((String)".");
        }
        strFullClassName = String.valueOf(strFullClassName) + this.iPSAppView.getFullCodeName();
        params.put("viewfullname2", strFullClassName);
        params.put("oriviewfullname", strFullClassName);
        strFullClassName = String.valueOf(strFullClassName) + this.getPSPFPubCode().getClassNameExt();
        params.put("viewfullname", strFullClassName);
        this.onFillGenerateCodeParams(params);
        PSPFCtrlTemplDetail psPFCtrlTemplDetail = this.iPSPFCtrlTemplDetail.getPSPFCtrlTemplDetailData();
        if (!StringHelper.IsNullOrEmpty((String)psPFCtrlTemplDetail.getTEMPLCODE())) {
            psGenerateCodeResultImpl.setCode(PSTemplHelper.generateCode((BaseDataEntity)psPFCtrlTemplDetail, "TEMPLCODE", params));
        }
        if (!StringHelper.IsNullOrEmpty((String)psPFCtrlTemplDetail.getTEMPLCODE2())) {
            psGenerateCodeResultImpl.setCode2(PSTemplHelper.generateCode((BaseDataEntity)psPFCtrlTemplDetail, "TEMPLCODE2", params));
        }
        if (!StringHelper.IsNullOrEmpty((String)psPFCtrlTemplDetail.getTEMPLCODE3())) {
            psGenerateCodeResultImpl.setCode3(PSTemplHelper.generateCode((BaseDataEntity)psPFCtrlTemplDetail, "TEMPLCODE3", params));
        }
        if (!StringHelper.IsNullOrEmpty((String)psPFCtrlTemplDetail.getTEMPLCODE4())) {
            psGenerateCodeResultImpl.setCode4(PSTemplHelper.generateCode((BaseDataEntity)psPFCtrlTemplDetail, "TEMPLCODE4", params));
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
        this.iPSPFCtrlCodePublisher = null;
        this.onClose();
        if (this.iPSPFCtrlTemplDetail != null) {
            this.iPSPFCtrlTemplDetail.releasePSPFCtrlPartCodePublisher(this);
        }
    }

    protected IPSPFStyle getPSPFStyle() {
        return this.iPSPFStyle;
    }

    @Override
    public IPSPublisherContext getContext() {
        return this.iPSPublisherContext;
    }

    @Override
    public String getCodePart(String strCodePart, Object objItem) throws Exception {
        if (this.iPSPFCtrlCodePublisher == null) {
            throw new Exception("\u90e8\u4ef6\u4ee3\u7801\u53d1\u5e03\u5668\u5bf9\u8c61\u65e0\u6548");
        }
        return this.iPSPFCtrlCodePublisher.getCodePart(strCodePart, objItem);
    }

    @Override
    public boolean hasCodePart(String strCodePart) throws Exception {
        if (this.iPSPFCtrlCodePublisher == null) {
            throw new Exception("\u90e8\u4ef6\u4ee3\u7801\u53d1\u5e03\u5668\u5bf9\u8c61\u65e0\u6548");
        }
        return this.iPSPFCtrlCodePublisher.hasCodePart(strCodePart);
    }
}

