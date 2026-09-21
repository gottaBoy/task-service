/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.jcraft.jsch.Channel
 *  com.jcraft.jsch.ChannelSftp
 *  com.jcraft.jsch.JSch
 *  com.jcraft.jsch.JSchException
 *  com.jcraft.jsch.Session
 *  com.trilead.ssh2.Connection
 *  com.trilead.ssh2.SCPClient
 *  com.trilead.ssh2.Session
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDCDBInstBK
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSAppServer
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInst
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSDBServer
 */
package SA.SRFDA.PS.Core.Database.Util;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.trilead.ssh2.Connection;
import com.trilead.ssh2.SCPClient;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDBInstBK;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSAppServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBServer;

public class MySQLHelper {
    public static final String SUCCESS = "SUCCESS";
    private static Session session = null;
    private static Channel channel = null;

    public static void restoreDBInst(String strFullBKFilePath, PSDevCenterDBInst psDCDBInst, PSDCDBInstBK dbBackupData, PSDBDevInst psDBDevInst, PSDBServer psDBServer, PSAppServer psAppServer) throws Exception {
        String strCmd = null;
        String ip = null;
        int port = 22;
        String username = null;
        String pwd = null;
        String transType = "SFTP";
        if (psAppServer != null) {
            ip = psAppServer.getSSHIPAddr();
            port = DataObject.getIntegerValue((Object)psAppServer.getSSHPort(), (Integer)port);
            username = psAppServer.getAdminUserName();
            pwd = psAppServer.getAdminPasswd();
            transType = psAppServer.getUploadFileMode();
        } else {
            ip = psDBServer.getIPAddr();
        }
        String dbusername = psDCDBInst.getPSDBDevInst().getUserName();
        String dbpwd = psDCDBInst.getPSDBDevInst().getPasswd();
        String dbname = psDCDBInst.getPSDBDevInst().getDBName();
        File bkFile = new File(strFullBKFilePath);
        String remoFilePath = String.format("/home/%1$s/%2$s", username, bkFile.getName());
        if (transType.equalsIgnoreCase("SFTP")) {
            MySQLHelper.putFileToRemoteBySFTP(ip, port, username, pwd, strFullBKFilePath, remoFilePath);
        } else {
            MySQLHelper.putFileToRemote(ip, port, username, pwd, strFullBKFilePath, remoFilePath);
        }
        strCmd = String.format("mysql -u%1$s -p'%2$s' -f %3$s < %4$s", dbusername, dbpwd, dbname, remoFilePath);
        MySQLHelper.runRemoteScriptError(ip, port, username, pwd, strCmd);
    }

    public static void backupDBInst(String strFullBKFilePath, PSDevCenterDBInst psDCDBInst, PSDCDBInstBK dbBackupData, PSDBDevInst psDBDevInst, PSDBServer psDBServer, PSAppServer psAppServer) throws Exception {
        String strCmd = null;
        String ip = null;
        int port = 22;
        String username = null;
        String pwd = null;
        String transType = "SFTP";
        if (psAppServer != null) {
            ip = psAppServer.getSSHIPAddr();
            port = DataObject.getIntegerValue((Object)psAppServer.getSSHPort(), (Integer)port);
            username = psAppServer.getAdminUserName();
            pwd = psAppServer.getAdminPasswd();
            transType = psAppServer.getUploadFileMode();
        } else {
            ip = psDBServer.getIPAddr();
        }
        String dbusername = psDCDBInst.getPSDBDevInst().getUserName();
        String dbpwd = psDCDBInst.getPSDBDevInst().getPasswd();
        String dbname = psDCDBInst.getPSDBDevInst().getDBName();
        File bkFile = new File(strFullBKFilePath);
        String remoFilePath = String.format("/home/%1$s/%2$s", username, bkFile.getName());
        strCmd = String.format("mysqldump -u%1$s -p'%2$s' %3$s >%4$s", dbusername, dbpwd, dbname, remoFilePath);
        MySQLHelper.runRemoteScriptError(ip, port, username, pwd, strCmd);
        if (transType.equalsIgnoreCase("SFTP")) {
            MySQLHelper.getFileFromRemoteBySFTP(ip, port, username, pwd, remoFilePath, strFullBKFilePath);
        } else {
            MySQLHelper.getFileFromRemote(ip, port, username, pwd, remoFilePath, strFullBKFilePath);
        }
    }

    public static String getFileFromRemote(String host, int nPort, String username, String password, String romoteFileName, String localDir) throws Exception {
        String msg = SUCCESS;
        Connection conn = new Connection(host, nPort);
        conn.connect();
        boolean isAuthenticated = conn.authenticateWithPassword(username, password);
        if (!isAuthenticated) {
            throw new Exception("\u6743\u9650\u4e0d\u591f!");
        }
        File inputFile = new File(localDir);
        if (!inputFile.exists()) {
            inputFile.mkdirs();
        }
        SCPClient scpClient = conn.createSCPClient();
        scpClient.get(romoteFileName, localDir);
        conn.close();
        return msg;
    }

