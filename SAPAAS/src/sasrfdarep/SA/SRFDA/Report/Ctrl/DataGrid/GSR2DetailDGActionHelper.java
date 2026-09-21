/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.Data.GSR2
 *  SA.SRFDA.Ctrl.Data.GSR2SumTable
 *  SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Report.Ctrl.DataGrid;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.Data.GSR2;
import SA.SRFDA.Ctrl.Data.GSR2SumTable;
import SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper;
import SA.SRFramework.Utility.StringHelper;

public class GSR2DetailDGActionHelper
extends BaseDADataGridActionHelper {
    protected String GetDAModelQueryScript(BaseDAQueryModelHelper daQueryModelHelper) {
        String strScript = super.GetDAModelQueryScript(daQueryModelHelper);
        String strGSR2Id = this.getWebContext().GetParamValue("SRFGSR2ID");
        String strGSR2TD = this.getWebContext().GetParamValue("SRFTD");
        if (!StringHelper.IsNullOrEmpty((String)strGSR2Id) && !StringHelper.IsNullOrEmpty((String)strGSR2TD)) {
            GSR2 gsr2 = this.getPage().getDAModelStorage().FindGSR2(strGSR2Id);
            if (gsr2 == null) {
                this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5206\u7ec4\u7edf\u8ba1\u62a5\u8868\u914d\u7f6e[%1$s]", (Object)strGSR2Id));
                return "";
            }
            GSR2SumTable sumTable = gsr2.FindSumTable(strGSR2TD);
            if (sumTable == null) {
                this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5206\u7ec4\u7edf\u8ba1\u62a5\u8868\u65f6\u95f4\u6c47\u603b\u8868[%1$s]", (Object)strGSR2TD));
                return "";
            }
            strScript = strScript.replaceAll(this.getDEHelper().GetMainTable(), sumTable.getGSR2SUMTABLENAME());
        }
        return strScript;
    }
}

