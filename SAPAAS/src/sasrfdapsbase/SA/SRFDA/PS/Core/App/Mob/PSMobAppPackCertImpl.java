/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.FileHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.psrt.srv.common.entity.File
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.Mob;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.Mob.IPSMobAppPackCert;
import SA.SRFDA.PS.Core.Deploy.PSDCResObjectImplBase;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.IPSTaskServerEnv;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Data.PSDCMobAppPackCert;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Map;
import net.ibizsys.paas.util.FileHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.common.entity.File;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSMobAppPackCertImpl
extends PSDCResObjectImplBase
implements IPSMobAppPackCert {
    private static final Log log = LogFactory.getLog(PSMobAppPackCertImpl.class);
    protected PSDCMobAppPackCert psDCMobAppPackCert = null;
    private IPSApplication iPSApplication = null;
    private String strPackType = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, PSDCMobAppPackCert psDCMobAppPackCert) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSApplication = iPSApplication;
            this.psDCMobAppPackCert = psDCMobAppPackCert;
            this.setId(this.psDCMobAppPackCert.getPSDCMOBPACKCERTID());
            this.setName(this.psDCMobAppPackCert.getPSDCMOBPACKCERTNAME());
            this.setPSObjectData(this.psDCMobAppPackCert);
            this.strPackType = this.psDCMobAppPackCert.getPACKTYPE();
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    public String getModelType() {
        return "PSDCMOBPACKCERT";
    }

    @Override
    protected void onFillResCfgParams(Map<String, String> params) throws Exception {
        File[] list;
        IPSTaskServerEnv iPSTaskServerEnv = PSTaskServerEnvImpl.getCurrent();
        if (!StringHelper.isNullOrEmpty((String)this.getPackType())) {
            params.put("mobcert.packtype", this.getPackType());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDCMobAppPackCert.getANDROIDCERTDOMAIN())) {
            params.put("mobcert.android.domain", this.psDCMobAppPackCert.getANDROIDCERTDOMAIN());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDCMobAppPackCert.getANDROIDCERTALIAS())) {
            params.put("mobcert.android.alias", this.psDCMobAppPackCert.getANDROIDCERTALIAS());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDCMobAppPackCert.getANDROIDCERTKEY())) {
            params.put("mobcert.android.id", this.psDCMobAppPackCert.getANDROIDCERTKEY());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDCMobAppPackCert.getANDROIDCERTSTOREPWD())) {
            params.put("mobcert.android.pass", this.psDCMobAppPackCert.getANDROIDCERTSTOREPWD());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDCMobAppPackCert.getANDROIDCERTFILE()) && (list = FileHelper.getFileList((String)this.psDCMobAppPackCert.getANDROIDCERTFILE(), null)) != null && list.length > 0) {
            params.put("mobcert.android.path", String.valueOf(iPSTaskServerEnv.getFileFolder()) + list[0].getLocalPath());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDCMobAppPackCert.getIOSAPPIDS())) {
            params.put("mobcert.ios.ids", this.psDCMobAppPackCert.getIOSAPPIDS());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDCMobAppPackCert.getIOSCERTPWD())) {
            params.put("mobcert.ios.pass", this.psDCMobAppPackCert.getIOSCERTPWD());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDCMobAppPackCert.getIOSDISTMPCERT()) && (list = FileHelper.getFileList((String)this.psDCMobAppPackCert.getIOSDISTMPCERT(), null)) != null && list.length > 0) {
            params.put("mobcert.ios.path", String.valueOf(iPSTaskServerEnv.getFileFolder()) + list[0].getLocalPath());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDCMobAppPackCert.getIOSDISTP12CERT()) && (list = FileHelper.getFileList((String)this.psDCMobAppPackCert.getIOSDISTP12CERT(), null)) != null && list.length > 0) {
            params.put("mobcert.ios.p12path", String.valueOf(iPSTaskServerEnv.getFileFolder()) + list[0].getLocalPath());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDCMobAppPackCert.getIOSWKAMPCERT()) && (list = FileHelper.getFileList((String)this.psDCMobAppPackCert.getIOSWKAMPCERT(), null)) != null && list.length > 0) {
            params.put("mobcert.ios.wkapath", String.valueOf(iPSTaskServerEnv.getFileFolder()) + list[0].getLocalPath());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDCMobAppPackCert.getIOSWKEMPCERT()) && (list = FileHelper.getFileList((String)this.psDCMobAppPackCert.getIOSWKEMPCERT(), null)) != null && list.length > 0) {
            params.put("mobcert.ios.wkepath", String.valueOf(iPSTaskServerEnv.getFileFolder()) + list[0].getLocalPath());
        }
        super.onFillResCfgParams(params);
    }

    @Override
    public IPSApplication getPSApplication() {
        return this.iPSApplication;
    }

    public IPSSystem getPSSystem() {
        return this.getPSApplication().getPSSystem();
    }

    @Override
    public String getPackType() {
        return this.strPackType;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSApplication.getPSSysModelInstId();
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSApplication().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSystem());
    }

    @Override
    public boolean isEnableDynaModel() {
        return false;
    }

    @Override
    public int getDynaInstMode() {
        return 0;
    }

    @Override
    public String getDynaInstTag2() {
        return null;
    }

    @Override
    public String getDynaModelFolder() {
        return null;
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }
}

