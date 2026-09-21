/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.Control;

import SA.SRFDA.PS.Core.App.Control.IPSAppPortlet;
import SA.SRFDA.PS.Core.App.Control.IPSAppPortletCat;
import SA.SRFDA.PS.Core.App.Control.IPSAppPortletRuntime;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBPortletPart;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBSysPortletPart;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSSysPortlet;
import SA.SRFDA.PS.Data.PSAppPortlet;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Properties;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppPortletImpl
extends PSApplicationObjectImpl
implements IPSAppPortlet,
IPSAppPortletRuntime {
    private static final Log log = LogFactory.getLog(PSAppPortletImpl.class);
    protected PSAppPortlet psAppPortlet = null;
    private IPSSysPortlet iPSSysPortlet = null;
    private IPSControl iPSControl = null;
    private String strCodeName = null;
    private IPSAppPortletCat iPSAppPortletCat = null;
    private IPSAppDataEntity iPSAppDataEntity = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, PSAppPortlet psAppPortlet) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(iPSApplication);
            this.psAppPortlet = psAppPortlet;
            this.setId(this.psAppPortlet.getPSAPPPORTLETID());
            this.setName(this.psAppPortlet.getPSAPPPORTLETNAME());
            this.setPSObjectData(psAppPortlet);
            this.strCodeName = psAppPortlet.getCODENAME();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psAppPortlet.getPSSYSPORTLETID())) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7cfb\u7edf\u95e8\u6237\u90e8\u4ef6");
            }
            this.iPSSysPortlet = this.getPSSystem().getPSSysPortlet(this.psAppPortlet.getPSSYSPORTLETID());
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.iPSSysPortlet.getCodeName();
            }
            this.iPSAppPortletCat = this.getPSSysPortlet().getPSSysPortletCat() != null ? this.getPSApplication().getPSAppPortletCat(this.getPSSysPortlet().getPSSysPortletCat().getId()) : this.getPSApplication().getUngroupPSAppPortletCat();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psAppPortlet.getPSAPPLOCALDEID())) {
                this.iPSAppDataEntity = this.getPSApplication().getPSAppDataEntity(psAppPortlet.getPSAPPLOCALDEID(), false);
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

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, IPSControl iPSControl) throws Exception {
        try {
            IPSDBPortletPart iPSDBPortletPart;
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(iPSApplication);
            this.iPSControl = iPSControl;
            this.setId(this.iPSControl.getId());
            this.strCodeName = iPSControl.getCodeName();
            if (iPSControl instanceof IPSDBPortletPart && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)(iPSDBPortletPart = (IPSDBPortletPart)iPSControl).getTitle())) {
                this.setName(iPSDBPortletPart.getTitle());
            }
            if (iPSControl instanceof IPSDBSysPortletPart) {
                IPSDBSysPortletPart iPSDBSysPortletPart = (IPSDBSysPortletPart)iPSControl;
                this.iPSSysPortlet = iPSDBSysPortletPart.getPSSysPortlet();
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName)) {
                    this.strCodeName = this.iPSSysPortlet.getCodeName();
                }
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getName())) {
                    this.setName(this.iPSSysPortlet.getTitle());
                }
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getName())) {
                this.setName(this.iPSControl.getName());
            }
            this.iPSAppPortletCat = this.getPSSysPortlet() != null && this.getPSSysPortlet().getPSSysPortletCat() != null ? this.getPSApplication().getPSAppPortletCat(this.getPSSysPortlet().getPSSysPortletCat().getId()) : this.getPSApplication().getUngroupPSAppPortletCat();
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
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u95e8\u6237\u90e8\u4ef6")
    public IPSSysPortlet getPSSysPortlet() {
        return this.iPSSysPortlet;
    }

    @Override
    public String getModelType() {
        return "PSAPPPORTLET";
    }

    @Override
    public String getModelId() {
        if (this.getPSApplication() != null) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSApplication().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSApplication().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    public void setPSControl(IPSControl iPSControl) {
        this.iPSControl = iPSControl;
    }

    @Override
    @PSModelRTMeta(description="\u63a7\u4ef6\u5bf9\u8c61", dumpref=true, rtdump=2)
    public IPSControl getPSControl() {
        return this.iPSControl;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u95e8\u6237\u90e8\u4ef6\u5206\u7c7b", child=true, group="\u57fa\u672c", order=120)
    public IPSAppPortletCat getPSAppPortletCat() {
        return this.iPSAppPortletCat;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", dumpref=true, fields={"PSAPPLOCALDEID"})
    public IPSAppDataEntity getPSAppDataEntity() {
        if (this.iPSAppDataEntity != null) {
            return this.iPSAppDataEntity;
        }
        if (this.getPSControl() != null) {
            return this.getPSControl().getPSAppDataEntity();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5e94\u7528\u5168\u5c40\u6570\u636e\u770b\u677f")
    public boolean isEnableAppDashboard() {
        if (this.getPSSysPortlet() != null) {
            return this.getPSSysPortlet().isEnableAppDashboard();
        }
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5b9e\u4f53\u6570\u636e\u770b\u677f", ignoredumpvalues="false")
    public boolean isEnableDEDashboard() {
        if (this.getPSAppDataEntity() != null && this.getPSSysPortlet() != null) {
            return this.getPSSysPortlet().isEnableDEDashboard();
        }
        return false;
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u52a8\u6001\u53c2\u6570", hideempty=true)
    public Properties getPortletParams() {
        if (this.getPSSysPortlet() != null) {
            return this.getPSSysPortlet().getPortletParams();
        }
        return null;
    }

    @Override
    protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
        super.onFillModelNode(objectNode, strModelType);
        if (this.getPSApplication().isEnableUIModelEx() && this.getPSAppPortletCat() != null) {
            ObjectNode node = (ObjectNode)objectNode.get("getPSAppPortletCat");
            node.remove("getPSSystemModule");
            node.remove("getPSSysCss");
            node.remove("getPSSysImage");
        }
    }
}

