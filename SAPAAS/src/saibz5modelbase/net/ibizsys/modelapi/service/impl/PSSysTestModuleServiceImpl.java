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
import net.ibizsys.modelapi.domain.PSSysTestModule;
import net.ibizsys.modelapi.domain.PSSysTestPrj;
import net.ibizsys.modelapi.dto.PSSysTestModuleDTO;
import net.ibizsys.modelapi.dto.PSSysTestPrjDTO;
import net.ibizsys.modelapi.service.IPSSysTestModuleService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysTestModuleServiceImpl
extends PSModelServiceImplBase<PSSysTestModule, PSSysTestModuleDTO>
implements IPSSysTestModuleService {
    private static final Log log = LogFactory.getLog(PSSysTestModuleServiceImpl.class);

    @Override
    public List<PSSysTestModule> listByPSSysTestPrj(PSSysTestPrj parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysTestModule get(PSSysTestPrj parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysTestModule> list = this.listByPSSysTestPrj(parent);
        if (list != null) {
            for (PSSysTestModule item : list) {
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
    public List<PSSysTestModuleDTO> listDTOByPSSysTestPrj(String strParentKey) throws Exception {
        PSSysTestPrj pssystestprj = (PSSysTestPrj)PSModelServiceUtil.getInstance().getPSSysTestPrjService().get(strParentKey);
        List<PSSysTestModule> list = this.listByPSSysTestPrj(pssystestprj);
        if (list != null) {
            ArrayList<PSSysTestModuleDTO> dtoList = new ArrayList<PSSysTestModuleDTO>();
            for (PSSysTestModule item : list) {
                PSSysTestModuleDTO dto = (PSSysTestModuleDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysTestModule> onListAll() throws Exception {
        ArrayList<PSSysTestModule> list = new ArrayList<PSSysTestModule>();
        List pssystestprjs = PSModelServiceUtil.getInstance().getPSSysTestPrjService().listAll();
        if (pssystestprjs != null) {
            for (PSSysTestPrj parent : pssystestprjs) {
                List<PSSysTestModule> items = this.listByPSSysTestPrj(parent);
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
    protected PSSysTestModule onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysTestModule item;
        PSSysTestPrj pssystestprj = (PSSysTestPrj)PSModelServiceUtil.getInstance().getPSSysTestPrjService().get(strParentKey, true);
        if (pssystestprj != null && (item = this.get(pssystestprj, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysTestModule)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysTestModuleDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysTestPrjId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysTestPrjService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysTestModule et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysTestModuleDTO dto, PSSysTestModule t, boolean bIgnoreNull) throws Exception {
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysTestModuleId(t.getId().replace("/", "."));
        }
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
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
        if (t.getModuleTag() != null || !bIgnoreNull) {
            dto.setModuleTag(t.getModuleTag());
        }
        if (t.getModuleTag2() != null || !bIgnoreNull) {
            dto.setModuleTag2(t.getModuleTag2());
        }
        if (t.getModuleType() != null || !bIgnoreNull) {
            dto.setModuleType(t.getModuleType());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPSSysAppId() != null || !bIgnoreNull) {
            dto.setPSSysAppId(t.getPSSysAppId());
        }
        if (t.getPSSysServiceAPIId() != null || !bIgnoreNull) {
            dto.setPSSysServiceAPIId(t.getPSSysServiceAPIId());
        }
        if (t.getPSSysTestModuleName() != null || !bIgnoreNull) {
            dto.setPSSysTestModuleName(t.getPSSysTestModuleName());
        }
        if (t.getPSSysTestPrjId() != null || !bIgnoreNull) {
            dto.setPSSysTestPrjId(t.getPSSysTestPrjId());
        }
        if (t.getPSSysTestPrjName() != null || !bIgnoreNull) {
            dto.setPSSysTestPrjName(t.getPSSysTestPrjName());
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
        if (StringUtils.hasLength((String)dto.getPSSysTestPrjId())) {
            dto.setPSSysTestPrjId(this.getRealPSModelId(t, dto.getPSSysTestPrjId()).replace("/", "."));
        }
        if ("PSSYSTESTPRJ".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysTestPrjId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysTestPrjId())) {
            PSSysTestPrjDTO linkDTO = (PSSysTestPrjDTO)PSModelServiceUtil.getInstance().getPSSysTestPrjService().getDTO(dto.getPSSysTestPrjId());
            dto.setPSSysAppId(linkDTO.getPSSysAppId());
            dto.setPSSysServiceAPIId(linkDTO.getPSSysServiceAPIId());
            dto.setPSSysTestPrjName(linkDTO.getPSSysTestPrjName());
        } else {
            dto.setPSSysAppId(null);
            dto.setPSSysServiceAPIId(null);
            dto.setPSSysTestPrjName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSYSTESTMODULE";
    }

    @Override
    public PSSysTestModule createDomain() {
        return new PSSysTestModule();
    }

    @Override
    public PSSysTestModuleDTO createDTO() {
        return new PSSysTestModuleDTO();
    }
}

