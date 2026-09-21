/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Wizard;

import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEWizard;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Data.PSDEWizardStep;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5411\u5bfc\u6b65\u9aa4\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEWizardStep")
public interface IPSDEWizardStep
extends IPSModelObject {
    public void init(ISRFDAGlobalHelper var1, IPSDEWizard var2, PSDEWizardStep var3) throws Exception;

    public IPSDEWizard getPSDEWizard();

    public String getStepTag();

    public boolean isEnableLink();

    public String getTitle();

    public String getSubTitle();

    public IPSSysCss getTitlePSSysCss();

    public IPSSysImage getPSSysImage();

    public IPSLanguageRes getTitlePSLanguageRes();

    public IPSLanguageRes getSubTitlePSLanguageRes();
}

