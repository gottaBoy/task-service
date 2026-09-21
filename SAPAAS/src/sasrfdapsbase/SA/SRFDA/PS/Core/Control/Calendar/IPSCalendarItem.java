/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.ctrlmodel.ICalendarItemModel
 */
package SA.SRFDA.PS.Core.Control.Calendar;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Calendar.IPSCalendarItemDataItem;
import SA.SRFDA.PS.Core.Control.IPSControlItem;
import SA.SRFDA.PS.Core.Control.IPSControlMDataContainer;
import SA.SRFDA.PS.Core.Control.IPSControlObjectNavigatable;
import SA.SRFDA.PS.Core.Control.IPSControlXDataContainer;
import SA.SRFDA.PS.Core.Control.Panel.IPSLayoutPanel;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEContextMenu;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.ctrlmodel.ICalendarItemModel;

@PSModelInterfaceMeta(title="\u65e5\u5386\u90e8\u4ef6\u9879\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3")
public interface IPSCalendarItem
extends IPSModelObject,
IPSControlItem,
ICalendarItemModel,
IPSControlXDataContainer,
IPSControlMDataContainer,
IPSControlObjectNavigatable,
IPSModelSortable {
    public static final String ITEMSTYLE_DEFAULT = "DEFAULT";
    public static final String ITEMSTYLE_STYLE2 = "STYLE2";
    public static final String ITEMSTYLE_STYLE3 = "STYLE3";
    public static final String ITEMSTYLE_STYLE4 = "STYLE4";

    public IPSDataEntity getPSDataEntity();

    public IPSSysImage getPSSysImage();

    public IPSSysCss getPSSysCss();

    public IPSDEContextMenu getPSDEContextMenu();

    public void fillRelatedPSAppViews(ArrayList<IPSAppView> var1) throws Exception;

    public String getCreatePSDEActionName();

    public String getCreatePSDEOPPrivName();

    public String getUpdatePSDEActionName();

    public String getUpdatePSDEOPPrivName();

    public String getRemovePSDEActionName();

    public String getRemovePSDEOPPrivName();

    public IPSLanguageRes getNamePSLanguageRes();

    public Iterator<IPSCalendarItemDataItem> getPSCalendarItemDataItems();

    public String getModelObj();

    @Override
    public IPSAppDataEntity getPSAppDataEntity();

    public IPSLayoutPanel getPSLayoutPanel();

    public String getItemStyle();

    public String getIconCls();

    public String getIconPath();

    public String getItemType();

    public String getIdField();

    public String getTextField();

    public String getIconField();

    public String getCreateDataAccessAction();

    public String getUpdateDataAccessAction();

    public String getRemoveDataAccessAction();

    public String getTipsField();

    public String getContentField();

    public String getBeginTimeField();

    public String getEndTimeField();

    public String getColorField();

    public String getBKColorField();

    public int getMaxSize();

    public String getColor();

    public String getBKColor();

    public String getLevelField();

    public boolean isEnableEdit();

    public String getDynaClass();
}

