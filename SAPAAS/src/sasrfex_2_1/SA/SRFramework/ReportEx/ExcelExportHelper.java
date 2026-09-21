/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.DataTable
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Utility.StringHelper
 *  jxl.Cell
 *  jxl.CellFeatures
 *  jxl.CellView
 *  jxl.Range
 *  jxl.Sheet
 *  jxl.Workbook
 *  jxl.format.CellFormat
 *  jxl.write.Blank
 *  jxl.write.Formula
 *  jxl.write.Label
 *  jxl.write.Number
 *  jxl.write.WritableCell
 *  jxl.write.WritableCellFeatures
 *  jxl.write.WritableCellFormat
 *  jxl.write.WritableSheet
 */
package SA.SRFramework.ReportEx;

import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.ReportEx.ExcelExportContext;
import SA.SRFramework.ReportEx.ExcelWorkbook;
import SA.SRFramework.ReportEx.Model.ExcelCellType;
import SA.SRFramework.ReportEx.Model.FormExcelExportConfig;
import SA.SRFramework.ReportEx.Model.FormExcelExportItemConfig;
import SA.SRFramework.ReportEx.Model.GridExcelExportColumnConfig;
import SA.SRFramework.ReportEx.Model.GridExcelExportColumnsConfig;
import SA.SRFramework.ReportEx.Model.GridExcelExportConfig;
import SA.SRFramework.ReportEx.Model.GridExcelExportGroupBottomConfig;
import SA.SRFramework.ReportEx.Model.GridExcelExportGroupBottomItemConfig;
import SA.SRFramework.ReportEx.Model.GridExcelExportGroupConfig;
import SA.SRFramework.ReportEx.Model.GridExcelExportGroupHeaderConfig;
import SA.SRFramework.ReportEx.Model.GridExcelExportGroupHeaderItemConfig;
import SA.SRFramework.ReportEx.Model.GridExcelExportGroupsConfig;
import SA.SRFramework.ReportEx.SRFCellFuncHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExWebContext;
import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.TreeMap;
import jxl.Cell;
import jxl.CellFeatures;
import jxl.CellView;
import jxl.Range;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.CellFormat;
import jxl.write.Blank;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCell;
import jxl.write.WritableCellFeatures;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;

public class ExcelExportHelper {
    public static final int MAXSHEETCOUNT = 20;

