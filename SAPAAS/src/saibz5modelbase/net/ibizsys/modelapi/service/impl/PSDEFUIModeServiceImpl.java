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
import net.ibizsys.modelapi.domain.PSDEFUIMode;
import net.ibizsys.modelapi.domain.PSDEField;
import net.ibizsys.modelapi.dto.PSACHandlerDTO;
import net.ibizsys.modelapi.dto.PSCodeListDTO;
import net.ibizsys.modelapi.dto.PSDEACModeDTO;
import net.ibizsys.modelapi.dto.PSDEDataSetDTO;
import net.ibizsys.modelapi.dto.PSDEFInputTipDTO;
import net.ibizsys.modelapi.dto.PSDEFUIModeDTO;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSDELogicDTO;
import net.ibizsys.modelapi.dto.PSDERDTO;
import net.ibizsys.modelapi.dto.PSDEViewBaseDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSysAppDTO;
import net.ibizsys.modelapi.dto.PSSysDictCatDTO;
import net.ibizsys.modelapi.dto.PSSysEditorStyleDTO;
import net.ibizsys.modelapi.dto.PSSysImageDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysUnitDTO;
import net.ibizsys.modelapi.service.IPSDEFUIModeService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEFUIModeServiceImpl
extends PSModelServiceImplBase<PSDEFUIMode, PSDEFUIModeDTO>
implements IPSDEFUIModeService {
    private static final Log log = LogFactory.getLog(PSDEFUIModeServiceImpl.class);

    @Override
    public List<PSDEFUIMode> listByPSDEField(PSDEField parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEFUIMode get(PSDEField parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEFUIMode> list = this.listByPSDEField(parent);
        if (list != null) {
            for (PSDEFUIMode item : list) {
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
    public List<PSDEFUIModeDTO> listDTOByPSDEField(String strParentKey) throws Exception {
        PSDEField psdefield = (PSDEField)PSModelServiceUtil.getInstance().getPSDEFieldService().get(strParentKey);
        List<PSDEFUIMode> list = this.listByPSDEField(psdefield);
        if (list != null) {
            ArrayList<PSDEFUIModeDTO> dtoList = new ArrayList<PSDEFUIModeDTO>();
            for (PSDEFUIMode item : list) {
                PSDEFUIModeDTO dto = (PSDEFUIModeDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEFUIMode> onListAll() throws Exception {
        ArrayList<PSDEFUIMode> list = new ArrayList<PSDEFUIMode>();
        List psdefields = PSModelServiceUtil.getInstance().getPSDEFieldService().listAll();
        if (psdefields != null) {
            for (PSDEField parent : psdefields) {
                List<PSDEFUIMode> items = this.listByPSDEField(parent);
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
    protected PSDEFUIMode onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEFUIMode item;
        PSDEField psdefield = (PSDEField)PSModelServiceUtil.getInstance().getPSDEFieldService().get(strParentKey, true);
        if (psdefield != null && (item = this.get(psdefield, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEFUIMode)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEFUIModeDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEFId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEFieldService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEFUIMode et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEFUIModeDTO dto, PSDEFUIMode t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEFUIModeId(t.getId().replace("/", "."));
        }
        if (t.getAllowEmpty() != null || !bIgnoreNull) {
            dto.setAllowEmpty(t.getAllowEmpty());
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
        if (t.getCodeListConfigMode() != null || !bIgnoreNull) {
            dto.setCodeListConfigMode(t.getCodeListConfigMode());
        }
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
        }
        if (t.getConvertCIText() != null || !bIgnoreNull) {
            dto.setConvertCIText(t.getConvertCIText());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateDV() != null || !bIgnoreNull) {
            dto.setCreateDV(t.getCreateDV());
        }
        if (t.getCreateDVT() != null || !bIgnoreNull) {
            dto.setCreateDVT(t.getCreateDVT());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getEditorParams() != null || !bIgnoreNull) {
            dto.setEditorParams(t.getEditorParams());
        }
        if (t.getEditorType() != null || !bIgnoreNull) {
            dto.setEditorType(t.getEditorType());
        }
        if (t.getEditorTypeName() != null || !bIgnoreNull) {
            dto.setEditorTypeName(t.getEditorTypeName());
        }
        if (t.getEnableInputTip() != null || !bIgnoreNull) {
            dto.setEnableInputTip(t.getEnableInputTip());
        }
        if (t.getEnableResetItemName() != null || !bIgnoreNull) {
            dto.setEnableResetItemName(t.getEnableResetItemName());
        }
        if (t.getEnableUnitName() != null || !bIgnoreNull) {
            dto.setEnableUnitName(t.getEnableUnitName());
        }
        if (t.getEnableValueRule() != null || !bIgnoreNull) {
            dto.setEnableValueRule(t.getEnableValueRule());
        }
        if (t.getFTMode() != null || !bIgnoreNull) {
            dto.setFTMode(t.getFTMode());
        }
        if (t.getGCRPSSysPFPluginId() != null || !bIgnoreNull) {
            dto.setGCRPSSysPFPluginId(t.getGCRPSSysPFPluginId());
        }
        if (t.getGCRPSSysPFPluginName() != null || !bIgnoreNull) {
            dto.setGCRPSSysPFPluginName(t.getGCRPSSysPFPluginName());
        }
        if (t.getGridColAlign() != null || !bIgnoreNull) {
            dto.setGridColAlign(t.getGridColAlign());
        }
        if (t.getGridColCLMode() != null || !bIgnoreNull) {
            dto.setGridColCLMode(t.getGridColCLMode());
        }
        if (t.getGridColWidth() != null || !bIgnoreNull) {
            dto.setGridColWidth(t.getGridColWidth());
        }
        if (t.getHeight() != null || !bIgnoreNull) {
            dto.setHeight(t.getHeight());
        }
        if (t.getIgnoreInput() != null || !bIgnoreNull) {
            dto.setIgnoreInput(t.getIgnoreInput());
        }
        if (t.getItemPSACHandlerId() != null || !bIgnoreNull) {
            dto.setItemPSACHandlerId(t.getItemPSACHandlerId());
        }
        if (t.getItemPSACHandlerName() != null || !bIgnoreNull) {
            dto.setItemPSACHandlerName(t.getItemPSACHandlerName());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getMaxValue() != null || !bIgnoreNull) {
            dto.setMaxValue(t.getMaxValue());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMinStrLength() != null || !bIgnoreNull) {
            dto.setMinStrLength(t.getMinStrLength());
        }
        if (t.getMinValue() != null || !bIgnoreNull) {
            dto.setMinValue(t.getMinValue());
        }
        if (t.getNeedCodeListConfig() != null || !bIgnoreNull) {
            dto.setNeedCodeListConfig(t.getNeedCodeListConfig());
        }
        if (t.getNoSort() != null || !bIgnoreNull) {
            dto.setNoSort(t.getNoSort());
        }
        if (t.getPHPSLanResId() != null || !bIgnoreNull) {
            dto.setPHPSLanResId(t.getPHPSLanResId());
        }
        if (t.getPHPSLanResName() != null || !bIgnoreNull) {
            dto.setPHPSLanResName(t.getPHPSLanResName());
        }
        if (t.getPickupTextOpts() != null || !bIgnoreNull) {
            dto.setPickupTextOpts(t.getPickupTextOpts());
        }
        if (t.getPlaceHolder() != null || !bIgnoreNull) {
            dto.setPlaceHolder(t.getPlaceHolder());
        }
        if (t.getPrecision2() != null || !bIgnoreNull) {
            dto.setPrecision2(t.getPrecision2());
        }
        if (t.getPreventXSS() != null || !bIgnoreNull) {
            dto.setPreventXSS(t.getPreventXSS());
        }
        if (t.getPSCodeListId() != null || !bIgnoreNull) {
            dto.setPSCodeListId(t.getPSCodeListId());
        }
        if (t.getPSCodeListName() != null || !bIgnoreNull) {
            dto.setPSCodeListName(t.getPSCodeListName());
        }
        if (t.getPSDEFUIModeName() != null || !bIgnoreNull) {
            dto.setPSDEFUIModeName(t.getPSDEFUIModeName());
        }
        if (t.getPSDEFId() != null || !bIgnoreNull) {
            dto.setPSDEFId(t.getPSDEFId());
        }
        if (t.getPSDEFInputTipId() != null || !bIgnoreNull) {
            dto.setPSDEFInputTipId(t.getPSDEFInputTipId());
        }
        if (t.getPSDEFInputTipName() != null || !bIgnoreNull) {
            dto.setPSDEFInputTipName(t.getPSDEFInputTipName());
        }
        if (t.getPSDEFName() != null || !bIgnoreNull) {
            dto.setPSDEFName(t.getPSDEFName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSSysAppId() != null || !bIgnoreNull) {
            dto.setPSSysAppId(t.getPSSysAppId());
        }
        if (t.getPSSysAppName() != null || !bIgnoreNull) {
            dto.setPSSysAppName(t.getPSSysAppName());
        }
        if (t.getPSSysDictCatId() != null || !bIgnoreNull) {
            dto.setPSSysDictCatId(t.getPSSysDictCatId());
        }
        if (t.getPSSysDictCatName() != null || !bIgnoreNull) {
            dto.setPSSysDictCatName(t.getPSSysDictCatName());
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
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSSysUnitId() != null || !bIgnoreNull) {
            dto.setPSSysUnitId(t.getPSSysUnitId());
        }
        if (t.getPSSysUnitName() != null || !bIgnoreNull) {
            dto.setPSSysUnitName(t.getPSSysUnitName());
        }
        if (t.getRefADPSDELogicId() != null || !bIgnoreNull) {
            dto.setRefADPSDELogicId(t.getRefADPSDELogicId());
        }
        if (t.getRefADPSDELogicName() != null || !bIgnoreNull) {
            dto.setRefADPSDELogicName(t.getRefADPSDELogicName());
        }
        if (t.getRefLinkPSDEViewId() != null || !bIgnoreNull) {
            dto.setRefLinkPSDEViewId(t.getRefLinkPSDEViewId());
        }
        if (t.getRefLinkPSDEViewName() != null || !bIgnoreNull) {
            dto.setRefLinkPSDEViewName(t.getRefLinkPSDEViewName());
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
        if (t.getRefTempData() != null || !bIgnoreNull) {
            dto.setRefTempData(t.getRefTempData());
        }
        if (t.getResetItemName() != null || !bIgnoreNull) {
            dto.setResetItemName(t.getResetItemName());
        }
        if (t.getStringCase() != null || !bIgnoreNull) {
            dto.setStringCase(t.getStringCase());
        }
        if (t.getStrLength() != null || !bIgnoreNull) {
            dto.setStrLength(t.getStrLength());
        }
        if (t.getUnitName() != null || !bIgnoreNull) {
            dto.setUnitName(t.getUnitName());
        }
        if (t.getUnitNameWidth() != null || !bIgnoreNull) {
            dto.setUnitNameWidth(t.getUnitNameWidth());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateDV() != null || !bIgnoreNull) {
            dto.setUpdateDV(t.getUpdateDV());
        }
        if (t.getUpdateDVT() != null || !bIgnoreNull) {
            dto.setUpdateDVT(t.getUpdateDVT());
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
        if (t.getValueItemName() != null || !bIgnoreNull) {
            dto.setValueItemName(t.getValueItemName());
        }
        if (t.getWidth() != null || !bIgnoreNull) {
            dto.setWidth(t.getWidth());
        }
        if (StringUtils.hasLength((String)dto.getCapPSLanResId())) {
            dto.setCapPSLanResId(this.getRealPSModelId(t, dto.getCapPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getGCRPSSysPFPluginId())) {
            dto.setGCRPSSysPFPluginId(this.getRealPSModelId(t, dto.getGCRPSSysPFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getItemPSACHandlerId())) {
            dto.setItemPSACHandlerId(this.getRealPSModelId(t, dto.getItemPSACHandlerId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSDEFInputTipId())) {
            dto.setPSDEFInputTipId(this.getRealPSModelId(t, dto.getPSDEFInputTipId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysAppId())) {
            dto.setPSSysAppId(this.getRealPSModelId(t, dto.getPSSysAppId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDictCatId())) {
            dto.setPSSysDictCatId(this.getRealPSModelId(t, dto.getPSSysDictCatId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysEditorStyleId())) {
            dto.setPSSysEditorStyleId(this.getRealPSModelId(t, dto.getPSSysEditorStyleId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysImageId())) {
            dto.setPSSysImageId(this.getRealPSModelId(t, dto.getPSSysImageId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysUnitId())) {
            dto.setPSSysUnitId(this.getRealPSModelId(t, dto.getPSSysUnitId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefADPSDELogicId())) {
            dto.setRefADPSDELogicId(this.getRealPSModelId(t, dto.getRefADPSDELogicId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefLinkPSDEViewId())) {
            dto.setRefLinkPSDEViewId(this.getRealPSModelId(t, dto.getRefLinkPSDEViewId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getGCRPSSysPFPluginId())) {
            linkDTO = (PSSysPFPluginDTO)PSModelServiceUtil.getInstance().getPSSysPFPluginService().getDTO(dto.getGCRPSSysPFPluginId());
            dto.setGCRPSSysPFPluginName(((PSSysPFPluginDTO)linkDTO).getPSSysPFPluginName());
        } else {
            dto.setGCRPSSysPFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getItemPSACHandlerId())) {
            linkDTO = (PSACHandlerDTO)PSModelServiceUtil.getInstance().getPSACHandlerService().getDTO(dto.getItemPSACHandlerId());
            dto.setItemPSACHandlerName(((PSACHandlerDTO)linkDTO).getPSACHandlerName());
        } else {
            dto.setItemPSACHandlerName(null);
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
            dto.setPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
            dto.setPSDEId(((PSDEFieldDTO)linkDTO).getPSDEId());
            dto.setPSDEName(((PSDEFieldDTO)linkDTO).getPSDEName());
            dto.setPSSystemId(((PSDEFieldDTO)linkDTO).getPSSystemId());
        } else {
            dto.setPSDEFName(null);
            dto.setPSDEId(null);
            dto.setPSDEName(null);
            dto.setPSSystemId(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFInputTipId())) {
            linkDTO = (PSDEFInputTipDTO)PSModelServiceUtil.getInstance().getPSDEFInputTipService().getDTO(dto.getPSDEFInputTipId());
            dto.setPSDEFInputTipName(((PSDEFInputTipDTO)linkDTO).getPSDEFInputTipName());
        } else {
            dto.setPSDEFInputTipName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysAppId())) {
            linkDTO = (PSSysAppDTO)PSModelServiceUtil.getInstance().getPSSysAppService().getDTO(dto.getPSSysAppId());
            dto.setPSSysAppName(((PSSysAppDTO)linkDTO).getPSSysAppName());
        } else {
            dto.setPSSysAppName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDictCatId())) {
            linkDTO = (PSSysDictCatDTO)PSModelServiceUtil.getInstance().getPSSysDictCatService().getDTO(dto.getPSSysDictCatId());
            dto.setPSSysDictCatName(((PSSysDictCatDTO)linkDTO).getPSSysDictCatName());
        } else {
            dto.setPSSysDictCatName(null);
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
        if (StringUtils.hasLength((String)dto.getPSSysUnitId())) {
            linkDTO = (PSSysUnitDTO)PSModelServiceUtil.getInstance().getPSSysUnitService().getDTO(dto.getPSSysUnitId());
            dto.setPSSysUnitName(((PSSysUnitDTO)linkDTO).getPSSysUnitName());
        } else {
            dto.setPSSysUnitName(null);
        }
        if (StringUtils.hasLength((String)dto.getRefADPSDELogicId())) {
            linkDTO = (PSDELogicDTO)PSModelServiceUtil.getInstance().getPSDELogicService().getDTO(dto.getRefADPSDELogicId());
            dto.setRefADPSDELogicName(((PSDELogicDTO)linkDTO).getPSDELogicName());
        } else {
            dto.setRefADPSDELogicName(null);
        }
        if (StringUtils.hasLength((String)dto.getRefLinkPSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getRefLinkPSDEViewId());
            dto.setRefLinkPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setRefLinkPSDEViewName(null);
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
        return "PSDEFFORMITEM";
    }

    @Override
    public PSDEFUIMode createDomain() {
        return new PSDEFUIMode();
    }

    @Override
    public PSDEFUIModeDTO createDTO() {
        return new PSDEFUIModeDTO();
    }
}

