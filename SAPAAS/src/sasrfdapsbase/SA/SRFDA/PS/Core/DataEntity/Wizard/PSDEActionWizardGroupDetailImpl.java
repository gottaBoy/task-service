/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Wizard;

import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEActionWizard;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEActionWizardGroup;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEActionWizardGroupDetail;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEAWGrpDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDEActionWizardGroupDetailImpl
extends PSObjectImpl
implements IPSDEActionWizardGroupDetail {
    private static final Log log = LogFactory.getLog(PSDEActionWizardGroupDetailImpl.class);
    private IPSDEActionWizardGroup iPSDEActionWizardGroup = null;
    private PSDEAWGrpDetail psDEAWGrpDetail = null;
    private IPSDEActionWizard iPSDEActionWizard = null;
    private String strPSDEActionWizardId = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEActionWizardGroup iPSDEActionWizardGroup, PSDEAWGrpDetail psDEAWGrpDetail) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEActionWizardGroup = iPSDEActionWizardGroup;
            this.psDEAWGrpDetail = psDEAWGrpDetail;
            this.setId(this.psDEAWGrpDetail.getPSDEAWGRPDETAILID());
            this.setName(this.psDEAWGrpDetail.getPSDEAWGRPDETAILNAME());
            this.strPSDEActionWizardId = this.psDEAWGrpDetail.getPSDEACTIONWIZARDID();
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
    public IPSDEActionWizardGroup getPSDEActionWizardGroup() {
        return this.iPSDEActionWizardGroup;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDEActionWizardGroup().getPSSysModelInstId();
    }

    public String getDEActionWizardId() {
        return this.strPSDEActionWizardId;
    }

    @Override
    public IPSDEActionWizard getPSDEActionWizard() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.getDEActionWizardId())) {
            return null;
        }
        if (this.iPSDEActionWizard == null) {
            this.iPSDEActionWizard = this.getPSDEActionWizardGroup().getPSDataEntity().getPSDEActionWizard(this.getDEActionWizardId());
        }
        return this.iPSDEActionWizard;
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDEActionWizardGroup().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEActionWizardGroup().getPSDataEntity().getPSSystem());
    }

    @Override
    public String getModelType() {
        return "PSDEAWGRPDETAIL";
    }
}

