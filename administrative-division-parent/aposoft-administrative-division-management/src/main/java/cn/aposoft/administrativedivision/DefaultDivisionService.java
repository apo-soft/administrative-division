/**
 * 
 */
package cn.aposoft.administrativedivision;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.aposoft.administrativedivision.db.AdministrativeDivision;
import cn.aposoft.administrativedivision.db.AdministrativeDivisionExample;
import cn.aposoft.administrativedivision.db.mappers.AdministrativeDivisionMapper;

/**
 * 行政区划查询服务
 * 
 * @author LiuJian
 *
 */
public class DefaultDivisionService implements DivisionService {
	// 底层数据库访问dao
	private AdministrativeDivisionMapper mapper;

	public DefaultDivisionService(AdministrativeDivisionMapper mapper) {
		this.mapper = mapper;
	}

	@Transactional(readOnly = true)
	@Override
	public List<? extends Division> getAllDivisions() {
		return mapper.selectByExample(new AdministrativeDivisionExample());
	}

	@Transactional(readOnly = true)
	@Override
	public List<? extends Division> getLevel1Divisions() {
		AdministrativeDivisionExample example = new AdministrativeDivisionExample();
		example.createCriteria().andDivisionLevelEqualTo(DivisionLevel.Province);
		return mapper.selectByExample(example);
	}

	@Transactional(readOnly = true)
	@Override
	public List<? extends Division> getDivisions(String parentCode) {
		AdministrativeDivisionExample example = new AdministrativeDivisionExample();
		example.createCriteria().andParentEqualTo(parentCode);
		return mapper.selectByExample(example);
	}

	@Transactional(readOnly = true)
	@Override
	public Division getDivision(String code) {
		AdministrativeDivisionExample example = new AdministrativeDivisionExample();
		example.createCriteria().andCodeEqualTo(code);
		example.setOrderByClause("code asc limit 1");
		List<AdministrativeDivision> list = mapper.selectByExample(example);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

}
