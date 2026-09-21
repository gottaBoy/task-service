/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.form.IFormItem
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxHandler;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFFormItem;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItemUpdate;
import SA.SRFDA.PS.Core.Control.Form.IPSFIDEFValueRule;
import SA.SRFDA.PS.Core.Control.IPSEditorContainer;
import SA.SRFDA.PS.Core.Control.IPSEditorType;
import SA.SRFDA.PS.Core.DEField.IPSDEFInputTip;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACMode;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysEditorStyle;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.paas.control.form.IFormItem;
import net.sf.json.JSONObject;

@PSModelExtendMeta(title="\u8868\u5355\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"FORMITEM"})
public interface IPSDEFormItem
extends IPSDEFormDetail,
IFormItem,
IPSEditorContainer {
    public static final String LABELPOS_LEFT = "LEFT";
    public static final String LABELPOS_TOP = "TOP";
    public static final String LABELPOS_RIGHT = "RIGHT";
    public static final String LABELPOS_BOTTOM = "BOTTOM";
    public static final String LABELPOS_NONE = "NONE";
    public static final int NOPRIVDISPLAYMODE_EMPTY = 1;
    public static final int NOPRIVDISPLAYMODE_HIDE = 2;
    public static final int ITEMSTATE_NONE = 0;
    public static final int ITEMSTATE_READONLY = 1;
    public static final int ITEMSTATE_DISABLED = 2;

    public IPSDEField getPSDEField();

    public String getLabelPos();

    public int getLabelWidth();

    public boolean isHidden();

    @Override
    public String getEditorType();

    @Override
    public IPSEditorType getPSEditorType();

    @Override
    public IPSSysEditorStyle getPSSysEditorStyle();

    @Override
    public String getEditorStyle();

    @Override
    public double getEditorWidth();

    @Override
    public double getEditorHeight();

    public boolean isAllowEmpty();

    public double getItemWidth();

    public double getItemHeight();

    public String getPSCodeListId();

    public Iterator<IPSFIDEFValueRule> getPSFIDEFValueRules();

    public IPSDEFFormItem getPSDEFFormItem();

    @Override
    public IPSAppView getRefLinkPSAppView() throws Exception;

    @Override
    public IPSAppView getRefPickupPSAppView() throws Exception;

    @Override
    public IPSDEDataSet getRefPSDEDataSet() throws Exception;

    public IPSDELogic getRefActiveDataPSDELogic() throws Exception;

    @Override
    public IPSDEACMode getRefPSDEACMode() throws Exception;

    public IPSDERBase getRefPSDER() throws Exception;

    @Override
    public String getItemHandlerType();

    @Override
    public IPSCodeList getPSCodeList();

    public boolean isEditable();

    @Override
    public JSONObject getItemParam() throws Exception;

    public String getPSDEFIUpdateId();

    public IPSDEFormItemUpdate getPSDEFormItemUpdate() throws Exception;

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

    public int getLabelColSpan();

    public int getCtrlColSpan();

    public int getLabelRealColSpan();

    public int getCtrlRealColSpan();

    public String getLabelColCssClass();

    public String getCtrlColCssClass();

    public boolean isNeedCodeListConfig();

    public int getOutputCodeListConfigMode();

    @Override
    public String getLabelCssStyle();

    @Override
    public String getLabelDynaClass();

    public String getCtrlCssStyle();

    @Override
    public String getEditorCssStyle();

    public String getResetItemName();

    public Iterator<String> getResetItemNames();

    public boolean isEmptyCaption();

    @Override
    public String getPlaceHolder();

    @Override
    public IPSSysImage getPSSysImage();

    public boolean isEnableItemPriv();

    public boolean isEnableUnitName();

    public String getUnitName();

    public int getUnitNameWidth();

    public IPSDEFInputTip getPSDEFInputTip();

    public IPSLanguageRes getPHPSLanguageRes();

    public String getPHLanResTag();

    @Override
    public IPSAjaxHandler getItemPSAjaxHandler();

    public int getNoPrivDisplayMode();

    @Override
    public String[] getValueItemNames();

    public boolean isCompositeItem();

    public boolean isRefTempData();

    public int getStdDataType();

    public int getDataType();

    public IPSAppDEField getPSAppDEField();

    public String getCaptionItemName();

    public boolean isEnableAnchor();

    public boolean isEnableInputTip();

    public int getEnableCond();

    public String getCreateDVT();

    public String getCreateDV();

    public String getUpdateDVT();

    public String getUpdateDV();

    @Override
    public String getCaption();

    @Override
    public String getCapLanResTag();

    public int getIgnoreInput();

    public String getValueTranslator();

    public String getInputTip();

    public String getInputTipLanResTag();

    public String getInputTipUrl();

    public String getInputTipUniqueTag();

    public boolean isInputTipClosable();

    public int getWriteBackDEFMode();

    public String getValueFormat();

    public String getFieldName();
}

