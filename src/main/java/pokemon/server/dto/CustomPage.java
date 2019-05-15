package pokemon.server.dto;

public class CustomPage {
    private final Object content;
    private final String prev;
    private final String next;

    public CustomPage(Object content, String prev, String next) {
        this.content = content;
        this.prev = prev;
        this.next = next;
    }

    /**
     * @return the next
     */
    public String getNext() {
        return next;
    }

    /**
     * @return the prev
     */
    public String getPrev() {
        return prev;
    }

    /**
     * @return the content
     */
    public Object getContent() {
        return content;
    }
}