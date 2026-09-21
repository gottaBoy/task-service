/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.SRFDAPageEx
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.BI.Web;

import SA.SRFDA.BI.Ctrl.Data.BICube;
import SA.SRFDA.BI.Ctrl.Data.BILevel;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DrillRedirectPage
extends SRFDAPageEx {
    protected boolean PreparePageEnv() {
        Vector<JSONObject> conditions2;
        Vector<JSONObject> conditions;
        BICube biCube;
        block31: {
            if (!super.PreparePageEnv()) {
                return false;
            }
            String strBICube = this.getWebContext().GetParamValue("BICUBE");
            if (StringHelper.IsNullOrEmpty((String)strBICube)) {
                this.OutputAlertMsg("\u6ca1\u6709\u6307\u5b9a\u5206\u6790\u7acb\u65b9\u4f53\u5bf9\u8c61", false);
                return false;
            }
            biCube = new BICube();
            biCube.setBICUBENAME(strBICube);
            IDEDataCtrl biCubeDataCtrl = this.GetDEDataCtrl("BI0001");
            if (biCubeDataCtrl == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"BI0001"));
                return false;
            }
            CallResult callResult = biCubeDataCtrl.Select((BaseDataEntity)biCube);
            if (callResult.IsError()) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u67e5\u8be2\u5206\u6790\u7acb\u65b9\u4f53[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strBICube, (Object)callResult.getErrorInfo()));
                this.OutputAlertMsg("\u67e5\u8be2\u5206\u6790\u7acb\u65b9\u4f53\u5bf9\u8c61\u5931\u8d25", false);
                return false;
            }
            String strQueryFormat = "select t1.DEFID,t2.DEID,t1.CAPDEFID from T_SRFBILEVEL t1 INNER JOIN T_SRFBIHIERARCHY t2 ON t1.BIHIERARCHYID = t2.BIHIERARCHYID INNER JOIN T_SRFBIDIMENSION t3  ON t3.BIDIMENSIONID = t2.BIDIMENSIONID where BILEVELNAME='%1$s' AND t3.BIDIMENSIONNAME='%2$s' AND t2.BIHIERARCHYNAME ='%3$s'";
            String strQueryFormat2 = "select t1.DEFID,t2.DEID,t1.CAPDEFID,t1.DEFNAME,t1.CAPDEFNAME from V_SRFBILEVEL t1 INNER JOIN T_SRFBIHIERARCHY t2 ON t1.BIHIERARCHYID = t2.BIHIERARCHYID INNER JOIN T_SRFBIDIMENSION t3  ON t3.BIDIMENSIONID = t2.BIDIMENSIONID where t3.BIDIMENSIONNAME='%1$s' AND t2.BIHIERARCHYNAME ='%2$s' ORDER BY t1.ORDERFLAG";
            Hashtable levelsMap = new Hashtable();
            conditions = new Vector<JSONObject>();
            String strDRILL = this.getWebContext().GetParamValue("DRILL");
            if (!StringHelper.IsNullOrEmpty((String)strDRILL)) {
                strDRILL = strDRILL.replace(";", "$SRF_SRF$");
                strDRILL = strDRILL.replace(",", "%SRF_SRF%");
                strDRILL = strDRILL.replace("$SRF$", ";");
                strDRILL = strDRILL.replace("%SRF%", ",");
                String[] parts = strDRILL.split("[;]");
                int i = 0;
                while (i < parts.length) {
                    String[] conditons = parts[i].split("[,]");
                    if (conditons.length == 2) {
                        String strLevel = conditons[0].replace("$SRF_SRF$", ";");
                        String strCondition = conditons[1].replace("%SRF_SRF%", ",");
                        int nPos = strLevel.indexOf("].[");
                        if (nPos != -1) {
                            String strDimension;
                            String[] dimensions = new String[]{strLevel.substring(0, nPos + 1), strLevel.substring(nPos + 2)};
                            if (StringHelper.Compare((String)dimensions[1], (String)"[(All)]", (boolean)false) != 0 && StringHelper.Length((String)(strDimension = dimensions[0])) >= 2) {
                                String strLevel2;
                                if (strDimension.charAt(0) == '[') {
                                    strDimension = strDimension.substring(1);
                                }
                                if (strDimension.charAt(strDimension.length() - 1) == ']') {
                                    strDimension = strDimension.substring(0, strDimension.length() - 1);
                                }
                                if (StringHelper.Length((String)(strLevel2 = dimensions[1])) >= 2) {
                                    String[] temp;
                                    if (strLevel2.charAt(0) == '[') {
                                        strLevel2 = strLevel2.substring(1);
                                    }
                                    if (strLevel2.charAt(strLevel2.length() - 1) == ']') {
                                        strLevel2 = strLevel2.substring(0, strLevel2.length() - 1);
                                    }
                                    if ((temp = strDimension.split("[.]")).length == 2) {
                                        String strSQL = StringHelper.Format((String)strQueryFormat, (Object)strLevel2, (Object)temp[0], (Object)temp[1]);
                                        BaseDataEntity dataEntity = new BaseDataEntity();
                                        callResult = BaseDEDataCtrl.SelectSingleEx((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), (String)"", (String)strSQL, (BaseDataEntity)dataEntity);
                                        if (callResult.IsError()) {
                                            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u67e5\u8be2[%1$s].[%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)strDimension, (Object)strLevel2, (Object)callResult.getErrorInfo()));
                                            return false;
                                        }
                                        dataEntity.SetParamValue("COND", (Object)strCondition);
                                        String strCapDEFId = dataEntity.GetParamStringValue("CAPDEFID", "");
                                        if (!StringHelper.IsNullOrEmpty((String)strCapDEFId)) {
                                            dataEntity.RemoveParam("CAPDEFID");
                                            dataEntity.SetParamValue("DEFID", (Object)strCapDEFId);
                                        }
                                        JSONObject objJSON = new JSONObject();
                                        dataEntity.FillJSONObject(objJSON, false);
                                        conditions.add(objJSON);
                                    }
                                }
                            }
                        }
                    }
                    ++i;
                }
            }
            conditions2 = new Vector<JSONObject>();
            String strDRILL2 = this.getWebContext().GetParamValue("DRILL2");
            if (StringHelper.IsNullOrEmpty((String)strDRILL2)) break block31;
            strDRILL2 = strDRILL2.replace(";", "$SRF_SRF$");
            strDRILL2 = strDRILL2.replace(",", "%SRF_SRF%");
            strDRILL2 = strDRILL2.replace("$SRF$", ";");
            strDRILL2 = strDRILL2.replace("%SRF%", ",");
            String[] parts = strDRILL2.split("[;]");
            int i = 0;
            while (i < parts.length) {
                block32: {
                    Vector biLevels;
                    String[] items;
                    block34: {
                        block33: {
                            String[] conds = parts[i].split("[,]");
                            if (conds.length != 1) break block32;
                            String strCondition = conds[0];
                            if (strCondition.charAt(0) == '[') {
                                strCondition = strCondition.substring(1);
                            }
                            if (strCondition.charAt(strCondition.length() - 1) == ']') {
                                strCondition = strCondition.substring(0, strCondition.length() - 1);
                            }
                            if ((items = StringHelper.Split((String)strCondition, (String)"].[")).length < 2 || StringHelper.Compare((String)items[1], (String)"(All)", (boolean)false) == 0 || StringHelper.Compare((String)items[1], (String)StringHelper.Format((String)"All %1$ss", (Object)items[0]), (boolean)false) == 0) break block32;
                            biLevels = null;
                            if (!levelsMap.containsKey(items[0])) break block33;
                            biLevels = (Vector)levelsMap.get(items[0]);
                            break block34;
                        }
                        String[] temp = items[0].split("[.]");
                        if (temp.length != 2) break block32;
                        biLevels = new Vector();
                        String strSQL = StringHelper.Format((String)strQueryFormat2, (Object)temp[0], (Object)temp[1]);
                        callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), (String)"", (String)strSQL, null, biLevels, (String)BILevel.class.getName());
                        if (callResult.IsError()) {
                            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u67e5\u8be2[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)items[0], (Object)callResult.getErrorInfo()));
                            return false;
                        }
                        levelsMap.put(items[0], biLevels);
                    }
                    if (biLevels == null || biLevels.size() == 0) {
                        return false;
                    }
                    JSONObject objJSON = new JSONObject();
                    objJSON.put("srfdeid", (Object)((BILevel)((Object)biLevels.get(0))).GetParamStringValue("DEID", ""));
                    int j = 1;
                    while (j < items.length) {
                        if (j > biLevels.size()) {
                            return false;
                        }
                        BILevel biLevel = (BILevel)((Object)biLevels.get(j - 1));
                        String strDEFName = biLevel.getDEFNAME();
                        if (!StringHelper.IsNullOrEmpty((String)biLevel.getCAPDEFNAME())) {
                            strDEFName = biLevel.getCAPDEFNAME();
                        }
                        objJSON.put(strDEFName.toLowerCase(), (Object)items[j]);
                        ++j;
                    }
                    conditions2.add(objJSON);
                }
                ++i;
            }
        }
        JSONArray ja = JSONArray.fromArray((Object[])conditions.toArray());
        this.getWebContext().SetParamValue("SRFBICOND", ja.toString());
        JSONArray ja2 = JSONArray.fromArray((Object[])conditions2.toArray());
        this.getWebContext().SetParamValue("SRFBICOND2", ja2.toString());
        String strMeasure = this.getWebContext().GetParamValue("MEASURE");
        if (!StringHelper.IsNullOrEmpty((String)strMeasure)) {
            this.getWebContext().SetParamValue("SRFBIMEASURE", strMeasure);
        }
        this.getWebContext().RemoveParam("DRILL");
        this.getWebContext().RemoveParam("DRILL2");
        this.getWebContext().RemoveParam("BICUBE");
        this.getWebContext().RemoveParam("MEASURE");
        String strURL = "../srfbi/bigridview.jsp?";
        strURL = String.valueOf(strURL) + this.getWebContext().GetQueryString();
        strURL = URLHelper.AppendURLSeperator((String)strURL);
        strURL = String.valueOf(strURL) + StringHelper.Format((String)"SRFDEID=%1$s", (Object)biCube.getDEID());
        try {
            this.getResponse().sendRedirect(strURL);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}

