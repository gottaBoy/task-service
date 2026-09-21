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

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethod;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodDTO;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodReturn;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionReturn;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetReturn;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodReturn;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIMethodReturn;
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

public class PSAppDEMethodReturnImpl
extends PSObjectImpl
implements IPSAppDEMethodReturn {
    private static final Log log = LogFactory.getLog(PSAppDEMethodReturnImpl.class);
    private IPSAppDEMethod iPSAppDEMethod = null;
    private IPSDEMethodReturn iPSDEMethodReturn = null;
    private IPSAppDEMethodDTO iPSAppDEMethodDTO = null;
    private int nStdDataType = 0;
    private IPSDEMethodDTO iPSDEMethodDTO = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppDEMethod iPSAppDEMethod, IPSDEMethodReturn iPSDEMethodReturn) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSAppDEMethod = iPSAppDEMethod;
            this.iPSDEMethodReturn = iPSDEMethodReturn;
            this.setId(KeyValueHelper.genUniqueId((String)this.getPSAppDEMethod().getId(), (String)this.getPSDEMethodReturn().getId()));
            this.setName(this.getPSDEMethodReturn().getName());
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
        if (this.getPSDEMethodReturn() instanceof IPSDEServiceAPIMethodReturn) {
            IPSDEServiceAPIMethodReturn iPSDEServiceAPIMethodReturn = (IPSDEServiceAPIMethodReturn)this.getPSDEMethodReturn();
            this.iPSDEMethodDTO = iPSDEServiceAPIMethodReturn.getPSDEMethodDTO();
            this.nStdDataType = iPSDEServiceAPIMethodReturn.getStdDataType();
        } else if (this.getPSDEMethodReturn() instanceof IPSDEActionReturn) {
            IPSDEActionReturn iPSDEActionReturn = (IPSDEActionReturn)this.getPSDEMethodReturn();
            this.iPSDEMethodDTO = iPSDEActionReturn.getPSDEMethodDTO();
            this.nStdDataType = iPSDEActionReturn.getStdDataType();
        } else if (this.getPSDEMethodReturn() instanceof IPSDEDataSetReturn) {
            IPSDEDataSetReturn iPSDEDataSetReturn = (IPSDEDataSetReturn)this.getPSDEMethodReturn();
            this.iPSDEMethodDTO = iPSDEDataSetReturn.getPSDEMethodDTO();
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
    @PSModelRTMeta(description="\u76f8\u5173\u5b9e\u4f53\u65b9\u6cd5\u8fd4\u56de\u5bf9\u8c61")
    public IPSDEMethodReturn getPSDEMethodReturn() {
        return this.iPSDEMethodReturn;
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
        return "PSAPPDEMETHODRETURN";
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
        return this.getPSDEMethodReturn().getCodeName();
    }

    @Override
    protected boolean onGetAutoModel() {
        return true;
    }

    @Override
    public String getMemo() {
        return this.getPSDEMethodReturn().getMemo();
    }

    @Override
    @PSModelRTMeta(description="\u8fd4\u56de\u7c7b\u578b", codelist="DEMethodReturnType")
    public String getType() {
        return this.getPSDEMethodReturn().getType();
    }

    @Override
    @PSModelRTMeta(description="\u8fd4\u56deDTO\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSAppDataEntity")
    public IPSAppDEMethodDTO getPSAppDEMethodDTO() throws Exception {
        if (this.iPSDEMethodDTO != null && this.iPSAppDEMethodDTO == null) {
            this.iPSAppDEMethodDTO = this.getPSAppDEMethod().getPSAppDataEntity().getPSAppDEMethodDTO(this.iPSDEMethodDTO);
        }
        return this.iPSAppDEMethodDTO;
    }

    @Override
    @PSModelRTMeta(description="\u7b80\u5355\u503c\u7c7b\u578b", ignoredumpvalues="0", codelist="StdDataType")
    public int getStdDataType() {
        return this.nStdDataType;
    }
}

