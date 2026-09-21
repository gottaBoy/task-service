/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUIActionLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDEUILogicNodeImpl;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSDEUIAction;
import net.ibizsys.paas.util.StringHelper;

public class PSDEUIActionLogicImpl
extends PSDEUILogicNodeImpl
implements IPSDEUIActionLogic {
    private IPSAppDEUIAction dstPSAppDEUIAction = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (StringHelper.isNullOrEmpty((String)this.psDELogicNode.getPSDEUIACTIONID())) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u8c03\u7528\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u5bf9\u8c61");
        }
        PSDEUIAction psDEUIAction = ((IPSSystem)((Object)this.getPSSystemUtil())).getPSDEUIActionData(this.psDELogicNode.getPSDEUIACTIONID(), true);
        if (psDEUIAction != null) {
            if (!StringHelper.isNullOrEmpty((String)psDEUIAction.getPSDEID())) {
                if (StringHelper.compare((String)psDEUIAction.getPSDEID(), (String)this.psDELogicNode.getDSTPSDEID(), (boolean)false) != 0) {
                    if (StringHelper.compare((String)psDEUIAction.getPSDEID(), (String)this.getPSDEUILogic().getPSDataEntity().getId(), (boolean)false) != 0) {
                        this.setDstPSDataEntity(this.getPSDEUILogic().getPSDataEntity().getPSSystem().getPSDataEntity2(psDEUIAction.getPSDEID()));
                    } else {
                        this.setDstPSDataEntity(this.getPSDEUILogic().getPSDataEntity());
                    }
                    if (this.getPSAppDEUILogic() != null) {
                        this.setDstPSAppDataEntity(this.getPSAppDEUILogic().getPSAppDataEntity().getPSApplication().getPSAppDataEntity(this.getDstPSDataEntity(), true));
                    }
                }
            } else {
                this.setDstPSDataEntity(null);
                this.setDstPSAppDataEntity(null);
            }
        }
    }

    @Override
    protected int onCheck() throws Exception {
        this.getDstPSAppDataEntity();
        this.getDstPSAppDEUIAction();
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", dumpref=true, fields={"dstpsdeid"})
    public IPSAppDataEntity getDstPSAppDataEntity() throws Exception {
        return super.getDstPSAppDataEntity();
    }

    @Override
    @PSModelRTMeta(description="\u8c03\u7528\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u884c\u4e3a", dumpref=true, fields={"psdeuiactionid"})
    public IPSAppDEUIAction getDstPSAppDEUIAction() throws Exception {
        if (this.dstPSAppDEUIAction != null) {
            return this.dstPSAppDEUIAction;
        }
        if (this.getDstPSAppDataEntity() == null && this.getPSAppDEUILogic() != null && this.getDstPSDataEntity() != null) {
            throw new Exception(String.format("\u5b9e\u4f53[%1$s]\u672a\u52a0\u5165\u5230\u524d\u7aef\u5e94\u7528[%2$s]", this.getDstPSDataEntity().getFullName(), this.getPSAppDEUILogic().getPSApplication().getFullName()));
        }
        if (this.getDstPSAppDataEntity() != null) {
            this.dstPSAppDEUIAction = this.getDstPSAppDataEntity().getPSAppDEUIAction(this.psDELogicNode.getPSDEUIACTIONID(), false, this.getPSDEUILogic());
        } else if (this.getPSAppDEUILogic() != null && this.getPSAppDEUILogic().getPSAppDataEntity() != null) {
            this.dstPSAppDEUIAction = this.getPSAppDEUILogic().getPSAppDataEntity().getPSAppDEUIAction(this.psDELogicNode.getPSDEUIACTIONID(), false, this.getPSDEUILogic());
        }
        return this.dstPSAppDEUIAction;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", dumpref=true, from="IPSDEUILogic", fields={"dstpsdlparamid"})
    public IPSDEUILogicParam getDstPSDEUILogicParam() throws Exception {
        return super.getDstPSDEUILogicParam();
    }
}

