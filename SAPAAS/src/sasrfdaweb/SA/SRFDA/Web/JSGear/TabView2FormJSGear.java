/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DER1N
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.Script.FormJSHelper
 *  SA.SRFramework.WebEx.Script.TabViewPageJSHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Web.JSGear;

import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.Script.FormJSHelper;
import SA.SRFramework.WebEx.Script.TabViewPageJSHelper;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TabView2FormJSGear {
    private static final Log log = LogFactory.getLog(TabView2FormJSGear.class);

    public static boolean Load(SRFDAPage daPage, SRFExForm form, String strTabViewId, String strTabViewPageId) {
        String strIgnoreKey = "true";
        String strSRFDERId = daPage.getWebContext().getSRFDERID();
        if (!StringHelper.IsNullOrEmpty((String)strSRFDERId)) {
            DER1N der1N = daPage.getDEHelper().FindDER1N(strSRFDERId);
            if (der1N == null) {
                der1N = new DER1N();
                CallResult callResult = daPage.getDAModelHelper().GetDER1N(strSRFDERId, der1N);
                if (callResult.getRetCode() != 0) {
                    daPage.PageLog(null, 1, StringHelper.Format((String)"\u83b7\u53d6DER1N[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strSRFDERId, (Object)callResult.getErrorInfo()));
                }
            }
            if (der1N != null && StringHelper.Compare((String)daPage.getDEHelper().getId(), (String)der1N.getMAJORDEID(), (boolean)true) == 0) {
                strIgnoreKey = "false";
            }
        }
        StringBuilderEx script = new StringBuilderEx();
        script.Append("var _TVD = %1$s;", (Object)TabViewPageJSHelper.getTabViewPageDataScript((String)strTabViewId, (String)strTabViewPageId));
        script.Append("var _COPYMODE=$V(_TVD._COPYMODE,false);");
        ArrayList keyControls = form.GetKeyFormControls();
        String strEmptyTestCode = "";
        String strSameTestCode = "";
        String strLoad2ParamCode = "";
        int nCount = keyControls.size();
        if (nCount == 0) {
            script.Append("alert('\u8868\u5355\u6ca1\u6709\u4efb\u4f55\u4e3b\u952e\uff0c\u5904\u7406\u505c\u6b62!');");
        }
        int i = 0;
        while (i < nCount) {
            SRFExControl control = (SRFExControl)keyControls.get(i);
            script.Append("var var%1$s=$V(_TVD.%2$s,'');", (Object)control.getID(), (Object)control.getID().toLowerCase());
            if (StringHelper.Length((String)strEmptyTestCode) != 0) {
                strEmptyTestCode = String.valueOf(strEmptyTestCode) + "&&";
            }
            strEmptyTestCode = String.valueOf(strEmptyTestCode) + StringHelper.Format((String)"var%1$s!=''", (Object)control.getID());
            if (StringHelper.Length((String)strSameTestCode) != 0) {
                strSameTestCode = String.valueOf(strSameTestCode) + " && ";
            }
            strSameTestCode = String.valueOf(strSameTestCode) + StringHelper.Format((String)"var%1$s==%2$s.G('%3$s')", (Object)control.getID(), (Object)form.getFormId(), (Object)control.getUniqueID());
            if (StringHelper.Length((String)strLoad2ParamCode) != 0) {
                strLoad2ParamCode = String.valueOf(strLoad2ParamCode) + ",";
            }
            strLoad2ParamCode = String.valueOf(strLoad2ParamCode) + StringHelper.Format((String)"var%1$s", (Object)control.getID());
            ++i;
        }
        script.Append("if(%1$s&&%4$s){if(%3$s && !_COPYMODE){return;}%2$s}", (Object)strEmptyTestCode, (Object)FormJSHelper.getLoad2Script((SRFExForm)form, (String)(String.valueOf(strLoad2ParamCode) + ",_COPYMODE")), (Object)strSameTestCode, (Object)strIgnoreKey);
        script.Append("else{if(_COPYMODE)return;%1$s %2$s}", (Object)FormJSHelper.getResetScript((SRFExForm)form), (Object)(form.getLoadAction().getLoadDefault() ? FormJSHelper.getLoadDefaultScript((SRFExForm)form) : ""));
        daPage.RegisterOnReadyScript(3, TabViewPageJSHelper.getOnDataChangedEventScript((String)strTabViewId, (String)strTabViewPageId, (String)script.toString()));
        daPage.RegisterOnReadyScript(5, script.toString());
        return true;
    }
}

