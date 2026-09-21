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
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetInput;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetParam;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEFilterDTO;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Util.PSModelCodeNameUtils;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSDEDataSetInputImpl
extends PSObjectImpl
implements IPSDEDataSetInput {
    private static final Log log = LogFactory.getLog(PSDEDataSetInputImpl.class);
    protected IPSDEDataSet iPSDEDataSet;
    private String strType = "UNKNOWN";
    private IPSSysDynaModel refPSSysDynaModel = null;
    private IPSDEFilterDTO iPSDEFilterDTO = null;
    private IPSDEFGroup iPSDEFGroup = null;
    private String strCodeName = null;
    private boolean bCalcPSDEMethodDTO = false;
    private boolean bDEMethodParamMode = false;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEDataSet iPSDEDataSet) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEDataSet = iPSDEDataSet;
            this.setId(KeyValueHelper.genUniqueId((String)iPSDEDataSet.getId(), (String)"INPUT"));
            this.strCodeName = String.format("%1$sInput", PSModelCodeNameUtils.capitalize(iPSDEDataSet.getCodeName()));
            this.setName(this.getCodeName());
            this.setAutoModel(true);
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
        boolean bl = this.bDEMethodParamMode = this.getPSDEDataSet().getParamMode() == 2;
        if (!this.bDEMethodParamMode) {
            this.iPSDEFGroup = this.getPSDEDataSet().getInPSDEFGroup();
        }
        this.strType = "DTO";
        super.onInit();
        this.setCalcPSDEMethodDTO(true);
    }

    @Override
    protected int onCheck() throws Exception {
        this.getPSDEFilterDTO();
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u96c6\u5bf9\u8c61", outputdoc="false")
    public IPSDEDataSet getPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u7c7b\u578b", codelist="DEMethodInputType")
    public String getType() {
        return this.strType;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDEDataSet().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSDEDATASETINPUT";
    }

    @Override
    public String getModelId() {
        if (this.getPSDEDataSet() != null) {
            return String.format("%1$s#%2$s", this.getPSDEDataSet().getModelId(), this.getId());
        }
        return super.getModelId();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEDataSet().getPSDataEntity().getPSSystem());
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u7ec4\u5bf9\u8c61")
    public IPSDEFGroup getPSDEFGroup() {
        return this.iPSDEFGroup;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u53c2\u6570\u6a21\u578b\u5bf9\u8c61")
    public IPSSysDynaModel getRefPSSysDynaModel() {
        return this.refPSSysDynaModel;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u8fc7\u6ee4\u5668DTO", from="IPSDataEntity", from_method="getPSDEMethodDTO", origin="IPSDEFilterDTO", dumpref=true)
    public IPSDEFilterDTO getPSDEFilterDTO() throws Exception {
        if (this.iPSDEFilterDTO == null && this.isCalcPSDEMethodDTO()) {
            this.iPSDEFilterDTO = this.bDEMethodParamMode ? this.getPSDEDataSet().getPSDataEntity().getPSDEDataSetInputDTO(this) : (this.getRefPSSysDynaModel() != null ? this.getPSDEDataSet().getPSDataEntity().getPSDEFilterDTO(this.getRefPSSysDynaModel()) : (this.getPSDEFGroup() != null ? this.getPSDEDataSet().getPSDataEntity().getPSDEFilterDTO(this.getPSDEFGroup()) : this.getPSDEDataSet().getPSDataEntity().getDefaultPSDEFilterDTO()));
        }
        return this.iPSDEFilterDTO;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6", dump=false)
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSDEDataSet();
    }

    @Override
    protected String onGetMOSFolder() {
        return null;
    }

    @Override
    protected String onGetRTMOSFolder() {
        return null;
    }

    protected boolean isCalcPSDEMethodDTO() {
        return this.bCalcPSDEMethodDTO;
    }

    protected void setCalcPSDEMethodDTO(boolean bCalcPSDEMethodDTO) {
        this.bCalcPSDEMethodDTO = bCalcPSDEMethodDTO;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u96c6\u53c2\u6570\u96c6\u5408", ignorepf=true, outputdoc="false")
    public Iterator<IPSDEDataSetParam> getPSDEDataSetParams() {
        if (this.bDEMethodParamMode) {
            return this.getPSDEDataSet().getPSDEDataSetParams();
        }
        return null;
    }
}

