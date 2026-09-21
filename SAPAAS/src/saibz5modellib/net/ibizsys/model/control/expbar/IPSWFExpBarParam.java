/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.expbar;

import net.ibizsys.model.control.expbar.IPSExpBarParam;

public interface IPSWFExpBarParam
extends IPSExpBarParam {
    public static final String SECTION_MYDATA = "MY";
    public static final String SECTION_ALLDATA = "ALL";
    public static final String SECTION_MYWFWORK = "MYWFWORK";
    public static final String SECTION_PROCESSING = "PROCESSING";

    public boolean isOutputMyWorkFirst();

    public boolean hasOutputMyWorkFirstParam();

    public boolean isExpandMyWork();

    public boolean isOutputMyHistoryWork();

    public String getWFDataSector();

    public String getMyHistoryWorkName();

    public String getMyWorkName();

    public boolean isOutputWFParallelFolder();

    public boolean isOutputMyDataWFSteps();

    public boolean hasOutputMyDataWFStepsParam();
}

