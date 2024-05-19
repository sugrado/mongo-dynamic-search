package com.sugrado.mongo_dynamic_search.core.services.search.models;

import com.sugrado.mongo_dynamic_search.core.services.search.enums.FilterOperator;

public record DynamicFilter(
        String field,
        FilterOperator operator,
        String value
) {
}
