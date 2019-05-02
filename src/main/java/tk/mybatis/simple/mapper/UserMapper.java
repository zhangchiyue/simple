package tk.mybatis.simple.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

public interface UserMapper {
	
	public SysUser selectById(Long id);
	
	List<SysUser> selectAll();
	
	List<SysRole> selectRolesByUserId(Long id);
	
	int insert(SysUser user);
	
	int insert2(SysUser user);
	
	int insert3(SysUser user);
	
	int updateById(SysUser sysUser);
	
	int deleteById(Long id);
	
	int deleteById(SysUser user);

	List<SysRole> selectRolesByUserIdAndRoleEnabled(@Param("userId")Long userId,@Param("enabled")Integer enabled);
	
	int updateByIdSelective(SysUser sysUser);
	
	SysUser selectByIdOrUsername(SysUser susUser);
	
	List<SysUser> selectByIdList(List<Long> idList);
	
	int insertList(List<SysUser> userList);
	
	int updateByMap(Map<String, Object> map);

	SysUser selectUserAndRoleById(Long id);
	
	SysUser selectUserAndRoleById2(Long id);

	public SysUser selectUserAndRoleByIdSelect(long l);
	
	List<SysUser> selectAllUserAndRoles();
	
	SysUser selectAllUserAndRolesSelect(Long id);
	
	void selectUserById(SysUser user);
	
	List<SysUser> selectUserPage(Map<String,Object> params);
	
	int insertUserAndRoles(@Param("user")SysUser user,@Param("roleIds")String roleIds);
	
	int deleteUserById(Long id);
}
