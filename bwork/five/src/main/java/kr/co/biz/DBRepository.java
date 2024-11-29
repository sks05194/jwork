package kr.co.biz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kr.co.biz.vo.DataBaseVo;

@Repository
public interface DBRepository extends JpaRepository<DataBaseVo, Long> {

	public DataBaseVo findByUserId(@Param("userId") String userId);  //userId 컬럼럼에 조건을 주고 조회합니다.
}