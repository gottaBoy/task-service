/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.ctrlmodel.ITreeNodeModel
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.Control.Tree;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewUIAction;
import SA.SRFDA.PS.Core.Control.IPSControlItem;
import SA.SRFDA.PS.Core.Control.IPSControlMDataContainer;
import SA.SRFDA.PS.Core.Control.IPSControlObjectNavigatable;
import SA.SRFDA.PS.Core.Control.IPSControlXDataContainer;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEContextMenu;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETree;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeColumn;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeDataItem;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeEditItem;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeEditItemUpdate;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeRS;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeRV;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Data.PSDETreeNode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.ctrlmodel.ITreeNodeModel;
import net.sf.json.JSONObject;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6811\u8282\u70b9\u6a21\u578b\u5bf9\u8c61\u57fa\u7840\u63a5\u53e3", typefield="treeNodeType", model="PSDETreeNode")
public interface IPSDETreeNode
extends IPSModelObject,
IPSControlItem,
ITreeNodeModel,
IPSControlXDataContainer,
IPSControlMDataContainer,
IPSControlObjectNavigatable {
    public static final int COUNTERMODE_NONE = 0;
    public static final int COUNTERMODE_HIDEZERO = 1;
    public static final String TREENODETYPE_STATIC = "STATIC";
    public static final String TREENODETYPE_DE = "DE";
    public static final String TREENODETYPE_CODELIST = "CODELIST";
    public static final int EDITMODE_NONE = 0;
    public static final int EDITMODE_TEXT = 1;
    public static final int EDITMODE_DRAG = 2;
    public static final int EDITMODE_DROP = 4;
    public static final int EDITMODE_ORDER = 8;
    public static final int EDITMODE_ROWEDIT = 16;
    public static final int EDITMODE_ROWEDITCHANGEDONLY = 2048;

    public void init(ISRFDAGlobalHelper var1, IPSDETree var2, PSDETreeNode var3) throws Exception;

    public boolean isAppendPNodeId();

    public String getIconCls();

    public String getIconPath();

    public boolean isExpanded();

    public boolean isEnableCheck();

    public String getNodeType();

    public boolean isChecked();

    public boolean isRootNode();

    public boolean hasTreeNodeRSModel();

    public String getNodeDataType();

    @Override
    public boolean isEnableQuickSearch();

    public IPSDETree getPSDETree();

    public IPSDataEntity getPSDataEntity();

    public String getEmbedViewId();

    @Override
    public String getNavPSDEViewId();

    @Override
    public IPSAppView getNavPSAppView();

    public JSONObject getNavViewParam();

    public IPSSysImage getPSSysImage();

    public IPSSysCss getPSSysCss();

    public IPSDEContextMenu getPSDEContextMenu();

    public void fillRelatedPSAppViews(ArrayList<IPSAppView> var1) throws Exception;

    public Iterator<IPSDETreeNodeRV> getPSDETreeNodeRVs();

    public String getRemovePSDEActionName();

    public String getRemovePSDEOPPrivName();

    public IPSLanguageRes getNamePSLanguageRes();

    @Override
    public String getNavPSDERId();

    @Override
    public IPSDERBase getNavPSDER();

    public String getCounterId();

    public int getCounterMode();

    public Iterator<IPSDETreeNodeColumn> getPSDETreeNodeColumns();

    public Iterator<IPSDETreeNodeDataItem> getPSDETreeNodeDataItems();

    public String getModelObj();

    public Iterator<IPSDETreeNodeRS> getPSDETreeNodeRSs();

    public boolean hasPSDETreeNodeRSs();

    public IPSSysPFPlugin getPSSysPFPlugin();

    @Override
    public String getNavFilter();

    public boolean isDisableSelect();

    public IPSAppViewUIAction getDefaultPSUIAction();

    public boolean isSelected();

    public boolean isSelectFirstOnly();

    public boolean isExpandFirstOnly();

    @Override
    public IPSAppDataEntity getPSAppDataEntity();

    public String getTreeNodeType();

    public int getEditMode();

    public boolean isAllowEditText();

    public boolean isAllowDrag();

    public boolean isAllowDrop();

    public boolean isAllowOrder();

    public boolean isDesignMode();

    public boolean isEnableRowEdit();

    public boolean isEnableRowEditChangedOnly();

    public IPSDETreeNodeEditItemUpdate getPSDETreeNodeEditItemUpdate(String var1) throws Exception;

    public IPSDETreeNodeDataItem getPSDETreeNodeDataItem(String var1, boolean var2) throws Exception;

    public IPSDETreeNodeDataItem getPSDETreeNodeDataItem(IPSDEField var1, boolean var2) throws Exception;

    public Iterator<IPSDETreeNodeEditItem> getPSDETreeNodeEditItems();

    public Iterator<IPSDETreeNodeEditItemUpdate> getPSDETreeNodeEditItemUpdates();

    public String getDynaClass();

    public int getAccUserMode();

    public String getAccessKey();

    public String getShapeDynaClass();

    public IPSSysCss getShapePSSysCss();
}

