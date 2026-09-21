/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.dr.IPSDEDRGroup
 *  net.ibizsys.model.res.IPSLanguageRes
 *  net.ibizsys.model.res.IPSSysImage
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.dr;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.PSDataEntityObjectImpl;
import net.ibizsys.model.dataentity.dr.IPSDEDRGroup;
import net.ibizsys.model.entity.PSDEDRGroup;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDRGroupImpl
extends PSDataEntityObjectImpl
implements IPSDEDRGroup {
    private static final Log log = LogFactory.getLog(PSDEDRGroupImpl.class);
    protected PSDEDRGroup psDEDRGroup = null;
    private IPSSysImage iPSSysImage = null;
    private IPSLanguageRes capPSLanguageRes = null;
    private boolean bHidden = false;

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDataEntity iPSDataEntity, PSDEDRGroup psDEDRGroup) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSDataEntity(iPSDataEntity);
            this.psDEDRGroup = psDEDRGroup;
            this.setId(this.psDEDRGroup.getPSDEDRGROUPID());
            this.setName(this.psDEDRGroup.getPSDEDRGROUPNAME());
            this.setPSObjectData(this.psDEDRGroup);
            if (!StringHelper.isNullOrEmpty((String)this.psDEDRGroup.getPSSYSIMAGEID())) {
                this.iPSSysImage = this.getPSDataEntity().getPSSystem().getPSSysImage(this.psDEDRGroup.getPSSYSIMAGEID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEDRGroup.getCAPPSLANRESID())) {
                this.capPSLanguageRes = this.getPSDataEntity().getPSSystem().getPSLanguageRes(this.psDEDRGroup.getCAPPSLANRESID());
            }
            if (!this.psDEDRGroup.isHIDDENFLAGNull()) {
                this.bHidden = this.psDEDRGroup.getHIDDENFLAG();
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

    public String getCaption(String strLanguage) {
        return this.psDEDRGroup.getPSDEDRGROUPNAME();
    }

    @PSModelRTMeta(description="\u5206\u7ec4\u56fe\u6807\u8d44\u6e90\u5bf9\u8c61")
    public IPSSysImage getPSSysImage() {
        return this.iPSSysImage;
    }

    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61")
    public IPSLanguageRes getCapPSLanguageRes() {
        return this.capPSLanguageRes;
    }

    @PSModelRTMeta(description="\u9690\u85cf\u5206\u7ec4")
    public boolean isHidden() {
        return this.bHidden;
    }

    @PSModelRTMeta(description="\u6807\u9898")
    public String getCaption() {
        return this.psDEDRGroup.getPSDEDRGROUPNAME();
    }
}

