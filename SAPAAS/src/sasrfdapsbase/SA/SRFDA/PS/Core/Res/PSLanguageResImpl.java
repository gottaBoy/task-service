/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSLanguageItem;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSLanguageRes;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSLanguageResImpl
extends PSSystemObjectImpl
implements IPSLanguageRes {
    private static final Log log = LogFactory.getLog(PSLanguageResImpl.class);
    protected PSLanguageRes psLanguageRes = null;
    private String strLanResTag = null;
    private String strLanResType = null;
    private String strDefaultValue = null;
    private String strShortLanResTag = null;
    private boolean bShortLanResTag = false;
    private boolean bUserRefFlag = false;
    private boolean bSysRefFlag = false;
    private boolean bEnableDefaultValueDefault = true;
    private IPSSystemModule iPSSystemModule = null;
    private String strCodeName = "";

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSLanguageRes psLanguageRes) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psLanguageRes = psLanguageRes;
            this.setId(this.psLanguageRes.getPSLANGUAGERESID());
            this.setName(this.psLanguageRes.getPSLANGUAGERESNAME());
            this.setPSObjectData(this.psLanguageRes);
            this.strCodeName = this.psLanguageRes.getCODENAME();
            this.strLanResTag = this.psLanguageRes.getLANRESTAG();
            this.strLanResType = this.psLanguageRes.getLANRESTYPE();
            this.strDefaultValue = this.psLanguageRes.getCONTENT();
            if (StringHelper.isNullOrEmpty((String)this.strDefaultValue)) {
                this.strDefaultValue = this.psLanguageRes.getCONTENT2();
            }
            this.strShortLanResTag = this.psLanguageRes.getSHORTTAG();
            if (StringHelper.isNullOrEmpty((String)this.strShortLanResTag)) {
                this.strShortLanResTag = this.strLanResTag;
            } else {
                this.bShortLanResTag = true;
            }
            if (!this.psLanguageRes.isAPPREFFLAGNull()) {
                this.bUserRefFlag = this.psLanguageRes.getAPPREFFLAG();
            }
            this.bEnableDefaultValueDefault = this.getPSSystemSetting().isEnableLanResDefaultContent();
            if (!StringHelper.isNullOrEmpty((String)this.psLanguageRes.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psLanguageRes.getPSMODULEID());
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
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u540d\u79f0", order=100)
    public String getName() {
        return super.getName();
    }

    @Override
    public String getModelType() {
        return "PSLANGUAGERES";
    }

    @Override
    @PSModelRTMeta(description="\u8bed\u8a00\u8d44\u6e90\u6807\u8bb0", fields={"LANRESTAG"})
    public String getLanResTag() {
        return this.strLanResTag;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5185\u5bb9", fields={"CONTENT"})
    public String getDefaultContent() {
        return this.strDefaultValue;
    }

    @Override
    @PSModelRTMeta(description="\u8bed\u8a00\u8d44\u6e90\u7c7b\u578b", codelist="SysLanResType", fields={"LANRESTYPE"})
    public String getLanResType() {
        return this.strLanResType;
    }

    @Override
    public String getShortLanResTag() {
        return this.strShortLanResTag;
    }

    @Override
    public String getContent(String strLocale) throws Exception {
        return this.getContent(strLocale, this.bEnableDefaultValueDefault);
    }

    @Override
    @PSModelRTMeta(description="\u5b9a\u4e49\u77ed\u8d44\u6e90\u6807\u8bc6", dump=false)
    public boolean hasShortLanResTag() {
        return this.bShortLanResTag;
    }

    @Override
    public boolean isUserRef() {
        return this.bUserRefFlag;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u6807\u5fd7", ignoredumpvalues="false")
    public boolean getRefFlag() {
        return this.isUserRef() || this.bSysRefFlag;
    }

    @Override
    public void markSysRef(Object objRef, String strMemo) {
        this.bSysRefFlag = true;
    }

    @Override
    public void markSysRef() {
        this.bSysRefFlag = true;
    }

    @Override
    public String getContent(String strLocale, boolean bDefault) throws Exception {
        String strKey = StringHelper.format((String)"%1$s.%2$s", (Object)strLocale, (Object)this.getLanResTag());
        IPSLanguageItem iPSLanguageItem = this.getPSSystem().getPSLanguageItem(strKey, true);
        if (iPSLanguageItem != null && !StringHelper.isNullOrEmpty((String)iPSLanguageItem.getContent())) {
            return iPSLanguageItem.getContent();
        }
        if (bDefault) {
            return this.getDefaultContent();
        }
        return "";
    }

    @Override
    protected boolean isExportModelAlways() {
        return true;
    }

    @Override
    public String getModelRefId() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6", dump=false)
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757")
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    public int getOrderValue() {
        return 99999;
    }

    @Override
    protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
        super.onFillModelNode(objectNode, strModelType);
        if (PSObjectImpl.getDynaModelPubIgnorePF()) {
            objectNode.remove("refFlag");
            objectNode.remove("defaultContent");
            objectNode.remove("lanResType");
            objectNode.remove("name");
        }
    }

    @Override
    public ObjectNode toModelRef(String strType) {
        ObjectNode objectNode = super.toModelRef(strType);
        objectNode.remove("refFlag");
        objectNode.remove("defaultContent");
        objectNode.remove("lanResType");
        objectNode.remove("name");
        return objectNode;
    }
}

