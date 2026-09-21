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
import net.ibizsys.modelapi.domain.PSSysCounter;
import net.ibizsys.modelapi.domain.PSSysCounterItem;
import net.ibizsys.modelapi.dto.PSSysCounterDTO;
import net.ibizsys.modelapi.dto.PSSysCounterItemDTO;
import net.ibizsys.modelapi.service.IPSSysCounterItemService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysCounterItemServiceImpl
extends PSModelServiceImplBase<PSSysCounterItem, PSSysCounterItemDTO>
implements IPSSysCounterItemService {
    private static final Log log = LogFactory.getLog(PSSysCounterItemServiceImpl.class);

    @Override
    public List<PSSysCounterItem> listByPSSysCounter(PSSysCounter parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysCounterItem get(PSSysCounter parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysCounterItem> list = this.listByPSSysCounter(parent);
        if (list != null) {
            for (PSSysCounterItem item : list) {
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
    public List<PSSysCounterItemDTO> listDTOByPSSysCounter(String strParentKey) throws Exception {
        PSSysCounter pssyscounter = (PSSysCounter)PSModelServiceUtil.getInstance().getPSSysCounterService().get(strParentKey);
        List<PSSysCounterItem> list = this.listByPSSysCounter(pssyscounter);
        if (list != null) {
            ArrayList<PSSysCounterItemDTO> dtoList = new ArrayList<PSSysCounterItemDTO>();
            for (PSSysCounterItem item : list) {
                PSSysCounterItemDTO dto = (PSSysCounterItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysCounterItem> onListAll() throws Exception {
        ArrayList<PSSysCounterItem> list = new ArrayList<PSSysCounterItem>();
        List pssyscounters = PSModelServiceUtil.getInstance().getPSSysCounterService().listAll();
        if (pssyscounters != null) {
            for (PSSysCounter parent : pssyscounters) {
                List<PSSysCounterItem> items = this.listByPSSysCounter(parent);
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
    protected PSSysCounterItem onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysCounterItem item;
        PSSysCounter pssyscounter = (PSSysCounter)PSModelServiceUtil.getInstance().getPSSysCounterService().get(strParentKey, true);
        if (pssyscounter != null && (item = this.get(pssyscounter, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysCounterItem)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysCounterItemDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysCounterId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysCounterService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysCounterItem et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSSysCounterItemName())) {
            return et.getPSSysCounterItemName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysCounterItemDTO dto, PSSysCounterItem t, boolean bIgnoreNull) throws Exception {
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysCounterItemId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getLogicName() != null || !bIgnoreNull) {
            dto.setLogicName(t.getLogicName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSSysCounterId() != null || !bIgnoreNull) {
            dto.setPSSysCounterId(t.getPSSysCounterId());
        }
        if (t.getPSSysCounterItemName() != null || !bIgnoreNull) {
            dto.setPSSysCounterItemName(t.getPSSysCounterItemName());
        }
        if (t.getPSSysCounterName() != null || !bIgnoreNull) {
            dto.setPSSysCounterName(t.getPSSysCounterName());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (StringUtils.hasLength((String)dto.getPSSysCounterId())) {
            dto.setPSSysCounterId(this.getRealPSModelId(t, dto.getPSSysCounterId()).replace("/", "."));
        }
        if ("PSSYSCOUNTER".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysCounterId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysCounterId())) {
            PSSysCounterDTO linkDTO = (PSSysCounterDTO)PSModelServiceUtil.getInstance().getPSSysCounterService().getDTO(dto.getPSSysCounterId());
            dto.setPSSysCounterName(linkDTO.getPSSysCounterName());
        } else {
            dto.setPSSysCounterName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSYSCOUNTERITEM";
    }

    @Override
    public PSSysCounterItem createDomain() {
        return new PSSysCounterItem();
    }

    @Override
    public PSSysCounterItemDTO createDTO() {
        return new PSSysCounterItemDTO();
    }
}

