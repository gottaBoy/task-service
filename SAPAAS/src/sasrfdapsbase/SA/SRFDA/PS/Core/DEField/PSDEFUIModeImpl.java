/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEFUIItem;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEFUIMode;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFFormItem;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEFGridColumn;
import SA.SRFDA.PS.Core.DEField.IPSDEFUIMode;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.PSDEFieldObjectImpl;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSDEFUIMode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSDEFUIModeImpl
extends PSDEFieldObjectImpl
implements IPSDEFUIMode,
IPSAppDEFUIMode {
    private static final Log log = LogFactory.getLog(PSDEFUIModeImpl.class);
    protected PSDEFUIMode psDEFUIMode = null;
    protected IPSDEFFormItem iPSDEFFormItem = null;
    protected IPSDEFGridColumn iPSDEFGridColumn = null;
    private boolean bMobileMode = false;
    private IPSAppDEField iPSAppDEField = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppDEField iPSAppDEField, PSDEFUIMode psDEFUIMode) throws Exception {
        this.setPSAppDEField(iPSAppDEField);
        this.init(iDAGlobalHelper, this.getPSAppDEField().getPSDEField(), psDEFUIMode);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEField iPSDEField, PSDEFUIMode psDEFUIMode) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDEField(iPSDEField);
            this.setId(psDEFUIMode.getPSDEFFORMITEMID());
            this.setName(psDEFUIMode.getPSDEFFORMITEMNAME());
            this.setPSObjectData(psDEFUIMode);
            this.psDEFUIMode = psDEFUIMode;
            if (StringHelper.Compare((String)psDEFUIMode.getFTMODE(), (String)"MOBILEDEFAULT", (boolean)false) == 0) {
                this.bMobileMode = true;
            }
            this.iPSDEFFormItem = this.iPSDEField.getPSDEFieldType().createPSDEFFormItem(psDEFUIMode);
            if (this.getPSAppDEField() != null) {
                if (!(this.iPSDEFFormItem instanceof IPSAppDEFUIItem)) throw new Exception(String.format("\u5c5e\u6027\u754c\u9762\u9879[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", this.iPSDEFFormItem));
                ((IPSAppDEFUIItem)((Object)this.iPSDEFFormItem)).init(iDAGlobalHelper, this.getPSAppDEField(), psDEFUIMode);
            } else {
                this.iPSDEFFormItem.init(iDAGlobalHelper, iPSDEField, psDEFUIMode);
            }
            this.iPSDEFGridColumn = this.iPSDEField.getPSDEFieldType().createPSDEFGridColumn(psDEFUIMode);
            if (this.getPSAppDEField() != null) {
                if (!(this.iPSDEFGridColumn instanceof IPSAppDEFUIItem)) throw new Exception(String.format("\u5c5e\u6027\u754c\u9762\u9879[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", this.iPSDEFFormItem));
                ((IPSAppDEFUIItem)((Object)this.iPSDEFGridColumn)).init(iDAGlobalHelper, this.getPSAppDEField(), psDEFUIMode);
            } else {
                this.iPSDEFGridColumn.init(iDAGlobalHelper, iPSDEField, psDEFUIMode);
            }
            this.onInit();
            return;
        }
        catch (Exception ex) {
            String strLogName = net.ibizsys.paas.util.StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = net.ibizsys.paas.util.StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)net.ibizsys.paas.util.StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u8868\u5355\u9879\u6a21\u5f0f", child=true, ignorert=3)
    public IPSDEFFormItem getPSDEFFormItem() {
        return this.iPSDEFFormItem;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u8868\u683c\u5217\u6a21\u5f0f")
    public IPSDEFGridColumn getPSDEFGridColumn() {
        return this.iPSDEFGridColumn;
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u7aef\u6a21\u5f0f", ignoredumpvalues="false")
    public boolean isMobileMode() {
        return this.bMobileMode;
    }

    @Override
    public String getModelType() {
        if (this.getPSAppDEField() != null) {
            return "PSAPPDEFUIMODE";
        }
        return "PSDEFUIMODE";
    }

    @Override
    public String getModelId() {
        if (this.getPSAppDEField() != null) {
            return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSAppDEField().getModelId(), (Object)super.getModelId());
        }
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDEField().getModelId(), (Object)super.getModelId());
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psDEFUIMode.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u6a21\u5f0f", codelist="FieldUIMode", fields={"FTMODE"})
    public String getType() {
        return this.psDEFUIMode.getFTMODE();
    }

    @Override
    public IPSAppDataEntity getPSAppDataEntity() {
        if (this.getPSAppDEField() != null) {
            return this.getPSAppDEField().getPSAppDataEntity();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", outputdoc="false", hideempty=true)
    public IPSAppDEField getPSAppDEField() {
        return this.iPSAppDEField;
    }

    protected void setPSAppDEField(IPSAppDEField iPSAppDEField) {
        this.iPSAppDEField = iPSAppDEField;
    }
}

