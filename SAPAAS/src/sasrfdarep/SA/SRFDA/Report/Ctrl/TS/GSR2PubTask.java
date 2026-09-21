/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.FtpSendQueue
 *  SA.SRFDA.Ctrl.Data.GSR2Pub
 *  SA.SRFDA.Ctrl.Data.PubFtp
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.TS.Ctrl.BaseScheduleEngineTask
 *  SA.SRFDA.TS.Ctrl.Data.TSSDTask
 *  SA.SRFDA.TS.Ctrl.Data.TSSDTaskType
 *  SA.SRFDA.TS.Ctrl.IScheduleEngineContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.httpclient.DefaultHttpMethodRetryHandler
 *  org.apache.commons.httpclient.HttpClient
 *  org.apache.commons.httpclient.HttpException
 *  org.apache.commons.httpclient.HttpMethod
 *  org.apache.commons.httpclient.NameValuePair
 *  org.apache.commons.httpclient.methods.GetMethod
 *  org.apache.commons.httpclient.methods.PostMethod
 */
package SA.SRFDA.Report.Ctrl.TS;

import SA.SRFDA.Ctrl.Data.FtpSendQueue;
import SA.SRFDA.Ctrl.Data.GSR2Pub;
import SA.SRFDA.Ctrl.Data.PubFtp;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.TS.Ctrl.BaseScheduleEngineTask;
import SA.SRFDA.TS.Ctrl.Data.TSSDTask;
import SA.SRFDA.TS.Ctrl.Data.TSSDTaskType;
import SA.SRFDA.TS.Ctrl.IScheduleEngineContext;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;
import java.util.Vector;
import net.sf.json.JSONObject;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

