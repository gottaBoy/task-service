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

public class PSClassNameMethod
implements TemplateMethodModel {
    private HashMap<String, String> nameMap = new HashMap();

    public PSClassNameMethod() {
        this.nameMap.put("FORM", "EditForm");
        this.nameMap.put("EDITFORM", "EditForm");
        this.nameMap.put("SEARCHFORM", "SearchForm");
        this.nameMap.put("GRID", "Grid");
        this.nameMap.put("TREEGRID", "TreeGrid");
        this.nameMap.put("GROUPGRID", "GroupGrid");
        this.nameMap.put("DATAVIEW", "DataView");
        this.nameMap.put("EXPBAR", "ExpBar");
        this.nameMap.put("WFEXPBAR", "WFExpBar");
        this.nameMap.put("DRBAR", "DRBar");
        this.nameMap.put("DASHBOARD", "Dashboard");
        this.nameMap.put("PORTLET", "Portlet");
        this.nameMap.put("CHART", "Chart");
        this.nameMap.put("APPMENU", "AppMenu");
        this.nameMap.put("LIST", "List");
        this.nameMap.put("TREEEXPBAR", "TreeExpBar");
        this.nameMap.put("TREEVIEW", "Tree");
        this.nameMap.put("DRTAB", "DRTab");
        this.nameMap.put("WIZARDPANEL", "WizardPanel");
        this.nameMap.put("HBASE", "HBase");
        this.nameMap.put("CALENDAR", "Calendar");
        this.nameMap.put("MAP", "Map");
    }

    public Object exec(List arg0) throws TemplateModelException {
        String strValue;
        block5: {
            if (arg0.size() == 0) {
                return StringHelper.Format((String)"/*%1$s*/", (Object)"\u6ca1\u6709\u6307\u5b9a\u5b57\u7b26\u4e32");
            }
            try {
                strValue = (String)arg0.get(0);
                if (!StringHelper.IsNullOrEmpty((String)strValue)) break block5;
                return "";
            }
            catch (Exception e) {
                throw new TemplateModelException(e);
            }
        }
        String strValue2 = this.nameMap.get(strValue.toUpperCase());
        if (strValue2 != null) {
            return strValue2;
        }
        return String.valueOf(strValue.substring(0, 1).toUpperCase()) + strValue.substring(1);
    }
}

