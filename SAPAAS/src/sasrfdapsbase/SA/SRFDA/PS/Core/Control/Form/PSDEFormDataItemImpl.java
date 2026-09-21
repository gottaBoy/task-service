/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.Control.Form.IPSDEForm;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDataItem;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.Data.IPSDataItemParam;
import SA.SRFDA.PS.Core.Data.PSDataItemImpl;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFormDataItemImpl
extends PSDataItemImpl
implements IPSDEFormDataItem {
    private static final Log log = LogFactory.getLog(PSDEFormDataItemImpl.class);
    private IPSDEForm iPSDEForm = null;
    private IPSDEFormDetail iPSDEFormDetail = null;
    private IPSDEField iPSDEField = null;
    private IPSAppDEField iPSAppDEField = null;

    public void init(IPSDEFormDetail iPSDEFormDetail) throws Exception {
        this.iPSDEFormDetail = iPSDEFormDetail;
        this.iPSDEForm = this.iPSDEFormDetail.getPSDEForm();
        if (StringHelper.isNullOrEmpty((String)this.getName())) {
            this.setName(this.iPSDEFormDetail.getName());
        }
        this.onInit();
    }

    public void init(IPSDEForm iPSDEForm) throws Exception {
        this.iPSDEForm = iPSDEForm;
        this.onInit();
    }

    @Override
    public String getModelId() {
        if (this.getPSDEForm() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEForm().getModelId(), (Object)this.getName());
        }
        return super.getModelId();
    }

    @Override
    public String getModelType() {
        return "PSDEFORMDATAITEM";
    }

    @Override
    public IPSDEForm getPSDEForm() {
        return this.iPSDEForm;
    }

    @Override
    public String getPSSysModelInstId() {
        if (this.getPSDEForm() != null) {
            return this.getPSDEForm().getPSSysModelInstId();
        }
        return super.getPSSysModelInstId();
    }

    @Override
    public IPSDEFormDetail getPSDEFormDetail() {
        return this.iPSDEFormDetail;
    }

    @Override
    public IPSDEField getPSDEField() {
        if (this.iPSDEField != null) {
            return this.iPSDEField;
        }
        IPSDEField iPSDEField = null;
        if (this.getDataItemParam() != null && this.getDataItemParam() instanceof IPSDataItemParam && (iPSDEField = ((IPSDataItemParam)this.getDataItemParam()).getPSDEField()) == null && this.getPSDEForm() != null) {
            try {
                iPSDEField = this.getPSDEForm().getPSDataEntity().getPSDEField(this.getDataItemParam().getName(), true);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        if (iPSDEField == null && this.getPSDEFormDetail() != null && this.getPSDEFormDetail() instanceof IPSDEFormItem) {
            iPSDEField = ((IPSDEFormItem)this.getPSDEFormDetail()).getPSDEField();
        }
        try {
            if (iPSDEField != null && this.getPSDEForm() != null && this.getPSDEForm().getPSAppDataEntity() != null) {
                this.iPSAppDEField = this.getPSDEForm().getPSAppDataEntity().getPSAppDEField(iPSDEField.getId(), true);
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

