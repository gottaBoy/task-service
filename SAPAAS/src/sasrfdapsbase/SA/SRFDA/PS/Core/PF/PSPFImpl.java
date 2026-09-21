/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.WebUtility
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.App.IPSAppType;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.JIT.App.IPSJITAppModel;
import SA.SRFDA.PS.Core.JIT.App.PSJITAppModel;
import SA.SRFDA.PS.Core.PF.IPSPF2;
import SA.SRFDA.PS.Core.PF.IPSPFCodeFolder;
import SA.SRFDA.PS.Core.PF.IPSPFEditorTempl;
import SA.SRFDA.PS.Core.PF.IPSPFPkg;
import SA.SRFDA.PS.Core.PF.IPSPFPkgVer;
import SA.SRFDA.PS.Core.PF.IPSPFPkgVerCDN;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.IPSPFPubObj;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PF.PSPFCodeFolderGlobalModel;
import SA.SRFDA.PS.Core.PF.PSPFEditorTemplGlobalModel;
import SA.SRFDA.PS.Core.PF.PSPFPkgGlobalModel;
import SA.SRFDA.PS.Core.PF.PSPFPkgVerCDNGlobalModel;
import SA.SRFDA.PS.Core.PF.PSPFPkgVerGlobalModel;
import SA.SRFDA.PS.Core.PF.PSPFPubCodeImpl;
import SA.SRFDA.PS.Core.PF.PSPFPubObjGlobalModel;
import SA.SRFDA.PS.Core.PF.PSPFStyle2Impl;
import SA.SRFDA.PS.Core.PF.PSPFStyleGlobalModel;
import SA.SRFDA.PS.Core.PF.PSPFStyleImpl;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSPFAppCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPFEditorCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPFUIActionCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPFViewCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPFViewLogicCodePublisher;
import SA.SRFDA.PS.Data.PSAppModule;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.PS.Data.PSPF;
import SA.SRFDA.PS.Data.PSPFPubCode;
import SA.SRFDA.PS.Data.PSPFStyle;
import SA.SRFDA.PS.Data.PSSubAppView;
import SA.SRFDA.PS.Data.PSSysApp;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.WebUtility;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFImpl
extends PSObjectImpl
implements IPSPF2 {
    protected PSPF psPF = null;
    private static final Log log = LogFactory.getLog(PSPFImpl.class);
    protected PSPFCodeFolderGlobalModel psPFCodeFolderGlobalModel = new PSPFCodeFolderGlobalModel();
    protected PSPFStyleGlobalModel psPFStyleGlobalModel = new PSPFStyleGlobalModel();
    protected PSPFEditorTemplGlobalModel psPFEditorTemplGlobalModel = new PSPFEditorTemplGlobalModel();
    protected HashMap<String, ArrayList<IPSPFPubCode>> psPFPubCodesMap = new HashMap();
    protected HashMap<String, IPSPFPubCode> psPFPubCodeMap = new HashMap();
    protected IPSAppType iPSAppType = null;
    protected PSPFPkgVerGlobalModel psPFPkgVerGlobalModel = new PSPFPkgVerGlobalModel();
    protected PSPFPkgGlobalModel psPFPkgGlobalModel = new PSPFPkgGlobalModel();
    protected PSPFPkgVerCDNGlobalModel psPFPkgVerCDNGlobalModel = new PSPFPkgVerCDNGlobalModel();
    protected PSPFPubObjGlobalModel psPFPubObjGlobalModel = new PSPFPubObjGlobalModel();
    public static final String DEFAULT_DOCURL = "http://www.ibizsys.net";
    private boolean bUseJITDesignPreview = false;
    private boolean bPreviewFramework = false;
    private int nPFEngineVer = 0;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSPF psPF) throws Exception {
        this.psPF = psPF;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psPF.getPSPFID());
        this.setName(psPF.getPSPFNAME());
        this.setPSObjectData(this.psPF);
        if (!StringHelper.IsNullOrEmpty((String)this.psPF.getPSAPPTYPEID())) {
            this.iPSAppType = this.getPSModelStorage().getPSAppType(this.psPF.getPSAPPTYPEID());
        }
        if (!this.psPF.isPFENGINEVERNull()) {
            this.nPFEngineVer = this.psPF.getPFENGINEVER();
        }
        this.psPFPubObjGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psPFPkgGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psPFPkgVerGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psPFPkgVerCDNGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psPFCodeFolderGlobalModel.Init(iDAGlobalHelper, this);
        this.onPreparePSPFPubCodes();
        this.psPFEditorTemplGlobalModel.Init(iDAGlobalHelper, this);
        this.psPFStyleGlobalModel.Init(iDAGlobalHelper, this);
        if (!this.psPF.isUSEJITPREVIEWNull()) {
            this.bUseJITDesignPreview = this.psPF.getUSEJITPREVIEW();
        }
        this.bPreviewFramework = this.getId().indexOf("PREVIEW_") == 0;
        this.onInit();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void onPreparePSPFPubCodes() throws Exception {
        HashMap<String, ArrayList<IPSPFPubCode>> hashMap = this.psPFPubCodesMap;
        synchronized (hashMap) {
            this.psPFPubCodesMap.clear();
            this.psPFPubCodeMap.clear();
            Vector<PSPFPubCode> psPFPubCodeList = new Vector<PSPFPubCode>();
            CallResult callResullt = this.getPSModelHelper().getPSPFPubCodes(this.getId(), psPFPubCodeList);
            if (callResullt.isError()) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5e94\u7528\u6280\u672f\u53d1\u5e03\u4ee3\u7801\u6e05\u5355\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResullt.getErrorInfo()));
            }
            for (PSPFPubCode psPFPubCode : psPFPubCodeList) {
                if (!psPFPubCode.isVALIDFLAGNull() && !psPFPubCode.getVALIDFLAG() || !StringHelper.IsNullOrEmpty((String)psPFPubCode.getPPSPFPUBCODEID())) continue;
                PSPFPubCodeImpl iPSPFPubCode = new PSPFPubCodeImpl();
                iPSPFPubCode.init(this.getDAGlobalHelper(), this, null, psPFPubCode);
                ArrayList<IPSPFPubCode> list = this.psPFPubCodesMap.get(iPSPFPubCode.getTargetType());
                if (list == null) {
                    list = new ArrayList();
                    this.psPFPubCodesMap.put(iPSPFPubCode.getTargetType(), list);
                }
                list.add(iPSPFPubCode);
                this.psPFPubCodeMap.put(iPSPFPubCode.getId(), iPSPFPubCode);
                if (StringHelper.IsNullOrEmpty((String)iPSPFPubCode.getName())) continue;
                this.psPFPubCodeMap.put(iPSPFPubCode.getName(), iPSPFPubCode);
            }
        }
    }

    @Override
    public IPSPFStyle getPSPFStyle(String strPFStyleId) throws Exception {
        IPSPFStyle iPSPFStyle = (IPSPFStyle)this.psPFStyleGlobalModel.FindModelHelper(strPFStyleId);
        return iPSPFStyle;
    }

    @Override
    public void resetPSPFStyle(String strPFStyleId) throws Exception {
        this.psPFStyleGlobalModel.ResetModel(strPFStyleId);
    }

    @Override
    public IPSPFCodeFolder getPSPFCodeFolder(String strPFCodeFolderId) throws Exception {
        return (IPSPFCodeFolder)this.psPFCodeFolderGlobalModel.FindModelHelper(strPFCodeFolderId);
    }

    @Override
    public void resetPSPFCodeFolder(String strPFCodeFolderId) throws Exception {
        this.psPFCodeFolderGlobalModel.ResetModel(strPFCodeFolderId);
    }

    @Override
    public Iterator<IPSPFPubCode> getPSPFPubCodes(String strTargetType) throws Exception {
        ArrayList<IPSPFPubCode> list = this.psPFPubCodesMap.get(strTargetType);
        if (list == null) {
            throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u76ee\u6807[%1$s]\u53d1\u5e03\u4ee3\u7801", (Object)strTargetType));
        }
        return list.iterator();
    }

    @Override
    public Iterator<IPSPFPubCode> getPSPFPubCodes(String strTargetType, boolean bTryMode) throws Exception {
        ArrayList<IPSPFPubCode> list = this.psPFPubCodesMap.get(strTargetType);
        if (list == null) {
            if (bTryMode) {
                return null;
            }
            throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u76ee\u6807[%1$s]\u53d1\u5e03\u4ee3\u7801", (Object)strTargetType));
        }
        return list.iterator();
    }

    @Override
    public IPSPFViewCodePublisher createPSPFViewCodePublisher() throws Exception {
        return (IPSPFViewCodePublisher)ObjectHelper.Create((String)this.psPF.getVIEWPUBOBJ());
    }

    @Override
    public IPSPFCtrlCodePublisher createPSPFCtrlCodePublisher() throws Exception {
        return (IPSPFCtrlCodePublisher)ObjectHelper.Create((String)this.psPF.getCTRLPUBOBJ());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSPFPubCode getPSPFPubCode(String strPFPubCodeId) throws Exception {
        HashMap<String, ArrayList<IPSPFPubCode>> hashMap = this.psPFPubCodesMap;
        synchronized (hashMap) {
            IPSPFPubCode iPSPFPubCode = this.psPFPubCodeMap.get(strPFPubCodeId);
            if (iPSPFPubCode == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u53d1\u5e03\u4ee3\u7801[%1$s]", (Object)strPFPubCodeId));
            }
            return iPSPFPubCode;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSPFPubCode getPSPFPubCode(String strPFPubCodeId, boolean bTryMode) throws Exception {
        HashMap<String, ArrayList<IPSPFPubCode>> hashMap = this.psPFPubCodesMap;
        synchronized (hashMap) {
            IPSPFPubCode iPSPFPubCode = this.psPFPubCodeMap.get(strPFPubCodeId);
            if (iPSPFPubCode == null && !bTryMode) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u53d1\u5e03\u4ee3\u7801[%1$s]", (Object)strPFPubCodeId));
            }
            return iPSPFPubCode;
        }
    }

    @Override
    public void resetAllPSPFPubCodes() throws Exception {
        this.onPreparePSPFPubCodes();
    }

    @Override
    public IPSPFCtrlPartCodePublisher createPSPFCtrlPartCodePublisher() throws Exception {
        return (IPSPFCtrlPartCodePublisher)ObjectHelper.Create((String)this.psPF.getCTRLPARTPUBOBJ());
    }

    @Override
    public IPSPFEditorCodePublisher createPSPFEditorCodePublisher() throws Exception {
        return (IPSPFEditorCodePublisher)ObjectHelper.Create((String)this.psPF.getEDITORPUBOBJ());
    }

    @Override
    public IPSPFEditorTempl getPSPFEditorTempl(String strPFEditorTemplId) throws Exception {
        return (IPSPFEditorTempl)this.psPFEditorTemplGlobalModel.FindModelHelper(strPFEditorTemplId);
    }

    @Override
    public IPSPFEditorTempl getPSPFEditorTempl(String strPFEditorTemplId, boolean bTryMode) throws Exception {
        return (IPSPFEditorTempl)this.psPFEditorTemplGlobalModel.FindModelHelper(strPFEditorTemplId, bTryMode);
    }

    @Override
    public void resetPSPFEditorTempl(String strPFEditorTemplId) throws Exception {
        this.psPFEditorTemplGlobalModel.ResetModel(strPFEditorTemplId);
    }

    @Override
    public IPSPFUIActionCodePublisher createPSPFUIActionCodePublisher() throws Exception {
        return (IPSPFUIActionCodePublisher)ObjectHelper.Create((String)this.psPF.getUAPUBOBJ());
    }

    @Override
    public IPSPFViewLogicCodePublisher createPSPFViewLogicCodePublisher() throws Exception {
        return (IPSPFViewLogicCodePublisher)ObjectHelper.Create((String)this.psPF.getVLPUBOBJ());
    }

    @Override
    public IPSPFAppCodePublisher createPSPFAppCodePublisher() throws Exception {
        return (IPSPFAppCodePublisher)ObjectHelper.Create((String)this.psPF.getAPPPUBOBJ());
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public String getFormLayoutMode() {
        return this.psPF.getFORMLAYOUTMODE();
    }

    @Override
    public void fillPSSubAppView(PSSubAppView psSubAppView, PSSysApp psSysApp, PSAppModule psAppModule, PSAppView psAppView) throws Exception {
    }

    @Override
    public String getPSAppViewPageUrl(IPSAppView iPSAppView) throws Exception {
        return null;
    }

    @Override
    public String getPSAppViewBackendUrl(IPSAppView iPSAppView) throws Exception {
        return StringHelper.Format((String)"../%1$s/%2$s/%3$s.do?", (Object)iPSAppView.getPSApplication().getPKGCodeName(), (Object)iPSAppView.getPSAppModule().getCodeName(), (Object)iPSAppView.getCodeName());
    }

    @Override
    public String getPSAppViewPageUrl(IPSAppView iPSAppView, Map<String, String> viewParamMap) throws Exception {
        return this.getPSAppViewPageUrl(iPSAppView);
    }

    @Override
    public String getPSAppViewBackendUrl(IPSAppView iPSAppView, Map<String, String> viewParamMap) throws Exception {
        if (viewParamMap != null) {
            return StringHelper.Format((String)"../%1$s/%2$s/%3$s.do?%4$s", (Object)iPSAppView.getPSApplication().getPKGCodeName(), (Object)iPSAppView.getPSAppModule().getCodeName(), (Object)iPSAppView.getCodeName(), (Object)WebUtility.getQueryString(viewParamMap));
        }
        return StringHelper.Format((String)"../%1$s/%2$s/%3$s.do?", (Object)iPSAppView.getPSApplication().getPKGCodeName(), (Object)iPSAppView.getPSAppModule().getCodeName(), (Object)iPSAppView.getCodeName());
    }

    @Override
    public IPSAppType getPSAppType() {
        return this.iPSAppType;
    }

    @Override
    public IPSPFPkgVer getPSPFPkgVer(String strPFPkgVerId) throws Exception {
        return (IPSPFPkgVer)this.psPFPkgVerGlobalModel.FindModelHelper(strPFPkgVerId);
    }

    @Override
    public void resetPSPFPkgVer(String strPFPkgVerId) throws Exception {
        this.psPFPkgVerGlobalModel.ResetModel(strPFPkgVerId);
    }

    @Override
    public IPSPFPkg getPSPFPkg(String strPFPkgId) throws Exception {
        return (IPSPFPkg)this.psPFPkgGlobalModel.FindModelHelper(strPFPkgId);
    }

    @Override
    public void resetPSPFPkg(String strPFPkgId) throws Exception {
        this.psPFPkgGlobalModel.ResetModel(strPFPkgId);
    }

    @Override
    public IPSPFPkgVerCDN getPSPFPkgVerCDN(String strPFPkgVerCDNId) throws Exception {
        return (IPSPFPkgVerCDN)this.psPFPkgVerCDNGlobalModel.FindModelHelper(strPFPkgVerCDNId);
    }

    @Override
    public void resetPSPFPkgVerCDN(String strPFPkgVerCDNId) throws Exception {
        this.psPFPkgVerCDNGlobalModel.ResetModel(strPFPkgVerCDNId);
    }

    @Override
    public IPSPFPkgVerCDN getPSPFPkgVerCDN(String strPFPkgVerId, String strPSPFCDNId, String strPSDevCenterId, boolean bTryMode) throws Exception {
        IPSPFPkgVerCDN iPSPFPkgVerCDN;
        String strId = "";
        if (!StringHelper.IsNullOrEmpty((String)strPSDevCenterId) && (iPSPFPkgVerCDN = (IPSPFPkgVerCDN)this.psPFPkgVerCDNGlobalModel.FindModelHelper(strId = StringHelper.Format((String)"%1$s|%2$s|%3$s", (Object)strPFPkgVerId, (Object)strPSPFCDNId, (Object)strPSDevCenterId), true)) != null) {
            return iPSPFPkgVerCDN;
        }
        strId = StringHelper.Format((String)"%1$s|%2$s", (Object)strPFPkgVerId, (Object)strPSPFCDNId);
        return (IPSPFPkgVerCDN)this.psPFPkgVerCDNGlobalModel.FindModelHelper(strId, bTryMode);
    }

    @Override
    public IPSPFStyle createPSPFStyle() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.psPF.getSTYLEOBJ())) {
            return new PSPFStyleImpl();
        }
        return (IPSPFStyle)ObjectHelper.Create((String)this.psPF.getSTYLEOBJ());
    }

    @Override
    public IPSJITAppModel createPSJITAppModel() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.psPF.getJITAPPOBJ())) {
            return new PSJITAppModel();
        }
        return (IPSJITAppModel)ObjectHelper.Create((String)this.psPF.getJITAPPOBJ());
    }

    @Override
    public boolean isUseJITDesignPreview() {
        return this.bUseJITDesignPreview;
    }

    @Override
    public boolean isPreviewFramework() {
        return this.bPreviewFramework;
    }

    @Override
    public String getPanelLayoutMode() {
        return this.getFormLayoutMode();
    }

    @Override
    public IPSPFPubObj getPSPFPubObj(String strSFPubObjId, boolean bTryMode) throws Exception {
        return (IPSPFPubObj)this.psPFPubObjGlobalModel.FindModelHelper(strSFPubObjId, bTryMode);
    }

    @Override
    public IPSPFPubObj getPSPFPubObjByTarget(String strTarget, boolean bTryMode) throws Exception {
        String strSFPubObjId = KeyValueHelper.genUniqueId((String)this.getId(), (String)strTarget.toUpperCase());
        return this.getPSPFPubObj(strSFPubObjId, bTryMode);
    }

    @Override
    public void resetPSPFPubObj(String strSFPubObjId) throws Exception {
        this.psPFPubObjGlobalModel.ResetModel(strSFPubObjId);
    }

    @Override
    public IPSPFStyle createPSPFStyle(PSPFStyle psPFStyle) throws Exception {
        if (StringHelper.Compare((String)psPFStyle.getSTYLEENGINE(), (String)"V2", (boolean)true) == 0) {
            if (StringHelper.IsNullOrEmpty((String)this.psPF.getSTYLE2OBJ())) {
                return new PSPFStyle2Impl();
            }
            return (IPSPFStyle)ObjectHelper.Create((String)this.psPF.getSTYLE2OBJ());
        }
        return this.createPSPFStyle();
    }

    @Override
    public String getViewPubObj2() {
        return this.psPF.getV2VIEWPUBOBJ();
    }

    @Override
    public String getViewPubObj2MacroParams() {
        return this.psPF.getV2VIEWMACROPARAMS();
    }

    @Override
    public int getPFEngineVer() {
        return this.nPFEngineVer;
    }
}

