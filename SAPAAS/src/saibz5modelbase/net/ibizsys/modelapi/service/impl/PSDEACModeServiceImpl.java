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
import net.ibizsys.modelapi.domain.PSDEACMode;
import net.ibizsys.modelapi.domain.PSDEACModeItem;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEACModeDTO;
import net.ibizsys.modelapi.dto.PSDEACModeItemDTO;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSDELogicDTO;
import net.ibizsys.modelapi.dto.PSDEUAGroupDTO;
import net.ibizsys.modelapi.dto.PSDEViewBaseDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.service.IPSDEACModeService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEACModeServiceImpl
extends PSModelServiceImplBase<PSDEACMode, PSDEACModeDTO>
implements IPSDEACModeService {
    private static final Log log = LogFactory.getLog(PSDEACModeServiceImpl.class);

    @Override
    public List<PSDEACMode> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEACMode get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEACMode> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSDEACMode item : list) {
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
    public List<PSDEACModeDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSDEACMode> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSDEACModeDTO> dtoList = new ArrayList<PSDEACModeDTO>();
            for (PSDEACMode item : list) {
                PSDEACModeDTO dto = (PSDEACModeDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEACMode> onListAll() throws Exception {
        ArrayList<PSDEACMode> list = new ArrayList<PSDEACMode>();
        List<PSDataEntity> psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll();
        if (psdataentities != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSDEACMode> items = this.listByPSDataEntity(parent);
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
    protected PSDEACMode onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEACMode item;
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey, true);
        if (psdataentity != null && (item = this.get(psdataentity, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEACMode)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEACModeDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDataEntityService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEACMode et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDEACModeName())) {
            return et.getPSDEACModeName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEACModeDTO dto, PSDEACMode t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEACModeId(t.getId().replace("/", "."));
        }
        if (t.getACIPSSysPFPluginId() != null || !bIgnoreNull) {
            dto.setACIPSSysPFPluginId(t.getACIPSSysPFPluginId());
        }
        if (t.getACIPSSysPFPluginName() != null || !bIgnoreNull) {
            dto.setACIPSSysPFPluginName(t.getACIPSSysPFPluginName());
        }
        if (t.getADPSDELogicId() != null || !bIgnoreNull) {
            dto.setADPSDELogicId(t.getADPSDELogicId());
        }
        if (t.getADPSDELogicName() != null || !bIgnoreNull) {
            dto.setADPSDELogicName(t.getADPSDELogicName());
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
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getEmptyText() != null || !bIgnoreNull) {
            dto.setEmptyText(t.getEmptyText());
        }
        if (t.getEmptyTextPSLanResId() != null || !bIgnoreNull) {
            dto.setEmptyTextPSLanResId(t.getEmptyTextPSLanResId());
        }
        if (t.getEmptyTextPSLanResName() != null || !bIgnoreNull) {
            dto.setEmptyTextPSLanResName(t.getEmptyTextPSLanResName());
        }
        if (t.getEnablePagingBar() != null || !bIgnoreNull) {
            dto.setEnablePagingBar(t.getEnablePagingBar());
        }
        if (t.getExtendMode() != null || !bIgnoreNull) {
            dto.setExtendMode(t.getExtendMode());
        }
        if (t.getFillerObj() != null || !bIgnoreNull) {
            dto.setFillerObj(t.getFillerObj());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getLogicName() != null || !bIgnoreNull) {
            dto.setLogicName(t.getLogicName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMinorSortDir() != null || !bIgnoreNull) {
            dto.setMinorSortDir(t.getMinorSortDir());
        }
        if (t.getMinorSortPSDEFId() != null || !bIgnoreNull) {
            dto.setMinorSortPSDEFId(t.getMinorSortPSDEFId());
        }
        if (t.getMinorSortPSDEFName() != null || !bIgnoreNull) {
            dto.setMinorSortPSDEFName(t.getMinorSortPSDEFName());
        }
        if (t.getPagingSize() != null || !bIgnoreNull) {
            dto.setPagingSize(t.getPagingSize());
        }
        if (t.getPickupPSDEViewId() != null || !bIgnoreNull) {
            dto.setPickupPSDEViewId(t.getPickupPSDEViewId());
        }
        if (t.getPickupPSDEViewName() != null || !bIgnoreNull) {
            dto.setPickupPSDEViewName(t.getPickupPSDEViewName());
        }
        if (t.getPSDEACModeName() != null || !bIgnoreNull) {
            dto.setPSDEACModeName(t.getPSDEACModeName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSDEUAGroupId() != null || !bIgnoreNull) {
            dto.setPSDEUAGroupId(t.getPSDEUAGroupId());
        }
        if (t.getPSDEUAGroupName() != null || !bIgnoreNull) {
            dto.setPSDEUAGroupName(t.getPSDEUAGroupName());
        }
        if (t.getTextPSDEFId() != null || !bIgnoreNull) {
            dto.setTextPSDEFId(t.getTextPSDEFId());
        }
        if (t.getTextPSDEFName() != null || !bIgnoreNull) {
            dto.setTextPSDEFName(t.getTextPSDEFName());
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
        if (t.getValuePSDEFId() != null || !bIgnoreNull) {
            dto.setValuePSDEFId(t.getValuePSDEFId());
        }
        if (t.getValuePSDEFName() != null || !bIgnoreNull) {
            dto.setValuePSDEFName(t.getValuePSDEFName());
        }
        if (StringUtils.hasLength((String)dto.getACIPSSysPFPluginId())) {
            dto.setACIPSSysPFPluginId(this.getRealPSModelId(t, dto.getACIPSSysPFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getADPSDELogicId())) {
            dto.setADPSDELogicId(this.getRealPSModelId(t, dto.getADPSDELogicId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getEmptyTextPSLanResId())) {
            dto.setEmptyTextPSLanResId(this.getRealPSModelId(t, dto.getEmptyTextPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMinorSortPSDEFId())) {
            dto.setMinorSortPSDEFId(this.getRealPSModelId(t, dto.getMinorSortPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPickupPSDEViewId())) {
            dto.setPickupPSDEViewId(this.getRealPSModelId(t, dto.getPickupPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if ("PSDATAENTITY".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEUAGroupId())) {
            dto.setPSDEUAGroupId(this.getRealPSModelId(t, dto.getPSDEUAGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTextPSDEFId())) {
            dto.setTextPSDEFId(this.getRealPSModelId(t, dto.getTextPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getValuePSDEFId())) {
            dto.setValuePSDEFId(this.getRealPSModelId(t, dto.getValuePSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getACIPSSysPFPluginId())) {
            linkDTO = (PSSysPFPluginDTO)PSModelServiceUtil.getInstance().getPSSysPFPluginService().getDTO(dto.getACIPSSysPFPluginId());
            dto.setACIPSSysPFPluginName(((PSSysPFPluginDTO)linkDTO).getPSSysPFPluginName());
        } else {
            dto.setACIPSSysPFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getADPSDELogicId())) {
            linkDTO = (PSDELogicDTO)PSModelServiceUtil.getInstance().getPSDELogicService().getDTO(dto.getADPSDELogicId());
            dto.setADPSDELogicName(((PSDELogicDTO)linkDTO).getPSDELogicName());
        } else {
            dto.setADPSDELogicName(null);
        }
        if (StringUtils.hasLength((String)dto.getEmptyTextPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getEmptyTextPSLanResId());
            dto.setEmptyTextPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setEmptyTextPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getMinorSortPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getMinorSortPSDEFId());
            dto.setMinorSortPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setMinorSortPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getPickupPSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getPickupPSDEViewId());
            dto.setPickupPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setPickupPSDEViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEUAGroupId())) {
            linkDTO = (PSDEUAGroupDTO)PSModelServiceUtil.getInstance().getPSDEUAGroupService().getDTO(dto.getPSDEUAGroupId());
            dto.setPSDEUAGroupName(((PSDEUAGroupDTO)linkDTO).getPSDEUAGroupName());
        } else {
            dto.setPSDEUAGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getTextPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getTextPSDEFId());
            dto.setTextPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setTextPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getValuePSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getValuePSDEFId());
            dto.setValuePSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setValuePSDEFName(null);
        }
        List<PSDEACModeItem> list = PSModelServiceUtil.getInstance().getPSDEACModeItemService().listByPSDEACMode(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSDEACModeItemDTO> psdeacmodeitems = new ArrayList<PSDEACModeItemDTO>();
            for (PSDEACModeItem item : list) {
                PSDEACModeItemDTO dstItem = (PSDEACModeItemDTO)PSModelServiceUtil.getInstance().getPSDEACModeItemService().toDTO(item);
                psdeacmodeitems.add(dstItem);
            }
            dto.setPsdeacmodeitems(psdeacmodeitems);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEACMODE";
    }

    @Override
    public PSDEACMode createDomain() {
        return new PSDEACMode();
    }

    @Override
    public PSDEACModeDTO createDTO() {
        return new PSDEACModeDTO();
    }
}

