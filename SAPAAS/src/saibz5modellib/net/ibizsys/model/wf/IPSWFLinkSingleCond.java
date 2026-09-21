/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFLinkSingleCondModel
 */
package net.ibizsys.model.wf;

import net.ibizsys.model.wf.IPSWFLinkCond;
import net.ibizsys.pswf.core.IWFLinkSingleCondModel;

public interface IPSWFLinkSingleCond
extends IPSWFLinkCond,
IWFLinkSingleCondModel {
    public static final String PARAMTYPE_ENTITYFIELD = "ENTITYFIELD";
    public static final String PARAMTYPE_CURTIME = "CURTIME";
    public static final String PARAMTYPE_TIMERULE = "TIMERULE";

    public String getFieldName() throws Exception;

    public String getPSDBValueOPId();

    public String getParamType();

    public String getParamValue();
}

