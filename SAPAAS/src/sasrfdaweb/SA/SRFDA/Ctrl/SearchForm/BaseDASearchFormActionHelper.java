/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.SFSaveState
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Form.SRFExFormAjaxResult
 *  SA.SRFramework.WebEx.Form.SRFExFormItemErrors
 *  SA.SRFramework.WebEx.Form.SRFExFormLoadResult
 *  SA.SRFramework.WebEx.Form.SRFExFormSearchResult
 *  SA.SRFramework.WebEx.Form.SRFExSearchForm
 *  SA.SRFramework.WebEx.Form.SRFExSearchFormActionHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Ctrl.SearchForm;

import SA.SRFDA.Ctrl.Data.SFSaveState;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Form.SRFExFormAjaxResult;
import SA.SRFramework.WebEx.Form.SRFExFormItemErrors;
import SA.SRFramework.WebEx.Form.SRFExFormLoadResult;
import SA.SRFramework.WebEx.Form.SRFExFormSearchResult;
import SA.SRFramework.WebEx.Form.SRFExSearchForm;
import SA.SRFramework.WebEx.Form.SRFExSearchFormActionHelper;
import java.util.Vector;
import net.sf.json.JSONObject;

public class BaseDASearchFormActionHelper
extends SRFExSearchFormActionHelper {
    private static boolean bLoadDefaultFromUrl = false;

    public static void setLoadDefaultFromUrl(boolean bValue) {
        bLoadDefaultFromUrl = bValue;
    }

    public static boolean getLoadDefaultFromUrl() {
        return bLoadDefaultFromUrl;
    }

    protected boolean OnListCondtionAction() {
        SRFExFormAjaxResult formAjaxResult = new SRFExFormAjaxResult();
        IDEDataCtrl sfSaveStateDataCtrl = this.getPage().GetDEDataCtrl("DE0104");
        if (sfSaveStateDataCtrl == null) {
            formAjaxResult.setRetCode(1);
            formAjaxResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0104"));
            this.getPage().Output(formAjaxResult.ToJSONString());
            return true;
        }
        BaseDataEntity cond = new BaseDataEntity();
        cond.SetParamValue("PERSONID", (Object)this.getWebContext().getCurUserId());
        cond.SetParamValue("SFID", (Object)this.strFormTag);
        cond.SetParamValue("DEID", (Object)this.GetDEId());
        Vector conds = new Vector();
        CallResult callResult = sfSaveStateDataCtrl.Select("LISTUSERCOND", cond, conds, SFSaveState.class.getName());
        if (callResult.IsError()) {
            formAjaxResult.From(callResult);
            formAjaxResult.ReformatErrorInfo("\u67e5\u8be2\u7528\u6237\u4fdd\u5b58\u6761\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s");
            this.getPage().Output(formAjaxResult.ToJSONString());
            return true;
        }
        for (SFSaveState sfSaveState : conds) {
            JSONObject jo = new JSONObject();
            jo.put("value", (Object)sfSaveState.getSFSAVESTATEID());
            jo.put("text", (Object)sfSaveState.getSFSAVESTATENAME());
            formAjaxResult.getItems().add(jo);
        }
        this.getPage().Output(formAjaxResult.ToJSONString());
        return true;
    }

    protected boolean OnLoadCondtionAction() {
        SRFExFormLoadResult loadResult = new SRFExFormLoadResult();
        IDEDataCtrl sfSaveStateDataCtrl = this.getPage().GetDEDataCtrl("DE0104");
        if (sfSaveStateDataCtrl == null) {
            loadResult.setRetCode(1);
            loadResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0104"));
            this.getPage().Output(loadResult.ToJSONString());
            return true;
        }
        String strSLId = this.getWebContext().GetPostValue("srfslid");
        SFSaveState ss = new SFSaveState();
        ss.setSFSAVESTATEID(strSLId);
        CallResult callResult = sfSaveStateDataCtrl.Select((BaseDataEntity)ss);
        if (callResult.IsError()) {
            loadResult.From(callResult);
            loadResult.ReformatErrorInfo("\u67e5\u8be2\u7528\u6237\u5b58\u50a8\u6761\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s");
            this.getPage().Output(loadResult.ToJSONString());
            return true;
        }
        SRFExSearchForm searchForm = this.getSearchForm();
        BaseDataEntity cond = BaseDataEntity.FromString((String)ss.getSAVESTATE());
        searchForm.FillByDataEntity(cond, false);
        searchForm.FillValueJSON(loadResult.getItems(), this.getPage().isControlValueFromUniqueId());
        String strDHCData = cond.GetParamStringValue("srfdhc", "");
        if (!StringHelper.IsNullOrEmpty((String)strDHCData)) {
            loadResult.setExtInfo("srfdhcdata", strDHCData);
        }
        this.getPage().Output(loadResult.ToJSONString());
        return true;
    }

    protected boolean OnSaveCondtionAction() {
        SRFExFormItemErrors formItemErrors;
        BaseDataEntity baseDataEntity;
        SRFExFormAjaxResult formAjaxResult = new SRFExFormAjaxResult();
        IDEDataCtrl sfSaveStateDataCtrl = this.getPage().GetDEDataCtrl("DE0104");
        if (sfSaveStateDataCtrl == null) {
            formAjaxResult.setRetCode(1);
            formAjaxResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0104"));
            this.getPage().Output(formAjaxResult.ToJSONString());
            return true;
        }
        SRFExSearchForm searchForm = this.getSearchForm();
        if (!searchForm.FillDataEntity(baseDataEntity = new BaseDataEntity(), false, formItemErrors = new SRFExFormItemErrors())) {
            String strMessageInfo = "\u67e5\u8be2\u6761\u4ef6\u8f93\u5165\u6709\u8bef\uff1a\\r\\n" + formItemErrors.GetTotalError().replace("\r", "\\r").replace("\n", "\\n");
            formAjaxResult.AppendJSCode(StringHelper.Format((String)"alert('%1$s');", (Object)strMessageInfo));
            formAjaxResult.setErrorInfo(strMessageInfo);
            formAjaxResult.setRetCode(5);
            formItemErrors.FillJSONs(formAjaxResult.getItems());
            this.getPage().Output(formAjaxResult.ToJSONString());
            return true;
        }
        String strSRFDHC = this.getWebContext().GetPostValue("srfdhcdata");
        if (!StringHelper.IsNullOrEmpty((String)strSRFDHC)) {
            baseDataEntity.SetParamValue("srfdhc", (Object)strSRFDHC);
        }
        String strSLId = this.getWebContext().GetPostValue("srfslid");
        String strSLName = this.getWebContext().GetPostValue("srfslname");
        if (StringHelper.IsNullOrEmpty((String)strSLName)) {
            formAjaxResult.AppendJSCode(StringHelper.Format((String)"alert('%1$s');", (Object)"\u5fc5\u987b\u8f93\u5165\u6761\u4ef6\u540d\u79f0"));
            formAjaxResult.setErrorInfo("\u5fc5\u987b\u8f93\u5165\u6761\u4ef6\u540d\u79f0");
            formAjaxResult.setRetCode(5);
            this.getPage().Output(formAjaxResult.ToJSONString());
            return true;
        }
        if (StringHelper.IsNullOrEmpty((String)strSLId) || StringHelper.Compare((String)strSLId, (String)"SRFNEW", (boolean)true) == 0) {
            SFSaveState ss = new SFSaveState();
            ss.setSFSAVESTATENAME(strSLName);
            ss.setDEID(this.GetDEId());
            ss.setSFID(this.strFormTag);
            ss.setSAVESTATE(BaseDataEntity.ToString((BaseDataEntity)baseDataEntity));
            CallResult callResult = sfSaveStateDataCtrl.Save(true, (BaseDataEntity)ss);
            if (callResult.IsError()) {
                formAjaxResult.From(callResult);
                formAjaxResult.ReformatErrorInfo("\u4fdd\u5b58\u7528\u6237\u4fdd\u5b58\u6761\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s");
                this.getPage().Output(formAjaxResult.ToJSONString());
                return true;
            }
        } else {
            SFSaveState ss = new SFSaveState();
            ss.setSFSAVESTATEID(strSLId);
            ss.setSFSAVESTATENAME(strSLName);
            ss.setDEID(this.GetDEId());
            ss.setSFID(this.strFormTag);
            ss.setSAVESTATE(BaseDataEntity.ToString((BaseDataEntity)baseDataEntity));
            CallResult callResult = sfSaveStateDataCtrl.Save(false, (BaseDataEntity)ss);
            if (callResult.IsError()) {
                formAjaxResult.From(callResult);
                formAjaxResult.ReformatErrorInfo("\u4fdd\u5b58\u7528\u6237\u4fdd\u5b58\u6761\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s");
                this.getPage().Output(formAjaxResult.ToJSONString());
                return true;
            }
        }
        return this.OnListCondtionAction();
    }

    protected boolean OnRemoveCondtionAction() {
        SRFExFormAjaxResult formAjaxResult = new SRFExFormAjaxResult();
        IDEDataCtrl sfSaveStateDataCtrl = this.getPage().GetDEDataCtrl("DE0104");
        if (sfSaveStateDataCtrl == null) {
            formAjaxResult.setRetCode(1);
            formAjaxResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0104"));
            this.getPage().Output(formAjaxResult.ToJSONString());
            return true;
        }
        String strSLId = this.getWebContext().GetPostValue("srfslid");
        SFSaveState ss = new SFSaveState();
        ss.setSFSAVESTATEID(strSLId);
        CallResult callResult = sfSaveStateDataCtrl.Remove((BaseDataEntity)ss);
        if (callResult.IsError()) {
            formAjaxResult.From(callResult);
            formAjaxResult.ReformatErrorInfo("\u5220\u9664\u7528\u6237\u4fdd\u5b58\u6761\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s");
            this.getPage().Output(formAjaxResult.ToJSONString());
            return true;
        }
        return this.OnListCondtionAction();
    }

    protected boolean OnLoadDefaultAction() {
        SRFExSearchForm searchForm = this.getSearchForm();
        SRFExFormLoadResult loadResult = new SRFExFormLoadResult();
        BaseDataEntity dataEntity = new BaseDataEntity();
        if (this.OnGetLoadDefaultFromUrl()) {
            searchForm.FillDataEntityDVEx(dataEntity, true);
        } else {
            searchForm.FillDataEntityDV(dataEntity);
        }
        this.OnLoadDefaultActionAfterFillDataEntity(dataEntity);
        searchForm.FillByDataEntity(dataEntity, false);
        searchForm.FillValueJSON(loadResult.getItems(), this.getPage().isControlValueFromUniqueId());
        this.getPage().Output(loadResult.ToJSONString());
        return true;
    }

    protected boolean OnGetLoadDefaultFromUrl() {
        return BaseDASearchFormActionHelper.getLoadDefaultFromUrl();
    }

    protected void OnLoadDefaultActionAfterFillDataEntity(BaseDataEntity dataEntity) {
    }

    protected boolean OnSearchAction() {
        SRFExSearchForm searchForm = this.getSearchForm();
        SRFExFormSearchResult searchResult = new SRFExFormSearchResult();
        BaseDataEntity baseDataEntity = new BaseDataEntity();
        SRFExFormItemErrors formItemErrors = new SRFExFormItemErrors();
        if (!searchForm.FillDataEntity(baseDataEntity, false, formItemErrors)) {
            String strMessageInfo = "\u67e5\u8be2\u6761\u4ef6\u8f93\u5165\u6709\u8bef\uff1a\\r\\n" + formItemErrors.GetTotalError().replace("\r", "\\r").replace("\n", "\\n");
            searchResult.AppendJSCode(StringHelper.Format((String)"alert('%1$s');", (Object)strMessageInfo));
            searchResult.setErrorInfo(strMessageInfo);
            searchResult.setRetCode(5);
            formItemErrors.FillJSONs(searchResult.getItems());
            this.getPage().Output(searchResult.ToJSONString());
            return true;
        }
        String strDTType = baseDataEntity.GetParamStringValue("dttype", "");
        if (!StringHelper.IsNullOrEmpty((String)strDTType) && !BaseDASearchFormActionHelper.ParseTimeDimension(strDTType, baseDataEntity, searchResult)) {
            this.getPage().Output(searchResult.ToJSONString());
            return true;
        }
        searchForm.FillValueJSON(searchResult.getItems(), false);
        this.getPage().Output(this.OnSearchActionOutputResult(baseDataEntity, searchResult));
        return true;
    }

    public static boolean ParseTimeDimension(String strDTType, BaseDataEntity baseDataEntity, SRFExFormSearchResult searchResult) {
        String[] yweeks;
        int l;
        int k;
        int j;
        int i;
        int k2;
        int j2;
        String[] months;
        String[] years;
        String strDTYear = baseDataEntity.GetParamStringValue("dtyear", "");
        String strDTMonth = baseDataEntity.GetParamStringValue("dtmonth", "");
        String strDTMDay = baseDataEntity.GetParamStringValue("dtmday", "");
        String strDTYWeek = baseDataEntity.GetParamStringValue("dtyweek", "");
        String strDTMWeek = baseDataEntity.GetParamStringValue("dtmweek", "");
        String strDTWDay = baseDataEntity.GetParamStringValue("dtwday", "");
        String strDTDHour = baseDataEntity.GetParamStringValue("dtdhour", "");
        Vector<String> timeDimensions = new Vector<String>();
        if (StringHelper.Compare((String)"YM", (String)strDTType, (boolean)true) == 0 && !StringHelper.IsNullOrEmpty((String)strDTYear) && !StringHelper.IsNullOrEmpty((String)strDTMonth)) {
            years = strDTYear.split("[,]");
            months = strDTMonth.split("[,]");
            int i2 = 0;
            while (i2 < years.length) {
                int j3 = 0;
                while (j3 < months.length) {
                    timeDimensions.add(StringHelper.Format((String)"M%1$s%2$s", (Object)years[i2], (Object)months[j3]));
                    ++j3;
                }
                ++i2;
            }
        }
        if (!(StringHelper.Compare((String)"YMD", (String)strDTType, (boolean)true) != 0 || StringHelper.IsNullOrEmpty((String)strDTYear) || StringHelper.IsNullOrEmpty((String)strDTMonth) || StringHelper.IsNullOrEmpty((String)strDTMDay))) {
            years = strDTYear.split("[,]");
            months = strDTMonth.split("[,]");
            String[] days = strDTMDay.split("[,]");
            int i3 = 0;
            while (i3 < years.length) {
                j2 = 0;
                while (j2 < months.length) {
                    k2 = 0;
                    while (k2 < days.length) {
                        timeDimensions.add(StringHelper.Format((String)"D%1$s%2$s%3$s", (Object)years[i3], (Object)months[j2], (Object)days[k2]));
                        ++k2;
                    }
                    ++j2;
                }
                ++i3;
            }
        }
        if (!(StringHelper.Compare((String)"YMDH", (String)strDTType, (boolean)true) != 0 || StringHelper.IsNullOrEmpty((String)strDTYear) || StringHelper.IsNullOrEmpty((String)strDTMonth) || StringHelper.IsNullOrEmpty((String)strDTMDay) || StringHelper.IsNullOrEmpty((String)strDTDHour))) {
            years = strDTYear.split("[,]");
            months = strDTMonth.split("[,]");
            String[] days = strDTMDay.split("[,]");
            String[] hours = strDTDHour.split("[,]");
            i = 0;
            while (i < years.length) {
                j = 0;
                while (j < months.length) {
                    k = 0;
                    while (k < days.length) {
                        l = 0;
                        while (l < hours.length) {
                            timeDimensions.add(StringHelper.Format((String)"H%1$s%2$s%3$s%4$s", (Object)years[i], (Object)months[j], (Object)days[k], (Object)hours[l]));
                            ++l;
                        }
                        ++k;
                    }
                    ++j;
                }
                ++i;
            }
        }
        if (!(StringHelper.Compare((String)"YMW", (String)strDTType, (boolean)true) != 0 || StringHelper.IsNullOrEmpty((String)strDTYear) || StringHelper.IsNullOrEmpty((String)strDTMonth) || StringHelper.IsNullOrEmpty((String)strDTMWeek))) {
            years = strDTYear.split("[,]");
            months = strDTMonth.split("[,]");
            String[] mweeks = strDTMWeek.split("[,]");
            int i4 = 0;
            while (i4 < years.length) {
                j2 = 0;
                while (j2 < months.length) {
                    k2 = 0;
                    while (k2 < mweeks.length) {
                        timeDimensions.add(StringHelper.Format((String)"W%1$s%2$s%3$s", (Object)years[i4], (Object)months[j2], (Object)mweeks[k2]));
                        ++k2;
                    }
                    ++j2;
                }
                ++i4;
            }
        }
        if (!(StringHelper.Compare((String)"YMWD", (String)strDTType, (boolean)true) != 0 || StringHelper.IsNullOrEmpty((String)strDTYear) || StringHelper.IsNullOrEmpty((String)strDTMonth) || StringHelper.IsNullOrEmpty((String)strDTMWeek) || StringHelper.IsNullOrEmpty((String)strDTWDay))) {
            years = strDTYear.split("[,]");
            months = strDTMonth.split("[,]");
            String[] mweeks = strDTMWeek.split("[,]");
            String[] wdays = strDTWDay.split("[,]");
            i = 0;
            while (i < years.length) {
                j = 0;
                while (j < months.length) {
                    k = 0;
                    while (k < mweeks.length) {
                        l = 0;
                        while (l < wdays.length) {
                            timeDimensions.add(StringHelper.Format((String)"O%1$s%2$s%3$s%4$s", (Object)years[i], (Object)months[j], (Object)mweeks[k], (Object)wdays[l]));
                            ++l;
                        }
                        ++k;
                    }
                    ++j;
                }
                ++i;
            }
        }
        if (!(StringHelper.Compare((String)"YMWDH", (String)strDTType, (boolean)true) != 0 || StringHelper.IsNullOrEmpty((String)strDTYear) || StringHelper.IsNullOrEmpty((String)strDTMonth) || StringHelper.IsNullOrEmpty((String)strDTMWeek) || StringHelper.IsNullOrEmpty((String)strDTWDay) || StringHelper.IsNullOrEmpty((String)strDTDHour))) {
            years = strDTYear.split("[,]");
            months = strDTMonth.split("[,]");
            String[] mweeks = strDTMWeek.split("[,]");
            String[] wdays = strDTWDay.split("[,]");
            String[] hours = strDTDHour.split("[,]");
            int i5 = 0;
            while (i5 < years.length) {
                int j4 = 0;
                while (j4 < months.length) {
                    int k3 = 0;
                    while (k3 < mweeks.length) {
                        int l2 = 0;
                        while (l2 < wdays.length) {
                            int m = 0;
                            while (m < hours.length) {
                                timeDimensions.add(StringHelper.Format((String)"P%1$s%2$s%3$s%4$s%5$s", (Object)years[i5], (Object)months[j4], (Object)mweeks[k3], (Object)wdays[l2], (Object)hours[m]));
                                ++m;
                            }
                            ++l2;
                        }
                        ++k3;
                    }
                    ++j4;
                }
                ++i5;
            }
        }
        if (StringHelper.Compare((String)"YW", (String)strDTType, (boolean)true) == 0 && !StringHelper.IsNullOrEmpty((String)strDTYear) && !StringHelper.IsNullOrEmpty((String)strDTYWeek)) {
            years = strDTYear.split("[,]");
            yweeks = strDTYWeek.split("[,]");
            int i6 = 0;
            while (i6 < years.length) {
                int j5 = 0;
                while (j5 < yweeks.length) {
                    timeDimensions.add(StringHelper.Format((String)"Z%1$s%2$s", (Object)years[i6], (Object)yweeks[j5]));
                    ++j5;
                }
                ++i6;
            }
        }
        if (!(StringHelper.Compare((String)"YWD", (String)strDTType, (boolean)true) != 0 || StringHelper.IsNullOrEmpty((String)strDTYear) || StringHelper.IsNullOrEmpty((String)strDTYWeek) || StringHelper.IsNullOrEmpty((String)strDTWDay))) {
            years = strDTYear.split("[,]");
            yweeks = strDTYWeek.split("[,]");
            String[] wdays = strDTWDay.split("[,]");
            int i7 = 0;
            while (i7 < years.length) {
                int j6 = 0;
                while (j6 < yweeks.length) {
                    k2 = 0;
                    while (k2 < wdays.length) {
                        timeDimensions.add(StringHelper.Format((String)"R%1$s%2$s%3$s%4$s", (Object)years[i7], (Object)yweeks[j6], (Object)wdays[k2]));
                        ++k2;
                    }
                    ++j6;
                }
                ++i7;
            }
        }
        if (!(StringHelper.Compare((String)"YWDH", (String)strDTType, (boolean)true) != 0 || StringHelper.IsNullOrEmpty((String)strDTYear) || StringHelper.IsNullOrEmpty((String)strDTYWeek) || StringHelper.IsNullOrEmpty((String)strDTWDay) || StringHelper.IsNullOrEmpty((String)strDTDHour))) {
            years = strDTYear.split("[,]");
            yweeks = strDTYWeek.split("[,]");
            String[] wdays = strDTWDay.split("[,]");
            String[] hours = strDTDHour.split("[,]");
            int i8 = 0;
            while (i8 < years.length) {
                j = 0;
                while (j < yweeks.length) {
                    k = 0;
                    while (k < wdays.length) {
                        l = 0;
                        while (l < hours.length) {
                            timeDimensions.add(StringHelper.Format((String)"S%1$s%2$s%3$s%4$s", (Object)years[i8], (Object)yweeks[j], (Object)wdays[k], (Object)hours[l]));
                            ++l;
                        }
                        ++k;
                    }
                    ++j;
                }
                ++i8;
            }
        }
        if (timeDimensions.size() > 100) {
            searchResult.setRetCode(5);
            searchResult.AppendJSBeforeCode(StringHelper.Format((String)"alert('\u6570\u636e\u7ef4\u5ea6\u603b\u91cf\u4e0d\u80fd\u8d85\u8fc7100,\u5f53\u524d\u60a8\u9009\u62e9\u4e86%1$s\u9879');", (Object)timeDimensions.size()));
            return false;
        }
        String strTimeDimensions = "";
        for (String strTimeDimension : timeDimensions) {
            if (!StringHelper.IsNullOrEmpty((String)strTimeDimensions)) {
                strTimeDimensions = String.valueOf(strTimeDimensions) + ";";
            }
            strTimeDimensions = String.valueOf(strTimeDimensions) + strTimeDimension;
        }
        if (!StringHelper.IsNullOrEmpty((String)strTimeDimensions)) {
            JSONObject objJSON = new JSONObject();
            objJSON.put("id", (Object)"srftimedimensionid");
            objJSON.put("value", (Object)strTimeDimensions);
            searchResult.getItems().add(objJSON);
        }
        return true;
    }

    protected String OnSearchActionOutputResult(BaseDataEntity baseDataEntity, SRFExFormSearchResult searchResult) {
        return searchResult.ToJSONString();
    }

    protected String GetDEId() {
        IDEHelper iDEHelper = this.getPage().getDEHelper();
        if (iDEHelper != null) {
            return iDEHelper.getId();
        }
        return "DE0000";
    }

    protected SRFDAPage getPage() {
        return (SRFDAPage)this.page;
    }

    protected SRFDAWebContext getWebContext() {
        return (SRFDAWebContext)super.getWebContext();
    }
}

