/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.dao;

import java.util.Date;
import net.ibizsys.paas.db.ISelectCond;

public interface IBASelectContext
extends ISelectCond {
    public String[] getColSets();

    public String getRowKeyPrefix();

    public int getMaxVersions();

    public Date getStartTimeStamp();

    public Date getStopTimeStamp();

    public String getStartRowKey();

    public String getStopRowKey();

    public int getBatchSize();

    public Date getTimeStamp();
}

