/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEAction
 */
package net.ibizsys.model.dataentity.action;

import java.util.Iterator;
import net.ibizsys.model.dataentity.IPSDataEntityObject;
import net.ibizsys.model.dataentity.action.IPSDEActionLogic;
import net.ibizsys.model.dataentity.action.IPSDEActionParam;
import net.ibizsys.paas.core.IDEAction;

public interface IPSDEAction
extends IPSDataEntityObject,
IDEAction {
    public static final String ACTIONTYPE_TEMPL = "TEMPL";
    public static final int PARAMMODE_ALL = 1;
    public static final int PARAMMODE_SOME = 2;

    public String getCodeName();

    public String getLogicName();

    public boolean isCustomParam();

    public int getParamMode();

    public Iterator<IPSDEActionLogic> getPSDEActionLogics(String var1);

    public Iterator<IPSDEActionLogic> getPSDEActionLogics();

    public Iterator<IPSDEActionParam> getPSDEActionParams();

    public boolean isGenerateTestUnit();

    public boolean isPubServiceDefault();

    public int getExtendMode();
}

