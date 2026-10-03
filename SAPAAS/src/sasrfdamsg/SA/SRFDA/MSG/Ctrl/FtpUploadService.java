/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.BaseService
 *  SA.SRFDA.Ctrl.Data.FtpSendQueue
 *  SA.SRFDA.Ctrl.Data.FtpServer
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.apache.commons.net.ftp.FTPClient
 *  org.apache.commons.net.ftp.FTPReply
 */
package SA.SRFDA.MSG.Ctrl;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.BaseService;
import SA.SRFDA.Ctrl.Data.FtpSendQueue;
import SA.SRFDA.Ctrl.Data.FtpServer;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Hashtable;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FtpUploadService
extends BaseService {
    private static Log log = LogFactory.getLog(FtpUploadService.class);
    private Timer sendFtpTimer = null;
    protected String strQuerySQL = "select * from T_SRFFTPSENDQUEUE where PROCESSTIME IS NULL  AND (PLANSENDTIME IS NULL OR PLANSENDTIME<? ) ";
    int nSendTimer = 30000;
    protected boolean bSending = false;
    protected boolean bDebug = false;
    protected boolean bPlanSendTime = false;
    protected IDEDataCtrl iFtpSendQueueDataCtrl = null;
    protected IDEDataCtrl iFtpSendQueueHisDataCtrl = null;
    protected IDEDataCtrl iFtpServerDataCtrl = null;

    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        this.bPlanSendTime = true;
        String strQMHelperObject = this.iDAGlobalHelper.getWebExConfig().GetValue("SRFDA", "DAQUERYMODELHELPER", "");
        if (StringHelper.IsNullOrEmpty((String)strQMHelperObject)) {
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
        int nPageSize = Integer.parseInt(this.GetServiceParam("PAGESIZE", "10"));
        this.strQuerySQL = this.GetServiceParam("QUERYSQL", this.strQuerySQL);
        this.strQuerySQL = daQueryModelHelper.GetPagingSQL(this.strQuerySQL, 0, nPageSize, "CREATEDATE", "ASC", "", "");
        if (StringHelper.IsNullOrEmpty((String)this.strQuerySQL)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u6ca1\u6709\u6307\u5b9a\u672a\u4e0a\u4f20\u6587\u4ef6\u67e5\u8be2SQL");
        }
        this.iFtpSendQueueDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("DE0167", "SYSTEM", null);
        if (this.iFtpSendQueueDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0167"));
            return callResult;
        }
        this.iFtpSendQueueHisDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("DE0168", "SYSTEM", null);
        if (this.iFtpSendQueueDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0168"));
            return callResult;
        }
        this.iFtpServerDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("DE0148", "SYSTEM", null);
        if (this.iFtpServerDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0148"));
            return callResult;
        }
        return callResult;
    }

    protected CallResult OnStart() {
        CallResult callResult = super.OnStart();
        if (callResult.IsError()) {
            return callResult;
        }
        if (this.sendFtpTimer == null) {
            this.sendFtpTimer = new Timer("FTPSENDQUEUE");
            this.sendFtpTimer.schedule((TimerTask)((Object)this), this.nSendTimer, (long)this.nSendTimer);
        }
        log.info((Object)StringHelper.Format((String)"FTP Upload Start"));
        return callResult;
    }

    protected CallResult OnStop() {
        log.info((Object)StringHelper.Format((String)"FTP Upload Stop"));
        if (this.sendFtpTimer != null) {
            this.sendFtpTimer.cancel();
            this.sendFtpTimer = null;
        }
        return super.OnStop();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void run() {
        FtpUploadService ftpUploadService = this;
        synchronized (ftpUploadService) {
            if (this.bSending) {
                return;
            }
            this.bSending = true;
        }
        this.InternalSend();
        ftpUploadService = this;
        synchronized (ftpUploadService) {
            this.bSending = false;
        }
    }

    protected void InternalSend() {
        CallResult callResult;
        Vector<FtpSendQueue> ftpSendQueueList = new Vector();
        CallParamList callParamList = new CallParamList();
        if (this.bPlanSendTime) {
            Date date = new Date();
            Timestamp sendTime = new Timestamp(date.getTime() + 30000L);
            callParamList.AddDateTime((Object)sendTime);
        }
        if ((callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.strQuerySQL, (Vector)callParamList.GetList(), ftpSendQueueList, (String)FtpSendQueue.class.getName())).IsError()) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u672a\u53d1\u9001\u90ae\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return;
        }
        if (ftpSendQueueList.size() == 0) {
            return;
        }
        Hashtable<String, FtpServer> ftpServerMap = new Hashtable<String, FtpServer>();
        for (FtpSendQueue ftpSendQueue : ftpSendQueueList) {
            ftpSendQueue.SetParamValue("PROCESSTIME", (Object)DateParser.GetTimestampValue((Object)new Date()));
            FtpServer ftpServer = null;
            if (ftpServerMap.containsKey(ftpSendQueue.getFTPSERVERID())) {
                ftpServer = (FtpServer)ftpServerMap.get(ftpSendQueue.getFTPSERVERID());
            } else {
                ftpServer = new FtpServer();
                ftpServer.setFTPSERVERID(ftpSendQueue.getFTPSERVERID());
                callResult = this.iFtpServerDataCtrl.Get((BaseDataEntity)ftpServer);
                if (callResult.IsError()) {
                    ftpSendQueue.setISERROR(true);
                    ftpSendQueue.setERRORINFO(StringHelper.Format((String)"\u83b7\u53d6FTPServer\u4fe1\u606f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    this.iFtpSendQueueDataCtrl.Save(false, (BaseDataEntity)ftpSendQueue);
                    continue;
                }
                ftpServerMap.put(ftpSendQueue.getFTPSERVERID(), ftpServer);
            }
            FTPClient ftpClient = new FTPClient();
            ftpClient.setControlEncoding("GBK");
            try {
                String strRemoteFolder;
                if (ftpServer.getSERVERPORT() > 0) {
                    ftpClient.connect(ftpServer.getSERVERPATH(), ftpServer.getSERVERPORT());
                } else {
                    ftpClient.connect(ftpServer.getSERVERPATH());
                }
                int reply = ftpClient.getReplyCode();
                if (!FTPReply.isPositiveCompletion((int)reply)) {
                    ftpClient.disconnect();
                    ftpSendQueue.setISERROR(true);
                    ftpSendQueue.setERRORINFO(StringHelper.Format((String)"\u8fde\u63a5\u670d\u52a1\u5668\u53d1\u751f\u9519\u8bef"));
                    this.iFtpSendQueueDataCtrl.Save(false, (BaseDataEntity)ftpSendQueue);
                    continue;
                }
                if (!ftpClient.login(ftpServer.getFTPUSER(), ftpServer.getFTPPWD())) {
                    ftpClient.disconnect();
                    ftpSendQueue.setISERROR(true);
                    ftpSendQueue.setERRORINFO(StringHelper.Format((String)"\u767b\u5f55\u670d\u52a1\u5668\u53d1\u751f\u9519\u8bef"));
                    this.iFtpSendQueueDataCtrl.Save(false, (BaseDataEntity)ftpSendQueue);
                    continue;
                }
                ftpClient.setFileType(2);
                if (ftpServer.getLOCALPASSIVE()) {
                    ftpClient.enterLocalPassiveMode();
                } else {
                    ftpClient.enterLocalActiveMode();
                }
                ftpClient.setUseEPSVwithIPv4(ftpServer.getEPSVWITHIP4());
                FileInputStream input = new FileInputStream(ftpSendQueue.getLOCALFILE());
                String strRemoteFile = ftpServer.getINITPATH();
                if (!StringHelper.IsNullOrEmpty((String)strRemoteFile)) {
                    if (strRemoteFile.charAt(strRemoteFile.length() - 1) != '/') {
                        strRemoteFile = String.valueOf(strRemoteFile) + "/";
                    }
                } else {
                    strRemoteFile = String.valueOf(strRemoteFile) + "/";
                }
                if (!StringHelper.IsNullOrEmpty((String)(strRemoteFolder = ftpSendQueue.getREMOTEFOLDER())) && strRemoteFolder.charAt(0) == '/') {
                    strRemoteFolder = strRemoteFolder.substring(1);
                }
                if ((strRemoteFile = String.valueOf(strRemoteFile) + strRemoteFolder).charAt(strRemoteFile.length() - 1) != '/') {
                    strRemoteFile = String.valueOf(strRemoteFile) + "/";
                }
                ftpClient.makeDirectory(strRemoteFile);
                reply = ftpClient.cwd(strRemoteFile);
                if (!FTPReply.isPositiveCompletion((int)reply)) {
                    ftpClient.disconnect();
                    ftpSendQueue.setISERROR(true);
                    ftpSendQueue.setERRORINFO(StringHelper.Format((String)"\u6539\u53d8\u5de5\u4f5c\u76ee\u5f55\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)this.GetFtpError(ftpClient)));
                    this.iFtpSendQueueDataCtrl.Save(false, (BaseDataEntity)ftpSendQueue);
                    continue;
                }
                if (!ftpClient.storeFile(ftpSendQueue.getREMOTEFILE(), (InputStream)input)) {
                    ftpClient.disconnect();
                    ((InputStream)input).close();
                    ftpSendQueue.setISERROR(true);
                    ftpSendQueue.setERRORINFO(StringHelper.Format((String)"\u4e0a\u4f20\u6587\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)this.GetFtpError(ftpClient)));
                    this.iFtpSendQueueDataCtrl.Save(false, (BaseDataEntity)ftpSendQueue);
                    continue;
                }
                ((InputStream)input).close();
                FtpSendQueue ftpSendQueue2 = new FtpSendQueue();
                ftpSendQueue.setISSEND(true);
                ftpSendQueue.CopyTo((BaseDataEntity)ftpSendQueue2, true);
                ftpSendQueue2.SetParamValue("FTPSENDQUEUEHISID", (Object)ftpSendQueue.getFTPSENDQUEUEID());
                ftpSendQueue2.SetParamValue("FTPSENDQUEUEHISNAME", (Object)ftpSendQueue.getFTPSENDQUEUENAME());
                callResult = this.iFtpSendQueueHisDataCtrl.Save(true, (BaseDataEntity)ftpSendQueue2);
                if (callResult.IsError()) {
                    throw new Exception(StringHelper.Format((String)"\u5c06\u53d1\u9001\u6570\u636e\u653e\u5165\u53d1\u9001\u5386\u53f2\u8bb0\u5f55\u961f\u5217\u4e2d\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                this.iFtpSendQueueDataCtrl.Remove((BaseDataEntity)ftpSendQueue);
                ftpClient.disconnect();
            }
            catch (Exception ex) {
                log.error((Object)ex);
                try {
                    ftpClient.disconnect();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                ftpSendQueue.setISERROR(true);
                ftpSendQueue.setERRORINFO(StringHelper.Format((String)"\u4e0a\u4f20\u6587\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)ex.getMessage()));
                this.iFtpSendQueueDataCtrl.Save(false, (BaseDataEntity)ftpSendQueue);
            }
        }
    }

    protected String GetFtpError(FTPClient ftpClient) {
        String strError = "";
        if (ftpClient.getReplyString() != null) {
            strError = String.valueOf(strError) + ftpClient.getReplyString();
        }
        if (ftpClient.getReplyStrings() != null) {
            int i = 0;
            while (i < ftpClient.getReplyStrings().length) {
                if (!StringHelper.IsNullOrEmpty((String)strError)) {
                    strError = String.valueOf(strError) + ".";
                }
                strError = String.valueOf(strError) + ftpClient.getReplyStrings()[i];
                ++i;
            }
        }
        return strError;
    }
}

