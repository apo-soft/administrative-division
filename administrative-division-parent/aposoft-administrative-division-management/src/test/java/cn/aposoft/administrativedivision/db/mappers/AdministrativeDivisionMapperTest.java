/**
 * 
 */
package cn.aposoft.administrativedivision.db.mappers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import cn.aposoft.administrativedivision.DivisionLevel;
import cn.aposoft.administrativedivision.db.AdministrativeDivision;
import cn.aposoft.administrativedivision.db.AdministrativeDivisionExample;

/**
 * 行政区划Mapper测试
 * 
 * @author LiuJian
 * @since 1.0
 */
public class AdministrativeDivisionMapperTest {
	final static Logger logger = LoggerFactory.getLogger(AdministrativeDivisionMapperTest.class);

	static SqlSession session;

	@BeforeClass
	public static void init() throws IOException {
		String resource = "mybatis/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		session = sqlSessionFactory.openSession();
	}

	@AfterClass
	public static void dispose() {
		session.close();
	}

	final static DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");

	@Ignore
	@Test
	public void testCreateAdministrativeDivision() throws ParseException {
		try {
			AdministrativeDivisionMapper mapper = session.getMapper(AdministrativeDivisionMapper.class);
			AdministrativeDivision record = new AdministrativeDivision();
			record.setCode("110000");
			record.setName("北京市");
			record.setVersion(0);
			record.setDivisionLevel(DivisionLevel.Province);
			record.setEstablishDate(dateformat.parse("2017-03-10"));
			// record.setParent("110000");
			int count = mapper.insertSelective(record);
			assertEquals(1, count);
			logger.info(String.valueOf(record.getId()));
			assertNotNull(record.getId());
			session.commit();
		} catch (ParseException | RuntimeException e) {
			session.rollback();
			throw e;
		}
		try {
			AdministrativeDivisionMapper mapper = session.getMapper(AdministrativeDivisionMapper.class);
			AdministrativeDivision record = new AdministrativeDivision();
			record.setCode("110100");
			record.setName("市辖区");
			record.setVersion(0);
			record.setDivisionLevel(DivisionLevel.City);
			record.setEstablishDate(dateformat.parse("2017-03-10"));
			record.setParent("110000");
			int count = mapper.insertSelective(record);
			assertEquals(1, count);
			logger.info(String.valueOf(record.getId()));
			assertNotNull(record.getId());
			session.commit();
		} catch (ParseException | RuntimeException e) {
			session.rollback();
			throw e;
		}

	}

	@Ignore
	@Test
	public void testUpdateAdministrativeDivision() throws ParseException {
		try {
			AdministrativeDivisionMapper mapper = session.getMapper(AdministrativeDivisionMapper.class);

			AdministrativeDivision record = new AdministrativeDivision();
			record.setId(1);
			record.setCode("110000");
			record.setName("北京市");
			// record.setVersion(0);
			record.setDivisionLevel(DivisionLevel.Province);
			record.setEstablishDate(dateformat.parse("2017-03-10"));
			// record.setParent("000000");
			int count = mapper.updateByPrimaryKeySelective(record);
			assertEquals(1, count);
			logger.info(String.valueOf(record.getId()));
			assertNotNull(record.getId());
			session.commit();
		} catch (ParseException | RuntimeException e) {
			session.rollback();
			throw e;
		}
	}

	@Test
	public void testDeleteAdministrativeDivision() throws ParseException {
		try {
			AdministrativeDivisionMapper mapper = session.getMapper(AdministrativeDivisionMapper.class);

			int count = mapper.deleteByPrimaryKey(2);
			assertEquals(1, count);
			session.commit();
		} catch (RuntimeException e) {
			session.rollback();
			throw e;
		}
	}

	@Test
	public void testGetAdministrativeDivision() {
		try {
			AdministrativeDivisionMapper mapper = session.getMapper(AdministrativeDivisionMapper.class);

			AdministrativeDivision division = mapper.selectByPrimaryKey(1);
			assertEquals("110000", division.getCode());
			assertEquals("北京市", division.getName());
			assertEquals(1, division.getId().intValue());
			assertEquals(DivisionLevel.Province, division.getDivisionLevel());
			System.out.println(JSON.toJSONStringWithDateFormat(division, "yyyy-MM-dd",
					new SerializerFeature[] { SerializerFeature.PrettyFormat }));
			session.commit();
		} catch (RuntimeException e) {
			session.rollback();
			throw e;
		}
	}

	@Test
	public void testCountAdministrativeDivisionAll() {
		try {
			AdministrativeDivisionMapper mapper = session.getMapper(AdministrativeDivisionMapper.class);

			AdministrativeDivisionExample example = new AdministrativeDivisionExample();
			long count = mapper.countByExample(example);
			logger.info("Result Total:" + count);
			assertEquals(2, count);
			session.commit();
		} catch (RuntimeException e) {
			session.rollback();
			throw e;
		}
	}

	@Test
	public void testSelectAdministrativeDivisionAll() {
		try {
			AdministrativeDivisionMapper mapper = session.getMapper(AdministrativeDivisionMapper.class);

			AdministrativeDivisionExample example = new AdministrativeDivisionExample();
			example.setOrderByClause("code");

			List<AdministrativeDivision> divisions = mapper.selectByExample(example);
			logger.info("Result Total:" + divisions.size());
			assertEquals(2, divisions.size());
			assertEquals("110000", divisions.get(0).getCode());
			assertEquals("110100", divisions.get(1).getCode());
			session.commit();
		} catch (RuntimeException e) {
			session.rollback();
			throw e;
		}
	}
}
