/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.DataTable
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.poi.hssf.usermodel.HSSFCell
 *  org.apache.poi.hssf.usermodel.HSSFCellStyle
 *  org.apache.poi.hssf.usermodel.HSSFRichTextString
 *  org.apache.poi.hssf.usermodel.HSSFRow
 *  org.apache.poi.hssf.usermodel.HSSFSheet
 *  org.apache.poi.hssf.usermodel.HSSFWorkbook
 *  org.apache.poi.ss.usermodel.RichTextString
 */
package SA.SRFramework.ReportEx;

import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.ReportEx.ExcelExportContext;
import SA.SRFramework.ReportEx.ExcelWorkbookEx;
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
import SA.SRFramework.WebEx.Utility.ContextHelper;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.TreeMap;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.RichTextString;

public class ExcelExportHelperEx {
    public static final int MAXSHEETCOUNT = 20;

    public static boolean Export(ExcelWorkbookEx excelWorkbook, SRFExWebContext webContext, FormExcelExportConfig formExcelExportConfig, DataTable dataTable, String strSheetNameField, int nStartRow, int nStartColumn) {
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
        return ExcelExportHelperEx.Export(excelWorkbook, webContext, formExcelExportConfig, arrs, strSheetNameField, nStartRow, nStartColumn);
    }

