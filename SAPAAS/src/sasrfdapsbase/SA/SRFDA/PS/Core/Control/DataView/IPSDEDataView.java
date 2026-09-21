/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.dataview.IDataView
 */
package SA.SRFDA.PS.Core.Control.DataView;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.DataView.IPSDEDataViewDataItem;
import SA.SRFDA.PS.Core.Control.DataView.IPSDEDataViewItem;
import SA.SRFDA.PS.Core.Control.DataView.IPSDEDataViewLogic;
import SA.SRFDA.PS.Core.Control.IPSControlAction;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlNavigatable;
import SA.SRFDA.PS.Core.Control.IPSMDAjaxControl;
import SA.SRFDA.PS.Core.Control.IPSMDControl2;
import SA.SRFDA.PS.Core.Control.Panel.IPSLayoutPanel;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysLayoutPanel;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbar;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import java.util.Iterator;
import net.ibizsys.paas.control.dataview.IDataView;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5361\u7247\u89c6\u56fe\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEDataView")
public interface IPSDEDataView
extends IPSMDAjaxControl,
IDataView,
IPSControlContainer,
IPSControlNavigatable,
IPSMDControl2 {
    public static final int EDITMODE_ORDERVALUE = 256;
    public static final int EDITMODE_GROUP = 512;
    public static final String GROUPMODE_NONE = "NONE";
    public static final String GROUPMODE_AUTO = "AUTO";
    public static final String GROUPMODE_CODELIST = "CODELIST";
    public static final String GROUPLAYOUT_ROW = "ROW";
    public static final String GROUPLAYOUT_COLUMN = "COLUMN";

    public Iterator<IPSDEDataViewItem> getPSDEDataViewItems();

    public Iterator<IPSDEDataViewDataItem> getPSDEDataViewDataItems();

    public boolean isEnablePagingBar();

    public int getPagingMode();

    public int getPagingSize();

    public boolean isSingleSelect();

    @Override
    public IPSSysPFPlugin getPSSysPFPlugin();

    public IPSSysPFPlugin getItemPSSysPFPlugin();

    public IPSDEField getMinorSortPSDEF();

    public String getMinorSortDir();

    public boolean isNoSort();

    public boolean isAppendDEItems();

    public IPSDEDataSet getPSDEDataSet();

    public IPSLanguageRes getEmptyTextPSLanguageRes();

    public String getEmptyText();

    public IPSSysLayoutPanel getItemPSSysLayoutPanel();

    public IPSLayoutPanel getItemPSLayoutPanel();

    public int getCardWidth();

    public int getCardHeight();

    public IPSPFXCodeObject getItemRender();

    public int getCardColXS();

    public int getCardColSM();

    public int getCardColMD();

    public int getCardColLG();

    public boolean isEnableGroup();

    public String getGroupMode();

    public String getGroupLayout();

    public IPSDEField getGroupPSDEField();

    public IPSCodeList getGroupPSCodeList();

    public IPSDEField getGroupTextPSDEField();

    public IPSAppDEField getGroupTextPSAppDEField();

    public boolean isEnableCardEdit();

    public boolean isEnableCardEditOrder();

    public boolean isEnableCardEditGroup();

    public boolean isEnableCardNew();

    public IPSAppDEField getGroupPSAppDEField();

    public IPSSysCss getItemPSSysCss();

    public int getGroupColXS();

    public int getGroupColSM();

    public int getGroupColMD();

    public int getGroupColLG();

    public int getGroupWidth();

    public int getGroupHeight();

    public IPSSysCss getGroupPSSysCss();

    public IPSSysPFPlugin getGroupPSSysPFPlugin();

    public IPSUIActionGroup getGroupPSUIActionGroup();

    public IPSDEToolbar getGroupQuickPSDEToolbar();

    public IPSPFXCodeObject getGroupRender();

    public IPSDEField getOrderValuePSDEField();

    public IPSAppDEField getOrderValuePSAppDEField();

    public IPSDEField getMinorSortPSDEField();

    public IPSAppDEField getMinorSortPSAppDEField();

    public Iterator<? extends IPSDEDataViewLogic> getPSDEDataViewLogics();

    public IPSControlAction getGroupMovePSControlAction();

    public IPSDataEntity getGroupPSDataEntity();

    public IPSAppDataEntity getGroupPSAppDataEntity();

    public String getGroupStyle();

    public IPSDEField getSwimlanePSDEField();

    public IPSAppDEField getSwimlanePSAppDEField();

    public IPSCodeList getSwimlanePSCodeList();
}

