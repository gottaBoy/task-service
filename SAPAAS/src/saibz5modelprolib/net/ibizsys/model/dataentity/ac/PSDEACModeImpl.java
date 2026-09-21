/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.field.IPSDEField
 *  net.ibizsys.model.res.IPSLanguageRes
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.data.IDataItem
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.ac;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.data.PSDataItemImpl;
import net.ibizsys.model.data.PSDataItemParamImpl;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.PSDataEntityObjectImpl;
import net.ibizsys.model.dataentity.ac.IPSDEACModeRuntime;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.entity.PSDEACMode;
import net.ibizsys.model.entity.PSDEACModeItem;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEACModeImpl
extends PSDataEntityObjectImpl
implements IPSDEACModeRuntime {
    private static final Log log = LogFactory.getLog(PSDEACModeImpl.class);
    protected PSDEACMode psDEACMode = null;
    protected ArrayList<IDataItem> dataItemList = new ArrayList();
    private boolean bDefaultMode = false;
    protected String strCodeName = "";
    protected IPSDEField minorPSDEField = null;
    protected String strMinorSortDir = "";
    protected IPSDEField valuePSDEField = null;
    protected IPSDEField textPSDEField = null;
    private String strLogicName = "";
    private String strEmptyText = null;
    private IPSLanguageRes emptyTextPSLanguageRes = null;
    private int nExtendMode = 0;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDataEntity iPSDataEntity, PSDEACMode psDEACMode) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSDataEntity(iPSDataEntity);
            this.psDEACMode = psDEACMode;
            this.setId(this.psDEACMode.getPSDEACMODEID());
            this.setName(this.psDEACMode.getPSDEACMODENAME());
            this.setPSObjectData(this.psDEACMode);
            if (!this.psDEACMode.isDEFAULTMODENull()) {
                this.bDefaultMode = this.psDEACMode.getDEFAULTMODE();
            }
            this.valuePSDEField = !StringHelper.isNullOrEmpty((String)this.psDEACMode.getVALUEPSDEFID()) ? this.getPSDataEntity().getPSDEField(this.psDEACMode.getVALUEPSDEFID()) : this.getPSDataEntity().getKeyPSDEField();
            this.textPSDEField = !StringHelper.isNullOrEmpty((String)this.psDEACMode.getTEXTPSDEFID()) ? this.getPSDataEntity().getPSDEField(this.psDEACMode.getTEXTPSDEFID()) : this.getPSDataEntity().getMajorPSDEField();
            this.strCodeName = this.psDEACMode.getCODENAME();
            if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.psDEACMode.getPSDEACMODENAME().toLowerCase();
            }
            if (!StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                String strHeader = this.strCodeName.substring(0, 1).toUpperCase();
                this.strCodeName = String.valueOf(strHeader) + this.strCodeName.substring(1);
            }
            this.strLogicName = this.psDEACMode.getLOGICNAME();
            if (StringHelper.isNullOrEmpty((String)this.strLogicName)) {
                this.strLogicName = this.getName();
            }
            this.strEmptyText = this.psDEACMode.getEMPTYTEXT();
            if (!StringHelper.isNullOrEmpty((String)this.psDEACMode.getEMPTYTEXTPSLANRESID())) {
                this.emptyTextPSLanguageRes = this.getPSDataEntity().getPSSystem().getPSLanguageRes(this.psDEACMode.getEMPTYTEXTPSLANRESID());
            }
            if (!this.psDEACMode.isEXTENDMODENull()) {
                this.nExtendMode = this.psDEACMode.getEXTENDMODE();
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @Override
    protected void onInit() throws Exception {
        PSDataItemParamImpl psItemParamImpl;
        PSDataItemImpl psDataItemImpl;
        String strMinorSortPSDEFName = this.psDEACMode.getMINORSORTPSDEFNAME();
        if (!StringHelper.isNullOrEmpty((String)strMinorSortPSDEFName)) {
            this.minorPSDEField = this.getPSDataEntity().getPSDEField(strMinorSortPSDEFName);
            this.strMinorSortDir = this.psDEACMode.getMINORSORTDIR();
            if (StringHelper.isNullOrEmpty((String)this.strMinorSortDir)) {
                this.strMinorSortDir = "ASC";
            }
        }
        super.onInit();
        if (this.getValuePSDEF() != null) {
            psDataItemImpl = new PSDataItemImpl();
            psDataItemImpl.setName("value");
            psDataItemImpl.setFormat("%1$s");
            if (this.getPSSystemSetting() != null) {
                psDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
            }
            psItemParamImpl = new PSDataItemParamImpl();
            psItemParamImpl.setName(this.getValuePSDEF().getName());
            psDataItemImpl.addDataItemParam(psItemParamImpl);
            this.dataItemList.add(psDataItemImpl);
        }
        if (this.getTextPSDEF() != null) {
            psDataItemImpl = new PSDataItemImpl();
            psDataItemImpl.setName("text");
            psDataItemImpl.setFormat("%1$s");
            if (this.getPSSystemSetting() != null) {
                psDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
            }
            psItemParamImpl = new PSDataItemParamImpl();
            psItemParamImpl.setName(this.getTextPSDEF().getName());
            psDataItemImpl.addDataItemParam(psItemParamImpl);
            this.dataItemList.add(psDataItemImpl);
        }
        Vector<PSDEACModeItem> psDEACModeItemList = new Vector<PSDEACModeItem>();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEACModeItems(this.getId(), psDEACModeItemList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5b9e\u4f53\u81ea\u586b\u6570\u636e\u9879\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEACModeItem psDEACModeItem : psDEACModeItemList) {
            if (StringHelper.compare((String)psDEACModeItem.getPSDEACMODEITEMNAME(), (String)"value", (boolean)true) == 0 || StringHelper.compare((String)psDEACModeItem.getPSDEACMODEITEMNAME(), (String)"text", (boolean)true) == 0) continue;
            PSDataItemImpl psDataItemImpl2 = new PSDataItemImpl();
            psDataItemImpl2.setName(psDEACModeItem.getPSDEACMODEITEMNAME().toLowerCase());
            psDataItemImpl2.setFormat("%1$s");
            if (this.getPSSystemSetting() != null) {
                psDataItemImpl2.setFormat(this.getPSSystemSetting().getValueFormat());
            }
            IPSDEField iPSDEField = this.getPSDataEntity().getPSDEField(psDEACModeItem.getPSDEFID(), true);
            PSDataItemParamImpl psItemParamImpl2 = new PSDataItemParamImpl();
            psItemParamImpl2.setName(psDEACModeItem.getPSDEFNAME());
            if (!psDEACModeItem.isCLCONVERTFLAGNull() && psDEACModeItem.getCLCONVERTFLAG()) {
                String strPSCodeListId = psDEACModeItem.getPSCODELISTID();
                if (StringHelper.isNullOrEmpty((String)strPSCodeListId) && iPSDEField != null && iPSDEField.getPSCodeList() != null) {
                    strPSCodeListId = iPSDEField.getPSCodeList().getId();
                }
                psItemParamImpl2.setCodeListId(strPSCodeListId);
            }
            if (StringHelper.isNullOrEmpty((String)psItemParamImpl2.getCodeListId())) {
                if (!StringHelper.isNullOrEmpty((String)psDEACModeItem.getVALUEFORMAT())) {
                    psItemParamImpl2.setFormat(psDEACModeItem.getVALUEFORMAT());
                } else if (iPSDEField != null) {
                    psItemParamImpl2.setFormat(iPSDEField.getValueFormat());
                }
            }
            psDataItemImpl2.addDataItemParam(psItemParamImpl2);
            this.dataItemList.add(psDataItemImpl2);
        }
    }

    public Iterator<IDataItem> getDataItems() {
        if (this.dataItemList == null || this.dataItemList.size() == 0) {
            return null;
        }
        return this.dataItemList.iterator();
    }

    @PSModelRTMeta(description="\u662f\u5426\u4e3a\u9ed8\u8ba4\u6a21\u5f0f")
    public boolean isDefaultMode() {
        return this.bDefaultMode;
    }

    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f0")
    public String getCodeName() {
        return this.strCodeName;
    }

    @PSModelRTMeta(description="\u652f\u6301\u5206\u9875\u680f")
    public boolean isEnablePagingBar() {
        if (this.psDEACMode.isENABLEPAGINGBARNull()) {
            return false;
        }
        return this.psDEACMode.getENABLEPAGINGBAR();
    }

    @PSModelRTMeta(description="\u5206\u9875\u5927\u5c0f")
    public int getPagingSize() {
        if (this.psDEACMode.isPAGINGSIZENull() || this.psDEACMode.getPAGINGSIZE() <= 0) {
            return 50;
        }
        return this.psDEACMode.getPAGINGSIZE();
    }

    @PSModelRTMeta(description="\u9644\u52a0\u6392\u5e8f\u5c5e\u6027")
    public IPSDEField getMinorSortPSDEF() {
        return this.minorPSDEField;
    }

    @PSModelRTMeta(description="\u9644\u52a0\u6392\u5e8f\u65b9\u5411")
    public String getMinorSortDir() {
        return this.strMinorSortDir;
    }

    public String getMinorSortField() {
        if (this.getMinorSortPSDEF() != null) {
            return this.getMinorSortPSDEF().getName();
        }
        return null;
    }

    @PSModelRTMeta(description="\u503c\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getValuePSDEF() {
        return this.valuePSDEField;
    }

    @PSModelRTMeta(description="\u6587\u672c\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getTextPSDEF() {
        return this.textPSDEField;
    }

    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0")
    public String getLogicName() {
        return this.strLogicName;
    }

    public void init(IDataEntity iDataEntity) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @PSModelRTMeta(description="\u65e0\u503c\u663e\u793a\u5185\u5bb9\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getEmptyTextPSLanguageRes() {
        return this.emptyTextPSLanguageRes;
    }

    @PSModelRTMeta(description="\u65e0\u503c\u663e\u793a\u5185\u5bb9")
    public String getEmptyText() {
        return this.strEmptyText;
    }

    @Override
    public int getExtendMode() {
        return this.nExtendMode;
    }
}

