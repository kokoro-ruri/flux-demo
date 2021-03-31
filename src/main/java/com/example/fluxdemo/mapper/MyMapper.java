package com.example.fluxdemo.mapper;

import com.example.fluxdemo.domain.AgBimProject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: com.example.fluxdemo.mapper
 * @ClassName: MyMapper
 * @Description:
 * @UpdateDate: 2021/3/25 16:41
 */
//@Mapper
@Repository
public interface MyMapper {
//    @Select("SELECT * from ag_bim_project where project_name = #{projectName}")
    AgBimProject getByProjectName(String projectName);

//    @Select("SELECT * from ag_bim_project limit #{limit} offset #{offset}")
    List<AgBimProject> getPage(@Param("limit") int limit, @Param("offset") int offset);
}
