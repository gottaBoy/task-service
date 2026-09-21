/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5e94\u7528\u754c\u9762\u8bbe\u7f6e\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSApplicationUI
extends IPSModelObject {
    public static final int GRIDROWACTIVEMODE_NONE = 0;
    public static final int GRIDROWACTIVEMODE_CLCIK = 1;
    public static final int GRIDROWACTIVEMODE_DBCLICK = 2;

    public String getPFType();

    public String getPFStyle();

    public IPSPF getPSPF();

    public IPSPFStyle getPSPFStyle();

    public Object getPFStyleParam(String var1) throws Exception;

    public boolean getPFStyleParam(String var1, boolean var2) throws Exception;

    public String getPFStyleParam(String var1, String var2) throws Exception;

    public int getPFStyleParam(String var1, int var2) throws Exception;

    public double getPFStyleParam(String var1, double var2) throws Exception;

    public String getMainMenuAlign();

    public int getButtonNoPrivDisplayMode();

    public boolean isEnableCol12ToCol24();

    public boolean isGridForceFit();

    public int getGridRowActiveMode();

    public int getFormItemNoPrivDisplayMode();

    public int getGridColumnNoPrivDisplayMode();

    public boolean isOutputFormItemUpdatePrivTag();

    public String getUIStyle();

    public String getDefaultControlStyle();

    public IPSSysCss getDefaultAppViewPSSysCss();

    public boolean isEnableFilterStorage();

    public boolean isEnableDynaDashboard();

    public int getGridColumnEnableLink();

    public IPSLanguageRes getMDCtrlEmptyTextPSLanguageRes();

    public String getMDCtrlEmptyText();

    public boolean isGridEnableCustomized();

    public String getFormItemEmptyText();

    public int getACMinChars();

    public int getGridColumnEnableFilter();

    public boolean isEnableUIModelEx();

    public Integer getDefaultAppViewPriority();
}

