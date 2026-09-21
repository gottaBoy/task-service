/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEFLogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEFLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicImpl;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

public class PSDEFLogicImpl
extends PSDELogicImpl
implements IPSDEFLogic,
IPSAppDEFLogic {
    private String strDEFLogicMode = null;
    private IPSDEField iPSDEField = null;
    private IPSAppDEField iPSAppDEField = null;

    @Override
    protected void onInit() throws Exception {
        this.strDEFLogicMode = this.psDELogic.getDEFLOGICMODE();
        if (StringHelper.isNullOrEmpty((String)this.getDEFLogicMode())) {
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027\u903b\u8f91\u6a21\u5f0f"));
        }
        if (this.getPSDEField() == null) {
            if (StringHelper.isNullOrEmpty((String)this.psDELogic.getPSDEFID())) {
                throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u5c5e\u6027"));
            }
            this.iPSDEField = this.getPSDataEntity().getPSDEField(this.psDELogic.getPSDEFID());
        }
        if (this.getPSAppDEField() == null && this.getPSAppDataEntity() != null && this.getPSDEField() != null) {
            this.iPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getPSDEField(), true);
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, fields={"PSDEFID"})
    public IPSAppDEField getPSAppDEField() {
        return this.iPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027", dumpref=true, ignorepf=true, fields={"PSDEFID"})
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u903b\u8f91\u6a21\u578b", codelist="DEFLogicMode", fields={"DEFLOGICMODE"})
    public String getDEFLogicMode() {
        return this.strDEFLogicMode;
    }

    @Override
    public String getModelType() {
        if (this.getPSAppDataEntity() != null) {
            return "PSAPPDEFLOGIC";
        }
        return "PSDEFLOGIC";
    }

    @Override
    public IPSModelObject getScopeModel() {
        if (this.getPSAppDEField() != null) {
            return this.getPSAppDEField();
        }
        if (this.getPSDEField() != null) {
            return this.getPSDEField();
        }
        return super.getScopeModel();
    }

    @Override
    public boolean isPrepareLast() {
        if (this.getPSAppDEField() == null && "ONCHANGE".equals(this.getDEFLogicMode())) {
            return true;
        }
        return super.isPrepareLast();
    }
}

