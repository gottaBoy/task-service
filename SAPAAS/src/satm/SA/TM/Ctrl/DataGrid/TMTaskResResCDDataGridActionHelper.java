/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DataTable
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExGridFetchResult
 *  net.sf.json.JSONObject
 */
package SA.TM.Ctrl.DataGrid;

import SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExGridFetchResult;
import SA.TM.Ctrl.Data.TMTaskRes;
import SA.TM.Ctrl.ITMModelStorage;
import SA.TM.Ctrl.ITMResCatalogHelper;
import SA.TM.Ctrl.ITMTaskResArrangeEngine;
import SA.TM.Ctrl.TMActionContext;
import SA.TM.Ctrl.TMModelStorageFactory;
import java.util.Hashtable;
import java.util.Vector;
import net.sf.json.JSONObject;

public class TMTaskResResCDDataGridActionHelper
extends BaseDADataGridActionHelper {
    protected void FillSummaryInfo(SRFExGridFetchResult fetchResult, DataTable dataTable) {
        super.FillSummaryInfo(fetchResult, dataTable);
        if (fetchResult.getRetCode() != 0) {
            return;
        }
        String strTMTaskResId = this.getWebContext().GetParamValue("TMTASKRESID");
        if (StringHelper.IsNullOrEmpty((String)strTMTaskResId)) {
            return;
        }
        TMTaskRes tmTaskRes = new TMTaskRes();
        tmTaskRes.setTMTASKRESID(strTMTaskResId);
        IDEDataCtrl tmTaskResDataCtrl = this.getPage().GetDEDataCtrl("TM0115");
        CallResult callResult = tmTaskResDataCtrl.Get((BaseDataEntity)tmTaskRes);
        if (!callResult.IsOk()) {
            fetchResult.AppendJSCode(StringHelper.Format((String)"alert('\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7684\u4efb\u52a1\u8d44\u6e90\u7f16\u53f7\uff0c\u65e0\u6cd5\u8fdb\u4e00\u6b65\u8ba1\u7b97\u8d44\u6e90\u6743\u503c');"));
            return;
        }
        if (tmTaskRes.isBEGINTIMENull() || tmTaskRes.isENDTIMENull()) {
            return;
        }
        String strTMResCatalogId = tmTaskRes.getTMRESCATALOGID();
        if (StringHelper.IsNullOrEmpty((String)strTMResCatalogId)) {
            return;
        }
        try {
            ITMModelStorage iTMModelStorage = TMModelStorageFactory.Create((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
            ITMResCatalogHelper iTMResCatalogHelper = iTMModelStorage.FindTMResCatalog(strTMResCatalogId);
            if (!StringHelper.IsNullOrEmpty((String)iTMResCatalogHelper.getTMTaskResAEId())) {
                ITMTaskResArrangeEngine iTMTaskResArrangeEngine = iTMModelStorage.CreateTMTaskResArrangeEngine(iTMResCatalogHelper.getTMTaskResAEId());
                Hashtable<String, Float> tmResCDScoreMap = new Hashtable<String, Float>();
                Hashtable<String, String> tmResCDScoreInfoMap = new Hashtable<String, String>();
                TMActionContext tmActionContext = new TMActionContext();
                tmActionContext.Init((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), tmTaskResDataCtrl);
                iTMTaskResArrangeEngine.CalcResCDScore(tmActionContext, tmTaskRes, tmResCDScoreMap, tmResCDScoreInfoMap);
                Vector<JSONObject> realSortList = new Vector<JSONObject>();
                for (Object objJO : fetchResult.getItems()) {
                    JSONObject jo = (JSONObject)objJO;
                    String strTMResCDId = jo.getString("TMRESCDID");
                    double fValue = -10000.0;
                    if (tmResCDScoreMap.containsKey(strTMResCDId)) {
                        Float objValue;
                        if (jo.has("priority")) {
                            jo.remove("priority");
                        }
                        if ((objValue = tmResCDScoreMap.get(strTMResCDId)) == null) {
                            fValue = -999.0;
                            jo.put("priority", (Object)"* \u8d44\u6e90\u4e0d\u53ef\u7528\uff0c\u53ef\u80fd\u4e0d\u5728\u6709\u6548\u65f6\u95f4  *");
                        } else {
                            fValue = tmResCDScoreMap.get(strTMResCDId).floatValue();
                            if (fValue == -1.0) {
                                fValue = -999.0;
                                jo.put("priority", (Object)"* \u8d44\u6e90\u4e0d\u53ef\u7528\uff0c\u53ef\u80fd\u4e0d\u5728\u6709\u6548\u65f6\u95f4  *");
                            } else {
                                jo.put("priority", (Object)StringHelper.Format((String)"\u8d44\u6e90\u53ef\u7528\uff0c\u5f97\u5206 %1$.02f", (Object)fValue));
                            }
                        }
                    } else {
                        if (jo.has("priority")) {
                            jo.remove("priority");
                        }
                        if (StringHelper.Compare((String)strTMResCDId, (String)tmTaskRes.getTMRESCDID(), (boolean)true) == 0) {
                            fValue = 1.0E8;
                            jo.put("priority", (Object)"- \u5f53\u524d\u4f7f\u7528\u8d44\u6e90 -");
                        } else {
                            jo.put("priority", (Object)"* \u8d44\u6e90\u4e0d\u53ef\u7528\uff0c\u53ef\u80fd\u88ab\u5360\u7528  *");
                        }
                    }
                    jo.put("SCOREVALUE", fValue);
                    boolean bAdd = false;
                    int i = 0;
                    while (i < realSortList.size()) {
                        JSONObject joItem = (JSONObject)realSortList.get(i);
                        double fOldValue = joItem.getDouble("SCOREVALUE");
                        if (fValue > fOldValue) {
                            bAdd = true;
                            realSortList.add(i, jo);
                            break;
                        }
                        ++i;
                    }
                    if (bAdd) continue;
                    realSortList.add(jo);
                }
                fetchResult.getItems().clear();
                int i = 0;
                while (i < realSortList.size()) {
                    JSONObject joItem = (JSONObject)realSortList.get(i);
                    fetchResult.getItems().add(joItem);
                    ++i;
                }
            }
        }
        catch (Exception ex) {
            this.getPage().PageLog((Object)this, 1, ex.getMessage(), (Throwable)ex);
            fetchResult.AppendJSCode(StringHelper.Format((String)"alert('\u8fdb\u4e00\u6b65\u8ba1\u7b97\u8d44\u6e90\u6743\u503c\u53d1\u751f\u5f02\u5e38\uff0c%1$s');", (Object)ex.getMessage()));
            return;
        }
    }
}

