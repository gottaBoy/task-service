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

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Core.Requirement.IPSSysReqItem;
import SA.SRFDA.PS.Core.Requirement.IPSSysReqModule;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.UML.IPSSysUseCase;
import SA.SRFDA.PS.Data.PSSysReqItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysReqItemImpl
extends PSSystemObjectImpl
implements IPSSysReqItem {
    private static final Log log = LogFactory.getLog(PSSysReqItemImpl.class);
    protected PSSysReqItem psSysReqItem = null;
    private IPSSystemModule iPSSystemModule = null;
    private IPSSysReqModule iPSSysReqModule = null;
    private IPSSysUseCase iPSSysUseCase = null;
    private Map<String, IPSModelObject> refPSModelObjectMap = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysReqItem psSysReqItem) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysReqItem = psSysReqItem;
            this.setId(this.psSysReqItem.getPSSYSREQITEMID());
            this.setName(this.psSysReqItem.getPSSYSREQITEMNAME());
            this.setPSObjectData(this.psSysReqItem);
            if (!StringHelper.isNullOrEmpty((String)psSysReqItem.getPSSYSUSERCASEID())) {
                this.iPSSysUseCase = this.getPSSystem().getPSSysUseCase(psSysReqItem.getPSSYSUSERCASEID());
            }
            if (!StringHelper.isNullOrEmpty((String)psSysReqItem.getPSSYSREQMODULEID())) {
                this.iPSSysReqModule = this.getPSSystem().getPSSysReqModule(psSysReqItem.getPSSYSREQMODULEID());
            } else if (!StringHelper.isNullOrEmpty((String)this.psSysReqItem.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysReqItem.getPSMODULEID());
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
    @PSModelRTMeta(description="\u9700\u6c42\u6a21\u5757", hideempty=true, dumpref=true)
    public IPSSysReqModule getPSSysReqModule() {
        return this.iPSSysReqModule;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", hideempty=true, dumpref=true)
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psSysReqItem.getCODENAME();
    }

    @Override
    public String getModelType() {
        return "PSSYSREQITEM";
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9", group="\u57fa\u672c", order=135, doctype="md")
    public String getContent() {
        return this.psSysReqItem.getREQCONTENT();
    }

    @Override
    public String getModelId() {
        return super.getModelId();
    }

    @Override
    @PSModelRTMeta(description="\u9879\u7f16\u53f7", group="\u57fa\u672c", order=105)
    public String getItemSN() {
        return this.psSysReqItem.getITEMSN();
    }

    @Override
    @PSModelRTMeta(description="\u9879\u6807\u8bb0")
    public String getItemTag() {
        return this.psSysReqItem.getITEMTAG();
    }

    @Override
    @PSModelRTMeta(description="\u9879\u6807\u8bb02")
    public String getItemTag2() {
        return this.psSysReqItem.getITEMTAG2();
    }

    @Override
    public int getVer() {
        return this.psSysReqItem.getVER();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u7528\u4f8b", dumpref=true)
    public IPSSysUseCase getPSSysUseCase() {
        return this.iPSSysUseCase;
    }

    @Override
    public void registerRefPSModelObject(IPSModelObject iPSModelObject) {
        if (PSTemplHelper.isBusy() || iPSModelObject == null || StringHelper.isNullOrEmpty((String)iPSModelObject.getModelType()) || StringHelper.isNullOrEmpty((String)iPSModelObject.getModelId())) {
            return;
        }
        if (this.refPSModelObjectMap == null) {
            this.refPSModelObjectMap = new ConcurrentHashMap<String, IPSModelObject>();
        }
        this.refPSModelObjectMap.put(StringHelper.format((String)"%1$s|%2$s", (Object)iPSModelObject.getModelType(), (Object)iPSModelObject.getModelId()), iPSModelObject);
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u8be5\u9700\u6c42\u5bf9\u8c61\u96c6\u5408")
    public Iterator<IPSModelObject> getRefPSModelObjects() {
        if (this.refPSModelObjectMap == null || this.refPSModelObjectMap.size() == 0) {
            return null;
        }
        return this.refPSModelObjectMap.values().iterator();
    }

    @Override
    protected boolean hasPSSysReqItem() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u670d\u52a1\u53d1\u5e03\u5bf9\u8c61", hideempty=true)
    public IPSSysSFPub getPSSysSFPub() {
        if (this.getPSSysReqModule() != null) {
            return this.getPSSysReqModule().getPSSysSFPub();
        }
        if (this.getPSSystemModule() != null) {
            return this.getPSSystemModule().getPSSysSFPub();
        }
        return this.getPSSystem().getDefaultPSSysSFPub();
    }

    @Override
    protected String onGetMOSFolder() {
        if (this.getPSSysReqModule() != null) {
            return String.format("%1$s/%2$s", this.getPSSysReqModule().getMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase());
        }
        return super.onGetMOSFolder();
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getPSSysReqModule() != null) {
            return String.format("%1$s/%2$s", this.getPSSysReqModule().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase());
        }
        return super.onGetRTMOSFolder();
    }

    @Override
    protected String onGetDynaModelFolder() {
        if (this.getPSSysReqModule() != null) {
            return String.format("%1$s/%2$s/%3$s", this.getPSSysReqModule().getDynaModelFolder(), Inflector.getInstance().pluralize((Object)this.getDumpModelType()).toUpperCase(), this.getDynaModelTag());
        }
        return super.onGetDynaModelFolder();
    }
}

