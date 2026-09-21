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
import net.ibizsys.modelapi.domain.PSWFLink;
import net.ibizsys.modelapi.domain.PSWFLinkRole;
import net.ibizsys.modelapi.dto.PSSysMsgTemplDTO;
import net.ibizsys.modelapi.dto.PSWFLinkDTO;
import net.ibizsys.modelapi.dto.PSWFLinkRoleDTO;
import net.ibizsys.modelapi.dto.PSWFProcRoleDTO;
import net.ibizsys.modelapi.service.IPSWFLinkRoleService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSWFLinkRoleServiceImpl
extends PSModelServiceImplBase<PSWFLinkRole, PSWFLinkRoleDTO>
implements IPSWFLinkRoleService {
    private static final Log log = LogFactory.getLog(PSWFLinkRoleServiceImpl.class);

    @Override
    public List<PSWFLinkRole> listByPSWFLink(PSWFLink parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSWFLinkRole get(PSWFLink parent, String strKey, boolean bTryMode) throws Exception {
        List<PSWFLinkRole> list = this.listByPSWFLink(parent);
        if (list != null) {
            for (PSWFLinkRole item : list) {
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
    public List<PSWFLinkRoleDTO> listDTOByPSWFLink(String strParentKey) throws Exception {
        PSWFLink pswflink = (PSWFLink)PSModelServiceUtil.getInstance().getPSWFLinkService().get(strParentKey);
        List<PSWFLinkRole> list = this.listByPSWFLink(pswflink);
        if (list != null) {
            ArrayList<PSWFLinkRoleDTO> dtoList = new ArrayList<PSWFLinkRoleDTO>();
            for (PSWFLinkRole item : list) {
                PSWFLinkRoleDTO dto = (PSWFLinkRoleDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSWFLinkRole> onListAll() throws Exception {
        ArrayList<PSWFLinkRole> list = new ArrayList<PSWFLinkRole>();
        List pswflinks = PSModelServiceUtil.getInstance().getPSWFLinkService().listAll();
        if (pswflinks != null) {
            for (PSWFLink parent : pswflinks) {
                List<PSWFLinkRole> items = this.listByPSWFLink(parent);
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
    protected PSWFLinkRole onGet(String strParentKey, String strCurKey) throws Exception {
        PSWFLinkRole item;
        PSWFLink pswflink = (PSWFLink)PSModelServiceUtil.getInstance().getPSWFLinkService().get(strParentKey, true);
        if (pswflink != null && (item = this.get(pswflink, strCurKey, true)) != null) {
            return item;
        }
        return (PSWFLinkRole)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSWFLinkRoleDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSWFLinkId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSWFLinkService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSWFLinkRole et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSWFLinkRoleName())) {
            return et.getPSWFLinkRoleName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSWFLinkRoleDTO dto, PSWFLinkRole t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSWFLinkRoleId(t.getId().replace("/", "."));
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
        if (t.getPSWFLinkId() != null || !bIgnoreNull) {
            dto.setPSWFLinkId(t.getPSWFLinkId());
        }
        if (t.getPSWFLinkName() != null || !bIgnoreNull) {
            dto.setPSWFLinkName(t.getPSWFLinkName());
        }
        if (t.getPSWFLinkRoleName() != null || !bIgnoreNull) {
            dto.setPSWFLinkRoleName(t.getPSWFLinkRoleName());
        }
        if (t.getPSWFProcessId() != null || !bIgnoreNull) {
            dto.setPSWFProcessId(t.getPSWFProcessId());
        }
        if (t.getPSWFProcRoleId() != null || !bIgnoreNull) {
            dto.setPSWFProcRoleId(t.getPSWFProcRoleId());
        }
        if (t.getPSWFProcRoleName() != null || !bIgnoreNull) {
            dto.setPSWFProcRoleName(t.getPSWFProcRoleName());
        }
        if (t.getPSWFVersionId() != null || !bIgnoreNull) {
            dto.setPSWFVersionId(t.getPSWFVersionId());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (StringUtils.hasLength((String)dto.getPSSysMsgTemplId())) {
            dto.setPSSysMsgTemplId(this.getRealPSModelId(t, dto.getPSSysMsgTemplId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWFLinkId())) {
            dto.setPSWFLinkId(this.getRealPSModelId(t, dto.getPSWFLinkId()).replace("/", "."));
        }
        if ("PSWFLINK".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSWFLinkId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWFProcRoleId())) {
            dto.setPSWFProcRoleId(this.getRealPSModelId(t, dto.getPSWFProcRoleId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysMsgTemplId())) {
            linkDTO = (PSSysMsgTemplDTO)PSModelServiceUtil.getInstance().getPSSysMsgTemplService().getDTO(dto.getPSSysMsgTemplId());
            dto.setPSSysMsgTemplName(((PSSysMsgTemplDTO)linkDTO).getPSSysMsgTemplName());
        } else {
            dto.setPSSysMsgTemplName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSWFLinkId())) {
            linkDTO = (PSWFLinkDTO)PSModelServiceUtil.getInstance().getPSWFLinkService().getDTO(dto.getPSWFLinkId());
            dto.setPSWFLinkName(((PSWFLinkDTO)linkDTO).getPSWFLinkName());
            dto.setPSWFProcessId(((PSWFLinkDTO)linkDTO).getFromPSWFProcId());
            dto.setPSWFVersionId(((PSWFLinkDTO)linkDTO).getPSWFVersionId());
        } else {
            dto.setPSWFLinkName(null);
            dto.setPSWFProcessId(null);
            dto.setPSWFVersionId(null);
        }
        if (StringUtils.hasLength((String)dto.getPSWFProcRoleId())) {
            linkDTO = (PSWFProcRoleDTO)PSModelServiceUtil.getInstance().getPSWFProcRoleService().getDTO(dto.getPSWFProcRoleId());
            dto.setPSWFProcRoleName(((PSWFProcRoleDTO)linkDTO).getPSWFProcRoleName());
        } else {
            dto.setPSWFProcRoleName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSWFLINKROLE";
    }

    @Override
    public PSWFLinkRole createDomain() {
        return new PSWFLinkRole();
    }

    @Override
    public PSWFLinkRoleDTO createDTO() {
        return new PSWFLinkRoleDTO();
    }
}

