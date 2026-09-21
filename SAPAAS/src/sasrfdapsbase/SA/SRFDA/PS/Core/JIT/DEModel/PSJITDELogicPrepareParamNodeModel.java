/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IActionContext
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.WebContext
 */
package SA.SRFDA.PS.Core.JIT.DEModel;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNodeParam;
import SA.SRFDA.PS.Core.JIT.DEModel.PSJITDELogicNodeModelBase;
import java.util.Iterator;
import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;

public class PSJITDELogicPrepareParamNodeModel
extends PSJITDELogicNodeModelBase {
    @Override
    protected void onExecute(IActionContext iActionContext) throws Exception {
        Iterator<IPSDELogicNodeParam> psDELogicNodeParams = this.getPSDELogicNode().getPSDELogicNodeParams();
        if (psDELogicNodeParams != null) {
            while (psDELogicNodeParams.hasNext()) {
                IPSDELogicNodeParam iPSDELogicNodeParam = psDELogicNodeParams.next();
                IEntity dstParam = (IEntity)iActionContext.getParam(iPSDELogicNodeParam.getDstPSDELogicParam().getCodeName());
                if (StringHelper.compare((String)iPSDELogicNodeParam.getLogicNodeParamType(), (String)"SETPARAMVALUE", (boolean)false) != 0) continue;
                if (StringHelper.compare((String)iPSDELogicNodeParam.getSrcValueType(), (String)"WEBCONTEXT", (boolean)false) == 0) {
                    dstParam.set(iPSDELogicNodeParam.getDstFieldName(), (Object)WebContext.getCurrent().getPostValue(iPSDELogicNodeParam.getSrcFieldName()));
                }
                if (StringHelper.compare((String)iPSDELogicNodeParam.getSrcValueType(), (String)"SRCDLPARAM", (boolean)false) == 0) {
                    IEntity srcParam = (IEntity)iActionContext.getParam(iPSDELogicNodeParam.getSrcPSDELogicParam().getCodeName());
                    dstParam.set(iPSDELogicNodeParam.getDstFieldName(), srcParam.get(iPSDELogicNodeParam.getSrcFieldName()));
                }
                if (StringHelper.compare((String)iPSDELogicNodeParam.getSrcValueType(), (String)"APPDATA", (boolean)false) == 0) {
                    dstParam.set(iPSDELogicNodeParam.getDstFieldName(), (Object)WebContext.getCurrent().getAppDataValue(iPSDELogicNodeParam.getSrcFieldName()));
                }
                if (StringHelper.compare((String)iPSDELogicNodeParam.getSrcValueType(), (String)"VIEWPARAM", (boolean)false) == 0) {
                    dstParam.set(iPSDELogicNodeParam.getDstFieldName(), (Object)WebContext.getCurrent().getViewParamValue(iPSDELogicNodeParam.getSrcFieldName()));
                }
                if (StringHelper.compare((String)iPSDELogicNodeParam.getSrcValueType(), (String)"APPLICATION", (boolean)false) == 0) {
                    dstParam.set(iPSDELogicNodeParam.getDstFieldName(), WebContext.getCurrent().getGlobalValue(iPSDELogicNodeParam.getSrcFieldName()));
                }
                if (StringHelper.compare((String)iPSDELogicNodeParam.getSrcValueType(), (String)"SESSION", (boolean)false) == 0) {
                    dstParam.set(iPSDELogicNodeParam.getDstFieldName(), WebContext.getCurrent().getSessionValue(iPSDELogicNodeParam.getSrcFieldName()));
                }
                if (StringHelper.compare((String)iPSDELogicNodeParam.getSrcValueType(), (String)"NONEVALUE", (boolean)false) == 0) {
                    dstParam.remove(iPSDELogicNodeParam.getDstFieldName());
                }
                if (StringHelper.compare((String)iPSDELogicNodeParam.getSrcValueType(), (String)"NULLVALUE", (boolean)false) == 0) {
                    dstParam.set(iPSDELogicNodeParam.getDstFieldName(), null);
                }
                if (StringHelper.compare((String)iPSDELogicNodeParam.getSrcValueType(), (String)"SRCVALUE", (boolean)false) != 0) continue;
                dstParam.set(iPSDELogicNodeParam.getDstFieldName(), (Object)iPSDELogicNodeParam.getSrcValue());
            }
        }
    }
}

