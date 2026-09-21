/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletInputStream
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  net.ibizsys.paas.appmodel.AppModelGlobal
 *  net.ibizsys.paas.appmodel.IAppDEViewModel
 *  net.ibizsys.paas.appmodel.IAppViewModel
 *  net.ibizsys.paas.appmodel.IApplicationModel
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.core.IDERIndex
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDEWFModel
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.sysmodel.ISystemRuntime
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.psrt.srv.common.entity.File
 *  net.ibizsys.psrt.srv.common.entity.LoginAccount
 *  net.ibizsys.psrt.srv.common.service.FileService
 *  net.ibizsys.psrt.srv.common.service.LoginAccountService
 *  net.ibizsys.psrt.srv.demodel.entity.DataEntity
 *  net.ibizsys.psrt.srv.demodel.service.DataEntityService
 *  net.ibizsys.psrt.srv.wf.entity.WFInstance
 *  net.ibizsys.psrt.srv.wf.service.WFInstanceService
 *  net.ibizsys.psrt.srv.wx.entity.WXMessage
 *  net.ibizsys.pswx.bean.WXMessageHelper
 *  net.ibizsys.pswx.bean.WXOutMsg
 *  net.ibizsys.pswx.bean.WXOutTextMsg
 *  net.ibizsys.pswx.core.IWXAccountModel
 *  net.ibizsys.pswx.core.IWXEntAppModel
 *  net.ibizsys.pswx.core.WXGlobal
 *  net.sf.json.JSON
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.log4j.Logger
 *  org.hibernate.SessionFactory
 *  org.springframework.web.bind.annotation.RequestMapping
 */
package net.ibizsys.pswx.controller;

import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.ibizsys.paas.appmodel.AppModelGlobal;
import net.ibizsys.paas.appmodel.IAppDEViewModel;
import net.ibizsys.paas.appmodel.IAppViewModel;
import net.ibizsys.paas.appmodel.IApplicationModel;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.IDERIndex;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDEWFModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.ISystemRuntime;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.common.entity.File;
import net.ibizsys.psrt.srv.common.entity.LoginAccount;
import net.ibizsys.psrt.srv.common.service.FileService;
import net.ibizsys.psrt.srv.common.service.LoginAccountService;
import net.ibizsys.psrt.srv.demodel.entity.DataEntity;
import net.ibizsys.psrt.srv.demodel.service.DataEntityService;
import net.ibizsys.psrt.srv.wf.entity.WFInstance;
import net.ibizsys.psrt.srv.wf.service.WFInstanceService;
import net.ibizsys.psrt.srv.wx.entity.WXMessage;
import net.ibizsys.pswx.api.WXEntAuthApi;
import net.ibizsys.pswx.api.WXEntUserInfoApi;
import net.ibizsys.pswx.bean.WXMessageHelper;
import net.ibizsys.pswx.bean.WXOutMsg;
import net.ibizsys.pswx.bean.WXOutTextMsg;
import net.ibizsys.pswx.core.IWXAccountModel;
import net.ibizsys.pswx.core.IWXEntAppModel;
import net.ibizsys.pswx.core.WXGlobal;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.web.bind.annotation.RequestMapping;

public abstract class WXEntAppController {
    private static final Logger log = Logger.getLogger(WXEntAppController.class);
    public static final String ACTION_AUTH = "SRFAUTH";
    private String wxAccountId = null;
    private int wxAppAgentId = -1;
    private String wfredirectUrl = null;
    private String appModelClazz = null;
    private WXBizMsgCrypt wxcpt = null;
    private IApplicationModel iApplicationModel = null;

    protected String getWXAccountId() {
        return this.wxAccountId;
    }

    protected void setWXAccountId(String wxAccountId) {
        this.wxAccountId = wxAccountId;
    }

    protected int getWXEntAppId() {
        return this.wxAppAgentId;
    }

    protected void setWXEntAppId(int wxAppAgentId) {
        this.wxAppAgentId = wxAppAgentId;
    }