    public static String putFileToRemote(String host, int nPort, String username, String password, String localFileName, String remoteDir) throws Exception {
        String msg = SUCCESS;
        Connection conn = new Connection(host, nPort);
        conn.connect();
        boolean isAuthenticated = conn.authenticateWithPassword(username, password);
        if (!isAuthenticated) {
            throw new Exception("\u6743\u9650\u4e0d\u591f!");
        }
        SCPClient scpClient = conn.createSCPClient();
        scpClient.put(localFileName, remoteDir);
        conn.close();
        return msg;
    }

    public static List<String> runRemoteScriptError(String host, int nPort, String username, String password, String cmd) throws Exception {
        Connection conn = new Connection(host, nPort);
        conn.connect();
        boolean isAuthenticated = conn.authenticateWithPassword(username, password);
        if (!isAuthenticated) {
            throw new Exception("\u6743\u9650\u4e0d\u591f");
        }
        com.trilead.ssh2.Session sess = conn.openSession();
        sess.execCommand(cmd);
        List<String> result = MySQLHelper.readStream(sess);
        sess.close();
        conn.close();
        return result;
    }

    public static List<String> readStream(com.trilead.ssh2.Session session) {
        ArrayList<String> result = new ArrayList<String>();
        final InputStream is1 = session.getStdout();
        final InputStream is2 = session.getStderr();
        Thread th2 = new Thread(){

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void run() {
                BufferedReader br2 = new BufferedReader(new InputStreamReader(is2));
                String line2 = null;
                try {
                    try {
                        while (br2 != null) {
                            line2 = br2.readLine();
                            if (line2 == null) {
                                return;
                            }
                            System.out.println(line2);
                        }
                        return;
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                        if (br2 != null) {
                            try {
                                br2.close();
                            }
                            catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (is2 == null) return;
                        try {
                            is2.close();
                            return;
                        }
                        catch (IOException e3) {
                            e3.printStackTrace();
                            return;
                        }
                    }
                }
                finally {
                    if (br2 != null) {
                        try {
                            br2.close();
                        }
                        catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (is2 != null) {
                        try {
                            is2.close();
                        }
                        catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        Thread th1 = new Thread(){

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void run() {
                BufferedReader br1 = new BufferedReader(new InputStreamReader(is1));
                try {
                    try {
                        String line1 = null;
                        while (br1 != null) {
                            line1 = br1.readLine();
                            if (line1 == null) {
                                return;
                            }
                            System.out.println(line1);
                        }
                        return;
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                        try {
                            if (br1 != null) {
                                br1.close();
                            }
                            if (is1 == null) return;
                            is1.close();
                            return;
                        }
                        catch (IOException e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                }
                finally {
                    try {
                        if (br1 != null) {
                            br1.close();
                        }
                        if (is1 != null) {
                            is1.close();
                        }
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        th2.start();
        th1.start();
        while (th1.isAlive()) {
            try {
                Thread.sleep(1000L);
                if (th1.isAlive()) continue;
                break;
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static String getFileFromRemoteBySFTP(String host, int nPort, String username, String password, String romoteFileName, String localDir) throws Exception {
        String msg = SUCCESS;
        ChannelSftp chSftp = MySQLHelper.getChannel(host, nPort, username, password, 60000);
        chSftp.get(romoteFileName, localDir);
        chSftp.quit();
        MySQLHelper.closeChannel();
        return msg;
    }

    public static String putFileToRemoteBySFTP(String host, int nPort, String username, String password, String localFileName, String remoteDir) throws Exception {
        String msg = SUCCESS;
        ChannelSftp chSftp = MySQLHelper.getChannel(host, nPort, username, password, 60000);
        chSftp.put(localFileName, remoteDir, 0);
        chSftp.quit();
        MySQLHelper.closeChannel();
        return msg;
    }

    private static ChannelSftp getChannel(String host, int nPort, String username, String password, int timeout) throws JSchException {
        JSch jsch = new JSch();
        session = jsch.getSession(username, host, nPort);
        if (password != null) {
            session.setPassword(password);
        }
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.setTimeout(timeout);
        session.connect();
        channel = session.openChannel("sftp");
        channel.connect();
        return (ChannelSftp)channel;
    }

    private static void closeChannel() throws Exception {
        if (channel != null) {
            channel.disconnect();
        }
        if (session != null) {
            session.disconnect();
        }
    }
}

