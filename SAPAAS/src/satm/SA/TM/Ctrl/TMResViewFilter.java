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

public class TMResViewFilter {
    protected JSONObject jo = null;
    protected Timestamp dtBeginTime = null;
    protected Timestamp dtEndTime = null;
    protected String strResources = "";

    public TMResViewFilter(String strValue) throws Exception {
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
            throw new Exception("\u8fc7\u6ee4\u503c\u65e0\u6548");
        }
        this.jo = JSONObject.fromString((String)strValue);
        if (this.jo == null) {
            throw new Exception("\u8fc7\u6ee4\u503c\u65e0\u6548");
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
        if (this.jo.has("resources")) {
            this.strResources = this.jo.getString("resources");
        }
        if (StringHelper.IsNullOrEmpty((String)this.strResources)) {
            throw new Exception("\u8d44\u6e90\u65e0\u6548");
        }
    }

    public Timestamp getBeginTime() {
        return this.dtBeginTime;
    }

    public Timestamp getEndTime() {
        return this.dtEndTime;
    }

    public String getResources() {
        return this.strResources;
    }
}

