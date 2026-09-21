/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 *  org.apache.poi.hssf.usermodel.HSSFCell
 *  org.apache.poi.hssf.usermodel.HSSFCellStyle
 *  org.apache.poi.hssf.usermodel.HSSFFont
 *  org.apache.poi.hssf.usermodel.HSSFRichTextString
 *  org.apache.poi.hssf.usermodel.HSSFRow
 *  org.apache.poi.hssf.usermodel.HSSFSheet
 *  org.apache.poi.hssf.usermodel.HSSFWorkbook
 *  org.apache.poi.hssf.util.CellRangeAddress
 *  org.apache.poi.ss.usermodel.RichTextString
 *  org.apache.poi.ss.util.CellRangeAddress
 */
package SA.SRFDA.BI.Ctrl.Model;

import SA.SRFDA.BI.Ctrl.IBICubeCache;
import SA.SRFDA.BI.Ctrl.IBIRepDMHelper;
import SA.SRFDA.BI.Ctrl.IBIRepMSHelper;
import SA.SRFDA.BI.Ctrl.IBIRepRPHelper;
import SA.SRFDA.BI.Ctrl.IBIReportExHelper;
import SA.SRFDA.BI.Ctrl.Model.BIRepDimensionModel;
import SA.SRFDA.BI.Ctrl.Model.BIRepMeasureModel;
import SA.SRFDA.BI.Ctrl.Model.BIRepPanelModel;
import SA.SRFDA.BI.Ctrl.Model.BaseBIObjectModel;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicReference;
import net.sf.json.JSONObject;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.util.CellRangeAddress;

