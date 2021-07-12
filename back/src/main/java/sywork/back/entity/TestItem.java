package sywork.back.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TestItem {

    @Id @GeneratedValue
    private Long id;
    private String name;

    public TestItem(String name) {
        this.name = name;
    }
}
