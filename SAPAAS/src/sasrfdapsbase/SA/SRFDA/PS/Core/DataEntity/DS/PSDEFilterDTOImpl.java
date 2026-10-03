package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DEField.IPSDEFGroupDetail;
import SA.SRFDA.PS.Core.DEField.IPSDEFSearchMode;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTOField;
import SA.SRFDA.PS.Core.DataEntity.Service.PSDEMethodDTOImpl;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.Util.PSModelUtil;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.IPSRecursionWork;
import net.ibizsys.pscore.srv.util.PSRecursionHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFilterDTOImpl extends PSDEMethodDTOImpl implements IPSDEFilterDTO, IPSDEDataSetInputDTO {
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
            throw new Exception("没有传入实体数据集输入对象");
         }

         this.setType("DEDATASETINPUT");
         this.setSourceType("DEDATASETINPUT");
         this.setId(KeyValueHelper.genUniqueId(iPSDataEntity.getId(), this.getType(), iPSDEDataSetInput.getId()));
         this.setCodeName(this.calcCodeName());
         this.setName(this.getCodeName());
         PSRecursionHelper.execute(new IPSRecursionWork<IPSDEMethodDTO>() {
            public IPSDEMethodDTO execute(Object obj) throws Exception {
               PSDEFilterDTOImpl.this.onInit();
               return null;
            }
         }, this);
      } catch (Exception ex) {
         String strLogName = StringHelper.format("%1$s[%2$s]", PSModels.getModelName(this.getModelType()), this.getFullModelName());
         String strExInfo = StringHelper.format("初始化发生异常，%1$s", ex.getMessage());
         log.error(StringHelper.format("%1$s%2$s", strLogName, strExInfo), ex);
         if (this.getPSSystemUtil() != null) {
            this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
         }

         this.throwInitException(ex);
      }
   }

   @Override
   protected void preparePSDEMethodDTOFields() throws Exception {
      this.psDEFilterDTOFieldList = new ArrayList<>();
      Map<String, IPSDEFilterDTOField> psDEFilterDTOFieldMap = new LinkedHashMap<>();
      if (StringHelper.compare(this.getSourceType(), "DE", false) == 0) {
         Map<String, IPSDEField> ignorePSDEFieldMap = new LinkedHashMap<>();
         if (this.getPSDataEntity().getLogicValidPSDEField() != null) {
            ignorePSDEFieldMap.put(this.getPSDataEntity().getLogicValidPSDEField().getId(), this.getPSDataEntity().getLogicValidPSDEField());
         }

         Map<String, IPSDEField> psDEFieldMap = null;
         if (this.getPSDEFGroup() != null) {
            psDEFieldMap = new LinkedHashMap<>();
            Iterator<IPSDEFGroupDetail> psDEFGroupDetails = this.getPSDEFGroup().getPSDEFGroupDetails();
            if (psDEFGroupDetails != null) {
               while (psDEFGroupDetails.hasNext()) {
                  IPSDEFGroupDetail iPSDEFGroupDetail = psDEFGroupDetails.next();
                  psDEFieldMap.put(iPSDEFGroupDetail.getPSDEField().getName(), iPSDEFGroupDetail.getPSDEField());
               }
            }
         }

         Iterator<IPSDEField> psDEFields = this.getPSDataEntity().getPSDEFields();

         while (psDEFields.hasNext()) {
            IPSDEField iPSDEField = psDEFields.next();
            if (!ignorePSDEFieldMap.containsKey(iPSDEField.getId()) && (psDEFieldMap == null || psDEFieldMap.containsKey(iPSDEField.getName()))) {
               Iterator<IPSDEFSearchMode> psDEFSearchModes = iPSDEField.getAllPSDEFSearchModes();
               if (psDEFSearchModes != null) {
                  while (psDEFSearchModes.hasNext()) {
                     IPSDEFSearchMode iPSDEFSearchMode = psDEFSearchModes.next();
                     PSDEFilterDTOFieldImpl psDEFilterDTOFieldImpl = new PSDEFilterDTOFieldImpl();
                     psDEFilterDTOFieldImpl.init(this.getDAGlobalHelper(), this, iPSDEFSearchMode);
                     if (!psDEFilterDTOFieldMap.containsKey(psDEFilterDTOFieldImpl.getCodeName().toUpperCase())) {
                        psDEFilterDTOFieldMap.put(psDEFilterDTOFieldImpl.getCodeName().toUpperCase(), psDEFilterDTOFieldImpl);
                        this.psDEFilterDTOFieldList.add(psDEFilterDTOFieldImpl);
                     }
                  }
               }
            }
         }
      } else if (StringHelper.compare(this.getSourceType(), "DYNAMODEL", false) != 0
         && StringHelper.compare(this.getSourceType(), "DEDATASETINPUT", false) == 0) {
         Iterator<IPSDEDataSetParam> psDEDataSetParams = this.getPSDEDataSetInput().getPSDEDataSetParams();
         if (psDEDataSetParams != null) {
            while (psDEDataSetParams.hasNext()) {
               IPSDEDataSetParam iPSDEDataSetParam = psDEDataSetParams.next();
               PSDEFilterDTOFieldImpl psDEFilterDTOFieldImpl = new PSDEFilterDTOFieldImpl();
               psDEFilterDTOFieldImpl.init(this.getDAGlobalHelper(), this, iPSDEDataSetParam);
               if (!psDEFilterDTOFieldMap.containsKey(psDEFilterDTOFieldImpl.getCodeName().toUpperCase())) {
                  psDEFilterDTOFieldMap.put(psDEFilterDTOFieldImpl.getCodeName().toUpperCase(), psDEFilterDTOFieldImpl);
                  this.psDEFilterDTOFieldList.add(psDEFilterDTOFieldImpl);
               }
            }
         }
      }

      PSModelUtil.sort(this.psDEFilterDTOFieldList);
   }

   @Override
   public Iterator<? extends IPSDEMethodDTOField> getPSDEMethodDTOFields() {
      return this.getPSDEFilterDTOFields();
   }

   @PSModelRTMeta(description = "DTO对象属性集合", child = true, alias = "getPSDEMethodDTOFields", group = "基本", order = 140, rtname = "getDEFilterDTOFields")
   @Override
   public Iterator<? extends IPSDEFilterDTOField> getPSDEFilterDTOFields() {
      return this.psDEFilterDTOFieldList != null && this.psDEFilterDTOFieldList.size() != 0 ? this.psDEFilterDTOFieldList.iterator() : null;
   }

   @PSModelRTMeta(description = "实体数据集输入对象", hideempty = true)
   @Override
   public IPSDEDataSetInput getPSDEDataSetInput() {
      return this.iPSDEDataSetInput;
   }
}
