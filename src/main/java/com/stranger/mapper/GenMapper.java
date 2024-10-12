package com.stranger.mapper;

import com.stranger.domain.GenTable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GenMapper {
//    @Select({"select table_name, table_comment, create_time, update_time from information_schema.tables where table_schema = (select database()) AND table_name NOT LIKE 'sys_%'"})
    List<GenTable> selectDbTableList();
}
