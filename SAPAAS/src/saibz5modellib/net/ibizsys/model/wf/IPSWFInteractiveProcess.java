/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFInteractiveProcessModel
 */
package net.ibizsys.model.wf;

import java.util.Iterator;
import net.ibizsys.model.wf.IPSWFProcess;
import net.ibizsys.model.wf.IPSWFProcessRole;
import net.ibizsys.pswf.core.IWFInteractiveProcessModel;

public interface IPSWFInteractiveProcess
extends IPSWFProcess,
IWFInteractiveProcessModel {
    public static final String PREDEFINEDACTION_SENDBACK = "SENDBACK";
    public static final String PREDEFINEDACTION_SUPPLYINFO = "SUPPLYINFO";
    public static final String PREDEFINEDACTION_ADDSTEPBEFORE = "ADDSTEPBEFORE";
    public static final String PREDEFINEDACTION_ADDSTEPAFTER = "ADDSTEPAFTER";
    public static final String PREDEFINEDACTION_TAKEADVICE = "TAKEADVICE";
    public static final String PREDEFINEDACTION_USERACTION = "USERACTION";
    public static final String PREDEFINEDACTION_USERACTION2 = "USERACTION2";
    public static final String PREDEFINEDACTION_USERACTION3 = "USERACTION3";
    public static final String PREDEFINEDACTION_USERACTION4 = "USERACTION4";
    public static final String PREDEFINEDACTION_USERACTION5 = "USERACTION5";
    public static final String PREDEFINEDACTION_USERACTION6 = "USERACTION6";

    public Iterator<IPSWFProcessRole> getPSWFProcessRoles();

    public Iterator<String> getPredefinedActions();

    public boolean isEnablePredefinedAction(String var1);
}

