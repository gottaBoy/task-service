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
import net.ibizsys.modelapi.domain.PSPanelItemLogic;
import net.ibizsys.modelapi.domain.PSSysViewPanelItem;
import net.ibizsys.modelapi.dto.PSPanelItemLogicDTO;
import net.ibizsys.modelapi.dto.PSSysViewPanelDTO;
import net.ibizsys.modelapi.dto.PSSysViewPanelItemDTO;
import net.ibizsys.modelapi.dto.PSSysViewPanelModelDTO;
import net.ibizsys.modelapi.service.IPSPanelItemLogicService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSPanelItemLogicServiceImpl
extends PSModelServiceImplBase<PSPanelItemLogic, PSPanelItemLogicDTO>
implements IPSPanelItemLogicService {
    private static final Log log = LogFactory.getLog(PSPanelItemLogicServiceImpl.class);

    @Override
    public List<PSPanelItemLogic> listByPSPanelItemLogic(PSPanelItemLogic parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSPanelItemLogic get(PSPanelItemLogic parent, String strKey, boolean bTryMode) throws Exception {
        List<PSPanelItemLogic> list = this.listByPSPanelItemLogic(parent);
        if (list != null) {
            for (PSPanelItemLogic item : list) {
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
    public List<PSPanelItemLogicDTO> listDTOByPSPanelItemLogic(String strParentKey) throws Exception {
        PSPanelItemLogic pspanelitemlogic = (PSPanelItemLogic)PSModelServiceUtil.getInstance().getPSPanelItemLogicService().get(strParentKey);
        List<PSPanelItemLogic> list = this.listByPSPanelItemLogic(pspanelitemlogic);
        if (list != null) {
            ArrayList<PSPanelItemLogicDTO> dtoList = new ArrayList<PSPanelItemLogicDTO>();
            for (PSPanelItemLogic item : list) {
                PSPanelItemLogicDTO dto = (PSPanelItemLogicDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSPanelItemLogic> listByPSSysViewPanelItem(PSSysViewPanelItem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSPanelItemLogic get(PSSysViewPanelItem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSPanelItemLogic> list = this.listByPSSysViewPanelItem(parent);
        if (list != null) {
            for (PSPanelItemLogic item : list) {
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
    public List<PSPanelItemLogicDTO> listDTOByPSSysViewPanelItem(String strParentKey) throws Exception {
        PSSysViewPanelItem pssysviewpanelitem = (PSSysViewPanelItem)PSModelServiceUtil.getInstance().getPSSysViewPanelItemService().get(strParentKey);
        List<PSPanelItemLogic> list = this.listByPSSysViewPanelItem(pssysviewpanelitem);
        if (list != null) {
            ArrayList<PSPanelItemLogicDTO> dtoList = new ArrayList<PSPanelItemLogicDTO>();
            for (PSPanelItemLogic item : list) {
                PSPanelItemLogicDTO dto = (PSPanelItemLogicDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSPanelItemLogic> onListAll() throws Exception {
        ArrayList<PSPanelItemLogic> list = new ArrayList<PSPanelItemLogic>();
        List pssysviewpanelitems = PSModelServiceUtil.getInstance().getPSSysViewPanelItemService().listAll();
        if (pssysviewpanelitems != null) {
            for (PSSysViewPanelItem parent : pssysviewpanelitems) {
                List<PSPanelItemLogic> items = this.listByPSSysViewPanelItem(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if (list.size() == 0) {
            return null;
        }
        ArrayList<PSPanelItemLogic> alllist = new ArrayList<PSPanelItemLogic>();
        alllist.addAll(list);
        for (PSPanelItemLogic item : list) {
            List<PSPanelItemLogic> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSPanelItemLogic> listAllChild(PSPanelItemLogic parent) throws Exception {
        List<PSPanelItemLogic> list = this.listByPSPanelItemLogic(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSPanelItemLogic> alllist = new ArrayList<PSPanelItemLogic>();
        alllist.addAll(list);
        for (PSPanelItemLogic item : list) {
            List<PSPanelItemLogic> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSPanelItemLogic> listAllByPSSysViewPanelItem(PSSysViewPanelItem parent) throws Exception {
        List<PSPanelItemLogic> list = this.listByPSSysViewPanelItem(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSPanelItemLogic> alllist = new ArrayList<PSPanelItemLogic>();
        alllist.addAll(list);
        for (PSPanelItemLogic item : list) {
            List<PSPanelItemLogic> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSPanelItemLogicDTO> listAllDTOByPSSysViewPanelItem(String strParentKey) throws Exception {
        PSSysViewPanelItem pssysviewpanelitem = (PSSysViewPanelItem)PSModelServiceUtil.getInstance().getPSSysViewPanelItemService().get(strParentKey);
        List<PSPanelItemLogic> list = this.listAllByPSSysViewPanelItem(pssysviewpanelitem);
        if (list != null) {
            ArrayList<PSPanelItemLogicDTO> dtoList = new ArrayList<PSPanelItemLogicDTO>();
            for (PSPanelItemLogic item : list) {
                PSPanelItemLogicDTO dto = (PSPanelItemLogicDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected PSPanelItemLogic onGet(String strParentKey, String strCurKey) throws Exception {
        PSPanelItemLogic item;
        PSPanelItemLogic item2;
        PSPanelItemLogic pspanelitemlogic = (PSPanelItemLogic)PSModelServiceUtil.getInstance().getPSPanelItemLogicService().get(strParentKey, true);
        if (pspanelitemlogic != null && (item2 = this.get(pspanelitemlogic, strCurKey, true)) != null) {
            return item2;
        }
        PSSysViewPanelItem pssysviewpanelitem = (PSSysViewPanelItem)PSModelServiceUtil.getInstance().getPSSysViewPanelItemService().get(strParentKey, true);
        if (pssysviewpanelitem != null && (item = this.get(pssysviewpanelitem, strCurKey, true)) != null) {
            return item;
        }
        return (PSPanelItemLogic)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSPanelItemLogicDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPPSPanelItemLogicId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSPanelItemLogicService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSSysViewPanelItemId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysViewPanelItemService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSPanelItemLogic et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSPanelItemLogicDTO dto, PSPanelItemLogic t, boolean bIgnoreNull) throws Exception {
        List<PSPanelItemLogic> list;
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSPanelItemLogicId(t.getId().replace("/", "."));
        }
        if (t.getCondOp() != null || !bIgnoreNull) {
            dto.setCondOp(t.getCondOp());
        }
        if (t.getCondValue() != null || !bIgnoreNull) {
            dto.setCondValue(t.getCondValue());
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
        if (t.getDstFieldName() != null || !bIgnoreNull) {
            dto.setDstFieldName(t.getDstFieldName());
        }
        if (t.getDstPSPanelModelId() != null || !bIgnoreNull) {
            dto.setDstPSPanelModelId(t.getDstPSPanelModelId());
        }
        if (t.getDstPSPanelModelName() != null || !bIgnoreNull) {
            dto.setDstPSPanelModelName(t.getDstPSPanelModelName());
        }
        if (t.getGroupNotFlag() != null || !bIgnoreNull) {
            dto.setGroupNotFlag(t.getGroupNotFlag());
        }
        if (t.getGroupOP() != null || !bIgnoreNull) {
            dto.setGroupOP(t.getGroupOP());
        }
        if (t.getLogicCat() != null || !bIgnoreNull) {
            dto.setLogicCat(t.getLogicCat());
        }
        if (t.getLogicType() != null || !bIgnoreNull) {
            dto.setLogicType(t.getLogicType());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPPSPanelItemLogicId() != null || !bIgnoreNull) {
            dto.setPPSPanelItemLogicId(t.getPPSPanelItemLogicId());
        }
        if (t.getPPSPanelItemLogicName() != null || !bIgnoreNull) {
            dto.setPPSPanelItemLogicName(t.getPPSPanelItemLogicName());
        }
        if (t.getPSPanelItemLogicName() != null || !bIgnoreNull) {
            dto.setPSPanelItemLogicName(t.getPSPanelItemLogicName());
        }
        if (t.getPSSysViewPanelId() != null || !bIgnoreNull) {
            dto.setPSSysViewPanelId(t.getPSSysViewPanelId());
        }
        if (t.getPSSysViewPanelItemId() != null || !bIgnoreNull) {
            dto.setPSSysViewPanelItemId(t.getPSSysViewPanelItemId());
        }
        if (t.getPSSysViewPanelItemName() != null || !bIgnoreNull) {
            dto.setPSSysViewPanelItemName(t.getPSSysViewPanelItemName());
        }
        if (t.getPSSysViewPanelName() != null || !bIgnoreNull) {
            dto.setPSSysViewPanelName(t.getPSSysViewPanelName());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (StringUtils.hasLength((String)dto.getDstPSPanelModelId())) {
            dto.setDstPSPanelModelId(this.getRealPSModelId(t, dto.getDstPSPanelModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPPSPanelItemLogicId())) {
            dto.setPPSPanelItemLogicId(this.getRealPSModelId(t, dto.getPPSPanelItemLogicId()).replace("/", "."));
        }
        if ("PSPANELITEMLOGIC".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPPSPanelItemLogicId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysViewPanelId())) {
            dto.setPSSysViewPanelId(this.getRealPSModelId(t, dto.getPSSysViewPanelId()).replace("/", "."));
        } else {
            dto.setPSSysViewPanelId(this.getRealPSModelId(t, "<PSSYSVIEWPANEL>").replace("/", "."));
        }
        if ("PSSYSVIEWPANEL".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysViewPanelId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysViewPanelItemId())) {
            dto.setPSSysViewPanelItemId(this.getRealPSModelId(t, dto.getPSSysViewPanelItemId()).replace("/", "."));
        }
        if ("PSSYSVIEWPANELITEM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysViewPanelItemId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDstPSPanelModelId())) {
            linkDTO = (PSSysViewPanelModelDTO)PSModelServiceUtil.getInstance().getPSSysViewPanelModelService().getDTO(dto.getDstPSPanelModelId());
            dto.setDstPSPanelModelName(((PSSysViewPanelModelDTO)linkDTO).getPSSysViewPanelModelName());
        } else {
            dto.setDstPSPanelModelName(null);
        }
        if (StringUtils.hasLength((String)dto.getPPSPanelItemLogicId())) {
            linkDTO = (PSPanelItemLogicDTO)PSModelServiceUtil.getInstance().getPSPanelItemLogicService().getDTO(dto.getPPSPanelItemLogicId());
            dto.setPPSPanelItemLogicName(((PSPanelItemLogicDTO)linkDTO).getPSPanelItemLogicName());
        } else {
            dto.setPPSPanelItemLogicName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysViewPanelId())) {
            linkDTO = (PSSysViewPanelDTO)PSModelServiceUtil.getInstance().getPSSysViewPanelService().getDTO(dto.getPSSysViewPanelId());
            dto.setPSSysViewPanelName(((PSSysViewPanelDTO)linkDTO).getPSSysViewPanelName());
        } else {
            dto.setPSSysViewPanelName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysViewPanelItemId())) {
            linkDTO = (PSSysViewPanelItemDTO)PSModelServiceUtil.getInstance().getPSSysViewPanelItemService().getDTO(dto.getPSSysViewPanelItemId(), true);
            if (linkDTO != null) {
                dto.setPSSysViewPanelItemName(((PSSysViewPanelItemDTO)linkDTO).getPSSysViewPanelItemName());
            }
        } else {
            dto.setPSSysViewPanelItemName(null);
        }
        if ((list = PSModelServiceUtil.getInstance().getPSPanelItemLogicService().listByPSPanelItemLogic(t)) != null && list.size() > 0) {
            ArrayList<PSPanelItemLogicDTO> pspanelitemlogics = new ArrayList<PSPanelItemLogicDTO>();
            for (PSPanelItemLogic item : list) {
                PSPanelItemLogicDTO dstItem = (PSPanelItemLogicDTO)PSModelServiceUtil.getInstance().getPSPanelItemLogicService().toDTO(item);
                pspanelitemlogics.add(dstItem);
            }
            dto.setPspanelitemlogics(pspanelitemlogics);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSPANELITEMLOGIC";
    }

    @Override
    public PSPanelItemLogic createDomain() {
        return new PSPanelItemLogic();
    }

    @Override
    public PSPanelItemLogicDTO createDTO() {
        return new PSPanelItemLogicDTO();
    }
}

