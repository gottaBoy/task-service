package SA.SRFDA.PS.Core.Service;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERCustom;
import SA.SRFDA.PS.Data.PSSubSysSADERS;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSubSysServiceAPIDERSGlobalModel extends PSSubSysServiceAPIGlobalModelBase<String, PSSubSysSADERS, IPSSubSysServiceAPIDERS> {
   private static final Log log = LogFactory.getLog(PSSubSysServiceAPIDERSGlobalModel.class);

   protected PSSubSysSADERS GetObject(String strPSSubSysSADERSId) {
      if (this.isPrepareModels()) {
         return null;
      }

      log.warn(StringHelper.Format("不支持指定获取外部服务接口实体关系[%1$s]", strPSSubSysSADERSId));
      return null;
   }

   protected Boolean TestObjectRenew(PSSubSysSADERS obj) {
      return false;
   }

   protected String getObjectId(PSSubSysSADERS vt) {
      return vt.getPSSUBSYSSADERSID();
   }

   protected IPSSubSysServiceAPIDERS OnCreateModelHelper(PSSubSysSADERS vt, String strPSSubSysSADERSId) throws Exception {
      if (StringHelper.Compare(strPSSubSysSADERSId, vt.getPSSUBSYSSADERSID(), false) == 0) {
         IPSSubSysServiceAPIDERS iPSSubSysServiceAPIDERS = new PSSubSysServiceAPIDERSImpl();
         iPSSubSysServiceAPIDERS.init(this.iDAGlobalHelper, this.getPSSubSysServiceAPI(), vt);
         return iPSSubSysServiceAPIDERS;
      } else {
         return this.FindModelHelper(vt.getPSSUBSYSSADERSID());
      }
   }

   protected IPSSubSysServiceAPIDERS registerModel(PSSubSysSADERS vt) throws Exception {
      IPSSubSysServiceAPIDERS iPSSubSysSADERS = this.InternalGetModelHelper(vt.getPSSUBSYSSADERSID());
      if (iPSSubSysSADERS != null) {
         return iPSSubSysSADERS;
      }

      this.setModel(vt.getPSSUBSYSSADERSID(), vt, null);
      return this.FindModelHelper(vt.getPSSUBSYSSADERSID());
   }

   @Override
   protected Vector<PSSubSysSADERS> getAllModels() throws Exception {
      Vector<PSSubSysSADERS> list = new Vector<>();
      CallResult callResult = this.iPSModelHelper.getPSSubSysSADERSs(this.getPSSubSysServiceAPI().getId(), list);
      if (callResult.isError()) {
         throw new Exception(StringHelper.Format("查询外部服务接口全部接口实体关系发生错误, %1$s", callResult.getErrorInfo()));
      }

      if (this.getPSSubSysServiceAPI().isFromDEModel()) {
         Iterator<IPSSubSysServiceAPIDE> psSubSysServiceAPIDEs = this.getPSSubSysServiceAPI().getAllPSSubSysServiceAPIDEs();
         if (psSubSysServiceAPIDEs != null) {
            Map<String, PSSubSysSADERS> psSubSysSADERSMap = new HashMap<>();

            for (PSSubSysSADERS psSubSysSADERS : list) {
               psSubSysSADERSMap.put(String.format("%1$s|%2$s", psSubSysSADERS.getPPSSUBSYSSADEID(), psSubSysSADERS.getCPSSUBSYSSADEID()), psSubSysSADERS);
            }

            Map<String, IPSDataEntity> psDataEntityMap = new HashMap<>();

            while (psSubSysServiceAPIDEs.hasNext()) {
               IPSSubSysServiceAPIDE iPSSubSysServiceAPIDE = psSubSysServiceAPIDEs.next();
               if (iPSSubSysServiceAPIDE.isAutoModel()) {
                  IPSDataEntity iPSDataEntity = this.getPSSubSysServiceAPI().getPSSystem().getPSDataEntity2(iPSSubSysServiceAPIDE.getId(), true);
                  if (iPSDataEntity != null) {
                     psDataEntityMap.put(iPSSubSysServiceAPIDE.getId(), iPSDataEntity);
                  }
               }
            }

            for (IPSDataEntity iPSDataEntity : psDataEntityMap.values()) {
               Iterator<IPSDERBase> psDERBases = iPSDataEntity.getMajorPSDERs();
               if (psDERBases != null) {
                  while (psDERBases.hasNext()) {
                     IPSDERBase iPSDERBase = psDERBases.next();
                     IPSDataEntity minorPSDataEntity = psDataEntityMap.get(iPSDERBase.getMinorDEId());
                     if (minorPSDataEntity != null) {
                        if ("DER1N".equals(iPSDERBase.getDERType())) {
                           IPSDER1N iPSDER1N = (IPSDER1N)iPSDERBase;
                           if ((iPSDER1N.getMasterRS() & 1) == 1) {
                              PSSubSysSADERS psSubSysSADERS = new PSSubSysSADERS();
                              String strTag = String.format("%1$s__%2$s", iPSDataEntity.getName(), minorPSDataEntity.getName());
                              psSubSysSADERS.setPSSUBSYSSADERSNAME(strTag);
                              psSubSysSADERS.setPSSUBSYSSADERSID(strTag);
                              psSubSysSADERS.setPPSSUBSYSSADEID(iPSDataEntity.getId());
                              psSubSysSADERS.setPPSSUBSYSSADENAME(iPSDataEntity.getName());
                              psSubSysSADERS.setCPSSUBSYSSADEID(minorPSDataEntity.getId());
                              psSubSysSADERS.setCPSSUBSYSSADENAME(minorPSDataEntity.getName());
                              psSubSysSADERS.setCODENAME(iPSDER1N.getMinorServiceCodeName());
                              psSubSysSADERS.setCHILDFILTER(iPSDER1N.getPSPickupDEField().getName());
                              psSubSysSADERS.set("AUTOMODEL", 1);
                              list.add(psSubSysSADERS);
                           }
                        } else if ("DERCUSTOM".equals(iPSDERBase.getDERType())) {
                           IPSDERCustom iPSDERCustom = (IPSDERCustom)iPSDERBase;
                           if ("DER1N".equals(iPSDERCustom.getDERSubType()) && (iPSDERCustom.getMasterRS() & 1) == 1) {
                              PSSubSysSADERS psSubSysSADERS = new PSSubSysSADERS();
                              String strTag = String.format("%1$s__%2$s", iPSDataEntity.getName(), minorPSDataEntity.getName());
                              psSubSysSADERS.setPSSUBSYSSADERSNAME(strTag);
                              psSubSysSADERS.setPSSUBSYSSADERSID(strTag);
                              psSubSysSADERS.setPPSSUBSYSSADEID(iPSDataEntity.getId());
                              psSubSysSADERS.setPPSSUBSYSSADENAME(iPSDataEntity.getName());
                              psSubSysSADERS.setCPSSUBSYSSADEID(minorPSDataEntity.getId());
                              psSubSysSADERS.setCPSSUBSYSSADENAME(minorPSDataEntity.getName());
                              psSubSysSADERS.setCODENAME(iPSDERCustom.getMinorServiceCodeName());
                              if (iPSDERCustom.getPickupPSDEField() != null) {
                                 psSubSysSADERS.setCHILDFILTER(iPSDERCustom.getPickupPSDEField().getName());
                              } else {
                                 psSubSysSADERS.setCHILDFILTER(iPSDERCustom.getPickupDEFName());
                              }

                              psSubSysSADERS.set("AUTOMODEL", 1);
                              list.add(psSubSysSADERS);
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      return list;
   }

   @Override
   protected void onPreloadModels() {
      super.onPreloadModels();

      try {
         this.getAllModelHelpers();
      } catch (Exception ex) {
         log.error(StringHelper.Format("获取外部服务接口全部实体关系发生异常，%1$s", ex.getMessage()), ex);
      }
   }
}
