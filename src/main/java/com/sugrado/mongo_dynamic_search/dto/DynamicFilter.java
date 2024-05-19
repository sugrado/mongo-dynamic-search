package com.sugrado.mongo_dynamic_search.dto;

import com.sugrado.mongo_dynamic_search.dto.enums.FilterOperator;

public record DynamicFilter(
        String field,
        FilterOperator operator,
        String value
) {
}
