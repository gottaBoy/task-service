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
import net.ibizsys.modelapi.domain.PSDEDataQuery;
import net.ibizsys.modelapi.dto.PSDEDQCondDTO;
import net.ibizsys.modelapi.dto.PSDEDQJoinDTO;
import net.ibizsys.modelapi.dto.PSDEDataQueryDTO;
import net.ibizsys.modelapi.dto.PSDERDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.service.IPSDEDQJoinService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEDQJoinServiceImpl
extends PSModelServiceImplBase<PSDEDQJoin, PSDEDQJoinDTO>
implements IPSDEDQJoinService {
    private static final Log log = LogFactory.getLog(PSDEDQJoinServiceImpl.class);

    @Override
    public List<PSDEDQJoin> listByPSDEDQJoin(PSDEDQJoin parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEDQJoin get(PSDEDQJoin parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEDQJoin> list = this.listByPSDEDQJoin(parent);
        if (list != null) {
            for (PSDEDQJoin item : list) {
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
    public List<PSDEDQJoinDTO> listDTOByPSDEDQJoin(String strParentKey) throws Exception {
        PSDEDQJoin psdedqjoin = (PSDEDQJoin)PSModelServiceUtil.getInstance().getPSDEDQJoinService().get(strParentKey);
        List<PSDEDQJoin> list = this.listByPSDEDQJoin(psdedqjoin);
        if (list != null) {
            ArrayList<PSDEDQJoinDTO> dtoList = new ArrayList<PSDEDQJoinDTO>();
            for (PSDEDQJoin item : list) {
                PSDEDQJoinDTO dto = (PSDEDQJoinDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSDEDQJoin> listByPSDEDataQuery(PSDEDataQuery parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEDQJoin get(PSDEDataQuery parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEDQJoin> list = this.listByPSDEDataQuery(parent);
        if (list != null) {
            for (PSDEDQJoin item : list) {
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
    public List<PSDEDQJoinDTO> listDTOByPSDEDataQuery(String strParentKey) throws Exception {
        PSDEDataQuery psdedataquery = (PSDEDataQuery)PSModelServiceUtil.getInstance().getPSDEDataQueryService().get(strParentKey);
        List<PSDEDQJoin> list = this.listByPSDEDataQuery(psdedataquery);
        if (list != null) {
            ArrayList<PSDEDQJoinDTO> dtoList = new ArrayList<PSDEDQJoinDTO>();
            for (PSDEDQJoin item : list) {
                PSDEDQJoinDTO dto = (PSDEDQJoinDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEDQJoin> onListAll() throws Exception {
        ArrayList<PSDEDQJoin> list = new ArrayList<PSDEDQJoin>();
        List<PSDEDataQuery> psdedataqueries = PSModelServiceUtil.getInstance().getPSDEDataQueryService().listAll();
        if (psdedataqueries != null) {
            for (PSDEDataQuery parent : psdedataqueries) {
                List<PSDEDQJoin> items = this.listByPSDEDataQuery(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if (list.size() == 0) {
            return null;
        }
        ArrayList<PSDEDQJoin> alllist = new ArrayList<PSDEDQJoin>();
        alllist.addAll(list);
        for (PSDEDQJoin item : list) {
            List<PSDEDQJoin> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSDEDQJoin> listAllChild(PSDEDQJoin parent) throws Exception {
        List<PSDEDQJoin> list = this.listByPSDEDQJoin(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSDEDQJoin> alllist = new ArrayList<PSDEDQJoin>();
        alllist.addAll(list);
        for (PSDEDQJoin item : list) {
            List<PSDEDQJoin> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSDEDQJoin> listAllByPSDEDataQuery(PSDEDataQuery parent) throws Exception {
        List<PSDEDQJoin> list = this.listByPSDEDataQuery(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSDEDQJoin> alllist = new ArrayList<PSDEDQJoin>();
        alllist.addAll(list);
        for (PSDEDQJoin item : list) {
            List<PSDEDQJoin> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSDEDQJoinDTO> listAllDTOByPSDEDataQuery(String strParentKey) throws Exception {
        PSDEDataQuery psdedataquery = (PSDEDataQuery)PSModelServiceUtil.getInstance().getPSDEDataQueryService().get(strParentKey);
        List<PSDEDQJoin> list = this.listAllByPSDEDataQuery(psdedataquery);
        if (list != null) {
            ArrayList<PSDEDQJoinDTO> dtoList = new ArrayList<PSDEDQJoinDTO>();
            for (PSDEDQJoin item : list) {
                PSDEDQJoinDTO dto = (PSDEDQJoinDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected PSDEDQJoin onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEDQJoin item;
        PSDEDQJoin item2;
        PSDEDQJoin psdedqjoin = (PSDEDQJoin)PSModelServiceUtil.getInstance().getPSDEDQJoinService().get(strParentKey, true);
        if (psdedqjoin != null && (item2 = this.get(psdedqjoin, strCurKey, true)) != null) {
            return item2;
        }
        PSDEDataQuery psdedataquery = (PSDEDataQuery)PSModelServiceUtil.getInstance().getPSDEDataQueryService().get(strParentKey, true);
        if (psdedataquery != null && (item = this.get(psdedataquery, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEDQJoin)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEDQJoinDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPPSDEDQJoinId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEDQJoinService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSDEDQId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEDataQueryService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEDQJoin et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEDQJoinDTO dto, PSDEDQJoin t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase dstItem;
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEDQJoinId(t.getId().replace("/", "."));
        }
        if (t.getAliasName() != null || !bIgnoreNull) {
            dto.setAliasName(t.getAliasName());
        }
        if (t.getCondFlag() != null || !bIgnoreNull) {
            dto.setCondFlag(t.getCondFlag());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getExtColumns() != null || !bIgnoreNull) {
            dto.setExtColumns(t.getExtColumns());
        }
        if (t.getJoinPSDEId() != null || !bIgnoreNull) {
            dto.setJoinPSDEId(t.getJoinPSDEId());
        }
        if (t.getJoinPSDEName() != null || !bIgnoreNull) {
            dto.setJoinPSDEName(t.getJoinPSDEName());
        }
        if (t.getJoinTag() != null || !bIgnoreNull) {
            dto.setJoinTag(t.getJoinTag());
        }
        if (t.getJoinTag2() != null || !bIgnoreNull) {
            dto.setJoinTag2(t.getJoinTag2());
        }
        if (t.getMainFlag() != null || !bIgnoreNull) {
            dto.setMainFlag(t.getMainFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getModelState() != null || !bIgnoreNull) {
            dto.setModelState(t.getModelState());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPJoinPSDEId() != null || !bIgnoreNull) {
            dto.setPJoinPSDEId(t.getPJoinPSDEId());
        }
        if (t.getPPSDEDQJoinId() != null || !bIgnoreNull) {
            dto.setPPSDEDQJoinId(t.getPPSDEDQJoinId());
        }
        if (t.getPPSDEDQJoinName() != null || !bIgnoreNull) {
            dto.setPPSDEDQJoinName(t.getPPSDEDQJoinName());
        }
        if (t.getPSDEDQId() != null || !bIgnoreNull) {
            dto.setPSDEDQId(t.getPSDEDQId());
        }
        if (t.getPSDEDQJoinName() != null || !bIgnoreNull) {
            dto.setPSDEDQJoinName(t.getPSDEDQJoinName());
        }
        if (t.getPSDEDQName() != null || !bIgnoreNull) {
            dto.setPSDEDQName(t.getPSDEDQName());
        }
        if (t.getPSDEJoinTypeId() != null || !bIgnoreNull) {
            dto.setPSDEJoinTypeId(t.getPSDEJoinTypeId());
        }
        if (t.getPSDEJoinTypeName() != null || !bIgnoreNull) {
            dto.setPSDEJoinTypeName(t.getPSDEJoinTypeName());
        }
        if (t.getPSDERId() != null || !bIgnoreNull) {
            dto.setPSDERId(t.getPSDERId());
        }
        if (t.getPSDERName() != null || !bIgnoreNull) {
            dto.setPSDERName(t.getPSDERName());
        }
        if (t.getQueryViewFlag() != null || !bIgnoreNull) {
            dto.setQueryViewFlag(t.getQueryViewFlag());
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
        if (StringUtils.hasLength((String)dto.getJoinPSDEId())) {
            dto.setJoinPSDEId(this.getRealPSModelId(t, dto.getJoinPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPPSDEDQJoinId())) {
            dto.setPPSDEDQJoinId(this.getRealPSModelId(t, dto.getPPSDEDQJoinId()).replace("/", "."));
        }
        if ("PSDEDQJOIN".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPPSDEDQJoinId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDQId())) {
            dto.setPSDEDQId(this.getRealPSModelId(t, dto.getPSDEDQId()).replace("/", "."));
        }
        if ("PSDEDATAQUERY".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEDQId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDERId())) {
            dto.setPSDERId(this.getRealPSModelId(t, dto.getPSDERId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getJoinPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getJoinPSDEId());
            dto.setJoinPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setJoinPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPPSDEDQJoinId())) {
            linkDTO = (PSDEDQJoinDTO)PSModelServiceUtil.getInstance().getPSDEDQJoinService().getDTO(dto.getPPSDEDQJoinId(), true);
            if (linkDTO != null) {
                dto.setPJoinPSDEId(((PSDEDQJoinDTO)linkDTO).getJoinPSDEId());
                dto.setPPSDEDQJoinName(((PSDEDQJoinDTO)linkDTO).getPSDEDQJoinName());
            }
        } else {
            dto.setPJoinPSDEId(null);
            dto.setPPSDEDQJoinName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEDQId())) {
            linkDTO = (PSDEDataQueryDTO)PSModelServiceUtil.getInstance().getPSDEDataQueryService().getDTO(dto.getPSDEDQId(), true);
            if (linkDTO != null) {
                dto.setPSDEDQName(((PSDEDataQueryDTO)linkDTO).getPSDEDataQueryName());
            }
        } else {
            dto.setPSDEDQName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDERId())) {
            linkDTO = (PSDERDTO)PSModelServiceUtil.getInstance().getPSDERService().getDTO(dto.getPSDERId());
            dto.setPSDERName(((PSDERDTO)linkDTO).getPSDERName());
        } else {
            dto.setPSDERName(null);
        }
        List<PSDEDQJoin> pSDEDQJoinList = PSModelServiceUtil.getInstance().getPSDEDQJoinService().listByPSDEDQJoin(t);
        if (pSDEDQJoinList != null && pSDEDQJoinList.size() > 0) {
            ArrayList<PSDEDQJoinDTO> psdedqjoins = new ArrayList<PSDEDQJoinDTO>();
            for (PSDEDQJoin pSDEDQJoin : pSDEDQJoinList) {
                dstItem = (PSDEDQJoinDTO)PSModelServiceUtil.getInstance().getPSDEDQJoinService().toDTO(pSDEDQJoin);
                psdedqjoins.add((PSDEDQJoinDTO)dstItem);
            }
            dto.setPsdedqjoins(psdedqjoins);
        }
        List<PSDEDQCond> pSDEDQCondList = PSModelServiceUtil.getInstance().getPSDEDQCondService().listByPSDEDQJoin(t);
        if (pSDEDQCondList != null && pSDEDQCondList.size() > 0) {
            ArrayList<PSDEDQCondDTO> psdedqconds = new ArrayList<PSDEDQCondDTO>();
            for (PSDEDQCond pSDEDQCond : pSDEDQCondList) {
                dstItem = (PSDEDQCondDTO)PSModelServiceUtil.getInstance().getPSDEDQCondService().toDTO(pSDEDQCond);
                psdedqconds.add((PSDEDQCondDTO)dstItem);
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
        return "PSDEDQJOIN";
    }

    @Override
    public PSDEDQJoin createDomain() {
        return new PSDEDQJoin();
    }

    @Override
    public PSDEDQJoinDTO createDTO() {
        return new PSDEDQJoinDTO();
    }
}

