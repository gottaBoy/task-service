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
package SA.SRFDA.PS.Core.DataEntity.DER;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1NDEFieldMap;
import SA.SRFDA.PS.Core.DataEntity.DER.PSDERDEFieldMapImpl;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Data.PSDERDEFMap;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDER1NDEFieldMapImpl
extends PSDERDEFieldMapImpl
implements IPSDER1NDEFieldMap {
    private static final Log log = LogFactory.getLog(PSDER1NDEFieldMapImpl.class);
    private IPSDER1N iPSDER1N = null;
    private PSDERDEFMap psDERDEFMap = null;
    private String strMapType = null;
    private IPSDEField majorPSDEField = null;
    private IPSDEField minorPSDEField = null;
    private IPSDEDataQuery minorPSDEDataQuery = null;
    private String strMinorPSDEDQId = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDER1N iPSDER1N, PSDERDEFMap psDERDEFMap) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDER1N = iPSDER1N;
            this.setPSDERBase(this.iPSDER1N);
            this.psDERDEFMap = psDERDEFMap;
            this.setPSObjectData(psDERDEFMap);
            this.setId(psDERDEFMap.getPSDERDEFMAPID());
            this.setName(psDERDEFMap.getPSDERDEFMAPNAME());
            this.strMapType = this.psDERDEFMap.getMAPTYPE();
            this.strMinorPSDEDQId = this.psDERDEFMap.getPSDEDQID();
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
        if (!StringHelper.isNullOrEmpty((String)this.psDERDEFMap.getPSSYSSFPLUGINID())) {
            this.iPSSysSFPlugin = this.getPSDER1N().getPSSystem().getPSSysSFPlugin(this.psDERDEFMap.getPSSYSSFPLUGINID());
        }
        if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSDER1N().getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSDER1N().getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u6620\u5c04\u7c7b\u578b", codelist="DER1NDEFMapType", fields={"MAPTYPE"})
    public String getMapType() {
        return this.strMapType;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psDERDEFMap.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSDER1N", from_method="getMajorPSDataEntityMust().getPSDEField", fields={"MAJORPSDEFID"})
    public IPSDEField getMajorPSDEField() throws Exception {
        if (this.majorPSDEField == null) {
            this.majorPSDEField = this.getPSDER1N().getMajorPSDataEntity().getPSDEField(this.psDERDEFMap.getMAJORPSDEFID());
        }
        return this.majorPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u4ece\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSDER1N", from_method="getMinorPSDataEntityMust().getPSDEField", fields={"MINORPSDEFID"})
    public IPSDEField getMinorPSDEField() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psDERDEFMap.getMINORPSDEFID())) {
            return null;
        }
        if (this.minorPSDEField == null) {
            this.minorPSDEField = this.getPSDER1N().getMinorPSDataEntity().getPSDEField(this.psDERDEFMap.getMINORPSDEFID());
        }
        return this.minorPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5173\u7cfb", outputdoc="false")
    public IPSDER1N getPSDER1N() {
        return this.iPSDER1N;
    }

    @Override
    @PSModelRTMeta(description="\u4ece\u5b9e\u4f53\u6570\u636e\u67e5\u8be2", dumpref=true, from="IPSDER1N", from_method="getMinorPSDataEntityMust().getPSDEDataQuery", fields={"PSDEDQID"})
    public IPSDEDataQuery getMinorPSDEDataQuery() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.getMinorPSDEDataQueryId())) {
            return null;
        }
        if (this.minorPSDEDataQuery == null) {
            this.minorPSDEDataQuery = this.getPSDER1N().getMinorPSDataEntity().getPSDEDataQuery(this.getMinorPSDEDataQueryId());
        }
        return this.minorPSDEDataQuery;
    }

    @Override
    public String getMinorPSDEDataQueryId() {
        return this.strMinorPSDEDQId;
    }

    @Override
    public String getModelType() {
        return "PSDER1NDEFMAP";
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSSFXCodeObject getRender() {
        return this.iPSSFXCodeObject;
    }
}

