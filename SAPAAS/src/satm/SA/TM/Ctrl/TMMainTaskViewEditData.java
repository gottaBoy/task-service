/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.TM.Ctrl;

import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Timestamp;
import net.sf.json.JSONObject;

public class TMMainTaskViewEditData {
    protected JSONObject jo = null;
    protected Timestamp dtBeginTime = null;
    protected Timestamp dtEndTime = null;
    protected String strTMTaskBaseId = "";
    protected String strAction = "";

    public TMMainTaskViewEditData(String strValue) throws Exception {
        this.jo = JSONObject.fromString((String)strValue);
        if (this.jo == null) {
            throw new Exception("\u7f16\u8f91\u503c\u65e0\u6548");
        }
        if (this.jo.has("begintime")) {
            this.dtBeginTime = DateParser.GetTimestampValue((Object)DateParser.Parse((String)this.jo.getString("begintime")));
        }
        if (this.dtBeginTime == null) {
            throw new Exception("\u5f00\u59cb\u65f6\u95f4\u65e0\u6548");
        }
        if (this.jo.has("endtime")) {
            this.dtEndTime = DateParser.GetTimestampValue((Object)DateParser.Parse((String)this.jo.getString("endtime")));
        }
        if (this.dtEndTime == null) {
            throw new Exception("\u7ed3\u675f\u65f6\u95f4\u65e0\u6548");
        }
        if (this.jo.has("tmtaskbaseid")) {
            this.strTMTaskBaseId = this.jo.getString("tmtaskbaseid");
        }
        if (StringHelper.IsNullOrEmpty((String)this.strTMTaskBaseId)) {
            throw new Exception("\u7f16\u8f91\u4efb\u52a1\u6570\u636e\u65e0\u6548");
        }
        if (this.jo.has("action")) {
            this.strAction = this.jo.getString("action");
        }
        if (StringHelper.IsNullOrEmpty((String)this.strAction)) {
            throw new Exception("\u7f16\u8f91\u884c\u4e3a\u65e0\u6548");
        }
    }

    public Timestamp getBeginTime() {
        return this.dtBeginTime;
    }

    public Timestamp getEndTime() {
        return this.dtEndTime;
    }

    public String getTMTaskBaseId() {
        return this.strTMTaskBaseId;
    }

    public String getAction() {
        return this.strAction;
    }
}

