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
import net.ibizsys.modelapi.domain.PSSysCalendarItem;
import net.ibizsys.modelapi.domain.PSSysCalendarItemRV;
import net.ibizsys.modelapi.dto.PSDEViewBaseDTO;
import net.ibizsys.modelapi.dto.PSSysCalendarItemDTO;
import net.ibizsys.modelapi.dto.PSSysCalendarItemRVDTO;
import net.ibizsys.modelapi.service.IPSSysCalendarItemRVService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysCalendarItemRVServiceImpl
extends PSModelServiceImplBase<PSSysCalendarItemRV, PSSysCalendarItemRVDTO>
implements IPSSysCalendarItemRVService {
    private static final Log log = LogFactory.getLog(PSSysCalendarItemRVServiceImpl.class);

    @Override
    public List<PSSysCalendarItemRV> listByPSSysCalendarItem(PSSysCalendarItem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysCalendarItemRV get(PSSysCalendarItem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysCalendarItemRV> list = this.listByPSSysCalendarItem(parent);
        if (list != null) {
            for (PSSysCalendarItemRV item : list) {
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
    public List<PSSysCalendarItemRVDTO> listDTOByPSSysCalendarItem(String strParentKey) throws Exception {
        PSSysCalendarItem pssyscalendaritem = (PSSysCalendarItem)PSModelServiceUtil.getInstance().getPSSysCalendarItemService().get(strParentKey);
        List<PSSysCalendarItemRV> list = this.listByPSSysCalendarItem(pssyscalendaritem);
        if (list != null) {
            ArrayList<PSSysCalendarItemRVDTO> dtoList = new ArrayList<PSSysCalendarItemRVDTO>();
            for (PSSysCalendarItemRV item : list) {
                PSSysCalendarItemRVDTO dto = (PSSysCalendarItemRVDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysCalendarItemRV> onListAll() throws Exception {
        ArrayList<PSSysCalendarItemRV> list = new ArrayList<PSSysCalendarItemRV>();
        List pssyscalendaritems = PSModelServiceUtil.getInstance().getPSSysCalendarItemService().listAll();
        if (pssyscalendaritems != null) {
            for (PSSysCalendarItem parent : pssyscalendaritems) {
                List<PSSysCalendarItemRV> items = this.listByPSSysCalendarItem(parent);
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
    protected PSSysCalendarItemRV onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysCalendarItemRV item;
        PSSysCalendarItem pssyscalendaritem = (PSSysCalendarItem)PSModelServiceUtil.getInstance().getPSSysCalendarItemService().get(strParentKey, true);
        if (pssyscalendaritem != null && (item = this.get(pssyscalendaritem, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysCalendarItemRV)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysCalendarItemRVDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysCalendarItemId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysCalendarItemService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysCalendarItemRV et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSSysCalendarItemRVName())) {
            return et.getPSSysCalendarItemRVName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysCalendarItemRVDTO dto, PSSysCalendarItemRV t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysCalendarItemRVId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSDEViewBaseId() != null || !bIgnoreNull) {
            dto.setPSDEViewBaseId(t.getPSDEViewBaseId());
        }
        if (t.getPSDEViewBaseName() != null || !bIgnoreNull) {
            dto.setPSDEViewBaseName(t.getPSDEViewBaseName());
        }
        if (t.getPSSysCalendarId() != null || !bIgnoreNull) {
            dto.setPSSysCalendarId(t.getPSSysCalendarId());
        }
        if (t.getPSSysCalendarItemId() != null || !bIgnoreNull) {
            dto.setPSSysCalendarItemId(t.getPSSysCalendarItemId());
        }
        if (t.getPSSysCalendarItemName() != null || !bIgnoreNull) {
            dto.setPSSysCalendarItemName(t.getPSSysCalendarItemName());
        }
        if (t.getPSSysCalendarItemRVName() != null || !bIgnoreNull) {
            dto.setPSSysCalendarItemRVName(t.getPSSysCalendarItemRVName());
        }
        if (t.getRefModeText() != null || !bIgnoreNull) {
            dto.setRefModeText(t.getRefModeText());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (t.getViewParams() != null || !bIgnoreNull) {
            dto.setViewParams(t.getViewParams());
        }
        if (StringUtils.hasLength((String)dto.getPSDEViewBaseId())) {
            dto.setPSDEViewBaseId(this.getRealPSModelId(t, dto.getPSDEViewBaseId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysCalendarItemId())) {
            dto.setPSSysCalendarItemId(this.getRealPSModelId(t, dto.getPSSysCalendarItemId()).replace("/", "."));
        }
        if ("PSSYSCALENDARITEM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysCalendarItemId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEViewBaseId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getPSDEViewBaseId());
            dto.setPSDEViewBaseName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setPSDEViewBaseName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysCalendarItemId())) {
            linkDTO = (PSSysCalendarItemDTO)PSModelServiceUtil.getInstance().getPSSysCalendarItemService().getDTO(dto.getPSSysCalendarItemId());
            dto.setPSSysCalendarId(((PSSysCalendarItemDTO)linkDTO).getPSSysCalendarId());
            dto.setPSSysCalendarItemName(((PSSysCalendarItemDTO)linkDTO).getPSSysCalendarItemName());
        } else {
            dto.setPSSysCalendarId(null);
            dto.setPSSysCalendarItemName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSSYSCALENDARITEMRV";
    }

    @Override
    public PSSysCalendarItemRV createDomain() {
        return new PSSysCalendarItemRV();
    }

    @Override
    public PSSysCalendarItemRVDTO createDTO() {
        return new PSSysCalendarItemRVDTO();
    }
}

