/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher2;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.IPSSysPubRuntime;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFDA.PS.Core.Pub.PSImportHelper;
import SA.SRFDA.PS.Core.Pub.PSPFCtrlCodePublisher2Impl;
import SA.SRFDA.PS.Data.PSAppViewCode;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.util.KeyValueHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFViewCtrlCodePublisher2Impl
extends PSPFCtrlCodePublisher2Impl
implements IPSPFCtrlCodePublisher2 {
    private static final Log log = LogFactory.getLog(PSPFViewCtrlCodePublisher2Impl.class);
    private String strCodeFolder = null;

    @Override
    protected void onInit() throws Exception {
        this.strCodeFolder = PSTaskServerEnvImpl.getCurrent().getCodeFolder();
        super.onInit();
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
            this.beforeGenerateCode();
            this.onGenerateCode2(new HashMap<String, Object>());
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
            this.beforeGenerateCode();
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
        File fileFolder;
        File folder;
        Object objPSAppViewCode;
        HashMap<String, Object> map = new HashMap<String, Object>();
        if (params != null) {
            map.putAll(params);
        }
        PSAppViewCode psAppViewCode = new PSAppViewCode();
        psAppViewCode.setPSAPPVIEWCODEID(KeyValueHelper.genUniqueId((String)this.iPSAppView.getId(), (String)this.iPSControl.getName(), (String)this.getPSPFPubCode().getId()));
        psAppViewCode.setPSSYSAPPID(this.iPSApplication.getId());
        psAppViewCode.setPSSYSAPPNAME(this.iPSApplication.getName());
        psAppViewCode.setPSAPPVIEWID(this.iPSAppView.getId());
        psAppViewCode.setPSAPPVIEWNAME(this.iPSAppView.getName());
        psAppViewCode.setPSPFPUBCODEID(this.getPSPFPubCode().getId());
        psAppViewCode.setPSPFPUBCODENAME(this.getPSPFPubCode().getName());
        psAppViewCode.setPSPFSTYLEID(this.iPSPFStyle.getId());
        PSGenerateCodeResultImpl psGenerateCodeResultImpl = this.onGenerateCode(map, psAppViewCode);
        String strCode = psGenerateCodeResultImpl.getCode();
        IPSSysPubRuntime iPSSysPubRuntime = null;
        if (this.iPSPublisherContext != null && this.iPSPublisherContext.getPubParams() != null && this.iPSPublisherContext.getPubParams().containsKey("syspub")) {
            iPSSysPubRuntime = (IPSSysPubRuntime)this.iPSPublisherContext.getPubParams().get("syspub");
        }
        boolean bV2 = false;
        if (StringHelper.Compare((String)((IPSSystemUtil)((Object)this.iPSApplication.getPSSystem())).getTemplEngineVer(), (String)"V2", (boolean)true) == 0) {
            bV2 = true;
        }
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

    @Override
    protected IPSGenerateCodeResult internalGetCtrlCode(Object objCtrl, String strCodeType, Map<String, Object> params) throws Exception {
        if (objCtrl instanceof String) {
            return super.internalGetCtrlCode(this.iPSControl, (String)objCtrl, params);
        }
        return super.internalGetCtrlCode(this.iPSControl, strCodeType, params);
    }

    @Override
    protected boolean internalHasCtrlCode(Object objCtrl, String strCodeType) throws Exception {
        if (objCtrl instanceof String) {
            return super.internalHasCtrlCode(this.iPSControl, (String)objCtrl);
        }
        return super.internalHasCtrlCode(this.iPSControl, strCodeType);
    }
}

