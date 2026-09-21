/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSAppModule;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSAppViewPreview {
    public static final int VERSION_DEFAULT = 1;
    public static final int VERSION_V2 = 2;

    public void initPreview(ISRFDAGlobalHelper var1, IPSApplication var2, PSAppView var3, PSAppModule var4, int var5) throws Exception;

    public void setPSPFStyle(IPSPFStyle var1);

    public boolean isDesignMode();
}

