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
package SA.SRFDA.PS.Core.Control.Ajax;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethod;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlHandler;
import SA.SRFDA.PS.Core.Control.IPSControlHandlerAction;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSACHandlerAction;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSControlHandlerActionImpl
extends PSObjectImpl
implements IPSControlHandlerAction {
    private static final Log log = LogFactory.getLog(PSControlHandlerActionImpl.class);
    protected PSACHandlerAction psACHandlerAction = null;
    private IPSControlHandler iPSControlHandler = null;
    private String strActionType = null;
    private String strActionDesc = null;
    private IPSDataEntity iPSDataEntity = null;
    private IPSAppDataEntity iPSAppDataEntity = null;
    private int nTimeout = -1;
    private IPSDEAction iPSDEAction = null;
    private IPSDEOPPriv iPSDEOPPriv = null;
    private String strDataAccessAction = null;
    private String strDEActionName = null;
    private IPSDEDataSet iPSDEDataSet = null;
    private IPSDELogic activeDataPSDELogic = null;
    private String strWFActionName = null;
    private IPSAppDEMethod iPSAppDEMethod = null;
    private IPSAppDELogic adPSAppDELogic = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlHandler iPSControlHandler, PSACHandlerAction psACHandlerAction) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSControlHandler = iPSControlHandler;
            this.psACHandlerAction = psACHandlerAction;
            this.setId(this.psACHandlerAction.getPSACHANDLERACTIONID());
            this.setName(this.psACHandlerAction.getPSACHANDLERACTIONNAME());
            this.setPSObjectData(this.psACHandlerAction);
            this.strActionType = this.psACHandlerAction.getACTIONTYPE();
            this.strActionDesc = this.psACHandlerAction.getACTIONDESC();
            if (this.psACHandlerAction.getACTIONTIMEOUT() > 0) {
                this.nTimeout = this.psACHandlerAction.getACTIONTIMEOUT();
            }
            if (iPSControlHandler != null && iPSControlHandler.getPSControl().getPSAppDataEntity() != null) {
                this.iPSAppDataEntity = iPSControlHandler.getPSControl().getPSAppDataEntity();
                this.iPSDataEntity = this.iPSAppDataEntity.getPSDataEntity();
            } else if (iPSControlHandler != null && iPSControlHandler.getPSControl().getPSDataEntity() != null) {
                this.iPSDataEntity = iPSControlHandler.getPSControl().getPSDataEntity();
            }
            if (this.getPSAppDataEntity() != null) {
                if (StringHelper.compare((String)this.getActionType(), (String)"WFACTION", (boolean)false) == 0) {
                    this.strWFActionName = this.getName();
                    if (!StringHelper.isNullOrEmpty((String)this.psACHandlerAction.getPSDEACTIONID())) {
                        this.strWFActionName = this.psACHandlerAction.getPSDEACTIONID();
                        this.iPSAppDEMethod = this.getPSAppDataEntity().getPSAppDEMethod("WFACTION", this.psACHandlerAction.getPSDEACTIONID(), true);
                    }
                } else if (StringHelper.compare((String)this.getActionType(), (String)"FILTERACTION", (boolean)false) == 0 && !StringHelper.isNullOrEmpty((String)this.psACHandlerAction.getPSDEACTIONID())) {
                    this.iPSAppDEMethod = this.getPSAppDataEntity().getPSAppDEMethod("FILTERACTION", this.psACHandlerAction.getPSDEACTIONID(), true);
                }
            } else if (StringHelper.compare((String)this.getActionType(), (String)"WFACTION", (boolean)false) == 0) {
                this.strWFActionName = this.getName();
                if (!StringHelper.isNullOrEmpty((String)this.psACHandlerAction.getPSDEACTIONID())) {
                    this.strWFActionName = this.psACHandlerAction.getPSDEACTIONID();
                }
            }
            if (this.getPSDataEntity() != null) {
                if (StringHelper.compare((String)this.getActionType(), (String)"DEACTION", (boolean)false) == 0) {
                    if (!StringHelper.isNullOrEmpty((String)this.psACHandlerAction.getPSDEACTIONID())) {
                        this.iPSDEAction = this.getPSDataEntity().getPSDEAction(this.psACHandlerAction.getPSDEACTIONID(), true);
                        if (this.iPSDEAction == null) {
                            this.strDEActionName = this.psACHandlerAction.getPSDEACTIONID();
                        } else if (this.getPSAppDataEntity() != null) {
                            this.iPSAppDEMethod = this.getPSAppDataEntity().getPSAppDEMethod(this.iPSDEAction, true);
                        }
                    }
                    if (!StringHelper.isNullOrEmpty((String)this.psACHandlerAction.getPSDEOPPRIVID())) {
                        this.iPSDEOPPriv = this.getPSDataEntity().getPSDEOPPriv(this.psACHandlerAction.getPSDEOPPRIVID());
                    }
                } else if (StringHelper.compare((String)this.getActionType(), (String)"DEDATASET", (boolean)false) == 0) {
                    if (!StringHelper.isNullOrEmpty((String)this.psACHandlerAction.getPSDEDATASETID())) {
                        this.iPSDEDataSet = this.getPSDataEntity().getPSDEDataSet(this.psACHandlerAction.getPSDEDATASETID());
                        if (this.iPSDEDataSet != null && this.getPSAppDataEntity() != null) {
                            this.iPSAppDEMethod = iPSControlHandler != null && iPSControlHandler.getTempMode() == 2 ? this.getPSAppDataEntity().getPSAppDEDataSetTempMode(this.iPSDEDataSet, true) : this.getPSAppDataEntity().getPSAppDEDataSet(this.iPSDEDataSet, true);
                        }
                    }
                    if (!StringHelper.isNullOrEmpty((String)this.psACHandlerAction.getADPSDELOGICID())) {
                        this.activeDataPSDELogic = this.getPSDataEntity().getPSDELogic(this.psACHandlerAction.getADPSDELOGICID());
                    }
                    if (this.activeDataPSDELogic != null && this.activeDataPSDELogic.isEnableFront() && this.getPSAppDataEntity() != null) {
                        this.adPSAppDELogic = this.getPSAppDataEntity().getPSAppDELogic(this.activeDataPSDELogic.getId(), true);
                    }
                }
            }
            this.strDataAccessAction = this.psACHandlerAction.getDATAACCACTION();
            if (StringHelper.isNullOrEmpty((String)this.strDataAccessAction) && this.getPSDEOPPriv() != null) {
                this.strDataAccessAction = this.getPSDEOPPriv().getName();
            }
            this.onInit();
        }
        catch (Exception ex) {
            this.throwCriticalInitException(ex);
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
    @PSModelRTMeta(description="\u884c\u4e3a\u7c7b\u578b")
    public String getActionType() {
        return this.strActionType;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6\u5bf9\u8c61", hideempty=true)
    public IPSDEOPPriv getPSDEOPPriv() {
        return this.iPSDEOPPriv;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u884c\u4e3a\u5bf9\u8c61", hideempty=true)
    public IPSDEAction getPSDEAction() {
        return this.iPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u5904\u7406\u8d85\u65f6\u65f6\u957f\uff08\u6beb\u79d2\uff09", ignoredumpvalues="-1")
    public int getTimeout() {
        return this.nTimeout;
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u63cf\u8ff0", hideempty2=true)
    public String getActionDesc() {
        return this.strActionDesc;
    }

    @Override
    public String getPSSysModelInstId() {
        if (this.getPSControlHandler() != null) {
            return this.getPSControlHandler().getPSSysModelInstId();
        }
        return null;
    }

    @Override
    public String getModelType() {
        return "PSACHANDLERACTION";
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61")
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u8bbf\u95ee\u884c\u4e3a", hideempty2=true)
    public String getDataAccessAction() {
        return this.strDataAccessAction;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u884c\u4e3a\u540d\u79f0", hideempty2=true, dump=false)
    public String getDEActionName() {
        if (this.getPSDEAction() != null) {
            return this.getPSDEAction().getName();
        }
        return this.strDEActionName;
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u884c\u4e3a\u540d\u79f0", hideempty2=true, dump=false)
    public String getWFActionName() {
        return this.strWFActionName;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u884c\u4e3a\u540d\u79f0", hideempty2=true)
    public String getActionName() {
        if ("DEACTION".equals(this.getActionType())) {
            return this.getDEActionName();
        }
        if ("WFACTION".equals(this.getActionType())) {
            return this.getWFActionName();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u96c6\u5408", hideempty=true)
    public IPSDEDataSet getPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u7ed3\u679c\u96c6\u9644\u52a0\u6761\u4ef6", hideempty2=true)
    public String getCustomCond() {
        return this.psACHandlerAction.getCUSTOMCOND();
    }

    @Override
    @PSModelRTMeta(description="\u4e0a\u4e0b\u6587\u8f6c\u5316\u903b\u8f91", hideempty=true)
    public IPSDELogic getActiveDataPSDELogic() {
        return this.activeDataPSDELogic;
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSControlHandler().getModelId(), (Object)this.getName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        if (this.getPSControlHandler() != null) {
            return (IPSSystemUtil)((Object)this.getPSControlHandler().getPSControl().getPSAppView().getPSSystem());
        }
        return null;
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSControlHandler().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u65b9\u6cd5", dumpref=true, from="IPSAppDataEntity")
    public IPSAppDEMethod getPSAppDEMethod() {
        return this.iPSAppDEMethod;
    }

    @Override
    @PSModelRTMeta(description="\u4e0a\u4e0b\u6587\u8f6c\u6362\u903b\u8f91", dumpref=true, from="IPSAppDataEntity")
    public IPSAppDELogic getADPSAppDELogic() {
        return this.adPSAppDELogic;
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u5bf9\u8c61")
    public IPSControl getPSControl() {
        if (this.getPSControlHandler() != null) {
            return this.getPSControlHandler().getPSControl();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", dumpref=true)
    public IPSAppDataEntity getPSAppDataEntity() {
        return this.iPSAppDataEntity;
    }

    public IPSControlHandler getPSControlHandler() {
        return this.iPSControlHandler;
    }

    @Override
    protected void onFillModelRefNode(ObjectNode objectNode, String strModelRefType) throws Exception {
        if (StringHelper.isNullOrEmpty((String)strModelRefType)) {
            super.onFillModelRefNode(objectNode, "SIMPLE");
        } else {
            super.onFillModelRefNode(objectNode, strModelRefType);
        }
        if (this.getPSControl() != null && this.getPSControl().isEnableUIModelEx()) {
            this.onFillModelNode(objectNode, null);
        }
    }
}

