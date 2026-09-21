/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.core.ModelBaseImpl
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.WebConfig
 *  net.ibizsys.psrt.srv.common.entity.File
 *  net.ibizsys.psrt.srv.wx.entity.WXAccessToken
 *  net.ibizsys.psrt.srv.wx.entity.WXMessage
 *  net.ibizsys.pswx.bean.WXOutMsg
 *  net.ibizsys.pswx.core.IWXAccount
 *  net.ibizsys.pswx.core.IWXAccountModel
 *  net.ibizsys.pswx.core.IWXEntAppModel
 *  net.ibizsys.pswx.core.IWXLogicModel
 *  net.ibizsys.pswx.core.IWXMenu
 *  net.ibizsys.pswx.core.IWXMenuModel
 *  net.ibizsys.pswx.util.SHA1Helper
 *  net.sf.json.JSONObject
 */
package net.ibizsys.pswx.core;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.psrt.srv.wx.entity.WXAccessToken;
import net.ibizsys.psrt.srv.wx.entity.WXMessage;
import net.ibizsys.pswx.api.WXEntAccessTokenApi;
import net.ibizsys.pswx.api.WXEntJsTicketApi;
import net.ibizsys.pswx.api.WXEntMediaApi;
import net.ibizsys.pswx.api.WXEntMenuApi;
import net.ibizsys.pswx.api.WXEntSendMessageApi;
import net.ibizsys.pswx.bean.WXOutMsg;
import net.ibizsys.pswx.core.IWXAccount;
import net.ibizsys.pswx.core.IWXAccountModel;
import net.ibizsys.pswx.core.IWXEntAppModel;
import net.ibizsys.pswx.core.IWXLogicModel;
import net.ibizsys.pswx.core.IWXMenu;
import net.ibizsys.pswx.core.IWXMenuModel;
import net.ibizsys.pswx.util.SHA1Helper;
import net.sf.json.JSONObject;

