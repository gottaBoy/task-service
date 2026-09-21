/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.grid.IGrid
 */
package SA.SRFDA.PS.Core.Control.Grid;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridColumn;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridDataItem;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItem;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItemUpdate;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItemVR;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridLogic;
import SA.SRFDA.PS.Core.Control.IPSControlAction;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlNavigatable;
import SA.SRFDA.PS.Core.Control.IPSMDAjaxControl;
import SA.SRFDA.PS.Core.Control.IPSMDControl2;
import SA.SRFDA.PS.Core.Control.Panel.IPSLayoutPanel;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import java.util.Iterator;
import net.ibizsys.paas.control.grid.IGrid;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u8868\u683c\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEGrid")
public interface IPSDEGrid
extends IPSMDAjaxControl,
IGrid,
IPSControlContainer,
IPSControlNavigatable,
IPSMDControl2 {
    public static final int EDITMODE_ORDERVALUE = 256;
    public static final int EDITMODE_CHANGEDONLY = 2048;
    public static final String GRIDSTYLE_TREEGRID = "TREEGRID";
    public static final String GRIDSTYLE_GROUPGRID = "GROUPGRID";
    public static final String GRIDSTYLE_LIST = "LIST";
    public static final String GRIDSTYLE_LIST_SORT = "LIST_SORT";
    public static final String SORTMODE_REMOTE = "REMOTE";
    public static final String SORTMODE_LOCAL = "LOCAL";
    public static final String AGGMODE_NONE = "NONE";
    public static final String AGGMODE_PAGE = "PAGE";
    public static final String AGGMODE_ALL = "ALL";
    public static final int EDITMODE_ROW = 1;
    public static final String GROUPMODE_NONE = "NONE";
    public static final String GROUPMODE_AUTO = "AUTO";
    public static final String GROUPMODE_CODELIST = "CODELIST";

    public Iterator<IPSDEGridColumn> getPSDEGridColumns();

    public Iterator<IPSDEGridColumn> getAllPSDEGridColumns();

    public Iterator<IPSDEGridDataItem> getPSDEGridDataItems();

    public Iterator<IPSDEGridEditItem> getPSDEGridEditItems();

    public IPSDEGridEditItem getPSDEGridEditItem(String var1, boolean var2) throws Exception;

    public boolean isEnablePagingBar();

    public int getPagingMode();

    public boolean isEnableRowEdit();

    public boolean isEnableRowNew();

    public boolean isEnableRowEditOrder();

    public boolean isEnableRowEditChangedOnly();

    public int getPagingSize();

    public boolean isSingleSelect();

    public boolean isForceFit();

    public String getGridStyle();

    public boolean isNoSort();

    public IPSDEField getMinorSortPSDEF();

    public String getMinorSortDir();

    public boolean isHideHeader();

    public boolean isStateful();

    public Iterator<IPSDEGridEditItemUpdate> getPSDEGridEditItemUpdates();

    public IPSDEGridEditItemUpdate getPSDEGridEditItemUpdate(String var1) throws Exception;

    public Iterator<IPSDEGridDataItem> getGroupPSDEGridDataItems();

    public IPSLanguageRes getEmptyTextPSLanguageRes();

    public String getEmptyText();

    public String getSortMode();

    public boolean isEnableColFilter();

    @Override
    public IPSControlAction getCreatePSControlAction();

    @Override
    public IPSControlAction getUpdatePSControlAction();

    @Override
    public IPSControlAction getRemovePSControlAction();

    @Override
    public IPSControlAction getGetPSControlAction();

    @Override
    public IPSControlAction getGetDraftPSControlAction();

    @Override
    public IPSControlAction getGetDraftFromPSControlAction();

    public String getAggMode();

    public IPSDataEntity getAggPSDataEntity();

    public IPSDEAction getAggPSDEAction();

    public IPSDEDataSet getAggPSDEDataSet();

    public IPSAppDataEntity getAggPSAppDataEntity();

    public IPSAppDEAction getAggPSAppDEAction();

    public IPSAppDEDataSet getAggPSAppDEDataSet();

    public IPSLayoutPanel getAggPSLayoutPanel();

    public int getColumnEnableLink();

    public IPSDEGridColumn getPSDEGridColumn(String var1, boolean var2) throws Exception;

    public Iterator<IPSDEGridEditItemVR> getPSDEGridEditItemVRs();

    public IPSDEGridEditItemVR getPSDEGridEditItemVR(String var1) throws Exception;

    public IPSDEField getOrderValuePSDEField();

    public IPSAppDEField getOrderValuePSAppDEField();

    public IPSDEField getMinorSortPSDEField();

    public IPSAppDEField getMinorSortPSAppDEField();

    public boolean isEnableGroup();

    public String getGroupMode();

    public IPSDEField getGroupPSDEField();

    public IPSCodeList getGroupPSCodeList();

    public IPSAppDEField getGroupPSAppDEField();

    public IPSDEField getGroupTextPSDEField();

    public IPSAppDEField getGroupTextPSAppDEField();

    public boolean isEnableCustomized();

    public int getColumnEnableFilter();

    public Iterator<? extends IPSDEGridLogic> getPSDEGridLogics();

    public IPSDEGridDataItem getPSDEGridDataItem(String var1, boolean var2) throws Exception;

    public int getFrozenFirstColumn();

    public int getFrozenLastColumn();

    public String getGroupStyle();
}

