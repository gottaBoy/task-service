/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  jxl.Workbook
 *  jxl.write.Label
 *  jxl.write.WritableCell
 *  jxl.write.WritableSheet
 *  jxl.write.WritableWorkbook
 */
package net.ibizsys.paas.util;

import java.io.File;
import java.util.Iterator;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import net.ibizsys.paas.control.grid.IGridColumn;
import net.ibizsys.paas.core.IDEDataExportItem;
import net.ibizsys.paas.ctrlmodel.IGridModel;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.demodel.IDEDataExportModel;
import net.ibizsys.paas.web.IWebContext;

public class DEDataExportHelper {
    public static void output(String strFile, IDataTable dt, IGridModel iGridModel, IWebContext iWebContext, boolean bEnableItemPrivilege) throws Exception {
        Iterator<IGridColumn> gridColumns = iGridModel.getGridColumns();
        WritableWorkbook workbook = Workbook.createWorkbook((File)new File(strFile));
        WritableSheet s1 = workbook.createSheet("\u6570\u636e", 0);
        int nRowIndex = 0;
        int nColumnIndex = 0;
        while (gridColumns.hasNext()) {
            IGridColumn iGridColumn = gridColumns.next();
            Label l = new Label(nColumnIndex, nRowIndex, iGridColumn.getExcelCaption());
            s1.addCell((WritableCell)l);
            s1.setColumnView(nColumnIndex, 30);
            ++nColumnIndex;
        }
        ++nRowIndex;
        if (dt.getCachedRowCount() == -1) {
            IDataRow iDataRow;
            while ((iDataRow = dt.next()) != null) {
                nColumnIndex = 0;
                gridColumns = iGridModel.getGridColumns();
                while (gridColumns.hasNext()) {
                    IGridColumn iGridColumn = gridColumns.next();
                    String strCellValue = iGridModel.getColumnExcelText(iGridColumn, iWebContext, iDataRow, bEnableItemPrivilege);
                    Label l = new Label(nColumnIndex, nRowIndex, strCellValue);
                    s1.addCell((WritableCell)l);
                    ++nColumnIndex;
                }
                ++nRowIndex;
            }
        } else {
            int nRows = dt.getCachedRowCount();
            int i = 0;
            while (i < nRows) {
                IDataRow iDataRow = dt.getCachedRow(i);
                nColumnIndex = 0;
                gridColumns = iGridModel.getGridColumns();
                while (gridColumns.hasNext()) {
                    IGridColumn iGridColumn = gridColumns.next();
                    String strCellValue = iGridModel.getColumnExcelText(iGridColumn, iWebContext, iDataRow, bEnableItemPrivilege);
                    Label l = new Label(nColumnIndex, nRowIndex, strCellValue);
                    s1.addCell((WritableCell)l);
                    ++nColumnIndex;
                }
                ++nRowIndex;
                ++i;
            }
        }
        workbook.write();
        workbook.close();
    }

    public static void output(String strFile, IDataTable dt, IDEDataExportModel iDEDataExportModel, IWebContext iWebContext, boolean bEnableItemPrivilege) throws Exception {
        Iterator<IDEDataExportItem> deDataExportItems = iDEDataExportModel.getDEDataExportItems();
        WritableWorkbook workbook = Workbook.createWorkbook((File)new File(strFile));
        WritableSheet s1 = workbook.createSheet("\u6570\u636e", 0);
        int nRowIndex = 0;
        int nColumnIndex = 0;
        while (deDataExportItems.hasNext()) {
            IDEDataExportItem iDEDataExportItem = deDataExportItems.next();
            Label l = new Label(nColumnIndex, nRowIndex, iDEDataExportItem.getCaption());
            s1.addCell((WritableCell)l);
            s1.setColumnView(nColumnIndex, 30);
            ++nColumnIndex;
        }
        ++nRowIndex;
        if (dt.getCachedRowCount() == -1) {
            IDataRow iDataRow;
            while ((iDataRow = dt.next()) != null) {
                nColumnIndex = 0;
                deDataExportItems = iDEDataExportModel.getDEDataExportItems();
                while (deDataExportItems.hasNext()) {
                    IDEDataExportItem iDEDataExportItem = deDataExportItems.next();
                    String strCellValue = iDEDataExportModel.getItemText(iDEDataExportItem, iWebContext, iDataRow, bEnableItemPrivilege);
                    Label l = new Label(nColumnIndex, nRowIndex, strCellValue);
                    s1.addCell((WritableCell)l);
                    ++nColumnIndex;
                }
                ++nRowIndex;
            }
        } else {
            int nRows = dt.getCachedRowCount();
            int i = 0;
            while (i < nRows) {
                IDataRow iDataRow = dt.getCachedRow(i);
                nColumnIndex = 0;
                deDataExportItems = iDEDataExportModel.getDEDataExportItems();
                while (deDataExportItems.hasNext()) {
                    IDEDataExportItem iDEDataExportItem = deDataExportItems.next();
                    String strCellValue = iDEDataExportModel.getItemText(iDEDataExportItem, iWebContext, iDataRow, bEnableItemPrivilege);
                    Label l = new Label(nColumnIndex, nRowIndex, strCellValue);
                    s1.addCell((WritableCell)l);
                    ++nColumnIndex;
                }
                ++nRowIndex;
                ++i;
            }
        }
        workbook.write();
        workbook.close();
    }
}

