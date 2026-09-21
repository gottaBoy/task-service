/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.psrt.srv.wf.entity.WFAction
 *  net.ibizsys.psrt.srv.wf.entity.WFActor
 *  net.ibizsys.psrt.srv.wf.entity.WFIAAction
 *  net.ibizsys.psrt.srv.wf.entity.WFInstance
 *  net.ibizsys.psrt.srv.wf.entity.WFStep
 *  net.ibizsys.psrt.srv.wf.entity.WFStepActor
 *  net.ibizsys.psrt.srv.wf.entity.WFStepData
 *  net.ibizsys.psrt.srv.wf.entity.WFStepInst
 *  net.ibizsys.psrt.srv.wf.entity.WFTmpStepActor
 *  net.ibizsys.psrt.srv.wf.entity.WFUser
 *  net.ibizsys.psrt.srv.wf.entity.WFUserAssist
 *  net.ibizsys.pswf.core.IWFModel
 *  net.ibizsys.pswf.core.IWFProcessModel
 *  net.ibizsys.pswf.core.WFActionParam
 */
package net.ibizsys.pswf.core;

import java.sql.Timestamp;
import java.util.ArrayList;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.psrt.srv.wf.entity.WFAction;
import net.ibizsys.psrt.srv.wf.entity.WFActor;
import net.ibizsys.psrt.srv.wf.entity.WFIAAction;
import net.ibizsys.psrt.srv.wf.entity.WFInstance;
import net.ibizsys.psrt.srv.wf.entity.WFStep;
import net.ibizsys.psrt.srv.wf.entity.WFStepActor;
import net.ibizsys.psrt.srv.wf.entity.WFStepData;
import net.ibizsys.psrt.srv.wf.entity.WFStepInst;
import net.ibizsys.psrt.srv.wf.entity.WFTmpStepActor;
import net.ibizsys.psrt.srv.wf.entity.WFUser;
import net.ibizsys.psrt.srv.wf.entity.WFUserAssist;
import net.ibizsys.pswf.core.IWFActionContext2;
import net.ibizsys.pswf.core.IWFEmbedWFProcessModel;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFParallelSubWFProcessModel;
import net.ibizsys.pswf.core.IWFProcessModel;
import net.ibizsys.pswf.core.WFActionParam;

public interface IWFDataCtrl {
    public static final String USERENTITY_ORGID = "srforgid";
    public static final String USERENTITY_ORGNAME = "srforgname";

    public void init(IWFModel var1) throws Exception;

    public WFInstance getWFInstance(IWFActionContext2 var1, WFInstance var2, boolean var3) throws Exception;

    public void getWFIAAction(IWFActionContext2 var1, String var2, String var3, WFIAAction var4) throws Exception;

    public void getWFUserAssist(IWFActionContext2 var1, String var2, String var3, WFUserAssist var4) throws Exception;

    public void getWFUserAssists(IWFActionContext2 var1, String var2, String var3, ArrayList<WFUserAssist> var4) throws Exception;

    public void getWFAction(String var1, String var2, WFAction var3) throws Exception;

    public int getWFStepDataCount(IWFActionContext2 var1, String var2, String var3) throws Exception;

    public int getWFStepActorCount(IWFActionContext2 var1, String var2) throws Exception;

    public void getWFStepActors(IWFActionContext2 var1, String var2, ArrayList<WFStepActor> var3) throws Exception;

    public void getWFStepDatas(IWFActionContext2 var1, String var2, ArrayList<WFStepData> var3) throws Exception;

    public int getWFStepRoleCount(IWFActionContext2 var1, String var2) throws Exception;

    public void removeNoDataWFStepActor(IWFActionContext2 var1, String var2, String var3) throws Exception;

    public void getWFUserEntity(IWFActionContext2 var1, IEntity var2) throws Exception;

    public void updateWFUserDataRunStep(IWFActionContext2 var1, String var2) throws Exception;

    public void addWFInstance(IWFActionContext2 var1, WFInstance var2) throws Exception;

    public void finishWFInstance(IWFActionContext2 var1, WFInstance var2) throws Exception;

    public void resetWFInstance(IWFActionContext2 var1, WFInstance var2) throws Exception;

    public void errorWFInstance(IWFActionContext2 var1, WFInstance var2) throws Exception;

    public void removeWFInstance(IWFActionContext2 var1, WFInstance var2) throws Exception;

    public void userCloseWFInstance(IWFActionContext2 var1, WFInstance var2) throws Exception;

    public void addWFStep(IWFActionContext2 var1, WFStep var2) throws Exception;

    public void addWFStepData(IWFActionContext2 var1, WFStepData var2) throws Exception;

    public void testWFStepData(IWFActionContext2 var1, WFStepData var2) throws Exception;

    public void finishWFStep(IWFActionContext2 var1, WFStep var2) throws Exception;

    public boolean addWFStepActor(IWFActionContext2 var1, WFStepActor var2) throws Exception;

    public void addWFIAAction(IWFActionContext2 var1, WFIAAction var2) throws Exception;

    public void addWFTmpStepActors(IWFActionContext2 var1, ArrayList<WFTmpStepActor> var2) throws Exception;

    public void removeWFTmpStepActors(IWFActionContext2 var1, String var2) throws Exception;

    public void sendWFStepActorInformMsg(IWFActionContext2 var1, ArrayList<String> var2, String var3, int var4) throws Exception;

    public Timestamp calcTimeout(Timestamp var1, String var2, int var3, String var4) throws Exception;

    public void testIAAction(String var1, String var2, String var3) throws Exception;

    public void execRawSql(String var1) throws Exception;

    public void getWFActor(IWFActionContext2 var1, WFActor var2) throws Exception;

    public void getWFSystemUser(IWFActionContext2 var1, String var2, ArrayList<WFUser> var3) throws Exception;

    public boolean testStartWF(IWFActionContext2 var1) throws Exception;

    public boolean testRestartWF(IWFActionContext2 var1) throws Exception;

    public boolean testCancelWF(IWFActionContext2 var1) throws Exception;

    public void getEmbedWorkflows(IWFActionContext2 var1, IWFEmbedWFProcessModel var2, ArrayList<WFActionParam> var3) throws Exception;

    public void getParallelSubWFs(IWFActionContext2 var1, IWFParallelSubWFProcessModel var2, ArrayList<WFActionParam> var3) throws Exception;

    public void addWFStepInst(IWFActionContext2 var1, WFStepInst var2) throws Exception;

    public void closeWFStepInst(IWFActionContext2 var1, WFStepInst var2) throws Exception;

    public int getWFStepInstCount(IWFActionContext2 var1, String var2, String var3) throws Exception;

    public int getWFStepInstCount(IWFActionContext2 var1, String var2) throws Exception;

    public void getUnfinishedWFStepInsts(IWFActionContext2 var1, String var2, ArrayList<WFStepInst> var3) throws Exception;

    public void updateCurWFStepActors(IWFActionContext2 var1) throws Exception;

    public void markWFStepActorReadFlag(IWFActionContext2 var1, WFStepActor var2) throws Exception;

    public String getEmbedWorkflowReturnValue(IWFActionContext2 var1, WFInstance var2, IEntity var3, IWFProcessModel var4) throws Exception;

    public void addRawWFStepData(IWFActionContext2 var1, WFStepData var2) throws Exception;

    public void getLastWFStepData(IWFActionContext2 var1, WFStepData var2) throws Exception;

    public void cancelStartWFInstance(IWFActionContext2 var1, WFInstance var2) throws Exception;
}

