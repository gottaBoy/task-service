/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DataMap;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMap;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMapField;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DataMap.IPSDEMap;
import SA.SRFDA.PS.Core.DataEntity.DataMap.IPSDEMapDetail;
import SA.SRFDA.PS.Core.DataEntity.DataMap.IPSDEMapField;
import SA.SRFDA.PS.Core.DataEntity.DataMap.PSDEMapObjectImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSSysTranslator;
import SA.SRFDA.PS.Data.PSDEMapDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEMapDetailImpl
extends PSDEMapObjectImpl
implements IPSDEMapDetail,
IPSDEMapField,
IPSAppDEMapField {
    private static final Log log = LogFactory.getLog(PSDEMapDetailImpl.class);
    private PSDEMapDetail psDEMapDetail = null;
    private String strDstFieldName = "";
    private String strSrcFieldName = "";
    private String strSrcValue = "";
    private IPSDEField srcPSDEField = null;
    private IPSDEField dstPSDEField = null;
    private IPSAppDEField srcPSAppDEField = null;
    private IPSAppDEField dstPSAppDEField = null;
    private String strSrcType = null;
    private IPSSysTranslator iPSSysTranslator = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEMap iPSDEMap, PSDEMapDetail psDEMapDetail) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDEMap(iPSDEMap);
            this.psDEMapDetail = psDEMapDetail;
            this.setId(this.psDEMapDetail.getPSDEMAPDETAILID());
            this.setName(this.psDEMapDetail.getPSDEMAPDETAILNAME());
            this.setPSObjectData(this.psDEMapDetail);
            this.strDstFieldName = this.psDEMapDetail.getDSTFIELDNAME();
            this.strSrcFieldName = this.psDEMapDetail.getSRCPSDEFNAME();
            this.strSrcValue = this.psDEMapDetail.getSRCVALUE();
            this.strSrcType = this.psDEMapDetail.getSRCTYPE();
            if (!StringHelper.IsNullOrEmpty((String)this.getSrcFieldName())) {
                this.srcPSDEField = this.getPSDEMap().getPSDataEntity().getPSDEField(this.getSrcFieldName(), true);
            }
            if (this.getPSDEMap().getDstPSDE() != null && !StringHelper.IsNullOrEmpty((String)this.getDstFieldName())) {
                this.dstPSDEField = this.getPSDEMap().getDstPSDE().getPSDEField(this.getDstFieldName(), true);
            }
            if (iPSDEMap instanceof IPSAppDEMap) {
                IPSAppDEMap iPSAppDEMap = (IPSAppDEMap)iPSDEMap;
                if (iPSAppDEMap.getPSAppDataEntity() != null && this.srcPSDEField != null) {
                    this.srcPSAppDEField = iPSAppDEMap.getPSAppDataEntity().getPSAppDEField(this.srcPSDEField, false);
                }
                if (iPSAppDEMap.getDstPSAppDataEntity() != null && this.dstPSDEField != null) {
                    this.dstPSAppDEField = iPSAppDEMap.getDstPSAppDataEntity().getPSAppDEField(this.dstPSDEField, false);
                }
            }
            if (StringHelper.IsNullOrEmpty((String)this.strSrcType)) {
                this.strSrcType = this.getSrcPSDEField() == null ? "VALUE" : "FIELD";
            }
            if (StringHelper.Compare((String)this.getSrcType(), (String)"FIELD", (boolean)false) == 0 && !StringHelper.IsNullOrEmpty((String)this.psDEMapDetail.getPSSYSTRANSLATORID())) {
                this.iPSSysTranslator = this.getPSDEMap().getPSDataEntity().getPSSystem().getPSSysTranslator(this.psDEMapDetail.getPSSYSTRANSLATORID());
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = net.ibizsys.paas.util.StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = net.ibizsys.paas.util.StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)net.ibizsys.paas.util.StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
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
    @PSModelRTMeta(description="\u76ee\u6807\u5c5e\u6027\u540d\u79f0", fields={"DSTFIELDNAME"})
    public String getDstFieldName() {
        return this.strDstFieldName;
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u5c5e\u6027\u540d\u79f0", fields={"SRCPSDEFNAME"})
    public String getSrcFieldName() {
        return this.strSrcFieldName;
    }

    @Override
    public String getSrcValue() {
        return this.strSrcValue;
    }

    @Override
    public String getModelType() {
        if (StringHelper.Compare((String)this.getPSDEMap().getModelType(), (String)"PSAPPDEMAP", (boolean)true) == 0) {
            return "PSAPPDEMAPFIELD";
        }
        return "PSDEMAPDETAIL";
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSDEMap", from_method="getDstPSDEMust().getPSDEField", ignorepf=true, fields={"DSTFIELDNAME"})
    public IPSDEField getDstPSDEField() {
        return this.dstPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSDataEntity", ignorepf=true, fields={"SRCPSDEFNAME"})
    public IPSDEField getSrcPSDEField() {
        return this.srcPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSAppDEMap", from_method="getDstPSAppDataEntityMust().getPSAppDEField")
    public IPSAppDEField getDstPSAppDEField() {
        return this.dstPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSAppDataEntity")
    public IPSAppDEField getSrcPSAppDEField() {
        return this.srcPSAppDEField;
    }

    @Override
    public String getSrcType() {
        return this.strSrcType;
    }

    @Override
    public String getModelRefId() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6620\u5c04\u7c7b\u578b", codelist="DEMapFieldSrcType", fields={"SRCTYPE"})
    public String getMapType() {
        return this.strSrcType;
    }

    @Override
    @PSModelRTMeta(description="\u76f4\u63a5\u503c", hideempty2=true, fields={"SRCVALUE"})
    public String getRawValue() {
        if (StringHelper.Compare((String)this.getMapType(), (String)"VALUE", (boolean)false) == 0 || StringHelper.Compare((String)this.getMapType(), (String)"VALUE_SRC", (boolean)false) == 0) {
            return this.strSrcValue;
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u8868\u8fbe\u5f0f", hideempty2=true, fields={"SRCVALUE"})
    public String getExpression() {
        if (StringHelper.Compare((String)this.getMapType(), (String)"EXPRESSION", (boolean)false) == 0 || StringHelper.Compare((String)this.getMapType(), (String)"EXPRESSION_SRC", (boolean)false) == 0) {
            return this.strSrcValue;
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u503c\u8f6c\u6362\u5668", hideempty=true, dumpref=true, ignorepf=true, fields={"PSSYSTRANSLATORID"})
    public IPSSysTranslator getPSSysTranslator() {
        return this.iPSSysTranslator;
    }
}

