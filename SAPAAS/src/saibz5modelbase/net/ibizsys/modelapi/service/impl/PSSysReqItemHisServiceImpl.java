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
import net.ibizsys.modelapi.domain.PSSysReqItem;
import net.ibizsys.modelapi.domain.PSSysReqItemHis;
import net.ibizsys.modelapi.dto.PSSysReqItemDTO;
import net.ibizsys.modelapi.dto.PSSysReqItemHisDTO;
import net.ibizsys.modelapi.service.IPSSysReqItemHisService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysReqItemHisServiceImpl
extends PSModelServiceImplBase<PSSysReqItemHis, PSSysReqItemHisDTO>
implements IPSSysReqItemHisService {
    private static final Log log = LogFactory.getLog(PSSysReqItemHisServiceImpl.class);

    @Override
    public List<PSSysReqItemHis> listByPSSysReqItem(PSSysReqItem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysReqItemHis get(PSSysReqItem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysReqItemHis> list = this.listByPSSysReqItem(parent);
        if (list != null) {
            for (PSSysReqItemHis item : list) {
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
    public List<PSSysReqItemHisDTO> listDTOByPSSysReqItem(String strParentKey) throws Exception {
        PSSysReqItem pssysreqitem = (PSSysReqItem)PSModelServiceUtil.getInstance().getPSSysReqItemService().get(strParentKey);
        List<PSSysReqItemHis> list = this.listByPSSysReqItem(pssysreqitem);
        if (list != null) {
            ArrayList<PSSysReqItemHisDTO> dtoList = new ArrayList<PSSysReqItemHisDTO>();
            for (PSSysReqItemHis item : list) {
                PSSysReqItemHisDTO dto = (PSSysReqItemHisDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysReqItemHis> onListAll() throws Exception {
        ArrayList<PSSysReqItemHis> list = new ArrayList<PSSysReqItemHis>();
        List pssysreqitems = PSModelServiceUtil.getInstance().getPSSysReqItemService().listAll();
        if (pssysreqitems != null) {
            for (PSSysReqItem parent : pssysreqitems) {
                List<PSSysReqItemHis> items = this.listByPSSysReqItem(parent);
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
    protected PSSysReqItemHis onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysReqItemHis item;
        PSSysReqItem pssysreqitem = (PSSysReqItem)PSModelServiceUtil.getInstance().getPSSysReqItemService().get(strParentKey, true);
        if (pssysreqitem != null && (item = this.get(pssysreqitem, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysReqItemHis)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysReqItemHisDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysReqItemId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysReqItemService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysReqItemHis et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysReqItemHisDTO dto, PSSysReqItemHis t, boolean bIgnoreNull) throws Exception {
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysReqItemHisId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getItemTag() != null || !bIgnoreNull) {
            dto.setItemTag(t.getItemTag());
        }
        if (t.getItemTag2() != null || !bIgnoreNull) {
            dto.setItemTag2(t.getItemTag2());
        }
        if (t.getPSSysReqItemHisName() != null || !bIgnoreNull) {
            dto.setPSSysReqItemHisName(t.getPSSysReqItemHisName());
        }
        if (t.getPSSysReqItemId() != null || !bIgnoreNull) {
            dto.setPSSysReqItemId(t.getPSSysReqItemId());
        }
        if (t.getPSSysReqItemName() != null || !bIgnoreNull) {
            dto.setPSSysReqItemName(t.getPSSysReqItemName());
        }
        if (t.getReqContent() != null || !bIgnoreNull) {
            dto.setReqContent(t.getReqContent());
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
        if (t.getVer() != null || !bIgnoreNull) {
            dto.setVer(t.getVer());
        }
        if (StringUtils.hasLength((String)dto.getPSSysReqItemId())) {
            dto.setPSSysReqItemId(this.getRealPSModelId(t, dto.getPSSysReqItemId()).replace("/", "."));
        }
        if ("PSSYSREQITEM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysReqItemId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysReqItemId())) {
            PSSysReqItemDTO linkDTO = (PSSysReqItemDTO)PSModelServiceUtil.getInstance().getPSSysReqItemService().getDTO(dto.getPSSysReqItemId());
            dto.setPSSysReqItemName(linkDTO.getPSSysReqItemName());
        } else {
            dto.setPSSysReqItemName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSYSREQITEMHIS";
    }

    @Override
    public PSSysReqItemHis createDomain() {
        return new PSSysReqItemHis();
    }

    @Override
    public PSSysReqItemHisDTO createDTO() {
        return new PSSysReqItemHisDTO();
    }
}

