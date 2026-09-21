/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.res.IPSLanguageRes
 *  net.ibizsys.model.res.IPSPortletType
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.res;

import java.util.Properties;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSSystemObjectImpl;
import net.ibizsys.model.entity.PSSysPortlet;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.res.IPSPortletType;
import net.ibizsys.model.res.IPSSysPortletRuntime;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysPortletImpl
extends PSSystemObjectImpl
implements IPSSysPortletRuntime {
    private static final Log log = LogFactory.getLog(PSSysPortletImpl.class);
    protected PSSysPortlet psSysPortlet = null;
    private String strCodeName = "";
    private int nReloadTimer = 0;
    private boolean bShowTitleBar = true;
    private Properties baseClassParams = null;
    private IPSPortletType iPSPortletType = null;
    private int nHeight = 300;
    private IPSLanguageRes titlePSLanguageRes = null;
    private String strEmptyText = null;
    private IPSLanguageRes emptyTextPSLanguageRes = null;
    private String strPSACHandlerId = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSSystem iPSSystem, PSSysPortlet psSysPortlet) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSSystem(iPSSystem);
            this.psSysPortlet = psSysPortlet;
            this.setId(this.psSysPortlet.getPSSYSPORTLETID());
            this.setName(this.psSysPortlet.getPSSYSPORTLETNAME());
            this.strCodeName = this.psSysPortlet.getCODENAME();
            this.iPSPortletType = this.getPSModelStorageContext().getPSPortletType(this.getPortletType());
            this.setPSObjectData(this.psSysPortlet);
            if (this.psSysPortlet.getRELOADTIMER() > 0) {
                this.nReloadTimer = this.psSysPortlet.getRELOADTIMER();
            }
            if (!this.psSysPortlet.isSHOWTITLEBARNull()) {
                this.bShowTitleBar = this.psSysPortlet.getSHOWTITLEBAR();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysPortlet.getTITLEPSLANRESID())) {
                this.titlePSLanguageRes = this.getPSSystem().getPSLanguageRes(this.psSysPortlet.getTITLEPSLANRESID());
            }
            if (this.psSysPortlet.getHEIGHT() > 0) {
                this.nHeight = this.psSysPortlet.getHEIGHT();
            }
            this.strEmptyText = this.psSysPortlet.getEMPTYTEXT();
            if (!StringHelper.isNullOrEmpty((String)this.psSysPortlet.getEMPTYTEXTPSLANRESID())) {
                this.emptyTextPSLanguageRes = this.getPSSystem().getPSLanguageRes(this.psSysPortlet.getEMPTYTEXTPSLANRESID());
            }
            this.strPSACHandlerId = this.psSysPortlet.getPSACHANDLERID();
            this.baseClassParams = PropertiesHelper.load((String)this.psSysPortlet.getBASECLSPARAMS());
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

    @PSModelRTMeta(description="\u90e8\u4ef6\u7c7b\u578b", codelist="PortletType")
    public String getPortletType() {
        return this.psSysPortlet.getPORTLETTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f0")
    public String getCodeName() {
        return this.psSysPortlet.getCODENAME();
    }

    @PSModelRTMeta(description="\u62ac\u5934")
    public String getTitle() {
        return this.psSysPortlet.getLOGICNAME();
    }

    @PSModelRTMeta(description="\u62ac\u5934\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getTitlePSIpsLanguageRes() {
        return this.titlePSLanguageRes;
    }

    @PSModelRTMeta(description="\u5237\u65b0\u95f4\u9694\uff08\u6beb\u79d2\uff09")
    public int getReloadTimer() {
        return this.nReloadTimer;
    }

    @PSModelRTMeta(description="\u663e\u793a\u62ac\u5934\u680f")
    public boolean isShowTitleBar() {
        return this.bShowTitleBar;
    }

    @PSModelRTMeta(description="\u9ad8\u5ea6")
    public int getHeight() {
        return this.nHeight;
    }

    public IPSPortletType getPSPortletType() {
        return this.iPSPortletType;
    }

    @PSModelRTMeta(description="\u7a7a\u767d\u5185\u5bb9\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getEmptyTextPSLanguageRes() {
        return this.emptyTextPSLanguageRes;
    }

    @PSModelRTMeta(description="\u7a7a\u767d\u663e\u793a\u5185\u5bb9")
    public String getEmptyText() {
        return this.strEmptyText;
    }

    @PSModelRTMeta(description="\u62ac\u5934\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61")
    public IPSLanguageRes getTitlePSLanguageRes() {
        return this.titlePSLanguageRes;
    }

    public String getPSACHandlerId() {
        return this.strPSACHandlerId;
    }
}

