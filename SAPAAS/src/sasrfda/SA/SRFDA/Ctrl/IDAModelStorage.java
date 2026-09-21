/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.DEDataCtrl.DataLockDataCtrl;
import SA.SRFDA.Ctrl.Data.DEBHGroup;
import SA.SRFDA.Ctrl.Data.DEBehavior;
import SA.SRFDA.Ctrl.Data.DataGrid;
import SA.SRFDA.Ctrl.Data.DevImage;
import SA.SRFDA.Ctrl.Data.FIUpdate;
import SA.SRFDA.Ctrl.Data.Form;
import SA.SRFDA.Ctrl.Data.GSR2;
import SA.SRFDA.Ctrl.Data.GroupStatisticsRep;
import SA.SRFDA.Ctrl.Data.MBPanel;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.Data.PageParamFolder;
import SA.SRFDA.Ctrl.Data.PageParamType;
import SA.SRFDA.Ctrl.Data.QueryModel;
import SA.SRFDA.Ctrl.Data.TBTempl;
import SA.SRFDA.Ctrl.Data.THGroup;
import SA.SRFDA.Ctrl.Data.Toolbar;
import SA.SRFDA.Ctrl.Data.TreeView;
import SA.SRFDA.Ctrl.Data.ValueRule;
import SA.SRFDA.Ctrl.DataSync.ISyncAgentTypeHelper;
import SA.SRFDA.Ctrl.ICounterHelper;
import SA.SRFDA.Ctrl.ICounterTypeHelper;
import SA.SRFDA.Ctrl.IDAGlobalModel;
import SA.SRFDA.Ctrl.IDASubSystemHelper;
import SA.SRFDA.Ctrl.IDBStorage;
import SA.SRFDA.Ctrl.IDEBehaviorHelper;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IDERGroupFolderHelper;
import SA.SRFDA.Ctrl.IDERModeHelper;
import SA.SRFDA.Ctrl.IDERTypeHelper;
import SA.SRFDA.Ctrl.ILayoutItemHelper;
import SA.SRFDA.Ctrl.IPageHelper;
import SA.SRFDA.Ctrl.ORG.IORGTreeNodeTypeHelper;
import SA.SRFDA.Ctrl.ORG.IORGTreeTypeHelper;
import SA.SRFDA.Ctrl.ORG.IORGUnitTypeHelper;
import SA.SRFDA.Model.DGModelMainQueryConfig;
import SA.SRFDA.Security.IRCAccListHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.UIGear.IUIGear;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.DataEx.CallResult;
import java.util.Iterator;

public interface IDAModelStorage {
    public CallResult Init();

    public BaseDAQueryModelHelper FindDAQueryModelHelper(String var1);

    public BaseDAQueryModelHelper FindDAQueryModelHelperEx(String var1, boolean var2);

    public BaseDAQueryModelHelper FindDAQueryModelHelper(QueryModel var1);

    public BaseDAQueryModelHelper FindDAQueryModelHelperEx(QueryModel var1, boolean var2);

    public BaseDAQueryModelHelper GetDAQueryModelHelper(String var1, DGModelMainQueryConfig var2);

    public BaseDAQueryModelHelper FindDAQueryModelHelper(String var1, DataGrid var2);

    public BaseDAQueryModelHelper FindDAQueryModelHelperEx(String var1, DataGrid var2, boolean var3);

    public BaseDAQueryModelHelper FindDAQueryModelHelper(DataGrid var1);

    public BaseDAQueryModelHelper FindDAQueryModelHelperEx(DataGrid var1, boolean var2);

    public BaseDAQueryModelHelper getDAQueryModelHelper(IDEHelper var1);

    public BaseDAQueryModelHelper FindDAQueryModelHelper(IDEHelper var1);

    public IDEDataCtrl FindDEDataCtrl(String var1, ISRFDAWebContext var2);

    public IDEDataCtrl FindDEDataCtrl2(String var1, ISRFDAWebContext var2) throws Exception;

    public IDEDataCtrl FindDEDataCtrl(String var1, String var2, ISRFDAWebContext var3);

    public IDEDataCtrl FindDEDataCtrl2(String var1, String var2, ISRFDAWebContext var3) throws Exception;

    public IDEDataCtrl FindDEDataCtrlEx(String var1, IDEDataCtrl var2);

