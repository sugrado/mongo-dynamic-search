package com.sugrado.mongo_dynamic_search.core.services.search.models;

import com.sugrado.mongo_dynamic_search.core.services.search.enums.SortDirection;

public record DynamicSort(
        String field,
        SortDirection direction
) {
}
