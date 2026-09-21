/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.List;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.Control.List.IPSDEList;
import SA.SRFDA.PS.Core.Control.List.IPSDEListDataItem;
import SA.SRFDA.PS.Core.Control.List.PSListDataItemImpl;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.Data.IPSDataItemParam;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEListDataItemImpl
extends PSListDataItemImpl
implements IPSDEListDataItem {
    private static final Log log = LogFactory.getLog(PSDEListDataItemImpl.class);
    private IPSDEList iPSDEList = null;
    private IPSDEField iPSDEField = null;
    private IPSAppDEField iPSAppDEField = null;

    public void init(IPSDEList iPSDEList) throws Exception {
        this.iPSDEList = iPSDEList;
        this.onInit();
    }

    protected void onInit() throws Exception {
        if (this.getPSCodeList() != null) {
            this.setConvertToCodeItemText(true);
        }
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSDELISTDATAITEM";
    }

    @Override
    public IPSDEList getPSDEList() {
        return this.iPSDEList;
    }

    @Override
    public String getModelId() {
        if (this.getPSDEList() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEList().getModelId(), (Object)this.getName());
        }
        return super.getModelId();
    }

    @Override
    @PSModelRTMeta(description="\u5173\u8054\u5b9e\u4f53\u5c5e\u6027")
    public IPSDEField getPSDEField() {
        if (this.iPSDEField != null) {
            return this.iPSDEField;
        }
        IPSDEField iPSDEField = null;
        if (this.getDataItemParam() != null && this.getDataItemParam() instanceof IPSDataItemParam && (iPSDEField = ((IPSDataItemParam)this.getDataItemParam()).getPSDEField()) == null && this.getPSDEList() != null) {
            try {
                iPSDEField = this.getPSDEList().getPSDataEntity().getPSDEField(this.getDataItemParam().getName(), true);
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
        try {
            if (iPSDEField != null && this.getPSDEList() != null && this.getPSDEList().getPSAppDataEntity() != null) {
                this.iPSAppDEField = this.getPSDEList().getPSAppDataEntity().getPSAppDEField(iPSDEField.getId(), true);
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        this.iPSDEField = iPSDEField;
        return this.iPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5173\u8054\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true)
    public IPSAppDEField getPSAppDEField() {
        this.getPSDEField();
        return this.iPSAppDEField;
    }

    @Override
    public String getPSSysModelInstId() {
        if (this.getPSDEList() != null) {
            return this.getPSDEList().getPSSysModelInstId();
        }
        return super.getPSSysModelInstId();
    }
}

