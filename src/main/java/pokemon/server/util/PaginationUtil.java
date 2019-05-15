package pokemon.server.util;

import org.springframework.data.domain.Page;
import org.springframework.web.util.UriComponentsBuilder;

public class PaginationUtil {
    private Page page;
    private UriComponentsBuilder uriBuilder;
    

    public PaginationUtil(Page page, UriComponentsBuilder uriBuilder) {
        this.page = page;
        this.uriBuilder = uriBuilder;
    }

    public String getPrev() {
        String prev = null;
        if (page.hasPrevious()) {
            prev = uriBuilder
                .replaceQueryParam("page", page.getNumber() - 1)
                .replaceQueryParam("size", page.getSize())
                .build()
                .toString();
        }
        return prev;

    }

    public String getNext() {
        String next = null;
        if (page.hasNext()) {
            next = uriBuilder
                .replaceQueryParam("page", page.getNumber() + 1)
                .replaceQueryParam("size", page.getSize())
                .build()
                .toString();
        }
        return next;
    }
}