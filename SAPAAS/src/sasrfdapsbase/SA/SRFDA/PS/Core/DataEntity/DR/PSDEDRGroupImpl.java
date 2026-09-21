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
package SA.SRFDA.PS.Core.DataEntity.DR;

import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRGroup;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Data.PSDEDRGroup;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSDEDRGroupImpl
extends PSDataEntityObjectImpl
implements IPSDEDRGroup {
    private static final Log log = LogFactory.getLog(PSDEDRGroupImpl.class);
    protected PSDEDRGroup psDEDRGroup = null;
    private IPSSysImage iPSSysImage = null;
    private IPSLanguageRes capPSLanguageRes = null;
    private boolean bHidden = false;
    private IPSSysPFPlugin headerPSSysPFPlugin = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSDEDRGroup psDEDRGroup) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDataEntity(iPSDataEntity);
            this.psDEDRGroup = psDEDRGroup;
            this.setId(this.psDEDRGroup.getPSDEDRGROUPID());
            this.setName(this.psDEDRGroup.getPSDEDRGROUPNAME());
            this.setPSObjectData(this.psDEDRGroup);
            if (!StringHelper.IsNullOrEmpty((String)this.psDEDRGroup.getPSSYSIMAGEID())) {
                this.iPSSysImage = this.getPSDataEntity().getPSSystem().getPSSysImage(this.psDEDRGroup.getPSSYSIMAGEID());
            }
            if (!StringHelper.IsNullOrEmpty((String)this.psDEDRGroup.getCAPPSLANRESID())) {
                this.capPSLanguageRes = this.getPSDataEntity().getPSSystem().getPSLanguageRes(this.psDEDRGroup.getCAPPSLANRESID());
            }
            if (!this.psDEDRGroup.isHIDDENFLAGNull()) {
                this.bHidden = this.psDEDRGroup.getHIDDENFLAG();
            }
            if (!StringHelper.IsNullOrEmpty((String)this.psDEDRGroup.getHEADERPSSYSPFPLUGINID())) {
                this.headerPSSysPFPlugin = this.getPSDataEntity().getPSSystem().getPSSysPFPlugin(this.psDEDRGroup.getHEADERPSSYSPFPLUGINID());
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
    public String getCaption(String strLanguage) {
        return this.psDEDRGroup.getPSDEDRGROUPNAME();
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u56fe\u6807\u8d44\u6e90\u5bf9\u8c61", fields={"PSSYSIMAGEID"})
    public IPSSysImage getPSSysImage() {
        return this.iPSSysImage;
    }

    @Override
    public String getModelType() {
        return "PSDEDRGROUP";
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61", fields={"CAPPSLANRESID"})
    public IPSLanguageRes getCapPSLanguageRes() {
        return this.capPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u9690\u85cf\u5206\u7ec4", fields={"HIDDENFLAG"})
    public boolean isHidden() {
        return this.bHidden;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898", fields={"PSDEDRGROUPNAME"})
    public String getCaption() {
        return this.psDEDRGroup.getPSDEDRGROUPNAME();
    }

    @Override
    public String getModelId() {
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDataEntity().getModelId(), (Object)this.getId());
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.psDEDRGroup.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u5934\u90e8\u524d\u7aef\u6269\u5c55\u63d2\u4ef6")
    public IPSSysPFPlugin getHeaderPSSysPFPlugin() {
        return this.headerPSSysPFPlugin;
    }
}

