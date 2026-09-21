/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.pswf.core.IWFVersionModel
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.IPSDynaInstSupportable;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.WF.IPSWFLink;
import SA.SRFDA.PS.Core.WF.IPSWFLinkCond;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import SA.SRFDA.PS.Core.WF.IPSWorkflowObject;
import SA.SRFDA.PS.Core.WF.UIAction.IPSWFUIAction;
import SA.SRFDA.PS.Core.WF.UIAction.IPSWFUIActionGroup;
import SA.SRFDA.PS.Data.PSWFVersion;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.pswf.core.IWFVersionModel;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5de5\u4f5c\u6d41\u7248\u672c\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSWFVersion")
public interface IPSWFVersion
extends IPSWorkflowObject,
IWFVersionModel,
IPSModelObject,
IPSDynaInstSupportable {
    public void init(ISRFDAGlobalHelper var1, IPSWorkflow var2, PSWFVersion var3) throws Exception;

    @Override
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

    public void resetPSWFUIAction(String var1) throws Exception;

    public IPSWFUIActionGroup getPSWFUIActionGroup(String var1) throws Exception;

    public IPSWFUIActionGroup getPSWFUIActionGroup(String var1, boolean var2) throws Exception;

    public void resetPSWFUIActionGroup(String var1) throws Exception;

    public boolean isValid();

    public Iterator<IPSWFUIAction> getPSWFUIActions() throws Exception;

    public Iterator<IPSWFUIActionGroup> getPSWFUIActionGroups() throws Exception;

    public IPSCodeList getWFStepPSCodeList();

    public IPSWFLink getPSWFLink(String var1, boolean var2) throws Exception;

    public Iterator<IPSWFLinkCond> getAllPSWFLinkConds();

    public boolean hasStartView();

    public boolean hasMobStartView();

    public String getWFCodeName();

    @Override
    public IPSWorkflow getPSWorkflow();
}

