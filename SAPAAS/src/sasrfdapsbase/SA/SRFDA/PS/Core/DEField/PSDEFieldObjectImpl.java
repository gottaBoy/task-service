/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.core.IDEField
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.pscore.srv.util.Inflector
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSDEFieldObject;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemSetting;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFramework.Utility.StringHelper;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.pscore.srv.util.Inflector;

@PSModelPFIgnoreMeta
public abstract class PSDEFieldObjectImpl
extends PSObjectImpl
implements IPSDEFieldObject {
    protected IPSDEField iPSDEField = null;

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027\u5bf9\u8c61", outputdoc="false")
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    protected void setPSDEField(IPSDEField iPSDEField) {
        this.iPSDEField = iPSDEField;
    }

    public IPSAppDEField getPSAppDEField() {
        return null;
    }

    public IPSAppDataEntity getPSAppDataEntity() {
        if (this.getPSAppDEField() != null) {
            return this.getPSAppDEField().getPSAppDataEntity();
        }
        return null;
    }

    public IDEField getDEField() {
        return this.getPSDEField();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDEField().getPSSysModelInstId();
    }

    @Override
    public IPSDataEntity getPSDataEntity() {
        return this.getPSDEField().getPSDataEntity();
    }

    public IDataEntity getDataEntity() {
        return this.getPSDEField().getDataEntity();
    }

    protected IPSSystemSetting getPSSystemSetting() {
        return (IPSSystemSetting)((Object)this.getPSDataEntity().getPSSystem());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDataEntity().getPSSystem());
    }

    @Override
    public String getFullModelName() {
        return StringHelper.Format((String)"%1$s|%2$s", (Object)this.getPSDEField().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    protected String onGetMOSFolder() {
        if (this.getPSDEField() != null) {
            return String.format("%1$s/%2$s", this.getPSDEField().getMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase();
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getPSAppDEField() != null) {
            return String.format("%1$s/%2$s", this.getPSAppDEField().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase());
        }
        if (this.getPSDEField() != null) {
            return String.format("%1$s/%2$s", this.getPSDEField().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase();
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSDEField();
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        return this.getPSDEField();
    }
}

