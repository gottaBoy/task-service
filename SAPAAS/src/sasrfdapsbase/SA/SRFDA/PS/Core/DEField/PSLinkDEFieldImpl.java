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
import SA.SRFDA.PS.Core.DEField.IPSLinkDEField;
import SA.SRFDA.PS.Core.DEField.PSDEFieldImpl;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFramework.Utility.StringHelper;
import net.ibizsys.paas.service.ActionSession;
import net.ibizsys.paas.service.ActionSessionManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSLinkDEFieldImpl
extends PSDEFieldImpl
implements IPSLinkDEField {
    private IPSDEField relatedPSDEField = null;
    private IPSDEField realPSDEField = null;
    private IPSDEField realPSDEField2 = null;
    private static final Log log = LogFactory.getLog(PSLinkDEFieldImpl.class);
    private IPSDERBase iPSDERBase = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    protected String getRelatedPSDEFId() {
        return this.getPSDEFieldData().getDERPSDEFID();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u9645\u94fe\u63a5\u7269\u7406\u5c5e\u6027", dumpref=true, from="__self__", from_method="getRealPSDataEntityMust().getPSDEField", group="\u5173\u7cfb", order=401, doc="\u9012\u5f52\u8ba1\u7b97\u5b9e\u9645\u7684\u5f15\u7528\u5c5e\u6027\uff08\u975e\u94fe\u63a5\uff09")
    public IPSDEField getRealPSDEField() throws Exception {
        this.prepareRealPSDEField(false);
        return this.realPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u94fe\u63a5\u5c5e\u6027", dumpref=true, from="__self__", from_method="getRelatedPSDataEntityMust().getPSDEField", group="\u5173\u7cfb", order=397, fields={"DERPSDEFID"})
    public synchronized IPSDEField getRelatedPSDEField() throws Exception {
        if (this.relatedPSDEField != null) {
            return this.relatedPSDEField;
        }
        IPSDataEntity majorPSDataEntity = this.getPSDER().getMajorPSDataEntity();
        if (StringHelper.IsNullOrEmpty((String)this.getRelatedPSDEFId())) {
            throw new Exception(StringHelper.Format((String)"\u5173\u7cfb\u5c5e\u6027[%1$s]\u6ca1\u6709\u6307\u5b9a\u5f15\u7528\u5c5e\u6027", (Object)this.getFullName()));
        }
        if (StringHelper.Compare((String)this.getId(), (String)this.getRelatedPSDEFId(), (boolean)false) == 0) {
            throw new Exception(StringHelper.Format((String)"\u5173\u7cfb\u5c5e\u6027[%1$s]\u4e0d\u80fd\u5f15\u7528\u81ea\u5df1", (Object)this.getFullName()));
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
            ActionSession actionSession = null;
            try {
                actionSession = ActionSessionManager.getCurrentSession();
                if (actionSession == null) {
                    bClose = true;
                    actionSession = ActionSessionManager.openSession((String)"PSLinkDEFieldImpl");
                    actionSession.registerRecursion("PSDEFIELD", (Object)this.getId());
                } else if (!actionSession.registerRecursion("PSDEFIELD", (Object)this.getId())) {
                    throw new Exception(StringHelper.Format((String)"\u5c5e\u6027[%1$s]\u5b58\u5728\u9012\u5f52\u5173\u7cfb", (Object)this.getFullName()));
                }
                if (this.getRelatedPSDEField().isLinkDEField()) {
                    IPSLinkDEField iLinkDEFHelper = null;
                    if (this.getRelatedPSDEField() instanceof IPSLinkDEField) {
                        iLinkDEFHelper = (IPSLinkDEField)this.getRelatedPSDEField();
                    }
                    if (iLinkDEFHelper == null) {
                        throw new Exception(StringHelper.Format((String)"\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61\u6ca1\u6709\u5b9e\u73b0\u63a5\u53e3[IPSLinkDEField]", (Object)this.getRelatedPSDEField().getFullName()));
                    }
                    this.realPSDEField = iLinkDEFHelper.getRealPSDEField();
                    if (this.realPSDEField == null) {
                        log.error((Object)StringHelper.Format((String)"\u5c5e\u6027[%1$s]\u5b9e\u9645\u5173\u7cfb\u5c5e\u6027\u65e0\u6548", (Object)this.getRelatedPSDEField().getFullName()));
                    }
                } else {
                    this.realPSDEField = this.getRelatedPSDEField();
                }
                actionSession.unregisterRecursion("PSDEFIELD", (Object)this.getId());
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
        ActionSession actionSession = null;
        try {
            actionSession = ActionSessionManager.getCurrentSession();
            if (actionSession == null) {
                bClose = true;
                actionSession = ActionSessionManager.openSession((String)"PSLinkDEFieldImpl");
                actionSession.registerRecursion("PSDEFIELD", (Object)this.getId());
            } else if (!actionSession.registerRecursion("PSDEFIELD", (Object)this.getId())) {
                throw new Exception(StringHelper.Format((String)"\u5c5e\u6027[%1$s]\u5b58\u5728\u9012\u5f52\u5173\u7cfb", (Object)this.getFullName()));
            }
            if (this.getRelatedPSDEField().isLinkDEField() && !this.getRelatedPSDEField().isPhisicalDEField()) {
                IPSLinkDEField iLinkDEFHelper = null;
                if (this.getRelatedPSDEField() instanceof IPSLinkDEField) {
                    iLinkDEFHelper = (IPSLinkDEField)this.getRelatedPSDEField();
                }
                if (iLinkDEFHelper == null) {
                    throw new Exception(StringHelper.Format((String)"\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61\u6ca1\u6709\u5b9e\u73b0\u63a5\u53e3[IPSLinkDEField]", (Object)this.getRelatedPSDEField().getFullName()));
                }
                this.realPSDEField2 = iLinkDEFHelper.getRealPSDEField();
                if (this.realPSDEField2 == null) {
                    log.error((Object)StringHelper.Format((String)"\u5c5e\u6027[%1$s]\u5b9e\u9645\u5173\u7cfb\u5c5e\u6027\u65e0\u6548", (Object)this.getRelatedPSDEField().getFullName()));
                }
            } else {
                this.realPSDEField2 = this.getRelatedPSDEField();
            }
            actionSession.unregisterRecursion("PSDEFIELD", (Object)this.getId());
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
    @PSModelRTMeta(description="\u94fe\u63a5\u5c5e\u6027", ignoredumpvalues="false")
    public boolean isLinkDEField() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u7269\u7406\u5c5e\u6027", ignoredumpvalues="true")
    public boolean isPhisicalDEField() {
        return false;
    }

    @Override
    public boolean isCustomJoin() {
        return StringHelper.Compare((String)this.iPSDERBase.getDERType(), (String)"DERCUSTOM", (boolean)true) == 0;
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
        if (!StringHelper.IsNullOrEmpty((String)this.getPSDEFieldData().getPSCODELISTID())) {
            return this.getPSDEFieldData().getPSCODELISTID();
        }
        String strCodeListId = this.getRealPSDEField().getCodeListId();
        if (!StringHelper.IsNullOrEmpty((String)strCodeListId)) {
            return strCodeListId;
        }
        return super.onGetCodeListId();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5173\u7cfb\u5bf9\u8c61", dumpref=true, group="\u5173\u7cfb", order=395, fields={"PSDERID"})
    public synchronized IPSDERBase getPSDER() throws Exception {
        if (this.iPSDERBase != null) {
            return this.iPSDERBase;
        }
        if (StringHelper.IsNullOrEmpty((String)this.getPSDEFieldData().getPSDERID())) {
            throw new Exception(StringHelper.Format((String)"\u5173\u7cfb\u5c5e\u6027[%1$s]\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u5173\u7cfb", (Object)this.getFullModelName()));
        }
        this.iPSDERBase = this.getPSDataEntity().getPSDER(false, this.getPSDEFieldData().getPSDERID());
        return this.iPSDERBase;
    }

    @Override
    public String getDERId() {
        return this.getPSDEFieldData().getPSDERID();
    }

    @Override
    public String getDERName() {
        return this.getPSDEFieldData().getPSDERNAME();
    }

    @Override
    protected IPSDEField onGetRestrictedPSDEField() throws Exception {
        IPSDER1N iPSDER1N;
        IPSDEField iPSDEField = super.onGetRestrictedPSDEField();
        if (iPSDEField != null) {
            return iPSDEField;
        }
        if (this.getPSDER() instanceof IPSDER1N && (iPSDER1N = (IPSDER1N)this.getPSDER()).isEnableExtRestrict() && !StringHelper.IsNullOrEmpty((String)iPSDER1N.getERMinorPSDEFId())) {
            return this.getPSDataEntity().getPSDEField(iPSDER1N.getERMinorPSDEFId());
        }
        return null;
    }

    @Override
    public String getLinkDEFName() {
        return this.psDEField.getDERPSDEFNAME();
    }

    @Override
    @PSModelRTMeta(description="\u503c\u683c\u5f0f\u5316", fields={"VALUEFORMAT"})
    public String getValueFormat() {
        if (StringHelper.IsNullOrEmpty((String)super.getValueFormat())) {
            try {
                return this.getRealPSDEField().getValueFormat();
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
        return super.getValueFormat();
    }

    @Override
    @PSModelRTMeta(description="JS\u683c\u5f0f\u5316", fields={"JSFORMAT"}, dump=false)
    public String getJSFormat() {
        if (StringHelper.IsNullOrEmpty((String)super.getJSFormat())) {
            try {
                return this.getRealPSDEField().getJSFormat();
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
        return super.getJSFormat();
    }

    @Override
    @PSModelRTMeta(description="Json\u683c\u5f0f\u5316", fields={"JSONFORMAT"}, dump=false)
    public String getJsonFormat() {
        if (StringHelper.IsNullOrEmpty((String)super.getJsonFormat())) {
            try {
                return this.getRealPSDEField().getJsonFormat();
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
        return super.getJsonFormat();
    }

    @Override
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
    @PSModelRTMeta(description="\u52a8\u6001\u5b58\u50a8\u5c5e\u6027", ignoredumpvalues="false")
    public boolean isDynaStorageDEField() {
        block3: {
            try {
                if (!super.isDynaStorageDEField()) break block3;
                return true;
            }
            catch (Exception ex) {
                log.error((Object)ex);
                return super.isDynaStorageDEField();
            }
        }
        return this.getRealPSDEField().isDynaStorageDEField();
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u8f85\u52a9\u5c5e\u6027", ignoredumpvalues="false")
    public boolean isUIAssistDEField() {
        block3: {
            try {
                if (!super.isUIAssistDEField()) break block3;
                return true;
            }
            catch (Exception ex) {
                log.error((Object)ex);
                return super.isUIAssistDEField();
            }
        }
        return this.getRealPSDEField().isUIAssistDEField();
    }

    @Override
    @PSModelRTMeta(description="\u94fe\u63a5\u5c5e\u6027\u6240\u5728\u5b9e\u4f53", dumpref=true, group="\u5173\u7cfb", order=399)
    public IPSDataEntity getRelatedPSDataEntity() throws Exception {
        if (this.getRelatedPSDEField() != null) {
            return this.getRelatedPSDEField().getPSDataEntity();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u9645\u5c5e\u6027\u6240\u5728\u5b9e\u4f53", dumpref=true, group="\u5173\u7cfb", order=403)
    public IPSDataEntity getRealPSDataEntity() throws Exception {
        if (this.getRealPSDEField() != null) {
            return this.getRealPSDEField().getPSDataEntity();
        }
        return null;
    }
}

