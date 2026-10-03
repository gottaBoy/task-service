package SA.SRFDA.EAI.Endpoint;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.EAI.Ctrl.Data.EAIAppInt;
import SA.SRFDA.EAI.Ctrl.Data.EAIFtpSendQueue;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.mule.api.MuleEventContext;

public class FtpPutProcess extends DEPrepareProcess {
    protected IDEDataCtrl iEAIFtpSendQueueDataCtrl;
    protected EAIAppInt eaiAppInt;

    public void setEAIFtpSendQueueDataCtrl(IDEDataCtrl ctrl) {
        this.iEAIFtpSendQueueDataCtrl = ctrl;
    }

    public void setEaiAppInt(EAIAppInt appInt) {
        this.eaiAppInt = appInt;
    }

    @Override
    public Object onCall(MuleEventContext event) throws Exception {
        Object payload = super.onCall(event);
        EAIFtpSendQueue queue = new EAIFtpSendQueue();
        GetDataEntity(payload).CopyTo(queue, true);
        if (eaiAppInt == null || eaiAppInt.getHOSTNAME().length() == 0
                || queue.getLOCALPATH().length() == 0
                || queue.getREMOTEFILENAME().length() == 0) {
            throw new IllegalArgumentException("FTP connection, LOCALPATH and REMOTEFILENAME are required");
        }
        FTPClient ftp = new FTPClient();
        boolean loggedIn = false;
        Exception failure = null;
        try {
            ftp.connect(eaiAppInt.getHOSTNAME(), eaiAppInt.getPORT(21));
            if (!ftp.login(eaiAppInt.getUSERNAME(), eaiAppInt.getPWD())) {
                throw new IllegalStateException("FTP login failed: " + ftp.getReplyString());
            }
            loggedIn = true;
            if (queue.getISPASSIVE()) {
                ftp.enterLocalPassiveMode();
            }
            if (!ftp.setFileType(queue.getISBINARY() ? FTP.BINARY_FILE_TYPE : FTP.ASCII_FILE_TYPE)) {
                throw new IllegalStateException("FTP file type rejected: " + ftp.getReplyString());
            }
            if (queue.getFTPPATH().length() != 0 && !ftp.changeWorkingDirectory(queue.getFTPPATH())) {
                throw new IllegalStateException("FTP path rejected: " + queue.getFTPPATH());
            }
            InputStream input = new FileInputStream(new File(queue.getLOCALPATH()));
            try {
                if (!ftp.storeFile(queue.getREMOTEFILENAME(), input)) {
                    throw new IllegalStateException("FTP upload failed: " + ftp.getReplyString());
                }
            } finally {
                input.close();
            }
            queue.setISERROR(false);
            queue.setFINISHTIME(new Date());
        } catch (Exception ex) {
            failure = ex;
            queue.setISERROR(true);
            if (iEAIFtpSendQueueDataCtrl != null) {
                try {
                    EndpointRuntime.check(iEAIFtpSendQueueDataCtrl.Save(false, queue));
                } catch (Exception persistenceError) {
                    ex.addSuppressed(persistenceError);
                }
            }
            throw ex;
        } finally {
            if (ftp.isConnected()) {
                IOException cleanupError = null;
                if (loggedIn) {
                    try {
                        ftp.logout();
                    } catch (IOException ex) {
                        cleanupError = ex;
                    }
                }
                try {
                    ftp.disconnect();
                } catch (IOException ex) {
                    if (cleanupError == null) {
                        cleanupError = ex;
                    } else {
                        cleanupError.addSuppressed(ex);
                    }
                }
                if (cleanupError != null) {
                    if (failure != null) {
                        failure.addSuppressed(cleanupError);
                    } else {
                        throw cleanupError;
                    }
                }
            }
        }
        if (iEAIFtpSendQueueDataCtrl != null) {
            EndpointRuntime.check(iEAIFtpSendQueueDataCtrl.Save(false, queue));
        }
        if (bReturnPayloadAsMap) {
            java.util.Map result = new java.util.HashMap();
            queue.FillMap(result);
            return result;
        }
        return queue;
    }
}
