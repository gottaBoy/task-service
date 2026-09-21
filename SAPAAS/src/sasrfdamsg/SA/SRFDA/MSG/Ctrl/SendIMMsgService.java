/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.BaseService
 *  SA.SRFDA.Ctrl.Data.MsgSendQueue
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.httpclient.HttpClient
 *  org.apache.commons.httpclient.HttpMethod
 *  org.apache.commons.httpclient.methods.PostMethod
 *  org.apache.commons.httpclient.methods.RequestEntity
 *  org.apache.commons.httpclient.methods.StringRequestEntity
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.MSG.Ctrl;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.BaseService;
import SA.SRFDA.Ctrl.Data.MsgSendQueue;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import net.sf.json.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SendIMMsgService
extends BaseService {
    private static Log log = LogFactory.getLog(SendIMMsgService.class);
    private Timer sendMsgTimer = null;
    private int nSendTimer = 30000;
    protected boolean bSending = false;
    protected boolean bPlanSendTime = false;
    private static final int EXPTIME = 864000000;
    private static final String DEFAULT_SENDER = "SYSTEM";
    private static final String TAG_USER = "USER";
    private static final String TAG_ALL = "ALL";
    private static final String TAG_WF = "1001";
    private static final String TAG_WFCANCEL = "1002";
    private static final String TAG_CANCELED = "CANCELED";
    private static final String TAG_IMACTION = "USERINFORM";
    public String strIMServerUrl = "";
    private Vector<MsgSendQueue> msgList = new Vector();
    private Vector<MsgSendQueue> msgList2 = new Vector();
    protected String strQuerySQL = "select * from T_SRFMSGSendQUEUE where PROCESSTIME IS NULL AND MSGTYPE = 16 AND (USERDATA4 IS NULL OR USERDATA4 <> '1002') ";
    protected String strQuerySQL2 = "select * from T_SRFMSGSendQUEUE where PROCESSTIME IS NULL  AND (PLANSENDTIME IS NULL OR PLANSENDTIME<? ) AND MSGTYPE = 16 AND (USERDATA4 IS NULL OR USERDATA4 <> '1002') ";
    protected String strCancelQuerySQL = "select distinct userdata ,msgsendqueueid,createdate from T_SRFMSGSendQUEUE where MSGTYPE = 16  AND USERDATA3='1002'";
    protected String strCancelQuerySQL2 = "delete from T_SRFMSGSendQUEUE where MSGTYPE = 16 and userdata = ? and createdate<?";
    protected String strCancelQueryHisSQL = "select * from T_SRFMSGSendQUEUEHIS WHERE USERDATA =? AND ( USERDATA4 IS NULL OR USERDATA4 <> 'CANCELED')";

    protected CallResult OnInit() {
        String strQMHelperObject;
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        if (this.iDAGlobalHelper.getDAModelVersion() >= 10111600) {
            this.strQuerySQL = this.strQuerySQL2;
            this.bPlanSendTime = true;
        }
        this.nSendTimer = Integer.parseInt(this.GetServiceParam("SENDTIME", "30000"));
        if (this.nSendTimer < 10000) {
            this.nSendTimer = 30000;
        }
        this.strIMServerUrl = this.GetServiceParam("IMSERVERURL", "");
        if (StringHelper.IsNullOrEmpty((String)this.strIMServerUrl)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9aIM\u670d\u52a1\u5668\u5730\u5740"));
            return callResult;
        }
        if (this.iDAGlobalHelper.getDAModelVersion() >= 10111600) {
            this.strQuerySQL = this.strQuerySQL2;
        }
        if (StringHelper.IsNullOrEmpty((String)(strQMHelperObject = this.iDAGlobalHelper.getWebExConfig().GetValue("SRFDA", "DAQUERYMODELHELPER", "")))) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u67e5\u8be2\u67e5\u8be2\u8f85\u52a9\u5bf9\u8c61"));
            return callResult;
        }
        BaseDAQueryModelHelper daQueryModelHelper = (BaseDAQueryModelHelper)ObjectHelper.Create((String)strQMHelperObject);
        if (daQueryModelHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u67e5\u8be2\u8f85\u52a9\u5bf9\u8c61[%1$s]", (Object)strQMHelperObject));
            return callResult;
        }
        int nPageSize = Integer.parseInt(this.GetServiceParam("PAGESIZE", "100"));
        this.strQuerySQL = daQueryModelHelper.GetPagingSQL(this.strQuerySQL, 0, nPageSize, "CREATEDATE", "ASC", "", "");
        return callResult;
    }

    protected CallResult OnStart() {
        CallResult callResult = super.OnStart();
        if (callResult.IsError()) {
            return callResult;
        }
        if (this.sendMsgTimer == null) {
            this.sendMsgTimer = new Timer("IMMSGSENDQUEUE");
            this.sendMsgTimer.schedule((TimerTask)((Object)this), this.nSendTimer, (long)this.nSendTimer);
        }
        log.info((Object)StringHelper.Format((String)"Send IM Msg Start"));
        return callResult;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void run() {
        SendIMMsgService sendIMMsgService = this;
        synchronized (sendIMMsgService) {
            if (this.bSending) {
                return;
            }
            this.bSending = true;
        }
        this.InternalRun();
        sendIMMsgService = this;
        synchronized (sendIMMsgService) {
            this.bSending = false;
        }
    }

    protected void InternalRun() {
        IDEDataCtrl iMsgSendQueueDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("DE0077", DEFAULT_SENDER, null);
        if (iMsgSendQueueDataCtrl == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0077"));
            return;
        }
        IDEDataCtrl iMsgSendQueueHisDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("DE0085", DEFAULT_SENDER, null);
        if (iMsgSendQueueHisDataCtrl == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0085"));
            return;
        }
        CallParamList cancelParamList = new CallParamList();
        cancelParamList.Add((Object)TAG_WFCANCEL);
        Vector sendIMQueueList2 = new Vector();
        CallResult callResult2 = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.strCancelQuerySQL, null, sendIMQueueList2, (String)MsgSendQueue.class.getName());
        if (callResult2.IsOk()) {
            for (MsgSendQueue msg : sendIMQueueList2) {
                ArrayList<MsgSendQueue> tmpList = new ArrayList<MsgSendQueue>();
                for (MsgSendQueue omsg : this.msgList) {
                    if (StringHelper.Compare((String)omsg.getUSERDATA(), (String)msg.getUSERDATA(), (boolean)true) != 0) continue;
                    tmpList.add(omsg);
                }
                this.msgList.removeAll(tmpList);
                Vector<CallParam> vector = new Vector<CallParam>();
                CallParam cp1 = new CallParam();
                cp1.setValue((Object)msg.getUSERDATA());
                vector.add(cp1);
                CallParam cp2 = new CallParam();
                cp2.setValue((Object)msg.getCREATEDATE());
                vector.add(cp2);
                BaseDEDataCtrl.ExecuteWithoutResult((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.strCancelQuerySQL2, vector);
                CallParamList cancelParamList2 = new CallParamList();
                cancelParamList2.Add((Object)msg.getUSERDATA());
                Vector cancelHisList3 = new Vector();
                CallResult callResult3 = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.strCancelQueryHisSQL, (Vector)cancelParamList2.GetList(), cancelHisList3, (String)MsgSendQueue.class.getName());
                for (MsgSendQueue hmsg : cancelHisList3) {
                    hmsg.setUSERDATA2(TAG_CANCELED);
                    String strMessageId = hmsg.getUSERDATA3();
                    if (!StringHelper.IsNullOrEmpty((String)strMessageId)) {
                        this.cancelIMMessage(strMessageId);
                    }
                    iMsgSendQueueHisDataCtrl.Save(false, (BaseDataEntity)hmsg);
                }
                iMsgSendQueueDataCtrl.Remove((BaseDataEntity)msg);
            }
        }
        this.DoSendMsg();
        CallParamList callParamList = new CallParamList();
        if (this.bPlanSendTime) {
            Date date = new Date();
            Timestamp sendTime = new Timestamp(date.getTime() + 30000L);
            callParamList.AddDateTime((Object)sendTime);
        }
        Vector sendIMQueueList = new Vector();
        CallResult callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.strQuerySQL, (Vector)callParamList.GetList(), sendIMQueueList, (String)MsgSendQueue.class.getName());
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u672a\u53d1\u9001IM\u6d88\u606f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return;
        }
        if (sendIMQueueList.size() == 0) {
            return;
        }
        for (MsgSendQueue msgSendQueue : sendIMQueueList) {
            msgSendQueue.SetParamValue("PROCESSTIME", (Object)DateParser.GetTimestampValue((Object)new Date()));
            try {
                this.msgList.add(msgSendQueue);
                msgSendQueue.setISSEND(true);
                iMsgSendQueueDataCtrl.Save(false, (BaseDataEntity)msgSendQueue);
                MsgSendQueue msgSendQueue2 = new MsgSendQueue();
                msgSendQueue.setISSEND(true);
                msgSendQueue.CopyTo((BaseDataEntity)msgSendQueue2, true);
                msgSendQueue2.SetParamValue("MSGSENDQUEUEHISID", (Object)msgSendQueue.getMSGSENDQUEUEID());
                msgSendQueue2.SetParamValue("MSGSENDQUEUEHISNAME", (Object)msgSendQueue.getMSGSENDQUEUENAME());
                callResult = iMsgSendQueueHisDataCtrl.Save(true, (BaseDataEntity)msgSendQueue2);
                if (callResult.IsError()) {
                    throw new Exception(StringHelper.Format((String)"\u5c06\u53d1\u9001\u6570\u636e\u653e\u5165\u53d1\u9001\u5386\u53f2\u8bb0\u5f55\u961f\u5217\u4e2d\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                iMsgSendQueueDataCtrl.Remove((BaseDataEntity)msgSendQueue);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.DoSendMsg();
    }

    private void DoSendMsg() {
        this.msgList2.clear();
        for (MsgSendQueue msg : this.msgList) {
            JSONObject jo = new JSONObject();
            String strReceiver = msg.getDSTUSERS();
            String strContent = msg.getCONTENT();
            jo.put("subject", (Object)msg.getSUBJECT());
            String[] arr = strContent.split("[|]");
            String expiredtime = DateParser.toDateString((Date)new Date(new Date().getTime() + 864000000L));
            if (arr.length == 2) {
                jo.put("content", (Object)arr[0]);
                jo.put("url", (Object)arr[1]);
            } else {
                jo.put("content", (Object)strContent);
            }
            if (!StringHelper.IsNullOrEmpty((String)msg.getDSTADDRESSES())) {
                jo.put("url", (Object)msg.getDSTADDRESSES());
            }
            String msgId = "";
            String strUserType = msg.getUSERDATA3();
            String strReceiverType = msg.getUSERDATA2();
            if (StringHelper.Compare((String)strReceiverType, (String)TAG_ALL, (boolean)true) != 0) {
                strReceiverType = TAG_USER;
            }
            if (StringHelper.IsNullOrEmpty((String)(msgId = this.SendIMMessage(this.strIMServerUrl, jo, DEFAULT_SENDER, strReceiverType, strReceiver, strUserType, expiredtime, TAG_IMACTION)))) continue;
            IDEDataCtrl iMsgSendQueueHisDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("DE0085", DEFAULT_SENDER, null);
            if (iMsgSendQueueHisDataCtrl == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0085"));
                return;
            }
            MsgSendQueue msgSendQueue2 = new MsgSendQueue();
            msgSendQueue2.SetParamValue("MSGSENDQUEUEHISID", (Object)msg.getMSGSENDQUEUEID());
            msgSendQueue2.setUSERDATA3(msgId);
            CallResult callResult = iMsgSendQueueHisDataCtrl.Save(false, (BaseDataEntity)msgSendQueue2);
            if (!callResult.IsError()) continue;
            log.error((Object)("\u4fdd\u5b58IM\u6d88\u606fId\u5230\u6d88\u606f\u5386\u53f2\u9519\u8bef\uff0c" + callResult.getErrorInfo()));
        }
        this.msgList.clear();
        this.msgList.addAll(this.msgList2);
    }

    protected CallResult OnStop() {
        log.info((Object)StringHelper.Format((String)"Send IM Msg Stop"));
        if (this.sendMsgTimer != null) {
            this.sendMsgTimer.cancel();
            this.sendMsgTimer = null;
        }
        this.DoSendMsg();
        return super.OnStop();
    }

    public void cancelIMMessage(String strMsgId) {
    }

    public String SendIMMessage(String serverUrl, JSONObject contentJO, String sender, String receivertype, String receiver, String informtype, String expiredtime, String imAction) {
        String strIMMsgId;
        block15: {
            strIMMsgId = null;
            HttpClient client = null;
            PostMethod postMethod = null;
            try {
                try {
                    int statusCode;
                    client = new HttpClient();
                    postMethod = new PostMethod(serverUrl);
                    String strParamString = StringHelper.Format((String)"IMACTION=%6$s&SENDER=%1$s&RECEIVERTYPE=%2$s&RECEIVER=%3$s&INFORMTYPE=%4$s&EXPIREDTIME=%5$s", (Object)sender, (Object)receivertype, (Object)receiver, (Object)informtype, (Object)expiredtime, (Object)imAction);
                    postMethod.setQueryString(strParamString);
                    if (contentJO != null) {
                        postMethod.setRequestEntity((RequestEntity)new StringRequestEntity(contentJO.toString(), "text/xml", "UTF-8"));
                    }
                    if ((statusCode = client.executeMethod((HttpMethod)postMethod)) == 200) {
                        String response = postMethod.getResponseBodyAsString();
                        JSONObject result = JSONObject.fromString((String)response);
                        int nRetCode = 0;
                        String strErrorInfo = "";
                        if (result.has("retcode")) {
                            nRetCode = result.getInt("retcode");
                        }
                        if (result.has("retinfo")) {
                            strErrorInfo = result.getString("retinfo");
                        }
                        if (nRetCode == 0) {
                            strIMMsgId = this.toCallResult(result);
                        } else {
                            log.error((Object)("IM\u670d\u52a1\u5668\u5904\u7406\u6d88\u606f\u9519\u8bef\uff0c" + strErrorInfo));
                        }
                        break block15;
                    }
                    log.error((Object)StringHelper.Format((String)"\u53d1\u9001\u6d88\u606f\u5230IM\u670d\u52a1\u5668\u8bf7\u6c42\u9519\u8bef\uff0c\u9519\u8bef\u7801[%1$s],%2$s", (Object)statusCode));
                }
                catch (Exception e) {
                    log.error((Object)("\u53d1\u9001\u6d88\u606f\u5230IM\u670d\u52a1\u5668\u9519\u8bef," + e.getMessage()));
                    if (client != null) {
                        client = null;
                    }
                    if (postMethod != null) {
                        postMethod = null;
                    }
                }
            }
            finally {
                if (client != null) {
                    client = null;
                }
                if (postMethod != null) {
                    postMethod = null;
                }
            }
        }
        return strIMMsgId;
    }

    private String toCallResult(JSONObject result) {
        JSONObject jo;
        if (result.has("extinfo") && (jo = result.getJSONObject("extinfo")) != null && jo.has("USERINFORMID")) {
            return jo.getString("USERINFORMID");
        }
        return "";
    }
}

