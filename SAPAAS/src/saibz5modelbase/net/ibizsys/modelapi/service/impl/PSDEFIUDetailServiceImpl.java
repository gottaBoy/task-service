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
import net.ibizsys.modelapi.domain.PSDEFIUDetail;
import net.ibizsys.modelapi.domain.PSDEFIUpdate;
import net.ibizsys.modelapi.domain.PSDEForm;
import net.ibizsys.modelapi.dto.PSDEFIUDetailDTO;
import net.ibizsys.modelapi.dto.PSDEFIUpdateDTO;
import net.ibizsys.modelapi.dto.PSDEFormDTO;
import net.ibizsys.modelapi.dto.PSDEFormDetailDTO;
import net.ibizsys.modelapi.service.IPSDEFIUDetailService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEFIUDetailServiceImpl
extends PSModelServiceImplBase<PSDEFIUDetail, PSDEFIUDetailDTO>
implements IPSDEFIUDetailService {
    private static final Log log = LogFactory.getLog(PSDEFIUDetailServiceImpl.class);

    @Override
    public List<PSDEFIUDetail> listByPSDEFIUpdate(PSDEFIUpdate parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEFIUDetail get(PSDEFIUpdate parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEFIUDetail> list = this.listByPSDEFIUpdate(parent);
        if (list != null) {
            for (PSDEFIUDetail item : list) {
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
    public List<PSDEFIUDetailDTO> listDTOByPSDEFIUpdate(String strParentKey) throws Exception {
        PSDEFIUpdate psdefiupdate = (PSDEFIUpdate)PSModelServiceUtil.getInstance().getPSDEFIUpdateService().get(strParentKey);
        List<PSDEFIUDetail> list = this.listByPSDEFIUpdate(psdefiupdate);
        if (list != null) {
            ArrayList<PSDEFIUDetailDTO> dtoList = new ArrayList<PSDEFIUDetailDTO>();
            for (PSDEFIUDetail item : list) {
                PSDEFIUDetailDTO dto = (PSDEFIUDetailDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSDEFIUDetail> listByPSDEForm(PSDEForm parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEFIUDetail get(PSDEForm parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEFIUDetail> list = this.listByPSDEForm(parent);
        if (list != null) {
            for (PSDEFIUDetail item : list) {
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
    public List<PSDEFIUDetailDTO> listDTOByPSDEForm(String strParentKey) throws Exception {
        PSDEForm psdeform = (PSDEForm)PSModelServiceUtil.getInstance().getPSDEFormService().get(strParentKey);
        List<PSDEFIUDetail> list = this.listByPSDEForm(psdeform);
        if (list != null) {
            ArrayList<PSDEFIUDetailDTO> dtoList = new ArrayList<PSDEFIUDetailDTO>();
            for (PSDEFIUDetail item : list) {
                PSDEFIUDetailDTO dto = (PSDEFIUDetailDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEFIUDetail> onListAll() throws Exception {
        ArrayList<PSDEFIUDetail> list = new ArrayList<PSDEFIUDetail>();
        List psdefiupdates = PSModelServiceUtil.getInstance().getPSDEFIUpdateService().listAll();
        if (psdefiupdates != null) {
            for (PSDEFIUpdate parent : psdefiupdates) {
                List<PSDEFIUDetail> items = this.listByPSDEFIUpdate(parent);
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
    protected PSDEFIUDetail onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEFIUDetail item;
        PSDEFIUpdate psdefiupdate = (PSDEFIUpdate)PSModelServiceUtil.getInstance().getPSDEFIUpdateService().get(strParentKey, true);
        if (psdefiupdate != null && (item = this.get(psdefiupdate, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEFIUDetail)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEFIUDetailDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEFIUpdateId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEFIUpdateService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSDEFormId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEFormService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEFIUDetail et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEFIUDetailDTO dto, PSDEFIUDetail t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEFIUDetailId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getPSDEFIUDetailName() != null || !bIgnoreNull) {
            dto.setPSDEFIUDetailName(t.getPSDEFIUDetailName());
        }
        if (t.getPSDEFIUpdateId() != null || !bIgnoreNull) {
            dto.setPSDEFIUpdateId(t.getPSDEFIUpdateId());
        }
        if (t.getPSDEFIUpdateName() != null || !bIgnoreNull) {
            dto.setPSDEFIUpdateName(t.getPSDEFIUpdateName());
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
        if (StringUtils.hasLength((String)dto.getPSDEFIUpdateId())) {
            dto.setPSDEFIUpdateId(this.getRealPSModelId(t, dto.getPSDEFIUpdateId()).replace("/", "."));
        }
        if ("PSDEFIUPDATE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEFIUpdateId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFormDetailId())) {
            dto.setPSDEFormDetailId(this.getRealPSModelId(t, dto.getPSDEFormDetailId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFormId())) {
            dto.setPSDEFormId(this.getRealPSModelId(t, dto.getPSDEFormId()).replace("/", "."));
        }
        if ("PSDEFORM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEFormId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFIUpdateId())) {
            linkDTO = (PSDEFIUpdateDTO)PSModelServiceUtil.getInstance().getPSDEFIUpdateService().getDTO(dto.getPSDEFIUpdateId(), true);
            if (linkDTO != null) {
                dto.setPSDEFIUpdateName(((PSDEFIUpdateDTO)linkDTO).getPSDEFIUpdateName());
            }
        } else {
            dto.setPSDEFIUpdateName(null);
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
            linkDTO = (PSDEFormDTO)PSModelServiceUtil.getInstance().getPSDEFormService().getDTO(dto.getPSDEFormId(), true);
            if (linkDTO != null) {
                dto.setPSDEFormName(((PSDEFormDTO)linkDTO).getPSDEFormName());
            }
        } else {
            dto.setPSDEFormName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEFIUDETAIL";
    }

    @Override
    public PSDEFIUDetail createDomain() {
        return new PSDEFIUDetail();
    }

    @Override
    public PSDEFIUDetailDTO createDTO() {
        return new PSDEFIUDetailDTO();
    }
}

