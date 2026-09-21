/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.Inflector
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Priv;

import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Security.IPSSysUniRes;
import SA.SRFDA.PS.Data.PSDEOPPriv;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEOPPrivImpl
extends PSSystemObjectImpl
implements IPSDEOPPriv,
IPSModelSortable {
    private static final Log log = LogFactory.getLog(PSDEOPPrivImpl.class);
    protected PSDEOPPriv psDEOPPriv = null;
    private String strLogicName = null;
    private IPSDataEntity iPSDataEntity = null;
    private String strPSDERName = null;
    private String strMapPSDEOPPrivName = null;
    private IPSDERBase iPSDERBase = null;
    private boolean bMapSysUniRes = false;
    private IPSSysUniRes iPSSysUniRes = null;
    private boolean bSystemReserved = false;
    private String strOPPrivType = "DEFAULT";
    private IPSDEFGroup iPSDEFGroup = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, IPSDataEntity iPSDataEntity, PSDEOPPriv psDEOPPriv) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.setPSDataEntity(iPSDataEntity);
            if (!StringHelper.isNullOrEmpty((String)psDEOPPriv.getPSDEID())) {
                if (this.getPSDataEntity() != null && StringHelper.compare((String)this.getPSDataEntity().getId(), (String)psDEOPPriv.getPSDEID(), (boolean)false) != 0) {
                    this.setPSDataEntity(null);
                }
                if (this.getPSDataEntity() == null) {
                    iPSDataEntity = this.getPSSystem().getPSDataEntity2(psDEOPPriv.getPSDEID());
                    this.setPSDataEntity(iPSDataEntity);
                }
            }
            this.psDEOPPriv = psDEOPPriv;
            this.setId(this.psDEOPPriv.getPSDEOPPRIVID());
            this.setName(this.psDEOPPriv.getPSDEOPPRIVNAME());
            this.strLogicName = this.psDEOPPriv.getLOGICNAME();
            this.setPSObjectData(this.psDEOPPriv);
            this.bMapSysUniRes = this.psDEOPPriv.getMAPSYSUNIRESMODE();
            if (this.isMapSysUniRes()) {
                if (!StringHelper.isNullOrEmpty((String)this.psDEOPPriv.getPSSYSUNIRESID())) {
                    this.iPSSysUniRes = this.getPSSystem().getPSSysUniRes(this.psDEOPPriv.getPSSYSUNIRESID());
                }
            } else if (!StringHelper.isNullOrEmpty((String)this.psDEOPPriv.getPSDERNAME())) {
                this.strPSDERName = this.psDEOPPriv.getPSDERNAME();
                this.strMapPSDEOPPrivName = this.psDEOPPriv.getMAPPSDEOPPRIVNAME();
                this.iPSDERBase = this.getPSSystem().getPSDER(this.psDEOPPriv.getPSDERID());
            }
            if (!this.psDEOPPriv.isSYSTEMFLAGNull()) {
                this.bSystemReserved = this.psDEOPPriv.getSYSTEMFLAG();
            }
            if (this.getPSDataEntity() != null) {
                if (!StringHelper.isNullOrEmpty((String)this.psDEOPPriv.getOPPRIVTYPE())) {
                    this.strOPPrivType = this.psDEOPPriv.getOPPRIVTYPE();
                }
                if (StringHelper.compare((String)this.getOPPrivType(), (String)"DEFGROUP", (boolean)true) == 0) {
                    if (StringHelper.isNullOrEmpty((String)this.psDEOPPriv.getPSDEFGROUPID())) {
                        throw new Exception("\u672a\u6307\u5b9a\u5c5e\u6027\u7ec4");
                    }
                    this.iPSDEFGroup = this.getPSDataEntity().getPSDEFGroup(this.psDEOPPriv.getPSDEFGROUPID());
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

    protected void setPSDataEntity(IPSDataEntity iPSDataEntity) {
        this.iPSDataEntity = iPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61", outputdoc="false")
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0", fields={"LOGICNAME"})
    public String getLogicName() {
        return this.strLogicName;
    }

    public IDataEntity getDataEntity() {
        return this.getPSDataEntity();
    }

    @Override
    public String getPSDERName() {
        return this.strPSDERName;
    }

    @Override
    @PSModelRTMeta(description="\u6620\u5c04\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6", hideempty2=true, fields={"MAPPSDEOPPRIVNAME"})
    public String getMapPSDEOPPrivName() {
        return this.strMapPSDEOPPrivName;
    }

    @Override
    @PSModelRTMeta(description="\u6620\u5c04\u5b9e\u4f53\u540d\u79f0", hideempty2=true, doc="\u7b49\u540c{@link #getMapPSDER}.getMajorDEName()")
    public String getMapPSDEName() {
        if (this.getMapPSDER() != null) {
            return this.getMapPSDER().getMajorDEName();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6620\u5c04\u5b9e\u4f53\u5bf9\u8c61", hideempty2=true, ignorepf=true, dumpref=true, doc="\u7b49\u540c{@link #getMapPSDER}.getMajorPSDataEntity()")
    public IPSDataEntity getMapPSDataEntity() {
        if (this.getMapPSDER() != null) {
            return this.getMapPSDER().getMajorPSDataEntity();
        }
        return null;
    }

    @Override
    public String getModelType() {
        return "PSDEOPPRIV";
    }

    @Override
    public String getModelId() {
        if (this.getPSDataEntity() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDataEntity().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }

    @Override
    public IPSDERBase getPSDER() {
        return this.iPSDERBase;
    }

    @Override
    public String getMapPSDERName() {
        return this.getPSDERName();
    }

    @Override
    @PSModelRTMeta(description="\u6620\u5c04\u5173\u7cfb\u5bf9\u8c61", hideempty2=true, dumpref=true, ignorepf=true, from="__self__", from_method="getMapPSDataEntityMust().getMajorPSDERBase", fields={"PSDERID"})
    public IPSDERBase getMapPSDER() {
        return this.getPSDER();
    }

    @Override
    @PSModelRTMeta(description="\u6620\u5c041:N\u5173\u7cfb\u5bf9\u8c61", hideempty2=true, ignorepf=true)
    public IPSDER1N getMapPSDER1N() {
        if (this.getPSDER() instanceof IPSDER1N) {
            return (IPSDER1N)this.getPSDER();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u7edf\u4e00\u8d44\u6e90", hideempty2=true, dumpref=true, ignorepf=true, group="\u57fa\u672c", order=126, fields={"PSSYSUNIRESID"})
    public IPSSysUniRes getMapPSSysUniRes() {
        return this.iPSSysUniRes;
    }

    @Override
    @PSModelRTMeta(description="\u6620\u5c04\u7cfb\u7edf\u7edf\u4e00\u8d44\u6e90", ignoredumpvalues="false", rtname="isMapSysUniResMode", group="\u57fa\u672c", order=125, fields={"MAPSYSUNIRESMODE"})
    public boolean isMapSysUniRes() {
        return this.bMapSysUniRes;
    }

    @Override
    @PSModelRTMeta(description="\u7edf\u4e00\u8d44\u6e90\u4ee3\u7801", hideempty2=true, doc="\u7b49\u540c{@link #getMapPSSysUniRes}.getResCode()")
    public String getMapSysUniResCode() {
        if (this.getMapPSSysUniRes() != null) {
            return this.getMapPSSysUniRes().getResCode();
        }
        return null;
    }

    @Override
    public int getOrderValue() {
        return 99999;
    }

    @Override
    public String getCodeName() {
        return null;
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u4fdd\u7559", ignoredumpvalues="false", fields={"SYSTEMFLAG"}, ignorert=3)
    public boolean isSystemReserved() {
        return this.bSystemReserved;
    }

    @Override
    public boolean isDEFieldPriv() {
        return false;
    }

    @Override
    public IPSDEField getPSDEField() {
        return null;
    }

    @Override
    public String getModelRefId() {
        if (this.getMapPSDER() != null) {
            if (!StringHelper.isNullOrEmpty((String)this.getMapPSDER().getCodeName())) {
                return String.format("%1$s__%2$s", this.getMapPSDER().getCodeName(), super.getModelRefId());
            }
            return String.format("%1$s__%2$s", this.getMapPSDER().getName(), super.getModelRefId());
        }
        return super.getModelRefId();
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u6807\u8bc6\u7c7b\u578b", ignorepf=true, codelist="DEOPPrivType", ignoredumpvalues="DEFAULT", fields={"OPPRIVTYPE"})
    public String getOPPrivType() {
        return this.strOPPrivType;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u7ec4", ignorepf=true, dumpref=true, from="IPSDataEntity", fields={"PSDEFGROUPID"})
    public IPSDEFGroup getPSDEFGroup() {
        return this.iPSDEFGroup;
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        if (this.getPSDataEntity() != null) {
            return this.getPSDataEntity();
        }
        return this.getPSSystem();
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        if (this.getPSDataEntity() != null) {
            return this.getPSDataEntity();
        }
        return this.getPSSystem();
    }

    @Override
    protected String onGetMOSFileName() {
        if (this.getMapPSDataEntity() != null) {
            return StringHelper.format((String)"%1$s__%2$s_%3$s", (Object)this.getName(), (Object)this.getMapPSDataEntity().getName(), (Object)this.getMapPSDEOPPrivName());
        }
        if (this.getMapPSSysUniRes() != null) {
            return StringHelper.format((String)"%1$s__%2$s_%3$s", (Object)this.getName(), (Object)this.getMapPSSysUniRes().getResCode());
        }
        return this.getName();
    }

    @Override
    protected String onGetRTMOSFileName() {
        if (this.getMapPSDataEntity() != null) {
            return StringHelper.format((String)"%1$s__%2$s_%3$s", (Object)this.getName(), (Object)this.getMapPSDataEntity().getName(), (Object)this.getMapPSDEOPPrivName());
        }
        if (this.getMapPSSysUniRes() != null) {
            return StringHelper.format((String)"%1$s__%2$s_%3$s", (Object)this.getName(), (Object)this.getMapPSSysUniRes().getResCode());
        }
        return this.getName();
    }

    @Override
    protected String onGetMOSFolder() {
        if (this.getPSDataEntity() != null) {
            return String.format("%1$s/%2$s", this.getPSDataEntity().getMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase();
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getPSDataEntity() != null) {
            return String.format("%1$s/%2$s", this.getPSDataEntity().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase();
    }

    @Override
    public int getExtendMode() {
        return 0;
    }
}

