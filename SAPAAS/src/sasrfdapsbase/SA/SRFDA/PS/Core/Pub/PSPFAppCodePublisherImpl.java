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
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFAppTempl;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Pub.IPSPFAppCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.IPSSysPubRuntime;
import SA.SRFDA.PS.Core.Pub.PSPFCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Data.PSAppViewCode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFAppCodePublisherImpl
extends PSPFCodePublisherImpl
implements IPSPFAppCodePublisher {
    private static final Log log = LogFactory.getLog(PSPFAppCodePublisherImpl.class);
    protected IPSPFAppTempl iPSPFAppTempl = null;
    protected IPSPublisherContext iPSPublisherContext = null;
    protected IPSApplication iPSApplication = null;
    protected IPSPF iPSPF = null;
    protected IPSPFStyle iPSPFStyle = null;
    private String strCodeFolder = null;
    private String strToolFolder = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPFAppTempl iPSPFAppTempl) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSPFAppTempl = iPSPFAppTempl;
        this.setPSPFPubCode(this.iPSPFAppTempl.getPSPFPubCode());
        this.strCodeFolder = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "CODEFOLDER", null);
        this.strToolFolder = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "TOOLFOLDER", null);
        this.onInit();
    }

    @Override
    public void generateCode(IPSPublisherContext iPSPublisherContext, IPSApplication iPSApplication) throws Exception {
        this.iPSPublisherContext = iPSPublisherContext;
        this.iPSApplication = iPSApplication;
        this.iPSPF = this.iPSApplication.getPSPF();
        this.iPSPFStyle = this.iPSApplication.getPSPFStyle();
        this.onGenerateCode();
    }

    protected void onGenerateCode() throws Exception {
        this.onGenerateCode(null, null);
    }

    protected void onGenerateCode(Object objItem, String strItemCodeName) throws Exception {
        String strPubFolder;
        Object objPSAppViewCode;
        boolean bV2 = false;
        if (StringHelper.Compare((String)((IPSSystemUtil)((Object)this.iPSApplication.getPSSystem())).getTemplEngineVer(), (String)"V2", (boolean)true) == 0) {
            bV2 = true;
        }
        IPSSysPubRuntime iPSSysPubRuntime = null;
        if (this.iPSPublisherContext != null && this.iPSPublisherContext.getPubParams() != null && this.iPSPublisherContext.getPubParams().containsKey("syspub")) {
            iPSSysPubRuntime = (IPSSysPubRuntime)this.iPSPublisherContext.getPubParams().get("syspub");
        }
        HashMap<String, Object> params = new HashMap<String, Object>();
        if (this.iPSPublisherContext.getPubParams() != null) {
            params.putAll(this.iPSPublisherContext.getPubParams());
        }
        params.put("publisher", this);
        params.put("app", this.iPSApplication);
        params.put("sys", this.iPSApplication.getPSSystem());
        params.put("apptempl", this.iPSPFAppTempl);
        params.put("codetempl", this.iPSPFAppTempl);
        params.put("pf", this.iPSPF);
        params.put("pfstyle", this.iPSPFStyle);
        if (objItem != null) {
            params.put("item", objItem);
        }
        params.put("toolfolder", this.strToolFolder);
        String strCodeFolder2 = this.strCodeFolder;
        if (PSJITWebContext.getInstance() != null && PSJITWebContext.getInstance().getSystemModel() != null) {
            strCodeFolder2 = PSJITWebContext.getInstance().getSystemModel().getJITCodeFolder();
            params.put("jitworkshop", PSJITWebContext.getInstance().getSystemModel().getJITWorkshopFolder());
        }
        params.put("codefolder", strCodeFolder2);
        this.onFillGenerateCodeParams(params);
        String strFullClassName = "";
        String strFullCodePath = "";
        if (bV2) {
            if (!StringHelper.IsNullOrEmpty((String)this.iPSPFAppTempl.getPSPFAppTemplData().getCODEPATH())) {
                strFullCodePath = PSTemplHelper.generateCode((BaseDataEntity)this.iPSPFAppTempl.getPSPFAppTemplData(), "CODEPATH", params);
            }
            if (!StringHelper.IsNullOrEmpty((String)this.iPSPFAppTempl.getPSPFAppTemplData().getFILENAME())) {
                strFullClassName = PSTemplHelper.generateCode((BaseDataEntity)this.iPSPFAppTempl.getPSPFAppTemplData(), "FILENAME", params);
            }
        } else {
            strFullClassName = this.iPSApplication.getPKGCodeName();
            if (!StringHelper.IsNullOrEmpty((String)this.getPSPFPubCode().getPKGCodeName())) {
                strFullClassName = String.valueOf(strFullClassName) + StringHelper.Format((String)".%1$s", (Object)this.getPSPFPubCode().getPKGCodeName());
            }
            if (!StringHelper.IsNullOrEmpty((String)strFullClassName)) {
                strFullClassName = String.valueOf(strFullClassName) + StringHelper.Format((String)".");
            }
            strFullCodePath = this.iPSApplication.getCodeFolder();
            strFullCodePath = String.valueOf(strFullCodePath) + StringHelper.Format((String)"%1$s%2$s", (Object)File.separator, (Object)this.getPSPFPubCode().getPSPFCodeFolder().getFolderName());
            if (!StringHelper.IsNullOrEmpty((String)this.getPSPFPubCode().getCodeFolder())) {
                strFullCodePath = String.valueOf(strFullCodePath) + StringHelper.Format((String)"%1$s%2$s", (Object)File.separator, (Object)this.getPSPFPubCode().getCodeFolder());
            }
            if (!StringHelper.IsNullOrEmpty((String)strFullCodePath)) {
                strFullCodePath = String.valueOf(strFullCodePath) + StringHelper.Format((String)File.separator);
            }
            if (!StringHelper.IsNullOrEmpty((String)strItemCodeName)) {
                strFullCodePath = String.valueOf(strFullCodePath) + strItemCodeName;
            }
            strFullCodePath = String.valueOf(strFullCodePath) + this.getPSPFPubCode().getClassNameExt();
            strFullCodePath = String.valueOf(strFullCodePath) + this.getPSPFPubCode().getFileNameExt();
        }
        String strCode = PSTemplHelper.generateCode((BaseDataEntity)this.iPSPFAppTempl.getPSPFAppTemplData(), "TEMPLCODE", params);
        PSAppViewCode psAppViewCode = new PSAppViewCode();
        psAppViewCode.setPSSYSAPPID(this.iPSApplication.getId());
        psAppViewCode.setPSSYSAPPNAME(this.iPSApplication.getName());
        psAppViewCode.setPSPFPUBCODEID(this.getPSPFPubCode().getId());
        psAppViewCode.setPSPFPUBCODENAME(this.getPSPFPubCode().getName());
        psAppViewCode.setPSAPPVIEWCODENAME(strFullClassName);
        psAppViewCode.setCODEPATH(strFullCodePath);
        psAppViewCode.setPUBCODE(strCode);
        psAppViewCode.setPSPFSTYLEID(this.iPSPFStyle.getId());
        if (this.iPSPublisherContext != null && (objPSAppViewCode = this.iPSPublisherContext.getUserTag("PSAPPVIEWCODE")) != null && objPSAppViewCode instanceof PSAppViewCode) {
            PSAppViewCode dstPSAppViewCode = (PSAppViewCode)((Object)objPSAppViewCode);
            psAppViewCode.CopyTo(dstPSAppViewCode, true);
            dstPSAppViewCode.set("TEMPLCODE", this.iPSPFAppTempl.getPSPFAppTemplData().getTEMPLCODE());
            return;
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
        File folder = new File(String.valueOf(strCodeFolder) + strCodePath);
        if ((folder = folder.getParentFile()) != null && !folder.exists()) {
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
    public void close() {
        this.iPSPublisherContext = null;
        this.iPSApplication = null;
        this.iPSPF = null;
        this.iPSPFStyle = null;
        this.onClose();
        if (this.iPSPFAppTempl != null) {
            this.iPSPFAppTempl.releasePSPFAppCodePublisher(this);
        }
    }

    @Override
    public IPSPublisherContext getContext() {
        return this.iPSPublisherContext;
    }
}

