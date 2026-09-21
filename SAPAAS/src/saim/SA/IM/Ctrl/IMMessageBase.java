/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.IM.Ctrl;

import SA.SRFramework.Utility.StringHelper;
import net.sf.json.JSONObject;

public abstract class IMMessageBase {
    public static final int MSGTARGETTYPE_UNKNOWN = 0;
    public static final int MSGTARGETTYPE_ALLUSER = 1;
    public static final int MSGTARGETTYPE_USER = 2;
    public static final int MSGTARGETTYPE_EXCEPTUSER = 3;
    private String strMsgTarget = "";
    private int nMsgTargetType = 1;
    protected String strMessageType = "";
    private String strParam = "";
    private String strParam2 = "";
    private String strParam3 = "";
    private String strParam4 = "";

    public String getMsgTarget() {
        return this.strMsgTarget;
    }

    public void setMsgTarget(String strMsgTarget) {
        this.strMsgTarget = strMsgTarget;
    }

    public int getMsgTargetType() {
        return this.nMsgTargetType;
    }

    public void setMsgTargetType(int nMsgTargetType) {
        this.nMsgTargetType = nMsgTargetType;
    }

    public JSONObject toJSONObject(JSONObject jo) throws Exception {
        if (jo == null) {
            jo = new JSONObject();
        }
        this.OnFillJSONObject(jo);
        return jo;
    }

    protected void OnFillJSONObject(JSONObject jo) throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.getParam())) {
            jo.put("param", (Object)this.getParam());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getParam2())) {
            jo.put("param2", (Object)this.getParam2());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getParam3())) {
            jo.put("param3", (Object)this.getParam3());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getParam4())) {
            jo.put("param4", (Object)this.getParam4());
        }
    }

    public boolean FromJSONObject(JSONObject jo) {
        try {
            if (jo.has("param")) {
                this.setParam(jo.getString("param"));
            }
            if (jo.has("param2")) {
                this.setParam2(jo.getString("param2"));
            }
            if (jo.has("param3")) {
                this.setParam3(jo.getString("param3"));
            }
            if (jo.has("param4")) {
                this.setParam4(jo.getString("param4"));
            }
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }

    public String getParam() {
        return this.strParam;
    }

    public void setParam(String strParam) {
        this.strParam = strParam;
    }

    public String getParam2() {
        return this.strParam2;
    }

    public void setParam2(String strParam2) {
        this.strParam2 = strParam2;
    }

    public String getParam3() {
        return this.strParam3;
    }

    public void setParam3(String strParam3) {
        this.strParam3 = strParam3;
    }

    public String getParam4() {
        return this.strParam4;
    }

    public void setParam4(String strParam4) {
        this.strParam4 = strParam4;
    }

    public String getDebugInfo() {
        return this.OnGetDebugInfo();
    }

    protected String OnGetDebugInfo() {
        return "";
    }

    public String getMsgTargetInfo() {
        switch (this.getMsgTargetType()) {
            case 1: {
                return "\u5168\u90e8\u7528\u6237";
            }
            case 2: {
                return StringHelper.Format((String)"\u6307\u5b9a\u7528\u6237=%1$s", (Object)this.getMsgTarget());
            }
            case 3: {
                return StringHelper.Format((String)"\u6392\u9664\u7528\u6237=%1$s", (Object)this.getMsgTarget());
            }
        }
        return "\u672a\u77e5\u76ee\u6807\u4fe1\u606f";
    }
}

