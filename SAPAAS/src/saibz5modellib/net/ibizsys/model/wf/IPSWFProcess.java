/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFProcessModel
 */
package net.ibizsys.model.wf;

import java.util.Iterator;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.wf.IPSWFLink;
import net.ibizsys.model.wf.IPSWFProcessParam;
import net.ibizsys.model.wf.IPSWFVersion;
import net.ibizsys.pswf.core.IWFProcessModel;

public interface IPSWFProcess
extends IWFProcessModel,
IPSModelObject {
    public static final String WFPROCESSTYPE_START = "START";
    public static final String WFPROCESSTYPE_END = "END";
    public static final String WFPROCESSTYPE_PROCESS = "PROCESS";
    public static final String WFPROCESSTYPE_INTERACTIVE = "INTERACTIVE";
    public static final String WFPROCESSTYPE_PARALLEL = "PARALLEL";
    public static final String WFPROCESSTYPE_EMBED = "EMBED";
    public static final String TIMEOUTTYPE_MINUTE = "MINUTE";
    public static final String TIMEOUTTYPE_HOUR = "HOUR";
    public static final String TIMEOUTTYPE_DAY = "DAY";
    public static final String TIMEOUTTYPE_WORKDAY = "WORKDAY";

    public Iterator<IPSWFLink> getPSWFLinks();

    public Iterator<IPSWFProcessParam> getPSWFProcessParams();

    public String getWFProcessType();

    public IPSWFVersion getPSWFVersion();

    public String getCodeName();

    public boolean isParallelOutput();

    public String getWFStepValue();

    public IPSLanguageRes getNamePSLanguageRes();

    public IPSLanguageRes getTSNPSLanguageRes();
}