    protected String getWFRedirectUrl() {
        if (StringHelper.isNullOrEmpty((String)this.wfredirectUrl)) {
            String appURL = this.getWXEntApp().getAppURL();
            if (appURL == null) {
                return null;
            }
            int nPos = appURL.lastIndexOf("/");
            if (nPos != -1) {
                appURL = appURL.substring(0, nPos);
            }
            if ((nPos = appURL.lastIndexOf("/")) != -1) {
                appURL = appURL.substring(0, nPos);
            }
            this.wfredirectUrl = String.valueOf(appURL) + "/ibizutil/redirectview.html";
        }
        return this.wfredirectUrl;
    }

    protected void setWFRedirectUrl(String url) {
        this.wfredirectUrl = url;
    }

    protected void setAppModelClazz(String clazz) {
        this.appModelClazz = clazz;
    }

    protected SessionFactory getSessionFactory() {
        if (this.getAppModel() != null && this.getAppModel().getSystem() != null && this.getAppModel().getSystem() instanceof ISystemRuntime) {
            return ((ISystemRuntime)this.getAppModel().getSystem()).getSessionFactory();
        }
        return null;
    }

    protected IWXAccountModel getWXAccount() {
        String strAccountId = this.getWXAccountId();
        if (StringHelper.isNullOrEmpty((String)strAccountId)) {
            log.error((Object)"\u5fae\u4fe1\u516c\u4f17\u53f7\u6807\u8bc6\u4e3a\u7a7a\uff0c\u63a5\u53e3\u65e0\u6548");
            return null;
        }
        try {
            return WXGlobal.getWXAccountModel((String)strAccountId);
        }
        catch (Exception e) {
            log.error((Object)"\u65e0\u6cd5\u83b7\u53d6\u5fae\u4fe1\u516c\u4f17\u53f7", (Throwable)e);
            return null;
        }
    }

    protected IWXEntAppModel getWXEntApp() {
        IWXAccountModel account = this.getWXAccount();
        if (account != null) {
            try {
                return account.getWXEntAppModel(this.getWXEntAppId());
            }
            catch (Exception e) {
                log.error((Object)"\u65e0\u6cd5\u83b7\u53d6\u5fae\u4fe1\u4f01\u4e1a\u53f7\u5e94\u7528", (Throwable)e);
            }
        }
        return null;
    }

    protected WXBizMsgCrypt getWXBizMsgCrypt() throws Exception {
        if (this.wxcpt == null) {
            IWXEntAppModel app = this.getWXEntApp();
            if (app == null) {
                return null;
            }
            this.wxcpt = new WXBizMsgCrypt(app.getToken(), app.getEncodingAESKey(), this.getWXAccount().getCorpId());
        }
        return this.wxcpt;
    }

    protected String getPostData(HttpServletRequest request) throws Exception {
        WXBizMsgCrypt wxcpt = this.getWXBizMsgCrypt();
        String sReqMsgSig = request.getParameter("msg_signature");
        String sReqTimeStamp = request.getParameter("timestamp");
        String sReqNonce = request.getParameter("nonce");
        ServletInputStream in = request.getInputStream();
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        byte[] tmpbuf = new byte[1024];
        int count = 0;
        while ((count = in.read(tmpbuf)) != -1) {
            bout.write(tmpbuf, 0, count);
            tmpbuf = new byte[1024];
        }
        in.close();
        byte[] orgData = bout.toByteArray();
        String strContent = new String(orgData, "UTF8");
        return wxcpt.DecryptMsg(sReqMsgSig, sReqTimeStamp, sReqNonce, strContent);
    }

    protected IWebContext createWebContext(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return this.getAppModel().createWebContext(null, request, response);
    }

    public IApplicationModel getAppModel() {
        if (this.iApplicationModel == null) {
            try {
                this.iApplicationModel = (IApplicationModel)AppModelGlobal.getApplication((String)this.appModelClazz);
            }
            catch (Exception e) {
                log.error((Object)("\u65e0\u6cd5\u83b7\u53d6\u5e94\u7528\u7a0b\u5e8f\u6a21\u578b[" + this.appModelClazz + "]"), (Throwable)e);
            }
        }
        return this.iApplicationModel;
    }

