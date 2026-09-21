/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.WebEx.ISRFExDataGridDSItem
 *  SA.SRFramework.WebEx.UI.DataGridDSItemConfig
 */
package SA.SRFDA.Ctrl.DataGrid;

import SA.SRFramework.Data.DataRow;
import SA.SRFramework.WebEx.ISRFExDataGridDSItem;
import SA.SRFramework.WebEx.UI.DataGridDSItemConfig;

public class PercentDSItem
implements ISRFExDataGridDSItem {
    public String GetValue(DataGridDSItemConfig dsItemConfig, DataRow dr, boolean excelMode) {
        try {
            String strId = dsItemConfig.getID();
            Integer nRate = 0;
            nRate = dr.Get(strId) == null ? Integer.valueOf(0) : Integer.valueOf((int)Math.floor(Double.parseDouble(dr.Get(strId).toString())));
            return this.InitTable(nRate);
        }
        catch (Exception ex) {
            return "";
        }
    }

    protected String InitTable(Integer nRate) {
        Integer nFRage = 100 - nRate;
        String strTable = "";
        if (nRate == 0) {
            strTable = "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">";
            strTable = String.valueOf(strTable) + "<tr height='13'>";
            strTable = String.valueOf(strTable) + "<td width=\"100%\" align='center'><span class='sx-normaltext'>" + nRate.toString() + "%" + "</span></td>";
            strTable = String.valueOf(strTable) + "</tr>";
            strTable = String.valueOf(strTable) + "<tr height='5'>";
            strTable = String.valueOf(strTable) + "<td width=\"100%\" bgcolor=\"lightblue\"  ></td>";
            strTable = String.valueOf(strTable) + "</tr>";
            strTable = String.valueOf(strTable) + "</table>";
        } else if (nRate <= 100 && nRate > 0) {
            strTable = "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">";
            strTable = String.valueOf(strTable) + "<tr height='13'>";
            strTable = String.valueOf(strTable) + "<td width=\"100%\" align='center'><span class='sx-normaltext'>" + nRate.toString() + "%" + "</span></td>";
            strTable = String.valueOf(strTable) + "</tr>";
            strTable = String.valueOf(strTable) + "<tr height='5'>";
            strTable = String.valueOf(strTable) + "<td width=\"100%\">";
            strTable = String.valueOf(strTable) + "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">";
            strTable = String.valueOf(strTable) + "<tr height='5'>";
            strTable = String.valueOf(strTable) + "<td width=\"" + nRate.toString() + "%\" bgcolor=\"blue\"  ></td>";
            strTable = String.valueOf(strTable) + "<td width=\"" + nFRage.toString() + "%\" bgcolor=\"lightblue\" ></td>";
            strTable = String.valueOf(strTable) + "</tr>";
            strTable = String.valueOf(strTable) + "</table>";
            strTable = String.valueOf(strTable) + "</td>";
            strTable = String.valueOf(strTable) + "</tr>";
            strTable = String.valueOf(strTable) + "</table>";
        } else {
            strTable = "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">";
            strTable = String.valueOf(strTable) + "<tr height='13'>";
            strTable = String.valueOf(strTable) + "<td width=\"100%\" align='center'><span class='sx-normaltext'>" + nRate.toString() + "%" + "</span></td>";
            strTable = String.valueOf(strTable) + "</tr>";
            strTable = String.valueOf(strTable) + "<tr height='5'>";
            strTable = String.valueOf(strTable) + "<td width=\"100%\" bgcolor=\"blue\"  ></td>";
            strTable = String.valueOf(strTable) + "</tr>";
            strTable = String.valueOf(strTable) + "</table>";
        }
        return strTable;
    }
}

