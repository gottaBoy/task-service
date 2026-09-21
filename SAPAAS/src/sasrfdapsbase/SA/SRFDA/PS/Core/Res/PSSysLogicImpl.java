/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSSysLogic;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysLogic;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysLogicImpl
extends PSSystemObjectImpl
implements IPSSysLogic {
    private static final Log log = LogFactory.getLog(PSSysLogicImpl.class);
    protected PSSysLogic psSysLogic = null;
    private boolean bCustomCode = false;
    protected String strCodeName = null;
    private IPSSystemModule iPSSystemModule = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSXCodeObject iPSXCodeObject = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysLogic psSysLogic) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysLogic = psSysLogic;
            this.setId(this.psSysLogic.getPSSYSDELOGICNODEID());
            this.setName(this.psSysLogic.getPSSYSDELOGICNODENAME());
            this.setPSObjectData(this.psSysLogic);
            this.strCodeName = this.psSysLogic.getCODENAME();
            if (!StringHelper.isNullOrEmpty((String)this.psSysLogic.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysLogic.getPSMODULEID());
            }
            if (!this.psSysLogic.isCUSTOMMODENull()) {
                this.bCustomCode = this.psSysLogic.getCUSTOMMODE();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysLogic.getPSSYSSFPLUGINID())) {
                this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(this.psSysLogic.getPSSYSSFPLUGINID());
            }
            if (this.getPSSysSFPlugin() != null) {
                String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
                IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
                if (iPSSysSFPluginTempl != null) {
                    this.iPSXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
                }
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
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSSYSDELOGICNODE";
    }

    @Override
    public String getCustomParams() {
        return this.psSysLogic.getCUSTOMPARAMS();
    }

    @Override
    public String getLogicType() {
        return "CUSTOM";
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u5904\u7406\u5bf9\u8c61", fields={"CUSTOMOBJ"})
    public String getCustomObject() {
        return this.psSysLogic.getCUSTOMOBJ();
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
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", dumpref=true, hideempty=true, dynamodelmode=4, fields={"PSMODULEID"})
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u7aef\u6a21\u677f\u63d2\u4ef6\u5bf9\u8c61", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u670d\u52a1\u53d1\u5e03\u5bf9\u8c61", hideempty=true)
    public IPSSysSFPub getPSSysSFPub() {
        if (this.getPSSystemModule() != null) {
            return this.getPSSystemModule().getPSSysSFPub();
        }
        return this.getPSSystem().getDefaultPSSysSFPub();
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSXCodeObject getRender() {
        return this.iPSXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u811a\u672c\u4ee3\u7801", ignoredumpvalues="false", fields={"CUSTOMMODE"})
    public boolean isCustomCode() {
        return this.bCustomCode;
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801", fields={"CUSTOMCODE"})
    public String getScriptCode() {
        return this.psSysLogic.getCUSTOMCODE();
    }
}

