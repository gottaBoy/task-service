/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFLinkModel
 */
package net.ibizsys.pswf.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFInteractiveLinkModel;
import net.ibizsys.pswf.core.IWFInteractiveProcessModel;
import net.ibizsys.pswf.core.IWFLinkModel;
import net.ibizsys.pswf.core.IWFProcRoleModel;
import net.ibizsys.pswf.core.WFProcessModelBase;

public abstract class WFInteractiveProcessModelBase
extends WFProcessModelBase
implements IWFInteractiveProcessModel {
    protected ArrayList<IWFProcRoleModel> wfProcRoleModelList = new ArrayList();
    private ArrayList<IWFInteractiveLinkModel> wfInteractiveLinkModelList = new ArrayList();
    private HashMap<String, IWFInteractiveLinkModel> wfInteractiveLinkModelMap = new HashMap();
    private ArrayList<String> udActorList = new ArrayList();
    private boolean bEditable = false;
    private String strMemoField = "";
    private boolean bSendInform = false;
    private String strMsgTemplateId = "";
    private int nMsgType = 0;
    private String strMultiInstMode = "NONE";

    protected void registerWFProcRoleModel(IWFProcRoleModel iWFProcRoleModel) throws Exception {
        this.wfProcRoleModelList.add(iWFProcRoleModel);
    }

    protected void registerUDActor(String strUDActor) throws Exception {
        this.udActorList.add(strUDActor);
    }

    @Override
    public void registerWFLinkModel(IWFLinkModel iWFLinkModel) throws Exception {
        super.registerWFLinkModel(iWFLinkModel);
        if (iWFLinkModel instanceof IWFInteractiveLinkModel) {
            IWFInteractiveLinkModel iWFInteractiveLinkModel = (IWFInteractiveLinkModel)iWFLinkModel;
            this.wfInteractiveLinkModelList.add(iWFInteractiveLinkModel);
            this.wfInteractiveLinkModelMap.put(iWFInteractiveLinkModel.getName(), iWFInteractiveLinkModel);
        }
    }

    @Override
    public Iterator<IWFInteractiveLinkModel> getWFInteractiveLinkModels() {
        return this.wfInteractiveLinkModelList.iterator();
    }

    @Override
    public IWFInteractiveLinkModel getWFInteractiveLinkModel(String strName, boolean bTryMode) throws Exception {
        IWFInteractiveLinkModel iWFInteractiveLinkModel = this.wfInteractiveLinkModelMap.get(strName);
        if (iWFInteractiveLinkModel == null && !bTryMode) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u4ea4\u4e92\u8fde\u63a5\uff0c\u6807\u8bc6\u4e3a[%1$s]", (Object)strName));
        }
        return iWFInteractiveLinkModel;
    }

    @Override
    public Iterator<IWFProcRoleModel> getWFProcRoleModels() {
        return this.wfProcRoleModelList.iterator();
    }

    @Override
    public boolean isSendInform() {
        return this.bSendInform;
    }

    protected void setSendInform(boolean bSendInform) {
        this.bSendInform = bSendInform;
    }

    @Override
    public String getMsgTemplateId() {
        return this.strMsgTemplateId;
    }

    protected void setMsgTemplateId(String strMsgTemplateId) {
        this.strMsgTemplateId = strMsgTemplateId;
    }

    @Override
    public int getMsgType() {
        return this.nMsgType;
    }

    protected void setMsgType(int nMsgType) {
        this.nMsgType = nMsgType;
    }

    @Override
    public boolean isActorIAActionControl() {
        return false;
    }

    @Override
    public Iterator<String> getUDActors() {
        return this.udActorList.iterator();
    }

    @Override
    public boolean isSuspendProcess() {
        return true;
    }

    @Override
    public boolean isEditable() {
        return this.bEditable;
    }

    protected void setEditable(boolean bEditable) {
        this.bEditable = bEditable;
    }

    public String getWFProcessType() {
        return "INTERACTIVE";
    }

    @Override
    public String getMemoField() {
        return this.strMemoField;
    }

    protected void setMemoField(String strMemoField) {
        this.strMemoField = strMemoField;
    }

    @Override
    public String getMultiInstMode() {
        return this.strMultiInstMode;
    }

    protected void setMultiInstMode(String strMultiInstMode) {
        this.strMultiInstMode = strMultiInstMode;
    }
}

