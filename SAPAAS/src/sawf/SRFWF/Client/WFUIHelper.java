/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.Button.SRFExAjaxButton
 *  SA.SRFramework.WebEx.SRFExBaseButton
 *  SA.SRFramework.WebEx.SRFExButton
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.SRFExPage
 *  SA.SRFramework.WebEx.Script.DataGridJSHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 */
package SRFWF.Client;

import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.Button.SRFExAjaxButton;
import SA.SRFramework.WebEx.SRFExBaseButton;
import SA.SRFramework.WebEx.SRFExButton;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.SRFExPage;
import SA.SRFramework.WebEx.Script.DataGridJSHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import SRFWF.Client.WFGetIAActionsResult;
import SRFWF.Model.WFInteractiveActionConfig;
import SRFWF.Model.WFUserActionConfig;
import java.net.URLEncoder;
import java.util.ArrayList;

public class WFUIHelper {
    public static ArrayList<SRFExBaseButton> GetIAActionButtons(String strWorkflowId, String strStepName, String strCodeListItemValue, WFGetIAActionsResult result, SRFExDataGrid dataGrid, SRFExPage page) {
        String strPageStyle;
        String strURL;
        StringBuilderEx script;
        SRFExButton button;
        ArrayList<SRFExBaseButton> buttons = new ArrayList<SRFExBaseButton>();
        for (WFInteractiveActionConfig iaActionConfig : result.getIAActionList()) {
            button = new SRFExButton();
            button.InitConfig();
            button.setID(Helper.GenGuidEx());
            button.getButtonConfig().setText(iaActionConfig.getLogicName());
            if (StringHelper.IsNullOrEmpty((String)iaActionConfig.getDesc())) {
                button.getButtonConfig().setTips(iaActionConfig.getLogicName());
            } else {
                button.getButtonConfig().setTips(iaActionConfig.getDesc());
            }
            button.getButtonConfig().SetValue("SHOWORDER", StringHelper.Format((String)"%1$s", (Object)iaActionConfig.getShowOrder()));
            script = new StringBuilderEx();
            strURL = iaActionConfig.getPagePath();
            strURL = URLHelper.AppendURLSeperator((String)strURL);
            try {
                strURL = String.valueOf(strURL) + StringHelper.Format((String)"SRFWFID=%1$s&SRFWFSTEPID=%2$s&SRFWFCLIV=%3$s&SRFWFIAANAME=%4$s", (Object)URLEncoder.encode(strWorkflowId, "UTF-8"), (Object)URLEncoder.encode(strStepName, "UTF-8"), (Object)URLEncoder.encode(strCodeListItemValue, "UTF-8"), (Object)URLEncoder.encode(iaActionConfig.getName(), "UTF-8"));
            }
            catch (Exception exception) {
                // empty catch block
            }
            strPageStyle = iaActionConfig.getPageStyle();
            if (StringHelper.IsNullOrEmpty((String)strPageStyle)) {
                strPageStyle = "dialogWidth:800px;dialogHeight:540px;resizable:no;scroll:no;status:no";
            }
            script.Append("var _data = %1$s;\r\n", (Object)DataGridJSHelper.getDataGridCheckedRows((String)dataGrid.getUniqueID(), (String)"srfwfdata", (boolean)false));
            script.Append("if(_data == '')return;\r\n");
            script.Append("var _DIALOGRESULT = window.showModalDialog('%1$s',{values:_data},'%2$s');", (Object)strURL, (Object)strPageStyle);
            script.Append(DataGridJSHelper.getDataReloadScript((String)dataGrid.getUniqueID()));
            button.getButtonConfig().setJSCode(script.toString());
            int nIndex = -1;
            int i = 0;
            while (i < buttons.size()) {
                nIndex = i;
                SRFExButton tempButton = (SRFExButton)buttons.get(i);
                if (tempButton.getButtonConfig().GetExtValue("SHOWORDER", 0) > iaActionConfig.getShowOrder()) break;
                ++i;
            }
            if (nIndex == -1) {
                buttons.add((SRFExBaseButton)button);
                continue;
            }
            buttons.add(nIndex, (SRFExBaseButton)button);
        }
        for (WFUserActionConfig wfAction : result.getUserActionList()) {
            if (wfAction.getActionType() == 1) {
                button = new SRFExAjaxButton();
                button.InitConfig();
                button.setID(Helper.GenGuidEx());
                button.getAjaxButtonConfig().setText(wfAction.getActionLogicName());
                if (StringHelper.IsNullOrEmpty((String)wfAction.getDescription())) {
                    button.getAjaxButtonConfig().setTips(wfAction.getActionLogicName());
                } else {
                    button.getAjaxButtonConfig().setTips(wfAction.getDescription());
                }
                button.getAjaxButtonConfig().setBackEndCtrl(wfAction.getButtonActionHelper());
                button.getAjaxButtonConfig().setConfirm(StringHelper.Format((String)"\u786e\u5b9e\u8981\u6267\u884c[%1$s]\u5417\uff1f", (Object)wfAction.getActionLogicName()));
                script = new StringBuilderEx();
                script.Append("var _SELECTEDROWS = %1$s;", (Object)DataGridJSHelper.getDataGridCheckedRows((String)dataGrid.getUniqueID()));
                script.Append("if( _SELECTEDROWS == '' ) { alert('\u6ca1\u6709\u9009\u4e2d\u4efb\u4f55\u6570\u636e\uff0c\u8bf7\u786e\u8ba4\uff01');return;}");
                script.Append("_PARAMS['ajaxparam1'] = _SELECTEDROWS;");
                script.Append(" _POSTDATA =  Ext.urlEncode(_PARAMS);");
                button.getClickAction().setBeforeCode(script.toString());
                script.Reset();
                buttons.add((SRFExBaseButton)button);
                continue;
            }
            if (wfAction.getActionType() != 2) continue;
            button = new SRFExButton();
            button.InitConfig();
            button.setID(Helper.GenGuidEx());
            button.getButtonConfig().setText(wfAction.getActionLogicName());
            if (StringHelper.IsNullOrEmpty((String)wfAction.getDescription())) {
                button.getButtonConfig().setTips(wfAction.getActionLogicName());
            } else {
                button.getButtonConfig().setTips(wfAction.getDescription());
            }
            script = new StringBuilderEx();
            strURL = wfAction.getPagePath();
            strPageStyle = wfAction.getPageStyle();
            if (StringHelper.IsNullOrEmpty((String)strPageStyle)) {
                strPageStyle = "dialogWidth:800px;dialogHeight:540px;resizable:no;scroll:no;status:no";
            }
            script.Append("var _data = %1$s;\r\n", (Object)DataGridJSHelper.getDataGridCheckedRows((String)dataGrid.getUniqueID(), (String)"srfwfdata", (boolean)false));
            script.Append("if(_data == '')return;\r\n");
            script.Append("var _DIALOGRESULT = window.showModalDialog('%1$s',{values:_data},'%2$s');", (Object)strURL, (Object)strPageStyle);
            script.Append(DataGridJSHelper.getDataReloadScript((String)dataGrid.getUniqueID()));
            button.getButtonConfig().setJSCode(script.toString());
            buttons.add((SRFExBaseButton)button);
        }
        return buttons;
    }
}

