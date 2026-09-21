/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.grid.IGridEditItem
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.Control.Grid;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxHandler;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEFGridColumn;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGrid;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridColumn;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItemUpdate;
import SA.SRFDA.PS.Core.Control.Grid.IPSGEIDEFValueRule;
import SA.SRFDA.PS.Core.Control.IPSEditorContainer;
import SA.SRFDA.PS.Core.Control.IPSEditorType;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACMode;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysEditorStyle;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.paas.control.grid.IGridEditItem;
import net.sf.json.JSONObject;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u8868\u683c\u7f16\u8f91\u9879\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", implement="HiddenPSDEGridEditItemImpl", model="PSDEGridCol")
public interface IPSDEGridEditItem
extends IGridEditItem,
IPSObject,
IPSModelObject,
IPSEditorContainer {
    public IPSDEGrid getPSDEGrid();

    @Override
    public String getCodeName();

    public IPSDEGridColumn getPSDEGridColumn();

    public IPSDEField getPSDEField();

    @Override
    public String getEditorType();

    @Override
    public IPSEditorType getPSEditorType();

    @Override
    public IPSSysEditorStyle getPSSysEditorStyle();

    @Override
    public String getEditorStyle();

    public boolean isAllowEmpty();

    public String getPSCodeListId();

    public Iterator<IPSGEIDEFValueRule> getPSGEIDEFValueRules();

    public IPSDEFGridColumn getPSDEFGridColumn();

    @Override
    public IPSAppView getRefLinkPSAppView() throws Exception;

    @Override
    public IPSAppView getRefPickupPSAppView() throws Exception;

    @Override
    public IPSDEDataSet getRefPSDEDataSet() throws Exception;

    @Override
    public IPSDEACMode getRefPSDEACMode() throws Exception;

    @Override
    public String getItemHandlerType();

    @Override
    public IPSCodeList getPSCodeList();

    public boolean isEditable();

    @Override
    public JSONObject getItemParam() throws Exception;

    public String getPSDEGEIUpdateId();

    public IPSDEGridEditItemUpdate getPSDEGridEditItemUpdate() throws Exception;

    @Override
    public int getEditorParam(String var1, int var2);

    @Override
    public String getEditorParam(String var1, String var2);

    @Override
    public double getEditorParam(String var1, double var2);

    @Override
    public boolean getEditorParam(String var1, boolean var2);

    @Override
    public Properties getEditorParams();

    public String getPSSysValueRuleId();

    public boolean isConvertToCodeItemText();

    public boolean isNeedCodeListConfig();

    public int getOutputCodeListConfigMode();

    @Override
    public String getEditorCssStyle();

    public String getResetItemName();

    public Iterator<String> getResetItemNames();

    @Override
    public String getPlaceHolder();

    @Override
    public IPSAjaxHandler getItemPSAjaxHandler();

    @Override
    public String[] getValueItemNames();

    public IPSAppDEField getPSAppDEField();

    public int getEnableCond();

    public String getCreateDVT();

    public String getCreateDV();

    public String getUpdateDVT();

    public String getUpdateDV();

    public String getCaption();

    public int getIgnoreInput();

    public String getValueTranslator();

    public String getUnitName();

    public int getUnitNameWidth();

    public boolean isEnableUnitName();
}

