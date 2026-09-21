/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IActionContext
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.demodel.DELogicModelBase
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.JIT.DEModel;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.JIT.DEModel.IPSJITDELogicModel;
import SA.SRFDA.PS.Core.JIT.DEModel.IPSJITDELogicNodeModel;
import SA.SRFDA.PS.Core.JIT.DEModel.IPSJITDEModel;
import SA.SRFDA.PS.Core.JIT.DEModel.PSJITDELogicBeginNodeModel;
import SA.SRFDA.PS.Core.JIT.DEModel.PSJITDELogicDEActionNodeModel;
import SA.SRFDA.PS.Core.JIT.DEModel.PSJITDELogicPrepareParamNodeModel;
import SA.SRFDA.PS.Core.JIT.DEModel.PSJITDELogicRawSqlCallNodeModel;
import SA.SRFDA.PS.Core.JIT.DEModel.PSJITDELogicRawSqlLoopCallNodeModel;
import SA.SRFDA.PS.Core.JIT.DEModel.PSJITDELogicStartWFNodeModel;
import SA.SRFDA.PS.Core.JIT.Entity.PSJITEntity;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.paas.util.StringHelper;

public class PSJITDELogicModel
extends DELogicModelBase<PSJITEntity>
implements IPSJITDELogicModel<PSJITEntity> {
    private IPSJITDEModel iPSJITDEModel = null;
    private IPSDELogic iPSDELogic = null;
    private HashMap<String, IPSJITDELogicNodeModel> psJITDELogicNodeModelMap = new HashMap();

    public void init(IPSJITDEModel iPSJITDEModel, IPSDELogic iPSDELogic) throws Exception {
        this.iPSJITDEModel = iPSJITDEModel;
        this.iPSDELogic = iPSDELogic;
        this.setDefaultParamName(this.getPSDELogic().getDefaultParamName());
        this.init((IDataEntity)iPSJITDEModel);
    }

    protected void onInit() throws Exception {
        this.preparePSJITDELogicNodeModels();
        super.onInit();
    }

    protected void preparePSJITDELogicNodeModels() throws Exception {
        Iterator<? extends IPSDELogicNode> psDELogicNodes = this.iPSDELogic.getPSDELogicNodes();
        while (psDELogicNodes.hasNext()) {
            IPSDELogicNode iPSDELogicNode = psDELogicNodes.next();
            this.registerPSDELogicNode(iPSDELogicNode);
        }
    }

    protected void registerPSDELogicNode(IPSDELogicNode iPSDELogicNode) throws Exception {
        IPSJITDELogicNodeModel iPSJITDELogicNodeModel = this.createPSJITDELogicNodeModel(iPSDELogicNode);
        this.psJITDELogicNodeModelMap.put(iPSJITDELogicNodeModel.getId(), iPSJITDELogicNodeModel);
    }

    protected IPSJITDELogicNodeModel createPSJITDELogicNodeModel(IPSDELogicNode iPSDELogicNode) throws Exception {
        if (StringHelper.compare((String)iPSDELogicNode.getLogicNodeType(), (String)"BEGIN", (boolean)false) == 0) {
            PSJITDELogicBeginNodeModel psJITDELogicBeginNodeModel = new PSJITDELogicBeginNodeModel();
            psJITDELogicBeginNodeModel.init(this, iPSDELogicNode);
            return psJITDELogicBeginNodeModel;
        }
        if (StringHelper.compare((String)iPSDELogicNode.getLogicNodeType(), (String)"DEACTION", (boolean)false) == 0) {
            PSJITDELogicDEActionNodeModel psJITDELogicDEActionNodeModel = new PSJITDELogicDEActionNodeModel();
            psJITDELogicDEActionNodeModel.init(this, iPSDELogicNode);
            return psJITDELogicDEActionNodeModel;
        }
        if (StringHelper.compare((String)iPSDELogicNode.getLogicNodeType(), (String)"PREPAREPARAM", (boolean)false) == 0) {
            PSJITDELogicPrepareParamNodeModel psJITDELogicPrepareParamNodeModel = new PSJITDELogicPrepareParamNodeModel();
            psJITDELogicPrepareParamNodeModel.init(this, iPSDELogicNode);
            return psJITDELogicPrepareParamNodeModel;
        }
        if (StringHelper.compare((String)iPSDELogicNode.getLogicNodeType(), (String)"RAWSQLANDLOOPCALL", (boolean)false) == 0) {
            PSJITDELogicRawSqlLoopCallNodeModel psJITDELogicRawSqlLoopCallNodeModel = new PSJITDELogicRawSqlLoopCallNodeModel();
            psJITDELogicRawSqlLoopCallNodeModel.init(this, iPSDELogicNode);
            return psJITDELogicRawSqlLoopCallNodeModel;
        }
        if (StringHelper.compare((String)iPSDELogicNode.getLogicNodeType(), (String)"RAWSQLCALL", (boolean)false) == 0) {
            PSJITDELogicRawSqlCallNodeModel psJITDELogicRawSqlCallNodeModel = new PSJITDELogicRawSqlCallNodeModel();
            psJITDELogicRawSqlCallNodeModel.init(this, iPSDELogicNode);
            return psJITDELogicRawSqlCallNodeModel;
        }
        if (StringHelper.compare((String)iPSDELogicNode.getLogicNodeType(), (String)"STARTWF", (boolean)false) == 0) {
            PSJITDELogicStartWFNodeModel psJITDELogicStartWFNodeModel = new PSJITDELogicStartWFNodeModel();
            psJITDELogicStartWFNodeModel.init(this, iPSDELogicNode);
            return psJITDELogicStartWFNodeModel;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u521b\u5efaJIG\u5b9e\u4f53\u903b\u8f91\u8282\u70b9[%1$s]\uff0c\u7c7b\u578b\u4e3a[%2$s]", (Object)iPSDELogicNode.getName(), (Object)iPSDELogicNode.getLogicNodeType()));
    }

    @Override
    public IPSJITDELogicNodeModel getPSJITDELogicNodeModel(IPSDELogicNode iPSDELogicNode) throws Exception {
        IPSJITDELogicNodeModel iPSJITDELogicNodeModel = this.psJITDELogicNodeModelMap.get(iPSDELogicNode.getId());
        if (iPSJITDELogicNodeModel == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u903b\u8f91\u8282\u70b9[%1$s]", (Object)iPSDELogicNode.getName()));
        }
        return iPSJITDELogicNodeModel;
    }

    @Override
    public IPSJITDEModel<PSJITEntity> getIPSJITDEModel() {
        return this.iPSJITDEModel;
    }

    @Override
    public IPSDELogic getPSDELogic() {
        return this.iPSDELogic;
    }

    public String getId() {
        return this.iPSDELogic.getId();
    }

    public String getName() {
        return this.iPSDELogic.getName();
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        Iterator<? extends IPSDELogicParam> psDELogicParams = this.getPSDELogic().getPSDELogicParams();
        while (psDELogicParams.hasNext()) {
            IPSDELogicParam iPSDELogicParam = psDELogicParams.next();
            if (iPSDELogicParam.isDefault()) continue;
            if (iPSDELogicParam.getParamPSDataEntity() != null) {
                iActionContext.setParam(iPSDELogicParam.getCodeName(), (Object)iPSDELogicParam.getParamPSDataEntity().createDataObject());
                continue;
            }
            iActionContext.setParam(iPSDELogicParam.getCodeName(), (Object)new PSJITEntity());
        }
        this.getPSJITDELogicNodeModel(this.getPSDELogic().getStartPSDELogicNode()).execute(iActionContext);
    }
}

