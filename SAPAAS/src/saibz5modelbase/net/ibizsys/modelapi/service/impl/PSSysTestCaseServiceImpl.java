/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.util.StringUtils
 */
package net.ibizsys.modelapi.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.ibizsys.modelapi.domain.PSAppView;
import net.ibizsys.modelapi.domain.PSDEAction;
import net.ibizsys.modelapi.domain.PSDEField;
import net.ibizsys.modelapi.domain.PSDELogic;
import net.ibizsys.modelapi.domain.PSDEServiceAPI;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.domain.PSSysTCAssert;
import net.ibizsys.modelapi.domain.PSSysTCInput;
import net.ibizsys.modelapi.domain.PSSysTestCase;
import net.ibizsys.modelapi.domain.PSSysTestPrj;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSAppViewDTO;
import net.ibizsys.modelapi.dto.PSDEActionDTO;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSDELogicDTO;
import net.ibizsys.modelapi.dto.PSDESADetailDTO;
import net.ibizsys.modelapi.dto.PSDEServiceAPIDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSSysSFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysSampleValueDTO;
import net.ibizsys.modelapi.dto.PSSysTCAssertDTO;
import net.ibizsys.modelapi.dto.PSSysTCInputDTO;
import net.ibizsys.modelapi.dto.PSSysTestCaseDTO;
import net.ibizsys.modelapi.dto.PSSysTestDataDTO;
import net.ibizsys.modelapi.dto.PSSysTestModuleDTO;
import net.ibizsys.modelapi.dto.PSSysTestPrjDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSSysTestCaseService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysTestCaseServiceImpl
extends PSModelServiceImplBase<PSSysTestCase, PSSysTestCaseDTO>
implements IPSSysTestCaseService {
    private static final Log log = LogFactory.getLog(PSSysTestCaseServiceImpl.class);

    @Override
    public List<PSSysTestCase> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysTestCase get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysTestCase> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSSysTestCase item : list) {
                String strTag = item.getSrfTag();
                if (!StringUtils.hasLength((String)strTag)) {
                    item.init();
                    strTag = this.getModelTag(item);
                }
                if (strKey.compareTo(strTag) != 0) continue;
                return item;
            }
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6a21\u578b\uff0c\u6807\u8bb0\u4e3a[%1$s]", strKey));
    }

    @Override
    public List<PSSysTestCaseDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSSysTestCase> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSSysTestCaseDTO> dtoList = new ArrayList<PSSysTestCaseDTO>();
            for (PSSysTestCase item : list) {
                PSSysTestCaseDTO dto = (PSSysTestCaseDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysTestCase> listByPSDEAction(PSDEAction parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysTestCase get(PSDEAction parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysTestCase> list = this.listByPSDEAction(parent);
        if (list != null) {
            for (PSSysTestCase item : list) {
                String strTag = item.getSrfTag();
                if (!StringUtils.hasLength((String)strTag)) {
                    item.init();
                    strTag = this.getModelTag(item);
                }
                if (strKey.compareTo(strTag) != 0) continue;
                return item;
            }
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6a21\u578b\uff0c\u6807\u8bb0\u4e3a[%1$s]", strKey));
    }

    @Override
    public List<PSSysTestCaseDTO> listDTOByPSDEAction(String strParentKey) throws Exception {
        PSDEAction psdeaction = (PSDEAction)PSModelServiceUtil.getInstance().getPSDEActionService().get(strParentKey);
        List<PSSysTestCase> list = this.listByPSDEAction(psdeaction);
        if (list != null) {
            ArrayList<PSSysTestCaseDTO> dtoList = new ArrayList<PSSysTestCaseDTO>();
            for (PSSysTestCase item : list) {
                PSSysTestCaseDTO dto = (PSSysTestCaseDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysTestCase> listByPSDELogic(PSDELogic parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysTestCase get(PSDELogic parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysTestCase> list = this.listByPSDELogic(parent);
        if (list != null) {
            for (PSSysTestCase item : list) {
                String strTag = item.getSrfTag();
                if (!StringUtils.hasLength((String)strTag)) {
                    item.init();
                    strTag = this.getModelTag(item);
                }
                if (strKey.compareTo(strTag) != 0) continue;
                return item;
            }
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6a21\u578b\uff0c\u6807\u8bb0\u4e3a[%1$s]", strKey));
    }

    @Override
    public List<PSSysTestCaseDTO> listDTOByPSDELogic(String strParentKey) throws Exception {
        PSDELogic psdelogic = (PSDELogic)PSModelServiceUtil.getInstance().getPSDELogicService().get(strParentKey);
        List<PSSysTestCase> list = this.listByPSDELogic(psdelogic);
        if (list != null) {
            ArrayList<PSSysTestCaseDTO> dtoList = new ArrayList<PSSysTestCaseDTO>();
            for (PSSysTestCase item : list) {
                PSSysTestCaseDTO dto = (PSSysTestCaseDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysTestCase> listByPSSysTestPrj(PSSysTestPrj parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysTestCase get(PSSysTestPrj parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysTestCase> list = this.listByPSSysTestPrj(parent);
        if (list != null) {
            for (PSSysTestCase item : list) {
                String strTag = item.getSrfTag();
                if (!StringUtils.hasLength((String)strTag)) {
                    item.init();
                    strTag = this.getModelTag(item);
                }
                if (strKey.compareTo(strTag) != 0) continue;
                return item;
            }
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6a21\u578b\uff0c\u6807\u8bb0\u4e3a[%1$s]", strKey));
    }

    @Override
    public List<PSSysTestCaseDTO> listDTOByPSSysTestPrj(String strParentKey) throws Exception {
        PSSysTestPrj pssystestprj = (PSSysTestPrj)PSModelServiceUtil.getInstance().getPSSysTestPrjService().get(strParentKey);
        List<PSSysTestCase> list = this.listByPSSysTestPrj(pssystestprj);
        if (list != null) {
            ArrayList<PSSysTestCaseDTO> dtoList = new ArrayList<PSSysTestCaseDTO>();
            for (PSSysTestCase item : list) {
                PSSysTestCaseDTO dto = (PSSysTestCaseDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysTestCase> listByPSAppView(PSAppView parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysTestCase get(PSAppView parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysTestCase> list = this.listByPSAppView(parent);
        if (list != null) {
            for (PSSysTestCase item : list) {
                String strTag = item.getSrfTag();
                if (!StringUtils.hasLength((String)strTag)) {
                    item.init();
                    strTag = this.getModelTag(item);
                }
                if (strKey.compareTo(strTag) != 0) continue;
                return item;
            }
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6a21\u578b\uff0c\u6807\u8bb0\u4e3a[%1$s]", strKey));
    }

    @Override
    public List<PSSysTestCaseDTO> listDTOByPSAppView(String strParentKey) throws Exception {
        PSAppView psappview = (PSAppView)PSModelServiceUtil.getInstance().getPSAppViewService().get(strParentKey);
        List<PSSysTestCase> list = this.listByPSAppView(psappview);
        if (list != null) {
            ArrayList<PSSysTestCaseDTO> dtoList = new ArrayList<PSSysTestCaseDTO>();
            for (PSSysTestCase item : list) {
                PSSysTestCaseDTO dto = (PSSysTestCaseDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysTestCase> listByPSDEField(PSDEField parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysTestCase get(PSDEField parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysTestCase> list = this.listByPSDEField(parent);
        if (list != null) {
            for (PSSysTestCase item : list) {
                String strTag = item.getSrfTag();
                if (!StringUtils.hasLength((String)strTag)) {
                    item.init();
                    strTag = this.getModelTag(item);
                }
                if (strKey.compareTo(strTag) != 0) continue;
                return item;
            }
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6a21\u578b\uff0c\u6807\u8bb0\u4e3a[%1$s]", strKey));
    }

    @Override
    public List<PSSysTestCaseDTO> listDTOByPSDEField(String strParentKey) throws Exception {
        PSDEField psdefield = (PSDEField)PSModelServiceUtil.getInstance().getPSDEFieldService().get(strParentKey);
        List<PSSysTestCase> list = this.listByPSDEField(psdefield);
        if (list != null) {
            ArrayList<PSSysTestCaseDTO> dtoList = new ArrayList<PSSysTestCaseDTO>();
            for (PSSysTestCase item : list) {
                PSSysTestCaseDTO dto = (PSSysTestCaseDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysTestCase> listByPSDEServiceAPI(PSDEServiceAPI parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysTestCase get(PSDEServiceAPI parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysTestCase> list = this.listByPSDEServiceAPI(parent);
        if (list != null) {
            for (PSSysTestCase item : list) {
                String strTag = item.getSrfTag();
                if (!StringUtils.hasLength((String)strTag)) {
                    item.init();
                    strTag = this.getModelTag(item);
                }
                if (strKey.compareTo(strTag) != 0) continue;
                return item;
            }
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6a21\u578b\uff0c\u6807\u8bb0\u4e3a[%1$s]", strKey));
    }

    @Override
    public List<PSSysTestCaseDTO> listDTOByPSDEServiceAPI(String strParentKey) throws Exception {
        PSDEServiceAPI psdeserviceapi = (PSDEServiceAPI)PSModelServiceUtil.getInstance().getPSDEServiceAPIService().get(strParentKey);
        List<PSSysTestCase> list = this.listByPSDEServiceAPI(psdeserviceapi);
        if (list != null) {
            ArrayList<PSSysTestCaseDTO> dtoList = new ArrayList<PSSysTestCaseDTO>();
            for (PSSysTestCase item : list) {
                PSSysTestCaseDTO dto = (PSSysTestCaseDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysTestCase> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysTestCase get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysTestCase> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSSysTestCase item : list) {
                String strTag = item.getSrfTag();
                if (!StringUtils.hasLength((String)strTag)) {
                    item.init();
                    strTag = this.getModelTag(item);
                }
                if (strKey.compareTo(strTag) != 0) continue;
                return item;
            }
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6a21\u578b\uff0c\u6807\u8bb0\u4e3a[%1$s]", strKey));
    }

    @Override
    public List<PSSysTestCaseDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSSysTestCase> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSSysTestCaseDTO> dtoList = new ArrayList<PSSysTestCaseDTO>();
            for (PSSysTestCase item : list) {
                PSSysTestCaseDTO dto = (PSSysTestCaseDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysTestCase> onListAll() throws Exception {
        List pssystems;
        List psdeserviceapis;
        List psdefields;
        List psappviews;
        List pssystestprjs;
        List psdelogics;
        List psdeactions;
        ArrayList<PSSysTestCase> list = new ArrayList<PSSysTestCase>();
        List psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll();
        if (psdataentities != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSSysTestCase> items = this.listByPSDataEntity(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((psdeactions = PSModelServiceUtil.getInstance().getPSDEActionService().listAll()) != null) {
            for (PSDEAction parent : psdeactions) {
                List<PSSysTestCase> items = this.listByPSDEAction(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((psdelogics = PSModelServiceUtil.getInstance().getPSDELogicService().listAll()) != null) {
            for (PSDELogic parent : psdelogics) {
                List<PSSysTestCase> items = this.listByPSDELogic(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pssystestprjs = PSModelServiceUtil.getInstance().getPSSysTestPrjService().listAll()) != null) {
            for (PSSysTestPrj parent : pssystestprjs) {
                List<PSSysTestCase> items = this.listByPSSysTestPrj(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((psappviews = PSModelServiceUtil.getInstance().getPSAppViewService().listAll()) != null) {
            for (PSAppView parent : psappviews) {
                List<PSSysTestCase> items = this.listByPSAppView(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((psdefields = PSModelServiceUtil.getInstance().getPSDEFieldService().listAll()) != null) {
            for (PSDEField parent : psdefields) {
                List<PSSysTestCase> items = this.listByPSDEField(parent);
                if (items == null) continue;
                list.addAll((Collection<PSSysTestCase>)items);
            }
        }
        if ((psdeserviceapis = PSModelServiceUtil.getInstance().getPSDEServiceAPIService().listAll()) != null) {
            for (PSDEServiceAPI parent : psdeserviceapis) {
                List<PSSysTestCase> items = this.listByPSDEServiceAPI(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pssystems = PSModelServiceUtil.getInstance().getPSSystemService().listAll()) != null) {
            for (PSSystem parent : pssystems) {
                List<PSSysTestCase> items = this.listByPSSystem(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if (list.size() == 0) {
            return null;
        }
        return list;
    }

    @Override
    protected PSSysTestCase onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysTestCase item;
        PSSysTestCase item2;
        PSSysTestCase item3;
        PSSysTestCase item4;
        PSSysTestCase item5;
        PSSysTestCase item6;
        PSSysTestCase item7;
        PSSysTestCase item8;
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey, true);
        if (psdataentity != null && (item8 = this.get(psdataentity, strCurKey, true)) != null) {
            return item8;
        }
        PSDEAction psdeaction = (PSDEAction)PSModelServiceUtil.getInstance().getPSDEActionService().get(strParentKey, true);
        if (psdeaction != null && (item7 = this.get(psdeaction, strCurKey, true)) != null) {
            return item7;
        }
        PSDELogic psdelogic = (PSDELogic)PSModelServiceUtil.getInstance().getPSDELogicService().get(strParentKey, true);
        if (psdelogic != null && (item6 = this.get(psdelogic, strCurKey, true)) != null) {
            return item6;
        }
        PSSysTestPrj pssystestprj = (PSSysTestPrj)PSModelServiceUtil.getInstance().getPSSysTestPrjService().get(strParentKey, true);
        if (pssystestprj != null && (item5 = this.get(pssystestprj, strCurKey, true)) != null) {
            return item5;
        }
        PSAppView psappview = (PSAppView)PSModelServiceUtil.getInstance().getPSAppViewService().get(strParentKey, true);
        if (psappview != null && (item4 = this.get(psappview, strCurKey, true)) != null) {
            return item4;
        }
        PSDEField psdefield = (PSDEField)PSModelServiceUtil.getInstance().getPSDEFieldService().get(strParentKey, true);
        if (psdefield != null && (item3 = this.get(psdefield, strCurKey, true)) != null) {
            return item3;
        }
        PSDEServiceAPI psdeserviceapi = (PSDEServiceAPI)PSModelServiceUtil.getInstance().getPSDEServiceAPIService().get(strParentKey, true);
        if (psdeserviceapi != null && (item2 = this.get(psdeserviceapi, strCurKey, true)) != null) {
            return item2;
        }
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey, true);
        if (pssystem != null && (item = this.get(pssystem, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysTestCase)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysTestCaseDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDataEntityService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSDEActionId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEActionService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSDELogicId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDELogicService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSSysTestPrjId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysTestPrjService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSAppViewId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSAppViewService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSDEFId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEFieldService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSDEServiceAPIId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEServiceAPIService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSSystemId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSystemService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysTestCase et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysTestCaseDTO dto, PSSysTestCase t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase dstItem;
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysTestCaseId(t.getId().replace("/", "."));
        }
        if (t.getActionParams() != null || !bIgnoreNull) {
            dto.setActionParams(t.getActionParams());
        }
        if (t.getAssertResult() != null || !bIgnoreNull) {
            dto.setAssertResult(t.getAssertResult());
        }
        if (t.getAssertType() != null || !bIgnoreNull) {
            dto.setAssertType(t.getAssertType());
        }
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
        }
        if (t.getContent() != null || !bIgnoreNull) {
            dto.setContent(t.getContent());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDEFPSSysSampleValueId() != null || !bIgnoreNull) {
            dto.setDEFPSSysSampleValueId(t.getDEFPSSysSampleValueId());
        }
        if (t.getDEFPSSysSampleValueName() != null || !bIgnoreNull) {
            dto.setDEFPSSysSampleValueName(t.getDEFPSSysSampleValueName());
        }
        if (t.getDEFValue() != null || !bIgnoreNull) {
            dto.setDEFValue(t.getDEFValue());
        }
        if (t.getExceptionData() != null || !bIgnoreNull) {
            dto.setExceptionData(t.getExceptionData());
        }
        if (t.getExceptionData2() != null || !bIgnoreNull) {
            dto.setExceptionData2(t.getExceptionData2());
        }
        if (t.getExceptionName() != null || !bIgnoreNull) {
            dto.setExceptionName(t.getExceptionName());
        }
        if (t.getInputValues() != null || !bIgnoreNull) {
            dto.setInputValues(t.getInputValues());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPSAppViewId() != null || !bIgnoreNull) {
            dto.setPSAppViewId(t.getPSAppViewId());
        }
        if (t.getPSAppViewName() != null || !bIgnoreNull) {
            dto.setPSAppViewName(t.getPSAppViewName());
        }
        if (t.getPSDEActionId() != null || !bIgnoreNull) {
            dto.setPSDEActionId(t.getPSDEActionId());
        }
        if (t.getPSDEActionName() != null || !bIgnoreNull) {
            dto.setPSDEActionName(t.getPSDEActionName());
        }
        if (t.getPSDEFId() != null || !bIgnoreNull) {
            dto.setPSDEFId(t.getPSDEFId());
        }
        if (t.getPSDEFName() != null || !bIgnoreNull) {
            dto.setPSDEFName(t.getPSDEFName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDELogicId() != null || !bIgnoreNull) {
            dto.setPSDELogicId(t.getPSDELogicId());
        }
        if (t.getPSDELogicName() != null || !bIgnoreNull) {
            dto.setPSDELogicName(t.getPSDELogicName());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSDESADetailId() != null || !bIgnoreNull) {
            dto.setPSDESADetailId(t.getPSDESADetailId());
        }
        if (t.getPSDESADetailName() != null || !bIgnoreNull) {
            dto.setPSDESADetailName(t.getPSDESADetailName());
        }
        if (t.getPSDEServiceAPIId() != null || !bIgnoreNull) {
            dto.setPSDEServiceAPIId(t.getPSDEServiceAPIId());
        }
        if (t.getPSDEServiceAPIName() != null || !bIgnoreNull) {
            dto.setPSDEServiceAPIName(t.getPSDEServiceAPIName());
        }
        if (t.getPSSysAppId() != null || !bIgnoreNull) {
            dto.setPSSysAppId(t.getPSSysAppId());
        }
        if (t.getPSSysServiceAPIId() != null || !bIgnoreNull) {
            dto.setPSSysServiceAPIId(t.getPSSysServiceAPIId());
        }
        if (t.getPSSysSFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginId(t.getPSSysSFPluginId());
        }
        if (t.getPSSysSFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginName(t.getPSSysSFPluginName());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSSystemName() != null || !bIgnoreNull) {
            dto.setPSSystemName(t.getPSSystemName());
        }
        if (t.getPSSysTestCaseName() != null || !bIgnoreNull) {
            dto.setPSSysTestCaseName(t.getPSSysTestCaseName());
        }
        if (t.getPSSysTestDataId() != null || !bIgnoreNull) {
            dto.setPSSysTestDataId(t.getPSSysTestDataId());
        }
        if (t.getPSSysTestDataName() != null || !bIgnoreNull) {
            dto.setPSSysTestDataName(t.getPSSysTestDataName());
        }
        if (t.getPSSysTestModuleId() != null || !bIgnoreNull) {
            dto.setPSSysTestModuleId(t.getPSSysTestModuleId());
        }
        if (t.getPSSysTestModuleName() != null || !bIgnoreNull) {
            dto.setPSSysTestModuleName(t.getPSSysTestModuleName());
        }
        if (t.getPSSysTestPrjId() != null || !bIgnoreNull) {
            dto.setPSSysTestPrjId(t.getPSSysTestPrjId());
        }
        if (t.getPSSysTestPrjName() != null || !bIgnoreNull) {
            dto.setPSSysTestPrjName(t.getPSSysTestPrjName());
        }
        if (t.getRollbackTran() != null || !bIgnoreNull) {
            dto.setRollbackTran(t.getRollbackTran());
        }
        if (t.getTargetType() != null || !bIgnoreNull) {
            dto.setTargetType(t.getTargetType());
        }
        if (t.getTestCaseLevel() != null || !bIgnoreNull) {
            dto.setTestCaseLevel(t.getTestCaseLevel());
        }
        if (t.getTestCaseSN() != null || !bIgnoreNull) {
            dto.setTestCaseSN(t.getTestCaseSN());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (t.getUserCat() != null || !bIgnoreNull) {
            dto.setUserCat(t.getUserCat());
        }
        if (t.getUserData() != null || !bIgnoreNull) {
            dto.setUserData(t.getUserData());
        }
        if (t.getUserData2() != null || !bIgnoreNull) {
            dto.setUserData2(t.getUserData2());
        }
        if (t.getUserData3() != null || !bIgnoreNull) {
            dto.setUserData3(t.getUserData3());
        }
        if (t.getUserData4() != null || !bIgnoreNull) {
            dto.setUserData4(t.getUserData4());
        }
        if (t.getUserFlag() != null || !bIgnoreNull) {
            dto.setUserFlag(t.getUserFlag());
        }
        if (t.getUserTag() != null || !bIgnoreNull) {
            dto.setUserTag(t.getUserTag());
        }
        if (t.getUserTag2() != null || !bIgnoreNull) {
            dto.setUserTag2(t.getUserTag2());
        }
        if (t.getUserTag3() != null || !bIgnoreNull) {
            dto.setUserTag3(t.getUserTag3());
        }
        if (t.getUserTag4() != null || !bIgnoreNull) {
            dto.setUserTag4(t.getUserTag4());
        }
        if (t.getValidFlag() != null || !bIgnoreNull) {
            dto.setValidFlag(t.getValidFlag());
        }
        if (StringUtils.hasLength((String)dto.getDEFPSSysSampleValueId())) {
            dto.setDEFPSSysSampleValueId(this.getRealPSModelId(t, dto.getDEFPSSysSampleValueId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSAppViewId())) {
            dto.setPSAppViewId(this.getRealPSModelId(t, dto.getPSAppViewId()).replace("/", "."));
        }
        if ("PSAPPVIEW".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSAppViewId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEActionId())) {
            dto.setPSDEActionId(this.getRealPSModelId(t, dto.getPSDEActionId()).replace("/", "."));
        }
        if ("PSDEACTION".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEActionId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            dto.setPSDEFId(this.getRealPSModelId(t, dto.getPSDEFId()).replace("/", "."));
        }
        if ("PSDEFIELD".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEFId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if ("PSDATAENTITY".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDELogicId())) {
            dto.setPSDELogicId(this.getRealPSModelId(t, dto.getPSDELogicId()).replace("/", "."));
        }
        if ("PSDELOGIC".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDELogicId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDESADetailId())) {
            dto.setPSDESADetailId(this.getRealPSModelId(t, dto.getPSDESADetailId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEServiceAPIId())) {
            dto.setPSDEServiceAPIId(this.getRealPSModelId(t, dto.getPSDEServiceAPIId()).replace("/", "."));
        }
        if ("PSDESERVICEAPI".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEServiceAPIId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            dto.setPSSysSFPluginId(this.getRealPSModelId(t, dto.getPSSysSFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            dto.setPSSystemId(this.getRealPSModelId(t, dto.getPSSystemId()).replace("/", "."));
        }
        if ("PSSYSTEM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSystemId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysTestDataId())) {
            dto.setPSSysTestDataId(this.getRealPSModelId(t, dto.getPSSysTestDataId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysTestModuleId())) {
            dto.setPSSysTestModuleId(this.getRealPSModelId(t, dto.getPSSysTestModuleId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysTestPrjId())) {
            dto.setPSSysTestPrjId(this.getRealPSModelId(t, dto.getPSSysTestPrjId()).replace("/", "."));
        }
        if ("PSSYSTESTPRJ".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysTestPrjId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDEFPSSysSampleValueId())) {
            linkDTO = (PSSysSampleValueDTO)PSModelServiceUtil.getInstance().getPSSysSampleValueService().getDTO(dto.getDEFPSSysSampleValueId());
            dto.setDEFPSSysSampleValueName(((PSSysSampleValueDTO)linkDTO).getPSSysSampleValueName());
        } else {
            dto.setDEFPSSysSampleValueName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSAppViewId())) {
            linkDTO = (PSAppViewDTO)PSModelServiceUtil.getInstance().getPSAppViewService().getDTO(dto.getPSAppViewId());
            dto.setPSAppViewName(((PSAppViewDTO)linkDTO).getPSAppViewName());
        } else {
            dto.setPSAppViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getPSDEActionId());
            dto.setPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getPSDEFId());
            dto.setPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDELogicId())) {
            linkDTO = (PSDELogicDTO)PSModelServiceUtil.getInstance().getPSDELogicService().getDTO(dto.getPSDELogicId());
            dto.setPSDELogicName(((PSDELogicDTO)linkDTO).getPSDELogicName());
        } else {
            dto.setPSDELogicName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDESADetailId())) {
            linkDTO = (PSDESADetailDTO)PSModelServiceUtil.getInstance().getPSDESADetailService().getDTO(dto.getPSDESADetailId());
            dto.setPSDESADetailName(((PSDESADetailDTO)linkDTO).getPSDESADetailName());
        } else {
            dto.setPSDESADetailName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEServiceAPIId())) {
            linkDTO = (PSDEServiceAPIDTO)PSModelServiceUtil.getInstance().getPSDEServiceAPIService().getDTO(dto.getPSDEServiceAPIId());
            dto.setPSDEServiceAPIName(((PSDEServiceAPIDTO)linkDTO).getPSDEServiceAPIName());
        } else {
            dto.setPSDEServiceAPIName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            linkDTO = (PSSysSFPluginDTO)PSModelServiceUtil.getInstance().getPSSysSFPluginService().getDTO(dto.getPSSysSFPluginId());
            dto.setPSSysSFPluginName(((PSSysSFPluginDTO)linkDTO).getPSSysSFPluginName());
        } else {
            dto.setPSSysSFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            linkDTO = (PSSystemDTO)PSModelServiceUtil.getInstance().getPSSystemService().getDTO(dto.getPSSystemId());
            dto.setPSSystemName(((PSSystemDTO)linkDTO).getPSSystemName());
        } else {
            dto.setPSSystemName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysTestDataId())) {
            linkDTO = (PSSysTestDataDTO)PSModelServiceUtil.getInstance().getPSSysTestDataService().getDTO(dto.getPSSysTestDataId());
            dto.setPSSysTestDataName(((PSSysTestDataDTO)linkDTO).getPSSysTestDataName());
        } else {
            dto.setPSSysTestDataName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysTestModuleId())) {
            linkDTO = (PSSysTestModuleDTO)PSModelServiceUtil.getInstance().getPSSysTestModuleService().getDTO(dto.getPSSysTestModuleId());
            dto.setPSSysTestModuleName(((PSSysTestModuleDTO)linkDTO).getPSSysTestModuleName());
        } else {
            dto.setPSSysTestModuleName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysTestPrjId())) {
            linkDTO = (PSSysTestPrjDTO)PSModelServiceUtil.getInstance().getPSSysTestPrjService().getDTO(dto.getPSSysTestPrjId());
            dto.setPSSysAppId(((PSSysTestPrjDTO)linkDTO).getPSSysAppId());
            dto.setPSSysServiceAPIId(((PSSysTestPrjDTO)linkDTO).getPSSysServiceAPIId());
            dto.setPSSysTestPrjName(((PSSysTestPrjDTO)linkDTO).getPSSysTestPrjName());
        } else {
            dto.setPSSysAppId(null);
            dto.setPSSysServiceAPIId(null);
            dto.setPSSysTestPrjName(null);
        }
        List<PSModelBase> list = PSModelServiceUtil.getInstance().getPSSysTCInputService().listByPSSysTestCase(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSSysTCInputDTO> pssystcinputs = new ArrayList<PSSysTCInputDTO>();
            for (PSSysTCInput pSSysTCInput : list) {
                dstItem = (PSSysTCInputDTO)PSModelServiceUtil.getInstance().getPSSysTCInputService().toDTO(pSSysTCInput);
                pssystcinputs.add((PSSysTCInputDTO)dstItem);
            }
            dto.setPssystcinputs(pssystcinputs);
        }
        if ((list = PSModelServiceUtil.getInstance().getPSSysTCAssertService().listByPSSysTestCase(t)) != null && list.size() > 0) {
            ArrayList<PSSysTCAssertDTO> pssystcasserts = new ArrayList<PSSysTCAssertDTO>();
            for (PSSysTCAssert pSSysTCAssert : list) {
                dstItem = (PSSysTCAssertDTO)PSModelServiceUtil.getInstance().getPSSysTCAssertService().toDTO(pSSysTCAssert);
                pssystcasserts.add((PSSysTCAssertDTO)dstItem);
            }
            dto.setPssystcasserts(pssystcasserts);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSSYSTESTCASE";
    }

    @Override
    public PSSysTestCase createDomain() {
        return new PSSysTestCase();
    }

    @Override
    public PSSysTestCaseDTO createDTO() {
        return new PSSysTestCaseDTO();
    }
}