    public static boolean Export(ExcelWorkbook excelWorkbook, SRFExWebContext webContext, FormExcelExportConfig formExcelExportConfig, DataTable dataTable, String strSheetNameField, int nStartRow, int nStartColumn) {
        ArrayList<BaseDataEntity> arrs = new ArrayList<BaseDataEntity>();
        int nRowCount = dataTable.GetRowCount();
        int i = 0;
        while (i < nRowCount) {
            try {
                DataRow dr = dataTable.GetRow(i);
                BaseDataEntity dataEntity = new BaseDataEntity();
                dataEntity.FromDataRow(dr);
                arrs.add(dataEntity);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
            ++i;
        }
        return ExcelExportHelper.Export(excelWorkbook, webContext, formExcelExportConfig, arrs, strSheetNameField, nStartRow, nStartColumn);
    }

    public static boolean Export(ExcelWorkbook excelWorkbook, SRFExWebContext webContext, FormExcelExportConfig formExcelExportConfig, ArrayList dataEntities, String strSheetNameField, int nStartRow, int nStartColumn) {
        int nCount;
        Workbook srcExcelWorkbook = null;
        Sheet srcWorkbookSheet = null;
        try {
            String strTemplatePath = formExcelExportConfig.getTemplate();
            if (StringHelper.Length((String)strTemplatePath) != 0 && (srcExcelWorkbook = Workbook.getWorkbook((File)new File(strTemplatePath))) != null && srcExcelWorkbook.getSheets().length > 0) {
                srcWorkbookSheet = srcExcelWorkbook.getSheet(0);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        if ((nCount = dataEntities.size()) > 20) {
            nCount = 20;
        }
        int i = 0;
        while (i < nCount) {
            BaseDataEntity dataEntity;
            String strSheetName;
            WritableSheet writableSheet;
            Object objEntity = dataEntities.get(i);
            if (objEntity instanceof BaseDataEntity && (writableSheet = excelWorkbook.getWritableSheet(strSheetName = (dataEntity = (BaseDataEntity)objEntity).GetParamStringValue(strSheetNameField, StringHelper.Format((String)"\u8868\u5355_%1$s", (Object)i)))) != null) {
                ExcelExportHelper.Export(writableSheet, srcWorkbookSheet, webContext, formExcelExportConfig, dataEntity, nStartRow, nStartColumn);
            }
            ++i;
        }
        if (srcExcelWorkbook != null) {
            srcWorkbookSheet = null;
            srcExcelWorkbook.close();
            srcExcelWorkbook = null;
        }
        return true;
    }

    public static boolean Export(ExcelWorkbook excelWorkbook, String strSheetName, SRFExWebContext webContext, FormExcelExportConfig formExcelExportConfig, BaseDataEntity dataEntity, int nStartRow, int nStartColumn) {
        WritableSheet writableSheet;
        if (StringHelper.Length((String)strSheetName) == 0) {
            strSheetName = formExcelExportConfig.getSheetName();
        }
        Workbook srcExcelWorkbook = null;
        Sheet srcWorkbookSheet = null;
        try {
            String strTemplatePath = formExcelExportConfig.getTemplate();
            if (StringHelper.Length((String)strTemplatePath) != 0 && (srcExcelWorkbook = Workbook.getWorkbook((File)new File(strTemplatePath))) != null && srcExcelWorkbook.getSheets().length > 0) {
                srcWorkbookSheet = srcExcelWorkbook.getSheet(0);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        if ((writableSheet = excelWorkbook.getWritableSheet(strSheetName)) == null) {
            return false;
        }
        boolean bRet = ExcelExportHelper.Export(writableSheet, srcWorkbookSheet, webContext, formExcelExportConfig, dataEntity, nStartRow, nStartColumn);
        if (srcExcelWorkbook != null) {
            srcWorkbookSheet = null;
            srcExcelWorkbook.close();
            srcExcelWorkbook = null;
        }
        return bRet;
    }

    public static boolean Export(WritableSheet writableSheet, Sheet srcWorkbookSheet, SRFExWebContext webContext, FormExcelExportConfig formExcelExportConfig, BaseDataEntity dataEntity) {
        return ExcelExportHelper.Export(writableSheet, srcWorkbookSheet, webContext, formExcelExportConfig, dataEntity, 0, 0);
    }

    public static boolean Export(WritableSheet writableSheet, Sheet srcWorkbookSheet, SRFExWebContext webContext, FormExcelExportConfig formExcelExportConfig, BaseDataEntity dataEntity, int nStartRow, int nStartColumn) {
        int nTemplateRow = formExcelExportConfig.getTemplateRow();
        int nTemplateRowCount = formExcelExportConfig.getTemplateRowCount();
        int nTemplateColumn = formExcelExportConfig.getTemplateColumn();
        int nTemplateColumnCount = formExcelExportConfig.getTemplateColumnCount();
        if (srcWorkbookSheet != null) {
            ExcelExportHelper.CopyExcelWorkSheetRows(writableSheet, srcWorkbookSheet, nStartRow, nStartColumn, nTemplateRow, nTemplateRowCount, nTemplateColumn, nTemplateColumnCount, true);
        }
        try {
            ArrayList list = formExcelExportConfig.getList();
            int i = 0;
            while (i < list.size()) {
                FormExcelExportItemConfig formExcelExportItemConfig = (FormExcelExportItemConfig)((Object)list.get(i));
                String strValue = formExcelExportItemConfig.GetItemValue(webContext, dataEntity);
                int nRowId = formExcelExportItemConfig.getRow() + nStartRow;
                int nColumnId = formExcelExportItemConfig.getColumn() + nStartColumn;
                try {
                    WritableCell writableCell = writableSheet.getWritableCell(nColumnId, nRowId);
                    if (writableCell != null) {
                        if (formExcelExportItemConfig.getCellType() == 4) {
                            CellFormat cellFormat = writableCell.getCellFormat();
                            writableCell = new Formula(nColumnId, nRowId, strValue);
                            writableCell.setCellFormat(cellFormat);
                            try {
                                writableSheet.addCell(writableCell);
                            }
                            catch (RuntimeException e) {
                                System.out.println(strValue);
                                e.printStackTrace();
                            }
                        } else {
                            ExcelExportHelper.SetWritableCellValue(writableCell, strValue);
                        }
                    }
                    if (formExcelExportItemConfig.getColumnCount() > 1 || formExcelExportItemConfig.getRowCount() > 1) {
                        writableSheet.mergeCells(nColumnId, nRowId, nColumnId + formExcelExportItemConfig.getColumnCount() - 1, nRowId + formExcelExportItemConfig.getRowCount() - 1);
                    }
                }
                catch (Exception exception) {
                    // empty catch block
                }
                ++i;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean Export(ExcelWorkbook excelWorkbook, SRFExWebContext webContext, FormExcelExportConfig formExcelExportConfig, BaseDataEntity dataEntity) {
        return ExcelExportHelper.Export(excelWorkbook, "", webContext, formExcelExportConfig, dataEntity, 0, 0);
    }

    public static boolean Export(WritableSheet writableSheet, Sheet srcWorkbookSheet, SRFExWebContext webContext, GridExcelExportConfig gridExcelExportConfig, DataTable dataTable, int nStartRow, int nStartColumn, boolean bReplace) {
        if (writableSheet == null || srcWorkbookSheet == null || webContext == null || dataTable == null || gridExcelExportConfig == null) {
            return false;
        }
        SRFCellFuncHelper cellFuncHelper = new SRFCellFuncHelper();
        cellFuncHelper.setStartRow(nStartRow);
        cellFuncHelper.setStartColumn(nStartColumn);
        cellFuncHelper.setIsGroup(false);
        GridExcelExportColumnsConfig gridExcelExportColumnsConfig = gridExcelExportConfig.getColumnsConfig();
        if (gridExcelExportColumnsConfig == null) {
            return false;
        }
        int nGridCellCount = 0;
        int nStartCellIndex = 0;
        int i = 0;
        while (i < gridExcelExportColumnsConfig.getList().size()) {
            GridExcelExportColumnConfig gridExcelExportColumnConfig = (GridExcelExportColumnConfig)((Object)gridExcelExportColumnsConfig.getList().get(i));
            if (gridExcelExportColumnConfig != null) {
                cellFuncHelper.SetCellIndex(gridExcelExportColumnConfig.getID(), nStartCellIndex);
                nStartCellIndex += gridExcelExportColumnConfig.getColumnCount();
            }
            ++i;
        }
        nGridCellCount = nStartCellIndex;
        int nCurRow = nStartRow;
        int nCurColumn = nStartColumn;
        if (gridExcelExportConfig.getShowHeader()) {
            if (!bReplace) {
                writableSheet.insertRow(nCurRow);
            }
            if (srcWorkbookSheet != null) {
                ExcelExportHelper.CopyExcelWorkSheetRows(writableSheet, srcWorkbookSheet, nCurRow, nStartColumn, gridExcelExportConfig.getHeaderTemplateRow(), 1, 0, nGridCellCount, true);
            }
            nStartCellIndex = 0;
            int i2 = 0;
            while (i2 < gridExcelExportColumnsConfig.getList().size()) {
                block19: {
                    GridExcelExportColumnConfig gridExcelExportColumnConfig = (GridExcelExportColumnConfig)((Object)gridExcelExportColumnsConfig.getList().get(i2));
                    if (gridExcelExportColumnConfig != null) {
                        block18: {
                            try {
                                WritableCell writableCell;
                                CellFeatures cellFeatures = null;
                                CellFormat cellFormat = null;
                                Cell srcCell = null;
                                if (srcWorkbookSheet != null && (srcCell = srcWorkbookSheet.getCell(nStartCellIndex, gridExcelExportConfig.getHeaderTemplateRow())) != null) {
                                    cellFeatures = srcCell.getCellFeatures();
                                    cellFormat = srcCell.getCellFormat();
                                }
                                if ((writableCell = ExcelExportHelper.GetCell(null, nCurColumn, nCurRow, gridExcelExportColumnConfig.getCaption(), 1, cellFormat, cellFeatures, null)) != null) {
                                    writableSheet.addCell(writableCell);
                                }
                                if (gridExcelExportColumnConfig.getColumnCount() <= 1) break block18;
                                writableSheet.mergeCells(nCurColumn, nCurRow, nCurColumn + gridExcelExportColumnConfig.getColumnCount() - 1, nCurRow);
                            }
                            catch (Exception ex) {
                                ex.printStackTrace();
                                break block19;
                            }
                        }
                        nStartCellIndex += gridExcelExportColumnConfig.getColumnCount();
                        nCurColumn += gridExcelExportColumnConfig.getColumnCount();
                    }
                }
                ++i2;
            }
            ++nCurRow;
            nCurColumn = nStartColumn;
        }
        ArrayList<DataRow> rows = new ArrayList<DataRow>();
        int i3 = 0;
        while (i3 < dataTable.GetRowCount()) {
            rows.add(dataTable.GetRow(i3));
            ++i3;
        }
        GridExcelExportGroupConfig rootGridExcelExportGroupConfig = null;
        GridExcelExportGroupConfig parentGridExcelExportGroupConfig = null;
        GridExcelExportGroupsConfig gridExcelExportGroupsConfig = gridExcelExportConfig.getGroupsConfig();
        if (gridExcelExportGroupsConfig != null) {
            int nGroupCount = gridExcelExportGroupsConfig.getList().size();
            int i4 = 0;
            while (i4 < nGroupCount) {
                GridExcelExportGroupConfig tempGridExcelExportGroupConfig = (GridExcelExportGroupConfig)((Object)gridExcelExportGroupsConfig.getList().get(i4));
                if (rootGridExcelExportGroupConfig == null) {
                    parentGridExcelExportGroupConfig = rootGridExcelExportGroupConfig = tempGridExcelExportGroupConfig;
                } else {
                    parentGridExcelExportGroupConfig.setChildGroupConfig(tempGridExcelExportGroupConfig);
                    parentGridExcelExportGroupConfig = tempGridExcelExportGroupConfig;
                }
                ++i4;
            }
        }
        ExcelExportContext context = new ExcelExportContext();
        context.setStartRow(nStartRow);
        context.setStartColumn(nStartColumn);
        context.setCurRow(nCurRow);
        context.setCurColumn(nCurColumn);
        context.setReplace(bReplace);
        Hashtable styleMap = new Hashtable();
        context.setParam("STYLEMAP", styleMap);
        context.setParam("GRIDCELLCOUNT", nGridCellCount);
        return ExcelExportHelper.ExportDataGridGroupData(context, cellFuncHelper, null, rootGridExcelExportGroupConfig, writableSheet, srcWorkbookSheet, webContext, gridExcelExportConfig, rows, nCurRow, nCurColumn, bReplace);
    }

    public static boolean Export(ExcelWorkbook excelWorkbook, SRFExWebContext webContext, GridExcelExportConfig gridExcelExportConfig, DataTable dataTable, int nStartRow, int nStartColumn, boolean bReplace) {
        String strSheetName;
        WritableSheet writableSheet;
        if (excelWorkbook == null || webContext == null || dataTable == null || gridExcelExportConfig == null) {
            return false;
        }
        Workbook srcExcelWorkbook = null;
        Sheet srcWorkbookSheet = null;
        try {
            String strTemplatePath = gridExcelExportConfig.getTemplate();
            if (StringHelper.Length((String)strTemplatePath) != 0 && (srcExcelWorkbook = Workbook.getWorkbook((File)new File(strTemplatePath))) != null && srcExcelWorkbook.getSheets().length > 0) {
                srcWorkbookSheet = srcExcelWorkbook.getSheet(0);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        if ((writableSheet = excelWorkbook.getWritableSheet(strSheetName = gridExcelExportConfig.getSheetName())) == null) {
            if (srcExcelWorkbook != null) {
                srcWorkbookSheet = null;
                srcExcelWorkbook.close();
                srcExcelWorkbook = null;
            }
            return false;
        }
        boolean bRet = ExcelExportHelper.Export(writableSheet, srcWorkbookSheet, webContext, gridExcelExportConfig, dataTable, nStartRow, nStartColumn, bReplace);
        if (srcExcelWorkbook != null) {
            srcWorkbookSheet = null;
            srcExcelWorkbook.close();
            srcExcelWorkbook = null;
        }
        return bRet;
    }

    protected static boolean ExportDataGridGroupData(ExcelExportContext context, SRFCellFuncHelper cellFuncHelper, GridExcelExportGroupConfig curGridExcelExportGroupConfig, GridExcelExportGroupConfig gridExcelExportGroupConfig, WritableSheet writableSheet, Sheet srcWorkbookSheet, SRFExWebContext webContext, GridExcelExportConfig gridExcelExportConfig, ArrayList rows, int nStartRow, int nStartColumn, boolean bReplace) {
        GridExcelExportGroupBottomConfig gridExcelExportGroupBottomConfig;
        GridExcelExportGroupHeaderConfig gridExcelExportGroupHeaderConfig;
        if (rows.size() == 0) {
            return true;
        }
        String strGroupField = "";
        boolean bSortAsc = true;
        if (gridExcelExportGroupConfig != null) {
            strGroupField = gridExcelExportGroupConfig.getDBField();
            bSortAsc = StringHelper.Compare((String)gridExcelExportGroupConfig.getSortDirection(), (String)"ASC", (boolean)true) == 0;
        }
        Hashtable styleMap = null;
        Object objStyleMap = context.getParam("STYLEMAP");
        if (objStyleMap != null) {
            styleMap = (Hashtable)objStyleMap;
        }
        int nGridCellCount = (Integer)context.getParam("GRIDCELLCOUNT");
        ArrayList<DataRow> defaultList = new ArrayList<DataRow>();
        ArrayList<Object> list = new ArrayList<Object>();
        if (StringHelper.Length((String)strGroupField) == 0) {
            defaultList.addAll(rows);
            list.add(defaultList);
        } else {
            TreeMap<String, ArrayList> strMap = new TreeMap<String, ArrayList>();
            TreeMap<Integer, ArrayList> intMap = new TreeMap<Integer, ArrayList>();
            TreeMap doubleMap = new TreeMap();
            TreeMap dateMap = new TreeMap();
            int nRowCount = rows.size();
            int i = 0;
            while (i < nRowCount) {
                block71: {
                    DataRow dr = (DataRow)rows.get(i);
                    Object objValue = null;
                    try {
                        if (!dr.IsDBNull(strGroupField)) {
                            ArrayList groupList;
                            objValue = dr.Get(strGroupField);
                            if (DataTypeHelper.IsStringType((int)gridExcelExportGroupConfig.getDataType())) {
                                String strValue = (String)objValue;
                                if (!StringHelper.IsNullOrEmpty((String)gridExcelExportGroupConfig.getGroupExt()) && StringHelper.Compare((String)gridExcelExportGroupConfig.getGroupExt(), (String)"TENDAYS", (boolean)true) == 0) {
                                    try {
                                        int nValue = Integer.parseInt(strValue);
                                        if (nValue > 0 && nValue <= 10) {
                                            strValue = "01~10\u53f7";
                                        }
                                        if (nValue > 10 && nValue <= 20) {
                                            strValue = "11~20\u53f7";
                                        }
                                        if (nValue > 20 && nValue <= 31) {
                                            strValue = "21~31\u53f7";
                                        }
                                    }
                                    catch (Exception ex) {
                                        ex.printStackTrace();
                                    }
                                }
                                groupList = null;
                                if (strMap.containsKey(strValue)) {
                                    groupList = (ArrayList)strMap.get(strValue);
                                } else {
                                    groupList = new ArrayList();
                                    strMap.put(strValue, groupList);
                                }
                                groupList.add(dr);
                                break block71;
                            }
                            if (DataTypeHelper.IsIntType((int)gridExcelExportGroupConfig.getDataType())) {
                                int nValue = Integer.parseInt(objValue.toString());
                                if (!StringHelper.IsNullOrEmpty((String)gridExcelExportGroupConfig.getGroupExt()) && StringHelper.Compare((String)gridExcelExportGroupConfig.getGroupExt(), (String)"TENDAYS", (boolean)true) == 0) {
                                    if (nValue > 0 && nValue <= 10) {
                                        nValue = 1;
                                    }
                                    if (nValue > 10 && nValue <= 20) {
                                        nValue = 2;
                                    }
                                    if (nValue > 20 && nValue <= 31) {
                                        nValue = 3;
                                    }
                                }
                                groupList = null;
                                if (intMap.containsKey(nValue)) {
                                    groupList = (ArrayList)intMap.get(nValue);
                                } else {
                                    groupList = new ArrayList();
                                    intMap.put(nValue, groupList);
                                }
                                groupList.add(dr);
                            }
                            break block71;
                        }
                        defaultList.add(dr);
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                ++i;
            }
            if (bSortAsc) {
                list.add(defaultList);
                if (DataTypeHelper.IsStringType((int)gridExcelExportGroupConfig.getDataType())) {
                    Object[] arr = strMap.values().toArray();
                    int i2 = 0;
                    while (i2 < arr.length) {
                        list.add(arr[i2]);
                        ++i2;
                    }
                }
                if (DataTypeHelper.IsIntType((int)gridExcelExportGroupConfig.getDataType())) {
                    Object[] arr = intMap.values().toArray();
                    int i3 = 0;
                    while (i3 < arr.length) {
                        list.add(arr[i3]);
                        ++i3;
                    }
                }
            } else {
                if (DataTypeHelper.IsStringType((int)gridExcelExportGroupConfig.getDataType())) {
                    Object[] arr = strMap.values().toArray();
                    int i4 = 0;
                    while (i4 < arr.length) {
                        list.add(0, arr[i4]);
                        ++i4;
                    }
                }
                if (DataTypeHelper.IsIntType((int)gridExcelExportGroupConfig.getDataType())) {
                    Object[] arr = intMap.values().toArray();
                    int i5 = 0;
                    while (i5 < arr.length) {
                        list.add(0, arr[i5]);
                        ++i5;
                    }
                }
                list.add(defaultList);
            }
        }
        int nCurColumn = context.getStartColumn();
        int nCurRow = context.getCurRow();
        if (curGridExcelExportGroupConfig != null && (gridExcelExportGroupHeaderConfig = curGridExcelExportGroupConfig.getHeaderConfig()) != null) {
            cellFuncHelper.setIsGroup(true);
            nCurColumn = context.getStartColumn();
            int nHeaderStartRow = nCurRow;
            int nHeaderStartColumn = context.getStartColumn();
            int nHeaderRowCount = gridExcelExportGroupHeaderConfig.getRowCount();
            if (nHeaderRowCount >= 1) {
                try {
                    if (!context.getReplace()) {
                        int k = 0;
                        while (k < nHeaderRowCount) {
                            writableSheet.insertRow(nHeaderStartRow + k);
                            ++k;
                        }
                    }
                    int nTemplateRow = gridExcelExportGroupHeaderConfig.getTemplateRow();
                    if (srcWorkbookSheet != null) {
                        ExcelExportHelper.CopyExcelWorkSheetRows(writableSheet, srcWorkbookSheet, nHeaderStartRow, nHeaderStartColumn, nTemplateRow, nHeaderRowCount, 0, nGridCellCount, false);
                    }
                    int nHeaderItemCount = gridExcelExportGroupHeaderConfig.getList().size();
                    int k = 0;
                    while (k < nHeaderItemCount) {
                        WritableCell writableCell;
                        GridExcelExportGroupHeaderItemConfig gridExcelExportGroupHeaderItemConfig = (GridExcelExportGroupHeaderItemConfig)((Object)gridExcelExportGroupHeaderConfig.getList().get(k));
                        String strValue = gridExcelExportGroupHeaderItemConfig.GetItemValue(webContext, (DataRow)rows.get(0));
                        int nItemColumn = nHeaderStartColumn + gridExcelExportGroupHeaderItemConfig.getColumn();
                        int nItemRow = nHeaderStartRow + gridExcelExportGroupHeaderItemConfig.getRow();
                        CellFeatures cellFeatures = null;
                        CellFormat cellFormat = null;
                        Cell srcCell = null;
                        if (srcWorkbookSheet != null && (srcCell = srcWorkbookSheet.getCell(gridExcelExportGroupHeaderItemConfig.getColumn(), nTemplateRow + gridExcelExportGroupHeaderItemConfig.getRow())) != null) {
                            cellFeatures = srcCell.getCellFeatures();
                            cellFormat = srcCell.getCellFormat();
                        }
                        if ((writableCell = ExcelExportHelper.GetCell(cellFuncHelper, nItemColumn, nItemRow, strValue, gridExcelExportGroupHeaderItemConfig.getCellType(), cellFormat, cellFeatures, styleMap)) != null) {
                            writableSheet.addCell(writableCell);
                        }
                        if (gridExcelExportGroupHeaderItemConfig.getColumnCount() > 1 || gridExcelExportGroupHeaderItemConfig.getRowCount() > 1) {
                            writableSheet.mergeCells(nItemColumn, nItemRow, nItemColumn + gridExcelExportGroupHeaderItemConfig.getColumnCount() - 1, nItemRow + gridExcelExportGroupHeaderItemConfig.getRowCount() - 1);
                        }
                        ++k;
                    }
                    nCurRow += nHeaderRowCount;
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        int nGroupStartRow = nCurRow;
        if (gridExcelExportGroupConfig != null) {
            GridExcelExportGroupConfig childGridExcelExportGroupConfig = gridExcelExportGroupConfig.getChildGroupConfig();
            int i = 0;
            while (i < list.size()) {
                ArrayList groupRows = (ArrayList)list.get(i);
                context.setCurColumn(nStartColumn);
                context.setCurRow(nCurRow);
                ExcelExportHelper.ExportDataGridGroupData(context, cellFuncHelper, gridExcelExportGroupConfig, childGridExcelExportGroupConfig, writableSheet, srcWorkbookSheet, webContext, gridExcelExportConfig, groupRows, nCurRow, nCurColumn, bReplace);
                nCurRow = context.getCurRow();
                nCurColumn = nStartColumn;
                ++i;
            }
            nCurRow = context.getCurRow();
        } else {
            cellFuncHelper.setIsGroup(false);
            int j = 0;
            while (j < rows.size()) {
                writableSheet.insertRow(nCurRow);
                cellFuncHelper.setDataRowIndex(context.getDataRowIndex());
                int nTemplateRow = gridExcelExportConfig.getTemplateRow();
                nCurColumn = context.getStartColumn();
                if (srcWorkbookSheet != null) {
                    ExcelExportHelper.CopyExcelWorkSheetRows(writableSheet, srcWorkbookSheet, nCurRow, nCurColumn, nTemplateRow, 1, 0, nGridCellCount, false);
                }
                try {
                    GridExcelExportColumnsConfig gridExcelExportColumnsConfig = gridExcelExportConfig.getColumnsConfig();
                    DataRow dr = (DataRow)rows.get(j);
                    if (gridExcelExportColumnsConfig != null) {
                        nCurColumn = context.getStartColumn();
                        int nCellIndex = 0;
                        int k = 0;
                        while (k < gridExcelExportColumnsConfig.getList().size()) {
                            block73: {
                                GridExcelExportColumnConfig gridExcelExportColumnConfig = (GridExcelExportColumnConfig)((Object)gridExcelExportColumnsConfig.getList().get(k));
                                if (gridExcelExportColumnConfig != null) {
                                    block72: {
                                        try {
                                            String strValue;
                                            WritableCell writableCell;
                                            CellFeatures cellFeatures = null;
                                            CellFormat cellFormat = null;
                                            Cell srcCell = null;
                                            if (srcWorkbookSheet != null && (srcCell = srcWorkbookSheet.getCell(nCellIndex, nTemplateRow)) != null) {
                                                cellFeatures = srcCell.getCellFeatures();
                                                cellFormat = srcCell.getCellFormat();
                                            }
                                            if ((writableCell = ExcelExportHelper.GetCell(cellFuncHelper, nCurColumn, nCurRow, strValue = gridExcelExportColumnConfig.GetItemValue(webContext, dr), gridExcelExportColumnConfig.getCellType(), cellFormat, cellFeatures, styleMap)) != null) {
                                                writableSheet.addCell(writableCell);
                                            }
                                            if (gridExcelExportColumnConfig.getColumnCount() <= 1) break block72;
                                            writableSheet.mergeCells(nCurColumn, nCurRow, nCurColumn + gridExcelExportColumnConfig.getColumnCount() - 1, nCurRow);
                                        }
                                        catch (Exception ex) {
                                            ex.printStackTrace();
                                            break block73;
                                        }
                                    }
                                    nCurColumn += gridExcelExportColumnConfig.getColumnCount();
                                    nCellIndex += gridExcelExportColumnConfig.getColumnCount();
                                }
                            }
                            ++k;
                        }
                    }
                    ++nCurRow;
                    context.IncreaseDataRowIndex();
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
                ++j;
            }
            cellFuncHelper.setGroup(nGroupStartRow, nCurRow - 1);
        }
        if (curGridExcelExportGroupConfig != null && (gridExcelExportGroupBottomConfig = curGridExcelExportGroupConfig.getBottomConfig()) != null) {
            cellFuncHelper.setIsGroup(true);
            cellFuncHelper.setStartGroupRow(nGroupStartRow);
            cellFuncHelper.setEndGroupRow(nCurRow - 1);
            nCurColumn = context.getStartColumn();
            int nBottomStartRow = nCurRow;
            int nBottomStartColumn = context.getStartColumn();
            int nBottomRowCount = gridExcelExportGroupBottomConfig.getRowCount();
            if (nBottomRowCount >= 1) {
                try {
                    if (!context.getReplace()) {
                        int k = 0;
                        while (k < nBottomRowCount) {
                            writableSheet.insertRow(nBottomStartRow + k);
                            ++k;
                        }
                    }
                    int nTemplateRow = gridExcelExportGroupBottomConfig.getTemplateRow();
                    if (srcWorkbookSheet != null) {
                        ExcelExportHelper.CopyExcelWorkSheetRows(writableSheet, srcWorkbookSheet, nBottomStartRow, nBottomStartColumn, nTemplateRow, nBottomRowCount, 0, nGridCellCount, false);
                    }
                    int nBottomItemCount = gridExcelExportGroupBottomConfig.getList().size();
                    int k = 0;
                    while (k < nBottomItemCount) {
                        WritableCell writableCell;
                        GridExcelExportGroupBottomItemConfig gridExcelExportGroupBottomItemConfig = (GridExcelExportGroupBottomItemConfig)((Object)gridExcelExportGroupBottomConfig.getList().get(k));
                        String strValue = gridExcelExportGroupBottomItemConfig.GetItemValue(webContext, (DataRow)rows.get(0));
                        int nItemColumn = nBottomStartColumn + gridExcelExportGroupBottomItemConfig.getColumn();
                        int nItemRow = nBottomStartRow + gridExcelExportGroupBottomItemConfig.getRow();
                        CellFeatures cellFeatures = null;
                        CellFormat cellFormat = null;
                        Cell srcCell = null;
                        if (srcWorkbookSheet != null && (srcCell = srcWorkbookSheet.getCell(gridExcelExportGroupBottomItemConfig.getColumn(), nTemplateRow + gridExcelExportGroupBottomItemConfig.getRow())) != null) {
                            cellFeatures = srcCell.getCellFeatures();
                            cellFormat = srcCell.getCellFormat();
                        }
                        if ((writableCell = ExcelExportHelper.GetCell(cellFuncHelper, nItemColumn, nItemRow, strValue, gridExcelExportGroupBottomItemConfig.getCellType(), cellFormat, cellFeatures, styleMap)) != null) {
                            writableSheet.addCell(writableCell);
                        }
                        if (gridExcelExportGroupBottomItemConfig.getColumnCount() > 1 || gridExcelExportGroupBottomItemConfig.getRowCount() > 1) {
                            writableSheet.mergeCells(nItemColumn, nItemRow, nItemColumn + gridExcelExportGroupBottomItemConfig.getColumnCount() - 1, nItemRow + gridExcelExportGroupBottomItemConfig.getRowCount() - 1);
                        }
                        ++k;
                    }
                    nCurRow += nBottomRowCount;
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        context.setCurRow(nCurRow);
        return true;
    }

    protected static boolean CopyExcelWorkSheetRows(WritableSheet writableSheet, Sheet srcWorkbookSheet, int nDstStartRow, int nDstStartColumn, int nSrcStartRow, int nRowCount, int nSrcStartColumn, int nColumnCount, boolean bCopyColumnWidth) {
        if (writableSheet == null || srcWorkbookSheet == null) {
            return false;
        }
        try {
            int nTemplateRow = nSrcStartRow;
            int nTemplateRowCount = nRowCount;
            int nTemplateColumn = nSrcStartColumn;
            int nTemplateColumnCount = nColumnCount;
            if (nTemplateColumn + nTemplateColumnCount > srcWorkbookSheet.getColumns()) {
                nTemplateColumnCount = srcWorkbookSheet.getColumns() - nTemplateColumn;
            }
            if (nTemplateRow + nTemplateRowCount > srcWorkbookSheet.getRows()) {
                nTemplateRowCount = srcWorkbookSheet.getRows() - nTemplateRow;
            }
            int i = 0;
            while (i < nTemplateRowCount) {
                CellView srcCellView = srcWorkbookSheet.getRowView(nTemplateRow + i);
                CellView cellView = new CellView(srcCellView);
                cellView.setFormat(null);
                writableSheet.setRowView(nDstStartRow + i, cellView);
                int j = 0;
                while (j < nTemplateColumnCount) {
                    WritableCell writableCell;
                    if (i == 0 && bCopyColumnWidth) {
                        srcCellView = null;
                        cellView = null;
                        srcCellView = srcWorkbookSheet.getColumnView(nTemplateColumn + j);
                        cellView = new CellView(srcCellView);
                        cellView.setFormat(null);
                        writableSheet.setColumnView(nDstStartColumn + j, cellView);
                    }
                    CellFeatures cellFeatures = null;
                    CellFormat cellFormat = null;
                    Cell srcCell = srcWorkbookSheet.getCell(nTemplateColumn + j, nTemplateRow + i);
                    if (srcCell != null) {
                        cellFeatures = srcCell.getCellFeatures();
                        cellFormat = srcCell.getCellFormat();
                    }
                    if ((writableCell = ExcelExportHelper.GetCell(null, nDstStartColumn + j, nDstStartRow + i, srcCell.getContents(), ExcelCellType.Parse(srcCell.getType()), cellFormat, cellFeatures, null)) != null) {
                        writableSheet.addCell(writableCell);
                    }
                    ++j;
                }
                ++i;
            }
            Range[] ranges = srcWorkbookSheet.getMergedCells();
            if (ranges != null && ranges.length > 0) {
                int i2 = 0;
                while (i2 < ranges.length) {
                    Range range = ranges[i2];
                    int nMergeCellLeft = range.getTopLeft().getColumn();
                    int nMergeCellTop = range.getTopLeft().getRow();
                    int nMergeCellRight = range.getBottomRight().getColumn();
                    int nMergeCellBottom = range.getBottomRight().getRow();
                    if (nMergeCellLeft >= nTemplateColumn && nMergeCellLeft <= nTemplateColumn + nTemplateColumnCount && nMergeCellTop >= nTemplateRow && nMergeCellTop <= nTemplateRow + nTemplateRowCount) {
                        int nOffsetLeft = nMergeCellLeft - nSrcStartColumn;
                        int nOffsetTop = nMergeCellTop - nSrcStartRow;
                        int nOffsetLeft2 = nMergeCellRight - nSrcStartColumn;
                        int nOffsetTop2 = nMergeCellBottom - nSrcStartRow;
                        writableSheet.mergeCells(nDstStartColumn + nOffsetLeft, nDstStartRow + nOffsetTop, nDstStartColumn + nOffsetLeft2, nDstStartRow + nOffsetTop2);
                    }
                    ++i2;
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return true;
    }

    protected static WritableCell GetCell(SRFCellFuncHelper cellFuncHelper, int nColumnId, int nRowId, String strValue, int nCellType, CellFormat cellFormat, CellFeatures cellFeatures, Hashtable cellStypeMap) {
        WritableCellFeatures writableCellFeatures = null;
        WritableCellFormat writableCellFormat = null;
        if (cellFeatures != null) {
            if (cellStypeMap != null) {
                if (cellStypeMap.containsKey(cellFeatures)) {
                    writableCellFeatures = (WritableCellFeatures)cellStypeMap.get(cellFeatures);
                } else {
                    writableCellFeatures = new WritableCellFeatures(cellFeatures);
                    cellStypeMap.put(cellFeatures, writableCellFeatures);
                }
            } else {
                writableCellFeatures = new WritableCellFeatures(cellFeatures);
            }
        }
        if (cellFormat != null) {
            if (cellStypeMap != null) {
                if (cellStypeMap.containsKey(cellFormat)) {
                    writableCellFormat = (WritableCellFormat)cellStypeMap.get(cellFormat);
                } else {
                    writableCellFormat = new WritableCellFormat(cellFormat);
                    cellStypeMap.put(cellFormat, writableCellFormat);
                }
            } else {
                writableCellFormat = new WritableCellFormat(cellFormat);
            }
        }
        if (cellFuncHelper != null) {
            cellFuncHelper.setCurColumn(nColumnId);
            cellFuncHelper.setCurRow(nRowId);
            strValue = cellFuncHelper.Parse(strValue);
        }
        switch (nCellType) {
            case 1: {
                Label lable = new Label(nColumnId, nRowId, strValue);
                if (writableCellFeatures != null) {
                    lable.setCellFeatures(writableCellFeatures);
                }
                if (writableCellFormat != null) {
                    lable.setCellFormat((CellFormat)writableCellFormat);
                }
                return lable;
            }
            case 2: {
                if (StringHelper.Length((String)strValue) > 0) {
                    double fValue = Double.parseDouble(strValue);
                    Number number = new Number(nColumnId, nRowId, fValue);
                    if (writableCellFeatures != null) {
                        number.setCellFeatures(writableCellFeatures);
                    }
                    if (writableCellFormat != null) {
                        number.setCellFormat((CellFormat)writableCellFormat);
                    }
                    return number;
                }
            }
            case 4: {
                if (StringHelper.Length((String)strValue) > 0) {
                    Formula formula = new Formula(nColumnId, nRowId, strValue);
                    if (writableCellFeatures != null) {
                        formula.setCellFeatures(writableCellFeatures);
                    }
                    if (writableCellFormat != null) {
                        formula.setCellFormat((CellFormat)writableCellFormat);
                    }
                    return formula;
                }
            }
            case 5: {
                Blank blank = new Blank(nColumnId, nRowId);
                if (writableCellFeatures != null) {
                    blank.setCellFeatures(writableCellFeatures);
                }
                if (writableCellFormat != null) {
                    blank.setCellFormat((CellFormat)writableCellFormat);
                }
                return blank;
            }
        }
        return null;
    }

    protected static void SetWritableCellValue(WritableCell writableCell, String strValue) {
        if (StringHelper.Length((String)strValue) == 0) {
            return;
        }
        if (writableCell instanceof Label) {
            Label label = (Label)writableCell;
            label.setString(strValue);
            return;
        }
        if (writableCell instanceof Number) {
            Number number = (Number)writableCell;
            number.setValue(Double.parseDouble(strValue));
            return;
        }
    }

    public static boolean Export(ExcelWorkbook excelWorkbook, SRFExWebContext webContext, GridExcelExportConfig gridExcelExportConfig, DataTable dataTable, int nStartRow, int nStartColumn) {
        return ExcelExportHelper.Export(excelWorkbook, webContext, gridExcelExportConfig, dataTable, nStartRow, nStartColumn, false);
    }

    public static boolean Export(ExcelWorkbook excelWorkbook, SRFExWebContext webContext, GridExcelExportConfig gridExcelExportConfig, DataTable dataTable) {
        return ExcelExportHelper.Export(excelWorkbook, webContext, gridExcelExportConfig, dataTable, 0, 0);
    }
}

