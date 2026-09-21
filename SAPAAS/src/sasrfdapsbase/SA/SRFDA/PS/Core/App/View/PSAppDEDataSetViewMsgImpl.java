/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.View.IPSAppDEDataSetViewMsg;
import SA.SRFDA.PS.Core.App.View.PSAppViewMsgImpl;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.View.IPSDEDataSetViewMsg;
import SA.SRFDA.PS.Core.View.IPSViewMsg;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;

@PSModelImplementMeta(implement="IPSAppViewMsg", typevalues={"1"})
public class PSAppDEDataSetViewMsgImpl
extends PSAppViewMsgImpl
implements IPSAppDEDataSetViewMsg {
    private IPSDEDataSetViewMsg iPSDEDataSetViewMsg;
    private IPSAppDataEntity iPSAppDataEntity;
    private IPSAppDEDataSet iPSAppDEDataSet;
    private IPSAppDEField titlePSAppDEField;
    private IPSAppDEField titleLanResTagPSAppDEField;
    private IPSAppDEField msgTypePSAppDEField;
    private IPSAppDEField msgPosPSAppDEField;
    private IPSAppDEField removeFlagPSAppDEField;
    private IPSAppDEField contentPSAppDEField;
    private IPSAppDEField orderValuePSAppDEField;
    private IPSAppDEField cacheTagPSAppDEField;
    private IPSAppDEField cacheTag2PSAppDEField;
    private IPSAppDEField contentTypePSAppDEField;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, IPSViewMsg iPSViewMsg) throws Exception {
        if (!(iPSViewMsg instanceof IPSDEDataSetViewMsg)) {
            throw new Exception(StringHelper.format((String)"\u4f20\u5165\u89c6\u56fe\u6d88\u606f\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e"));
        }
        this.iPSDEDataSetViewMsg = (IPSDEDataSetViewMsg)iPSViewMsg;
        super.init(iDAGlobalHelper, iPSApplication, iPSViewMsg);
    }

    public IPSDEDataSetViewMsg getPSDEDataSetViewMsg() {
        return this.iPSDEDataSetViewMsg;
    }

    @Override
    protected void onInit() throws Exception {
        boolean bTryMode = true;
        if (this.getPSDataEntity() != null) {
            this.iPSAppDataEntity = this.getPSApplication().getPSAppDataEntity(this.getPSDataEntity(), bTryMode);
        }
        if (this.getPSAppDataEntity() != null) {
            if (this.getPSDEDataSet() != null) {
                this.iPSAppDEDataSet = (IPSAppDEDataSet)this.getPSAppDataEntity().getPSAppDEMethod(this.getPSDEDataSet(), bTryMode);
            }
            if (this.getTitlePSDEField() != null) {
                this.titlePSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getTitlePSDEField(), bTryMode);
            }
            if (this.getTitleLanResTagPSDEField() != null) {
                this.titleLanResTagPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getTitleLanResTagPSDEField(), bTryMode);
            }
            if (this.getMsgTypePSDEField() != null) {
                this.msgTypePSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getMsgTypePSDEField(), bTryMode);
            }
            if (this.getMsgPosPSDEField() != null) {
                this.msgPosPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getMsgPosPSDEField(), bTryMode);
            }
            if (this.getRemoveFlagPSDEField() != null) {
                this.removeFlagPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getRemoveFlagPSDEField(), bTryMode);
            }
            if (this.getContentPSDEField() != null) {
                this.contentPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getContentPSDEField(), bTryMode);
            }
            if (this.getContentTypePSDEField() != null) {
                this.contentTypePSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getContentTypePSDEField(), bTryMode);
            }
            if (this.getOrderValuePSDEField() != null) {
                this.orderValuePSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getOrderValuePSDEField(), bTryMode);
            }
            if (this.getCacheTagPSDEField() != null) {
                this.cacheTagPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getCacheTagPSDEField(), bTryMode);
            }
            if (this.getCacheTag2PSDEField() != null) {
                this.cacheTag2PSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getCacheTag2PSDEField(), bTryMode);
            }
        }
        super.onInit();
    }

    public String getDEName() {
        return this.getPSDEDataSetViewMsg().getDEName();
    }

    public String getDEDataSetName() {
        return this.getPSDEDataSetViewMsg().getDEDataSetName();
    }

    @PSModelRTMeta(description="\u62ac\u5934\u5c5e\u6027", hideempty=true, dump=false)
    public String getTitleField() {
        return this.getPSDEDataSetViewMsg().getTitleField();
    }

    @PSModelRTMeta(description="\u62ac\u5934\u8bed\u8a00\u6807\u8bb0\u5c5e\u6027", hideempty=true, dump=false)
    public String getTitleLanResTagField() {
        return this.getPSDEDataSetViewMsg().getTitleLanResTagField();
    }

    @PSModelRTMeta(description="\u6d88\u606f\u7c7b\u578b\u5c5e\u6027", hideempty=true, dump=false)
    public String getMsgTypeField() {
        return this.getPSDEDataSetViewMsg().getMsgTypeField();
    }

    @PSModelRTMeta(description="\u6d88\u606f\u4f4d\u7f6e\u5c5e\u6027", hideempty=true, dump=false)
    public String getMsgPosField() {
        return this.getPSDEDataSetViewMsg().getMsgPosField();
    }

    @PSModelRTMeta(description="\u79fb\u9664\u6807\u5fd7\u5c5e\u6027", hideempty=true, dump=false)
    public String getRemoveFlagField() {
        return this.getPSDEDataSetViewMsg().getRemoveFlagField();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61")
    public IPSDataEntity getPSDataEntity() {
        return this.getPSDEDataSetViewMsg().getPSDataEntity();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u96c6\u5408\u5bf9\u8c61")
    public IPSDEDataSet getPSDEDataSet() {
        return this.getPSDEDataSetViewMsg().getPSDEDataSet();
    }

    @Override
    @PSModelRTMeta(description="\u62ac\u5934\u5c5e\u6027\u5bf9\u8c61", hideempty=true)
    public IPSDEField getTitlePSDEField() {
        return this.getPSDEDataSetViewMsg().getTitlePSDEField();
    }

    @Override
    @PSModelRTMeta(description="\u62ac\u5934\u8bed\u8a00\u6807\u8bb0\u5c5e\u6027\u5bf9\u8c61", hideempty=true)
    public IPSDEField getTitleLanResTagPSDEField() {
        return this.getPSDEDataSetViewMsg().getTitleLanResTagPSDEField();
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u7c7b\u578b\u5c5e\u6027\u5bf9\u8c61", hideempty=true)
    public IPSDEField getMsgTypePSDEField() {
        return this.getPSDEDataSetViewMsg().getMsgTypePSDEField();
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u4f4d\u7f6e\u5c5e\u6027\u5bf9\u8c61", hideempty=true)
    public IPSDEField getMsgPosPSDEField() {
        return this.getPSDEDataSetViewMsg().getMsgPosPSDEField();
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u9664\u6807\u5fd7\u5c5e\u6027\u5bf9\u8c61", hideempty=true)
    public IPSDEField getRemoveFlagPSDEField() {
        return this.getPSDEDataSetViewMsg().getRemoveFlagPSDEField();
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u5c5e\u6027\u5bf9\u8c61", hideempty=true)
    public IPSDEField getContentPSDEField() {
        return this.getPSDEDataSetViewMsg().getContentPSDEField();
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u7c7b\u578b\u5c5e\u6027\u5bf9\u8c61", hideempty=true)
    public IPSDEField getContentTypePSDEField() {
        return this.getPSDEDataSetViewMsg().getContentTypePSDEField();
    }

    @PSModelRTMeta(description="\u5185\u5bb9\u5c5e\u6027", hideempty=true, dump=false)
    public String getContentField() {
        return this.getPSDEDataSetViewMsg().getContentField();
    }

    public String getActiveDataDELogicId() {
        return this.getPSDEDataSetViewMsg().getActiveDataDELogicId();
    }

    @PSModelRTMeta(description="\u6392\u5e8f\u503c\u5c5e\u6027", hideempty=true, dump=false)
    public String getOrderValueField() {
        return this.getPSDEDataSetViewMsg().getOrderValueField();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u7f13\u5b58")
    public boolean isEnableCache() {
        return this.getPSDEDataSetViewMsg().isEnableCache();
    }

    @Override
    @PSModelRTMeta(description="\u7f13\u5b58\u8303\u56f4", codelist="ViewMsgCacheScope")
    public String getCacheScope() {
        return this.getPSDEDataSetViewMsg().getCacheScope();
    }

    @Override
    @PSModelRTMeta(description="\u7f13\u5b58\u8d85\u65f6")
    public int getCacheTimeout() {
        return this.getPSDEDataSetViewMsg().getCacheTimeout();
    }

    @PSModelRTMeta(description="\u7f13\u5b58\u6807\u8bb0\u5c5e\u6027", hideempty=true, dump=false)
    public String getCacheTagField() {
        return this.getPSDEDataSetViewMsg().getCacheTagField();
    }

    @PSModelRTMeta(description="\u7f13\u5b58\u6807\u8bb02\u5c5e\u6027", hideempty=true, dump=false)
    public String getCacheTag2Field() {
        return this.getPSDEDataSetViewMsg().getCacheTag2Field();
    }

    @Override
    public boolean getDefaultFlag() {
        return this.getPSDEDataSetViewMsg().getDefaultFlag();
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c\u5c5e\u6027\u5bf9\u8c61", hideempty=true)
    public IPSDEField getOrderValuePSDEField() {
        return this.getPSDEDataSetViewMsg().getOrderValuePSDEField();
    }

    @Override
    @PSModelRTMeta(description="\u4e0a\u4e0b\u6587\u6570\u636e\u8f6c\u5316\u903b\u8f91", hideempty=true)
    public IPSDELogic getActiveDataPSDELogic() {
        return this.getPSDEDataSetViewMsg().getActiveDataPSDELogic();
    }

    @Override
    @PSModelRTMeta(description="\u7f13\u5b58\u6807\u8bb0\u5c5e\u6027\u5bf9\u8c61", hideempty=true)
    public IPSDEField getCacheTagPSDEField() {
        return this.getPSDEDataSetViewMsg().getCacheTagPSDEField();
    }

    @Override
    @PSModelRTMeta(description="\u7f13\u5b58\u6807\u8bb02\u5c5e\u6027\u5bf9\u8c61", hideempty=true)
    public IPSDEField getCacheTag2PSDEField() {
        return this.getPSDEDataSetViewMsg().getCacheTag2PSDEField();
    }

    @PSModelRTMeta(description="\u6570\u636e\u6e90", codelist="SysDeployDBMode", dump=false)
    public String getDSLink() {
        return this.getPSDEDataSetViewMsg().getDSLink();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", hideempty=true, dumpref=true)
    public IPSAppDataEntity getPSAppDataEntity() {
        return this.iPSAppDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u96c6\u5408\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSAppDataEntity")
    public IPSAppDEDataSet getPSAppDEDataSet() {
        return this.iPSAppDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u62ac\u5934\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSAppDataEntity")
    public IPSAppDEField getTitlePSAppDEField() {
        return this.titlePSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u62ac\u5934\u8bed\u8a00\u6807\u8bb0\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSAppDataEntity")
    public IPSAppDEField getTitleLanResTagPSAppDEField() {
        return this.titleLanResTagPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u7c7b\u578b\u6807\u8bb0\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSAppDataEntity")
    public IPSAppDEField getMsgTypePSAppDEField() {
        return this.msgTypePSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u4f4d\u7f6e\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSAppDataEntity")
    public IPSAppDEField getMsgPosPSAppDEField() {
        return this.msgPosPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u9664\u6807\u5fd7\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSAppDataEntity")
    public IPSAppDEField getRemoveFlagPSAppDEField() {
        return this.removeFlagPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u5185\u5bb9\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSAppDataEntity")
    public IPSAppDEField getContentPSAppDEField() {
        return this.contentPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u7c7b\u578b\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSAppDataEntity")
    public IPSAppDEField getContentTypePSAppDEField() {
        return this.contentTypePSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u6b21\u5e8f\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSAppDataEntity")
    public IPSAppDEField getOrderValuePSAppDEField() {
        return this.orderValuePSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u7f13\u5b58\u6807\u8bb0\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSAppDataEntity")
    public IPSAppDEField getCacheTagPSAppDEField() {
        return this.cacheTagPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u7f13\u5b58\u6807\u8bb02\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSAppDataEntity")
    public IPSAppDEField getCacheTag2PSAppDEField() {
        return this.cacheTag2PSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u7c7b\u578b")
    public String getContentType() {
        return this.getPSDEDataSetViewMsg().getContentType();
    }
}

