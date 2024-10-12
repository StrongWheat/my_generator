package com.stranger.mapper;

import com.stranger.domain.GenTableColumn;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GenTableColumnMapper
{
    List<GenTableColumn> selectDbTableColumnsByName(String paramString);
}
