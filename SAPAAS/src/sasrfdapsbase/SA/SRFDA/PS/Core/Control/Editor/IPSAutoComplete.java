/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEACMode;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.Control.IPSAjaxEditor;
import SA.SRFDA.PS.Core.Control.IPSNavigateParamContainer;
import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACMode;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import net.sf.json.JSONObject;

@PSModelExtendMeta(title="\u81ea\u52a8\u586b\u5145\u7f16\u8f91\u5668\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"AC", "AC_FS", "AC_NOBUTTON", "AC_FS_NOBUTTON"})
public interface IPSAutoComplete
extends IPSAjaxEditor,
IPSNavigateParamContainer {
    public static final String PARAM_FORCESELECTION = "FORCESELECTION";
    public static final String PARAM_TRIGGER = "TRIGGER";
    public static final String PARAM_ACMINCHARS = "ACMINCHARS";

    public boolean isEnableAC();

    public IPSDataEntity getPSDataEntity() throws Exception;

    public IPSDEDataSet getPSDEDataSet() throws Exception;

    public IPSDEACMode getPSDEACMode() throws Exception;

    public JSONObject getItemParamJO() throws Exception;

    public boolean isForceSelection();

    public boolean isShowTrigger();

    public IPSAppDataEntity getPSAppDataEntity() throws Exception;

    public IPSAppDEDataSet getPSAppDEDataSet() throws Exception;

    public IPSAppDEACMode getPSAppDEACMode() throws Exception;

    public String getParamJOString();

    public String getContextJOString();

    public IPSUIActionGroup getPSUIActionGroup() throws Exception;

    public int getACMinChars();
}

