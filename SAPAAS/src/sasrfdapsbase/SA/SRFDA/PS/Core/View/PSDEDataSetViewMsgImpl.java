/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.View;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.View.IPSDEDataSetViewMsg;
import SA.SRFDA.PS.Core.View.PSViewMsgImpl;
import net.ibizsys.paas.util.StringHelper;

@PSModelPFIgnoreMeta
public class PSDEDataSetViewMsgImpl
extends PSViewMsgImpl
implements IPSDEDataSetViewMsg {
    private IPSDEDataSet iPSDEDataSet = null;
    private IPSDEField titlePSDEField = null;
    private IPSDEField msgTypePSDEField = null;
    private IPSDEField msgPosPSDEField = null;
    private IPSDEField removeFlagPSDEField = null;
    private IPSDEField contentPSDEField = null;
    private IPSDEField titleLanResTagPSDEField = null;
    private IPSDEField cacheTagPSDEField = null;
    private IPSDEField cacheTag2PSDEField = null;
    private IPSDELogic activeDataPSDELogic = null;
    private IPSDEField orderValuePSDEField = null;
    private IPSDEField contentTypePSDEField = null;
    private boolean bEnableCache = false;
    private String strCacheScope = null;
    private int nCacheTimeout = -1;
    private boolean bDefaultFlag = false;

    @Override
    protected void onInit() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psViewMsg.getPSDEID())) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u89c6\u56fe\u6d88\u606f\u6240\u5f15\u7528\u7684\u5b9e\u4f53");
        }
        if (!this.psViewMsg.isDEFAULTFLAGNull()) {
            this.bDefaultFlag = this.psViewMsg.getDEFAULTFLAG();
        }
        if (!this.psViewMsg.isENABLECACHENull()) {
            this.bEnableCache = this.psViewMsg.getENABLECACHE();
        }
        if (this.isEnableCache()) {
            if (!this.psViewMsg.isCACHETIMEOUTNull()) {
                this.nCacheTimeout = this.psViewMsg.getCACHETIMEOUT();
            }
            if (!this.psViewMsg.isCACHESCOPENull()) {
                this.strCacheScope = this.psViewMsg.getCACHESCOPE();
            }
        }
        this.setPSDataEntity(this.getPSSystem().getPSDataEntity2(this.psViewMsg.getPSDEID()));
        this.iPSDEDataSet = this.getPSDataEntity().getPSDEDataSet(this.psViewMsg.getPSDEDSID());
        if (!StringHelper.isNullOrEmpty((String)this.psViewMsg.getTITLEPSDEFID())) {
            this.titlePSDEField = this.getPSDataEntity().getPSDEField(this.psViewMsg.getTITLEPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psViewMsg.getMSGPOSPSDEFID())) {
            this.msgPosPSDEField = this.getPSDataEntity().getPSDEField(this.psViewMsg.getMSGPOSPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psViewMsg.getMSGTYPEPSDEFID())) {
            this.msgTypePSDEField = this.getPSDataEntity().getPSDEField(this.psViewMsg.getMSGTYPEPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psViewMsg.getREMOVEPSDEFID())) {
            this.removeFlagPSDEField = this.getPSDataEntity().getPSDEField(this.psViewMsg.getREMOVEPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psViewMsg.getTITLELANRESTAGPSDEFID())) {
            this.titleLanResTagPSDEField = this.getPSDataEntity().getPSDEField(this.psViewMsg.getTITLELANRESTAGPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psViewMsg.getCONTENTPSDEFID())) {
            this.contentPSDEField = this.getPSDataEntity().getPSDEField(this.psViewMsg.getCONTENTPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psViewMsg.getORDERVALUEPSDEFID())) {
            this.orderValuePSDEField = this.getPSDataEntity().getPSDEField(this.psViewMsg.getORDERVALUEPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psViewMsg.getCACHETAGPSDEFID())) {
            this.cacheTagPSDEField = this.getPSDataEntity().getPSDEField(this.psViewMsg.getCACHETAGPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psViewMsg.getCACHETAG2PSDEFID())) {
            this.cacheTag2PSDEField = this.getPSDataEntity().getPSDEField(this.psViewMsg.getCACHETAG2PSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psViewMsg.getPSDELOGICID())) {
            this.activeDataPSDELogic = this.getPSDataEntity().getPSDELogic(this.psViewMsg.getPSDELOGICID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psViewMsg.getCONTENTTYPEPSDEFID())) {
            this.contentTypePSDEField = this.getPSDataEntity().getPSDEField(this.psViewMsg.getCONTENTTYPEPSDEFID());
        }
        super.onInit();
    }

    public String getDEName() {
        if (this.getPSDataEntity() != null) {
            return this.getPSDataEntity().getName();
        }
        return null;
    }

    public String getDEDataSetName() {
        if (this.getPSDEDataSet() != null) {
            return this.getPSDEDataSet().getName();
        }
        return null;
    }

    public String getTitleField() {
        if (this.getTitlePSDEField() != null) {
            return this.getTitlePSDEField().getName();
        }
        return null;
    }

    public String getTitleLanResTagField() {
        if (this.getTitleLanResTagPSDEField() != null) {
            return this.getTitleLanResTagPSDEField().getName();
        }
        return null;
    }

    public String getMsgTypeField() {
        if (this.getMsgTypePSDEField() != null) {
            return this.getMsgTypePSDEField().getName();
        }
        return null;
    }

    public String getMsgPosField() {
        if (this.getMsgPosPSDEField() != null) {
            return this.getMsgPosPSDEField().getName();
        }
        return null;
    }

    public String getRemoveFlagField() {
        if (this.getRemoveFlagPSDEField() != null) {
            return this.getRemoveFlagPSDEField().getName();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u96c6\u5408\u5bf9\u8c61")
    public IPSDEDataSet getPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u62ac\u5934\u5c5e\u6027\u5bf9\u8c61", hideempty=true)
    public IPSDEField getTitlePSDEField() {
        return this.titlePSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u62ac\u5934\u8bed\u8a00\u6807\u8bb0\u5c5e\u6027\u5bf9\u8c61", hideempty=true)
    public IPSDEField getTitleLanResTagPSDEField() {
        return this.titleLanResTagPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u7c7b\u578b\u5c5e\u6027\u5bf9\u8c61", hideempty=true)
    public IPSDEField getMsgTypePSDEField() {
        return this.msgTypePSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u4f4d\u7f6e\u5c5e\u6027\u5bf9\u8c61", hideempty=true)
    public IPSDEField getMsgPosPSDEField() {
        return this.msgPosPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u9664\u6807\u5fd7\u5c5e\u6027\u5bf9\u8c61", hideempty=true)
    public IPSDEField getRemoveFlagPSDEField() {
        return this.removeFlagPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u5c5e\u6027\u5bf9\u8c61", hideempty=true)
    public IPSDEField getContentPSDEField() {
        return this.contentPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u7c7b\u578b\u5c5e\u6027\u5bf9\u8c61", hideempty=true)
    public IPSDEField getContentTypePSDEField() {
        return this.contentTypePSDEField;
    }

    public String getContentField() {
        if (this.getContentPSDEField() == null) {
            return null;
        }
        return this.getContentPSDEField().getName();
    }

    public String getActiveDataDELogicId() {
        if (this.getActiveDataPSDELogic() != null) {
            return this.getActiveDataPSDELogic().getId();
        }
        return null;
    }

    public String getOrderValueField() {
        if (this.getOrderValuePSDEField() != null) {
            return this.getOrderValuePSDEField().getName();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u7f13\u5b58")
    public boolean isEnableCache() {
        return this.bEnableCache;
    }

    @Override
    @PSModelRTMeta(description="\u7f13\u5b58\u8303\u56f4", codelist="ViewMsgCacheScope")
    public String getCacheScope() {
        return this.strCacheScope;
    }

    @Override
    @PSModelRTMeta(description="\u7f13\u5b58\u8d85\u65f6")
    public int getCacheTimeout() {
        return this.nCacheTimeout;
    }

    public String getCacheTagField() {
        if (this.getCacheTagPSDEField() != null) {
            return this.getCacheTagPSDEField().getName();
        }
        return null;
    }

    public String getCacheTag2Field() {
        if (this.getCacheTag2PSDEField() != null) {
            return this.getCacheTag2PSDEField().getName();
        }
        return null;
    }

    @Override
    public boolean getDefaultFlag() {
        return this.bDefaultFlag;
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c\u5c5e\u6027\u5bf9\u8c61", hideempty=true)
    public IPSDEField getOrderValuePSDEField() {
        return this.orderValuePSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u4e0a\u4e0b\u6587\u6570\u636e\u8f6c\u5316\u903b\u8f91", hideempty=true)
    public IPSDELogic getActiveDataPSDELogic() {
        return this.activeDataPSDELogic;
    }

    @Override
    @PSModelRTMeta(description="\u7f13\u5b58\u6807\u8bb0\u5c5e\u6027\u5bf9\u8c61", hideempty=true)
    public IPSDEField getCacheTagPSDEField() {
        return this.cacheTagPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u7f13\u5b58\u6807\u8bb02\u5c5e\u6027\u5bf9\u8c61", hideempty=true)
    public IPSDEField getCacheTag2PSDEField() {
        return this.cacheTag2PSDEField;
    }

    @PSModelRTMeta(description="\u6570\u636e\u6e90", codelist="SysDeployDBMode")
    public String getDSLink() {
        return this.psViewMsg.getDSLINK();
    }
}

