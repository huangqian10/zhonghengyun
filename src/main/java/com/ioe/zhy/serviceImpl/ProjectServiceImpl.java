package com.ioe.zhy.serviceImpl;

import com.ioe.common.util.Constants;
import com.ioe.common.util.ZRIGenerater;
import com.ioe.zhy.dao.ProjectDao;
import com.ioe.zhy.entity.Project;
import com.ioe.zhy.service.ProjectService;
import com.ioe.zhy.util.ListResult;
import com.ioe.zhy.util.Result;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by wangqiyun on 2017/1/18.
 */
@Service("projectService")
@Transactional
public class ProjectServiceImpl implements ProjectService {
    private static final String SERVICE_NAME = "zhy/t_WatchProjectService";
    @Resource
    private ProjectDao projectDao;

    /**
     * 添加工程接入
     * @param category 分类编码
     * @param content 检查内容
     * @param result 检查结果
     * @param status 状态
     * @param powerClientId 用电客户id
     * @param electricianId 电工id
     * @param serviceCompanyId 服务商id
     * @return 插入结果
     */
    @Override
    public Result saveProjectRecord(String category, String content, String result, boolean status, String powerClientId, String electricianId, String serviceCompanyId) {
        Result result1 = new Result();

        try {
            Project project = new Project();
            project.setRecord_id(ZRIGenerater.generate(SERVICE_NAME));
            project.setCategory(category);
            project.setContent(content);
            project.setResult(result);
            project.setStatus(status);
            project.setPowerClient_id(powerClientId);
            project.setElectrician_id(electricianId);
            project.setService_company_id(serviceCompanyId);
            if (projectDao.addProject(project)) return result1;
        } catch (Exception e) {
        }
        result1.setCode(Constants.SERVICE_ERROR);
        result1.setMessage("error");
        return result1;
    }

    /**
     * 更新工程接入
     * @param recordId 记录id
     * @param category 分类编码
     * @param content 检查内容
     * @param result 检查结果
     * @param status 状态
     * @param powerClientId 用电客户id
     * @param electricianId 电工id
     * @param serviceCompanyId 服务商id
     * @return 更新结果
     */
    @Override
    public Result updateProjectRecord(String recordId, String category, String content, String result, boolean status, String powerClientId, String electricianId, String serviceCompanyId) {
        Result result1 = new Result();

        try {
            Project project = new Project();
            project.setRecord_id(recordId);
            project.setCategory(category);
            project.setContent(content);
            project.setResult(result);
            project.setStatus(status);
            project.setPowerClient_id(powerClientId);
            project.setElectrician_id(electricianId);
            project.setService_company_id(serviceCompanyId);
            if (projectDao.updateProject(project)) return result1;
        } catch (Exception e) {
        }

        result1.setCode(Constants.SERVICE_ERROR);
        result1.setMessage("error");
        return result1;
    }

    /**
     * 工程接入查询
     * @param powerClientId 用电客户id
     * @return 查询结果
     */
    @Override
    public ListResult<Project> getProjectRecord(String powerClientId) {
        ListResult<Project> result = new ListResult<>();
        result.setDataList(projectDao.getProjrct(powerClientId));
        return result;
    }
}
