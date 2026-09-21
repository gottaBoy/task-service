/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.AC;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEACMode;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEACModeDataItem;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.Data.IPSDataItemParam;
import SA.SRFDA.PS.Core.Data.PSDataItemImpl;
import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACMode;
import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACModeDataItem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEACModeDataItemImpl
extends PSDataItemImpl
implements IPSDEACModeDataItem,
IPSAppDEACModeDataItem {
    private static final Log log = LogFactory.getLog(PSDEACModeDataItemImpl.class);
    private IPSDEACMode iPSDEACMode = null;
    private IPSDEField iPSDEField = null;
    private IPSAppDEField iPSAppDEField = null;
    private boolean bCustomCode = false;
    private String strScriptCode = null;

    public void init(IPSDEACMode iPSDEACMode) throws Exception {
        this.iPSDEACMode = iPSDEACMode;
        this.onInit();
    }

    @Override
    public String getModelId() {
        if (this.getPSDEACMode() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEACMode().getModelId(), (Object)this.getName());
        }
        return super.getModelId();
    }

    @Override
    public String getModelType() {
        if (StringHelper.compare((String)this.getPSDEACMode().getModelType(), (String)"PSAPPDEACMODE", (boolean)true) == 0) {
            return "PSAPPDEACMODEDATAITEM";
        }
        return "PSDEACMODEDATAITEM";
    }

    @Override
    public IPSDEACMode getPSDEACMode() {
        return this.iPSDEACMode;
    }

    @Override
    public String getPSSysModelInstId() {
        if (this.getPSDEACMode() != null) {
            return this.getPSDEACMode().getPSSysModelInstId();
        }
        return super.getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027", ignorepf=true, dumpref=true)
    public IPSDEField getPSDEField() {
        if (this.iPSDEField != null) {
            return this.iPSDEField;
        }
        IPSDEField iPSDEField = null;
        if (this.getDataItemParam() != null && this.getDataItemParam() instanceof IPSDataItemParam && (iPSDEField = ((IPSDataItemParam)this.getDataItemParam()).getPSDEField()) == null && this.getPSDEACMode() != null) {
            try {
                iPSDEField = this.getPSDEACMode().getPSDataEntity().getPSDEField(this.getDataItemParam().getName(), true);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        IPSAppDataEntity iPSAppDataEntity = null;
        if (this.getPSDEACMode() instanceof IPSAppDEACMode) {
            iPSAppDataEntity = ((IPSAppDEACMode)this.getPSDEACMode()).getPSAppDataEntity();
        }
        try {
            if (iPSDEField != null && iPSAppDataEntity != null) {
                this.iPSAppDEField = iPSAppDataEntity.getPSAppDEField(iPSDEField.getId(), true);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.iPSDEField = iPSDEField;
        return this.iPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, fields={"PSDEFID"})
    public IPSAppDEField getPSAppDEField() {
        this.getPSDEField();
        return this.iPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u683c\u5f0f\u5316", hideempty2=true, dump=false)
    public String getFormat() {
        return super.getFormat();
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u65701\u683c\u5f0f\u5316", hideempty2=true, modelattr="format")
    public String getDataItemParam0Format() {
        if (this.getDataItemParam() != null && this.getDataItemParam() instanceof IPSDataItemParam) {
            return this.getDataItemParam().getFormat();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801\u6a21\u5f0f", ignoredumpvalues="false", fields={"CUSTOMMODE"})
    public boolean isCustomCode() {
        return this.bCustomCode;
    }

    public void setCustomCode(boolean bCustomCode) {
        this.bCustomCode = bCustomCode;
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801", hideempty2=true, fields={"CUSTOMCODE"})
    public String getScriptCode() {
        return this.strScriptCode;
    }

    public void setScriptCode(String strScriptCode) {
        this.strScriptCode = strScriptCode;
    }
}

