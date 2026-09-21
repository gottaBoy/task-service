/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.EAI;

import SA.SRFDA.PS.Core.EAI.IPSSysEAIDataType;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIDataTypeItem;
import SA.SRFDA.PS.Core.EAI.PSSysEAIDataTypeObjectImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSSysEAIDataTypeItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysEAIDataTypeItemImpl
extends PSSysEAIDataTypeObjectImpl
implements IPSSysEAIDataTypeItem {
    private static final Log log = LogFactory.getLog(PSSysEAIDataTypeItemImpl.class);
    protected PSSysEAIDataTypeItem psSysEAIDataTypeItem = null;
    private String strData = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysEAIDataType iPSSysEAIDataType, PSSysEAIDataTypeItem psSysEAIDataTypeItem) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysEAIDataType(iPSSysEAIDataType);
            this.psSysEAIDataTypeItem = psSysEAIDataTypeItem;
            this.setId(this.psSysEAIDataTypeItem.getPSSYSEAIDATATYPEITEMID());
            this.setName(this.psSysEAIDataTypeItem.getPSSYSEAIDATATYPEITEMNAME());
            this.setPSObjectData(this.psSysEAIDataTypeItem);
            if (!StringHelper.isNullOrEmpty((String)this.psSysEAIDataTypeItem.getDATA())) {
                this.strData = this.psSysEAIDataTypeItem.getDATA();
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
    public String getModelType() {
        return "PSSYSEAIDATATYPEITEM";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psSysEAIDataTypeItem.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u9879\u6807\u8bb0", hideempty2=true)
    public String getItemTag() {
        return this.psSysEAIDataTypeItem.getEAIDATATYPEITEMTAG();
    }

    @Override
    @PSModelRTMeta(description="\u9879\u6807\u8bb02", hideempty2=true)
    public String getItemTag2() {
        return this.psSysEAIDataTypeItem.getEAIDATATYPEITEMTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u503c", hideempty=true)
    public String getValue() {
        return this.psSysEAIDataTypeItem.getVALUE();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e", hideempty=true)
    public String getData() {
        return this.strData;
    }
}

