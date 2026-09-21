/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Map;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.Control.IPSControlMDObject;
import SA.SRFDA.PS.Core.Control.Map.IPSMapItem;
import SA.SRFDA.PS.Core.Control.Map.IPSSysMap;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSSysMapItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u7cfb\u7edf\u5730\u56fe\u90e8\u4ef6\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysMapItem")
public interface IPSSysMapItem
extends IPSMapItem,
IPSControlMDObject {
    public void init(ISRFDAGlobalHelper var1, IPSSysMap var2, PSSysMapItem var3) throws Exception;

    public IPSSysMap getPSSysMap();

    public IPSDEDataSet getPSDEDataSet();

    public IPSDEAction getRemovePSDEAction();

    public IPSDEOPPriv getRemovePSDEOPPriv();

    public IPSDELogic getActiveDataPSDELogic();

    public IPSDEField getIdPSDEField();

    public IPSDEField getTextPSDEField();

    public IPSDEField getIconPSDEField();

    public IPSDEField getContentPSDEField();

    public IPSDEField getLongitudePSDEField();

    public IPSDEField getLatitudePSDEField();

    public IPSDEField getAltitudePSDEField();

    public IPSDEField getColorPSDEField();

    public IPSDEField getBKColorPSDEField();

    public IPSDEField getTipsPSDEField();

    public IPSDEField getOrderValuePSDEField();

    public IPSDEField getGroupPSDEField();

    public IPSDEField getTagPSDEField();

    public IPSDEField getTag2PSDEField();

    public IPSDEField getDataPSDEField();

    public IPSDEField getData2PSDEField();

    public IPSDEField getTimePSDEField();

    public IPSDEField getShapeClsPSDEField();

    public IPSAppDEField getIdPSAppDEField();

    public IPSAppDEField getTextPSAppDEField();

    public IPSAppDEField getIconPSAppDEField();

    public IPSAppDEField getContentPSAppDEField();

    public IPSAppDEField getLongitudePSAppDEField();

    public IPSAppDEField getLatitudePSAppDEField();

    public IPSAppDEField getAltitudePSAppDEField();

    public IPSAppDEField getColorPSAppDEField();

    public IPSAppDEField getBKColorPSAppDEField();

    public IPSAppDEField getTipsPSAppDEField();

    public IPSAppDEField getOrderValuePSAppDEField();

    public IPSAppDEField getGroupPSAppDEField();

    public IPSAppDEField getTagPSAppDEField();

    public IPSAppDEField getTag2PSAppDEField();

    public IPSAppDEDataSet getPSAppDEDataSet();

    public String getCustomCond();

    public IPSAppDEAction getRemovePSAppDEAction();

    public IPSDEField getClsPSDEField();

    public IPSAppDEField getClsPSAppDEField();

    public IPSAppDEField getDataPSAppDEField();

    public IPSAppDEField getData2PSAppDEField();

    public IPSAppDEField getTimePSAppDEField();

    public IPSAppDEField getShapeClsPSAppDEField();

    public IPSDEField getLinkPSDEField();

    public IPSAppDEField getLinkPSAppDEField();
}

