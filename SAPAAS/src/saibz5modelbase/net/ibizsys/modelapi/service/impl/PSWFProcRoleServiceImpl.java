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
import net.ibizsys.modelapi.domain.PSWFProcRole;
import net.ibizsys.modelapi.domain.PSWFProcess;
import net.ibizsys.modelapi.dto.PSSysMsgTemplDTO;
import net.ibizsys.modelapi.dto.PSWFProcRoleDTO;
import net.ibizsys.modelapi.dto.PSWFProcessDTO;
import net.ibizsys.modelapi.dto.PSWFRoleDTO;
import net.ibizsys.modelapi.dto.PSWFVersionDTO;
import net.ibizsys.modelapi.service.IPSWFProcRoleService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSWFProcRoleServiceImpl
extends PSModelServiceImplBase<PSWFProcRole, PSWFProcRoleDTO>
implements IPSWFProcRoleService {
    private static final Log log = LogFactory.getLog(PSWFProcRoleServiceImpl.class);

    @Override
    public List<PSWFProcRole> listByPSWFProcess(PSWFProcess parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSWFProcRole get(PSWFProcess parent, String strKey, boolean bTryMode) throws Exception {
        List<PSWFProcRole> list = this.listByPSWFProcess(parent);
        if (list != null) {
            for (PSWFProcRole item : list) {
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
    public List<PSWFProcRoleDTO> listDTOByPSWFProcess(String strParentKey) throws Exception {
        PSWFProcess pswfprocess = (PSWFProcess)PSModelServiceUtil.getInstance().getPSWFProcessService().get(strParentKey);
        List<PSWFProcRole> list = this.listByPSWFProcess(pswfprocess);
        if (list != null) {
            ArrayList<PSWFProcRoleDTO> dtoList = new ArrayList<PSWFProcRoleDTO>();
            for (PSWFProcRole item : list) {
                PSWFProcRoleDTO dto = (PSWFProcRoleDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSWFProcRole> onListAll() throws Exception {
        ArrayList<PSWFProcRole> list = new ArrayList<PSWFProcRole>();
        List<PSWFProcess> pswfprocesses = PSModelServiceUtil.getInstance().getPSWFProcessService().listAll();
        if (pswfprocesses != null) {
            for (PSWFProcess parent : pswfprocesses) {
                List<PSWFProcRole> items = this.listByPSWFProcess(parent);
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
    protected PSWFProcRole onGet(String strParentKey, String strCurKey) throws Exception {
        PSWFProcRole item;
        PSWFProcess pswfprocess = (PSWFProcess)PSModelServiceUtil.getInstance().getPSWFProcessService().get(strParentKey, true);
        if (pswfprocess != null && (item = this.get(pswfprocess, strCurKey, true)) != null) {
            return item;
        }
        return (PSWFProcRole)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSWFProcRoleDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSWFProcessId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSWFProcessService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSWFProcRole et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSWFProcRoleName())) {
            return et.getPSWFProcRoleName();
        }
        if (StringUtils.hasLength((String)et.getPSWFProcRoleName())) {
            return et.getPSWFProcRoleName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSWFProcRoleDTO dto, PSWFProcRole t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSWFProcRoleId(t.getId().replace("/", "."));
        }
        if (t.getCCMode() != null || !bIgnoreNull) {
            dto.setCCMode(t.getCCMode());
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
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSSysMsgTemplId() != null || !bIgnoreNull) {
            dto.setPSSysMsgTemplId(t.getPSSysMsgTemplId());
        }
        if (t.getPSSysMsgTemplName() != null || !bIgnoreNull) {
            dto.setPSSysMsgTemplName(t.getPSSysMsgTemplName());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSWFID() != null || !bIgnoreNull) {
            dto.setPSWFID(t.getPSWFID());
        }
        if (t.getPSWFProcessId() != null || !bIgnoreNull) {
            dto.setPSWFProcessId(t.getPSWFProcessId());
        }
        if (t.getPSWFProcessName() != null || !bIgnoreNull) {
            dto.setPSWFProcessName(t.getPSWFProcessName());
        }
        if (t.getPSWFProcRoleName() != null || !bIgnoreNull) {
            dto.setPSWFProcRoleName(t.getPSWFProcRoleName());
        }
        if (t.getPSWFRoleId() != null || !bIgnoreNull) {
            dto.setPSWFRoleId(t.getPSWFRoleId());
        }
        if (t.getPSWFRoleName() != null || !bIgnoreNull) {
            dto.setPSWFRoleName(t.getPSWFRoleName());
        }
        if (t.getPSWFVersionId() != null || !bIgnoreNull) {
            dto.setPSWFVersionId(t.getPSWFVersionId());
        }
        if (t.getPSWFVersionName() != null || !bIgnoreNull) {
            dto.setPSWFVersionName(t.getPSWFVersionName());
        }
        if (t.getRoleType() != null || !bIgnoreNull) {
            dto.setRoleType(t.getRoleType());
        }
        if (t.getUDFields() != null || !bIgnoreNull) {
            dto.setUDFields(t.getUDFields());
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
        if (t.getUserData() != null || !bIgnoreNull) {
            dto.setUserData(t.getUserData());
        }
        if (t.getUserData2() != null || !bIgnoreNull) {
            dto.setUserData2(t.getUserData2());
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
        if (StringUtils.hasLength((String)dto.getPSSysMsgTemplId())) {
            dto.setPSSysMsgTemplId(this.getRealPSModelId(t, dto.getPSSysMsgTemplId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWFProcessId())) {
            dto.setPSWFProcessId(this.getRealPSModelId(t, dto.getPSWFProcessId()).replace("/", "."));
        }
        if ("PSWFPROCESS".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSWFProcessId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWFRoleId())) {
            dto.setPSWFRoleId(this.getRealPSModelId(t, dto.getPSWFRoleId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWFVersionId())) {
            dto.setPSWFVersionId(this.getRealPSModelId(t, dto.getPSWFVersionId()).replace("/", "."));
        } else {
            dto.setPSWFVersionId(this.getRealPSModelId(t, "<PSWFVERSION>").replace("/", "."));
        }
        if ("PSWFVERSION".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSWFVersionId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysMsgTemplId())) {
            linkDTO = (PSSysMsgTemplDTO)PSModelServiceUtil.getInstance().getPSSysMsgTemplService().getDTO(dto.getPSSysMsgTemplId());
            dto.setPSSysMsgTemplName(((PSSysMsgTemplDTO)linkDTO).getPSSysMsgTemplName());
        } else {
            dto.setPSSysMsgTemplName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSWFProcessId())) {
            linkDTO = (PSWFProcessDTO)PSModelServiceUtil.getInstance().getPSWFProcessService().getDTO(dto.getPSWFProcessId());
            dto.setPSSystemId(((PSWFProcessDTO)linkDTO).getPSSystemId());
            dto.setPSWFProcessName(((PSWFProcessDTO)linkDTO).getPSWFProcessName());
        } else {
            dto.setPSSystemId(null);
            dto.setPSWFProcessName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSWFRoleId())) {
            linkDTO = (PSWFRoleDTO)PSModelServiceUtil.getInstance().getPSWFRoleService().getDTO(dto.getPSWFRoleId());
            dto.setPSWFRoleName(((PSWFRoleDTO)linkDTO).getPSWFRoleName());
        } else {
            dto.setPSWFRoleName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSWFVersionId())) {
            linkDTO = (PSWFVersionDTO)PSModelServiceUtil.getInstance().getPSWFVersionService().getDTO(dto.getPSWFVersionId());
            dto.setPSWFID(((PSWFVersionDTO)linkDTO).getPSWFId());
            dto.setPSWFVersionName(((PSWFVersionDTO)linkDTO).getPSWFVersionName());
        } else {
            dto.setPSWFID(null);
            dto.setPSWFVersionName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSWFPROCROLE";
    }

    @Override
    public PSWFProcRole createDomain() {
        return new PSWFProcRole();
    }

    @Override
    public PSWFProcRoleDTO createDTO() {
        return new PSWFProcRoleDTO();
    }
}

