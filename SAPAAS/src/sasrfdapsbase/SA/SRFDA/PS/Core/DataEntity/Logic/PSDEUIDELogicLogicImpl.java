/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUIDELogicLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDEUILogicNodeImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

public class PSDEUIDELogicLogicImpl
extends PSDEUILogicNodeImpl
implements IPSDEUIDELogicLogic {
    private IPSDELogic iPSDELogic = null;
    private IPSAppDELogic iPSAppDELogic = null;

    @Override
    protected void onInit() throws Exception {
        if (this.getDstPSDataEntity() != null) {
            if (StringHelper.isNullOrEmpty((String)this.psDELogicNode.getDSTPSDELOGICID())) {
                throw new Exception("\u672a\u6307\u5b9a\u76ee\u6807\u903b\u8f91\u5bf9\u8c61");
            }
            this.iPSDELogic = this.getDstPSDataEntity().getPSDELogic(this.psDELogicNode.getDSTPSDELOGICID());
        }
        if (this.getDstPSAppDataEntity() != null) {
            this.iPSAppDELogic = this.getDstPSAppDataEntity().getPSAppDELogic(this.psDELogicNode.getDSTPSDELOGICID(), true);
        }
        super.onInit();
    }

    public IPSDELogic getDstPSDELogic() throws Exception {
        return this.iPSDELogic;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDEUILogic", fields={"DSTPSDLPARAMID"})
    public IPSDEUILogicParam getDstPSDEUILogicParam() throws Exception {
        return super.getDstPSDEUILogicParam();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", hideempty=true, dumpref=true, fields={"DSTPSDEID"})
    public IPSAppDataEntity getDstPSAppDataEntity() throws Exception {
        return super.getDstPSAppDataEntity();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u903b\u8f91\u5bf9\u8c61", hideempty=true, dumpref=true, from="__self__", from_method="getDstPSAppDataEntityMust().getPSAppDELogic", fields={"DSTPSDELOGICID"})
    public IPSAppDELogic getDstPSAppDELogic() throws Exception {
        return this.iPSAppDELogic;
    }

    @Override
    @PSModelRTMeta(description="\u8fd4\u56de\u503c\u7ed1\u5b9a\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDEUILogic", fields={"RETPSDLPARAMID"})
    public IPSDEUILogicParam getRetPSDEUILogicParam() throws Exception {
        return super.getRetPSDEUILogicParam();
    }
}

