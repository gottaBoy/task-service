/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.res.IPSLanguageRes
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.res;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSSystemObjectImpl;
import net.ibizsys.model.entity.PSLanguageItem;
import net.ibizsys.model.res.IPSLanguageItemRuntime;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSLanguageItemImpl
extends PSSystemObjectImpl
implements IPSLanguageItemRuntime {
    private static final Log log = LogFactory.getLog(PSLanguageItemImpl.class);
    protected PSLanguageItem psLanguageItem = null;
    private String strContent = null;
    private IPSLanguageRes iPSLanguageRes = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSSystem iPSSystem, PSLanguageItem psLanguageItem) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSSystem(iPSSystem);
            this.psLanguageItem = psLanguageItem;
            this.setId(this.psLanguageItem.getPSLANGUAGEITEMID());
            this.setName(this.psLanguageItem.getPSLANGUAGEITEMNAME());
            this.setPSObjectData(this.psLanguageItem);
            this.strContent = this.psLanguageItem.getCONTENT();
            if (StringHelper.isNullOrEmpty((String)this.strContent)) {
                this.strContent = this.psLanguageItem.getCONTENT2();
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
        this.iPSLanguageRes = this.getPSSystem().getPSLanguageRes(this.psLanguageItem.getPSLANGUAGERESID());
        super.onInit();
    }

    public IPSLanguageRes getPSLanguageRes() {
        return this.iPSLanguageRes;
    }

    public String getContent() {
        return this.strContent;
    }
}

