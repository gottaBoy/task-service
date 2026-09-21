/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.res.IPSLanguageItem
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.res;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSSystemObjectImpl;
import net.ibizsys.model.entity.PSLanguageRes;
import net.ibizsys.model.res.IPSLanguageItem;
import net.ibizsys.model.res.IPSLanguageResRuntime;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSLanguageResImpl
extends PSSystemObjectImpl
implements IPSLanguageResRuntime {
    private static final Log log = LogFactory.getLog(PSLanguageResImpl.class);
    protected PSLanguageRes psLanguageRes = null;
    private String strLanResTag = null;
    private String strLanResType = null;
    private String strDefaultValue = null;
    private String strShortLanResTag = null;
    private boolean bShortLanResTag = false;
    private boolean bUserRefFlag = false;
    private boolean bSysRefFlag = false;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSSystem iPSSystem, PSLanguageRes psLanguageRes) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSSystem(iPSSystem);
            this.psLanguageRes = psLanguageRes;
            this.setId(this.psLanguageRes.getPSLANGUAGERESID());
            this.setName(this.psLanguageRes.getPSLANGUAGERESNAME());
            this.setPSObjectData(this.psLanguageRes);
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
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @PSModelRTMeta(description="\u8bed\u8a00\u8d44\u6e90\u6807\u8bb0")
    public String getLanResTag() {
        return this.strLanResTag;
    }

    public String getDefaultContent() {
        return this.strDefaultValue;
    }

    @PSModelRTMeta(description="\u8bed\u8a00\u8d44\u6e90\u7c7b\u578b", codelist="SysLanResType")
    public String getLanResType() {
        return this.strLanResType;
    }

    public String getShortLanResTag() {
        return this.strShortLanResTag;
    }

    public String getContent(String strLocale) throws Exception {
        return this.getContent(strLocale, true);
    }

    @PSModelRTMeta(description="\u5b9a\u4e49\u77ed\u8d44\u6e90\u6807\u8bc6")
    public boolean hasShortLanResTag() {
        return this.bShortLanResTag;
    }

    public boolean isUserRef() {
        return this.bUserRefFlag;
    }

    @PSModelRTMeta(description="\u5f15\u7528\u6807\u5fd7")
    public boolean getRefFlag() {
        return this.isUserRef() || this.bSysRefFlag;
    }

    public void markSysRef(Object objRef, String strMemo) {
        this.bSysRefFlag = true;
    }

    public void markSysRef() {
        this.bSysRefFlag = true;
    }

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
}

