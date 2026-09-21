/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DevCenter;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSDevCenterNetworkFlow {
    public void setActionType(String var1);

    public String getActionType();

    public void setActionInfo(String var1);

    public String getActionInfo();

    public void setFlow(Integer var1);

    public Integer getFlow();

    public long getBeginTime();

    public void setBeginTime(long var1);

    public long getEndTime();

    public void setEndTime(long var1);
}

