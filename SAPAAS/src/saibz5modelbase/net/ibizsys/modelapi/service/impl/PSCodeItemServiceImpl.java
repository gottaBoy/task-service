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
import net.ibizsys.modelapi.domain.PSCodeItem;
import net.ibizsys.modelapi.domain.PSCodeList;
import net.ibizsys.modelapi.dto.PSCodeItemDTO;
import net.ibizsys.modelapi.dto.PSCodeListDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSysCssDTO;
import net.ibizsys.modelapi.dto.PSSysImageDTO;
import net.ibizsys.modelapi.service.IPSCodeItemService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSCodeItemServiceImpl
extends PSModelServiceImplBase<PSCodeItem, PSCodeItemDTO>
implements IPSCodeItemService {
    private static final Log log = LogFactory.getLog(PSCodeItemServiceImpl.class);

    @Override
    public List<PSCodeItem> listByPSCodeItem(PSCodeItem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSCodeItem get(PSCodeItem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSCodeItem> list = this.listByPSCodeItem(parent);
        if (list != null) {
            for (PSCodeItem item : list) {
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
    public List<PSCodeItemDTO> listDTOByPSCodeItem(String strParentKey) throws Exception {
        PSCodeItem pscodeitem = (PSCodeItem)PSModelServiceUtil.getInstance().getPSCodeItemService().get(strParentKey);
        List<PSCodeItem> list = this.listByPSCodeItem(pscodeitem);
        if (list != null) {
            ArrayList<PSCodeItemDTO> dtoList = new ArrayList<PSCodeItemDTO>();
            for (PSCodeItem item : list) {
                PSCodeItemDTO dto = (PSCodeItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSCodeItem> listByPSCodeList(PSCodeList parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSCodeItem get(PSCodeList parent, String strKey, boolean bTryMode) throws Exception {
        List<PSCodeItem> list = this.listByPSCodeList(parent);
        if (list != null) {
            for (PSCodeItem item : list) {
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
    public List<PSCodeItemDTO> listDTOByPSCodeList(String strParentKey) throws Exception {
        PSCodeList pscodelist = (PSCodeList)PSModelServiceUtil.getInstance().getPSCodeListService().get(strParentKey);
        List<PSCodeItem> list = this.listByPSCodeList(pscodelist);
        if (list != null) {
            ArrayList<PSCodeItemDTO> dtoList = new ArrayList<PSCodeItemDTO>();
            for (PSCodeItem item : list) {
                PSCodeItemDTO dto = (PSCodeItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSCodeItem> onListAll() throws Exception {
        ArrayList<PSCodeItem> list = new ArrayList<PSCodeItem>();
        List pscodelists = PSModelServiceUtil.getInstance().getPSCodeListService().listAll();
        if (pscodelists != null) {
            for (PSCodeList parent : pscodelists) {
                List<PSCodeItem> items = this.listByPSCodeList(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if (list.size() == 0) {
            return null;
        }
        ArrayList<PSCodeItem> alllist = new ArrayList<PSCodeItem>();
        alllist.addAll(list);
        for (PSCodeItem item : list) {
            List<PSCodeItem> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSCodeItem> listAllChild(PSCodeItem parent) throws Exception {
        List<PSCodeItem> list = this.listByPSCodeItem(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSCodeItem> alllist = new ArrayList<PSCodeItem>();
        alllist.addAll(list);
        for (PSCodeItem item : list) {
            List<PSCodeItem> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSCodeItem> listAllByPSCodeList(PSCodeList parent) throws Exception {
        List<PSCodeItem> list = this.listByPSCodeList(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSCodeItem> alllist = new ArrayList<PSCodeItem>();
        alllist.addAll(list);
        for (PSCodeItem item : list) {
            List<PSCodeItem> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSCodeItemDTO> listAllDTOByPSCodeList(String strParentKey) throws Exception {
        PSCodeList pscodelist = (PSCodeList)PSModelServiceUtil.getInstance().getPSCodeListService().get(strParentKey);
        List<PSCodeItem> list = this.listAllByPSCodeList(pscodelist);
        if (list != null) {
            ArrayList<PSCodeItemDTO> dtoList = new ArrayList<PSCodeItemDTO>();
            for (PSCodeItem item : list) {
                PSCodeItemDTO dto = (PSCodeItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected PSCodeItem onGet(String strParentKey, String strCurKey) throws Exception {
        PSCodeItem item;
        PSCodeItem item2;
        PSCodeItem pscodeitem = (PSCodeItem)PSModelServiceUtil.getInstance().getPSCodeItemService().get(strParentKey, true);
        if (pscodeitem != null && (item2 = this.get(pscodeitem, strCurKey, true)) != null) {
            return item2;
        }
        PSCodeList pscodelist = (PSCodeList)PSModelServiceUtil.getInstance().getPSCodeListService().get(strParentKey, true);
        if (pscodelist != null && (item = this.get(pscodelist, strCurKey, true)) != null) {
            return item;
        }
        return (PSCodeItem)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSCodeItemDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPPSCodeItemId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSCodeItemService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSCodeListId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSCodeListService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSCodeItem et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSCodeItemDTO dto, PSCodeItem t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSCodeItemId(t.getId().replace("/", "."));
        }
        if (t.getBeginValue() != null || !bIgnoreNull) {
            dto.setBeginValue(t.getBeginValue());
        }
        if (t.getBKColor() != null || !bIgnoreNull) {
            dto.setBKColor(t.getBKColor());
        }
        if (t.getCodeItemValue() != null || !bIgnoreNull) {
            dto.setCodeItemValue(t.getCodeItemValue());
        }
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
        }
        if (t.getColor() != null || !bIgnoreNull) {
            dto.setColor(t.getColor());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getData() != null || !bIgnoreNull) {
            dto.setData(t.getData());
        }
        if (t.getDefaultFlag() != null || !bIgnoreNull) {
            dto.setDefaultFlag(t.getDefaultFlag());
        }
        if (t.getDisableSelect() != null || !bIgnoreNull) {
            dto.setDisableSelect(t.getDisableSelect());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getEndValue() != null || !bIgnoreNull) {
            dto.setEndValue(t.getEndValue());
        }
        if (t.getIconCls() != null || !bIgnoreNull) {
            dto.setIconCls(t.getIconCls());
        }
        if (t.getIncBeginValue() != null || !bIgnoreNull) {
            dto.setIncBeginValue(t.getIncBeginValue());
        }
        if (t.getIncEndValue() != null || !bIgnoreNull) {
            dto.setIncEndValue(t.getIncEndValue());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPPSCodeItemId() != null || !bIgnoreNull) {
            dto.setPPSCodeItemId(t.getPPSCodeItemId());
        }
        if (t.getPPSCodeItemName() != null || !bIgnoreNull) {
            dto.setPPSCodeItemName(t.getPPSCodeItemName());
        }
        if (t.getPSCodeItemName() != null || !bIgnoreNull) {
            dto.setPSCodeItemName(t.getPSCodeItemName());
        }
        if (t.getPSCodeListId() != null || !bIgnoreNull) {
            dto.setPSCodeListId(t.getPSCodeListId());
        }
        if (t.getPSCodeListName() != null || !bIgnoreNull) {
            dto.setPSCodeListName(t.getPSCodeListName());
        }
        if (t.getPSSysCssId() != null || !bIgnoreNull) {
            dto.setPSSysCssId(t.getPSSysCssId());
        }
        if (t.getPSSysCssName() != null || !bIgnoreNull) {
            dto.setPSSysCssName(t.getPSSysCssName());
        }
        if (t.getPSSysImageId() != null || !bIgnoreNull) {
            dto.setPSSysImageId(t.getPSSysImageId());
        }
        if (t.getPSSysImageName() != null || !bIgnoreNull) {
            dto.setPSSysImageName(t.getPSSysImageName());
        }
        if (t.getShortKey() != null || !bIgnoreNull) {
            dto.setShortKey(t.getShortKey());
        }
        if (t.getShowAsEmpty() != null || !bIgnoreNull) {
            dto.setShowAsEmpty(t.getShowAsEmpty());
        }
        if (t.getTextPSLanResId() != null || !bIgnoreNull) {
            dto.setTextPSLanResId(t.getTextPSLanResId());
        }
        if (t.getTextPSLanResName() != null || !bIgnoreNull) {
            dto.setTextPSLanResName(t.getTextPSLanResName());
        }
        if (t.getThresholdGroupFlag() != null || !bIgnoreNull) {
            dto.setThresholdGroupFlag(t.getThresholdGroupFlag());
        }
        if (t.getTipPSLanResId() != null || !bIgnoreNull) {
            dto.setTipPSLanResId(t.getTipPSLanResId());
        }
        if (t.getTipPSLanResName() != null || !bIgnoreNull) {
            dto.setTipPSLanResName(t.getTipPSLanResName());
        }
        if (t.getTooltipInfo() != null || !bIgnoreNull) {
            dto.setTooltipInfo(t.getTooltipInfo());
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
        if (t.getValidFlag() != null || !bIgnoreNull) {
            dto.setValidFlag(t.getValidFlag());
        }
        if (StringUtils.hasLength((String)dto.getPPSCodeItemId())) {
            dto.setPPSCodeItemId(this.getRealPSModelId(t, dto.getPPSCodeItemId()).replace("/", "."));
        }
        if ("PSCODEITEM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPPSCodeItemId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSCodeListId())) {
            dto.setPSCodeListId(this.getRealPSModelId(t, dto.getPSCodeListId()).replace("/", "."));
        }
        if ("PSCODELIST".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSCodeListId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysCssId())) {
            dto.setPSSysCssId(this.getRealPSModelId(t, dto.getPSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysImageId())) {
            dto.setPSSysImageId(this.getRealPSModelId(t, dto.getPSSysImageId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTextPSLanResId())) {
            dto.setTextPSLanResId(this.getRealPSModelId(t, dto.getTextPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTipPSLanResId())) {
            dto.setTipPSLanResId(this.getRealPSModelId(t, dto.getTipPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPPSCodeItemId())) {
            linkDTO = (PSCodeItemDTO)PSModelServiceUtil.getInstance().getPSCodeItemService().getDTO(dto.getPPSCodeItemId(), true);
            if (linkDTO != null) {
                dto.setPPSCodeItemName(((PSCodeItemDTO)linkDTO).getPSCodeItemName());
            }
        } else {
            dto.setPPSCodeItemName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSCodeListId())) {
            linkDTO = (PSCodeListDTO)PSModelServiceUtil.getInstance().getPSCodeListService().getDTO(dto.getPSCodeListId());
            dto.setPSCodeListName(((PSCodeListDTO)linkDTO).getPSCodeListName());
            dto.setThresholdGroupFlag(((PSCodeListDTO)linkDTO).getThresholdGroupFlag());
        } else {
            dto.setPSCodeListName(null);
            dto.setThresholdGroupFlag(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysCssId())) {
            linkDTO = (PSSysCssDTO)PSModelServiceUtil.getInstance().getPSSysCssService().getDTO(dto.getPSSysCssId());
            dto.setPSSysCssName(((PSSysCssDTO)linkDTO).getPSSysCssName());
        } else {
            dto.setPSSysCssName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysImageId())) {
            linkDTO = (PSSysImageDTO)PSModelServiceUtil.getInstance().getPSSysImageService().getDTO(dto.getPSSysImageId());
            dto.setPSSysImageName(((PSSysImageDTO)linkDTO).getPSSysImageName());
        } else {
            dto.setPSSysImageName(null);
        }
        if (StringUtils.hasLength((String)dto.getTextPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getTextPSLanResId());
            dto.setTextPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setTextPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getTipPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getTipPSLanResId());
            dto.setTipPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setTipPSLanResName(null);
        }
        List<PSCodeItem> list = PSModelServiceUtil.getInstance().getPSCodeItemService().listByPSCodeItem(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSCodeItemDTO> pscodeitems = new ArrayList<PSCodeItemDTO>();
            for (PSCodeItem item : list) {
                PSCodeItemDTO dstItem = (PSCodeItemDTO)PSModelServiceUtil.getInstance().getPSCodeItemService().toDTO(item);
                pscodeitems.add(dstItem);
            }
            dto.setPscodeitems(pscodeitems);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSCODEITEM";
    }

    @Override
    public PSCodeItem createDomain() {
        return new PSCodeItem();
    }

    @Override
    public PSCodeItemDTO createDTO() {
        return new PSCodeItemDTO();
    }
}

