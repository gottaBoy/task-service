/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.field.IPSDEField
 *  net.ibizsys.model.dataentity.field.IPSLinkDEField
 *  net.ibizsys.model.der.IPSDERBase
 *  net.ibizsys.paas.service.ActionSession
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.field;

import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.field.IPSLinkDEField;
import net.ibizsys.model.dataentity.field.PSDEFieldImpl;
import net.ibizsys.model.der.IPSDERBase;
import net.ibizsys.paas.service.ActionSession;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSLinkDEFieldImpl
extends PSDEFieldImpl
implements IPSLinkDEField {
    private IPSDEField relatedPSDEField = null;
    private IPSDEField realPSDEField = null;
    private IPSDEField realPSDEField2 = null;
    private static final Log log = LogFactory.getLog(PSLinkDEFieldImpl.class);
    private IPSDERBase iPSDERBase = null;
    private Boolean bCalcRestrictedPSDEField = false;
    private IPSDEField restrictedPSDEField = null;
    private Object objCalcRestrictedPSDEField = new Object();

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    protected String getRelatedPSDEFId() {
        return this.getPSDEFieldData().getDERPSDEFID();
    }

    @PSModelRTMeta(description="\u5b9e\u9645\u94fe\u63a5\u7269\u7406\u5c5e\u6027")
    public IPSDEField getRealPSDEField() throws Exception {
        this.prepareRealPSDEField(false);
        return this.realPSDEField;
    }

    @PSModelRTMeta(description="\u94fe\u63a5\u5230\u5c5e\u6027")
    public synchronized IPSDEField getRelatedPSDEField() throws Exception {
        if (this.relatedPSDEField != null) {
            return this.relatedPSDEField;
        }
        IPSDataEntity majorPSDataEntity = this.getPSDER().getMajorPSDataEntity();
        if (StringHelper.isNullOrEmpty((String)this.getRelatedPSDEFId())) {
            throw new Exception(StringHelper.format((String)"\u5173\u7cfb\u5c5e\u6027[%1$s]\u6ca1\u6709\u6307\u5b9a\u5f15\u7528\u5c5e\u6027", (Object)this.getFullName()));
        }
        this.relatedPSDEField = majorPSDataEntity.getPSDEField(this.getRelatedPSDEFId(), false);
        return this.relatedPSDEField;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected synchronized void prepareRealPSDEField(boolean bFirstPhisical) throws Exception {
        if (!bFirstPhisical) {
            if (this.realPSDEField != null) {
                return;
            }
            boolean bClose = false;
            try {
                ActionSession actionSession = ActionSessionManager.getCurrentSession();
                if (actionSession == null) {
                    bClose = true;
                    actionSession = ActionSessionManager.openSession((String)"PSLinkDEFieldImpl");
                    actionSession.registerRecursion("PSDEFIELD", (Object)this.getId());
                } else if (!actionSession.registerRecursion("PSDEFIELD", (Object)this.getId())) {
                    throw new Exception(StringHelper.format((String)"\u5c5e\u6027[%1$s]\u5b58\u5728\u9012\u5f52\u5173\u7cfb", (Object)this.getFullName()));
                }
                if (this.getRelatedPSDEField().isLinkDEField()) {
                    IPSLinkDEField iLinkDEFHelper = null;
                    if (this.getRelatedPSDEField() instanceof IPSLinkDEField) {
                        iLinkDEFHelper = (IPSLinkDEField)this.getRelatedPSDEField();
                    }
                    if (iLinkDEFHelper == null) {
                        throw new Exception(StringHelper.format((String)"\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61\u6ca1\u6709\u5b9e\u73b0\u63a5\u53e3[IPSLinkDEField]", (Object)this.getRelatedPSDEField().getFullName()));
                    }
                    this.realPSDEField = iLinkDEFHelper.getRealPSDEField();
                    if (this.realPSDEField == null) {
                        log.error((Object)StringHelper.format((String)"\u5c5e\u6027[%1$s]\u5b9e\u9645\u5173\u7cfb\u5c5e\u6027\u65e0\u6548", (Object)this.getRelatedPSDEField().getFullName()));
                    }
                } else {
                    this.realPSDEField = this.getRelatedPSDEField();
                }
                if (!bClose) return;
                ActionSessionManager.closeSession();
                return;
            }
            catch (Exception ex) {
                if (!bClose) throw ex;
                ActionSessionManager.closeSession();
                throw ex;
            }
        }
        if (this.realPSDEField2 != null) {
            return;
        }
        boolean bClose = false;
        try {
            ActionSession actionSession = ActionSessionManager.getCurrentSession();
            if (actionSession == null) {
                bClose = true;
                actionSession = ActionSessionManager.openSession((String)"PSLinkDEFieldImpl");
                actionSession.registerRecursion("PSDEFIELD", (Object)this.getId());
            } else if (!actionSession.registerRecursion("PSDEFIELD", (Object)this.getId())) {
                throw new Exception(StringHelper.format((String)"\u5c5e\u6027[%1$s]\u5b58\u5728\u9012\u5f52\u5173\u7cfb", (Object)this.getFullName()));
            }
            if (this.getRelatedPSDEField().isLinkDEField() && !this.getRelatedPSDEField().isPhisicalDEField()) {
                IPSLinkDEField iLinkDEFHelper = null;
                if (this.getRelatedPSDEField() instanceof IPSLinkDEField) {
                    iLinkDEFHelper = (IPSLinkDEField)this.getRelatedPSDEField();
                }
                if (iLinkDEFHelper == null) {
                    throw new Exception(StringHelper.format((String)"\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61\u6ca1\u6709\u5b9e\u73b0\u63a5\u53e3[IPSLinkDEField]", (Object)this.getRelatedPSDEField().getFullName()));
                }
                this.realPSDEField2 = iLinkDEFHelper.getRealPSDEField();
                if (this.realPSDEField2 == null) {
                    log.error((Object)StringHelper.format((String)"\u5c5e\u6027[%1$s]\u5b9e\u9645\u5173\u7cfb\u5c5e\u6027\u65e0\u6548", (Object)this.getRelatedPSDEField().getFullName()));
                }
            } else {
                this.realPSDEField2 = this.getRelatedPSDEField();
            }
            if (!bClose) return;
            ActionSessionManager.closeSession();
            return;
        }
        catch (Exception ex) {
            if (!bClose) throw ex;
            ActionSessionManager.closeSession();
            throw ex;
        }
    }

    @Override
    @PSModelRTMeta(description="\u94fe\u63a5\u5c5e\u6027")
    public boolean isLinkDEField() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u7269\u7406\u5c5e\u6027")
    public boolean isPhisicalDEField() {
        return false;
    }

    public boolean isCustomJoin() {
        return StringHelper.compare((String)this.iPSDERBase.getDERType(), (String)"DERCUSTOM", (boolean)true) == 0;
    }

    @Override
    protected int onGetStdDataType() throws Exception {
        return this.getRealPSDEField().getStdDataType();
    }

    @Override
    protected int onGetLength() throws Exception {
        return this.getRealPSDEField().getLength();
    }

    @Override
    protected int onGetStringLength() throws Exception {
        return this.getRealPSDEField().getStringLength();
    }

    @Override
    protected int onGetPrecision() throws Exception {
        return this.getRealPSDEField().getPrecision();
    }

    @Override
    protected String onGetCodeListId() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getPSDEFieldData().getPSCODELISTID())) {
            return this.getPSDEFieldData().getPSCODELISTID();
        }
        String strCodeListId = this.getRealPSDEField().getCodeListId();
        if (!StringHelper.isNullOrEmpty((String)strCodeListId)) {
            return strCodeListId;
        }
        return super.onGetCodeListId();
    }

    public synchronized IPSDERBase getPSDER() throws Exception {
        if (this.iPSDERBase != null) {
            return this.iPSDERBase;
        }
        this.iPSDERBase = this.getPSDataEntity().getPSDER(false, this.getPSDEFieldData().getPSDERID());
        return this.iPSDERBase;
    }

    public String getDERId() {
        return this.getPSDEFieldData().getPSDERID();
    }

    @Override
    public String getDERName() {
        return this.getPSDEFieldData().getPSDERNAME();
    }

    @Override
    public String getLinkDEFName() {
        return this.psDEField.getDERPSDEFNAME();
    }

    @Override
    @PSModelRTMeta(description="\u503c\u683c\u5f0f\u5316")
    public String getValueFormat() {
        if (StringHelper.isNullOrEmpty((String)super.getValueFormat())) {
            try {
                return this.getRealPSDEField().getValueFormat();
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
        return super.getValueFormat();
    }

    public IPSDEField getRealPSDEField(boolean bFirstPhisical) throws Exception {
        this.prepareRealPSDEField(bFirstPhisical);
        return bFirstPhisical ? this.realPSDEField2 : this.realPSDEField;
    }

    @Override
    protected boolean onCalcCheckRecursion() throws Exception {
        if (!this.getPSDEFieldData().isCHECKRECURSIONNull()) {
            return this.getPSDEFieldData().getCHECKRECURSION();
        }
        return this.getRealPSDEField().isCheckRecursion();
    }

    @Override
    public boolean isDynaStorageDEField() {
        try {
            return this.getRealPSDEField().isDynaStorageDEField();
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return super.isDynaStorageDEField();
        }
    }
}

