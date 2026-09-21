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
import net.ibizsys.modelapi.domain.PSDEGEIUDetail;
import net.ibizsys.modelapi.domain.PSDEGEIUpdate;
import net.ibizsys.modelapi.dto.PSDEGEIUDetailDTO;
import net.ibizsys.modelapi.dto.PSDEGEIUpdateDTO;
import net.ibizsys.modelapi.dto.PSDEGridColDTO;
import net.ibizsys.modelapi.dto.PSDEGridDTO;
import net.ibizsys.modelapi.service.IPSDEGEIUDetailService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEGEIUDetailServiceImpl
extends PSModelServiceImplBase<PSDEGEIUDetail, PSDEGEIUDetailDTO>
implements IPSDEGEIUDetailService {
    private static final Log log = LogFactory.getLog(PSDEGEIUDetailServiceImpl.class);

    @Override
    public List<PSDEGEIUDetail> listByPSDEGEIUpdate(PSDEGEIUpdate parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEGEIUDetail get(PSDEGEIUpdate parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEGEIUDetail> list = this.listByPSDEGEIUpdate(parent);
        if (list != null) {
            for (PSDEGEIUDetail item : list) {
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
    public List<PSDEGEIUDetailDTO> listDTOByPSDEGEIUpdate(String strParentKey) throws Exception {
        PSDEGEIUpdate psdegeiupdate = (PSDEGEIUpdate)PSModelServiceUtil.getInstance().getPSDEGEIUpdateService().get(strParentKey);
        List<PSDEGEIUDetail> list = this.listByPSDEGEIUpdate(psdegeiupdate);
        if (list != null) {
            ArrayList<PSDEGEIUDetailDTO> dtoList = new ArrayList<PSDEGEIUDetailDTO>();
            for (PSDEGEIUDetail item : list) {
                PSDEGEIUDetailDTO dto = (PSDEGEIUDetailDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEGEIUDetail> onListAll() throws Exception {
        ArrayList<PSDEGEIUDetail> list = new ArrayList<PSDEGEIUDetail>();
        List psdegeiupdates = PSModelServiceUtil.getInstance().getPSDEGEIUpdateService().listAll();
        if (psdegeiupdates != null) {
            for (PSDEGEIUpdate parent : psdegeiupdates) {
                List<PSDEGEIUDetail> items = this.listByPSDEGEIUpdate(parent);
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
    protected PSDEGEIUDetail onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEGEIUDetail item;
        PSDEGEIUpdate psdegeiupdate = (PSDEGEIUpdate)PSModelServiceUtil.getInstance().getPSDEGEIUpdateService().get(strParentKey, true);
        if (psdegeiupdate != null && (item = this.get(psdegeiupdate, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEGEIUDetail)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEGEIUDetailDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEGEIUpdateId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEGEIUpdateService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEGEIUDetail et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEGEIUDetailDTO dto, PSDEGEIUDetail t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEGEIUDetailId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getPSDEGEIUDetailName() != null || !bIgnoreNull) {
            dto.setPSDEGEIUDetailName(t.getPSDEGEIUDetailName());
        }
        if (t.getPSDEGEIUpdateId() != null || !bIgnoreNull) {
            dto.setPSDEGEIUpdateId(t.getPSDEGEIUpdateId());
        }
        if (t.getPSDEGEIUpdateName() != null || !bIgnoreNull) {
            dto.setPSDEGEIUpdateName(t.getPSDEGEIUpdateName());
        }
        if (t.getPSDEGridColId() != null || !bIgnoreNull) {
            dto.setPSDEGridColId(t.getPSDEGridColId());
        }
        if (t.getPSDEGridColName() != null || !bIgnoreNull) {
            dto.setPSDEGridColName(t.getPSDEGridColName());
        }
        if (t.getPSDEGridId() != null || !bIgnoreNull) {
            dto.setPSDEGridId(t.getPSDEGridId());
        }
        if (t.getPSDEGridName() != null || !bIgnoreNull) {
            dto.setPSDEGridName(t.getPSDEGridName());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (StringUtils.hasLength((String)dto.getPSDEGEIUpdateId())) {
            dto.setPSDEGEIUpdateId(this.getRealPSModelId(t, dto.getPSDEGEIUpdateId()).replace("/", "."));
        }
        if ("PSDEGEIUPDATE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEGEIUpdateId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEGridColId())) {
            dto.setPSDEGridColId(this.getRealPSModelId(t, dto.getPSDEGridColId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEGridId())) {
            dto.setPSDEGridId(this.getRealPSModelId(t, dto.getPSDEGridId()).replace("/", "."));
        } else {
            dto.setPSDEGridId(this.getRealPSModelId(t, "<PSDEGRID>").replace("/", "."));
        }
        if ("PSDEGRID".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEGridId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEGEIUpdateId())) {
            linkDTO = (PSDEGEIUpdateDTO)PSModelServiceUtil.getInstance().getPSDEGEIUpdateService().getDTO(dto.getPSDEGEIUpdateId(), true);
            if (linkDTO != null) {
                dto.setPSDEGEIUpdateName(((PSDEGEIUpdateDTO)linkDTO).getPSDEGEIUpdateName());
            }
        } else {
            dto.setPSDEGEIUpdateName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEGridColId())) {
            linkDTO = (PSDEGridColDTO)PSModelServiceUtil.getInstance().getPSDEGridColService().getDTO(dto.getPSDEGridColId());
            dto.setPSDEGridColName(((PSDEGridColDTO)linkDTO).getPSDEGridColName());
        } else {
            dto.setPSDEGridColName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEGridId())) {
            linkDTO = (PSDEGridDTO)PSModelServiceUtil.getInstance().getPSDEGridService().getDTO(dto.getPSDEGridId(), true);
            if (linkDTO != null) {
                dto.setPSDEGridName(((PSDEGridDTO)linkDTO).getPSDEGridName());
            }
        } else {
            dto.setPSDEGridName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEGEIUDETAIL";
    }

    @Override
    public PSDEGEIUDetail createDomain() {
        return new PSDEGEIUDetail();
    }

    @Override
    public PSDEGEIUDetailDTO createDTO() {
        return new PSDEGEIUDetailDTO();
    }
}

