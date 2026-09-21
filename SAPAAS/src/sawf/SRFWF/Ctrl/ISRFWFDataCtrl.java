/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDBCallerHelperEx
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  javax.servlet.ServletContext
 */
package SRFWF.Ctrl;

import SA.SRFramework.DataEx.BaseDBCallerHelperEx;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SRFWF.Client.WFParam;
import SRFWF.Ctrl.Data.WFAction;
import SRFWF.Ctrl.Data.WFActor;
import SRFWF.Ctrl.Data.WFIAAction;
import SRFWF.Ctrl.Data.WFInstance;
import SRFWF.Ctrl.Data.WFStep;
import SRFWF.Ctrl.Data.WFStepActor;
import SRFWF.Ctrl.Data.WFStepData;
import SRFWF.Ctrl.Data.WFTmpStepActor;
import SRFWF.Ctrl.Data.WFUser;
import SRFWF.Ctrl.Data.WFUserAssist;
import SRFWF.Ctrl.Data.WFWorkflow;
import SRFWF.Ctrl.ISRFWFContext;
import java.sql.Timestamp;
import java.util.Vector;
import javax.servlet.ServletContext;

public interface ISRFWFDataCtrl {
    public void Init(ServletContext var1, BaseDBCallerHelperEx var2);

    public CallResult GetWFWorkflow(String var1, WFWorkflow var2);

    public CallResult GetWFInstance(String var1, WFInstance var2);

    public CallResult GetWFIAAction(String var1, String var2, WFIAAction var3);

    public CallResult GetWFUserAssist(String var1, String var2, String var3, WFUserAssist var4);

    public CallResult GetWFUserAssists(WFInstance var1, String var2, String var3, String var4, Vector<WFUserAssist> var5);

    public CallResult GetWFAction(String var1, String var2, WFAction var3);

    public CallResult GetWFStepDataCount(String var1, String var2);

    public CallResult GetWFStepActorCount(String var1);

    public CallResult GetWFStepActor(String var1, Vector<WFStepActor> var2);

    public CallResult GetWFStepData(String var1, Vector<WFStepData> var2);

    public CallResult GetWFStepRoleCount(String var1);

    public CallResult RemoveNoDataWFStepActor(String var1, String var2);

    public CallResult GetWFInstance(String var1, String var2, String var3, String var4, String var5, WFInstance var6);

    public CallResult GetWFUserData(String var1, BaseDataEntity var2);

    public CallResult GetWFUserData(WFWorkflow var1, WFParam var2, BaseDataEntity var3);

    public CallResult UpdateWFUserDataRunStep(WFInstance var1, String var2, String var3);

    public CallResult AddWFInstance(WFInstance var1, String var2);

    public CallResult FinishWFInstance(WFInstance var1, String var2);

    public CallResult ResetWFInstance(WFInstance var1, String var2);

    public CallResult ErrorWFInstance(WFInstance var1, String var2, String var3);

    public CallResult RemoveWFInstance(WFInstance var1, String var2);

    public CallResult UserCloseWFInstance(WFInstance var1, String var2);

    public CallResult AddWFStep(WFStep var1, String var2);

    public CallResult AddWFStepData(WFStepData var1, String var2);

    public CallResult TestWFStepData(WFStepData var1, String var2);

    public CallResult FinishWFStep(WFStep var1, String var2);

    public CallResult AddWFStepActor(WFStepActor var1, String var2);

    public CallResult AddWFIAAction(WFIAAction var1, String var2);

    public CallResult AddWFTmpStepActors(Vector<WFTmpStepActor> var1, String var2);

    public CallResult RemoveWFTmpStepActors(String var1, String var2);

    public CallResult SendWFStepActorInformMsg(Vector<String> var1, WFInstance var2, String var3, int var4);

    public CallResult CalcTimeout(Timestamp var1, String var2, int var3, String var4);

    public CallResult TestIAAction(String var1, String var2, String var3);

    public CallResult ExecRawSql(String var1);

    public CallResult GetWFActor(String var1, WFActor var2);

    public CallResult GetWFUserGroupDetail(String var1, Vector<WFUser> var2);

    public CallResult GetWFSystemUser(ISRFWFContext var1, String var2, Vector<WFUser> var3);

    public boolean isMultiUse();
}

