/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSUIActionItem;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItemUpdate;
import SA.SRFDA.PS.Core.Control.IPSNavigateParamContainer;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.WF.UIAction.IPSWFUIAction;
import net.sf.json.JSONObject;

@PSModelExtendMeta(title="\u8868\u5355\u6309\u94ae\u6210\u5458\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"BUTTON"})
public interface IPSDEFormButton
extends IPSDEFormDetail,
IPSUIActionItem,
IPSNavigateParamContainer {
    public static final String ACTIONTYPE_UIACTION = "UIACTION";
    public static final String ACTIONTYPE_FIUPDATE = "FIUPDATE";

    public String getActionType();

    public String getPSUIActionId();

    @Override
    public IPSUIAction getPSUIAction();

    public IPSDEUIAction getPSDEUIAction();

    public IPSWFUIAction getPSWFUIAction();

    public String getPSDEFIUpdateId();

    public IPSDEFormItemUpdate getPSDEFormItemUpdate();

    public String getTooltip();

    public IPSLanguageRes getTooltipPSLanguageRes();

    public IPSAppView getParamPickupPSAppView() throws Exception;

    public JSONObject getParamViewParamJO() throws Exception;

    public String getCaptionItemName();

    @Override
    public String getUIActionTarget();

    public IPSUIAction getInlinePSUIAction();

    public String getIconAlign();

    public String getBorderStyle();

    public String getButtonStyle();
}

