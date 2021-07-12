package sywork.back.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TestItem {

    @Id @GeneratedValue
    private Long id;
    private String name;

    public TestItem(String name) {
        this.name = name;
    }
}
