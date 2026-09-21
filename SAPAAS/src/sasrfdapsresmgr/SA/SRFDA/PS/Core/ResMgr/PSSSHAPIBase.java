/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  com.trilead.ssh2.Connection
 *  com.trilead.ssh2.SCPClient
 *  com.trilead.ssh2.Session
 *  com.trilead.ssh2.StreamGobbler
 */
package SA.SRFDA.PS.Core.ResMgr;

import SA.SRFramework.Utility.StringHelper;
import com.trilead.ssh2.Connection;
import com.trilead.ssh2.SCPClient;
import com.trilead.ssh2.Session;
import com.trilead.ssh2.StreamGobbler;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class PSSSHAPIBase {
    private static HashMap<String, Connection> connectionMap = new HashMap();
    public static final String SUCCESS = "SUCCESS";

    public static List<String> runRemoteScript(String host, String username, String password, String cmd) throws Exception {
        return PSSSHAPIBase.runRemoteScript(host, 22, username, password, cmd);
    }

    public static List<String> runRemoteScript(String host, int port, String username, String password, String cmd) throws Exception {
        String line;
        ArrayList<String> result = new ArrayList<String>();
        Connection conn = PSSSHAPIBase.getConnection(host, port, username, password);
        Session sess = conn.openSession();
        sess.execCommand(cmd);
        StreamGobbler stdout = new StreamGobbler(sess.getStdout());
        BufferedReader br = new BufferedReader(new InputStreamReader((InputStream)stdout));
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            result.add(line);
        }
        sess.close();
        return result;
    }

    public static String getFileFromRemote(String host, String username, String password, String romoteFileName, String localDir) {
        return PSSSHAPIBase.getFileFromRemote(host, 22, username, password, romoteFileName, localDir);
    }

    public static String getFileFromRemote(String host, int port, String username, String password, String romoteFileName, String localDir) {
        Connection conn;
        String msg;
        block4: {
            msg = SUCCESS;
            try {
                conn = null;
                conn = port == 22 ? new Connection(host) : new Connection(host, port);
                conn.connect();
                boolean isAuthenticated = conn.authenticateWithPassword(username, password);
                if (isAuthenticated) break block4;
                return "\u6743\u9650\u4e0d\u591f!";
            }
            catch (IOException e) {
                return "\u51fa\u73b0\u4e86IO\u9519\u8bef!";
            }
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

    public static String putFileToRemote(String host, String username, String password, String localFileName, String remoteDir) throws Exception {
        return PSSSHAPIBase.putFileToRemote(host, 22, username, password, localFileName, remoteDir);
    }

    public static String putFileToRemote(String host, int port, String username, String password, String localFileName, String remoteDir) throws Exception {
        String msg = SUCCESS;
        Connection conn = PSSSHAPIBase.getConnection(host, port, username, password);
        SCPClient scpClient = conn.createSCPClient();
        scpClient.put(localFileName, remoteDir);
        return msg;
    }

    public static Connection getConnection(String host, String username, String password) throws Exception {
        return PSSSHAPIBase.getConnection(host, 22, username, password);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Connection getConnection(String host, int port, String username, String password) throws Exception {
        HashMap<String, Connection> hashMap;
        String strKey = StringHelper.Format((String)"%1$s|%2$s|%3$s|%4$s", (Object)host, (Object)port, (Object)username, (Object)password);
        Connection connection = null;
        HashMap<String, Connection> hashMap2 = connectionMap;
        synchronized (hashMap2) {
            connection = connectionMap.get(strKey);
        }
        if (connection != null) {
            try {
                PSSSHAPIBase.testConnection(connection);
                return connection;
            }
            catch (Exception ex) {
                connection.close();
                hashMap = connectionMap;
                synchronized (hashMap) {
                    connectionMap.remove(strKey);
                    connection = null;
                }
            }
        }
        connection = port == 22 ? new Connection(host) : new Connection(host, port);
        connection.connect();
        boolean isAuthenticated = connection.authenticateWithPassword(username, password);
        if (!isAuthenticated) {
            throw new Exception("\u6743\u9650\u4e0d\u591f!");
        }
        hashMap = connectionMap;
        synchronized (hashMap) {
            connectionMap.put(strKey, connection);
        }
        return connection;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void closeConnection(String host, int port, String username, String password) {
        String strKey = StringHelper.Format((String)"%1$s|%2$s|%3$s|%4$s", (Object)host, (Object)port, (Object)username, (Object)password);
        Connection connection = null;
        HashMap<String, Connection> hashMap = connectionMap;
        synchronized (hashMap) {
            connection = connectionMap.get(strKey);
        }
        if (connection != null) {
            connection.close();
            hashMap = connectionMap;
            synchronized (hashMap) {
                connectionMap.remove(strKey);
                connection = null;
            }
        }
    }

    public static void closeConnection(String host, String username, String password) {
        PSSSHAPIBase.closeConnection(host, 22, username, password);
    }

    protected static void testConnection(Connection connection) throws Exception {
        String line;
        Session sess = connection.openSession();
        sess.execCommand("date");
        StreamGobbler stdout = new StreamGobbler(sess.getStdout());
        BufferedReader br = new BufferedReader(new InputStreamReader((InputStream)stdout));
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        sess.close();
    }
}

