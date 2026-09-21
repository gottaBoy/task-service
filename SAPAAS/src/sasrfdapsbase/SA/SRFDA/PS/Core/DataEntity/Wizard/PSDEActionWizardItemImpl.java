/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDEActionWizard
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Wizard;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEActionWizard;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEActionWizardItem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEAWItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.core.IDEActionWizard;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDEActionWizardItemImpl
extends PSObjectImpl
implements IPSDEActionWizardItem {
    private static final Log log = LogFactory.getLog(PSDEActionWizardItemImpl.class);
    private IPSDEActionWizard iPSDEActionWizard = null;
    private PSDEAWItem psDEActionWizardItem = null;
    private String strContent = null;
    private String strActionValue = null;
    private String strMoreUrl = null;
    private IPSDEField iPSDEField = null;
    private String strPSDEFieldId = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEActionWizard iPSDEActionWizard, PSDEAWItem psDEActionWizardItem) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDEActionWizard(iPSDEActionWizard);
            this.setPSDEActionWizardItemData(psDEActionWizardItem);
            this.setId(this.psDEActionWizardItem.getPSDEAWITEMID());
            this.setName(this.psDEActionWizardItem.getPSDEAWITEMNAME());
            this.setPSObjectData(this.psDEActionWizardItem);
            this.strContent = this.psDEActionWizardItem.getCONTENT();
            this.strActionValue = this.psDEActionWizardItem.getACTIONVALUE();
            this.strMoreUrl = this.psDEActionWizardItem.getMOREURL();
            this.strPSDEFieldId = this.psDEActionWizardItem.getPSDEFID();
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
    public IPSDEActionWizard getPSDEActionWizard() {
        return this.iPSDEActionWizard;
    }

    protected void setPSDEActionWizard(IPSDEActionWizard iPSDEActionWizard) {
        this.iPSDEActionWizard = iPSDEActionWizard;
    }

    public PSDEAWItem getPSDEActionWizardItemData() {
        return this.psDEActionWizardItem;
    }

    protected void setPSDEActionWizardItemData(PSDEAWItem psDEActionWizardItem) {
        this.psDEActionWizardItem = psDEActionWizardItem;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEActionWizard.getPSSysModelInstId();
    }

    public String getContent() {
        return this.strContent;
    }

    public String getMoreUrl() {
        return this.strMoreUrl;
    }

    public String getActionValue() {
        return this.strActionValue;
    }

    @Override
    public String getPSDEFieldId() {
        return this.strPSDEFieldId;
    }

    @Override
    public IPSDEField getPSDEField() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.getPSDEFieldId())) {
            return null;
        }
        if (this.iPSDEField == null) {
            this.iPSDEField = this.getPSDEActionWizard().getPSDataEntity().getPSDEField(this.getPSDEFieldId());
        }
        return this.iPSDEField;
    }

    public IDEActionWizard getDEActionWizard() {
        return this.getPSDEActionWizard();
    }

    @Override
    public String getModelType() {
        return "PSDEAWITEM";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDEActionWizard().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEActionWizard().getPSDataEntity().getPSSystem());
    }
}

