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
import net.ibizsys.modelapi.domain.PSSysReqItemData;
import net.ibizsys.modelapi.dto.PSSysReqItemDTO;
import net.ibizsys.modelapi.dto.PSSysReqItemDataDTO;
import net.ibizsys.modelapi.service.IPSSysReqItemDataService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysReqItemDataServiceImpl
extends PSModelServiceImplBase<PSSysReqItemData, PSSysReqItemDataDTO>
implements IPSSysReqItemDataService {
    private static final Log log = LogFactory.getLog(PSSysReqItemDataServiceImpl.class);

    @Override
    public List<PSSysReqItemData> listByPSSysReqItem(PSSysReqItem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysReqItemData get(PSSysReqItem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysReqItemData> list = this.listByPSSysReqItem(parent);
        if (list != null) {
            for (PSSysReqItemData item : list) {
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
    public List<PSSysReqItemDataDTO> listDTOByPSSysReqItem(String strParentKey) throws Exception {
        PSSysReqItem pssysreqitem = (PSSysReqItem)PSModelServiceUtil.getInstance().getPSSysReqItemService().get(strParentKey);
        List<PSSysReqItemData> list = this.listByPSSysReqItem(pssysreqitem);
        if (list != null) {
            ArrayList<PSSysReqItemDataDTO> dtoList = new ArrayList<PSSysReqItemDataDTO>();
            for (PSSysReqItemData item : list) {
                PSSysReqItemDataDTO dto = (PSSysReqItemDataDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysReqItemData> onListAll() throws Exception {
        ArrayList<PSSysReqItemData> list = new ArrayList<PSSysReqItemData>();
        List pssysreqitems = PSModelServiceUtil.getInstance().getPSSysReqItemService().listAll();
        if (pssysreqitems != null) {
            for (PSSysReqItem parent : pssysreqitems) {
                List<PSSysReqItemData> items = this.listByPSSysReqItem(parent);
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
    protected PSSysReqItemData onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysReqItemData item;
        PSSysReqItem pssysreqitem = (PSSysReqItem)PSModelServiceUtil.getInstance().getPSSysReqItemService().get(strParentKey, true);
        if (pssysreqitem != null && (item = this.get(pssysreqitem, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysReqItemData)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysReqItemDataDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysReqItemId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysReqItemService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysReqItemData et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysReqItemDataDTO dto, PSSysReqItemData t, boolean bIgnoreNull) throws Exception {
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysReqItemDataId(t.getId().replace("/", "."));
        }
        if (t.getContent() != null || !bIgnoreNull) {
            dto.setContent(t.getContent());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getPSSysReqItemDataName() != null || !bIgnoreNull) {
            dto.setPSSysReqItemDataName(t.getPSSysReqItemDataName());
        }
        if (t.getPSSysReqItemId() != null || !bIgnoreNull) {
            dto.setPSSysReqItemId(t.getPSSysReqItemId());
        }
        if (t.getPSSysReqItemName() != null || !bIgnoreNull) {
            dto.setPSSysReqItemName(t.getPSSysReqItemName());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
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
        return "PSSYSREQITEMDATA";
    }

    @Override
    public PSSysReqItemData createDomain() {
        return new PSSysReqItemData();
    }

    @Override
    public PSSysReqItemDataDTO createDTO() {
        return new PSSysReqItemDataDTO();
    }
}

