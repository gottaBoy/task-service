/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.IIMRemoteAction;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.Hashtable;

public class IMRemoteAction
implements IIMRemoteAction {
    protected String strAction = "";
    protected Hashtable<String, String> paramMap = new Hashtable();
    protected String strRemoteAddress = "";
    protected boolean bFromServer = false;
    protected String strContent = "";
    protected String strFromServerId = "";

    @Override
    public String getAction() {
        return this.strAction;
    }

    public void setAction(String strAction) {
        this.strAction = strAction;
    }

    @Override
    public Hashtable<String, String> getParams() {
        return this.paramMap;
    }

    @Override
    public String getParam(String strParamName, String strDefault) {
        if (this.paramMap.containsKey(strParamName = strParamName.toUpperCase())) {
            return this.paramMap.get(strParamName);
        }
        return strDefault;
    }

    public void setParam(String strParamName, String strValue) {
        strParamName = strParamName.toUpperCase();
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
            this.paramMap.remove(strParamName);
        } else {
            this.paramMap.put(strParamName, strValue);
        }
    }

    @Override
    public String getRemoteAddress() {
        return this.strRemoteAddress;
    }

    public void setRemoteAddress(String strRemoteAddress) {
        this.strRemoteAddress = strRemoteAddress;
    }

    @Override
    public boolean isFromServer() {
        return this.bFromServer;
    }

    public void setFromServer(boolean bFromServer) {
        this.bFromServer = bFromServer;
    }

    @Override
    public String getContent() {
        if (!StringHelper.IsNullOrEmpty((String)this.strContent)) {
            return this.strContent;
        }
        return this.getParam("CONTENT", "");
    }

    public void setContent(String strContent) {
        this.strContent = strContent;
    }

    @Override
    public void FromWebContext(ISRFDAWebContext webContext) throws Exception {
        String strAction = webContext.GetParamValue("IMACTION");
        if (StringHelper.IsNullOrEmpty((String)strAction)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u8fdc\u7a0b\u884c\u4e3a");
        }
        this.setAction(strAction);
        this.setRemoteAddress(webContext.getRemoteAddr());
        Hashtable params = webContext.GetParams();
        for (String strKey : params.keySet()) {
            if (StringHelper.Compare((String)strKey, (String)"IMACTION", (boolean)true) == 0) continue;
            if (StringHelper.Compare((String)"SERVERID", (String)strKey, (boolean)true) == 0) {
                this.setFromServer(true);
            }
            this.setParam(strKey, (String)params.get(strKey));
        }
        String strContent = webContext.GetPostValue("content");
        if (!StringHelper.IsNullOrEmpty((String)strContent)) {
            this.setContent(strContent);
        }
    }

    @Override
    public void FromRemoteAction(IIMRemoteAction imRemoteActionClone) {
        this.setAction(imRemoteActionClone.getAction());
        this.setContent(imRemoteActionClone.getContent());
        this.setFromServer(imRemoteActionClone.isFromServer());
        Hashtable<String, String> params = imRemoteActionClone.getParams();
        for (String strKey : params.keySet()) {
            this.setParam(strKey, params.get(strKey));
        }
    }

    @Override
    public String getParamString() {
        String strParamString = StringHelper.Format((String)"IMACTION=%1$s&FROMIMSERVERID=%2$s&", (Object)this.getAction(), (Object)this.getFromServerId());
        strParamString = String.valueOf(strParamString) + URLHelper.GetQueryString(this.paramMap);
        return strParamString;
    }

    @Override
    public String getFromServerId() {
        return this.getParam("SERVERID", "");
    }
}