    public IDEDataCtrl FindDEDataCtrlEx2(String var1, IDEDataCtrl var2) throws Exception;

    public IDEHelper FindDEHelper(String var1);

    public IDEHelper FindDEHelper(String var1, boolean var2);

    public IDEHelper FindDEHelper2(String var1) throws Exception;

    public IDEHelper FindDEHelper2(String var1, boolean var2) throws Exception;

    public void ResetCodeListConfig(String var1);

    public void ResetAllCodeList();

    public CodeListConfig FindCodeListConfig(String var1);

    public Page FindPage(String var1);

    public IPageHelper FindPage2(String var1) throws Exception;

    public void ResetPage(String var1);

    public DataLockDataCtrl GetDataLockDataCtrl();

    public IDEDataCtrl GetSessionDataDataCtrl();

    public IDBStorage FindDBStorage(String var1);

    public CallResult GetQueryModel(String var1, QueryModel var2, boolean var3);

    public void ResetQueryModel(String var1);

    public CallResult GetDEMainForm(String var1, Form var2, boolean var3);

    public FIUpdate FindFIUpdate(String var1, String var2);

    public void ResetFIUpdate(String var1, String var2);

    public GroupStatisticsRep FindGroupStatisticsRep(String var1);

    public void ResetGroupStatisticsRep(String var1);

    public int GetDAModelVersion(String var1, Object var2);

    public int GetDAModelVersion(String var1, Object var2, boolean var3);

    public THGroup FindTHGroup(String var1);

    public void ResetTHGroup(String var1);

    public TreeView FindTreeView(String var1);

    public void ResetTreeView(String var1);

    public GSR2 FindGSR2(String var1);

    public void ResetGSR2(String var1);

    public ValueRule FindValueRule(String var1);

    public void ResetValueRule(String var1);

    public DevImage FindDevImage(String var1);

    public void ResetDevImage(String var1);

    public TBTempl FindTBTempl(String var1);

    public void ResetTBTempl(String var1);

    public Toolbar FindToolbar(String var1);

    public void ResetToolbar(String var1);

    public DEBehavior FindDEBehavior(String var1);

    public IDEBehaviorHelper FindDEBehavior2(String var1) throws Exception;

    public void ResetDEBehavior(String var1);

    public PageParamType FindPageParamType(String var1);

    public void ResetPageParamType(String var1);

    public PageParamFolder FindPageParamFolder(String var1);

    public void ResetPageParamFolder(String var1);

    public DEBHGroup FindDEBHGroup(String var1);

    public void ResetDEBHGroup(String var1);

    public IUIGear FindUIGear(String var1);

    public void ResetUIGear(String var1);

    public IDAGlobalModel FindGlobalModel(String var1);

    public boolean IsEnableGlobalModel();

    public MBPanel FindMBPanel(String var1);

    public void ResetMBPanel(String var1);

    public IDERModeHelper FindDERMode(String var1) throws Exception;

    public IDERTypeHelper FindDERType(String var1) throws Exception;

    public void ResetDERType(String var1);

    public IDERGroupFolderHelper FindDERGroupFolder(String var1) throws Exception;

    public void ResetDERGroupFolder(String var1);

    public IDEDataCtrl FindGlobalDEDataCtrl(String var1, String var2) throws Exception;

    public ISyncAgentTypeHelper FindSyncAgentType(String var1) throws Exception;

    public void ResetSyncAgentType(String var1);

    public void ReloadDETBBHandlers() throws Exception;

    public String GetDETBBHandler(String var1, String var2);

    public boolean TestProduct(String var1);

    public boolean TestDataEntity(String var1);

    public IORGUnitTypeHelper FindORGUnitType(String var1) throws Exception;

    public IORGTreeTypeHelper FindORGTreeType(String var1) throws Exception;

    public IORGTreeNodeTypeHelper FindORGTreeNodeType(String var1) throws Exception;

    public IRCAccListHelper FindRCAccList(String var1) throws Exception;

    public void ResetRCAccList(String var1);

    public Iterator<IDASubSystemHelper> getSubSystems();

    public ICounterTypeHelper FindCounterType(String var1) throws Exception;

    public ICounterHelper FindCounter(String var1) throws Exception;

    public ILayoutItemHelper FindLayoutItem(String var1) throws Exception;
}

