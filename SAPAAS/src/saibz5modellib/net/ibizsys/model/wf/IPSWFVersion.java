/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFVersionModel
 */
package net.ibizsys.model.wf;

import java.util.Iterator;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.wf.IPSWFLink;
import net.ibizsys.model.wf.IPSWFProcess;
import net.ibizsys.model.wf.IPSWorkflowObject;
import net.ibizsys.model.wf.uiaction.IPSWFUIAction;
import net.ibizsys.model.wf.uiaction.IPSWFUIActionGroup;
import net.ibizsys.pswf.core.IWFVersionModel;

public interface IPSWFVersion
extends IPSWorkflowObject,
IWFVersionModel,
IPSModelObject {
    public String getCodeName();

    public int getWFVersion();

    public IPSWFProcess getStartPSWFProcess();

    public Iterator<IPSWFProcess> getPSWFProcesses();

    public IPSWFProcess getPSWFProcess(String var1, boolean var2) throws Exception;

    public Iterator<IPSWFLink> getPSWFLinks();

    public IPSWFProcess getPSWFProcessByWFStepValue(String var1, boolean var2) throws Exception;

    public Iterator<IPSWFUIAction> getAllPSWFUIActions() throws Exception;

    public IPSWFUIAction getPSWFUIAction(String var1) throws Exception;

    public IPSWFUIAction getPSWFUIAction(String var1, boolean var2) throws Exception;

    public IPSWFUIActionGroup getPSWFUIActionGroup(String var1) throws Exception;

    public IPSWFUIActionGroup getPSWFUIActionGroup(String var1, boolean var2) throws Exception;

    public boolean isValid();

    public Iterator<IPSWFUIAction> getPSWFUIActions() throws Exception;

    public Iterator<IPSWFUIActionGroup> getPSWFUIActionGroups() throws Exception;

    public IPSCodeList getWFStepPSCodeList();

    public int getVersion();
}

