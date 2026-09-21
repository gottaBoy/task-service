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
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher2;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.IPSSysPubRuntime;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFDA.PS.Core.Pub.PSImportHelper;
import SA.SRFDA.PS.Core.Pub.PSPFCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSCtrlMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSSubCodeMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Data.PSAppViewCode;
import SA.SRFDA.PS.Data.PSPFCtrlTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFCtrlCodePublisherImpl
extends PSPFCodePublisherImpl
implements IPSPFCtrlCodePublisher,
IPSPFCtrlCodePublisher2 {
    private static final Log log = LogFactory.getLog(PSPFCtrlCodePublisherImpl.class);
    protected IPSPFCtrlTempl iPSPFCtrlTempl = null;
    protected IPSPublisherContext iPSPublisherContext = null;
    protected IPSAppView iPSAppView = null;
    protected IPSApplication iPSApplication = null;
    protected IPSPF iPSPF = null;
    protected IPSPFStyle iPSPFStyle = null;
    protected IPSControl iPSControl = null;
    private String strCodeFolder = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPFCtrlTempl iPSPFCtrlTempl) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSPFCtrlTempl = iPSPFCtrlTempl;
        this.setPSPFPubCode(this.iPSPFCtrlTempl.getPSPFPubCode());
        this.strCodeFolder = PSTaskServerEnvImpl.getCurrent().getCodeFolder();
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
            PSGenerateCodeResultImpl iPSGenerateCodeResult = null;
            iPSGenerateCodeResult = params != null ? this.onGenerateCode((HashMap)params) : this.onGenerateCode();
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
        psCtrlMethod.resetCtrlResult();
        params.put("srfctrl", psCtrlMethod);
        if (params.get("srfviewctrl") == null) {
            params.put("srfviewctrl", psCtrlMethod);
        }
        psSubCodeMethod.resetSubCode();
        params.put("srfsubcode", psSubCodeMethod);
        if (this.iPSControl instanceof IPSControlContainer) {
            IPSControlContainer iPSControlContainer = (IPSControlContainer)((Object)this.iPSControl);
            ArrayList<IPSGenerateCodeResult> psGenerateCodeResultList = new ArrayList<IPSGenerateCodeResult>();
            Iterator<IPSControl> psControls = iPSControlContainer.getPSControls();
            while (psControls.hasNext()) {
                IPSControl iPSControl = psControls.next();
                IPSPFCtrlTempl iPSPFCtrlTempl = this.iPSPFStyle.getPSPFCtrlTempl(iPSControl.getPSControlType(), this.getPSPFPubCode());
                if (iPSPFCtrlTempl == null) continue;
                IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher = iPSPFCtrlTempl.getPSPFCtrlCodePublisher();
                IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlCodePublisher.generateCode(this.iPSPublisherContext, iPSControl);
                if (iPSGenerateCodeResult != null) {
                    params.put(iPSControl.getName(), iPSGenerateCodeResult);
                    psGenerateCodeResultList.add(iPSGenerateCodeResult);
                    psCtrlMethod.registerCtrlResult(iPSControl.getName(), iPSGenerateCodeResult);
                }
                iPSPFCtrlCodePublisher.close();
            }
            params.put("ctrls", psGenerateCodeResultList);
        }
        this.onFillGenerateCodeParams(params);
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
        this.onClose();
        this.iPSPFCtrlTempl.releasePSPFCtrlCodePublisher(this);
    }

    @Override
    public void generateCode2(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl) throws Exception {
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
            this.onGenerateCode2(null);
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

    @Override
    public String generateCode2(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl, Map<String, Object> params) throws Exception {
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
        File folder;
        String strPubFolder;
        Object objPSAppViewCode;
        boolean bV2 = false;
        if (StringHelper.Compare((String)((IPSSystemUtil)((Object)this.iPSApplication.getPSSystem())).getTemplEngineVer(), (String)"V2", (boolean)true) == 0) {
            bV2 = true;
        }
        HashMap<String, Object> map = new HashMap<String, Object>();
        if (params != null) {
            map.putAll(params);
        }
        PSGenerateCodeResultImpl psGenerateCodeResultImpl = this.onGenerateCode(map);
        String strCode = psGenerateCodeResultImpl.getCode();
        IPSSysPubRuntime iPSSysPubRuntime = null;
        if (this.iPSPublisherContext != null && this.iPSPublisherContext.getPubParams() != null && this.iPSPublisherContext.getPubParams().containsKey("syspub")) {
            iPSSysPubRuntime = (IPSSysPubRuntime)this.iPSPublisherContext.getPubParams().get("syspub");
        }
        String strFullCodePath = "";
        String strFullClassName = "";
        if (bV2) {
            PSPFCtrlTempl psPFCtrlTempl = this.iPSPFCtrlTempl.getPSPFCtrlTemplData();
            if (!StringHelper.IsNullOrEmpty((String)psPFCtrlTempl.getCODEPATH())) {
                strFullCodePath = PSTemplHelper.generateCode((BaseDataEntity)psPFCtrlTempl, "CODEPATH", params);
            }
            if (!StringHelper.IsNullOrEmpty((String)psPFCtrlTempl.getFILENAME())) {
                strFullClassName = PSTemplHelper.generateCode((BaseDataEntity)psPFCtrlTempl, "FILENAME", params);
            }
        } else {
            strFullCodePath = this.iPSApplication.getCodeFolder();
            strFullCodePath = String.valueOf(strFullCodePath) + StringHelper.Format((String)"%1$s%2$s", (Object)File.separator, (Object)this.getPSPFPubCode().getPSPFCodeFolder().getFolderName());
            if (!StringHelper.IsNullOrEmpty((String)this.getPSPFPubCode().getCodeFolder())) {
                strFullCodePath = String.valueOf(strFullCodePath) + StringHelper.Format((String)"%1$s%2$s", (Object)File.separator, (Object)this.getPSPFPubCode().getCodeFolder());
            }
            if (!StringHelper.IsNullOrEmpty((String)strFullCodePath)) {
                strFullCodePath = String.valueOf(strFullCodePath) + File.separator;
            }
            strFullCodePath = String.valueOf(strFullCodePath) + this.getPSControlCodeName(this.iPSAppView, this.iPSControl);
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
            strFullClassName = String.valueOf(strFullClassName) + this.getPSControlCodeName(this.iPSAppView, this.iPSControl);
        }
        PSAppViewCode psAppViewCode = new PSAppViewCode();
        psAppViewCode.setPSSYSAPPID(this.iPSApplication.getId());
        psAppViewCode.setPSSYSAPPNAME(this.iPSApplication.getName());
        psAppViewCode.setPSAPPVIEWID(this.iPSAppView.getId());
        psAppViewCode.setPSAPPVIEWNAME(this.iPSAppView.getName());
        psAppViewCode.setPSPFPUBCODEID(this.getPSPFPubCode().getId());
        psAppViewCode.setPSPFPUBCODENAME(this.getPSPFPubCode().getName());
        psAppViewCode.setPSAPPVIEWCODENAME(strFullClassName);
        psAppViewCode.setCODEPATH(strFullCodePath);
        psAppViewCode.setPUBCODE(strCode);
        psAppViewCode.setPSPFSTYLEID(this.iPSPFStyle.getId());
        if (this.iPSPublisherContext != null && (objPSAppViewCode = this.iPSPublisherContext.getUserTag("PSAPPVIEWCODE")) != null && objPSAppViewCode instanceof PSAppViewCode) {
            PSAppViewCode dstPSAppViewCode = (PSAppViewCode)((Object)objPSAppViewCode);
            psAppViewCode.CopyTo(dstPSAppViewCode, true);
            return strCode;
        }
        String strFolder = this.strCodeFolder;
        if (PSJITWebContext.getInstance() != null) {
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
            this.iPSPublisherContext.log(4, null, strInfo);
            log.warn((Object)strInfo);
            if (PSTaskServerEnvImpl.getCurrent().isThrowExceptionWhenFileNameTooLong()) {
                throw new Exception(StringHelper.Format((String)"\u53d1\u5e03\u4ee3\u7801[%1$s]\u540d\u79f0\u957f\u5ea6\u8d85\u8fc7[%2$s]", (Object)strFullPath, (Object)PSTaskServerEnvImpl.getCurrent().getMaxFileNameLength()));
            }
        }
        if (this.iPSPFStyle.getPFEngineVer() >= 20 && StringHelper.IsNullOrEmpty((String)strCode.trim())) {
            File removeFile = new File(strFullPath);
            if (removeFile.exists()) {
                removeFile.delete();
            }
            return "";
        }
        if (iPSSysPubRuntime != null) {
            ((IPSSystemUtil)((Object)this.iPSApplication.getPSSystem())).pubPFCode(iPSSysPubRuntime, this.iPSApplication, this.getPSPFPubCode().getPSPFCodeFolder().getFolderName(), strFullPath, strCode, null);
        } else {
            ((IPSSystemUtil)((Object)this.iPSApplication.getPSSystem())).writeFile(strFullPath, strCode, null);
        }
        return strCode;
    }

    protected String getPSControlCodeName(IPSAppView iPSAppView, IPSControl iPSControl) {
        return String.valueOf(iPSAppView.getFullCodeName()) + "_" + iPSControl.getName().toLowerCase();
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
        IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(strCodePart).getPSPFCtrlPartCodePublisher();
        IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, this, this.iPSControl, objItem, null);
        iPSPFCtrlPartCodePublisher.close();
        return iPSGenerateCodeResult.getCode();
    }

    @Override
    public boolean hasCodePart(String strCodePart) throws Exception {
        return this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(strCodePart, true) != null;
    }
}

