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
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERAggData;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERAggDataDEFieldMap;
import SA.SRFDA.PS.Core.DataEntity.DER.PSDERDEFieldMapImpl;
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

public class PSDERAggDataDEFieldMapImpl
extends PSDERDEFieldMapImpl
implements IPSDERAggDataDEFieldMap {
    private static final Log log = LogFactory.getLog(PSDERAggDataDEFieldMapImpl.class);
    private IPSDERAggData iPSDERAggData = null;
    private PSDERDEFMap psDERDEFMap = null;
    private String strMapType = null;
    private IPSDEField majorPSDEField = null;
    private IPSDEField minorPSDEField = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDERAggData iPSDERAggData, PSDERDEFMap psDERDEFMap) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDERAggData = iPSDERAggData;
            this.setPSDERBase(this.iPSDERAggData);
            this.psDERDEFMap = psDERDEFMap;
            this.setPSObjectData(psDERDEFMap);
            this.setId(psDERDEFMap.getPSDERDEFMAPID());
            this.setName(psDERDEFMap.getPSDERDEFMAPNAME());
            this.strMapType = this.psDERDEFMap.getMAPTYPE();
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
            this.iPSSysSFPlugin = this.getPSDERAggData().getPSSystem().getPSSysSFPlugin(this.psDERDEFMap.getPSSYSSFPLUGINID());
        }
        if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSDERAggData().getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSDERAggData().getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u6620\u5c04\u7c7b\u578b", codelist="DERAggDataDEFMapType", fields={"MAPTYPE"})
    public String getMapType() {
        return this.strMapType;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psDERDEFMap.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSDERAggData", from_method="getMajorPSDataEntityMust().getPSDEField", fields={"MAJORPSDEFID"})
    public IPSDEField getMajorPSDEField() throws Exception {
        if (this.majorPSDEField == null) {
            this.majorPSDEField = this.getPSDERAggData().getMajorPSDataEntity().getPSDEField(this.psDERDEFMap.getMAJORPSDEFID());
        }
        return this.majorPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u4ece\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSDERAggData", from_method="getMinorPSDataEntityMust().getPSDEField", fields={"MINORPSDEFID"})
    public IPSDEField getMinorPSDEField() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psDERDEFMap.getMINORPSDEFID())) {
            return null;
        }
        if (this.minorPSDEField == null) {
            this.minorPSDEField = this.getPSDERAggData().getMinorPSDataEntity().getPSDEField(this.psDERDEFMap.getMINORPSDEFID());
        }
        return this.minorPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5173\u7cfb", outputdoc="false")
    public IPSDERAggData getPSDERAggData() {
        return this.iPSDERAggData;
    }

    @Override
    public String getModelType() {
        return "PSDERAGGDATADEFMAP";
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

    @Override
    @PSModelRTMeta(description="\u516c\u5f0f\u5217\u683c\u5f0f", hideempty2=true, fields={"FORMULAFORMAT"})
    public String getFormulaFormat() {
        return this.psDERDEFMap.getFORMULAFORMAT();
    }

    @Override
    @PSModelRTMeta(description="\u94bb\u53d6\u6761\u4ef6\u683c\u5f0f", hideempty2=true)
    public String getDrillDownCondFormat() {
        return "";
    }
}

