/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.dataentity.logic;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.logic.IPSDELogicNode;
import net.ibizsys.model.dataentity.logic.IPSDELogicParam;

public interface IPSDELogicNodeParam
extends IPSModelObject {
    public static final String PARAMTYPE_SETPARAMVALUE = "SETPARAMVALUE";
    public static final String PARAMTYPE_RESETPARAM = "RESETPARAM";
    public static final String PARAMTYPE_COPYPARAM = "COPYPARAM";
    public static final String PARAMTYPE_SQLPARAM = "SQLPARAM";
    public static final String SRCVALUETYPE_SRCDLPARAM = "SRCDLPARAM";
    public static final String SRCVALUETYPE_WEBCONTEXT = "WEBCONTEXT";
    public static final String SRCVALUETYPE_NONEVALUE = "NONEVALUE";
    public static final String SRCVALUETYPE_NULLVALUE = "NULLVALUE";

    public IPSDELogicNode getPSDELogicNode();

    public String getLogicNodeParamType();

    public IPSDELogicParam getDstPSDELogicParam() throws Exception;

    public String getDstFieldName() throws Exception;

    public IPSDELogicParam getSrcPSDELogicParam() throws Exception;

    public String getSrcFieldName() throws Exception;

    public String getSrcValue();

    public String getDirectCode();

    public String getSrcValueType();
}

