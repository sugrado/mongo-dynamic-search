package com.sugrado.mongo_dynamic_search.service.abstracts;

import com.sugrado.mongo_dynamic_search.dto.DynamicQuery;

import java.util.List;

public interface SearchService {
    <T> List<T> dynamicSearch(DynamicQuery dynamicQuery, Class<T> type);
}
