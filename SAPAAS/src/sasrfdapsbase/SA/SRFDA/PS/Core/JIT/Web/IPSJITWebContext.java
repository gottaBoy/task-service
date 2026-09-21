/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.web.IWebContext
 */
package SA.SRFDA.PS.Core.JIT.Web;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.JIT.App.IPSJITAppModel;
import SA.SRFDA.PS.Core.JIT.SysModel.IPSJITSystemModel;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.web.IWebContext;

public interface IPSJITWebContext
extends IWebContext {
    public String getPSAppViewId();

    public String getPSAppName();

    public IPSSystem getPSSystem() throws Exception;

    public IPSApplication getPSApplication() throws Exception;

    public String getCode();

    public void resetCode();

    public void writeFile(String var1, String var2, Object var3) throws Exception;

    public ISRFDAGlobalHelper getDAGlobalHelper();

    public IPSJITAppModel getAppModel();

    public IPSJITSystemModel getSystemModel();

    public String getContextPath();

    public boolean isRealWriteFile();

    public void setRealWriteFile(boolean var1);

    public boolean isPreviewMode();
}

