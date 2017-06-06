/**
 * 
 */
package cn.aposoft.administrativedivision.db.mappers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.aposoft.administrativedivision.DefaultDivisionService;
import cn.aposoft.administrativedivision.Division;
import cn.aposoft.administrativedivision.DivisionLevel;
import cn.aposoft.administrativedivision.DivisionService;

/**
 * @author LiuJian
 *
 */
public class DefaultDivisionServiceTest {
	final static Logger logger = LoggerFactory.getLogger(AdministrativeDivisionMapperTest.class);

	static SqlSession session;
	AdministrativeDivisionMapper mapper;

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

	@Before
	public void openMapper() {
		mapper = session.getMapper(AdministrativeDivisionMapper.class);
	}

	@After
	public void close() {
		session.commit();
	}

	@Test
	public void testSelectOneWithCode() {
		DivisionService service = new DefaultDivisionService(mapper);
		Division division = service.getDivision("110000");
		assertEquals("110000", division.getCode());
		assertEquals("北京市", division.getName());
		assertEquals(DivisionLevel.Province, division.getDivisionLevel());
		assertEquals("2017-03-10", new SimpleDateFormat("yyyy-MM-dd").format(division.getEstablishDate()));
	}

	@Test
	public void testSelectLevel1Divisions() {
		DivisionService service = new DefaultDivisionService(mapper);
		List<? extends Division> divisions = service.getLevel1Divisions();
		assertNotNull(divisions);
		assertFalse(divisions.isEmpty());
		Division division = divisions.get(0);
		assertEquals("110000", division.getCode());
		assertEquals("北京市", division.getName());
		assertEquals(DivisionLevel.Province, division.getDivisionLevel());
		assertEquals("2017-03-10", new SimpleDateFormat("yyyy-MM-dd").format(division.getEstablishDate()));
	}
}
