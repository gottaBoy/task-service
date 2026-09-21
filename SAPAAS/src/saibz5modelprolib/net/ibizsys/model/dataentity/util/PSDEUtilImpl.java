/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.util;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.PSDataEntityObjectImpl;
import net.ibizsys.model.dataentity.util.IPSDEUtilRuntime;
import net.ibizsys.model.entity.PSDEUtil;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEUtilImpl
extends PSDataEntityObjectImpl
implements IPSDEUtilRuntime {
    private static final Log log = LogFactory.getLog(PSDEUtilImpl.class);
    protected PSDEUtil psDEUtil;
    private String strUtilPSDEId = null;
    private String strUtilPSDE2Id = null;
    private String strUtilPSDE3Id = null;
    private String strUtilPSDE4Id = null;
    private String strUtilPSDE5Id = null;
    private String strUtilPSDE6Id = null;
    private String strUtilPSDE7Id = null;
    private String strUtilPSDE8Id = null;
    private String strUtilPSDE9Id = null;
    private String strUtilPSDE10Id = null;
    private String strUtilPSDE11Id = null;
    private String strUtilPSDE12Id = null;
    private String strUtilPSDE13Id = null;
    private String strUtilPSDE14Id = null;
    private String strUtilPSDE15Id = null;
    private String strUtilPSDE16Id = null;
    private String strUtilPSDE17Id = null;
    private String strUtilPSDE18Id = null;
    private String strUtilPSDE19Id = null;
    private String strUtilPSDE20Id = null;
    private String strUtilPSDEName = null;
    private String strUtilPSDE2Name = null;
    private String strUtilPSDE3Name = null;
    private String strUtilPSDE4Name = null;
    private String strUtilPSDE5Name = null;
    private String strUtilPSDE6Name = null;
    private String strUtilPSDE7Name = null;
    private String strUtilPSDE8Name = null;
    private String strUtilPSDE9Name = null;
    private String strUtilPSDE10Name = null;
    private String strUtilPSDE11Name = null;
    private String strUtilPSDE12Name = null;
    private String strUtilPSDE13Name = null;
    private String strUtilPSDE14Name = null;
    private String strUtilPSDE15Name = null;
    private String strUtilPSDE16Name = null;
    private String strUtilPSDE17Name = null;
    private String strUtilPSDE18Name = null;
    private String strUtilPSDE19Name = null;
    private String strUtilPSDE20Name = null;
    private String strUtilType = null;
    private int nExtendMode = 0;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDataEntity iPSDataEntity, PSDEUtil psDEUtil) throws Exception {
        try {
            this.setPSDataEntity(iPSDataEntity);
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.psDEUtil = psDEUtil;
            this.setId(psDEUtil.getPSDEUTILDEID());
            this.setName(psDEUtil.getPSDEUTILDENAME());
            this.setPSObjectData(this.psDEUtil);
            if (!this.psDEUtil.isEXTENDMODENull()) {
                this.nExtendMode = this.psDEUtil.getEXTENDMODE();
            }
            this.strUtilPSDEId = this.psDEUtil.getUTILPSDEID();
            this.strUtilPSDE2Id = this.psDEUtil.getUTILPSDE2ID();
            this.strUtilPSDE3Id = this.psDEUtil.getUTILPSDE3ID();
            this.strUtilPSDE4Id = this.psDEUtil.getUTILPSDE4ID();
            this.strUtilPSDE5Id = this.psDEUtil.getUTILPSDE5ID();
            this.strUtilPSDE6Id = this.psDEUtil.getUTILPSDE6ID();
            this.strUtilPSDE7Id = this.psDEUtil.getUTILPSDE7ID();
            this.strUtilPSDE8Id = this.psDEUtil.getUTILPSDE8ID();
            this.strUtilPSDE9Id = this.psDEUtil.getUTILPSDE9ID();
            this.strUtilPSDE10Id = this.psDEUtil.getUTILPSDE10ID();
            this.strUtilPSDE11Id = this.psDEUtil.getUTILPSDE11ID();
            this.strUtilPSDE12Id = this.psDEUtil.getUTILPSDE12ID();
            this.strUtilPSDE13Id = this.psDEUtil.getUTILPSDE13ID();
            this.strUtilPSDE14Id = this.psDEUtil.getUTILPSDE14ID();
            this.strUtilPSDE15Id = this.psDEUtil.getUTILPSDE15ID();
            this.strUtilPSDE16Id = this.psDEUtil.getUTILPSDE16ID();
            this.strUtilPSDE17Id = this.psDEUtil.getUTILPSDE17ID();
            this.strUtilPSDE18Id = this.psDEUtil.getUTILPSDE18ID();
            this.strUtilPSDE19Id = this.psDEUtil.getUTILPSDE19ID();
            this.strUtilPSDE20Id = this.psDEUtil.getUTILPSDE20ID();
            this.strUtilPSDEName = this.psDEUtil.getUTILPSDENAME();
            this.strUtilPSDE2Name = this.psDEUtil.getUTILPSDE2NAME();
            this.strUtilPSDE3Name = this.psDEUtil.getUTILPSDE3NAME();
            this.strUtilPSDE4Name = this.psDEUtil.getUTILPSDE4NAME();
            this.strUtilPSDE5Name = this.psDEUtil.getUTILPSDE5NAME();
            this.strUtilPSDE6Name = this.psDEUtil.getUTILPSDE6NAME();
            this.strUtilPSDE7Name = this.psDEUtil.getUTILPSDE7NAME();
            this.strUtilPSDE8Name = this.psDEUtil.getUTILPSDE8NAME();
            this.strUtilPSDE9Name = this.psDEUtil.getUTILPSDE9NAME();
            this.strUtilPSDE10Name = this.psDEUtil.getUTILPSDE10NAME();
            this.strUtilPSDE11Name = this.psDEUtil.getUTILPSDE11NAME();
            this.strUtilPSDE12Name = this.psDEUtil.getUTILPSDE12NAME();
            this.strUtilPSDE13Name = this.psDEUtil.getUTILPSDE13NAME();
            this.strUtilPSDE14Name = this.psDEUtil.getUTILPSDE14NAME();
            this.strUtilPSDE15Name = this.psDEUtil.getUTILPSDE15NAME();
            this.strUtilPSDE16Name = this.psDEUtil.getUTILPSDE16NAME();
            this.strUtilPSDE17Name = this.psDEUtil.getUTILPSDE17NAME();
            this.strUtilPSDE18Name = this.psDEUtil.getUTILPSDE18NAME();
            this.strUtilPSDE19Name = this.psDEUtil.getUTILPSDE19NAME();
            this.strUtilPSDE20Name = this.psDEUtil.getUTILPSDE20NAME();
            this.strUtilType = this.psDEUtil.getUTILTYPE();
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

    public String getUtilType() {
        return this.strUtilType;
    }

    public String getUtilPSDEId() {
        return this.strUtilPSDEId;
    }

    public String getUtilPSDE2Id() {
        return this.strUtilPSDE2Id;
    }

    public String getUtilPSDE3Id() {
        return this.strUtilPSDE3Id;
    }

    public String getUtilPSDE4Id() {
        return this.strUtilPSDE4Id;
    }

    public String getUtilPSDE5Id() {
        return this.strUtilPSDE5Id;
    }

    public String getUtilPSDE6Id() {
        return this.strUtilPSDE6Id;
    }

    public String getUtilPSDE7Id() {
        return this.strUtilPSDE7Id;
    }

    public String getUtilPSDE8Id() {
        return this.strUtilPSDE8Id;
    }

    public String getUtilPSDE9Id() {
        return this.strUtilPSDE9Id;
    }

    public String getUtilPSDE10Id() {
        return this.strUtilPSDE10Id;
    }

    public String getUtilPSDE11Id() {
        return this.strUtilPSDE11Id;
    }

    public String getUtilPSDE12Id() {
        return this.strUtilPSDE12Id;
    }

    public String getUtilPSDE13Id() {
        return this.strUtilPSDE13Id;
    }

    public String getUtilPSDE14Id() {
        return this.strUtilPSDE14Id;
    }

    public String getUtilPSDE15Id() {
        return this.strUtilPSDE15Id;
    }

    public String getUtilPSDE16Id() {
        return this.strUtilPSDE16Id;
    }

    public String getUtilPSDE17Id() {
        return this.strUtilPSDE17Id;
    }

    public String getUtilPSDE18Id() {
        return this.strUtilPSDE18Id;
    }

    public String getUtilPSDE19Id() {
        return this.strUtilPSDE19Id;
    }

    public String getUtilPSDE20Id() {
        return this.strUtilPSDE20Id;
    }

    public String getUtilPSDEName() {
        return this.strUtilPSDEName;
    }

    public String getUtilPSDE2Name() {
        return this.strUtilPSDE2Name;
    }

    public String getUtilPSDE3Name() {
        return this.strUtilPSDE3Name;
    }

    public String getUtilPSDE4Name() {
        return this.strUtilPSDE4Name;
    }

    public String getUtilPSDE5Name() {
        return this.strUtilPSDE5Name;
    }

    public String getUtilPSDE6Name() {
        return this.strUtilPSDE6Name;
    }

    public String getUtilPSDE7Name() {
        return this.strUtilPSDE7Name;
    }

    public String getUtilPSDE8Name() {
        return this.strUtilPSDE8Name;
    }

    public String getUtilPSDE9Name() {
        return this.strUtilPSDE9Name;
    }

    public String getUtilPSDE10Name() {
        return this.strUtilPSDE10Name;
    }

    public String getUtilPSDE11Name() {
        return this.strUtilPSDE11Name;
    }

    public String getUtilPSDE12Name() {
        return this.strUtilPSDE12Name;
    }

    public String getUtilPSDE13Name() {
        return this.strUtilPSDE13Name;
    }

    public String getUtilPSDE14Name() {
        return this.strUtilPSDE14Name;
    }

    public String getUtilPSDE15Name() {
        return this.strUtilPSDE15Name;
    }

    public String getUtilPSDE16Name() {
        return this.strUtilPSDE16Name;
    }

    public String getUtilPSDE17Name() {
        return this.strUtilPSDE17Name;
    }

    public String getUtilPSDE18Name() {
        return this.strUtilPSDE18Name;
    }

    public String getUtilPSDE19Name() {
        return this.strUtilPSDE19Name;
    }

    public String getUtilPSDE20Name() {
        return this.strUtilPSDE20Name;
    }
}

