/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Form.BaseDAFormActionHelper
 *  SA.SRFDA.Web.Script.RichAppJSHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.Web.WebUtility
 *  SA.SRFramework.WebEx.Form.SRFExFormItemErrors
 *  SA.SRFramework.WebEx.Form.SRFExFormRemoveResult
 *  SA.SRFramework.WebEx.Form.SRFExFormSaveResult
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.CAL.Ctrl.Form;

import SA.SRFDA.CAL.Ctrl.Data.Calendar;
import SA.SRFDA.Ctrl.Form.BaseDAFormActionHelper;
import SA.SRFDA.Web.Script.RichAppJSHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.WebUtility;
import SA.SRFramework.WebEx.Form.SRFExFormItemErrors;
import SA.SRFramework.WebEx.Form.SRFExFormRemoveResult;
import SA.SRFramework.WebEx.Form.SRFExFormSaveResult;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import java.sql.Timestamp;
import net.sf.json.JSONObject;

public class CalendarFormActionHelper
extends BaseDAFormActionHelper {
    protected void OnLoadDefaultActionAfterFillDataEntity(BaseDataEntity dataEntity) {
        super.OnLoadDefaultActionAfterFillDataEntity(dataEntity);
        String strEventName = this.getWebContext().GetParamValue("text");
        String strStartTime = this.getWebContext().GetParamValue("starttime");
        String strEndTime = this.getWebContext().GetParamValue("endtime");
        String strCalType = this.getWebContext().GetParamValue("caltype");
        Timestamp dtStartTime = new Timestamp(Long.parseLong(strStartTime));
        Timestamp dtEndTime = new Timestamp(Long.parseLong(strEndTime));
        dataEntity.SetParamValue("CALENDARNAME", (Object)strEventName);
        dataEntity.SetParamValue("OWNERID", (Object)this.getWebContext().getCurUserId());
        dataEntity.SetParamValue("IMPORTANCE", (Object)"NORMAL");
        dataEntity.SetParamValue("BEGINTIME", (Object)dtStartTime);
        dataEntity.SetParamValue("ENDTIME", (Object)dtEndTime);
        dataEntity.SetParamValue("CALENDARTYPEID", (Object)strCalType);
    }

    protected boolean OnSaveActionAfterFillDataEntity(BaseDataEntity dataEntity, boolean insert, SRFExFormItemErrors formItemErrors) {
        if (insert) {
            dataEntity.SetParamValue("CALENDARTYPEID", (Object)"CT_DEFAULT");
            dataEntity.SetParamValue("OWNERID", (Object)this.getWebContext().getCurUserId());
        }
        return super.OnSaveActionAfterFillDataEntity(dataEntity, insert, formItemErrors);
    }

    protected String OnSaveActionOutputResult(BaseDataEntity dataEntity, SRFExFormSaveResult saveResult) {
        if (saveResult.getRetCode() == 0) {
            Calendar calendar = new Calendar();
            dataEntity.CopyTo((BaseDataEntity)calendar, true);
            saveResult.AppendJSCode(BrowserJSHelper.getResetDialogReturnValue());
            JSONObject obj = new JSONObject();
            obj.put("id", (Object)calendar.getCALENDARID());
            if (StringHelper.IsNullOrEmpty((String)this.getPage().getPageModel())) {
                obj.put("text", (Object)(String.valueOf(WebUtility.TextToHTML((String)calendar.getCALENDARNAME())) + "<BR>" + WebUtility.TextToHTML((String)calendar.getCONTENT())));
            } else {
                obj.put("text", (Object)calendar.getCALENDARNAME());
                obj.put("details", (Object)calendar.getCONTENT());
            }
            obj.put("begintime", calendar.getBEGINTIME().getTime());
            obj.put("endtime", calendar.getENDTIME().getTime());
            obj.put("caltype", (Object)calendar.getCALENDARTYPEID());
            if (StringHelper.IsNullOrEmpty((String)this.getPage().getPageModel())) {
                saveResult.AppendJSCode(BrowserJSHelper.getSetDialogReturnValue((String)"ret", (String)"'ok'"));
                saveResult.AppendJSCode(BrowserJSHelper.getSetDialogReturnValue((String)"item", (String)obj.toString()));
                saveResult.AppendJSCode(BrowserJSHelper.getCloseWindowScript());
            } else {
                saveResult.AppendJSCode(RichAppJSHelper.getSetDialogResult((String)this.getPage().getPageModel(), (String)"OK"));
                saveResult.AppendJSCode(RichAppJSHelper.getCloseWindowScript((String)this.getPage().getPageModel()));
            }
        }
        return super.OnSaveActionOutputResult(dataEntity, saveResult);
    }

    protected String OnRemoveActionOutputResult(BaseDataEntity dataEntity, SRFExFormRemoveResult removeResult) {
        if (removeResult.IsOk() && !StringHelper.IsNullOrEmpty((String)this.getPage().getPageModel())) {
            removeResult.AppendJSCode(RichAppJSHelper.getSetDialogResult((String)this.getPage().getPageModel(), (String)"OK"));
        }
        return super.OnRemoveActionOutputResult(dataEntity, removeResult);
    }
}

