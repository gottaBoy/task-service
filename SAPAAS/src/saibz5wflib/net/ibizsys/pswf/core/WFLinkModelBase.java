/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFLinkModel
 *  net.ibizsys.pswf.core.IWFVersionModel
 */
package net.ibizsys.pswf.core;

import net.ibizsys.pswf.core.IWFLinkModel;
import net.ibizsys.pswf.core.IWFVersionModel;

public abstract class WFLinkModelBase
implements IWFLinkModel {
    private String strId = "";
    private String strName = "";
    private String strFrom = "";
    private String strNext = "";
    private String strLogicName = "";
    private IWFVersionModel iWFVersionModel = null;
    private String strSrcEndPoint = "";
    private String strDstEndPoint = "";
    private String strUserData = "";
    private String strUserdata2 = "";
    private int nThreadLinkMode = 1;
    private String strThreadShowName = "";
    private String strLNLanResTag = null;
    private String strBPMNModelId = "";
    private String strNextCondition = "";

    public void init(IWFVersionModel iWFVersionModel) throws Exception {
        this.iWFVersionModel = iWFVersionModel;
        this.onInit();
    }

    protected void onInit() throws Exception {
    }

    public String getId() {
        return this.strId;
    }

    public String getName() {
        return this.strName;
    }

    protected void setId(String strId) {
        this.strId = strId;
    }

    protected void setName(String strName) {
        this.strName = strName;
    }

    public IWFVersionModel getWFVersionModel() {
        return this.iWFVersionModel;
    }

    public String getNext() {
        return this.strNext;
    }

    public String getFrom() {
        return this.strFrom;
    }

    public String getLogicName() {
        return this.strLogicName;
    }

    protected void setFrom(String strFrom) {
        this.strFrom = strFrom;
    }

    protected void setNext(String strNext) {
        this.strNext = strNext;
    }

    protected void setLogicName(String strLogicName) {
        this.strLogicName = strLogicName;
    }

    public String getSrcEndPoint() {
        return this.strSrcEndPoint;
    }

    public String getDstEndPoint() {
        return this.strDstEndPoint;
    }

    protected void setSrcEndPoint(String strSrcEndPoint) {
        this.strSrcEndPoint = strSrcEndPoint;
    }

    protected void setDstEndPoint(String strDstEndPoint) {
        this.strDstEndPoint = strDstEndPoint;
    }

    public String getUserData() {
        return this.strUserData;
    }

    public String getUserData2() {
        return this.strUserdata2;
    }

    protected void setUserData(String strUserData) {
        this.strUserData = strUserData;
    }

    protected void setUserData2(String strUserdata2) {
        this.strUserdata2 = strUserdata2;
    }

    public String getThreadShowName() {
        return this.strThreadShowName;
    }

    public int getThreadLinkMode() {
        return this.nThreadLinkMode;
    }

    protected void setThreadLinkMode(int nThreadLinkMode) {
        this.nThreadLinkMode = nThreadLinkMode;
    }

    protected void setThreadShowName(String strThreadShowName) {
        this.strThreadShowName = strThreadShowName;
    }

    public String getLNLanResTag() {
        return this.strLNLanResTag;
    }

    protected void setLNLanResTag(String strLNLanResTag) {
        this.strLNLanResTag = strLNLanResTag;
    }

    public String getBPMNModelId() {
        return this.strBPMNModelId;
    }

    protected void setBPMNModelId(String strBPMNModelId) {
        this.strBPMNModelId = strBPMNModelId;
    }

    public String getNextCondition() {
        return this.strNextCondition;
    }

    protected void setNextCondition(String strNextCondition) {
        this.strNextCondition = strNextCondition;
    }
}

