package hello.jpa;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    @Column(name = "USERNAME")
    private String username;

    public Team getTeam() {
        return team;
    }

    @ManyToOne
    @JoinColumn(name="TEAM_ID")
    private Team team;

//    public void changeTeam(Team team) {
//        this.team = team;
//        team.getMembers().add(this);
//    }

    @OneToOne
    @JoinColumn(name="LOCKER_ID")
    private Locker locker;

    //객체 다대다 맵핑
    @ManyToMany
    @JoinTable(name="MEMBER_PRODUCT")
    private List<Product> products = new ArrayList<>();
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTeam(Team team) {
    }
}