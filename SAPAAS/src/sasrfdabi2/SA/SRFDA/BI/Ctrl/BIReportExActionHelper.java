/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.BI.Ctrl.BICubeCacheCondition
 *  SA.SRFDA.BI.Ctrl.BICubeCacheSortInfo
 *  SA.SRFDA.BI.Ctrl.BIUSSFactory
 *  SA.SRFDA.BI.Ctrl.BaseBIReportExActionHelper
 *  SA.SRFDA.BI.Ctrl.IBICubeCache
 *  SA.SRFDA.BI.Ctrl.IBICubeMeasureHelper
 *  SA.SRFDA.BI.Ctrl.IBIHierarchyHelper
 *  SA.SRFDA.BI.Ctrl.IBIRepDMHelper
 *  SA.SRFDA.BI.Ctrl.IBIRepMSHelper
 *  SA.SRFDA.BI.Ctrl.IBIUserSessionStorage
 *  SA.SRFDA.BI.Ctrl.Model.BIReportExModel
 *  SA.SRFDA.BI.Ctrl.SRFDABIActionResult
 *  SA.SRFDA.BI.Web.SRFDABIWebCTXHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.BICubeCacheCondition;
import SA.SRFDA.BI.Ctrl.BICubeCacheSortInfo;
import SA.SRFDA.BI.Ctrl.BIUSSFactory;
import SA.SRFDA.BI.Ctrl.BaseBIReportExActionHelper;
import SA.SRFDA.BI.Ctrl.IBICubeCache;
import SA.SRFDA.BI.Ctrl.IBICubeMeasureHelper;
import SA.SRFDA.BI.Ctrl.IBIHierarchyHelper;
import SA.SRFDA.BI.Ctrl.IBIRepDMHelper;
import SA.SRFDA.BI.Ctrl.IBIRepMSHelper;
import SA.SRFDA.BI.Ctrl.IBIUserSessionStorage;
import SA.SRFDA.BI.Ctrl.Model.BIReportExModel;
import SA.SRFDA.BI.Ctrl.SRFDABIActionResult;
import SA.SRFDA.BI.Web.SRFDABIWebCTXHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BIReportExActionHelper
extends BaseBIReportExActionHelper {
    private static final Log log = LogFactory.getLog(BIReportExActionHelper.class);
    protected IBIUserSessionStorage iBIUserSessionStorage = null;

    protected void OnBeforeProcess() throws Exception {
        super.OnBeforeProcess();
        this.iBIUserSessionStorage = BIUSSFactory.GetCurrentUSS((ISRFDAWebContext)this.getWebContext());
    }

    protected SRFDABIActionResult OnFetchTable() throws Exception {
        SRFDABIActionResult actionResult = new SRFDABIActionResult();
        String strBISessionId = SRFDABIWebCTXHelper.GetBISessionId((ISRFDAWebContext)this.getWebContext());
        String strBIFilter = SRFDABIWebCTXHelper.GetBIFilterId((ISRFDAWebContext)this.getWebContext());
        IBICubeCache iBICubeCache = this.iBIUserSessionStorage.GetBICubeCache(this.getIBIReportEx().getBICube(), strBIFilter, "TABLE");
        Vector<IBIRepDMHelper> rowDimensions = new Vector<IBIRepDMHelper>();
        for (IBIRepDMHelper iBIRepDMHelper : this.iReportExHelper.getLeftDimensions()) {
            if (!iBICubeCache.hasBIHierarchyFilter(iBIRepDMHelper.getBIHierarchy().getUniqueName())) continue;
            rowDimensions.add(iBIRepDMHelper);
        }
        int nStartRow = SRFDABIWebCTXHelper.GetBIStartRow((ISRFDAWebContext)this.getWebContext(), (int)1);
        int nPageSize = SRFDABIWebCTXHelper.GetBIPageSize((ISRFDAWebContext)this.getWebContext(), (int)100);
        Vector rowDMDataInfos = new Vector();
        this.getIBIReportEx().GetPovitTableRowDimensionDataInfo(iBICubeCache, rowDMDataInfos);
        int nTotalRow = 0;
        int nDMRowCount = 1;
        int[] rowLoopCount = null;
        if (rowDMDataInfos.size() > 0) {
            rowLoopCount = new int[rowDMDataInfos.size()];
            nTotalRow = 1;
            int i = 0;
            while (i < rowDMDataInfos.size()) {
                rowLoopCount[i] = 1;
                BaseDataEntity rowDMDataInfo = (BaseDataEntity)rowDMDataInfos.get(i);
                int nRowCount = rowDMDataInfo.GetParamIntValue("Count", 0);
                nTotalRow *= nRowCount;
                if (i > 0) {
                    nDMRowCount *= nRowCount;
                }
                int j = 0;
                while (j < i) {
                    rowLoopCount[j] = rowLoopCount[j] * nRowCount;
                    ++j;
                }
                ++i;
            }
        }
        if (nTotalRow == 0) {
            return actionResult;
        }
        if (nStartRow > nTotalRow + 1) {
            return actionResult;
        }
        int nEndRow = nStartRow + nPageSize - 1;
        if (nEndRow > nTotalRow) {
            nEndRow = nTotalRow;
        }
        int nStartDMIndex = nStartRow / nDMRowCount + (nStartRow % nDMRowCount == 0 ? 0 : 1);
        int nEndDMIndex = nEndRow / nDMRowCount + (nEndRow % nDMRowCount == 0 ? 0 : 1);
        IBIHierarchyHelper firstBIHierarchyHelper = ((IBIRepDMHelper)rowDimensions.get(0)).getBIHierarchy();
        String strBIHierarchy = firstBIHierarchyHelper.getUniqueName();
        Hashtable<String, BaseDataEntity> datas = new Hashtable<String, BaseDataEntity>();
        Vector<IBIHierarchyHelper> allBIHierarchies = new Vector<IBIHierarchyHelper>();
        for (IBIRepDMHelper iBIRepDMHelper : rowDimensions) {
            allBIHierarchies.add(iBIRepDMHelper.getBIHierarchy());
        }
        for (IBIRepDMHelper iBIRepDMHelper : this.iReportExHelper.getTopDimensions()) {
            allBIHierarchies.add(iBIRepDMHelper.getBIHierarchy());
        }
        iBICubeCache.FetchDataByBIHierarchy(strBIHierarchy, nStartDMIndex, nEndDMIndex, allBIHierarchies, datas);
        Vector<BaseDataEntity> rowDatas = new Vector<BaseDataEntity>();
        Vector firstRowDMDatas = iBICubeCache.getBIHierarchyDatas(((IBIRepDMHelper)rowDimensions.get(0)).getBIHierarchy().getUniqueName());
        int i = nStartDMIndex - 1;
        while (i < nEndDMIndex) {
            BaseDataEntity dmData = (BaseDataEntity)firstRowDMDatas.get(i);
            BaseDataEntity rowData = new BaseDataEntity();
            String strRowKey = firstBIHierarchyHelper.getDataKey(dmData);
            rowData.SetParamValue(firstBIHierarchyHelper.getShortId(), (Object)firstBIHierarchyHelper.getDataCaption(dmData));
            rowData.SetParamValue(String.valueOf(firstBIHierarchyHelper.getShortId()) + "K", (Object)strRowKey);
            rowData.SetParamValue("SRFROWKEY", (Object)strRowKey);
            rowDatas.add(rowData);
            this.BuildPivotTableRowDatas(rowDatas, rowData, rowDimensions, 1, iBICubeCache, datas);
            ++i;
        }
        BaseDataEntity firstRow = (BaseDataEntity)rowDatas.get(0);
        Vector columns = new Vector();
        for (Object objKey : firstRow.getTotalParamList().keySet()) {
            columns.add(objKey);
        }
        StringBuilderEx sb = new StringBuilderEx();
        sb.Append("\r\n---------------------------------------------------------------------------------------\r\n");
        for (Object objKey : columns) {
            sb.Append("%1$s\t\t", objKey);
        }
        sb.Append("\r\n");
        for (BaseDataEntity rowData : rowDatas) {
            for (Object objKey : columns) {
                sb.Append("%1$s\t\t", rowData.GetParamValue(objKey.toString()));
            }
            sb.Append("\r\n");
        }
        log.info((Object)sb.toString());
        Vector<BaseDataEntity> retRowDatas = new Vector<BaseDataEntity>();
        int nCurStartRow = (nStartDMIndex - 1) * nDMRowCount + 1;
        int nInterval = nStartRow - nCurStartRow;
        int nCnt = 0;
        int i2 = nInterval;
        while (i2 < rowDatas.size()) {
            retRowDatas.add(rowDatas.get(i2));
            if (++nCnt >= nPageSize) break;
            ++i2;
        }
        BIReportExModel biReportExModel = new BIReportExModel();
        biReportExModel.Init(this.getIBIReportEx(), iBICubeCache, "TABLE", false);
        biReportExModel.setRowDatas(retRowDatas);
        biReportExModel.setTotalRow(nTotalRow);
        biReportExModel.setPageSize(nPageSize);
        biReportExModel.setPageNo(nStartRow / nPageSize + (nStartRow % nPageSize == 0 ? 0 : 1));
        actionResult.setModel(biReportExModel.ToJSONObject());
        return actionResult;
    }

    protected void BuildPivotTableRowDatas(Vector<BaseDataEntity> rowDatas, BaseDataEntity rowData, Vector<IBIRepDMHelper> rowDimensions, int nRowDMIndex, IBICubeCache iBICubeCache, Hashtable<String, BaseDataEntity> datas) throws Exception {
        if (nRowDMIndex >= rowDimensions.size()) {
            this.BuildPivotTableRowMeasures(rowData, "", "", this.iReportExHelper.getTopDimensions(), 0, iBICubeCache, datas);
            return;
        }
        IBIHierarchyHelper iBIHierarchyHelper = rowDimensions.get(nRowDMIndex).getBIHierarchy();
        Vector dmDatas = iBICubeCache.getBIHierarchyDatas(iBIHierarchyHelper.getUniqueName());
        BaseDataEntity activeRowData = null;
        String strCurRowKey = rowData.GetParamStringValue("SRFROWKEY", "");
        int i = 0;
        while (i < dmDatas.size()) {
            BaseDataEntity dmData = (BaseDataEntity)dmDatas.get(i);
            String strDataCaption = iBIHierarchyHelper.getDataCaption(dmData);
            String strDataKey = iBIHierarchyHelper.getDataKey(dmData);
            if (i == 0) {
                activeRowData = rowData;
            } else {
                activeRowData = new BaseDataEntity();
                rowData.CopyTo(activeRowData, false);
                rowDatas.add(activeRowData);
            }
            String strRowKey = StringHelper.Format((String)"%1$s;%2$s", (Object)strCurRowKey, (Object)strDataKey);
            activeRowData.SetParamValue("SRFROWKEY", (Object)strRowKey);
            activeRowData.SetParamValue(iBIHierarchyHelper.getShortId(), (Object)strDataCaption);
            activeRowData.SetParamValue(String.valueOf(iBIHierarchyHelper.getShortId()) + "K", (Object)strDataKey);
            this.BuildPivotTableRowDatas(rowDatas, activeRowData, rowDimensions, nRowDMIndex + 1, iBICubeCache, datas);
            ++i;
        }
    }

    protected void BuildPivotTableRowMeasures(BaseDataEntity rowData, String strMeasureId, String strMeasureKey, Vector<IBIRepDMHelper> colDimensions, int nColDMIndex, IBICubeCache iBICubeCache, Hashtable<String, BaseDataEntity> datas) throws Exception {
        if (nColDMIndex >= colDimensions.size()) {
            String strRowKey;
            String strTotalKey = strRowKey = rowData.GetParamStringValue("SRFROWKEY", "");
            if (!StringHelper.IsNullOrEmpty((String)strMeasureKey)) {
                strTotalKey = StringHelper.IsNullOrEmpty((String)strTotalKey) ? strMeasureKey : StringHelper.Format((String)"%1$s;%2$s", (Object)strTotalKey, (Object)strMeasureKey);
            }
            BaseDataEntity data = datas.get(strTotalKey);
            int i = 0;
            while (i < this.iReportExHelper.getMeasures().size()) {
                IBICubeMeasureHelper iBICubeMeasureHelper = ((IBIRepMSHelper)this.iReportExHelper.getMeasures().get(i)).getBICubeMeasure();
                String strTotalMeasureId = strMeasureKey;
                if (!StringHelper.IsNullOrEmpty((String)strTotalMeasureId)) {
                    strTotalMeasureId = String.valueOf(strTotalMeasureId) + ";";
                }
                strTotalMeasureId = String.valueOf(strTotalMeasureId) + iBICubeMeasureHelper.getShortId();
                if (data != null) {
                    rowData.SetParamValue(strTotalMeasureId, data.GetParamValue(iBICubeMeasureHelper.getShortId()));
                } else {
                    rowData.SetParamValue(strTotalMeasureId, null);
                }
                ++i;
            }
            return;
        }
        IBIHierarchyHelper iBIHierarchyHelper = colDimensions.get(nColDMIndex).getBIHierarchy();
        Vector dmDatas = iBICubeCache.getBIHierarchyDatas(iBIHierarchyHelper.getUniqueName());
        int i = 0;
        while (i < dmDatas.size()) {
            BaseDataEntity dmData = (BaseDataEntity)dmDatas.get(i);
            String strDataCaption = iBIHierarchyHelper.getDataCaption(dmData);
            String strDataKey = iBIHierarchyHelper.getDataKey(dmData);
            String strMeasureKey2 = "";
            strMeasureKey2 = StringHelper.IsNullOrEmpty((String)strMeasureKey) ? strDataKey : StringHelper.Format((String)"%1$s;%2$s", (Object)strMeasureKey, (Object)strDataKey);
            String strMeasureId2 = "";
            strMeasureId2 = StringHelper.IsNullOrEmpty((String)strMeasureId) ? iBIHierarchyHelper.getShortId() : StringHelper.Format((String)"%1$s;%2$s", (Object)strMeasureId, (Object)iBIHierarchyHelper.getShortId());
            this.BuildPivotTableRowMeasures(rowData, strMeasureId2, strMeasureKey2, colDimensions, nColDMIndex + 1, iBICubeCache, datas);
            ++i;
        }
    }

    protected SRFDABIActionResult OnExportTable() throws Exception {
        SRFDABIActionResult actionResult = new SRFDABIActionResult();
        String strBISessionId = SRFDABIWebCTXHelper.GetBISessionId((ISRFDAWebContext)this.getWebContext());
        String strBIFilter = SRFDABIWebCTXHelper.GetBIFilterId((ISRFDAWebContext)this.getWebContext());
        IBICubeCache iBICubeCache = this.iBIUserSessionStorage.GetBICubeCache(this.getIBIReportEx().getBICube(), strBIFilter, "TABLE");
        Vector<IBIRepDMHelper> rowDimensions = new Vector<IBIRepDMHelper>();
        for (IBIRepDMHelper iBIRepDMHelper : this.iReportExHelper.getLeftDimensions()) {
            if (!iBICubeCache.hasBIHierarchyFilter(iBIRepDMHelper.getBIHierarchy().getUniqueName())) continue;
            rowDimensions.add(iBIRepDMHelper);
        }
        int nStartRow = 1;
        int nPageSize = 65535;
        Vector rowDMDataInfos = new Vector();
        this.getIBIReportEx().GetPovitTableRowDimensionDataInfo(iBICubeCache, rowDMDataInfos);
        int nTotalRow = 0;
        int nDMRowCount = 1;
        int[] rowLoopCount = null;
        if (rowDMDataInfos.size() > 0) {
            rowLoopCount = new int[rowDMDataInfos.size()];
            nTotalRow = 1;
            int i = 0;
            while (i < rowDMDataInfos.size()) {
                rowLoopCount[i] = 1;
                BaseDataEntity rowDMDataInfo = (BaseDataEntity)rowDMDataInfos.get(i);
                int nRowCount = rowDMDataInfo.GetParamIntValue("Count", 0);
                nTotalRow *= nRowCount;
                if (i > 0) {
                    nDMRowCount *= nRowCount;
                }
                int j = 0;
                while (j < i) {
                    rowLoopCount[j] = rowLoopCount[j] * nRowCount;
                    ++j;
                }
                ++i;
            }
        }
        if (nTotalRow == 0) {
            return actionResult;
        }
        if (nStartRow > nTotalRow + 1) {
            return actionResult;
        }
        int nEndRow = nStartRow + nPageSize - 1;
        if (nEndRow > nTotalRow) {
            nEndRow = nTotalRow;
        }
        int nStartDMIndex = nStartRow / nDMRowCount + (nStartRow % nDMRowCount == 0 ? 0 : 1);
        int nEndDMIndex = nEndRow / nDMRowCount + (nEndRow % nDMRowCount == 0 ? 0 : 1);
        IBIHierarchyHelper firstBIHierarchyHelper = ((IBIRepDMHelper)rowDimensions.get(0)).getBIHierarchy();
        String strBIHierarchy = firstBIHierarchyHelper.getUniqueName();
        Hashtable<String, BaseDataEntity> datas = new Hashtable<String, BaseDataEntity>();
        Vector<IBIHierarchyHelper> allBIHierarchies = new Vector<IBIHierarchyHelper>();
        for (IBIRepDMHelper iBIRepDMHelper : rowDimensions) {
            allBIHierarchies.add(iBIRepDMHelper.getBIHierarchy());
        }
        for (IBIRepDMHelper iBIRepDMHelper : this.iReportExHelper.getTopDimensions()) {
            allBIHierarchies.add(iBIRepDMHelper.getBIHierarchy());
        }
        iBICubeCache.FetchDataByBIHierarchy(strBIHierarchy, nStartDMIndex, nEndDMIndex, allBIHierarchies, datas);
        Vector<BaseDataEntity> rowDatas = new Vector<BaseDataEntity>();
        Vector firstRowDMDatas = iBICubeCache.getBIHierarchyDatas(((IBIRepDMHelper)rowDimensions.get(0)).getBIHierarchy().getUniqueName());
        int i = nStartDMIndex - 1;
        while (i < nEndDMIndex) {
            BaseDataEntity dmData = (BaseDataEntity)firstRowDMDatas.get(i);
            BaseDataEntity rowData = new BaseDataEntity();
            String strRowKey = firstBIHierarchyHelper.getDataKey(dmData);
            rowData.SetParamValue(firstBIHierarchyHelper.getShortId(), (Object)firstBIHierarchyHelper.getDataCaption(dmData));
            rowData.SetParamValue(String.valueOf(firstBIHierarchyHelper.getShortId()) + "K", (Object)strRowKey);
            rowData.SetParamValue("SRFROWKEY", (Object)strRowKey);
            rowDatas.add(rowData);
            this.BuildPivotTableRowDatas(rowDatas, rowData, rowDimensions, 1, iBICubeCache, datas);
            ++i;
        }
        BaseDataEntity firstRow = (BaseDataEntity)rowDatas.get(0);
        Vector columns = new Vector();
        for (Object objKey : firstRow.getTotalParamList().keySet()) {
            columns.add(objKey);
        }
        StringBuilderEx sb = new StringBuilderEx();
        sb.Append("\r\n---------------------------------------------------------------------------------------\r\n");
        for (Object objKey : columns) {
            sb.Append("%1$s\t\t", objKey);
        }
        sb.Append("\r\n");
        for (BaseDataEntity rowData : rowDatas) {
            for (Object objKey : columns) {
                sb.Append("%1$s\t\t", rowData.GetParamValue(objKey.toString()));
            }
            sb.Append("\r\n");
        }
        log.info((Object)sb.toString());
        Vector<BaseDataEntity> retRowDatas = new Vector<BaseDataEntity>();
        int nCurStartRow = (nStartDMIndex - 1) * nDMRowCount + 1;
        int nInterval = nStartRow - nCurStartRow;
        int nCnt = 0;
        int i2 = nInterval;
        while (i2 < rowDatas.size()) {
            retRowDatas.add(rowDatas.get(i2));
            if (++nCnt >= nPageSize) break;
            ++i2;
        }
        BIReportExModel biReportExModel = new BIReportExModel();
        biReportExModel.Init(this.getIBIReportEx(), iBICubeCache, "TABLE", false);
        biReportExModel.setRowDatas(retRowDatas);
        try {
            String strTempFileName = Helper.GenGuid();
            String strDir = StringHelper.Format((String)"%1$s%2$s", (Object)this.getWebContext().getGlobalHelper().GetTempPath(), (Object)this.getWebContext().getSessionId());
            File dir = new File(strDir);
            dir.mkdirs();
            String strFullFileName = StringHelper.Format((String)"%1$s%2$s%3$s%4$s.%5$s", (Object)this.getWebContext().getGlobalHelper().GetTempPath(), (Object)this.getWebContext().getSessionId(), (Object)File.separator, (Object)strTempFileName, (Object)"xls");
            FileOutputStream out = new FileOutputStream(strFullFileName);
            biReportExModel.Export((OutputStream)out);
            ((OutputStream)out).close();
            String strDownloadURL = "";
            strDownloadURL = StringHelper.Format((String)"'../srfpage/exportexcel.jsp?FILEID=%1$s&EXPORTTYPE=%2$s'", (Object)strTempFileName, (Object)"");
            String strScript = "";
            strScript = StringHelper.IsNullOrEmpty((String)this.getWebContext().getSRFPageModel()) ? StringHelper.Format((String)"SRFUtility.root().location=%1$s;", (Object)strDownloadURL) : StringHelper.Format((String)"SRFUtility.download(%1$s);", (Object)strDownloadURL);
            actionResult.setJSCode(strScript);
        }
        catch (Exception ex) {
            actionResult.setRetCode(1);
            actionResult.setErrorInfo(StringHelper.Format((String)"\u5bfc\u51fa\u5230Excel\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)actionResult.getErrorInfo(), (Throwable)ex);
        }
        return actionResult;
    }

    protected SRFDABIActionResult OnFetchChart() throws Exception {
        SRFDABIActionResult actionResult = new SRFDABIActionResult();
        String strBISessionId = SRFDABIWebCTXHelper.GetBISessionId((ISRFDAWebContext)this.getWebContext());
        String strBIFilter = SRFDABIWebCTXHelper.GetBIFilterId((ISRFDAWebContext)this.getWebContext());
        String strBIExtQuery = SRFDABIWebCTXHelper.GetBIExtQuery((ISRFDAWebContext)this.getWebContext());
        boolean bModelOnly = SRFDABIWebCTXHelper.GetBIModelOnly((ISRFDAWebContext)this.getWebContext(), (boolean)false);
        IBICubeCache iBICubeCache = this.iBIUserSessionStorage.GetBICubeCache(this.getIBIReportEx().getBICube(), strBIFilter, "CHART");
        Vector<IBIRepDMHelper> rowDimensions = new Vector<IBIRepDMHelper>();
        for (IBIRepDMHelper iBIRepDMHelper : this.iReportExHelper.getLeftDimensions()) {
            if (!iBICubeCache.hasBIHierarchyFilter(iBIRepDMHelper.getBIHierarchy().getUniqueName())) continue;
            rowDimensions.add(iBIRepDMHelper);
        }
        for (IBIRepDMHelper iBIRepDMHelper : this.iReportExHelper.getTopDimensions()) {
            if (!iBICubeCache.hasBIHierarchyFilter(iBIRepDMHelper.getBIHierarchy().getUniqueName())) continue;
            rowDimensions.add(iBIRepDMHelper);
        }
        int nStartRow = SRFDABIWebCTXHelper.GetBIStartRow((ISRFDAWebContext)this.getWebContext(), (int)1);
        int nPageSize = SRFDABIWebCTXHelper.GetBIPageSize((ISRFDAWebContext)this.getWebContext(), (int)10000);
        boolean bSortMode = false;
        BICubeCacheSortInfo sortInfo = null;
        BICubeCacheCondition condition = null;
        if (!StringHelper.IsNullOrEmpty((String)strBIExtQuery)) {
            JSONObject extCondition = null;
            JSONObject extSortInfo = null;
            JSONObject extQuery = JSONObject.fromString((String)strBIExtQuery);
            if (extQuery.has("condition")) {
                extCondition = extQuery.getJSONObject("condition");
                condition = new BICubeCacheCondition(extCondition);
            }
            if (extQuery.has("sortinfo")) {
                extSortInfo = extQuery.getJSONObject("sortinfo");
                bSortMode = true;
                sortInfo = new BICubeCacheSortInfo(extSortInfo);
                if (sortInfo.getSortField().indexOf("[Measures].") == 0) {
                    IBICubeMeasureHelper iBICubeMeasureHelper = this.iReportExHelper.getBICube().FindBICubeMeasure(sortInfo.getSortField());
                    sortInfo.setSortField(iBICubeMeasureHelper.getShortId());
                }
            }
        }
        BIReportExModel biReportExModel = new BIReportExModel();
        biReportExModel.Init(this.getIBIReportEx(), iBICubeCache, "CHART", false);
        if (!bModelOnly) {
            int nTotalRow = 0;
            int nDMRowCount = 1;
            Vector rowDMDataInfos = new Vector();
            this.getIBIReportEx().GetChartRowDimensionDataInfo(iBICubeCache, rowDMDataInfos, condition);
            int[] rowLoopCount = null;
            if (rowDMDataInfos.size() > 0) {
                rowLoopCount = new int[rowDMDataInfos.size()];
                nTotalRow = 1;
                int i = 0;
                while (i < rowDMDataInfos.size()) {
                    rowLoopCount[i] = 1;
                    BaseDataEntity rowDMDataInfo = (BaseDataEntity)rowDMDataInfos.get(i);
                    int nRowCount = rowDMDataInfo.GetParamIntValue("Count", 0);
                    nTotalRow *= nRowCount;
                    if (i > 0) {
                        nDMRowCount *= nRowCount;
                    }
                    int j = 0;
                    while (j < i) {
                        rowLoopCount[j] = rowLoopCount[j] * nRowCount;
                        ++j;
                    }
                    ++i;
                }
            }
            if (nTotalRow == 0) {
                return actionResult;
            }
            if (nStartRow > nTotalRow + 1) {
                return actionResult;
            }
            int nEndRow = nStartRow + nPageSize - 1;
            if (nEndRow > nTotalRow) {
                nEndRow = nTotalRow;
            }
            int nStartDMIndex = nStartRow / nDMRowCount + (nStartRow % nDMRowCount == 0 ? 0 : 1);
            int nEndDMIndex = nEndRow / nDMRowCount + (nEndRow % nDMRowCount == 0 ? 0 : 1);
            IBIHierarchyHelper firstBIHierarchyHelper = ((IBIRepDMHelper)rowDimensions.get(0)).getBIHierarchy();
            String strBIHierarchy = firstBIHierarchyHelper.getUniqueName();
            String strFirstDMExtQuery = "";
            if (condition != null && condition.hasCondition(strBIHierarchy)) {
                strFirstDMExtQuery = condition.getCondition(strBIHierarchy);
            }
            Hashtable<String, BaseDataEntity> datas = new Hashtable<String, BaseDataEntity>();
            Vector<IBIHierarchyHelper> allBIHierarchies = new Vector<IBIHierarchyHelper>();
            for (IBIRepDMHelper iBIRepDMHelper : rowDimensions) {
                allBIHierarchies.add(iBIRepDMHelper.getBIHierarchy());
            }
            Vector<BaseDataEntity> rowDatas = new Vector<BaseDataEntity>();
            if (condition == null) {
                if (!bSortMode) {
                    iBICubeCache.FetchDataByBIHierarchy(strBIHierarchy, nStartDMIndex, nEndDMIndex, allBIHierarchies, datas);
                } else {
                    iBICubeCache.FetchData(condition, sortInfo, allBIHierarchies, rowDatas);
                }
            } else if (!bSortMode) {
                iBICubeCache.FetchData(condition, allBIHierarchies, datas);
            } else {
                iBICubeCache.FetchData(condition, sortInfo, allBIHierarchies, rowDatas);
            }
            if (!bSortMode) {
                Vector firstRowDMDatas = iBICubeCache.getBIHierarchyDatas(strBIHierarchy, strFirstDMExtQuery);
                int i = nStartDMIndex - 1;
                while (i < nEndDMIndex) {
                    BaseDataEntity dmData = (BaseDataEntity)firstRowDMDatas.get(i);
                    BaseDataEntity rowData = new BaseDataEntity();
                    Iterator strRowKey = firstBIHierarchyHelper.getDataKey(dmData);
                    rowData.SetParamValue(firstBIHierarchyHelper.getShortId(), (Object)firstBIHierarchyHelper.getDataCaption(dmData));
                    rowData.SetParamValue(String.valueOf(firstBIHierarchyHelper.getShortId()) + "K", strRowKey);
                    rowData.SetParamValue("SRFROWKEY", strRowKey);
                    rowDatas.add(rowData);
                    this.BuildChartRowDatas(rowDatas, rowData, rowDimensions, 1, condition, iBICubeCache, datas);
                    ++i;
                }
            }
            if (rowDatas.size() > 0) {
                BaseDataEntity firstRow = (BaseDataEntity)rowDatas.get(0);
                Vector columns = new Vector();
                for (Object objKey : firstRow.getTotalParamList().keySet()) {
                    columns.add(objKey);
                }
                StringBuilderEx sb = new StringBuilderEx();
                sb.Append("\r\n---------------------------------------------------------------------------------------\r\n");
                for (Object objKey : columns) {
                    sb.Append("%1$s\t\t", objKey);
                }
                sb.Append("\r\n");
                for (BaseDataEntity rowData : rowDatas) {
                    for (Object objKey : columns) {
                        sb.Append("%1$s\t\t", rowData.GetParamValue(objKey.toString()));
                    }
                    sb.Append("\r\n");
                }
                log.info((Object)sb.toString());
            }
            Vector<BaseDataEntity> retRowDatas = new Vector<BaseDataEntity>();
            if (bSortMode) {
                int i = 0;
                while (i < rowDatas.size()) {
                    BaseDataEntity data = (BaseDataEntity)rowDatas.get(i);
                    String strCurRowKey = "";
                    int j = 0;
                    while (j < rowDimensions.size()) {
                        IBIHierarchyHelper iBIHierarchyHelper = ((IBIRepDMHelper)rowDimensions.get(j)).getBIHierarchy();
                        String strDataCaption = iBIHierarchyHelper.getDataCaption(data);
                        String strDataKey = iBIHierarchyHelper.getDataKey(data);
                        data.SetParamValue(iBIHierarchyHelper.getShortId(), (Object)strDataCaption);
                        data.SetParamValue(String.valueOf(iBIHierarchyHelper.getShortId()) + "K", (Object)strDataKey);
                        if (!StringHelper.IsNullOrEmpty((String)strCurRowKey)) {
                            strCurRowKey = String.valueOf(strCurRowKey) + ";";
                        }
                        strCurRowKey = String.valueOf(strCurRowKey) + strDataKey;
                        ++j;
                    }
                    data.SetParamValue("SRFROWKEY", (Object)strCurRowKey);
                    retRowDatas.add(data);
                    ++i;
                }
                biReportExModel.setTotalRow(rowDatas.size());
                biReportExModel.setPageSize(rowDatas.size());
                biReportExModel.setPageNo(1);
            } else {
                int nCurStartRow = (nStartDMIndex - 1) * nDMRowCount + 1;
                int nInterval = nStartRow - nCurStartRow;
                int nCnt = 0;
                int i = nInterval;
                while (i < rowDatas.size()) {
                    retRowDatas.add((BaseDataEntity)rowDatas.get(i));
                    if (++nCnt >= nPageSize) break;
                    ++i;
                }
                biReportExModel.setTotalRow(nTotalRow);
                biReportExModel.setPageSize(nPageSize);
                biReportExModel.setPageNo(nStartRow / nPageSize + (nStartRow % nPageSize == 0 ? 0 : 1));
            }
            biReportExModel.setRowDatas(retRowDatas);
        }
        actionResult.setModel(biReportExModel.ToJSONObject());
        return actionResult;
    }

    protected void BuildChartRowDatas(Vector<BaseDataEntity> rowDatas, BaseDataEntity rowData, Vector<IBIRepDMHelper> rowDimensions, int nRowDMIndex, BICubeCacheCondition extCondition, IBICubeCache iBICubeCache, Hashtable<String, BaseDataEntity> datas) throws Exception {
        if (nRowDMIndex >= rowDimensions.size()) {
            this.BuildChartRowMeasures(rowData, "", "", iBICubeCache, datas);
            return;
        }
        IBIHierarchyHelper iBIHierarchyHelper = rowDimensions.get(nRowDMIndex).getBIHierarchy();
        String strFirstDMExtQuery = "";
        if (extCondition != null && extCondition.hasCondition(iBIHierarchyHelper.getUniqueName())) {
            strFirstDMExtQuery = extCondition.getCondition(iBIHierarchyHelper.getUniqueName());
        }
        Vector dmDatas = iBICubeCache.getBIHierarchyDatas(iBIHierarchyHelper.getUniqueName(), strFirstDMExtQuery);
        BaseDataEntity activeRowData = null;
        String strCurRowKey = rowData.GetParamStringValue("SRFROWKEY", "");
        int i = 0;
        while (i < dmDatas.size()) {
            BaseDataEntity dmData = (BaseDataEntity)dmDatas.get(i);
            String strDataCaption = iBIHierarchyHelper.getDataCaption(dmData);
            String strDataKey = iBIHierarchyHelper.getDataKey(dmData);
            if (i == 0) {
                activeRowData = rowData;
            } else {
                activeRowData = new BaseDataEntity();
                rowData.CopyTo(activeRowData, false);
                rowDatas.add(activeRowData);
            }
            String strRowKey = StringHelper.Format((String)"%1$s;%2$s", (Object)strCurRowKey, (Object)strDataKey);
            activeRowData.SetParamValue("SRFROWKEY", (Object)strRowKey);
            activeRowData.SetParamValue(iBIHierarchyHelper.getShortId(), (Object)strDataCaption);
            activeRowData.SetParamValue(String.valueOf(iBIHierarchyHelper.getShortId()) + "K", (Object)strDataKey);
            this.BuildChartRowDatas(rowDatas, activeRowData, rowDimensions, nRowDMIndex + 1, extCondition, iBICubeCache, datas);
            ++i;
        }
    }

    protected void BuildChartRowMeasures(BaseDataEntity rowData, String strMeasureId, String strMeasureKey, IBICubeCache iBICubeCache, Hashtable<String, BaseDataEntity> datas) throws Exception {
        String strRowKey;
        String strTotalKey = strRowKey = rowData.GetParamStringValue("SRFROWKEY", "");
        if (!StringHelper.IsNullOrEmpty((String)strMeasureKey)) {
            strTotalKey = StringHelper.IsNullOrEmpty((String)strTotalKey) ? strMeasureKey : StringHelper.Format((String)"%1$s;%2$s", (Object)strTotalKey, (Object)strMeasureKey);
        }
        BaseDataEntity data = datas.get(strTotalKey);
        int i = 0;
        while (i < this.iReportExHelper.getMeasures().size()) {
            IBICubeMeasureHelper iBICubeMeasureHelper = ((IBIRepMSHelper)this.iReportExHelper.getMeasures().get(i)).getBICubeMeasure();
            String strTotalMeasureId = strMeasureKey;
            if (!StringHelper.IsNullOrEmpty((String)strTotalMeasureId)) {
                strTotalMeasureId = String.valueOf(strTotalMeasureId) + ";";
            }
            strTotalMeasureId = String.valueOf(strTotalMeasureId) + iBICubeMeasureHelper.getShortId();
            if (data != null) {
                rowData.SetParamValue(strTotalMeasureId, data.GetParamValue(iBICubeMeasureHelper.getShortId()));
            } else {
                rowData.SetParamValue(strTotalMeasureId, null);
            }
            ++i;
        }
    }
}

