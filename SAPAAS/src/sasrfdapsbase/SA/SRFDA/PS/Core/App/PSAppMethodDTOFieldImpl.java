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
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodDTO;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSAppMethodDTO;
import SA.SRFDA.PS.Core.App.IPSAppMethodDTOField;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Service.IPSSysMethodDTO;
import SA.SRFDA.PS.Core.Service.IPSSysMethodDTOField;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppMethodDTOFieldImpl
extends PSObjectImpl
implements IPSAppMethodDTOField {
    private static final Log log = LogFactory.getLog(PSAppMethodDTOFieldImpl.class);
    private IPSAppMethodDTO iPSAppMethodDTO = null;
    private IPSSysMethodDTOField iPSSysMethodDTOField = null;
    private IPSAppDEMethodDTO refPSAppDEMethodDTO = null;
    private IPSAppMethodDTO refPSAppMethodDTO = null;
    private boolean bCalcRefPSAppDEMethodDTO = false;
    private boolean bCalcRefPSAppMethodDTO = false;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppMethodDTO iPSAppMethodDTO, IPSSysMethodDTOField iPSSysMethodDTOField) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSAppMethodDTO = iPSAppMethodDTO;
            this.iPSSysMethodDTOField = iPSSysMethodDTOField;
            this.setId(KeyValueHelper.genUniqueId((String)this.getPSAppMethodDTO().getId(), (String)this.getPSSysMethodDTOField().getId()));
            this.setName(this.getPSSysMethodDTOField().getName());
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
        if (this.getPSSysMethodDTOField().getRefPSDEMethodDTO() != null) {
            this.setCalcRefPSAppDEMethodDTO(true);
        }
        if (this.getPSSysMethodDTOField().getRefPSSysMethodDTO() != null) {
            this.setCalcRefPSAppMethodDTO(true);
        }
        super.onInit();
    }

    @Override
    protected int onCheck() throws Exception {
        if (this.getRefPSAppDEMethodDTO() != null) {
            this.getRefPSAppDEMethodDTO().check();
        }
        if (this.getRefPSAppMethodDTO() != null) {
            this.getRefPSAppMethodDTO().check();
        }
        return super.onCheck();
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSAppMethodDTO();
    }

    protected IPSAppDEMethodDTO calcRefPSAppDEMethodDTO(IPSDEMethodDTO iPSDEMethodDTO) throws Exception {
        IPSAppDataEntity refPSAppDataEntity = this.getPSAppMethodDTO().getPSApplication().getPSAppDataEntity(iPSDEMethodDTO.getPSDataEntity(), true);
        if (refPSAppDataEntity == null) {
            throw new Exception(String.format("\u5b9e\u4f53[%1$s]\u672a\u52a0\u5165\u5f53\u524d\u5e94\u7528", iPSDEMethodDTO.getPSDataEntity().getFullName()));
        }
        return refPSAppDataEntity.getPSAppDEMethodDTO(iPSDEMethodDTO);
    }

    protected IPSAppMethodDTO calcRefPSAppMethodDTO(IPSSysMethodDTO iPSSysMethodDTO) throws Exception {
        if (StringHelper.compare((String)this.getPSAppMethodDTO().getPSSysMethodDTO().getId(), (String)iPSSysMethodDTO.getId(), (boolean)false) == 0) {
            return this.getPSAppMethodDTO();
        }
        return this.getPSAppMethodDTO().getPSApplication().getPSAppMethodDTO(iPSSysMethodDTO);
    }

    @Override
    @PSModelRTMeta(description="\u76f8\u5173\u7cfb\u7edf\u65b9\u6cd5DTO\u5c5e\u6027\u5bf9\u8c61")
    public IPSSysMethodDTOField getPSSysMethodDTOField() {
        return this.iPSSysMethodDTOField;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u65b9\u6cd5DTO\u5bf9\u8c61")
    public IPSAppMethodDTO getPSAppMethodDTO() {
        return this.iPSAppMethodDTO;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSAppMethodDTO().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSAPPMETHODDTOFIELD";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSAppMethodDTO().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSAppMethodDTO().getPSApplication().getPSSystem());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSAppMethodDTO().getModelId(), (Object)this.getName());
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.getPSSysMethodDTOField().getCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c", ignoredumpvalues="99999", dump=false)
    public int getOrderValue() {
        return this.getPSSysMethodDTOField().getOrderValue();
    }

    @Override
    @PSModelRTMeta(description="\u5141\u8bb8\u7a7a\u8f93\u5165", ignoredumpvalues="true")
    public boolean isAllowEmpty() {
        return this.getPSSysMethodDTOField().isAllowEmpty();
    }

    @Override
    protected boolean onGetAutoModel() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u4e2d\u6587\u540d\u79f0")
    public String getLogicName() {
        return this.getPSSysMethodDTOField().getLogicName();
    }

    @Override
    public String getMemo() {
        return this.getPSSysMethodDTOField().getMemo();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528DTO\u5bf9\u8c61\u5c5e\u6027\u7c7b\u578b", codelist="DEMethodDTOFieldType")
    public String getType() {
        return this.getPSSysMethodDTOField().getType();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u51c6\u6570\u636e\u7c7b\u578b", codelist="StdDataType", ignoredumpvalues="0")
    public int getStdDataType() {
        return this.getPSSysMethodDTOField().getStdDataType();
    }

    @Override
    @PSModelRTMeta(description="Json\u683c\u5f0f\u5316")
    public String getJsonFormat() {
        return this.getPSSysMethodDTOField().getJsonFormat();
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", hideempty=true, dumpref=true)
    public IPSAppDataEntity getRefPSAppDataEntity() throws Exception {
        if (this.getRefPSAppDEMethodDTO() == null) {
            return null;
        }
        return this.getRefPSAppDEMethodDTO().getPSAppDataEntity();
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5e94\u7528\u5b9e\u4f53\u65b9\u6cd5DTO\u5bf9\u8c61", outputdoc="false", dumpref=true, from="__self__", from_method="getRefPSAppDataEntityMust().getPSAppDEMethodDTO")
    public IPSAppDEMethodDTO getRefPSAppDEMethodDTO() throws Exception {
        if (this.refPSAppDEMethodDTO == null && this.isCalcRefPSAppDEMethodDTO()) {
            this.refPSAppDEMethodDTO = this.calcRefPSAppDEMethodDTO(this.getPSSysMethodDTOField().getRefPSDEMethodDTO());
        }
        return this.refPSAppDEMethodDTO;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5e94\u7528\u65b9\u6cd5DTO\u5bf9\u8c61", outputdoc="false", dumpref=true, from="IPSApplication")
    public IPSAppMethodDTO getRefPSAppMethodDTO() throws Exception {
        if (this.refPSAppMethodDTO == null && this.isCalcRefPSAppMethodDTO()) {
            this.refPSAppMethodDTO = this.calcRefPSAppMethodDTO(this.getPSSysMethodDTOField().getRefPSSysMethodDTO());
        }
        return this.refPSAppMethodDTO;
    }

    @Override
    @PSModelRTMeta(description="DTO\u5c5e\u6027\u6765\u6e90\u7c7b\u578b", codelist="DEMethodDTOFieldSourceType")
    public String getSourceType() {
        return this.getPSSysMethodDTOField().getSourceType();
    }

    protected boolean isCalcRefPSAppDEMethodDTO() {
        return this.bCalcRefPSAppDEMethodDTO;
    }

    protected void setCalcRefPSAppDEMethodDTO(boolean bCalcRefPSAppDEMethodDTO) {
        this.bCalcRefPSAppDEMethodDTO = bCalcRefPSAppDEMethodDTO;
    }

    protected boolean isCalcRefPSAppMethodDTO() {
        return this.bCalcRefPSAppMethodDTO;
    }

    protected void setCalcRefPSAppMethodDTO(boolean bCalcRefPSAppMethodDTO) {
        this.bCalcRefPSAppMethodDTO = bCalcRefPSAppMethodDTO;
    }
}

