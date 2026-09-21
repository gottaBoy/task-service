/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.control.form.IFormItem
 */
package net.ibizsys.model.control.form;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.IPSEditorType;
import net.ibizsys.model.control.ajax.IPSAjaxHandler;
import net.ibizsys.model.control.form.IPSDEFFormItem;
import net.ibizsys.model.control.form.IPSDEFormDetail;
import net.ibizsys.model.control.form.IPSDEFormItemUpdate;
import net.ibizsys.model.control.form.IPSFIDEFValueRule;
import net.ibizsys.model.dataentity.ac.IPSDEACMode;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.logic.IPSDELogic;
import net.ibizsys.model.res.IPSSysEditorStyle;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.paas.control.form.IFormItem;

public interface IPSDEFormItem
extends IPSDEFormDetail,
IFormItem {
    public static final String LABELPOS_LEFT = "LEFT";
    public static final String LABELPOS_TOP = "TOP";
    public static final String LABELPOS_RIGHT = "RIGHT";
    public static final String LABELPOS_BOTTOM = "BOTTOM";
    public static final String LABELPOS_NONE = "NONE";

    public IPSDEField getPSDEField();

    public String getLabelPos();

    public int getLabelWidth();

    public boolean isHidden();

    public String getEditorType();

    public IPSEditorType getPSEditorType();

    public IPSSysEditorStyle getPSSysEditorStyle();

    public String getEditorStyle();

    public double getEditorWidth();

    public double getEditorHeight();

    public boolean isAllowEmpty();

    public double getItemWidth();

    public double getItemHeight();

    public String getPSCodeListId();

    public Iterator<IPSFIDEFValueRule> getPSFIDEFValueRules();

    public IPSDEFFormItem getPSDEFFormItem();

    public IPSAppView getRefLinkPSAppView() throws Exception;

    public IPSAppView getRefPickupPSAppView() throws Exception;

    public IPSDEDataSet getRefPSDEDataSet() throws Exception;

    public IPSDELogic getRefActiveDataPSDELogic() throws Exception;

    public IPSDEACMode getRefPSDEACMode() throws Exception;

    public String getItemHandlerType();

    public IPSCodeList getPSCodeList();

    public boolean isEditable();

    public ObjectNode getItemParam() throws Exception;

    public String getPSDEFIUpdateId();

    public IPSDEFormItemUpdate getPSDEFormItemUpdate() throws Exception;

    public int getEditorParam(String var1, int var2);

    public String getEditorParam(String var1, String var2);

    public double getEditorParam(String var1, double var2);

    public boolean getEditorParam(String var1, boolean var2);

    public Properties getEditorParams();

    public String getPSSysValueRuleId();

    public boolean isConvertToCodeItemText();

    public int getLabelColSpan();

    public int getCtrlColSpan();

    public int getLabelRealColSpan();

    public int getCtrlRealColSpan();

    public String getLabelColCssClass();

    public String getCtrlColCssClass();

    public boolean isNeedCodeListConfig();

    public int getOutputCodeListConfigMode();

    public String getLabelCssStyle();

    public String getCtrlCssStyle();

    public String getEditorCssStyle();

    public String getResetItemName();

    public Iterator<String> getResetItemNames();

    public boolean isEmptyCaption();

    public String getPlaceHolder();

    @Override
    public IPSSysImage getPSSysImage();

    public boolean isEnableItemPriv();

    public boolean isEnableUnitName();

    public String getUnitName();

    public int getUnitNameWidth();

    public String getPHLanResTag();

    public IPSAjaxHandler getItemPSAjaxHandler();
}

