/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.ctrlmodel.ITreeDEDataSetNodeModel
 */
package SA.SRFDA.PS.Core.Control.Tree;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogic;
import SA.SRFDA.PS.Core.Control.IPSControlMDObject;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNode;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import net.ibizsys.paas.ctrlmodel.ITreeDEDataSetNodeModel;

@PSModelExtendMeta(title="\u5b9e\u4f53\u6811\u89c6\u56fe\u5b9e\u4f53\u6570\u636e\u96c6\u8282\u70b9\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"DE"})
public interface IPSDETreeDataSetNode
extends IPSDETreeNode,
ITreeDEDataSetNodeModel,
IPSControlMDObject {
    public static final String DATASOURCETYPE_DEACTION = "DEACTION";
    public static final String DATASOURCETYPE_DEDATASET = "DEDATASET";
    public static final String DATASOURCETYPE_DELOGIC = "DELOGIC";
    public static final String DATASOURCETYPE_PARENTDATAPARAM = "PARENTDATAPARAM";
    public static final String DATASOURCETYPE_APPGLOBALPARAM = "APPGLOBALPARAM";
    public static final String DATASOURCETYPE_TOPVIEWSESSIONPARAM = "TOPVIEWSESSIONPARAM";
    public static final String DATASOURCETYPE_VIEWSESSIONPARAM = "VIEWSESSIONPARAM";
    public static final String DATASOURCETYPE_CUSTOM = "CUSTOM";

    public IPSDEDataSet getPSDEDataSet();

    public IPSDEDataSet getFilterPSDEDataSet();

    public IPSDEAction getRemovePSDEAction();

    public IPSDEOPPriv getRemovePSDEOPPriv();

    public IPSDEAction getUpdatePSDEAction();

    public IPSDEOPPriv getUpdatePSDEOPPriv();

    public IPSDELogic getActiveDataPSDELogic();

    public IPSDEField getIdPSDEField();

    public IPSDEField getTextPSDEField();

    public IPSDEField getIconPSDEField();

    public IPSDEField getSortPSDEField();

    public IPSDEField getChildCntPSDEField();

    public IPSDEField getLeafFlagPSDEField();

    public String getTextFormat();

    public IPSAppDEField getIdPSAppDEField();

    public IPSAppDEField getTextPSAppDEField();

    public IPSAppDEField getIconPSAppDEField();

    public IPSAppDEField getSortPSAppDEField();

    public IPSAppDEField getChildCntPSAppDEField();

    public IPSAppDEField getLeafFlagPSAppDEField();

    public IPSAppDEDataSet getPSAppDEDataSet();

    public IPSAppDEDataSet getFilterPSAppDEDataSet();

    public IPSAppDEAction getRemovePSAppDEAction();

    public boolean isAppendCaption();

    public String getIdField();

    public String getTextField();

    public String getIconField();

    public String getSortField();

    public String getSortDir();

    public boolean isDistinctMode();

    public String getChildCntField();

    public String getRemoveDataAccessAction();

    public String getDataTypeField();

    public String getLeafFlagField();

    public int getMaxSize();

    public String getCustomCond();

    public IPSDEField getTipsPSDEField();

    public IPSAppDEField getTipsPSAppDEField();

    public IPSDEField getClsPSDEField();

    public IPSAppDEField getClsPSAppDEField();

    public String getUpdateDataAccessAction();

    public IPSAppDEAction getUpdatePSAppDEAction();

    public IPSDEField getLinkPSDEField();

    public IPSAppDEField getLinkPSAppDEField();

    public IPSDEField getDataPSDEField();

    public IPSDEField getData2PSDEField();

    public IPSAppDEField getDataPSAppDEField();

    public IPSAppDEField getData2PSAppDEField();

    public IPSDEField getShapeClsPSDEField();

    public IPSAppDEField getShapeClsPSAppDEField();

    public int getPagingSize();

    public boolean isEnablePaging();

    public IPSDEAction getMovePSDEAction();

    public IPSDEOPPriv getMovePSDEOPPriv();

    public String getMoveDataAccessAction();

    public IPSAppDEAction getMovePSAppDEAction();

    public String getDataSourceType();

    public String getDataName();

    public String getScriptCode();

    public IPSDEAction getPSDEAction();

    public IPSDELogic getPSDELogic();

    public IPSAppDEAction getPSAppDEAction();

    public IPSAppDELogic getPSAppDELogic();
}

