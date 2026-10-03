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
import net.ibizsys.modelapi.domain.PSDEFSFItem;
import net.ibizsys.modelapi.domain.PSDEField;
import net.ibizsys.modelapi.dto.PSCodeListDTO;
import net.ibizsys.modelapi.dto.PSDEACModeDTO;
import net.ibizsys.modelapi.dto.PSDEDataSetDTO;
import net.ibizsys.modelapi.dto.PSDEFSFItemDTO;
import net.ibizsys.modelapi.dto.PSDEFValueRuleDTO;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSDELogicDTO;
import net.ibizsys.modelapi.dto.PSDERDTO;
import net.ibizsys.modelapi.dto.PSDEViewBaseDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSysDBVFDTO;
import net.ibizsys.modelapi.dto.PSSysEditorStyleDTO;
import net.ibizsys.modelapi.dto.PSSysImageDTO;
import net.ibizsys.modelapi.dto.PSSysValueRuleDTO;
import net.ibizsys.modelapi.service.IPSDEFSFItemService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEFSFItemServiceImpl
extends PSModelServiceImplBase<PSDEFSFItem, PSDEFSFItemDTO>
implements IPSDEFSFItemService {
    private static final Log log = LogFactory.getLog(PSDEFSFItemServiceImpl.class);

    @Override
    public List<PSDEFSFItem> listByPSDEField(PSDEField parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEFSFItem get(PSDEField parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEFSFItem> list = this.listByPSDEField(parent);
        if (list != null) {
            for (PSDEFSFItem item : list) {
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
    public List<PSDEFSFItemDTO> listDTOByPSDEField(String strParentKey) throws Exception {
        PSDEField psdefield = (PSDEField)PSModelServiceUtil.getInstance().getPSDEFieldService().get(strParentKey);
        List<PSDEFSFItem> list = this.listByPSDEField(psdefield);
        if (list != null) {
            ArrayList<PSDEFSFItemDTO> dtoList = new ArrayList<PSDEFSFItemDTO>();
            for (PSDEFSFItem item : list) {
                PSDEFSFItemDTO dto = (PSDEFSFItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEFSFItem> onListAll() throws Exception {
        ArrayList<PSDEFSFItem> list = new ArrayList<PSDEFSFItem>();
        List<PSDEField> psdefields = PSModelServiceUtil.getInstance().getPSDEFieldService().listAll();
        if (psdefields != null) {
            for (PSDEField parent : psdefields) {
                List<PSDEFSFItem> items = this.listByPSDEField(parent);
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
    protected PSDEFSFItem onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEFSFItem item;
        PSDEField psdefield = (PSDEField)PSModelServiceUtil.getInstance().getPSDEFieldService().get(strParentKey, true);
        if (psdefield != null && (item = this.get(psdefield, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEFSFItem)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEFSFItemDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEFId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEFieldService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEFSFItem et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDEFSFItemName())) {
            return et.getPSDEFSFItemName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEFSFItemDTO dto, PSDEFSFItem t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEFSFItemId(t.getId().replace("/", "."));
        }
        if (t.getCapPSLanResId() != null || !bIgnoreNull) {
            dto.setCapPSLanResId(t.getCapPSLanResId());
        }
        if (t.getCapPSLanResName() != null || !bIgnoreNull) {
            dto.setCapPSLanResName(t.getCapPSLanResName());
        }
        if (t.getCaption() != null || !bIgnoreNull) {
            dto.setCaption(t.getCaption());
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
        if (t.getDefaultFlag() != null || !bIgnoreNull) {
            dto.setDefaultFlag(t.getDefaultFlag());
        }
        if (t.getEditorType() != null || !bIgnoreNull) {
            dto.setEditorType(t.getEditorType());
        }
        if (t.getEditorTypeName() != null || !bIgnoreNull) {
            dto.setEditorTypeName(t.getEditorTypeName());
        }
        if (t.getExtendMode() != null || !bIgnoreNull) {
            dto.setExtendMode(t.getExtendMode());
        }
        if (t.getHeight() != null || !bIgnoreNull) {
            dto.setHeight(t.getHeight());
        }
        if (t.getItemTag() != null || !bIgnoreNull) {
            dto.setItemTag(t.getItemTag());
        }
        if (t.getItemTag2() != null || !bIgnoreNull) {
            dto.setItemTag2(t.getItemTag2());
        }
        if (t.getJsonFormat() != null || !bIgnoreNull) {
            dto.setJsonFormat(t.getJsonFormat());
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
        if (t.getPHPSLanResId() != null || !bIgnoreNull) {
            dto.setPHPSLanResId(t.getPHPSLanResId());
        }
        if (t.getPHPSLanResName() != null || !bIgnoreNull) {
            dto.setPHPSLanResName(t.getPHPSLanResName());
        }
        if (t.getPlaceHolder() != null || !bIgnoreNull) {
            dto.setPlaceHolder(t.getPlaceHolder());
        }
        if (t.getPSCodeListId() != null || !bIgnoreNull) {
            dto.setPSCodeListId(t.getPSCodeListId());
        }
        if (t.getPSCodeListName() != null || !bIgnoreNull) {
            dto.setPSCodeListName(t.getPSCodeListName());
        }
        if (t.getPSDBValueOPId() != null || !bIgnoreNull) {
            dto.setPSDBValueOPId(t.getPSDBValueOPId());
        }
        if (t.getPSDBValueOPName() != null || !bIgnoreNull) {
            dto.setPSDBValueOPName(t.getPSDBValueOPName());
        }
        if (t.getPSDEFId() != null || !bIgnoreNull) {
            dto.setPSDEFId(t.getPSDEFId());
        }
        if (t.getPSDEFName() != null || !bIgnoreNull) {
            dto.setPSDEFName(t.getPSDEFName());
        }
        if (t.getPSDEFSFItemName() != null || !bIgnoreNull) {
            dto.setPSDEFSFItemName(t.getPSDEFSFItemName());
        }
        if (t.getPSDEFValueRuleId() != null || !bIgnoreNull) {
            dto.setPSDEFValueRuleId(t.getPSDEFValueRuleId());
        }
        if (t.getPSDEFValueRuleName() != null || !bIgnoreNull) {
            dto.setPSDEFValueRuleName(t.getPSDEFValueRuleName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSSysDBVFId() != null || !bIgnoreNull) {
            dto.setPSSysDBVFId(t.getPSSysDBVFId());
        }
        if (t.getPSSysDBVFName() != null || !bIgnoreNull) {
            dto.setPSSysDBVFName(t.getPSSysDBVFName());
        }
        if (t.getPSSysEditorStyleId() != null || !bIgnoreNull) {
            dto.setPSSysEditorStyleId(t.getPSSysEditorStyleId());
        }
        if (t.getPSSysEditorStyleName() != null || !bIgnoreNull) {
            dto.setPSSysEditorStyleName(t.getPSSysEditorStyleName());
        }
        if (t.getPSSysImageId() != null || !bIgnoreNull) {
            dto.setPSSysImageId(t.getPSSysImageId());
        }
        if (t.getPSSysImageName() != null || !bIgnoreNull) {
            dto.setPSSysImageName(t.getPSSysImageName());
        }
        if (t.getPSSysValueRuleId() != null || !bIgnoreNull) {
            dto.setPSSysValueRuleId(t.getPSSysValueRuleId());
        }
        if (t.getPSSysValueRuleName() != null || !bIgnoreNull) {
            dto.setPSSysValueRuleName(t.getPSSysValueRuleName());
        }
        if (t.getRefADPSDELogicId() != null || !bIgnoreNull) {
            dto.setRefADPSDELogicId(t.getRefADPSDELogicId());
        }
        if (t.getRefADPSDELogicName() != null || !bIgnoreNull) {
            dto.setRefADPSDELogicName(t.getRefADPSDELogicName());
        }
        if (t.getRefMobMPickupPSDEViewId() != null || !bIgnoreNull) {
            dto.setRefMobMPickupPSDEViewId(t.getRefMobMPickupPSDEViewId());
        }
        if (t.getRefMobMPickupPSDEViewName() != null || !bIgnoreNull) {
            dto.setRefMobMPickupPSDEViewName(t.getRefMobMPickupPSDEViewName());
        }
        if (t.getRefMobPickupPSDEViewId() != null || !bIgnoreNull) {
            dto.setRefMobPickupPSDEViewId(t.getRefMobPickupPSDEViewId());
        }
        if (t.getRefMobPickupPSDEViewName() != null || !bIgnoreNull) {
            dto.setRefMobPickupPSDEViewName(t.getRefMobPickupPSDEViewName());
        }
        if (t.getRefMPickupPSDEViewId() != null || !bIgnoreNull) {
            dto.setRefMPickupPSDEViewId(t.getRefMPickupPSDEViewId());
        }
        if (t.getRefMPickupPSDEViewName() != null || !bIgnoreNull) {
            dto.setRefMPickupPSDEViewName(t.getRefMPickupPSDEViewName());
        }
        if (t.getRefPickupPSDEViewId() != null || !bIgnoreNull) {
            dto.setRefPickupPSDEViewId(t.getRefPickupPSDEViewId());
        }
        if (t.getRefPickupPSDEViewName() != null || !bIgnoreNull) {
            dto.setRefPickupPSDEViewName(t.getRefPickupPSDEViewName());
        }
        if (t.getRefPSDEACModeId() != null || !bIgnoreNull) {
            dto.setRefPSDEACModeId(t.getRefPSDEACModeId());
        }
        if (t.getRefPSDEACModeName() != null || !bIgnoreNull) {
            dto.setRefPSDEACModeName(t.getRefPSDEACModeName());
        }
        if (t.getRefPSDEDataSetId() != null || !bIgnoreNull) {
            dto.setRefPSDEDataSetId(t.getRefPSDEDataSetId());
        }
        if (t.getRefPSDEDataSetName() != null || !bIgnoreNull) {
            dto.setRefPSDEDataSetName(t.getRefPSDEDataSetName());
        }
        if (t.getRefPSDEId() != null || !bIgnoreNull) {
            dto.setRefPSDEId(t.getRefPSDEId());
        }
        if (t.getRefPSDEName() != null || !bIgnoreNull) {
            dto.setRefPSDEName(t.getRefPSDEName());
        }
        if (t.getRefPSDERId() != null || !bIgnoreNull) {
            dto.setRefPSDERId(t.getRefPSDERId());
        }
        if (t.getRefPSDERName() != null || !bIgnoreNull) {
            dto.setRefPSDERName(t.getRefPSDERName());
        }
        if (t.getSearchMode() != null || !bIgnoreNull) {
            dto.setSearchMode(t.getSearchMode());
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
        if (t.getUserParams() != null || !bIgnoreNull) {
            dto.setUserParams(t.getUserParams());
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
        if (t.getValueFormat() != null || !bIgnoreNull) {
            dto.setValueFormat(t.getValueFormat());
        }
        if (t.getWidth() != null || !bIgnoreNull) {
            dto.setWidth(t.getWidth());
        }
        if (StringUtils.hasLength((String)dto.getCapPSLanResId())) {
            dto.setCapPSLanResId(this.getRealPSModelId(t, dto.getCapPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPHPSLanResId())) {
            dto.setPHPSLanResId(this.getRealPSModelId(t, dto.getPHPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSCodeListId())) {
            dto.setPSCodeListId(this.getRealPSModelId(t, dto.getPSCodeListId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            dto.setPSDEFId(this.getRealPSModelId(t, dto.getPSDEFId()).replace("/", "."));
        }
        if ("PSDEFIELD".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEFId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFValueRuleId())) {
            dto.setPSDEFValueRuleId(this.getRealPSModelId(t, dto.getPSDEFValueRuleId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDBVFId())) {
            dto.setPSSysDBVFId(this.getRealPSModelId(t, dto.getPSSysDBVFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysEditorStyleId())) {
            dto.setPSSysEditorStyleId(this.getRealPSModelId(t, dto.getPSSysEditorStyleId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysImageId())) {
            dto.setPSSysImageId(this.getRealPSModelId(t, dto.getPSSysImageId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysValueRuleId())) {
            dto.setPSSysValueRuleId(this.getRealPSModelId(t, dto.getPSSysValueRuleId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefADPSDELogicId())) {
            dto.setRefADPSDELogicId(this.getRealPSModelId(t, dto.getRefADPSDELogicId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefMobMPickupPSDEViewId())) {
            dto.setRefMobMPickupPSDEViewId(this.getRealPSModelId(t, dto.getRefMobMPickupPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefMobPickupPSDEViewId())) {
            dto.setRefMobPickupPSDEViewId(this.getRealPSModelId(t, dto.getRefMobPickupPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefMPickupPSDEViewId())) {
            dto.setRefMPickupPSDEViewId(this.getRealPSModelId(t, dto.getRefMPickupPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefPickupPSDEViewId())) {
            dto.setRefPickupPSDEViewId(this.getRealPSModelId(t, dto.getRefPickupPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefPSDEACModeId())) {
            dto.setRefPSDEACModeId(this.getRealPSModelId(t, dto.getRefPSDEACModeId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefPSDEDataSetId())) {
            dto.setRefPSDEDataSetId(this.getRealPSModelId(t, dto.getRefPSDEDataSetId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefPSDEId())) {
            dto.setRefPSDEId(this.getRealPSModelId(t, dto.getRefPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefPSDERId())) {
            dto.setRefPSDERId(this.getRealPSModelId(t, dto.getRefPSDERId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCapPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getCapPSLanResId());
            dto.setCapPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setCapPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getPHPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getPHPSLanResId());
            dto.setPHPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setPHPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSCodeListId())) {
            linkDTO = (PSCodeListDTO)PSModelServiceUtil.getInstance().getPSCodeListService().getDTO(dto.getPSCodeListId());
            dto.setPSCodeListName(((PSCodeListDTO)linkDTO).getPSCodeListName());
        } else {
            dto.setPSCodeListName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getPSDEFId());
            dto.setLogicName(((PSDEFieldDTO)linkDTO).getLogicName());
            dto.setPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setLogicName(null);
            dto.setPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFValueRuleId())) {
            linkDTO = (PSDEFValueRuleDTO)PSModelServiceUtil.getInstance().getPSDEFValueRuleService().getDTO(dto.getPSDEFValueRuleId());
            dto.setPSDEFValueRuleName(((PSDEFValueRuleDTO)linkDTO).getPSDEFValueRuleName());
        } else {
            dto.setPSDEFValueRuleName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDBVFId())) {
            linkDTO = (PSSysDBVFDTO)PSModelServiceUtil.getInstance().getPSSysDBVFService().getDTO(dto.getPSSysDBVFId());
            dto.setPSSysDBVFName(((PSSysDBVFDTO)linkDTO).getPSSysDBVFName());
        } else {
            dto.setPSSysDBVFName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysEditorStyleId())) {
            linkDTO = (PSSysEditorStyleDTO)PSModelServiceUtil.getInstance().getPSSysEditorStyleService().getDTO(dto.getPSSysEditorStyleId());
            dto.setPSSysEditorStyleName(((PSSysEditorStyleDTO)linkDTO).getPSSysEditorStyleName());
        } else {
            dto.setPSSysEditorStyleName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysImageId())) {
            linkDTO = (PSSysImageDTO)PSModelServiceUtil.getInstance().getPSSysImageService().getDTO(dto.getPSSysImageId());
            dto.setPSSysImageName(((PSSysImageDTO)linkDTO).getPSSysImageName());
        } else {
            dto.setPSSysImageName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysValueRuleId())) {
            linkDTO = (PSSysValueRuleDTO)PSModelServiceUtil.getInstance().getPSSysValueRuleService().getDTO(dto.getPSSysValueRuleId());
            dto.setPSSysValueRuleName(((PSSysValueRuleDTO)linkDTO).getPSSysValueRuleName());
        } else {
            dto.setPSSysValueRuleName(null);
        }
        if (StringUtils.hasLength((String)dto.getRefADPSDELogicId())) {
            linkDTO = (PSDELogicDTO)PSModelServiceUtil.getInstance().getPSDELogicService().getDTO(dto.getRefADPSDELogicId());
            dto.setRefADPSDELogicName(((PSDELogicDTO)linkDTO).getPSDELogicName());
        } else {
            dto.setRefADPSDELogicName(null);
        }
        if (StringUtils.hasLength((String)dto.getRefMobMPickupPSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getRefMobMPickupPSDEViewId());
            dto.setRefMobMPickupPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setRefMobMPickupPSDEViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getRefMobPickupPSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getRefMobPickupPSDEViewId());
            dto.setRefMobPickupPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setRefMobPickupPSDEViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getRefMPickupPSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getRefMPickupPSDEViewId());
            dto.setRefMPickupPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setRefMPickupPSDEViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getRefPickupPSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getRefPickupPSDEViewId());
            dto.setRefPickupPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setRefPickupPSDEViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getRefPSDEACModeId())) {
            linkDTO = (PSDEACModeDTO)PSModelServiceUtil.getInstance().getPSDEACModeService().getDTO(dto.getRefPSDEACModeId());
            dto.setRefPSDEACModeName(((PSDEACModeDTO)linkDTO).getPSDEACModeName());
        } else {
            dto.setRefPSDEACModeName(null);
        }
        if (StringUtils.hasLength((String)dto.getRefPSDEDataSetId())) {
            linkDTO = (PSDEDataSetDTO)PSModelServiceUtil.getInstance().getPSDEDataSetService().getDTO(dto.getRefPSDEDataSetId());
            dto.setRefPSDEDataSetName(((PSDEDataSetDTO)linkDTO).getPSDEDataSetName());
        } else {
            dto.setRefPSDEDataSetName(null);
        }
        if (StringUtils.hasLength((String)dto.getRefPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getRefPSDEId());
            dto.setRefPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setRefPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getRefPSDERId())) {
            linkDTO = (PSDERDTO)PSModelServiceUtil.getInstance().getPSDERService().getDTO(dto.getRefPSDERId());
            dto.setRefPSDERName(((PSDERDTO)linkDTO).getPSDERName());
        } else {
            dto.setRefPSDERName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSDEFSFITEM";
    }

    @Override
    public PSDEFSFItem createDomain() {
        return new PSDEFSFItem();
    }

    @Override
    public PSDEFSFItemDTO createDTO() {
        return new PSDEFSFItemDTO();
    }
}

