/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Report.List.ListColumnConfig
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.Web.WebUtility
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Report.List;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Report.List.IListCell;
import SA.SRFDA.Report.List.ListColumnConfig;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.WebUtility;
import java.util.Hashtable;
import net.sf.json.JSONObject;

public class BaseListCell
implements IListCell {
    private Hashtable<String, Object> properties = null;

    protected Object GetProperty(String strKey) {
        if (this.properties == null) {
            return null;
        }
        return this.properties.get(strKey);
    }

    protected void SetProperty(String strKey, Object objValue) {
        if (this.properties == null) {
            this.properties = new Hashtable();
        }
        if (objValue == null) {
            this.properties.remove(strKey);
        } else {
            this.properties.put(strKey, objValue);
        }
    }

    protected String GetLocalization(ISRFDAGlobalHelper globalContext, String strLanguage, String strResId, String strDefault) {
        Object objLocalization = this.GetProperty(String.valueOf(strLanguage) + "." + strResId);
        if (objLocalization == null) {
            objLocalization = StringHelper.Format((String)globalContext.getLocalizationHelper().GetLocalization(strLanguage, strResId, strDefault));
            this.SetProperty(String.valueOf(strLanguage) + "." + strResId, objLocalization);
        }
        return (String)objLocalization;
    }

    @Override
    public String GetValue(IDEHelper iDEHelper, ISRFDAWebContext webContext, ISRFDAGlobalHelper globalContext, DataRow dr, ListColumnConfig listColumnConfig) {
        String strItemParams;
        String strValue;
        String strItemFormat;
        block16: {
            strItemFormat = listColumnConfig.getFormat();
            strValue = "";
            if (StringHelper.Length((String)strItemFormat) == 0) {
                strItemFormat = "%1$s";
            }
            strItemParams = listColumnConfig.getParams();
            if (!StringHelper.IsNullOrEmpty((String)(strItemParams = strItemParams.trim()))) break block16;
            return "\u6ca1\u6709\u5b9a\u4e49\u53c2\u6570";
        }
        try {
            String[] itemParams = strItemParams.split("[|]");
            Object[] valueObj = new Object[itemParams.length];
            int i = 0;
            while (i < itemParams.length) {
                IDEFHelper iDEFHelper;
                if (dr.IsDBNull(itemParams[i])) {
                    return listColumnConfig.getDefault();
                }
                Object objValue = dr.Get(itemParams[i]);
                if (iDEHelper.IsContainDEField(itemParams[i]) && (iDEFHelper = iDEHelper.GetDEFHelper(itemParams[i])) != null && !StringHelper.IsNullOrEmpty((String)iDEFHelper.GetCodeList())) {
                    String strTempValue = objValue.toString();
                    CodeListConfig codeListConfig = globalContext.getCodeListMgr().GetCodeListConfig(iDEFHelper.GetCodeList(), webContext.getLocalization());
                    if (codeListConfig != null) {
                        String strPageModel = SRFDAWebCTXHelper.GetPageModel((ISRFDAWebContext)webContext);
                        if (StringHelper.IsNullOrEmpty((String)strPageModel)) {
                            objValue = codeListConfig.GetCodeListValueWithStyle(strTempValue, true);
                        } else {
                            CodeItemConfig codeItemConfig = codeListConfig.FindCodeItemConfigByValue(strTempValue, true);
                            if (codeItemConfig == null) {
                                objValue = codeListConfig.getEmptyText();
                            } else if (StringHelper.Compare((String)strItemFormat, (String)"%1$s", (boolean)true) == 0) {
                                JSONObject jo = new JSONObject();
                                jo.put("text", (Object)WebUtility.GetJSONText((String)codeItemConfig.getText()));
                                jo.put("color", (Object)codeItemConfig.getColor());
                                if (!StringHelper.IsNullOrEmpty((String)codeItemConfig.getIcon())) {
                                    jo.put("icon", (Object)codeItemConfig.getIcon());
                                }
                                if (!StringHelper.IsNullOrEmpty((String)codeItemConfig.getIconCls())) {
                                    jo.put("icon", (Object)codeItemConfig.getIconCls());
                                }
                                objValue = jo.toString();
                            } else {
                                objValue = codeItemConfig.getText();
                            }
                        }
                    }
                }
                valueObj[i] = objValue;
                ++i;
            }
            strValue = StringHelper.Format((String)strItemFormat, (Object[])valueObj);
            return strValue;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return "\u9519\u8bef";
        }
    }
}

