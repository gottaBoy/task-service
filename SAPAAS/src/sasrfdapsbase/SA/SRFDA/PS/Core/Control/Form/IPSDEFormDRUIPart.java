/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItemUpdate;
import SA.SRFDA.PS.Core.Control.IPSNavigateParamContainer;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRItem;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import net.sf.json.JSONObject;

@PSModelExtendMeta(title="\u5b9e\u4f53\u8868\u5355\u5173\u7cfb\u754c\u9762\u90e8\u4ef6\u6210\u5458\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"DRUIPART"})
public interface IPSDEFormDRUIPart
extends IPSDEFormDetail,
IPSNavigateParamContainer {
    public static final int REFRESHACTION_LOAD = 1;
    public static final int REFRESHACTION_SAVE = 2;
    public static final int REFRESHACTION_REFRESHITEMSSETPARAMONLY = 4;
    public static final int MASKMODE_AUTO = -1;
    public static final int MASKMODE_INVISIBLE = 0;
    public static final int MASKMODE_NEWDATA = 1;

    public IPSDEDRItem getPSDEDRItem();

    public IPSAppView getPSAppView();

    public String getEmbedViewId();

    public String getRefreshItems();

    public String getPSDEFIUpdateId();

    public IPSDEFormItemUpdate getPSDEFormItemUpdate() throws Exception;

    public int getRefreshActions();

    public boolean isEnableRefreshAction(int var1);

    public String getParamItem();

    public boolean isNeedSave();

    public boolean isRefreshItemsSetParamOnly();

    public JSONObject getParentDataJO();

    public String getParamJOString();

    public String getContextJOString();

    public int getMaskMode();

    public String getMaskInfo();

    public IPSLanguageRes getMaskPSLanguageRes();

    public String getDRItemTag();
}

