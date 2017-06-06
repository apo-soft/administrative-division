/**
 * 
 */
package cn.aposoft.administrativedivision.db.mappers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import cn.aposoft.administrativedivision.Division;
import cn.aposoft.administrativedivision.DivisionLevel;
import cn.aposoft.administrativedivision.DivisionService;

/**
 * 默认区划查询服务
 * 
 * @author LiuJian
 *
 */
@RunWith(value = SpringRunner.class)
// classpath:/spring/app-config.xml
// class-package-relative:DefaultDivisionServiceTest-context.xml
@ContextConfiguration({ "/spring/app-config.xml", "DefaultDivisionServiceTest-context.xml" })
public class DefaultDivisionServiceTest {
	final static Logger logger = LoggerFactory.getLogger(AdministrativeDivisionMapperTest.class);

	@Autowired
	DivisionService service;

	/*
	 * @BeforeClass public static void init() throws IOException { String
	 * resource = "mybatis/mybatis-config.xml"; InputStream inputStream =
	 * Resources.getResourceAsStream(resource); SqlSessionFactory
	 * sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	 * session = sqlSessionFactory.openSession(); }
	 * 
	 * @AfterClass public static void dispose() { session.close(); }
	 */
	/*
	 * @Before public void openMapper() { mapper =
	 * session.getMapper(AdministrativeDivisionMapper.class); }
	 * 
	 * @After public void close() { session.commit(); }
	 */

	@Transactional
	@Test
	public void testSelectOneWithCode() {
		Division division = service.getDivision("110000");
		assertEquals("110000", division.getCode());
		assertEquals("北京市", division.getName());
		assertEquals(DivisionLevel.Province, division.getDivisionLevel());
		assertEquals("2017-03-10", new SimpleDateFormat("yyyy-MM-dd").format(division.getEstablishDate()));
	}

	@Transactional
	@Test
	public void testSelectLevel1Divisions() {
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
