/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.psrt.srv.dynasys.entity.DSDynaWFVer
 *  net.ibizsys.pswf.core.WFVersionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pswf.core;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaWFVer;
import net.ibizsys.pswf.core.DynaWFDEActionProcessModel;
import net.ibizsys.pswf.core.DynaWFEmbedWFProcessModel;
import net.ibizsys.pswf.core.DynaWFEmbedWFReturnModel;
import net.ibizsys.pswf.core.DynaWFEndProcessModel;
import net.ibizsys.pswf.core.DynaWFExclusiveGatewayProcessModel;
import net.ibizsys.pswf.core.DynaWFInclusiveGatewayProcessModel;
import net.ibizsys.pswf.core.DynaWFInteractiveLinkModel;
import net.ibizsys.pswf.core.DynaWFInteractiveProcessModel;
import net.ibizsys.pswf.core.DynaWFParallelGatewayProcessModel;
import net.ibizsys.pswf.core.DynaWFParallelSubWFProcessModel;
import net.ibizsys.pswf.core.DynaWFRouteLinkModel;
import net.ibizsys.pswf.core.DynaWFStartProcessModel;
import net.ibizsys.pswf.core.DynaWFTimeoutLinkModel;
import net.ibizsys.pswf.core.DynaWFTimerEventProcessModel;
import net.ibizsys.pswf.core.IDynaWFLinkModel;
import net.ibizsys.pswf.core.IDynaWFModel;
import net.ibizsys.pswf.core.IDynaWFProcessModel;
import net.ibizsys.pswf.core.IDynaWFVersionModel;
import net.ibizsys.pswf.core.WFVersionModelBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class DynaWFVersionModelBase
extends WFVersionModelBase
implements IDynaWFVersionModel {
    private static final Log log = LogFactory.getLog(DynaWFVersionModelBase.class);
    private String strDynaInstId = null;
    private ObjectNode modelJsonObject = null;
    private IDynaWFModel iDynaWFModel = null;
    private DSDynaWFVer dsDynaWFVer = new DSDynaWFVer();

    @Override
    public void init(IDynaWFModel iDynaWFModel, IEntity iEntity) throws Exception {
        iEntity.copyTo((IDataObject)this.dsDynaWFVer, false);
        this.iDynaWFModel = iDynaWFModel;
        this.setId(this.dsDynaWFVer.getDSDynaWFVerId());
        this.setName(this.dsDynaWFVer.getDSDynaWFVerName());
        this.strDynaInstId = this.dsDynaWFVer.getDynaSysInstId();
        this.setWFVersion(DataObject.getIntegerValue((Object)this.dsDynaWFVer.getWFVersion(), (Integer)1));
        this.init(iDynaWFModel);
        if (!StringHelper.isNullOrEmpty((String)this.dsDynaWFVer.getDynaModel())) {
            ObjectNode objectNode = (ObjectNode)JsonNodeHelper.fromString((String)this.dsDynaWFVer.getDynaModel());
            this.loadJsonObject(objectNode);
        }
    }

    @Override
    public void loadJsonObject(ObjectNode jsonObject) throws Exception {
        this.modelJsonObject = jsonObject;
        this.onLoadJsonObject(jsonObject);
    }

    protected void onLoadJsonObject(ObjectNode jsonObject) throws Exception {
        String strBPMNModel;
        int i;
        int nSize;
        ArrayNode arrayNode = JsonNodeHelper.getArray((ObjectNode)jsonObject, (String)"wfprocesses");
        if (arrayNode != null) {
            nSize = arrayNode.size();
            i = 0;
            while (i < nSize) {
                ObjectNode processNode = (ObjectNode)arrayNode.get(i);
                this.registerWFProcessModel(this.loadWFProcessModel(processNode));
                ++i;
            }
        }
        if ((arrayNode = JsonNodeHelper.getArray((ObjectNode)jsonObject, (String)"wflinks")) != null) {
            nSize = arrayNode.size();
            i = 0;
            while (i < nSize) {
                ObjectNode linkNode = (ObjectNode)arrayNode.get(i);
                this.registerWFLinkModel(this.loadWFLinkModel(linkNode));
                ++i;
            }
        }
        if (!StringHelper.isNullOrEmpty((String)(strBPMNModel = JsonNodeHelper.getString((ObjectNode)jsonObject, (String)"bpmnmodel", null)))) {
            this.setBPMNModel(strBPMNModel);
        }
    }

    protected IDynaWFProcessModel loadWFProcessModel(ObjectNode wfProcessModelNode) throws Exception {
        String strItemType = JsonNodeHelper.getString((ObjectNode)wfProcessModelNode, (String)"type", null);
        if (StringHelper.isNullOrEmpty((String)strItemType)) {
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u5904\u7406\u7c7b\u578b"));
        }
        IDynaWFProcessModel iDynaWFProcessModel = this.createDynaWFProcessModel(strItemType);
        iDynaWFProcessModel.init(this, wfProcessModelNode);
        return iDynaWFProcessModel;
    }

    public IDynaWFProcessModel createDynaWFProcessModel(String strType) throws Exception {
        if (StringHelper.compare((String)strType, (String)"START", (boolean)true) == 0) {
            return new DynaWFStartProcessModel();
        }
        if (StringHelper.compare((String)strType, (String)"END", (boolean)true) == 0) {
            return new DynaWFEndProcessModel();
        }
        if (StringHelper.compare((String)strType, (String)"EMBED", (boolean)true) == 0) {
            return new DynaWFEmbedWFProcessModel();
        }
        if (StringHelper.compare((String)strType, (String)"INTERACTIVE", (boolean)true) == 0) {
            return new DynaWFInteractiveProcessModel();
        }
        if (StringHelper.compare((String)strType, (String)"EXCLUSIVEGATEWAY", (boolean)true) == 0) {
            return new DynaWFExclusiveGatewayProcessModel();
        }
        if (StringHelper.compare((String)strType, (String)"INCLUSIVEGATEWAY", (boolean)true) == 0) {
            return new DynaWFInclusiveGatewayProcessModel();
        }
        if (StringHelper.compare((String)strType, (String)"PARALLEL", (boolean)true) == 0) {
            return new DynaWFParallelSubWFProcessModel();
        }
        if (StringHelper.compare((String)strType, (String)"PARALLELGATEWAY", (boolean)true) == 0) {
            return new DynaWFParallelGatewayProcessModel();
        }
        if (StringHelper.compare((String)strType, (String)"PROCESS", (boolean)true) == 0) {
            return new DynaWFDEActionProcessModel();
        }
        if (StringHelper.compare((String)strType, (String)"TIMEREVENT", (boolean)true) == 0) {
            return new DynaWFTimerEventProcessModel();
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u5de5\u4f5c\u6d41\u5904\u7406\u7c7b\u578b[%1$s]", (Object)strType));
    }

    protected IDynaWFLinkModel loadWFLinkModel(ObjectNode wfLinkModelNode) throws Exception {
        String strItemType = JsonNodeHelper.getString((ObjectNode)wfLinkModelNode, (String)"type", null);
        if (StringHelper.isNullOrEmpty((String)strItemType)) {
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u8fde\u63a5\u7c7b\u578b"));
        }
        IDynaWFLinkModel iDynaWFLinkModel = this.createDynaWFLinkModel(strItemType);
        iDynaWFLinkModel.init(this, wfLinkModelNode);
        return iDynaWFLinkModel;
    }

    public IDynaWFLinkModel createDynaWFLinkModel(String strType) throws Exception {
        if (StringHelper.compare((String)strType, (String)"ROUTE", (boolean)true) == 0) {
            return new DynaWFRouteLinkModel();
        }
        if (StringHelper.compare((String)strType, (String)"IAACTION", (boolean)true) == 0) {
            return new DynaWFInteractiveLinkModel();
        }
        if (StringHelper.compare((String)strType, (String)"TIMEOUT", (boolean)true) == 0) {
            return new DynaWFTimeoutLinkModel();
        }
        if (StringHelper.compare((String)strType, (String)"WFRETURN", (boolean)true) == 0) {
            return new DynaWFEmbedWFReturnModel();
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u5de5\u4f5c\u6d41\u8fde\u63a5\u7c7b\u578b[%1$s]", (Object)strType));
    }

    @Override
    public String getDynaInstId() {
        return this.strDynaInstId;
    }
}

