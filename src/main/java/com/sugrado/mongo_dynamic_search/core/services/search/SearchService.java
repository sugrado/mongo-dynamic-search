package com.sugrado.mongo_dynamic_search.core.services.search;

import com.sugrado.mongo_dynamic_search.core.services.search.models.DynamicQuery;

import java.util.List;

public interface SearchService {
    <T> List<T> dynamicSearch(DynamicQuery dynamicQuery, Class<T> type);
}
