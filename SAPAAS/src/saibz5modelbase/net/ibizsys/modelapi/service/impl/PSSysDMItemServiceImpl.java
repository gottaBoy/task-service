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
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.domain.PSSysDMItem;
import net.ibizsys.modelapi.domain.PSSystemDBCfg;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSSysDMItemDTO;
import net.ibizsys.modelapi.dto.PSSysDMVerDTO;
import net.ibizsys.modelapi.dto.PSSystemDBCfgDTO;
import net.ibizsys.modelapi.service.IPSSysDMItemService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysDMItemServiceImpl
extends PSModelServiceImplBase<PSSysDMItem, PSSysDMItemDTO>
implements IPSSysDMItemService {
    private static final Log log = LogFactory.getLog(PSSysDMItemServiceImpl.class);

    @Override
    public List<PSSysDMItem> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysDMItem get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysDMItem> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSSysDMItem item : list) {
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
    public List<PSSysDMItemDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSSysDMItem> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSSysDMItemDTO> dtoList = new ArrayList<PSSysDMItemDTO>();
            for (PSSysDMItem item : list) {
                PSSysDMItemDTO dto = (PSSysDMItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysDMItem> listByPSSystemDBCfg(PSSystemDBCfg parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysDMItem get(PSSystemDBCfg parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysDMItem> list = this.listByPSSystemDBCfg(parent);
        if (list != null) {
            for (PSSysDMItem item : list) {
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
    public List<PSSysDMItemDTO> listDTOByPSSystemDBCfg(String strParentKey) throws Exception {
        PSSystemDBCfg pssystemdbcfg = (PSSystemDBCfg)PSModelServiceUtil.getInstance().getPSSystemDBCfgService().get(strParentKey);
        List<PSSysDMItem> list = this.listByPSSystemDBCfg(pssystemdbcfg);
        if (list != null) {
            ArrayList<PSSysDMItemDTO> dtoList = new ArrayList<PSSysDMItemDTO>();
            for (PSSysDMItem item : list) {
                PSSysDMItemDTO dto = (PSSysDMItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysDMItem> onListAll() throws Exception {
        List<PSSystemDBCfg> pssystemdbcfgs;
        ArrayList<PSSysDMItem> list = new ArrayList<PSSysDMItem>();
        List<PSDataEntity> psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll();
        if (psdataentities != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSSysDMItem> items = this.listByPSDataEntity(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pssystemdbcfgs = PSModelServiceUtil.getInstance().getPSSystemDBCfgService().listAll()) != null) {
            for (PSSystemDBCfg parent : pssystemdbcfgs) {
                List<PSSysDMItem> items = this.listByPSSystemDBCfg(parent);
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
    protected PSSysDMItem onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysDMItem item;
        PSSysDMItem item2;
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey, true);
        if (psdataentity != null && (item2 = this.get(psdataentity, strCurKey, true)) != null) {
            return item2;
        }
        PSSystemDBCfg pssystemdbcfg = (PSSystemDBCfg)PSModelServiceUtil.getInstance().getPSSystemDBCfgService().get(strParentKey, true);
        if (pssystemdbcfg != null && (item = this.get(pssystemdbcfg, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysDMItem)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysDMItemDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDataEntityService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSSystemDBCfgId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSystemDBCfgService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysDMItem et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSSysDMItemName())) {
            return et.getPSSysDMItemName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysDMItemDTO dto, PSSysDMItem t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysDMItemId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getCreateSql() != null || !bIgnoreNull) {
            dto.setCreateSql(t.getCreateSql());
        }
        if (t.getCreateSql2() != null || !bIgnoreNull) {
            dto.setCreateSql2(t.getCreateSql2());
        }
        if (t.getCreateSql3() != null || !bIgnoreNull) {
            dto.setCreateSql3(t.getCreateSql3());
        }
        if (t.getCreateSql4() != null || !bIgnoreNull) {
            dto.setCreateSql4(t.getCreateSql4());
        }
        if (t.getCreateSql5() != null || !bIgnoreNull) {
            dto.setCreateSql5(t.getCreateSql5());
        }
        if (t.getCreateSql6() != null || !bIgnoreNull) {
            dto.setCreateSql6(t.getCreateSql6());
        }
        if (t.getCreateSql7() != null || !bIgnoreNull) {
            dto.setCreateSql7(t.getCreateSql7());
        }
        if (t.getDBObjType() != null || !bIgnoreNull) {
            dto.setDBObjType(t.getDBObjType());
        }
        if (t.getDropSql() != null || !bIgnoreNull) {
            dto.setDropSql(t.getDropSql());
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
        if (t.getPSObjId() != null || !bIgnoreNull) {
            dto.setPSObjId(t.getPSObjId());
        }
        if (t.getPSObjName() != null || !bIgnoreNull) {
            dto.setPSObjName(t.getPSObjName());
        }
        if (t.getPSSysDMItemName() != null || !bIgnoreNull) {
            dto.setPSSysDMItemName(t.getPSSysDMItemName());
        }
        if (t.getPSSysDMVerId() != null || !bIgnoreNull) {
            dto.setPSSysDMVerId(t.getPSSysDMVerId());
        }
        if (t.getPSSysDMVerName() != null || !bIgnoreNull) {
            dto.setPSSysDMVerName(t.getPSSysDMVerName());
        }
        if (t.getPSSystemDBCfgId() != null || !bIgnoreNull) {
            dto.setPSSystemDBCfgId(t.getPSSystemDBCfgId());
        }
        if (t.getPSSystemDBCfgName() != null || !bIgnoreNull) {
            dto.setPSSystemDBCfgName(t.getPSSystemDBCfgName());
        }
        if (t.getSysDBVer() != null || !bIgnoreNull) {
            dto.setSysDBVer(t.getSysDBVer());
        }
        if (t.getTestSql() != null || !bIgnoreNull) {
            dto.setTestSql(t.getTestSql());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (t.getUserFlag() != null || !bIgnoreNull) {
            dto.setUserFlag(t.getUserFlag());
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if ("PSDATAENTITY".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDMVerId())) {
            dto.setPSSysDMVerId(this.getRealPSModelId(t, dto.getPSSysDMVerId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSystemDBCfgId())) {
            dto.setPSSystemDBCfgId(this.getRealPSModelId(t, dto.getPSSystemDBCfgId()).replace("/", "."));
        }
        if ("PSSYSTEMDBCFG".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSystemDBCfgId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDMVerId())) {
            linkDTO = (PSSysDMVerDTO)PSModelServiceUtil.getInstance().getPSSysDMVerService().getDTO(dto.getPSSysDMVerId());
            dto.setPSSysDMVerName(((PSSysDMVerDTO)linkDTO).getPSSysDMVerName());
        } else {
            dto.setPSSysDMVerName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSystemDBCfgId())) {
            linkDTO = (PSSystemDBCfgDTO)PSModelServiceUtil.getInstance().getPSSystemDBCfgService().getDTO(dto.getPSSystemDBCfgId());
            dto.setPSSystemDBCfgName(((PSSystemDBCfgDTO)linkDTO).getPSSystemDBCfgName());
        } else {
            dto.setPSSystemDBCfgName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSYSDMITEM";
    }

    @Override
    public PSSysDMItem createDomain() {
        return new PSSysDMItem();
    }

    @Override
    public PSSysDMItemDTO createDTO() {
        return new PSSysDMItemDTO();
    }
}