    protected void onVerifyAPIUrl(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String sVerifyMsgSig = request.getParameter("msg_signature");
        String sVerifyTimeStamp = request.getParameter("timestamp");
        String sVerifyNonce = request.getParameter("nonce");
        String sVerifyEchoStr = request.getParameter("echostr");
        String sEchoStr = "";
        try {
            WXBizMsgCrypt wxcpt = this.getWXBizMsgCrypt();
            sEchoStr = wxcpt.VerifyURL(sVerifyMsgSig, sVerifyTimeStamp, sVerifyNonce, sVerifyEchoStr);
        }
        catch (Exception ex) {
            log.error((Object)("\u5fae\u4fe1\u4f01\u4e1a\u5e94\u7528[" + this.getWXEntAppId() + "]\u6821\u9a8capi\u5408\u6cd5\u6027\u5931\u8d25"), (Throwable)ex);
        }
        response.getWriter().print(sEchoStr);
    }

    protected void onProcessIncomingMsg(HttpServletRequest request, HttpServletResponse response) {
        block2: {
            WXMessage wxMessage = null;
            try {
                wxMessage = WXMessageHelper.getWXMessage((String)this.getPostData(request));
                log.debug((Object)("\u63a5\u6536\u5230\u5fae\u4fe1\u5e94\u7528[" + this.getWXEntAppId() + "]\u6d88\u606f[" + wxMessage.toJSONString() + "]"));
                this.getWXEntApp().processWXMessage(wxMessage);
            }
            catch (Exception ex) {
                log.error((Object)("\u5904\u7406\u5fae\u4fe1\u5e94\u7528[" + this.getWXEntAppId() + "]\u6d88\u606f\u5931\u8d25"), (Throwable)ex);
                if (wxMessage == null) break block2;
                WXOutTextMsg textMsg = new WXOutTextMsg();
                textMsg.setAgentid(this.getWXEntAppId());
                textMsg.setContent(ex.getMessage());
                textMsg.setCreatetime(System.currentTimeMillis());
                textMsg.setFromusername(this.getWXAccount().getCorpId());
                textMsg.setSafe(0);
                textMsg.setTouser(wxMessage.getFromUserName());
                CallResult callResult = this.getWXEntApp().sendMsg((WXOutMsg)textMsg);
                log.error((Object)("\u53d1\u9001\u5fae\u4fe1\u6d88\u606f\u5931\u8d25," + callResult.getErrorInfo()));
            }
        }
    }

