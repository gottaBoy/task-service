/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.Control.DRCtrl;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogic;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRCtrl;
import SA.SRFDA.PS.Core.Control.IPSControlItem;
import SA.SRFDA.PS.Core.Control.IPSNavigateParamContainer;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRDetail;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRItem;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.sf.json.JSONObject;

@PSModelInterfaceMeta(title="\u6570\u636e\u5173\u7cfb\u8fb9\u680f\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSDEDRBarItemImpl", model="PSDEDRDetail")
public interface IPSDEDRCtrlItem
extends IPSModelObject,
IPSControlItem,
IPSNavigateParamContainer {
    public void init(ISRFDAGlobalHelper var1, IPSDEDRCtrl var2, IPSDEDRDetail var3) throws Exception;

    public String getCaption();

    public IPSDEDRDetail getPSDEDRDetail();

    public IPSAppView getPSAppView();

    public String getEmbedViewId();

    public IPSDEDRItem getPSDEDRItem();

    public JSONObject getViewParamJO();

    public IPSLanguageRes getCapPSLanguageRes();

    public String getCounterId();

    public int getCounterMode();

    public IPSSysImage getPSSysImage();

    public String getEnableMode();

    public String getDataAccessAction();

    public int getOrderValue();

    public IPSAppDELogic getTestPSAppDELogic();

    public String getTestScriptCode();

    public String getItemTag();

    public String getItemTag2();

    public IPSSysPFPlugin getHeaderPSSysPFPlugin();
}

