/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.Inflector
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DER;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSLinkDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImplBase;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Data.PSDER;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDERBaseImpl
extends PSSystemObjectImplBase
implements IPSDERBase {
    private static final Log log = LogFactory.getLog(PSDERBaseImpl.class);
    protected IPSDataEntity majorPSDataEntity = null;
    protected IPSDataEntity minorPSDataEntity = null;
    protected PSDER psDER = null;
    protected String strCodeName = "";
    protected String strMinorCodeName = "";
    private String strLogicName = "";
    private int nOrderValue = 100;
    private IPSSysSFPlugin iPSSysSFPlugin = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity majorPSDataEntity, IPSDataEntity minorPSDataEntity, PSDER psDER) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.psDER = psDER;
            this.setId(this.psDER.getPSDERID());
            if (StringHelper.isNullOrEmpty((String)this.psDER.getPSDERNAME())) {
                this.setName(this.psDER.getPSDERNAME());
            } else {
                this.setName(this.psDER.getPSDERNAME().replace(" ", ""));
            }
            this.setPSObjectData(this.psDER);
            this.majorPSDataEntity = majorPSDataEntity;
            this.minorPSDataEntity = minorPSDataEntity;
            if (this.majorPSDataEntity == null) {
                throw new Exception(StringHelper.format((String)"\u5173\u7cfb[%1$s]\u4e3b\u5b9e\u4f53\u65e0\u6548", (Object)this.getName()));
            }
            if (this.minorPSDataEntity == null) {
                throw new Exception(StringHelper.format((String)"\u5173\u7cfb[%1$s]\u4ece\u5b9e\u4f53\u65e0\u6548", (Object)this.getName()));
            }
            this.setLogicName(this.psDER.getLOGICNAME());
            if (!this.psDER.isORDERVALUENull()) {
                this.nOrderValue = this.psDER.getORDERVALUE();
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getModelName());
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
        String strPSSysSFPluginId = this.psDER.getPSSYSSFPLUGINID();
        if (!StringHelper.isNullOrEmpty((String)strPSSysSFPluginId)) {
            this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(strPSSysSFPluginId);
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u7c7b\u578b", codelist="DERType", group="\u57fa\u672c", order=125, fields={"DERTYPE"})
    public String getDERType() {
        return this.psDER.getDERTYPE();
    }

    public String getMajorDEId() {
        return this.getMajorPSDEId();
    }

    public String getMinorDEId() {
        return this.getMinorPSDEId();
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u5b9e\u4f53", dumpref=true, allowempty=false, ignorepf=true, group="\u57fa\u672c", order=126, fields={"MAJORPSDEID"})
    public IPSDataEntity getMajorPSDataEntity() {
        return this.majorPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u5b9e\u4f53", dumpref=true, allowempty=false, ignorepf=true, group="\u57fa\u672c", order=127, fields={"MINORPSDEID"})
    public IPSDataEntity getMinorPSDataEntity() {
        return this.minorPSDataEntity;
    }

    @Override
    public String getMajorPSDEId() {
        return this.majorPSDataEntity.getId();
    }

    @Override
    public String getMinorPSDEId() {
        return this.minorPSDataEntity.getId();
    }

    public String getMajorDEName() {
        return this.majorPSDataEntity.getName();
    }

    public String getMinorDEName() {
        return this.minorPSDataEntity.getName();
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
    @PSModelRTMeta(description="\u5173\u7cfb\u6570\u636e\u4ee3\u7801\u6807\u8bc6", fields={"MINORCODENAME"})
    public String getMinorCodeName() {
        return this.onGetMinorCodeName();
    }

    protected String onGetMinorCodeName() {
        return this.strMinorCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u4ee3\u7801\u6807\u8bc6", fields={"SERVICECODENAME"})
    public String getServiceCodeName() {
        return this.onGetServiceCodeName();
    }

    protected String onGetServiceCodeName() {
        String strServiceCodeName = this.psDER.getSERVICECODENAME();
        if (StringHelper.isNullOrEmpty((String)strServiceCodeName)) {
            return this.getMinorPSDataEntity().getAPICodeName(null, this.getCodeName(), null);
        }
        return strServiceCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u6570\u636e\u670d\u52a1\u4ee3\u7801\u6807\u8bc6", fields={"MINORSERVICECODENAME"})
    public String getMinorServiceCodeName() {
        return this.onGetMinorServiceCodeName();
    }

    protected String onGetMinorServiceCodeName() {
        String strMinorServiceCodeName = this.psDER.getMINORSERVICECODENAME();
        if (StringHelper.isNullOrEmpty((String)strMinorServiceCodeName)) {
            return this.getMajorPSDataEntity().getAPICodeName(null, this.getMinorCodeName(), null);
        }
        return strMinorServiceCodeName;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.majorPSDataEntity.getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0", fields={"LOGICNAME"})
    public String getLogicName() {
        return this.strLogicName;
    }

    @Override
    @PSModelRTMeta(description="\u4ece\u903b\u8f91\u540d\u79f0", fields={"MINORLOGICNAME"})
    public String getMinorLogicName() {
        return this.psDER.getMINORLOGICNAME();
    }

    protected void setLogicName(String strLogicName) {
        this.strLogicName = strLogicName;
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c", fields={"ORDERVALUE"})
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    public void fillViewParentModeJO(JSONObject jo) {
        this.onFillViewParentModeJO(jo);
    }

    protected void onFillViewParentModeJO(JSONObject jo) {
        if (!jo.has("SRFPARENTTYPE".toLowerCase())) {
            jo.put("SRFPARENTTYPE".toLowerCase(), (Object)this.getDERType());
        }
    }

    @Override
    public String getModelType() {
        return "PSDER_" + this.getDERType();
    }

    @Override
    public IPSSystem getPSSystem() {
        if (this.getMajorPSDataEntity() == null) {
            return null;
        }
        return this.getMajorPSDataEntity().getPSSystem();
    }

    @Override
    @PSModelRTMeta(description="\u5168\u90e8\u5173\u7cfb\u5c5e\u6027")
    public Iterator<IPSLinkDEField> getAllPSLinkDEFields() throws Exception {
        ArrayList<IPSLinkDEField> psLinkDEFieldList = new ArrayList<IPSLinkDEField>();
        Iterator<IPSDEField> psDEFields = this.getMinorPSDataEntity().getAllPSDEFields();
        if (psDEFields != null) {
            while (psDEFields.hasNext()) {
                IPSLinkDEField iPSLinkDEField;
                IPSDEField iPSDEField = psDEFields.next();
                if (!(iPSDEField instanceof IPSLinkDEField) || StringHelper.compare((String)(iPSLinkDEField = (IPSLinkDEField)iPSDEField).getDERId(), (String)this.getId(), (boolean)false) != 0) continue;
                psLinkDEFieldList.add(iPSLinkDEField);
            }
        }
        if (psLinkDEFieldList.size() == 0) {
            return null;
        }
        return psLinkDEFieldList.iterator();
    }

    @Override
    public String getModelRefId() {
        return this.getName();
    }

    @Override
    protected String onGetDynaModelTag() {
        return this.getName();
    }

    @Override
    public String getDumpModelType() {
        return "PSDER";
    }

    @Override
    protected String onGetDynaModelFolder() {
        if (this.getMinorPSDataEntity() != null) {
            return String.format("%1$s/%2$s/%3$s", this.getMinorPSDataEntity().getDynaModelFolder(), Inflector.getInstance().pluralize((Object)this.getDumpModelType()).toUpperCase(), this.getDynaModelTag());
        }
        return super.onGetDynaModelFolder();
    }

    @Override
    protected String onGetMOSFolder() {
        if (this.getMinorPSDataEntity() != null) {
            return String.format("%1$s/minorpsders", this.getMinorPSDataEntity().getMOSFilePath());
        }
        return super.onGetMOSFolder();
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getMinorPSDataEntity() != null) {
            return String.format("%1$s/minorpsders", this.getMinorPSDataEntity().getRTMOSFilePath());
        }
        return super.onGetRTMOSFolder();
    }

    @Override
    protected String onGetMOSFileName() {
        return this.getName();
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u6807\u8bb0", fields={"DERTAG"})
    public String getDERTag() {
        return this.psDER.getDERTAG();
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u6807\u8bb02", fields={"DERTAG2"})
    public String getDERTag2() {
        return this.psDER.getDERTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }
}

