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
import net.ibizsys.modelapi.dto.PSCodeListDTO;
import net.ibizsys.modelapi.dto.PSDEACModeDTO;
import net.ibizsys.modelapi.dto.PSDEACModeItemDTO;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.service.IPSDEACModeItemService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEACModeItemServiceImpl
extends PSModelServiceImplBase<PSDEACModeItem, PSDEACModeItemDTO>
implements IPSDEACModeItemService {
    private static final Log log = LogFactory.getLog(PSDEACModeItemServiceImpl.class);

    @Override
    public List<PSDEACModeItem> listByPSDEACMode(PSDEACMode parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEACModeItem get(PSDEACMode parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEACModeItem> list = this.listByPSDEACMode(parent);
        if (list != null) {
            for (PSDEACModeItem item : list) {
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
    public List<PSDEACModeItemDTO> listDTOByPSDEACMode(String strParentKey) throws Exception {
        PSDEACMode psdeacmode = (PSDEACMode)PSModelServiceUtil.getInstance().getPSDEACModeService().get(strParentKey);
        List<PSDEACModeItem> list = this.listByPSDEACMode(psdeacmode);
        if (list != null) {
            ArrayList<PSDEACModeItemDTO> dtoList = new ArrayList<PSDEACModeItemDTO>();
            for (PSDEACModeItem item : list) {
                PSDEACModeItemDTO dto = (PSDEACModeItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEACModeItem> onListAll() throws Exception {
        ArrayList<PSDEACModeItem> list = new ArrayList<PSDEACModeItem>();
        List<PSDEACMode> psdeacmodes = PSModelServiceUtil.getInstance().getPSDEACModeService().listAll();
        if (psdeacmodes != null) {
            for (PSDEACMode parent : psdeacmodes) {
                List<PSDEACModeItem> items = this.listByPSDEACMode(parent);
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
    protected PSDEACModeItem onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEACModeItem item;
        PSDEACMode psdeacmode = (PSDEACMode)PSModelServiceUtil.getInstance().getPSDEACModeService().get(strParentKey, true);
        if (psdeacmode != null && (item = this.get(psdeacmode, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEACModeItem)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEACModeItemDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEACModeId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEACModeService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEACModeItem et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDEACModeItemName())) {
            return et.getPSDEACModeItemName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEACModeItemDTO dto, PSDEACModeItem t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEACModeItemId(t.getId().replace("/", "."));
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
        if (t.getCLConvertFlag() != null || !bIgnoreNull) {
            dto.setCLConvertFlag(t.getCLConvertFlag());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getCustomCode() != null || !bIgnoreNull) {
            dto.setCustomCode(t.getCustomCode());
        }
        if (t.getCustomMode() != null || !bIgnoreNull) {
            dto.setCustomMode(t.getCustomMode());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPSCodeListId() != null || !bIgnoreNull) {
            dto.setPSCodeListId(t.getPSCodeListId());
        }
        if (t.getPSCodeListName() != null || !bIgnoreNull) {
            dto.setPSCodeListName(t.getPSCodeListName());
        }
        if (t.getPSDEACModeId() != null || !bIgnoreNull) {
            dto.setPSDEACModeId(t.getPSDEACModeId());
        }
        if (t.getPSDEACModeItemName() != null || !bIgnoreNull) {
            dto.setPSDEACModeItemName(t.getPSDEACModeItemName());
        }
        if (t.getPSDEACModeName() != null || !bIgnoreNull) {
            dto.setPSDEACModeName(t.getPSDEACModeName());
        }
        if (t.getPSDEFId() != null || !bIgnoreNull) {
            dto.setPSDEFId(t.getPSDEFId());
        }
        if (t.getPSDEFName() != null || !bIgnoreNull) {
            dto.setPSDEFName(t.getPSDEFName());
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
        if (t.getValueFormat() != null || !bIgnoreNull) {
            dto.setValueFormat(t.getValueFormat());
        }
        if (t.getWidth() != null || !bIgnoreNull) {
            dto.setWidth(t.getWidth());
        }
        if (t.getWidthUnit() != null || !bIgnoreNull) {
            dto.setWidthUnit(t.getWidthUnit());
        }
        if (StringUtils.hasLength((String)dto.getCapPSLanResId())) {
            dto.setCapPSLanResId(this.getRealPSModelId(t, dto.getCapPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSCodeListId())) {
            dto.setPSCodeListId(this.getRealPSModelId(t, dto.getPSCodeListId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEACModeId())) {
            dto.setPSDEACModeId(this.getRealPSModelId(t, dto.getPSDEACModeId()).replace("/", "."));
        }
        if ("PSDEACMODE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEACModeId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            dto.setPSDEFId(this.getRealPSModelId(t, dto.getPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCapPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getCapPSLanResId());
            dto.setCapPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setCapPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSCodeListId())) {
            linkDTO = (PSCodeListDTO)PSModelServiceUtil.getInstance().getPSCodeListService().getDTO(dto.getPSCodeListId());
            dto.setPSCodeListName(((PSCodeListDTO)linkDTO).getPSCodeListName());
        } else {
            dto.setPSCodeListName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEACModeId())) {
            linkDTO = (PSDEACModeDTO)PSModelServiceUtil.getInstance().getPSDEACModeService().getDTO(dto.getPSDEACModeId());
            dto.setPSDEACModeName(((PSDEACModeDTO)linkDTO).getPSDEACModeName());
        } else {
            dto.setPSDEACModeName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getPSDEFId());
            dto.setPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setPSDEFName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEACMODEITEM";
    }

    @Override
    public PSDEACModeItem createDomain() {
        return new PSDEACModeItem();
    }

    @Override
    public PSDEACModeItemDTO createDTO() {
        return new PSDEACModeItemDTO();
    }
}

