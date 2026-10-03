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
import java.util.List;
import net.ibizsys.modelapi.domain.PSDEMap;
import net.ibizsys.modelapi.domain.PSDEMapAction;
import net.ibizsys.modelapi.domain.PSDEMapDQ;
import net.ibizsys.modelapi.domain.PSDEMapDS;
import net.ibizsys.modelapi.domain.PSDEMapDetail;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEMapActionDTO;
import net.ibizsys.modelapi.dto.PSDEMapDQDTO;
import net.ibizsys.modelapi.dto.PSDEMapDSDTO;
import net.ibizsys.modelapi.dto.PSDEMapDTO;
import net.ibizsys.modelapi.dto.PSDEMapDetailDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysRefDTO;
import net.ibizsys.modelapi.dto.PSSysSFPluginDTO;
import net.ibizsys.modelapi.service.IPSDEMapService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEMapServiceImpl
extends PSModelServiceImplBase<PSDEMap, PSDEMapDTO>
implements IPSDEMapService {
    private static final Log log = LogFactory.getLog(PSDEMapServiceImpl.class);

    @Override
    public List<PSDEMap> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEMap get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEMap> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSDEMap item : list) {
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
    public List<PSDEMapDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSDEMap> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSDEMapDTO> dtoList = new ArrayList<PSDEMapDTO>();
            for (PSDEMap item : list) {
                PSDEMapDTO dto = (PSDEMapDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEMap> onListAll() throws Exception {
        ArrayList<PSDEMap> list = new ArrayList<PSDEMap>();
        List<PSDataEntity> psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll();
        if (psdataentities != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSDEMap> items = this.listByPSDataEntity(parent);
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
    protected PSDEMap onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEMap item;
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey, true);
        if (psdataentity != null && (item = this.get(psdataentity, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEMap)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEMapDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDataEntityService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEMap et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getPSDEMapName())) {
            return et.getPSDEMapName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEMapDTO dto, PSDEMap t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase dstItem;
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEMapId(t.getId().replace("/", "."));
        }
        if (t.getAutoDEActionMap() != null || !bIgnoreNull) {
            dto.setAutoDEActionMap(t.getAutoDEActionMap());
        }
        if (t.getAutoDEDQMap() != null || !bIgnoreNull) {
            dto.setAutoDEDQMap(t.getAutoDEDQMap());
        }
        if (t.getAutoDEDSMap() != null || !bIgnoreNull) {
            dto.setAutoDEDSMap(t.getAutoDEDSMap());
        }
        if (t.getAutoDEFieldMap() != null || !bIgnoreNull) {
            dto.setAutoDEFieldMap(t.getAutoDEFieldMap());
        }
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDefaultMode() != null || !bIgnoreNull) {
            dto.setDefaultMode(t.getDefaultMode());
        }
        if (t.getDSTPSDEId() != null || !bIgnoreNull) {
            dto.setDSTPSDEId(t.getDSTPSDEId());
        }
        if (t.getDSTPSDEName() != null || !bIgnoreNull) {
            dto.setDSTPSDEName(t.getDSTPSDEName());
        }
        if (t.getDstPSSysRefDEId() != null || !bIgnoreNull) {
            dto.setDstPSSysRefDEId(t.getDstPSSysRefDEId());
        }
        if (t.getDstPSSysRefDEName() != null || !bIgnoreNull) {
            dto.setDstPSSysRefDEName(t.getDstPSSysRefDEName());
        }
        if (t.getLogicName() != null || !bIgnoreNull) {
            dto.setLogicName(t.getLogicName());
        }
        if (t.getMapMode() != null || !bIgnoreNull) {
            dto.setMapMode(t.getMapMode());
        }
        if (t.getMapTarget() != null || !bIgnoreNull) {
            dto.setMapTarget(t.getMapTarget());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEMapName() != null || !bIgnoreNull) {
            dto.setPSDEMapName(t.getPSDEMapName());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSSysDynaModelId() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelId(t.getPSSysDynaModelId());
        }
        if (t.getPSSysDynaModelName() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelName(t.getPSSysDynaModelName());
        }
        if (t.getPSSysRefId() != null || !bIgnoreNull) {
            dto.setPSSysRefId(t.getPSSysRefId());
        }
        if (t.getPSSysRefName() != null || !bIgnoreNull) {
            dto.setPSSysRefName(t.getPSSysRefName());
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
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (t.getUserCat() != null || !bIgnoreNull) {
            dto.setUserCat(t.getUserCat());
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
        if (StringUtils.hasLength((String)dto.getDSTPSDEId())) {
            dto.setDSTPSDEId(this.getRealPSModelId(t, dto.getDSTPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if ("PSDATAENTITY".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            dto.setPSSysDynaModelId(this.getRealPSModelId(t, dto.getPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysRefId())) {
            dto.setPSSysRefId(this.getRealPSModelId(t, dto.getPSSysRefId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            dto.setPSSysSFPluginId(this.getRealPSModelId(t, dto.getPSSysSFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDSTPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getDSTPSDEId());
            dto.setDSTPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setDSTPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
            dto.setPSSystemId(((PSDataEntityDTO)linkDTO).getPSSystemId());
        } else {
            dto.setPSDEName(null);
            dto.setPSSystemId(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            linkDTO = (PSSysDynaModelDTO)PSModelServiceUtil.getInstance().getPSSysDynaModelService().getDTO(dto.getPSSysDynaModelId());
            dto.setPSSysDynaModelName(((PSSysDynaModelDTO)linkDTO).getPSSysDynaModelName());
        } else {
            dto.setPSSysDynaModelName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysRefId())) {
            linkDTO = (PSSysRefDTO)PSModelServiceUtil.getInstance().getPSSysRefService().getDTO(dto.getPSSysRefId());
            dto.setPSSysRefName(((PSSysRefDTO)linkDTO).getPSSysRefName());
        } else {
            dto.setPSSysRefName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            linkDTO = (PSSysSFPluginDTO)PSModelServiceUtil.getInstance().getPSSysSFPluginService().getDTO(dto.getPSSysSFPluginId());
            dto.setPSSysSFPluginName(((PSSysSFPluginDTO)linkDTO).getPSSysSFPluginName());
        } else {
            dto.setPSSysSFPluginName(null);
        }
        List<PSDEMapAction> pSDEMapActionList = PSModelServiceUtil.getInstance().getPSDEMapActionService().listByPSDEMap(t);
        if (pSDEMapActionList != null && pSDEMapActionList.size() > 0) {
            ArrayList<PSDEMapActionDTO> psdemapactions = new ArrayList<PSDEMapActionDTO>();
            for (PSDEMapAction pSDEMapAction : pSDEMapActionList) {
                dstItem = (PSDEMapActionDTO)PSModelServiceUtil.getInstance().getPSDEMapActionService().toDTO(pSDEMapAction);
                psdemapactions.add((PSDEMapActionDTO)dstItem);
            }
            dto.setPsdemapactions(psdemapactions);
        }
        List<PSDEMapDetail> pSDEMapDetailList = PSModelServiceUtil.getInstance().getPSDEMapDetailService().listByPSDEMap(t);
        if (pSDEMapDetailList != null && pSDEMapDetailList.size() > 0) {
            ArrayList<PSDEMapDetailDTO> psdemapdetails = new ArrayList<PSDEMapDetailDTO>();
            for (PSDEMapDetail pSDEMapDetail : pSDEMapDetailList) {
                dstItem = (PSDEMapDetailDTO)PSModelServiceUtil.getInstance().getPSDEMapDetailService().toDTO(pSDEMapDetail);
                psdemapdetails.add((PSDEMapDetailDTO)dstItem);
            }
            dto.setPsdemapdetails(psdemapdetails);
        }
        List<PSDEMapDQ> pSDEMapDQList = PSModelServiceUtil.getInstance().getPSDEMapDQService().listByPSDEMap(t);
        if (pSDEMapDQList != null && pSDEMapDQList.size() > 0) {
            ArrayList<PSDEMapDQDTO> psdemapdqs = new ArrayList<PSDEMapDQDTO>();
            for (PSDEMapDQ pSDEMapDQ : pSDEMapDQList) {
                dstItem = (PSDEMapDQDTO)PSModelServiceUtil.getInstance().getPSDEMapDQService().toDTO(pSDEMapDQ);
                psdemapdqs.add((PSDEMapDQDTO)dstItem);
            }
            dto.setPsdemapdqs(psdemapdqs);
        }
        List<PSDEMapDS> pSDEMapDSList = PSModelServiceUtil.getInstance().getPSDEMapDSService().listByPSDEMap(t);
        if (pSDEMapDSList != null && pSDEMapDSList.size() > 0) {
            ArrayList<PSDEMapDSDTO> psdemapds = new ArrayList<PSDEMapDSDTO>();
            for (PSDEMapDS pSDEMapDS : pSDEMapDSList) {
                dstItem = (PSDEMapDSDTO)PSModelServiceUtil.getInstance().getPSDEMapDSService().toDTO(pSDEMapDS);
                psdemapds.add((PSDEMapDSDTO)dstItem);
            }
            dto.setPsdemapds(psdemapds);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEMAP";
    }

    @Override
    public PSDEMap createDomain() {
        return new PSDEMap();
    }

    @Override
    public PSDEMapDTO createDTO() {
        return new PSDEMapDTO();
    }
}

