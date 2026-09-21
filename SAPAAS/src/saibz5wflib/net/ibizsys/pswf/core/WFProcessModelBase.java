/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFLinkModel
 *  net.ibizsys.pswf.core.IWFProcess
 *  net.ibizsys.pswf.core.IWFProcessModel
 *  net.ibizsys.pswf.core.IWFVersionModel
 */
package net.ibizsys.pswf.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFLinkModel;
import net.ibizsys.pswf.core.IWFProcess;
import net.ibizsys.pswf.core.IWFProcessModel;
import net.ibizsys.pswf.core.IWFVersionModel;
import net.ibizsys.pswf.core.WFProcess;

public abstract class WFProcessModelBase
implements IWFProcessModel {
    private String strId = "";
    private String strName = "";
    private IWFVersionModel iWFVersionModel = null;
    private boolean bAsyncMode = false;
    private ArrayList<IWFLinkModel> wfLinkModelList = new ArrayList();
    private HashMap<String, IWFLinkModel> wfLinkModelMap = new HashMap();
    private IWFProcess iWFProcess = null;
    private String strWFStepValue = "";
    private int nLeftPos = -1;
    private int nTopPos = -1;
    private String strUserData = "";
    private String strUserdata2 = "";
    private int nTimeout = 0;
    private boolean bIsEnableTimeout = false;
    private String strTimeoutField = "";
    private String strTimeoutType = "";
    private String strTimeoutNext = "";
    private String strWorkTimeType = "";
    private int nThreadSN = -1;
    private String strThreadShowName = null;
    private String strNameLanResTag = null;
    private String strTSNLanResTag = null;
    private String strBPMNModelId = "";

    public void init(IWFVersionModel iWFVersionModel) throws Exception {
        this.iWFVersionModel = iWFVersionModel;
        this.onInit();
    }

    protected void onInit() throws Exception {
        this.iWFProcess = this.createWFProcess();
        this.iWFProcess.init((IWFProcessModel)this);
    }

    protected IWFProcess createWFProcess() throws Exception {
        return new WFProcess();
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

    protected void setAsynchronousProcess(boolean bAsyncMode) {
        this.bAsyncMode = bAsyncMode;
    }

    public boolean isAsynchronousProcess() {
        return this.bAsyncMode;
    }

    public boolean isSuspendProcess() {
        return false;
    }

    public boolean isTerminalProcess() {
        return false;
    }

    public boolean isStartProcess() {
        return false;
    }

    public String getLogicName() {
        return this.getName();
    }

    public String getWFStepValue() {
        return this.strWFStepValue;
    }

    public IWFProcess getWFProcess() {
        return this.iWFProcess;
    }

    public boolean isEnableTimeout() {
        return this.bIsEnableTimeout;
    }

    public void setIsEnableTimeout(boolean isEnableTimeout) {
        this.bIsEnableTimeout = isEnableTimeout;
    }

    public String getTimeoutNext() {
        return this.strTimeoutNext;
    }

    public void setTimeoutNext(String strTimeoutNext) {
        this.strTimeoutNext = strTimeoutNext;
    }

    public int getTimeout() {
        return this.nTimeout;
    }

    public void setTimeout(int nTimeout) {
        this.nTimeout = nTimeout;
    }

    public String getTimeoutField() {
        return this.strTimeoutField;
    }

    public void setTimeoutField(String strTimeoutField) {
        this.strTimeoutField = strTimeoutField;
    }

    public String getTimeoutType() {
        return this.strTimeoutType;
    }

    public void setTimeoutType(String strTimeoutType) {
        this.strTimeoutType = strTimeoutType;
    }

    public String getWorkTimeType() {
        return this.strWorkTimeType;
    }

    public void setWorkTimeType(String strWorkTimeType) {
        this.strWorkTimeType = strWorkTimeType;
    }

    public void registerWFLinkModel(IWFLinkModel iWFLinkModel) throws Exception {
        this.wfLinkModelList.add(iWFLinkModel);
    }

    public Iterator<IWFLinkModel> getWFLinkModels() throws Exception {
        return this.wfLinkModelList.iterator();
    }

    protected void setWFStepValue(String strWFStepValue) {
        this.strWFStepValue = strWFStepValue;
    }

    public int getLeftPos() {
        return this.nLeftPos;
    }

    public int getTopPos() {
        return this.nTopPos;
    }

    protected void setLeftPos(int nLeftPos) {
        this.nLeftPos = nLeftPos;
    }

    protected void setTopPos(int nTopPos) {
        this.nTopPos = nTopPos;
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

    @Deprecated
    public String getWorktimeType() {
        return this.strWorkTimeType;
    }

    @Deprecated
    public void setWorktimeType(String strWorkTimeType) {
        this.strWorkTimeType = strWorkTimeType;
    }

    public int getThreadSN() {
        return this.nThreadSN;
    }

    protected void setThreadSN(int nThreadSN) {
        this.nThreadSN = nThreadSN;
    }

    public String getThreadShowName() {
        return this.strThreadShowName;
    }

    protected void setThreadShowName(String strThreadShowName) {
        this.strThreadShowName = strThreadShowName;
    }

    public String getNameLanResTag() {
        return this.strNameLanResTag;
    }

    public String getTSNLanResTag() {
        return this.strTSNLanResTag;
    }

    protected void setNameLanResTag(String strNameLanResTag) {
        this.strNameLanResTag = strNameLanResTag;
    }

    protected void setTSNLanResTag(String strTSNLanResTag) {
        this.strTSNLanResTag = strTSNLanResTag;
    }

    public IWFLinkModel getWFLinkModel(String strWFLinkId) throws Exception {
        IWFLinkModel iWFLinkModel = this.wfLinkModelMap.get(strWFLinkId);
        if (iWFLinkModel == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6d41\u7a0b\u8fde\u63a5\u6a21\u578b\uff0c\u6807\u8bc6\u4e3a[%1$s]", (Object)strWFLinkId));
        }
        return iWFLinkModel;
    }

    public String getBPMNModelId() {
        return this.strBPMNModelId;
    }

    protected void setBPMNModelId(String strBPMNModelId) {
        this.strBPMNModelId = strBPMNModelId;
    }
}

