/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  com.jcraft.jsch.Channel
 *  com.jcraft.jsch.ChannelSftp
 *  com.jcraft.jsch.JSch
 *  com.jcraft.jsch.Session
 *  com.trilead.ssh2.Connection
 *  com.trilead.ssh2.SCPClient
 *  com.trilead.ssh2.Session
 *  com.trilead.ssh2.StreamGobbler
 */
package SA.SRFDA.PS.Core.Util;

import SA.SRFramework.UtilityEx.StringBuilderEx;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.trilead.ssh2.Connection;
import com.trilead.ssh2.SCPClient;
import com.trilead.ssh2.Session;
import com.trilead.ssh2.StreamGobbler;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SSHCmd {
    public static final String SUCCESS = "SUCCESS";

    public static List<String> runRemoteScript(String host, int nPort, String username, String password, String cmd) throws Exception {
        String line;
        ArrayList<String> result = new ArrayList<String>();
        Connection conn = new Connection(host, nPort);
        conn.connect();
        boolean isAuthenticated = conn.authenticateWithPassword(username, password);
        if (!isAuthenticated) {
            throw new Exception("\u6743\u9650\u4e0d\u591f");
        }
        Session sess = conn.openSession();
        sess.execCommand(cmd);
        StreamGobbler stdout = new StreamGobbler(sess.getStdout());
        BufferedReader br = new BufferedReader(new InputStreamReader((InputStream)stdout));
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            result.add(line);
        }
        sess.close();
        conn.close();
        return result;
    }

    public static String runRemoteScript2(String host, int nPort, String username, String password, String cmd) throws Exception {
        List<String> result = SSHCmd.runRemoteScript(host, nPort, username, password, cmd);
        StringBuilderEx sb = new StringBuilderEx();
        for (String row : result) {
            sb.Append(row);
            sb.Append("\r\n");
        }
        return sb.toString();
    }

    public static String getFileFromRemote(String host, int nPort, String username, String password, String strRemoteFileName, String localDir) throws Exception {
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
        scpClient.get(strRemoteFileName, localDir);
        conn.close();
        return msg;
    }

    public static String getFileFromRemoteBySFTP(String host, int nPort, String username, String password, String strRemoteFileName, String localDir) throws Exception {
        String msg = SUCCESS;
        com.jcraft.jsch.Session session = null;
        Channel channel = null;
        try {
            JSch jsch = new JSch();
            session = jsch.getSession(username, host, nPort);
            if (password != null) {
                session.setPassword(password);
            }
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.setTimeout(60000);
            session.connect();
            channel = session.openChannel("sftp");
            ChannelSftp chSftp = (ChannelSftp)channel;
            chSftp.get(strRemoteFileName, localDir);
            chSftp.quit();
            if (channel != null) {
                channel.disconnect();
            }
            if (session != null) {
                session.disconnect();
            }
        }
        catch (Exception e) {
            if (channel != null) {
                channel.disconnect();
            }
            if (session != null) {
                session.disconnect();
            }
            throw e;
        }
        return msg;
    }

    public static String putFileToRemote(String host, int nPort, String username, String password, String strLocalFileName, String remoteDir) throws Exception {
        String msg = SUCCESS;
        Connection conn = new Connection(host, nPort);
        conn.connect();
        boolean isAuthenticated = conn.authenticateWithPassword(username, password);
        if (!isAuthenticated) {
            throw new Exception("\u6743\u9650\u4e0d\u591f!");
        }
        SCPClient scpClient = conn.createSCPClient();
        scpClient.put(strLocalFileName, remoteDir);
        conn.close();
        return msg;
    }

    public static String putFileToRemoteBySFTP(String host, int nPort, String username, String password, String strLocalFileName, String remoteDir) throws Exception {
        String msg = SUCCESS;
        com.jcraft.jsch.Session session = null;
        Channel channel = null;
        try {
            JSch jsch = new JSch();
            session = jsch.getSession(username, host, nPort);
            if (password != null) {
                session.setPassword(password);
            }
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.setTimeout(60000);
            session.connect();
            channel = session.openChannel("sftp");
            ChannelSftp chSftp = (ChannelSftp)channel;
            chSftp.put(strLocalFileName, remoteDir, 2);
            chSftp.quit();
            if (channel != null) {
                channel.disconnect();
            }
            if (session != null) {
                session.disconnect();
            }
        }
        catch (Exception e) {
            if (channel != null) {
                channel.disconnect();
            }
            if (session != null) {
                session.disconnect();
            }
            throw e;
        }
        return msg;
    }
}

