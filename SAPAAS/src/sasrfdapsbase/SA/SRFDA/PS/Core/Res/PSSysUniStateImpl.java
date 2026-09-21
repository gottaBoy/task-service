/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.Res.IPSSysUniState;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysUniState;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysUniStateImpl
extends PSSystemObjectImpl
implements IPSSysUniState {
    private static final Log log = LogFactory.getLog(PSSysUniStateImpl.class);
    protected PSSysUniState psSysUniState = null;
    private IPSDataEntity iPSDataEntity = null;
    private IPSDEField keyPSDEField = null;
    private IPSDEField folderPSDEField = null;
    private IPSDEField folder2PSDEField = null;
    private IPSDEField folder3PSDEField = null;
    private IPSDEField folder4PSDEField = null;
    private IPSDEField folder5PSDEField = null;
    private IPSDEField folder6PSDEField = null;
    private IPSDEField folder7PSDEField = null;
    private IPSDEField folder8PSDEField = null;
    private IPSDEField statePSDEField = null;
    private IPSDEField state2PSDEField = null;
    private IPSDEField state3PSDEField = null;
    private IPSDEField state4PSDEField = null;
    private IPSDEField state5PSDEField = null;
    private IPSDEField state6PSDEField = null;
    private IPSDEField state7PSDEField = null;
    private IPSDEField state8PSDEField = null;
    private IPSDEDataSet iPSDEDataSet = null;
    private IPSDELogic initPSDELogic = null;
    private IPSDELogic onChangePSDELogic = null;
    private IPSDELogic onDeletePSDELogic = null;
    private IPSSystemModule iPSSystemModule = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSXCodeObject iPSXCodeObject = null;
    private Properties uniStateParams = null;
    private int nCacheTimeout = -1;
    private String strCacheCat = null;
    private boolean bDeleteAsDelete = false;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysUniState psSysUniState) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysUniState = psSysUniState;
            this.setId(this.psSysUniState.getPSSYSUNISTATEID());
            this.setName(this.psSysUniState.getPSSYSUNISTATENAME());
            this.setPSObjectData(this.psSysUniState);
            if (StringHelper.isNullOrEmpty((String)this.psSysUniState.getPSDEID())) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7edf\u4e00\u72b6\u6001\u534f\u540c\u5bf9\u8c61\u7684\u5b9e\u4f53");
            }
            this.iPSDataEntity = this.getPSSystem().getPSDataEntity2(this.psSysUniState.getPSDEID());
            this.keyPSDEField = !StringHelper.isNullOrEmpty((String)this.psSysUniState.getKEYPSDEFID()) ? this.getPSDataEntity().getPSDEField(this.psSysUniState.getKEYPSDEFID()) : this.getPSDataEntity().getKeyPSDEField();
            if (!StringHelper.isNullOrEmpty((String)this.psSysUniState.getKEY2PSDEFID())) {
                this.folderPSDEField = this.getPSDataEntity().getPSDEField(this.psSysUniState.getKEY2PSDEFID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysUniState.getKEY3PSDEFID())) {
                this.folder2PSDEField = this.getPSDataEntity().getPSDEField(this.psSysUniState.getKEY3PSDEFID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysUniState.getKEY4PSDEFID())) {
                this.folder3PSDEField = this.getPSDataEntity().getPSDEField(this.psSysUniState.getKEY4PSDEFID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysUniState.getKEY5PSDEFID())) {
                this.folder4PSDEField = this.getPSDataEntity().getPSDEField(this.psSysUniState.getKEY5PSDEFID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysUniState.getKEY6PSDEFID())) {
                this.folder5PSDEField = this.getPSDataEntity().getPSDEField(this.psSysUniState.getKEY6PSDEFID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysUniState.getKEY7PSDEFID())) {
                this.folder6PSDEField = this.getPSDataEntity().getPSDEField(this.psSysUniState.getKEY7PSDEFID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysUniState.getKEY8PSDEFID())) {
                this.folder7PSDEField = this.getPSDataEntity().getPSDEField(this.psSysUniState.getKEY8PSDEFID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysUniState.getKEY9PSDEFID())) {
                this.folder8PSDEField = this.getPSDataEntity().getPSDEField(this.psSysUniState.getKEY9PSDEFID());
            }
            this.statePSDEField = !StringHelper.isNullOrEmpty((String)this.psSysUniState.getSTATEPSDEFID()) ? this.getPSDataEntity().getPSDEField(this.psSysUniState.getSTATEPSDEFID()) : this.getPSDataEntity().getPSDEFieldByPDT("UPDATEDATE", true);
            if (!StringHelper.isNullOrEmpty((String)this.psSysUniState.getSTATE2PSDEFID())) {
                this.state2PSDEField = this.getPSDataEntity().getPSDEField(this.psSysUniState.getSTATE2PSDEFID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysUniState.getSTATE3PSDEFID())) {
                this.state3PSDEField = this.getPSDataEntity().getPSDEField(this.psSysUniState.getSTATE3PSDEFID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysUniState.getSTATE4PSDEFID())) {
                this.state4PSDEField = this.getPSDataEntity().getPSDEField(this.psSysUniState.getSTATE4PSDEFID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysUniState.getSTATE5PSDEFID())) {
                this.state5PSDEField = this.getPSDataEntity().getPSDEField(this.psSysUniState.getSTATE5PSDEFID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysUniState.getSTATE6PSDEFID())) {
                this.state6PSDEField = this.getPSDataEntity().getPSDEField(this.psSysUniState.getSTATE6PSDEFID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysUniState.getSTATE7PSDEFID())) {
                this.state7PSDEField = this.getPSDataEntity().getPSDEField(this.psSysUniState.getSTATE7PSDEFID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysUniState.getSTATE8PSDEFID())) {
                this.state8PSDEField = this.getPSDataEntity().getPSDEField(this.psSysUniState.getSTATE8PSDEFID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysUniState.getPSDEDATASETID())) {
                this.iPSDEDataSet = this.getPSDataEntity().getPSDEDataSet(this.psSysUniState.getPSDEDATASETID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysUniState.getINITPSDELOGICID())) {
                this.initPSDELogic = this.getPSDataEntity().getPSDELogic(this.psSysUniState.getINITPSDELOGICID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysUniState.getONCHANGEPSDELOGICID())) {
                this.onChangePSDELogic = this.getPSDataEntity().getPSDELogic(this.psSysUniState.getONCHANGEPSDELOGICID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysUniState.getONDELETEPSDELOGICID())) {
                this.onDeletePSDELogic = this.getPSDataEntity().getPSDELogic(this.psSysUniState.getONDELETEPSDELOGICID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysUniState.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysUniState.getPSMODULEID());
            }
            if (StringHelper.compare((String)this.getUniStateMode(), (String)"CACHE", (boolean)true) == 0) {
                if (this.psSysUniState.getCACHETIMEOUT() > 0) {
                    this.nCacheTimeout = this.psSysUniState.getCACHETIMEOUT();
                }
                this.strCacheCat = this.psSysUniState.getCACHECAT();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysUniState.getUNISTATEPARAMS())) {
                this.uniStateParams = PropertiesHelper.load((String)this.psSysUniState.getUNISTATEPARAMS());
            }
            if (!this.psSysUniState.isDELETEASUPDATENull()) {
                this.bDeleteAsDelete = this.psSysUniState.getDELETEASUPDATE();
            } else if (this.uniStateParams != null) {
                this.bDeleteAsDelete = PropertiesHelper.getProperty((Properties)this.uniStateParams, (String)"DELETEASUPDATE", (boolean)false);
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysUniState.getPSSYSSFPLUGINID())) {
                this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(this.psSysUniState.getPSSYSSFPLUGINID());
            }
            if (this.getPSSysSFPlugin() != null) {
                String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
                IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
                if (iPSSysSFPluginTempl != null) {
                    this.iPSXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
                }
            }
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
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSSYSUNISTATE";
    }

    @Override
    @PSModelRTMeta(description="\u552f\u4e00\u4e1a\u52a1\u6807\u8bc6", fields={"UNIQUETAG"})
    public String getUniqueTag() {
        return this.psSysUniState.getUNIQUETAG();
    }

    @Override
    public String getDEName() {
        if (this.getPSDataEntity() != null) {
            return this.getPSDataEntity().getName();
        }
        return null;
    }

    @Override
    public String getKeyField() {
        if (this.getKeyPSDEField() != null) {
            return this.getKeyPSDEField().getName();
        }
        return null;
    }

    @Override
    public String getFolderField() {
        if (this.getFolderPSDEField() != null) {
            return this.getFolderPSDEField().getName();
        }
        return null;
    }

    @Override
    public String getFolder2Field() {
        if (this.getFolder2PSDEField() != null) {
            return this.getFolder2PSDEField().getName();
        }
        return null;
    }

    @Override
    public String getStateField() {
        if (this.getStatePSDEField() != null) {
            return this.getStatePSDEField().getName();
        }
        return null;
    }

    @Override
    public String getState2Field() {
        if (this.getState2PSDEField() != null) {
            return this.getState2PSDEField().getName();
        }
        return null;
    }

    @Override
    public String getState3Field() {
        if (this.getState3PSDEField() != null) {
            return this.getState3PSDEField().getName();
        }
        return null;
    }

    @Override
    public String getState4Field() {
        if (this.getState4PSDEField() != null) {
            return this.getState4PSDEField().getName();
        }
        return null;
    }

    @Override
    public String getState5Field() {
        if (this.getState5PSDEField() != null) {
            return this.getState5PSDEField().getName();
        }
        return null;
    }

    @Override
    public String getState6Field() {
        if (this.getState6PSDEField() != null) {
            return this.getState6PSDEField().getName();
        }
        return null;
    }

    @Override
    public String getState7Field() {
        if (this.getState7PSDEField() != null) {
            return this.getState7PSDEField().getName();
        }
        return null;
    }

    @Override
    public String getState8Field() {
        if (this.getState8PSDEField() != null) {
            return this.getState8PSDEField().getName();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53", dumpref=true)
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u8bc6\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSDataEntity")
    public IPSDEField getKeyPSDEField() {
        return this.keyPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u5f55\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSDataEntity")
    public IPSDEField getFolderPSDEField() {
        return this.folderPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u5f552\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSDataEntity")
    public IPSDEField getFolder2PSDEField() {
        return this.folder2PSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u72b6\u6001\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSDataEntity")
    public IPSDEField getStatePSDEField() {
        return this.statePSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u72b6\u60012\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSDataEntity")
    public IPSDEField getState2PSDEField() {
        return this.state2PSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u72b6\u60013\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSDataEntity")
    public IPSDEField getState3PSDEField() {
        return this.state3PSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u72b6\u60014\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSDataEntity")
    public IPSDEField getState4PSDEField() {
        return this.state4PSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u72b6\u60015\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSDataEntity")
    public IPSDEField getState5PSDEField() {
        return this.state5PSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u72b6\u60016\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSDataEntity")
    public IPSDEField getState6PSDEField() {
        return this.state6PSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u72b6\u60017\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSDataEntity")
    public IPSDEField getState7PSDEField() {
        return this.state7PSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u72b6\u60018\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSDataEntity")
    public IPSDEField getState8PSDEField() {
        return this.state8PSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u521d\u59cb\u5316\u903b\u8f91", hideempty=true, dumpref=true, from="IPSDataEntity")
    public IPSDELogic getInitPSDELogic() {
        return this.initPSDELogic;
    }

    @Override
    @PSModelRTMeta(description="\u53d8\u66f4\u903b\u8f91", hideempty=true, dumpref=true, from="IPSDataEntity")
    public IPSDELogic getOnChangePSDELogic() {
        return this.onChangePSDELogic;
    }

    @Override
    @PSModelRTMeta(description="\u5220\u9664\u903b\u8f91", hideempty=true, dumpref=true, from="IPSDataEntity")
    public IPSDELogic getOnDeletePSDELogic() {
        return this.onDeletePSDELogic;
    }

    @Override
    @PSModelRTMeta(description="\u9884\u8f7d\u6570\u636e\u96c6", hideempty=true, dumpref=true, from="IPSDataEntity")
    public IPSDEDataSet getPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    @Override
    public String getFolder3Field() {
        if (this.getFolder3PSDEField() != null) {
            return this.getFolder3PSDEField().getName();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u5f553\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSDataEntity")
    public IPSDEField getFolder3PSDEField() {
        return this.folder3PSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u5f554\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSDataEntity")
    public IPSDEField getFolder4PSDEField() {
        return this.folder4PSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u5f555\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSDataEntity")
    public IPSDEField getFolder5PSDEField() {
        return this.folder5PSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u5f556\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSDataEntity")
    public IPSDEField getFolder6PSDEField() {
        return this.folder6PSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u5f557\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSDataEntity")
    public IPSDEField getFolder7PSDEField() {
        return this.folder7PSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u5f558\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSDataEntity")
    public IPSDEField getFolder8PSDEField() {
        return this.folder8PSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u72b6\u6001\u534f\u540c\u7c7b\u578b", codelist="SysUniStateType", group="\u57fa\u672c", order=125, fields={"UNISTATETYPE"})
    public String getUniStateType() {
        return this.psSysUniState.getUNISTATETYPE();
    }

    @Override
    @PSModelRTMeta(description="\u72b6\u6001\u534f\u540c\u6a21\u5f0f", codelist="SysUniStateMode", ignoredumpvalues="DEFAULT", group="\u57fa\u672c", order=126, fields={"UNISTATEMODE"})
    public String getUniStateMode() {
        return this.psSysUniState.getUNISTATEMODE();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", dumpref=true, dynamodelmode=4, fields={"PSMODULEID"})
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    public String getCodeName() {
        return this.getUniqueTag();
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
    @PSModelRTMeta(description="\u7edf\u4e00\u72b6\u6001\u6807\u8bb0", hideempty2=true, fields={"UNISTATETAG"})
    public String getUniStateTag() {
        return this.psSysUniState.getUNISTATETAG();
    }

    @Override
    @PSModelRTMeta(description="\u7edf\u4e00\u72b6\u6001\u6807\u8bb02", hideempty2=true, fields={"UNISTATETAG2"})
    public String getUniStateTag2() {
        return this.psSysUniState.getUNISTATETAG2();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u7aef\u6a21\u677f\u63d2\u4ef6\u5bf9\u8c61", hideempty=true, fields={"PSSYSSFPLUGINID"})
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u8f6c\u6362\u5668\u52a8\u6001\u53c2\u6570", hideempty=true, ignorepf=true, fields={"UNISTATEPARAMS"})
    public Properties getUniStateParams() {
        return this.uniStateParams;
    }

    @Override
    @PSModelRTMeta(description="\u5237\u65b0\u95f4\u9694\uff08ms\uff09", ignoredumpvalues="0;-1", fields={"RELOADTIMER"})
    public int getReloadTimer() {
        return this.psSysUniState.getRELOADTIMER();
    }

    @Override
    @PSModelRTMeta(description="\u5168\u90e8\u6570\u636e", ignoredumpvalues="false", fields={"ALLDATAFLAG"})
    public boolean isAllData() {
        return this.psSysUniState.getALLDATAFLAG();
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u5f55\u683c\u5f0f\u5316", fields={"KEYFORMAT"})
    public String getPathFormat() {
        return this.psSysUniState.getKEYFORMAT();
    }

    @Override
    @PSModelRTMeta(description="\u76d1\u63a7\u5668\u683c\u5f0f\u5316", fields={"MONITORFORMAT"})
    public String getMonitorFormat() {
        return this.psSysUniState.getMONITORFORMAT();
    }

    @Override
    @PSModelRTMeta(description="\u7f13\u5b58\u5206\u7c7b", fields={"CACHECAT"})
    public String getCacheCat() {
        return this.strCacheCat;
    }

    @Override
    @PSModelRTMeta(description="\u7f13\u5b58\u8d85\u65f6", ignoredumpvalues="-1", fields={"CACHETIMEOUT"})
    public int getCacheTimeout() {
        return this.nCacheTimeout;
    }

    @Override
    @PSModelRTMeta(description="\u5220\u9664\u4f5c\u4e3a\u66f4\u65b0\u64cd\u4f5c", ignoredumpvalues="false", fields={"DELETEASUPDATE"})
    public boolean isDeleteAsUpdate() {
        return this.bDeleteAsDelete;
    }
}

