/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.IPSModelObject
 *  net.ibizsys.pscore.srv.util.IPSRecursionWork
 *  net.ibizsys.pscore.srv.util.PSRecursionHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Service;

import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DEField.IPSDEFGroupDetail;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERCustom;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTOField;
import SA.SRFDA.PS.Core.DataEntity.Service.PSDEMethodDTOFieldImpl;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModelAttr;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Service.IPSSysMethodDTO;
import SA.SRFDA.PS.Core.Util.PSModelUtil;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.IPSModelObject;
import net.ibizsys.pscore.srv.util.IPSRecursionWork;
import net.ibizsys.pscore.srv.util.PSRecursionHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSDEMethodDTOImpl
extends PSDataEntityObjectImpl
implements IPSDEMethodDTO {
    private static final Log log = LogFactory.getLog(PSDEMethodDTOImpl.class);
    private IPSDEFGroup iPSDEFGroup = null;
    private IPSSysDynaModel srcPSSysDynaModel = null;
    private boolean bDefaultMode = false;
    private String strCodeName = null;
    private List<IPSDEMethodDTOField> psDEMethodDTOFieldList = null;
    private String strSourceType = null;
    private String strType = "DEFAULT";

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, IPSDEFGroup iPSDEFGroup) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDataEntity(iPSDataEntity);
            this.iPSDEFGroup = iPSDEFGroup;
            if (this.iPSDEFGroup == null) {
                this.setId(KeyValueHelper.genUniqueId((String)iPSDataEntity.getId(), (String)this.getType()));
                this.bDefaultMode = true;
            } else {
                this.setId(KeyValueHelper.genUniqueId((String)iPSDataEntity.getId(), (String)this.getType(), (String)iPSDEFGroup.getId()));
                this.setCodeName(iPSDEFGroup.getDTOCodeName());
            }
            if (StringHelper.isNullOrEmpty((String)this.getCodeName())) {
                this.setCodeName(this.calcCodeName());
            }
            this.setName(this.getCodeName());
            this.strSourceType = "DE";
            PSRecursionHelper.execute((IPSRecursionWork)new IPSRecursionWork<IPSDEMethodDTO>(){

                public IPSDEMethodDTO execute(Object obj) throws Exception {
                    PSDEMethodDTOImpl.this.onInit();
                    return null;
                }
            }, (IPSModelObject)this);
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

    public void initFromDynaModel(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, IPSSysDynaModel iPSSysDynaModel) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDataEntity(iPSDataEntity);
            this.srcPSSysDynaModel = iPSSysDynaModel;
            this.setId(KeyValueHelper.genUniqueId((String)iPSDataEntity.getId(), (String)this.getType(), (String)this.srcPSSysDynaModel.getId()));
            this.setCodeName(this.calcCodeName());
            this.setName(this.getCodeName());
            this.strSourceType = "DYNAMODEL";
            PSRecursionHelper.execute((IPSRecursionWork)new IPSRecursionWork<IPSDEMethodDTO>(){

                public IPSDEMethodDTO execute(Object obj) throws Exception {
                    PSDEMethodDTOImpl.this.onInit();
                    return null;
                }
            }, (IPSModelObject)this);
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
        this.preparePSDEMethodDTOFields();
    }

    protected void preparePSDEMethodDTOFields() throws Exception {
        Iterator<? extends IPSSysDynaModelAttr> psSysDynaModelAttrs;
        this.psDEMethodDTOFieldList = new ArrayList<IPSDEMethodDTOField>();
        LinkedHashMap<String, PSDEMethodDTOFieldImpl> psDEMethodDTOFieldMap = new LinkedHashMap<String, PSDEMethodDTOFieldImpl>();
        if (StringHelper.compare((String)this.getSourceType(), (String)"DE", (boolean)false) == 0) {
            LinkedHashMap<String, IPSDEField> ignorePSDEFieldMap = new LinkedHashMap<String, IPSDEField>();
            if (this.getPSDataEntity().getLogicValidPSDEField() != null) {
                ignorePSDEFieldMap.put(this.getPSDataEntity().getLogicValidPSDEField().getId(), this.getPSDataEntity().getLogicValidPSDEField());
            }
            if (this.getPSDEFGroup() != null) {
                Iterator<IPSDEFGroupDetail> psDEFGroupDetails = this.getPSDEFGroup().getPSDEFGroupDetails();
                if (psDEFGroupDetails != null) {
                    while (psDEFGroupDetails.hasNext()) {
                        IPSDEFGroupDetail iPSDEFGroupDetail = psDEFGroupDetails.next();
                        if (ignorePSDEFieldMap.containsKey(iPSDEFGroupDetail.getPSDEField().getId())) continue;
                        PSDEMethodDTOFieldImpl psDEMethodDTOFieldImpl = new PSDEMethodDTOFieldImpl();
                        psDEMethodDTOFieldImpl.init(this.getDAGlobalHelper(), this, iPSDEFGroupDetail);
                        if (psDEMethodDTOFieldMap.containsKey(psDEMethodDTOFieldImpl.getCodeName().toUpperCase())) {
                            throw new Exception(String.format("\u5b9e\u4f53\u5c5e\u6027\u7ec4\u6210\u5458[%1$s]\u6307\u5b9a\u4ee3\u7801\u6807\u8bc6[%2$s]\u5df2\u5b58\u5728", iPSDEFGroupDetail.getName(), psDEMethodDTOFieldImpl.getCodeName()));
                        }
                        psDEMethodDTOFieldMap.put(psDEMethodDTOFieldImpl.getCodeName().toUpperCase(), psDEMethodDTOFieldImpl);
                        if (psDEMethodDTOFieldImpl.getPSDER() != null) {
                            psDEMethodDTOFieldMap.put(psDEMethodDTOFieldImpl.getPSDER().getName(), psDEMethodDTOFieldImpl);
                        }
                        this.psDEMethodDTOFieldList.add(psDEMethodDTOFieldImpl);
                    }
                }
            } else {
                Iterator<IPSDEField> psDEFields = this.getPSDataEntity().getPSDEFields();
                while (psDEFields.hasNext()) {
                    IPSDEField iPSDEField = psDEFields.next();
                    if (ignorePSDEFieldMap.containsKey(iPSDEField.getId())) continue;
                    PSDEMethodDTOFieldImpl psDEMethodDTOFieldImpl = new PSDEMethodDTOFieldImpl();
                    psDEMethodDTOFieldImpl.init(this.getDAGlobalHelper(), this, iPSDEField);
                    if (psDEMethodDTOFieldMap.containsKey(psDEMethodDTOFieldImpl.getCodeName().toUpperCase())) {
                        throw new Exception(String.format("\u5b9e\u4f53\u5c5e\u6027[%1$s]\u6307\u5b9a\u4ee3\u7801\u6807\u8bc6[%2$s]\u5df2\u5b58\u5728", iPSDEField.getName(), psDEMethodDTOFieldImpl.getCodeName()));
                    }
                    psDEMethodDTOFieldMap.put(psDEMethodDTOFieldImpl.getCodeName().toUpperCase(), psDEMethodDTOFieldImpl);
                    if (psDEMethodDTOFieldImpl.getPSDER() != null) {
                        psDEMethodDTOFieldMap.put(psDEMethodDTOFieldImpl.getPSDER().getName(), psDEMethodDTOFieldImpl);
                    }
                    this.psDEMethodDTOFieldList.add(psDEMethodDTOFieldImpl);
                }
                Iterator<IPSDERBase> psDERBases = this.getPSDataEntity().getMajorPSDERs();
                if (psDERBases != null) {
                    while (psDERBases.hasNext()) {
                        IPSDER1N iPSDER1N;
                        PSDEMethodDTOFieldImpl psDEMethodDTOFieldImpl;
                        IPSDERBase iPSDERBase = psDERBases.next();
                        if (psDEMethodDTOFieldMap.containsKey(iPSDERBase.getName())) continue;
                        if (iPSDERBase instanceof IPSDERCustom) {
                            IPSDERCustom iPSDERCustom = (IPSDERCustom)iPSDERBase;
                            if (StringHelper.compare((String)iPSDERCustom.getDERSubType(), (String)"DER11", (boolean)false) != 0 && StringHelper.compare((String)iPSDERCustom.getDERSubType(), (String)"DER1N", (boolean)false) != 0 || (iPSDERCustom.getMasterRS() & 8) != 8 || StringHelper.isNullOrEmpty((String)iPSDERCustom.getMinorServiceCodeName())) continue;
                            psDEMethodDTOFieldImpl = new PSDEMethodDTOFieldImpl();
                            psDEMethodDTOFieldImpl.init(this.getDAGlobalHelper(), this, iPSDERCustom);
                            if (psDEMethodDTOFieldMap.containsKey(psDEMethodDTOFieldImpl.getCodeName().toUpperCase())) continue;
                            psDEMethodDTOFieldMap.put(psDEMethodDTOFieldImpl.getCodeName().toUpperCase(), psDEMethodDTOFieldImpl);
                            if (psDEMethodDTOFieldImpl.getPSDER() != null) {
                                psDEMethodDTOFieldMap.put(psDEMethodDTOFieldImpl.getPSDER().getName(), psDEMethodDTOFieldImpl);
                            }
                            this.psDEMethodDTOFieldList.add(psDEMethodDTOFieldImpl);
                            continue;
                        }
                        if (!(iPSDERBase instanceof IPSDER1N) || ((iPSDER1N = (IPSDER1N)iPSDERBase).getMasterRS() & 8) != 8 || StringHelper.isNullOrEmpty((String)iPSDER1N.getMinorServiceCodeName())) continue;
                        psDEMethodDTOFieldImpl = new PSDEMethodDTOFieldImpl();
                        psDEMethodDTOFieldImpl.init(this.getDAGlobalHelper(), this, iPSDER1N);
                        if (psDEMethodDTOFieldMap.containsKey(psDEMethodDTOFieldImpl.getCodeName().toUpperCase())) continue;
                        psDEMethodDTOFieldMap.put(psDEMethodDTOFieldImpl.getCodeName().toUpperCase(), psDEMethodDTOFieldImpl);
                        if (psDEMethodDTOFieldImpl.getPSDER() != null) {
                            psDEMethodDTOFieldMap.put(psDEMethodDTOFieldImpl.getPSDER().getName(), psDEMethodDTOFieldImpl);
                        }
                        this.psDEMethodDTOFieldList.add(psDEMethodDTOFieldImpl);
                    }
                }
            }
        } else if (StringHelper.compare((String)this.getSourceType(), (String)"DYNAMODEL", (boolean)false) == 0 && (psSysDynaModelAttrs = this.getSrcPSSysDynaModel().getPSSysDynaModelAttrs()) != null) {
            while (psSysDynaModelAttrs.hasNext()) {
                IPSSysDynaModelAttr iPSSysDynaModelAttr = psSysDynaModelAttrs.next();
                PSDEMethodDTOFieldImpl psDEMethodDTOFieldImpl = new PSDEMethodDTOFieldImpl();
                psDEMethodDTOFieldImpl.initFromDynaModelAttr(this.getDAGlobalHelper(), this, iPSSysDynaModelAttr);
                if (psDEMethodDTOFieldMap.containsKey(psDEMethodDTOFieldImpl.getCodeName().toUpperCase())) {
                    throw new Exception(String.format("\u52a8\u6001\u6a21\u578b\u5c5e\u6027[%1$s]\u6307\u5b9a\u4ee3\u7801\u6807\u8bc6[%2$s]\u5df2\u5b58\u5728", iPSSysDynaModelAttr.getName(), psDEMethodDTOFieldImpl.getCodeName()));
                }
                psDEMethodDTOFieldMap.put(psDEMethodDTOFieldImpl.getCodeName().toUpperCase(), psDEMethodDTOFieldImpl);
                if (psDEMethodDTOFieldImpl.getPSDER() != null) {
                    psDEMethodDTOFieldMap.put(psDEMethodDTOFieldImpl.getPSDER().getName(), psDEMethodDTOFieldImpl);
                }
                this.psDEMethodDTOFieldList.add(psDEMethodDTOFieldImpl);
            }
        }
        PSModelUtil.sort(this.psDEMethodDTOFieldList);
    }

    @Override
    protected int onCheck() throws Exception {
        this.getSrcPSSysMethodDTO();
        Iterator<? extends IPSDEMethodDTOField> psDEMethodDTOFields = this.getPSDEMethodDTOFields();
        if (psDEMethodDTOFields != null) {
            while (psDEMethodDTOFields.hasNext()) {
                IPSDEMethodDTOField iPSDEMethodDTOField = psDEMethodDTOFields.next();
                iPSDEMethodDTOField.check();
            }
        }
        return super.onCheck();
    }

    @Override
    public String getModelType() {
        return "PSDEMETHODDTO";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDataEntity().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDataEntity().getPSSystem());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDataEntity().getModelId(), (Object)super.getModelId());
    }

    @Override
    @PSModelRTMeta(description="DTO\u5c5e\u6027\u96c6\u5408", child=true, group="\u57fa\u672c", order=140)
    public Iterator<? extends IPSDEMethodDTOField> getPSDEMethodDTOFields() {
        if (this.psDEMethodDTOFieldList == null || this.psDEMethodDTOFieldList.size() == 0) {
            return null;
        }
        return this.psDEMethodDTOFieldList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u57df\u5bf9\u8c61", ignoredumpvalues="false")
    public boolean isDefaultMode() {
        return this.bDefaultMode;
    }

    @Override
    @PSModelRTMeta(description="\u76f8\u5173\u5c5e\u6027\u7ec4\u5bf9\u8c61")
    public IPSDEFGroup getPSDEFGroup() {
        return this.iPSDEFGroup;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6", dump=false)
    public String getCodeName() {
        return this.strCodeName;
    }

    protected void setCodeName(String strCodeName) {
        this.strCodeName = strCodeName;
    }

    @Override
    protected boolean onGetAutoModel() {
        return true;
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u65b9\u6cd5DTO\u5bf9\u8c61\u6765\u6e90\u7c7b\u578b", codelist="DEMethodDTOSourceType")
    public String getSourceType() {
        return this.strSourceType;
    }

    protected void setSourceType(String strSourceType) {
        this.strSourceType = strSourceType;
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u52a8\u6001\u6a21\u578b\u5bf9\u8c61", hideempty=true)
    public IPSSysDynaModel getSrcPSSysDynaModel() {
        return this.srcPSSysDynaModel;
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u52a8\u6001\u6a21\u578b\u7cfb\u7edfDTO", dumpref=true, from="IPSSystem")
    public IPSSysMethodDTO getSrcPSSysMethodDTO() throws Exception {
        if ("DYNAMODEL".equals(this.getSourceType()) && this.getSrcPSSysDynaModel() != null) {
            return this.getPSDataEntity().getPSSystem().getPSSysMethodDTO(this.getSrcPSSysDynaModel());
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7c7b\u578b", codelist="DEMethodDTOType", group="\u57fa\u672c", order=125)
    public String getType() {
        return this.strType;
    }

    protected void setType(String strType) {
        this.strType = strType;
    }

    protected String calcCodeName() throws Exception {
        return this.getPSDataEntity().getDEMethodDTOCodeName(this);
    }

    @Override
    protected boolean isExportModelCodeName() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u8bb0")
    public String getTag() {
        if (StringHelper.compare((String)this.getSourceType(), (String)"DE", (boolean)false) == 0 && this.getPSDEFGroup() != null) {
            return this.getPSDEFGroup().getGroupTag();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u8bb02")
    public String getTag2() {
        if (StringHelper.compare((String)this.getSourceType(), (String)"DE", (boolean)false) == 0 && this.getPSDEFGroup() != null) {
            return this.getPSDEFGroup().getGroupTag2();
        }
        return null;
    }
}

