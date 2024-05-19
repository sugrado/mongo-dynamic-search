package com.sugrado.mongo_dynamic_search.core.services.search.models;

import java.util.List;

public record DynamicQuery(
        List<DynamicFilter> filters,
        List<DynamicSort> sorts
) {
}
