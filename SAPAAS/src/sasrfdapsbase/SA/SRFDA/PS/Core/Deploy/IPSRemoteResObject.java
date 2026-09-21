/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSRemoteResObject {
    public static final String CFG_HOST_ADDR = "host.addr";
    public static final String CFG_HOST_PORT = "host.port";
    public static final String CFG_HOST_USER = "host.user";
    public static final String CFG_HOST_PASS = "host.pass";
    public static final String CFG_HOST_UPLOADPATH = "host.uploadpath";
    public static final String CFG_HOST_UPLOADMODE = "host.uploadmode";
    public static final String CFG_HOST_ADDR2 = "host.addr2";
    public static final String CFG_HOST_PORT2 = "host.port2";
    public static final String UPLOADMODE_SSH = "SSH";
    public static final String UPLOADMODE_SFTP = "SFTP";
    public static final String UPLOADMODE_FTP = "FTP";

    public String getRemoteAddress();

    public int getRemotePort();

    public String getRemoteUserName();

    public String getRemotePassword();

    public String getRemoteUploadPath();

    public String getRemoteUploadMode();
}

