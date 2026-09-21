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
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryReturn;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Util.PSModelCodeNameUtils;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSDEDataQueryReturnImpl
extends PSObjectImpl
implements IPSDEDataQueryReturn {
    private static final Log log = LogFactory.getLog(PSDEDataQueryReturnImpl.class);
    protected IPSDEDataQuery iPSDEDataQuery;
    private String strType = "UNKNOWN";
    private IPSDEFGroup iPSDEFGroup = null;
    private IPSDEMethodDTO iPSDEMethodDTO = null;
    private String strCodeName = null;
    private boolean bCalcPSDEMethodDTO = false;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEDataQuery iPSDEDataQuery) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEDataQuery = iPSDEDataQuery;
            this.setId(KeyValueHelper.genUniqueId((String)iPSDEDataQuery.getId(), (String)"RETURN"));
            this.strCodeName = String.format("%1$sResult", PSModelCodeNameUtils.capitalize(iPSDEDataQuery.getCodeName()));
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
        this.strType = "DTOS";
        this.iPSDEFGroup = this.getPSDEDataQuery().getPSDEFGroup();
        super.onInit();
        if (StringHelper.compare((String)this.getType(), (String)"DTO", (boolean)false) == 0 || StringHelper.compare((String)this.getType(), (String)"DTOS", (boolean)false) == 0 || StringHelper.compare((String)this.getType(), (String)"PAGE", (boolean)false) == 0) {
            this.setCalcPSDEMethodDTO(true);
        }
    }

    @Override
    protected int onCheck() throws Exception {
        this.getPSDEMethodDTO();
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\u5bf9\u8c61", outputdoc="false")
    public IPSDEDataQuery getPSDEDataQuery() {
        return this.iPSDEDataQuery;
    }

    @Override
    @PSModelRTMeta(description="\u8fd4\u56de\u7c7b\u578b", codelist="DEMethodReturnType")
    public String getType() {
        return this.strType;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u7ec4\u5bf9\u8c61")
    public IPSDEFGroup getPSDEFGroup() {
        return this.iPSDEFGroup;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDEDataQuery().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSDEDATAQUERYRETURN";
    }

    @Override
    public String getModelId() {
        if (this.getPSDEDataQuery() != null) {
            return String.format("%1$s#%2$s", this.getPSDEDataQuery().getModelId(), this.getId());
        }
        return super.getModelId();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEDataQuery().getPSDataEntity().getPSSystem());
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u65b9\u6cd5DTO\u5bf9\u8c61", dumpref=true, from="IPSDataEntity")
    public IPSDEMethodDTO getPSDEMethodDTO() throws Exception {
        if (this.iPSDEMethodDTO == null && this.isCalcPSDEMethodDTO()) {
            this.iPSDEMethodDTO = this.getPSDEFGroup() != null ? this.getPSDEDataQuery().getPSDataEntity().getPSDEMethodDTO(this.getPSDEFGroup()) : this.getPSDEDataQuery().getPSDataEntity().getDefaultPSDEMethodDTO();
        }
        return this.iPSDEMethodDTO;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6", dump=false)
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSDEDataQuery();
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
}

