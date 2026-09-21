/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIAction;
import SA.SRFDA.PS.Core.App.Func.IPSAppFunc;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSAppFunc;
import SA.SRFDA.PS.Data.PSDEUIAction;

@PSModelIgnoreMeta
public interface IPSApplicationRuntime {
    public void calcPSAppViewSysRefFlag() throws Exception;

    public void log(int var1, IPSModelObject var2, String var3);

    public void log(int var1, IPSModelObject var2, String var3, String var4);

    public void log(int var1, IPSModelObject var2, String var3, String var4, String var5);

    public IPSAppDEUIAction registerPSAppDEUIAction(PSDEUIAction var1) throws Exception;

    public IPSAppFunc registerPSAppFunc(PSAppFunc var1) throws Exception;
}

