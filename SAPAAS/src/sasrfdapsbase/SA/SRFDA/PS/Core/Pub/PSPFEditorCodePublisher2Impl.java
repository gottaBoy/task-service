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
import SA.SRFDA.PS.Core.Control.IPSEditor;
import SA.SRFDA.PS.Core.Control.IPSEditorContainer;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl;
import SA.SRFDA.PS.Core.PF.IPSPFEditorTempl;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PF.IPSPFStyle2;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPFEditorCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPFEditorCodePublisherContext;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFDA.PS.Core.Pub.PSPFCodePublisher2Impl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Data.PSPFEditorTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFEditorCodePublisher2Impl
extends PSPFCodePublisher2Impl
implements IPSPFEditorCodePublisher {
    private static final Log log = LogFactory.getLog(PSPFEditorCodePublisher2Impl.class);
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
        this.beforeGenerateCode();
        return this.onGenerateCode();
    }

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        IPSEditor iPSEditor;
        PSGenerateCodeResultImpl psGenerateCodeResultImpl = new PSGenerateCodeResultImpl();
        psGenerateCodeResultImpl.setObject(this.iPSControl);
        final HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("item", this.object);
        params.put("ctrl", this.iPSControl);
        params.put("app", this.iPSApplication);
        params.put("sys", this.iPSApplication.getPSSystem());
        params.put("view", this.iPSAppView);
        if (this.object instanceof IPSEditorContainer && (iPSEditor = ((IPSEditorContainer)this.object).getPSEditor()) != null) {
            params.put("editor", iPSEditor);
        }
        this.onFillGenerateCodeParams(params);
        params.put("P", new IPSPFEditorCodePublisherContext(){

            @Override
            public IPSGenerateCodeResult getCtrlCode(Object objCtrl, String strCodeType) throws Exception {
                return PSPFEditorCodePublisher2Impl.this.internalGetCtrlCode(objCtrl, strCodeType, params);
            }

            @Override
            public IPSGenerateCodeResult getCtrlCode(Object objCtrl) throws Exception {
                return this.getCtrlCode(objCtrl, "");
            }

            @Override
            public boolean hasCtrlCode(Object objCtrl, String strCodeType) throws Exception {
                return PSPFEditorCodePublisher2Impl.this.internalHasCtrlCode(objCtrl, strCodeType);
            }

            @Override
            public boolean hasCtrlCode(Object objCtrl) throws Exception {
                return this.hasCtrlCode(objCtrl, "");
            }

            @Override
            public IPSGenerateCodeResult getLogicCode(Object objCtrl, String strCodeType) throws Exception {
                return PSPFEditorCodePublisher2Impl.this.internalGetLogicCode(objCtrl, strCodeType, params);
            }

            @Override
            public boolean exists(String strType) {
                return this.exists(strType, "", "");
            }

            @Override
            public boolean exists(String strType, String strParam) {
                return this.exists(strType, strParam, "");
            }

            @Override
            public boolean exists(String strType, String strParam, String strParam2) {
                return PSPFEditorCodePublisher2Impl.this.internalExists(strType, strParam, strParam2);
            }

            @Override
            public boolean set(String strParam, String strValue) {
                return PSPFEditorCodePublisher2Impl.this.internalSet(strParam, strValue);
            }

            @Override
            public String get(String strParam, String strDefault) {
                return PSPFEditorCodePublisher2Impl.this.internalGet(strParam, strDefault);
            }

            @Override
            public String get(String strParam) {
                return this.get(strParam, null);
            }
        });
        params.put("publisher", params.get("P"));
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

    protected boolean internalHasCtrlCode(Object objCtrl, String strCodeType) throws Exception {
        IPSPFCtrlTempl iPSPFCtrlTempl;
        IPSControl iPSControl = null;
        iPSControl = objCtrl instanceof IPSControl ? (IPSControl)objCtrl : (objCtrl instanceof String ? this.iPSAppView.getPSControl((String)objCtrl) : this.iPSAppView.getPSControl(objCtrl.toString()));
        IPSPFPubCode iPSPFPubCode = null;
        if (!StringHelper.IsNullOrEmpty((String)strCodeType)) {
            iPSPFPubCode = this.iPSPFStyle.getPSPFPubCode(strCodeType, true);
            if (iPSPFPubCode == null) {
                return false;
            }
        } else {
            iPSPFPubCode = this.getPSPFPubCode();
        }
        return (iPSPFCtrlTempl = this.getPSPFStyle2().getPSPFCtrlTempl(iPSControl, iPSPFPubCode)) != null;
    }

    protected IPSGenerateCodeResult internalGetCtrlCode(Object objCtrl, String strCodeType, Map<String, Object> params) throws Exception {
        IPSPFCtrlTempl iPSPFCtrlTempl;
        IPSControl iPSControl = null;
        iPSControl = objCtrl instanceof IPSControl ? (IPSControl)objCtrl : (objCtrl instanceof String ? this.iPSAppView.getPSControl((String)objCtrl) : this.iPSAppView.getPSControl(objCtrl.toString()));
        IPSPFPubCode iPSPFPubCode = null;
        if (!StringHelper.IsNullOrEmpty((String)strCodeType)) {
            iPSPFPubCode = this.iPSPFStyle.getPSPFPubCode(strCodeType, true);
            if (iPSPFPubCode == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u53d1\u5e03\u4ee3\u7801[%1$s]", (Object)strCodeType));
            }
        } else {
            iPSPFPubCode = this.getPSPFPubCode();
        }
        if ((iPSPFCtrlTempl = this.getPSPFStyle2().getPSPFCtrlTempl(iPSControl, iPSPFPubCode)) != null) {
            HashMap<String, Object> params2 = new HashMap<String, Object>();
            params2.putAll(params);
            IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher = iPSPFCtrlTempl.getPSPFCtrlCodePublisher();
            IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlCodePublisher.generateCode(this.iPSPublisherContext, iPSControl, params2);
            iPSPFCtrlCodePublisher.close();
            return iPSGenerateCodeResult;
        }
        if (StringHelper.IsNullOrEmpty((String)iPSControl.getControlStyle())) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u90e8\u4ef6[%1$s]\u53d1\u5e03\u4ee3\u7801[%2$s]", (Object)iPSControl.getControlType(), (Object)iPSPFPubCode.getName()));
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u90e8\u4ef6[%1$s#%2$s]\u53d1\u5e03\u4ee3\u7801[%3$s]", (Object)iPSControl.getControlType(), (Object)iPSControl.getControlStyle(), (Object)iPSPFPubCode.getName()));
    }

    @Override
    public IPSPFStyle2 getPSPFStyle2() {
        return (IPSPFStyle2)this.iPSPFStyle;
    }
}

