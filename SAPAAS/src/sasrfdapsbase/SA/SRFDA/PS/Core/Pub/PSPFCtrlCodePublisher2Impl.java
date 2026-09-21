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
import SA.SRFDA.PS.Core.Control.IPSEditorContainer;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlPartCodeObject;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl;
import SA.SRFDA.PS.Core.PF.IPSPFEditorTempl;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PF.IPSPFStyle2;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisherContext;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPFEditorCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFDA.PS.Core.Pub.PSImportHelper;
import SA.SRFDA.PS.Core.Pub.PSPFCodePublisher2Impl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Data.PSAppViewCode;
import SA.SRFDA.PS.Data.PSPFCtrlTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFCtrlCodePublisher2Impl
extends PSPFCodePublisher2Impl
implements IPSPFCtrlCodePublisher {
    private static final Log log = LogFactory.getLog(PSPFCtrlCodePublisher2Impl.class);
    protected IPSPFCtrlTempl iPSPFCtrlTempl = null;
    protected IPSPublisherContext iPSPublisherContext = null;
    protected IPSAppView iPSAppView = null;
    protected IPSApplication iPSApplication = null;
    protected IPSPF iPSPF = null;
    protected IPSPFStyle iPSPFStyle = null;
    protected IPSControl iPSControl = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPFCtrlTempl iPSPFCtrlTempl) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSPFCtrlTempl = iPSPFCtrlTempl;
        this.setPSPFPubCode(this.iPSPFCtrlTempl.getPSPFPubCode());
        this.onInit();
    }

    @Override
    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl) throws Exception {
        return this.generateCode(iPSPublisherContext, iPSControl, null);
    }

    @Override
    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl, Map<String, Object> params) throws Exception {
        PSImportHelper psImportHelper = null;
        try {
            psImportHelper = new PSImportHelper();
            PSImportHelper.addHelper(psImportHelper);
            this.iPSControl = iPSControl;
            this.iPSPublisherContext = iPSPublisherContext;
            this.iPSAppView = iPSControl.getPSAppView();
            this.iPSApplication = this.iPSAppView.getPSApplication();
            if (iPSControl.isDesignMode()) {
                this.iPSPF = this.iPSPFCtrlTempl.getPSPF();
                this.iPSPFStyle = this.iPSPFCtrlTempl.getPSPFStyle();
            } else {
                this.iPSPF = this.iPSApplication.getPSPF();
                this.iPSPFStyle = this.iPSAppView.getPSPFStyle();
            }
            this.beforeGenerateCode();
            PSGenerateCodeResultImpl iPSGenerateCodeResult = null;
            iPSGenerateCodeResult = params != null ? this.onGenerateCode(params) : this.onGenerateCode(new HashMap<String, Object>());
            PSImportHelper.releaseHelper();
            psImportHelper = null;
            return iPSGenerateCodeResult;
        }
        catch (Exception ex) {
            if (psImportHelper != null) {
                PSImportHelper.releaseHelper();
            }
            log.error((Object)ex);
            throw ex;
        }
    }

    protected PSGenerateCodeResultImpl onGenerateCode(Map<String, Object> params) throws Exception {
        return this.onGenerateCode(params, null);
    }

    protected PSGenerateCodeResultImpl onGenerateCode(final Map<String, Object> params, PSAppViewCode psAppViewCode) throws Exception {
        PSGenerateCodeResultImpl psGenerateCodeResultImpl = new PSGenerateCodeResultImpl();
        psGenerateCodeResultImpl.setObject(this.iPSControl);
        params.put("ctrl", this.iPSControl);
        params.put("app", this.iPSApplication);
        params.put("sys", this.iPSApplication.getPSSystem());
        params.put("view", this.iPSAppView);
        if (this.iPSControl.getPSDataEntity() != null) {
            params.put("de", this.iPSControl.getPSDataEntity());
        }
        if (this.iPSControl.getPSAppDataEntity() != null) {
            params.put("appde", this.iPSControl.getPSAppDataEntity());
        }
        params.put("pf", this.iPSPF);
        params.put("pfstyle", this.iPSPFStyle);
        this.onFillGenerateCodeParams(params);
        params.put("P", new IPSPFCtrlCodePublisherContext(){

            @Override
            public IPSGenerateCodeResult getCtrlCode(Object objCtrl, String strCodeType) throws Exception {
                return PSPFCtrlCodePublisher2Impl.this.internalGetCtrlCode(objCtrl, strCodeType, params);
            }

            @Override
            public IPSGenerateCodeResult getCtrlCode(Object objCtrl) throws Exception {
                return this.getCtrlCode(objCtrl, "");
            }

            @Override
            public boolean hasCtrlCode(Object objCtrl, String strCodeType) throws Exception {
                return PSPFCtrlCodePublisher2Impl.this.internalHasCtrlCode(objCtrl, strCodeType);
            }

            @Override
            public boolean hasCtrlCode(Object objCtrl) throws Exception {
                return this.hasCtrlCode(objCtrl, "");
            }

            @Override
            public IPSGenerateCodeResult getPartCode(Object objPart) throws Exception {
                return this.getPartCode(objPart, null);
            }

            @Override
            public IPSGenerateCodeResult getPartCode(Object objPart, String strCodeType) throws Exception {
                return PSPFCtrlCodePublisher2Impl.this.internalGetPartCode(objPart, strCodeType, params);
            }

            @Override
            public boolean hasPartCode(Object objPart) throws Exception {
                return PSPFCtrlCodePublisher2Impl.this.internalTestPartCode(objPart);
            }

            @Override
            public IPSGenerateCodeResult getEditorCode(Object objItem) throws Exception {
                return this.getEditorCode(objItem, "");
            }

            @Override
            public IPSGenerateCodeResult getEditorCode(Object objItem, String strCodeType) throws Exception {
                return PSPFCtrlCodePublisher2Impl.this.internalGetEditorCode(objItem, strCodeType, params);
            }

            @Override
            public IPSGenerateCodeResult getLogicCode(Object objCtrl, String strCodeType) throws Exception {
                return PSPFCtrlCodePublisher2Impl.this.internalGetLogicCode(objCtrl, strCodeType, params);
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
                return PSPFCtrlCodePublisher2Impl.this.internalExists(strType, strParam, strParam2);
            }

            @Override
            public boolean set(String strParam, String strValue) {
                return PSPFCtrlCodePublisher2Impl.this.internalSet(strParam, strValue);
            }

            @Override
            public String get(String strParam, String strDefault) {
                return PSPFCtrlCodePublisher2Impl.this.internalGet(strParam, strDefault);
            }

            @Override
            public String get(String strParam) {
                return this.get(strParam, null);
            }
        });
        params.put("publisher", params.get("P"));
        PSPFCtrlTempl psPFCtrlTempl = this.iPSPFCtrlTempl.getPSPFCtrlTemplData();
        if (!StringHelper.IsNullOrEmpty((String)psPFCtrlTempl.getTEMPLCODE())) {
            psGenerateCodeResultImpl.setCode(PSTemplHelper.generateCode((BaseDataEntity)psPFCtrlTempl, "TEMPLCODE", params));
        }
        if (!StringHelper.IsNullOrEmpty((String)psPFCtrlTempl.getTEMPLCODE2())) {
            psGenerateCodeResultImpl.setCode2(PSTemplHelper.generateCode((BaseDataEntity)psPFCtrlTempl, "TEMPLCODE2", params));
        }
        if (!StringHelper.IsNullOrEmpty((String)psPFCtrlTempl.getTEMPLCODE3())) {
            psGenerateCodeResultImpl.setCode3(PSTemplHelper.generateCode((BaseDataEntity)psPFCtrlTempl, "TEMPLCODE3", params));
        }
        if (!StringHelper.IsNullOrEmpty((String)psPFCtrlTempl.getTEMPLCODE4())) {
            psGenerateCodeResultImpl.setCode4(PSTemplHelper.generateCode((BaseDataEntity)psPFCtrlTempl, "TEMPLCODE4", params));
        }
        if (psAppViewCode != null) {
            psAppViewCode.setPUBCODE(psGenerateCodeResultImpl.getCode());
            if (!StringHelper.IsNullOrEmpty((String)psPFCtrlTempl.getCODEPATH())) {
                psAppViewCode.setCODEPATH(PSTemplHelper.generateCode((BaseDataEntity)psPFCtrlTempl, "CODEPATH", params));
            }
            if (!StringHelper.IsNullOrEmpty((String)psPFCtrlTempl.getFILENAME())) {
                psAppViewCode.setPSAPPVIEWCODENAME(PSTemplHelper.generateCode((BaseDataEntity)psPFCtrlTempl, "FILENAME", params));
            }
            if (!StringHelper.IsNullOrEmpty((String)this.iPSApplication.getProjectPath())) {
                psAppViewCode.setPRJPATH(PSTemplHelper.generateCode(this.iPSApplication.getProjectPath(), params));
            }
            psAppViewCode.set("TEMPLCODE", this.iPSPFCtrlTempl.getPSPFCtrlTemplData().getTEMPLCODE());
        }
        return psGenerateCodeResultImpl;
    }

    protected void onFillGenerateCodeParams(Map<String, Object> params) throws Exception {
    }

    @Override
    public void close() {
        this.iPSPublisherContext = null;
        this.iPSAppView = null;
        this.iPSApplication = null;
        this.iPSPF = null;
        this.iPSPFStyle = null;
        this.iPSControl = null;
        this.onClose();
        this.iPSPFCtrlTempl.releasePSPFCtrlCodePublisher(this);
    }

    protected IPSPFCtrlTempl getPSPFCtrlTempl() {
        return this.iPSPFCtrlTempl;
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
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public boolean hasCodePart(String strCodePart) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
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

    protected IPSGenerateCodeResult internalGetPartCode(Object objPart, String strCodeType, Map<String, Object> params) throws Exception {
        Object objItem = null;
        if (StringHelper.IsNullOrEmpty((String)strCodeType)) {
            if (objPart instanceof IPSPFCtrlPartCodeObject) {
                strCodeType = ((IPSPFCtrlPartCodeObject)objPart).getPFPartCodeType();
                objItem = objPart;
            } else {
                strCodeType = objPart instanceof String ? (String)objPart : objPart.toString();
            }
        } else {
            objItem = objPart;
        }
        HashMap<String, Object> params2 = new HashMap<String, Object>();
        params2.putAll(params);
        IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(strCodeType).getPSPFCtrlPartCodePublisher();
        IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, this, this.iPSControl, objItem, params2);
        iPSPFCtrlPartCodePublisher.close();
        return iPSGenerateCodeResult;
    }

    protected boolean internalTestPartCode(Object objPart) throws Exception {
        if (objPart instanceof IPSPFCtrlPartCodeObject) {
            return this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(((IPSPFCtrlPartCodeObject)objPart).getPFPartCodeType(), true) != null;
        }
        if (objPart instanceof String) {
            return this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail((String)objPart, true) != null;
        }
        return this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(objPart.toString(), true) != null;
    }

    protected IPSGenerateCodeResult internalGetEditorCode(Object objEditor, String strCodeType, Map<String, Object> params) throws Exception {
        IPSPFEditorTempl iPSPFEditorTempl;
        if (!(objEditor instanceof IPSEditorContainer)) {
            throw new Exception(StringHelper.Format((String)"\u4f20\u5165\u5bf9\u8c61\u4e0d\u662f\u7f16\u8f91\u5668"));
        }
        IPSEditorContainer iPSEditor = (IPSEditorContainer)objEditor;
        IPSPFPubCode iPSPFPubCode = null;
        if (!StringHelper.IsNullOrEmpty((String)strCodeType)) {
            iPSPFPubCode = this.iPSPFStyle.getPSPFPubCode(strCodeType, true);
            if (iPSPFPubCode == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u53d1\u5e03\u4ee3\u7801[%1$s]", (Object)strCodeType));
            }
        } else {
            iPSPFPubCode = this.getPSPFPubCode();
        }
        if ((iPSPFEditorTempl = this.getPSPFStyle2().getPSPFEditorTempl(iPSEditor, iPSPFPubCode)) != null) {
            HashMap<String, Object> params2 = new HashMap<String, Object>();
            params2.putAll(params);
            IPSPFEditorCodePublisher iPSPFEditorCodePublisher = iPSPFEditorTempl.getPSPFEditorCodePublisher();
            IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFEditorCodePublisher.generateCode(this.iPSPublisherContext, this.iPSControl, objEditor);
            iPSPFEditorCodePublisher.close();
            return iPSGenerateCodeResult;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7f16\u8f91\u5668[%1$s]\u53d1\u5e03\u4ee3\u7801[%2$s]", (Object)iPSEditor.getPSEditorType().getId(), (Object)iPSPFPubCode.getName()));
    }

    @Override
    public IPSPFStyle2 getPSPFStyle2() {
        return (IPSPFStyle2)this.iPSPFStyle;
    }
}

