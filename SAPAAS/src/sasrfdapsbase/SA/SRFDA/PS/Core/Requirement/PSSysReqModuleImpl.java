/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.Inflector
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Requirement;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Requirement.IPSSysReqItem;
import SA.SRFDA.PS.Core.Requirement.IPSSysReqModule;
import SA.SRFDA.PS.Core.Requirement.PSSysReqModuleGlobalModel;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysReqModule;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysReqModuleImpl
extends PSSystemObjectImpl
implements IPSSysReqModule {
    private static final Log log = LogFactory.getLog(PSSysReqModuleImpl.class);
    protected PSSysReqModule psSysReqModule = null;
    private IPSSystemModule iPSSystemModule = null;
    private PSSysReqModuleGlobalModel psSysReqModuleGlobalModel = new PSSysReqModuleGlobalModel();
    private IPSSysReqModule parentPSSysReqModule = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, IPSSysReqModule parentPSSysReqModule, PSSysReqModule psSysReqModule) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysReqModule = psSysReqModule;
            this.parentPSSysReqModule = parentPSSysReqModule;
            this.setId(this.psSysReqModule.getPSSYSREQMODULEID());
            this.setName(this.psSysReqModule.getPSSYSREQMODULENAME());
            this.setPSObjectData(this.psSysReqModule);
            if (!StringHelper.isNullOrEmpty((String)this.psSysReqModule.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysReqModule.getPSMODULEID());
            }
            this.psSysReqModuleGlobalModel.Init(this.getDAGlobalHelper(), this);
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
        this.getPSSysReqModules();
    }

    @Override
    @PSModelRTMeta(description="\u7236\u6a21\u5757", hideempty=true, dumpref=true)
    public IPSSysReqModule getParentPSSysReqModule() {
        return this.parentPSSysReqModule;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psSysReqModule.getCODENAME();
    }

    @Override
    public String getModelType() {
        return "PSSYSREQMODULE";
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", hideempty=true, dumpref=true)
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u5757\u7f16\u53f7", group="\u57fa\u672c", order=105)
    public String getModuleSN() {
        return this.psSysReqModule.getMODULESN();
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u5757\u6807\u8bb0")
    public String getModuleTag() {
        return this.psSysReqModule.getMODULETAG();
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u5757\u6807\u8bb02")
    public String getModuleTag2() {
        return this.psSysReqModule.getMODULETAG2();
    }

    @Override
    @PSModelRTMeta(description="\u9700\u6c42\u6a21\u5757\u96c6\u5408", child=true, dumpref=true)
    public Iterator<IPSSysReqModule> getPSSysReqModules() throws Exception {
        return this.psSysReqModuleGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysReqModule getPSSysReqModule(String strSysReqModuleId) throws Exception {
        return (IPSSysReqModule)this.psSysReqModuleGlobalModel.FindModelHelper(strSysReqModuleId);
    }

    @Override
    public IPSSysReqModule getPSSysReqModule(String strSysReqModuleId, boolean bTryMode) throws Exception {
        return (IPSSysReqModule)this.psSysReqModuleGlobalModel.FindModelHelper(strSysReqModuleId, bTryMode);
    }

    @Override
    public void resetPSSysReqModule(String strSysReqModuleId) {
        this.psSysReqModuleGlobalModel.ResetModel(strSysReqModuleId);
    }

    @Override
    public void resetPSSysReqModules() {
        this.psSysReqModuleGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u9700\u6c42\u9879\u96c6\u5408", child=true, dumpref=true)
    public Iterator<IPSSysReqItem> getPSSysReqItems() throws Exception {
        Iterator<IPSSysReqItem> psSysReqItems = this.getPSSystem().getAllPSSysReqItems();
        if (psSysReqItems == null) {
            return null;
        }
        ArrayList<IPSSysReqItem> list = new ArrayList<IPSSysReqItem>();
        while (psSysReqItems.hasNext()) {
            IPSSysReqItem iPSSysReqItem = psSysReqItems.next();
            if (iPSSysReqItem.getPSSysReqModule() == null || StringHelper.compare((String)iPSSysReqItem.getPSSysReqModule().getId(), (String)this.getId(), (boolean)false) != 0) continue;
            list.add(iPSSysReqItem);
        }
        if (list.size() == 0) {
            return null;
        }
        return list.iterator();
    }

    @Override
    protected String onGetMOSFolder() {
        if (this.getParentPSSysReqModule() != null) {
            return String.format("%1$s/%2$s", this.getParentPSSysReqModule().getMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase());
        }
        return super.onGetMOSFolder();
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getParentPSSysReqModule() != null) {
            return String.format("%1$s/%2$s", this.getParentPSSysReqModule().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase());
        }
        return super.onGetRTMOSFolder();
    }

    @Override
    protected String onGetDynaModelFolder() {
        if (this.getParentPSSysReqModule() != null) {
            return String.format("%1$s/%2$s/%3$s", this.getParentPSSysReqModule().getDynaModelFolder(), Inflector.getInstance().pluralize((Object)this.getDumpModelType()).toUpperCase(), this.getDynaModelTag());
        }
        return super.onGetDynaModelFolder();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u670d\u52a1\u53d1\u5e03\u5bf9\u8c61", hideempty=true)
    public IPSSysSFPub getPSSysSFPub() {
        if (this.getPSSystemModule() != null) {
            return this.getPSSystemModule().getPSSysSFPub();
        }
        return this.getPSSystem().getDefaultPSSysSFPub();
    }
}

