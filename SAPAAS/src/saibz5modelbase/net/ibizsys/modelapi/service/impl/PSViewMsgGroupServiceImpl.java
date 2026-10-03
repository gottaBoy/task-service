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
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.domain.PSViewMsgGroup;
import net.ibizsys.modelapi.domain.PSViewMsgGrpDetail;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSModuleDTO;
import net.ibizsys.modelapi.dto.PSSysCssDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.dto.PSViewMsgGroupDTO;
import net.ibizsys.modelapi.dto.PSViewMsgGrpDetailDTO;
import net.ibizsys.modelapi.service.IPSViewMsgGroupService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSViewMsgGroupServiceImpl
extends PSModelServiceImplBase<PSViewMsgGroup, PSViewMsgGroupDTO>
implements IPSViewMsgGroupService {
    private static final Log log = LogFactory.getLog(PSViewMsgGroupServiceImpl.class);

    @Override
    public List<PSViewMsgGroup> listByPSModule(PSModule parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSViewMsgGroup get(PSModule parent, String strKey, boolean bTryMode) throws Exception {
        List<PSViewMsgGroup> list = this.listByPSModule(parent);
        if (list != null) {
            for (PSViewMsgGroup item : list) {
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
    public List<PSViewMsgGroupDTO> listDTOByPSModule(String strParentKey) throws Exception {
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey);
        List<PSViewMsgGroup> list = this.listByPSModule(psmodule);
        if (list != null) {
            ArrayList<PSViewMsgGroupDTO> dtoList = new ArrayList<PSViewMsgGroupDTO>();
            for (PSViewMsgGroup item : list) {
                PSViewMsgGroupDTO dto = (PSViewMsgGroupDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSViewMsgGroup> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSViewMsgGroup get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSViewMsgGroup> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSViewMsgGroup item : list) {
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
    public List<PSViewMsgGroupDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSViewMsgGroup> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSViewMsgGroupDTO> dtoList = new ArrayList<PSViewMsgGroupDTO>();
            for (PSViewMsgGroup item : list) {
                PSViewMsgGroupDTO dto = (PSViewMsgGroupDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSViewMsgGroup> onListAll() throws Exception {
        List<PSSystem> pssystems;
        ArrayList<PSViewMsgGroup> list = new ArrayList<PSViewMsgGroup>();
        List<PSModule> psmodules = PSModelServiceUtil.getInstance().getPSModuleService().listAll();
        if (psmodules != null) {
            for (PSModule parent : psmodules) {
                List<PSViewMsgGroup> items = this.listByPSModule(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pssystems = PSModelServiceUtil.getInstance().getPSSystemService().listAll()) != null) {
            for (PSSystem parent : pssystems) {
                List<PSViewMsgGroup> items = this.listByPSSystem(parent);
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
    protected PSViewMsgGroup onGet(String strParentKey, String strCurKey) throws Exception {
        PSViewMsgGroup item;
        PSViewMsgGroup item2;
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey, true);
        if (psmodule != null && (item2 = this.get(psmodule, strCurKey, true)) != null) {
            return item2;
        }
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey, true);
        if (pssystem != null && (item = this.get(pssystem, strCurKey, true)) != null) {
            return item;
        }
        return (PSViewMsgGroup)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSViewMsgGroupDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSModuleId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSModuleService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSSystemId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSystemService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSViewMsgGroup et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getPSViewMsgGroupName())) {
            return et.getPSViewMsgGroupName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSViewMsgGroupDTO dto, PSViewMsgGroup t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSViewMsgGroupId(t.getId().replace("/", "."));
        }
        if (t.getBodyMsgPSSysCssId() != null || !bIgnoreNull) {
            dto.setBodyMsgPSSysCssId(t.getBodyMsgPSSysCssId());
        }
        if (t.getBodyMsgPSSysCssName() != null || !bIgnoreNull) {
            dto.setBodyMsgPSSysCssName(t.getBodyMsgPSSysCssName());
        }
        if (t.getBodyMsgStyle() != null || !bIgnoreNull) {
            dto.setBodyMsgStyle(t.getBodyMsgStyle());
        }
        if (t.getBottomMsgPSSysCssId() != null || !bIgnoreNull) {
            dto.setBottomMsgPSSysCssId(t.getBottomMsgPSSysCssId());
        }
        if (t.getBottomMsgPSSysCssName() != null || !bIgnoreNull) {
            dto.setBottomMsgPSSysCssName(t.getBottomMsgPSSysCssName());
        }
        if (t.getBottomMsgStyle() != null || !bIgnoreNull) {
            dto.setBottomMsgStyle(t.getBottomMsgStyle());
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
        if (t.getDynamicMode() != null || !bIgnoreNull) {
            dto.setDynamicMode(t.getDynamicMode());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSModuleId() != null || !bIgnoreNull) {
            dto.setPSModuleId(t.getPSModuleId());
        }
        if (t.getPSModuleName() != null || !bIgnoreNull) {
            dto.setPSModuleName(t.getPSModuleName());
        }
        if (t.getPSSysDynaModelId() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelId(t.getPSSysDynaModelId());
        }
        if (t.getPSSysDynaModelName() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelName(t.getPSSysDynaModelName());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSSystemName() != null || !bIgnoreNull) {
            dto.setPSSystemName(t.getPSSystemName());
        }
        if (t.getPSViewMsgGroupName() != null || !bIgnoreNull) {
            dto.setPSViewMsgGroupName(t.getPSViewMsgGroupName());
        }
        if (t.getTopMsgPSSysCssId() != null || !bIgnoreNull) {
            dto.setTopMsgPSSysCssId(t.getTopMsgPSSysCssId());
        }
        if (t.getTopMsgPSSysCssName() != null || !bIgnoreNull) {
            dto.setTopMsgPSSysCssName(t.getTopMsgPSSysCssName());
        }
        if (t.getTopMsgStyle() != null || !bIgnoreNull) {
            dto.setTopMsgStyle(t.getTopMsgStyle());
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
        if (t.getUserParams() != null || !bIgnoreNull) {
            dto.setUserParams(t.getUserParams());
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
        if (StringUtils.hasLength((String)dto.getBodyMsgPSSysCssId())) {
            dto.setBodyMsgPSSysCssId(this.getRealPSModelId(t, dto.getBodyMsgPSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getBottomMsgPSSysCssId())) {
            dto.setBottomMsgPSSysCssId(this.getRealPSModelId(t, dto.getBottomMsgPSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            dto.setPSModuleId(this.getRealPSModelId(t, dto.getPSModuleId()).replace("/", "."));
        }
        if ("PSMODULE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSModuleId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            dto.setPSSysDynaModelId(this.getRealPSModelId(t, dto.getPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            dto.setPSSystemId(this.getRealPSModelId(t, dto.getPSSystemId()).replace("/", "."));
        }
        if ("PSSYSTEM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSystemId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTopMsgPSSysCssId())) {
            dto.setTopMsgPSSysCssId(this.getRealPSModelId(t, dto.getTopMsgPSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getBodyMsgPSSysCssId())) {
            linkDTO = (PSSysCssDTO)PSModelServiceUtil.getInstance().getPSSysCssService().getDTO(dto.getBodyMsgPSSysCssId());
            dto.setBodyMsgPSSysCssName(((PSSysCssDTO)linkDTO).getPSSysCssName());
        } else {
            dto.setBodyMsgPSSysCssName(null);
        }
        if (StringUtils.hasLength((String)dto.getBottomMsgPSSysCssId())) {
            linkDTO = (PSSysCssDTO)PSModelServiceUtil.getInstance().getPSSysCssService().getDTO(dto.getBottomMsgPSSysCssId());
            dto.setBottomMsgPSSysCssName(((PSSysCssDTO)linkDTO).getPSSysCssName());
        } else {
            dto.setBottomMsgPSSysCssName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            linkDTO = (PSModuleDTO)PSModelServiceUtil.getInstance().getPSModuleService().getDTO(dto.getPSModuleId());
            dto.setPSModuleName(((PSModuleDTO)linkDTO).getPSModuleName());
        } else {
            dto.setPSModuleName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            linkDTO = (PSSysDynaModelDTO)PSModelServiceUtil.getInstance().getPSSysDynaModelService().getDTO(dto.getPSSysDynaModelId());
            dto.setPSSysDynaModelName(((PSSysDynaModelDTO)linkDTO).getPSSysDynaModelName());
        } else {
            dto.setPSSysDynaModelName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            linkDTO = (PSSystemDTO)PSModelServiceUtil.getInstance().getPSSystemService().getDTO(dto.getPSSystemId());
            dto.setPSSystemName(((PSSystemDTO)linkDTO).getPSSystemName());
        } else {
            dto.setPSSystemName(null);
        }
        if (StringUtils.hasLength((String)dto.getTopMsgPSSysCssId())) {
            linkDTO = (PSSysCssDTO)PSModelServiceUtil.getInstance().getPSSysCssService().getDTO(dto.getTopMsgPSSysCssId());
            dto.setTopMsgPSSysCssName(((PSSysCssDTO)linkDTO).getPSSysCssName());
        } else {
            dto.setTopMsgPSSysCssName(null);
        }
        List<PSViewMsgGrpDetail> list = PSModelServiceUtil.getInstance().getPSViewMsgGrpDetailService().listByPSViewMsgGroup(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSViewMsgGrpDetailDTO> psviewmsggrpdetails = new ArrayList<PSViewMsgGrpDetailDTO>();
            for (PSViewMsgGrpDetail item : list) {
                PSViewMsgGrpDetailDTO dstItem = (PSViewMsgGrpDetailDTO)PSModelServiceUtil.getInstance().getPSViewMsgGrpDetailService().toDTO(item);
                psviewmsggrpdetails.add(dstItem);
            }
            dto.setPsviewmsggrpdetails(psviewmsggrpdetails);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSVIEWMSGGROUP";
    }

    @Override
    public PSViewMsgGroup createDomain() {
        return new PSViewMsgGroup();
    }

    @Override
    public PSViewMsgGroupDTO createDTO() {
        return new PSViewMsgGroupDTO();
    }
}

