/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.CodeList.IUserCodeListContext
 *  SA.SRFramework.CodeList.IUserCodeListFiller
 *  SA.SRFramework.CodeList.IUserCodeListQuery
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.CodeList;

import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.CodeList.IUserCodeListContext;
import SA.SRFramework.CodeList.IUserCodeListFiller;
import SA.SRFramework.CodeList.IUserCodeListQuery;
import SA.SRFramework.Utility.StringHelper;
import java.net.URLDecoder;
import java.util.Hashtable;

public class DynamicUserCodeList
implements IUserCodeListFiller,
IUserCodeListQuery {
    private IUserCodeListContext iUserCodeListContext = null;
    private Hashtable<String, String> paramList = new Hashtable();

    public boolean Fill(IUserCodeListContext iUserCodeListContext, CodeListConfig codeListConfig) {
        String strQueryString = codeListConfig.GetExtValue("CODELISTPARAM", "");
        String[] strLists = strQueryString.split("&");
        int i = 0;
        while (i < strLists.length) {
            String[] set = strLists[i].split("=");
            if (set.length == 2) {
                try {
                    String strValue = URLDecoder.decode(set[1], "UTF-8");
                    if (StringHelper.Length((String)strValue) != 0) {
                        this.paramList.put(set[0].toUpperCase(), strValue);
                    }
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            ++i;
        }
        String strMainState = this.paramList.get("MAINSTATE");
        if (!StringHelper.IsNullOrEmpty((String)strMainState)) {
            CodeItemConfig codeItemConfig = new CodeItemConfig();
            codeItemConfig.setText(strMainState);
            codeItemConfig.setValue(strMainState);
            codeListConfig.AddCodeItemConfig(codeItemConfig);
        }
        return true;
    }

    public void Init(IUserCodeListContext iUserCodeListContext) {
        this.iUserCodeListContext = iUserCodeListContext;
    }

    public CodeItemConfig Query(String strValue) {
        return null;
    }
}

