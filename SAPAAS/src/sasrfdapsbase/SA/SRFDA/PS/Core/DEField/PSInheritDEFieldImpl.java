/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.service.ActionSession
 *  net.ibizsys.paas.service.ActionSessionManager
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSInheritDEField;
import SA.SRFDA.PS.Core.DEField.PSLinkDEFieldImpl;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFramework.Utility.StringHelper;
import net.ibizsys.paas.service.ActionSession;
import net.ibizsys.paas.service.ActionSessionManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSInheritDEFieldImpl
extends PSLinkDEFieldImpl
implements IPSInheritDEField {
    private static final Log log = LogFactory.getLog(PSInheritDEFieldImpl.class);
    private IPSDEField realInheritPSDEField = null;

    @Override
    @PSModelRTMeta(description="\u7ee7\u627f\u5c5e\u6027", doc="\u6052\u4e3atrue")
    public boolean isInheritDEField() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u7269\u7406\u5c5e\u6027", ignoredumpvalues="true")
    public boolean isPhisicalDEField() {
        try {
            if (this.getPSDataEntity().getPSDERInherit() != null && this.getPSDataEntity().getPSDERInherit().isSameTable()) {
                return this.getRelatedPSDEField().isPhisicalDEField();
            }
            if (this.getPSDataEntity().getVirtualMode() == 5) {
                return this.getRelatedPSDEField().isPhisicalDEField();
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u9645\u7ee7\u627f\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getRealInheritPSDEField() throws Exception {
        this.prepareRealInheritPSDEField();
        return this.realInheritPSDEField;
    }

    protected synchronized void prepareRealInheritPSDEField() throws Exception {
        if (this.realInheritPSDEField != null) {
            return;
        }
        boolean bClose = false;
        ActionSession actionSession = null;
        try {
            actionSession = ActionSessionManager.getCurrentSession();
            if (actionSession == null) {
                bClose = true;
                actionSession = ActionSessionManager.openSession((String)"PSInheritDEFieldImpl");
                actionSession.registerRecursion("PSDEFIELD", (Object)this.getId());
            } else if (!actionSession.registerRecursion("PSDEFIELD", (Object)this.getId())) {
                throw new Exception(StringHelper.Format((String)"\u5c5e\u6027[%1$s]\u5b58\u5728\u9012\u5f52\u5173\u7cfb", (Object)this.getFullName()));
            }
            if (this.getRelatedPSDEField().isInheritDEField()) {
                IPSInheritDEField iInheritDEFHelper = null;
                if (this.getRelatedPSDEField() instanceof IPSInheritDEField) {
                    iInheritDEFHelper = (IPSInheritDEField)this.getRelatedPSDEField();
                }
                if (iInheritDEFHelper == null) {
                    log.error((Object)StringHelper.Format((String)"\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61\u6ca1\u6709\u5b9e\u73b0\u63a5\u53e3[IPSInheritDEField]", (Object)this.getRelatedPSDEField().getFullName()));
                }
                this.realInheritPSDEField = iInheritDEFHelper.getRealInheritPSDEField();
                if (this.realInheritPSDEField == null) {
                    log.error((Object)StringHelper.Format((String)"\u5c5e\u6027[%1$s]\u5b9e\u9645\u5173\u7cfb\u5c5e\u6027\u65e0\u6548", (Object)this.getRelatedPSDEField().getFullName()));
                }
            } else {
                this.realInheritPSDEField = this.getRelatedPSDEField();
            }
            actionSession.unregisterRecursion("PSDEFIELD", (Object)this.getId());
            if (bClose) {
                ActionSessionManager.closeSession();
            }
        }
        catch (Exception ex) {
            if (bClose) {
                ActionSessionManager.closeSession();
            }
            throw ex;
        }
    }

    @Override
    protected IPSDEField onGetRestrictedPSDEField() throws Exception {
        IPSDEField iPSDEField = super.onGetRestrictedPSDEField();
        if (iPSDEField != null) {
            return iPSDEField;
        }
        iPSDEField = this.getRelatedPSDEField().getRestrictedPSDEField();
        if (iPSDEField != null) {
            return this.getPSDataEntity().getPSDEField(iPSDEField.getName(), true);
        }
        return null;
    }

    @Override
    protected IPSDEField onGetValuePSDEField() throws Exception {
        IPSDEField iPSDEField = super.onGetValuePSDEField();
        if (iPSDEField != null) {
            return iPSDEField;
        }
        iPSDEField = this.getRelatedPSDEField().getValuePSDEField();
        if (iPSDEField != null) {
            return this.getPSDataEntity().getPSDEField(iPSDEField.getName(), true);
        }
        return null;
    }

    @Override
    protected boolean onGetEnableAudit() throws Exception {
        if (this.getRelatedPSDEField() != null) {
            return this.getRelatedPSDEField().isPhisicalDEField();
        }
        return super.onGetEnableAudit();
    }
}

