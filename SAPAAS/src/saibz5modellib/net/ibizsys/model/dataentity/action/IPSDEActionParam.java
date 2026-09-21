/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.dataentity.action;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.field.IPSDEField;

public interface IPSDEActionParam
extends IPSModelObject {
    public static final String VALUETYPE_INPUTVALUE = "INPUTVALUE";
    public static final String VALUETYPE_VALUE = "VALUE";
    public static final String VALUETYPE_NULLVALUE = "NULLVALUE";
    public static final String VALUETYPE_SESSION = "SESSION";
    public static final String VALUETYPE_APPLICATION = "APPLICATION";
    public static final String VALUETYPE_UNIQUEID = "UNIQUEID";
    public static final String VALUETYPE_CONTEXT = "CONTEXT";
    public static final String VALUETYPE_PARAM = "PARAM";
    public static final String VALUETYPE_OPERATOR = "OPERATOR";
    public static final String VALUETYPE_OPERATORNAME = "OPERATORNAME";
    public static final String VALUETYPE_CURTIME = "CURTIME";
    public static final String VALUETYPE_APPDATA = "APPDATA";
    public static final String VALUETYPE_NONEVALUE = "NONEVALUE";

    public IPSDEField getPSDEField();

    public IPSDEAction getPSDEAction();

    public String getValueType();

    public String getValue();
}

