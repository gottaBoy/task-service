/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Wizard;

import SA.SRFDA.PS.Core.DataEntity.PSDataEntityException;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEWizard;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEWizardStep;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;

@PSModelIgnoreMeta
public class PSDEWizardException
extends PSDataEntityException {
    private IPSDEWizard iPSDEWizard = null;

    public PSDEWizardException(IPSDEWizard iPSDEWizard, int nErrorCode, String strErrorInfo) {
        super(iPSDEWizard.getPSDataEntity(), nErrorCode, strErrorInfo);
        this.iPSDEWizard = iPSDEWizard;
    }

    public IPSDEWizard getPSDEWizard() {
        return this.iPSDEWizard;
    }

    public static PSDEWizardException create(IPSDEWizard iPSDEWizard, int nErrorCode, Object objArg) throws Exception {
        return PSDEWizardException.create(iPSDEWizard, nErrorCode, objArg);
    }

    public static PSDEWizardException create(IPSDEWizard iPSDEWizard, int nErrorCode, Object objArg, Object objArg2) throws Exception {
        switch (nErrorCode) {
            case 20010: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSDEWizardStep psDEWizardStep = new PSDEWizardStep();
                CallResult callResult = PSDEWizardException.getPSModelHelper(iPSDEWizard).getPSDEWizardStep((String)objArg, psDEWizardStep);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSDEWizard.getId(), (String)psDEWizardStep.getPSDEWIZARDID(), (boolean)false) != 0) {
                        return new PSDEWizardException(iPSDEWizard, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53\u5411\u5bfc[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u6b65\u9aa4[%2$s]\uff0c\u9519\u8bef\u7684\u5b9e\u4f53\u5411\u5bfc[%3$s]", (Object)iPSDEWizard.getName(), (Object)psDEWizardStep.getPSDEWIZARDSTEPNAME(), (Object)psDEWizardStep.getPSDEWIZARDNAME()));
                    }
                    return new PSDEWizardException(iPSDEWizard, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53\u5411\u5bfc[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u6b65\u9aa4[%2$s]", (Object)iPSDEWizard.getName(), (Object)psDEWizardStep.getPSDEWIZARDSTEPNAME()));
                }
                return new PSDEWizardException(iPSDEWizard, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53\u5411\u5bfc[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u6b65\u9aa4[%2$s]", (Object)iPSDEWizard.getName(), (Object)objArg));
            }
        }
        if (objArg != null && objArg instanceof String) {
            return new PSDEWizardException(iPSDEWizard, nErrorCode, (String)objArg);
        }
        return new PSDEWizardException(iPSDEWizard, nErrorCode, null);
    }
}

