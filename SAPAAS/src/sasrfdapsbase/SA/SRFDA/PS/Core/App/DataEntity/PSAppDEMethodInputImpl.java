/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethod;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodDTO;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodInput;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionInput;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetInput;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodInput;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIMethodInput;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppDEMethodInputImpl
extends PSObjectImpl
implements IPSAppDEMethodInput {
    private static final Log log = LogFactory.getLog(PSAppDEMethodInputImpl.class);
    private IPSAppDEMethod iPSAppDEMethod = null;
    private IPSDEMethodInput iPSDEMethodInput = null;
    private IPSAppDEMethodDTO iPSAppDEMethodDTO = null;
    private boolean bOutput = false;
    private IPSAppDEField keyPSAppDEField = null;
    private IPSDEMethodDTO iPSDEMethodDTO = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppDEMethod iPSAppDEMethod, IPSDEMethodInput iPSDEMethodInput) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSAppDEMethod = iPSAppDEMethod;
            this.iPSDEMethodInput = iPSDEMethodInput;
            this.setId(KeyValueHelper.genUniqueId((String)this.getPSAppDEMethod().getId(), (String)this.getPSDEMethodInput().getId()));
            this.setName(this.getPSDEMethodInput().getName());
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        if (this.getPSDEMethodInput() instanceof IPSDEServiceAPIMethodInput) {
            IPSDEServiceAPIMethodInput iPSDEServiceAPIMethodInput = (IPSDEServiceAPIMethodInput)this.getPSDEMethodInput();
            if (iPSDEServiceAPIMethodInput.getKeyPSDEServiceAPIField() != null) {
                this.keyPSAppDEField = this.getPSAppDEMethod().getPSAppDataEntity().getPSAppDEField(iPSDEServiceAPIMethodInput.getKeyPSDEServiceAPIField().getPSDEField(), false);
            } else {
                this.iPSDEMethodDTO = iPSDEServiceAPIMethodInput.getPSDEMethodDTO();
                if (iPSDEServiceAPIMethodInput.getPSDEServiceAPIMethod().getPSDEAction() != null && iPSDEServiceAPIMethodInput.getPSDEServiceAPIMethod().getPSDEAction().getPSDEActionInput() != null) {
                    this.bOutput = iPSDEServiceAPIMethodInput.getPSDEServiceAPIMethod().getPSDEAction().getPSDEActionInput().isOutput();
                }
            }
        } else if (this.getPSDEMethodInput() instanceof IPSDEActionInput) {
            IPSDEActionInput iPSDEActionInput = (IPSDEActionInput)this.getPSDEMethodInput();
            if (iPSDEActionInput.getKeyPSDEField() != null) {
                this.keyPSAppDEField = this.getPSAppDEMethod().getPSAppDataEntity().getPSAppDEField(iPSDEActionInput.getKeyPSDEField(), false);
            } else {
                this.iPSDEMethodDTO = iPSDEActionInput.getPSDEMethodDTO();
                this.bOutput = iPSDEActionInput.isOutput();
            }
        } else if (this.getPSDEMethodInput() instanceof IPSDEDataSetInput) {
            IPSDEDataSetInput iPSDEDataSetInput = (IPSDEDataSetInput)this.getPSDEMethodInput();
            this.iPSDEMethodDTO = iPSDEDataSetInput.getPSDEFilterDTO();
        }
        super.onInit();
    }

    @Override
    protected int onCheck() throws Exception {
        this.getPSAppDEMethodDTO();
        return super.onCheck();
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSAppDEMethod();
    }

    @Override
    @PSModelRTMeta(description="\u76f8\u5173\u5b9e\u4f53\u65b9\u6cd5\u8f93\u5165\u5bf9\u8c61")
    public IPSDEMethodInput getPSDEMethodInput() {
        return this.iPSDEMethodInput;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u65b9\u6cd5\u5bf9\u8c61", outputdoc="false")
    public IPSAppDEMethod getPSAppDEMethod() {
        return this.iPSAppDEMethod;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSAppDEMethod().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSAPPDEMETHODINPUT";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSAppDEMethod().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSAppDEMethod().getPSAppDataEntity().getPSApplication().getPSSystem());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSAppDEMethod().getModelId(), (Object)this.getName());
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.getPSDEMethodInput().getCodeName();
    }

    @Override
    protected boolean onGetAutoModel() {
        return true;
    }

    @Override
    public String getMemo() {
        return this.getPSDEMethodInput().getMemo();
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u7c7b\u578b", codelist="DEMethodInputType")
    public String getType() {
        return this.getPSDEMethodInput().getType();
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165DTO\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSAppDataEntity")
    public IPSAppDEMethodDTO getPSAppDEMethodDTO() throws Exception {
        if (this.iPSDEMethodDTO != null && this.iPSAppDEMethodDTO == null) {
            this.iPSAppDEMethodDTO = this.getPSAppDEMethod().getPSAppDataEntity().getPSAppDEMethodDTO(this.iPSDEMethodDTO);
        }
        return this.iPSAppDEMethodDTO;
    }

    @Override
    @PSModelRTMeta(description="\u540c\u65f6\u4e3a\u7ed3\u679c\u8f93\u51fa", ignoredumpvalues="false")
    public boolean isOutput() {
        return this.bOutput;
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u4e3b\u952e\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSAppDataEntity")
    public IPSAppDEField getKeyPSAppDEField() {
        return this.keyPSAppDEField;
    }
}

