/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.List;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.IPSMDControl2;
import SA.SRFDA.PS.Core.Control.List.IPSDEListDataItem;
import SA.SRFDA.PS.Core.Control.List.IPSDEListItem;
import SA.SRFDA.PS.Core.Control.List.IPSDEListLogic;
import SA.SRFDA.PS.Core.Control.List.IPSList;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysLayoutPanel;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbar;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5217\u8868\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEList")
public interface IPSDEList
extends IPSList,
IPSMDControl2 {
    public static final String MOBLISTSTYLE_ICONVIEW = "ICONVIEW";
    public static final String MOBLISTSTYLE_LISTVIEW = "LISTVIEW";
    public static final String MOBLISTSTYLE_SWIPERVIEW = "SWIPERVIEW";
    public static final int EDITMODE_ORDERVALUE = 256;
    public static final int EDITMODE_GROUP = 512;
    public static final String GROUPMODE_NONE = "NONE";
    public static final String GROUPMODE_AUTO = "AUTO";
    public static final String GROUPMODE_CODELIST = "CODELIST";

    public IPSDEDataSet getPSDEDataSet();

    public IPSDELogic getActiveDataPSDELogic();

    public Iterator<IPSDEListItem> getPSDEListItems();

    public boolean isShowHeader();

    public boolean isForceFit();

    @Override
    public IPSSysPFPlugin getPSSysPFPlugin();

    public int getPagingSize();

    public boolean isEnablePagingBar();

    public IPSDEField getMinorSortPSDEF();

    public String getMinorSortDir();

    public boolean isNoSort();

    public boolean isAppendDEItems();

    public String getMobListStyle();

    public IPSSysLayoutPanel getItemPSSysLayoutPanel();

    public IPSPFXCodeObject getItemRender();

    public boolean isEnableGroup();

    public String getGroupMode();

    public IPSDEField getGroupPSDEField();

    public IPSCodeList getGroupPSCodeList();

    public IPSDEField getGroupTextPSDEField();

    public IPSAppDEField getGroupTextPSAppDEField();

    public boolean isEnableRowEdit();

    public boolean isEnableRowEditOrder();

    public boolean isEnableRowEditGroup();

    public boolean isEnableRowNew();

    public IPSAppDEField getGroupPSAppDEField();

    public IPSDEField getOrderValuePSDEField();

    public IPSAppDEField getOrderValuePSAppDEField();

    public IPSDEField getMinorSortPSDEField();

    public IPSAppDEField getMinorSortPSAppDEField();

    public Iterator<? extends IPSDEListDataItem> getPSDEListDataItems();

    public Iterator<? extends IPSDEListLogic> getPSDEListLogics();

    public int getPagingMode();

    public boolean isSingleSelect();

    public IPSSysCss getGroupPSSysCss();

    public IPSSysPFPlugin getGroupPSSysPFPlugin();

    public IPSUIActionGroup getGroupPSUIActionGroup();

    public IPSDEToolbar getGroupQuickPSDEToolbar();

    public IPSPFXCodeObject getGroupRender();

    public String getGroupStyle();

    public IPSDEField getSwimlanePSDEField();

    public IPSAppDEField getSwimlanePSAppDEField();

    public IPSCodeList getSwimlanePSCodeList();
}

