/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSLanguageItem;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSLanguageItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSLanguageItemImpl
extends PSSystemObjectImpl
implements IPSLanguageItem {
    private static final Log log = LogFactory.getLog(PSLanguageItemImpl.class);
    protected PSLanguageItem psLanguageItem = null;
    private String strContent = null;
    private IPSLanguageRes iPSLanguageRes = null;
    private IPSSystemModule iPSSystemModule = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSLanguageItem psLanguageItem) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psLanguageItem = psLanguageItem;
            this.setId(this.psLanguageItem.getPSLANGUAGEITEMID());
            this.setName(this.psLanguageItem.getPSLANGUAGEITEMNAME());
            this.setPSObjectData(this.psLanguageItem);
            this.strContent = this.psLanguageItem.getCONTENT();
            if (StringHelper.isNullOrEmpty((String)this.strContent)) {
                this.strContent = this.psLanguageItem.getCONTENT2();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psLanguageItem.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psLanguageItem.getPSMODULEID());
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
        if (!StringHelper.isNullOrEmpty((String)this.psLanguageItem.getPSLANGUAGERESID())) {
            this.iPSLanguageRes = this.getPSSystem().getPSLanguageRes(this.psLanguageItem.getPSLANGUAGERESID());
        }
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSLANGUAGEITEM";
    }

    @Override
    public IPSLanguageRes getPSLanguageRes() {
        return this.iPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9")
    public String getContent() {
        return this.strContent;
    }

    @Override
    public String getLanguage() {
        return this.psLanguageItem.getPSLANGUAGEID();
    }

    @Override
    @PSModelRTMeta(description="\u8bed\u8a00\u8d44\u6e90\u6807\u8bb0")
    public String getLanResTag() {
        if (this.getPSLanguageRes() == null) {
            return null;
        }
        return this.getPSLanguageRes().getLanResTag();
    }

    @Override
    public String getModelRefId() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u540d\u79f0", order=100, dump=false)
    public String getName() {
        return super.getName();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757")
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }
}

