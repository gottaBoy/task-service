/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IActionContext
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.JIT.DEModel;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEDEActionLogic;
import SA.SRFDA.PS.Core.JIT.DEModel.PSJITDELogicNodeModelBase;
import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import org.hibernate.SessionFactory;

public class PSJITDELogicDEActionNodeModel
extends PSJITDELogicNodeModelBase {
    @Override
    protected void onExecute(IActionContext iActionContext) throws Exception {
        IPSDEDEActionLogic iPSDEDEActionLogic;
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        if (this.getPSDELogicNode() instanceof IPSDEDEActionLogic && (iPSDEDEActionLogic = (IPSDEDEActionLogic)this.getPSDELogicNode()).getDstPSDataEntity() != null) {
            IService service = this.getPSJITDELogicModel().getIPSJITDEModel().getPSJITSystemModel().getDataEntityModel(iPSDEDEActionLogic.getDstPSDataEntity().getId()).getService(sessionFactory);
            service.executeAction(iPSDEDEActionLogic.getDstPSDEAction().getCodeName().toUpperCase(), (IEntity)iActionContext.getParam(iPSDEDEActionLogic.getDstPSDELogicParam().getCodeName()));
        }
    }
}

