/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFInteractiveProcessModel
 *  net.ibizsys.pswf.core.IWFProcRoleModel
 *  net.ibizsys.pswf.core.WFInteractiveProcessModelBase
 *  net.ibizsys.pswf.core.WFProcRoleModel
 *  net.ibizsys.pswf.core.WFProcSysActorRoleModel
 *  net.ibizsys.pswf.core.WFProcUDActorRoleModel
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pswf.core;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IDynaWFProcessModel;
import net.ibizsys.pswf.core.IDynaWFVersionModel;
import net.ibizsys.pswf.core.IWFInteractiveProcessModel;
import net.ibizsys.pswf.core.IWFProcRoleModel;
import net.ibizsys.pswf.core.WFInteractiveProcessModelBase;
import net.ibizsys.pswf.core.WFProcRoleModel;
import net.ibizsys.pswf.core.WFProcSysActorRoleModel;
import net.ibizsys.pswf.core.WFProcUDActorRoleModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DynaWFInteractiveProcessModel
extends WFInteractiveProcessModelBase
implements IDynaWFProcessModel {
    private static final Log log = LogFactory.getLog(DynaWFInteractiveProcessModel.class);
    private ObjectNode modelJsonObject = null;

    @Override
    public void init(IDynaWFVersionModel iDynaWFVersionModel, Object modelObject) throws Exception {
        this.init(iDynaWFVersionModel);
        if (modelObject != null && modelObject instanceof ObjectNode) {
            this.loadJsonObject((ObjectNode)modelObject);
            return;
        }
    }

    @Override
    public void loadJsonObject(ObjectNode jsonObject) throws Exception {
        this.modelJsonObject = jsonObject;
        this.onLoadJsonObject(jsonObject);
    }

    protected void onLoadJsonObject(ObjectNode jsonObject) throws Exception {
        ArrayNode arrayNode;
        String strUserData2;
        String strUserData;
        String strModelId;
        String strId = JsonNodeHelper.getString((ObjectNode)jsonObject, (String)"id", null);
        if (StringHelper.isNullOrEmpty((String)strId)) {
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u6d41\u7a0b\u5904\u7406\u6807\u8bc6"));
        }
        this.setId(strId);
        String strName = JsonNodeHelper.getString((ObjectNode)jsonObject, (String)"name", null);
        if (!StringHelper.isNullOrEmpty((String)strName)) {
            this.setName(strName);
        }
        if (!StringHelper.isNullOrEmpty((String)(strModelId = JsonNodeHelper.getString((ObjectNode)jsonObject, (String)"modelid", null)))) {
            this.setBPMNModelId(strModelId);
        }
        this.setTopPos(JsonNodeHelper.getInt((ObjectNode)jsonObject, (String)"toppos", (int)0));
        this.setLeftPos(JsonNodeHelper.getInt((ObjectNode)jsonObject, (String)"leftpos", (int)0));
        this.setWFStepValue(JsonNodeHelper.getString((ObjectNode)jsonObject, (String)"wfstepvalue", null));
        this.setEditable(JsonNodeHelper.getInt((ObjectNode)jsonObject, (String)"editable", (int)0) == 1);
        this.setAsynchronousProcess(JsonNodeHelper.getInt((ObjectNode)jsonObject, (String)"asyncmode", (int)0) == 1);
        String strMemoField = JsonNodeHelper.getString((ObjectNode)jsonObject, (String)"memofield", null);
        if (!StringHelper.isNullOrEmpty((String)strMemoField)) {
            this.setMemoField(strMemoField);
        }
        if (!StringHelper.isNullOrEmpty((String)(strUserData = JsonNodeHelper.getString((ObjectNode)jsonObject, (String)"userdata", null)))) {
            this.setUserData(strUserData);
        }
        if (!StringHelper.isNullOrEmpty((String)(strUserData2 = JsonNodeHelper.getString((ObjectNode)jsonObject, (String)"userdata2", null)))) {
            this.setUserData2(strUserData2);
        }
        if (JsonNodeHelper.getInt((ObjectNode)jsonObject, (String)"sendinform", (int)0) == 1) {
            this.setSendInform(true);
            this.setMsgTemplateId(JsonNodeHelper.getString((ObjectNode)jsonObject, (String)"sysmsgtemplid", null));
            this.setMsgType(JsonNodeHelper.getInt((ObjectNode)jsonObject, (String)"msgtype", (int)0));
        }
        if ((arrayNode = JsonNodeHelper.getArray((ObjectNode)jsonObject, (String)"wfprocroles")) != null) {
            int i = 0;
            while (i < arrayNode.size()) {
                WFProcRoleModel wfProcRoleModel;
                ObjectNode wfProcRoleNode = (ObjectNode)arrayNode.get(i);
                String strRoleType = JsonNodeHelper.getString((ObjectNode)wfProcRoleNode, (String)"roletype", (String)"");
                if (StringHelper.compare((String)strRoleType, (String)"WFROLE", (boolean)true) == 0) {
                    wfProcRoleModel = new WFProcRoleModel();
                    wfProcRoleModel.setWFRoleId(JsonNodeHelper.getString((ObjectNode)wfProcRoleNode, (String)"wfroleid", (String)""));
                    wfProcRoleModel.setId(JsonNodeHelper.getString((ObjectNode)wfProcRoleNode, (String)"id", (String)""));
                    wfProcRoleModel.setName(JsonNodeHelper.getString((ObjectNode)wfProcRoleNode, (String)"name", (String)""));
                    wfProcRoleModel.setWFProcRoleType(strRoleType);
                    wfProcRoleModel.init((IWFInteractiveProcessModel)this);
                    this.registerWFProcRoleModel((IWFProcRoleModel)wfProcRoleModel);
                } else if (StringHelper.compare((String)strRoleType, (String)"UDACTOR", (boolean)true) == 0) {
                    wfProcRoleModel = new WFProcUDActorRoleModel();
                    wfProcRoleModel.setUDField(JsonNodeHelper.getString((ObjectNode)wfProcRoleNode, (String)"udfield", (String)""));
                    wfProcRoleModel.setId(JsonNodeHelper.getString((ObjectNode)wfProcRoleNode, (String)"id", (String)""));
                    wfProcRoleModel.setName(JsonNodeHelper.getString((ObjectNode)wfProcRoleNode, (String)"name", (String)""));
                    wfProcRoleModel.setWFProcRoleType(strRoleType);
                    wfProcRoleModel.init((IWFInteractiveProcessModel)this);
                    this.registerWFProcRoleModel((IWFProcRoleModel)wfProcRoleModel);
                } else {
                    wfProcRoleModel = new WFProcSysActorRoleModel();
                    wfProcRoleModel.setId(JsonNodeHelper.getString((ObjectNode)wfProcRoleNode, (String)"id", (String)""));
                    wfProcRoleModel.setName(JsonNodeHelper.getString((ObjectNode)wfProcRoleNode, (String)"name", (String)""));
                    wfProcRoleModel.setWFProcRoleType(strRoleType);
                    wfProcRoleModel.init((IWFInteractiveProcessModel)this);
                    this.registerWFProcRoleModel((IWFProcRoleModel)wfProcRoleModel);
                }
                ++i;
            }
        }
    }
}

