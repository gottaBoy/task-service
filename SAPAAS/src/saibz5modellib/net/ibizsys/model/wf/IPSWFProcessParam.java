/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFDEActionProcessParamModel
 */
package net.ibizsys.model.wf;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.wf.IPSWFProcess;
import net.ibizsys.pswf.core.IWFDEActionProcessParamModel;

public interface IPSWFProcessParam
extends IPSModelObject,
IWFDEActionProcessParamModel {
    public static final String SRCVALUETYPE_SESSION = "SESSION";
    public static final String SRCVALUETYPE_APPLICATION = "APPLICATION";
    public static final String SRCVALUETYPE_UNIQUEID = "UNIQUEID";
    public static final String SRCVALUETYPE_CONTEXT = "CONTEXT";
    public static final String SRCVALUETYPE_OPERATOR = "OPERATOR";
    public static final String SRCVALUETYPE_OPERATORNAME = "OPERATORNAME";
    public static final String SRCVALUETYPE_CURTIME = "CURTIME";

    public IPSWFProcess getPSWFProcess();

    public String getDstField() throws Exception;

    public String getSrcValue();

    public String getDirectCode();

    public String getSrcValueType();
}

