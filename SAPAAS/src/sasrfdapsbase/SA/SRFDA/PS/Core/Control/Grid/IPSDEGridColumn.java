/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.control.grid.IGridColumn
 */
package SA.SRFDA.PS.Core.Control.Grid;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGrid;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridDataItem;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItem;
import SA.SRFDA.PS.Core.Control.IPSControlItem;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Data.PSDEGridColumn;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.control.grid.IGridColumn;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u8868\u683c\u5217\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", typefield="columnType", implement="PSDEGridFieldColumnImpl", model="PSDEGridCol")
public interface IPSDEGridColumn
extends IPSModelObject,
IGridColumn,
IPSControlItem {
    public static final String GRIDCOLTYPE_DEFGRIDCOLUMN = "DEFGRIDCOLUMN";
    public static final String GRIDCOLTYPE_DEFTREEGRIDCOLUMN = "DEFTREEGRIDCOLUMN";
    public static final String GRIDCOLTYPE_GROUPGRIDCOLUMN = "GROUPGRIDCOLUMN";
    public static final String GRIDCOLTYPE_UAGRIDCOLUMN = "UAGRIDCOLUMN";
    public static final String ALIGN_LEFT = "LEFT";
    public static final String ALIGN_CENTER = "CENTER";
    public static final String ALIGN_RIGHT = "RIGHT";
    public static final int NOPRIVDISPLAYMODE_EMPTY = 1;
    public static final int NOPRIVDISPLAYMODE_HIDE = 2;
    public static final String AGGMODE_NONE = "NONE";
    public static final String AGGMODE_SUM = "SUM";
    public static final String AGGMODE_AVG = "AVG";
    public static final String AGGMODE_MAX = "MAX";
    public static final String AGGMODE_MIN = "MIN";
    public static final String AGGMODE_COUNT = "COUNT";
    public static final String AGGMODE_USER = "USER";
    public static final String AGGMODE_USER2 = "USER2";
    public static final String AGGMODE_USER3 = "USER3";
    public static final String AGGMODE_USER4 = "USER4";
    public static final int HIDEMODE_NOTHIDE = 0;
    public static final int HIDEMODE_HIDE = 1;
    public static final int HIDEMODE_ALWAYSHIDE = 2;
    public static final int HIDEMODE_NEVERHIDE = 3;

    public void init(ISRFDAGlobalHelper var1, IPSDEGrid var2, IPSDEGridColumn var3, PSDEGridColumn var4) throws Exception;

    public IPSDEGrid getPSDEGrid();

    @Override
    public String getCodeName();

    public Iterator<IPSDEGridDataItem> getPSDEGridDataItems();

    public String getWidthUnit();

    public int getWidth();

    public String getColumnType();

    public boolean isEnableSort();

    public IPSSysPFPlugin getRenderPSSysPFPlugin();

    public String getWidthString();

    public boolean isHiddenDataItem();

    public String getAlign();

    public boolean isHideDefault();

    public int getHideMode();

    public void fillRelatedPSAppViews(ArrayList<IPSAppView> var1) throws Exception;

    public boolean isEnableRowEdit();

    public IPSDEGridEditItem getPSDEGridEditItem();

    public IPSDEGridColumn getParentPSGridColumn();

    public IPSLanguageRes getCapPSLanguageRes();

    public String getCapLanResTag();

    public IPSLanguageRes getExcelCapPSLanguageRes();

    public String getColumnStyle();

    public IPSSysCss getHeaderPSSysCss();

    public IPSSysCss getCellPSSysCss();

    public int getNoPrivDisplayMode();

    public IPSPFXCodeObject getRender();

    public String getAggMode();

    public String getAggField();

    public IPSSysImage getPSSysImage();

    public String getCaption();

    public String getDataItemName();

    public String getExcelCaption();

    public String getExcelCapLanResTag();

    public String getAggValueFormat();

    public boolean isCustomCode();

    public String getScriptCode();
}

