package pokemon.server.dto;

public class PageDTO {
    private Object content;
    private String prev;
    private String next;

    /**
     * @return the content
     */
    public Object getContent() {
        return content;
    }

    /**
     * @return the next
     */
    public String getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(String next) {
        this.next = next;
    }

    /**
     * @return the prev
     */
    public String getPrev() {
        return prev;
    }

    /**
     * @param prev the prev to set
     */
    public void setPrev(String prev) {
        this.prev = prev;
    }

    /**
     * @param content the content to set
     */
    public void setContent(Object content) {
        this.content = content;
    }
}