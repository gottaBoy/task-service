/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.IPSApplication
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.IPSControlContainer
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.pub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.app.IPSApplication;
import net.ibizsys.model.app.IPSApplicationRuntime;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRuntime;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.IPSControlContainer;
import net.ibizsys.model.entity.PSPFCtrlTempl;
import net.ibizsys.model.pf.IPSPF;
import net.ibizsys.model.pf.IPSPFCtrlTempl;
import net.ibizsys.model.pf.IPSPFCtrlTemplDetailRuntime;
import net.ibizsys.model.pf.IPSPFCtrlTemplRuntime;
import net.ibizsys.model.pf.IPSPFStyle;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFCtrlCodePublisher;
import net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;
import net.ibizsys.model.pub.PSPFCodePublisherImpl;
import net.ibizsys.model.pub.util.PSCtrlMethod;
import net.ibizsys.model.pub.util.PSSubCodeMethod;
import net.ibizsys.model.pub.util.PSTemplHelper;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFCtrlCodePublisherImpl
extends PSPFCodePublisherImpl
implements IPSPFCtrlCodePublisher {
    private static final Log log = LogFactory.getLog(PSPFCtrlCodePublisherImpl.class);
    protected IPSPFCtrlTempl iPSPFCtrlTempl = null;
    protected IPSAppView iPSAppView = null;
    protected IPSApplication iPSApplication = null;
    protected IPSPF iPSPF = null;
    protected IPSPFStyle iPSPFStyle = null;
    protected IPSControl iPSControl = null;
    private String strCodeFolder = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSPFCtrlTempl iPSPFCtrlTempl) throws Exception {
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.iPSPFCtrlTempl = iPSPFCtrlTempl;
        this.setPSPFPubCode(this.iPSPFCtrlTempl.getPSPFPubCode());
        this.onInit();
    }

    @Override
    public IPSGenerateCodeResult generateCode(IPSControl iPSControl) throws Exception {
        return this.generateCode(iPSControl, null);
    }

    @Override
    public IPSGenerateCodeResult generateCode(IPSControl iPSControl, Map<String, Object> params) throws Exception {
        try {
            this.iPSControl = iPSControl;
            this.iPSAppView = iPSControl.getPSAppView();
            this.iPSApplication = this.iPSAppView.getPSApplication();
            this.iPSPF = ((IPSApplicationRuntime)this.iPSApplication).getPSPF();
            this.iPSPFStyle = ((IPSAppViewRuntime)this.iPSAppView).getPSPFStyle();
            PSGenerateCodeResultImpl iPSGenerateCodeResult = null;
            iPSGenerateCodeResult = params != null ? this.onGenerateCode((HashMap)params) : this.onGenerateCode();
            return iPSGenerateCodeResult;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            throw ex;
        }
    }

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        return this.onGenerateCode(null);
    }

    protected PSGenerateCodeResultImpl onGenerateCode(HashMap<String, Object> params) throws Exception {
        PSGenerateCodeResultImpl psGenerateCodeResultImpl = new PSGenerateCodeResultImpl();
        psGenerateCodeResultImpl.setObject(this.iPSControl);
        PSCtrlMethod psCtrlMethod = new PSCtrlMethod();
        PSSubCodeMethod psSubCodeMethod = new PSSubCodeMethod();
        if (params == null) {
            params = new HashMap();
        }
        params.put("publisher", this);
        params.put("ctrl", this.iPSControl);
        params.put("app", this.iPSApplication);
        params.put("sys", this.iPSApplication.getPSSystem());
        params.put("view", this.iPSAppView);
        params.put("ctrltempl", this.iPSPFCtrlTempl);
        params.put("codetempl", this.iPSPFCtrlTempl);
        params.put("pf", this.iPSPF);
        params.put("pfstyle", this.iPSPFStyle);
        psCtrlMethod.resetCtrlResult();
        params.put("srfctrl", psCtrlMethod);
        if (params.get("srfviewctrl") == null) {
            params.put("srfviewctrl", psCtrlMethod);
        }
        psSubCodeMethod.resetSubCode();
        params.put("srfsubcode", psSubCodeMethod);
        if (this.iPSControl instanceof IPSControlContainer) {
            IPSControlContainer iPSControlContainer = (IPSControlContainer)this.iPSControl;
            ArrayList<IPSGenerateCodeResult> psGenerateCodeResultList = new ArrayList<IPSGenerateCodeResult>();
            Iterator psControls = iPSControlContainer.getPSControls();
            while (psControls.hasNext()) {
                IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher;
                IPSGenerateCodeResult iPSGenerateCodeResult;
                IPSControl iPSControl = (IPSControl)psControls.next();
                IPSPFCtrlTempl iPSPFCtrlTempl = this.iPSPFStyle.getPSPFCtrlTempl(iPSControl.getPSControlType(), this.getPSPFPubCode());
                if (iPSPFCtrlTempl == null || (iPSGenerateCodeResult = (iPSPFCtrlCodePublisher = ((IPSPFCtrlTemplRuntime)iPSPFCtrlTempl).getPSPFCtrlCodePublisher()).generateCode(iPSControl)) == null) continue;
                params.put(iPSControl.getName(), iPSGenerateCodeResult);
                psGenerateCodeResultList.add(iPSGenerateCodeResult);
                psCtrlMethod.registerCtrlResult(iPSControl.getName(), iPSGenerateCodeResult);
            }
            params.put("ctrls", psGenerateCodeResultList);
        }
        this.onFillGenerateCodeParams(params);
        PSPFCtrlTempl psPFCtrlTempl = ((IPSPFCtrlTemplRuntime)this.iPSPFCtrlTempl).getPSPFCtrlTemplData();
        if (!StringHelper.isNullOrEmpty((String)psPFCtrlTempl.getTEMPLCODE())) {
            psGenerateCodeResultImpl.setCode(PSTemplHelper.generateCode((IEntity)psPFCtrlTempl, "TEMPLCODE", params));
        }
        if (!StringHelper.isNullOrEmpty((String)psPFCtrlTempl.getTEMPLCODE2())) {
            psGenerateCodeResultImpl.setCode2(PSTemplHelper.generateCode((IEntity)psPFCtrlTempl, "TEMPLCODE2", params));
        }
        if (!StringHelper.isNullOrEmpty((String)psPFCtrlTempl.getTEMPLCODE3())) {
            psGenerateCodeResultImpl.setCode3(PSTemplHelper.generateCode((IEntity)psPFCtrlTempl, "TEMPLCODE3", params));
        }
        if (!StringHelper.isNullOrEmpty((String)psPFCtrlTempl.getTEMPLCODE4())) {
            psGenerateCodeResultImpl.setCode4(PSTemplHelper.generateCode((IEntity)psPFCtrlTempl, "TEMPLCODE4", params));
        }
        psGenerateCodeResultImpl.setParams(params);
        return psGenerateCodeResultImpl;
    }

    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
    }

    @Override
    public String generateCode2(IPSControl iPSControl, Map<String, Object> params) throws Exception {
        try {
            this.iPSControl = iPSControl;
            this.iPSAppView = iPSControl.getPSAppView();
            this.iPSApplication = this.iPSAppView.getPSApplication();
            this.iPSPF = ((IPSApplicationRuntime)this.iPSApplication).getPSPF();
            this.iPSPFStyle = ((IPSAppViewRuntime)this.iPSAppView).getPSPFStyle();
            String strCode = this.onGenerateCode2(params);
            return strCode;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            throw ex;
        }
    }

    protected String onGenerateCode2(Map<String, Object> params) throws Exception {
        HashMap<String, Object> map = new HashMap<String, Object>();
        if (params != null) {
            map.putAll(params);
        }
        PSGenerateCodeResultImpl psGenerateCodeResultImpl = this.onGenerateCode(map);
        String strCode = psGenerateCodeResultImpl.getCode();
        return strCode;
    }

    protected IPSPFCtrlTempl getPSPFCtrlTempl() {
        return this.iPSPFCtrlTempl;
    }

    protected IPSPFStyle getPSPFStyle() {
        return this.iPSPFStyle;
    }

    @Override
    public String getCodePart(String strCodePart, Object objItem) throws Exception {
        IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = ((IPSPFCtrlTemplDetailRuntime)this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(strCodePart)).getPSPFCtrlPartCodePublisher();
        IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this, this.iPSControl, objItem, null);
        return iPSGenerateCodeResult.getCode();
    }

    @Override
    public boolean hasCodePart(String strCodePart) throws Exception {
        return this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(strCodePart, true) != null;
    }
}

