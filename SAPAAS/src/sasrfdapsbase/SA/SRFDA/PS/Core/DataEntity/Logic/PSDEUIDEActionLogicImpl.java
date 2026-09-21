/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethod;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUIDEActionLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDEUILogicNodeImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

public class PSDEUIDEActionLogicImpl
extends PSDEUILogicNodeImpl
implements IPSDEUIDEActionLogic {
    private IPSAppDEAction dstPSAppDEAction = null;
    private IPSDEAction dstPSDEAction = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (this.getDstPSDataEntity() == null) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u76ee\u6807\u5b9e\u4f53\u5bf9\u8c61");
        }
        if (StringHelper.isNullOrEmpty((String)this.psDELogicNode.getDSTPSDEACTIONID())) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u76ee\u6807\u5b9e\u4f53\u884c\u4e3a\u5bf9\u8c61");
        }
        this.dstPSDEAction = this.getDstPSDataEntity().getPSDEAction(this.psDELogicNode.getDSTPSDEACTIONID());
    }

    @Override
    protected int onCheck() throws Exception {
        this.getDstPSAppDataEntity();
        this.getDstPSAppDEAction();
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", dumpref=true, fields={"DSTPSDEID"})
    public IPSAppDataEntity getDstPSAppDataEntity() throws Exception {
        return super.getDstPSAppDataEntity();
    }

    @Override
    @PSModelRTMeta(description="\u8c03\u7528\u5e94\u7528\u5b9e\u4f53\u884c\u4e3a", dumpref=true, from="__self__", from_method="getDstPSAppDataEntityMust().getPSAppDEAction", fields={"DSTPSDEACTIONID"})
    public IPSAppDEAction getDstPSAppDEAction() throws Exception {
        IPSAppDEMethod iPSAppDEMethod;
        if (this.dstPSAppDEAction != null) {
            return this.dstPSAppDEAction;
        }
        if (this.getDstPSAppDataEntity() == null) {
            throw new Exception("\u76ee\u6807\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61");
        }
        boolean bTryMode = true;
        if (this.getDstPSAppDataEntity().getPSApplication().getPSPFStyle() != null && this.getDstPSAppDataEntity().getPSApplication().getPSPFStyle().getPFEngineVer() >= 20) {
            bTryMode = false;
        }
        if ((iPSAppDEMethod = this.getDstPSAppDataEntity().getPSAppDEMethod(this.dstPSDEAction, bTryMode)) instanceof IPSAppDEAction) {
            this.dstPSAppDEAction = (IPSAppDEAction)iPSAppDEMethod;
        }
        if (!bTryMode && this.dstPSAppDEAction == null) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u8c03\u7528\u5e94\u7528\u5b9e\u4f53\u884c\u4e3a\u5bf9\u8c61");
        }
        return this.dstPSAppDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", dumpref=true, from="IPSDEUILogic", fields={"DSTPSDLPARAMID"})
    public IPSDEUILogicParam getDstPSDEUILogicParam() throws Exception {
        return super.getDstPSDEUILogicParam();
    }

    @Override
    @PSModelRTMeta(description="\u8fd4\u56de\u503c\u7ed1\u5b9a\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDEUILogic", fields={"RETPSDLPARAMID"})
    public IPSDEUILogicParam getRetPSDEUILogicParam() throws Exception {
        return super.getRetPSDEUILogicParam();
    }
}

