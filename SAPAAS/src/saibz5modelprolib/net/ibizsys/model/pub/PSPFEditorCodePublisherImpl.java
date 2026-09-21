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
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.app.IPSApplication;
import net.ibizsys.model.app.IPSApplicationRuntime;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRuntime;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.entity.PSPFEditorTempl;
import net.ibizsys.model.pf.IPSPF;
import net.ibizsys.model.pf.IPSPFEditorTempl;
import net.ibizsys.model.pf.IPSPFEditorTemplRuntime;
import net.ibizsys.model.pf.IPSPFStyle;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFEditorCodePublisher;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;
import net.ibizsys.model.pub.PSPFCodePublisherImpl;
import net.ibizsys.model.pub.util.PSTemplHelper;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFEditorCodePublisherImpl
extends PSPFCodePublisherImpl
implements IPSPFEditorCodePublisher {
    private static final Log log = LogFactory.getLog(PSPFEditorCodePublisherImpl.class);
    protected IPSPFEditorTempl iPSPFEditorTempl = null;
    protected IPSAppView iPSAppView = null;
    protected IPSApplication iPSApplication = null;
    protected IPSPF iPSPF = null;
    protected IPSPFStyle iPSPFStyle = null;
    protected IPSControl iPSControl = null;
    protected Object object = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSPFEditorTempl iPSPFEditorTempl) throws Exception {
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.iPSPFEditorTempl = iPSPFEditorTempl;
        this.setPSPFPubCode(this.iPSPFEditorTempl.getPSPFPubCode());
        this.onInit();
    }

    @Override
    public IPSGenerateCodeResult generateCode(IPSControl iPSControl, Object object) throws Exception {
        this.object = object;
        this.iPSControl = iPSControl;
        this.iPSAppView = iPSControl.getPSAppView();
        this.iPSApplication = this.iPSAppView.getPSApplication();
        this.iPSPF = ((IPSApplicationRuntime)this.iPSApplication).getPSPF();
        this.iPSPFStyle = ((IPSAppViewRuntime)this.iPSAppView).getPSPFStyle();
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
        PSPFEditorTempl psPFEditorTempl = ((IPSPFEditorTemplRuntime)this.iPSPFEditorTempl).getPSPFEditorTemplData();
        if (!StringHelper.isNullOrEmpty((String)psPFEditorTempl.getTEMPLCODE())) {
            psGenerateCodeResultImpl.setCode(PSTemplHelper.generateCode((IEntity)psPFEditorTempl, "TEMPLCODE", params));
        }
        if (!StringHelper.isNullOrEmpty((String)psPFEditorTempl.getTEMPLCODE2())) {
            psGenerateCodeResultImpl.setCode2(PSTemplHelper.generateCode((IEntity)psPFEditorTempl, "TEMPLCODE2", params));
        }
        if (!StringHelper.isNullOrEmpty((String)psPFEditorTempl.getTEMPLCODE3())) {
            psGenerateCodeResultImpl.setCode3(PSTemplHelper.generateCode((IEntity)psPFEditorTempl, "TEMPLCODE3", params));
        }
        if (!StringHelper.isNullOrEmpty((String)psPFEditorTempl.getTEMPLCODE4())) {
            psGenerateCodeResultImpl.setCode4(PSTemplHelper.generateCode((IEntity)psPFEditorTempl, "TEMPLCODE4", params));
        }
        psGenerateCodeResultImpl.setParams(params);
        return psGenerateCodeResultImpl;
    }

    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
    }
}

