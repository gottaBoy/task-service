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
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.IPSModelData;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSModelObj;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSModelDataImpl
extends PSObjectImpl
implements IPSModelData {
    private static final Log log = LogFactory.getLog(PSModelDataImpl.class);
    private PSModelObj psModelObj = null;
    private IPSModelObject iPSModelObject = null;
    private String strCodeName = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSModelObject iPSModelObject, PSModelObj psModelObj) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSModelObject = iPSModelObject;
            this.psModelObj = psModelObj;
            if (!StringHelper.isNullOrEmpty((String)psModelObj.getPSMODELOBJID())) {
                this.setId(psModelObj.getPSMODELOBJID());
            } else {
                this.setId(KeyValueHelper.genUniqueId((String)this.psModelObj.getPSMODELTYPE(), (String)this.psModelObj.getREALMODELOBJID()));
            }
            this.setName(this.psModelObj.getPSMODELOBJNAME());
            this.setPSObjectData(this.psModelObj);
            this.strCodeName = psModelObj.getCODENAME();
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
    public IPSModelObject getPSModelObject() {
        return this.iPSModelObject;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSModelObject().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSMODELDATA$" + this.getPSModelObject().getModelType();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        if (this.getPSModelObject() instanceof IPSSystemObject) {
            return (IPSSystemUtil)((Object)((IPSSystemObject)this.getPSModelObject()).getPSSystem());
        }
        if (this.getPSModelObject() instanceof IPSDataEntityObject) {
            return (IPSSystemUtil)((Object)((IPSDataEntityObject)this.getPSModelObject()).getPSDataEntity().getPSSystem());
        }
        return null;
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSModelObject().getModelId(), (Object)super.getModelId());
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u578b\u5185\u5bb9")
    public String getContent() {
        return this.psModelObj.getCONTENT();
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u578b\u6807\u8bb0")
    public String getModelTag() {
        return this.psModelObj.getMODELTAG();
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u578b\u6807\u8bb02")
    public String getModelTag2() {
        return this.psModelObj.getMODELTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u578b\u903b\u8f91\u540d\u79f0")
    public String getLogicName() {
        return this.psModelObj.getLOGICNAME();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u9645\u6a21\u578b\u7c7b\u578b")
    public String getRealModelType() {
        return this.psModelObj.getPSMODELTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u9645\u6a21\u578b\u6807\u8bc6", dump=false)
    public String getRealModelId() {
        return this.psModelObj.getREALMODELOBJID();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u9645\u6a21\u578b\u5b50\u7c7b\u578b")
    public String getRealModelSubType() {
        return this.psModelObj.getPSMODELSUBTYPE();
    }
}

