/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.WF.UIAction;

import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import SA.SRFDA.PS.Core.WF.IPSWorkflowObject;
import SA.SRFDA.PS.Core.WF.UIAction.IPSWFUIAction;
import SA.SRFDA.PS.Core.WF.UIAction.IPSWFUIActionGroupDetail;
import SA.SRFDA.PS.Data.PSDEUIActionGroup;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSWFUIActionGroup
extends IPSWorkflowObject,
IPSUIActionGroup {
    public void init(ISRFDAGlobalHelper var1, IPSWorkflow var2, IPSWFVersion var3, PSDEUIActionGroup var4) throws Exception;

    public IPSWFVersion getPSWFVersion();

    public Iterator<IPSWFUIAction> getPSWFUIActions();

    public Iterator<IPSWFUIActionGroupDetail> getPSWFUIActionGroupDetails();
}

