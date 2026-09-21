/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysCss;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u7cfb\u7edf\u754c\u9762\u6837\u5f0f\u8868\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysCss")
public interface IPSSysCss
extends IPSSystemObject {
    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysCss var3) throws Exception;

    public String getPSCssTemplId();

    public String getCssName();

    public String getCssStyle();

    public String getRawCssStyle();

    public String getDesignCssStyle();

    @Override
    public String getCodeName();

    public IPSSystemModule getPSSystemModule();
}

