/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl.DEFHelper;

import SA.SRFDA.Ctrl.DEFHelper.DEFMobileSettingConfig;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DEFMobile;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IDEFMobileSetting {
    public void Init(IDEFHelper var1, DEFMobile var2, DEFMobileSettingConfig var3, ISRFDAGlobalHelper var4) throws Exception;

    public String getItemFormat() throws Exception;
}

