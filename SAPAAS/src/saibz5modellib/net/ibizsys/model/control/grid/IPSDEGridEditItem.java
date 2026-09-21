/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.control.grid.IGridEditItem
 */
package net.ibizsys.model.control.grid;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.IPSEditorType;
import net.ibizsys.model.control.ajax.IPSAjaxHandler;
import net.ibizsys.model.control.grid.IPSDEFGridColumn;
import net.ibizsys.model.control.grid.IPSDEGrid;
import net.ibizsys.model.control.grid.IPSDEGridColumn;
import net.ibizsys.model.control.grid.IPSDEGridEditItemUpdate;
import net.ibizsys.model.control.grid.IPSGEIDEFValueRule;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.ac.IPSDEACMode;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.res.IPSSysEditorStyle;
import net.ibizsys.paas.control.grid.IGridEditItem;

public interface IPSDEGridEditItem
extends IGridEditItem,
IPSModelObject {
    public IPSDEGrid getPSDEGrid();

    public String getCodeName();

    public IPSDEGridColumn getPSDEGridColumn();

    public IPSDEField getPSDEField();

    public String getEditorType();

    public IPSEditorType getPSEditorType();

    public IPSSysEditorStyle getPSSysEditorStyle();

    public String getEditorStyle();

    public boolean isAllowEmpty();

    public String getPSCodeListId();

    public Iterator<IPSGEIDEFValueRule> getPSGEIDEFValueRules();

    public IPSDEFGridColumn getPSDEFGridColumn();

    public IPSAppView getRefLinkPSAppView() throws Exception;

    public IPSAppView getRefPickupPSAppView() throws Exception;

    public IPSDEDataSet getRefPSDEDataSet() throws Exception;

    public IPSDEACMode getRefPSDEACMode() throws Exception;

    public String getItemHandlerType();

    public IPSCodeList getPSCodeList();

    public boolean isEditable();

    public ObjectNode getItemParam() throws Exception;

    public String getPSDEGEIUpdateId();

    public IPSDEGridEditItemUpdate getPSDEGridEditItemUpdate() throws Exception;

    public int getEditorParam(String var1, int var2);

    public String getEditorParam(String var1, String var2);

    public double getEditorParam(String var1, double var2);

    public boolean getEditorParam(String var1, boolean var2);

    public Properties getEditorParams();

    public String getPSSysValueRuleId();

    public boolean isConvertToCodeItemText();

    public boolean isNeedCodeListConfig();

    public int getOutputCodeListConfigMode();

    public String getEditorCssStyle();

    public String getResetItemName();

    public Iterator<String> getResetItemNames();

    public String getPlaceHolder();

    public IPSAjaxHandler getItemPSAjaxHandler();
}

