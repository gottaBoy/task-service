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
import SA.SRFDA.PS.Core.App.View.IPSAppViewLogic;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PF.IPSPFViewLogicTempl;
import SA.SRFDA.PS.Core.PF.IPSPFViewTempl;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPFViewCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPFViewLogicCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.IPSSysPubRuntime;
import SA.SRFDA.PS.Core.Pub.PSImportHelper;
import SA.SRFDA.PS.Core.Pub.PSPFCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSCtrlMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSSubCodeMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Core.Res.IPSSysViewLogic;
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

public class PSPFViewCodePublisherImpl
extends PSPFCodePublisherImpl
implements IPSPFViewCodePublisher {
    private static final Log log = LogFactory.getLog(PSPFViewCodePublisherImpl.class);
    protected IPSPFViewTempl iPSPFViewTempl = null;
    protected IPSPublisherContext iPSPublisherContext = null;
    protected IPSAppView iPSAppView = null;
    protected IPSApplication iPSApplication = null;
    protected IPSPF iPSPF = null;
    protected IPSPFStyle iPSPFStyle = null;
    protected PSCtrlMethod psCtrlMethod = null;
    protected PSSubCodeMethod psSubCodeMethod = null;
    private String strCodeFolder = null;
    private String strToolFolder = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPFViewTempl iPSPFViewTempl) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSPFViewTempl = iPSPFViewTempl;
        this.setPSPFPubCode(this.iPSPFViewTempl.getPSPFPubCode());
        this.strCodeFolder = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "CODEFOLDER", null);
        this.strToolFolder = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "TOOLFOLDER", null);
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
        File folder;
        String strPubFolder;
        IPSAppViewCodeDataCtrl psAppViewCodeDataCtrl;
        CallResult callResult;
        boolean bV2 = false;
        if (StringHelper.Compare((String)((IPSSystemUtil)((Object)this.iPSApplication.getPSSystem())).getTemplEngineVer(), (String)"V2", (boolean)true) == 0) {
            bV2 = true;
        }
        HashMap pubParamMap = null;
        if (bV2) {
            pubParamMap = new HashMap();
        }
        String strCode = this.generateCode(pubParamMap);
        IPSSysPubRuntime iPSSysPubRuntime = null;
        if (this.iPSPublisherContext != null && this.iPSPublisherContext.getPubParams() != null && this.iPSPublisherContext.getPubParams().containsKey("syspub")) {
            iPSSysPubRuntime = (IPSSysPubRuntime)this.iPSPublisherContext.getPubParams().get("syspub");
        }
        String strFullCodePath = "";
        String strFullClassName = "";
        if (bV2) {
            strFullCodePath = (String)pubParamMap.get("srfcodepathv2");
            strFullClassName = (String)pubParamMap.get("srffilenamev2");
        } else {
            strFullCodePath = this.iPSApplication.getCodeFolder();
            strFullCodePath = String.valueOf(strFullCodePath) + StringHelper.Format((String)"%1$s%2$s", (Object)File.separator, (Object)this.getPSPFPubCode().getPSPFCodeFolder().getFolderName());
            if (!StringHelper.IsNullOrEmpty((String)this.getPSPFPubCode().getCodeFolder())) {
                strFullCodePath = String.valueOf(strFullCodePath) + StringHelper.Format((String)"%1$s%2$s", (Object)File.separator, (Object)this.getPSPFPubCode().getCodeFolder());
            }
            if (!StringHelper.IsNullOrEmpty((String)strFullCodePath)) {
                strFullCodePath = String.valueOf(strFullCodePath) + File.separator;
            }
            strFullCodePath = String.valueOf(strFullCodePath) + this.getPSAppViewCodeName(this.iPSAppView);
            strFullCodePath = String.valueOf(strFullCodePath) + this.getPSPFPubCode().getClassNameExt();
            strFullCodePath = strFullCodePath.replace('.', File.separatorChar);
            strFullCodePath = String.valueOf(strFullCodePath) + this.getPSPFPubCode().getFileNameExt();
            strFullClassName = this.iPSApplication.getPKGCodeName();
            if (!StringHelper.IsNullOrEmpty((String)this.getPSPFPubCode().getPKGCodeName())) {
                strFullClassName = String.valueOf(strFullClassName) + StringHelper.Format((String)".%1$s", (Object)this.getPSPFPubCode().getPKGCodeName());
            }
            if (!StringHelper.IsNullOrEmpty((String)strFullClassName)) {
                strFullClassName = String.valueOf(strFullClassName) + StringHelper.Format((String)".");
            }
            strFullClassName = String.valueOf(strFullClassName) + this.getPSAppViewCodeName(this.iPSAppView);
        }
        PSAppViewCode psAppViewCode = new PSAppViewCode();
        psAppViewCode.setPSSYSAPPID(this.iPSApplication.getId());
        psAppViewCode.setPSSYSAPPNAME(this.iPSApplication.getName());
        psAppViewCode.setPSAPPVIEWCODEID(Helper.GenUniqueId((String)this.iPSAppView.getId(), (String)this.getPSPFPubCode().getId()));
        psAppViewCode.setPSAPPVIEWID(this.iPSAppView.getId());
        psAppViewCode.setPSAPPVIEWNAME(this.iPSAppView.getName());
        psAppViewCode.setPSPFPUBCODEID(this.getPSPFPubCode().getId());
        psAppViewCode.setPSPFPUBCODENAME(this.getPSPFPubCode().getName());
        psAppViewCode.setPSPFSTYLEID(this.iPSPFStyle.getId());
        psAppViewCode.setPSAPPVIEWCODENAME(strFullClassName);
        psAppViewCode.setCODEPATH(strFullCodePath);
        psAppViewCode.setPUBCODE(strCode);
        IPSAppViewCode iPSAppViewCode = this.iPSApplication.getPSAppViewCode(psAppViewCode.getPSAPPVIEWCODEID(), true);
        if (iPSAppViewCode != null && StringHelper.IsNullOrEmpty((String)this.iPSApplication.getPSSysModelInstId()) && (callResult = (psAppViewCodeDataCtrl = (IPSAppViewCodeDataCtrl)this.iPSPublisherContext.getDEDataCtrl("DE2590")).Save(false, psAppViewCode)).isError()) {
            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5e94\u7528\u89c6\u56fe\u4ee3\u7801\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        String strFolder = this.strCodeFolder;
        if (PSJITWebContext.getInstance() != null && PSJITWebContext.getInstance().getSystemModel() != null) {
            strFolder = PSJITWebContext.getInstance().getSystemModel().getJITCodeFolder();
        }
        if (StringHelper.IsNullOrEmpty((String)strFolder)) {
            throw new Exception("\u6ca1\u6709\u5b9a\u4e49\u4ee3\u7801\u53d1\u5e03\u76ee\u5f55");
        }
        strFolder = String.valueOf(strFolder) + File.separator + this.iPSApplication.getPSSystem().getPSDevCenterDomain();
        strFolder = String.valueOf(strFolder) + File.separator + this.iPSApplication.getPSSystem().getPubSystemId();
        strFolder = String.valueOf(strFolder) + File.separator + this.iPSApplication.getPSSystem().getVCName();
        if (bV2) {
            strFolder = String.valueOf(strFolder) + File.separator + this.iPSApplication.getPSSystem().getCodeName();
        }
        String strCodeFolder = strPubFolder = String.valueOf(strFolder) + File.separator + "app_" + this.iPSApplication.getWorkshopName();
        String strCodePath = psAppViewCode.getCODEPATH();
        int nPos = strCodePath.lastIndexOf(File.separator);
        if (nPos != -1) {
            strCodeFolder = String.valueOf(strCodeFolder) + strCodePath.substring(0, nPos);
        }
        if (!(folder = new File(strCodeFolder)).exists()) {
            folder.mkdirs();
        }
        String strFullPath = String.valueOf(strPubFolder) + strCodePath;
        if (bV2) {
            folder = new File(strFullPath);
            if (!folder.exists()) {
                folder.mkdirs();
            }
            strFullPath = String.valueOf(strFullPath) + File.separator;
            strFullPath = String.valueOf(strFullPath) + psAppViewCode.getPSAPPVIEWCODENAME();
        }
        if (StringHelper.IsNullOrEmpty((String)(strCode = psAppViewCode.getUSERCODE()))) {
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
        String strCode = this.generateCode(params);
        String strFullCodePath = "";
        if (!StringHelper.IsNullOrEmpty((String)this.getPSPFPubCode().getCodeFolder())) {
            strFullCodePath = String.valueOf(strFullCodePath) + StringHelper.Format((String)"%1$s%2$s", (Object)"/", (Object)this.getPSPFPubCode().getCodeFolder());
        }
        if (!StringHelper.IsNullOrEmpty((String)strFullCodePath)) {
            strFullCodePath = String.valueOf(strFullCodePath) + "/";
        }
        strFullCodePath = String.valueOf(strFullCodePath) + this.getPSAppViewCodeName(this.iPSAppView);
        strFullCodePath = String.valueOf(strFullCodePath) + this.getPSPFPubCode().getClassNameExt();
        strFullCodePath = strFullCodePath.replace('.', '/');
        strFullCodePath = String.valueOf(strFullCodePath) + this.getPSPFPubCode().getFileNameExt();
        String strFullClassName = this.iPSApplication.getPKGCodeName();
        if (!StringHelper.IsNullOrEmpty((String)this.getPSPFPubCode().getPKGCodeName())) {
            strFullClassName = String.valueOf(strFullClassName) + StringHelper.Format((String)".%1$s", (Object)this.getPSPFPubCode().getPKGCodeName());
        }
        if (!StringHelper.IsNullOrEmpty((String)strFullClassName)) {
            strFullClassName = String.valueOf(strFullClassName) + StringHelper.Format((String)".");
        }
        strFullClassName = String.valueOf(strFullClassName) + this.getPSAppViewCodeName(this.iPSAppView);
        PSAppViewCode psAppViewCode = new PSAppViewCode();
        psAppViewCode.setPSSYSAPPID(this.iPSApplication.getId());
        psAppViewCode.setPSSYSAPPNAME(this.iPSApplication.getName());
        psAppViewCode.setPSAPPVIEWCODEID(Helper.GenUniqueId((String)this.iPSAppView.getId(), (String)this.getPSPFPubCode().getId()));
        psAppViewCode.setPSAPPVIEWID(this.iPSAppView.getId());
        psAppViewCode.setPSAPPVIEWNAME(this.iPSAppView.getName());
        psAppViewCode.setPSPFPUBCODEID(this.getPSPFPubCode().getId());
        psAppViewCode.setPSPFPUBCODENAME(this.getPSPFPubCode().getName());
        psAppViewCode.setPSPFSTYLEID(this.iPSPFStyle.getId());
        psAppViewCode.setPSAPPVIEWCODENAME(new File(strFullCodePath).getName());
        psAppViewCode.setCODEPATH(strFullCodePath);
        psAppViewCode.setPUBCODE(strCode);
        strCode = psAppViewCode.getUSERCODE();
        if (StringHelper.IsNullOrEmpty((String)strCode)) {
            strCode = psAppViewCode.getPUBCODE();
        }
        if (this.iPSPublisherContext != null && (objPSAppViewCode = this.iPSPublisherContext.getUserTag("PSAPPVIEWCODE")) != null && objPSAppViewCode instanceof PSAppViewCode) {
            PSAppViewCode dstPSAppViewCode = (PSAppViewCode)((Object)objPSAppViewCode);
            psAppViewCode.CopyTo(dstPSAppViewCode, true);
        }
        return strCode;
    }

    protected String generateCode(Map<String, Object> params2) throws Exception {
        IPSPFCtrlTempl iPSPFCtrlTempl;
        IPSAppDEView iPSAppDEView;
        IPSGenerateCodeResult iPSGenerateCodeResult;
        HashMap<String, Object> params = new HashMap<String, Object>();
        if (this.iPSPublisherContext != null && this.iPSPublisherContext.getPubParams() != null) {
            params.putAll(this.iPSPublisherContext.getPubParams());
        }
        if (params2 != null) {
            params.putAll(params2);
        }
        this.psCtrlMethod = new PSCtrlMethod();
        this.psSubCodeMethod = new PSSubCodeMethod();
        this.psCtrlMethod.resetCtrlResult();
        params.put("srfctrl", this.psCtrlMethod);
        this.psSubCodeMethod.resetSubCode();
        params.put("srfsubcode", this.psSubCodeMethod);
        ArrayList<IPSGenerateCodeResult> psGenerateCodeResultList = new ArrayList<IPSGenerateCodeResult>();
        HashMap<String, ArrayList<IPSGenerateCodeResult>> psGenerateCodeResultListMap = null;
        if (this.getPSPFPubCode().getChildPSPFPubCodes() != null) {
            psGenerateCodeResultListMap = new HashMap<String, ArrayList<IPSGenerateCodeResult>>();
        }
        Iterator<IPSControl> psControls = null;
        if (this.isOutputAllControls()) {
            if (!this.isOutputChildControlFirst()) {
                psControls = this.iPSAppView.getAllPSControls().iterator();
            } else {
                ArrayList<IPSControl> psControlList = new ArrayList<IPSControl>();
                this.fillContainerControls(this.iPSAppView, psControlList, true);
                psControls = psControlList.iterator();
            }
        } else {
            psControls = this.iPSAppView.getPSControls();
        }
        while (psControls.hasNext()) {
            Iterator<IPSPFPubCode> psPFPubCodes;
            IPSControl iPSControl = psControls.next();
            IPSPFCtrlTempl iPSPFCtrlTempl2 = this.iPSPFStyle.getPSPFCtrlTempl(iPSControl.getPSControlType(), this.getPSPFPubCode());
            if (iPSPFCtrlTempl2 != null) {
                IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher = iPSPFCtrlTempl2.getPSPFCtrlCodePublisher();
                iPSGenerateCodeResult = iPSPFCtrlCodePublisher.generateCode(this.iPSPublisherContext, iPSControl);
                if (iPSGenerateCodeResult != null) {
                    params.put(iPSControl.getName(), iPSGenerateCodeResult);
                    psGenerateCodeResultList.add(iPSGenerateCodeResult);
                    this.psCtrlMethod.registerCtrlResult(iPSControl.getName(), iPSGenerateCodeResult);
                }
                iPSPFCtrlCodePublisher.close();
            }
            if ((psPFPubCodes = this.getPSPFPubCode().getChildPSPFPubCodes()) == null) continue;
            while (psPFPubCodes.hasNext()) {
                IPSPFPubCode iPSPFPubCode = psPFPubCodes.next();
                iPSPFCtrlTempl2 = this.iPSPFStyle.getPSPFCtrlTempl(iPSControl.getPSControlType(), iPSPFPubCode);
                if (iPSPFCtrlTempl2 == null) continue;
                IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher = iPSPFCtrlTempl2.getPSPFCtrlCodePublisher();
                IPSGenerateCodeResult iPSGenerateCodeResult2 = iPSPFCtrlCodePublisher.generateCode(this.iPSPublisherContext, iPSControl);
                if (iPSGenerateCodeResult2 != null) {
                    ArrayList<IPSGenerateCodeResult> childPSGenerateCodeResultList = (ArrayList<IPSGenerateCodeResult>)psGenerateCodeResultListMap.get(iPSPFPubCode.getName().toLowerCase());
                    if (childPSGenerateCodeResultList == null) {
                        childPSGenerateCodeResultList = new ArrayList<IPSGenerateCodeResult>();
                        psGenerateCodeResultListMap.put(iPSPFPubCode.getName().toLowerCase(), childPSGenerateCodeResultList);
                    }
                    params.put(String.valueOf(iPSControl.getName()) + "__" + iPSPFPubCode.getName().toLowerCase(), iPSGenerateCodeResult2);
                    childPSGenerateCodeResultList.add(iPSGenerateCodeResult2);
                    this.psCtrlMethod.registerCtrlResult(String.valueOf(iPSControl.getName()) + "__" + iPSPFPubCode.getName().toLowerCase(), iPSGenerateCodeResult2);
                }
                iPSPFCtrlCodePublisher.close();
            }
        }
        params.put("ctrls", psGenerateCodeResultList);
        if (psGenerateCodeResultListMap != null) {
            for (String strKey : psGenerateCodeResultListMap.keySet()) {
                params.put("ctrls__" + strKey, psGenerateCodeResultListMap.get(strKey));
            }
        }
        psGenerateCodeResultList = new ArrayList();
        params.put("uiactions", psGenerateCodeResultList);
        psGenerateCodeResultList = new ArrayList();
        Iterator<IPSAppViewLogic> psAppViewLogics = this.iPSAppView.getPSAppViewLogics();
        while (psAppViewLogics.hasNext()) {
            IPSSysViewLogic iPSSysViewLogic;
            IPSPFViewLogicTempl iPSPFViewLogicTempl;
            IPSAppViewLogic iPSAppViewLogic = psAppViewLogics.next();
            if (iPSAppViewLogic.getPSViewLogic() == null || !(iPSAppViewLogic.getPSViewLogic() instanceof IPSSysViewLogic) || (iPSPFViewLogicTempl = this.iPSPFStyle.getPSPFViewLogicTempl((iPSSysViewLogic = (IPSSysViewLogic)iPSAppViewLogic.getPSViewLogic()).getPSViewLogicType(), this.getPSPFPubCode())) == null) continue;
            IPSPFViewLogicCodePublisher iPSPFViewLogicCodePublisher = iPSPFViewLogicTempl.getPSPFViewLogicCodePublisher();
            iPSGenerateCodeResult = iPSPFViewLogicCodePublisher.generateCode(this.iPSPublisherContext, iPSAppViewLogic);
            if (iPSGenerateCodeResult != null) {
                psGenerateCodeResultList.add(iPSGenerateCodeResult);
            }
            iPSPFViewLogicCodePublisher.close();
        }
        params.put("viewlogics", psGenerateCodeResultList);
        params.put("publisher", this);
        params.put("sys", this.iPSApplication.getPSSystem());
        params.put("app", this.iPSApplication);
        params.put("view", this.iPSAppView);
        params.put("viewtempl", this.iPSPFViewTempl);
        params.put("codetempl", this.iPSPFViewTempl);
        params.put("pf", this.iPSPF);
        params.put("pfstyle", this.iPSPFStyle);
        if (this.iPSAppView.getPSAppDataEntity() != null) {
            params.put("appde", this.iPSAppView.getPSAppDataEntity());
        }
        if (this.iPSAppView instanceof IPSAppDEView && (iPSAppDEView = (IPSAppDEView)this.iPSAppView).getPSDataEntity() != null) {
            params.put("de", iPSAppDEView.getPSDataEntity());
        }
        String strFullClassName = this.iPSApplication.getPKGCodeName();
        if (!StringHelper.IsNullOrEmpty((String)this.getPSPFPubCode().getPKGCodeName())) {
            strFullClassName = String.valueOf(strFullClassName) + StringHelper.Format((String)".%1$s", (Object)this.getPSPFPubCode().getPKGCodeName());
        }
        if (!StringHelper.IsNullOrEmpty((String)strFullClassName)) {
            strFullClassName = String.valueOf(strFullClassName) + StringHelper.Format((String)".");
        }
        strFullClassName = String.valueOf(strFullClassName) + this.getPSAppViewCodeName(this.iPSAppView);
        params.put("viewfullname2", strFullClassName);
        params.put("oriviewfullname", strFullClassName);
        strFullClassName = String.valueOf(strFullClassName) + this.getPSPFPubCode().getClassNameExt();
        params.put("viewfullname", strFullClassName);
        if (this.iPSAppView.getPSSysViewLayoutPanel() != null && (iPSPFCtrlTempl = this.iPSPFStyle.getPSPFCtrlTempl(this.iPSAppView.getPSSysViewLayoutPanel().getPSControlType(), this.getPSPFPubCode())) != null) {
            HashMap<String, Object> panelParams = new HashMap<String, Object>();
            panelParams.put("srfviewctrl", this.psCtrlMethod);
            IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher = iPSPFCtrlTempl.getPSPFCtrlCodePublisher();
            IPSGenerateCodeResult iPSGenerateCodeResult3 = iPSPFCtrlCodePublisher.generateCode(this.iPSPublisherContext, this.iPSAppView.getPSSysViewLayoutPanel(), panelParams);
            if (iPSGenerateCodeResult3 != null) {
                params.put(this.iPSAppView.getPSSysViewLayoutPanel().getName(), iPSGenerateCodeResult3);
            }
            iPSPFCtrlCodePublisher.close();
        }
        this.onFillGenerateCodeParams(params);
        String strCode = this.generateCode(this.iPSPFViewTempl.getPSPFViewTemplData(), "TEMPLCODE", params);
        if (params2 != null) {
            boolean bV2 = false;
            if (StringHelper.Compare((String)((IPSSystemUtil)((Object)this.iPSApplication.getPSSystem())).getTemplEngineVer(), (String)"V2", (boolean)true) == 0) {
                bV2 = true;
            }
            if (bV2) {
                PSPFViewTempl psPFViewTempl = this.iPSPFViewTempl.getPSPFViewTemplData();
                if (!StringHelper.IsNullOrEmpty((String)psPFViewTempl.getCODEPATH())) {
                    params2.put("srfcodepathv2", PSTemplHelper.generateCode((BaseDataEntity)psPFViewTempl, "CODEPATH", params));
                }
                if (!StringHelper.IsNullOrEmpty((String)psPFViewTempl.getFILENAME())) {
                    params2.put("srffilenamev2", PSTemplHelper.generateCode((BaseDataEntity)psPFViewTempl, "FILENAME", params));
                }
                if (!StringHelper.IsNullOrEmpty((String)this.iPSApplication.getProjectPath())) {
                    params2.put("srfprjpathv2", PSTemplHelper.generateCode(this.iPSApplication.getProjectPath(), params));
                }
                params2.put("srftemplcodev2", this.iPSPFViewTempl.getPSPFViewTemplData().getTEMPLCODE());
            }
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
        this.psCtrlMethod = null;
        this.psSubCodeMethod = null;
        this.onClose();
        if (this.iPSPFViewTempl != null) {
            this.iPSPFViewTempl.releasePSPFViewCodePublisher(this);
        }
    }

    protected String getPSAppViewCodeName(IPSAppView iPSAppView) {
        return iPSAppView.getFullCodeName();
    }

    protected String generateCode(BaseDataEntity templData, String strCodeName, HashMap<String, Object> params) throws Exception {
        String strCode = PSTemplHelper.generateCode((BaseDataEntity)this.iPSPFViewTempl.getPSPFViewTemplData(), "TEMPLCODE", params);
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
}
