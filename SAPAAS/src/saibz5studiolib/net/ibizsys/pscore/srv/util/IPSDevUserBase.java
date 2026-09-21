/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util;

import java.io.Serializable;
import java.sql.Timestamp;

public interface IPSDevUserBase
extends Serializable {
    public static final int ACCMODE_NONE = 0;
    public static final int ACCMODE_READ = 1;
    public static final int ACCMODE_WRITE = 2;
    public static final int ACCMODE_SHARE = 5;
    public static final int ACCMODE_ALL = 3;
    public static final int ACCMODE_MAINTAIN = 11;
    public static final int ACCMODE_OWNER = 19;
    public static final String STUDIOVER_S0500 = "S0500";
    public static final String STUDIOVER_S0600 = "S0600";
    public static final String STUDIOVER_S0600M1 = "S0600M1";

    public String getPSDevCenterId();

    public String getPSDevCenterName();

    public String getPSDevUserId();

    public String getTaskServerUrl();

    public Timestamp getExpiredTime();

    public boolean isExpired();

    public String getUserTag();

    public String getUserTag2();

    public Object getUserTag3();

    public Object getUserTag4();

    public String getStudioVer();

    public String getStudioTag();

    public String getStudioTag2();

    public String getPSDevUserName();
}

