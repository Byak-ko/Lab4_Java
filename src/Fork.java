import java.util.Objects;

public class Fork {

    private String name;

    public Fork(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fork fork)) return false;
        return Objects.equals(getName(), fork.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}