    protected void onDoVisitAuth(IWebContext iWebContext) throws Exception {
        IWXEntAppModel iWXEntAppModel = this.getWXEntApp();
        if (iWXEntAppModel == null) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5fae\u4fe1\u4f01\u4e1a\u53f7\u5e94\u7528");
        }
        if (!StringHelper.isNullOrEmpty((String)WebContext.getCurrent().getCurUserId())) {
            iWebContext.getResponse().sendRedirect(iWXEntAppModel.getAppURL());
        } else {
            String url = iWebContext.getRequest().getRequestURL().toString();
            String authUrl = WXEntAuthApi.createAuthUrl(iWXEntAppModel.getWXAccountModel().getCorpId(), iWXEntAppModel.getAgentId(), url, null, ACTION_AUTH);
            iWebContext.getResponse().sendRedirect(authUrl);
        }
    }

    protected void onDoVisitAuthCallBack(IWebContext iWebContext) throws Exception {
        String code = iWebContext.getRequest().getParameter("code");
        if (!StringHelper.isNullOrEmpty((String)code)) {
            IWXEntAppModel iWXEntAppModel = this.getWXEntApp();
            CallResult callResult = WXEntUserInfoApi.call(iWXEntAppModel.getAccessToken(), code);
            if (callResult.getRetCode() == 0 && callResult.getUserObject() instanceof JSONObject) {
                JSONObject json = (JSONObject)callResult.getUserObject();
                String userId = json.getString("UserId");
                LoginAccountService loginAccountService = (LoginAccountService)ServiceGlobal.getService(LoginAccountService.class);
                LoginAccount loginAccount = new LoginAccount();
                loginAccount.setLoginAccountName(userId);
                if (!loginAccountService.select((IEntity)loginAccount, true)) {
                    iWebContext.getResponse().getWriter().write("\u8d26\u6237\u4e0d\u5b58\u5728");
                    return;
                }
                WebContext.fillByLoginAccount((IWebContext)iWebContext, (LoginAccount)loginAccount);
                iWebContext.login(userId);
                iWebContext.getResponse().sendRedirect(iWXEntAppModel.getAppURL());
            } else {
                iWebContext.getResponse().getWriter().write("\u83b7\u53d6\u5fae\u4fe1\u6388\u6743\u7528\u6237\u4fe1\u606f\u5f02\u5e38\uff0c" + callResult.getUserObject());
            }
        } else {
            iWebContext.getResponse().getWriter().write("\u5fae\u4fe1\u8eab\u4efd\u9a8c\u8bc1\u56de\u8c03\u5931\u8d25\uff0c\u65e0\u6cd5\u83b7\u53d6[code]\u53c2\u6570");
        }
    }

    protected void onDoUpload(IWebContext iWebContext) throws Exception {
        JSONObject json = new JSONObject();
        String serverId = iWebContext.getRequest().getParameter("serverId");
        if (StringHelper.isNullOrEmpty((String)serverId)) {
            json.put("ret", -1);
            json.put("errorMessage", (Object)"\u65e0\u6cd5\u83b7\u53d6\u6587\u4ef6\u7684serverId");
            iWebContext.getResponse().getWriter().write(json.toString());
            return;
        }
        IWXEntAppModel iWXEntAppModel = this.getWXEntApp();
        CallResult callResult = iWXEntAppModel.downloadMedia(serverId);
        if (callResult.isError() || !(callResult.getUserObject() instanceof File)) {
            json.put("ret", -1);
            json.put("errorMessage", (Object)"\u4e0b\u8f7d\u6587\u4ef6\u5931\u8d25");
            log.error((Object)("\u4ece\u5fae\u4fe1\u670d\u52a1\u5668\u4e0b\u8f7d\u6587\u4ef6[" + serverId + "]\u5931\u8d25," + callResult.getErrorInfo()));
        } else {
            try {
                File file = (File)callResult.getUserObject();
                FileService fileService = (FileService)ServiceGlobal.getService(FileService.class, (SessionFactory)this.getSessionFactory());
                fileService.create((IEntity)file);
                JSONObject jsonFile = new JSONObject();
                jsonFile.put("id", (Object)file.getFileId());
                jsonFile.put("name", (Object)file.getFileName());
                JSONArray files = new JSONArray();
                files.put((JSON)jsonFile);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("files", (Object)files);
                json.put("ret", 0);
                json.put("obj", (Object)jsonObject);
            }
            catch (Exception ex) {
                json.put("ret", -1);
                log.error((Object)("\u4fdd\u5b58\u5fae\u4fe1\u6587\u4ef6[" + serverId + "]\u5931\u8d25"), (Throwable)ex);
            }
        }
        iWebContext.getResponse().getWriter().write(json.toString());
    }

    protected void doWFAuthResult() throws Exception {
        String code = WebContext.getCurrent().getRequest().getParameter("code");
        if (!StringHelper.isNullOrEmpty((String)code)) {
            CallResult callResult = WXEntUserInfoApi.call(this.getWXEntApp().getAccessToken(), code);
            if (callResult.getRetCode() == 0 && callResult.getUserObject() instanceof JSONObject) {
                JSONObject json = (JSONObject)callResult.getUserObject();
                String userId = json.getString("UserId");
                LoginAccountService loginAccountService = (LoginAccountService)ServiceGlobal.getService(LoginAccountService.class);
                LoginAccount loginAccount = new LoginAccount();
                loginAccount.setLoginAccountName(userId);
                if (!loginAccountService.select((IEntity)loginAccount, true)) {
                    WebContext.getCurrent().getResponse().getWriter().write("\u8d26\u6237\u4e0d\u5b58\u5728");
                    return;
                }
                WebContext.fillByLoginAccount((IWebContext)WebContext.getCurrent(), (LoginAccount)loginAccount);
                WebContext.getCurrent().login(userId);
                this.doWFRedirect();
            } else {
                WebContext.getCurrent().getResponse().getWriter().write("\u5fae\u4fe1\u6388\u6743\u5f02\u5e38");
            }
        }
    }

    protected void doWFRedirect() throws IOException {
        CallResult result = this.getWFRedirectData();
        JSONObject json = new JSONObject();
        json.put("ret", result.getRetCode());
        json.put("errorInfo", (Object)result.getErrorInfo());
        json.put("data", result.getUserObject());
        String data = json.toString();
        data = URLEncoder.encode(data, "utf-8");
        WebContext.getCurrent().getResponse().sendRedirect(String.valueOf(this.getWFRedirectUrl()) + "?redirectdata=" + data);
    }

    protected CallResult getWFRedirectData() {
        CallResult result = new CallResult();
        try {
            String wfInstanceId = WebContext.getCurrent().getRequest().getParameter("wfinstanceid");
            WFInstanceService wfinsService = (WFInstanceService)ServiceGlobal.getService(WFInstanceService.class, (SessionFactory)this.getSessionFactory());
            DataEntityService entityService = (DataEntityService)ServiceGlobal.getService(DataEntityService.class, (SessionFactory)this.getSessionFactory());
            WFInstance wfIns = new WFInstance();
            wfIns.setWFInstanceId(wfInstanceId);
            if (!wfinsService.select((IEntity)wfIns, true)) {
                result.setRetCode(-1);
                result.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u6d41\u7a0b\u5b9e\u4f8b\u6570\u636e");
                return result;
            }
            String deid = wfIns.getUserData4();
            String srfkey = wfIns.getUserData();
            DataEntity entity = new DataEntity();
            entity.setDEId(deid);
            if (!entityService.select((IEntity)entity, true)) {
                result.setRetCode(-1);
                result.setErrorInfo("\u65e0\u6cd5\u5b9e\u4f53\u5b9a\u4e49\u6570\u636e");
                return result;
            }
            String strDEName = entity.getDEName();
            IAppViewModel iAppViewModel = this.getRDAppViewModel(deid, srfkey);
            String url = StringHelper.format((String)"/%1$s/%2$s.html", (Object)iAppViewModel.getModuleName(), (Object)iAppViewModel.getName()).toLowerCase();
            JSONObject json = new JSONObject();
            json.put("viewurl", (Object)url);
            json.put("srfdeid", (Object)strDEName);
            json.put("srfkey", (Object)srfkey);
            json.put("title", (Object)iAppViewModel.getTitle());
            result.setUserObject((Object)json);
        }
        catch (Exception ex) {
            result.setRetCode(-1);
            result.setErrorInfo(ex.getMessage());
        }
        return result;
    }

    protected IAppViewModel getRDAppViewModel(String strDEName, String strKeyValue) throws Exception {
        IDEWFModel iDEWF;
        IEntity iEntity;
        IDataEntityModel iDEModel = DEModelGlobal.getDEModel((String)strDEName);
        IDataEntityModel<?> iRealDEModel = this.getRealDEModel(iDEModel, iEntity = this.getActiveEntity(iDEModel, strKeyValue));
        if (iRealDEModel != iDEModel) {
            iEntity = this.getActiveEntity(iRealDEModel, strKeyValue);
        }
        boolean bDataInWF = false;
        boolean bWFMode = false;
        if (this.isEnableWorkflow() && (iDEWF = iRealDEModel.testDataInWF(iEntity)) != null) {
            bDataInWF = true;
            bWFMode = iDEWF.testUserWFSubmit(iEntity, WebContext.getCurrent().getCurUserId(), this.getSessionFactory());
        }
        String strPDTViewParam = "MOB" + iRealDEModel.getSDDEViewPDTParam(iEntity, bDataInWF, bWFMode);
        IAppDEViewModel iAppViewModel = null;
        String strDEViewId = iRealDEModel.getDEViewIdByPDT(strPDTViewParam, false);
        iAppViewModel = this.getAppModel().getAppViewByDEViewId(strDEViewId, false);
        return iAppViewModel;
    }

    protected IDataEntityModel<?> getRealDEModel(IDataEntityModel<?> iDEModel, IEntity iEntity) throws Exception {
        IDataEntityModel curDEModel = iDEModel;
        if (StringHelper.isNullOrEmpty((String)curDEModel.getIndexDEType())) {
            return curDEModel;
        }
        Object objKeyValue = iEntity.get(iDEModel.getKeyDEField().getName());
        while (true) {
            String strIndexType;
            if (StringHelper.isNullOrEmpty((String)(strIndexType = DataObject.getStringValue((IDataObject)iEntity, (String)curDEModel.getIndexTypeDEField().getName(), null)))) {
                throw new Exception(StringHelper.format((String)"\u5f53\u524d\u6570\u636e\u672a\u63d0\u4f9b\u7d22\u5f15\u7c7b\u578b\u503c"));
            }
            IDERIndex iDERIndex = curDEModel.getDERIndex(true, strIndexType);
            if (StringHelper.isNullOrEmpty((String)(curDEModel = DEModelGlobal.getDEModel((String)iDERIndex.getMinorDEId())).getIndexDEType())) {
                return curDEModel;
            }
            iEntity = this.getActiveEntity(curDEModel, objKeyValue);
        }
    }

    protected IEntity getActiveEntity(IDataEntityModel iRealDEModel, Object strKeyValue) throws Exception {
        IEntity iEntity = iRealDEModel.createEntity();
        iEntity.set(iRealDEModel.getKeyDEField().getName(), strKeyValue);
        iRealDEModel.getService(this.getSessionFactory()).get(iEntity);
        return iEntity;
    }

    protected boolean isEnableWorkflow() {
        return true;
    }

    protected String getRespContent(HttpServletRequest request, WXOutMsg wxMessage) throws Exception {
        String strData = wxMessage.toXMLStr();
        String sReqTimeStamp = request.getParameter("timestamp");
        String sReqNonce = request.getParameter("nonce");
        return this.getWXBizMsgCrypt().EncryptMsg(strData, sReqTimeStamp, sReqNonce);
    }

    @RequestMapping(value={"/msg.do"})
    public void processMessage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        if (StringHelper.compare((String)request.getMethod(), (String)"GET", (boolean)true) == 0) {
            this.onVerifyAPIUrl(request, response);
        } else if (StringHelper.compare((String)request.getMethod(), (String)"POST", (boolean)true) == 0) {
            this.onProcessIncomingMsg(request, response);
        } else {
            throw new Exception("\u65e0\u6cd5\u5904\u7406\u7684\u8bf7\u6c42\u7c7b\u578b" + request.getMethod());
        }
    }

    @RequestMapping(value={"/visit.do"})
    public void processVisit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        IWebContext iWebContext = this.createWebContext(request, response);
        WebContext.setCurrent((IWebContext)iWebContext);
        String state = iWebContext.getRequest().getParameter("state");
        if (StringHelper.compare((String)ACTION_AUTH, (String)state, (boolean)true) == 0) {
            this.onDoVisitAuthCallBack(iWebContext);
        } else {
            this.onDoVisitAuth(iWebContext);
        }
    }

    @RequestMapping(value={"/uploadfile.do"})
    public void processUpload(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        IWebContext iWebContext = this.createWebContext(request, response);
        WebContext.setCurrent((IWebContext)iWebContext);
        this.onDoUpload(iWebContext);
    }

    @RequestMapping(value={"/jsticket.do"})
    public void processJsTicket(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        IWXEntAppModel iWXEntAppModel = this.getWXEntApp();
        String strRequestUrl = request.getRequestURL().toString();
        String strRequestUri = request.getRequestURI();
        String url = strRequestUrl.substring(0, strRequestUrl.indexOf(strRequestUri));
        url = String.valueOf(url) + request.getContextPath() + "/" + request.getParameter("url");
        String token = iWXEntAppModel.createJsToken(url);
        JSONObject json = new JSONObject();
        json.put("ret", 0);
        json.put("obj", (Object)token);
        response.getWriter().write(json.toString());
    }

    @RequestMapping(value={"/wfredirect.do"})
    public void processWFRedirect(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        try {
            IWebContext iWebContext = this.createWebContext(request, response);
            WebContext.setCurrent((IWebContext)iWebContext);
            String state = iWebContext.getRequest().getParameter("state");
            if (StringHelper.compare((String)ACTION_AUTH, (String)state, (boolean)true) == 0) {
                this.doWFAuthResult();
            } else {
                IWXEntAppModel iWXEntAppModel = this.getWXEntApp();
                if (!StringHelper.isNullOrEmpty((String)WebContext.getCurrent().getCurUserId())) {
                    this.doWFRedirect();
                } else {
                    String strRedirectUrl = String.valueOf(request.getRequestURL().toString()) + "?" + request.getQueryString();
                    String authUrl = WXEntAuthApi.createAuthUrl(iWXEntAppModel.getWXAccountModel().getCorpId(), iWXEntAppModel.getAgentId(), strRedirectUrl, null, ACTION_AUTH);
                    response.sendRedirect(authUrl);
                }
            }
        }
        catch (Exception e) {
            response.getWriter().write(e.getMessage());
        }
    }
}