public abstract class WXEntAppModelBase
extends ModelBaseImpl
implements IWXEntAppModel {
    private IWXAccountModel iWXAccountModel = null;
    private int nAgentId = -1;
    private String strAppURL = null;
    private String strAppType = null;
    private boolean bReportLocation = false;
    private boolean bReportEnter = false;
    private String strToken = null;
    private String strAppSecret = null;
    private String strEncodingAESKey = null;
    private IWXMenu defaultWXMenu = null;
    private Object objRuntimeId = null;
    private WXAccessToken accessToken = null;
    private String jsTicketToken = "";
    private long jsTicketExpTime = 0L;
    private ArrayList<IWXLogicModel> wxLogicModelList = new ArrayList();

    public void init(IWXAccountModel iWXAccountModel) throws Exception {
        this.iWXAccountModel = iWXAccountModel;
        this.onInit();
    }

    public IWXAccount getWXAccount() {
        return this.iWXAccountModel;
    }

    public String getAppURL() {
        return this.strAppURL;
    }

    public void setAppURL(String strAppURL) {
        this.strAppURL = strAppURL;
    }

    public IWXAccountModel getWXAccountModel() {
        return this.iWXAccountModel;
    }

    public int getAgentId() {
        return this.nAgentId;
    }

    public void setAgentId(int nAgentId) {
        this.nAgentId = nAgentId;
    }

    protected void setId(String strId) {
        this.strId = strId;
    }

    protected void setName(String strName) {
        this.strName = strName;
    }

    public String getAppType() {
        return this.strAppType;
    }

    protected void setAppType(String strAppType) {
        this.strAppType = strAppType;
    }

    public boolean isReportLocation() {
        return this.bReportLocation;
    }

    public boolean isReportEnter() {
        return this.bReportEnter;
    }

    public void setReportLocation(boolean bReportLocation) {
        this.bReportLocation = bReportLocation;
    }

    public void setReportEnter(boolean bReportEnter) {
        this.bReportEnter = bReportEnter;
    }

    public void setAppSecret(String secret) {
        this.strAppSecret = secret;
    }

    public String getAppSecret() {
        return this.strAppSecret;
    }

    public void setToken(String token) {
        this.strToken = token;
    }

    public String getToken() {
        return this.strToken;
    }

    public String getEncodingAESKey() {
        return this.strEncodingAESKey;
    }

    public void setEncodingAESKey(String key) {
        this.strEncodingAESKey = key;
    }

    public IWXMenu getDefaultWXMenu() {
        return this.defaultWXMenu;
    }

    protected void setDefaultWXMenu(IWXMenu defaultWXMenu) {
        this.defaultWXMenu = defaultWXMenu;
    }

    protected void registerWXLogicModel(IWXLogicModel iWXLogicModel) throws Exception {
        this.wxLogicModelList.add(iWXLogicModel);
    }

    public void processWXMessage(WXMessage wxMessage) throws Exception {
        wxMessage.setWXEntAppId(this.getId());
        for (IWXLogicModel iWXLogicModel : this.wxLogicModelList) {
            if (!this.testWXMessage(iWXLogicModel, wxMessage)) continue;
            this.processWXMessage(iWXLogicModel, wxMessage);
            return;
        }
        throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u5904\u7406\u7684\u5fae\u4fe1\u6d88\u606f[%1$s]", (Object)wxMessage.getEvent()));
    }

    protected void processWXMessage(IWXLogicModel iWXLogicModel, WXMessage wxMessage) throws Exception {
        if (StringHelper.isNullOrEmpty((String)iWXLogicModel.getDEName()) || StringHelper.isNullOrEmpty((String)iWXLogicModel.getDEActionName())) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u81ea\u52a8\u5904\u7406\u5fae\u4fe1\u903b\u8f91[%1$s]", (Object)iWXLogicModel.getName()));
        }
        IDataEntityModel iDEModel = DEModelGlobal.getDEModel((String)iWXLogicModel.getDEName());
        iDEModel.getService().executeAction(iWXLogicModel.getDEActionName(), (IEntity)wxMessage);
    }

    protected boolean testWXMessage(IWXLogicModel iWXLogicModel, WXMessage wxMessage) throws Exception {
        if (StringHelper.compare((String)wxMessage.getMsgType(), (String)"event", (boolean)true) == 0) {
            if (StringHelper.compare((String)wxMessage.getEvent(), (String)"enter_agent", (boolean)true) == 0 && StringHelper.compare((String)iWXLogicModel.getEventType(), (String)"app_in", (boolean)true) == 0) {
                return true;
            }
            if (StringHelper.compare((String)wxMessage.getEvent(), (String)"LOCATION", (boolean)true) == 0 && StringHelper.compare((String)iWXLogicModel.getEventType(), (String)"location_in", (boolean)true) == 0) {
                return true;
            }
            if (StringHelper.compare((String)wxMessage.getEvent(), (String)"batch_job_result", (boolean)true) == 0 && StringHelper.compare((String)iWXLogicModel.getEventType(), (String)"asynctask_finish", (boolean)true) == 0) {
                return true;
            }
            if (StringHelper.compare((String)wxMessage.getEvent(), (String)"click", (boolean)true) == 0 && StringHelper.compare((String)iWXLogicModel.getEventType(), (String)"menu_click", (boolean)true) == 0) {
                return true;
            }
            if (StringHelper.compare((String)wxMessage.getEvent(), (String)"view", (boolean)true) == 0 && StringHelper.compare((String)iWXLogicModel.getEventType(), (String)"message_in", (boolean)true) == 0) {
                return true;
            }
        }
        return true;
    }

    protected CallResult createResult(JSONObject json) {
        CallResult callResult = new CallResult();
        if (json.has("errcode")) {
            callResult.setRetCode(json.getInt("errcode"));
        }
        if (json.has("errmsg")) {
            callResult.setErrorInfo(json.getString("errmsg"));
        }
        callResult.setUserObject((Object)json);
        return callResult;
    }

    protected boolean isTicketAvailable() {
        return this.jsTicketExpTime > System.currentTimeMillis();
    }

    protected String getJsTicketToken() {
        if (!this.isTicketAvailable()) {
            this.refreshJsTicketToken();
        }
        return this.jsTicketToken;
    }

    protected void refreshJsTicketToken() {
        try {
            CallResult callResult = WXEntJsTicketApi.call(this.getAccessToken());
            if (callResult.isOk()) {
                JSONObject json = (JSONObject)callResult.getUserObject();
                if (json.has("ticket")) {
                    this.jsTicketToken = json.getString("ticket");
                    this.jsTicketExpTime = System.currentTimeMillis() + (long)((json.getInt("expires_in") - 10) * 1000);
                } else {
                    this.jsTicketToken = "";
                    this.jsTicketExpTime = 0L;
                }
            }
        }
        catch (Exception ex) {
            this.jsTicketToken = "";
            this.jsTicketExpTime = 0L;
        }
    }

    public String getAccessToken() {
        WXAccessToken accessToken = this.getAccessTokenData();
        if (accessToken != null) {
            return accessToken.getAccessToken();
        }
        return null;
    }

    protected boolean isAccessTokenAvailable() {
        return this.accessToken != null && this.accessToken.getExpiredTime() != null && this.accessToken.getExpiredTime().getTime() > System.currentTimeMillis();
    }

    protected WXAccessToken getAccessTokenData() {
        if (!this.isAccessTokenAvailable()) {
            this.accessToken = this.refreshAccessToken();
            this.saveAccessToken(this.accessToken);
        }
        return this.accessToken;
    }

    public WXAccessToken refreshAccessToken() {
        try {
            return this.createAccessToken(WXEntAccessTokenApi.call(this.getWXAccountModel().getCorpId(), this.getAppSecret()));
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected WXAccessToken createAccessToken(CallResult callResult) throws Exception {
        JSONObject json = (JSONObject)callResult.getUserObject();
        if (json.has("access_token")) {
            String access_token = json.getString("access_token");
            int expires_in = json.getInt("expires_in");
            WXAccessToken accessToken = new WXAccessToken();
            accessToken.setAccessToken(access_token);
            accessToken.setExpiredTime(new Timestamp(System.currentTimeMillis() + (long)((expires_in - 10) * 1000)));
            return accessToken;
        }
        return null;
    }

    protected void saveAccessToken(WXAccessToken accessToken) {
    }

    public String createJsToken(String url) {
        String noncestr = UUID.randomUUID().toString();
        long timestamp = System.currentTimeMillis();
        String val = String.format("jsapi_ticket=%1$s&noncestr=%2$s&timestamp=%3$s&url=%4$s", this.getJsTicketToken(), noncestr, timestamp, url);
        String signature = SHA1Helper.encode((String)val);
        JSONObject json = new JSONObject();
        json.put("appId", (Object)this.getWXAccountModel().getCorpId());
        json.put("timestamp", timestamp);
        json.put("nonceStr", (Object)noncestr);
        json.put("signature", (Object)signature);
        return json.toString();
    }

    public CallResult sendMsg(WXOutMsg wxOutMsg) {
        return WXEntSendMessageApi.send(this.getAccessToken(), wxOutMsg.toJSON());
    }

    public CallResult downloadMedia(String mediaId) {
        CallResult callResult = new CallResult();
        try {
            String strFileLocalPath = WebConfig.getCurrent().getFilePath();
            if (StringHelper.isNullOrEmpty((String)strFileLocalPath)) {
                callResult.setRetCode(-1);
                callResult.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u6587\u4ef6\u4fdd\u5b58\u76ee\u5f55");
                return callResult;
            }
            String strFileFolder = String.valueOf(StringHelper.format((String)"%1$tY-%1$tm-%1$td", (Object)new Date())) + File.separator + KeyValueHelper.genGuidEx().toUpperCase() + File.separator;
            File dir = new File(String.valueOf(strFileLocalPath) + strFileFolder);
            dir.mkdirs();
            String strFilename = String.valueOf(mediaId) + ".jpg";
            String strFilePathName = String.valueOf(strFileLocalPath) + strFileFolder;
            File saveFile = new File(String.valueOf(strFilePathName) + strFilename);
            boolean result = WXEntMediaApi.downloadMedia(this.getAccessToken(), mediaId, saveFile);
            if (result) {
                net.ibizsys.psrt.srv.common.entity.File file = new net.ibizsys.psrt.srv.common.entity.File();
                file.setFileSize(Integer.valueOf((int)saveFile.length()));
                file.setFileName(strFilename);
                file.setLocalPath(String.valueOf(strFileFolder) + strFilename);
                callResult.setRetCode(0);
                callResult.setUserObject((Object)file);
            } else {
                callResult.setRetCode(-1);
                callResult.setErrorInfo("\u4e0b\u8f7d\u6587\u4ef6\u5931\u8d25");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
            callResult.setRetCode(-1);
            callResult.setErrorInfo(ex.getMessage());
        }
        return callResult;
    }

    public CallResult publishMenu() {
        return WXEntMenuApi.createMenu(this.getAccessToken(), this.getAgentId(), ((IWXMenuModel)this.getDefaultWXMenu()).toJSON());
    }

    public CallResult deleteMenu() {
        return WXEntMenuApi.deleteMenu(this.getAccessToken(), this.getAgentId());
    }

    public CallResult getMenu() {
        return WXEntMenuApi.getMenu(this.getAccessToken(), this.getAgentId());
    }

    public Object getRuntimeId() {
        if (this.objRuntimeId == null) {
            return this.getId();
        }
        return this.objRuntimeId;
    }

    public void setRuntimeId(Object objRuntimeId) {
        this.objRuntimeId = objRuntimeId;
    }
}

