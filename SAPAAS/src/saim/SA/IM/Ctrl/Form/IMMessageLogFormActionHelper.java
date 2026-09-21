/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Form.BaseDAFormActionHelper
 *  SA.SRFDA.Web.Utility.GlobalHelperEx
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.IM.Ctrl.Form;

import SA.SRFDA.Ctrl.Form.BaseDAFormActionHelper;
import SA.SRFDA.Web.Utility.GlobalHelperEx;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IMMessageLogFormActionHelper
extends BaseDAFormActionHelper {
    private Log log = LogFactory.getLog(IMMessageLogFormActionHelper.class);

    protected void OnLoadActionFillForm(BaseDataEntity dataEntity) {
        String strUserName = "";
        String strValue = "";
        try {
            String[] users;
            strValue = dataEntity.GetParamStringValue("IMUSERIDS", "");
            String strValue2 = dataEntity.GetParamStringValue("IMUSERID", "");
            String[] stringArray = users = strValue.split("[;]");
            int n = users.length;
            int n2 = 0;
            while (n2 < n) {
                String user = stringArray[n2];
                if (StringHelper.Compare((String)user, (String)strValue2, (boolean)true) != 0) {
                    strValue = user;
                }
                ++n2;
            }
            GlobalHelperEx helper = this.getWebContext().getGlobalHelper();
            CodeListConfig codeListConfig = helper.getDAModelStorage().FindCodeListConfig("CODELIST_IM0070_003");
            CodeItemConfig codeItemConfig = codeListConfig.FindCodeItemConfigByValue(strValue, true);
            if (codeItemConfig != null) {
                strUserName = codeItemConfig.getText();
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        if (StringHelper.IsNullOrEmpty((String)strUserName)) {
            this.log.error((Object)("\u65e0\u6cd5\u83b7\u53d6\u6d88\u606f\u7684\u63a5\u6536\u4eba" + strValue));
        }
        dataEntity.SetParamValue("IMUSERIDS", (Object)strUserName);
        super.OnLoadActionFillForm(dataEntity);
    }
}

