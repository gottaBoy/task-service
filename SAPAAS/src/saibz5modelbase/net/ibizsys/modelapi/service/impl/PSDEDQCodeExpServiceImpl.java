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
import net.ibizsys.modelapi.domain.PSDEDQCodeExp;
import net.ibizsys.modelapi.dto.PSDEDQCodeDTO;
import net.ibizsys.modelapi.dto.PSDEDQCodeExpDTO;
import net.ibizsys.modelapi.service.IPSDEDQCodeExpService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEDQCodeExpServiceImpl
extends PSModelServiceImplBase<PSDEDQCodeExp, PSDEDQCodeExpDTO>
implements IPSDEDQCodeExpService {
    private static final Log log = LogFactory.getLog(PSDEDQCodeExpServiceImpl.class);

    @Override
    public List<PSDEDQCodeExp> listByPSDEDQCode(PSDEDQCode parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEDQCodeExp get(PSDEDQCode parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEDQCodeExp> list = this.listByPSDEDQCode(parent);
        if (list != null) {
            for (PSDEDQCodeExp item : list) {
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
    public List<PSDEDQCodeExpDTO> listDTOByPSDEDQCode(String strParentKey) throws Exception {
        PSDEDQCode psdedqcode = (PSDEDQCode)PSModelServiceUtil.getInstance().getPSDEDQCodeService().get(strParentKey);
        List<PSDEDQCodeExp> list = this.listByPSDEDQCode(psdedqcode);
        if (list != null) {
            ArrayList<PSDEDQCodeExpDTO> dtoList = new ArrayList<PSDEDQCodeExpDTO>();
            for (PSDEDQCodeExp item : list) {
                PSDEDQCodeExpDTO dto = (PSDEDQCodeExpDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEDQCodeExp> onListAll() throws Exception {
        ArrayList<PSDEDQCodeExp> list = new ArrayList<PSDEDQCodeExp>();
        List<PSDEDQCode> psdedqcodes = PSModelServiceUtil.getInstance().getPSDEDQCodeService().listAll();
        if (psdedqcodes != null) {
            for (PSDEDQCode parent : psdedqcodes) {
                List<PSDEDQCodeExp> items = this.listByPSDEDQCode(parent);
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
    protected PSDEDQCodeExp onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEDQCodeExp item;
        PSDEDQCode psdedqcode = (PSDEDQCode)PSModelServiceUtil.getInstance().getPSDEDQCodeService().get(strParentKey, true);
        if (psdedqcode != null && (item = this.get(psdedqcode, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEDQCodeExp)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEDQCodeExpDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEDQCodeId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEDQCodeService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEDQCodeExp et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDEDQCodeExpName())) {
            return et.getPSDEDQCodeExpName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEDQCodeExpDTO dto, PSDEDQCodeExp t, boolean bIgnoreNull) throws Exception {
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEDQCodeExpId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getExpCode() != null || !bIgnoreNull) {
            dto.setExpCode(t.getExpCode());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPSDEDQCodeExpName() != null || !bIgnoreNull) {
            dto.setPSDEDQCodeExpName(t.getPSDEDQCodeExpName());
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
        return "PSDEDQCODEEXP";
    }

    @Override
    public PSDEDQCodeExp createDomain() {
        return new PSDEDQCodeExp();
    }

    @Override
    public PSDEDQCodeExpDTO createDTO() {
        return new PSDEDQCodeExpDTO();
    }
}

