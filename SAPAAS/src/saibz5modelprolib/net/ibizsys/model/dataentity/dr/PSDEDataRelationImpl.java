/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.dr.IPSDEDRDetail
 *  net.ibizsys.model.dataentity.dr.IPSDEDataRelation
 *  net.ibizsys.model.res.IPSLanguageRes
 *  net.ibizsys.model.res.IPSSysImage
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.dr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.PSDataEntityObjectImpl;
import net.ibizsys.model.dataentity.dr.IPSDEDRDetail;
import net.ibizsys.model.dataentity.dr.IPSDEDataRelation;
import net.ibizsys.model.dataentity.dr.PSDEDRDetailImpl;
import net.ibizsys.model.entity.PSDEDRDetail;
import net.ibizsys.model.entity.PSDEDataRelation;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataRelationImpl
extends PSDataEntityObjectImpl
implements IPSDEDataRelation {
    private static final Log log = LogFactory.getLog(PSDEDataRelationImpl.class);
    protected PSDEDataRelation psDEDataRelation;
    protected ArrayList<IPSDEDRDetail> psDEDRDetailList = new ArrayList();
    private boolean bHideEditItem = false;
    private String strFormCaption = null;
    private IPSLanguageRes formCapPSLanguageRes = null;
    private IPSSysImage formPSSysImage = null;

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDataEntity iPSDataEntity, PSDEDataRelation psDEDataRelation) throws Exception {
        try {
            this.setPSDataEntity(iPSDataEntity);
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.psDEDataRelation = psDEDataRelation;
            this.setId(psDEDataRelation.getPSDEDATARELATIONID());
            this.setName(psDEDataRelation.getPSDEDATARELATIONNAME());
            this.setPSObjectData(this.psDEDataRelation);
            if (!this.psDEDataRelation.isHIDEEDITITEMNull()) {
                this.bHideEditItem = this.psDEDataRelation.getHIDEEDITITEM();
            }
            this.strFormCaption = this.psDEDataRelation.getFORMCAPTION();
            if (StringHelper.isNullOrEmpty((String)this.strFormCaption)) {
                this.strFormCaption = this.getPSDataEntity().getLogicName();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEDataRelation.getFORMCAPPSLANRESID())) {
                this.formCapPSLanguageRes = this.getPSSystem().getPSLanguageRes(this.psDEDataRelation.getFORMCAPPSLANRESID());
            }
            this.formPSSysImage = !StringHelper.isNullOrEmpty((String)this.psDEDataRelation.getFORMPSSYSIMAGEID()) ? this.getPSSystem().getPSSysImage(this.psDEDataRelation.getFORMPSSYSIMAGEID()) : this.getPSDataEntity().getPSSysImage();
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
        super.onInit();
        this.onPreparePSDEDRDetails();
    }

    protected void onPreparePSDEDRDetails() throws Exception {
        this.psDEDRDetailList.clear();
        Vector<PSDEDRDetail> psDEDRDetailList = new Vector<PSDEDRDetail>();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEDRDetails(this.getId(), psDEDRDetailList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5b9e\u4f53\u6570\u636e\u5173\u7cfb\u9879\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEDRDetail psDEDRDetail : psDEDRDetailList) {
            if (psDEDRDetail.getORDERVALUE() < 0 || !psDEDRDetail.isVALIDFLAGNull() && !psDEDRDetail.getVALIDFLAG()) continue;
            PSDEDRDetailImpl iPSDEDRDetail = new PSDEDRDetailImpl();
            iPSDEDRDetail.init(this.getPSModelStorageContext(), this, psDEDRDetail);
            this.psDEDRDetailList.add(iPSDEDRDetail);
        }
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u5173\u7cfb\u7ec4\u6210\u5458\u96c6\u5408")
    public Iterator<IPSDEDRDetail> getPSDEDRDetails() {
        return this.psDEDRDetailList.iterator();
    }

    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f0")
    public String getCodeName() {
        return this.psDEDataRelation.getCODENAME();
    }

    public String getPSSysCounterId() {
        return this.psDEDataRelation.getPSSYSCOUNTERID();
    }

    public String getFormPSDEViewBaseId() {
        return this.psDEDataRelation.getFORMPSDEVIEWBASEID();
    }

    @PSModelRTMeta(description="\u9ed8\u8ba4\u9690\u85cf\u7f16\u8f91\u9879")
    public boolean isHideEditItem() {
        return this.bHideEditItem;
    }

    @PSModelRTMeta(description="\u7f16\u8f91\u9879\u6807\u9898")
    public String getFormCaption() {
        return this.strFormCaption;
    }

    @PSModelRTMeta(description="\u7f16\u8f91\u9879\u6807\u9898\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getFormCapPSLanguageRes() {
        return this.formCapPSLanguageRes;
    }

    @PSModelRTMeta(description="\u7f16\u8f91\u9879\u56fe\u6807\u8d44\u6e90")
    public IPSSysImage getFormPSSysImage() {
        return this.formPSSysImage;
    }
}

