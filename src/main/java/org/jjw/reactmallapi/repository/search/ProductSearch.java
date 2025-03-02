package org.jjw.reactmallapi.repository.search;

import org.jjw.reactmallapi.dto.PageRequestDTO;
import org.jjw.reactmallapi.dto.PageResponseDTO;
import org.jjw.reactmallapi.dto.ProductDTO;

public interface ProductSearch {

    PageResponseDTO<ProductDTO> searchList (PageRequestDTO pageRequestDTO);
}
