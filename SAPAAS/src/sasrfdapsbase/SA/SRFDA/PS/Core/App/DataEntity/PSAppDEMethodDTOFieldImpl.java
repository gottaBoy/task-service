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

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodDTO;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodDTOField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERCustom;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTOField;
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

public class PSAppDEMethodDTOFieldImpl
extends PSObjectImpl
implements IPSAppDEMethodDTOField {
    private static final Log log = LogFactory.getLog(PSAppDEMethodDTOFieldImpl.class);
    private IPSAppDEMethodDTO iPSAppDEMethodDTO = null;
    private IPSDEMethodDTOField iPSDEMethodDTOField = null;
    private IPSAppDEField iPSAppDEField = null;
    private IPSAppDEMethodDTO refPSAppDEMethodDTO = null;
    private boolean bCalcRefPSAppDEMethodDTO = false;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppDEMethodDTO iPSAppDEMethodDTO, IPSDEMethodDTOField iPSDEMethodDTOField) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSAppDEMethodDTO = iPSAppDEMethodDTO;
            this.iPSDEMethodDTOField = iPSDEMethodDTOField;
            this.setId(KeyValueHelper.genUniqueId((String)this.getPSAppDEMethodDTO().getId(), (String)this.getPSDEMethodDTOField().getId()));
            this.setName(this.getPSDEMethodDTOField().getName());
            if (this.getPSDEMethodDTOField().getPSDEField() != null) {
                this.iPSAppDEField = this.getPSAppDEMethodDTO().getPSAppDataEntity().getPSAppDEField(this.getPSDEMethodDTOField().getPSDEField(), true);
            }
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
        if (this.getPSDEMethodDTOField().getRefPSDEMethodDTO() != null) {
            this.setCalcRefPSAppDEMethodDTO(true);
        }
        super.onInit();
    }

    @Override
    protected int onCheck() throws Exception {
        this.getRefPSAppDEMethodDTO();
        this.getRefPickupPSAppDEField();
        return super.onCheck();
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSAppDEMethodDTO();
    }

    protected IPSAppDEMethodDTO calcRefPSAppDEMethodDTO(IPSDEMethodDTO iPSDEMethodDTO) throws Exception {
        if (StringHelper.compare((String)this.getPSAppDEMethodDTO().getPSDEMethodDTO().getId(), (String)iPSDEMethodDTO.getId(), (boolean)false) == 0) {
            return this.getPSAppDEMethodDTO();
        }
        IPSAppDataEntity refPSAppDataEntity = this.getPSAppDEMethodDTO().getPSAppDataEntity().getPSApplication().getPSAppDataEntity(iPSDEMethodDTO.getPSDataEntity(), true);
        if (refPSAppDataEntity == null) {
            throw new Exception(String.format("\u5b9e\u4f53[%1$s]\u672a\u52a0\u5165\u5e94\u7528[%2$s]", iPSDEMethodDTO.getPSDataEntity().getFullName(), this.getPSAppDEMethodDTO().getPSAppDataEntity().getPSApplication().getName()));
        }
        return refPSAppDataEntity.getPSAppDEMethodDTO(iPSDEMethodDTO);
    }

    @Override
    @PSModelRTMeta(description="\u76f8\u5173\u5b9e\u4f53\u65b9\u6cd5DTO\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEMethodDTOField getPSDEMethodDTOField() {
        return this.iPSDEMethodDTOField;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u65b9\u6cd5DTO\u5bf9\u8c61")
    public IPSAppDEMethodDTO getPSAppDEMethodDTO() {
        return this.iPSAppDEMethodDTO;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSAppDataEntity")
    public IPSAppDEField getPSAppDEField() {
        return this.iPSAppDEField;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSAppDEMethodDTO().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSAPPDEMETHODDTOFIELD";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSAppDEMethodDTO().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSAppDEMethodDTO().getPSAppDataEntity().getPSApplication().getPSSystem());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSAppDEMethodDTO().getModelId(), (Object)this.getName());
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.getPSDEMethodDTOField().getCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c", ignoredumpvalues="99999", dump=false)
    public int getOrderValue() {
        return this.getPSDEMethodDTOField().getOrderValue();
    }

    @Override
    @PSModelRTMeta(description="\u5141\u8bb8\u7a7a\u8f93\u5165", ignoredumpvalues="true")
    public boolean isAllowEmpty() {
        return this.getPSDEMethodDTOField().isAllowEmpty();
    }

    @Override
    protected boolean onGetAutoModel() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u4e2d\u6587\u540d\u79f0")
    public String getLogicName() {
        return this.getPSDEMethodDTOField().getLogicName();
    }

    @Override
    public String getMemo() {
        return this.getPSDEMethodDTOField().getMemo();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53DTO\u5bf9\u8c61\u5c5e\u6027\u7c7b\u578b", codelist="DEMethodDTOFieldType")
    public String getType() {
        return this.getPSDEMethodDTOField().getType();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u51c6\u6570\u636e\u7c7b\u578b", codelist="StdDataType", ignoredumpvalues="0")
    public int getStdDataType() {
        return this.getPSDEMethodDTOField().getStdDataType();
    }

    @Override
    @PSModelRTMeta(description="Json\u683c\u5f0f\u5316")
    public String getJsonFormat() {
        return this.getPSDEMethodDTOField().getJsonFormat();
    }

    @Override
    @PSModelRTMeta(description="\u662f\u5426\u4e3aList\u7684MAP\u6295\u5c04", ignoredumpvalues="false")
    public boolean isListMap() {
        return this.getPSDEMethodDTOField().isListMap();
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
            this.refPSAppDEMethodDTO = this.calcRefPSAppDEMethodDTO(this.getPSDEMethodDTOField().getRefPSDEMethodDTO());
        }
        return this.refPSAppDEMethodDTO;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5e94\u7528\u5b9e\u4f53\u7684\u5d4c\u5957\u6570\u636e\u96c6", dumpref=true, from="__self__", from_method="getRefPSAppDataEntityMust().getPSAppDEDataSet")
    public IPSAppDEDataSet getRefPSAppDEDataSet() throws Exception {
        if (this.getRefPSAppDataEntity() != null && this.getPSDEMethodDTOField().getPSDER() != null) {
            if (this.getPSDEMethodDTOField().getPSDER() instanceof IPSDER1N) {
                IPSDER1N iPSDER1N = (IPSDER1N)this.getPSDEMethodDTOField().getPSDER();
                if (iPSDER1N.getNestedPSDEDataSet() != null) {
                    return this.getRefPSAppDataEntity().getPSAppDEDataSet(iPSDER1N.getNestedPSDEDataSet(), true);
                }
                return null;
            }
            if (this.getPSDEMethodDTOField().getPSDER() instanceof IPSDERCustom) {
                IPSDERCustom iPSDERCustom = (IPSDERCustom)this.getPSDEMethodDTOField().getPSDER();
                if (iPSDERCustom.getNestedPSDEDataSet() != null) {
                    return this.getRefPSAppDataEntity().getPSAppDEDataSet(iPSDERCustom.getNestedPSDEDataSet(), true);
                }
                return null;
            }
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="DTO\u5c5e\u6027\u6765\u6e90\u7c7b\u578b", codelist="DEMethodDTOFieldSourceType")
    public String getSourceType() {
        return this.getPSDEMethodDTOField().getSourceType();
    }

    protected boolean isCalcRefPSAppDEMethodDTO() {
        return this.bCalcRefPSAppDEMethodDTO;
    }

    protected void setCalcRefPSAppDEMethodDTO(boolean bCalcRefPSAppDEMethodDTO) {
        this.bCalcRefPSAppDEMethodDTO = bCalcRefPSAppDEMethodDTO;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5e94\u7528\u5b9e\u4f53\u7684\u8fde\u63a5\u5c5e\u6027", dumpref=true, from="__self__", from_method="getRefPSAppDataEntityMust().getPSAppDEField")
    public IPSAppDEField getRefPickupPSAppDEField() throws Exception {
        if (this.getRefPSAppDataEntity() != null && this.getPSDEMethodDTOField().getPSDER() != null) {
            if (this.getPSDEMethodDTOField().getPSDER() instanceof IPSDER1N) {
                IPSDER1N iPSDER1N = (IPSDER1N)this.getPSDEMethodDTOField().getPSDER();
                return this.getRefPSAppDataEntity().getPSAppDEField(iPSDER1N.getPSPickupDEField(), true);
            }
            if (this.getPSDEMethodDTOField().getPSDER() instanceof IPSDERCustom) {
                IPSDERCustom iPSDERCustom = (IPSDERCustom)this.getPSDEMethodDTOField().getPSDER();
                if (iPSDERCustom.getPickupPSDEField() != null) {
                    return this.getRefPSAppDataEntity().getPSAppDEField(iPSDERCustom.getPickupPSDEField(), true);
                }
                return null;
            }
        }
        return null;
    }
}

