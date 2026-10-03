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
import net.ibizsys.modelapi.domain.PSSysBDInstCfg;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysBDInstCfgDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSSysBDInstCfgService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysBDInstCfgServiceImpl
extends PSModelServiceImplBase<PSSysBDInstCfg, PSSysBDInstCfgDTO>
implements IPSSysBDInstCfgService {
    private static final Log log = LogFactory.getLog(PSSysBDInstCfgServiceImpl.class);

    @Override
    public List<PSSysBDInstCfg> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysBDInstCfg get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysBDInstCfg> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSSysBDInstCfg item : list) {
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
    public List<PSSysBDInstCfgDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSSysBDInstCfg> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSSysBDInstCfgDTO> dtoList = new ArrayList<PSSysBDInstCfgDTO>();
            for (PSSysBDInstCfg item : list) {
                PSSysBDInstCfgDTO dto = (PSSysBDInstCfgDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysBDInstCfg> onListAll() throws Exception {
        ArrayList<PSSysBDInstCfg> list = new ArrayList<PSSysBDInstCfg>();
        List<PSSystem> pssystems = PSModelServiceUtil.getInstance().getPSSystemService().listAll();
        if (pssystems != null) {
            for (PSSystem parent : pssystems) {
                List<PSSysBDInstCfg> items = this.listByPSSystem(parent);
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
    protected PSSysBDInstCfg onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysBDInstCfg item;
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey, true);
        if (pssystem != null && (item = this.get(pssystem, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysBDInstCfg)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysBDInstCfgDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSystemId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSystemService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysBDInstCfg et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSSysBDInstCfgName())) {
            return et.getPSSysBDInstCfgName();
        }
        if (StringUtils.hasLength((String)et.getPSSysBDInstCfgName())) {
            return et.getPSSysBDInstCfgName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysBDInstCfgDTO dto, PSSysBDInstCfg t, boolean bIgnoreNull) throws Exception {
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysBDInstCfgId(t.getId().replace("/", "."));
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
        if (t.getPSDCBDInstId() != null || !bIgnoreNull) {
            dto.setPSDCBDInstId(t.getPSDCBDInstId());
        }
        if (t.getPSDCBDInstName() != null || !bIgnoreNull) {
            dto.setPSDCBDInstName(t.getPSDCBDInstName());
        }
        if (t.getPSSysBDInstCfgName() != null || !bIgnoreNull) {
            dto.setPSSysBDInstCfgName(t.getPSSysBDInstCfgName());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSSystemName() != null || !bIgnoreNull) {
            dto.setPSSystemName(t.getPSSystemName());
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
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            dto.setPSSystemId(this.getRealPSModelId(t, dto.getPSSystemId()).replace("/", "."));
        }
        if ("PSSYSTEM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSystemId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            PSSystemDTO linkDTO = (PSSystemDTO)PSModelServiceUtil.getInstance().getPSSystemService().getDTO(dto.getPSSystemId());
            dto.setPSSystemName(linkDTO.getPSSystemName());
        } else {
            dto.setPSSystemName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSYSBDINSTCFG";
    }

    @Override
    public PSSysBDInstCfg createDomain() {
        return new PSSysBDInstCfg();
    }

    @Override
    public PSSysBDInstCfgDTO createDTO() {
        return new PSSysBDInstCfgDTO();
    }
}

