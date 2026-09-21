/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFDEActionProcessParamModel
 *  net.ibizsys.pswf.core.WFDEActionProcessModelBase
 *  net.ibizsys.pswf.core.WFDEActionProcessParamModel
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
import net.ibizsys.pswf.core.IWFDEActionProcessParamModel;
import net.ibizsys.pswf.core.WFDEActionProcessModelBase;
import net.ibizsys.pswf.core.WFDEActionProcessParamModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DynaWFDEActionProcessModel
extends WFDEActionProcessModelBase
implements IDynaWFProcessModel {
    private static final Log log = LogFactory.getLog(DynaWFDEActionProcessModel.class);
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
        String strDEActionName;
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
        if (!StringHelper.isNullOrEmpty((String)(strDEActionName = JsonNodeHelper.getString((ObjectNode)jsonObject, (String)"deactionname", null)))) {
            this.setDEActionName(strDEActionName);
        }
        if ((arrayNode = JsonNodeHelper.getArray((ObjectNode)jsonObject, (String)"wfprocparams")) != null) {
            int i = 0;
            while (i < arrayNode.size()) {
                ObjectNode wfProcParamNode = (ObjectNode)arrayNode.get(i);
                WFDEActionProcessParamModel procParam = new WFDEActionProcessParamModel();
                String strDstField = JsonNodeHelper.getString((ObjectNode)wfProcParamNode, (String)"customdstdefname", (String)"");
                if (StringHelper.isNullOrEmpty((String)strDstField)) {
                    strDstField = JsonNodeHelper.getString((ObjectNode)wfProcParamNode, (String)"defname", (String)"");
                }
                procParam.setDstField(strDstField);
                procParam.setSrcValueType(JsonNodeHelper.getString((ObjectNode)wfProcParamNode, (String)"srcvaluetype", (String)""));
                procParam.setSrcValue(JsonNodeHelper.getString((ObjectNode)wfProcParamNode, (String)"srcvalue", (String)""));
                this.registerWFDEActionProcessParamModel((IWFDEActionProcessParamModel)procParam);
                ++i;
            }
        }
        this.setTopPos(JsonNodeHelper.getInt((ObjectNode)jsonObject, (String)"toppos", (int)0));
        this.setLeftPos(JsonNodeHelper.getInt((ObjectNode)jsonObject, (String)"leftpos", (int)0));
    }
}

