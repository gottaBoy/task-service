/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Wizard;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogic;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEWizardForm;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEWizardLogic;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEWizardStep;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Data.PSDEWizard;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5411\u5bfc\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEWizard")
public interface IPSDEWizard
extends IPSDataEntityObject {
    public static final String WIZARDSTYLE_DEFAULT = "DEFAULT";
    public static final String WIZARDSTYLE_STYLE2 = "STYLE2";
    public static final String WIZARDSTYLE_STYLE3 = "STYLE3";
    public static final String WIZARDSTYLE_STYLE4 = "STYLE4";

    public void init(ISRFDAGlobalHelper var1, IPSDataEntity var2, PSDEWizard var3) throws Exception;

    public Iterator<IPSDEWizardStep> getPSDEWizardSteps();

    public IPSDEWizardStep getPSDEWizardStep(String var1) throws Exception;

    public Iterator<IPSDEWizardForm> getPSDEWizardForms();

    @Override
    public String getCodeName();

    public IPSDEAction getInitPSDEAction();

    public IPSDEAction getFinishPSDEAction();

    public String getPrevCaption();

    public String getNextCaption();

    public String getFinishCaption();

    public IPSLanguageRes getPrevCapPSLanguageRes();

    public IPSLanguageRes getNextCapPSLanguageRes();

    public IPSLanguageRes getFinishCapPSLanguageRes();

    public String getPrevCapLanResTag();

    public String getNextCapLanResTag();

    public String getFinishCapLanResTag();

    public String getWizardStyle();

    public IPSDEWizardForm getFirstPSDEWizardForm();

    public IPSDEField getStatePSDEField();

    public boolean isStateWizard();

    public boolean isEnableMainStateLogic();

    public IPSDEMSLogic getPSDEMSLogic();

    public Iterator<? extends IPSDEWizardLogic> getPSDEWizardLogics();
}

