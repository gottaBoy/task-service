/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubPkg;
import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Core.SF.IPSSFPkg;
import SA.SRFDA.PS.Core.SF.IPSSFPkgVer;
import SA.SRFDA.PS.Core.SF.PSSFStylePkgImpl;
import SA.SRFDA.PS.Data.PSSFPkgVer;
import SA.SRFDA.PS.Data.PSSysSFPubPkg;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysSFPubPkgImpl
extends PSObjectImpl
implements IPSSysSFPubPkg,
IPSSFPkgVer {
    private static final Log log = LogFactory.getLog(PSSysSFPubPkgImpl.class);
    private IPSSysSFPub iPSSysSFPub = null;
    private PSSysSFPubPkg psSysSFPubPkg = null;
    private IPSSFPkg iPSSFPkg = null;
    private IPSSFPkgVer iPSSFPkgVer = null;
    private String strVerParam = "";
    private int nOrderValue = PSSFStylePkgImpl.DEFAULTORDERVALUE;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysSFPub iPSSysSFPub, PSSysSFPubPkg psSysSFPubPkg) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSSysSFPub = iPSSysSFPub;
            this.psSysSFPubPkg = psSysSFPubPkg;
            this.setId(this.psSysSFPubPkg.getPSSYSSFPUBPKGID());
            this.setName(this.psSysSFPubPkg.getPSSYSSFPUBPKGNAME());
            this.setPSObjectData(this.psSysSFPubPkg);
            if (!StringHelper.IsNullOrEmpty((String)this.psSysSFPubPkg.getPSSFPKGID())) {
                this.iPSSFPkg = this.getPSSF().getPSSFPkg(this.psSysSFPubPkg.getPSSFPKGID());
                if (!StringHelper.IsNullOrEmpty((String)this.psSysSFPubPkg.getPSSFPKGVERID())) {
                    this.iPSSFPkgVer = this.getPSSF().getPSSFPkgVer(this.psSysSFPubPkg.getPSSFPKGVERID());
                }
            }
            this.strVerParam = this.psSysSFPubPkg.getPKGPARAM();
            if (!this.psSysSFPubPkg.isORDERVALUENull()) {
                this.nOrderValue = this.psSysSFPubPkg.getORDERVALUE();
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = net.ibizsys.paas.util.StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = net.ibizsys.paas.util.StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)net.ibizsys.paas.util.StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysSFPub().getPSSysModelInstId();
    }

    @Override
    public IPSSysSFPub getPSSysSFPub() {
        return this.iPSSysSFPub;
    }

    @Override
    public IPSSF getPSSF() {
        return this.getPSSysSFPub().getPSSFStyle().getPSSF();
    }

    @Override
    public IPSSFPkgVer getPSSFPkgVer() {
        return this.iPSSFPkgVer;
    }

    @Override
    @PSModelRTMeta(description="\u5305\u53c2\u6570")
    public String getPkgParam() {
        return this.strVerParam;
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSF iPSSF, PSSFPkgVer psSFPkgVer) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public IPSSFPkg getPSSFPkg() {
        return this.iPSSFPkg;
    }

    @Override
    @PSModelRTMeta(description="\u7248\u672c\u6807\u8bb0")
    public String getVerTag() {
        if (this.getPSSFPkgVer() != null) {
            return this.getPSSFPkgVer().getVerTag();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7248\u672c\u6807\u8bb02")
    public String getVerTag2() {
        if (this.getPSSFPkgVer() != null) {
            return this.getPSSFPkgVer().getVerTag2();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7248\u672c\u53c2\u6570")
    public String getVerParam() {
        if (!StringHelper.IsNullOrEmpty((String)this.strVerParam)) {
            return this.strVerParam;
        }
        if (this.getPSSFPkgVer() != null) {
            return this.getPSSFPkgVer().getVerParam();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c")
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    @PSModelRTMeta(description="\u5305\u53c2\u65702")
    public String getPkgParam2() {
        return this.psSysSFPubPkg.getPKGPARAM2();
    }

    @Override
    @PSModelRTMeta(description="\u5305\u53c2\u65703")
    public String getPkgParam3() {
        return this.psSysSFPubPkg.getPKGPARAM3();
    }

    @Override
    @PSModelRTMeta(description="\u5305\u53c2\u65704")
    public String getPkgParam4() {
        return this.psSysSFPubPkg.getPKGPARAM4();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSysSFPub().getPSSystem());
    }

    @Override
    public String getModelType() {
        return "PSSYSSFPUBPKG";
    }

    @Override
    public String getModelId() {
        if (this.getPSSysSFPub() != null) {
            return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSSysSFPub().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }
}

