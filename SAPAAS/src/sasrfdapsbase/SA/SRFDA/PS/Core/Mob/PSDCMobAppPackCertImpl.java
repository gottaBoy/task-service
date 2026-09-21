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
package SA.SRFDA.PS.Core.Mob;

import SA.SRFDA.PS.Core.Deploy.PSDCResObjectImplBase;
import SA.SRFDA.PS.Core.Mob.IPSDCMobAppPackCert;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDCMobAppPackCert;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Map;
import net.ibizsys.paas.util.FileHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.common.entity.File;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDCMobAppPackCertImpl
extends PSDCResObjectImplBase
implements IPSDCMobAppPackCert {
    private static final Log log = LogFactory.getLog(PSDCMobAppPackCertImpl.class);
    protected PSDCMobAppPackCert psDCMobAppPackCert = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDCMobAppPackCert psDCMobAppPackCert) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psDCMobAppPackCert = psDCMobAppPackCert;
        this.setId(this.psDCMobAppPackCert.getPSDCMOBPACKCERTID());
        this.setName(this.psDCMobAppPackCert.getPSDCMOBPACKCERTNAME());
        this.setPSObjectData(this.psDCMobAppPackCert);
        this.onInit();
    }

    @Override
    public String getModelType() {
        return "PSDCMOBPACKCERT";
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected void onFillResCfgParams(Map<String, String> params) throws Exception {
        File[] list;
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
            params.put("mobcert.android.path", list[0].getLocalPath2());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDCMobAppPackCert.getIOSAPPIDS())) {
            params.put("mobcert.ios.ids", this.psDCMobAppPackCert.getIOSAPPIDS());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDCMobAppPackCert.getIOSCERTPWD())) {
            params.put("mobcert.ios.pass", this.psDCMobAppPackCert.getIOSCERTPWD());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDCMobAppPackCert.getIOSDISTMPCERT()) && (list = FileHelper.getFileList((String)this.psDCMobAppPackCert.getIOSDISTMPCERT(), null)) != null && list.length > 0) {
            params.put("mobcert.ios.path", list[0].getLocalPath2());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDCMobAppPackCert.getIOSDISTP12CERT()) && (list = FileHelper.getFileList((String)this.psDCMobAppPackCert.getIOSDISTP12CERT(), null)) != null && list.length > 0) {
            params.put("mobcert.ios.p12path", list[0].getLocalPath2());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDCMobAppPackCert.getIOSWKAMPCERT()) && (list = FileHelper.getFileList((String)this.psDCMobAppPackCert.getIOSWKAMPCERT(), null)) != null && list.length > 0) {
            params.put("mobcert.ios.wkapath", list[0].getLocalPath2());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDCMobAppPackCert.getIOSWKEMPCERT()) && (list = FileHelper.getFileList((String)this.psDCMobAppPackCert.getIOSWKEMPCERT(), null)) != null && list.length > 0) {
            params.put("mobcert.ios.wkepath", list[0].getLocalPath2());
        }
        super.onFillResCfgParams(params);
    }
}

