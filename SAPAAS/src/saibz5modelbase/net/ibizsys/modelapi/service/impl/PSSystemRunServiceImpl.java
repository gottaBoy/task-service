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
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.domain.PSSystemRun;
import net.ibizsys.modelapi.dto.PSSysAppDTO;
import net.ibizsys.modelapi.dto.PSSysBDInstCfgDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysSFPubDTO;
import net.ibizsys.modelapi.dto.PSSystemDBCfgDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.dto.PSSystemRunDTO;
import net.ibizsys.modelapi.service.IPSSystemRunService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSystemRunServiceImpl
extends PSModelServiceImplBase<PSSystemRun, PSSystemRunDTO>
implements IPSSystemRunService {
    private static final Log log = LogFactory.getLog(PSSystemRunServiceImpl.class);

    @Override
    public List<PSSystemRun> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSystemRun get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSystemRun> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSSystemRun item : list) {
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
    public List<PSSystemRunDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSSystemRun> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSSystemRunDTO> dtoList = new ArrayList<PSSystemRunDTO>();
            for (PSSystemRun item : list) {
                PSSystemRunDTO dto = (PSSystemRunDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSystemRun> onListAll() throws Exception {
        ArrayList<PSSystemRun> list = new ArrayList<PSSystemRun>();
        List<PSSystem> pssystems = PSModelServiceUtil.getInstance().getPSSystemService().listAll();
        if (pssystems != null) {
            for (PSSystem parent : pssystems) {
                List<PSSystemRun> items = this.listByPSSystem(parent);
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
    protected PSSystemRun onGet(String strParentKey, String strCurKey) throws Exception {
        PSSystemRun item;
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey, true);
        if (pssystem != null && (item = this.get(pssystem, strCurKey, true)) != null) {
            return item;
        }
        return (PSSystemRun)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSystemRunDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSystemId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSystemService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSystemRun et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSSystemRunName())) {
            return et.getPSSystemRunName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSystemRunDTO dto, PSSystemRun t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSystemRunId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDefaultFlag() != null || !bIgnoreNull) {
            dto.setDefaultFlag(t.getDefaultFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSSysAppId() != null || !bIgnoreNull) {
            dto.setPSSysAppId(t.getPSSysAppId());
        }
        if (t.getPSSysAppId2() != null || !bIgnoreNull) {
            dto.setPSSysAppId2(t.getPSSysAppId2());
        }
        if (t.getPSSysAppName() != null || !bIgnoreNull) {
            dto.setPSSysAppName(t.getPSSysAppName());
        }
        if (t.getPSSysAppName2() != null || !bIgnoreNull) {
            dto.setPSSysAppName2(t.getPSSysAppName2());
        }
        if (t.getPSSysBDInstCfgId() != null || !bIgnoreNull) {
            dto.setPSSysBDInstCfgId(t.getPSSysBDInstCfgId());
        }
        if (t.getPSSysBDInstCfgName() != null || !bIgnoreNull) {
            dto.setPSSysBDInstCfgName(t.getPSSysBDInstCfgName());
        }
        if (t.getPSSysSFPubId() != null || !bIgnoreNull) {
            dto.setPSSysSFPubId(t.getPSSysSFPubId());
        }
        if (t.getPSSysSFPubName() != null || !bIgnoreNull) {
            dto.setPSSysSFPubName(t.getPSSysSFPubName());
        }
        if (t.getPSSystemASId() != null || !bIgnoreNull) {
            dto.setPSSystemASId(t.getPSSystemASId());
        }
        if (t.getPSSystemASName() != null || !bIgnoreNull) {
            dto.setPSSystemASName(t.getPSSystemASName());
        }
        if (t.getPSSystemDBCfgId() != null || !bIgnoreNull) {
            dto.setPSSystemDBCfgId(t.getPSSystemDBCfgId());
        }
        if (t.getPSSystemDBCfgName() != null || !bIgnoreNull) {
            dto.setPSSystemDBCfgName(t.getPSSystemDBCfgName());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSSystemName() != null || !bIgnoreNull) {
            dto.setPSSystemName(t.getPSSystemName());
        }
        if (t.getPSSystemRunName() != null || !bIgnoreNull) {
            dto.setPSSystemRunName(t.getPSSystemRunName());
        }
        if (t.getRunPSSysDynaModelId() != null || !bIgnoreNull) {
            dto.setRunPSSysDynaModelId(t.getRunPSSysDynaModelId());
        }
        if (t.getRunPSSysDynaModelName() != null || !bIgnoreNull) {
            dto.setRunPSSysDynaModelName(t.getRunPSSysDynaModelName());
        }
        if (t.getStopWhenTemplError() != null || !bIgnoreNull) {
            dto.setStopWhenTemplError(t.getStopWhenTemplError());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (StringUtils.hasLength((String)dto.getPSSysAppId())) {
            dto.setPSSysAppId(this.getRealPSModelId(t, dto.getPSSysAppId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysAppId2())) {
            dto.setPSSysAppId2(this.getRealPSModelId(t, dto.getPSSysAppId2()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysBDInstCfgId())) {
            dto.setPSSysBDInstCfgId(this.getRealPSModelId(t, dto.getPSSysBDInstCfgId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPubId())) {
            dto.setPSSysSFPubId(this.getRealPSModelId(t, dto.getPSSysSFPubId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSystemDBCfgId())) {
            dto.setPSSystemDBCfgId(this.getRealPSModelId(t, dto.getPSSystemDBCfgId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            dto.setPSSystemId(this.getRealPSModelId(t, dto.getPSSystemId()).replace("/", "."));
        }
        if ("PSSYSTEM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSystemId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRunPSSysDynaModelId())) {
            dto.setRunPSSysDynaModelId(this.getRealPSModelId(t, dto.getRunPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysAppId())) {
            linkDTO = (PSSysAppDTO)PSModelServiceUtil.getInstance().getPSSysAppService().getDTO(dto.getPSSysAppId());
            dto.setPSSysAppName(((PSSysAppDTO)linkDTO).getPSSysAppName());
        } else {
            dto.setPSSysAppName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysAppId2())) {
            linkDTO = (PSSysAppDTO)PSModelServiceUtil.getInstance().getPSSysAppService().getDTO(dto.getPSSysAppId2());
            dto.setPSSysAppName2(((PSSysAppDTO)linkDTO).getPSSysAppName());
        } else {
            dto.setPSSysAppName2(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysBDInstCfgId())) {
            linkDTO = (PSSysBDInstCfgDTO)PSModelServiceUtil.getInstance().getPSSysBDInstCfgService().getDTO(dto.getPSSysBDInstCfgId());
            dto.setPSSysBDInstCfgName(((PSSysBDInstCfgDTO)linkDTO).getPSSysBDInstCfgName());
        } else {
            dto.setPSSysBDInstCfgName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPubId())) {
            linkDTO = (PSSysSFPubDTO)PSModelServiceUtil.getInstance().getPSSysSFPubService().getDTO(dto.getPSSysSFPubId());
            dto.setPSSysSFPubName(((PSSysSFPubDTO)linkDTO).getPSSysSFPubName());
        } else {
            dto.setPSSysSFPubName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSystemDBCfgId())) {
            linkDTO = (PSSystemDBCfgDTO)PSModelServiceUtil.getInstance().getPSSystemDBCfgService().getDTO(dto.getPSSystemDBCfgId());
            dto.setPSSystemDBCfgName(((PSSystemDBCfgDTO)linkDTO).getPSSystemDBCfgName());
        } else {
            dto.setPSSystemDBCfgName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            linkDTO = (PSSystemDTO)PSModelServiceUtil.getInstance().getPSSystemService().getDTO(dto.getPSSystemId());
            dto.setPSSystemName(((PSSystemDTO)linkDTO).getPSSystemName());
        } else {
            dto.setPSSystemName(null);
        }
        if (StringUtils.hasLength((String)dto.getRunPSSysDynaModelId())) {
            linkDTO = (PSSysDynaModelDTO)PSModelServiceUtil.getInstance().getPSSysDynaModelService().getDTO(dto.getRunPSSysDynaModelId());
            dto.setRunPSSysDynaModelName(((PSSysDynaModelDTO)linkDTO).getPSSysDynaModelName());
        } else {
            dto.setRunPSSysDynaModelName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSYSTEMRUN";
    }

    @Override
    public PSSystemRun createDomain() {
        return new PSSystemRun();
    }

    @Override
    public PSSystemRunDTO createDTO() {
        return new PSSystemRunDTO();
    }
}

