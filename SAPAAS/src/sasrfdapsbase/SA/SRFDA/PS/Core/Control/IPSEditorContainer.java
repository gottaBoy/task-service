/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxHandler;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSEditor;
import SA.SRFDA.PS.Core.Control.IPSEditorType;
import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACMode;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysEditorStyle;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;
import java.util.Properties;
import net.sf.json.JSONObject;

@PSModelInterfaceMeta(title="\u7f16\u8f91\u5668\u5bb9\u5668\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", util=true)
public interface IPSEditorContainer
extends IPSModelObject {
    public static final String CONTAINERTYPE_FORMITEM = "FORMITEM";
    public static final String CONTAINERTYPE_GRIDCOLUMN = "GRIDCOLUMN";
    public static final String CONTAINERTYPE_PANELFIELD = "PANELFIELD";
    public static final String CONTAINERTYPE_SEARCHBARFILTER = "SEARCHBARFILTER";

    public String getEditorType();

    public String getEditorStyle();

    public double getEditorWidth();

    public double getEditorHeight();

    public String getEditorDynaClass();

    public Properties getEditorParams();

    public int getEditorParam(String var1, int var2);

    public String getEditorParam(String var1, String var2);

    public double getEditorParam(String var1, double var2);

    public boolean getEditorParam(String var1, boolean var2);

    public IPSDataEntity getRefPSDataEntity() throws Exception;

    public IPSAppView getRefLinkPSAppView() throws Exception;

    public IPSAppView getRefPickupPSAppView() throws Exception;

    public IPSDEDataSet getRefPSDEDataSet() throws Exception;

    public IPSDEACMode getRefPSDEACMode() throws Exception;

    public String getItemHandlerType();

    public IPSCodeList getPSCodeList();

    public JSONObject getItemParam() throws Exception;

    public String getEditorContainer();

    public IPSEditorType getPSEditorType();

    public IPSAjaxHandler getItemPSAjaxHandler();

    public String getValueItemName();

    public String[] getValueItemNames();

    public IPSSysEditorStyle getPSSysEditorStyle();

    public IPSEditor getPSEditor() throws Exception;

    public String getEditorName();

    public IPSControlContainer getPSControlContainer();

    public String getPlaceHolder();

    public String getPSSysDictCatId();

    public IPSSysValueRule getPSSysValueRule() throws Exception;

    public String getPredefinedType();

    public String getRenderMode();

    public String getEditorCssStyle();

    public String getEditorCssStyle2();

    public IPSSysCss getEditorPSSysCss();
}

