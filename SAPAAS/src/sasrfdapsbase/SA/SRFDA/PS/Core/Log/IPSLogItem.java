/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Log;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import java.sql.Timestamp;

@PSModelIgnoreMeta
public interface IPSLogItem {
    public Timestamp getLogTime();

    public IPSObject getPSObject();

    public String getLogInfo();

    public int getLogLevel();

    public String getUserData();

    public String getUserData2();
}

