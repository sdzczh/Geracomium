package com.zh.service.impl;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zh.dao.inte.BaseDaoI;
import com.zh.pojo.User;
import com.zh.service.UserManageService;
@SuppressWarnings("unchecked")
@Service
@Transactional
public class UserManageServiceImpl implements UserManageService{

	@Autowired
	private BaseDaoI dao;

	@Override
	public List<User> findUser(User user) {
		String sql="from User";
		List<User> list = dao.find(sql);
		return list;
	}
	
}
/*
public Map<String,Object> getUserList(Map<String,Object> map,Integer page,Integer rows,Integer isDel){
	StringBuffer sql = new StringBuffer();
	Map<String,Object> params = new HashMap<String, Object>();
	sql.append("SELECT ");
	sql.append("tu.*,a.state,a.packageNum,a.activeTime,refer.userCode as referUserCode,refer.userAccount as  referUserAccount ");
	sql.append("FROM t_user tu ");
	sql.append("LEFT JOIN t_account a ON  tu.id= a.userId ");
	sql.append("LEFT JOIN t_user refer ON  tu.referenceId= refer.id ");
	sql.append("where ");
	sql.append("tu.isDel=:isDel ");
	if(!StrUtils.isBlank((String)map.get("userAccount"))){
		sql.append("and tu.userAccount like :userAccount ");
		params.put("userAccount", "%"+map.get("userAccount")+"%");
	}
	if(!StrUtils.isBlank((String)map.get("userCode"))){
		sql.append("and tu.userCode like :userCode ");
		params.put("userCode", "%"+map.get("userCode")+"%");
	}
	if(!StrUtils.isBlank((String)map.get("userName"))){
		sql.append("and tu.userName like :userName ");
		params.put("userName", "%"+map.get("userName")+"%");
	}
	if(!StrUtils.isBlank((String)map.get("referCode"))){
		sql.append("and refer.userCode like :referCode ");
		params.put("referCode", "%"+map.get("referCode")+"%");
	}
	if(!StrUtils.isBlank((String)map.get("accountState"))){
		sql.append("and a.state = :accountState ");
		params.put("accountState", map.get("accountState"));
	}
	if(!StrUtils.isBlank((String)map.get("createTimeStart"))){
		sql.append("and tu.createTime >= :createTimeStart ");
		params.put("createTimeStart", map.get("createTimeStart"));
	}
	if(!StrUtils.isBlank((String)map.get("createTimeEnd"))){
		sql.append("and tu.createTime <= :createTimeEnd ");
		params.put("createTimeEnd", map.get("createTimeEnd"));
	}
	if(!StrUtils.isBlank((String)map.get("activeTimeStart"))){
		sql.append("and left(a.activeTime,10) >= :activeTimeStart ");
		params.put("activeTimeStart", map.get("activeTimeStart"));
	}
	if(!StrUtils.isBlank((String)map.get("activeTimeEnd"))){
		sql.append("and left(a.activeTime,10) <= :activeTimeEnd ");
		params.put("activeTimeEnd", map.get("activeTimeEnd"));
	}
	params.put("isDel", isDel);
	List<Map<String,Object>> users = (List<Map<String,Object>>) dao.findBySql( sql.toString(), params, page, rows);
	
	String countSql = "SELECT COUNT(id) FROM ( "+sql.toString()+" )z";
	BigInteger count = dao.countBySql(countSql, params);
	
	map.put("count", count);
	map.put("data", users);
	map.put("page", page);
	map.put("rows", rows);
	return map;
}

public void loginOut(){
	WebUtils.getSession().removeAttribute(GolbParams.Manager);
}

public Map<String,Object> adminLogin(User user,HttpServletRequest request){
	Map<String,Object> map = new HashMap<String, Object>();
	try {
	HttpSession session =request.getSession();
	map.put("state",false);
	String account = Base64Utils.decoder(user.getUserAccount());
	String userpwd = user.getUserPassword().toLowerCase();
	StringBuffer sql = new StringBuffer();
	sql.append("SELECT tu.id loginUserId,tu.userName,tu.userRole,tu.userAccount,tu.createTime loginUserCreateTime,ta.* ");
	sql.append("FROM t_user tu ");
	sql.append("LEFT JOIN t_account ta ON tu.id = ta.userId ");
	sql.append("WHERE ");
	sql.append("tu.userRole = :userRole ");
	sql.append("AND ");
	sql.append("tu.userAccount = :account ");
	sql.append("AND ");
	sql.append("tu.userPassword= :userpwd ");
	Map<String, Object> params = new HashMap<String, Object>();
	params.put("account", account);
	params.put("userpwd", userpwd);
	params.put("userRole", 1);
	session.setAttribute("pwd", userpwd);
	
	List<?> results = dao.findBySql(sql.toString(), params);
	if(results.size()==1){
		map.put("state", true);
		Map<String,Object> userInfo = (Map<String, Object>) results.get(0);
		User loginUser = new User();
		loginUser.setId(Integer.parseInt(userInfo.get("loginUserId").toString()));
		loginUser.setUserRole(Integer.parseInt(userInfo.get("userRole").toString()));
		WebUtils.getSession().setAttribute(GolbParams.Manager,loginUser);
		LoginHistory history = new LoginHistory();
		history.setUserId(loginUser.getId());
		history.setUserRole(loginUser.getUserRole());
		history.setLoginIp(IPUtils.getIpAddr(request));
		history.setLoginDate(DateUtils.getCurrentTimeStr());
		
			dao.save(history);
				
	}
	
	} catch (Exception e) {
		e.printStackTrace();
		map.put("state", false);
		throw new RuntimeException(e);
	}
	return map;
}

public Map<String, Object> createUser(User user) {
	dao.save(user);
	return null;
}

@Override
public Map<String, Object> addUserAndAccount(User user, Account account,
		HttpServletRequest request) {
	Map<String,Object> map = new HashMap<String, Object>();
//	User users = this.selectByUserAccount(user.getUserAccount());
//	if(users!=null){
//		map.put("success", false);
//	}
	try{
		唯一编码生成并校验
		String userCode =null;
		User checkUser = new User(); 
		while(checkUser!=null){
			userCode = StrUtils.getCode(8);
			String checkUserCodeHql = "from User where userCode=:userCode";
			Map<String,Object> checkUserCodeHqlParams = new HashMap<String, Object>();
			checkUserCodeHqlParams.put("userCode", userCode);
			checkUser = dao.findUnique(checkUserCodeHql, checkUserCodeHqlParams);
		}
		user.setIsDel(0);
		user.setUserPassword(GolbParams.USER_PASSWORD_DEFAULT);
		user.setCreateTime(DateUtils.getCurrentTimeStr());
		user.setReferenceAccount("0");//系统添加操作员为初始一级
		user.setReferenceId(0);
		user.setUserRole(0);
		user.setLoginState(String.valueOf(System.currentTimeMillis()));
		user.setUserCode(userCode);
		dao.save(user);
		
		account.setUserId(user.getId());
		account.setState(1);
		account.setCreateTime(DateUtils.getCurrentTimeStr());
		account.setUpdateTime(DateUtils.getCurrentTimeStr());
		account.setActiveTime(DateUtils.getCurrentTimeStr());
		account.setPackageNum(1);
		dao.save(account);
		map.put("success", true);
	}catch (Exception e) {
		e.printStackTrace();
		map.put("success", false);
		throw new RuntimeException(e);
	}
	
	return map;
}

public User queryUser(String userAccount){
	Map<String,Object> map = new HashMap<String, Object>();
	map.put("userAccount", userAccount);
	StringBuffer querySql = new StringBuffer();
	querySql.append("select");
	querySql.append("*");
	querySql.append("from t_user ");
	querySql.append("where ");
	querySql.append("userAccount= :userAccount ");
	
	List<User> list = dao.findBySql(User.class,querySql.toString(), map);
	if(list==null || list.isEmpty()){			
		return null;
	}else{
		return list.get(0);
	}
}

@Override
public Map<String, Object> userUpdate(User user) {

	Map<String,Object> map = new HashMap<String, Object>();
	try{		
		if(user==null){
			map.put("success", false);
		}else{				
			dao.update(user);
			map.put("success", true);
		}
	}catch(Exception e){
		e.printStackTrace();
		map.put("success", false);
		throw new RuntimeException(e);
	}
	return map;
}

@Override
public User queryOne(Integer userId) {
	Map<String,Object> map = new HashMap<String, Object>();
	map.put("id", userId);
	StringBuffer userQuerySql = new StringBuffer();
	userQuerySql.append("select");
	userQuerySql.append("*"); 
	userQuerySql.append("from t_user ");
	userQuerySql.append("where ");
	userQuerySql.append("id= :id ");
	
	List<User> list = dao.findBySql(User.class,userQuerySql.toString(), map);
	if(list==null || list.isEmpty()){			
		return null;
	}else{
		return list.get(0);
	}
}

@Override
public Map<String, Object> userModify(User user, Account account) {
	Map<String,Object> map = new HashMap<String, Object>();
	try {
		User oldUser = this.queryUser(user.getUserAccount());
		Account oldAccount = accountService.queryByUserId(oldUser.getId(),null);
		oldUser.setUserName(user.getUserName()); 
		if(oldAccount!=null){
			oldAccount.setAlipayNumber(account.getAlipayNumber());
			oldAccount.setBankName(account.getBankName());
			oldAccount.setBankNumber(account.getBankNumber());
			oldAccount.setWebcatNumber(account.getWebcatNumber());
			oldAccount.setPackageJ(account.getPackageJ());
			oldAccount.setPackageZ(account.getPackageZ());
			oldAccount.setPackageD(account.getPackageD());
			oldAccount.setUpdateTime(DateUtils.getCurrentTimeStr());
			dao.update(oldAccount);
		}else{
			account.setUserId(oldUser.getId());
			account.setState(1);
			account.setCreateTime(DateUtils.getCurrentTimeStr());
			account.setUpdateTime(DateUtils.getCurrentTimeStr());
			account.setPackageNum(0);
			dao.save(account);
		}
		
		
		dao.update(oldUser);
		
		map.put("success", true);
	} catch (Exception e) {
		e.printStackTrace();
		map.put("success", false);
		throw new RuntimeException(e);
	}
	return map;
}

@Override
public Map<String, Object> userDeletePerm(Integer userId) {

	Map<String,Object> map = new HashMap<String, Object>();
	User user = this.queryOne(userId);
	try{		
		if(user==null){
			map.put("success", false);
		}else{				
			dao.delete(user);
			map.put("success", true);
		}
	}catch(Exception e){
		e.printStackTrace();
		map.put("success", false);
		throw new RuntimeException(e);
	}
	return map;
}

@Override
public Map<String, Object> userDelete(String userIds) {
	Map<String,Object> map = new HashMap<String, Object>();
	try{	
		if(!StrUtils.isBlank(userIds)){
			String[] ids = userIds.split(",");
			for(String id :ids){
				Integer idInt = Integer.parseInt(id);
				User user = this.queryOne(idInt);
				if(user==null){
					map.put("success", false);
				}else{	
					//检查未完成订单
					List<Order> orders = orderService.queryUnfinishedByUserId(idInt);
					if(!orders.isEmpty()){
						map.put("success", false);
						map.put("errCode", "1");
						map.put("errMsg", user.getUserAccount()+",存在未完成的交易，请检查！");
						return map;
					}
					//上调此会员的下级会员
					List<User> userNext = this.queryByReferenceId(user.getId());
					for (User usern : userNext) {
						usern.setReferenceId(user.getReferenceId());
						usern.setReferenceAccount(user.getReferenceAccount());
						dao.update(usern);
					}
					
					//此会员置为已删除
					user.setIsDel(1);
					dao.update(user);
					
				}
			}
			map.put("success", true);
		}
	}catch(Exception e){
		e.printStackTrace();
		map.put("success", false);
		throw new RuntimeException(e);
	}
	return map;
}

@Override
public List<User> queryByReferenceId(Integer referenceId) {
	Map<String,Object> map = new HashMap<String, Object>();
	map.put("referenceId", referenceId);
	StringBuffer userQuerySql = new StringBuffer();
	userQuerySql.append("select");
	userQuerySql.append("*");
	userQuerySql.append("from t_user ");
	userQuerySql.append("where ");
	userQuerySql.append("referenceId= :referenceId ");
	
	return dao.findBySql(User.class,userQuerySql.toString(), map);
}

@Override
public User queryByUserAccount(String userAccount,Integer state) {
	Map<String,Object> map = new HashMap<String, Object>();
	map.put("userAccount", userAccount);
	map.put("state", state);
	StringBuffer userQuerySql = new StringBuffer();
	userQuerySql.append("select");
	userQuerySql.append(" * ");
	userQuerySql.append("from t_user ");
	userQuerySql.append("where ");
	userQuerySql.append("userAccount= :userAccount ");
	userQuerySql.append("and isDel= :state ");
	
	List<User> list = dao.findBySql(User.class,userQuerySql.toString(), map);
	if(list==null || list.isEmpty()){			
		return null;
	}else{
		return list.get(0);
	}
}
@Override
public User selectByUserAccount(String userAccount) {
	Map<String,Object> map = new HashMap<String, Object>();
	map.put("userAccount", userAccount);
	StringBuffer userQuerySql = new StringBuffer();
	userQuerySql.append("select");
	userQuerySql.append(" * ");
	userQuerySql.append("from t_user ");
	userQuerySql.append("where ");
	userQuerySql.append("userAccount= :userAccount ");
	
	List<User> list = dao.findBySql(User.class,userQuerySql.toString(), map);
	if(list==null || list.isEmpty()){			
		return null;
	}else{
		return list.get(0);
	}
}
@Override
public Map<String, Object> getRechargeList(Map<String, Object> map, Integer page, Integer rows,Integer isDel) {
	StringBuffer sql = new StringBuffer();
	sql.append("SELECT ");
	sql.append("t_user.id,t_user.userAccount,t_user.userName,t_account.packageD,t_account.packageJ,t_account.packageZ,t_account.state ");
	sql.append("FROM t_user ");
	sql.append("LEFT JOIN t_account  ON t_user.id = t_account.userId ");
	sql.append("where isDel=:isDel ");
	Map<String,Object> params = new HashMap<String, Object>();
	if(!StrUtils.isBlank((String)map.get("userAccount"))){
		sql.append("and t_user.userAccount like :userAccount ");
		params.put("userAccount", "%"+map.get("userAccount")+"%");
	}
	if(!StrUtils.isBlank((String)map.get("userName"))){
		sql.append("and t_user.userName like :userName ");
		params.put("userName", "%"+map.get("userName")+"%");
	}
	params.put("isDel", isDel);
	List<Map<String,Object>> users = (List<Map<String,Object>>) dao.findBySql( sql.toString(), params, page, rows);
	
	String countSql = "SELECT COUNT(userAccount) FROM ( "+sql.toString()+" )z";
	BigInteger count = dao.countBySql(countSql, params);
	
	map.put("count", count);
	map.put("data", users);
	map.put("page", page);
	map.put("rows", rows);
	return map;
}

@Override
public void addOneMoney(Integer userId, String wallet, String s) {
	StringBuffer sql = new StringBuffer();
	sql.append("update Account set ");
	sql.append(wallet+"="+wallet+s+" ");
	sql.append("where ");
	sql.append("userId="+userId);
	dao.executeHql(sql.toString());
	Integer wallets = 0;
	if(wallet.contains("packageJ")){
		wallets=0;
	}else 
		if(wallet.contains("packageD")){
		wallets=1;
	}else 
		if(wallet.contains("packageZ")){
		wallets=2;
	}
//	String ss="insert into CapitalFlow(id,userId,createDateTime,packageType,amount,type) values(null,"+userId+","+DateUtils.getCurrentTimeStr()+","+wallets+","+s+",11)";
	CapitalFlow capitalFlow=new CapitalFlow();
	capitalFlow.setUserId(userId);
	capitalFlow.setCreateDateTime(DateUtils.getCurrentTimeStr());
	capitalFlow.setPackageType(wallets);
	capitalFlow.setAmount(Double.parseDouble(s));
	capitalFlow.setType(11);
	dao.save(capitalFlow);
//	Account account=accountService.queryByUserId(userId);
}

@Override
public String updateRole(Integer userId) {
	
	String sql="select id from User where userRole=3";
	if(dao.find(sql)!=null&&!dao.find(sql).isEmpty()){
		return "false";
	}else{
		String s="select userRole from User where id="+userId;
		int num=(Integer) dao.find(s).get(0);
		if(num==0){
			String ss="update User set userRole=3 where id="+userId;
			dao.executeHql(ss.toString());
			return "true";
		}else
			return "false";
	}
}

@Override
public String revoke(Integer userId) {
	String ss="update User set userRole=0 where id="+userId;
	dao.executeHql(ss.toString());
	return "true";
}*/