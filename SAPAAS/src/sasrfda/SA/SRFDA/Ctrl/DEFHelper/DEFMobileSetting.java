/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.DEFHelper;

import SA.SRFDA.Ctrl.DEFHelper.DEFMobileSettingConfig;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFMobileSetting;
import SA.SRFDA.Ctrl.DEFHelper.IInheritDEFHelper;
import SA.SRFDA.Ctrl.Data.DEFMobile;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;

public class DEFMobileSetting
implements IDEFMobileSetting {
    protected IDEFHelper iDEFHelper = null;
    protected DEFMobile defMobile = null;
    protected ISRFDAGlobalHelper globalHelperEx = null;
    protected DEFMobileSettingConfig defMobileSettingConfig = null;

    @Override
    public void Init(IDEFHelper iDEFHelper, DEFMobile defMobile, DEFMobileSettingConfig defMobileSettingConfig, ISRFDAGlobalHelper globalHelperEx) throws Exception {
        this.iDEFHelper = iDEFHelper;
        this.defMobile = defMobile;
        this.globalHelperEx = globalHelperEx;
        this.defMobileSettingConfig = defMobileSettingConfig;
    }

    @Override
    public String getItemFormat() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.iDEFHelper.getDEField().getDSITEMFORMAT())) {
            return this.iDEFHelper.getDEField().getDSITEMFORMAT();
        }
        if (this.iDEFHelper.IsInheritDEField()) {
            IInheritDEFHelper inheritDEFHelper = (IInheritDEFHelper)this.iDEFHelper;
            return inheritDEFHelper.GetRelatedDEFHelper().getMobileSetting().getItemFormat();
        }
        if (this.defMobileSettingConfig.getDefaultItemFormat() && this.iDEFHelper.getDEField().getPRECISION2() >= 0) {
            return StringHelper.Format((String)"%%1$.%1$sf", (Object)this.iDEFHelper.getDEField().getPRECISION2());
        }
        return this.defMobileSettingConfig.getItemFormat();
    }
}

