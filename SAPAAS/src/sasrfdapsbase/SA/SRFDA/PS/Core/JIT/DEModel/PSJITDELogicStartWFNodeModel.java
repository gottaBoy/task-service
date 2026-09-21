/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IActionContext
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.pswf.core.IWFModel
 *  net.ibizsys.pswf.core.IWFService
 *  net.ibizsys.pswf.core.WFActionParam
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.JIT.DEModel;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEStartWFLogic;
import SA.SRFDA.PS.Core.JIT.DEModel.PSJITDELogicNodeModelBase;
import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFService;
import net.ibizsys.pswf.core.WFActionParam;
import org.hibernate.SessionFactory;

public class PSJITDELogicStartWFNodeModel
extends PSJITDELogicNodeModelBase {
    @Override
    protected void onExecute(IActionContext iActionContext) throws Exception {
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        if (this.getPSDELogicNode() instanceof IPSDEStartWFLogic) {
            IPSDEStartWFLogic iPSDEStartWFLogic = (IPSDEStartWFLogic)this.getPSDELogicNode();
            IDataEntityModel iDataEntityModel = this.getSystemModel().getDataEntityModel(iPSDEStartWFLogic.getPSDEWF().getPSDataEntity().getName());
            IEntity dstParam = (IEntity)iActionContext.getParam(iPSDEStartWFLogic.getDstPSDELogicParam().getCodeName());
            String strKeyValue = DataObject.getStringValue((Object)dstParam.get(iPSDEStartWFLogic.getPSDEWF().getPSDataEntity().getKeyPSDEField().getName()));
            IWFModel iWFModel = this.getSystemModel().getWFModel(iPSDEStartWFLogic.getPSWorkflow().getId());
            IWFService iWFService = iWFModel.getWFService();
            WFActionParam wfActionParam = new WFActionParam();
            wfActionParam.setUserData(strKeyValue);
            wfActionParam.setUserData4(iPSDEStartWFLogic.getPSDEWF().getPSDataEntity().getId());
            wfActionParam.setOpPersonId(iActionContext.getOperator());
            iWFService.start(wfActionParam);
        }
    }
}

