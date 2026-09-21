/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Tree;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.IPSControlItem;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeColumn;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNode;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeDataItem;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeEditItem;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Data.PSDETreeNodeColumn;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6811\u8282\u70b9\u8868\u683c\u5217\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", typefield="columnType", implement="PSDETreeNodeFieldColumnImpl", model="PSDETreeNodeCol")
public interface IPSDETreeNodeColumn
extends IPSModelObject,
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
    public static final int EDITMODE_ENABLE = 1;
    public static final int EDITMODE_CHANGEDONLY = 2048;

    public void init(ISRFDAGlobalHelper var1, IPSDETreeNode var2, PSDETreeNodeColumn var3) throws Exception;

    public IPSDETreeNode getPSDETreeNode();

    public IPSDETreeColumn getPSDETreeColumn();

    @Override
    public String getCodeName();

    public Iterator<IPSDETreeNodeDataItem> getPSDETreeNodeDataItems();

    public String getColumnType();

    public IPSSysPFPlugin getRenderPSSysPFPlugin();

    public boolean isHiddenDataItem();

    public void fillRelatedPSAppViews(ArrayList<IPSAppView> var1) throws Exception;

    public boolean isEnableRowEdit();

    public IPSDETreeNodeEditItem getPSDETreeNodeEditItem();

    public String getColumnStyle();

    public IPSSysCss getCellPSSysCss();

    public int getNoPrivDisplayMode();

    public IPSPFXCodeObject getRender();

    public String getDataItemName();

    public boolean isCustomCode();

    public String getScriptCode();
}

