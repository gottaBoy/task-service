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
import net.ibizsys.modelapi.domain.PSSystemDBCfg;
import net.ibizsys.modelapi.dto.PSSystemDBCfgDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSSystemDBCfgService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSystemDBCfgServiceImpl
extends PSModelServiceImplBase<PSSystemDBCfg, PSSystemDBCfgDTO>
implements IPSSystemDBCfgService {
    private static final Log log = LogFactory.getLog(PSSystemDBCfgServiceImpl.class);

    @Override
    public List<PSSystemDBCfg> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSystemDBCfg get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSystemDBCfg> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSSystemDBCfg item : list) {
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
    public List<PSSystemDBCfgDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSSystemDBCfg> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSSystemDBCfgDTO> dtoList = new ArrayList<PSSystemDBCfgDTO>();
            for (PSSystemDBCfg item : list) {
                PSSystemDBCfgDTO dto = (PSSystemDBCfgDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSystemDBCfg> onListAll() throws Exception {
        ArrayList<PSSystemDBCfg> list = new ArrayList<PSSystemDBCfg>();
        List pssystems = PSModelServiceUtil.getInstance().getPSSystemService().listAll();
        if (pssystems != null) {
            for (PSSystem parent : pssystems) {
                List<PSSystemDBCfg> items = this.listByPSSystem(parent);
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
    protected PSSystemDBCfg onGet(String strParentKey, String strCurKey) throws Exception {
        PSSystemDBCfg item;
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey, true);
        if (pssystem != null && (item = this.get(pssystem, strCurKey, true)) != null) {
            return item;
        }
        return (PSSystemDBCfg)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSystemDBCfgDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSystemId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSystemService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSystemDBCfg et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSSystemDBCfgName())) {
            return et.getPSSystemDBCfgName();
        }
        if (StringUtils.hasLength((String)et.getPSSystemDBCfgName())) {
            return et.getPSSystemDBCfgName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSystemDBCfgDTO dto, PSSystemDBCfg t, boolean bIgnoreNull) throws Exception {
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSystemDBCfgId(t.getId().replace("/", "."));
        }
        if (t.getAppendSchema() != null || !bIgnoreNull) {
            dto.setAppendSchema(t.getAppendSchema());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDBSchemaName() != null || !bIgnoreNull) {
            dto.setDBSchemaName(t.getDBSchemaName());
        }
        if (t.getDefaultFlag() != null || !bIgnoreNull) {
            dto.setDefaultFlag(t.getDefaultFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getNo2PSDBDevInstId() != null || !bIgnoreNull) {
            dto.setNo2PSDBDevInstId(t.getNo2PSDBDevInstId());
        }
        if (t.getNo2PSDBDevInstName() != null || !bIgnoreNull) {
            dto.setNo2PSDBDevInstName(t.getNo2PSDBDevInstName());
        }
        if (t.getNo2PSDCDBInstId() != null || !bIgnoreNull) {
            dto.setNo2PSDCDBInstId(t.getNo2PSDCDBInstId());
        }
        if (t.getNo2PSDCDBInstName() != null || !bIgnoreNull) {
            dto.setNo2PSDCDBInstName(t.getNo2PSDCDBInstName());
        }
        if (t.getNoDBInstMode() != null || !bIgnoreNull) {
            dto.setNoDBInstMode(t.getNoDBInstMode());
        }
        if (t.getNullValOrder() != null || !bIgnoreNull) {
            dto.setNullValOrder(t.getNullValOrder());
        }
        if (t.getObjNameCase() != null || !bIgnoreNull) {
            dto.setObjNameCase(t.getObjNameCase());
        }
        if (t.getPSDBDevInstId() != null || !bIgnoreNull) {
            dto.setPSDBDevInstId(t.getPSDBDevInstId());
        }
        if (t.getPSDBDevInstName() != null || !bIgnoreNull) {
            dto.setPSDBDevInstName(t.getPSDBDevInstName());
        }
        if (t.getPSDevCenterDBInstId() != null || !bIgnoreNull) {
            dto.setPSDevCenterDBInstId(t.getPSDevCenterDBInstId());
        }
        if (t.getPSDevCenterDBInstName() != null || !bIgnoreNull) {
            dto.setPSDevCenterDBInstName(t.getPSDevCenterDBInstName());
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
        if (t.getPubCommentFlag() != null || !bIgnoreNull) {
            dto.setPubCommentFlag(t.getPubCommentFlag());
        }
        if (t.getPubDBModelFlag() != null || !bIgnoreNull) {
            dto.setPubDBModelFlag(t.getPubDBModelFlag());
        }
        if (t.getPubFKeyFlag() != null || !bIgnoreNull) {
            dto.setPubFKeyFlag(t.getPubFKeyFlag());
        }
        if (t.getPubIndexFlag() != null || !bIgnoreNull) {
            dto.setPubIndexFlag(t.getPubIndexFlag());
        }
        if (t.getPubViewFlag() != null || !bIgnoreNull) {
            dto.setPubViewFlag(t.getPubViewFlag());
        }
        if (t.getResInfo() != null || !bIgnoreNull) {
            dto.setResInfo(t.getResInfo());
        }
        if (t.getResReadyTime() != null || !bIgnoreNull) {
            dto.setResReadyTime(t.getResReadyTime());
        }
        if (t.getResState() != null || !bIgnoreNull) {
            dto.setResState(t.getResState());
        }
        if (t.getTabSpace() != null || !bIgnoreNull) {
            dto.setTabSpace(t.getTabSpace());
        }
        if (t.getTabSpace2() != null || !bIgnoreNull) {
            dto.setTabSpace2(t.getTabSpace2());
        }
        if (t.getTabSpace3() != null || !bIgnoreNull) {
            dto.setTabSpace3(t.getTabSpace3());
        }
        if (t.getTabSpace4() != null || !bIgnoreNull) {
            dto.setTabSpace4(t.getTabSpace4());
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
        return "PSSYSTEMDBCFG";
    }

    @Override
    public PSSystemDBCfg createDomain() {
        return new PSSystemDBCfg();
    }

    @Override
    public PSSystemDBCfgDTO createDTO() {
        return new PSSystemDBCfgDTO();
    }
}

