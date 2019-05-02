package tk.mybatis.simple.plugin;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ResultMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
/**
 * MyBatis 通用分页拦截器 
 * @author liuzh
 *
 */
@SuppressWarnings({"rawtypes","unchecked"})
@Intercepts(
	@Signature(
			type = Executor.class,
			method = "query",
			args = {MappedStatement.class , Object.class,RowBounds.class,ResultHandler.class}))
public class PageInterceptor implements Interceptor{
	
	private static final List<ResultMapping> EMPTY_RESULTMAPPING = new ArrayList<ResultMapping>(0);

	/* private Dialect dialect; */
	
	private Field additionalParametersField;
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		//获取拦截方法的参数
		Object[] args = invocation.getArgs();
		MappedStatement ms = (MappedStatement) args[0];
		Object parameterObject = args[1];
		RowBounds rowBounds = (RowBounds) args[2];
		//调用方法判断是否需要进行分页,如果不需要,直接返回结果
		
		return null;
	}

	@Override
	public Object plugin(Object target) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub
		
	}

}
