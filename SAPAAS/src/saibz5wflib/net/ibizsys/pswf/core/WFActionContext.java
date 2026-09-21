/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.psrt.srv.wf.entity.WFInstance
 *  net.ibizsys.psrt.srv.wf.entity.WFStep
 *  net.ibizsys.psrt.srv.wf.entity.WFStepActor
 *  net.ibizsys.pswf.core.IWFModel
 *  net.ibizsys.pswf.core.IWFProcessModel
 *  net.ibizsys.pswf.core.IWFVersionModel
 *  net.ibizsys.pswf.core.WFActionParam
 *  net.ibizsys.pswf.core.WFActionResult
 */
package net.ibizsys.pswf.core;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.wf.entity.WFInstance;
import net.ibizsys.psrt.srv.wf.entity.WFStep;
import net.ibizsys.psrt.srv.wf.entity.WFStepActor;
import net.ibizsys.pswf.core.IWFActionContext2;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFProcessModel;
import net.ibizsys.pswf.core.IWFVersionModel;
import net.ibizsys.pswf.core.WFActionParam;
import net.ibizsys.pswf.core.WFActionResult;

public class WFActionContext
implements IWFActionContext2 {
    private WFActionParam wfActionParam = null;
    private String strOpPersonId = null;
    private String strOpPersonName = null;
    private IEntity activeEntity = null;
    private IWFVersionModel iWFVersionModel = null;
    private IWFModel iWFModel = null;
    private boolean bThreadMode = false;
    private WFStep activeWFStep = null;
    private WFInstance activeWFInstance = null;
    private int nMaxLoopCount = 100;
    private String strCurNext = "";
    private IWFProcessModel curWFProcessModel = null;
    private boolean bFinishInteractiveProcess = false;
    private HashMap<String, String> nextIAStepActorMap = new HashMap();
    private HashMap<String, Object> attributes = null;
    private StringBuilderEx runInfo = new StringBuilderEx();
    private String strUserTag = "";
    private String strUserTag2 = "";
    private boolean bEnableNextIAStepActors = false;
    private ArrayList<WFStepActor> rollbackStepActors = new ArrayList();

    public WFActionParam getWFActionParam() {
        return this.wfActionParam;
    }

    public void setWFActionParam(WFActionParam wfActionParam) {
        this.wfActionParam = wfActionParam;
    }

    public String getOpPersonId() {
        if (StringHelper.isNullOrEmpty((String)this.strOpPersonId)) {
            return this.getWFActionParam().getOpPersonId();
        }
        return this.strOpPersonId;
    }

    public void setOpPersonId(String strOpPersonId) {
        this.strOpPersonId = strOpPersonId;
    }

    @Override
    public String getOpPersonName() {
        if (StringHelper.isNullOrEmpty((String)this.strOpPersonName)) {
            return this.getWFActionParam().getOpPersonName();
        }
        return this.strOpPersonName;
    }

    public void setOpPersonName(String strOpPersonName) {
        this.strOpPersonName = strOpPersonName;
    }

    public IEntity getActiveEntity() {
        return this.activeEntity;
    }

    public void setActiveEntity(IEntity activeEntity) {
        this.activeEntity = activeEntity;
    }

    public IWFVersionModel getWFVersionModel() {
        return this.iWFVersionModel;
    }

    public void setWFVersionModel(IWFVersionModel iWFVersionModel) {
        this.iWFVersionModel = iWFVersionModel;
    }

    public boolean isThreadMode() {
        return this.bThreadMode;
    }

    public void setThreadMode(boolean bThreadMode) {
        this.bThreadMode = bThreadMode;
    }

    public WFStep getActiveWFStep() {
        return this.activeWFStep;
    }

    public void setActiveWFStep(WFStep activeWFStep) {
        this.activeWFStep = activeWFStep;
    }

    @Override
    public WFInstance getActiveWFInstance() {
        return this.activeWFInstance;
    }

    public void setActiveWFInstance(WFInstance activeWFInstance) {
        this.activeWFInstance = activeWFInstance;
    }

    public int getMaxLoopCount() {
        return this.nMaxLoopCount;
    }

    public void setMaxLoopCount(int maxLoopCount) {
        this.nMaxLoopCount = maxLoopCount;
    }

    public String getCurNext() {
        return this.strCurNext;
    }

    public void setCurNext(String strCurNext) {
        this.strCurNext = strCurNext;
    }

    public IWFProcessModel getCurWFProcessModel() {
        return this.curWFProcessModel;
    }

    public void setCurWFProcessModel(IWFProcessModel curWFProcessModel) {
        this.curWFProcessModel = curWFProcessModel;
    }

    public boolean isFinishInteractiveProcess() {
        return this.bFinishInteractiveProcess;
    }

    public void setFinishInteractiveProcess(boolean bFinishInteractiveProcess) {
        this.bFinishInteractiveProcess = bFinishInteractiveProcess;
    }

    public Object getAttribute(String strName) {
        if (this.attributes == null) {
            return null;
        }
        return this.attributes.get(strName);
    }

    public void setAttribute(String strName, Object objValue) {
        if (this.attributes == null) {
            this.attributes = new HashMap();
        }
        this.attributes.put(strName, objValue);
    }

    public void appendReturnInfo(String strInfo) {
        if (!StringHelper.isNullOrEmpty((String)this.runInfo.toString())) {
            this.runInfo.append("\r\n");
        }
        this.runInfo.append(strInfo);
    }

    public StringBuilderEx getReturnInfoSB() {
        return this.runInfo;
    }

    public String getUserTag() {
        return this.strUserTag;
    }

    public void setUserTag(String strUserTag) {
        this.strUserTag = strUserTag;
    }

    public String getUserTag2() {
        return this.strUserTag2;
    }

    public void setUserTag2(String strUserTag2) {
        this.strUserTag2 = strUserTag2;
    }

    public HashMap<String, String> getNextIAStepActorMap() {
        return this.nextIAStepActorMap;
    }

    public WFActionResult createWFActionResult() {
        WFActionResult wfActionResult = new WFActionResult();
        if (this.getActiveWFInstance() != null) {
            wfActionResult.setInstanceId(this.getActiveWFInstance().getWFInstanceId());
        }
        wfActionResult.setReturnInfo(this.getReturnInfoSB().toString());
        return wfActionResult;
    }

    public String getActiveWFInstanceId() {
        return this.getActiveWFInstance().getWFInstanceId();
    }

    public ArrayList<WFStepActor> getRollbackStepActors() {
        return this.rollbackStepActors;
    }

    public boolean isEnableNextIAStepActors() {
        return this.bEnableNextIAStepActors;
    }

    public void setEnableNextIAStepActors(boolean bEnableNextIAStepActors) {
        this.bEnableNextIAStepActors = bEnableNextIAStepActors;
    }

    public IWFModel getWFModel() {
        return this.iWFModel;
    }

    public void setWFModel(IWFModel iWFModel) {
        this.iWFModel = iWFModel;
    }
}

