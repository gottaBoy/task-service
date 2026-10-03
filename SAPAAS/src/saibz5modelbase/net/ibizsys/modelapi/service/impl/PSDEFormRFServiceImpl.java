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
import net.ibizsys.modelapi.domain.PSDEForm;
import net.ibizsys.modelapi.domain.PSDEFormRF;
import net.ibizsys.modelapi.dto.PSDEFormDTO;
import net.ibizsys.modelapi.dto.PSDEFormRFDTO;
import net.ibizsys.modelapi.service.IPSDEFormRFService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEFormRFServiceImpl
extends PSModelServiceImplBase<PSDEFormRF, PSDEFormRFDTO>
implements IPSDEFormRFService {
    private static final Log log = LogFactory.getLog(PSDEFormRFServiceImpl.class);

    @Override
    public List<PSDEFormRF> listByPSDEForm(PSDEForm parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEFormRF get(PSDEForm parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEFormRF> list = this.listByPSDEForm(parent);
        if (list != null) {
            for (PSDEFormRF item : list) {
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
    public List<PSDEFormRFDTO> listDTOByPSDEForm(String strParentKey) throws Exception {
        PSDEForm psdeform = (PSDEForm)PSModelServiceUtil.getInstance().getPSDEFormService().get(strParentKey);
        List<PSDEFormRF> list = this.listByPSDEForm(psdeform);
        if (list != null) {
            ArrayList<PSDEFormRFDTO> dtoList = new ArrayList<PSDEFormRFDTO>();
            for (PSDEFormRF item : list) {
                PSDEFormRFDTO dto = (PSDEFormRFDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEFormRF> onListAll() throws Exception {
        ArrayList<PSDEFormRF> list = new ArrayList<PSDEFormRF>();
        List<PSDEForm> psdeforms = PSModelServiceUtil.getInstance().getPSDEFormService().listAll();
        if (psdeforms != null) {
            for (PSDEForm parent : psdeforms) {
                List<PSDEFormRF> items = this.listByPSDEForm(parent);
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
    protected PSDEFormRF onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEFormRF item;
        PSDEForm psdeform = (PSDEForm)PSModelServiceUtil.getInstance().getPSDEFormService().get(strParentKey, true);
        if (psdeform != null && (item = this.get(psdeform, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEFormRF)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEFormRFDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getMajorPSDEFormId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEFormService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEFormRF et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDEFormRFName())) {
            return et.getPSDEFormRFName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEFormRFDTO dto, PSDEFormRF t, boolean bIgnoreNull) throws Exception {
        PSDEFormDTO linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEFormRFId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getMajorPSDEFormId() != null || !bIgnoreNull) {
            dto.setMajorPSDEFormId(t.getMajorPSDEFormId());
        }
        if (t.getMajorPSDEFormName() != null || !bIgnoreNull) {
            dto.setMajorPSDEFormName(t.getMajorPSDEFormName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMinorPSDEFormId() != null || !bIgnoreNull) {
            dto.setMinorPSDEFormId(t.getMinorPSDEFormId());
        }
        if (t.getMinorPSDEFormName() != null || !bIgnoreNull) {
            dto.setMinorPSDEFormName(t.getMinorPSDEFormName());
        }
        if (t.getPSDEFormRFName() != null || !bIgnoreNull) {
            dto.setPSDEFormRFName(t.getPSDEFormRFName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (StringUtils.hasLength((String)dto.getMajorPSDEFormId())) {
            dto.setMajorPSDEFormId(this.getRealPSModelId(t, dto.getMajorPSDEFormId()).replace("/", "."));
        }
        if ("PSDEFORM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setMajorPSDEFormId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMinorPSDEFormId())) {
            dto.setMinorPSDEFormId(this.getRealPSModelId(t, dto.getMinorPSDEFormId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMajorPSDEFormId())) {
            linkDTO = (PSDEFormDTO)PSModelServiceUtil.getInstance().getPSDEFormService().getDTO(dto.getMajorPSDEFormId());
            dto.setMajorPSDEFormName(linkDTO.getPSDEFormName());
            dto.setPSDEId(linkDTO.getPSDEId());
        } else {
            dto.setMajorPSDEFormName(null);
            dto.setPSDEId(null);
        }
        if (StringUtils.hasLength((String)dto.getMinorPSDEFormId())) {
            linkDTO = (PSDEFormDTO)PSModelServiceUtil.getInstance().getPSDEFormService().getDTO(dto.getMinorPSDEFormId());
            dto.setMinorPSDEFormName(linkDTO.getPSDEFormName());
        } else {
            dto.setMinorPSDEFormName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEFORMRF";
    }

    @Override
    public PSDEFormRF createDomain() {
        return new PSDEFormRF();
    }

    @Override
    public PSDEFormRFDTO createDTO() {
        return new PSDEFormRFDTO();
    }
}