    public static boolean Export(ExcelWorkbookEx excelWorkbook, ContextHelper contextHelper, FormExcelExportConfig formExcelExportConfig, ArrayList dataEntities, String strSheetNameField, int nStartRow, int nStartColumn) {
        int nCount;
        HSSFWorkbook srcExcelWorkbook = null;
        HSSFSheet srcWorkbookSheet = null;
        try {
            FileInputStream inputStream;
            String strTemplatePath = formExcelExportConfig.getTemplate();
            if (StringHelper.Length((String)strTemplatePath) != 0 && (srcExcelWorkbook = new HSSFWorkbook((InputStream)(inputStream = new FileInputStream(strTemplatePath)))) != null && srcExcelWorkbook.getNumberOfSheets() > 0) {
                srcWorkbookSheet = srcExcelWorkbook.getSheetAt(0);
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
            HSSFSheet writableSheet;
            Object objEntity = dataEntities.get(i);
            if (objEntity instanceof BaseDataEntity && (writableSheet = excelWorkbook.getHSSfSheetByName(strSheetName = (dataEntity = (BaseDataEntity)objEntity).GetParamStringValue(strSheetNameField, StringHelper.Format((String)"\u8868\u5355_%1$s", (Object)i)))) != null) {
                ExcelExportHelperEx.Export(writableSheet, srcWorkbookSheet, contextHelper, formExcelExportConfig, dataEntity, nStartRow, nStartColumn);
            }
            ++i;
        }
        if (srcExcelWorkbook != null) {
            srcWorkbookSheet = null;
            srcExcelWorkbook = null;
        }
        return true;
    }

    public static boolean Export(ExcelWorkbookEx excelWorkbook, SRFExWebContext webContext, FormExcelExportConfig formExcelExportConfig, ArrayList dataEntities, String strSheetNameField, int nStartRow, int nStartColumn) {
        return ExcelExportHelperEx.Export(excelWorkbook, webContext.getGlobalHelper(), formExcelExportConfig, dataEntities, strSheetNameField, nStartRow, nStartColumn);
    }

    public static boolean Export(ExcelWorkbookEx excelWorkbook, String strSheetName, SRFExWebContext webContext, FormExcelExportConfig formExcelExportConfig, BaseDataEntity dataEntity, int nStartRow, int nStartColumn) {
        return ExcelExportHelperEx.Export(excelWorkbook, strSheetName, webContext.getGlobalHelper(), formExcelExportConfig, dataEntity, nStartRow, nStartColumn);
    }

    public static boolean Export(ExcelWorkbookEx excelWorkbook, String strSheetName, ContextHelper contextHelper, FormExcelExportConfig formExcelExportConfig, BaseDataEntity dataEntity, int nStartRow, int nStartColumn) {
        if (StringHelper.Length((String)strSheetName) == 0) {
            strSheetName = formExcelExportConfig.getSheetName();
        }
        HSSFWorkbook srcExcelWorkbook = excelWorkbook.getHSSFWorkbook();
        HSSFSheet srcWorkbookSheet = null;
        try {
            String strTemplatePath = formExcelExportConfig.getTemplate();
            if (StringHelper.Length((String)strTemplatePath) != 0) {
                if (srcExcelWorkbook == null) {
                    FileInputStream inputStream = new FileInputStream(strTemplatePath);
                    srcExcelWorkbook = new HSSFWorkbook((InputStream)inputStream);
                    excelWorkbook.setHSSFWorkbook(srcExcelWorkbook);
                }
                if (srcExcelWorkbook != null && srcExcelWorkbook.getNumberOfSheets() > 0) {
                    srcWorkbookSheet = srcExcelWorkbook.getSheetAt(0);
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        HSSFSheet writableSheet = excelWorkbook.getHSSfSheetByName(strSheetName);
        writableSheet = excelWorkbook.getHSSFWorkbook().getSheetAt(0);
        if (writableSheet == null) {
            return false;
        }
        boolean bRet = ExcelExportHelperEx.Export(writableSheet, writableSheet, contextHelper, formExcelExportConfig, dataEntity, nStartRow, nStartColumn);
        if (srcExcelWorkbook != null) {
            srcWorkbookSheet = null;
            srcExcelWorkbook = null;
        }
        return bRet;
    }

    public static boolean Export(HSSFSheet writableSheet, HSSFSheet srcWorkbookSheet, SRFExWebContext webContext, FormExcelExportConfig formExcelExportConfig, BaseDataEntity dataEntity) {
        return ExcelExportHelperEx.Export(writableSheet, srcWorkbookSheet, webContext, formExcelExportConfig, dataEntity, 0, 0);
    }

    public static boolean Export(HSSFSheet writableSheet, HSSFSheet srcWorkbookSheet, SRFExWebContext webContext, FormExcelExportConfig formExcelExportConfig, BaseDataEntity dataEntity, int nStartRow, int nStartColumn) {
        return ExcelExportHelperEx.Export(writableSheet, srcWorkbookSheet, webContext.getGlobalHelper(), formExcelExportConfig, dataEntity, nStartRow, nStartColumn);
    }

    public static boolean Export(HSSFSheet writableSheet, HSSFSheet srcWorkbookSheet, ContextHelper contextHelper, FormExcelExportConfig formExcelExportConfig, BaseDataEntity dataEntity, int nStartRow, int nStartColumn) {
        int nTemplateRow = formExcelExportConfig.getTemplateRow();
        int nTemplateRowCount = formExcelExportConfig.getTemplateRowCount();
        int nTemplateColumn = formExcelExportConfig.getTemplateColumn();
        int nTemplateColumnCount = formExcelExportConfig.getTemplateColumnCount();
        try {
            ArrayList list = formExcelExportConfig.getList();
            int i = 0;
            while (i < list.size()) {
                FormExcelExportItemConfig formExcelExportItemConfig = (FormExcelExportItemConfig)((Object)list.get(i));
                String strValue = formExcelExportItemConfig.GetItemValue(contextHelper, dataEntity);
                int nRowId = formExcelExportItemConfig.getRow() + nStartRow;
                int nColumnId = formExcelExportItemConfig.getColumn() + nStartColumn;
                try {
                    HSSFCell hssfCell = ExcelExportHelperEx.CreateCell(writableSheet.getRow(nRowId), nColumnId);
                    if (hssfCell != null) {
                        ExcelExportHelperEx.SetWritableCellValue(hssfCell, strValue, formExcelExportItemConfig.getCellType());
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

    public static boolean Export(ExcelWorkbookEx excelWorkbook, SRFExWebContext webContext, FormExcelExportConfig formExcelExportConfig, BaseDataEntity dataEntity) {
        return ExcelExportHelperEx.Export(excelWorkbook, "", webContext, formExcelExportConfig, dataEntity, 0, 0);
    }

    public static boolean Export(ExcelWorkbookEx excelWorkbook, ContextHelper contextHelper, FormExcelExportConfig formExcelExportConfig, BaseDataEntity dataEntity) {
        return ExcelExportHelperEx.Export(excelWorkbook, "", contextHelper, formExcelExportConfig, dataEntity, 0, 0);
    }

    public static boolean Export(ExcelWorkbookEx excelWorkbook, HSSFSheet writableSheet, HSSFSheet srcWorkbookSheet, ContextHelper contextHelper, GridExcelExportConfig gridExcelExportConfig, DataTable dataTable, int nStartRow, int nStartColumn, boolean bReplace) {
        if (writableSheet == null || srcWorkbookSheet == null || contextHelper == null || dataTable == null || gridExcelExportConfig == null) {
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
        ArrayList<DataRow> rows = new ArrayList<DataRow>();
        int i2 = 0;
        while (i2 < dataTable.GetRowCount()) {
            rows.add(dataTable.GetRow(i2));
            ++i2;
        }
        GridExcelExportGroupConfig rootGridExcelExportGroupConfig = null;
        GridExcelExportGroupConfig parentGridExcelExportGroupConfig = null;
        GridExcelExportGroupsConfig gridExcelExportGroupsConfig = gridExcelExportConfig.getGroupsConfig();
        if (gridExcelExportGroupsConfig != null) {
            int nGroupCount = gridExcelExportGroupsConfig.getList().size();
            int i3 = 0;
            while (i3 < nGroupCount) {
                GridExcelExportGroupConfig tempGridExcelExportGroupConfig = (GridExcelExportGroupConfig)((Object)gridExcelExportGroupsConfig.getList().get(i3));
                if (rootGridExcelExportGroupConfig == null) {
                    parentGridExcelExportGroupConfig = rootGridExcelExportGroupConfig = tempGridExcelExportGroupConfig;
                } else {
                    parentGridExcelExportGroupConfig.setChildGroupConfig(tempGridExcelExportGroupConfig);
                    parentGridExcelExportGroupConfig = tempGridExcelExportGroupConfig;
                }
                ++i3;
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
        return ExcelExportHelperEx.ExportDataGridGroupData(excelWorkbook, context, cellFuncHelper, null, rootGridExcelExportGroupConfig, writableSheet, srcWorkbookSheet, contextHelper, gridExcelExportConfig, rows, nCurRow, nCurColumn, bReplace);
    }

    public static boolean Export(ExcelWorkbookEx excelWorkbook, HSSFSheet writableSheet, HSSFSheet srcWorkbookSheet, SRFExWebContext webContext, GridExcelExportConfig gridExcelExportConfig, DataTable dataTable, int nStartRow, int nStartColumn, boolean bReplace) {
        if (writableSheet == null || srcWorkbookSheet == null || webContext == null || dataTable == null || gridExcelExportConfig == null) {
            return false;
        }
        return ExcelExportHelperEx.Export(excelWorkbook, writableSheet, srcWorkbookSheet, webContext.getGlobalHelper(), gridExcelExportConfig, dataTable, nStartRow, nStartColumn, bReplace);
    }

    public static boolean Export(ExcelWorkbookEx excelWorkbook, SRFExWebContext webContext, GridExcelExportConfig gridExcelExportConfig, DataTable dataTable, int nStartRow, int nStartColumn, boolean bReplace) {
        return ExcelExportHelperEx.Export(excelWorkbook, webContext.getGlobalHelper(), gridExcelExportConfig, dataTable, nStartRow, nStartColumn, bReplace);
    }

    public static boolean Export(ExcelWorkbookEx excelWorkbook, ContextHelper contextHelper, GridExcelExportConfig gridExcelExportConfig, DataTable dataTable, int nStartRow, int nStartColumn, boolean bReplace) {
        if (excelWorkbook == null || contextHelper == null || dataTable == null || gridExcelExportConfig == null) {
            return false;
        }
        HSSFWorkbook srcExcelWorkbook = excelWorkbook.getHSSFWorkbook();
        HSSFSheet srcWorkbookSheet = null;
        try {
            String strTemplatePath = gridExcelExportConfig.getTemplate();
            if (StringHelper.Length((String)strTemplatePath) != 0) {
                if (srcExcelWorkbook == null) {
                    FileInputStream inputStream = new FileInputStream(strTemplatePath);
                    srcExcelWorkbook = new HSSFWorkbook((InputStream)inputStream);
                    excelWorkbook.setHSSFWorkbook(srcExcelWorkbook);
                }
                if (srcExcelWorkbook != null && srcExcelWorkbook.getNumberOfSheets() > 0) {
                    srcWorkbookSheet = srcExcelWorkbook.getSheetAt(0);
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        String strSheetName = gridExcelExportConfig.getSheetName();
        HSSFSheet writableSheet = srcExcelWorkbook.getSheetAt(0);
        if (writableSheet == null) {
            if (srcExcelWorkbook != null) {
                srcWorkbookSheet = null;
                srcExcelWorkbook = null;
            }
            return false;
        }
        boolean bRet = ExcelExportHelperEx.Export(excelWorkbook, writableSheet, srcWorkbookSheet, contextHelper, gridExcelExportConfig, dataTable, nStartRow, nStartColumn, bReplace);
        if (srcExcelWorkbook != null) {
            srcWorkbookSheet = null;
            srcExcelWorkbook = null;
        }
        return bRet;
    }

    protected static boolean ExportDataGridGroupData(ExcelWorkbookEx excelWorkbook, ExcelExportContext context, SRFCellFuncHelper cellFuncHelper, GridExcelExportGroupConfig curGridExcelExportGroupConfig, GridExcelExportGroupConfig gridExcelExportGroupConfig, HSSFSheet writableSheet, HSSFSheet srcWorkbookSheet, ContextHelper contextHelper, GridExcelExportConfig gridExcelExportConfig, ArrayList rows, int nStartRow, int nStartColumn, boolean bReplace) {
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
                block65: {
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
                                break block65;
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
                            break block65;
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
                            writableSheet.createRow(nHeaderStartRow + k);
                            ++k;
                        }
                    }
                    int nTemplateRow = gridExcelExportGroupHeaderConfig.getTemplateRow();
                    int nHeaderItemCount = gridExcelExportGroupHeaderConfig.getList().size();
                    int k = 0;
                    while (k < nHeaderItemCount) {
                        GridExcelExportGroupHeaderItemConfig gridExcelExportGroupHeaderItemConfig = (GridExcelExportGroupHeaderItemConfig)((Object)gridExcelExportGroupHeaderConfig.getList().get(k));
                        String strValue = gridExcelExportGroupHeaderItemConfig.GetItemValue(contextHelper, (DataRow)rows.get(0));
                        int nItemColumn = nHeaderStartColumn + gridExcelExportGroupHeaderItemConfig.getColumn();
                        int nItemRow = nHeaderStartRow + gridExcelExportGroupHeaderItemConfig.getRow();
                        HSSFCellStyle hssfCellStyle = null;
                        HSSFCell hssfCell = null;
                        if (srcWorkbookSheet != null && (hssfCell = srcWorkbookSheet.createRow(nTemplateRow + gridExcelExportGroupHeaderItemConfig.getRow()).createCell(gridExcelExportGroupHeaderItemConfig.getColumn())) != null) {
                            hssfCellStyle = hssfCell.getCellStyle();
                        }
                        if (hssfCell != null) {
                            hssfCell.setCellValue((RichTextString)new HSSFRichTextString(strValue));
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
                ExcelExportHelperEx.ExportDataGridGroupData(excelWorkbook, context, cellFuncHelper, gridExcelExportGroupConfig, childGridExcelExportGroupConfig, writableSheet, srcWorkbookSheet, contextHelper, gridExcelExportConfig, groupRows, nCurRow, nCurColumn, bReplace);
                nCurRow = context.getCurRow();
                nCurColumn = nStartColumn;
                ++i;
            }
            nCurRow = context.getCurRow();
        } else {
            cellFuncHelper.setIsGroup(false);
            HSSFRow templateRow = excelWorkbook.templateRowContainer.get(String.valueOf(gridExcelExportConfig.getTemplateRow()));
            int j = 0;
            while (j < rows.size()) {
                HSSFRow targetRow = writableSheet.createRow(nCurRow);
                cellFuncHelper.setDataRowIndex(context.getDataRowIndex());
                int nTemplateRow = gridExcelExportConfig.getTemplateRow();
                nCurColumn = context.getStartColumn();
                try {
                    GridExcelExportColumnsConfig gridExcelExportColumnsConfig = gridExcelExportConfig.getColumnsConfig();
                    DataRow dr = (DataRow)rows.get(j);
                    if (gridExcelExportColumnsConfig != null) {
                        nCurColumn = context.getStartColumn();
                        int nCellIndex = 0;
                        int k = 0;
                        while (k < gridExcelExportColumnsConfig.getList().size()) {
                            block66: {
                                GridExcelExportColumnConfig gridExcelExportColumnConfig = (GridExcelExportColumnConfig)((Object)gridExcelExportColumnsConfig.getList().get(k));
                                if (gridExcelExportColumnConfig != null) {
                                    try {
                                        HSSFCellStyle hssfCellStyle = null;
                                        if (srcWorkbookSheet != null && templateRow != null) {
                                            ExcelExportHelperEx.CopyRowCellStyle(templateRow, targetRow);
                                        }
                                        HSSFCell writeableCell = ExcelExportHelperEx.CreateCell(srcWorkbookSheet.getRow(nCurRow), nCurColumn);
                                        String strValue = gridExcelExportColumnConfig.GetItemValue(contextHelper, dr);
                                        ExcelExportHelperEx.RenderCell(srcWorkbookSheet, cellFuncHelper, nCurColumn, nCurRow, strValue, gridExcelExportColumnConfig.getCellType(), hssfCellStyle);
                                    }
                                    catch (Exception ex) {
                                        ex.printStackTrace();
                                        break block66;
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
                            writableSheet.createRow(nBottomStartRow + k);
                            ++k;
                        }
                    }
                    int nTemplateRow = gridExcelExportGroupBottomConfig.getTemplateRow();
                    HSSFRow teplateRowBottom = excelWorkbook.templateRowContainer.get(String.valueOf(gridExcelExportGroupBottomConfig.getTemplateRow()));
                    int nBottomItemCount = gridExcelExportGroupBottomConfig.getList().size();
                    int k = 0;
                    while (k < nBottomItemCount) {
                        GridExcelExportGroupBottomItemConfig gridExcelExportGroupBottomItemConfig = (GridExcelExportGroupBottomItemConfig)((Object)gridExcelExportGroupBottomConfig.getList().get(k));
                        String strValue = gridExcelExportGroupBottomItemConfig.GetItemValue(contextHelper, (DataRow)rows.get(0));
                        int nItemColumn = nBottomStartColumn + gridExcelExportGroupBottomItemConfig.getColumn();
                        int nItemRow = nBottomStartRow + gridExcelExportGroupBottomItemConfig.getRow();
                        HSSFCellStyle hssfCellStyle = null;
                        HSSFCell srcCell = null;
                        if (srcWorkbookSheet != null && teplateRowBottom != null) {
                            ExcelExportHelperEx.CopyRowCellStyle(teplateRowBottom, srcWorkbookSheet.getRow(nItemRow));
                            srcCell = teplateRowBottom.getCell(nItemColumn);
                            if (srcCell != null) {
                                hssfCellStyle = srcCell.getCellStyle();
                            }
                        }
                        ExcelExportHelperEx.RenderCell(srcWorkbookSheet, cellFuncHelper, nItemColumn, nItemRow, strValue, gridExcelExportGroupBottomItemConfig.getCellType(), hssfCellStyle);
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

    protected static void RenderCell(HSSFSheet hssfSheet, SRFCellFuncHelper cellFuncHelper, int nColumnId, int nRowId, String strValue, int nCellType, HSSFCellStyle hssfCellStyle) {
        HSSFCell hssfCell;
        if (hssfSheet == null) {
            System.out.println("\u7a7aSheet!");
            return;
        }
        if (cellFuncHelper != null) {
            cellFuncHelper.setCurColumn(nColumnId);
            cellFuncHelper.setCurRow(nRowId);
            strValue = cellFuncHelper.Parse(strValue);
        }
        if ((hssfCell = ExcelExportHelperEx.CreateCell(hssfSheet.getRow(nRowId), nColumnId)) != null && hssfCellStyle != null) {
            hssfCell.setCellStyle(hssfCellStyle);
        }
        if (StringHelper.Length((String)strValue) <= 0) {
            return;
        }
        switch (nCellType) {
            case 2: {
                try {
                    double fValue = Double.parseDouble(strValue);
                    hssfCell.setCellValue(fValue);
                }
                catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            case 4: {
                hssfCell.setCellFormula(strValue);
            }
        }
        hssfCell.setCellValue((RichTextString)new HSSFRichTextString(strValue));
    }

    protected static HSSFCell GetCell(SRFCellFuncHelper cellFuncHelper, int nColumnId, int nRowId, String strValue, int nCellType, HSSFCellStyle hssfCellStyle, Hashtable cellStypeMap) {
        if (cellFuncHelper != null) {
            cellFuncHelper.setCurColumn(nColumnId);
            cellFuncHelper.setCurRow(nRowId);
            strValue = cellFuncHelper.Parse(strValue);
        }
        return null;
    }

    protected static void SetWritableCellValue(HSSFCell hssfCell, String strValue, int nCellType) {
        if (StringHelper.Length((String)strValue) == 0) {
            hssfCell.setCellValue((RichTextString)new HSSFRichTextString(strValue));
            return;
        }
        if (hssfCell.getCellType() == 2) {
            hssfCell.setCellFormula(hssfCell.getCellFormula());
            return;
        }
        switch (nCellType) {
            case 2: {
                hssfCell.setCellType(0);
                hssfCell.setCellValue(Double.parseDouble(strValue));
                break;
            }
            case 4: {
                hssfCell.setCellFormula(strValue);
            }
            default: {
                hssfCell.setCellValue((RichTextString)new HSSFRichTextString(strValue));
            }
        }
    }

    public static boolean Export(ExcelWorkbookEx excelWorkbook, SRFExWebContext webContext, GridExcelExportConfig gridExcelExportConfig, DataTable dataTable, int nStartRow, int nStartColumn) {
        return ExcelExportHelperEx.Export(excelWorkbook, webContext, gridExcelExportConfig, dataTable, nStartRow, nStartColumn, false);
    }

    public static boolean CopyRowCellStyle(HSSFRow templateRow, HSSFRow targetRow) {
        if (templateRow == null || targetRow == null) {
            return false;
        }
        Iterator iterator = templateRow.cellIterator();
        while (iterator.hasNext()) {
            HSSFCell hssfCell = (HSSFCell)iterator.next();
            int nColumnIndex = hssfCell.getColumnIndex();
            HSSFCellStyle hssfCellStyle = hssfCell.getCellStyle();
            HSSFCell targetCell = ExcelExportHelperEx.CreateCell(targetRow, nColumnIndex);
            if (targetCell == null || hssfCellStyle == null) continue;
            targetCell.setCellStyle(hssfCellStyle);
        }
        return true;
    }

    public static HSSFCell CreateCell(HSSFRow hssfRow, int nColumnIndex) {
        if (hssfRow == null) {
            return null;
        }
        HSSFCell hssfCell = hssfRow.getCell(nColumnIndex);
        if (hssfCell == null) {
            hssfRow.createCell(nColumnIndex);
        }
        return hssfCell;
    }

    public static boolean Export(ExcelWorkbookEx excelWorkbook, SRFExWebContext webContext, GridExcelExportConfig gridExcelExportConfig, DataTable dataTable) {
        return ExcelExportHelperEx.Export(excelWorkbook, webContext, gridExcelExportConfig, dataTable, 0, 0);
    }
}

