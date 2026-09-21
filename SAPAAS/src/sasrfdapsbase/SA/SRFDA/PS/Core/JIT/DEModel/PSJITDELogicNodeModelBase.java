/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IActionContext
 *  net.ibizsys.paas.core.ModelBaseImpl
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.demodel.DELogicModelBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.JIT.DEModel;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLink;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkCond;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkGroupCond;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkSingleCond;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNode;
import SA.SRFDA.PS.Core.JIT.DEModel.IPSJITDELogicModel;
import SA.SRFDA.PS.Core.JIT.DEModel.IPSJITDELogicNodeModel;
import SA.SRFDA.PS.Core.JIT.DEModel.IPSJITDEModel;
import SA.SRFDA.PS.Core.JIT.SysModel.IPSJITSystemModel;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.StringHelper;

public abstract class PSJITDELogicNodeModelBase
extends ModelBaseImpl
implements IPSJITDELogicNodeModel {
    public static final String LOOPCNT = "SRFJITLOOPCNT";
    private IPSJITDELogicModel iPSJITDELogicModel = null;
    private IPSDELogicNode iPSDELogicNode = null;

    public void init(IPSJITDELogicModel iPSJITDELogicModel, IPSDELogicNode iPSDELogicNode) throws Exception {
        this.iPSDELogicNode = iPSDELogicNode;
        this.iPSJITDELogicModel = iPSJITDELogicModel;
        this.onInit();
    }

    @Override
    public IPSJITDELogicModel getPSJITDELogicModel() {
        return this.iPSJITDELogicModel;
    }

    @Override
    public IPSDELogicNode getPSDELogicNode() {
        return this.iPSDELogicNode;
    }

    @Override
    public void execute(IActionContext iActionContext) throws Exception {
        Integer nLoopCnt = (Integer)iActionContext.getParam(LOOPCNT);
        nLoopCnt = nLoopCnt == null ? Integer.valueOf(1) : Integer.valueOf(nLoopCnt + 1);
        if (nLoopCnt >= 100) {
            throw new Exception(StringHelper.format((String)"\u5b9e\u4f53\u903b\u8f91[%1$s]\u51fa\u73b0100\u4ee5\u4e0a\u8c03\u7528\uff0c\u53ef\u80fd\u51fa\u73b0\u9012\u5f52", (Object)this.iPSDELogicNode.getPSDELogic().getName()));
        }
        this.onExecute(iActionContext);
        Iterator<IPSDELogicLink> psDELogicLinks = this.iPSDELogicNode.getPSDELogicLinks();
        if (psDELogicLinks != null) {
            while (psDELogicLinks.hasNext()) {
                IPSDELogicLink iPSDELogicLink = psDELogicLinks.next();
                if (!this.testPSDELogicLinkGroupCond(iPSDELogicLink.getPSDELogicLinkGroupCond(), iActionContext).booleanValue()) continue;
                this.getPSJITDELogicModel().getPSJITDELogicNodeModel(iPSDELogicLink.getDstPSDELogicNode()).execute(iActionContext);
                if (this.getPSDELogicNode().isParallelOutput()) continue;
                return;
            }
        }
    }

    protected abstract void onExecute(IActionContext var1) throws Exception;

    protected Boolean testPSDELogicLinkGroupCond(IPSDELogicLinkGroupCond iPSDELogicLinkGroupCond, IActionContext iActionContext) throws Exception {
        if (iPSDELogicLinkGroupCond == null) {
            return true;
        }
        Boolean bRet = this.testPSDELogicLinkCond(iPSDELogicLinkGroupCond, iActionContext);
        if (bRet == null) {
            return true;
        }
        return bRet;
    }

    protected Boolean testPSDELogicLinkCond(IPSDELogicLinkCond iPSDELogicLinkCond, IActionContext iActionContext) throws Exception {
        if (iPSDELogicLinkCond instanceof IPSDELogicLinkGroupCond) {
            IPSDELogicLinkGroupCond iPSDELogicLinkGroupCond = (IPSDELogicLinkGroupCond)iPSDELogicLinkCond;
            ArrayList<Boolean> retList = new ArrayList<Boolean>();
            Iterator<? extends IPSDELogicLinkCond> psDEFDLogics = iPSDELogicLinkGroupCond.getPSDELogicLinkConds();
            if (psDEFDLogics != null) {
                while (psDEFDLogics.hasNext()) {
                    IPSDELogicLinkCond childPSDELogicLinkCond = psDEFDLogics.next();
                    Boolean bRet = this.testPSDELogicLinkCond(childPSDELogicLinkCond, iActionContext);
                    if (bRet == null) continue;
                    retList.add(bRet);
                }
            }
            if (retList.size() == 0) {
                return null;
            }
            if (retList.size() == 1) {
                if (iPSDELogicLinkGroupCond.isNotMode()) {
                    return (Boolean)retList.get(0) == false;
                }
                return (Boolean)retList.get(0);
            }
            Boolean bRet = null;
            bRet = StringHelper.compare((String)iPSDELogicLinkGroupCond.getGroupOP(), (String)"AND", (boolean)true) == 0 ? Boolean.valueOf(true) : Boolean.valueOf(false);
            int i = 0;
            while (i < retList.size()) {
                if (StringHelper.compare((String)iPSDELogicLinkGroupCond.getGroupOP(), (String)"AND", (boolean)true) == 0) {
                    if (!((Boolean)retList.get(i)).booleanValue()) {
                        bRet = false;
                        break;
                    }
                } else if (((Boolean)retList.get(i)).booleanValue()) {
                    bRet = true;
                    break;
                }
                ++i;
            }
            if (iPSDELogicLinkGroupCond.isNotMode()) {
                bRet = bRet == false;
            }
            return bRet;
        }
        if (iPSDELogicLinkCond instanceof IPSDELogicLinkSingleCond) {
            IPSDELogicLinkSingleCond iPSDELogicLinkSingleCond = (IPSDELogicLinkSingleCond)iPSDELogicLinkCond;
            String strParamName = iPSDELogicLinkSingleCond.getDstLogicParam().getCodeName();
            IEntity iEntity = (IEntity)iActionContext.getParam(strParamName);
            return DELogicModelBase.testCond((Object)iEntity.get(iPSDELogicLinkSingleCond.getDstFieldName()), (String)iPSDELogicLinkSingleCond.getPSDBValueOPId(), (Object)iPSDELogicLinkSingleCond.getValue());
        }
        throw new Exception("\u65e0\u6cd5\u8ba1\u7b97\u903b\u8f91\u503c");
    }

    protected IPSJITSystemModel getSystemModel() {
        return this.getDataEntity().getPSJITSystemModel();
    }

    public IPSJITDEModel getDataEntity() {
        return this.getPSJITDELogicModel().getIPSJITDEModel();
    }

    protected IService getService(IActionContext iActionContext) throws Exception {
        return this.getDataEntity().getService(iActionContext.getSessionFactory());
    }

    protected IDAO getDAO(IActionContext iActionContext) throws Exception {
        return this.getService(iActionContext).getDAO();
    }
}

