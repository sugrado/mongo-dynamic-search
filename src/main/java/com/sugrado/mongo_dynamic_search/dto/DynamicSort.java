package com.sugrado.mongo_dynamic_search.dto;

import com.sugrado.mongo_dynamic_search.dto.enums.SortDirection;

public record DynamicSort(
        String field,
        SortDirection direction
) {
}
