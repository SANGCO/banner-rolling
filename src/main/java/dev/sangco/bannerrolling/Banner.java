package dev.sangco.bannerrolling;

public class Banner {

    private long id;

    private int order;

    // TODO 우선순위 뭘로 할까나?
    private int priority;

    public Banner(long id, int order, int priority) {
        this.id = id;
        this.order = order;
        this.priority = priority;
    }

    public long getId() {
        return id;
    }

    public int getOrder() {
        return order;
    }

    public int getPriority() {
        return priority;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id=" + id +
                ", order=" + order +
                ", priority=" + priority +
                '}';
    }
}