public class GSR2PubTask
extends BaseScheduleEngineTask {
    protected String strServerUrl = "http://lionlau-w500:8000/SAEAM/";
    protected String strLoginUrl = "uacclient/uacremotelogin.jsp";
    protected String strFetchUrlFmt = "srfpage/gridviewbackend.jsp?SRFGRIDVIEW=DG_DE0001_001&SRFDEID=DE0001&SRFPAGEID=PAGE_DE0001_G001&";
    protected String strPostDataFmt = "start=0&limit=40&sort=deid&dir=ASC&realsort=&gridid=M1b&action=SRFDAEXPORT&actiontype=gridaction";

    public void Init(IScheduleEngineContext iScheduleEngineContext, TSSDTaskType taskType) {
        super.Init(iScheduleEngineContext, taskType);
        this.strServerUrl = PropertiesHelper.GetProperty((Properties)taskType.getTaskTypeParam(), (String)"SERVER", (String)this.strServerUrl);
        this.strLoginUrl = PropertiesHelper.GetProperty((Properties)taskType.getTaskTypeParam(), (String)"LOGINURL", (String)this.strLoginUrl);
        this.strFetchUrlFmt = PropertiesHelper.GetProperty((Properties)taskType.getTaskTypeParam(), (String)"FETCHURLFMT", (String)this.strFetchUrlFmt);
        this.strPostDataFmt = PropertiesHelper.GetProperty((Properties)taskType.getTaskTypeParam(), (String)"POSTDATAFMT", (String)this.strPostDataFmt);
    }

    protected void FillParamListStartTimeAndEndTime(GSR2Pub gsr2Pub, Object[] paramList) {
        String strTD = gsr2Pub.getTD();
        Date date = new Date();
        paramList[3] = date;
        paramList[4] = date;
    }

    public CallResult Execute(TSSDTask task) {
        CallResult callResult = new CallResult();
        try {
            String strGSR2PubId = PropertiesHelper.GetProperty((Properties)task.getTaskParam(), (String)"GSR2PUBID");
            if (StringHelper.IsNullOrEmpty((String)strGSR2PubId)) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9aGSR2\u62a5\u8868\u53d1\u5e03\u7f16\u53f7"));
                return callResult;
            }
            IDEDataCtrl gsr2PubDataCtrl = this.iScheduleEngineContext.getDAGlobalHelper().getDAModelStorage().FindDEDataCtrl("DE0506", "SYSTEM", null);
            if (gsr2PubDataCtrl == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0506"));
                return callResult;
            }
            GSR2Pub gsr2Pub = new GSR2Pub();
            gsr2Pub.setGSR2PUBID(strGSR2PubId);
            callResult = gsr2PubDataCtrl.Get((BaseDataEntity)gsr2Pub);
            if (callResult.IsError()) {
                return callResult;
            }
            Date date = new Date();
            Object[] paramList = new Object[]{gsr2Pub.getGSR2ID(), gsr2Pub.getGSR2SUMTABLEID(), gsr2Pub.getGSR2DIMENSIONID(), date, date};
            this.FillParamListStartTimeAndEndTime(gsr2Pub, paramList);
            String strFullLoginUrl = StringHelper.Format((String)"%1$s%2$s", (Object)this.strServerUrl, (Object)this.strLoginUrl);
            HttpClient httpClient = new HttpClient();
            GetMethod getMethod = new GetMethod(strFullLoginUrl);
            int statusCode = httpClient.executeMethod((HttpMethod)getMethod);
            if (statusCode != 200) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u6267\u884c\u8fdc\u7a0b\u767b\u5f55\u5931\u8d25\uff0c\u8fd4\u56de[%1$s]", (Object)statusCode));
                return callResult;
            }
            getMethod.releaseConnection();
            String strPostData = StringHelper.Format((String)this.strPostDataFmt, (Object[])paramList);
            Vector<NameValuePair> postList = new Vector<NameValuePair>();
            String[] strLists = strPostData.split("&");
            int i = 0;
            while (i < strLists.length) {
                String[] set = strLists[i].split("=");
                if (set.length == 2) {
                    try {
                        String strValue = set[1];
                        postList.add(new NameValuePair(set[0].toLowerCase(), strValue));
                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                ++i;
            }
            NameValuePair[] arr = null;
            if (postList.size() > 0) {
                arr = new NameValuePair[postList.size()];
                arr = postList.toArray(arr);
            }
            String strFetchUrl = StringHelper.Format((String)this.strFetchUrlFmt, (Object[])paramList);
            String strPostUrl = StringHelper.Format((String)"%1$s%2$s", (Object)this.strServerUrl, (Object)strFetchUrl);
            PostMethod postMethod = new PostMethod(strPostUrl);
            postMethod.setRequestBody(arr);
            statusCode = httpClient.executeMethod((HttpMethod)postMethod);
            if (statusCode != 200) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u8bf7\u6c42\u4e0b\u8f7d\u6587\u4ef6\u8def\u5f84\u5931\u8d25\uff0c\u8fd4\u56de[%1$s]", (Object)statusCode));
                return callResult;
            }
            String strContent = postMethod.getResponseBodyAsString();
            if (StringHelper.IsNullOrEmpty((String)strContent)) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u8bf7\u6c42\u4e0b\u8f7d\u6587\u4ef6\u8def\u5f84\u8fd4\u56de\u7a7a\u5185\u5bb9"));
                return callResult;
            }
            postMethod.releaseConnection();
            String strDownloadUrl = "";
            try {
                JSONObject jo = JSONObject.fromString((String)strContent);
                String strCode = jo.getString("code");
                String strPreFix = "SRFUtility.root().location='../";
                int nPos = strCode.indexOf(strPreFix);
                if (nPos == -1) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u8bf7\u6c42\u4e0b\u8f7d\u6587\u4ef6\u8def\u5f84\u8fd4\u56de\u5185\u5bb9\u6709\u8bef"));
                    return callResult;
                }
                if ((nPos = (strCode = strCode.substring(nPos + strPreFix.length())).indexOf("'")) == -1) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u8bf7\u6c42\u4e0b\u8f7d\u6587\u4ef6\u8def\u5f84\u8fd4\u56de\u5185\u5bb9\u6709\u8bef"));
                    return callResult;
                }
                strDownloadUrl = strCode.substring(0, nPos);
            }
            catch (Exception ex) {
                ex.printStackTrace();
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u8bf7\u6c42\u4e0b\u8f7d\u6587\u4ef6\u8def\u5f84\u8fd4\u56de\u5185\u5bb9\u6709\u8bef"));
                return callResult;
            }
            strDownloadUrl = String.valueOf(this.strServerUrl) + strDownloadUrl;
            getMethod = new GetMethod(strDownloadUrl);
            getMethod.getParams().setParameter("http.method.retry-handler", (Object)new DefaultHttpMethodRetryHandler());
            statusCode = httpClient.executeMethod((HttpMethod)getMethod);
            if (statusCode != 200) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u4e0b\u8f7d\u6587\u4ef6\u5931\u8d25\uff0c\u8fd4\u56de[%1$s]", (Object)statusCode));
                return callResult;
            }
            byte[] responseBody = getMethod.getResponseBody();
            String strFileFolder = this.iScheduleEngineContext.getDAGlobalHelper().GetTempPath();
            strFileFolder = String.valueOf(strFileFolder) + StringHelper.Format((String)"%1$tY-%1$tm-%1$td", (Object)new Date());
            strFileFolder = String.valueOf(strFileFolder) + File.separator;
            strFileFolder = String.valueOf(strFileFolder) + Helper.GenGuid();
            strFileFolder = String.valueOf(strFileFolder) + File.separator;
            File dir = new File(strFileFolder);
            dir.mkdirs();
            String strRemoteFileName = String.valueOf(Helper.GenGuid()) + ".xls";
            if (!StringHelper.IsNullOrEmpty((String)gsr2Pub.getFILENAME())) {
                strRemoteFileName = StringHelper.Format((String)gsr2Pub.getFILENAME(), (Object)paramList[3]);
            }
            String strLocalFile = String.valueOf(strFileFolder) + strRemoteFileName;
            FileOutputStream serverout = new FileOutputStream(strLocalFile);
            ((OutputStream)serverout).write(responseBody);
            serverout.flush();
            ((OutputStream)serverout).close();
            getMethod.releaseConnection();
            callResult = paramList[3] != null && paramList[3] instanceof Date ? this.Publish(gsr2Pub.getPUBGROUPID(), strRemoteFileName, strLocalFile, (Date)paramList[3]) : this.Publish(gsr2Pub.getPUBGROUPID(), strRemoteFileName, strLocalFile, date);
        }
        catch (HttpException e) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5904\u7406\u53d1\u751f\u5f02\u5e38:%1$s", (Object)e.getMessage()));
            e.printStackTrace();
        }
        catch (IOException e) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5904\u7406\u53d1\u751f\u5f02\u5e38:%1$s", (Object)e.getMessage()));
            e.printStackTrace();
        }
        return callResult;
    }

    protected CallResult Publish(String strPublishGroupId, String strRemoteFileName, String strLocalFile, Date date) {
        CallResult callResult = new CallResult();
        IDEDataCtrl pubFtpDataCtrl = this.iScheduleEngineContext.getDAGlobalHelper().getDAModelStorage().FindDEDataCtrl("DE0176", "SYSTEM", null);
        if (pubFtpDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0176"));
            return callResult;
        }
        IDEDataCtrl ftpSendQueueDataCtrl = this.iScheduleEngineContext.getDAGlobalHelper().getDAModelStorage().FindDEDataCtrl("DE0167", "SYSTEM", null);
        if (ftpSendQueueDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0167"));
            return callResult;
        }
        BaseDataEntity cond = new BaseDataEntity();
        cond.SetParamValue("PUBGROUPID", (Object)strPublishGroupId);
        Vector pubFtpList = new Vector();
        callResult = pubFtpDataCtrl.Select(cond, pubFtpList);
        if (callResult.IsError()) {
            return callResult;
        }
        PubFtp pubFtp = new PubFtp();
        for (BaseDataEntity baseDataEntity : pubFtpList) {
            pubFtp.Proxy(baseDataEntity);
            FtpSendQueue ftpSendQueue = new FtpSendQueue();
            ftpSendQueue.setFTPSERVERID(pubFtp.getFTPSERVERID());
            ftpSendQueue.setREMOTEFOLDER(StringHelper.Format((String)pubFtp.getFTPFOLDER(), (Object)date));
            ftpSendQueue.setLOCALFILE(strLocalFile);
            ftpSendQueue.setREMOTEFILE(strRemoteFileName);
            callResult = ftpSendQueueDataCtrl.Save(true, (BaseDataEntity)ftpSendQueue);
            if (!callResult.IsError()) continue;
            return callResult;
        }
        return new CallResult();
    }
}

