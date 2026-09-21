/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.PF.IPSPFPkgVer;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSAppPkg;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5e94\u7528\u9644\u52a0\u7ec4\u4ef6\u5305\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSAppPkg")
public interface IPSAppPkg
extends IPSApplicationObject,
IPSPFPkgVer {
    public void init(ISRFDAGlobalHelper var1, IPSApplication var2, PSAppPkg var3) throws Exception;

    @Override
    public String getVerTag();

    @Override
    public String getVerTag2();

    @Override
    public String getVerParam();

    @Override
    public String getVerParam2();

    @Override
    public String getVerParam3();

    @Override
    public String getVerParam4();

    @Override
    public int getOrderValue();
}

