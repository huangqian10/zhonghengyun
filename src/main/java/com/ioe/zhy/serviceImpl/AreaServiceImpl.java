package com.ioe.zhy.serviceImpl;

import com.ioe.common.util.Constants;
import com.ioe.common.util.ZRIGenerater;
import com.ioe.zhy.dao.AreaDao;
import com.ioe.zhy.dao.ElectricianDao;
import com.ioe.zhy.dao.PowerClientAreaDao;
import com.ioe.zhy.entity.Area;
import com.ioe.zhy.entity.PowerClientArea;
import com.ioe.zhy.service.AreaService;
import com.ioe.zhy.util.ListResult;
import com.ioe.zhy.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by wangqiyun on 2017/1/19.
 */
@Service("areaService")
public class AreaServiceImpl implements AreaService {
    private static final String SERVICE_NAME = "zhy/t_AreaService";
    @Resource
    AreaDao areaDao;
    @Resource
    PowerClientAreaDao powerClientAreaDao;
    @Resource
    ElectricianDao electricianDao;

    @Override
    public Result addArea(String companyId, String areaName) {
        Result result1 = new Result();

        try {
            Area area = new Area();
            area.setArea_id(ZRIGenerater.generate(SERVICE_NAME));
            area.setArea_name(areaName);
            area.setCompany_id(companyId);
            if (areaDao.add(area)) return result1;
        } catch (Exception e) {
        }
        result1.setCode(Constants.SERVICE_ERROR);
        result1.setMessage("error");
        return result1;
    }

    @Override
    public Result updateArea(String areaId, String areaName) {
        Result result1 = new Result();

        try {
            Area area = new Area();
            area.setArea_id(areaId);
            area.setArea_name(areaName);
            if (areaDao.update(area)) return result1;
        } catch (Exception e) {
        }
        result1.setCode(Constants.SERVICE_ERROR);
        result1.setMessage("error");
        return result1;
    }

    @Override
    public Result deleteArea(String areaId) {
        Result result1 = new Result();

        try {
            powerClientAreaDao.deleteByArea(areaId);
            electricianDao.deleteElectricianByArea(areaId);
            if (areaDao.delete(areaId)) return result1;
        } catch (Exception e) {
        }
        result1.setCode(Constants.SERVICE_ERROR);
        result1.setMessage("error");
        return result1;
    }

    @Override
    public ListResult<Map<String, Object>> getAreaByCompanyId(String companyId) {
        List<Map<String, Object>> result = areaDao.getByCompanyId(companyId);
        ListResult<Map<String, Object>> result1 = new ListResult<>();
        result1.setDataList(result);
        return result1;
    }

    @Override
    public Result bindElectricianAndArea(String electricianId, String areaId) {
        electricianDao.electricianAndArea(electricianId, "1", areaId);
        Result result = new Result();
        return result;
    }

    @Override
    public Result unBindElectricianAndArea(String electricianId, String areaId) {
        electricianDao.electricianAndArea(electricianId, "1", null);
        Result result = new Result();
        return result;
    }

    @Override
    public Result bindPowerClientAndArea(String powerClientId, String areaId) {
        PowerClientArea powerClientArea = new PowerClientArea(), t;
        powerClientArea.setPowerClient_id(powerClientId);
        powerClientArea.setArea_id(areaId);
        t = powerClientAreaDao.get(powerClientArea);
        if (t == null)
            powerClientAreaDao.add(powerClientArea);
        Result result = new Result();
        return result;
    }

    @Override
    public Result unBindPowerClientAndArea(String powerClientId, String areaId) {
        PowerClientArea powerClientArea = new PowerClientArea();
        powerClientArea.setPowerClient_id(powerClientId);
        powerClientArea.setArea_id(areaId);
        powerClientAreaDao.delete(powerClientArea);
        Result result = new Result();
        return result;
    }
}
