/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanel;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelDataItem;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelField;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelItem;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.Data.IPSDataItemParam;
import SA.SRFDA.PS.Core.Data.PSDataItemImpl;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysPanelDataItemImpl
extends PSDataItemImpl
implements IPSSysPanelDataItem {
    private static final Log log = LogFactory.getLog(PSSysPanelDataItemImpl.class);
    private IPSSysPanel iPSSysPanel = null;
    private IPSSysPanelItem iPSSysPanelItem = null;
    private IPSDEField iPSDEField = null;
    private IPSAppDEField iPSAppDEField = null;

    public void init(IPSSysPanelItem iPSSysPanelItem) throws Exception {
        this.iPSSysPanelItem = iPSSysPanelItem;
        this.iPSSysPanel = this.iPSSysPanelItem.getPSSysPanel();
        if (StringHelper.isNullOrEmpty((String)this.getName())) {
            this.setName(this.iPSSysPanelItem.getName());
        }
        this.onInit();
    }

    public void init(IPSSysPanel iPSSysPanel) throws Exception {
        this.iPSSysPanel = iPSSysPanel;
        this.onInit();
    }

    @Override
    public String getModelId() {
        if (this.getPSSysPanel() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSysPanel().getModelId(), (Object)this.getName());
        }
        return super.getModelId();
    }

    @Override
    public String getModelType() {
        return "PSSYSPANELDATAITEM";
    }

    @Override
    public IPSSysPanel getPSSysPanel() {
        return this.iPSSysPanel;
    }

    @Override
    public String getPSSysModelInstId() {
        if (this.getPSSysPanel() != null) {
            return this.getPSSysPanel().getPSSysModelInstId();
        }
        return super.getPSSysModelInstId();
    }

    @Override
    public IPSSysPanelItem getPSSysPanelItem() {
        return this.iPSSysPanelItem;
    }

    @Override
    public IPSDEField getPSDEField() {
        if (this.iPSDEField != null) {
            return this.iPSDEField;
        }
        IPSDEField iPSDEField = null;
        if (this.getDataItemParam() != null && this.getDataItemParam() instanceof IPSDataItemParam && (iPSDEField = ((IPSDataItemParam)this.getDataItemParam()).getPSDEField()) == null && this.getPSSysPanel() != null && this.getPSSysPanel().getPSDataEntity() != null) {
            try {
                iPSDEField = this.getPSSysPanel().getPSDataEntity().getPSDEField(this.getDataItemParam().getName(), true);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        if (iPSDEField == null && this.getPSSysPanelItem() != null && this.getPSSysPanelItem() instanceof IPSSysPanelField && this.getPSSysPanel() != null && this.getPSSysPanel().getPSDataEntity() != null) {
            try {
                iPSDEField = this.getPSSysPanel().getPSDataEntity().getPSDEField(((IPSSysPanelField)this.getPSSysPanelItem()).getFieldName(), true);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        try {
            if (iPSDEField != null && this.getPSSysPanel() != null && this.getPSSysPanel().getPSAppDataEntity() != null) {
                this.iPSAppDEField = this.getPSSysPanel().getPSAppDataEntity().getPSAppDEField(iPSDEField.getId(), true);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.iPSDEField = iPSDEField;
        return this.iPSDEField;
    }

    @Override
    public IPSAppDEField getPSAppDEField() {
        this.getPSDEField();
        return this.iPSAppDEField;
    }
}

