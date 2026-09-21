/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.IPSNavigateParamContainer;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Data.PSAppViewRef;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.sf.json.JSONObject;

@PSModelInterfaceMeta(title="\u5e94\u7528\u89c6\u56fe\u5f15\u7528\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAppViewRef
extends IPSModelObject,
IPSNavigateParamContainer {
    public void init(ISRFDAGlobalHelper var1, Object var2, PSAppViewRef var3) throws Exception;

    public IPSAppView getPSAppView();

    public Object getOwner();

    public String getRefPSAppViewId();

    public IPSAppView getRefPSAppView() throws Exception;

    public String getOpenMode();

    public String getEmbedId();

    public int getHeight();

    public int getWidth();

    public JSONObject getViewParam(boolean var1);

    public JSONObject getViewParam();

    public JSONObject getViewParamJO(boolean var1);

    public JSONObject getViewParamJO();

    public JSONObject getParentModeJO(boolean var1);

    public JSONObject getParentModeJO();

    public JSONObject getParentDataJO(boolean var1);

    public JSONObject getParentDataJO();

    public String getRealTitle() throws Exception;

    public int getRealWidth(int var1) throws Exception;

    public int getRealHeight(int var1) throws Exception;

    public String getRealOpenMode() throws Exception;

    public IPSLanguageRes getTitlePSLanguageRes();

    public IPSLanguageRes getRealTitlePSLanguageRes() throws Exception;

    public String getRealTitleLanResTag() throws Exception;

    public String getRefModeDesc();

    public String getParamJOString();

    public String getContextJOString();
}

