/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.SessionData
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.SearchForm.BaseDASearchFormActionHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.Form.SRFExFormSearchResult
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.BI.Ctrl.SearchForm;

import SA.SRFDA.BI.Ctrl.DEDataCtrl.BIHierarchyDataCtrl;
import SA.SRFDA.BI.Ctrl.Data.BIHierarchy;
import SA.SRFDA.BI.Ctrl.Data.BILevel;
import SA.SRFDA.BI.Ctrl.Data.BIReport;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.SessionData;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.SearchForm.BaseDASearchFormActionHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.Form.SRFExFormSearchResult;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class BIQuerySearchFormActionHelper
extends BaseDASearchFormActionHelper {
    protected String OnSearchActionOutputResult(BaseDataEntity baseDataEntity, SRFExFormSearchResult searchResult) {
        if (baseDataEntity.getParamList() != null) {
            JSONObject item;
            int i;
            BIReport biReport = this.GetBIReport();
            String strBICubeId = biReport.getBICUBEID();
            BIHierarchyDataCtrl hrcDataCtrl = (BIHierarchyDataCtrl)this.getPage().GetDEDataCtrl("BI0005");
            if (hrcDataCtrl == null) {
                searchResult.setRetCode(1);
                searchResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"BI0005"));
                return searchResult.ToJSONString();
            }
            Hashtable<String, JSONObject> rowsMap = new Hashtable<String, JSONObject>();
            Hashtable<String, JSONObject> colsMap = new Hashtable<String, JSONObject>();
            JSONObject jsonObject = JSONObject.fromString((String)biReport.getREPORTMODEL());
            if (jsonObject.has("rows")) {
                JSONArray rowsObject = (JSONArray)jsonObject.get("rows");
                i = 0;
                while (i < rowsObject.length()) {
                    item = (JSONObject)rowsObject.get(i);
                    rowsMap.put(item.getString("Dimension"), item);
                    ++i;
                }
            }
            if (jsonObject.has("cols")) {
                JSONArray colsObject = (JSONArray)jsonObject.get("cols");
                i = 0;
                while (i < colsObject.length()) {
                    item = (JSONObject)colsObject.get(i);
                    colsMap.put(item.getString("Dimension"), item);
                    ++i;
                }
            }
            Vector<JSONObject> filters = new Vector<JSONObject>();
            Vector<Object> rowfm2loads = new Vector<Object>();
            Vector<JSONObject> colfm2loads = new Vector<JSONObject>();
            Vector<JSONObject> filterfm2loads = new Vector<JSONObject>();
            Vector<Object> rowhc2exps = new Vector<Object>();
            Vector<JSONObject> colhc2exps = new Vector<JSONObject>();
            Vector<JSONObject> filterhc2exps = new Vector<JSONObject>();
            Hashtable<String, String> hc2expMap = new Hashtable<String, String>();
            Vector<JSONObject> fm2exps = new Vector<JSONObject>();
            Enumeration en = baseDataEntity.getParamList().keys();
            block2: while (en.hasMoreElements()) {
                String strCurHierarchyName;
                JSONObject jo;
                String[] checkItems;
                String strKey = (String)en.nextElement();
                String strValue = baseDataEntity.GetParamStringValue(strKey, "");
                String[] paramItems = StringHelper.Split((String)strValue, (String)"%|SRF2|%");
                if (paramItems.length != 2) continue;
                if (StringHelper.Compare((String)paramItems[0], (String)"NORMAL", (boolean)true) == 0) {
                    strValue = paramItems[1];
                    checkItems = StringHelper.Split((String)strValue, (String)"%|SRF|%");
                    BIHierarchy biHierarchy = null;
                    boolean bRow = false;
                    boolean bCol = false;
                    boolean bFilter = false;
                    int i2 = 0;
                    while (i2 < checkItems.length) {
                        String[] checkitem;
                        String[] items = StringHelper.Split((String)checkItems[i2], (String)"%|SRF1|%");
                        if (items.length == 2 && (checkitem = items[0].split("[;]")).length >= 1) {
                            String strNodeId = checkitem[0];
                            String[] nodeids = strNodeId.split("[|]");
                            if (StringHelper.Compare((String)nodeids[0], (String)"HRC", (boolean)true) == 0) {
                                JSONObject fmjo;
                                String strCurHierarchyName2;
                                JSONObject jo2;
                                String strHRCId = nodeids[1];
                                biHierarchy = new BIHierarchy();
                                biHierarchy.setBIHIERARCHYID(strHRCId);
                                CallResult callResult = hrcDataCtrl.Get(biHierarchy);
                                if (callResult.IsError()) {
                                    searchResult.From(callResult);
                                    return searchResult.ToJSONString();
                                }
                                String strHierarchyName = StringHelper.Format((String)"[%1$s.%2$s]", (Object)biHierarchy.getBIDIMENSIONNAME(), (Object)biHierarchy.getBIHIERARCHYNAME());
                                String strDimensionName = StringHelper.Format((String)"[%1$s]", (Object)biHierarchy.getBIDIMENSIONNAME());
                                if (rowsMap.containsKey(strDimensionName)) {
                                    jo2 = (JSONObject)rowsMap.get(strDimensionName);
                                    strCurHierarchyName2 = jo2.getString("Hierarchy");
                                    if (StringHelper.Compare((String)strCurHierarchyName2, (String)strHierarchyName, (boolean)false) != 0) {
                                        jo2.remove("Hierarchy");
                                        jo2.put("Hierarchy", (Object)strHierarchyName);
                                    }
                                    bRow = true;
                                    if (StringHelper.Compare((String)items[1], (String)"2", (boolean)true) != 0) {
                                        fmjo = new JSONObject();
                                        fmjo.put("selected", true);
                                        fmjo.put("name", (Object)StringHelper.Format((String)"[%1$s.%2$s].[All %1$s.%2$ss]", (Object)biHierarchy.getBIDIMENSIONNAME(), (Object)biHierarchy.getBIHIERARCHYNAME()));
                                        rowfm2loads.add(0, fmjo);
                                    }
                                } else if (colsMap.containsKey(strDimensionName)) {
                                    jo2 = (JSONObject)colsMap.get(strDimensionName);
                                    strCurHierarchyName2 = jo2.getString("Hierarchy");
                                    if (StringHelper.Compare((String)strCurHierarchyName2, (String)strHierarchyName, (boolean)false) != 0) {
                                        jo2.remove("Hierarchy");
                                        jo2.put("Hierarchy", (Object)strHierarchyName);
                                    }
                                    bCol = true;
                                    if (StringHelper.Compare((String)items[1], (String)"2", (boolean)true) != 0) {
                                        fmjo = new JSONObject();
                                        fmjo.put("selected", true);
                                        fmjo.put("name", (Object)StringHelper.Format((String)"[%1$s.%2$s].[All %1$s.%2$ss]", (Object)biHierarchy.getBIDIMENSIONNAME(), (Object)biHierarchy.getBIHIERARCHYNAME()));
                                        colfm2loads.add(0, fmjo);
                                    }
                                } else if (checkItems.length > 1) {
                                    jo2 = new JSONObject();
                                    jo2.put("Dimension", (Object)strDimensionName);
                                    jo2.put("Hierarchy", (Object)strHierarchyName);
                                    filters.add(jo2);
                                    if (StringHelper.Compare((String)items[1], (String)"2", (boolean)true) != 0) {
                                        JSONObject fmjo2 = new JSONObject();
                                        fmjo2.put("selected", true);
                                        fmjo2.put("name", (Object)StringHelper.Format((String)"[%1$s.%2$s].[All %1$s.%2$ss]", (Object)biHierarchy.getBIDIMENSIONNAME(), (Object)biHierarchy.getBIHIERARCHYNAME()));
                                        filterfm2loads.add(0, fmjo2);
                                    }
                                    bFilter = true;
                                }
                            } else {
                                String strLevel = StringHelper.Format((String)"[%1$s.%2$s]", (Object)biHierarchy.getBIDIMENSIONNAME(), (Object)biHierarchy.getBIHIERARCHYNAME());
                                String strDimensionName = StringHelper.Format((String)"[%1$s]", (Object)biHierarchy.getBIDIMENSIONNAME());
                                int j = checkitem.length - 1;
                                while (j >= 1) {
                                    if (!StringHelper.IsNullOrEmpty((String)strLevel)) {
                                        strLevel = String.valueOf(strLevel) + ".";
                                    }
                                    strLevel = String.valueOf(strLevel) + StringHelper.Format((String)"[%1$s]", (Object)checkitem[j]);
                                    --j;
                                }
                                if (StringHelper.Compare((String)items[1], (String)"2", (boolean)true) != 0) {
                                    JSONObject jo2 = new JSONObject();
                                    jo2.put("name", (Object)strLevel);
                                    jo2.put("selected", StringHelper.Compare((String)items[1], (String)"1", (boolean)true) == 0);
                                    if (rowsMap.containsKey(strDimensionName)) {
                                        rowfm2loads.add(0, jo2);
                                    } else if (colsMap.containsKey(strDimensionName)) {
                                        colfm2loads.add(0, jo2);
                                    } else {
                                        filterfm2loads.add(0, jo2);
                                    }
                                }
                                String strExpandLevel = "";
                                int j2 = checkitem.length - 1;
                                while (j2 >= 2) {
                                    if (!StringHelper.IsNullOrEmpty((String)strExpandLevel)) {
                                        strExpandLevel = String.valueOf(strExpandLevel) + ".";
                                    }
                                    strExpandLevel = String.valueOf(strExpandLevel) + StringHelper.Format((String)"[%1$s]", (Object)checkitem[j2]);
                                    --j2;
                                }
                                strExpandLevel = StringHelper.IsNullOrEmpty((String)strExpandLevel) ? StringHelper.Format((String)"[%1$s.%2$s].[All %1$s.%2$ss]", (Object)biHierarchy.getBIDIMENSIONNAME(), (Object)biHierarchy.getBIHIERARCHYNAME()) : StringHelper.Format((String)"[%1$s.%2$s].%3$s", (Object)biHierarchy.getBIDIMENSIONNAME(), (Object)biHierarchy.getBIHIERARCHYNAME(), (Object)strExpandLevel);
                                if (bRow || bCol) {
                                    if (!hc2expMap.containsKey(strExpandLevel)) {
                                        JSONObject hcjo = new JSONObject();
                                        hcjo.put("row", bRow);
                                        hcjo.put("name", (Object)strExpandLevel);
                                        if (rowsMap.containsKey(strDimensionName)) {
                                            rowhc2exps.add(0, hcjo);
                                        } else if (colsMap.containsKey(strDimensionName)) {
                                            colhc2exps.add(0, hcjo);
                                        } else {
                                            filterhc2exps.add(0, hcjo);
                                        }
                                        hc2expMap.put(strExpandLevel, "");
                                    }
                                } else {
                                    JSONObject hcjo = new JSONObject();
                                    hcjo.put("name", (Object)strExpandLevel);
                                    hcjo.put("expanded", true);
                                    fm2exps.add(0, hcjo);
                                }
                            }
                        }
                        ++i2;
                    }
                    continue;
                }
                if (StringHelper.Compare((String)paramItems[0], (String)"TD", (boolean)true) != 0 || (checkItems = StringHelper.Split((String)(strValue = paramItems[1]), (String)"%|SRF1|%")).length != 4 || StringHelper.IsNullOrEmpty((String)checkItems[1])) continue;
                String strDimensionType = checkItems[1];
                String strHRCId = checkItems[0];
                boolean bRow = false;
                boolean bCol = false;
                boolean bFilter = false;
                BIHierarchy biHierarchy = null;
                biHierarchy = new BIHierarchy();
                biHierarchy.setBIHIERARCHYID(strHRCId);
                CallResult callResult = hrcDataCtrl.Get(biHierarchy);
                if (callResult.IsError()) {
                    searchResult.From(callResult);
                    return searchResult.ToJSONString();
                }
                String strHierarchyName = StringHelper.Format((String)"[%1$s.%2$s]", (Object)biHierarchy.getBIDIMENSIONNAME(), (Object)biHierarchy.getBIHIERARCHYNAME());
                String strDimensionName = StringHelper.Format((String)"[%1$s]", (Object)biHierarchy.getBIDIMENSIONNAME());
                char chType = strDimensionType.charAt(0);
                strDimensionType = strDimensionType.substring(1);
                Vector<Object> hc2exps = null;
                Vector<Object> fm2loads = null;
                if (rowsMap.containsKey(strDimensionName)) {
                    jo = (JSONObject)rowsMap.get(strDimensionName);
                    strCurHierarchyName = jo.getString("Hierarchy");
                    if (StringHelper.Compare((String)strCurHierarchyName, (String)strHierarchyName, (boolean)false) != 0) {
                        jo.remove("Hierarchy");
                        jo.put("Hierarchy", (Object)strHierarchyName);
                    }
                    bRow = true;
                    fm2loads = rowfm2loads;
                    hc2exps = rowhc2exps;
                } else if (colsMap.containsKey(strDimensionName)) {
                    jo = (JSONObject)colsMap.get(strDimensionName);
                    strCurHierarchyName = jo.getString("Hierarchy");
                    if (StringHelper.Compare((String)strCurHierarchyName, (String)strHierarchyName, (boolean)false) != 0) {
                        jo.remove("Hierarchy");
                        jo.put("Hierarchy", (Object)strHierarchyName);
                    }
                    bCol = true;
                    fm2loads = colfm2loads;
                    hc2exps = colhc2exps;
                } else if (chType != 'H') {
                    jo = new JSONObject();
                    jo.put("Dimension", (Object)strDimensionName);
                    jo.put("Hierarchy", (Object)strHierarchyName);
                    filters.add(jo);
                    bFilter = true;
                    fm2loads = filterfm2loads;
                }
                if (fm2loads == null) continue;
                if (biHierarchy.getHASALL()) {
                    JSONObject hcjo;
                    String strExpandLevel = StringHelper.Format((String)"[%1$s.%2$s].[All %1$s.%2$ss]", (Object)biHierarchy.getBIDIMENSIONNAME(), (Object)biHierarchy.getBIHIERARCHYNAME());
                    if (bRow || bCol) {
                        hcjo = new JSONObject();
                        hcjo.put("row", bRow);
                        hcjo.put("name", (Object)strExpandLevel);
                        hc2exps.add(0, hcjo);
                    } else {
                        hcjo = new JSONObject();
                        hcjo.put("name", (Object)strExpandLevel);
                        hcjo.put("expanded", true);
                        fm2exps.add(0, hcjo);
                    }
                }
                if (chType == 'H') {
                    JSONObject fmjo = new JSONObject();
                    fmjo.put("selected", true);
                    fmjo.put("name", (Object)StringHelper.Format((String)"[%1$s.%2$s].[All %1$s.%2$ss]", (Object)biHierarchy.getBIDIMENSIONNAME(), (Object)biHierarchy.getBIHIERARCHYNAME()));
                    fm2loads.add(0, fmjo);
                    continue;
                }
                Vector<BILevel> biLevels = new Vector<BILevel>();
                callResult = hrcDataCtrl.ListBILevels(biHierarchy.getBIHIERARCHYID(), biLevels);
                if (callResult.IsError()) {
                    searchResult.setRetCode(1);
                    searchResult.setErrorInfo(StringHelper.Format((String)"\u67e5\u8be2\u7ef4\u5ea6\u4f53\u7cfb[%1$s]\u7ea7\u522b\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)biHierarchy.getBIHIERARCHYID(), (Object)callResult.getErrorInfo()));
                    return searchResult.ToJSONString();
                }
                IDEHelper hrcDEHelper = this.getPage().getDAModelStorage().FindDEHelper(biHierarchy.getDEID());
                if (hrcDEHelper == null) {
                    searchResult.setRetCode(1);
                    searchResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)biHierarchy.getDEID()));
                    return searchResult.ToJSONString();
                }
                if (StringHelper.IsNullOrEmpty((String)biHierarchy.getTIMEDEFID())) {
                    searchResult.setRetCode(1);
                    searchResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u7ef4\u5ea6\u4f53\u7cfb[%1$s]\u65f6\u95f4\u5c5e\u6027", (Object)biHierarchy.getBIHIERARCHYID()));
                    return searchResult.ToJSONString();
                }
                IDEFHelper timeDEFHelper = hrcDEHelper.GetDEFHelper(biHierarchy.getTIMEDEFID());
                if (timeDEFHelper == null) {
                    searchResult.setRetCode(1);
                    searchResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)biHierarchy.getTIMEDEFID()));
                    return searchResult.ToJSONString();
                }
                String strFromDate = checkItems[2];
                String strToDate = checkItems[3];
                String strCondSql = "";
                CallParamList callParamList = new CallParamList();
                if (!StringHelper.IsNullOrEmpty((String)strFromDate)) {
                    callParamList.AddDateTime((Object)strFromDate);
                    if (!StringHelper.IsNullOrEmpty((String)strCondSql)) {
                        strCondSql = String.valueOf(strCondSql) + " AND ";
                    }
                    strCondSql = String.valueOf(strCondSql) + StringHelper.Format((String)" %1$s>=? ", (Object)timeDEFHelper.GetDTColumn().GetColumnName());
                }
                if (!StringHelper.IsNullOrEmpty((String)strToDate)) {
                    callParamList.AddDateTime((Object)strToDate);
                    if (!StringHelper.IsNullOrEmpty((String)strCondSql)) {
                        strCondSql = String.valueOf(strCondSql) + " AND ";
                    }
                    strCondSql = String.valueOf(strCondSql) + StringHelper.Format((String)" %1$s<=? ", (Object)timeDEFHelper.GetDTColumn().GetColumnName());
                }
                if (!StringHelper.IsNullOrEmpty((String)strCondSql)) {
                    strCondSql = " WHERE " + strCondSql;
                }
                Vector<IDEFHelper> levelDEFHelpers = new Vector<IDEFHelper>();
                Vector<IDEFHelper> groupDEFHelpers = new Vector<IDEFHelper>();
                for (BILevel biLevel : biLevels) {
                    String strLevelKey;
                    IDEFHelper levelDEFHelper = hrcDEHelper.GetDEFHelper(biLevel.getDEFID());
                    if (levelDEFHelper == null) {
                        searchResult.setRetCode(1);
                        searchResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)biLevel.getDEFID()));
                        return searchResult.ToJSONString();
                    }
                    groupDEFHelpers.add(levelDEFHelper);
                    IDEFHelper capDEFHelper = levelDEFHelper;
                    if (!StringHelper.IsNullOrEmpty((String)biLevel.getCAPDEFID())) {
                        capDEFHelper = hrcDEHelper.GetDEFHelper(biLevel.getCAPDEFID());
                        if (capDEFHelper == null) {
                            searchResult.setRetCode(1);
                            searchResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)biLevel.getCAPDEFID()));
                            return searchResult.ToJSONString();
                        }
                        groupDEFHelpers.add(capDEFHelper);
                    }
                    levelDEFHelpers.add(capDEFHelper);
                    StringBuilderEx sql = new StringBuilderEx();
                    sql.Append("SELECT ");
                    boolean bFirst = true;
                    for (IDEFHelper tempDEFHelper : groupDEFHelpers) {
                        if (bFirst) {
                            bFirst = false;
                        } else {
                            sql.Append(",");
                        }
                        sql.Append("%1$s", (Object)tempDEFHelper.GetDTColumn().GetColumnName());
                    }
                    sql.Append(" FROM %1$s ", (Object)hrcDEHelper.GetMainTable());
                    sql.Append(" __CONDITION__  ");
                    sql.Append("GROUP BY ");
                    bFirst = true;
                    for (IDEFHelper tempDEFHelper : groupDEFHelpers) {
                        if (bFirst) {
                            bFirst = false;
                        } else {
                            sql.Append(",");
                        }
                        sql.Append("%1$s", (Object)tempDEFHelper.GetDTColumn().GetColumnName());
                    }
                    String strSQL = sql.toString();
                    Vector results = new Vector();
                    callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), (String)hrcDEHelper.GetDBStorage(), (String)strSQL.replaceAll("__CONDITION__", ""), null, results, (String)"");
                    if (callResult.IsError()) {
                        searchResult.setRetCode(1);
                        searchResult.setErrorInfo(StringHelper.Format((String)"\u67e5\u8be2\u5206\u7ec4\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        return searchResult.ToJSONString();
                    }
                    Hashtable<String, Boolean> levelMap = new Hashtable<String, Boolean>();
                    for (BaseDataEntity dataEntity : results) {
                        strLevelKey = strHierarchyName;
                        for (IDEFHelper tempDEFHelper : levelDEFHelpers) {
                            strLevelKey = String.valueOf(strLevelKey) + StringHelper.Format((String)".[%1$s]", (Object)dataEntity.GetParamValue(tempDEFHelper.GetDTColumn().GetColumnName()));
                        }
                        levelMap.put(strLevelKey, false);
                    }
                    results.clear();
                    callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), (String)hrcDEHelper.GetDBStorage(), (String)strSQL.replaceAll("__CONDITION__", strCondSql), (Vector)callParamList.GetList(), results, (String)"");
                    if (callResult.IsError()) {
                        searchResult.setRetCode(1);
                        searchResult.setErrorInfo(StringHelper.Format((String)"\u67e5\u8be2\u5206\u7ec4\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        return searchResult.ToJSONString();
                    }
                    for (BaseDataEntity dataEntity : results) {
                        strLevelKey = strHierarchyName;
                        for (IDEFHelper tempDEFHelper : levelDEFHelpers) {
                            strLevelKey = String.valueOf(strLevelKey) + StringHelper.Format((String)".[%1$s]", (Object)dataEntity.GetParamValue(tempDEFHelper.GetDTColumn().GetColumnName()));
                        }
                        if (!levelMap.containsKey(strLevelKey)) continue;
                        levelMap.put(strLevelKey, true);
                    }
                    boolean bCurLevel = StringHelper.Compare((String)biLevel.getBILEVELID(), (String)strDimensionType, (boolean)true) == 0;
                    for (String strLevelKey2 : levelMap.keySet()) {
                        JSONObject hcjo;
                        JSONObject fmjo;
                        if (!((Boolean)levelMap.get(strLevelKey2)).booleanValue()) {
                            fmjo = new JSONObject();
                            fmjo.put("selected", false);
                            fmjo.put("name", (Object)strLevelKey2);
                            fm2loads.add(0, fmjo);
                            continue;
                        }
                        if (bCurLevel) {
                            fmjo = new JSONObject();
                            fmjo.put("selected", true);
                            fmjo.put("name", (Object)strLevelKey2);
                            fm2loads.add(0, fmjo);
                            continue;
                        }
                        if (bRow || bCol) {
                            hcjo = new JSONObject();
                            hcjo.put("row", bRow);
                            hcjo.put("name", (Object)strLevelKey2);
                            hc2exps.add(0, hcjo);
                            continue;
                        }
                        hcjo = new JSONObject();
                        hcjo.put("name", (Object)strLevelKey2);
                        hcjo.put("expanded", true);
                        fm2exps.add(0, hcjo);
                    }
                    if (bCurLevel) continue block2;
                }
            }
            jsonObject.remove("filters");
            jsonObject.remove("fm2load");
            jsonObject.remove("hc2exp");
            jsonObject.remove("fm2exp");
            jsonObject.put("filters", (Object)JSONArray.fromArray((Object[])filters.toArray()));
            rowfm2loads.addAll(colfm2loads);
            rowfm2loads.addAll(filterfm2loads);
            jsonObject.put("fm2load", (Object)JSONArray.fromArray((Object[])rowfm2loads.toArray()));
            rowhc2exps.addAll(colhc2exps);
            rowhc2exps.addAll(filterhc2exps);
            jsonObject.put("hc2exp", (Object)JSONArray.fromArray((Object[])rowhc2exps.toArray()));
            jsonObject.put("fm2exp", (Object)JSONArray.fromArray((Object[])fm2exps.toArray()));
            String strSessionDataId = Helper.GenGuidEx();
            SessionData sessionData = new SessionData();
            sessionData.setDATA(jsonObject.toString());
            sessionData.setSESSIONDATAID(String.valueOf(this.getWebContext().getSessionId()) + "_" + strSessionDataId);
            CallResult callResult = this.getPage().getDAModelStorage().GetSessionDataDataCtrl().Save(true, (BaseDataEntity)sessionData);
            if (callResult.IsError()) {
                searchResult.From(callResult);
                return searchResult.ToJSONString();
            }
            String strScript = StringHelper.Format((String)"hidesp();Ext.getDom('%3$s').src='../srfbiui2/slpivottableview.jsp?BIREPORTID=%1$s&SESSIONDATAID=%2$s&SRFEMBEDMODE=TRUE';", (Object)biReport.getBIREPORTID(), (Object)strSessionDataId, (Object)this.getPage().GetCtrlUniqueId("iFrame"));
            searchResult.setJSCode(strScript);
        }
        return super.OnSearchActionOutputResult(baseDataEntity, searchResult);
    }

    public BIReport GetBIReport() {
        return (BIReport)((Object)this.getPage().getPageParam("BIREPORT"));
    }
}

