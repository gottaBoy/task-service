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
import net.ibizsys.modelapi.domain.PSDEDQCond;
import net.ibizsys.modelapi.domain.PSDEDQJoin;
import net.ibizsys.modelapi.dto.PSDEDQCondDTO;
import net.ibizsys.modelapi.dto.PSDEDQJoinDTO;
import net.ibizsys.modelapi.dto.PSDEDataQueryDTO;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSSysDBVFDTO;
import net.ibizsys.modelapi.service.IPSDEDQCondService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEDQCondServiceImpl
extends PSModelServiceImplBase<PSDEDQCond, PSDEDQCondDTO>
implements IPSDEDQCondService {
    private static final Log log = LogFactory.getLog(PSDEDQCondServiceImpl.class);

    @Override
    public List<PSDEDQCond> listByPSDEDQCond(PSDEDQCond parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEDQCond get(PSDEDQCond parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEDQCond> list = this.listByPSDEDQCond(parent);
        if (list != null) {
            for (PSDEDQCond item : list) {
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
    public List<PSDEDQCondDTO> listDTOByPSDEDQCond(String strParentKey) throws Exception {
        PSDEDQCond psdedqcond = (PSDEDQCond)PSModelServiceUtil.getInstance().getPSDEDQCondService().get(strParentKey);
        List<PSDEDQCond> list = this.listByPSDEDQCond(psdedqcond);
        if (list != null) {
            ArrayList<PSDEDQCondDTO> dtoList = new ArrayList<PSDEDQCondDTO>();
            for (PSDEDQCond item : list) {
                PSDEDQCondDTO dto = (PSDEDQCondDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSDEDQCond> listByPSDEDQJoin(PSDEDQJoin parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEDQCond get(PSDEDQJoin parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEDQCond> list = this.listByPSDEDQJoin(parent);
        if (list != null) {
            for (PSDEDQCond item : list) {
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
    public List<PSDEDQCondDTO> listDTOByPSDEDQJoin(String strParentKey) throws Exception {
        PSDEDQJoin psdedqjoin = (PSDEDQJoin)PSModelServiceUtil.getInstance().getPSDEDQJoinService().get(strParentKey);
        List<PSDEDQCond> list = this.listByPSDEDQJoin(psdedqjoin);
        if (list != null) {
            ArrayList<PSDEDQCondDTO> dtoList = new ArrayList<PSDEDQCondDTO>();
            for (PSDEDQCond item : list) {
                PSDEDQCondDTO dto = (PSDEDQCondDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEDQCond> onListAll() throws Exception {
        ArrayList<PSDEDQCond> list = new ArrayList<PSDEDQCond>();
        List psdedqjoins = PSModelServiceUtil.getInstance().getPSDEDQJoinService().listAll();
        if (psdedqjoins != null) {
            for (PSDEDQJoin parent : psdedqjoins) {
                List<PSDEDQCond> items = this.listByPSDEDQJoin(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if (list.size() == 0) {
            return null;
        }
        ArrayList<PSDEDQCond> alllist = new ArrayList<PSDEDQCond>();
        alllist.addAll(list);
        for (PSDEDQCond item : list) {
            List<PSDEDQCond> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSDEDQCond> listAllChild(PSDEDQCond parent) throws Exception {
        List<PSDEDQCond> list = this.listByPSDEDQCond(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSDEDQCond> alllist = new ArrayList<PSDEDQCond>();
        alllist.addAll(list);
        for (PSDEDQCond item : list) {
            List<PSDEDQCond> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSDEDQCond> listAllByPSDEDQJoin(PSDEDQJoin parent) throws Exception {
        List<PSDEDQCond> list = this.listByPSDEDQJoin(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSDEDQCond> alllist = new ArrayList<PSDEDQCond>();
        alllist.addAll(list);
        for (PSDEDQCond item : list) {
            List<PSDEDQCond> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSDEDQCondDTO> listAllDTOByPSDEDQJoin(String strParentKey) throws Exception {
        PSDEDQJoin psdedqjoin = (PSDEDQJoin)PSModelServiceUtil.getInstance().getPSDEDQJoinService().get(strParentKey);
        List<PSDEDQCond> list = this.listAllByPSDEDQJoin(psdedqjoin);
        if (list != null) {
            ArrayList<PSDEDQCondDTO> dtoList = new ArrayList<PSDEDQCondDTO>();
            for (PSDEDQCond item : list) {
                PSDEDQCondDTO dto = (PSDEDQCondDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected PSDEDQCond onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEDQCond item;
        PSDEDQCond item2;
        PSDEDQCond psdedqcond = (PSDEDQCond)PSModelServiceUtil.getInstance().getPSDEDQCondService().get(strParentKey, true);
        if (psdedqcond != null && (item2 = this.get(psdedqcond, strCurKey, true)) != null) {
            return item2;
        }
        PSDEDQJoin psdedqjoin = (PSDEDQJoin)PSModelServiceUtil.getInstance().getPSDEDQJoinService().get(strParentKey, true);
        if (psdedqjoin != null && (item = this.get(psdedqjoin, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEDQCond)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEDQCondDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPPSDEDQCondId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEDQCondService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSDEDQJoinId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEDQJoinService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEDQCond et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEDQCondDTO dto, PSDEDQCond t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEDQCondId(t.getId().replace("/", "."));
        }
        if (t.getCondType() != null || !bIgnoreNull) {
            dto.setCondType(t.getCondType());
        }
        if (t.getCondValue() != null || !bIgnoreNull) {
            dto.setCondValue(t.getCondValue());
        }
        if (t.getCondValueText() != null || !bIgnoreNull) {
            dto.setCondValueText(t.getCondValueText());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getCustomCond() != null || !bIgnoreNull) {
            dto.setCustomCond(t.getCustomCond());
        }
        if (t.getCustomType() != null || !bIgnoreNull) {
            dto.setCustomType(t.getCustomType());
        }
        if (t.getGroupNotFlag() != null || !bIgnoreNull) {
            dto.setGroupNotFlag(t.getGroupNotFlag());
        }
        if (t.getGroupOP() != null || !bIgnoreNull) {
            dto.setGroupOP(t.getGroupOP());
        }
        if (t.getIgnoreEmpty() != null || !bIgnoreNull) {
            dto.setIgnoreEmpty(t.getIgnoreEmpty());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPPSDEDQCondId() != null || !bIgnoreNull) {
            dto.setPPSDEDQCondId(t.getPPSDEDQCondId());
        }
        if (t.getPPSDEDQCondName() != null || !bIgnoreNull) {
            dto.setPPSDEDQCondName(t.getPPSDEDQCondName());
        }
        if (t.getPSDBValueOPId() != null || !bIgnoreNull) {
            dto.setPSDBValueOPId(t.getPSDBValueOPId());
        }
        if (t.getPSDBValueOPName() != null || !bIgnoreNull) {
            dto.setPSDBValueOPName(t.getPSDBValueOPName());
        }
        if (t.getPSDEDQCondName() != null || !bIgnoreNull) {
            dto.setPSDEDQCondName(t.getPSDEDQCondName());
        }
        if (t.getPSDEDQId() != null || !bIgnoreNull) {
            dto.setPSDEDQId(t.getPSDEDQId());
        }
        if (t.getPSDEDQJoinId() != null || !bIgnoreNull) {
            dto.setPSDEDQJoinId(t.getPSDEDQJoinId());
        }
        if (t.getPSDEDQJoinName() != null || !bIgnoreNull) {
            dto.setPSDEDQJoinName(t.getPSDEDQJoinName());
        }
        if (t.getPSDEDQName() != null || !bIgnoreNull) {
            dto.setPSDEDQName(t.getPSDEDQName());
        }
        if (t.getPSDEDQPDCondId() != null || !bIgnoreNull) {
            dto.setPSDEDQPDCondId(t.getPSDEDQPDCondId());
        }
        if (t.getPSDEDQPDCondName() != null || !bIgnoreNull) {
            dto.setPSDEDQPDCondName(t.getPSDEDQPDCondName());
        }
        if (t.getPSDEFId() != null || !bIgnoreNull) {
            dto.setPSDEFId(t.getPSDEFId());
        }
        if (t.getPSDEFName() != null || !bIgnoreNull) {
            dto.setPSDEFName(t.getPSDEFName());
        }
        if (t.getPSSysDBVFId() != null || !bIgnoreNull) {
            dto.setPSSysDBVFId(t.getPSSysDBVFId());
        }
        if (t.getPSSysDBVFName() != null || !bIgnoreNull) {
            dto.setPSSysDBVFName(t.getPSSysDBVFName());
        }
        if (t.getPSVARTypeId() != null || !bIgnoreNull) {
            dto.setPSVARTypeId(t.getPSVARTypeId());
        }
        if (t.getPSVARTypeName() != null || !bIgnoreNull) {
            dto.setPSVARTypeName(t.getPSVARTypeName());
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
        if (StringUtils.hasLength((String)dto.getPPSDEDQCondId())) {
            dto.setPPSDEDQCondId(this.getRealPSModelId(t, dto.getPPSDEDQCondId()).replace("/", "."));
        }
        if ("PSDEDQCOND".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPPSDEDQCondId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDQId())) {
            dto.setPSDEDQId(this.getRealPSModelId(t, dto.getPSDEDQId()).replace("/", "."));
        } else {
            dto.setPSDEDQId(this.getRealPSModelId(t, "<PSDEDATAQUERY>").replace("/", "."));
        }
        if ("PSDEDATAQUERY".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEDQId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDQJoinId())) {
            dto.setPSDEDQJoinId(this.getRealPSModelId(t, dto.getPSDEDQJoinId()).replace("/", "."));
        }
        if ("PSDEDQJOIN".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEDQJoinId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            dto.setPSDEFId(this.getRealPSModelId(t, dto.getPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDBVFId())) {
            dto.setPSSysDBVFId(this.getRealPSModelId(t, dto.getPSSysDBVFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPPSDEDQCondId())) {
            linkDTO = (PSDEDQCondDTO)PSModelServiceUtil.getInstance().getPSDEDQCondService().getDTO(dto.getPPSDEDQCondId(), true);
            if (linkDTO != null) {
                dto.setPPSDEDQCondName(((PSDEDQCondDTO)linkDTO).getPSDEDQCondName());
            }
        } else {
            dto.setPPSDEDQCondName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEDQId())) {
            linkDTO = (PSDEDataQueryDTO)PSModelServiceUtil.getInstance().getPSDEDataQueryService().getDTO(dto.getPSDEDQId(), true);
            if (linkDTO != null) {
                dto.setPSDEDQName(((PSDEDataQueryDTO)linkDTO).getPSDEDataQueryName());
            }
        } else {
            dto.setPSDEDQName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEDQJoinId())) {
            linkDTO = (PSDEDQJoinDTO)PSModelServiceUtil.getInstance().getPSDEDQJoinService().getDTO(dto.getPSDEDQJoinId(), true);
            if (linkDTO != null) {
                dto.setPSDEDQJoinName(((PSDEDQJoinDTO)linkDTO).getPSDEDQJoinName());
            }
        } else {
            dto.setPSDEDQJoinName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getPSDEFId());
            dto.setPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDBVFId())) {
            linkDTO = (PSSysDBVFDTO)PSModelServiceUtil.getInstance().getPSSysDBVFService().getDTO(dto.getPSSysDBVFId());
            dto.setPSSysDBVFName(((PSSysDBVFDTO)linkDTO).getPSSysDBVFName());
        } else {
            dto.setPSSysDBVFName(null);
        }
        List<PSDEDQCond> list = PSModelServiceUtil.getInstance().getPSDEDQCondService().listByPSDEDQCond(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSDEDQCondDTO> psdedqconds = new ArrayList<PSDEDQCondDTO>();
            for (PSDEDQCond item : list) {
                PSDEDQCondDTO dstItem = (PSDEDQCondDTO)PSModelServiceUtil.getInstance().getPSDEDQCondService().toDTO(item);
                psdedqconds.add(dstItem);
            }
            dto.setPsdedqconds(psdedqconds);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEDQCOND";
    }

    @Override
    public PSDEDQCond createDomain() {
        return new PSDEDQCond();
    }

    @Override
    public PSDEDQCondDTO createDTO() {
        return new PSDEDQCondDTO();
    }
}

