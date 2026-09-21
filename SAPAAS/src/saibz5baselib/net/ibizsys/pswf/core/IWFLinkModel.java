/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswf.core;

import net.ibizsys.pswf.core.IWFVersionModel;

public interface IWFLinkModel {
    public static final String Timeout = "TIMEOUT";
    public static final String IAAction = "IAACTION";
    public static final String Route = "ROUTE";
    public static final String WFReturn = "WFRETURN";
    public static final int THREADLINKMODE_NONE = 0;
    public static final int THREADLINKMODE_MAJOR = 1;
    public static final int THREADLINKMODE_MINOR = 2;

    public void init(IWFVersionModel var1) throws Exception;

    public String getId();

    public String getName();

    public String getLogicName();

    public String getLNLanResTag();

    public IWFVersionModel getWFVersionModel();

    public String getNext();

    public String getFrom();

    public String getSrcEndPoint();

    public String getDstEndPoint();

    public String getUserData();

    public String getUserData2();

    public String getThreadShowName();

    public int getThreadLinkMode();

    public String getBPMNModelId();

    public String getNextCondition();
}

