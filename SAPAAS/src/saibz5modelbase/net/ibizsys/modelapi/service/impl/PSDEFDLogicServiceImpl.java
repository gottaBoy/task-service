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
import net.ibizsys.modelapi.domain.PSDEFDLogic;
import net.ibizsys.modelapi.domain.PSDEForm;
import net.ibizsys.modelapi.domain.PSDEFormDetail;
import net.ibizsys.modelapi.dto.PSDEFDLogicDTO;
import net.ibizsys.modelapi.dto.PSDEFormDTO;
import net.ibizsys.modelapi.dto.PSDEFormDetailDTO;
import net.ibizsys.modelapi.service.IPSDEFDLogicService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEFDLogicServiceImpl
extends PSModelServiceImplBase<PSDEFDLogic, PSDEFDLogicDTO>
implements IPSDEFDLogicService {
    private static final Log log = LogFactory.getLog(PSDEFDLogicServiceImpl.class);

    @Override
    public List<PSDEFDLogic> listByPSDEFDLogic(PSDEFDLogic parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEFDLogic get(PSDEFDLogic parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEFDLogic> list = this.listByPSDEFDLogic(parent);
        if (list != null) {
            for (PSDEFDLogic item : list) {
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
    public List<PSDEFDLogicDTO> listDTOByPSDEFDLogic(String strParentKey) throws Exception {
        PSDEFDLogic psdefdlogic = (PSDEFDLogic)PSModelServiceUtil.getInstance().getPSDEFDLogicService().get(strParentKey);
        List<PSDEFDLogic> list = this.listByPSDEFDLogic(psdefdlogic);
        if (list != null) {
            ArrayList<PSDEFDLogicDTO> dtoList = new ArrayList<PSDEFDLogicDTO>();
            for (PSDEFDLogic item : list) {
                PSDEFDLogicDTO dto = (PSDEFDLogicDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSDEFDLogic> listByPSDEFormDetail(PSDEFormDetail parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEFDLogic get(PSDEFormDetail parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEFDLogic> list = this.listByPSDEFormDetail(parent);
        if (list != null) {
            for (PSDEFDLogic item : list) {
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
    public List<PSDEFDLogicDTO> listDTOByPSDEFormDetail(String strParentKey) throws Exception {
        PSDEFormDetail psdeformdetail = (PSDEFormDetail)PSModelServiceUtil.getInstance().getPSDEFormDetailService().get(strParentKey);
        List<PSDEFDLogic> list = this.listByPSDEFormDetail(psdeformdetail);
        if (list != null) {
            ArrayList<PSDEFDLogicDTO> dtoList = new ArrayList<PSDEFDLogicDTO>();
            for (PSDEFDLogic item : list) {
                PSDEFDLogicDTO dto = (PSDEFDLogicDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSDEFDLogic> listByPSDEForm(PSDEForm parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEFDLogic get(PSDEForm parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEFDLogic> list = this.listByPSDEForm(parent);
        if (list != null) {
            for (PSDEFDLogic item : list) {
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
    public List<PSDEFDLogicDTO> listDTOByPSDEForm(String strParentKey) throws Exception {
        PSDEForm psdeform = (PSDEForm)PSModelServiceUtil.getInstance().getPSDEFormService().get(strParentKey);
        List<PSDEFDLogic> list = this.listByPSDEForm(psdeform);
        if (list != null) {
            ArrayList<PSDEFDLogicDTO> dtoList = new ArrayList<PSDEFDLogicDTO>();
            for (PSDEFDLogic item : list) {
                PSDEFDLogicDTO dto = (PSDEFDLogicDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEFDLogic> onListAll() throws Exception {
        ArrayList<PSDEFDLogic> list = new ArrayList<PSDEFDLogic>();
        List<PSDEFormDetail> psdeformdetails = PSModelServiceUtil.getInstance().getPSDEFormDetailService().listAll();
        if (psdeformdetails != null) {
            for (PSDEFormDetail parent : psdeformdetails) {
                List<PSDEFDLogic> items = this.listByPSDEFormDetail(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if (list.size() == 0) {
            return null;
        }
        ArrayList<PSDEFDLogic> alllist = new ArrayList<PSDEFDLogic>();
        alllist.addAll(list);
        for (PSDEFDLogic item : list) {
            List<PSDEFDLogic> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSDEFDLogic> listAllChild(PSDEFDLogic parent) throws Exception {
        List<PSDEFDLogic> list = this.listByPSDEFDLogic(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSDEFDLogic> alllist = new ArrayList<PSDEFDLogic>();
        alllist.addAll(list);
        for (PSDEFDLogic item : list) {
            List<PSDEFDLogic> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSDEFDLogic> listAllByPSDEFormDetail(PSDEFormDetail parent) throws Exception {
        List<PSDEFDLogic> list = this.listByPSDEFormDetail(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSDEFDLogic> alllist = new ArrayList<PSDEFDLogic>();
        alllist.addAll(list);
        for (PSDEFDLogic item : list) {
            List<PSDEFDLogic> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSDEFDLogicDTO> listAllDTOByPSDEFormDetail(String strParentKey) throws Exception {
        PSDEFormDetail psdeformdetail = (PSDEFormDetail)PSModelServiceUtil.getInstance().getPSDEFormDetailService().get(strParentKey);
        List<PSDEFDLogic> list = this.listAllByPSDEFormDetail(psdeformdetail);
        if (list != null) {
            ArrayList<PSDEFDLogicDTO> dtoList = new ArrayList<PSDEFDLogicDTO>();
            for (PSDEFDLogic item : list) {
                PSDEFDLogicDTO dto = (PSDEFDLogicDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSDEFDLogic> listAllByPSDEForm(PSDEForm parent) throws Exception {
        List<PSDEFDLogic> list = this.listByPSDEForm(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSDEFDLogic> alllist = new ArrayList<PSDEFDLogic>();
        alllist.addAll(list);
        for (PSDEFDLogic item : list) {
            List<PSDEFDLogic> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSDEFDLogicDTO> listAllDTOByPSDEForm(String strParentKey) throws Exception {
        PSDEForm psdeform = (PSDEForm)PSModelServiceUtil.getInstance().getPSDEFormService().get(strParentKey);
        List<PSDEFDLogic> list = this.listAllByPSDEForm(psdeform);
        if (list != null) {
            ArrayList<PSDEFDLogicDTO> dtoList = new ArrayList<PSDEFDLogicDTO>();
            for (PSDEFDLogic item : list) {
                PSDEFDLogicDTO dto = (PSDEFDLogicDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected PSDEFDLogic onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEFDLogic item;
        PSDEFDLogic item2;
        PSDEFDLogic psdefdlogic = (PSDEFDLogic)PSModelServiceUtil.getInstance().getPSDEFDLogicService().get(strParentKey, true);
        if (psdefdlogic != null && (item2 = this.get(psdefdlogic, strCurKey, true)) != null) {
            return item2;
        }
        PSDEFormDetail psdeformdetail = (PSDEFormDetail)PSModelServiceUtil.getInstance().getPSDEFormDetailService().get(strParentKey, true);
        if (psdeformdetail != null && (item = this.get(psdeformdetail, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEFDLogic)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEFDLogicDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPPSDEFDLogicId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEFDLogicService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSDEFormDetailId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEFormDetailService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSDEFormId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEFormService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEFDLogic et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEFDLogicDTO dto, PSDEFDLogic t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEFDLogicId(t.getId().replace("/", "."));
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
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getFDName() != null || !bIgnoreNull) {
            dto.setFDName(t.getFDName());
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
        if (t.getPPSDEFDLogicId() != null || !bIgnoreNull) {
            dto.setPPSDEFDLogicId(t.getPPSDEFDLogicId());
        }
        if (t.getPPSDEFDLogicName() != null || !bIgnoreNull) {
            dto.setPPSDEFDLogicName(t.getPPSDEFDLogicName());
        }
        if (t.getPSDBValueOPId() != null || !bIgnoreNull) {
            dto.setPSDBValueOPId(t.getPSDBValueOPId());
        }
        if (t.getPSDBValueOPName() != null || !bIgnoreNull) {
            dto.setPSDBValueOPName(t.getPSDBValueOPName());
        }
        if (t.getPSDEFDLogicName() != null || !bIgnoreNull) {
            dto.setPSDEFDLogicName(t.getPSDEFDLogicName());
        }
        if (t.getPSDEFormDetailId() != null || !bIgnoreNull) {
            dto.setPSDEFormDetailId(t.getPSDEFormDetailId());
        }
        if (t.getPSDEFormDetailName() != null || !bIgnoreNull) {
            dto.setPSDEFormDetailName(t.getPSDEFormDetailName());
        }
        if (t.getPSDEFormId() != null || !bIgnoreNull) {
            dto.setPSDEFormId(t.getPSDEFormId());
        }
        if (t.getPSDEFormName() != null || !bIgnoreNull) {
            dto.setPSDEFormName(t.getPSDEFormName());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (StringUtils.hasLength((String)dto.getPPSDEFDLogicId())) {
            dto.setPPSDEFDLogicId(this.getRealPSModelId(t, dto.getPPSDEFDLogicId()).replace("/", "."));
        }
        if ("PSDEFDLOGIC".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPPSDEFDLogicId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFormDetailId())) {
            dto.setPSDEFormDetailId(this.getRealPSModelId(t, dto.getPSDEFormDetailId()).replace("/", "."));
        }
        if ("PSDEFORMDETAIL".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEFormDetailId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFormId())) {
            dto.setPSDEFormId(this.getRealPSModelId(t, dto.getPSDEFormId()).replace("/", "."));
        }
        if ("PSDEFORM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEFormId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPPSDEFDLogicId())) {
            linkDTO = (PSDEFDLogicDTO)PSModelServiceUtil.getInstance().getPSDEFDLogicService().getDTO(dto.getPPSDEFDLogicId());
            dto.setPPSDEFDLogicName(((PSDEFDLogicDTO)linkDTO).getPSDEFDLogicName());
        } else {
            dto.setPPSDEFDLogicName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFormDetailId())) {
            linkDTO = (PSDEFormDetailDTO)PSModelServiceUtil.getInstance().getPSDEFormDetailService().getDTO(dto.getPSDEFormDetailId(), true);
            if (linkDTO != null) {
                dto.setPSDEFormDetailName(((PSDEFormDetailDTO)linkDTO).getPSDEFormDetailName());
            }
        } else {
            dto.setPSDEFormDetailName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFormId())) {
            linkDTO = (PSDEFormDTO)PSModelServiceUtil.getInstance().getPSDEFormService().getDTO(dto.getPSDEFormId());
            dto.setPSDEFormName(((PSDEFormDTO)linkDTO).getPSDEFormName());
        } else {
            dto.setPSDEFormName(null);
        }
        List<PSDEFDLogic> list = PSModelServiceUtil.getInstance().getPSDEFDLogicService().listByPSDEFDLogic(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSDEFDLogicDTO> psdefdlogics = new ArrayList<PSDEFDLogicDTO>();
            for (PSDEFDLogic item : list) {
                PSDEFDLogicDTO dstItem = (PSDEFDLogicDTO)PSModelServiceUtil.getInstance().getPSDEFDLogicService().toDTO(item);
                psdefdlogics.add(dstItem);
            }
            dto.setPsdefdlogics(psdefdlogics);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEFDLOGIC";
    }

    @Override
    public PSDEFDLogic createDomain() {
        return new PSDEFDLogic();
    }

    @Override
    public PSDEFDLogicDTO createDTO() {
        return new PSDEFDLogicDTO();
    }
}

