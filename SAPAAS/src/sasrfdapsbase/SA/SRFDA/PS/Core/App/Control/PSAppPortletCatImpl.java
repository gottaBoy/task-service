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
package SA.SRFDA.PS.Core.App.Control;

import SA.SRFDA.PS.Core.App.Control.IPSAppPortletCat;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPortletCat;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysPortletCat;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppPortletCatImpl
extends PSApplicationObjectImpl
implements IPSAppPortletCat {
    private static final Log log = LogFactory.getLog(PSAppPortletCatImpl.class);
    public static final String UNGROUP = "UNGROUP";
    private IPSSysPortletCat iPSSysPortletCat = null;
    private boolean bUngroup = false;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, IPSSysPortletCat iPSSysPortletCat) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(iPSApplication);
            this.iPSSysPortletCat = iPSSysPortletCat;
            if (this.iPSSysPortletCat != null) {
                this.setId(iPSSysPortletCat.getId());
                this.setName(iPSSysPortletCat.getName());
            } else {
                this.setId(UNGROUP);
                this.setName("\uff08\u672a\u5206\u7c7b\uff09");
                this.bUngroup = true;
            }
            if (this.getNamePSLanguageRes() != null) {
                this.getPSApplication().getPSLanguageRes(this.getNamePSLanguageRes().getId());
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
    public String getModelId() {
        if (this.getPSApplication() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSApplication().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysPortletCat psSysPortletCat) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u95e8\u6237\u90e8\u4ef6\u5206\u7c7b", outputdoc="false")
    public IPSSysPortletCat getPSSysPortletCat() {
        return this.iPSSysPortletCat;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.calcCodeName();
    }

    protected String calcCodeName() {
        if (this.getPSSysPortletCat() != null) {
            if (this.getPSApplication().isEnableUIModelEx()) {
                return this.getPSSysPortletCat().getUniqueTag();
            }
            return this.getPSSysPortletCat().getCodeName();
        }
        return "Ungroup";
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", dumpref=true, ignorepf=true)
    public IPSSystemModule getPSSystemModule() {
        if (this.getPSSysPortletCat() != null) {
            return this.getPSSysPortletCat().getPSSystemModule();
        }
        return null;
    }

    @Override
    public String getModelType() {
        return "PSAPPPORTLETCAT";
    }

    @Override
    protected IPSModelObject getProxyPSModelObject() {
        return this.getPSSysPortletCat();
    }

    @Override
    @PSModelRTMeta(description="\u540d\u79f0\u8bed\u8a00\u8d44\u6e90", fields={"NAMEPSLANRESID"})
    public IPSLanguageRes getNamePSLanguageRes() {
        if (this.getPSSysPortletCat() != null) {
            return this.getPSSysPortletCat().getNamePSLanguageRes();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u672a\u5206\u7ec4\u5206\u7c7b", ignoredumpvalues="false")
    public boolean isUngroup() {
        return this.bUngroup;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u56fe\u7247", fields={"PSSYSIMAGEID"})
    public IPSSysImage getPSSysImage() {
        if (this.getPSSysPortletCat() != null) {
            return this.getPSSysPortletCat().getPSSysImage();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u754c\u9762\u6837\u5f0f\u8868", fields={"PSSYSCSSID"})
    public IPSSysCss getPSSysCss() {
        if (this.getPSSysPortletCat() != null) {
            return this.getPSSysPortletCat().getPSSysCss();
        }
        return null;
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }

    @Override
    public int getOrderValue() {
        return 99999;
    }

    @Override
    @PSModelRTMeta(description="\u552f\u4e00\u6807\u8bb0")
    public String getUniqueTag() {
        if (this.getPSSysPortletCat() != null) {
            return this.getPSSysPortletCat().getUniqueTag();
        }
        return "Ungroup";
    }

    @Override
    protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
        super.onFillModelNode(objectNode, strModelType);
        objectNode.remove("getPSSystemModule");
    }
}

