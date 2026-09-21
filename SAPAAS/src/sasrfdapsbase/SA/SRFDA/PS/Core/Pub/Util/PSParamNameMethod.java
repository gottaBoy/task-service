/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  freemarker.template.TemplateMethodModel
 *  freemarker.template.TemplateModelException
 */
package SA.SRFDA.PS.Core.Pub.Util;

import SA.SRFramework.Utility.StringHelper;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import java.util.HashMap;
import java.util.List;

public class PSParamNameMethod
implements TemplateMethodModel {
    private static HashMap<String, String> nameMap = new HashMap();

    static {
        nameMap.put("FORM", "editForm");
        nameMap.put("EDITFORM", "editForm");
        nameMap.put("SEARCHFORM", "searchForm");
        nameMap.put("GRID", "grid");
        nameMap.put("DATAVIEW", "dataView");
        nameMap.put("DEFAULT", "_default");
        nameMap.put("TREEGRID", "treeGrid");
        nameMap.put("GROUPGRID", "groupGrid");
        nameMap.put("EXPBAR", "expBar");
        nameMap.put("WFEXPBAR", "wfExpBar");
        nameMap.put("DRBAR", "drBar");
        nameMap.put("DASHBOARD", "dashboard");
        nameMap.put("PORTLET", "portlet");
        nameMap.put("CHART", "chart");
        nameMap.put("APPMENU", "appMenu");
        nameMap.put("LIST", "list");
        nameMap.put("DRTAB", "drTab");
        nameMap.put("WIZARDPANEL", "wizardPanel");
        nameMap.put("STATIC", "_static");
        nameMap.put("CLASS", "_class");
        nameMap.put("PUBLIC", "_public");
        nameMap.put("PRIVATE", "_private");
        nameMap.put("PROTECTED", "_protected");
        nameMap.put("NEW", "_new");
        nameMap.put("PACKAGE", "_package");
        nameMap.put("IMPORT", "_import");
        nameMap.put("NULL", "_null");
        nameMap.put("SUPER", "_super");
        nameMap.put("RETURN", "_return");
        nameMap.put("TRY", "_try");
        nameMap.put("THROWS", "_throws");
        nameMap.put("CATCH", "_catch");
        nameMap.put("IMPLEMENTS", "_implements");
        nameMap.put("EXTENDS", "_extends");
        nameMap.put("INTERFACE", "_interface");
        nameMap.put("FLOAT", "_float");
        nameMap.put("CHAR", "_char");
        nameMap.put("INTEGER", "_integer");
        nameMap.put("STRING", "_string");
        nameMap.put("DOUBLE", "_double");
    }

    public static String getValue(String strValue) {
        String strValue2 = nameMap.get(strValue.toUpperCase());
        if (strValue2 != null) {
            return strValue2;
        }
        return String.valueOf(strValue.substring(0, 1).toLowerCase()) + strValue.substring(1);
    }

    public Object exec(List arg0) throws TemplateModelException {
        String strValue;
        block4: {
            if (arg0.size() == 0) {
                return StringHelper.Format((String)"/*%1$s*/", (Object)"\u6ca1\u6709\u6307\u5b9a\u5b57\u7b26\u4e32");
            }
            try {
                strValue = (String)arg0.get(0);
                if (!StringHelper.IsNullOrEmpty((String)strValue)) break block4;
                return "";
            }
            catch (Exception e) {
                throw new TemplateModelException(e);
            }
        }
        return PSParamNameMethod.getValue(strValue);
    }
}

