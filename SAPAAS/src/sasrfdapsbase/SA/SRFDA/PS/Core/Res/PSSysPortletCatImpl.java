/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPortletCat;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysPortletCat;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysPortletCatImpl
extends PSSystemObjectImpl
implements IPSSysPortletCat {
    private static final Log log = LogFactory.getLog(PSSysPortletCatImpl.class);
    protected PSSysPortletCat psSysPortletCat = null;
    private IPSSystemModule iPSSystemModule = null;
    private IPSLanguageRes namePSLanguageRes = null;
    private IPSSysImage iPSSysImage = null;
    private IPSSysCss iPSSysCss = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysPortletCat psSysPortletCat) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysPortletCat = psSysPortletCat;
            this.setId(this.psSysPortletCat.getPSSYSPORTLETCATID());
            this.setName(this.psSysPortletCat.getPSSYSPORTLETCATNAME());
            this.setPSObjectData(this.psSysPortletCat);
            if (!StringHelper.isNullOrEmpty((String)this.psSysPortletCat.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysPortletCat.getPSMODULEID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysPortletCat.getNAMEPSLANRESID())) {
                this.namePSLanguageRes = this.getPSSystem().getPSLanguageRes(this.psSysPortletCat.getNAMEPSLANRESID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysPortletCat.getPSSYSIMAGEID())) {
                this.iPSSysImage = this.getPSSystem().getPSSysImage(this.psSysPortletCat.getPSSYSIMAGEID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysPortletCat.getPSSYSCSSID())) {
                this.iPSSysCss = this.getPSSystem().getPSSysCss(this.psSysPortletCat.getPSSYSCSSID());
            }
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
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSSYSPORTLETCAT";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psSysPortletCat.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", dumpref=true, ignorepf=true)
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u540d\u79f0\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getNamePSLanguageRes() {
        return this.namePSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u56fe\u7247")
    public IPSSysImage getPSSysImage() {
        return this.iPSSysImage;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u754c\u9762\u6837\u5f0f")
    public IPSSysCss getPSSysCss() {
        return this.iPSSysCss;
    }

    @Override
    @PSModelRTMeta(description="\u95e8\u6237\u90e8\u4ef6\u5206\u7c7b\u6807\u8bb0")
    public String getUniqueTag() {
        if (this.getPSSystemModule() != null) {
            if (this.getPSSystemModule().getPSSysModelGroup() != null) {
                return String.format("%1$s__%2$s__%3$s", this.getPSSystemModule().getPSSysModelGroup().getCodeName(), this.getPSSystemModule().getCodeName(), this.getCodeName());
            }
            if (this.getPSSystemModule().getPSSysRef() != null) {
                return String.format("%1$s__%2$s__%3$s", this.getPSSystemModule().getPSSysRef().getSysRefTag(), this.getPSSystemModule().getCodeName(), this.getCodeName());
            }
            return String.format("%1$s__%2$s", this.getPSSystemModule().getCodeName(), this.getCodeName());
        }
        return this.getCodeName();
    }
}

