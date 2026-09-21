/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.WebEx.DGEx.UI.DGExConfig
 *  SA.SRFramework.WebEx.DP.UI.DPConfig
 *  SA.SRFramework.WebEx.SP.UI.SPExConfig
 *  SRFWF.Client.WFGetIAActionsResult
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.DataGrid;
import SA.SRFDA.Ctrl.Data.DataGridEx;
import SA.SRFDA.Ctrl.Data.Form;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.Data.SearchForm;
import SA.SRFDA.Ctrl.IDAConfigPublishContext;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.ISRFDAPage;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.WebEx.DGEx.UI.DGExConfig;
import SA.SRFramework.WebEx.DP.UI.DPConfig;
import SA.SRFramework.WebEx.SP.UI.SPExConfig;
import SRFWF.Client.WFGetIAActionsResult;
import java.util.TreeMap;

public interface IDAConfigHelper {
    public boolean Init(ISRFDAGlobalHelper var1, String var2, String var3);

    public void setCurPage(ISRFDAPage var1);

    public ISRFDAPage getCurPage();

    public ISRFDAGlobalHelper getGlobalHelper();

    public String getLanguage();

    public String getPageModel();

    public String GetGridViewToolbarConfigId(IDEHelper var1, Page var2, DataGrid var3, boolean var4);

    public String GetGridViewToolbarConfigId(IDEHelper var1, Page var2, DataGrid var3, boolean var4, boolean var5, boolean var6, boolean var7, boolean var8, TreeMap<String, Boolean> var9);

    public String GetRIAGridViewToolbarConfigPath(IDEHelper var1, Page var2, DataGrid var3, boolean var4, boolean var5, boolean var6, boolean var7, TreeMap<String, Boolean> var8);

    public String GetWFGridViewToolbarConfigId(IDEHelper var1, Page var2, DataGrid var3, String var4, boolean var5, String var6, boolean var7, boolean var8, boolean var9, WFGetIAActionsResult var10);

    public String GetWFMgrGridViewToolbarConfigId(IDEHelper var1, Page var2, DataGrid var3);

    public String GetWFInfoViewToolbarConfigId(IDEHelper var1, Page var2, String var3, String var4, boolean var5, WFGetIAActionsResult var6);

    public String GetRIAMainMenuExConfigPath(SRFDAWebContext var1, String var2);

    public String GetMainMenuExConfigId(SRFDAWebContext var1);

    public String GetMainMenuExConfigId(SRFDAWebContext var1, String var2);

    public String GetEditViewToolbarConfigId(IDEHelper var1, Page var2, Form var3, boolean var4, boolean var5);

    public String GetWFEditViewToolbarConfigId(IDEHelper var1, Page var2, Form var3, boolean var4, String var5);

    public String GetEditViewTabViewConfigId(IDEHelper var1, Page var2);

    public String GetWFInfoViewTabViewConfigId(IDEHelper var1, Page var2, boolean var3);

    public String GetDPConfigId(IDEHelper var1, Form var2);

    public String GetEditViewDPId(IDEHelper var1, Form var2);

    public DPConfig GetDPConfig(IDEHelper var1, String var2);

    public DGExConfig GetDGExConfig(IDEHelper var1, String var2);

    public String GetSPExId(IDEHelper var1, SearchForm var2);

    public String GetSPExConfigId(IDEHelper var1, SearchForm var2);

    public String GetRIASPExConfigPath(IDEHelper var1, SearchForm var2);

    public SPExConfig GetSPExConfig(IDEHelper var1, String var2);

    public SPExConfig GetDEFGroupSPExConfig(String var1, String var2);

    public String GetGridViewDGConfigId(IDEHelper var1, Page var2, DataGrid var3);

    public String GetGridViewDGConfigId(IDEHelper var1, Page var2, DataGrid var3, String var4);

    public String GetGridViewExDGExId(IDEHelper var1, Page var2, DataGridEx var3);

    public String GetGridViewSPExConfigId(IDEHelper var1, DataGrid var2);

    public String GetGridViewExSPExConfigId(IDEHelper var1, DataGridEx var2);

    public String GetRIAGridViewSPExConfigPath(IDEHelper var1, DataGrid var2);

    public String GetGridViewExToolbarConfigId(IDEHelper var1, Page var2, DataGridEx var3, TreeMap<String, Boolean> var4);

    public String GetSPExConfigId(IDEHelper var1);

    public String GetConfigId(String var1, IDAConfigPublishContext var2) throws Exception;
}

