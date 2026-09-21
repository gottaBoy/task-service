/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.dao;

import java.util.Date;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.psba.dao.IBASelectContext;

public class BASelectContext
extends SelectCond
implements IBASelectContext {
    private String[] colSets = null;
    private String strRowKeyPrefix = null;
    private int nMaxVersions = -1;
    private Date startTimeStamp = null;
    private Date stopTimeStamp = null;
    private String strStartRowKey = null;
    private String strStopRowKey = null;
    private int nBatchSize = -1;
    private Date timeStamp = null;

    @Override
    public String[] getColSets() {
        return this.colSets;
    }

    @Override
    public String getRowKeyPrefix() {
        return this.strRowKeyPrefix;
    }

    @Override
    public int getMaxVersions() {
        return this.nMaxVersions;
    }

    @Override
    public Date getStartTimeStamp() {
        return this.startTimeStamp;
    }

    @Override
    public Date getStopTimeStamp() {
        return this.stopTimeStamp;
    }

    @Override
    public String getStartRowKey() {
        return this.strStartRowKey;
    }

    @Override
    public String getStopRowKey() {
        return this.strStopRowKey;
    }

    @Override
    public int getBatchSize() {
        return this.nBatchSize;
    }

    public void setColSets(String[] colSets) {
        this.colSets = colSets;
    }

    public void setRowKeyPrefix(String strRowKeyPrefix) {
        this.strRowKeyPrefix = strRowKeyPrefix;
    }

    public void setMaxVersions(int nMaxVersions) {
        this.nMaxVersions = nMaxVersions;
    }

    public void setStartTimeStamp(Date startTimeStamp) {
        this.startTimeStamp = startTimeStamp;
    }

    public void setStopTimeStamp(Date stopTimeStamp) {
        this.stopTimeStamp = stopTimeStamp;
    }

    public void setStartRowKey(String strStartRowKey) {
        this.strStartRowKey = strStartRowKey;
    }

    public void setStopRowKey(String strStopRowKey) {
        this.strStopRowKey = strStopRowKey;
    }

    public void setBatchSize(int nBatchSize) {
        this.nBatchSize = nBatchSize;
    }

    @Override
    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    protected void onReset() {
        this.colSets = null;
        this.strRowKeyPrefix = null;
        this.nMaxVersions = -1;
        this.startTimeStamp = null;
        this.stopTimeStamp = null;
        this.strStartRowKey = null;
        this.strStopRowKey = null;
        this.nBatchSize = -1;
        this.timeStamp = null;
        super.onReset();
    }
}

