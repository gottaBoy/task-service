/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Util;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.PSSysUtilImpl;
import SA.SRFDA.PS.Core.Util.IPSSysFileUtil;
import net.ibizsys.paas.util.StringHelper;

public class PSSysFileUtilImpl
extends PSSysUtilImpl
implements IPSSysFileUtil {
    private IPSDataEntity iPSDataEntity = null;
    private IPSDEAction createPSDEAction = null;
    private IPSDEAction updatePSDEAction = null;
    private IPSDEAction getPSDEAction = null;
    private IPSDEAction removePSDEAction = null;
    private IPSDEField sysIdPSDEField = null;
    private IPSDEField modelPSDEField = null;
    private IPSDEField modelIdPSDEField = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        IPSDataEntity iPSDataEntity = null;
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDEId())) {
            iPSDataEntity = this.getPSSystem().getPSDataEntity2(this.getUtilPSDEId());
        }
        if (this.getStoagePSDataEntity() == null) {
            if (iPSDataEntity == null) {
                this.getPSSystemUtil().getPSSysConsole().warn(this.getLogName(), StringHelper.format((String)"\u9644\u4ef6\u5b58\u50a8\u5b9e\u4f53\u65e0\u6548"));
            }
        } else {
            if (this.getCreatePSDEAction() == null) {
                this.createPSDEAction = this.getStoagePSDataEntity().getPSDEAction(this.getCreateDEActionName(), true);
            }
            if (this.getUpdatePSDEAction() == null) {
                this.updatePSDEAction = this.getStoagePSDataEntity().getPSDEAction(this.getUpdateDEActionName(), true);
            }
            if (this.getGetPSDEAction() == null) {
                this.getPSDEAction = this.getStoagePSDataEntity().getPSDEAction(this.getGetDEActionName(), true);
            }
            if (this.getRemovePSDEAction() == null) {
                this.removePSDEAction = this.getStoagePSDataEntity().getPSDEAction(this.getRemoveDEActionName(), true);
            }
            if (!StringHelper.isNullOrEmpty((String)this.getSysIdDEFieldName()) && this.getSysIdPSDEField() == null) {
                this.sysIdPSDEField = this.getStoagePSDataEntity().getPSDEField(this.getSysIdDEFieldName(), true);
            }
            if (!StringHelper.isNullOrEmpty((String)this.getModelIdDEFieldName()) && this.getModelIdPSDEField() == null) {
                this.modelIdPSDEField = this.getStoagePSDataEntity().getPSDEField(this.getModelIdDEFieldName(), true);
            }
            if (!StringHelper.isNullOrEmpty((String)this.getModelDEFieldName()) && this.getModelPSDEField() == null) {
                this.modelPSDEField = this.getStoagePSDataEntity().getPSDEField(this.getModelDEFieldName(), true);
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u6570\u636e\u5b58\u50a8\u5b9e\u4f53")
    public IPSDataEntity getStoagePSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u5efa\u7acb\u6570\u636e\u884c\u4e3a")
    public IPSDEAction getCreatePSDEAction() {
        return this.createPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u66f4\u65b0\u6570\u636e\u884c\u4e3a")
    public IPSDEAction getUpdatePSDEAction() {
        return this.updatePSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u5220\u9664\u6570\u636e\u884c\u4e3a")
    public IPSDEAction getRemovePSDEAction() {
        return this.removePSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u83b7\u53d6\u6570\u636e\u884c\u4e3a")
    public IPSDEAction getGetPSDEAction() {
        return this.getPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6807\u8bc6\u5b58\u50a8\u5c5e\u6027")
    public IPSDEField getSysIdPSDEField() {
        return this.sysIdPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u578b\u5b58\u50a8\u5c5e\u6027")
    public IPSDEField getModelPSDEField() {
        return this.modelPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u578b\u6807\u8bc6\u5b58\u50a8\u5c5e\u6027")
    public IPSDEField getModelIdPSDEField() {
        return this.modelIdPSDEField;
    }

    public String getCreateDEActionName() {
        return "CREATE";
    }

    public String getUpdateDEActionName() {
        return "UPDATE";
    }

    public String getGetDEActionName() {
        return "GET";
    }

    public String getRemoveDEActionName() {
        return "REMOVE";
    }

    public String getSysIdDEFieldName() {
        return "SYSID";
    }

    public String getModelDEFieldName() {
        return "MODEL";
    }

    public String getModelIdDEFieldName() {
        return "MODELID";
    }
}

