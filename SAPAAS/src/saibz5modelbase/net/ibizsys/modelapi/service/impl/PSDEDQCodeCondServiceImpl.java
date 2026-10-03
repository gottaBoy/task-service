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
import net.ibizsys.modelapi.domain.PSDEDQCode;
import net.ibizsys.modelapi.domain.PSDEDQCodeCond;
import net.ibizsys.modelapi.dto.PSDEDQCodeCondDTO;
import net.ibizsys.modelapi.dto.PSDEDQCodeDTO;
import net.ibizsys.modelapi.service.IPSDEDQCodeCondService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEDQCodeCondServiceImpl
extends PSModelServiceImplBase<PSDEDQCodeCond, PSDEDQCodeCondDTO>
implements IPSDEDQCodeCondService {
    private static final Log log = LogFactory.getLog(PSDEDQCodeCondServiceImpl.class);

    @Override
    public List<PSDEDQCodeCond> listByPSDEDQCode(PSDEDQCode parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEDQCodeCond get(PSDEDQCode parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEDQCodeCond> list = this.listByPSDEDQCode(parent);
        if (list != null) {
            for (PSDEDQCodeCond item : list) {
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
    public List<PSDEDQCodeCondDTO> listDTOByPSDEDQCode(String strParentKey) throws Exception {
        PSDEDQCode psdedqcode = (PSDEDQCode)PSModelServiceUtil.getInstance().getPSDEDQCodeService().get(strParentKey);
        List<PSDEDQCodeCond> list = this.listByPSDEDQCode(psdedqcode);
        if (list != null) {
            ArrayList<PSDEDQCodeCondDTO> dtoList = new ArrayList<PSDEDQCodeCondDTO>();
            for (PSDEDQCodeCond item : list) {
                PSDEDQCodeCondDTO dto = (PSDEDQCodeCondDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEDQCodeCond> onListAll() throws Exception {
        ArrayList<PSDEDQCodeCond> list = new ArrayList<PSDEDQCodeCond>();
        List<PSDEDQCode> psdedqcodes = PSModelServiceUtil.getInstance().getPSDEDQCodeService().listAll();
        if (psdedqcodes != null) {
            for (PSDEDQCode parent : psdedqcodes) {
                List<PSDEDQCodeCond> items = this.listByPSDEDQCode(parent);
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
    protected PSDEDQCodeCond onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEDQCodeCond item;
        PSDEDQCode psdedqcode = (PSDEDQCode)PSModelServiceUtil.getInstance().getPSDEDQCodeService().get(strParentKey, true);
        if (psdedqcode != null && (item = this.get(psdedqcode, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEDQCodeCond)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEDQCodeCondDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEDQCodeId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEDQCodeService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEDQCodeCond et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEDQCodeCondDTO dto, PSDEDQCodeCond t, boolean bIgnoreNull) throws Exception {
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEDQCodeCondId(t.getId().replace("/", "."));
        }
        if (t.getCondCode() != null || !bIgnoreNull) {
            dto.setCondCode(t.getCondCode());
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
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPSDEDQCodeCondName() != null || !bIgnoreNull) {
            dto.setPSDEDQCodeCondName(t.getPSDEDQCodeCondName());
        }
        if (t.getPSDEDQCodeId() != null || !bIgnoreNull) {
            dto.setPSDEDQCodeId(t.getPSDEDQCodeId());
        }
        if (t.getPSDEDQCodeName() != null || !bIgnoreNull) {
            dto.setPSDEDQCodeName(t.getPSDEDQCodeName());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (StringUtils.hasLength((String)dto.getPSDEDQCodeId())) {
            dto.setPSDEDQCodeId(this.getRealPSModelId(t, dto.getPSDEDQCodeId()).replace("/", "."));
        }
        if ("PSDEDQCODE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEDQCodeId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDQCodeId())) {
            PSDEDQCodeDTO linkDTO = (PSDEDQCodeDTO)PSModelServiceUtil.getInstance().getPSDEDQCodeService().getDTO(dto.getPSDEDQCodeId());
            dto.setPSDEDQCodeName(linkDTO.getPSDEDQCodeName());
        } else {
            dto.setPSDEDQCodeName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSDEDQCODECOND";
    }

    @Override
    public PSDEDQCodeCond createDomain() {
        return new PSDEDQCodeCond();
    }

    @Override
    public PSDEDQCodeCondDTO createDTO() {
        return new PSDEDQCodeCondDTO();
    }
}

