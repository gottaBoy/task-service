/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jdom.Content
 *  org.jdom.Element
 */
package SA.SRFramework.Data;

import SA.SRFramework.Data.DataColumn;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Utility.Base64;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import org.jdom.Content;
import org.jdom.Element;

public class DataExportHelper {
    public static String TAG_DATATABLE = "DATATABLE";
    public static String TAG_DATAROW = "DATAROW";
    public static String TAG_FIELD = "FIELD";
    public static String TAG_NAME = "NAME";
    public static String TAG_VALUE = "VALUE";
    public static String TAG_ISNULL = "ISNULL";

    public static Element ExportDataTable(DataTable dataTable) throws Exception {
        Element dataTableElement = new Element(TAG_DATATABLE);
        int nRowCount = dataTable.GetRowCount();
        int i = 0;
        while (i < nRowCount) {
            DataRow dr = dataTable.GetRow(i);
            Element dataRowElement = DataExportHelper.ExportDataRow(dataTable, dr);
            if (dataRowElement != null) {
                dataTableElement.addContent((Content)dataRowElement);
            }
            ++i;
        }
        return dataTableElement;
    }

    public static Element ExportDataRow(DataTable dataTable, DataRow dr) throws Exception {
        Element dataRowElement = new Element(TAG_DATAROW);
        int nColumnCount = dataTable.GetColumnCount();
        int i = 0;
        while (i < nColumnCount) {
            DataColumn dataColumn = dataTable.GetDataColumn(i);
            Element fieldElement = new Element(TAG_FIELD);
            fieldElement.setAttribute(TAG_NAME, dataColumn.getName().toUpperCase());
            if (dr.IsDBNull(dataColumn.getName())) {
                fieldElement.setAttribute(TAG_ISNULL, "TRUE");
            } else {
                Object objValue = dr.Get(dataColumn.getName());
                if (objValue == null) {
                    fieldElement.setAttribute(TAG_ISNULL, "TRUE");
                } else {
                    fieldElement.setAttribute(TAG_ISNULL, "false");
                    try {
                        ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
                        ObjectOutputStream objOutput = new ObjectOutputStream(byteOutputStream);
                        objOutput.writeObject(objValue);
                        objOutput.flush();
                        objOutput.close();
                        String strOutput = Base64.encodeBytes(byteOutputStream.toByteArray(), 2);
                        fieldElement.setAttribute(TAG_VALUE, strOutput);
                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
            dataRowElement.addContent((Content)fieldElement);
            ++i;
        }
        return dataRowElement;
    }
}

