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
import net.ibizsys.modelapi.domain.PSSysModelGroup;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysModelGroupDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSSysModelGroupService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysModelGroupServiceImpl
extends PSModelServiceImplBase<PSSysModelGroup, PSSysModelGroupDTO>
implements IPSSysModelGroupService {
    private static final Log log = LogFactory.getLog(PSSysModelGroupServiceImpl.class);

    @Override
    public List<PSSysModelGroup> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysModelGroup get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysModelGroup> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSSysModelGroup item : list) {
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
    public List<PSSysModelGroupDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSSysModelGroup> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSSysModelGroupDTO> dtoList = new ArrayList<PSSysModelGroupDTO>();
            for (PSSysModelGroup item : list) {
                PSSysModelGroupDTO dto = (PSSysModelGroupDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysModelGroup> onListAll() throws Exception {
        ArrayList<PSSysModelGroup> list = new ArrayList<PSSysModelGroup>();
        List pssystems = PSModelServiceUtil.getInstance().getPSSystemService().listAll();
        if (pssystems != null) {
            for (PSSystem parent : pssystems) {
                List<PSSysModelGroup> items = this.listByPSSystem(parent);
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
    protected PSSysModelGroup onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysModelGroup item;
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey, true);
        if (pssystem != null && (item = this.get(pssystem, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysModelGroup)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysModelGroupDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSystemId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSystemService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysModelGroup et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysModelGroupDTO dto, PSSysModelGroup t, boolean bIgnoreNull) throws Exception {
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysModelGroupId(t.getId().replace("/", "."));
        }
        if (t.getClsPkgParams() != null || !bIgnoreNull) {
            dto.setClsPkgParams(t.getClsPkgParams());
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
        if (t.getDTOFormat() != null || !bIgnoreNull) {
            dto.setDTOFormat(t.getDTOFormat());
        }
        if (t.getDynaInstMode() != null || !bIgnoreNull) {
            dto.setDynaInstMode(t.getDynaInstMode());
        }
        if (t.getDynaInstTag() != null || !bIgnoreNull) {
            dto.setDynaInstTag(t.getDynaInstTag());
        }
        if (t.getDynaInstTag2() != null || !bIgnoreNull) {
            dto.setDynaInstTag2(t.getDynaInstTag2());
        }
        if (t.getGroupParams() != null || !bIgnoreNull) {
            dto.setGroupParams(t.getGroupParams());
        }
        if (t.getGroupTag() != null || !bIgnoreNull) {
            dto.setGroupTag(t.getGroupTag());
        }
        if (t.getGroupTag2() != null || !bIgnoreNull) {
            dto.setGroupTag2(t.getGroupTag2());
        }
        if (t.getGroupTag3() != null || !bIgnoreNull) {
            dto.setGroupTag3(t.getGroupTag3());
        }
        if (t.getGroupTag4() != null || !bIgnoreNull) {
            dto.setGroupTag4(t.getGroupTag4());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPFRTObjectRepo() != null || !bIgnoreNull) {
            dto.setPFRTObjectRepo(t.getPFRTObjectRepo());
        }
        if (t.getPKGCodeName() != null || !bIgnoreNull) {
            dto.setPKGCodeName(t.getPKGCodeName());
        }
        if (t.getPSDCSysModelRepoId() != null || !bIgnoreNull) {
            dto.setPSDCSysModelRepoId(t.getPSDCSysModelRepoId());
        }
        if (t.getPSDCSysModelRepoName() != null || !bIgnoreNull) {
            dto.setPSDCSysModelRepoName(t.getPSDCSysModelRepoName());
        }
        if (t.getPSSysModelGroupName() != null || !bIgnoreNull) {
            dto.setPSSysModelGroupName(t.getPSSysModelGroupName());
        }
        if (t.getPSSysModelRepoId() != null || !bIgnoreNull) {
            dto.setPSSysModelRepoId(t.getPSSysModelRepoId());
        }
        if (t.getPSSysModelRepoName() != null || !bIgnoreNull) {
            dto.setPSSysModelRepoName(t.getPSSysModelRepoName());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSSystemName() != null || !bIgnoreNull) {
            dto.setPSSystemName(t.getPSSystemName());
        }
        if (t.getSFRTObjectRepo() != null || !bIgnoreNull) {
            dto.setSFRTObjectRepo(t.getSFRTObjectRepo());
        }
        if (t.getSyncMode() != null || !bIgnoreNull) {
            dto.setSyncMode(t.getSyncMode());
        }
        if (t.getSysModelFrom() != null || !bIgnoreNull) {
            dto.setSysModelFrom(t.getSysModelFrom());
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
        return "PSSYSMODELGROUP";
    }

    @Override
    public PSSysModelGroup createDomain() {
        return new PSSysModelGroup();
    }

    @Override
    public PSSysModelGroupDTO createDTO() {
        return new PSSysModelGroupDTO();
    }
}

