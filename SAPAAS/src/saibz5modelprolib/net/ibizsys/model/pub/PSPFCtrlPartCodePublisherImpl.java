/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.IPSApplication
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.pub;

import java.util.HashMap;
import java.util.Map;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.app.IPSApplication;
import net.ibizsys.model.app.IPSApplicationRuntime;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRuntime;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.entity.PSPFCtrlTemplDetail;
import net.ibizsys.model.pf.IPSPF;
import net.ibizsys.model.pf.IPSPFCtrlTempl;
import net.ibizsys.model.pf.IPSPFCtrlTemplDetail;
import net.ibizsys.model.pf.IPSPFCtrlTemplDetailRuntime;
import net.ibizsys.model.pf.IPSPFStyle;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFCtrlCodePublisher;
import net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;
import net.ibizsys.model.pub.PSPFCodePublisherImpl;
import net.ibizsys.model.pub.util.PSTemplHelper;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFCtrlPartCodePublisherImpl
extends PSPFCodePublisherImpl
implements IPSPFCtrlPartCodePublisher {
    private static final Log log = LogFactory.getLog(PSPFCtrlPartCodePublisherImpl.class);
    protected IPSPFCtrlTemplDetail iPSPFCtrlTemplDetail = null;
    private IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher = null;
    protected IPSAppView iPSAppView = null;
    protected IPSApplication iPSApplication = null;
    protected IPSPF iPSPF = null;
    protected IPSPFStyle iPSPFStyle = null;
    protected IPSControl iPSControl = null;
    protected Object object = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSPFCtrlTemplDetail iPSPFCtrlTemplDetail) throws Exception {
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.iPSPFCtrlTemplDetail = iPSPFCtrlTemplDetail;
        this.setPSPFPubCode(this.iPSPFCtrlTemplDetail.getPSPFPubCode());
        this.onInit();
    }

    protected IPSPFCtrlTempl getPSPFCtrlTempl() {
        return this.iPSPFCtrlTemplDetail.getPSPFCtrlTempl();
    }

    @Override
    public IPSGenerateCodeResult generateCode(IPSControl iPSControl, Object object) throws Exception {
        return this.generateCode(iPSControl, object, null);
    }

    @Override
    public IPSGenerateCodeResult generateCode(IPSControl iPSControl, Object object, Map<String, Object> params) throws Exception {
        return this.generateCode(null, iPSControl, object, params);
    }

    @Override
    public IPSGenerateCodeResult generateCode(IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher, IPSControl iPSControl, Object object, Map<String, Object> params) throws Exception {
        this.object = object;
        this.iPSControl = iPSControl;
        this.iPSPFCtrlCodePublisher = iPSPFCtrlCodePublisher;
        this.iPSAppView = iPSControl.getPSAppView();
        this.iPSApplication = this.iPSAppView.getPSApplication();
        this.iPSPF = ((IPSApplicationRuntime)this.iPSApplication).getPSPF();
        this.iPSPFStyle = ((IPSAppViewRuntime)this.iPSAppView).getPSPFStyle();
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
        this.onFillGenerateCodeParams(params);
        PSPFCtrlTemplDetail psPFCtrlTemplDetail = ((IPSPFCtrlTemplDetailRuntime)this.iPSPFCtrlTemplDetail).getPSPFCtrlTemplDetailData();
        if (!StringHelper.isNullOrEmpty((String)psPFCtrlTemplDetail.getTEMPLCODE())) {
            psGenerateCodeResultImpl.setCode(PSTemplHelper.generateCode((IEntity)psPFCtrlTemplDetail, "TEMPLCODE", params));
        }
        if (!StringHelper.isNullOrEmpty((String)psPFCtrlTemplDetail.getTEMPLCODE2())) {
            psGenerateCodeResultImpl.setCode2(PSTemplHelper.generateCode((IEntity)psPFCtrlTemplDetail, "TEMPLCODE2", params));
        }
        if (!StringHelper.isNullOrEmpty((String)psPFCtrlTemplDetail.getTEMPLCODE3())) {
            psGenerateCodeResultImpl.setCode3(PSTemplHelper.generateCode((IEntity)psPFCtrlTemplDetail, "TEMPLCODE3", params));
        }
        if (!StringHelper.isNullOrEmpty((String)psPFCtrlTemplDetail.getTEMPLCODE4())) {
            psGenerateCodeResultImpl.setCode4(PSTemplHelper.generateCode((IEntity)psPFCtrlTemplDetail, "TEMPLCODE4", params));
        }
        psGenerateCodeResultImpl.setParams(params);
        return psGenerateCodeResultImpl;
    }

    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
    }

    protected IPSPFStyle getPSPFStyle() {
        return this.iPSPFStyle;
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

