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
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetInput;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetInputDTO;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEFilterDTO;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEFilterDTOField;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEFilterDTOFieldImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTOField;
import SA.SRFDA.PS.Core.DataEntity.Service.PSDEMethodDTOImpl;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
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

public class PSDEFilterDTOImpl
extends PSDEMethodDTOImpl
implements IPSDEFilterDTO,
IPSDEDataSetInputDTO {
    private static final Log log = LogFactory.getLog(PSDEFilterDTOImpl.class);
    private List<IPSDEFilterDTOField> psDEFilterDTOFieldList = null;
    private IPSDEDataSetInput iPSDEDataSetInput = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, IPSDEFGroup iPSDEFGroup) throws Exception {
        this.setType("DEFILTER");
        super.init(iDAGlobalHelper, iPSDataEntity, iPSDEFGroup);
    }

    @Override
    public void initFromDynaModel(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, IPSSysDynaModel iPSSysDynaModel) throws Exception {
        this.setType("DEFILTER");
        super.initFromDynaModel(iDAGlobalHelper, iPSDataEntity, iPSSysDynaModel);
    }

    public void initFromDataSetInput(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, IPSDEDataSetInput iPSDEDataSetInput) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDataEntity(iPSDataEntity);
            this.iPSDEDataSetInput = iPSDEDataSetInput;
            if (this.getPSDEDataSetInput() == null) {
                throw new Exception("\u6ca1\u6709\u4f20\u5165\u5b9e\u4f53\u6570\u636e\u96c6\u8f93\u5165\u5bf9\u8c61");
            }
            this.setType("DEDATASETINPUT");
            this.setSourceType("DEDATASETINPUT");
            this.setId(KeyValueHelper.genUniqueId((String)iPSDataEntity.getId(), (String)this.getType(), (String)iPSDEDataSetInput.getId()));
            this.setCodeName(this.calcCodeName());
            this.setName(this.getCodeName());
            PSRecursionHelper.execute((IPSRecursionWork)new IPSRecursionWork<IPSDEMethodDTO>(){

                public IPSDEMethodDTO execute(Object obj) throws Exception {
                    PSDEFilterDTOImpl.this.onInit();
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

    /*
     * Unable to fully structure code
     */
    @Override
    protected void preparePSDEMethodDTOFields() throws Exception {
        block9: {
            block8: {
                this.psDEFilterDTOFieldList = new ArrayList<IPSDEFilterDTOField>();
                psDEFilterDTOFieldMap = new LinkedHashMap<String, PSDEFilterDTOFieldImpl>();
                if (StringHelper.compare((String)this.getSourceType(), (String)"DE", (boolean)false) != 0) break block8;
                ignorePSDEFieldMap = new LinkedHashMap<String, IPSDEField>();
                if (this.getPSDataEntity().getLogicValidPSDEField() != null) {
                    ignorePSDEFieldMap.put(this.getPSDataEntity().getLogicValidPSDEField().getId(), this.getPSDataEntity().getLogicValidPSDEField());
                }
                psDEFieldMap = null;
                if (this.getPSDEFGroup() != null) {
                    psDEFieldMap = new LinkedHashMap<String, IPSDEField>();
                    psDEFGroupDetails = this.getPSDEFGroup().getPSDEFGroupDetails();
                    if (psDEFGroupDetails != null) {
                        while (psDEFGroupDetails.hasNext()) {
                            iPSDEFGroupDetail = psDEFGroupDetails.next();
                            psDEFieldMap.put(iPSDEFGroupDetail.getPSDEField().getName(), iPSDEFGroupDetail.getPSDEField());
                        }
                    }
                }
                psDEFields = this.getPSDataEntity().getPSDEFields();
                while (psDEFields.hasNext()) {
                    iPSDEField = psDEFields.next();
                    if (!ignorePSDEFieldMap.containsKey(iPSDEField.getId()) && (psDEFieldMap == null || psDEFieldMap.containsKey(iPSDEField.getName())) && (psDEFSearchModes = iPSDEField.getAllPSDEFSearchModes()) != null) ** GOTO lbl31
                    continue;
lbl-1000:
                    // 1 sources

                    {
                        iPSDEFSearchMode = psDEFSearchModes.next();
                        psDEFilterDTOFieldImpl = new PSDEFilterDTOFieldImpl();
                        psDEFilterDTOFieldImpl.init(this.getDAGlobalHelper(), (IPSDEFilterDTO)this, iPSDEFSearchMode);
                        if (psDEFilterDTOFieldMap.containsKey(psDEFilterDTOFieldImpl.getCodeName().toUpperCase())) continue;
                        psDEFilterDTOFieldMap.put(psDEFilterDTOFieldImpl.getCodeName().toUpperCase(), psDEFilterDTOFieldImpl);
                        this.psDEFilterDTOFieldList.add(psDEFilterDTOFieldImpl);
lbl31:
                        // 3 sources

                        ** while (psDEFSearchModes.hasNext())
                    }
lbl32:
                    // 1 sources

                }
                break block9;
            }
            if (StringHelper.compare((String)this.getSourceType(), (String)"DYNAMODEL", (boolean)false) != 0 && StringHelper.compare((String)this.getSourceType(), (String)"DEDATASETINPUT", (boolean)false) == 0 && (psDEDataSetParams = this.getPSDEDataSetInput().getPSDEDataSetParams()) != null) {
                while (psDEDataSetParams.hasNext()) {
                    iPSDEDataSetParam = psDEDataSetParams.next();
                    psDEFilterDTOFieldImpl = new PSDEFilterDTOFieldImpl();
                    psDEFilterDTOFieldImpl.init(this.getDAGlobalHelper(), (IPSDEFilterDTO)this, iPSDEDataSetParam);
                    if (psDEFilterDTOFieldMap.containsKey(psDEFilterDTOFieldImpl.getCodeName().toUpperCase())) continue;
                    psDEFilterDTOFieldMap.put(psDEFilterDTOFieldImpl.getCodeName().toUpperCase(), psDEFilterDTOFieldImpl);
                    this.psDEFilterDTOFieldList.add(psDEFilterDTOFieldImpl);
                }
            }
        }
        PSModelUtil.sort(this.psDEFilterDTOFieldList);
    }

    @Override
    public Iterator<? extends IPSDEMethodDTOField> getPSDEMethodDTOFields() {
        return this.getPSDEFilterDTOFields();
    }

    @Override
    @PSModelRTMeta(description="DTO\u5bf9\u8c61\u5c5e\u6027\u96c6\u5408", child=true, alias="getPSDEMethodDTOFields", group="\u57fa\u672c", order=140, rtname="getDEFilterDTOFields")
    public Iterator<? extends IPSDEFilterDTOField> getPSDEFilterDTOFields() {
        if (this.psDEFilterDTOFieldList == null || this.psDEFilterDTOFieldList.size() == 0) {
            return null;
        }
        return this.psDEFilterDTOFieldList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u96c6\u8f93\u5165\u5bf9\u8c61", hideempty=true)
    public IPSDEDataSetInput getPSDEDataSetInput() {
        return this.iPSDEDataSetInput;
    }
}

