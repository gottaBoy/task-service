/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import java.sql.Timestamp;

@PSModelIgnoreMeta
public interface IPSDCResObject
extends IPSObject {
    public static final int RESSTATE_UNINIT = 10;
    public static final int RESSTATE_VALID = 20;
    public static final int RESSTATE_INVALID = 40;
    public static final int RESSTATE_EXPIRED = 41;
    public static final int RESSTATE_TSRESNOTREADY = 42;
    public static final int RESPOS_PAAS = 1;
    public static final int RESPOS_USER = 2;
    public static final int RESPOS_PAAS_TIMESHARE = 5;
    public static final int RESPOS_USER_CLUSTER = 10;

    public int getResState();

    public int getResPos();

    public String getResCfgFilePath();

    public boolean isLocalRes();

    public Timestamp getExpiredTime();
}

