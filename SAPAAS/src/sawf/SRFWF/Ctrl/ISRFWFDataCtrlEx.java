/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 */
package SRFWF.Ctrl;

import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SRFWF.Client.WFParam;
import SRFWF.Ctrl.Data.WFInstance;
import SRFWF.Ctrl.Data.WFStepActor;
import SRFWF.Ctrl.Data.WFStepData;
import SRFWF.Ctrl.Data.WFStepInst;
import SRFWF.Ctrl.ISRFWFContext;
import SRFWF.Ctrl.ISRFWFDataCtrl;
import SRFWF.Model.WFBaseProcessConfig;
import SRFWF.Model.WFEmbedWorkflowConfig;
import SRFWF.Model.WFParallelSubWFConfig;
import java.util.Vector;

public interface ISRFWFDataCtrlEx
extends ISRFWFDataCtrl {
    public CallResult TestStartWF(ISRFWFContext var1);

    public CallResult TestRestartWF(ISRFWFContext var1);

    public CallResult TestCancelWF(ISRFWFContext var1);

    public CallResult GetEmbedWorkflows(ISRFWFContext var1, WFEmbedWorkflowConfig var2, Vector<WFParam> var3);

    public CallResult GetParallelSubWFs(ISRFWFContext var1, WFParallelSubWFConfig var2, Vector<WFParam> var3);

    public CallResult AddWFStepInst(ISRFWFContext var1, WFStepInst var2);

    public CallResult CloseWFStepInst(ISRFWFContext var1, WFStepInst var2);

    public CallResult GetWFStepInstCount(ISRFWFContext var1, String var2, String var3);

    public CallResult GetWFStepInstCount(ISRFWFContext var1, String var2);

    public CallResult GetUnfinishWFStepInsts(ISRFWFContext var1, String var2, Vector<WFStepInst> var3);

    public CallResult UpdateCurWFStepActors(ISRFWFContext var1);

    public CallResult MarkWFStepActorReadFlag(ISRFWFContext var1, WFStepActor var2);

    public CallResult GetEmbedWorkflowReturnValue(ISRFWFContext var1, String var2, BaseDataEntity var3, WFBaseProcessConfig var4);

    public CallResult AddRawWFStepData(ISRFWFContext var1, WFStepData var2);

    public CallResult GetLastWFStepData(ISRFWFContext var1, WFStepData var2);

    public CallResult CancelStartWFInstance(WFInstance var1, String var2);
}

