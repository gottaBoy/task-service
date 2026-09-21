/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.res;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSSystemObjectImpl;
import net.ibizsys.model.entity.PSSysPDTView;
import net.ibizsys.model.res.IPSSysPDTViewRuntime;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysPDTViewImpl
extends PSSystemObjectImpl
implements IPSSysPDTViewRuntime {
    private static final Log log = LogFactory.getLog(PSSysPDTViewImpl.class);
    protected PSSysPDTView psSysPDTView = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSSystem iPSSystem, PSSysPDTView psSysPDTView) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSSystem(iPSSystem);
            this.psSysPDTView = psSysPDTView;
            this.setId(this.psSysPDTView.getPSSYSPDTVIEWID());
            this.setName(this.psSysPDTView.getPSSYSPDTVIEWNAME());
            this.setPSObjectData(this.psSysPDTView);
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

    public String getPSPDTViewId() {
        return this.psSysPDTView.getPSPDTVIEWID();
    }

    public String getPSDEViewBaseId() {
        return this.psSysPDTView.getPSDEVIEWBASEID();
    }

    public String getCaption(String strLanguage) {
        return this.getName();
    }
}

