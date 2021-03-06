/**
 * 
 */
package com.ioe.zhy.serviceImpl;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ioe.common.util.Constants;
import com.ioe.common.util.ZRIGenerater;
import com.ioe.zhy.dao.ElectricianDao;
import com.ioe.zhy.dao.UserPowerClientFavorDao;
import com.ioe.zhy.entity.Electrician;
import com.ioe.zhy.entity.WatchPlan;
import com.ioe.zhy.entity.WatchRecord;
import com.ioe.zhy.service.AssetAccountService;
import com.ioe.zhy.service.WatchManageService;
import com.ioe.zhy.util.DataResult;
import com.ioe.zhy.util.ListResult;
import com.ioe.zhy.util.Result;

/**
 * @author hq
 *
 */
@Service("assetAccountService")
@Transactional
public class AssetAccountServiceImpl implements AssetAccountService {

	private final Logger LOG = LoggerFactory.getLogger(AssetAccountService.class);

	private static final String SERVICE_NAME = "zhy/t_AssetAccountService";

	@Resource
	private ElectricianDao electricianDao;
	
	@Resource
	private UserPowerClientFavorDao userPowerClientFavorDao;

	@Override
	public Result addElectrician(String netLicence, String specialCertificate, String professionalCredential,
			String areaId, String accountId, String employeeId) {

		Result result = new Result();

		try {
			
			Electrician electrician = new Electrician();
			electrician.setElectrician_id(ZRIGenerater.generate(SERVICE_NAME));
			electrician.setNetwork_licence(netLicence);
			electrician.setSpecial_certificate(specialCertificate);
			electrician.setProfessional_credential(professionalCredential);
			electrician.setArea_id(areaId);
			electrician.setAccount_id(accountId);
			electrician.setEmployee_id(employeeId);
			electrician.setSys_create_time(new Date());
			electrician.setSys_hash("3");
			electricianDao.addElectrician(electrician);
			result.setMessage("success");
		} catch (Exception e) {
	
			LOG.error("addElectrician error");
			result.setCode(Constants.SERVICE_ERROR);
			result.setMessage("addElectrician error");

		}
		return result;
	}


	@Override
	public Result updateElectrician(String electricianId, String netLicence, String specialCertificate,
			String professionalCredential, String areaId, String accountId, String employeeId) {

		Result result = new Result();
		try {
			Electrician electrician = new Electrician();
			electrician.setElectrician_id(electricianId);
			electrician.setNetwork_licence(netLicence);
			electrician.setSpecial_certificate(specialCertificate);
			electrician.setProfessional_credential(professionalCredential);
			electrician.setArea_id(areaId);
			electrician.setAccount_id(accountId);
			electrician.setEmployee_id(employeeId);
			electrician.setSys_hash("3");
			electricianDao.updateElectrician(electrician);
			result.setMessage("success");
		} catch (Exception e) {
		
			LOG.error("updateElectrician error");
			result.setCode(Constants.SERVICE_ERROR);
			result.setMessage("updateElectrician error");

		}
		return result;
	}


	@Override
	public Result deleteElectrician(String electricianId) {
		Result result = new Result();
		try {
			electricianDao.deleteElectrician(electricianId, "4");
			result.setMessage("success");
		} catch (Exception e) {
			LOG.error("deleteElectrician error");
			result.setCode(Constants.SERVICE_ERROR);
			result.setMessage("deleteElectrician error");

		}
		return result;
	
	}


	@Override
	public DataResult<Electrician> getElectricianInfo(String electricianId) {
		 DataResult<Electrician> dataResult=new DataResult<>();
		 
		 try{
		 dataResult.setData( electricianDao.getElectricianInfo(electricianId));
		 dataResult.setMessage("success");
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("getElectricianInfo error");
			dataResult.setCode(Constants.SERVICE_ERROR);
			dataResult.setMessage("getElectricianInfo error");
		}
		return dataResult;
	}


	
	@Override
	public ListResult<Electrician> getElectricianList(String companyId) {
		ListResult<Electrician>  listResult=new  ListResult<Electrician>();
		 try{
			 listResult.setDataList( electricianDao.getElectricianList(companyId));
			 listResult.setMessage("success");
			} catch (Exception e) {
				e.printStackTrace();
				LOG.error("getElectricianList error");
				listResult.setCode(Constants.SERVICE_ERROR);
				listResult.setMessage("getElectricianList error");
			}
			return listResult;
	}



	@Override
	public ListResult<Electrician> searchElectrician(String companyId, String name, String netLicence,
			String specialCertificate, String professionalCredential) {
		ListResult<Electrician>  listResult=new  ListResult<Electrician>();
		 try{
			 listResult.setDataList(electricianDao.searchElectrician(companyId, netLicence, specialCertificate, professionalCredential));
			 listResult.setMessage("success");
			} catch (Exception e) {
				e.printStackTrace();
				LOG.error("searchElectrician error");
				listResult.setCode(Constants.SERVICE_ERROR);
				listResult.setMessage("searchElectrician error");
			}
			return listResult;
	}


	@Override
	public Result addFavorPowerClient(String userId, String powerClientId) {
		Result result = new Result();
		 try{
			 if(userPowerClientFavorDao.FavorPowerClientIsExist(userId, powerClientId)==1)
				 return result;
			 userPowerClientFavorDao.addFavorPowerClient(userId, powerClientId);
			 result.setMessage("success");
			} catch (Exception e) {
				e.printStackTrace();
				LOG.error("addFavorPowerClient error");
				result.setCode(Constants.SERVICE_ERROR);
				result.setMessage("addFavorPowerClient error");
			}
			return result;
	}



	@Override
	public Result cancelFavorPowerClient(String userId, String powerClientId) {
		Result result = new Result();
		 try{
			 userPowerClientFavorDao.cancelFavorPowerClient(userId, powerClientId);
			 result.setMessage("success");
			} catch (Exception e) {
				e.printStackTrace();
				LOG.error("cancelFavorPowerClient error");
				result.setCode(Constants.SERVICE_ERROR);
				result.setMessage("cancelFavorPowerClient error");
			}
			return result;
	}




}
