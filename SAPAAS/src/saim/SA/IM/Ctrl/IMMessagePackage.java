/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.IMMessageBase;
import SA.IM.Ctrl.Message.IMInformMessage;
import SA.SRFramework.Utility.StringHelper;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class IMMessagePackage {
    private int nRetCode = 0;
    private String nRetInfo = "";
    private Hashtable<String, Object> extInfoMap = new Hashtable();
    private Vector<IMMessageBase> messageList = new Vector();

    public int getRetCode() {
        return this.nRetCode;
    }

    public void setRetCode(int nRetCode) {
        this.nRetCode = nRetCode;
    }

    public String getRetInfo() {
        return this.nRetInfo;
    }

    public void setRetInfo(String nRetInfo) {
        this.nRetInfo = nRetInfo;
    }

    public void AddMessage(IMMessageBase imMessageBase) {
        this.messageList.add(imMessageBase);
    }

    public String toJSONString() throws Exception {
        JSONObject jo = new JSONObject();
        this.OnFillJSONObject(jo);
        return jo.toString();
    }

    public boolean FromJSONObject(JSONObject jo) {
        Object msges;
        Object obj;
        if (jo == null) {
            return false;
        }
        if (jo.has("retcode")) {
            this.nRetCode = jo.getInt("retcode");
        }
        if (jo.has("retinfo")) {
            this.nRetInfo = jo.getString("retinfo");
        }
        if (jo.has("extinfo") && (obj = jo.get("extinfo")) instanceof JSONObject) {
            JSONObject extJO = (JSONObject)obj;
            Iterator keys = extJO.keys();
            while (keys.hasNext()) {
                String strKey = keys.next().toString();
                String objValue = extJO.getString(strKey);
                this.extInfoMap.put(strKey, objValue.toString());
            }
        }
        if (jo.has("messages") && (msges = jo.get("messages")) instanceof JSONArray) {
            JSONArray array = (JSONArray)msges;
            int i = 0;
            while (i < array.length()) {
                IMInformMessage msgBase = new IMInformMessage();
                JSONObject jo2 = array.getJSONObject(i);
                boolean bSuccess = ((IMMessageBase)msgBase).FromJSONObject(jo2);
                if (bSuccess) {
                    this.messageList.add(msgBase);
                }
                ++i;
            }
        }
        return true;
    }

    protected void OnFillJSONObject(JSONObject jo) throws Exception {
        Vector<JSONObject> messages = new Vector<JSONObject>();
        for (IMMessageBase messageBase : this.messageList) {
            messages.add(messageBase.toJSONObject(null));
        }
        jo.put("messages", (Object)messages.toArray());
        jo.put("retcode", this.nRetCode);
        jo.put("retinfo", (Object)this.nRetInfo);
        JSONObject extInfo = new JSONObject();
        for (String strKey : this.extInfoMap.keySet()) {
            extInfo.put(strKey, this.extInfoMap.get(strKey));
        }
        jo.put("extinfo", (Object)extInfo);
    }

    public void setExtInfo(String strParam, Object objValue) {
        strParam = strParam.toUpperCase();
        if (objValue == null) {
            this.extInfoMap.remove(strParam);
        } else {
            this.extInfoMap.put(strParam, objValue);
        }
    }

    public void setExtInfo(String strParam, String strValue) {
        strParam = strParam.toUpperCase();
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
            this.extInfoMap.remove(strParam);
        } else {
            this.extInfoMap.put(strParam, strValue);
        }
    }

    public String getExtInfo(String strParam, String strDefault) {
        if (this.extInfoMap.containsKey(strParam = strParam.toUpperCase())) {
            return (String)this.extInfoMap.get(strParam);
        }
        return strDefault;
    }
}

