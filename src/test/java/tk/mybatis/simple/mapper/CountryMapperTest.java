package tk.mybatis.simple.mapper;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;


import tk.mybatis.simple.model.Country;
import tk.mybatis.simple.model.CountryExample;
import tk.mybatis.simple.model.CountryExample.Criteria;

public class CountryMapperTest extends BaseMapperTest {
	

	@Test
	public void testSelectAll() {
		SqlSession sqlSession = getSqlSession();
		try {
		
			List<Country> list = sqlSession.selectList("tk.mybatis.simple.mapper.CountryMapper.selectAll");
			printCountryList(list);
			
		} finally {
			sqlSession.close();
			// TODO: handle finally clause
		}
	}
	
	private void printCountryList(List<Country> countrylist) {
		for(Country country: countrylist) {
			System.out.printf("%-4d%4s%4s\n",country.getId(),country.getCountryname(),country.getCountrycode());
		}
	}
	
	@Test
	public void testExample() {
		SqlSession sqlSession = getSqlSession();
		try {
			CountryMapper countryMapper = sqlSession.getMapper(CountryMapper.class);
			CountryExample example = new CountryExample();
			example.setOrderByClause("id desc, countryname asc");
			example.setDistinct(true);
			Criteria criteria = example.createCriteria();
			criteria.andIdGreaterThanOrEqualTo(1);
			criteria.andIdLessThan(4);
			criteria.andCountrycodeLike("%U%");
			Criteria or = example.or();
			or.andCountrynameEqualTo("中国");
			List<Country> list = countryMapper.selectByExample(example);
			printCountryList(list);
			
		
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testUpdateByExampleSelective() {
		SqlSession sqlSession = getSqlSession();
		try {
			CountryMapper countryMapper = sqlSession.getMapper(CountryMapper.class);
			CountryExample example = new CountryExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdGreaterThan(2);
			Country country = new Country();
			country.setCountryname("China");
			countryMapper.updateByExampleSelective(country, example);
			printCountryList(countryMapper.selectByExample(example));
		
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testDeleteByExample() {
		SqlSession sqlSession = getSqlSession();
		try {
			CountryMapper countryMapper = sqlSession.getMapper(CountryMapper.class);
			CountryExample example = new CountryExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdGreaterThan(2);
			countryMapper.deleteByExample(example);
			Assert.assertEquals(0, countryMapper.countByExample(example));
		} finally {
			sqlSession.close();
		}
	}

}
