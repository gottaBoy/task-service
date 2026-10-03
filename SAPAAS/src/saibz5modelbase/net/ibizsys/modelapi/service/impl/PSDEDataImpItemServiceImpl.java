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
import net.ibizsys.modelapi.domain.PSDEDataImp;
import net.ibizsys.modelapi.domain.PSDEDataImpItem;
import net.ibizsys.modelapi.dto.PSCodeListDTO;
import net.ibizsys.modelapi.dto.PSDEDataImpDTO;
import net.ibizsys.modelapi.dto.PSDEDataImpItemDTO;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.service.IPSDEDataImpItemService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEDataImpItemServiceImpl
extends PSModelServiceImplBase<PSDEDataImpItem, PSDEDataImpItemDTO>
implements IPSDEDataImpItemService {
    private static final Log log = LogFactory.getLog(PSDEDataImpItemServiceImpl.class);

    @Override
    public List<PSDEDataImpItem> listByPSDEDataImp(PSDEDataImp parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEDataImpItem get(PSDEDataImp parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEDataImpItem> list = this.listByPSDEDataImp(parent);
        if (list != null) {
            for (PSDEDataImpItem item : list) {
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
    public List<PSDEDataImpItemDTO> listDTOByPSDEDataImp(String strParentKey) throws Exception {
        PSDEDataImp psdedataimp = (PSDEDataImp)PSModelServiceUtil.getInstance().getPSDEDataImpService().get(strParentKey);
        List<PSDEDataImpItem> list = this.listByPSDEDataImp(psdedataimp);
        if (list != null) {
            ArrayList<PSDEDataImpItemDTO> dtoList = new ArrayList<PSDEDataImpItemDTO>();
            for (PSDEDataImpItem item : list) {
                PSDEDataImpItemDTO dto = (PSDEDataImpItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEDataImpItem> onListAll() throws Exception {
        ArrayList<PSDEDataImpItem> list = new ArrayList<PSDEDataImpItem>();
        List<PSDEDataImp> psdedataimps = PSModelServiceUtil.getInstance().getPSDEDataImpService().listAll();
        if (psdedataimps != null) {
            for (PSDEDataImp parent : psdedataimps) {
                List<PSDEDataImpItem> items = this.listByPSDEDataImp(parent);
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
    protected PSDEDataImpItem onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEDataImpItem item;
        PSDEDataImp psdedataimp = (PSDEDataImp)PSModelServiceUtil.getInstance().getPSDEDataImpService().get(strParentKey, true);
        if (psdedataimp != null && (item = this.get(psdedataimp, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEDataImpItem)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEDataImpItemDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEDataImpId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEDataImpService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEDataImpItem et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEDataImpItemDTO dto, PSDEDataImpItem t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEDataImpItemId(t.getId().replace("/", "."));
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
        if (t.getHiddenDataItem() != null || !bIgnoreNull) {
            dto.setHiddenDataItem(t.getHiddenDataItem());
        }
        if (t.getKeyFlag() != null || !bIgnoreNull) {
            dto.setKeyFlag(t.getKeyFlag());
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
        if (t.getPSDEDataImpId() != null || !bIgnoreNull) {
            dto.setPSDEDataImpId(t.getPSDEDataImpId());
        }
        if (t.getPSDEDataImpItemName() != null || !bIgnoreNull) {
            dto.setPSDEDataImpItemName(t.getPSDEDataImpItemName());
        }
        if (t.getPSDEDataImpName() != null || !bIgnoreNull) {
            dto.setPSDEDataImpName(t.getPSDEDataImpName());
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
        if (StringUtils.hasLength((String)dto.getCapPSLanResId())) {
            dto.setCapPSLanResId(this.getRealPSModelId(t, dto.getCapPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSCodeListId())) {
            dto.setPSCodeListId(this.getRealPSModelId(t, dto.getPSCodeListId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDataImpId())) {
            dto.setPSDEDataImpId(this.getRealPSModelId(t, dto.getPSDEDataImpId()).replace("/", "."));
        }
        if ("PSDEDATAIMP".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEDataImpId(t.getSrfParent().getId().replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSDEDataImpId())) {
            linkDTO = (PSDEDataImpDTO)PSModelServiceUtil.getInstance().getPSDEDataImpService().getDTO(dto.getPSDEDataImpId());
            dto.setPSDEDataImpName(((PSDEDataImpDTO)linkDTO).getPSDEDataImpName());
            dto.setPSDEId(((PSDEDataImpDTO)linkDTO).getPSDEId());
        } else {
            dto.setPSDEDataImpName(null);
            dto.setPSDEId(null);
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
        return "PSDEDATAIMPITEM";
    }

    @Override
    public PSDEDataImpItem createDomain() {
        return new PSDEDataImpItem();
    }

    @Override
    public PSDEDataImpItemDTO createDTO() {
        return new PSDEDataImpItemDTO();
    }
}