public class BIReportExModel
extends BaseBIObjectModel {
    protected Vector<BIRepPanelModel> repPanels = new Vector();
    protected Vector<BIRepDimensionModel> leftDimensions = new Vector();
    protected Vector<BIRepDimensionModel> topDimensions = new Vector();
    protected Vector<BIRepMeasureModel> measures = new Vector();
    protected Vector<Integer> measureGroupList = new Vector();
    protected IBIReportExHelper iBIExReportHelper = null;
    protected Vector<BaseDataEntity> rowDatas = null;
    protected boolean bShowMeasureGroup = true;
    protected int nPageSize = 100;
    protected int nTotalRow = 0;
    protected int nPageNo = 1;
    protected String strMode = "";
    protected boolean bDefaultModel = true;

    public void Init(IBIReportExHelper iBIExReportHelper, IBICubeCache iBICubeCache, String strMode, boolean bDefaultModel) throws Exception {
        BIRepDimensionModel biRepDimensionModel;
        this.strMode = strMode;
        this.bDefaultModel = bDefaultModel;
        this.setPageSize(iBIExReportHelper.getPageSize(this.getPageSize()));
        this.setShowMeasureGroup(iBIExReportHelper.isShowMeasureGroup());
        for (IBIRepDMHelper iBIRepDMHelper : iBIExReportHelper.getLeftDimensions()) {
            if (StringHelper.Compare((String)iBIRepDMHelper.getPlaceType(), (String)"HIDDEN", (boolean)true) == 0 && (iBICubeCache == null || !iBICubeCache.hasBIHierarchyFilter(iBIRepDMHelper.getBIHierarchy().getUniqueName()))) continue;
            biRepDimensionModel = new BIRepDimensionModel();
            biRepDimensionModel.Init(this, iBIRepDMHelper, iBICubeCache);
            this.leftDimensions.add(biRepDimensionModel);
        }
        for (IBIRepDMHelper iBIRepDMHelper : iBIExReportHelper.getTopDimensions()) {
            biRepDimensionModel = new BIRepDimensionModel();
            biRepDimensionModel.Init(this, iBIRepDMHelper, iBICubeCache);
            if (StringHelper.Compare((String)strMode, (String)"CHART", (boolean)true) == 0) {
                this.leftDimensions.add(biRepDimensionModel);
                continue;
            }
            this.topDimensions.add(biRepDimensionModel);
        }
        for (IBIRepMSHelper iBIRepMSHelper : iBIExReportHelper.getMeasures()) {
            BIRepMeasureModel biRepMeasureModel = new BIRepMeasureModel();
            biRepMeasureModel.Init(iBIRepMSHelper, iBICubeCache);
            this.measures.add(biRepMeasureModel);
        }
        if (iBICubeCache == null) {
            for (IBIRepRPHelper iBIRepRPHelper : iBIExReportHelper.getRelatedPanels()) {
                BIRepPanelModel biRepPanelModel = new BIRepPanelModel();
                biRepPanelModel.Init(iBIRepRPHelper, iBICubeCache);
                this.repPanels.add(biRepPanelModel);
            }
        }
    }

    @Override
    protected void OnFillJSONObject(JSONObject jsonObject) throws Exception {
        super.OnFillJSONObject(jsonObject);
        Vector<JSONObject> leftdms = new Vector<JSONObject>();
        for (BIRepDimensionModel biRepDimensionModel : this.leftDimensions) {
            JSONObject item = biRepDimensionModel.ToJSONObject();
            leftdms.add(item);
        }
        jsonObject.put("leftdimensions", (Object)leftdms.toArray());
        Vector<JSONObject> topdms = new Vector<JSONObject>();
        for (BIRepDimensionModel biRepDimensionModel : this.topDimensions) {
            JSONObject item = biRepDimensionModel.ToJSONObject();
            topdms.add(item);
        }
        jsonObject.put("topdimensions", (Object)topdms.toArray());
        Vector<JSONObject> msList = new Vector<JSONObject>();
        for (BIRepMeasureModel biRepMeasureModel : this.measures) {
            JSONObject item = biRepMeasureModel.ToJSONObject();
            msList.add(item);
        }
        jsonObject.put("measures", (Object)msList.toArray());
        Vector<JSONObject> panelList = new Vector<JSONObject>();
        for (BIRepPanelModel biRepPanelModel : this.repPanels) {
            JSONObject item = biRepPanelModel.ToJSONObject();
            panelList.add(item);
        }
        jsonObject.put("panels", (Object)panelList.toArray());
        jsonObject.put("showmeasuregroup", this.isShowMeasureGroup());
        jsonObject.put("totalrow", this.getTotalRow());
        jsonObject.put("pagesize", this.getPageSize());
        jsonObject.put("pageno", this.getPageNo());
        if (this.rowDatas != null && this.rowDatas.size() > 0) {
            JSONObject rowsJO = new JSONObject();
            BaseDataEntity firstRow = this.rowDatas.get(0);
            ArrayList columns = new ArrayList();
            for (Object objKey : firstRow.getTotalParamList().keySet()) {
                columns.add(objKey);
            }
            rowsJO.put("columns", (Object)columns.toArray());
            ArrayList rowDatasList = new ArrayList();
            for (BaseDataEntity rowData : this.rowDatas) {
                ArrayList<Object> rowDataList = new ArrayList<Object>();
                JSONObject rowJO = new JSONObject();
                for (Object objKey : columns) {
                    rowDataList.add(rowData.GetParamValue(objKey.toString()));
                }
                rowDatasList.add(rowDataList);
            }
            rowsJO.put("datas", (Object)rowDatasList.toArray());
            jsonObject.put("datarows", (Object)rowsJO);
        }
    }

    public Vector<BaseDataEntity> getRowDatas() {
        return this.rowDatas;
    }

    public void setRowDatas(Vector<BaseDataEntity> rowDatas) {
        this.rowDatas = rowDatas;
    }

    public boolean isShowMeasureGroup() {
        return this.bShowMeasureGroup;
    }

    public void setShowMeasureGroup(boolean bShowMeasureGroup) {
        this.bShowMeasureGroup = bShowMeasureGroup;
    }

    public int getTotalRow() {
        return this.nTotalRow;
    }

    public void setTotalRow(int nTotalRow) {
        this.nTotalRow = nTotalRow;
    }

    public int getPageSize() {
        return this.nPageSize;
    }

    public void setPageSize(int nPageSize) {
        this.nPageSize = nPageSize;
    }

    public int getPageNo() {
        return this.nPageNo;
    }

    public void setPageNo(int nPageNo) {
        this.nPageNo = nPageNo;
    }

    public String getMode() {
        return this.strMode;
    }

    public boolean isDefaultModel() {
        return this.bDefaultModel;
    }

    public void Export(OutputStream out) throws Exception {
        Hashtable<Integer, String> columnDataMap = new Hashtable<Integer, String>();
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("Sheet");
        HSSFFont fontLabel = wb.createFont();
        fontLabel.setBoldweight((short)700);
        HSSFFont fontGroup = wb.createFont();
        fontGroup.setBoldweight((short)700);
        fontGroup.setItalic(true);
        HSSFCellStyle style = wb.createCellStyle();
        style.setVerticalAlignment((short)1);
        style.setAlignment((short)1);
        style.setBorderTop((short)1);
        style.setBorderLeft((short)1);
        style.setBorderRight((short)1);
        style.setBorderBottom((short)1);
        HSSFCellStyle style_sum = wb.createCellStyle();
        style_sum.setVerticalAlignment((short)1);
        style_sum.setAlignment((short)1);
        style_sum.setBorderTop((short)1);
        style_sum.setBorderLeft((short)1);
        style_sum.setBorderRight((short)1);
        style_sum.setBorderBottom((short)1);
        style_sum.setFont(fontGroup);
        HSSFCellStyle styleLabel = wb.createCellStyle();
        styleLabel.setVerticalAlignment((short)1);
        styleLabel.setAlignment((short)1);
        styleLabel.setBorderTop((short)1);
        styleLabel.setBorderLeft((short)1);
        styleLabel.setBorderRight((short)1);
        styleLabel.setBorderBottom((short)1);
        styleLabel.setFont(fontLabel);
        styleLabel.setFillBackgroundColor((short)22);
        HSSFCellStyle style2 = wb.createCellStyle();
        style2.setVerticalAlignment((short)1);
        style2.setAlignment((short)3);
        style2.setBorderTop((short)1);
        style2.setBorderLeft((short)1);
        style2.setBorderRight((short)1);
        style2.setBorderBottom((short)1);
        HSSFCellStyle style2_sum = wb.createCellStyle();
        style2_sum.setVerticalAlignment((short)1);
        style2_sum.setAlignment((short)3);
        style2_sum.setBorderTop((short)1);
        style2_sum.setBorderLeft((short)1);
        style2_sum.setBorderRight((short)1);
        style2_sum.setBorderBottom((short)1);
        style2_sum.setFont(fontGroup);
        this.measureGroupList.clear();
        int nGroupCnt = 0;
        String strLastMeasureGroup = "";
        for (BIRepMeasureModel biRepMeasureModel : this.measures) {
            if (StringHelper.IsNullOrEmpty((String)strLastMeasureGroup)) {
                strLastMeasureGroup = biRepMeasureModel.getGroupName();
                nGroupCnt = 1;
                continue;
            }
            if (StringHelper.Compare((String)biRepMeasureModel.getGroupName(), (String)strLastMeasureGroup, (boolean)true) == 0) {
                ++nGroupCnt;
                continue;
            }
            strLastMeasureGroup = biRepMeasureModel.getGroupName();
            this.measureGroupList.add(nGroupCnt);
            nGroupCnt = 1;
        }
        this.measureGroupList.add(nGroupCnt);
        int nHeaderRowCount = 1;
        if (this.bShowMeasureGroup) {
            ++nHeaderRowCount;
        }
        nHeaderRowCount += this.topDimensions.size();
        int nHeaderColumnCount = this.leftDimensions.size();
        if (this.topDimensions.size() > 0) {
            int nColumnCount = 0;
            int i = 0;
            while (i < this.topDimensions.size()) {
                BIRepDimensionModel biRepDimensionModel = this.topDimensions.get(i);
                int nDMCnt = biRepDimensionModel.getDataList().size();
                nColumnCount = i == 0 ? nDMCnt : (nColumnCount *= nDMCnt);
                ++i;
            }
            nHeaderColumnCount += (nColumnCount *= this.measures.size());
        } else {
            nHeaderColumnCount += this.measures.size();
        }
        int i = 0;
        while (i < nHeaderRowCount) {
            sheet.createRow((int)((short)i));
            ++i;
        }
        i = 0;
        while (i < this.leftDimensions.size()) {
            BIRepDimensionModel repDimensionModel = this.leftDimensions.get(i);
            int nIndex = 0;
            int j = 0;
            while (j < this.topDimensions.size()) {
                HSSFCell cell1 = sheet.getRow(j).createCell(i);
                cell1.setCellValue((RichTextString)new HSSFRichTextString("\u7ef4\u5ea6"));
                cell1.setCellStyle(styleLabel);
                ++j;
            }
            nIndex = this.topDimensions.size();
            if (this.bShowMeasureGroup) {
                HSSFCell cell1 = sheet.getRow(nIndex).createCell(i);
                cell1.setCellValue((RichTextString)new HSSFRichTextString(repDimensionModel.getCaption()));
                cell1.setCellStyle(styleLabel);
                ++nIndex;
            }
            HSSFCell cell1 = sheet.getRow(nIndex).createCell(i);
            cell1.setCellValue((RichTextString)new HSSFRichTextString(repDimensionModel.getCaption()));
            cell1.setCellStyle(styleLabel);
            double fColumnWidth = repDimensionModel.getColumnWidth();
            sheet.setColumnWidth(i, (int)fColumnWidth * 50);
            columnDataMap.put(i, repDimensionModel.getId());
            ++i;
        }
        Vector<String> bindingList = new Vector<String>();
        Vector<String[]> columnList = new Vector<String[]>();
        int nMeasureColumnCount = nHeaderColumnCount - this.leftDimensions.size();
        int i2 = 0;
        while (i2 < nMeasureColumnCount) {
            bindingList.add("");
            String[] columnTexts = new String[nHeaderRowCount];
            int j = 0;
            while (j < nHeaderRowCount) {
                columnTexts[j] = "";
                ++j;
            }
            columnList.add(columnTexts);
            ++i2;
        }
        Vector<MergeRange> mergeRangeList = new Vector<MergeRange>();
        AtomicReference<Object> refColumnIndex = new AtomicReference<Object>(0);
        this.BuildPivotTableMeasureColumns(0, columnList, bindingList, "", refColumnIndex, mergeRangeList);
        int nXOffset = this.leftDimensions.size();
        int i3 = 0;
        while (i3 < columnList.size()) {
            String[] columnTexts = columnList.get(i3);
            int j = 0;
            while (j < columnTexts.length) {
                HSSFCell cell1 = sheet.getRow(j).createCell(i3 + nXOffset);
                cell1.setCellValue((RichTextString)new HSSFRichTextString(columnTexts[j]));
                cell1.setCellStyle(styleLabel);
                ++j;
            }
            double fColumnWidth = this.measures.get(i3 % this.measures.size()).getColumnWidth();
            sheet.setColumnWidth(i3 + nXOffset, (int)fColumnWidth * 50);
            if (this.rowDatas != null) {
                String strMeasureId = bindingList.get(i3);
                columnDataMap.put(i3 + nXOffset, strMeasureId);
            }
            ++i3;
        }
        i3 = 0;
        while (i3 < mergeRangeList.size()) {
            MergeRange mergeRange = mergeRangeList.get(i3);
            mergeRange.StartColumn += this.leftDimensions.size();
            mergeRange.EndColumn += this.leftDimensions.size();
            org.apache.poi.hssf.util.CellRangeAddress cellRangeAddress = new org.apache.poi.hssf.util.CellRangeAddress(mergeRange.StartRow, mergeRange.EndRow, mergeRange.StartColumn, mergeRange.EndColumn);
            sheet.addMergedRegion((CellRangeAddress)cellRangeAddress);
            ++i3;
        }
        if (this.leftDimensions.size() > 1 && this.topDimensions.size() > 0) {
            org.apache.poi.hssf.util.CellRangeAddress cellRangeAddress = new org.apache.poi.hssf.util.CellRangeAddress(0, this.topDimensions.size() - 1, 0, this.leftDimensions.size() - 1);
            sheet.addMergedRegion((CellRangeAddress)cellRangeAddress);
        }
        if (this.bShowMeasureGroup) {
            i = 0;
            while (i < this.leftDimensions.size()) {
                int nStartX = i;
                int nStartY = this.topDimensions.size();
                int nEndX = i++;
                int nEndY = nStartY + 1;
                org.apache.poi.hssf.util.CellRangeAddress cellRangeAddress = new org.apache.poi.hssf.util.CellRangeAddress(nStartY, nEndY, nStartX, nEndX);
                sheet.addMergedRegion((CellRangeAddress)cellRangeAddress);
            }
        }
        if (this.rowDatas != null) {
            i = 0;
            while (i < this.rowDatas.size()) {
                HSSFRow row = sheet.createRow(i + nHeaderRowCount);
                BaseDataEntity rowData = this.rowDatas.get(i);
                String strRowKey = rowData.GetParamStringValue("SRFROWKEY", "");
                boolean bGroup = strRowKey.indexOf("(ALL)") != -1;
                int j = 0;
                while (j < columnDataMap.size()) {
                    String strCaption;
                    String strColumnName = columnDataMap.get(j);
                    HSSFCell cell1 = row.createCell(j);
                    if (j >= this.leftDimensions.size()) {
                        BIRepMeasureModel biRepMeasureModel;
                        strCaption = rowData.GetParamStringValue(strColumnName, "");
                        if (!StringHelper.IsNullOrEmpty((String)strCaption) && !StringHelper.IsNullOrEmpty((String)(biRepMeasureModel = this.measures.get((j - this.leftDimensions.size()) % this.measures.size())).getFormat())) {
                            Double fValue = rowData.GetParamDoubleValue(strColumnName, 0.0);
                            DecimalFormat df1 = new DecimalFormat(biRepMeasureModel.getFormat());
                            strCaption = df1.format(fValue);
                        }
                        cell1.setCellValue((RichTextString)new HSSFRichTextString(strCaption));
                        if (bGroup) {
                            cell1.setCellStyle(style2_sum);
                        } else {
                            cell1.setCellStyle(style2);
                        }
                    } else {
                        strCaption = rowData.GetParamStringValue(strColumnName, "");
                        if (bGroup) {
                            cell1.setCellStyle(style_sum);
                        } else {
                            cell1.setCellStyle(style);
                        }
                        cell1.setCellValue((RichTextString)new HSSFRichTextString(strCaption));
                    }
                    ++j;
                }
                ++i;
            }
            mergeRangeList.clear();
            this.MergePivotTableDataRows(0, 0, this.rowDatas.size() - 1, mergeRangeList, columnDataMap);
            i = 0;
            while (i < mergeRangeList.size()) {
                MergeRange mergeRange = mergeRangeList.get(i);
                mergeRange.StartRow += nHeaderRowCount;
                mergeRange.EndRow += nHeaderRowCount;
                org.apache.poi.hssf.util.CellRangeAddress cellRangeAddress = new org.apache.poi.hssf.util.CellRangeAddress(mergeRange.StartRow, mergeRange.EndRow, mergeRange.StartColumn, mergeRange.EndColumn);
                sheet.addMergedRegion((CellRangeAddress)cellRangeAddress);
                ++i;
            }
        }
        wb.write(out);
    }

    protected void BuildPivotTableMeasureColumns(int nDMIndex, Vector<String[]> columnList, Vector<String> bindingList, String strDMKey, AtomicReference<Object> refColumnIndex, Vector<MergeRange> mergeRangeList) {
        if (this.topDimensions.size() <= nDMIndex) {
            Object columnTexts;
            Integer nCurColumnIndex = (Integer)refColumnIndex.get();
            int i = 0;
            while (i < this.measures.size()) {
                int nColumnTextIndex = nDMIndex;
                columnTexts = columnList.get(nCurColumnIndex);
                int nLastColumnIndex = nCurColumnIndex;
                if (this.bShowMeasureGroup) {
                    columnTexts[nColumnTextIndex] = this.measures.get(i).getGroupName();
                    ++nColumnTextIndex;
                }
                columnTexts[nColumnTextIndex] = this.measures.get(i).getCaption();
                String strMKey = strDMKey;
                if (!StringHelper.IsNullOrEmpty((String)strMKey)) {
                    strMKey = String.valueOf(strMKey) + ";";
                }
                strMKey = String.valueOf(strMKey) + this.measures.get(i).getId();
                bindingList.set(nCurColumnIndex, strMKey);
                nCurColumnIndex = nCurColumnIndex + 1;
                ++i;
            }
            if (this.bShowMeasureGroup) {
                Integer nMeasureGroupSpanStart = (Integer)refColumnIndex.get();
                columnTexts = this.measureGroupList.iterator();
                while (columnTexts.hasNext()) {
                    int nMeasureGroupSpan = (Integer)columnTexts.next();
                    if (nMeasureGroupSpan > 1) {
                        MergeRange mergeRange = new MergeRange();
                        mergeRange.StartRow = nDMIndex;
                        mergeRange.EndRow = nDMIndex;
                        mergeRange.StartColumn = nMeasureGroupSpanStart;
                        mergeRange.EndColumn = nMeasureGroupSpanStart + nMeasureGroupSpan - 1;
                        mergeRangeList.add(mergeRange);
                    }
                    nMeasureGroupSpanStart = nMeasureGroupSpanStart + nMeasureGroupSpan;
                }
            }
            refColumnIndex.set(nCurColumnIndex - 1);
            return;
        }
        Integer nCurColumnIndex = (Integer)refColumnIndex.get();
        BIRepDimensionModel biRepDimensionModel = this.topDimensions.get(nDMIndex);
        int i = 0;
        while (i < biRepDimensionModel.getDataList().size()) {
            String[] columnTexts = columnList.get(nCurColumnIndex);
            columnTexts[nDMIndex] = biRepDimensionModel.getDataList().get(i);
            int nLastColumnIndex = nCurColumnIndex;
            String strNewDMKey = strDMKey;
            if (!StringHelper.IsNullOrEmpty((String)strNewDMKey)) {
                strNewDMKey = String.valueOf(strNewDMKey) + ";";
            }
            strNewDMKey = String.valueOf(strNewDMKey) + biRepDimensionModel.getKeyList().get(i);
            AtomicReference<Object> refCurColumnIndex = new AtomicReference<Object>(nCurColumnIndex);
            this.BuildPivotTableMeasureColumns(nDMIndex + 1, columnList, bindingList, strNewDMKey, refCurColumnIndex, mergeRangeList);
            nCurColumnIndex = (Integer)refCurColumnIndex.get();
            if (nLastColumnIndex != nCurColumnIndex) {
                MergeRange mergeRange = new MergeRange();
                mergeRange.StartRow = nDMIndex;
                mergeRange.EndRow = nDMIndex;
                mergeRange.StartColumn = nLastColumnIndex;
                mergeRange.EndColumn = nCurColumnIndex;
                mergeRangeList.add(mergeRange);
            }
            nCurColumnIndex = nCurColumnIndex + 1;
            ++i;
        }
        refColumnIndex.set(nCurColumnIndex - 1);
    }

    protected void MergePivotTableDataRows(int nDMIndex, int nPageNo, int nEndRow, Vector<MergeRange> mergeRangeList, Hashtable<Integer, String> columnDataMap) {
        if (nDMIndex >= this.leftDimensions.size()) {
            return;
        }
        BIRepDimensionModel repDimensionModel = this.leftDimensions.get(nDMIndex);
        String strHeaderName = columnDataMap.get(nDMIndex);
        String strLastCaption = "";
        int nLastPageNo = 0;
        int nLastEndRow = 0;
        int i = nPageNo;
        while (i <= nEndRow) {
            BaseDataEntity data = this.rowDatas.get(i);
            String strCaption = data.GetParamStringValue(strHeaderName, "");
            if (StringHelper.IsNullOrEmpty((String)strLastCaption)) {
                strLastCaption = strCaption;
                nLastPageNo = i;
                nLastEndRow = i;
            } else if (StringHelper.Compare((String)strLastCaption, (String)strCaption, (boolean)true) == 0) {
                nLastEndRow = i;
            } else {
                if (nLastEndRow != nLastPageNo) {
                    MergeRange mergeRange = new MergeRange();
                    mergeRange.StartColumn = nDMIndex;
                    mergeRange.EndColumn = nDMIndex;
                    mergeRange.StartRow = nLastPageNo;
                    mergeRange.EndRow = nLastEndRow;
                    mergeRangeList.add(mergeRange);
                    this.MergePivotTableDataRows(nDMIndex + 1, nLastPageNo, nLastEndRow, mergeRangeList, columnDataMap);
                }
                strLastCaption = strCaption;
                nLastPageNo = i;
                nLastEndRow = i;
            }
            ++i;
        }
        if (nLastEndRow != nLastPageNo) {
            MergeRange mergeRange = new MergeRange();
            mergeRange.StartColumn = nDMIndex;
            mergeRange.EndColumn = nDMIndex;
            mergeRange.StartRow = nLastPageNo;
            mergeRange.EndRow = nLastEndRow;
            mergeRangeList.add(mergeRange);
            this.MergePivotTableDataRows(nDMIndex + 1, nLastPageNo, nLastEndRow, mergeRangeList, columnDataMap);
        }
    }

    private class MergeRange {
        public int StartRow;
        public int EndRow;
        public int StartColumn;
        public int EndColumn;

        private MergeRange() {
        }
    }
}

