/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.panel.IPanelField
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxHandler;
import SA.SRFDA.PS.Core.Control.IPSEditorContainer;
import SA.SRFDA.PS.Core.Control.IPSEditorType;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItem;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysEditorStyle;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.paas.control.panel.IPanelField;
import net.sf.json.JSONObject;

@PSModelInterfaceMeta(title="\u9762\u677f\u5c5e\u6027\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSSysPanelFieldImpl", model="PSSysViewPanelItem")
@PSModelExtendMeta(extend="IPSPanelItem", typevalue={"FIELD"})
public interface IPSPanelField
extends IPSPanelItem,
IPanelField,
IPSEditorContainer {
    public static final int FIELDSTATE_NONE = 0;
    public static final int FIELDSTATE_READONLY = 1;
    public static final int FIELDSTATE_DISABLED = 2;

    public String getFieldName();

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

    public String getPSCodeListId();

    @Override
    public String getItemHandlerType();

    @Override
    public IPSCodeList getPSCodeList();

    public boolean isEditable();

    @Override
    public JSONObject getItemParam() throws Exception;

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

    public boolean isConvertToCodeItemText();

    public boolean isNeedCodeListConfig();

    public int getOutputCodeListConfigMode();

    @Override
    public String getEditorCssStyle();

    @Override
    public String getPlaceHolder();

    @Override
    public IPSSysImage getPSSysImage();

    @Override
    public IPSAjaxHandler getItemPSAjaxHandler();

    public String getValueFormat();

    public int getFieldStates();

    @Override
    public String getLabelCssStyle();

    @Override
    public String getLabelDynaClass();

    public String getViewFieldName();

    public String getResetItemName();

    public Iterator<String> getResetItemNames();
}

