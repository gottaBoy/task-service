/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.WF.UIAction;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.WF.IPSWFLink;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import SA.SRFDA.PS.Core.WF.IPSWorkflowObject;
import SA.SRFDA.PS.Data.PSDEUIAction;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(implement="PSWFUIActionImpl")
public interface IPSWFUIAction
extends IPSWorkflowObject,
IPSUIAction {
    public static final String UIACTIONTYPE_WFUIACTION = "WFUIACTION";

    public void init(ISRFDAGlobalHelper var1, IPSWorkflow var2, IPSWFVersion var3, PSDEUIAction var4) throws Exception;

    public String getFrontPSDEViewId();

    public String getFrontPSDEViewId(Object var1);

    @Override
    public IPSAppView getFrontPSAppView(Object var1) throws Exception;

    public IPSWFVersion getPSWFVersion();

    public IPSWFProcess getPSWFProcess();

    public IPSWFLink getPSWFLink();

    public String getFrontPSSysPDTViewId();

    public boolean isFrontPDTView();

    public String getPSSysDEUIActionId(Object var1) throws Exception;

    public boolean isSaveTargetFirst();
}

