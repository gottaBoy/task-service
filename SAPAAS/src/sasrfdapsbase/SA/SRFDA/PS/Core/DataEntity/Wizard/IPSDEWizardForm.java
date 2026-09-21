/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Wizard;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEWizard;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEWizardStep;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Data.PSDEWizardForm;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5411\u5bfc\u8868\u5355\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEWizardForm")
public interface IPSDEWizardForm
extends IPSModelObject {
    public static final String STEPACTION_PREV = "PREV";
    public static final String STEPACTION_NEXT = "NEXT";
    public static final String STEPACTION_FINISH = "FINISH";

    public void init(ISRFDAGlobalHelper var1, IPSDEWizard var2, PSDEWizardForm var3) throws Exception;

    public IPSDEWizard getPSDEWizard();

    public IPSDEWizardStep getPSDEWizardStep();

    public String getFormTag();

    public IPSDEAction getLoadPSDEAction();

    public IPSDEAction getSavePSDEAction();

    public IPSDEAction getGoBackPSDEAction();

    public String[] getStepActions();

    public boolean isFirstForm();

    public String getPSDEFormId();

    public String getPSDEFormName();

    public String getMobPSDEFormId();

    public String getMobPSDEFormName();

    public String getConfirmMsg();

    public IPSLanguageRes getCMPSLanguageRes();

    public String getConfirmMsg2();

    public IPSLanguageRes getCM2PSLanguageRes();

    public String getGoFinishEnableScriptCode();

    public String getGoPrevEnableScriptCode();

    public String getGoNextEnableScriptCode();

    public String getStepTag();
}

