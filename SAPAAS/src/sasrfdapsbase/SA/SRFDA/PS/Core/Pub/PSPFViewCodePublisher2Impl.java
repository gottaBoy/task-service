/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.Pub.IPSAppViewCode;
import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PF.IPSPFStyle2;
import SA.SRFDA.PS.Core.PF.IPSPFViewTempl;
import SA.SRFDA.PS.Core.PF.IPSPFViewTempl2;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPFViewCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPFViewCodePublisherContext2;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.IPSSysPubRuntime;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFDA.PS.Core.Pub.PSImportHelper;
import SA.SRFDA.PS.Core.Pub.PSPFCodePublisher2Impl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.IPSAppViewCodeDataCtrl;
import SA.SRFDA.PS.Data.PSAppViewCode;
import SA.SRFDA.PS.Data.PSPFViewTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFViewCodePublisher2Impl
extends PSPFCodePublisher2Impl
implements IPSPFViewCodePublisher {
    private static final Log log = LogFactory.getLog(PSPFViewCodePublisher2Impl.class);
    protected IPSPFViewTempl2 iPSPFViewTempl = null;
    protected IPSPublisherContext iPSPublisherContext = null;
    protected IPSAppView iPSAppView = null;
    protected IPSApplication iPSApplication = null;
    protected IPSPF iPSPF = null;
    protected IPSPFStyle iPSPFStyle = null;
    private String strCodeFolder = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPFViewTempl iPSPFViewTempl) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        if (!(iPSPFViewTempl instanceof IPSPFViewTempl2)) {
            throw new Exception(StringHelper.Format((String)"\u4f20\u5165\u89c6\u56fe\u6a21\u677f[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)iPSPFViewTempl.getName()));
        }
        this.iPSPFViewTempl = (IPSPFViewTempl2)iPSPFViewTempl;
        this.setPSPFPubCode(this.iPSPFViewTempl.getPSPFPubCode());
        this.strCodeFolder = PSTaskServerEnvImpl.getCurrent().getCodeFolder();
        this.onInit();
    }

    @Override
    public void generateCode(IPSPublisherContext iPSPublisherContext, IPSAppView iPSAppView) throws Exception {
        PSImportHelper psImportHelper = null;
        try {
            psImportHelper = new PSImportHelper();
            PSImportHelper.addHelper(psImportHelper);
            this.iPSPublisherContext = iPSPublisherContext;
            this.iPSAppView = iPSAppView;
            this.iPSApplication = iPSAppView.getPSApplication();
            this.iPSPF = this.iPSApplication.getPSPF();
            this.iPSPFStyle = iPSAppView.getPSPFStyle();
            this.beforeGenerateCode();
            this.onGenerateCode();
            PSImportHelper.releaseHelper();
            psImportHelper = null;
        }
        catch (Exception ex) {
            if (psImportHelper != null) {
                PSImportHelper.releaseHelper();
            }
            log.error((Object)ex);
            throw ex;
        }
    }

    protected void onGenerateCode() throws Exception {
        File fileFolder;
        File folder;
        IPSAppViewCodeDataCtrl psAppViewCodeDataCtrl;
        CallResult callResult;
        IPSAppViewCode iPSAppViewCode;
        PSAppViewCode psAppViewCode = new PSAppViewCode();
        psAppViewCode.setPSSYSAPPID(this.iPSApplication.getId());
        psAppViewCode.setPSSYSAPPNAME(this.iPSApplication.getName());
        psAppViewCode.setPSAPPVIEWCODEID(Helper.GenUniqueId((String)this.iPSAppView.getId(), (String)this.getPSPFPubCode().getId()));
        psAppViewCode.setPSAPPVIEWID(this.iPSAppView.getId());
        psAppViewCode.setPSAPPVIEWNAME(this.iPSAppView.getName());
        psAppViewCode.setPSPFPUBCODEID(this.getPSPFPubCode().getId());
        psAppViewCode.setPSPFPUBCODENAME(this.getPSPFPubCode().getName());
        psAppViewCode.setPSPFSTYLEID(this.iPSPFStyle.getId());
        String strCode = this.generateCode(null, psAppViewCode);
        IPSSysPubRuntime iPSSysPubRuntime = null;
        if (this.iPSPublisherContext != null && this.iPSPublisherContext.getPubParams() != null && this.iPSPublisherContext.getPubParams().containsKey("syspub")) {
            iPSSysPubRuntime = (IPSSysPubRuntime)this.iPSPublisherContext.getPubParams().get("syspub");
        }
        if ((iPSAppViewCode = this.iPSApplication.getPSAppViewCode(psAppViewCode.getPSAPPVIEWCODEID(), true)) != null && StringHelper.IsNullOrEmpty((String)this.iPSApplication.getPSSysModelInstId()) && (callResult = (psAppViewCodeDataCtrl = (IPSAppViewCodeDataCtrl)this.iPSPublisherContext.getDEDataCtrl("DE2590")).Save(false, psAppViewCode)).isError()) {
            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5e94\u7528\u89c6\u56fe\u4ee3\u7801\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        String strFolder = this.strCodeFolder;
        if (PSJITWebContext.getInstance() != null && PSJITWebContext.getInstance().getSystemModel() != null) {
            strFolder = PSJITWebContext.getInstance().getSystemModel().getJITCodeFolder();
        }
        if (StringHelper.IsNullOrEmpty((String)strFolder)) {
            throw new Exception("\u6ca1\u6709\u5b9a\u4e49\u4ee3\u7801\u53d1\u5e03\u76ee\u5f55");
        }
        boolean bV2 = false;
        if (StringHelper.Compare((String)((IPSSystemUtil)((Object)this.iPSApplication.getPSSystem())).getTemplEngineVer(), (String)"V2", (boolean)true) == 0) {
            bV2 = true;
        }
        strFolder = String.valueOf(strFolder) + File.separator + this.iPSApplication.getPSSystem().getPSDevCenterDomain();
        strFolder = String.valueOf(strFolder) + File.separator + this.iPSApplication.getPSSystem().getPubSystemId();
        strFolder = String.valueOf(strFolder) + File.separator + this.iPSApplication.getPSSystem().getVCName();
        if (bV2) {
            strFolder = String.valueOf(strFolder) + File.separator + this.iPSApplication.getPSSystem().getCodeName();
        }
        String strPubFolder = "";
        if (bV2 && !StringHelper.IsNullOrEmpty((String)psAppViewCode.getPRJPATH())) {
            strPubFolder = String.valueOf(strFolder) + File.separator + psAppViewCode.getPRJPATH();
        }
        if (StringHelper.IsNullOrEmpty((String)strPubFolder)) {
            strPubFolder = String.valueOf(strFolder) + File.separator + "app_" + this.iPSApplication.getWorkshopName();
        }
        String strCodeFolder = strPubFolder;
        String strCodePath = psAppViewCode.getCODEPATH();
        int nPos = strCodePath.lastIndexOf(File.separator);
        if (nPos != -1) {
            strCodeFolder = String.valueOf(strCodeFolder) + strCodePath.substring(0, nPos);
        }
        if (!(folder = new File(strCodeFolder)).exists()) {
            folder.mkdirs();
        }
        String strFullPath = strPubFolder;
        if (!bV2 && !StringHelper.IsNullOrEmpty((String)this.getPSPFPubCode().getPSPFCodeFolder().getFolderName())) {
            strFullPath = String.valueOf(strFullPath) + StringHelper.Format((String)"%1$s%2$s", (Object)File.separator, (Object)this.getPSPFPubCode().getPSPFCodeFolder().getFolderName());
        }
        if (!(fileFolder = new File(strFullPath = String.valueOf(strFullPath) + strCodePath)).exists()) {
            fileFolder.mkdirs();
        }
        strFullPath = String.valueOf(strFullPath) + File.separator;
        strFullPath = String.valueOf(strFullPath) + psAppViewCode.getPSAPPVIEWCODENAME();
        strCode = psAppViewCode.getUSERCODE();
        if (StringHelper.IsNullOrEmpty((String)strCode)) {
            strCode = psAppViewCode.getPUBCODE();
        }
        if (strFullPath.length() >= PSTaskServerEnvImpl.getCurrent().getMaxFileNameLength()) {
            String strInfo = StringHelper.Format((String)"\u53d1\u5e03\u4ee3\u7801[%1$s]\u8def\u5f84\u8fc7\u957f[%2$s]\uff0c\u53ef\u80fd\u65e0\u6cd5\u5199\u5165", (Object)strFullPath, (Object)strFullPath.length());
            ((IPSSystemUtil)((Object)this.iPSApplication.getPSSystem())).log(4, this.iPSApplication, strInfo);
            log.warn((Object)strInfo);
            this.iPSPublisherContext.log(4, null, strInfo);
            if (PSTaskServerEnvImpl.getCurrent().isThrowExceptionWhenFileNameTooLong()) {
                throw new Exception(StringHelper.Format((String)"\u53d1\u5e03\u4ee3\u7801[%1$s]\u540d\u79f0\u957f\u5ea6\u8d85\u8fc7[%2$s]", (Object)strFullPath, (Object)PSTaskServerEnvImpl.getCurrent().getMaxFileNameLength()));
            }
        }
        if (this.iPSPFStyle.getPFEngineVer() >= 20 && StringHelper.IsNullOrEmpty((String)strCode.trim())) {
            File removeFile = new File(strFullPath);
            if (removeFile.exists()) {
                removeFile.delete();
            }
            return;
        }
        if (iPSSysPubRuntime != null) {
            ((IPSSystemUtil)((Object)this.iPSApplication.getPSSystem())).pubPFCode(iPSSysPubRuntime, this.iPSApplication, this.getPSPFPubCode().getPSPFCodeFolder().getFolderName(), strFullPath, strCode, null);
        } else {
            ((IPSSystemUtil)((Object)this.iPSApplication.getPSSystem())).writeFile(strFullPath, strCode, null);
        }
    }

    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
    }

    @Override
    public String generateCode2(IPSPublisherContext iPSPublisherContext, IPSAppView iPSAppView, Map<String, Object> params) throws Exception {
        PSImportHelper psImportHelper = null;
        try {
            psImportHelper = new PSImportHelper();
            PSImportHelper.addHelper(psImportHelper);
            this.iPSPublisherContext = iPSPublisherContext;
            this.iPSAppView = iPSAppView;
            this.iPSApplication = iPSAppView.getPSApplication();
            this.iPSPF = this.iPSApplication.getPSPF();
            this.iPSPFStyle = this.iPSAppView.getPSPFStyle();
            String strCode = this.onGenerateCode2(params);
            PSImportHelper.releaseHelper();
            psImportHelper = null;
            return strCode;
        }
        catch (Exception ex) {
            if (psImportHelper != null) {
                PSImportHelper.releaseHelper();
            }
            log.error((Object)ex);
            throw ex;
        }
    }

    protected String onGenerateCode2(Map<String, Object> params) throws Exception {
        Object objPSAppViewCode;
        PSAppViewCode psAppViewCode = new PSAppViewCode();
        psAppViewCode.setPSSYSAPPID(this.iPSApplication.getId());
        psAppViewCode.setPSSYSAPPNAME(this.iPSApplication.getName());
        psAppViewCode.setPSAPPVIEWCODEID(Helper.GenUniqueId((String)this.iPSAppView.getId(), (String)this.getPSPFPubCode().getId()));
        psAppViewCode.setPSAPPVIEWID(this.iPSAppView.getId());
        psAppViewCode.setPSAPPVIEWNAME(this.iPSAppView.getName());
        psAppViewCode.setPSPFPUBCODEID(this.getPSPFPubCode().getId());
        psAppViewCode.setPSPFPUBCODENAME(this.getPSPFPubCode().getName());
        psAppViewCode.setPSPFSTYLEID(this.iPSPFStyle.getId());
        String strCode = this.generateCode(params, psAppViewCode);
        strCode = psAppViewCode.getUSERCODE();
        if (StringHelper.IsNullOrEmpty((String)strCode)) {
            strCode = psAppViewCode.getPUBCODE();
        }
        boolean bV2 = false;
        if (StringHelper.Compare((String)((IPSSystemUtil)((Object)this.iPSApplication.getPSSystem())).getTemplEngineVer(), (String)"V2", (boolean)true) == 0) {
            bV2 = true;
        }
        if (this.iPSPublisherContext != null && (objPSAppViewCode = this.iPSPublisherContext.getUserTag("PSAPPVIEWCODE")) != null && objPSAppViewCode instanceof PSAppViewCode) {
            PSAppViewCode dstPSAppViewCode = (PSAppViewCode)((Object)objPSAppViewCode);
            psAppViewCode.CopyTo(dstPSAppViewCode, true);
        }
        return strCode;
    }

    protected String generateCode(Map<String, Object> params2) throws Exception {
        return this.generateCode(params2, null);
    }

    protected String generateCode(Map<String, Object> params2, PSAppViewCode psAppViewCode) throws Exception {
        IPSAppDEView iPSAppDEView;
        final HashMap<String, Object> params = new HashMap<String, Object>();
        if (this.iPSPublisherContext != null && this.iPSPublisherContext.getPubParams() != null) {
            params.putAll(this.iPSPublisherContext.getPubParams());
        }
        if (params2 != null) {
            params.putAll(params2);
        }
        params.put("P", new IPSPFViewCodePublisherContext2(){

            @Override
            public IPSGenerateCodeResult getCtrlCode(Object objCtrl, String strCodeType) throws Exception {
                return PSPFViewCodePublisher2Impl.this.internalGetCtrlCode(objCtrl, strCodeType, params);
            }

            @Override
            public IPSGenerateCodeResult getCtrlCode(Object objCtrl) throws Exception {
                return this.getCtrlCode(objCtrl, "");
            }

            @Override
            public boolean hasCtrlCode(Object objCtrl, String strCodeType) throws Exception {
                return PSPFViewCodePublisher2Impl.this.internalHasCtrlCode(objCtrl, strCodeType);
            }

            @Override
            public boolean hasCtrlCode(Object objCtrl) throws Exception {
                return this.hasCtrlCode(objCtrl, "");
            }

            @Override
            public IPSGenerateCodeResult getLogicCode(Object objCtrl, String strCodeType) throws Exception {
                return PSPFViewCodePublisher2Impl.this.internalGetLogicCode(objCtrl, strCodeType, params);
            }

            @Override
            public IPSGenerateCodeResult getLayoutCode(String strCodeType) throws Exception {
                return PSPFViewCodePublisher2Impl.this.internalGetLayoutCode(strCodeType, params);
            }

            @Override
            public IPSGenerateCodeResult getLayoutCode() throws Exception {
                return this.getLayoutCode("");
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
                return PSPFViewCodePublisher2Impl.this.internalExists(strType, strParam, strParam2);
            }

            @Override
            public boolean set(String strParam, String strValue) {
                return PSPFViewCodePublisher2Impl.this.internalSet(strParam, strValue);
            }

            @Override
            public String get(String strParam, String strDefault) {
                return PSPFViewCodePublisher2Impl.this.internalGet(strParam, strDefault);
            }

            @Override
            public String get(String strParam) {
                return this.get(strParam, null);
            }
        });
        params.put("publisher", params.get("P"));
        params.put("sys", this.iPSApplication.getPSSystem());
        params.put("app", this.iPSApplication);
        params.put("view", this.iPSAppView);
        params.put("pf", this.iPSPF);
        params.put("pfstyle", this.iPSPFStyle);
        if (this.iPSAppView instanceof IPSAppDEView && (iPSAppDEView = (IPSAppDEView)this.iPSAppView).getPSDataEntity() != null) {
            params.put("de", iPSAppDEView.getPSDataEntity());
        }
        if (this.iPSAppView.getPSAppDataEntity() != null) {
            params.put("appde", this.iPSAppView.getPSAppDataEntity());
        }
        this.onFillGenerateCodeParams(params);
        String strCode = this.generateCode(this.iPSPFViewTempl.getPSPFViewTemplData(), "TEMPLCODE", params);
        if (psAppViewCode != null) {
            psAppViewCode.setPUBCODE(strCode);
            PSPFViewTempl psPFViewTempl = this.iPSPFViewTempl.getPSPFViewTemplData();
            if (!StringHelper.IsNullOrEmpty((String)psPFViewTempl.getCODEPATH())) {
                psAppViewCode.setCODEPATH(PSTemplHelper.generateCode((BaseDataEntity)psPFViewTempl, "CODEPATH", params));
            }
            if (!StringHelper.IsNullOrEmpty((String)psPFViewTempl.getFILENAME())) {
                psAppViewCode.setPSAPPVIEWCODENAME(PSTemplHelper.generateCode((BaseDataEntity)psPFViewTempl, "FILENAME", params));
            }
            if (!StringHelper.IsNullOrEmpty((String)this.iPSApplication.getProjectPath())) {
                psAppViewCode.setPRJPATH(PSTemplHelper.generateCode(this.iPSApplication.getProjectPath(), params));
            }
            psAppViewCode.set("TEMPLCODE", this.iPSPFViewTempl.getPSPFViewTemplData().getTEMPLCODE());
        }
        return strCode;
    }

    @Override
    public void close() {
        this.iPSPublisherContext = null;
        this.iPSAppView = null;
        this.iPSApplication = null;
        this.iPSPF = null;
        this.iPSPFStyle = null;
        this.onClose();
        if (this.iPSPFViewTempl != null) {
            this.iPSPFViewTempl.releasePSPFViewCodePublisher(this);
        }
    }

    protected String getPSAppViewCodeName(IPSAppView iPSAppView) {
        return iPSAppView.getFullCodeName();
    }

    protected String generateCode(BaseDataEntity templData, String strCodeName, HashMap<String, Object> params) throws Exception {
        String strCode = PSTemplHelper.generateCode((BaseDataEntity)this.iPSPFViewTempl.getPSPFViewTemplData(), strCodeName, params);
        return strCode;
    }

    @Override
    public IPSPublisherContext getContext() {
        return this.iPSPublisherContext;
    }

    protected boolean isOutputAllControls() {
        return false;
    }

    protected boolean isOutputChildControlFirst() {
        return false;
    }

    protected void fillContainerControls(IPSControlContainer iPSControlContainer, ArrayList<IPSControl> psControlList, boolean bChildFirst) {
        Iterator<IPSControl> psControls = iPSControlContainer.getPSControls();
        while (psControls.hasNext()) {
            IPSControl iPSControl = psControls.next();
            if (!bChildFirst) {
                psControlList.add(iPSControl);
            }
            if (iPSControl instanceof IPSControlContainer) {
                this.fillContainerControls((IPSControlContainer)((Object)iPSControl), psControlList, bChildFirst);
            }
            if (!bChildFirst) continue;
            psControlList.add(iPSControl);
        }
    }

    protected IPSGenerateCodeResult internalGetLayoutCode(String strCodeType, Map<String, Object> params) throws Exception {
        if (this.iPSAppView.getPSSysViewLayoutPanel() == null) {
            PSGenerateCodeResultImpl psGenerateCodeResultImpl = new PSGenerateCodeResultImpl();
            psGenerateCodeResultImpl.setCode("\u5f53\u524d\u89c6\u56fe\u6ca1\u6709\u6307\u5b9a\u5e03\u5c40\u9762\u677f");
            return psGenerateCodeResultImpl;
        }
        return this.internalGetCtrlCode(this.iPSAppView.getPSSysViewLayoutPanel(), strCodeType, params);
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

