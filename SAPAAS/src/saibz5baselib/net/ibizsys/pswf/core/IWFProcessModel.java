/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswf.core;

import java.util.Iterator;
import net.ibizsys.pswf.core.IWFLinkModel;
import net.ibizsys.pswf.core.IWFProcess;
import net.ibizsys.pswf.core.IWFVersionModel;

public interface IWFProcessModel {
    public static final String Start = "START";
    public static final String End = "END";
    public static final String Process = "PROCESS";
    public static final String Interactive = "INTERACTIVE";
    public static final String Parallel = "PARALLEL";
    public static final String Embed = "EMBED";
    public static final String ExclusiveGateway = "EXCLUSIVEGATEWAY";
    public static final String InclusiveGateway = "INCLUSIVEGATEWAY";
    public static final String ParallelGateway = "PARALLELGATEWAY";
    public static final String TimerEvent = "TIMEREVENT";
    public static final String TIMEOUTTYPE_MINUTE = "MINUTE";
    public static final String TIMEOUTTYPE_HOUR = "HOUR";
    public static final String TIMEOUTTYPE_DAY = "DAY";
    public static final String TIMEOUTTYPE_WORKDAY = "WORKDAY";

    public void init(IWFVersionModel var1) throws Exception;

    public String getId();

    public String getName();

    public String getLogicName();

    public IWFVersionModel getWFVersionModel();

    public String getWFProcessType();

    public boolean isAsynchronousProcess();

    public boolean isSuspendProcess();

    public boolean isTerminalProcess();

    public boolean isStartProcess();

    public String getWFStepValue();

    public IWFProcess getWFProcess();

    public boolean isEnableTimeout();

    public String getTimeoutNext();

    public int getTimeout();

    public String getTimeoutField();

    public String getTimeoutType();

    public String getWorkTimeType();

    @Deprecated
    public String getWorktimeType();

    public void registerWFLinkModel(IWFLinkModel var1) throws Exception;

    public Iterator<IWFLinkModel> getWFLinkModels() throws Exception;

    public IWFLinkModel getWFLinkModel(String var1) throws Exception;

    public int getLeftPos();

    public int getTopPos();

    public String getUserData();

    public String getUserData2();

    public int getThreadSN();

    public String getThreadShowName();

    public String getNameLanResTag();

    public String getTSNLanResTag();

    public String getBPMNModelId();
}

